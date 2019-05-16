package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class a {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        b FW = e.FV().FW();
        return FW != null && FW.a(view, bVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        b FW = e.FV().FW();
        return FW != null && FW.b(view, bVar);
    }

    public static boolean al(View view) {
        b FW = e.FV().FW();
        return FW != null && FW.al(view);
    }

    public static Context SE() {
        b FW = e.FV().FW();
        if (FW != null) {
            return FW.getContext();
        }
        return null;
    }
}
