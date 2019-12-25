package com.baidu.down.loopj.android.urlconnection;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.baidu.down.common.NameValuePair;
import com.baidu.sapi2.utils.SapiUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;
/* loaded from: classes4.dex */
public class HttpURLExecutorRunnable implements Runnable {
    private static final boolean DEBUG = false;
    private static final long SLEEP_TIME_WHILE_REQUEST_FAILED = 1000;
    private static final String TAG = "HttpURLExecutorRunnable";
    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(2);
    private static final int TRY_COUNT = 3;
    private Context mContext;
    private OnWebRequestListener mOnWebRequestListener;
    private List<NameValuePair> mParams;
    private String mRequestType;
    private int mTryCount;
    private String mUrl;
    private boolean mUsingDNSProxy;

    /* loaded from: classes4.dex */
    public interface OnWebRequestListener {
        void onFailed();

        void onSuccess(String str);
    }

    public HttpURLExecutorRunnable(Context context, boolean z, String str, List<NameValuePair> list, OnWebRequestListener onWebRequestListener) {
        this.mRequestType = "GET";
        this.mTryCount = 3;
        this.mUsingDNSProxy = true;
        this.mContext = context.getApplicationContext();
        this.mUrl = str;
        this.mUsingDNSProxy = z;
        this.mParams = list;
        this.mOnWebRequestListener = onWebRequestListener;
    }

    public HttpURLExecutorRunnable(Context context, boolean z, String str, List<NameValuePair> list, OnWebRequestListener onWebRequestListener, int i) {
        this(context, z, str, list, onWebRequestListener);
        this.mTryCount = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [178=4] */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008a, code lost:
        if (r2 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008c, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a3, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a4, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        InputStream inputStream;
        BufferedReader bufferedReader;
        int i = 0;
        BufferedReader bufferedReader2 = null;
        System.currentTimeMillis();
        if (TextUtils.isEmpty(this.mUrl)) {
            if (this.mOnWebRequestListener != null) {
                this.mOnWebRequestListener.onFailed();
                return;
            }
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 >= this.mTryCount) {
                if (this.mOnWebRequestListener != null) {
                    this.mOnWebRequestListener.onFailed();
                    return;
                }
                return;
            }
            try {
                HttpURLConnection httpURLConnection = new ProxyURLConnection(this.mContext, this.mUsingDNSProxy).getHttpURLConnection(this.mUrl, null, this.mRequestType, this.mParams, false, false);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = isGzip(httpURLConnection.getContentEncoding()) ? new GZIPInputStream(httpURLConnection.getInputStream()) : httpURLConnection.getInputStream();
                    try {
                        String str = "";
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                str = str + readLine;
                            } catch (Exception e) {
                                e = e;
                                try {
                                    e.printStackTrace();
                                    if (i2 == 0 || !URLUtil.isHttpsUrl(this.mUrl)) {
                                        try {
                                            Thread.sleep(1000L);
                                        } catch (InterruptedException e2) {
                                            e2.printStackTrace();
                                        }
                                    } else {
                                        this.mUrl = this.mUrl.replaceFirst(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "http://");
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    if (bufferedReader == null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    i = i2 + 1;
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader2 = bufferedReader;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e6) {
                                            e6.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                        this.mOnWebRequestListener.onSuccess(str);
                    } catch (Exception e7) {
                        e = e7;
                        bufferedReader = null;
                        e.printStackTrace();
                        if (i2 == 0) {
                        }
                        Thread.sleep(1000L);
                        if (inputStream != null) {
                        }
                        if (bufferedReader == null) {
                        }
                        i = i2 + 1;
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                        }
                        if (bufferedReader2 != null) {
                        }
                        throw th;
                    }
                } else {
                    this.mOnWebRequestListener.onFailed();
                    bufferedReader = null;
                    inputStream = null;
                }
                if (inputStream != null) {
                    inputStream.close();
                    inputStream = null;
                }
                if (bufferedReader == null) {
                    bufferedReader2 = bufferedReader;
                    break;
                } else {
                    bufferedReader.close();
                    break;
                }
            } catch (Exception e8) {
                e = e8;
                bufferedReader = null;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
            i = i2 + 1;
        }
        if (bufferedReader2 != null) {
            try {
                bufferedReader2.close();
            } catch (IOException e9) {
                e9.printStackTrace();
            }
        }
    }

    private boolean isGzip(String str) {
        return str != null && str.contains("gzip");
    }

    public void execute() {
        THREAD_POOL.execute(this);
    }

    public void setRequestType(String str) {
        this.mRequestType = str;
    }
}
