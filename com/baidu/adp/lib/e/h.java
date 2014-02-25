package com.baidu.adp.lib.e;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class h {
    private Map<String, Object> a = new HashMap();

    public void a(String str, Object obj) {
        this.a.put(str, obj);
    }

    public Object a(String str) {
        return this.a.get(str);
    }
}
