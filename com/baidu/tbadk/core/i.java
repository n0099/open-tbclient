package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class i {
    protected com.baidu.tbadk.core.util.w Ti;
    protected NewErrorData Tj = null;

    public i() {
        this.Ti = null;
        this.Ti = new com.baidu.tbadk.core.util.w();
    }

    public void cancel() {
        if (this.Ti != null) {
            this.Ti.gJ();
        }
    }

    protected void setUrl(String str) {
        this.Ti.setUrl(str);
    }

    public void o(String str, String str2) {
        this.Ti.o(str, str2);
    }

    protected String qU() {
        String tG = this.Ti.tG();
        this.Tj = new NewErrorData();
        this.Tj.parserJson(tG);
        return tG;
    }

    public boolean qV() {
        if (this.Ti != null) {
            return this.Ti.uh().uZ().qV();
        }
        return false;
    }

    public String qW() {
        if (this.Ti != null) {
            return this.Ti.getErrorString();
        }
        return null;
    }

    public int getErrorCode() {
        if (this.Tj != null) {
            return this.Tj.getErrorNumber();
        }
        return -1;
    }

    public String getErrorMsg() {
        if (this.Tj != null) {
            return this.Tj.getErrorMsg();
        }
        return null;
    }
}
