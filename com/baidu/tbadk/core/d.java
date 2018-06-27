package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes.dex */
public class d {
    protected NewErrorData acD = null;
    protected y mNetWork;

    public d() {
        this.mNetWork = null;
        this.mNetWork = new y();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.hN();
        }
    }

    protected void setUrl(String str) {
        this.mNetWork.setUrl(str);
    }

    public void o(String str, String str2) {
        this.mNetWork.o(str, str2);
    }

    protected String getResult() {
        String yz = this.mNetWork.yz();
        this.acD = new NewErrorData();
        this.acD.parserJson(yz);
        return yz;
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.yX().zY().isRequestSuccess();
        }
        return false;
    }

    public String tr() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
