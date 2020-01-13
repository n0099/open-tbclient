package com.baidu.swan.pms.model;
/* loaded from: classes10.dex */
public class a {
    public String cxh;
    public String errorMsg;
    public int errorNo;

    public a(int i, String str) {
        this(i, str, "");
    }

    public a(int i, String str, String str2) {
        this.errorNo = i;
        this.errorMsg = str;
        this.cxh = str2;
    }

    public String toString() {
        return "ErrCode=" + this.errorNo + ",ErrMsg=" + this.errorMsg + ",TipMsg=" + this.cxh;
    }
}
