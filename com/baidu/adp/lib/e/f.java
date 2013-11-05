package com.baidu.adp.lib.e;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f482a = new HashMap();

    public void a(String str, Object obj) {
        this.f482a.put(str, obj);
    }

    public Object a(String str) {
        return this.f482a.get(str);
    }
}
