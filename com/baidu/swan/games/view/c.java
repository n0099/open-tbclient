package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.v.f;
/* loaded from: classes8.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d azQ = f.azN().azQ();
        return azQ != null && azQ.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d azQ = f.azN().azQ();
        return azQ != null && azQ.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d azQ = f.azN().azQ();
        return azQ != null && azQ.removeView(view);
    }

    public static Context getViewContext() {
        d azQ = f.azN().azQ();
        if (azQ != null) {
            return azQ.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d azQ = f.azN().azQ();
        if (azQ != null) {
            azQ.a(aVar);
        }
    }

    public static void b(a aVar) {
        d azQ = f.azN().azQ();
        if (azQ != null) {
            azQ.b(aVar);
        }
    }
}
