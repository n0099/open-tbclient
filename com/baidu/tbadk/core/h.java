package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class h {
    protected NewErrorData Nj = null;
    protected com.baidu.tbadk.core.util.y mNetWork;

    public h() {
        this.mNetWork = null;
        this.mNetWork = new com.baidu.tbadk.core.util.y();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.ee();
        }
    }

    protected void setUrl(String str) {
        this.mNetWork.setUrl(str);
    }

    public void n(String str, String str2) {
        this.mNetWork.n(str, str2);
    }

    protected String getResult() {
        String ud = this.mNetWork.ud();
        this.Nj = new NewErrorData();
        this.Nj.parserJson(ud);
        return ud;
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.uC().vw().isRequestSuccess();
        }
        return false;
    }

    public String oB() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
