package com.baidu.ar.load;

import android.text.TextUtils;
import com.baidu.ar.load.util.ResponseUtil;
import com.baidu.ar.load.util.a;
import com.baidu.ar.task.ActionResponseListener;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.FileUtils;
import com.baidu.ar.util.IoUtils;
import com.baidu.ar.util.ZipUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
/* loaded from: classes3.dex */
public class FileManageTask extends ARAsyncTask<Object, Double, String> {
    public static final int STATUS_CANCEL = 3;
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_SUCCESS = 0;
    public static final int STATUS_TIMEOUT = 2;
    private ExtraOperateListener mExtraOperateListener;
    private FileMergeStrategy mFileMergeStrategy;
    private ActionResponseListener<String> mListener;
    private String mOriginFilePath;
    private String mTargetPath;
    private boolean mIsPause = false;
    private boolean mUseParallel = false;
    private long mProgressTime = 0;
    private double mProgress = 0.0d;

    /* loaded from: classes3.dex */
    public interface ExtraOperateListener {
        String excuteChangeResult(String str);
    }

    /* loaded from: classes3.dex */
    public enum FileMergeStrategy {
        COVER,
        SKIP
    }

    public FileManageTask(String str, String str2, FileMergeStrategy fileMergeStrategy, ActionResponseListener<String> actionResponseListener, ExtraOperateListener extraOperateListener) {
        this.mOriginFilePath = null;
        this.mTargetPath = null;
        this.mFileMergeStrategy = FileMergeStrategy.COVER;
        this.mOriginFilePath = str;
        this.mTargetPath = str2;
        this.mFileMergeStrategy = fileMergeStrategy;
        this.mListener = actionResponseListener;
        this.mExtraOperateListener = extraOperateListener;
    }

    private void checkPauseValid() {
        while (this.mIsPause) {
            ARLog.d("mIsPause = " + this.mIsPause);
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String executeExtraOperation(String str) {
        if (this.mExtraOperateListener != null) {
            String excuteChangeResult = this.mExtraOperateListener.excuteChangeResult(str);
            return !TextUtils.isEmpty(excuteChangeResult) ? excuteChangeResult : str;
        }
        return str;
    }

    private String manageFile() {
        if (TextUtils.isEmpty(this.mOriginFilePath)) {
            ARLog.e("originFilePath is null!");
            return null;
        } else if (TextUtils.isEmpty(this.mTargetPath)) {
            ARLog.e("targetPath is null!");
            return null;
        } else {
            File file = new File(this.mOriginFilePath);
            if (!file.exists()) {
                ARLog.e("originFile not exist!");
                return null;
            } else if (this.mOriginFilePath.length() <= 4) {
                ARLog.e("originFilePath is invalid for too short!");
                return null;
            } else if (!file.isDirectory()) {
                return FileUtils.getFileExtention(this.mOriginFilePath).equals("zip") ? manageZipFile() : manageNormalFile();
            } else {
                ARLog.e("originFile should not be directory!");
                return null;
            }
        }
    }

    private String manageNormalFile() {
        int i = 0;
        try {
            File file = new File(this.mOriginFilePath);
            File file2 = new File(this.mTargetPath);
            if (file2.isDirectory()) {
                ARLog.e("targetFile for normal should not be directory!");
                return null;
            } else if (file2.exists() && this.mFileMergeStrategy == FileMergeStrategy.SKIP) {
                return this.mTargetPath;
            } else {
                if (file.exists()) {
                    long length = file.length();
                    FileInputStream fileInputStream = new FileInputStream(this.mOriginFilePath);
                    FileOutputStream fileOutputStream = new FileOutputStream(this.mTargetPath);
                    byte[] bArr = new byte[1024];
                    do {
                        int read = fileInputStream.read(bArr);
                        if (read != -1) {
                            i += read;
                            postProgress((i / ((float) length)) * 100.0d);
                            fileOutputStream.write(bArr, 0, read);
                            checkPauseValid();
                        } else {
                            fileInputStream.close();
                        }
                    } while (!isCancelled());
                    ARLog.d("cancelled");
                    return null;
                }
                checkPauseValid();
                String executeExtraOperation = executeExtraOperation(this.mTargetPath);
                checkPauseValid();
                return executeExtraOperation;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ARLog.e(e.getMessage());
            return null;
        }
    }

    private String manageZipFile() {
        ZipFile zipFile;
        ZipFile zipFile2;
        ZipFile zipFile3;
        InputStream inputStream;
        InputStream inputStream2;
        final long j = 0;
        File file = new File(this.mOriginFilePath);
        if (new File(this.mTargetPath).isFile()) {
            ARLog.e("targetPath for unzip should be directory!");
            return null;
        }
        try {
            if (!ZipUtils.isZipFile(this.mOriginFilePath)) {
                ARLog.e("format error: not valid zip file!");
                return null;
            }
            try {
                zipFile2 = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                    Enumeration<? extends ZipEntry> entries2 = zipFile2.entries();
                    final long j2 = 0;
                    while (entries2.hasMoreElements()) {
                        j2 += entries2.nextElement().getSize();
                    }
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        if (!nextElement.getName().contains("../") && !nextElement.isDirectory()) {
                            File file2 = new File(this.mTargetPath, nextElement.getName());
                            if (!file2.getParentFile().exists()) {
                                ARLog.d("file path = " + file2.getAbsolutePath() + ", parent path = " + file2.getParentFile().getAbsolutePath());
                                file2.getParentFile().mkdirs();
                            }
                            if (!file2.exists() || this.mFileMergeStrategy != FileMergeStrategy.SKIP) {
                                long size = nextElement.getSize();
                                try {
                                    inputStream = zipFile2.getInputStream(nextElement);
                                    try {
                                        IoUtils.copyStream(inputStream, file2, size, new IoUtils.ProgressListener() { // from class: com.baidu.ar.load.FileManageTask.1
                                            @Override // com.baidu.ar.util.IoUtils.ProgressListener
                                            public void progress(long j3, long j4) {
                                                FileManageTask.this.postProgress((((float) (j + j3)) / ((float) j2)) * 100.0d);
                                            }
                                        });
                                        j += size;
                                        checkPauseValid();
                                        if (isCancelled()) {
                                            ARLog.d("cancelled");
                                            IoUtils.closeQuietly(inputStream);
                                            ZipUtils.closeZipFile(zipFile2);
                                            return null;
                                        }
                                        IoUtils.closeQuietly(inputStream);
                                    } catch (IOException e) {
                                        e = e;
                                        inputStream2 = inputStream;
                                        try {
                                            e.printStackTrace();
                                            ARLog.e(e.getMessage());
                                            IoUtils.closeQuietly(inputStream2);
                                            ZipUtils.closeZipFile(zipFile2);
                                            return null;
                                        } catch (Throwable th) {
                                            th = th;
                                            inputStream = inputStream2;
                                            IoUtils.closeQuietly(inputStream);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        IoUtils.closeQuietly(inputStream);
                                        throw th;
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    inputStream2 = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    inputStream = null;
                                }
                            }
                        }
                    }
                    ZipUtils.closeZipFile(zipFile2);
                    checkPauseValid();
                    String executeExtraOperation = executeExtraOperation(this.mTargetPath);
                    checkPauseValid();
                    return executeExtraOperation;
                } catch (ZipException e3) {
                    e = e3;
                    zipFile3 = zipFile2;
                    try {
                        e.printStackTrace();
                        ARLog.e(e.getMessage());
                        ZipUtils.closeZipFile(zipFile3);
                        return null;
                    } catch (Throwable th4) {
                        th = th4;
                        zipFile = zipFile3;
                        ZipUtils.closeZipFile(zipFile);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    ARLog.e(e.getMessage());
                    ZipUtils.closeZipFile(zipFile2);
                    return null;
                }
            } catch (ZipException e5) {
                e = e5;
                zipFile3 = null;
            } catch (IOException e6) {
                e = e6;
                zipFile2 = null;
            } catch (Throwable th5) {
                th = th5;
                zipFile = null;
                ZipUtils.closeZipFile(zipFile);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postProgress(double d) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mProgressTime <= 30 || d - this.mProgress < 1.0d) {
            return;
        }
        publishProgress(Double.valueOf(d));
        this.mProgressTime = currentTimeMillis;
        this.mProgress = d;
    }

    public void cancel() {
        this.mIsPause = false;
        cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.load.ARAsyncTask
    public String doInBackground(Object[] objArr) {
        return manageFile();
    }

    @Override // com.baidu.ar.load.ARAsyncTask
    protected void onCancelled() {
        if (this.mListener != null) {
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(3, "file manage cancel!", null));
        }
    }

    @Override // com.baidu.ar.load.ARAsyncTask
    protected void onError(String str) {
        if (this.mListener != null) {
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(1, "file manage task execute error:" + str, null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.load.ARAsyncTask
    public void onPostExecute(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.mListener != null) {
                this.mListener.onResponse(ResponseUtil.getActionResponseInfo(1, "file manage result is null!", null));
                return;
            }
            return;
        }
        onProgressUpdate(Double.valueOf(100.0d));
        if (this.mListener != null) {
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(0, str, null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.load.ARAsyncTask
    public void onProgressUpdate(Double... dArr) {
        super.onProgressUpdate((Object[]) dArr);
        if (dArr.length <= 0 || this.mListener == null) {
            return;
        }
        this.mListener.onProgress(dArr[0].intValue());
    }

    @Override // com.baidu.ar.load.ARAsyncTask
    protected void onTimeout() {
        if (this.mListener != null) {
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(2, "file manage time out!", null));
        }
    }

    public void pause() {
        this.mIsPause = true;
    }

    public void resume() {
        this.mIsPause = false;
    }

    public void setParallel() {
        this.mUseParallel = true;
    }

    public void start() {
        if (this.mUseParallel) {
            executeOnExecutor(a.b(), new Object[0]);
        } else {
            execute(new Object[0]);
        }
    }

    public void startDelay(long j) {
        if (this.mUseParallel) {
            postDelay(j, 1);
        } else {
            postDelay(j, 0);
        }
    }
}
