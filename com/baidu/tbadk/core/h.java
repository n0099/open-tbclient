package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.ad;
/* loaded from: classes.dex */
public class h {
    protected ad AO;
    protected NewErrorData Cy = null;

    public h() {
        this.AO = null;
        this.AO = new ad();
    }

    public void cancel() {
        if (this.AO != null) {
            this.AO.dJ();
        }
    }

    protected void setUrl(String str) {
        this.AO.setUrl(str);
    }

    public void o(String str, String str2) {
        this.AO.o(str, str2);
    }

    protected String lS() {
        String or = this.AO.or();
        this.Cy = new NewErrorData();
        this.Cy.parserJson(or);
        return or;
    }

    public boolean lT() {
        if (this.AO != null) {
            return this.AO.oS().qa().lT();
        }
        return false;
    }

    public String lU() {
        if (this.AO != null) {
            return this.AO.getErrorString();
        }
        return null;
    }

    public int getErrorCode() {
        if (this.Cy != null) {
            return this.Cy.getErrorNumber();
        }
        return -1;
    }

    public String getErrorMsg() {
        if (this.Cy != null) {
            return this.Cy.getErrorMsg();
        }
        return null;
    }
}
