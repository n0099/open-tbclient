package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.ad;
/* loaded from: classes.dex */
public class h {
    protected ad AR;
    protected NewErrorData CB = null;

    public h() {
        this.AR = null;
        this.AR = new ad();
    }

    public void cancel() {
        if (this.AR != null) {
            this.AR.dL();
        }
    }

    protected void setUrl(String str) {
        this.AR.setUrl(str);
    }

    public void o(String str, String str2) {
        this.AR.o(str, str2);
    }

    protected String lZ() {
        String ov = this.AR.ov();
        this.CB = new NewErrorData();
        this.CB.parserJson(ov);
        return ov;
    }

    public boolean ma() {
        if (this.AR != null) {
            return this.AR.oW().pW().ma();
        }
        return false;
    }

    public String mb() {
        if (this.AR != null) {
            return this.AR.getErrorString();
        }
        return null;
    }

    public int getErrorCode() {
        if (this.CB != null) {
            return this.CB.getErrorNumber();
        }
        return -1;
    }

    public String getErrorMsg() {
        if (this.CB != null) {
            return this.CB.getErrorMsg();
        }
        return null;
    }
}
