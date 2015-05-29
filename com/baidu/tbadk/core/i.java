package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class i {
    protected com.baidu.tbadk.core.util.aa OE;
    protected NewErrorData OF = null;

    public i() {
        this.OE = null;
        this.OE = new com.baidu.tbadk.core.util.aa();
    }

    public void cancel() {
        if (this.OE != null) {
            this.OE.gS();
        }
    }

    protected void setUrl(String str) {
        this.OE.setUrl(str);
    }

    public void o(String str, String str2) {
        this.OE.o(str, str2);
    }

    protected String pZ() {
        String sw = this.OE.sw();
        this.OF = new NewErrorData();
        this.OF.parserJson(sw);
        return sw;
    }

    public boolean qa() {
        if (this.OE != null) {
            return this.OE.sX().tT().qa();
        }
        return false;
    }

    public String qb() {
        if (this.OE != null) {
            return this.OE.getErrorString();
        }
        return null;
    }

    public int getErrorCode() {
        if (this.OF != null) {
            return this.OF.getErrorNumber();
        }
        return -1;
    }

    public String getErrorMsg() {
        if (this.OF != null) {
            return this.OF.getErrorMsg();
        }
        return null;
    }
}
