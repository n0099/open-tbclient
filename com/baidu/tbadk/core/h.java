package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class h {
    protected com.baidu.tbadk.core.util.ab LK;
    protected NewErrorData LM = null;

    public h() {
        this.LK = null;
        this.LK = new com.baidu.tbadk.core.util.ab();
    }

    public void cancel() {
        if (this.LK != null) {
            this.LK.dm();
        }
    }

    protected void setUrl(String str) {
        this.LK.setUrl(str);
    }

    public void n(String str, String str2) {
        this.LK.n(str, str2);
    }

    protected String getResult() {
        String ta = this.LK.ta();
        this.LM = new NewErrorData();
        this.LM.parserJson(ta);
        return ta;
    }

    public boolean nU() {
        if (this.LK != null) {
            return this.LK.ty().uv().nU();
        }
        return false;
    }

    public String nV() {
        if (this.LK != null) {
            return this.LK.getErrorString();
        }
        return null;
    }

    public int getErrorCode() {
        if (this.LM != null) {
            return this.LM.getErrorNumber();
        }
        return -1;
    }

    public String getErrorMsg() {
        if (this.LM != null) {
            return this.LM.getErrorMsg();
        }
        return null;
    }
}
