package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class i {
    protected com.baidu.tbadk.core.util.aa Oi;
    protected NewErrorData Oj = null;

    public i() {
        this.Oi = null;
        this.Oi = new com.baidu.tbadk.core.util.aa();
    }

    public void cancel() {
        if (this.Oi != null) {
            this.Oi.hh();
        }
    }

    protected void setUrl(String str) {
        this.Oi.setUrl(str);
    }

    public void o(String str, String str2) {
        this.Oi.o(str, str2);
    }

    protected String pu() {
        String rO = this.Oi.rO();
        this.Oj = new NewErrorData();
        this.Oj.parserJson(rO);
        return rO;
    }

    public boolean pv() {
        if (this.Oi != null) {
            return this.Oi.sp().tq().pv();
        }
        return false;
    }

    public String pw() {
        if (this.Oi != null) {
            return this.Oi.getErrorString();
        }
        return null;
    }

    public int getErrorCode() {
        if (this.Oj != null) {
            return this.Oj.getErrorNumber();
        }
        return -1;
    }

    public String getErrorMsg() {
        if (this.Oj != null) {
            return this.Oj.getErrorMsg();
        }
        return null;
    }
}
