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

    protected String qR() {
        String tD = this.Ti.tD();
        this.Tj = new NewErrorData();
        this.Tj.parserJson(tD);
        return tD;
    }

    public boolean qS() {
        if (this.Ti != null) {
            return this.Ti.ue().uW().qS();
        }
        return false;
    }

    public String qT() {
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
