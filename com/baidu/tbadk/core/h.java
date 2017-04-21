package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class h {
    protected NewErrorData SH = null;
    protected com.baidu.tbadk.core.util.z mNetWork;

    public h() {
        this.mNetWork = null;
        this.mNetWork = new com.baidu.tbadk.core.util.z();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.fs();
        }
    }

    protected void setUrl(String str) {
        this.mNetWork.setUrl(str);
    }

    public void n(String str, String str2) {
        this.mNetWork.n(str, str2);
    }

    protected String getResult() {
        String uY = this.mNetWork.uY();
        this.SH = new NewErrorData();
        this.SH.parserJson(uY);
        return uY;
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.vw().wq().isRequestSuccess();
        }
        return false;
    }

    public String pm() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
