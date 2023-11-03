package com.baidu.android.pushservice.x;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.baidu.android.pushservice.util.Utility;
/* loaded from: classes.dex */
public abstract class g {
    public Context a;
    public String b;
    public String c;
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public int h = Integer.MIN_VALUE;
    public int i = Integer.MIN_VALUE;

    public g(Context context, int i, String str) {
        this.b = "";
        this.c = "";
        this.a = context;
        this.b = str;
        context.getResources();
        this.c = context.getPackageName();
        a(context);
    }

    public void a(Context context) {
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle("NOTIFICATION_TITLE");
        builder.setContentText("NOTIFICATION_CONTENT");
        Notification build = builder.build();
        LinearLayout linearLayout = new LinearLayout(context);
        try {
            a((ViewGroup) (Build.VERSION.SDK_INT >= 24 ? builder.createContentView() : build.contentView).apply(context, linearLayout));
            linearLayout.removeAllViews();
        } catch (Exception unused) {
        }
    }

    public final void a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (textView.getText().toString().equals("NOTIFICATION_TITLE")) {
                    this.h = textView.getCurrentTextColor();
                }
                if (textView.getText().toString().equals("NOTIFICATION_CONTENT")) {
                    this.i = textView.getCurrentTextColor();
                }
            } else if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt);
            }
        }
    }

    public void a(String str) {
        this.e = str;
    }

    public boolean a() {
        return !Utility.F(this.a);
    }

    public String b() {
        if (Build.VERSION.SDK_INT >= 24) {
            com.baidu.android.pushservice.a0.h.a(this.a, "com.baidu.android.pushservice.push.importance_HIGH", "云通知", 4);
        }
        return "com.baidu.android.pushservice.push.importance_HIGH";
    }

    public void b(String str) {
        this.g = str;
    }

    public abstract RemoteViews c();

    public void c(String str) {
        this.f = str;
    }

    public RemoteViews d() {
        return null;
    }

    public void d(String str) {
        this.d = str;
    }

    public abstract boolean e();

    public boolean f() {
        int i;
        return (!Utility.N(this.a) || (i = Build.VERSION.SDK_INT) < 26 || i > 29) && h() && !Utility.T(this.a);
    }

    public boolean g() {
        return !Utility.F(this.a);
    }

    public boolean h() {
        return (Utility.F(this.a) || Utility.S(this.a)) ? false : true;
    }
}
