package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
public class h {
    protected com.baidu.tbadk.core.util.ab LL;
    protected NewErrorData LM = null;

    public h() {
        this.LL = null;
        this.LL = new com.baidu.tbadk.core.util.ab();
    }

    public void cancel() {
        if (this.LL != null) {
            this.LL.dl();
        }
    }

    protected void setUrl(String str) {
        this.LL.setUrl(str);
    }

    public void n(String str, String str2) {
        this.LL.n(str, str2);
    }

    protected String getResult() {
        String tc = this.LL.tc();
        this.LM = new NewErrorData();
        this.LM.parserJson(tc);
        return tc;
    }

    public boolean nZ() {
        if (this.LL != null) {
            return this.LL.tA().uv().nZ();
        }
        return false;
    }

    public String oa() {
        if (this.LL != null) {
            return this.LL.getErrorString();
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
