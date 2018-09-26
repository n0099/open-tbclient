package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class d {
    protected NewErrorData aeK = null;
    protected x mNetWork;

    public d() {
        this.mNetWork = null;
        this.mNetWork = new x();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.iT();
        }
    }

    protected void setUrl(String str) {
        this.mNetWork.setUrl(str);
    }

    public void u(String str, String str2) {
        this.mNetWork.u(str, str2);
    }

    protected String getResult() {
        String zt = this.mNetWork.zt();
        this.aeK = new NewErrorData();
        this.aeK.parserJson(zt);
        return zt;
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.zR().AQ().isRequestSuccess();
        }
        return false;
    }

    public String uh() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
