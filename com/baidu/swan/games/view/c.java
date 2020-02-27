package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.y.f;
/* loaded from: classes11.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d WS = f.WQ().WS();
        return WS != null && WS.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d WS = f.WQ().WS();
        return WS != null && WS.b(view, aVar);
    }

    public static boolean au(View view) {
        d WS = f.WQ().WS();
        return WS != null && WS.au(view);
    }

    public static Context aqp() {
        d WS = f.WQ().WS();
        if (WS != null) {
            return WS.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d WS = f.WQ().WS();
        if (WS != null) {
            WS.a(aVar);
        }
    }

    public static void b(a aVar) {
        d WS = f.WQ().WS();
        if (WS != null) {
            WS.b(aVar);
        }
    }
}
