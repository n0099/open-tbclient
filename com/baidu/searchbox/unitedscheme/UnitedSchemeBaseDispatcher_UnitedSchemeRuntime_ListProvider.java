package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.a.a;
import com.baidu.swan.apps.scheme.g;
import com.baidu.swan.apps.scheme.h;
import com.baidu.swan.apps.scheme.i;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider implements a {
    @Override // com.baidu.pyramid.a.a
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new g());
        arrayList.add(new h());
        arrayList.add(new i());
        return arrayList;
    }
}
