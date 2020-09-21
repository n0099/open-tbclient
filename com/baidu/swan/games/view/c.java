package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.v.f;
/* loaded from: classes3.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d asM = f.asJ().asM();
        return asM != null && asM.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d asM = f.asJ().asM();
        return asM != null && asM.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d asM = f.asJ().asM();
        return asM != null && asM.removeView(view);
    }

    public static Context aQY() {
        d asM = f.asJ().asM();
        if (asM != null) {
            return asM.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d asM = f.asJ().asM();
        if (asM != null) {
            asM.a(aVar);
        }
    }

    public static void b(a aVar) {
        d asM = f.asJ().asM();
        if (asM != null) {
            asM.b(aVar);
        }
    }
}
