package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.v.f;
/* loaded from: classes10.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d axr = f.axo().axr();
        return axr != null && axr.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d axr = f.axo().axr();
        return axr != null && axr.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d axr = f.axo().axr();
        return axr != null && axr.removeView(view);
    }

    public static Context aVB() {
        d axr = f.axo().axr();
        if (axr != null) {
            return axr.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d axr = f.axo().axr();
        if (axr != null) {
            axr.a(aVar);
        }
    }

    public static void b(a aVar) {
        d axr = f.axo().axr();
        if (axr != null) {
            axr.b(aVar);
        }
    }
}
