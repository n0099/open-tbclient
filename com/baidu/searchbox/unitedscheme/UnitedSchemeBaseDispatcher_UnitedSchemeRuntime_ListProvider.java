package com.baidu.searchbox.unitedscheme;

import com.baidu.j.e.b;
import com.baidu.pyramid.a.a;
import com.baidu.swan.apps.scheme.g;
import com.baidu.swan.apps.scheme.h;
import com.baidu.swan.apps.scheme.i;
import com.baidu.tieba.write.b.a.o;
import com.baidu.tieba.write.b.a.p;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider implements a {
    @Override // com.baidu.pyramid.a.a
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.d.a.a());
        arrayList.add(new com.baidu.i.b.a());
        arrayList.add(new g());
        arrayList.add(new h());
        arrayList.add(new i());
        arrayList.add(new com.baidu.j.e.a());
        arrayList.add(new b());
        arrayList.add(new o());
        arrayList.add(new p());
        return arrayList;
    }
}
