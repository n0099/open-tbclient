package com.baidu.fsg.face.base.d;

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
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5632a = -1728053248;

    /* renamed from: b  reason: collision with root package name */
    public static String f5633b;

    /* renamed from: c  reason: collision with root package name */
    public final a f5634c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5635d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5636e;

    /* renamed from: f  reason: collision with root package name */
    public View f5637f;

    /* renamed from: g  reason: collision with root package name */
    public View f5638g;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f5639a = "status_bar_height";

        /* renamed from: b  reason: collision with root package name */
        public static final String f5640b = "navigation_bar_height";

        /* renamed from: c  reason: collision with root package name */
        public static final String f5641c = "navigation_bar_height_landscape";

        /* renamed from: d  reason: collision with root package name */
        public static final String f5642d = "navigation_bar_width";

        /* renamed from: e  reason: collision with root package name */
        public static final String f5643e = "config_showNavigationBar";

        /* renamed from: f  reason: collision with root package name */
        public final int f5644f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f5645g;

        /* renamed from: h  reason: collision with root package name */
        public final int f5646h;
        public final int i;
        public final boolean j;
        public final float k;

        @TargetApi(14)
        private int a(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !c(context)) {
                return 0;
            }
            return a(resources, this.j ? "navigation_bar_height" : "navigation_bar_height_landscape");
        }

        @TargetApi(14)
        private int b(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !c(context)) {
                return 0;
            }
            return a(resources, "navigation_bar_width");
        }

        @TargetApi(14)
        private boolean c(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                if ("1".equals(j.f5633b)) {
                    return false;
                }
                if ("0".equals(j.f5633b)) {
                    return true;
                }
                return z;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }

        public int d() {
            return this.f5644f;
        }

        public boolean e() {
            return this.f5645g;
        }

        public a(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.j = resources.getConfiguration().orientation == 1;
            this.k = a(activity);
            this.f5644f = a(resources, "status_bar_height");
            this.f5646h = a((Context) activity);
            this.i = b(activity);
            this.f5645g = this.f5646h > 0;
        }

        public int b() {
            return this.i;
        }

        public int a() {
            return this.f5646h;
        }

        private int a(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        public boolean c() {
            return this.k >= 600.0f || this.j;
        }

        @SuppressLint({"NewApi"})
        private float a(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 16) {
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            }
            float f2 = displayMetrics.density;
            return Math.min(displayMetrics.widthPixels / f2, displayMetrics.heightPixels / f2);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                f5633b = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                f5633b = null;
            }
        }
    }

    @TargetApi(19)
    public j(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{16843759, 16843760});
            try {
                this.f5635d = obtainStyledAttributes.getBoolean(0, false);
                this.f5636e = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.f5635d = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.f5636e = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        a aVar = new a(activity, this.f5635d, this.f5636e);
        this.f5634c = aVar;
        if (!aVar.e()) {
            this.f5636e = false;
        }
        if (this.f5635d) {
            a(activity, viewGroup);
        }
        if (this.f5636e) {
            b(activity, viewGroup);
        }
    }

    public void a(boolean z) {
        if (this.f5635d) {
            this.f5637f.setVisibility(z ? 0 : 8);
        }
    }

    public void b(boolean z) {
        if (this.f5636e) {
            this.f5638g.setVisibility(z ? 0 : 8);
        }
    }

    public void a(int i) {
        if (this.f5635d) {
            this.f5637f.setBackgroundColor(i);
        }
    }

    public void b(int i) {
        if (this.f5636e) {
            this.f5638g.setBackgroundColor(i);
        }
    }

    public a a() {
        return this.f5634c;
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.f5637f = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f5634c.d());
        layoutParams.gravity = 48;
        if (this.f5636e && !this.f5634c.c()) {
            layoutParams.rightMargin = this.f5634c.b();
        }
        this.f5637f.setLayoutParams(layoutParams);
        this.f5637f.setBackgroundColor(-1728053248);
        this.f5637f.setVisibility(8);
        viewGroup.addView(this.f5637f);
    }

    private void b(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.f5638g = new View(context);
        if (this.f5634c.c()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f5634c.a());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f5634c.b(), -1);
            layoutParams.gravity = 5;
        }
        this.f5638g.setLayoutParams(layoutParams);
        this.f5638g.setBackgroundColor(-1728053248);
        this.f5638g.setVisibility(8);
        viewGroup.addView(this.f5638g);
    }
}
