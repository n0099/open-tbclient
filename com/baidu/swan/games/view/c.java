package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.v.f;
/* loaded from: classes8.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d asb = f.arY().asb();
        return asb != null && asb.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d asb = f.arY().asb();
        return asb != null && asb.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d asb = f.arY().asb();
        return asb != null && asb.removeView(view);
    }

    public static Context aQm() {
        d asb = f.arY().asb();
        if (asb != null) {
            return asb.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d asb = f.arY().asb();
        if (asb != null) {
            asb.a(aVar);
        }
    }

    public static void b(a aVar) {
        d asb = f.arY().asb();
        if (asb != null) {
            asb.b(aVar);
        }
    }
}
