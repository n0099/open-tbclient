package com.baidu.swan.apps.component.container;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.v.f;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Nullable
    public static <C extends com.baidu.swan.apps.component.b.a> C d(com.baidu.swan.apps.component.b.b bVar) {
        C c;
        if (bVar == null) {
            com.baidu.swan.apps.component.e.a.br("Component-Finder", "find a null component: null model");
            return null;
        }
        String name = bVar.getName();
        String str = bVar.cNP;
        if (TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.console.c.e("Component-Finder", "find a null " + name + " : slaveId is empty");
            return null;
        }
        com.baidu.swan.apps.component.c.a mH = mH(str);
        if (mH == null) {
            com.baidu.swan.apps.console.c.e("Component-Finder", "find a null " + name + " : null component context");
            return null;
        }
        String str2 = bVar.cNO;
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Finder", "find " + name + " with a empty componentId");
            List<com.baidu.swan.apps.component.b.a> list = mH.aoQ().cOZ.get(bVar.cNN);
            if (list == null) {
                com.baidu.swan.apps.console.c.e("Component-Finder", "find a null " + name + " with a empty componentId: fallbackComponents are null ");
                return null;
            } else if (list.size() <= 0) {
                com.baidu.swan.apps.console.c.e("Component-Finder", "find a null " + name + " with a empty componentId: fallbackComponents are empty ");
                return null;
            } else {
                com.baidu.swan.apps.console.c.w("Component-Finder", "find " + name + " with a empty componentId: fina a fallback component");
                c = (C) list.get(0);
            }
        } else {
            c = (C) mH.aoQ().cOY.get(str2);
        }
        if (c == null) {
            com.baidu.swan.apps.console.c.e("Component-Finder", "find a null " + name + " : not exist");
            return null;
        }
        return c;
    }

    @Nullable
    public static <C extends com.baidu.swan.apps.component.b.a> C bq(@Nullable String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        com.baidu.swan.apps.component.c.a mH = mH(str);
        if (mH == null) {
            com.baidu.swan.apps.console.c.e("Component-Finder", "find a null " + str2 + " : null component context");
            return null;
        }
        C c = (C) mH.aoQ().cOY.get(str2);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("Component-Finder", "find a null " + str2 + " : not exist");
            return null;
        }
        return c;
    }

    @Nullable
    public static com.baidu.swan.apps.component.c.a e(com.baidu.swan.apps.component.b.b bVar) {
        if (bVar == null) {
            com.baidu.swan.apps.component.e.a.br("Component-Finder", "find component context with a null model");
            return null;
        }
        return mH(bVar.cNP);
    }

    @Nullable
    private static com.baidu.swan.apps.component.c.a mH(String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.console.c.e("Component-Finder", "find component context with a null slave id");
            return null;
        }
        e ob = f.aDG().ob(str);
        if (ob instanceof com.baidu.swan.apps.adaptation.b.c) {
            return ((com.baidu.swan.apps.adaptation.b.c) ob).amn();
        }
        return null;
    }
}
