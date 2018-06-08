package com.baidu.ar.load;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.ar.load.util.ResponseUtil;
import com.baidu.ar.task.ActionResponseListener;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.FileUtils;
import com.baidu.ar.util.HttpUtils;
import com.baidu.ar.util.IoUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;
/* loaded from: classes3.dex */
public class DownloadTask extends ARAsyncTask<Object, Double, String> {
    public static final int STATUS_CANCEL = 3;
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_SUCCESS = 0;
    public static final int STATUS_TIMEOUT = 2;
    private FileStoreStrategy mFileStoreStrategy;
    private ActionResponseListener<String> mListener;
    private String mTargetPath;
    private String mUrl;
    private boolean mIsPause = false;
    private boolean mUseParallel = false;

    /* loaded from: classes3.dex */
    public enum FileStoreStrategy {
        COVER,
        SKIP
    }

    public DownloadTask(String str, String str2, FileStoreStrategy fileStoreStrategy, ActionResponseListener<String> actionResponseListener) {
        this.mUrl = null;
        this.mTargetPath = null;
        this.mFileStoreStrategy = FileStoreStrategy.SKIP;
        this.mUrl = str;
        this.mTargetPath = str2;
        this.mFileStoreStrategy = fileStoreStrategy;
        this.mListener = actionResponseListener;
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

    private String doDownload() {
        RandomAccessFile randomAccessFile;
        BufferedInputStream bufferedInputStream;
        URLConnection openConnection;
        long j;
        if (TextUtils.isEmpty(this.mUrl)) {
            ARLog.e("download url is null!");
            return null;
        } else if (TextUtils.isEmpty(this.mTargetPath)) {
            ARLog.e("targetPath is null!");
            return null;
        } else {
            int length = HttpUtils.getLength(this.mUrl);
            ARLog.d("download length = " + length);
            if (length <= 0) {
                ARLog.e("download file totalSize is smaller than 0!");
                return null;
            }
            File file = new File(this.mTargetPath);
            if (file.exists()) {
                if (file.length() == length && this.mFileStoreStrategy != FileStoreStrategy.COVER) {
                    return this.mTargetPath;
                }
                file.delete();
            }
            String str = this.mTargetPath + "tmp";
            File file2 = new File(str);
            if (file2.exists()) {
                file2.delete();
            } else if (!FileUtils.ensureDirectoryExist(file2.getParentFile())) {
                ARLog.e("create file directory failed!");
                return null;
            } else {
                try {
                    file2.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                    ARLog.e("create file error!");
                    return null;
                }
            }
            try {
                openConnection = new URL(this.mUrl).openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setRequestProperty("Range", "bytes=0-" + length);
                randomAccessFile = new RandomAccessFile(str, "rw");
            } catch (IOException e2) {
                e = e2;
                randomAccessFile = null;
                bufferedInputStream = null;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = null;
                bufferedInputStream = null;
            }
            try {
                randomAccessFile.seek(0L);
                byte[] bArr = new byte[8192];
                bufferedInputStream = new BufferedInputStream(openConnection.getInputStream(), 8192);
                int i = 0;
                long j2 = 0;
                double d = 0.0d;
                while (true) {
                    try {
                        try {
                            int read = bufferedInputStream.read(bArr, 0, 8192);
                            if (read == -1) {
                                IoUtils.closeQuietly(bufferedInputStream);
                                IoUtils.closeQuietly(randomAccessFile);
                                try {
                                    file2.renameTo(new File(this.mTargetPath));
                                    checkPauseValid();
                                    return this.mTargetPath;
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                    ARLog.e("temp file rename error!");
                                    return null;
                                }
                            }
                            ARLog.d("one while read start n =" + read);
                            randomAccessFile.write(bArr, 0, read);
                            i += read;
                            double d2 = (i / length) * 100.0d;
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - j2 <= 30 || d2 - d < 1.0d) {
                                d2 = d;
                                j = j2;
                            } else {
                                publishProgress(Double.valueOf((i / length) * 100.0d));
                                j = currentTimeMillis;
                            }
                            ARLog.d("one while read end count = " + i);
                            checkPauseValid();
                            if (isCancelled()) {
                                ARLog.d("cancelled");
                                IoUtils.closeQuietly(bufferedInputStream);
                                IoUtils.closeQuietly(randomAccessFile);
                                return null;
                            }
                            j2 = j;
                            d = d2;
                        } catch (IOException e4) {
                            e = e4;
                            e.printStackTrace();
                            ARLog.e(e.getMessage());
                            IoUtils.closeQuietly(bufferedInputStream);
                            IoUtils.closeQuietly(randomAccessFile);
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        IoUtils.closeQuietly(bufferedInputStream);
                        IoUtils.closeQuietly(randomAccessFile);
                        throw th;
                    }
                }
            } catch (IOException e5) {
                e = e5;
                bufferedInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
                IoUtils.closeQuietly(bufferedInputStream);
                IoUtils.closeQuietly(randomAccessFile);
                throw th;
            }
        }
    }

    public void cancel() {
        this.mIsPause = false;
        cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.load.ARAsyncTask
    public String doInBackground(Object[] objArr) {
        return doDownload();
    }

    @Override // com.baidu.ar.load.ARAsyncTask
    protected void onCancelled() {
        if (this.mListener != null) {
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(3, "download cancel!", null));
        }
    }

    @Override // com.baidu.ar.load.ARAsyncTask
    protected void onError(String str) {
        if (this.mListener != null) {
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(1, "download task execute error:" + str, null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.load.ARAsyncTask
    public void onPostExecute(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.mListener != null) {
                this.mListener.onResponse(ResponseUtil.getActionResponseInfo(1, "download result is null!", null));
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
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(2, "download time out!", null));
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
            executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
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
