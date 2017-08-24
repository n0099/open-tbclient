package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public class d {
    protected NewErrorData Tv = null;
    protected w mNetWork;

    public d() {
        this.mNetWork = null;
        this.mNetWork = new w();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.fA();
        }
    }

    protected void setUrl(String str) {
        this.mNetWork.setUrl(str);
    }

    public void n(String str, String str2) {
        this.mNetWork.n(str, str2);
    }

    protected String getResult() {
        String uP = this.mNetWork.uP();
        this.Tv = new NewErrorData();
        this.Tv.parserJson(uP);
        return uP;
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.vm().wj().isRequestSuccess();
        }
        return false;
    }

    public String oW() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
