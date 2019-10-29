package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class a {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        b LE = e.LD().LE();
        return LE != null && LE.a(view, bVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        b LE = e.LD().LE();
        return LE != null && LE.b(view, bVar);
    }

    public static boolean at(View view) {
        b LE = e.LD().LE();
        return LE != null && LE.at(view);
    }

    public static Context Ys() {
        b LE = e.LD().LE();
        if (LE != null) {
            return LE.getContext();
        }
        return null;
    }
}
