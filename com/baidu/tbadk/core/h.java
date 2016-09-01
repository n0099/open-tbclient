package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class h {
    protected com.baidu.tbadk.core.util.ab NX;
    protected NewErrorData NY = null;

    public h() {
        this.NX = null;
        this.NX = new com.baidu.tbadk.core.util.ab();
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
        String ue = this.NX.ue();
        this.NY = new NewErrorData();
        this.NY.parserJson(ue);
        return ue;
    }

    public boolean oE() {
        if (this.NX != null) {
            return this.NX.uD().vA().oE();
        }
        return false;
    }

    public String oF() {
        if (this.NX != null) {
            return this.NX.getErrorString();
        }
        return null;
    }
}
