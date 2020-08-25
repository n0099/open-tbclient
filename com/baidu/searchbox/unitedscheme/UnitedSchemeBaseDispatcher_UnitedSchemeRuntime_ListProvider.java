package com.baidu.searchbox.unitedscheme;

import com.baidu.o.e.b;
import com.baidu.pyramid.a.a;
import com.baidu.swan.apps.scheme.g;
import com.baidu.swan.apps.scheme.h;
import com.baidu.swan.apps.scheme.i;
import com.baidu.tieba.write.b.a.o;
import com.baidu.tieba.write.b.a.p;
import java.util.ArrayList;
/* loaded from: classes14.dex */
public class UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider implements a {
    @Override // com.baidu.pyramid.a.a
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.i.a.a());
        arrayList.add(new com.baidu.n.b.a());
        arrayList.add(new g());
        arrayList.add(new h());
        arrayList.add(new i());
        arrayList.add(new com.baidu.o.e.a());
        arrayList.add(new b());
        arrayList.add(new o());
        arrayList.add(new p());
        return arrayList;
    }
}
