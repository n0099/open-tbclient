package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.v.f;
/* loaded from: classes9.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aAo = f.aAl().aAo();
        return aAo != null && aAo.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aAo = f.aAl().aAo();
        return aAo != null && aAo.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d aAo = f.aAl().aAo();
        return aAo != null && aAo.removeView(view);
    }

    public static Context getViewContext() {
        d aAo = f.aAl().aAo();
        if (aAo != null) {
            return aAo.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d aAo = f.aAl().aAo();
        if (aAo != null) {
            aAo.a(aVar);
        }
    }

    public static void b(a aVar) {
        d aAo = f.aAl().aAo();
        if (aAo != null) {
            aAo.b(aVar);
        }
    }
}
