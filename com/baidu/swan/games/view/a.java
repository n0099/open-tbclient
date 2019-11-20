package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class a {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        b LF = e.LE().LF();
        return LF != null && LF.a(view, bVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        b LF = e.LE().LF();
        return LF != null && LF.b(view, bVar);
    }

    public static boolean at(View view) {
        b LF = e.LE().LF();
        return LF != null && LF.at(view);
    }

    public static Context Yq() {
        b LF = e.LE().LF();
        if (LF != null) {
            return LF.getContext();
        }
        return null;
    }
}
