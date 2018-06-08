package com.baidu.ar.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.fsg.base.utils.ResUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class Res {
    private static String a = null;
    private static Map<String, a> b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        private final Context a;
        private Context b;

        public a(Context context) {
            this.a = context;
        }

        public void a(Context context) {
            this.b = context;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b {
        private final a a;
        private final int b;

        public b(a aVar, int i) {
            this.a = aVar;
            this.b = i;
        }

        private Resources j() {
            return this.a.a.getResources();
        }

        private LayoutInflater k() {
            return this.a.b != null ? LayoutInflater.from(this.a.b) : LayoutInflater.from(this.a.a);
        }

        public View a(ViewGroup viewGroup, boolean z) {
            return k().inflate(this.b, viewGroup, z);
        }

        public String a() {
            return j().getString(this.b);
        }

        public int b() {
            return j().getDimensionPixelSize(this.b);
        }

        public Drawable c() {
            return j().getDrawable(this.b);
        }

        public Bitmap d() {
            return BitmapFactory.decodeResource(j(), this.b);
        }

        public int e() {
            return j().getColor(this.b);
        }

        public ColorStateList f() {
            return j().getColorStateList(this.b);
        }

        public View g() {
            return k().inflate(this.b, (ViewGroup) null);
        }

        public int h() {
            return this.b;
        }

        public Animation i() {
            return AnimationUtils.loadAnimation(this.a.a, this.b);
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

    private static b a(String str, String str2) {
        for (String str3 : b.keySet()) {
            a aVar = b.get(str3);
            int a2 = a(aVar.a.getResources(), str, str2, str3);
            if (a2 > 0) {
                return new b(aVar, a2);
            }
        }
        ARLog.e("Can not found res, name:" + str + ", type:" + str2);
        return null;
    }

    private static String a() {
        return a;
    }

    public static void addResource(Context context) {
        addResource(context, context.getPackageName());
    }

    public static void addResource(Context context, String str) {
        b.put(str, new a(context));
    }

    public static void addResource(Context context, String str, Context context2) {
        a aVar = new a(context);
        aVar.a(context2);
        b.put(str, aVar);
    }

    private static int b(String str, String str2) {
        b a2 = a(str, str2);
        if (a2 != null) {
            return a2.h();
        }
        return -1;
    }

    public static void clear() {
        b.clear();
    }

    public static void clear(Context context) {
        boolean z;
        Iterator<String> it = b.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (b.get(it.next()).a == context) {
                z = true;
                break;
            }
        }
        if (z) {
            clear();
        }
    }

    public static void clear(String str, Context context) {
        if (!TextUtils.isEmpty(str) && str.equals(a())) {
            clear(context);
        }
    }

    public static void clearDelay(final String str, final Context context) {
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.ar.util.Res.1
            @Override // java.lang.Runnable
            public void run() {
                Res.clear(str, context);
            }
        }, 1000L);
    }

    public static Bitmap decodeBitmap(String str) {
        b a2 = a(str, "drawable");
        if (a2 != null) {
            return a2.d();
        }
        return null;
    }

    public static View findViewById(View view, String str) {
        return view.findViewById(id(str));
    }

    public static int getColor(String str) {
        b a2 = a(str, "color");
        if (a2 != null) {
            return a2.e();
        }
        return 0;
    }

    public static ColorStateList getColorStateList(String str) {
        b a2 = a(str, "color");
        if (a2 != null) {
            return a2.f();
        }
        return null;
    }

    public static int getDimensionPixelSize(String str) {
        b a2 = a(str, "dimen");
        if (a2 != null) {
            return a2.b();
        }
        return 0;
    }

    public static Drawable getDrawable(String str) {
        b a2 = a(str, "drawable");
        if (a2 != null) {
            return a2.c();
        }
        return null;
    }

    public static int getRaw(String str) {
        return b(str, "raw");
    }

    public static String getString(String str) {
        b a2 = a(str, "string");
        if (a2 != null) {
            return a2.a();
        }
        return null;
    }

    public static int getStyle(String str) {
        return b(str, "style");
    }

    public static int id(String str) {
        b a2 = a(str, "id");
        if (a2 != null) {
            return a2.h();
        }
        return -1;
    }

    public static View inflate(String str) {
        b a2 = a(str, "layout");
        if (a2 != null) {
            return a2.g();
        }
        return null;
    }

    public static View inflate(String str, ViewGroup viewGroup, boolean z) {
        b a2 = a(str, "layout");
        if (a2 != null) {
            return a2.a(viewGroup, z);
        }
        return null;
    }

    public static Animation loadAnimation(String str) {
        b a2 = a(str, ResUtils.ANIM);
        if (a2 != null) {
            return a2.i();
        }
        return null;
    }

    public static void removeResource(String str) {
        b.remove(str);
    }

    public static void setFragmentHashCode(String str) {
        a = str;
    }
}
