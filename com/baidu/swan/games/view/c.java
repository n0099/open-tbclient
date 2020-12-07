package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.v.f;
/* loaded from: classes25.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aCs = f.aCp().aCs();
        return aCs != null && aCs.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aCs = f.aCp().aCs();
        return aCs != null && aCs.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d aCs = f.aCp().aCs();
        return aCs != null && aCs.removeView(view);
    }

    public static Context bay() {
        d aCs = f.aCp().aCs();
        if (aCs != null) {
            return aCs.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d aCs = f.aCp().aCs();
        if (aCs != null) {
            aCs.a(aVar);
        }
    }

    public static void b(a aVar) {
        d aCs = f.aCp().aCs();
        if (aCs != null) {
            aCs.b(aVar);
        }
    }
}
