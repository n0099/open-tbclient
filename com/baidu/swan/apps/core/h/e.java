package com.baidu.swan.apps.core.h;

import android.content.Context;
import com.baidu.swan.apps.b.c.g;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class e {
    private static ArrayList<g> atj = new ArrayList<>();

    static {
        atj.add(new a());
    }

    public static boolean ad(Context context, String str) {
        Iterator<g> it = atj.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && next.ad(context, str)) {
                return true;
            }
        }
        return false;
    }
}
