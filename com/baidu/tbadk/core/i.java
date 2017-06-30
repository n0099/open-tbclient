package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class i {
    protected NewErrorData RH = null;
    protected com.baidu.tbadk.core.util.ab mNetWork;

    public i() {
        this.mNetWork = null;
        this.mNetWork = new com.baidu.tbadk.core.util.ab();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.fr();
        }
    }

    protected void setUrl(String str) {
        this.mNetWork.setUrl(str);
    }

    public void n(String str, String str2) {
        this.mNetWork.n(str, str2);
    }

    protected String getResult() {
        String uy = this.mNetWork.uy();
        this.RH = new NewErrorData();
        this.RH.parserJson(uy);
        return uy;
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.uV().vS().isRequestSuccess();
        }
        return false;
    }

    public String oI() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
