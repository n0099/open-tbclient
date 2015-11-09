package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class i {
    protected com.baidu.tbadk.core.util.w Tj;
    protected NewErrorData Tk = null;

    public i() {
        this.Tj = null;
        this.Tj = new com.baidu.tbadk.core.util.w();
    }

    public void cancel() {
        if (this.Tj != null) {
            this.Tj.gJ();
        }
    }

    protected void setUrl(String str) {
        this.Tj.setUrl(str);
    }

    public void o(String str, String str2) {
        this.Tj.o(str, str2);
    }

    protected String qS() {
        String tG = this.Tj.tG();
        this.Tk = new NewErrorData();
        this.Tk.parserJson(tG);
        return tG;
    }

    public boolean qT() {
        if (this.Tj != null) {
            return this.Tj.uh().va().qT();
        }
        return false;
    }

    public String qU() {
        if (this.Tj != null) {
            return this.Tj.getErrorString();
        }
        return null;
    }

    public int getErrorCode() {
        if (this.Tk != null) {
            return this.Tk.getErrorNumber();
        }
        return -1;
    }

    public String getErrorMsg() {
        if (this.Tk != null) {
            return this.Tk.getErrorMsg();
        }
        return null;
    }
}
