package com.baidu.android.imsdk.retrieve;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatmessage.IGenBosObjectUrlListener;
import com.baidu.android.imsdk.chatmessage.request.IMGenBosObjectUrlRequest;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.retrieve.RetrieveFileData;
import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
import com.baidu.android.imsdk.retrieve.util.FileUtils;
import com.baidu.android.imsdk.retrieve.util.FileZipUtil;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.AsyncChatTask;
import com.baidu.android.imsdk.upload.IFileUploadListener;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class RetrieveFileJob extends IRetrieveJob {
    public static final String FETCH_FILE_ZIP = ".im_fetch_file_zip";
    public static final long MAX_SIZE = 1048576;
    public static final String TAG = "RetrieveFileJob";
    public final AtomicInteger mRetryCount = new AtomicInteger(0);

    /* renamed from: com.baidu.android.imsdk.retrieve.RetrieveFileJob$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements IGenBosObjectUrlListener {
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ RetrieveFileData.RetrieveFileBean val$fileBean;
        public final /* synthetic */ String val$filePath;
        public final /* synthetic */ String val$metaStr;
        public final /* synthetic */ File val$zipFile;

        public AnonymousClass2(Context context, RetrieveFileData.RetrieveFileBean retrieveFileBean, String str, File file, String str2) {
            this.val$context = context;
            this.val$fileBean = retrieveFileBean;
            this.val$metaStr = str;
            this.val$zipFile = file;
            this.val$filePath = str2;
        }

        @Override // com.baidu.android.imsdk.chatmessage.IGenBosObjectUrlListener
        public void onGenBosObjectUrlListener(int i2, String str, String str2, String str3, Map<String, String> map) {
            String str4;
            if (i2 == 0) {
                if (map != null) {
                    str4 = map.get(AsyncChatTask.PUT_URL);
                    map.get(AsyncChatTask.GET_URL);
                } else {
                    str4 = "";
                }
                final String str5 = str4;
                IFileUploadListener iFileUploadListener = new IFileUploadListener() { // from class: com.baidu.android.imsdk.retrieve.RetrieveFileJob.2.1
                    @Override // com.baidu.android.imsdk.upload.IFileUploadListener
                    public void onFailed(int i3, String str6) {
                        LogUtils.d(RetrieveFileJob.TAG, "retrieve--> IFileUploadListener onFailed errorcode:" + i3 + ", failedMsg:" + str6);
                        if (i3 != 1005) {
                            RetrieveFileJob.this.mRetryCount.incrementAndGet();
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            RetrieveFileJob.this.startRetrieveFile(anonymousClass2.val$fileBean, anonymousClass2.val$context);
                            return;
                        }
                        RetrieveReportImpl retrieveReportImpl = RetrieveReportImpl.getInstance(AnonymousClass2.this.val$context);
                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                        RetrieveFileData.RetrieveFileBean retrieveFileBean = anonymousClass22.val$fileBean;
                        retrieveReportImpl.reportTaskDone(retrieveFileBean.mType, retrieveFileBean.mJobId, retrieveFileBean.mVersion, "1", "", anonymousClass22.val$metaStr, null, "");
                    }

                    @Override // com.baidu.android.imsdk.upload.IFileUploadListener
                    public void onFinished(int i3) {
                        LogUtils.d(RetrieveFileJob.TAG, "retrieve--> IFileUploadListener onFinished");
                        if (i3 == 0) {
                            RetrieveFileJob.this.mRetryCount.set(0);
                            RetrieveReportImpl retrieveReportImpl = RetrieveReportImpl.getInstance(AnonymousClass2.this.val$context);
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            RetrieveFileData.RetrieveFileBean retrieveFileBean = anonymousClass2.val$fileBean;
                            retrieveReportImpl.reportTaskDone(retrieveFileBean.mType, retrieveFileBean.mJobId, retrieveFileBean.mVersion, "0", "", anonymousClass2.val$metaStr, new IReportListener() { // from class: com.baidu.android.imsdk.retrieve.RetrieveFileJob.2.1.1
                                @Override // com.baidu.android.imsdk.retrieve.IReportListener
                                public void onFailure() {
                                    LogUtils.d(RetrieveFileJob.TAG, "retrieve-->文件回传failed");
                                }

                                @Override // com.baidu.android.imsdk.retrieve.IReportListener
                                public void onSuccess(ReportResult reportResult) {
                                    LogUtils.d(RetrieveFileJob.TAG, "retrieve--> 回传文件成功，可以删除缓存文件，删除的文件路径：" + AnonymousClass2.this.val$zipFile.getAbsolutePath());
                                    AnonymousClass2.this.val$zipFile.delete();
                                }
                            }, str5);
                        }
                    }

                    @Override // com.baidu.android.imsdk.upload.IFileUploadListener
                    public void onProgress(int i3) {
                    }
                };
                if (RetrieveFileJob.this.isUpload(this.val$context, this.val$filePath, this.val$fileBean)) {
                    ChatMsgManager.uploadFile(this.val$context, str5, this.val$filePath, "application/octet-stream", str2, str3, iFileUploadListener);
                    return;
                }
                RetrieveReportImpl retrieveReportImpl = RetrieveReportImpl.getInstance(this.val$context);
                RetrieveFileData.RetrieveFileBean retrieveFileBean = this.val$fileBean;
                retrieveReportImpl.reportTaskDone(retrieveFileBean.mType, retrieveFileBean.mJobId, retrieveFileBean.mVersion, "2", "", this.val$metaStr, null, "");
                return;
            }
            RetrieveReportImpl retrieveReportImpl2 = RetrieveReportImpl.getInstance(this.val$context);
            RetrieveFileData.RetrieveFileBean retrieveFileBean2 = this.val$fileBean;
            retrieveReportImpl2.reportTaskDone(retrieveFileBean2.mType, retrieveFileBean2.mJobId, retrieveFileBean2.mVersion, "1", "", this.val$metaStr, null, "");
        }
    }

    private void deleteZip(Context context, List<String> list) {
        File file = new File(context.getFilesDir(), FETCH_FILE_ZIP);
        if (file.exists()) {
            FileUtils.deleteFile(file);
        }
    }

    private void genBosObjectUrl(Context context, String str, String str2, String str3, int i2, int i3, int i4, IGenBosObjectUrlListener iGenBosObjectUrlListener) {
        LogUtils.d(TAG, "filePath=" + str);
        IMGenBosObjectUrlRequest iMGenBosObjectUrlRequest = new IMGenBosObjectUrlRequest(context, str, str2, str3, i2, i3, i4, ListenerManager.getInstance().addListener(iGenBosObjectUrlListener));
        HttpHelper.executor(context, iMGenBosObjectUrlRequest, iMGenBosObjectUrlRequest);
    }

    private void generateMetaInfo(String str, String str2, String str3, File file, String str4, boolean z, JSONObject jSONObject) {
        try {
            JSONObject makeFileMeta = FileMetaUtil.makeFileMeta(file, str4, str2, str3, z);
            jSONObject.put(str, makeFileMeta);
            LogUtils.d(TAG, "retrieve--> generateMetaInfo error:" + str2);
            LogUtils.d(TAG, "retrieve-->generateMetaInfo path:" + str + " fileMeta:" + makeFileMeta);
        } catch (JSONException e2) {
            LogUtils.d(TAG, e2.toString());
        }
    }

    private File getZipFile(List<String> list, JSONObject jSONObject, RetrieveFileData.RetrieveFileBean retrieveFileBean, Context context) {
        Iterator<String> it;
        String str;
        String str2;
        String replace;
        File[] listFiles;
        File[] fileArr;
        long j;
        String str3 = Constants.PATH_INTERNAL;
        String str4 = Constants.PATH_EXTERNAL;
        String str5 = null;
        try {
            ArrayList arrayList = new ArrayList(list.size());
            long j2 = 0;
            long j3 = retrieveFileBean.mMaxFileSize * 1000;
            Iterator<String> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                String next = it2.next();
                if (TextUtils.isEmpty(next)) {
                    str = str3;
                    str2 = str4;
                    it = it2;
                } else {
                    if (next.startsWith(str4)) {
                        StringBuilder sb = new StringBuilder();
                        it = it2;
                        sb.append(context.getExternalFilesDir(str5).getParent());
                        sb.append(File.separatorChar);
                        replace = next.replace(str4, sb.toString());
                    } else {
                        it = it2;
                        if (next.startsWith(str3)) {
                            replace = next.replace(str3, context.getFilesDir().getParent() + File.separatorChar);
                        } else {
                            str = str3;
                            str2 = str4;
                            generateMetaInfo(next, "4", next + " error", null, null, true, jSONObject);
                        }
                    }
                    LogUtils.d(TAG, "retrieve--> 回捞路径：" + replace);
                    if (replace.contains(Constants.PATH_PARENT)) {
                        generateMetaInfo(replace, "4", replace + " error", null, null, true, jSONObject);
                    } else {
                        File file = new File(replace);
                        if (!file.exists()) {
                            generateMetaInfo(replace, "1", replace + " not exist", null, null, true, jSONObject);
                        } else {
                            if (file.isFile()) {
                                j2 += file.length();
                                if (j2 > j3) {
                                    generateMetaInfo(replace, "3", replace + " size exceed maxFileSize ", null, null, true, jSONObject);
                                    break;
                                }
                                StringBuilder sb2 = new StringBuilder(Utility.getMd5(file.getAbsolutePath()));
                                sb2.append("_");
                                sb2.append(file.getName());
                                str = str3;
                                arrayList.add(new FileZipUtil.ZipSrc(file, sb2.toString()));
                                generateMetaInfo(replace, "0", replace + " success", file, sb2.toString(), true, jSONObject);
                            } else {
                                str = str3;
                            }
                            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                                ArrayList arrayList2 = new ArrayList(listFiles.length);
                                int length = listFiles.length;
                                boolean z = false;
                                str2 = str4;
                                int i2 = 0;
                                while (i2 < length) {
                                    File file2 = listFiles[i2];
                                    long length2 = j2 + file2.length();
                                    if (file2.exists()) {
                                        fileArr = listFiles;
                                        j = length2;
                                        arrayList2.add(new FileZipUtil.ZipSrc(file2, file2.getName()));
                                    } else {
                                        fileArr = listFiles;
                                        j = length2;
                                    }
                                    i2++;
                                    listFiles = fileArr;
                                    j2 = j;
                                }
                                if (j2 > j3) {
                                    generateMetaInfo(replace, "3", file.getPath() + "size exceed maxFileSize ", null, null, true, jSONObject);
                                    break;
                                }
                                File file3 = new File(context.getFilesDir(), FETCH_FILE_ZIP);
                                String md5 = Utility.getMd5(file.getAbsolutePath());
                                LogUtils.d(TAG, "retrieve--> innerZipPathMD5:" + md5);
                                File file4 = new File(file3, md5 + ".zip");
                                try {
                                    if (!file3.exists()) {
                                        file3.mkdir();
                                    }
                                    if (file4.exists()) {
                                        file4.delete();
                                    }
                                    file4.createNewFile();
                                    FileZipUtil.zip(file4, arrayList2);
                                    z = true;
                                } catch (IOException unused) {
                                }
                                if (z) {
                                    arrayList.add(new FileZipUtil.ZipSrc(file4, file4.getName(), true));
                                    generateMetaInfo(replace, "0", "success", file4, file4.getPath(), false, jSONObject);
                                } else {
                                    generateMetaInfo(replace, "2", replace + "copy error", null, null, false, jSONObject);
                                }
                            }
                            str2 = str4;
                        }
                    }
                    str = str3;
                    str2 = str4;
                }
                it2 = it;
                str3 = str;
                str4 = str2;
                str5 = null;
            }
            File file5 = new File(context.getFilesDir(), FETCH_FILE_ZIP);
            File file6 = new File(file5, System.nanoTime() + ".zip");
            if (!file5.exists()) {
                file5.mkdir();
            }
            if (file6.exists()) {
                file6.delete();
            }
            file6.createNewFile();
            if (arrayList.size() > 0) {
                FileZipUtil.zip(file6, arrayList);
                String absolutePath = file6.getAbsolutePath();
                LogUtils.d(TAG, "retrieve--> zipFile path:" + absolutePath);
                return new File(absolutePath);
            }
            String absolutePath2 = file6.getAbsolutePath();
            generateMetaInfo(absolutePath2, "1", file6.getPath() + " not exist", null, null, true, jSONObject);
            LogUtils.d(TAG, "retrieve--> zipFile path 空");
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isUpload(Context context, String str, RetrieveFileData.RetrieveFileBean retrieveFileBean) {
        if (retrieveFileBean == null) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.length() <= 1048576 || RequsetNetworkUtils.isWifiConnected(context);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRetrieveFile(RetrieveFileData.RetrieveFileBean retrieveFileBean, Context context) {
        List<String> list = retrieveFileBean.mPathList;
        if (list == null || list.size() == 0) {
            return;
        }
        deleteZip(context, list);
        if (this.mRetryCount.get() > 1) {
            LogUtils.d(TAG, "文件一直上报失败，不再重试上报");
            RetrieveReportImpl.getInstance(context).reportTaskDone(retrieveFileBean.mType, retrieveFileBean.mJobId, retrieveFileBean.mVersion, "2", "", "", null, "");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        File zipFile = getZipFile(list, jSONObject, retrieveFileBean, context);
        String jSONObject2 = jSONObject.toString();
        if (zipFile != null && zipFile.exists()) {
            String absolutePath = zipFile.getAbsolutePath();
            genBosObjectUrl(context, absolutePath, "application/octet-stream", "zip", 0, 0, 0, new AnonymousClass2(context, retrieveFileBean, jSONObject2, zipFile, absolutePath));
            return;
        }
        RetrieveReportImpl.getInstance(context).reportTaskDone(retrieveFileBean.mType, retrieveFileBean.mJobId, retrieveFileBean.mVersion, "1", "", jSONObject2, null, "");
    }

    @Override // com.baidu.android.imsdk.retrieve.IRetrieveJob
    public void dispatch(final JSONObject jSONObject, final Context context) {
        TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.retrieve.RetrieveFileJob.1
            @Override // java.lang.Runnable
            public void run() {
                final RetrieveFileData.RetrieveFileBean parseJsonContent = RetrieveFileData.parseJsonContent(jSONObject, context);
                if (parseJsonContent != null) {
                    RetrieveReportImpl.getInstance(context).reportDispatch(parseJsonContent.mType, parseJsonContent.mJobId, parseJsonContent.mVersion, jSONObject, "3", new IReportListener() { // from class: com.baidu.android.imsdk.retrieve.RetrieveFileJob.1.1
                        @Override // com.baidu.android.imsdk.retrieve.IReportListener
                        public void onFailure() {
                        }

                        @Override // com.baidu.android.imsdk.retrieve.IReportListener
                        public void onSuccess(ReportResult reportResult) {
                            if (reportResult == null || !TextUtils.equals("1", reportResult.getValid())) {
                                return;
                            }
                            LogUtils.d(RetrieveFileJob.TAG, "retrieve--> 文件任务真正开始上报");
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            RetrieveFileJob.this.startRetrieveFile(parseJsonContent, context);
                        }
                    });
                }
            }
        });
    }

    @Override // com.baidu.android.imsdk.retrieve.IRetrieveJob
    public String getRetrieveJobType() {
        return null;
    }
}
