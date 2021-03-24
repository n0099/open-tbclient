package com.baidu.down.loopj.android.urlconnection;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.baidu.down.common.NameValuePair;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;
/* loaded from: classes2.dex */
public class HttpURLExecutorRunnable implements Runnable {
    public static final boolean DEBUG = false;
    public static final long SLEEP_TIME_WHILE_REQUEST_FAILED = 1000;
    public static final String TAG = "HttpURLExecutorRunnable";
    public static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(2);
    public static final int TRY_COUNT = 3;
    public Context mContext;
    public OnWebRequestListener mOnWebRequestListener;
    public List<NameValuePair> mParams;
    public String mRequestType;
    public int mTryCount;
    public String mUrl;
    public boolean mUsingDNSProxy;

    /* loaded from: classes2.dex */
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

    private boolean isGzip(String str) {
        return str != null && str.contains(AsyncHttpClient.ENCODING_GZIP);
    }

    public void execute() {
        THREAD_POOL.execute(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        BufferedReader bufferedReader;
        InputStream inputStream;
        System.currentTimeMillis();
        if (TextUtils.isEmpty(this.mUrl)) {
            OnWebRequestListener onWebRequestListener = this.mOnWebRequestListener;
            if (onWebRequestListener != null) {
                onWebRequestListener.onFailed();
                return;
            }
            return;
        }
        for (int i = 0; i < this.mTryCount; i++) {
            InputStream inputStream2 = null;
            BufferedReader bufferedReader2 = null;
            inputStream2 = null;
            try {
                HttpURLConnection httpURLConnection = new ProxyURLConnection(this.mContext, this.mUsingDNSProxy).getHttpURLConnection(this.mUrl, null, this.mRequestType, this.mParams, false, false);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    if (isGzip(httpURLConnection.getContentEncoding())) {
                        inputStream = new GZIPInputStream(httpURLConnection.getInputStream());
                    } else {
                        inputStream = httpURLConnection.getInputStream();
                    }
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
                            } catch (Exception e2) {
                                e = e2;
                                inputStream2 = inputStream;
                                try {
                                    e.printStackTrace();
                                    if (i != 0 && URLUtil.isHttpsUrl(this.mUrl)) {
                                        this.mUrl = this.mUrl.replaceFirst("https://", "http://");
                                    } else {
                                        try {
                                            Thread.sleep(1000L);
                                        } catch (InterruptedException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    if (bufferedReader == null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException e6) {
                                            e6.printStackTrace();
                                        }
                                    }
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e7) {
                                            e7.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                }
                                if (bufferedReader != null) {
                                }
                                throw th;
                            }
                        }
                        this.mOnWebRequestListener.onSuccess(str);
                    } catch (Exception e8) {
                        e = e8;
                        bufferedReader = null;
                        inputStream2 = inputStream;
                        e.printStackTrace();
                        if (i != 0) {
                        }
                        Thread.sleep(1000L);
                        if (inputStream2 != null) {
                        }
                        if (bufferedReader == null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                        inputStream2 = inputStream;
                        if (inputStream2 != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                } else {
                    this.mOnWebRequestListener.onFailed();
                    inputStream = null;
                    bufferedReader = null;
                }
                if (inputStream != null) {
                    inputStream.close();
                    inputStream = null;
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                } else {
                    bufferedReader2 = bufferedReader;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                        return;
                    } catch (IOException e10) {
                        e10.printStackTrace();
                        return;
                    }
                }
                return;
            } catch (Exception e11) {
                e = e11;
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        }
        OnWebRequestListener onWebRequestListener2 = this.mOnWebRequestListener;
        if (onWebRequestListener2 != null) {
            onWebRequestListener2.onFailed();
        }
    }

    public void setRequestType(String str) {
        this.mRequestType = str;
    }

    public HttpURLExecutorRunnable(Context context, boolean z, String str, List<NameValuePair> list, OnWebRequestListener onWebRequestListener, int i) {
        this(context, z, str, list, onWebRequestListener);
        this.mTryCount = i;
    }
}
