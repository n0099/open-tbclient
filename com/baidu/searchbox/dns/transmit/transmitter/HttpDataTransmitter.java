package com.baidu.searchbox.dns.transmit.transmitter;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.searchbox.dns.transmit.transmitter.exception.ExceptionMessage;
import com.baidu.searchbox.dns.transmit.transmitter.exception.RetryException;
import com.baidu.searchbox.dns.transmit.transmitter.exception.StopRequestException;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.searchbox.privateapi.PrivateApiUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes3.dex */
public abstract class HttpDataTransmitter<T> implements HttpTransmitter<T> {
    public static final String CHARSET = "UTF-8";
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded;charset=UTF-8";
    public static final String CONTENT_TYPE_KEY = "Content-Type";
    public static final int RETRY_DELAY = 5000;
    public static final int RETRY_MAX_TIMES = 2;
    public static final int SUCCESS_CODE = 200;
    public static final int TIMEOUT = 30000;
    public static final String USER_AGENT = "Mozilla/5.0 (Linux; Android %s) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    public int retryTimes = 0;
    public boolean mIsCancel = false;
    public int maxRetryTimes = getMaxRetryTimes();

    public int getMaxRetryTimes() {
        return 2;
    }

    public abstract Map<String, Object> getParameters();

    public abstract String getUrl();

    public abstract void handleException(Exception exc);

    public abstract void handleServerError(int i);

    public boolean isHttps() {
        return false;
    }

    public boolean isNoRetryServerError(int i) {
        return 403 == i || 404 == i;
    }

    public abstract T parseResult(String str);

    public abstract void postHandleConnection(HttpURLConnection httpURLConnection) throws RetryException;

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpTransmitter
    public void cancel() {
        this.mIsCancel = true;
    }

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpTransmitter
    public T sendRequest() {
        this.retryTimes = 0;
        while (this.retryTimes <= this.maxRetryTimes) {
            try {
                try {
                    return transmitData();
                } catch (RetryException e) {
                    doRetry(e);
                }
            } catch (StopRequestException e2) {
                if (e2.getFailStatus() == 10001) {
                    handleServerError(e2.getDetailErrorCode());
                    return null;
                }
                handleException(e2);
                return null;
            }
        }
        return null;
    }

    private T transmitData() throws RetryException, StopRequestException {
        HttpURLConnection httpURLConnection;
        if (!this.mIsCancel) {
            HttpURLConnection httpURLConnection2 = null;
            String url = getUrl();
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " sendRequest url:" + url);
            }
            try {
                if (!TextUtils.isEmpty(url)) {
                    try {
                        if (!isHttps()) {
                            httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
                        } else {
                            httpURLConnection = (HttpsURLConnection) new URL(url).openConnection();
                        }
                        httpURLConnection2 = httpURLConnection;
                        httpURLConnection2.setRequestProperty("Charsert", "UTF-8");
                        httpURLConnection2.setConnectTimeout(30000);
                        httpURLConnection2.setReadTimeout(30000);
                        processExtraConnection(httpURLConnection2);
                        httpURLConnection2.connect();
                        postHandleConnection(httpURLConnection2);
                        handleResponseCode(httpURLConnection2);
                        return parseResult(handleResponseEntity(httpURLConnection2));
                    } catch (Exception e) {
                        throw new RetryException(e.getMessage());
                    }
                }
                throw new StopRequestException(ExceptionMessage.URL_EMPTY);
            } finally {
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            }
        }
        throw new StopRequestException(10002, ExceptionMessage.CANCEL);
    }

    public String buildParametersString(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String obj = entry.getValue().toString();
            try {
                sb.append(entry.getKey() + "=" + URLEncoder.encode(obj, "UTF-8"));
                sb.append("&");
            } catch (UnsupportedEncodingException unused) {
                return null;
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public void doRetry(RetryException retryException) throws StopRequestException {
        int i = this.retryTimes + 1;
        this.retryTimes = i;
        if (i <= this.maxRetryTimes) {
            SystemClock.sleep(5000L);
        } else if (retryException.getFailStatus() == 10001) {
            throw new StopRequestException(retryException.getFailStatus(), retryException.getDetailErrorCode(), " retry count reach fail ");
        } else {
            throw new StopRequestException(" retry count reach fail ");
        }
    }

    public void processExtraConnection(HttpURLConnection httpURLConnection) throws ProtocolException {
        httpURLConnection.setRequestProperty("Content-Type", CONTENT_TYPE);
        httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
    }

    public String getUserAgent() {
        StringBuffer stringBuffer = new StringBuffer();
        String str = Build.VERSION.RELEASE;
        if (str.length() > 0) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append("1.0");
        }
        if (PrivateApiUtils.SDK_VERSION_NAME.equals(Build.VERSION.CODENAME)) {
            String str2 = Build.MODEL;
            if (str2.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str2);
            }
        }
        String str3 = Build.ID;
        if (str3.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(str3);
        }
        return String.format(USER_AGENT, stringBuffer);
    }

    public void handleResponseCode(HttpURLConnection httpURLConnection) throws RetryException, StopRequestException {
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                String str = " http response error -> " + responseCode;
                if (isNoRetryServerError(responseCode)) {
                    throw new StopRequestException(10001, responseCode, str);
                }
                throw new RetryException(10001, responseCode, str);
            }
        } catch (IOException e) {
            throw new RetryException(e.getMessage());
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0059 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: java.io.BufferedReader */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String handleResponseEntity(HttpURLConnection httpURLConnection) throws RetryException, StopRequestException {
        BufferedReader bufferedReader;
        InputStream inputStream;
        BufferedReader bufferedReader2;
        InputStream inputStream2 = null;
        try {
            String contentEncoding = httpURLConnection.getContentEncoding();
            inputStream = httpURLConnection.getInputStream();
            try {
                try {
                    if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.equals("gzip")) {
                        inputStream = new GZIPInputStream(inputStream);
                    }
                    bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, IMAudioTransRequest.CHARSET));
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = inputStream2;
            }
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String readLine = bufferedReader2.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(new String(readLine.getBytes(IMAudioTransRequest.CHARSET), IMAudioTransRequest.CHARSET));
            }
            String stringBuffer2 = stringBuffer.toString();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            try {
                bufferedReader2.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
            return stringBuffer2;
        } catch (Exception e7) {
            e = e7;
            inputStream2 = bufferedReader2;
            throw new StopRequestException(e.getMessage());
        } catch (Throwable th3) {
            th = th3;
            inputStream2 = inputStream;
            bufferedReader = bufferedReader2;
            if (inputStream2 != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
    }
}
