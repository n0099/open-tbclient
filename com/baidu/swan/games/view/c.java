package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.y.f;
/* loaded from: classes11.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aeN = f.aeK().aeN();
        return aeN != null && aeN.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aeN = f.aeK().aeN();
        return aeN != null && aeN.b(view, aVar);
    }

    public static boolean av(View view) {
        d aeN = f.aeK().aeN();
        return aeN != null && aeN.av(view);
    }

    public static Context ayG() {
        d aeN = f.aeK().aeN();
        if (aeN != null) {
            return aeN.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d aeN = f.aeK().aeN();
        if (aeN != null) {
            aeN.a(aVar);
        }
    }

    public static void b(a aVar) {
        d aeN = f.aeK().aeN();
        if (aeN != null) {
            aeN.b(aVar);
        }
    }
}
