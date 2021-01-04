package com.baidu.swan.pms.model;
/* loaded from: classes6.dex */
public class a {
    public String errorMsg;
    public int errorNo;
    public String ewK;

    public a(int i, String str) {
        this(i, str, "");
    }

    public a(int i, String str, String str2) {
        this.errorNo = i;
        this.errorMsg = str;
        this.ewK = str2;
    }

    public String toString() {
        return "ErrCode=" + this.errorNo + ",ErrMsg=" + this.errorMsg + ",TipMsg=" + this.ewK;
    }
}
