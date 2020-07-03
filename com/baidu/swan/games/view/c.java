package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.w.f;
/* loaded from: classes11.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aje = f.ajb().aje();
        return aje != null && aje.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aje = f.ajb().aje();
        return aje != null && aje.b(view, aVar);
    }

    public static boolean av(View view) {
        d aje = f.ajb().aje();
        return aje != null && aje.av(view);
    }

    public static Context aDE() {
        d aje = f.ajb().aje();
        if (aje != null) {
            return aje.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d aje = f.ajb().aje();
        if (aje != null) {
            aje.a(aVar);
        }
    }

    public static void b(a aVar) {
        d aje = f.ajb().aje();
        if (aje != null) {
            aje.b(aVar);
        }
    }
}
