package com.baidu.browser.core.net;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.browser.core.net.BdNet;
import com.baidu.browser.core.util.BdLog;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.cyberplayer.sdk.BVideoView;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import com.baidu.zeus.Headers;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* loaded from: classes.dex */
public class BdNetEngine extends HandlerThread {
    public static final int EXCUTE_TASK_ERROR = 3;
    public static final int EXCUTE_TASK_REDIRECT = 2;
    public static final int EXCUTE_TASK_SUCCESS = 1;
    public static final int MESSAGE_EXCUTE_TASK = 1;
    private static int mNid = 0;
    private HttpURLConnection mConnection;
    private volatile boolean mIsAllocate;
    private boolean mIsCmwap;
    private volatile boolean mIsRunning;
    private volatile boolean mIsWorking;
    private BdNetEngineListener mListener;
    private BdNetTask mNetTask;
    private Handler mPrivateHandler;
    private String mWapApnUrl;

    /* loaded from: classes.dex */
    public interface BdNetEngineListener {
        BdNetTask onNetDownloadComplete(BdNetEngine bdNetEngine, BdNetTask bdNetTask, boolean z);

        void onNetDownloadError(BdNetEngine bdNetEngine, BdNetTask bdNetTask, BdNet.NetError netError, int i);

        void onNetDownloadStart(BdNetEngine bdNetEngine, BdNetTask bdNetTask);

        void onNetReceiveData(BdNetEngine bdNetEngine, BdNetTask bdNetTask, byte[] bArr, int i);

        void onNetReceiveHeaders(BdNetEngine bdNetEngine, BdNetTask bdNetTask);

        boolean onNetRedirect(BdNetEngine bdNetEngine, BdNetTask bdNetTask, int i);

        void onNetResponseCode(BdNetEngine bdNetEngine, BdNetTask bdNetTask, int i);

        void onNetStateChanged(BdNetEngine bdNetEngine, BdNetTask bdNetTask, BdNet.NetState netState, int i);

        void onNetUploadComplete(BdNetEngine bdNetEngine, BdNetTask bdNetTask);

        void onNetUploadData(BdNetEngine bdNetEngine, BdNetTask bdNetTask, int i, int i2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BdNetEngine() {
        super(r0.append(r1).toString());
        StringBuilder sb = new StringBuilder("BdNetEngine");
        int i = mNid;
        mNid = i + 1;
    }

    public void setCmwap(boolean z) {
        this.mIsCmwap = z;
    }

    public void setWapApnUrl(String str) {
        this.mWapApnUrl = str;
    }

    public void setEventListener(BdNetEngineListener bdNetEngineListener) {
        this.mListener = bdNetEngineListener;
    }

    public void startDownload(BdNetTask bdNetTask) {
        if (bdNetTask == null) {
            throw new NullPointerException();
        }
        if (!isAlive()) {
            this.mIsRunning = true;
            this.mIsWorking = true;
            this.mNetTask = bdNetTask;
            try {
                start();
            } catch (IllegalThreadStateException e) {
                this.mIsRunning = false;
                this.mIsWorking = false;
                throw e;
            }
        } else if (!this.mIsRunning) {
            throw new IllegalThreadStateException();
        } else {
            if (!this.mIsWorking) {
                this.mIsWorking = true;
                this.mNetTask = bdNetTask;
                this.mPrivateHandler.obtainMessage(1, this.mNetTask).sendToTarget();
                return;
            }
            throw new IllegalThreadStateException();
        }
    }

    public void stopDownload() {
        this.mIsRunning = false;
        if (this.mPrivateHandler != null) {
            this.mPrivateHandler.removeMessages(1);
        }
        if (this.mNetTask != null) {
            this.mNetTask.stop();
        }
        if (this.mConnection != null) {
            this.mConnection.disconnect();
        }
        quit();
    }

    public boolean isWorking() {
        return this.mIsWorking;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAllocate() {
        return this.mIsAllocate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void allocate() {
        this.mIsAllocate = true;
    }

    void recycle() {
        this.mIsAllocate = false;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        if (this.mPrivateHandler == null) {
            this.mPrivateHandler = new Handler(getLooper()) { // from class: com.baidu.browser.core.net.BdNetEngine.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 1:
                            BdNetEngine.this.mIsWorking = true;
                            BdNetEngine.this.mNetTask = BdNetEngine.this.performTask((BdNetTask) message.obj);
                            if (BdNetEngine.this.mNetTask != null) {
                                BdNetEngine.this.mPrivateHandler.obtainMessage(1, BdNetEngine.this.mNetTask).sendToTarget();
                            } else {
                                BdNetEngine.this.recycle();
                            }
                            BdNetEngine.this.mIsWorking = false;
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        this.mPrivateHandler.obtainMessage(1, this.mNetTask).sendToTarget();
    }

    public BdNetTask performTask(BdNetTask bdNetTask) {
        try {
            if (this.mListener != null) {
                this.mListener.onNetDownloadStart(this, bdNetTask);
            }
            int excuteTask = excuteTask(bdNetTask);
            if (this.mIsRunning) {
                if (excuteTask == 1 && this.mListener != null) {
                    return this.mListener.onNetDownloadComplete(this, bdNetTask, true);
                }
                if (excuteTask != 2) {
                    if (excuteTask != 3 || this.mListener == null) {
                        return null;
                    }
                    return this.mListener.onNetDownloadComplete(this, bdNetTask, false);
                }
                return bdNetTask;
            }
            if (this.mListener != null && excuteTask != 3) {
                this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_RUN_STOP, 0);
            }
            return null;
        } catch (Exception e) {
            BdLog.w("runTask Exception", e);
            try {
                if (this.mListener != null) {
                    this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_RUN_EXCEPTION, 0);
                }
            } catch (Exception e2) {
                BdLog.w("runTask onNetDownloadError Exception", e);
            }
            return null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, SGET, INVOKE, IF, IGET, IGET, INVOKE, IGET, SGET, INVOKE, IF, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [423=10, 424=10, 427=10, 428=10] */
    private int excuteTask(BdNetTask bdNetTask) {
        try {
            try {
                try {
                    try {
                        URL url = new URL(bdNetTask.isRedirect() ? bdNetTask.getRedirectUrl() : bdNetTask.getUrl());
                        if (!this.mIsCmwap) {
                            this.mConnection = (HttpURLConnection) url.openConnection();
                        } else if (this.mWapApnUrl == null || !this.mWapApnUrl.startsWith(HttpUtils.IP_CTWAP)) {
                            this.mConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80)));
                            this.mConnection.setRequestProperty(HttpUtils.HEADER_NAME_CMWAP_ONLINE_HOST, url.getHost());
                        } else {
                            this.mConnection = (HttpURLConnection) url.openConnection();
                        }
                        this.mConnection.setConnectTimeout(bdNetTask.getConnectionTimeOut());
                        this.mConnection.setReadTimeout(bdNetTask.getReadTimeOut());
                        this.mConnection.setInstanceFollowRedirects(bdNetTask.isFollowRedirects());
                        if (this.mIsRunning && !bdNetTask.isStop()) {
                            bdNetTask.setConnection(this.mConnection);
                            if (bdNetTask.getMethod() == BdNet.HttpMethod.METHOD_POST) {
                                byte[] content = bdNetTask.getContent();
                                this.mConnection.setDoOutput(true);
                                this.mConnection.setDoInput(true);
                                this.mConnection.setUseCaches(false);
                                this.mConnection.setRequestMethod("POST");
                                this.mConnection.setRequestProperty("Content-length", String.valueOf(content.length));
                            }
                            addHeaders(bdNetTask);
                            if (this.mListener != null) {
                                this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_CONNECT_START, 0);
                            }
                            this.mConnection.connect();
                        }
                        if (this.mIsRunning && !bdNetTask.isStop()) {
                            if (this.mListener != null) {
                                this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_CONNECT_SETUP, 0);
                            }
                            if (bdNetTask.getMethod() == BdNet.HttpMethod.METHOD_POST && !upload(bdNetTask)) {
                                if (this.mConnection != null) {
                                    this.mConnection.disconnect();
                                }
                                if (this.mListener != null) {
                                    this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                                }
                                return 3;
                            }
                        }
                        if (this.mIsRunning && !bdNetTask.isStop()) {
                            int responseCode = this.mConnection.getResponseCode();
                            if (this.mIsRunning && !bdNetTask.isStop()) {
                                if (this.mListener != null) {
                                    this.mListener.onNetResponseCode(this, bdNetTask, responseCode);
                                }
                                switch (responseCode) {
                                    case 200:
                                    case 206:
                                        if (this.mListener != null) {
                                            this.mListener.onNetReceiveHeaders(this, bdNetTask);
                                        }
                                        if (!download(bdNetTask)) {
                                            if (this.mConnection != null) {
                                                this.mConnection.disconnect();
                                            }
                                            if (this.mListener != null) {
                                                this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                                            }
                                            return 3;
                                        }
                                        break;
                                    case 300:
                                    case BVideoView.MEDIA_ERROR_NO_INPUTFILE /* 301 */:
                                    case BVideoView.MEDIA_ERROR_INVALID_INPUTFILE /* 302 */:
                                    case BVideoView.MEDIA_ERROR_NO_SUPPORTED_CODEC /* 303 */:
                                    case 307:
                                        if (this.mListener != null && this.mListener.onNetRedirect(this, bdNetTask, responseCode)) {
                                            if (redirect(bdNetTask)) {
                                                if (this.mConnection != null) {
                                                    this.mConnection.disconnect();
                                                }
                                                if (this.mListener != null) {
                                                    this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                                                }
                                                return 2;
                                            }
                                            this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_REDIRECT, responseCode);
                                            if (this.mConnection != null) {
                                                this.mConnection.disconnect();
                                            }
                                            if (this.mListener != null) {
                                                this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                                            }
                                            return 3;
                                        }
                                        break;
                                    case BVideoView.MEDIA_ERROR_DISPLAY /* 304 */:
                                        if (this.mListener != null) {
                                            this.mListener.onNetReceiveHeaders(this, bdNetTask);
                                            break;
                                        }
                                        break;
                                    case BdWebErrorView.ERROR_CODE_404 /* 404 */:
                                    case BdWebErrorView.ERROR_CODE_500 /* 500 */:
                                    case BdWebErrorView.ERROR_CODE_503 /* 503 */:
                                        if (this.mListener != null) {
                                            this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_HTTP, responseCode);
                                            break;
                                        }
                                        break;
                                    default:
                                        if (this.mListener != null) {
                                            this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_UNKNOWN, responseCode);
                                            break;
                                        }
                                        break;
                                }
                            }
                        }
                        if (this.mConnection != null) {
                            this.mConnection.disconnect();
                        }
                        if (this.mListener != null) {
                            this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                        }
                        return 1;
                    } catch (IOException e) {
                        BdLog.w("runTask IOException", e);
                        if (this.mListener != null) {
                            this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_IO, 0);
                        }
                        if (this.mConnection != null) {
                            this.mConnection.disconnect();
                        }
                        if (this.mListener != null) {
                            this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                        }
                        return 3;
                    }
                } catch (Exception e2) {
                    BdLog.w("runTask Exception", e2);
                    if (this.mListener != null) {
                        this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_UNKNOWN, 0);
                    }
                    if (this.mConnection != null) {
                        this.mConnection.disconnect();
                    }
                    if (this.mListener != null) {
                        this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                    }
                    return 3;
                }
            } catch (MalformedURLException e3) {
                BdLog.w("runTask MalformedURLException", e3);
                if (this.mListener != null) {
                    this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_MALFORMEDURL, 0);
                }
                if (this.mConnection != null) {
                    this.mConnection.disconnect();
                }
                if (this.mListener != null) {
                    this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                }
                return 3;
            } catch (SocketTimeoutException e4) {
                BdLog.w("runTask SocketTimeoutException", e4);
                if (this.mListener != null) {
                    this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_CONNECT_TIMEOUT, 0);
                }
                if (this.mConnection != null) {
                    this.mConnection.disconnect();
                }
                if (this.mListener != null) {
                    this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                }
                return 3;
            }
        } catch (Throwable th) {
            if (this.mConnection != null) {
                this.mConnection.disconnect();
            }
            if (this.mListener != null) {
                this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
            }
            throw th;
        }
    }

    private void addHeaders(BdNetTask bdNetTask) {
        Map<String, String> headers = bdNetTask.getHeaders();
        for (String str : headers.keySet()) {
            this.mConnection.addRequestProperty(str, headers.get(str));
        }
        StringBuffer stringBuffer = new StringBuffer();
        Map<String, String> cookies = bdNetTask.getCookies();
        for (String str2 : cookies.keySet()) {
            stringBuffer.append(str2.trim());
            stringBuffer.append("=");
            stringBuffer.append(cookies.get(str2).trim());
            stringBuffer.append(";");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.setLength(stringBuffer.length() - 1);
            this.mConnection.addRequestProperty(HttpUtils.HEADER_NAME_COOKIE, stringBuffer.toString());
        }
        String refer = bdNetTask.getRefer();
        if (refer != null) {
            this.mConnection.addRequestProperty(HttpUtils.HEADER_NAME_REFERER, refer);
        }
        String userAgent = bdNetTask.getUserAgent();
        if (userAgent != null) {
            this.mConnection.addRequestProperty(HttpUtils.HEADER_NAME_USER_AGENT, userAgent);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean upload(BdNetTask bdNetTask) {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2 = null;
        try {
            try {
                byte[] content = bdNetTask.getContent();
                dataOutputStream = new DataOutputStream(this.mConnection.getOutputStream());
                try {
                    dataOutputStream.write(content);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    if (this.mIsRunning && !bdNetTask.isStop() && this.mListener != null) {
                        this.mListener.onNetUploadData(this, bdNetTask, content.length, content.length);
                        this.mListener.onNetUploadComplete(this, bdNetTask);
                    }
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e) {
                            BdLog.w("upload IOException", e);
                        }
                    }
                    return true;
                } catch (IOException e2) {
                    e = e2;
                    if (this.mListener != null) {
                        this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_IO, 0);
                    }
                    BdLog.w("upload IOException", e);
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                            return false;
                        } catch (IOException e3) {
                            BdLog.w("upload IOException", e3);
                            return false;
                        }
                    }
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        dataOutputStream2.close();
                    } catch (IOException e4) {
                        BdLog.w("upload IOException", e4);
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            dataOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean download(BdNetTask bdNetTask) {
        InputStream inputStream;
        InputStream inputStream2;
        GZIPInputStream gZIPInputStream = null;
        try {
            inputStream = this.mConnection.getInputStream();
            if (inputStream != null) {
                try {
                    if (this.mIsRunning && !bdNetTask.isStop()) {
                        byte[] bArr = new byte[LVBuffer.LENGTH_ALLOC_PER_NEW];
                        String headerField = this.mConnection.getHeaderField(HttpUtils.HEADER_NAME_CONTENT_ENCODING);
                        if (!(headerField != null && headerField.indexOf("gzip") >= 0)) {
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1 || !this.mIsRunning || bdNetTask.isStop()) {
                                    break;
                                } else if (this.mListener != null) {
                                    this.mListener.onNetReceiveData(this, bdNetTask, bArr, read);
                                }
                            }
                        } else {
                            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
                            if (gZIPInputStream2 != null) {
                                while (true) {
                                    try {
                                        int read2 = gZIPInputStream2.read(bArr);
                                        if (read2 != -1 && this.mIsRunning && !bdNetTask.isStop()) {
                                            if (this.mListener != null) {
                                                this.mListener.onNetReceiveData(this, bdNetTask, bArr, read2);
                                            }
                                        }
                                    } catch (IOException e) {
                                        e = e;
                                        gZIPInputStream = gZIPInputStream2;
                                        inputStream2 = inputStream;
                                        try {
                                            if (this.mListener != null) {
                                                this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_IO, 0);
                                            }
                                            BdLog.w("download IOException", e);
                                            if (gZIPInputStream != null) {
                                                try {
                                                    gZIPInputStream.close();
                                                } catch (IOException e2) {
                                                    BdLog.w("download IOException", e2);
                                                }
                                            }
                                            if (inputStream2 != null) {
                                                try {
                                                    inputStream2.close();
                                                } catch (IOException e3) {
                                                    BdLog.w("download IOException", e3);
                                                }
                                            }
                                            return false;
                                        } catch (Throwable th) {
                                            th = th;
                                            inputStream = inputStream2;
                                            if (gZIPInputStream != null) {
                                                try {
                                                    gZIPInputStream.close();
                                                } catch (IOException e4) {
                                                    BdLog.w("download IOException", e4);
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e5) {
                                                    BdLog.w("download IOException", e5);
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        gZIPInputStream = gZIPInputStream2;
                                        if (gZIPInputStream != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        throw th;
                                    }
                                }
                                gZIPInputStream2.close();
                                gZIPInputStream = gZIPInputStream2;
                            } else {
                                gZIPInputStream = gZIPInputStream2;
                            }
                        }
                    }
                    inputStream.close();
                } catch (IOException e6) {
                    e = e6;
                    inputStream2 = inputStream;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            if (gZIPInputStream != null) {
                try {
                    gZIPInputStream.close();
                } catch (IOException e7) {
                    BdLog.w("download IOException", e7);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return true;
                } catch (IOException e8) {
                    BdLog.w("download IOException", e8);
                    return true;
                }
            }
            return true;
        } catch (IOException e9) {
            e = e9;
            inputStream2 = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    private boolean redirect(BdNetTask bdNetTask) {
        String headerField = this.mConnection.getHeaderField(Headers.LOCATION);
        if (headerField != null) {
            String headerField2 = this.mConnection.getHeaderField(Headers.SET_COOKIE);
            if (headerField2 != null) {
                bdNetTask.addCookies(headerField2);
            }
            bdNetTask.setRedirect(true);
            bdNetTask.setRedirectUrl(headerField);
            return true;
        }
        return false;
    }
}
