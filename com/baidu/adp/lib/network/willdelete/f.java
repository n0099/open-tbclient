package com.baidu.adp.lib.network.willdelete;
/* loaded from: classes.dex */
public class f {
    public byte[] data;
    public String kW;
    public int kV = 0;
    public com.baidu.adp.lib.network.http.d kX = new com.baidu.adp.lib.network.http.d();
    public String charset = "utf-8";

    public String toString() {
        try {
            return new String(this.data, this.charset);
        } catch (Exception e) {
            return "";
        }
    }
}
