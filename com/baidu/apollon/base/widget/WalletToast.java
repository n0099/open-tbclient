package com.baidu.apollon.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.baidu.apollon.utils.ResUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class WalletToast {
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;

    /* renamed from: h  reason: collision with root package name */
    public static final int f3547h = 3500;
    public static final int i = 2000;
    public static List<View> j = new ArrayList();
    public static CancleRunnable k;

    /* renamed from: a  reason: collision with root package name */
    public Context f3548a;

    /* renamed from: b  reason: collision with root package name */
    public int f3549b;

    /* renamed from: c  reason: collision with root package name */
    public int f3550c;

    /* renamed from: d  reason: collision with root package name */
    public int f3551d;

    /* renamed from: e  reason: collision with root package name */
    public int f3552e;

    /* renamed from: f  reason: collision with root package name */
    public float f3553f;

    /* renamed from: g  reason: collision with root package name */
    public float f3554g;
    public WindowManager l;
    public View m;
    public WindowManager.LayoutParams n;
    public Handler o = new Handler(Looper.getMainLooper());

    /* loaded from: classes.dex */
    public class CancleRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f3556a = false;

        public CancleRunnable() {
        }

        public void discard() {
            this.f3556a = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3556a) {
                return;
            }
            WalletToast.this.a();
        }
    }

    public WalletToast(Context context) {
        this.l = (WindowManager) context.getSystemService("window");
        this.f3548a = context;
        Toast toast = new Toast(context);
        this.f3552e = toast.getYOffset();
        a(toast);
    }

    public int getDuration() {
        return this.f3549b;
    }

    public int getGravity() {
        return this.f3550c;
    }

    public float getHorizontalMargin() {
        return this.f3554g;
    }

    public float getVerticalMargin() {
        return this.f3553f;
    }

    public View getView() {
        return this.m;
    }

    public int getXOffset() {
        return this.f3551d;
    }

    public int getYOffset() {
        return this.f3552e;
    }

    public void setDuration(int i2) {
        this.f3549b = i2;
    }

    public void setGravity(int i2, int i3, int i4) {
        this.f3550c = i2;
        this.f3551d = i3;
        this.f3552e = i4;
    }

    public void setMargin(float f2, float f3) {
        this.f3554g = f2;
        this.f3553f = f3;
    }

    public void setView(View view) {
        this.m = view;
    }

    public void show() {
        this.o.post(new Runnable() { // from class: com.baidu.apollon.base.widget.WalletToast.1
            @Override // java.lang.Runnable
            public void run() {
                WalletToast.this.a();
                WalletToast walletToast = WalletToast.this;
                walletToast.a(walletToast.m);
            }
        });
    }

    private void b(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        try {
            this.l.removeView(view);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(Toast toast) {
        try {
            Field declaredField = toast.getClass().getDeclaredField("mTN");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(toast);
            Field declaredField2 = obj.getClass().getDeclaredField("mParams");
            declaredField2.setAccessible(true);
            this.n = (WindowManager.LayoutParams) declaredField2.get(obj);
        } catch (Exception e2) {
            e2.printStackTrace();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.n = layoutParams;
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.type = 2005;
            layoutParams.windowAnimations = ResUtils.style(this.f3548a, "EbpayActivityAnim2");
            this.n.setTitle("Toast");
            this.n.flags = 152;
        }
        this.f3550c = 17;
        this.f3552e = 0;
        this.m = toast.getView();
    }

    @SuppressLint({"ShowToast"})
    public WalletToast(Context context, String str, int i2) {
        this.l = (WindowManager) context.getSystemService("window");
        this.f3548a = context;
        Toast makeText = Toast.makeText(context, str, i2);
        this.f3552e = makeText.getYOffset();
        a(makeText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        CancleRunnable cancleRunnable = k;
        if (cancleRunnable != null) {
            cancleRunnable.discard();
            this.o.removeCallbacks(k);
            k = null;
        }
        for (View view : j) {
            b(view);
        }
        j.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        Context applicationContext = this.f3548a.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = this.f3548a;
        }
        this.l = (WindowManager) applicationContext.getSystemService("window");
        int i2 = this.f3550c;
        WindowManager.LayoutParams layoutParams = this.n;
        layoutParams.gravity = i2;
        if ((i2 & 7) == 7) {
            layoutParams.horizontalWeight = 1.0f;
        }
        if ((i2 & 112) == 112) {
            this.n.verticalWeight = 1.0f;
        }
        WindowManager.LayoutParams layoutParams2 = this.n;
        layoutParams2.x = this.f3551d;
        layoutParams2.y = this.f3552e;
        layoutParams2.verticalMargin = this.f3553f;
        layoutParams2.horizontalMargin = this.f3554g;
        try {
            if (view.getParent() != null) {
                this.l.updateViewLayout(view, this.n);
            } else {
                this.l.addView(view, this.n);
            }
            j.add(view);
            CancleRunnable cancleRunnable = new CancleRunnable();
            k = cancleRunnable;
            this.o.postDelayed(cancleRunnable, this.f3549b == 1 ? 3500L : 2000L);
        } catch (Exception unused) {
        }
    }
}
