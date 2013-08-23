package com.baidu.adp.lib.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private Map f371a = new HashMap();

    public void a(String str, Object obj) {
        this.f371a.put(str, obj);
    }

    public Object a(String str) {
        return this.f371a.get(str);
    }
}
