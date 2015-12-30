package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class i {
    protected com.baidu.tbadk.core.util.ab Ua;
    protected NewErrorData Ub = null;

    public i() {
        this.Ua = null;
        this.Ua = new com.baidu.tbadk.core.util.ab();
    }

    public void cancel() {
        if (this.Ua != null) {
            this.Ua.gL();
        }
    }

    protected void setUrl(String str) {
        this.Ua.setUrl(str);
    }

    public void o(String str, String str2) {
        this.Ua.o(str, str2);
    }

    protected String qN() {
        String tV = this.Ua.tV();
        this.Ub = new NewErrorData();
        this.Ub.parserJson(tV);
        return tV;
    }

    public boolean qO() {
        if (this.Ua != null) {
            return this.Ua.uw().vq().qO();
        }
        return false;
    }

    public String qP() {
        if (this.Ua != null) {
            return this.Ua.getErrorString();
        }
        return null;
    }

    public int getErrorCode() {
        if (this.Ub != null) {
            return this.Ub.getErrorNumber();
        }
        return -1;
    }

    public String getErrorMsg() {
        if (this.Ub != null) {
            return this.Ub.getErrorMsg();
        }
        return null;
    }
}
