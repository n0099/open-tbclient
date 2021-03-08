package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.pyramid.a.a;
import com.baidu.swan.apps.scheme.a.b;
import com.baidu.swan.apps.scheme.a.c;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider implements a {
    @Override // com.baidu.pyramid.a.a
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.swan.apps.impl.a.b.a());
        arrayList.add(new com.baidu.swan.apps.scheme.a.a());
        arrayList.add(new b());
        arrayList.add(new c());
        arrayList.add(new com.baidu.swan.games.o.a());
        return arrayList;
    }
}
