package com.baidu.mobads.container.components.net;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.AdURIUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class OAdURLConnection {
    public static final String CONTENT_TYPE_APPLICATION_JSON = "application/json";
    public static final String CONTENT_TYPE_TEXT_PLAIN = "text/plain";
    public static final int LOADER_PRIORITY_HIGH = 1;
    public static final int LOADER_PRIORITY_NORMAL = 2;
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    public static final String TAG = "URLConnection";
    public RemoteXAdLogger mAdLogger;
    public OnAdRequestListener mAdRequestListener;
    public int mConnectTimeOut;
    public String mContentType;
    public HttpURLConnection mHttpURLConnection;
    public OnImageRequestListener mImageRequestListener;
    public int mPriority;
    public int mReadTimeOut;
    public String mRequestMethod;
    public String mRequestUrl;
    public Uri.Builder mUriBuilder;
    public boolean mUseCaches;
    public String mUserAgent;

    /* loaded from: classes2.dex */
    public class LoadUrlRunnable extends BaseTask {
        public LoadUrlRunnable() {
        }

        @Override // com.baidu.mobads.container.executor.BaseTask
        public Object doInBackground() {
            OAdURLConnection.this.request();
            OAdURLConnection.this.connect();
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public interface OnAdRequestListener {
        void onFail(String str, int i2);

        void onSuccess(String str, String str2);
    }

    /* loaded from: classes2.dex */
    public interface OnImageRequestListener {
        void onFail(String str, int i2);

        void onSuccess(InputStream inputStream, String str);
    }

    public OAdURLConnection(int i2, String str) {
        this(i2, str, "GET");
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    public void connect() {
        HttpURLConnection httpURLConnection;
        try {
            try {
                this.mHttpURLConnection.connect();
                RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
                remoteXAdLogger.d(TAG, this.mHttpURLConnection.getRequestMethod() + " connect code :" + this.mHttpURLConnection.getResponseCode());
                int responseCode = this.mHttpURLConnection.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    this.mHttpURLConnection.setInstanceFollowRedirects(false);
                    HttpURLConnection openConnectionCheckRedirects = openConnectionCheckRedirects(this.mHttpURLConnection);
                    this.mHttpURLConnection = openConnectionCheckRedirects;
                    responseCode = openConnectionCheckRedirects.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    if (this.mAdRequestListener != null) {
                        this.mAdRequestListener.onFail(this.mHttpURLConnection.getResponseMessage(), responseCode);
                    }
                    if (this.mImageRequestListener != null) {
                        this.mImageRequestListener.onFail(this.mHttpURLConnection.getResponseMessage(), responseCode);
                    }
                } else {
                    String fixedString = AdURIUtils.getFixedString(this.mRequestUrl);
                    if (this.mAdRequestListener != null) {
                        this.mAdRequestListener.onSuccess(getReadContent(), fixedString);
                    }
                    if (this.mImageRequestListener != null) {
                        this.mImageRequestListener.onSuccess(this.mHttpURLConnection.getInputStream(), fixedString);
                    }
                }
                httpURLConnection = this.mHttpURLConnection;
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Exception e2) {
                if (this.mAdRequestListener != null) {
                    OnAdRequestListener onAdRequestListener = this.mAdRequestListener;
                    onAdRequestListener.onFail("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                if (this.mImageRequestListener != null) {
                    OnImageRequestListener onImageRequestListener = this.mImageRequestListener;
                    onImageRequestListener.onFail("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                httpURLConnection = this.mHttpURLConnection;
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection2 = this.mHttpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    private HttpURLConnection openConnectionCheckRedirects(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(httpURLConnection.getHeaderField("Location")).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(httpURLConnection2.getConnectTimeout());
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

    private void postDataToOutputStream(String str, HttpURLConnection httpURLConnection) throws IOException {
        OutputStream outputStream;
        BufferedWriter bufferedWriter = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                try {
                    bufferedWriter2.write(str);
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void request() {
        if (TextUtils.isEmpty(this.mRequestUrl)) {
            return;
        }
        try {
            HttpURLConnection httpURLConnection = AdURIUtils.getHttpURLConnection(new URL(this.mRequestUrl));
            this.mHttpURLConnection = httpURLConnection;
            httpURLConnection.setConnectTimeout(this.mConnectTimeOut);
            this.mHttpURLConnection.setReadTimeout(this.mReadTimeOut);
            if (Integer.parseInt(Build.VERSION.SDK) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            this.mHttpURLConnection.setRequestMethod(this.mRequestMethod);
            this.mHttpURLConnection.setUseCaches(this.mUseCaches);
            if (!TextUtils.isEmpty(this.mUserAgent)) {
                this.mHttpURLConnection.setRequestProperty("User-Agent", this.mUserAgent);
            }
            this.mHttpURLConnection.setRequestProperty("Content-type", this.mContentType);
            this.mHttpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
            this.mHttpURLConnection.setRequestProperty("Cache-Control", "no-cache");
            if (this.mRequestMethod.equals("POST")) {
                this.mHttpURLConnection.setDoInput(true);
                this.mHttpURLConnection.setDoOutput(true);
                if (this.mUriBuilder != null) {
                    postDataToOutputStream(this.mUriBuilder.build().getEncodedQuery(), this.mHttpURLConnection);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            OnAdRequestListener onAdRequestListener = this.mAdRequestListener;
            if (onAdRequestListener != null) {
                onAdRequestListener.onFail("Net Create RuntimeError: " + e2.toString(), 0);
            }
            OnImageRequestListener onImageRequestListener = this.mImageRequestListener;
            if (onImageRequestListener != null) {
                onImageRequestListener.onFail("Net Create RuntimeError: " + e2.toString(), 0);
            }
        } catch (Throwable th) {
            OnAdRequestListener onAdRequestListener2 = this.mAdRequestListener;
            if (onAdRequestListener2 != null) {
                onAdRequestListener2.onFail("Net Create RuntimeError: " + th.toString(), 0);
            }
            OnImageRequestListener onImageRequestListener2 = this.mImageRequestListener;
            if (onImageRequestListener2 != null) {
                onImageRequestListener2.onFail("Net Create RuntimeError: " + th.toString(), 0);
            }
        }
    }

    public void addAdRequestListener(OnAdRequestListener onAdRequestListener) {
        this.mAdRequestListener = onAdRequestListener;
    }

    public void addImageRequestListener(OnImageRequestListener onImageRequestListener) {
        this.mImageRequestListener = onImageRequestListener;
    }

    public void asynLoad() {
        try {
            if (this.mPriority == 1) {
                TaskScheduler.getInstance().submit(new LoadUrlRunnable(), 1);
            } else {
                TaskScheduler.getInstance().submit(new LoadUrlRunnable(), 2);
            }
        } catch (Exception unused) {
        }
    }

    public void closeInputStream() {
        HttpURLConnection httpURLConnection = this.mHttpURLConnection;
        if (httpURLConnection != null) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e2) {
                Log.e(TAG, e2.toString());
            }
        }
    }

    public String getReadContent() throws Exception {
        InputStream inputStream = null;
        try {
            inputStream = this.mHttpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[128];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toString();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public void setConnectTimeout(int i2) {
        this.mConnectTimeOut = i2;
    }

    public void setContentType(String str) {
        this.mContentType = str;
    }

    public void setReadTimeout(int i2) {
        this.mReadTimeOut = i2;
    }

    public void setRequestProperty(Map<String, String> map) {
        if (this.mHttpURLConnection != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.mHttpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    public void setUriBuilder(Uri.Builder builder) {
        this.mUriBuilder = builder;
    }

    public String synLoad() {
        request();
        HttpURLConnection httpURLConnection = this.mHttpURLConnection;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getResponseCode() / 100 != 2) {
                    HttpURLConnection httpURLConnection2 = this.mHttpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return null;
                }
                String readContent = getReadContent();
                HttpURLConnection httpURLConnection3 = this.mHttpURLConnection;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                return readContent;
            } catch (Throwable unused) {
                HttpURLConnection httpURLConnection4 = this.mHttpURLConnection;
                if (httpURLConnection4 != null) {
                    httpURLConnection4.disconnect();
                }
            }
        }
        return null;
    }

    public OAdURLConnection(int i2, String str, String str2) {
        this.mAdLogger = RemoteXAdLogger.getInstance();
        this.mAdRequestListener = null;
        this.mImageRequestListener = null;
        this.mContentType = "text/plain";
        this.mConnectTimeOut = 10000;
        this.mReadTimeOut = 10000;
        this.mUseCaches = false;
        this.mUriBuilder = null;
        this.mPriority = i2;
        this.mRequestUrl = str;
        this.mRequestMethod = str2;
    }
}
