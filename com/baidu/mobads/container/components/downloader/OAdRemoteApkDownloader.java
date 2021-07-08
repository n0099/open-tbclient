package com.baidu.mobads.container.components.downloader;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BLOCK_SIZE = 102400;
    public static final int BUFFER_SIZE = 102400;
    public static final int MIN_DOWNLOAD_SIZE = 5120000;
    public static final String TAG = "Downloader";
    public transient /* synthetic */ FieldHolder $fh;
    public URL mApkUrl;
    public Context mContext;
    public volatile long mDownloaded;
    public String mFileName;
    public long mFileSize;
    public boolean mIsOnlyWifi;
    public ArrayList<DownloadThread> mListDownloadThread;
    public int mNumConnections;
    public String mOutputFolder;
    public int mProgress;
    public OAdSqlLiteAccessObj mSqlLiteAccessObj;
    public IDownloader.DownloadStatus mState;
    public Boolean mSupportResumeFromBreakPoint;
    public URL mURL;
    public String packageName;
    public boolean pausedManually;
    public String title;

    /* loaded from: classes2.dex */
    public class DownloadThread extends BaseTask {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TAG = "DownloadThread";
        public transient /* synthetic */ FieldHolder $fh;
        public volatile int exeVer;
        public volatile boolean isAlive;
        public volatile boolean isCancelled;
        public long mCompleteByte;
        public long mEndByte;
        public boolean mIsFinished;
        public final Object mLock;
        public String mOutputFile;
        public long mStartByte;
        public int mThreadID;
        public URL mURL;
        public HttpURLConnection mUrlConnection;
        public final /* synthetic */ OAdRemoteApkDownloader this$0;

        public DownloadThread(OAdRemoteApkDownloader oAdRemoteApkDownloader, int i2, URL url, String str, long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oAdRemoteApkDownloader, Integer.valueOf(i2), url, str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = oAdRemoteApkDownloader;
            this.isCancelled = false;
            this.exeVer = 0;
            this.mLock = new Object();
            this.mThreadID = i2;
            this.mURL = url;
            this.mOutputFile = str;
            this.mStartByte = j;
            this.mEndByte = j2;
            this.mCompleteByte = j3;
            this.mIsFinished = false;
        }

        public void addFirstConn(HttpURLConnection httpURLConnection) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) {
                this.mUrlConnection = httpURLConnection;
            }
        }

        @Override // com.baidu.mobads.container.executor.BaseTask
        public synchronized void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this) {
                    this.isCancelled = true;
                    this.exeVer++;
                }
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:92:0x0238 */
        /* JADX DEBUG: Multi-variable search result rejected for r11v6, resolved type: java.io.RandomAccessFile */
        /* JADX WARN: Code restructure failed: missing block: B:124:0x02d0, code lost:
            if (r7 == null) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:126:0x02d4, code lost:
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x022e, code lost:
            if (r7 != null) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0230, code lost:
            r7.disconnect();
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0233, code lost:
            r17.isAlive = r6;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 11, insn: 0x02d7: MOVE  (r5 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:128:0x02d6 */
        /* JADX WARN: Removed duplicated region for block: B:111:0x0263 A[Catch: all -> 0x02d5, TRY_LEAVE, TryCatch #9 {all -> 0x02d5, blocks: (B:53:0x017f, B:54:0x0187, B:56:0x018f, B:58:0x0196, B:60:0x019c, B:63:0x01a1, B:64:0x01b0, B:73:0x01bd, B:74:0x01be, B:76:0x01c4, B:109:0x0252, B:111:0x0263), top: B:158:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:142:0x0342  */
        /* JADX WARN: Removed duplicated region for block: B:149:0x0308 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:151:0x02b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:156:0x0298 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:161:0x0324 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.baidu.mobads.container.executor.BaseTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object doInBackground() {
            InterceptResult invokeV;
            Throwable th;
            HttpURLConnection httpURLConnection;
            RandomAccessFile randomAccessFile;
            BufferedInputStream bufferedInputStream;
            boolean z;
            RandomAccessFile randomAccessFile2;
            boolean z2;
            int read;
            RandomAccessFile randomAccessFile3;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
                return invokeV.objValue;
            }
            int i2 = this.exeVer;
            RandomAccessFile randomAccessFile4 = null;
            int i3 = 0;
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
                                    if (this.this$0.mSupportResumeFromBreakPoint.booleanValue()) {
                                        httpURLConnection.setRequestProperty("Range", "bytes=" + ((this.mStartByte + this.mCompleteByte) + "-" + this.mEndByte));
                                    } else {
                                        this.mCompleteByte = 0L;
                                    }
                                    httpURLConnection.connect();
                                    int responseCode = httpURLConnection.getResponseCode();
                                    if (i2 != this.exeVer) {
                                        RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i2 + ") executed end; isFinished=" + this.mIsFinished);
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        this.isAlive = false;
                                        return null;
                                    } else if (responseCode / 100 != 2) {
                                        this.this$0.innerError();
                                        RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i2 + ") executed end; isFinished=" + this.mIsFinished);
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        this.isAlive = false;
                                        return null;
                                    } else if (httpURLConnection.getContentType().equals(SapiWebView.DATA_MIME_TYPE)) {
                                        this.this$0.innerError();
                                        RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i2 + ") executed end; isFinished=" + this.mIsFinished);
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
                                    if (i2 == this.exeVer) {
                                    }
                                    RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i2 + ") executed end; isFinished=" + this.mIsFinished);
                                    if (randomAccessFile2 != null) {
                                    }
                                    if (bufferedInputStream != null) {
                                    }
                                    z2 = false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedInputStream = null;
                                    RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i2 + ") executed end; isFinished=" + this.mIsFinished);
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
                                    if (i2 == this.exeVer) {
                                    }
                                    RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i2 + ") executed end; isFinished=" + this.mIsFinished);
                                    if (randomAccessFile2 != null) {
                                    }
                                    if (bufferedInputStream != null) {
                                    }
                                    z2 = false;
                                } catch (Throwable th3) {
                                    th = th3;
                                    randomAccessFile4 = null;
                                    bufferedInputStream = null;
                                    RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i2 + ") executed end; isFinished=" + this.mIsFinished);
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
                                        if (this.this$0.mState != IDownloader.DownloadStatus.DOWNLOADING || (read = bufferedInputStream.read(bArr, i3, 102400)) == -1 || j >= this.mEndByte || i2 != this.exeVer) {
                                            break;
                                        }
                                        randomAccessFile2.write(bArr, i3, read);
                                        long j2 = read;
                                        this.mCompleteByte += j2;
                                        j += j2;
                                        this.this$0.updateDownloadedSize(read);
                                        synchronized (this) {
                                            if (this.isCancelled) {
                                                break;
                                            }
                                        }
                                        i3 = 0;
                                    }
                                    randomAccessFile3 = randomAccessFile2;
                                    if (j >= this.mEndByte) {
                                        this.mIsFinished = true;
                                        randomAccessFile3 = randomAccessFile2;
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    RemoteXAdLogger.getInstance().d(TAG, e.getMessage());
                                    if (i2 == this.exeVer) {
                                        this.this$0.innerError();
                                    }
                                    RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i2 + ") executed end; isFinished=" + this.mIsFinished);
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
                                if (i2 == this.exeVer) {
                                }
                                RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i2 + ") executed end; isFinished=" + this.mIsFinished);
                                if (randomAccessFile2 != null) {
                                }
                                if (bufferedInputStream != null) {
                                }
                                z2 = false;
                            } catch (Throwable th4) {
                                th = th4;
                                randomAccessFile4 = null;
                                RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i2 + ") executed end; isFinished=" + this.mIsFinished);
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
                        RemoteXAdLogger.getInstance().d(TAG, "Thread[" + this.mThreadID + "] ver(" + i2 + ") executed end; isFinished=" + this.mIsFinished);
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
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIsFinished : invokeV.booleanValue;
        }

        public synchronized void start() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                synchronized (this) {
                    this.isCancelled = false;
                    this.isAlive = true;
                    TaskScheduler.getInstance().submit(this, 3);
                }
            }
        }

        public void waitFinish() throws InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                synchronized (this.mLock) {
                    while (this.isAlive && !isComplete()) {
                        this.mLock.wait(10L);
                    }
                }
            }
        }
    }

    public OAdRemoteApkDownloader(Context context, URL url, String str, String str2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, url, str, str2, Integer.valueOf(i2), str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSupportResumeFromBreakPoint = Boolean.TRUE;
        this.mIsOnlyWifi = false;
        this.mSqlLiteAccessObj = null;
        this.pausedManually = false;
        this.mContext = context;
        this.mURL = url;
        this.mOutputFolder = str;
        this.mNumConnections = i2;
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, this, httpURLConnection)) != null) {
            return (HttpURLConnection) invokeL.objValue;
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) {
            CommonUtils.renameFile(this.mOutputFolder + this.mFileName + ".tmp", this.mOutputFolder + this.mFileName);
        }
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
                remoteXAdLogger.d(TAG, "execute Cancel; state = " + this.mState);
                if (this.mState == IDownloader.DownloadStatus.PAUSED || this.mState == IDownloader.DownloadStatus.DOWNLOADING) {
                    if (this.mListDownloadThread != null) {
                        for (int i2 = 0; i2 < this.mListDownloadThread.size(); i2++) {
                            if (!this.mListDownloadThread.get(i2).isFinished()) {
                                this.mListDownloadThread.get(i2).cancel();
                            }
                        }
                    }
                    setState(IDownloader.DownloadStatus.CANCELLED);
                }
            } catch (Exception unused) {
                RemoteXAdLogger.getInstance().d(TAG, "cancel exception");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doDownload(HttpURLConnection httpURLConnection) throws InterruptedException {
        String str;
        String str2;
        String str3;
        int i2;
        int i3;
        IDownloader.DownloadStatus downloadStatus;
        int i4;
        String str4;
        Iterator it;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, httpURLConnection) == null) {
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
                                    i4 = this.mNumConnections;
                                    if (i4 <= 1) {
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
                                    while (i2 < this.mListDownloadThread.size()) {
                                    }
                                    while (i3 < this.mListDownloadThread.size()) {
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
                    i4 = this.mNumConnections;
                    if (i4 <= 1) {
                        long round = Math.round((((float) j32) / i4) / 102400.0f) * 102400;
                        int i5 = 0;
                        while (j22 < j42) {
                            long j5 = j22 + 1;
                            long j6 = j22 + round;
                            long j7 = j6 < j42 ? j6 : j42;
                            int i6 = i5 + 1;
                            arrayList32.add(new OAdSqlLiteDownloadingInfo(i6, url, str5, j5, j7, 0L));
                            str7 = str7;
                            j22 = j7;
                            i5 = i6;
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
                    DownloadThread downloadThread = new DownloadThread(this, oAdSqlLiteDownloadingInfo2.getThreadId(), this.mApkUrl, oAdSqlLiteDownloadingInfo2.getDownloadedFilePath(), oAdSqlLiteDownloadingInfo2.getStartPos(), oAdSqlLiteDownloadingInfo2.getEndPos(), oAdSqlLiteDownloadingInfo2.getDownloadedContentLength());
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
                for (int i7 = 0; i7 < this.mListDownloadThread.size(); i7++) {
                    j += this.mListDownloadThread.get(i7).mCompleteByte;
                }
            }
            this.mDownloaded = j;
            this.mProgress = (int) getProgress();
            setState(IDownloader.DownloadStatus.DOWNLOADING);
            RemoteXAdLogger.getInstance().d(str3, "Downloader starts unfinished threads and waits threads end");
            for (i2 = 0; i2 < this.mListDownloadThread.size(); i2++) {
                if (!this.mListDownloadThread.get(i2).isFinished()) {
                    this.mListDownloadThread.get(i2).start();
                }
            }
            for (i3 = 0; i3 < this.mListDownloadThread.size(); i3++) {
                if (!this.mListDownloadThread.get(i3).isFinished()) {
                    this.mListDownloadThread.get(i3).waitFinish();
                }
            }
            downloadStatus = this.mState;
            if (downloadStatus != IDownloader.DownloadStatus.DOWNLOADING) {
                int i8 = 0;
                while (true) {
                    if (i8 >= this.mListDownloadThread.size()) {
                        break;
                    } else if (!this.mListDownloadThread.get(i8).isFinished()) {
                        z = true;
                        break;
                    } else {
                        i8++;
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
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public int getFileSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long j = this.mFileSize;
            if (j > 2147483647L) {
                return -1;
            }
            return (int) j;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public long getFileSizeLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mFileSize : invokeV.longValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public String getOutputPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mOutputFolder + this.mFileName;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.packageName : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Math.abs((((float) this.mDownloaded) / ((float) this.mFileSize)) * 100.0f) : invokeV.floatValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public IDownloader.DownloadStatus getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mState : (IDownloader.DownloadStatus) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public String getTargetURL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            URL url = this.mApkUrl;
            if (url == null) {
                return null;
            }
            return url.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public String getURL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mURL.toString() : (String) invokeV.objValue;
    }

    public synchronized void innerError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                this.mState = IDownloader.DownloadStatus.ERROR;
                for (int i2 = 0; i2 < this.mListDownloadThread.size(); i2++) {
                    if (!this.mListDownloadThread.get(i2).isFinished()) {
                        this.mListDownloadThread.get(i2).cancel();
                    }
                }
            }
        }
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public boolean isDownloadOnlyWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mIsOnlyWifi : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public boolean isPausedManually() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.pausedManually : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            try {
                RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
                remoteXAdLogger.d(TAG, "execute Pause; state = " + this.mState);
                if (this.mState == IDownloader.DownloadStatus.DOWNLOADING || this.mState == IDownloader.DownloadStatus.ERROR || this.mState == IDownloader.DownloadStatus.NONE) {
                    if (this.mListDownloadThread != null) {
                        for (int i2 = 0; i2 < this.mListDownloadThread.size(); i2++) {
                            if (!this.mListDownloadThread.get(i2).isFinished()) {
                                this.mListDownloadThread.get(i2).cancel();
                            }
                        }
                    }
                    setState(IDownloader.DownloadStatus.PAUSED);
                }
            } catch (Exception unused) {
                RemoteXAdLogger.getInstance().d(TAG, "pause exception");
            }
        }
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void removeObservers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            deleteObservers();
        }
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
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
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Override // java.lang.Runnable
    public void run() {
        int responseCode;
        long contentLength;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
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
                } catch (Throwable th) {
                    if (0 != 0) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
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
            } else if (httpURLConnection.getContentType().equals(SapiWebView.DATA_MIME_TYPE)) {
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
        }
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void setDownloadOnlyWifi(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.mIsOnlyWifi = z;
        }
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void setPausedManually(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.pausedManually = z;
        }
    }

    public void setState(IDownloader.DownloadStatus downloadStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, downloadStatus) == null) {
            this.mState = downloadStatus;
            stateChanged();
        }
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
            remoteXAdLogger.d(TAG, "execute Start; state = " + this.mState);
            if (this.mState == IDownloader.DownloadStatus.NONE) {
                setState(IDownloader.DownloadStatus.INITING);
                setPausedManually(true);
                TaskScheduler.getInstance().submit(this);
            }
        }
    }

    public void stateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            setChanged();
            notifyObservers();
        }
    }

    public synchronized void updateDownloadedSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            synchronized (this) {
                this.mDownloaded += i2;
                int progress = (int) getProgress();
                if (this.mProgress < progress) {
                    this.mProgress = progress;
                    stateChanged();
                }
            }
        }
    }
}
