package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.y.f;
/* loaded from: classes11.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d WX = f.WV().WX();
        return WX != null && WX.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d WX = f.WV().WX();
        return WX != null && WX.b(view, aVar);
    }

    public static boolean au(View view) {
        d WX = f.WV().WX();
        return WX != null && WX.au(view);
    }

    public static Context aqu() {
        d WX = f.WV().WX();
        if (WX != null) {
            return WX.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d WX = f.WV().WX();
        if (WX != null) {
            WX.a(aVar);
        }
    }

    public static void b(a aVar) {
        d WX = f.WV().WX();
        if (WX != null) {
            WX.b(aVar);
        }
    }
}
