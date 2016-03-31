package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class h {
    protected com.baidu.tbadk.core.util.ab QV;
    protected NewErrorData QW = null;

    public h() {
        this.QV = null;
        this.QV = new com.baidu.tbadk.core.util.ab();
    }

    public void cancel() {
        if (this.QV != null) {
            this.QV.gX();
        }
    }

    protected void setUrl(String str) {
        this.QV.setUrl(str);
    }

    public void p(String str, String str2) {
        this.QV.p(str, str2);
    }

    protected String getResult() {
        String vw = this.QV.vw();
        this.QW = new NewErrorData();
        this.QW.parserJson(vw);
        return vw;
    }

    public boolean qC() {
        if (this.QV != null) {
            return this.QV.vU().wP().qC();
        }
        return false;
    }

    public String qD() {
        if (this.QV != null) {
            return this.QV.getErrorString();
        }
        return null;
    }

    public int getErrorCode() {
        if (this.QW != null) {
            return this.QW.getErrorNumber();
        }
        return -1;
    }

    public String getErrorMsg() {
        if (this.QW != null) {
            return this.QW.getErrorMsg();
        }
        return null;
    }
}
