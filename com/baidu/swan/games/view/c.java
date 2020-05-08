package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.y.f;
/* loaded from: classes11.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aeM = f.aeJ().aeM();
        return aeM != null && aeM.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aeM = f.aeJ().aeM();
        return aeM != null && aeM.b(view, aVar);
    }

    public static boolean av(View view) {
        d aeM = f.aeJ().aeM();
        return aeM != null && aeM.av(view);
    }

    public static Context ayG() {
        d aeM = f.aeJ().aeM();
        if (aeM != null) {
            return aeM.getContext();
        }
        return null;
    }

    public static void a(a aVar) {
        d aeM = f.aeJ().aeM();
        if (aeM != null) {
            aeM.a(aVar);
        }
    }

    public static void b(a aVar) {
        d aeM = f.aeJ().aeM();
        if (aeM != null) {
            aeM.b(aVar);
        }
    }
}
