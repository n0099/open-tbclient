package com.baidu.sapi2.views;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import java.lang.reflect.Method;
/* loaded from: classes15.dex */
public class c {
    public static final int f = -1728053248;
    private static String g;

    /* renamed from: a  reason: collision with root package name */
    private final b f3582a;
    private boolean b;
    private boolean c;
    private View d;
    private View e;

    /* loaded from: classes15.dex */
    public static class b {
        private static final String g = "status_bar_height";
        private static final String h = "navigation_bar_height";
        private static final String i = "navigation_bar_height_landscape";
        private static final String j = "navigation_bar_width";
        private static final String k = "config_showNavigationBar";

        /* renamed from: a  reason: collision with root package name */
        private final int f3583a;
        private final boolean b;
        private final int c;
        private final int d;
        private final boolean e;
        private final float f;

        @TargetApi(14)
        private int a(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !c(context)) {
                return 0;
            }
            return a(resources, this.e ? h : i);
        }

        @TargetApi(14)
        private int b(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !c(context)) {
                return 0;
            }
            return a(resources, j);
        }

        @TargetApi(14)
        private boolean c(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(k, "bool", "android");
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                if ("1".equals(c.g)) {
                    return false;
                }
                if ("0".equals(c.g)) {
                    return true;
                }
                return z;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }

        public boolean d() {
            return this.b;
        }

        public boolean e() {
            return this.f >= 600.0f || this.e;
        }

        private b(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.e = resources.getConfiguration().orientation == 1;
            this.f = a(activity);
            this.f3583a = a(resources, g);
            this.c = a((Context) activity);
            this.d = b(activity);
            this.b = this.c > 0;
        }

        public int b() {
            return this.d;
        }

        public int a() {
            return this.c;
        }

        private int a(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        public int c() {
            return this.f3583a;
        }

        @SuppressLint({"NewApi"})
        private float a(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 16) {
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            }
            float f = displayMetrics.density;
            return Math.min(displayMetrics.widthPixels / f, displayMetrics.heightPixels / f);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                g = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable th) {
                g = null;
            }
        }
    }

    @TargetApi(19)
    public c(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{16843759, 16843760});
            try {
                this.b = obtainStyledAttributes.getBoolean(0, false);
                this.c = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((attributes.flags & 67108864) != 0) {
                    this.b = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.c = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.f3582a = new b(activity, this.b, this.c);
        if (!this.f3582a.d()) {
            this.c = false;
        }
        if (this.b) {
            b(activity, viewGroup);
        }
        if (this.c) {
            a(activity, viewGroup);
        }
    }

    public void a(boolean z) {
        if (this.c) {
            this.e.setVisibility(z ? 0 : 8);
        }
    }

    public void b(boolean z) {
        if (this.b) {
            this.d.setVisibility(z ? 0 : 8);
        }
    }

    public void a(int i) {
        if (this.c) {
            this.e.setBackgroundColor(i);
        }
    }

    public void b(int i) {
        if (this.b) {
            this.d.setBackgroundColor(i);
        }
    }

    public b a() {
        return this.f3582a;
    }

    private void a(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.e = new View(context);
        if (this.f3582a.e()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f3582a.a());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f3582a.b(), -1);
            layoutParams.gravity = 5;
        }
        this.e.setLayoutParams(layoutParams);
        this.e.setBackgroundColor(-1728053248);
        this.e.setVisibility(8);
        viewGroup.addView(this.e);
    }

    private void b(Context context, ViewGroup viewGroup) {
        this.d = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f3582a.c());
        layoutParams.gravity = 48;
        if (this.c && !this.f3582a.e()) {
            layoutParams.rightMargin = this.f3582a.b();
        }
        this.d.setLayoutParams(layoutParams);
        this.d.setBackgroundColor(-1728053248);
        this.d.setVisibility(8);
        viewGroup.addView(this.d);
    }
}
