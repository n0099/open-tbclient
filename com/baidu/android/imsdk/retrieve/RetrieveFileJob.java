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
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class RetrieveFileJob extends IRetrieveJob {
    private static final String FETCH_FILE_ZIP = ".im_fetch_file_zip";
    private static final long MAX_SIZE = 1048576;
    private static final String TAG = "RetrieveFileJob";
    private final AtomicInteger mRetryCount = new AtomicInteger(0);

    @Override // com.baidu.android.imsdk.retrieve.IRetrieveJob
    public void dispatch(final JSONObject jSONObject, final Context context) {
        TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.retrieve.RetrieveFileJob.1
            @Override // java.lang.Runnable
            public void run() {
                final RetrieveFileData.RetrieveFileBean parseJsonContent = RetrieveFileData.parseJsonContent(jSONObject, context);
                if (parseJsonContent != null) {
                    RetrieveReportImpl.getInstance(context).reportDispatch(parseJsonContent.mType, parseJsonContent.mJobId, parseJsonContent.mVersion, jSONObject, "3", new IReportListener() { // from class: com.baidu.android.imsdk.retrieve.RetrieveFileJob.1.1
                        @Override // com.baidu.android.imsdk.retrieve.IReportListener
                        public void onSuccess(ReportResult reportResult) {
                            if (reportResult != null && TextUtils.equals("1", reportResult.getValid())) {
                                LogUtils.d(RetrieveFileJob.TAG, "retrieve--> 文件任务真正开始上报");
                                RetrieveFileJob.this.startRetrieveFile(parseJsonContent, context);
                            }
                        }

                        @Override // com.baidu.android.imsdk.retrieve.IReportListener
                        public void onFailure() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void startRetrieveFile(RetrieveFileData.RetrieveFileBean retrieveFileBean, Context context) {
        List<String> list = retrieveFileBean.mPathList;
        if (list != null && list.size() != 0) {
            deleteZip(context, list);
            if (this.mRetryCount.get() > 1) {
                LogUtils.d(TAG, "文件一直上报失败，不再重试上报");
                RetrieveReportImpl.getInstance(context).reportTaskDone(retrieveFileBean.mType, retrieveFileBean.mJobId, retrieveFileBean.mVersion, "2", "", "", null, "");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            File zipFile = getZipFile(list, jSONObject, retrieveFileBean, context);
            String jSONObject2 = jSONObject == null ? "" : jSONObject.toString();
            if (zipFile != null && zipFile.exists()) {
                String absolutePath = zipFile.getAbsolutePath();
                genBosObjectUrl(context, absolutePath, "application/octet-stream", "zip", 0, 0, 0, new AnonymousClass2(context, retrieveFileBean, jSONObject2, zipFile, absolutePath));
                return;
            }
            RetrieveReportImpl.getInstance(context).reportTaskDone(retrieveFileBean.mType, retrieveFileBean.mJobId, retrieveFileBean.mVersion, "1", "", jSONObject2, null, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.android.imsdk.retrieve.RetrieveFileJob$2  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass2 implements IGenBosObjectUrlListener {
        final /* synthetic */ Context val$context;
        final /* synthetic */ RetrieveFileData.RetrieveFileBean val$fileBean;
        final /* synthetic */ String val$filePath;
        final /* synthetic */ String val$metaStr;
        final /* synthetic */ File val$zipFile;

        AnonymousClass2(Context context, RetrieveFileData.RetrieveFileBean retrieveFileBean, String str, File file, String str2) {
            this.val$context = context;
            this.val$fileBean = retrieveFileBean;
            this.val$metaStr = str;
            this.val$zipFile = file;
            this.val$filePath = str2;
        }

        @Override // com.baidu.android.imsdk.chatmessage.IGenBosObjectUrlListener
        public void onGenBosObjectUrlListener(int i, String str, String str2, String str3, Map<String, String> map) {
            if (i == 0) {
                final String str4 = "";
                if (map != null) {
                    map.get(AsyncChatTask.GET_URL);
                    str4 = map.get(AsyncChatTask.PUT_URL);
                }
                IFileUploadListener iFileUploadListener = new IFileUploadListener() { // from class: com.baidu.android.imsdk.retrieve.RetrieveFileJob.2.1
                    @Override // com.baidu.android.imsdk.upload.IFileUploadListener
                    public void onFailed(int i2, String str5) {
                        LogUtils.d(RetrieveFileJob.TAG, "retrieve--> IFileUploadListener onFailed errorcode:" + i2 + ", failedMsg:" + str5);
                        switch (i2) {
                            case 1005:
                                RetrieveReportImpl.getInstance(AnonymousClass2.this.val$context).reportTaskDone(AnonymousClass2.this.val$fileBean.mType, AnonymousClass2.this.val$fileBean.mJobId, AnonymousClass2.this.val$fileBean.mVersion, "1", "", AnonymousClass2.this.val$metaStr, null, "");
                                return;
                            default:
                                RetrieveFileJob.this.mRetryCount.incrementAndGet();
                                RetrieveFileJob.this.startRetrieveFile(AnonymousClass2.this.val$fileBean, AnonymousClass2.this.val$context);
                                return;
                        }
                    }

                    @Override // com.baidu.android.imsdk.upload.IFileUploadListener
                    public void onFinished(int i2) {
                        LogUtils.d(RetrieveFileJob.TAG, "retrieve--> IFileUploadListener onFinished");
                        if (i2 == 0) {
                            RetrieveFileJob.this.mRetryCount.set(0);
                            RetrieveReportImpl.getInstance(AnonymousClass2.this.val$context).reportTaskDone(AnonymousClass2.this.val$fileBean.mType, AnonymousClass2.this.val$fileBean.mJobId, AnonymousClass2.this.val$fileBean.mVersion, "0", "", AnonymousClass2.this.val$metaStr, new IReportListener() { // from class: com.baidu.android.imsdk.retrieve.RetrieveFileJob.2.1.1
                                @Override // com.baidu.android.imsdk.retrieve.IReportListener
                                public void onSuccess(ReportResult reportResult) {
                                    LogUtils.d(RetrieveFileJob.TAG, "retrieve--> 回传文件成功，可以删除缓存文件，删除的文件路径：" + AnonymousClass2.this.val$zipFile.getAbsolutePath());
                                    AnonymousClass2.this.val$zipFile.delete();
                                }

                                @Override // com.baidu.android.imsdk.retrieve.IReportListener
                                public void onFailure() {
                                    LogUtils.d(RetrieveFileJob.TAG, "retrieve-->文件回传failed");
                                }
                            }, str4);
                        }
                    }

                    @Override // com.baidu.android.imsdk.upload.IFileUploadListener
                    public void onProgress(int i2) {
                    }
                };
                if (RetrieveFileJob.this.isUpload(this.val$context, this.val$filePath, this.val$fileBean)) {
                    ChatMsgManager.uploadFile(this.val$context, str4, this.val$filePath, "application/octet-stream", str2, str3, iFileUploadListener);
                    return;
                } else {
                    RetrieveReportImpl.getInstance(this.val$context).reportTaskDone(this.val$fileBean.mType, this.val$fileBean.mJobId, this.val$fileBean.mVersion, "2", "", this.val$metaStr, null, "");
                    return;
                }
            }
            RetrieveReportImpl.getInstance(this.val$context).reportTaskDone(this.val$fileBean.mType, this.val$fileBean.mJobId, this.val$fileBean.mVersion, "1", "", this.val$metaStr, null, "");
        }
    }

    private void deleteZip(Context context, List<String> list) {
        File file = new File(context.getFilesDir(), FETCH_FILE_ZIP);
        if (file.exists()) {
            FileUtils.deleteFile(file);
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

    private void genBosObjectUrl(Context context, String str, String str2, String str3, int i, int i2, int i3, IGenBosObjectUrlListener iGenBosObjectUrlListener) {
        LogUtils.d(TAG, "filePath=" + str);
        IMGenBosObjectUrlRequest iMGenBosObjectUrlRequest = new IMGenBosObjectUrlRequest(context, str, str2, str3, i, i2, i3, ListenerManager.getInstance().addListener(iGenBosObjectUrlListener));
        HttpHelper.executor(context, iMGenBosObjectUrlRequest, iMGenBosObjectUrlRequest);
    }

    private File getZipFile(List<String> list, JSONObject jSONObject, RetrieveFileData.RetrieveFileBean retrieveFileBean, Context context) {
        ArrayList arrayList;
        File file;
        String replace;
        long j;
        try {
            arrayList = new ArrayList(list.size());
            long j2 = 0;
            long j3 = retrieveFileBean.mMaxFileSize * 1000;
            Iterator<String> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    if (next.startsWith(Constants.PATH_EXTERNAL)) {
                        replace = next.replace(Constants.PATH_EXTERNAL, context.getExternalFilesDir(null).getParent() + File.separatorChar);
                    } else if (next.startsWith(Constants.PATH_INTERNAL)) {
                        replace = next.replace(Constants.PATH_INTERNAL, context.getFilesDir().getParent() + File.separatorChar);
                    } else {
                        generateMetaInfo(next, "4", next + " error", null, null, true, jSONObject);
                    }
                    LogUtils.d(TAG, "retrieve--> 回捞路径：" + replace);
                    if (replace.contains(Constants.PATH_PARENT)) {
                        generateMetaInfo(replace, "4", replace + " error", null, null, true, jSONObject);
                    } else {
                        File file2 = new File(replace);
                        if (!file2.exists()) {
                            generateMetaInfo(replace, "1", replace + " not exist", null, null, true, jSONObject);
                        } else {
                            if (file2.isFile()) {
                                j2 += file2.length();
                                if (j2 > j3) {
                                    generateMetaInfo(replace, "3", replace + " size exceed maxFileSize ", null, null, true, jSONObject);
                                    break;
                                }
                                StringBuilder sb = new StringBuilder(Utility.getMd5(file2.getAbsolutePath()));
                                sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(file2.getName());
                                arrayList.add(new FileZipUtil.ZipSrc(file2, sb.toString()));
                                generateMetaInfo(replace, "0", replace + " success", file2, sb.toString(), true, jSONObject);
                            }
                            long j4 = j2;
                            if (file2.isDirectory()) {
                                File[] listFiles = file2.listFiles();
                                if (listFiles == null) {
                                    j2 = j4;
                                } else if (listFiles.length == 0) {
                                    j2 = j4;
                                } else {
                                    ArrayList arrayList2 = new ArrayList(listFiles.length);
                                    long j5 = j4;
                                    for (File file3 : listFiles) {
                                        j5 += file3.length();
                                        if (file3.exists()) {
                                            arrayList2.add(new FileZipUtil.ZipSrc(file3, file3.getName()));
                                        }
                                    }
                                    if (j5 > j3) {
                                        generateMetaInfo(replace, "3", file2.getPath() + "size exceed maxFileSize ", null, null, true, jSONObject);
                                        break;
                                    }
                                    File file4 = new File(context.getFilesDir(), FETCH_FILE_ZIP);
                                    String md5 = Utility.getMd5(file2.getAbsolutePath());
                                    LogUtils.d(TAG, "retrieve--> innerZipPathMD5:" + md5);
                                    File file5 = new File(file4, md5 + ".zip");
                                    boolean z = true;
                                    try {
                                        if (!file4.exists()) {
                                            file4.mkdir();
                                        }
                                        if (file5.exists()) {
                                            file5.delete();
                                        }
                                        file5.createNewFile();
                                        FileZipUtil.zip(file5, arrayList2);
                                    } catch (IOException e) {
                                        z = false;
                                    }
                                    if (z) {
                                        arrayList.add(new FileZipUtil.ZipSrc(file5, file5.getName(), true));
                                        generateMetaInfo(replace, "0", "success", file5, file5.getPath(), false, jSONObject);
                                        j = j5;
                                    } else {
                                        generateMetaInfo(replace, "2", replace + "copy error", null, null, false, jSONObject);
                                        j = j5;
                                    }
                                }
                            } else {
                                j = j4;
                            }
                            j2 = j;
                        }
                    }
                }
            }
            File file6 = new File(context.getFilesDir(), FETCH_FILE_ZIP);
            file = new File(file6, System.nanoTime() + ".zip");
            if (!file6.exists()) {
                file6.mkdir();
            }
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (arrayList.size() > 0) {
            FileZipUtil.zip(file, arrayList);
            String absolutePath = file.getAbsolutePath();
            LogUtils.d(TAG, "retrieve--> zipFile path:" + absolutePath);
            return new File(absolutePath);
        }
        generateMetaInfo(file.getAbsolutePath(), "1", file.getPath() + " not exist", null, null, true, jSONObject);
        LogUtils.d(TAG, "retrieve--> zipFile path 空");
        return null;
    }

    private void generateMetaInfo(String str, String str2, String str3, File file, String str4, boolean z, JSONObject jSONObject) {
        try {
            JSONObject makeFileMeta = FileMetaUtil.makeFileMeta(file, str4, str2, str3, z);
            jSONObject.put(str, makeFileMeta);
            LogUtils.d(TAG, "retrieve--> generateMetaInfo error:" + str2);
            LogUtils.d(TAG, "retrieve-->generateMetaInfo path:" + str + " fileMeta:" + makeFileMeta);
        } catch (JSONException e) {
            LogUtils.d(TAG, e.toString());
        }
    }
}
