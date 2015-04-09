package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class i {
    protected com.baidu.tbadk.core.util.aa Ok;
    protected NewErrorData Ol = null;

    public i() {
        this.Ok = null;
        this.Ok = new com.baidu.tbadk.core.util.aa();
    }

    public void cancel() {
        if (this.Ok != null) {
            this.Ok.hh();
        }
    }

    protected void setUrl(String str) {
        this.Ok.setUrl(str);
    }

    public void o(String str, String str2) {
        this.Ok.o(str, str2);
    }

    protected String pu() {
        String rO = this.Ok.rO();
        this.Ol = new NewErrorData();
        this.Ol.parserJson(rO);
        return rO;
    }

    public boolean pv() {
        if (this.Ok != null) {
            return this.Ok.sp().tq().pv();
        }
        return false;
    }

    public String pw() {
        if (this.Ok != null) {
            return this.Ok.getErrorString();
        }
        return null;
    }

    public int getErrorCode() {
        if (this.Ol != null) {
            return this.Ol.getErrorNumber();
        }
        return -1;
    }

    public String getErrorMsg() {
        if (this.Ol != null) {
            return this.Ol.getErrorMsg();
        }
        return null;
    }
}
