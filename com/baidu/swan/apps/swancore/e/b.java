package com.baidu.swan.apps.swancore.e;

import com.baidu.swan.apps.swancore.e.c;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends com.baidu.b.a.a.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c aXr;
    private Map<String, String> aXs;

    public b(c cVar) {
        this(cVar, null);
    }

    public b(c cVar, List<String> list) {
        super("33", "swan_core", list);
        this.aXs = null;
        this.aXr = cVar == null ? c.a.Oo().Oq() : cVar;
    }
}
