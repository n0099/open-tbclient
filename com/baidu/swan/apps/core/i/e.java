package com.baidu.swan.apps.core.i;

import android.content.Context;
import com.baidu.swan.apps.b.c.g;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class e {
    private static ArrayList<g> aua = new ArrayList<>();

    static {
        aua.add(new a());
    }

    public static boolean P(Context context, String str) {
        Iterator<g> it = aua.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && next.P(context, str)) {
                return true;
            }
        }
        return false;
    }
}
