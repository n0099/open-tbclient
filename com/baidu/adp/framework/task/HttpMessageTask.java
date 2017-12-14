package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.c.e;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public class HttpMessageTask extends MessageTask {
    private e mConnectTimeOut;
    private a mDownloadTask;
    private boolean mIsImm;
    private HTTP_METHOD mMethod;
    private boolean mNeedGzip;
    private Class<? extends HttpResponsedMessage> mResponsedClass;
    private String mUrl;

    /* loaded from: classes.dex */
    public enum HTTP_METHOD {
        GET,
        POST
    }

    public HttpMessageTask(int i, String str) {
        super(i);
        this.mConnectTimeOut = null;
        this.mUrl = null;
        this.mMethod = HTTP_METHOD.POST;
        this.mNeedGzip = true;
        this.mIsImm = false;
        this.mDownloadTask = null;
        this.mUrl = str;
        this.mPriority = 1;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String setUrl(String str) {
        String str2 = this.mUrl;
        this.mUrl = str;
        return str2;
    }

    public HTTP_METHOD getMethod() {
        return this.mMethod;
    }

    public void setMethod(HTTP_METHOD http_method) {
        this.mMethod = http_method;
    }

    public boolean isNeedGzip() {
        return this.mNeedGzip;
    }

    public void setNeedGzip(boolean z) {
        this.mNeedGzip = z;
    }

    public boolean getIsImm() {
        return this.mIsImm;
    }

    public void setIsImm(boolean z) {
        this.mIsImm = z;
    }

    public a getDownloadTask() {
        return this.mDownloadTask;
    }

    public void setDownloadTask(a aVar) {
        this.mDownloadTask = aVar;
    }

    public Class<? extends HttpResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends HttpResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.H(this.mCmd);
    }

    public e getConnectTimeOut() {
        return this.mConnectTimeOut;
    }

    public void setConnectTimeOut(e eVar) {
        this.mConnectTimeOut = eVar;
    }

    /* loaded from: classes.dex */
    public static class a {
        private int mCmd;
        private String qA;
        private boolean qB;

        public int getCmd() {
            return this.mCmd;
        }

        public String dx() {
            return this.qA;
        }

        public boolean dy() {
            return this.qB;
        }
    }
}
