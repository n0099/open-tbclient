package com.baidu.swan.apps.component.container;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.v.f;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Nullable
    public static <C extends com.baidu.swan.apps.component.b.a> C d(com.baidu.swan.apps.component.b.b bVar) {
        C c;
        if (bVar == null) {
            com.baidu.swan.apps.component.e.a.bk("Component-Finder", "find a null component: null model");
            return null;
        }
        String name = bVar.getName();
        String str = bVar.cMR;
        if (TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.console.c.e("Component-Finder", "find a null " + name + " : slaveId is empty");
            return null;
        }
        com.baidu.swan.apps.component.c.a lV = lV(str);
        if (lV == null) {
            com.baidu.swan.apps.console.c.e("Component-Finder", "find a null " + name + " : null component context");
            return null;
        }
        String str2 = bVar.cMQ;
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Finder", "find " + name + " with a empty componentId");
            List<com.baidu.swan.apps.component.b.a> list = lV.aly().cOb.get(bVar.cMP);
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
            c = (C) lV.aly().cOa.get(str2);
        }
        if (c == null) {
            com.baidu.swan.apps.console.c.e("Component-Finder", "find a null " + name + " : not exist");
            return null;
        }
        return c;
    }

    @Nullable
    public static <C extends com.baidu.swan.apps.component.b.a> C bj(@Nullable String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        com.baidu.swan.apps.component.c.a lV = lV(str);
        if (lV == null) {
            com.baidu.swan.apps.console.c.e("Component-Finder", "find a null " + str2 + " : null component context");
            return null;
        }
        C c = (C) lV.aly().cOa.get(str2);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("Component-Finder", "find a null " + str2 + " : not exist");
            return null;
        }
        return c;
    }

    @Nullable
    public static com.baidu.swan.apps.component.c.a e(com.baidu.swan.apps.component.b.b bVar) {
        if (bVar == null) {
            com.baidu.swan.apps.component.e.a.bk("Component-Finder", "find component context with a null model");
            return null;
        }
        return lV(bVar.cMR);
    }

    @Nullable
    private static com.baidu.swan.apps.component.c.a lV(String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.console.c.e("Component-Finder", "find component context with a null slave id");
            return null;
        }
        e np = f.aAo().np(str);
        if (np instanceof com.baidu.swan.apps.adaptation.b.c) {
            return ((com.baidu.swan.apps.adaptation.b.c) np).aiV();
        }
        return null;
    }
}
