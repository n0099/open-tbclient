package com.baidu.mobads.container.components.downloader;

import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.executor.TaskScheduler;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;
/* loaded from: classes2.dex */
public class FileDownloader extends Observable implements Runnable, IDownloader {
    public static final int BLOCK_SIZE = 10240;
    public static final int BUFFER_SIZE = 10240;
    public static final String TAG = "OAdSimpleFileDownloader";
    public static final String TEMP_SUFFIX = ".tmp";
    public byte[] mByteArray;
    public int mDownloaded;
    public String mFileName;
    public int mFileSize;
    public String mOutputFolder;
    public int mProgress;
    public IDownloader.DownloadStatus mState;
    public URL mURL;
    public boolean saveFileAndMemory;

    public FileDownloader(URL url, String str, String str2, boolean z) {
        this.saveFileAndMemory = false;
        this.mURL = url;
        this.mOutputFolder = str;
        this.saveFileAndMemory = z;
        if (str2 != null && str2.trim().length() > 0) {
            this.mFileName = str2;
        } else {
            String file = url.getFile();
            this.mFileName = file.substring(file.lastIndexOf(47) + 1);
        }
        this.mFileSize = -1;
        this.mState = IDownloader.DownloadStatus.DOWNLOADING;
        this.mDownloaded = 0;
        this.mProgress = 0;
    }

    private void error() {
        setState(IDownloader.DownloadStatus.ERROR);
    }

    private HttpURLConnection openConnectionCheckRedirects(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                URL url = new URL(httpURLConnection.getHeaderField("Location"));
                this.mURL = url;
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception unused) {
                    return httpURLConnection2;
                }
            } catch (Exception unused2) {
                return httpURLConnection;
            }
        }
    }

    private boolean renameFile(String str, String str2) {
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (file.exists()) {
                return file.renameTo(file2);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void beforeCompleted() {
        renameFile(this.mOutputFolder + this.mFileName + ".tmp", this.mOutputFolder + this.mFileName);
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    @Deprecated
    public void cancel() {
    }

    public void download() {
        TaskScheduler.getInstance().submit(this);
    }

    public void downloaded(int i2, float f2) {
        this.mDownloaded += i2;
        stateChanged();
    }

    public byte[] getByteArray() {
        return this.mByteArray;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public int getFileSize() {
        return this.mFileSize;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public long getFileSizeLong() {
        return this.mFileSize;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public String getOutputPath() {
        return this.mOutputFolder + this.mFileName;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    @Deprecated
    public String getPackageName() {
        return null;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public float getProgress() {
        return Math.abs((this.mDownloaded / this.mFileSize) * 100.0f);
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public IDownloader.DownloadStatus getState() {
        return this.mState;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    @Deprecated
    public String getTargetURL() {
        return null;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public String getURL() {
        return this.mURL.toString();
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public boolean isDownloadOnlyWifi() {
        return false;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public boolean isPausedManually() {
        return false;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    @Deprecated
    public void pause() {
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void removeObservers() {
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    @Deprecated
    public void resume() {
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ByteArrayOutputStream byteArrayOutputStream;
        HttpURLConnection httpURLConnection;
        Throwable th;
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection2;
        int responseCode;
        BufferedOutputStream bufferedOutputStream;
        int read;
        BufferedOutputStream bufferedOutputStream2 = null;
        bufferedOutputStream2 = null;
        bufferedOutputStream2 = null;
        bufferedOutputStream2 = null;
        bufferedOutputStream2 = null;
        bufferedOutputStream2 = null;
        try {
            try {
                httpURLConnection2 = (HttpURLConnection) this.mURL.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setInstanceFollowRedirects(true);
                    httpURLConnection2.connect();
                    responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode == 302 || responseCode == 301) {
                        httpURLConnection2.setInstanceFollowRedirects(false);
                        httpURLConnection2 = openConnectionCheckRedirects(httpURLConnection2);
                        responseCode = httpURLConnection2.getResponseCode();
                    }
                } catch (Exception unused) {
                    bufferedInputStream = null;
                    httpURLConnection = httpURLConnection2;
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    httpURLConnection = httpURLConnection2;
                    th = th2;
                    byteArrayOutputStream = null;
                    bufferedInputStream = null;
                }
            } catch (Exception unused2) {
                return;
            }
        } catch (Exception unused3) {
            byteArrayOutputStream = null;
            bufferedInputStream = null;
            httpURLConnection = null;
        } catch (Throwable th3) {
            byteArrayOutputStream = null;
            httpURLConnection = null;
            th = th3;
            bufferedInputStream = null;
        }
        if (responseCode / 100 != 2) {
            error();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.disconnect();
                    return;
                } catch (Exception unused4) {
                    return;
                }
            }
            return;
        }
        int contentLength = httpURLConnection2.getContentLength();
        if (contentLength > 0) {
            this.mFileSize = contentLength;
        }
        File file = new File(this.mOutputFolder);
        if (!file.exists()) {
            file.mkdirs();
        }
        bufferedInputStream = new BufferedInputStream(httpURLConnection2.getInputStream());
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(getOutputPath() + ".tmp"));
        } catch (Exception unused5) {
            httpURLConnection = httpURLConnection2;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = httpURLConnection2;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[10240];
            ByteArrayOutputStream byteArrayOutputStream2 = this.saveFileAndMemory ? new ByteArrayOutputStream() : null;
            int i2 = 0;
            while (this.mState == IDownloader.DownloadStatus.DOWNLOADING && (read = bufferedInputStream.read(bArr, 0, 10240)) != -1) {
                bufferedOutputStream.write(bArr, 0, read);
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.write(bArr, 0, read);
                }
                i2 += read;
                downloaded(read, i2 / this.mFileSize);
            }
            bufferedOutputStream.flush();
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.flush();
            }
            if (this.mState == IDownloader.DownloadStatus.DOWNLOADING) {
                beforeCompleted();
                setState(IDownloader.DownloadStatus.COMPLETED);
            } else {
                IDownloader.DownloadStatus downloadStatus = IDownloader.DownloadStatus.ERROR;
            }
            try {
                bufferedOutputStream.close();
            } catch (Exception unused6) {
            }
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (Exception unused7) {
                }
            }
            try {
                bufferedInputStream.close();
            } catch (Exception unused8) {
            }
        } catch (Exception unused9) {
            HttpURLConnection httpURLConnection3 = httpURLConnection2;
            byteArrayOutputStream = null;
            bufferedOutputStream2 = bufferedOutputStream;
            httpURLConnection = httpURLConnection3;
            try {
                error();
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception unused10) {
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused11) {
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused12) {
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return;
            } catch (Throwable th5) {
                th = th5;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception unused13) {
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused14) {
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused15) {
                    }
                }
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused16) {
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            HttpURLConnection httpURLConnection4 = httpURLConnection2;
            byteArrayOutputStream = null;
            bufferedOutputStream2 = bufferedOutputStream;
            httpURLConnection = httpURLConnection4;
            if (bufferedOutputStream2 != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
            if (httpURLConnection != null) {
            }
            throw th;
        }
        if (httpURLConnection2 != null) {
            httpURLConnection2.disconnect();
        }
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void setDownloadOnlyWifi(boolean z) {
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void setPausedManually(boolean z) {
    }

    public void setState(IDownloader.DownloadStatus downloadStatus) {
        this.mState = downloadStatus;
        stateChanged();
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void start() {
        setState(IDownloader.DownloadStatus.DOWNLOADING);
        download();
    }

    public void stateChanged() {
        setChanged();
        notifyObservers();
    }
}
