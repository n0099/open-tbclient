package com.baidu.ar.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.ar.util.Res;
/* loaded from: classes3.dex */
public class c {
    private static c c;
    private Toast a;
    private TextView b;

    private c(Context context, Activity activity) {
        this.a = new Toast(context);
        View inflate = Res.inflate("bdar_toast_custom");
        this.b = (TextView) inflate.findViewById(Res.id("bdar_toast_text"));
        this.a.setView(inflate);
    }

    public static c a(Context context, Activity activity, String str, int i) {
        if (c == null) {
            c = new c(context, activity);
        }
        c.a(str);
        c.a(i);
        return c;
    }

    public static c a(Context context, Activity activity, String str, int i, int i2) {
        if (c == null) {
            c = new c(context, activity);
        }
        c.a(str);
        c.a(i);
        c.b(i2);
        return c;
    }

    public static void b() {
        if (c != null) {
            c.b = null;
            c.a = null;
            c = null;
        }
    }

    public void a() {
        this.a.show();
    }

    public void a(int i) {
        this.a.setDuration(i);
    }

    public void a(String str) {
        this.b.setText(str);
    }

    public void b(int i) {
        switch (i) {
            case 1:
                this.a.setGravity(48, 0, 0);
                return;
            case 2:
                this.a.setGravity(17, 0, 0);
                return;
            default:
                return;
        }
    }
}
