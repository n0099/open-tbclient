package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.v.f;
/* loaded from: classes10.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d avx = f.avu().avx();
        return avx != null && avx.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d avx = f.avu().avx();
        return avx != null && avx.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d avx = f.avu().avx();
        return avx != null && avx.removeView(view);
    }

    public static Context aTH() {
        d avx = f.avu().avx();
        if (avx != null) {
            return avx.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d avx = f.avu().avx();
        if (avx != null) {
            avx.a(aVar);
        }
    }

    public static void b(a aVar) {
        d avx = f.avu().avx();
        if (avx != null) {
            avx.b(aVar);
        }
    }
}
