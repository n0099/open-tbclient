package com.baidu.swan.apps.swancore.e;

import com.baidu.swan.apps.swancore.e.c;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends com.baidu.a.a.a.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c bqd;
    private Map<String, String> bqe;

    public b(c cVar) {
        this(cVar, null);
    }

    public b(c cVar, List<String> list) {
        super("33", "swan_core", list);
        this.bqe = null;
        this.bqd = cVar == null ? c.a.Tg().Ti() : cVar;
    }
}
