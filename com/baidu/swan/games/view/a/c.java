package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes11.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d ajf = f.ajb().ajf();
        return ajf != null && ajf.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d ajf = f.ajb().ajf();
        return ajf != null && ajf.b(view, aVar);
    }

    public static boolean av(View view) {
        d ajf = f.ajb().ajf();
        return ajf != null && ajf.av(view);
    }

    public static boolean ay(View view) {
        d ajf = f.ajb().ajf();
        return ajf != null && ajf.ax(view);
    }

    public static boolean isLandScape() {
        d ajf = f.ajb().ajf();
        return ajf != null && ajf.isLandScape();
    }

    public static int aDM() {
        return ((Integer) f.ajb().aiO().first).intValue();
    }

    public static int aDN() {
        return ((Integer) f.ajb().aiO().second).intValue();
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d ajf = f.ajb().ajf();
        if (ajf != null) {
            ajf.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d ajf = f.ajb().ajf();
        if (ajf != null) {
            ajf.b(aVar);
        }
    }
}
