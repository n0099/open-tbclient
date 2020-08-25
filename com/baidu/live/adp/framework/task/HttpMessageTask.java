package com.baidu.live.adp.framework.task;

import com.baidu.live.adp.framework.FrameHelper;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.settings.TimeOutData;
/* loaded from: classes7.dex */
public class HttpMessageTask extends MessageTask {
    private TimeOutData mConnectTimeOut;
    private HttpDownloadTask mDownloadTask;
    private boolean mIsImm;
    private HTTP_METHOD mMethod;
    private boolean mNeedGzip;
    private Class<? extends HttpResponsedMessage> mResponsedClass;
    private String mUrl;

    /* loaded from: classes7.dex */
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

    public HttpDownloadTask getDownloadTask() {
        return this.mDownloadTask;
    }

    public void setDownloadTask(HttpDownloadTask httpDownloadTask) {
        this.mDownloadTask = httpDownloadTask;
    }

    public Class<? extends HttpResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends HttpResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    @Override // com.baidu.live.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.checkHttpCmd(this.mCmd);
    }

    public TimeOutData getConnectTimeOut() {
        return this.mConnectTimeOut;
    }

    public void setConnectTimeOut(TimeOutData timeOutData) {
        this.mConnectTimeOut = timeOutData;
    }

    /* loaded from: classes7.dex */
    public static class HttpDownloadTask {
        private int mCmd;
        private String mDownloadPath;
        private boolean mIsOverWrite;

        public HttpDownloadTask(String str) {
            this.mCmd = 0;
            this.mIsOverWrite = false;
            this.mDownloadPath = str;
        }

        public HttpDownloadTask(int i, String str, boolean z) {
            this.mCmd = 0;
            this.mIsOverWrite = false;
            this.mCmd = i;
            this.mDownloadPath = str;
            this.mIsOverWrite = z;
        }

        public int getCmd() {
            return this.mCmd;
        }

        public void setCmd(int i) {
            this.mCmd = i;
        }

        public String getDownloadPath() {
            return this.mDownloadPath;
        }

        public void setDownloadPath(String str) {
            this.mDownloadPath = str;
        }

        public boolean getIsOverWrite() {
            return this.mIsOverWrite;
        }

        public void setIsOverWrite(boolean z) {
            this.mIsOverWrite = z;
        }
    }
}
