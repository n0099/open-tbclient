package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class h {
    protected com.baidu.tbadk.core.util.ab NY;
    protected NewErrorData NZ = null;

    public h() {
        this.NY = null;
        this.NY = new com.baidu.tbadk.core.util.ab();
    }

    public void cancel() {
        if (this.NY != null) {
            this.NY.eg();
        }
    }

    protected void setUrl(String str) {
        this.NY.setUrl(str);
    }

    public void n(String str, String str2) {
        this.NY.n(str, str2);
    }

    protected String getResult() {
        String uu = this.NY.uu();
        this.NZ = new NewErrorData();
        this.NZ.parserJson(uu);
        return uu;
    }

    public boolean oF() {
        if (this.NY != null) {
            return this.NY.uS().vO().oF();
        }
        return false;
    }

    public String oG() {
        if (this.NY != null) {
            return this.NY.getErrorString();
        }
        return null;
    }
}
