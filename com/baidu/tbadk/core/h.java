package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class h {
    protected com.baidu.tbadk.core.util.ab LI;
    protected NewErrorData LJ = null;

    public h() {
        this.LI = null;
        this.LI = new com.baidu.tbadk.core.util.ab();
    }

    public void cancel() {
        if (this.LI != null) {
            this.LI.dl();
        }
    }

    protected void setUrl(String str) {
        this.LI.setUrl(str);
    }

    public void n(String str, String str2) {
        this.LI.n(str, str2);
    }

    protected String getResult() {
        String sZ = this.LI.sZ();
        this.LJ = new NewErrorData();
        this.LJ.parserJson(sZ);
        return sZ;
    }

    public boolean nJ() {
        if (this.LI != null) {
            return this.LI.tx().uv().nJ();
        }
        return false;
    }

    public String nK() {
        if (this.LI != null) {
            return this.LI.getErrorString();
        }
        return null;
    }
}
