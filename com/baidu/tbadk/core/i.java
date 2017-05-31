package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class i {
    protected NewErrorData RM = null;
    protected com.baidu.tbadk.core.util.z mNetWork;

    public i() {
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
        String ug = this.mNetWork.ug();
        this.RM = new NewErrorData();
        this.RM.parserJson(ug);
        return ug;
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.uF().vB().isRequestSuccess();
        }
        return false;
    }

    public String oL() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
