package com.baidu.browser.core.net;

import com.baidu.browser.core.net.BdNet;
import com.baidu.browser.core.util.BdLog;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
/* loaded from: classes.dex */
public class BdNetTask {
    public static final String DEFAULT_USERAGENT = "Mozilla/5.0 (Linux; U; Android 2.2; en-us; Nexus One Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) FlyFlow/1.0 Version/4.0 Mobile Safari/533.1";
    private static final int MAX_POOL_SIZE = 10;
    public static final int TIMEOUT_CONNECTION = 0;
    public static final int TIMEOUT_READ = 25000;
    private HttpURLConnection mConnection;
    private byte[] mContent;
    private boolean mIsRedirect;
    private volatile boolean mIsStop;
    private BdNet mNet;
    private BdNetWorker mNetWorker;
    private String mRedirectUrl;
    private String mRefer;
    private String mUrl;
    private static final Map NULL_ARRAY = Collections.emptyMap();
    private static Vector sTaskPool = new Vector();
    private String mUserAgent = DEFAULT_USERAGENT;
    private BdNet.HttpMethod mMethod = BdNet.HttpMethod.METHOD_GET;
    private Map mHeaders = NULL_ARRAY;
    private Map mCookies = NULL_ARRAY;
    private int mReadTimeOut = TIMEOUT_READ;
    private int mConnectionTimeOut = 0;
    private boolean mFollowRedirects = true;

    public static BdNetTask obtain() {
        return sTaskPool.size() > 0 ? (BdNetTask) sTaskPool.remove(0) : new BdNetTask();
    }

    public static BdNetTask obtain(BdNet bdNet) {
        BdNetTask obtain = obtain();
        obtain.setNet(bdNet);
        return obtain;
    }

    public static BdNetTask obtain(BdNet bdNet, String str) {
        BdNetTask obtain = obtain();
        obtain.setNet(bdNet);
        obtain.setUrl(str);
        return obtain;
    }

    public void recycle() {
        if (sTaskPool.size() < 10) {
            clearForRecycle();
            sTaskPool.add(this);
        }
    }

    private void clearForRecycle() {
        stop();
        this.mUrl = null;
        this.mRedirectUrl = null;
        this.mRefer = null;
        this.mUserAgent = DEFAULT_USERAGENT;
        this.mContent = null;
        this.mMethod = BdNet.HttpMethod.METHOD_GET;
        this.mHeaders = NULL_ARRAY;
        this.mCookies = NULL_ARRAY;
        this.mReadTimeOut = TIMEOUT_READ;
        this.mConnectionTimeOut = 0;
        this.mIsRedirect = false;
        this.mFollowRedirects = true;
        this.mIsStop = false;
        this.mNet = null;
        this.mNetWorker = null;
        this.mConnection = null;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public String getRedirectUrl() {
        return this.mRedirectUrl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRedirectUrl(String str) {
        this.mRedirectUrl = str;
    }

    public String getRefer() {
        return this.mRefer;
    }

    public void setRefer(String str) {
        this.mRefer = str;
    }

    public String getUserAgent() {
        return this.mUserAgent;
    }

    public void setUserAgent(String str) {
        this.mUserAgent = str;
    }

    public byte[] getContent() {
        return this.mContent;
    }

    public void setContent(byte[] bArr) {
        this.mContent = bArr;
    }

    public BdNet.HttpMethod getMethod() {
        return this.mMethod;
    }

    public void setMethod(BdNet.HttpMethod httpMethod) {
        this.mMethod = httpMethod;
    }

    public Map getHeaders() {
        return this.mHeaders;
    }

    public void addHeaders(String str, String str2) {
        if (this.mHeaders == NULL_ARRAY) {
            this.mHeaders = new HashMap();
        }
        this.mHeaders.put(str, str2);
    }

    public void setHeaders(Map map) {
        this.mHeaders = map;
    }

    public Map getCookies() {
        return this.mCookies;
    }

    public void addCookies(String str) {
        try {
            if (this.mCookies == NULL_ARRAY) {
                this.mCookies = new HashMap();
            }
            for (String str2 : str.split(";")) {
                String[] split = str2.split("=");
                if (split.length >= 2) {
                    this.mCookies.put(split[0], split[1]);
                }
            }
        } catch (Exception e) {
            BdLog.w("addCookies Exception", e);
        }
    }

    public void addCookies(String str, String str2) {
        if (this.mCookies == NULL_ARRAY) {
            this.mCookies = new HashMap();
        }
        this.mCookies.put(str, str2);
    }

    public void setCookies(Map map) {
        this.mCookies = map;
    }

    public int getReadTimeOut() {
        return this.mReadTimeOut;
    }

    public void setReadTimeOut(int i) {
        this.mReadTimeOut = i;
    }

    public int getConnectionTimeOut() {
        return this.mConnectionTimeOut;
    }

    public void setConnectionTimeOut(int i) {
        this.mConnectionTimeOut = i;
    }

    public boolean isRedirect() {
        return this.mIsRedirect;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRedirect(boolean z) {
        this.mIsRedirect = z;
    }

    public boolean isFollowRedirects() {
        return this.mFollowRedirects;
    }

    public void setFollowRedirects(boolean z) {
        this.mFollowRedirects = z;
    }

    public void start() {
        if (this.mNet != null) {
            this.mIsStop = false;
            this.mNet.start(this);
        }
    }

    public synchronized boolean isStop() {
        return this.mIsStop;
    }

    public synchronized void stop() {
        try {
            this.mIsStop = true;
            if (this.mConnection != null) {
                this.mConnection.disconnect();
                this.mConnection = null;
            }
        } catch (Exception e) {
            BdLog.w("Stop Exception", e);
        }
    }

    public BdNet getNet() {
        return this.mNet;
    }

    public void setNet(BdNet bdNet) {
        this.mNet = bdNet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BdNetWorker getWorker() {
        return this.mNetWorker;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWorker(BdNetWorker bdNetWorker) {
        this.mNetWorker = bdNetWorker;
    }

    public HttpURLConnection getConnection() {
        return this.mConnection;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConnection(HttpURLConnection httpURLConnection) {
        this.mConnection = httpURLConnection;
    }
}
