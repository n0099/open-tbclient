package com.baidu.adp.framework.task;

import android.net.Uri;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.kwai.video.player.KsMediaMeta;
import d.b.b.c.j.e;
/* loaded from: classes.dex */
public class HttpMessageTask extends MessageTask {
    public e mConnectTimeOut;
    public a mDownloadTask;
    public boolean mIsImm;
    public HTTP_METHOD mMethod;
    public boolean mNeedGzip;
    public Class<? extends HttpResponsedMessage> mResponsedClass;
    public String mUrl;

    /* loaded from: classes.dex */
    public enum HTTP_METHOD {
        GET,
        POST
    }

    /* loaded from: classes.dex */
    public static class a {
        public abstract int a();

        public abstract String b();

        public abstract boolean c();
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
        addProtobufSuffix();
        this.mPriority = 1;
    }

    private void addProtobufSuffix() {
        if (StringUtils.isNull(this.mUrl)) {
            return;
        }
        Uri parse = Uri.parse(this.mUrl);
        if (StringUtils.isNull(parse.getQueryParameter("cmd")) || !StringUtils.isNull(parse.getQueryParameter(KsMediaMeta.KSM_KEY_FORMAT))) {
            return;
        }
        this.mUrl = parse.buildUpon().appendQueryParameter(KsMediaMeta.KSM_KEY_FORMAT, "protobuf").toString();
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.b(this.mCmd);
    }

    public e getConnectTimeOut() {
        return this.mConnectTimeOut;
    }

    public a getDownloadTask() {
        return this.mDownloadTask;
    }

    public boolean getIsImm() {
        return this.mIsImm;
    }

    public HTTP_METHOD getMethod() {
        return this.mMethod;
    }

    public Class<? extends HttpResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean isNeedGzip() {
        return this.mNeedGzip;
    }

    public void setConnectTimeOut(e eVar) {
        this.mConnectTimeOut = eVar;
    }

    public void setDownloadTask(a aVar) {
        this.mDownloadTask = aVar;
    }

    public void setIsImm(boolean z) {
        this.mIsImm = z;
    }

    public void setMethod(HTTP_METHOD http_method) {
        this.mMethod = http_method;
    }

    public void setNeedGzip(boolean z) {
        this.mNeedGzip = z;
    }

    public void setResponsedClass(Class<? extends HttpResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public String setUrl(String str) {
        String str2 = this.mUrl;
        this.mUrl = str;
        addProtobufSuffix();
        return str2;
    }
}
