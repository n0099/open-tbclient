package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class h {
    protected com.baidu.tbadk.core.util.z NX;
    protected NewErrorData NY = null;

    public h() {
        this.NX = null;
        this.NX = new com.baidu.tbadk.core.util.z();
    }

    public void cancel() {
        if (this.NX != null) {
            this.NX.eg();
        }
    }

    protected void setUrl(String str) {
        this.NX.setUrl(str);
    }

    public void n(String str, String str2) {
        this.NX.n(str, str2);
    }

    protected String getResult() {
        String uk = this.NX.uk();
        this.NY = new NewErrorData();
        this.NY.parserJson(uk);
        return uk;
    }

    public boolean oH() {
        if (this.NX != null) {
            return this.NX.uI().vC().oH();
        }
        return false;
    }

    public String oI() {
        if (this.NX != null) {
            return this.NX.getErrorString();
        }
        return null;
    }
}
