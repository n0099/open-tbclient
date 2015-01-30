package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.c.e;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public class HttpMessageTask extends MessageTask {
    private e mConnectTimeOut;
    private boolean mIsImm;
    private HTTP_METHOD mMethod;
    private boolean mNeedGzip;
    private Class<? extends HttpResponsedMessage> mResponsedClass;
    private String mUrl;

    /* loaded from: classes.dex */
    public enum HTTP_METHOD {
        GET,
        POST;

        /* JADX DEBUG: Replace access to removed values field (fq) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static HTTP_METHOD[] valuesCustom() {
            HTTP_METHOD[] valuesCustom = values();
            int length = valuesCustom.length;
            HTTP_METHOD[] http_methodArr = new HTTP_METHOD[length];
            System.arraycopy(valuesCustom, 0, http_methodArr, 0, length);
            return http_methodArr;
        }
    }

    public HttpMessageTask(int i, String str) {
        super(i);
        this.mConnectTimeOut = null;
        this.mUrl = null;
        this.mMethod = HTTP_METHOD.POST;
        this.mNeedGzip = true;
        this.mIsImm = false;
        this.mUrl = str;
        this.mPriority = 1;
    }

    public String getUrl() {
        return this.mUrl;
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

    public Class<? extends HttpResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends HttpResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.q(this.mCmd);
    }

    public e getConnectTimeOut() {
        return this.mConnectTimeOut;
    }

    public void setConnectTimeOut(e eVar) {
        this.mConnectTimeOut = eVar;
    }
}
