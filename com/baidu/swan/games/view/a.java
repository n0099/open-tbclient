package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class a {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        b GK = e.GJ().GK();
        return GK != null && GK.a(view, bVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        b GK = e.GJ().GK();
        return GK != null && GK.b(view, bVar);
    }

    public static boolean an(View view) {
        b GK = e.GJ().GK();
        return GK != null && GK.an(view);
    }

    public static Context TB() {
        b GK = e.GJ().GK();
        if (GK != null) {
            return GK.getContext();
        }
        return null;
    }
}
