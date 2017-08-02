package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public class d {
    protected NewErrorData RV = null;
    protected w mNetWork;

    public d() {
        this.mNetWork = null;
        this.mNetWork = new w();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.fp();
        }
    }

    protected void setUrl(String str) {
        this.mNetWork.setUrl(str);
    }

    public void n(String str, String str2) {
        this.mNetWork.n(str, str2);
    }

    protected String getResult() {
        String uE = this.mNetWork.uE();
        this.RV = new NewErrorData();
        this.RV.parserJson(uE);
        return uE;
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.vb().vY().isRequestSuccess();
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
