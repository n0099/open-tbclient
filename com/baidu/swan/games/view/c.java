package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.w.f;
/* loaded from: classes11.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d ahY = f.ahV().ahY();
        return ahY != null && ahY.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d ahY = f.ahV().ahY();
        return ahY != null && ahY.b(view, aVar);
    }

    public static boolean av(View view) {
        d ahY = f.ahV().ahY();
        return ahY != null && ahY.av(view);
    }

    public static Context aCy() {
        d ahY = f.ahV().ahY();
        if (ahY != null) {
            return ahY.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d ahY = f.ahV().ahY();
        if (ahY != null) {
            ahY.a(aVar);
        }
    }

    public static void b(a aVar) {
        d ahY = f.ahV().ahY();
        if (ahY != null) {
            ahY.b(aVar);
        }
    }
}
