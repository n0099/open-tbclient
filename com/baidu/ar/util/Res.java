package com.baidu.ar.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.fsg.base.utils.ResUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class Res {
    private static Map<String, Context> a = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        private final Context a;
        private final int b;

        public a(Context context, int i) {
            this.a = context;
            this.b = i;
        }

        private Resources i() {
            return this.a.getResources();
        }

        private LayoutInflater j() {
            return LayoutInflater.from(this.a);
        }

        public View a(ViewGroup viewGroup, boolean z) {
            return j().inflate(this.b, viewGroup, z);
        }

        public String a() {
            return i().getString(this.b);
        }

        public int b() {
            return i().getDimensionPixelSize(this.b);
        }

        public Drawable c() {
            return i().getDrawable(this.b);
        }

        public int d() {
            return i().getColor(this.b);
        }

        public ColorStateList e() {
            return i().getColorStateList(this.b);
        }

        public View f() {
            return j().inflate(this.b, (ViewGroup) null);
        }

        public int g() {
            return this.b;
        }

        public Animation h() {
            return AnimationUtils.loadAnimation(this.a, this.b);
        }
    }

    private static int a(Resources resources, String str, String str2, String str3) {
        try {
            return resources.getIdentifier(str, str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static a a(String str, String str2) {
        for (String str3 : a.keySet()) {
            Context context = a.get(str3);
            int a2 = a(context.getResources(), str, str2, str3);
            if (a2 != -1) {
                return new a(context, a2);
            }
        }
        return null;
    }

    public static void addResource(Context context) {
        addResource(context, context.getPackageName());
    }

    public static void addResource(Context context, String str) {
        a.put(str, context);
    }

    private static int b(String str, String str2) {
        a a2 = a(str, str2);
        if (a2 != null) {
            return a2.g();
        }
        return -1;
    }

    public static View findViewById(View view2, String str) {
        return view2.findViewById(id(str));
    }

    public static int getColor(String str) {
        a a2 = a(str, "color");
        if (a2 != null) {
            return a2.d();
        }
        return 0;
    }

    public static ColorStateList getColorStateList(String str) {
        a a2 = a(str, "color");
        if (a2 != null) {
            return a2.e();
        }
        return null;
    }

    public static int getDimensionPixelSize(String str) {
        a a2 = a(str, "dimen");
        if (a2 != null) {
            return a2.b();
        }
        return 0;
    }

    public static Drawable getDrawable(String str) {
        a a2 = a(str, "drawable");
        if (a2 != null) {
            return a2.c();
        }
        return null;
    }

    public static int getRaw(String str) {
        return b(str, "raw");
    }

    public static String getString(String str) {
        a a2 = a(str, "string");
        if (a2 != null) {
            return a2.a();
        }
        return null;
    }

    public static int getStyle(String str) {
        return b(str, "style");
    }

    public static int id(String str) {
        a a2 = a(str, "id");
        if (a2 != null) {
            return a2.g();
        }
        return -1;
    }

    public static View inflate(String str) {
        a a2 = a(str, "layout");
        if (a2 != null) {
            return a2.f();
        }
        return null;
    }

    public static View inflate(String str, ViewGroup viewGroup, boolean z) {
        a a2 = a(str, "layout");
        if (a2 != null) {
            return a2.a(viewGroup, z);
        }
        return null;
    }

    public static Animation loadAnimation(String str) {
        a a2 = a(str, ResUtils.ANIM);
        if (a2 != null) {
            return a2.h();
        }
        return null;
    }

    public static void removeResource(String str) {
        a.remove(str);
    }
}
