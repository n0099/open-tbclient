package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class h {
    protected com.baidu.tbadk.core.util.z Ob;
    protected NewErrorData Oc = null;

    public h() {
        this.Ob = null;
        this.Ob = new com.baidu.tbadk.core.util.z();
    }

    public void cancel() {
        if (this.Ob != null) {
            this.Ob.eg();
        }
    }

    protected void setUrl(String str) {
        this.Ob.setUrl(str);
    }

    public void n(String str, String str2) {
        this.Ob.n(str, str2);
    }

    protected String getResult() {
        String uy = this.Ob.uy();
        this.Oc = new NewErrorData();
        this.Oc.parserJson(uy);
        return uy;
    }

    public boolean oH() {
        if (this.Ob != null) {
            return this.Ob.uW().vS().oH();
        }
        return false;
    }

    public String oI() {
        if (this.Ob != null) {
            return this.Ob.getErrorString();
        }
        return null;
    }
}
