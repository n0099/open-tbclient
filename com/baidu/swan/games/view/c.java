package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.v.f;
/* loaded from: classes7.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aku = f.akr().aku();
        return aku != null && aku.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aku = f.akr().aku();
        return aku != null && aku.b(view, aVar);
    }

    public static boolean ay(View view) {
        d aku = f.akr().aku();
        return aku != null && aku.ay(view);
    }

    public static Context aHu() {
        d aku = f.akr().aku();
        if (aku != null) {
            return aku.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d aku = f.akr().aku();
        if (aku != null) {
            aku.a(aVar);
        }
    }

    public static void b(a aVar) {
        d aku = f.akr().aku();
        if (aku != null) {
            aku.b(aVar);
        }
    }
}
