package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class i {
    protected com.baidu.tbadk.core.util.ab Ty;
    protected NewErrorData Tz = null;

    public i() {
        this.Ty = null;
        this.Ty = new com.baidu.tbadk.core.util.ab();
    }

    public void cancel() {
        if (this.Ty != null) {
            this.Ty.gL();
        }
    }

    protected void setUrl(String str) {
        this.Ty.setUrl(str);
    }

    public void o(String str, String str2) {
        this.Ty.o(str, str2);
    }

    protected String re() {
        String ul = this.Ty.ul();
        this.Tz = new NewErrorData();
        this.Tz.parserJson(ul);
        return ul;
    }

    public boolean rf() {
        if (this.Ty != null) {
            return this.Ty.uM().vG().rf();
        }
        return false;
    }

    public String rg() {
        if (this.Ty != null) {
            return this.Ty.getErrorString();
        }
        return null;
    }

    public int getErrorCode() {
        if (this.Tz != null) {
            return this.Tz.getErrorNumber();
        }
        return -1;
    }

    public String getErrorMsg() {
        if (this.Tz != null) {
            return this.Tz.getErrorMsg();
        }
        return null;
    }
}
