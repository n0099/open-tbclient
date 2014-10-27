package com.baidu.adp.lib.debug.b;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
/* loaded from: classes.dex */
public class l {
    private static float x = 0.0f;
    private static float y = 200.0f;
    private static float ho = 0.0f;
    private static float hp = 0.0f;
    private static float hq = 0.0f;
    private static WindowManager hr = null;
    private static View hs = null;
    public static WindowManager.LayoutParams ht = new WindowManager.LayoutParams();
    public static int hu = 0;
    private static View hv = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, View view) {
        g(context);
        hs = view;
        hv = view;
        hr = (WindowManager) context.getSystemService("window");
        ht.type = 2007;
        ht.flags = 40;
        ht.width = -2;
        ht.height = -2;
        ht.alpha = 0.5f;
        ht.gravity = 51;
        ht.x = (int) x;
        ht.y = (int) y;
        hr.addView(view, ht);
    }

    public static boolean a(MotionEvent motionEvent, View view) {
        x = motionEvent.getRawX();
        y = motionEvent.getRawY();
        switch (motionEvent.getAction()) {
            case 0:
                a(0.0f);
                hp = motionEvent.getX();
                hq = motionEvent.getY();
                return false;
            case 1:
                a(1.0f);
                return false;
            case 2:
                a(2.0f);
                a(view);
                return false;
            default:
                return false;
        }
    }

    public static void g(Context context) {
        if (hv != null && hv.isShown()) {
            ((WindowManager) context.getSystemService("window")).removeView(hv);
        }
    }

    private static void a(View view) {
        ht.x = (int) (x - hp);
        ht.y = (int) (y - hq);
        hr.updateViewLayout(hs, ht);
    }

    public static void a(float f) {
        ho = f;
    }
}
