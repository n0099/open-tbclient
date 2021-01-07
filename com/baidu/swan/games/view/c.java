package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.v.f;
/* loaded from: classes9.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aDK = f.aDH().aDK();
        return aDK != null && aDK.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aDK = f.aDH().aDK();
        return aDK != null && aDK.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d aDK = f.aDH().aDK();
        return aDK != null && aDK.removeView(view);
    }

    public static Context getViewContext() {
        d aDK = f.aDH().aDK();
        if (aDK != null) {
            return aDK.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d aDK = f.aDH().aDK();
        if (aDK != null) {
            aDK.a(aVar);
        }
    }

    public static void b(a aVar) {
        d aDK = f.aDH().aDK();
        if (aDK != null) {
            aDK.b(aVar);
        }
    }
}
