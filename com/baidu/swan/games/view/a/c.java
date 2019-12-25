package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes9.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d Ui = f.Uf().Ui();
        return Ui != null && Ui.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d Ui = f.Uf().Ui();
        return Ui != null && Ui.b(view, aVar);
    }

    public static boolean aq(View view) {
        d Ui = f.Uf().Ui();
        return Ui != null && Ui.aq(view);
    }

    public static boolean au(View view) {
        d Ui = f.Uf().Ui();
        return Ui != null && Ui.at(view);
    }

    public static boolean isLandScape() {
        d Ui = f.Uf().Ui();
        return Ui != null && Ui.isLandScape();
    }

    public static int anQ() {
        return ((Integer) f.Uf().TT().first).intValue();
    }

    public static int anR() {
        return ((Integer) f.Uf().TT().second).intValue();
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d Ui = f.Uf().Ui();
        if (Ui != null) {
            Ui.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d Ui = f.Uf().Ui();
        if (Ui != null) {
            Ui.b(aVar);
        }
    }
}
