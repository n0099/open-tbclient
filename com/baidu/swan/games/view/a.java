package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class a {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        b Ed = e.Ec().Ed();
        return Ed != null && Ed.a(view, bVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        b Ed = e.Ec().Ed();
        return Ed != null && Ed.b(view, bVar);
    }

    public static boolean ai(View view) {
        b Ed = e.Ec().Ed();
        return Ed != null && Ed.ai(view);
    }

    public static Context Pn() {
        b Ed = e.Ec().Ed();
        if (Ed != null) {
            return Ed.getContext();
        }
        return null;
    }
}
