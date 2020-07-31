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
/* loaded from: classes19.dex */
public class r {
    public static final int a = -1728053248;
    private static String b;
    private final a c;
    private boolean d;
    private boolean e;
    private View f;
    private View g;

    /* loaded from: classes19.dex */
    public static class a {
        private static final String a = "status_bar_height";
        private static final String b = "navigation_bar_height";
        private static final String c = "navigation_bar_height_landscape";
        private static final String d = "navigation_bar_width";
        private static final String e = "config_showNavigationBar";
        private final int f;
        private final boolean g;
        private final int h;
        private final int i;
        private final boolean j;
        private final float k;

        @TargetApi(14)
        private int a(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !c(context)) {
                return 0;
            }
            return a(resources, this.j ? b : c);
        }

        @TargetApi(14)
        private int b(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !c(context)) {
                return 0;
            }
            return a(resources, d);
        }

        @TargetApi(14)
        private boolean c(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(e, "bool", "android");
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                if ("1".equals(r.b)) {
                    return false;
                }
                if ("0".equals(r.b)) {
                    return true;
                }
                return z;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }

        public boolean d() {
            return this.g;
        }

        public boolean e() {
            return this.k >= 600.0f || this.j;
        }

        private a(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.j = resources.getConfiguration().orientation == 1;
            this.k = a(activity);
            this.f = a(resources, a);
            this.h = a((Context) activity);
            this.i = b(activity);
            this.g = this.h > 0;
        }

        public int b() {
            return this.i;
        }

        public int a() {
            return this.h;
        }

        private int a(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        public int c() {
            return this.f;
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
                Object[] objArr = new Object[1];
                objArr[0] = "qemu.hw.mainkeys";
                b = (String) declaredMethod.invoke(null, objArr);
            } catch (Throwable th) {
                b = null;
            }
        }
    }

    @TargetApi(19)
    public r(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{16843759, 16843760});
            try {
                this.d = obtainStyledAttributes.getBoolean(0, false);
                this.e = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((attributes.flags & 67108864) != 0) {
                    this.d = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.e = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.c = new a(activity, this.d, this.e);
        if (!this.c.d()) {
            this.e = false;
        }
        if (this.d) {
            b(activity, viewGroup);
        }
        if (this.e) {
            a(activity, viewGroup);
        }
    }

    public void b(boolean z) {
        if (this.d) {
            this.f.setVisibility(z ? 0 : 8);
        }
    }

    public void a(boolean z) {
        if (this.e) {
            this.g.setVisibility(z ? 0 : 8);
        }
    }

    public void b(int i) {
        if (this.d) {
            this.f.setBackgroundColor(i);
        }
    }

    public void a(int i) {
        if (this.e) {
            this.g.setBackgroundColor(i);
        }
    }

    public a b() {
        return this.c;
    }

    private void a(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.g = new View(context);
        if (this.c.e()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.c.a());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.c.b(), -1);
            layoutParams.gravity = 5;
        }
        this.g.setLayoutParams(layoutParams);
        this.g.setBackgroundColor(-1728053248);
        this.g.setVisibility(8);
        viewGroup.addView(this.g);
    }

    private void b(Context context, ViewGroup viewGroup) {
        this.f = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.c.c());
        layoutParams.gravity = 48;
        if (this.e && !this.c.e()) {
            layoutParams.rightMargin = this.c.b();
        }
        this.f.setLayoutParams(layoutParams);
        this.f.setBackgroundColor(-1728053248);
        this.f.setVisibility(8);
        viewGroup.addView(this.f);
    }
}
