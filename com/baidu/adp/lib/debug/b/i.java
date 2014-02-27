package com.baidu.adp.lib.debug.b;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
/* loaded from: classes.dex */
public final class i {
    private static float c = 0.0f;
    private static float d = 200.0f;
    private static float e = 0.0f;
    private static float f = 0.0f;
    private static float g = 0.0f;
    private static WindowManager h = null;
    private static View i = null;
    public static WindowManager.LayoutParams a = new WindowManager.LayoutParams();
    public static int b = 0;
    private static View j = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, View view) {
        if (j != null && j.isShown()) {
            ((WindowManager) context.getSystemService("window")).removeView(j);
        }
        i = view;
        j = view;
        h = (WindowManager) context.getSystemService("window");
        a.type = 2007;
        a.flags = 40;
        a.width = -2;
        a.height = -2;
        a.alpha = 0.5f;
        a.gravity = 51;
        a.x = (int) c;
        a.y = (int) d;
        h.addView(view, a);
    }

    public static boolean a(MotionEvent motionEvent, View view) {
        c = motionEvent.getRawX();
        d = motionEvent.getRawY();
        switch (motionEvent.getAction()) {
            case 0:
                e = 0.0f;
                f = motionEvent.getX();
                g = motionEvent.getY();
                return false;
            case 1:
                e = 1.0f;
                return false;
            case 2:
                e = 2.0f;
                a.x = (int) (c - f);
                a.y = (int) (d - g);
                h.updateViewLayout(i, a);
                return false;
            default:
                return false;
        }
    }
}
