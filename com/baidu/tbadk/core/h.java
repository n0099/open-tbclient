package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class h {
    protected NewErrorData Sn = null;
    protected com.baidu.tbadk.core.util.z mNetWork;

    public h() {
        this.mNetWork = null;
        this.mNetWork = new com.baidu.tbadk.core.util.z();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.fm();
        }
    }

    protected void setUrl(String str) {
        this.mNetWork.setUrl(str);
    }

    public void n(String str, String str2) {
        this.mNetWork.n(str, str2);
    }

    protected String getResult() {
        String uB = this.mNetWork.uB();
        this.Sn = new NewErrorData();
        this.Sn.parserJson(uB);
        return uB;
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.uZ().vT().isRequestSuccess();
        }
        return false;
    }

    public String oP() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
