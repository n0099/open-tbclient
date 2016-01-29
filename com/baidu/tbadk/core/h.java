package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class h {
    protected com.baidu.tbadk.core.util.aa Ty;
    protected NewErrorData Tz = null;

    public h() {
        this.Ty = null;
        this.Ty = new com.baidu.tbadk.core.util.aa();
    }

    public void cancel() {
        if (this.Ty != null) {
            this.Ty.gT();
        }
    }

    protected void setUrl(String str) {
        this.Ty.setUrl(str);
    }

    public void p(String str, String str2) {
        this.Ty.p(str, str2);
    }

    protected String getResult() {
        String uZ = this.Ty.uZ();
        this.Tz = new NewErrorData();
        this.Tz.parserJson(uZ);
        return uZ;
    }

    public boolean rl() {
        if (this.Ty != null) {
            return this.Ty.vB().ww().rl();
        }
        return false;
    }

    public String rm() {
        if (this.Ty != null) {
            return this.Ty.getErrorString();
        }
        return null;
    }

    public int getErrorCode() {
        if (this.Tz != null) {
            return this.Tz.getErrorNumber();
        }
        return -1;
    }

    public String getErrorMsg() {
        if (this.Tz != null) {
            return this.Tz.getErrorMsg();
        }
        return null;
    }
}
