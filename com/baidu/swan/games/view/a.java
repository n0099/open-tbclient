package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class a {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        b GG = e.GF().GG();
        return GG != null && GG.a(view, bVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        b GG = e.GF().GG();
        return GG != null && GG.b(view, bVar);
    }

    public static boolean an(View view) {
        b GG = e.GF().GG();
        return GG != null && GG.an(view);
    }

    public static Context Tx() {
        b GG = e.GF().GG();
        if (GG != null) {
            return GG.getContext();
        }
        return null;
    }
}
