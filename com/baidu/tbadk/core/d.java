package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class d {
    protected NewErrorData aoz = null;
    protected x mNetWork;

    public d() {
        this.mNetWork = null;
        this.mNetWork = new x();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.jg();
        }
    }

    protected void setUrl(String str) {
        this.mNetWork.setUrl(str);
    }

    public void x(String str, String str2) {
        this.mNetWork.x(str, str2);
    }

    protected String getResult() {
        String CY = this.mNetWork.CY();
        this.aoz = new NewErrorData();
        this.aoz.parserJson(CY);
        return CY;
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.Dw().Ev().isRequestSuccess();
        }
        return false;
    }

    public String xP() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
