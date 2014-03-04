package com.baidu.adp.lib.e;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class f {
    private Map<String, Object> a = new HashMap();

    public final void a(String str, Object obj) {
        this.a.put(str, obj);
    }

    public final Object a(String str) {
        return this.a.get(str);
    }
}
