package com.baidu.searchbox.unitedscheme;

import com.baidu.m.e.b;
import com.baidu.pyramid.a.a;
import com.baidu.searchbox.ugc.webjs.UnitedSchemeUGCDispatcher;
import com.baidu.searchbox.ugc.webjs.UnitedSchemeWendaInfoDispatcher;
import com.baidu.swan.apps.scheme.g;
import com.baidu.swan.apps.scheme.h;
import com.baidu.swan.apps.scheme.i;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider implements a {
    @Override // com.baidu.pyramid.a.a
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.h.a.a());
        arrayList.add(new UnitedSchemeUGCDispatcher());
        arrayList.add(new UnitedSchemeWendaInfoDispatcher());
        arrayList.add(new com.baidu.l.b.a());
        arrayList.add(new g());
        arrayList.add(new h());
        arrayList.add(new i());
        arrayList.add(new com.baidu.m.e.a());
        arrayList.add(new b());
        return arrayList;
    }
}
