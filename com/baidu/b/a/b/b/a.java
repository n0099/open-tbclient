package com.baidu.b.a.b.b;
/* loaded from: classes2.dex */
public class a {
    public String Zv;
    public int code;
    public String errorMsg;
    public String packageName;

    public a(int i, String str, String str2) {
        this(null, i, str, str2);
    }

    public a(String str, int i, String str2, String str3) {
        this.code = i;
        this.packageName = str;
        this.errorMsg = str2;
        this.Zv = str3;
    }

    public String toString() {
        return "package=" + this.packageName + ",code=" + this.code + ",errMsg=" + this.errorMsg + ",tipMsg" + this.Zv;
    }
}
