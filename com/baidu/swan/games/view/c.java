package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.v.f;
/* loaded from: classes10.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d azR = f.azO().azR();
        return azR != null && azR.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d azR = f.azO().azR();
        return azR != null && azR.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d azR = f.azO().azR();
        return azR != null && azR.removeView(view);
    }

    public static Context aYb() {
        d azR = f.azO().azR();
        if (azR != null) {
            return azR.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d azR = f.azO().azR();
        if (azR != null) {
            azR.a(aVar);
        }
    }

    public static void b(a aVar) {
        d azR = f.azO().azR();
        if (azR != null) {
            azR.b(aVar);
        }
    }
}
