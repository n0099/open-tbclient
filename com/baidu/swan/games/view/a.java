package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class a {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        b Eb = e.Ea().Eb();
        return Eb != null && Eb.a(view, bVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        b Eb = e.Ea().Eb();
        return Eb != null && Eb.b(view, bVar);
    }

    public static boolean ai(View view) {
        b Eb = e.Ea().Eb();
        return Eb != null && Eb.ai(view);
    }

    public static Context Pl() {
        b Eb = e.Ea().Eb();
        if (Eb != null) {
            return Eb.getContext();
        }
        return null;
    }
}
