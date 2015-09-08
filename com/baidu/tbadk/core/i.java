package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class i {
    protected com.baidu.tbadk.core.util.v Tv;
    protected NewErrorData Tw = null;

    public i() {
        this.Tv = null;
        this.Tv = new com.baidu.tbadk.core.util.v();
    }

    public void cancel() {
        if (this.Tv != null) {
            this.Tv.gJ();
        }
    }

    protected void setUrl(String str) {
        this.Tv.setUrl(str);
    }

    public void o(String str, String str2) {
        this.Tv.o(str, str2);
    }

    protected String qY() {
        String tI = this.Tv.tI();
        this.Tw = new NewErrorData();
        this.Tw.parserJson(tI);
        return tI;
    }

    public boolean qZ() {
        if (this.Tv != null) {
            return this.Tv.uj().va().qZ();
        }
        return false;
    }

    public String ra() {
        if (this.Tv != null) {
            return this.Tv.getErrorString();
        }
        return null;
    }

    public int getErrorCode() {
        if (this.Tw != null) {
            return this.Tw.getErrorNumber();
        }
        return -1;
    }

    public String getErrorMsg() {
        if (this.Tw != null) {
            return this.Tw.getErrorMsg();
        }
        return null;
    }
}
