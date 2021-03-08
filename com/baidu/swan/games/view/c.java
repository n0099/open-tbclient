package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.v.f;
/* loaded from: classes8.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aAr = f.aAo().aAr();
        return aAr != null && aAr.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aAr = f.aAo().aAr();
        return aAr != null && aAr.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d aAr = f.aAo().aAr();
        return aAr != null && aAr.removeView(view);
    }

    public static Context getViewContext() {
        d aAr = f.aAo().aAr();
        if (aAr != null) {
            return aAr.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d aAr = f.aAo().aAr();
        if (aAr != null) {
            aAr.a(aVar);
        }
    }

    public static void b(a aVar) {
        d aAr = f.aAo().aAr();
        if (aAr != null) {
            aAr.b(aVar);
        }
    }
}
