package com.baidu.swan.apps.component.container;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.v.f;
import java.util.List;
/* loaded from: classes25.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Nullable
    public static <C extends com.baidu.swan.apps.component.b.a> C d(com.baidu.swan.apps.component.b.b bVar) {
        C c;
        if (bVar == null) {
            com.baidu.swan.apps.component.e.a.bs("Component-Finder", "find a null component: null model");
            return null;
        }
        String name = bVar.getName();
        String str = bVar.cIW;
        if (TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.console.c.e("Component-Finder", "find a null " + name + " : slaveId is empty");
            return null;
        }
        com.baidu.swan.apps.component.c.a mO = mO(str);
        if (mO == null) {
            com.baidu.swan.apps.console.c.e("Component-Finder", "find a null " + name + " : null component context");
            return null;
        }
        String str2 = bVar.cIV;
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Finder", "find " + name + " with a empty componentId");
            List<com.baidu.swan.apps.component.b.a> list = mO.anF().cKe.get(bVar.cIU);
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
            c = (C) mO.anF().cKd.get(str2);
        }
        if (c == null) {
            com.baidu.swan.apps.console.c.e("Component-Finder", "find a null " + name + " : not exist");
            return null;
        }
        return c;
    }

    @Nullable
    public static <C extends com.baidu.swan.apps.component.b.a> C br(@Nullable String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        com.baidu.swan.apps.component.c.a mO = mO(str);
        if (mO == null) {
            com.baidu.swan.apps.console.c.e("Component-Finder", "find a null " + str2 + " : null component context");
            return null;
        }
        C c = (C) mO.anF().cKd.get(str2);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("Component-Finder", "find a null " + str2 + " : not exist");
            return null;
        }
        return c;
    }

    @Nullable
    public static com.baidu.swan.apps.component.c.a e(com.baidu.swan.apps.component.b.b bVar) {
        if (bVar == null) {
            com.baidu.swan.apps.component.e.a.bs("Component-Finder", "find component context with a null model");
            return null;
        }
        return mO(bVar.cIW);
    }

    @Nullable
    private static com.baidu.swan.apps.component.c.a mO(String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.console.c.e("Component-Finder", "find component context with a null slave id");
            return null;
        }
        e oj = f.aCp().oj(str);
        if (oj instanceof com.baidu.swan.apps.adaptation.b.c) {
            return ((com.baidu.swan.apps.adaptation.b.c) oj).ald();
        }
        return null;
    }
}
