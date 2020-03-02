package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.y.f;
/* loaded from: classes11.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d WU = f.WS().WU();
        return WU != null && WU.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d WU = f.WS().WU();
        return WU != null && WU.b(view, aVar);
    }

    public static boolean au(View view) {
        d WU = f.WS().WU();
        return WU != null && WU.au(view);
    }

    public static Context aqr() {
        d WU = f.WS().WU();
        if (WU != null) {
            return WU.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d WU = f.WS().WU();
        if (WU != null) {
            WU.a(aVar);
        }
    }

    public static void b(a aVar) {
        d WU = f.WS().WU();
        if (WU != null) {
            WU.b(aVar);
        }
    }
}
