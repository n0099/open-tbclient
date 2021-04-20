package com.baidu.mobads.container.components.downloader;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.AdURIUtils;
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.mobads.container.util.EncryptUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.SdcardUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.bddownload.core.Util;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
/* loaded from: classes2.dex */
public class OAdRemoteApkDownloader extends Observable implements Runnable, IDownloader {
    public static final int BLOCK_SIZE = 102400;
    public static final int BUFFER_SIZE = 102400;
    public static final int MIN_DOWNLOAD_SIZE = 5120000;
    public static final String TAG = "Downloader";
    public URL mApkUrl;
    public Context mContext;
    public volatile long mDownloaded;
    public String mFileName;
    public long mFileSize;
    public ArrayList<DownloadThread> mListDownloadThread;
    public int mNumConnections;
    public String mOutputFolder;
    public int mProgress;
    public IDownloader.DownloadStatus mState;
    public URL mURL;
    public String packageName;
    public String title;
    public Boolean mSupportResumeFromBreakPoint = Boolean.TRUE;
    public boolean mIsOnlyWifi = false;
    public OAdSqlLiteAccessObj mSqlLiteAccessObj = null;
    public boolean pausedManually = false;

    /* loaded from: classes2.dex */
    public class DownloadThread extends BaseTask {
        public static final String TAG = "DownloadThread";
        public volatile boolean isAlive;
        public long mCompleteByte;
        public long mEndByte;
        public String mOutputFile;
        public long mStartByte;
        public int mThreadID;
        public URL mURL;
        public HttpURLConnection mUrlConnection;
        public volatile boolean isCancelled = false;
        public volatile int exeVer = 0;
        public final Object mLock = new Object();
        public boolean mIsFinished = false;

        public DownloadThread(int i, URL url, String str, long j, long j2, long j3) {
            this.mThreadID = i;
            this.mURL = url;
            this.mOutputFile = str;
            this.mStartByte = j;
            this.mEndByte = j2;
            this.mCompleteByte = j3;
        }

        public void addFirstConn(HttpURLConnection httpURLConnection) {
            this.mUrlConnection = httpURLConnection;
        }

        @Override // com.baidu.mobads.container.executor.BaseTask
        public synchronized void cancel() {
            this.isCancelled = true;
            this.exeVer++;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:90:0x0233 */
        /* JADX DEBUG: Multi-variable search result rejected for r11v6, resolved type: java.io.RandomAccessFile */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x02cb, code lost:
            if (r7 == null) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:124:0x02cf, code lost:
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0229, code lost:
            if (r7 != null) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x022b, code lost:
            r7.disconnect();
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x022e, code lost:
            r17.isAlive = r6;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 11, insn: 0x02d2: MOVE  (r5 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:126:0x02d1 */
        /* JADX WARN: Removed duplicated region for block: B:109:0x025e A[Catch: all -> 0x02d0, TRY_LEAVE, TryCatch #7 {all -> 0x02d0, blocks: (B:51:0x017a, B:52:0x0182, B:54:0x018a, B:56:0x0191, B:58:0x0197, B:61:0x019c, B:62:0x01ab, B:71:0x01b8, B:72:0x01b9, B:74:0x01bf, B:107:0x024d, B:109:0x025e), top: B:152:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:140:0x033d  */
        /* JADX WARN: Removed duplicated region for block: B:143:0x0293 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:147:0x02af A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:155:0x0303 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:157:0x031f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.baidu.mobads.container.executor.BaseTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object doInBackground() {
            Throwable th;
            HttpURLConnection httpURLConnection;
            RandomAccessFile randomAccessFile;
            BufferedInputStream bufferedInputStream;
            boolean z;
            RandomAccessFile randomAccessFile2;
            boolean z2;
            int read;
            RandomAccessFile randomAccessFile3;
            int i = this.exeVer;
            RandomAccessFile randomAccessFile4 = null;
            int i2 = 0;
            try {
                try {
                    try {
                        if (this.mStartByte + this.mCompleteByte >= this.mEndByte) {
                            this.mIsFinished = true;
                            httpURLConnection = null;
                            bufferedInputStream = null;
                            randomAccessFile3 = null;
                        } else {
                            if (this.mUrlConnection == null) {
                                httpURLConnection = (HttpURLConnection) this.mURL.openConnection();
                                try {
                                    if (OAdRemoteApkDownloader.this.mSupportResumeFromBreakPoint.booleanValue()) {
                                        httpURLConnection.setRequestProperty("Range", "bytes=" + ((this.mStartByte + this.mCompleteByte) + "-" + this.mEndByte));
                                    } else {
                                        this.mCompleteByte = 0L;
                                    }
                                    httpURLConnection.connect();
                                    int responseCode = httpURLConnection.getResponseCode();
                                    if (i != this.exeVer) {
                                        RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i + ") executed end; isFinished=" + this.mIsFinished);
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        this.isAlive = false;
                                        return null;
                                    } else if (responseCode / 100 != 2) {
                                        OAdRemoteApkDownloader.this.innerError();
                                        RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i + ") executed end; isFinished=" + this.mIsFinished);
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        this.isAlive = false;
                                        return null;
                                    } else if (httpURLConnection.getContentType().equals(SapiWebView.K)) {
                                        OAdRemoteApkDownloader.this.innerError();
                                        RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i + ") executed end; isFinished=" + this.mIsFinished);
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        this.isAlive = false;
                                        return null;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    bufferedInputStream = null;
                                    randomAccessFile2 = bufferedInputStream;
                                    RemoteXAdLogger.getInstance().d(TAG, e.getMessage());
                                    if (i == this.exeVer) {
                                    }
                                    RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i + ") executed end; isFinished=" + this.mIsFinished);
                                    if (randomAccessFile2 != null) {
                                    }
                                    if (bufferedInputStream != null) {
                                    }
                                    z2 = false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedInputStream = null;
                                    RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i + ") executed end; isFinished=" + this.mIsFinished);
                                    if (randomAccessFile4 != null) {
                                    }
                                    if (bufferedInputStream != null) {
                                    }
                                    z = false;
                                    if (httpURLConnection != null) {
                                    }
                                    this.isAlive = z;
                                    throw th;
                                }
                            } else {
                                httpURLConnection = this.mUrlConnection;
                                try {
                                    this.mUrlConnection = null;
                                } catch (Exception e3) {
                                    e = e3;
                                    bufferedInputStream = null;
                                    randomAccessFile2 = null;
                                    RemoteXAdLogger.getInstance().d(TAG, e.getMessage());
                                    if (i == this.exeVer) {
                                    }
                                    RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i + ") executed end; isFinished=" + this.mIsFinished);
                                    if (randomAccessFile2 != null) {
                                    }
                                    if (bufferedInputStream != null) {
                                    }
                                    z2 = false;
                                } catch (Throwable th3) {
                                    th = th3;
                                    randomAccessFile4 = null;
                                    bufferedInputStream = null;
                                    RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i + ") executed end; isFinished=" + this.mIsFinished);
                                    if (randomAccessFile4 != null) {
                                        try {
                                            randomAccessFile4.close();
                                        } catch (Exception e4) {
                                            RemoteXAdLogger.getInstance().w(TAG, e4.getMessage());
                                        }
                                    }
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (Exception e5) {
                                            z = false;
                                            RemoteXAdLogger.getInstance().w(TAG, e5.getMessage());
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            this.isAlive = z;
                                            throw th;
                                        }
                                    }
                                    z = false;
                                    if (httpURLConnection != null) {
                                    }
                                    this.isAlive = z;
                                    throw th;
                                }
                            }
                            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                            try {
                                long j = this.mStartByte + this.mCompleteByte;
                                RemoteXAdLogger.getInstance().d(TAG, "tmpStartByte = " + j);
                                randomAccessFile2 = new RandomAccessFile(this.mOutputFile, "rw");
                                try {
                                    randomAccessFile2.seek(j);
                                    byte[] bArr = new byte[102400];
                                    while (true) {
                                        if (OAdRemoteApkDownloader.this.mState != IDownloader.DownloadStatus.DOWNLOADING || (read = bufferedInputStream.read(bArr, i2, 102400)) == -1 || j >= this.mEndByte || i != this.exeVer) {
                                            break;
                                        }
                                        randomAccessFile2.write(bArr, i2, read);
                                        long j2 = read;
                                        this.mCompleteByte += j2;
                                        j += j2;
                                        OAdRemoteApkDownloader.this.updateDownloadedSize(read);
                                        synchronized (this) {
                                            if (this.isCancelled) {
                                                break;
                                            }
                                        }
                                        i2 = 0;
                                    }
                                    randomAccessFile3 = randomAccessFile2;
                                    if (j >= this.mEndByte) {
                                        this.mIsFinished = true;
                                        randomAccessFile3 = randomAccessFile2;
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    RemoteXAdLogger.getInstance().d(TAG, e.getMessage());
                                    if (i == this.exeVer) {
                                        OAdRemoteApkDownloader.this.innerError();
                                    }
                                    RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i + ") executed end; isFinished=" + this.mIsFinished);
                                    if (randomAccessFile2 != null) {
                                        try {
                                            randomAccessFile2.close();
                                        } catch (Exception e7) {
                                            RemoteXAdLogger.getInstance().w(TAG, e7.getMessage());
                                        }
                                    }
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (Exception e8) {
                                            z2 = false;
                                            RemoteXAdLogger.getInstance().w(TAG, e8.getMessage());
                                        }
                                    }
                                    z2 = false;
                                }
                            } catch (Exception e9) {
                                e = e9;
                                randomAccessFile2 = null;
                                RemoteXAdLogger.getInstance().d(TAG, e.getMessage());
                                if (i == this.exeVer) {
                                }
                                RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i + ") executed end; isFinished=" + this.mIsFinished);
                                if (randomAccessFile2 != null) {
                                }
                                if (bufferedInputStream != null) {
                                }
                                z2 = false;
                            } catch (Throwable th4) {
                                th = th4;
                                randomAccessFile4 = null;
                                RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i + ") executed end; isFinished=" + this.mIsFinished);
                                if (randomAccessFile4 != null) {
                                }
                                if (bufferedInputStream != null) {
                                }
                                z = false;
                                if (httpURLConnection != null) {
                                }
                                this.isAlive = z;
                                throw th;
                            }
                        }
                        RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i + ") executed end; isFinished=" + this.mIsFinished);
                        if (randomAccessFile3 != null) {
                            try {
                                randomAccessFile3.close();
                            } catch (Exception e10) {
                                RemoteXAdLogger.getInstance().w(TAG, e10.getMessage());
                            }
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e11) {
                                z2 = false;
                                RemoteXAdLogger.getInstance().w(TAG, e11.getMessage());
                            }
                        }
                        z2 = false;
                    } catch (Exception e12) {
                        e = e12;
                        httpURLConnection = null;
                        bufferedInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        httpURLConnection = null;
                        bufferedInputStream = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    randomAccessFile4 = randomAccessFile;
                }
            } catch (Exception e13) {
                e = e13;
                httpURLConnection = null;
            } catch (Throwable th7) {
                th = th7;
                randomAccessFile4 = null;
                httpURLConnection = null;
            }
        }

        public boolean isFinished() {
            return this.mIsFinished;
        }

        public synchronized void start() {
            this.isCancelled = false;
            this.isAlive = true;
            TaskScheduler.getInstance().submit(this, 3);
        }

        public void waitFinish() throws InterruptedException {
            synchronized (this.mLock) {
                while (this.isAlive && !isComplete()) {
                    this.mLock.wait(10L);
                }
            }
        }
    }

    public OAdRemoteApkDownloader(Context context, URL url, String str, String str2, int i, String str3) {
        this.mContext = context;
        this.mURL = url;
        this.mOutputFolder = str;
        this.mNumConnections = i;
        if (str2 != null && str2.trim().length() > 0) {
            this.mFileName = str2;
        } else {
            String file = url.getFile();
            this.mFileName = file.substring(file.lastIndexOf(47) + 1);
        }
        this.mFileSize = -1L;
        this.mState = IDownloader.DownloadStatus.NONE;
        this.mDownloaded = 0L;
        this.mProgress = 0;
        this.packageName = str3;
        this.mListDownloadThread = new ArrayList<>();
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

    public void beforeCompleted(ArrayList<DownloadThread> arrayList) {
        CommonUtils.renameFile(this.mOutputFolder + this.mFileName + ".tmp", this.mOutputFolder + this.mFileName);
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void cancel() {
        try {
            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
            remoteXAdLogger.d(TAG, "execute Cancel; state = " + this.mState);
            if (this.mState == IDownloader.DownloadStatus.PAUSED || this.mState == IDownloader.DownloadStatus.DOWNLOADING) {
                if (this.mListDownloadThread != null) {
                    for (int i = 0; i < this.mListDownloadThread.size(); i++) {
                        if (!this.mListDownloadThread.get(i).isFinished()) {
                            this.mListDownloadThread.get(i).cancel();
                        }
                    }
                }
                setState(IDownloader.DownloadStatus.CANCELLED);
            }
        } catch (Exception unused) {
            RemoteXAdLogger.getInstance().d(TAG, "cancel exception");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doDownload(HttpURLConnection httpURLConnection) throws InterruptedException {
        String str;
        String str2;
        String str3;
        int i;
        int i2;
        IDownloader.DownloadStatus downloadStatus;
        int i3;
        String str4;
        Iterator it;
        String url = this.mApkUrl.toString();
        String str5 = (this.mOutputFolder + this.mFileName) + ".tmp";
        int size = this.mListDownloadThread.size();
        String str6 = ";complete=";
        long j = 0;
        boolean z = false;
        String str7 = TAG;
        if (size == 0) {
            File file = new File(this.mOutputFolder);
            if (!file.exists()) {
                file.mkdirs();
            }
            ArrayList arrayList = null;
            File file2 = new File(str5);
            if (this.mSupportResumeFromBreakPoint.booleanValue() && file2.exists() && file2.length() == this.mFileSize) {
                try {
                    OAdSqlLiteAccessObj oAdSqlLiteAccessObj = new OAdSqlLiteAccessObj(this.mContext);
                    this.mSqlLiteAccessObj = oAdSqlLiteAccessObj;
                    List<OAdSqlLiteDownloadingInfo> query = oAdSqlLiteAccessObj.query(url, str5);
                    if (query != null && query.size() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        try {
                            HashSet hashSet = new HashSet();
                            for (OAdSqlLiteDownloadingInfo oAdSqlLiteDownloadingInfo : query) {
                                if (!hashSet.contains(Integer.valueOf(oAdSqlLiteDownloadingInfo.getThreadId()))) {
                                    hashSet.add(Integer.valueOf(oAdSqlLiteDownloadingInfo.getThreadId()));
                                    arrayList2.add(oAdSqlLiteDownloadingInfo);
                                    RemoteXAdLogger.getInstance().d(TAG, "resume from db: start=" + oAdSqlLiteDownloadingInfo.getStartPos() + ";end =" + oAdSqlLiteDownloadingInfo.getEndPos() + ";complete=" + oAdSqlLiteDownloadingInfo.getDownloadedContentLength());
                                }
                            }
                            arrayList = arrayList2;
                        } catch (Exception e2) {
                            e = e2;
                            arrayList = arrayList2;
                            RemoteXAdLogger.getInstance().d(TAG, e);
                            if (arrayList != null) {
                            }
                            if (file2.exists()) {
                            }
                            try {
                                file2.createNewFile();
                                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rwd");
                                randomAccessFile.setLength(this.mFileSize);
                                randomAccessFile.close();
                                RemoteXAdLogger.getInstance().d("Downloader.init():  建立完random文件 ts:" + System.currentTimeMillis());
                                ArrayList arrayList3 = new ArrayList();
                                long j2 = -1;
                                long j3 = this.mFileSize;
                                long j4 = j3 - 1;
                                i3 = this.mNumConnections;
                                if (i3 <= 1) {
                                }
                                arrayList = arrayList3;
                                it = arrayList.iterator();
                                while (it.hasNext()) {
                                }
                                str = str4;
                                if (this.mSupportResumeFromBreakPoint.booleanValue()) {
                                }
                                this.mDownloaded = j;
                                this.mProgress = (int) getProgress();
                                setState(IDownloader.DownloadStatus.DOWNLOADING);
                                RemoteXAdLogger.getInstance().d(str3, "Downloader starts unfinished threads and waits threads end");
                                while (i < this.mListDownloadThread.size()) {
                                }
                                while (i2 < this.mListDownloadThread.size()) {
                                }
                                downloadStatus = this.mState;
                                if (downloadStatus != IDownloader.DownloadStatus.DOWNLOADING) {
                                }
                                if (this.mState == IDownloader.DownloadStatus.COMPLETED) {
                                }
                            } catch (Exception unused) {
                                RemoteXAdLogger.getInstance().d(TAG, " 建立文件失败:");
                                setState(IDownloader.DownloadStatus.ERROR);
                                return;
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            if (arrayList != null || arrayList.size() < 1) {
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rwd");
                randomAccessFile2.setLength(this.mFileSize);
                randomAccessFile2.close();
                RemoteXAdLogger.getInstance().d("Downloader.init():  建立完random文件 ts:" + System.currentTimeMillis());
                ArrayList arrayList32 = new ArrayList();
                long j22 = -1;
                long j32 = this.mFileSize;
                long j42 = j32 - 1;
                i3 = this.mNumConnections;
                if (i3 <= 1) {
                    long round = Math.round((((float) j32) / i3) / 102400.0f) * 102400;
                    int i4 = 0;
                    while (j22 < j42) {
                        long j5 = j22 + 1;
                        long j6 = j22 + round;
                        long j7 = j6 < j42 ? j6 : j42;
                        int i5 = i4 + 1;
                        arrayList32.add(new OAdSqlLiteDownloadingInfo(i5, url, str5, j5, j7, 0L));
                        str7 = str7;
                        j22 = j7;
                        i4 = i5;
                        round = round;
                        str6 = str6;
                    }
                    str2 = str6;
                    str3 = str7;
                    str4 = ";end =";
                } else {
                    str2 = ";complete=";
                    str3 = TAG;
                    str4 = ";end =";
                    arrayList32.add(new OAdSqlLiteDownloadingInfo(1, url, str5, 0L, j42, 0L));
                }
                arrayList = arrayList32;
            } else {
                str4 = ";end =";
                str2 = ";complete=";
                str3 = TAG;
            }
            it = arrayList.iterator();
            while (it.hasNext()) {
                OAdSqlLiteDownloadingInfo oAdSqlLiteDownloadingInfo2 = (OAdSqlLiteDownloadingInfo) it.next();
                Iterator it2 = it;
                String str8 = str4;
                DownloadThread downloadThread = new DownloadThread(oAdSqlLiteDownloadingInfo2.getThreadId(), this.mApkUrl, oAdSqlLiteDownloadingInfo2.getDownloadedFilePath(), oAdSqlLiteDownloadingInfo2.getStartPos(), oAdSqlLiteDownloadingInfo2.getEndPos(), oAdSqlLiteDownloadingInfo2.getDownloadedContentLength());
                if (oAdSqlLiteDownloadingInfo2.getStartPos() == 0 && oAdSqlLiteDownloadingInfo2.getDownloadedContentLength() == 0) {
                    downloadThread.addFirstConn(httpURLConnection);
                }
                this.mListDownloadThread.add(downloadThread);
                it = it2;
                str4 = str8;
            }
            str = str4;
        } else {
            str = ";end =";
            str2 = ";complete=";
            str3 = TAG;
        }
        if (this.mSupportResumeFromBreakPoint.booleanValue()) {
            for (int i6 = 0; i6 < this.mListDownloadThread.size(); i6++) {
                j += this.mListDownloadThread.get(i6).mCompleteByte;
            }
        }
        this.mDownloaded = j;
        this.mProgress = (int) getProgress();
        setState(IDownloader.DownloadStatus.DOWNLOADING);
        RemoteXAdLogger.getInstance().d(str3, "Downloader starts unfinished threads and waits threads end");
        for (i = 0; i < this.mListDownloadThread.size(); i++) {
            if (!this.mListDownloadThread.get(i).isFinished()) {
                this.mListDownloadThread.get(i).start();
            }
        }
        for (i2 = 0; i2 < this.mListDownloadThread.size(); i2++) {
            if (!this.mListDownloadThread.get(i2).isFinished()) {
                this.mListDownloadThread.get(i2).waitFinish();
            }
        }
        downloadStatus = this.mState;
        if (downloadStatus != IDownloader.DownloadStatus.DOWNLOADING) {
            int i7 = 0;
            while (true) {
                if (i7 >= this.mListDownloadThread.size()) {
                    break;
                } else if (!this.mListDownloadThread.get(i7).isFinished()) {
                    z = true;
                    break;
                } else {
                    i7++;
                }
            }
            if (z) {
                setState(IDownloader.DownloadStatus.ERROR);
            } else {
                beforeCompleted(this.mListDownloadThread);
                setState(IDownloader.DownloadStatus.COMPLETED);
            }
        } else {
            IDownloader.DownloadStatus downloadStatus2 = IDownloader.DownloadStatus.ERROR;
            if (downloadStatus == downloadStatus2) {
                setState(downloadStatus2);
            } else if (downloadStatus == IDownloader.DownloadStatus.CANCELLED) {
                RemoteXAdLogger.getInstance().d(str3, "Downloader is cancelled");
            } else if (downloadStatus == IDownloader.DownloadStatus.PAUSED) {
                RemoteXAdLogger.getInstance().d(str3, "Downloader is paused");
            }
        }
        if (this.mState == IDownloader.DownloadStatus.COMPLETED) {
            RemoteXAdLogger.getInstance().d(str3, "save database now");
            if (this.mSupportResumeFromBreakPoint.booleanValue()) {
                try {
                    if (this.mSqlLiteAccessObj == null) {
                        this.mSqlLiteAccessObj = new OAdSqlLiteAccessObj(this.mContext);
                    }
                    ArrayList arrayList4 = new ArrayList();
                    Iterator<DownloadThread> it3 = this.mListDownloadThread.iterator();
                    while (it3.hasNext()) {
                        DownloadThread next = it3.next();
                        arrayList4.add(new OAdSqlLiteDownloadingInfo(next.mThreadID, url, str5, next.mStartByte, next.mEndByte, next.mCompleteByte));
                        RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
                        StringBuilder sb = new StringBuilder();
                        sb.append("save to db: start=");
                        sb.append(next.mStartByte);
                        String str9 = str;
                        sb.append(str9);
                        sb.append(next.mEndByte);
                        String str10 = str2;
                        sb.append(str10);
                        sb.append(next.mCompleteByte);
                        remoteXAdLogger.d(str3, sb.toString());
                        it3 = it3;
                        str = str9;
                        str2 = str10;
                        url = url;
                    }
                    if (this.mSqlLiteAccessObj.isHasInfors(url, str5)) {
                        this.mSqlLiteAccessObj.updataInfos(arrayList4);
                    } else {
                        this.mSqlLiteAccessObj.saveInfos(arrayList4);
                    }
                } catch (Exception e4) {
                    RemoteXAdLogger.getInstance().d(str3, e4);
                }
            }
        }
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public int getFileSize() {
        long j = this.mFileSize;
        if (j > 2147483647L) {
            return -1;
        }
        return (int) j;
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
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public float getProgress() {
        return Math.abs((((float) this.mDownloaded) / ((float) this.mFileSize)) * 100.0f);
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public IDownloader.DownloadStatus getState() {
        return this.mState;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public String getTargetURL() {
        URL url = this.mApkUrl;
        if (url == null) {
            return null;
        }
        return url.toString();
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public String getURL() {
        return this.mURL.toString();
    }

    public synchronized void innerError() {
        this.mState = IDownloader.DownloadStatus.ERROR;
        for (int i = 0; i < this.mListDownloadThread.size(); i++) {
            if (!this.mListDownloadThread.get(i).isFinished()) {
                this.mListDownloadThread.get(i).cancel();
            }
        }
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public boolean isDownloadOnlyWifi() {
        return this.mIsOnlyWifi;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public boolean isPausedManually() {
        return this.pausedManually;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void pause() {
        try {
            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
            remoteXAdLogger.d(TAG, "execute Pause; state = " + this.mState);
            if (this.mState == IDownloader.DownloadStatus.DOWNLOADING || this.mState == IDownloader.DownloadStatus.ERROR || this.mState == IDownloader.DownloadStatus.NONE) {
                if (this.mListDownloadThread != null) {
                    for (int i = 0; i < this.mListDownloadThread.size(); i++) {
                        if (!this.mListDownloadThread.get(i).isFinished()) {
                            this.mListDownloadThread.get(i).cancel();
                        }
                    }
                }
                setState(IDownloader.DownloadStatus.PAUSED);
            }
        } catch (Exception unused) {
            RemoteXAdLogger.getInstance().d(TAG, "pause exception");
        }
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void removeObservers() {
        deleteObservers();
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void resume() {
        try {
            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
            remoteXAdLogger.d(TAG, "execute Resume; state = " + this.mState);
            if (this.mState == IDownloader.DownloadStatus.PAUSED || this.mState == IDownloader.DownloadStatus.ERROR || this.mState == IDownloader.DownloadStatus.CANCELLED) {
                setState(IDownloader.DownloadStatus.INITING);
                setPausedManually(true);
                TaskScheduler.getInstance().submit(this);
            }
        } catch (Exception unused) {
            RemoteXAdLogger.getInstance().d(TAG, "resume exception");
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Override // java.lang.Runnable
    public void run() {
        int responseCode;
        long contentLength;
        HttpURLConnection httpURLConnection = null;
        if (this.mApkUrl != null && this.mFileSize >= 1) {
            try {
                doDownload(null);
                return;
            } catch (Exception e2) {
                setState(IDownloader.DownloadStatus.ERROR);
                RemoteXAdLogger.getInstance().d(TAG, e2);
                return;
            }
        }
        try {
            try {
                httpURLConnection = AdURIUtils.getHttpURLConnection(this.mURL);
                httpURLConnection.setRequestProperty("Range", "bytes=0-");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection = openConnectionCheckRedirects(httpURLConnection);
                    responseCode = httpURLConnection.getResponseCode();
                }
            } catch (Exception unused) {
                setState(IDownloader.DownloadStatus.ERROR);
                if (0 == 0) {
                    return;
                }
            }
            if (responseCode / 100 != 2) {
                setState(IDownloader.DownloadStatus.ERROR);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } else if (httpURLConnection.getContentType().equals(SapiWebView.K)) {
                setState(IDownloader.DownloadStatus.ERROR);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } else {
                if (Build.VERSION.SDK_INT >= 24) {
                    contentLength = httpURLConnection.getContentLengthLong();
                } else {
                    contentLength = httpURLConnection.getContentLength();
                }
                if (contentLength < 1) {
                    setState(IDownloader.DownloadStatus.ERROR);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                }
                if (contentLength < 5120000) {
                    this.mNumConnections = 1;
                }
                this.mApkUrl = httpURLConnection.getURL();
                if (!"mounted".equals(Environment.getExternalStorageState())) {
                    setState(IDownloader.DownloadStatus.ERROR);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                }
                String storagePathForDlApk = SdcardUtils.getStoragePathForDlApk(this.mContext);
                String str = EncryptUtils.getMD5(this.mApkUrl.toString()) + ".apk";
                this.mOutputFolder = storagePathForDlApk;
                this.mFileName = str;
                if (new File(storagePathForDlApk + str).exists()) {
                    setState(IDownloader.DownloadStatus.COMPLETED);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                }
                if (httpURLConnection.getHeaderField("Content-Range") == null && (httpURLConnection.getHeaderField(Util.ACCEPT_RANGES) == null || httpURLConnection.getHeaderField(Util.ACCEPT_RANGES).equalsIgnoreCase("none"))) {
                    this.mSupportResumeFromBreakPoint = Boolean.FALSE;
                    this.mNumConnections = 1;
                }
                if (this.mFileSize == -1) {
                    this.mFileSize = contentLength;
                }
                doDownload(httpURLConnection);
                if (httpURLConnection == null) {
                    return;
                }
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void setDownloadOnlyWifi(boolean z) {
        this.mIsOnlyWifi = z;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void setPausedManually(boolean z) {
        this.pausedManually = z;
    }

    public void setState(IDownloader.DownloadStatus downloadStatus) {
        this.mState = downloadStatus;
        stateChanged();
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void start() {
        RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
        remoteXAdLogger.d(TAG, "execute Start; state = " + this.mState);
        if (this.mState == IDownloader.DownloadStatus.NONE) {
            setState(IDownloader.DownloadStatus.INITING);
            setPausedManually(true);
            TaskScheduler.getInstance().submit(this);
        }
    }

    public void stateChanged() {
        setChanged();
        notifyObservers();
    }

    public synchronized void updateDownloadedSize(int i) {
        this.mDownloaded += i;
        int progress = (int) getProgress();
        if (this.mProgress < progress) {
            this.mProgress = progress;
            stateChanged();
        }
    }
}
