package com.baidu.adp.lib.network.willdelete;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    public byte[] data;
    public String wn;
    public int wm = 0;
    public com.baidu.adp.lib.network.http.d wo = new com.baidu.adp.lib.network.http.d();
    public Map<String, List<String>> mHeader = null;
    public String charset = "utf-8";

    public String toString() {
        try {
            return new String(this.data, this.charset);
        } catch (Exception e) {
            return "";
        }
    }
}
