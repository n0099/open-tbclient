package com.baidu.searchbox.ugc.upload;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.model.CompleteMultipartUploadRequest;
import com.baidubce.services.bos.model.CompleteMultipartUploadResponse;
import com.baidubce.services.bos.model.InitiateMultipartUploadRequest;
import com.baidubce.services.bos.model.ObjectMetadata;
import com.baidubce.services.bos.model.PartETag;
import com.baidubce.services.bos.model.UploadPartRequest;
import com.baidubce.services.bos.model.UploadPartResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes14.dex */
public class FileUploadSession {
    static final long CHUNK_SIZE = 1048576;
    static final int RETRY_COUNT = 2;
    private static final String TAG = "FileUploadSession";
    static final boolean VERBOSE = false;
    private BosClient bosClient;
    private String bosKey;
    private String bucket;
    private StringBuilder errorMessage;
    private File file;
    private MultipartUploadProgressListener mProgressListener;
    private LinkedList<Pair<String, Object>> pairs;
    private ExecutorService singlePool;
    private UploadVideoTask task;
    private int tryNum;
    private String uploadId;

    /* loaded from: classes14.dex */
    public interface MultipartUploadProgressListener {
        void notifyPercent(int i);
    }

    public FileUploadSession(UploadVideoTask uploadVideoTask, BosClient bosClient) {
        this(uploadVideoTask, bosClient, null);
    }

    public FileUploadSession(UploadVideoTask uploadVideoTask, BosClient bosClient, MultipartUploadProgressListener multipartUploadProgressListener) {
        this.pairs = new LinkedList<>();
        this.task = uploadVideoTask;
        this.bosClient = bosClient;
        this.mProgressListener = multipartUploadProgressListener;
        this.errorMessage = new StringBuilder();
    }

    public void releaseUploadListener() {
        this.mProgressListener = null;
    }

    public boolean upload(File file, String str, String str2, int i, ObjectMetadata objectMetadata) {
        CompleteMultipartUploadResponse completeMultipartUpload;
        this.file = file;
        this.bucket = str;
        this.bosKey = str2;
        this.tryNum = i;
        this.errorMessage.append("尝试的次数:").append(i).append(" : file:").append(file).append(" ; file.length").append(file.length()).append(" ; bucket:").append(str).append(" ; bosKey:").append(str2);
        log("upload file bucket=" + str + ";bosKey=" + str2 + ";file=" + file.getName());
        long length = file.length();
        int i2 = (int) (length / 1048576);
        int i3 = length % 1048576 > 0 ? i2 + 1 : i2;
        this.errorMessage.append(" ; parts = ").append(i3);
        initMultipartUpload(objectMetadata);
        if (TextUtils.isEmpty(this.uploadId)) {
            return false;
        }
        removeRepeatETag();
        if (this.mProgressListener != null) {
            int size = (int) ((ProcessCacheManager.getInstance().uploadCacheBean.parts.size() * 100.0f) / i3);
            log("percent : " + size);
            this.mProgressListener.notifyPercent(size);
        }
        this.singlePool = Executors.newSingleThreadExecutor();
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            if (ProcessCacheManager.getInstance().uploadCacheBean.parts == null || ProcessCacheManager.getInstance().uploadCacheBean.parts.size() == 0) {
                arrayList.add(this.singlePool.submit(new UploadPartTask(this, i4, i3)));
                log("单 线程池添加 任务: " + i4);
            } else if (!currentPartHasUploaded(i4)) {
                arrayList.add(this.singlePool.submit(new UploadPartTask(this, i4, i3)));
                log("单 线程池添加 任务: " + i4);
            }
        }
        boolean z = true;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            try {
                if (((Boolean) ((Future) arrayList.get(i5)).get()).booleanValue()) {
                    log("The upload task [ " + i5 + "] completed.");
                    if (this.mProgressListener != null) {
                        int i6 = (int) (((i5 + 1) * 100.0f) / i3);
                        log("percent : " + i6);
                        this.mProgressListener.notifyPercent(i6);
                    }
                } else {
                    this.errorMessage.append("feature.get() 方法为false");
                    log("The upload task [ " + i5 + "] failed.");
                    z = false;
                }
            } catch (Exception e) {
                this.errorMessage.append("Exception").append(e.getMessage());
                log("The upload task [ " + i5 + "] failed." + e.getMessage());
                z = false;
            }
        }
        this.singlePool.shutdownNow();
        if (z) {
            if (ProcessCacheManager.getInstance().uploadCacheBean.parts != null && ProcessCacheManager.getInstance().uploadCacheBean.parts.size() > 0) {
                Collections.sort(ProcessCacheManager.getInstance().uploadCacheBean.parts, new Comparator<PartETag>() { // from class: com.baidu.searchbox.ugc.upload.FileUploadSession.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    public int compare(PartETag partETag, PartETag partETag2) {
                        return partETag.getPartNumber() - partETag2.getPartNumber();
                    }
                });
            }
            removeRepeatETag();
            if (ProcessCacheManager.getInstance().uploadCacheBean.parts == null || ProcessCacheManager.getInstance().uploadCacheBean.parts.size() != i3) {
                return false;
            }
            if (!ProcessCacheManager.getInstance().uploadCacheBean.completeMultipartUpload) {
                try {
                    completeMultipartUpload = this.bosClient.completeMultipartUpload(new CompleteMultipartUploadRequest(str, str2, this.uploadId, ProcessCacheManager.getInstance().uploadCacheBean.parts));
                } catch (Exception e2) {
                    this.errorMessage.append(" ; 请求合并视频 : ").append(e2.getMessage());
                    e2.printStackTrace();
                }
                if (completeMultipartUpload != null && !TextUtils.isEmpty(completeMultipartUpload.getETag())) {
                    ProcessCacheManager.getInstance().uploadCacheBean.completeMultipartUpload = true;
                } else {
                    this.errorMessage.append(" response 返回数据错误");
                    log("合并视频失败");
                    z = false;
                }
            } else if (!isCancelByUser()) {
            }
        } else if (isCancelByUser() || i == 2) {
        }
        return z;
    }

    private boolean currentPartHasUploaded(int i) {
        int i2 = i + 1;
        int size = ProcessCacheManager.getInstance().uploadCacheBean.parts.size();
        for (int i3 = 0; i3 < size; i3++) {
            PartETag partETag = ProcessCacheManager.getInstance().uploadCacheBean.parts.get(i3);
            if (partETag != null && !TextUtils.isEmpty(partETag.getETag()) && partETag.getPartNumber() == i2) {
                return true;
            }
        }
        return false;
    }

    private boolean contains(List<PartETag> list, PartETag partETag) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            PartETag partETag2 = list.get(i);
            if (partETag2 != null && partETag != null && partETag2.getPartNumber() == partETag.getPartNumber()) {
                return true;
            }
        }
        return false;
    }

    private void removeRepeatETag() {
        List<PartETag> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < ProcessCacheManager.getInstance().uploadCacheBean.parts.size()) {
                if (!contains(arrayList, ProcessCacheManager.getInstance().uploadCacheBean.parts.get(i2))) {
                    arrayList.add(ProcessCacheManager.getInstance().uploadCacheBean.parts.get(i2));
                }
                i = i2 + 1;
            } else {
                ProcessCacheManager.getInstance().uploadCacheBean.parts.clear();
                ProcessCacheManager.getInstance().uploadCacheBean.parts.addAll(arrayList);
                return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [377=5, 379=4, 382=5] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean uploadPart(int i, int i2) {
        FileInputStream fileInputStream;
        int i3;
        UploadPartResponse uploadPart;
        log("Upload part: " + i + " totalPartNum: " + i2);
        int i4 = 2;
        while (true) {
            if (i4 <= 0) {
                break;
            }
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(this.file);
                long j = i * 1048576;
                try {
                    try {
                        fileInputStream.skip(j);
                        long length = 1048576 < this.file.length() - j ? 1048576L : this.file.length() - j;
                        log("[skipBytes]= " + j + ", [partSize] = " + length + ", [file.length() - skipBytes] = " + (this.file.length() - j));
                        byte[] bArr = new byte[(int) length];
                        int i5 = 0;
                        do {
                            int read = fileInputStream.read(bArr, i5, (int) length);
                            i5 += read;
                            if (read < 0) {
                                break;
                            }
                        } while (i5 < length);
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                        UploadPartRequest uploadPartRequest = new UploadPartRequest();
                        uploadPartRequest.setBucketName(this.bucket);
                        uploadPartRequest.setKey(this.bosKey);
                        uploadPartRequest.setUploadId(this.uploadId);
                        uploadPartRequest.setInputStream(byteArrayInputStream);
                        uploadPartRequest.setPartSize(length);
                        uploadPartRequest.setPartNumber(i + 1);
                        uploadPart = this.bosClient.uploadPart(uploadPartRequest);
                    } catch (Throwable th) {
                        fileInputStream2 = fileInputStream;
                        th = th;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    log("Failed to upload the part " + i + " [tryCount] = " + i4);
                    i3 = i4 - 1;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            i4 = i3;
                        } catch (Exception e3) {
                            i4 = i3;
                        }
                    } else {
                        i4 = i3;
                    }
                }
            } catch (IOException e4) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
            if (uploadPart == null || uploadPart.getPartETag() == null || TextUtils.isEmpty(uploadPart.getPartETag().getETag())) {
                log("Failed to upload the part " + i + " [tryCount] = " + i4 + " 数据为null ");
                i3 = i4 - 1;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        i4 = i3;
                    } catch (Exception e5) {
                        i4 = i3;
                    }
                } else {
                    i4 = i3;
                }
            } else {
                ProcessCacheManager.getInstance().uploadCacheBean.parts.add(uploadPart.getPartETag());
                log("Complete upload with ETag: " + uploadPart.getPartETag() + System.currentTimeMillis());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e6) {
                    }
                }
            }
        }
        log("upload part : " + i + ", isSuccess : " + (i4 > 0));
        return i4 > 0;
    }

    private void initMultipartUpload(ObjectMetadata objectMetadata) {
        if (!TextUtils.isEmpty(ProcessCacheManager.getInstance().uploadCacheBean.uploadId)) {
            this.uploadId = ProcessCacheManager.getInstance().uploadCacheBean.uploadId;
        } else {
            InitiateMultipartUploadRequest initiateMultipartUploadRequest = new InitiateMultipartUploadRequest(this.bucket, this.bosKey);
            initiateMultipartUploadRequest.setObjectMetadata(objectMetadata);
            this.uploadId = this.bosClient.initiateMultipartUpload(initiateMultipartUploadRequest).getUploadId();
            ProcessCacheManager.getInstance().uploadCacheBean.uploadId = this.uploadId;
            ProcessCacheManager.getInstance().uploadCacheBean.getUpLoadIdReset();
        }
        if (TextUtils.isEmpty(this.uploadId)) {
            if (isCancelByUser() || this.tryNum != 2) {
            }
            return;
        }
        if (!isCancelByUser()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class UploadPartTask implements Callable<Boolean> {
        int partNum;
        FileUploadSession session;
        int totalPartNum;

        UploadPartTask(FileUploadSession fileUploadSession, int i, int i2) {
            this.session = fileUploadSession;
            this.partNum = i;
            this.totalPartNum = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            return Boolean.valueOf(this.session.uploadPart(this.partNum, this.totalPartNum));
        }
    }

    private void log(String str) {
    }

    public void singlePoolShutDownNow() {
        if (this.singlePool != null && !this.singlePool.isShutdown()) {
            Log.d("FileUploadTag", "单线程池 ShutDown " + System.currentTimeMillis());
            this.singlePool.shutdownNow();
        }
    }

    public boolean isCancelByUser() {
        return this.task != null && this.task.isCanceledByUser;
    }
}
