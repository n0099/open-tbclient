package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.y.f;
/* loaded from: classes9.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d Uh = f.Uf().Uh();
        return Uh != null && Uh.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d Uh = f.Uf().Uh();
        return Uh != null && Uh.b(view, aVar);
    }

    public static boolean aq(View view) {
        d Uh = f.Uf().Uh();
        return Uh != null && Uh.aq(view);
    }

    public static Context anI() {
        d Uh = f.Uf().Uh();
        if (Uh != null) {
            return Uh.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d Uh = f.Uf().Uh();
        if (Uh != null) {
            Uh.a(aVar);
        }
    }

    public static void b(a aVar) {
        d Uh = f.Uf().Uh();
        if (Uh != null) {
            Uh.b(aVar);
        }
    }
}
