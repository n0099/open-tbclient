package com.baidu.adp.lib.debug.b;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
/* loaded from: classes.dex */
public class i {
    private static float c = 0.0f;
    private static float d = 200.0f;
    private static float e = 0.0f;
    private static float f = 0.0f;
    private static float g = 0.0f;
    private static WindowManager h = null;
    private static View i = null;

    /* renamed from: a  reason: collision with root package name */
    public static WindowManager.LayoutParams f470a = new WindowManager.LayoutParams();
    public static int b = 0;
    private static View j = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, View view) {
        a(context);
        i = view;
        j = view;
        h = (WindowManager) context.getSystemService("window");
        f470a.type = 2007;
        f470a.flags = 40;
        f470a.width = -2;
        f470a.height = -2;
        f470a.alpha = 0.5f;
        f470a.gravity = 51;
        f470a.x = (int) c;
        f470a.y = (int) d;
        h.addView(view, f470a);
    }

    public static boolean a(MotionEvent motionEvent, View view) {
        c = motionEvent.getRawX();
        d = motionEvent.getRawY();
        switch (motionEvent.getAction()) {
            case 0:
                a(0.0f);
                f = motionEvent.getX();
                g = motionEvent.getY();
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

    public static void a(Context context) {
        if (j != null && j.isShown()) {
            ((WindowManager) context.getSystemService("window")).removeView(j);
        }
    }

    private static void a(View view) {
        f470a.x = (int) (c - f);
        f470a.y = (int) (d - g);
        h.updateViewLayout(i, f470a);
    }

    public static void a(float f2) {
        e = f2;
    }
}
