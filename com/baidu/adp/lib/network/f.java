package com.baidu.adp.lib.network;
/* loaded from: classes.dex */
public class f {
    public String b;
    public byte[] d;
    public int a = 0;
    public h c = new h();
    public String e = "utf-8";

    public String toString() {
        try {
            return new String(this.d, this.e);
        } catch (Exception e) {
            return "";
        }
    }
}
