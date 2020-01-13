package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.y.f;
/* loaded from: classes10.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d UE = f.UC().UE();
        return UE != null && UE.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d UE = f.UC().UE();
        return UE != null && UE.b(view, aVar);
    }

    public static boolean au(View view) {
        d UE = f.UC().UE();
        return UE != null && UE.au(view);
    }

    public static Context aob() {
        d UE = f.UC().UE();
        if (UE != null) {
            return UE.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d UE = f.UC().UE();
        if (UE != null) {
            UE.a(aVar);
        }
    }

    public static void b(a aVar) {
        d UE = f.UC().UE();
        if (UE != null) {
            UE.b(aVar);
        }
    }
}
