package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class i {
    protected com.baidu.tbadk.core.util.v Tu;
    protected NewErrorData Tv = null;

    public i() {
        this.Tu = null;
        this.Tu = new com.baidu.tbadk.core.util.v();
    }

    public void cancel() {
        if (this.Tu != null) {
            this.Tu.gM();
        }
    }

    protected void setUrl(String str) {
        this.Tu.setUrl(str);
    }

    public void o(String str, String str2) {
        this.Tu.o(str, str2);
    }

    protected String ra() {
        String tD = this.Tu.tD();
        this.Tv = new NewErrorData();
        this.Tv.parserJson(tD);
        return tD;
    }

    public boolean rb() {
        if (this.Tu != null) {
            return this.Tu.ue().uW().rb();
        }
        return false;
    }

    public String rc() {
        if (this.Tu != null) {
            return this.Tu.getErrorString();
        }
        return null;
    }

    public int getErrorCode() {
        if (this.Tv != null) {
            return this.Tv.getErrorNumber();
        }
        return -1;
    }

    public String getErrorMsg() {
        if (this.Tv != null) {
            return this.Tv.getErrorMsg();
        }
        return null;
    }
}
