package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class i {
    protected com.baidu.tbadk.core.util.w Th;
    protected NewErrorData Ti = null;

    public i() {
        this.Th = null;
        this.Th = new com.baidu.tbadk.core.util.w();
    }

    public void cancel() {
        if (this.Th != null) {
            this.Th.gJ();
        }
    }

    protected void setUrl(String str) {
        this.Th.setUrl(str);
    }

    public void o(String str, String str2) {
        this.Th.o(str, str2);
    }

    protected String qU() {
        String tG = this.Th.tG();
        this.Ti = new NewErrorData();
        this.Ti.parserJson(tG);
        return tG;
    }

    public boolean qV() {
        if (this.Th != null) {
            return this.Th.uh().uY().qV();
        }
        return false;
    }

    public String qW() {
        if (this.Th != null) {
            return this.Th.getErrorString();
        }
        return null;
    }

    public int getErrorCode() {
        if (this.Ti != null) {
            return this.Ti.getErrorNumber();
        }
        return -1;
    }

    public String getErrorMsg() {
        if (this.Ti != null) {
            return this.Ti.getErrorMsg();
        }
        return null;
    }
}
