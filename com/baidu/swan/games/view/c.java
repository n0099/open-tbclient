package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.v.f;
/* loaded from: classes9.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aDJ = f.aDG().aDJ();
        return aDJ != null && aDJ.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aDJ = f.aDG().aDJ();
        return aDJ != null && aDJ.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d aDJ = f.aDG().aDJ();
        return aDJ != null && aDJ.removeView(view);
    }

    public static Context getViewContext() {
        d aDJ = f.aDG().aDJ();
        if (aDJ != null) {
            return aDJ.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d aDJ = f.aDG().aDJ();
        if (aDJ != null) {
            aDJ.a(aVar);
        }
    }

    public static void b(a aVar) {
        d aDJ = f.aDG().aDJ();
        if (aDJ != null) {
            aDJ.b(aVar);
        }
    }
}
