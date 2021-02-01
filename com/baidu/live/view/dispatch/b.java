package com.baidu.live.view.dispatch;

import android.view.View;
/* loaded from: classes11.dex */
public class b {
    public static boolean a(View view, a aVar) {
        if (view == null || aVar == null || !aVar.ai(view)) {
            return false;
        }
        aVar.onViewAdded(view);
        return true;
    }

    public static boolean b(View view, a aVar) {
        if (view == null || aVar == null || !aVar.ai(view)) {
            return false;
        }
        aVar.onViewRemoved(view);
        return true;
    }
}
