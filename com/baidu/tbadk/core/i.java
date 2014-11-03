package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.ac;
/* loaded from: classes.dex */
public class i {
    protected ac mNetWork;
    protected NewErrorData yH = null;

    public i() {
        this.mNetWork = null;
        this.mNetWork = new ac();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.mNetWork.setUrl(str);
    }

    public void k(String str, String str2) {
        this.mNetWork.k(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String jp() {
        String lA = this.mNetWork.lA();
        this.yH = new NewErrorData();
        this.yH.parserJson(lA);
        return lA;
    }

    public boolean jq() {
        if (this.mNetWork != null) {
            return this.mNetWork.mc().nb().jq();
        }
        return false;
    }

    public String jr() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }

    public int getErrorCode() {
        if (this.yH != null) {
            return this.yH.getErrorNumber();
        }
        return -1;
    }

    public String getErrorMsg() {
        if (this.yH != null) {
            return this.yH.getErrorMsg();
        }
        return null;
    }
}
