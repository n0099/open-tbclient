package com.baidu.swan.bdprivate.extensions.g.a;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes8.dex */
public class c extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public c(j jVar) {
        super(jVar, "/swan/recommendSimilarProducts");
    }

    @Override // com.baidu.swan.bdprivate.extensions.g.a.a
    @NonNull
    protected String getUrl() {
        return com.baidu.swan.apps.i.a.agM();
    }
}
