package com.baidu.adp.lib.network;
/* loaded from: classes.dex */
public final class f {
    public String b;
    public byte[] d;
    public int a = 0;
    public h c = new h();
    public String e = "utf-8";

    public final String toString() {
        try {
            return new String(this.d, this.e);
        } catch (Exception e) {
            return "";
        }
    }
}
