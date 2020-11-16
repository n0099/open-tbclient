package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.v.f;
/* loaded from: classes7.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d azj = f.azg().azj();
        return azj != null && azj.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d azj = f.azg().azj();
        return azj != null && azj.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d azj = f.azg().azj();
        return azj != null && azj.removeView(view);
    }

    public static Context aXt() {
        d azj = f.azg().azj();
        if (azj != null) {
            return azj.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d azj = f.azg().azj();
        if (azj != null) {
            azj.a(aVar);
        }
    }

    public static void b(a aVar) {
        d azj = f.azg().azj();
        if (azj != null) {
            azj.b(aVar);
        }
    }
}
