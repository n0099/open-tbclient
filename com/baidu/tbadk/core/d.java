package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class d {
    protected NewErrorData ST = null;
    protected x mNetWork;

    public d() {
        this.mNetWork = null;
        this.mNetWork = new x();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.fo();
        }
    }

    protected void setUrl(String str) {
        this.mNetWork.setUrl(str);
    }

    public void n(String str, String str2) {
        this.mNetWork.n(str, str2);
    }

    protected String getResult() {
        String up = this.mNetWork.up();
        this.ST = new NewErrorData();
        this.ST.parserJson(up);
        return up;
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.uN().vL().isRequestSuccess();
        }
        return false;
    }

    public String oR() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
