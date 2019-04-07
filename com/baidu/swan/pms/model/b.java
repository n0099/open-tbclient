package com.baidu.swan.pms.model;
/* loaded from: classes2.dex */
public class b {
    public String blY;
    public String errorMsg;
    public int errorNo;

    public b(int i, String str) {
        this(i, str, "");
    }

    public b(int i, String str, String str2) {
        this.errorNo = i;
        this.errorMsg = str;
        this.blY = str2;
    }

    public String toString() {
        return "ErrCode=" + this.errorNo + ",ErrMsg=" + this.errorMsg + ",TipMsg=" + this.blY;
    }
}
