package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class d {
    protected NewErrorData bvo = null;
    protected x mNetWork;

    public d() {
        this.mNetWork = null;
        this.mNetWork = new x();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.ji();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.mNetWork.setUrl(str);
    }

    public void x(String str, String str2) {
        this.mNetWork.x(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String acg = this.mNetWork.acg();
        this.bvo = new NewErrorData();
        this.bvo.parserJson(acg);
        return acg;
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.acE().adD().isRequestSuccess();
        }
        return false;
    }

    public String Wt() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
