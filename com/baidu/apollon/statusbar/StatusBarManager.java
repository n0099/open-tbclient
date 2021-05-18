package com.baidu.apollon.statusbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes.dex */
public class StatusBarManager {
    public a mBarParams;

    /* loaded from: classes.dex */
    public final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f3974a;

        /* renamed from: b  reason: collision with root package name */
        public int f3975b;

        /* renamed from: c  reason: collision with root package name */
        public float f3976c;

        /* renamed from: d  reason: collision with root package name */
        public View f3977d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3978e;

        /* renamed from: f  reason: collision with root package name */
        public int f3979f;

        public a() {
            this.f3974a = 0;
            this.f3975b = -16777216;
            this.f3976c = 0.0f;
            this.f3978e = false;
        }
    }

    public StatusBarManager() {
        buildParams();
    }

    private void setupStatusBarView(Activity activity) {
        a aVar = this.mBarParams;
        if (aVar.f3977d == null) {
            aVar.f3977d = new View(activity);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(activity));
        layoutParams.gravity = 48;
        this.mBarParams.f3977d.setLayoutParams(layoutParams);
        a aVar2 = this.mBarParams;
        aVar2.f3977d.setBackgroundColor(StatusBarUtils.blendARGB(aVar2.f3974a, aVar2.f3975b, aVar2.f3976c));
        this.mBarParams.f3977d.setVisibility(0);
        ViewGroup viewGroup = (ViewGroup) this.mBarParams.f3977d.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.mBarParams.f3977d);
        }
        ((ViewGroup) activity.getWindow().getDecorView()).addView(this.mBarParams.f3977d);
    }

    public void apply(Activity activity) {
        if (activity == null) {
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 27) {
            activity.getWindow().clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            r2 = this.mBarParams.f3978e ? 9472 : 1280;
            Window window = activity.getWindow();
            a aVar = this.mBarParams;
            window.setStatusBarColor(StatusBarUtils.blendARGB(aVar.f3974a, aVar.f3975b, aVar.f3976c));
            activity.getWindow().getDecorView().setSystemUiVisibility(r2);
        } else if (i2 >= 19) {
            int i3 = 256;
            if (i2 >= 21 && !ImmersiveOSUtils.isEMUI3_1()) {
                activity.getWindow().clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                activity.getWindow().addFlags(Integer.MIN_VALUE);
                r2 = (Build.VERSION.SDK_INT < 23 || !this.mBarParams.f3978e) ? 1280 : 1280;
                Window window2 = activity.getWindow();
                a aVar2 = this.mBarParams;
                window2.setStatusBarColor(StatusBarUtils.blendARGB(aVar2.f3974a, aVar2.f3975b, aVar2.f3976c));
                i3 = r2;
            } else {
                activity.getWindow().addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                setupStatusBarView(activity);
            }
            activity.getWindow().getDecorView().setSystemUiVisibility(i3);
            if (ImmersiveOSUtils.isMIUI6Plus()) {
                StatusBarUtils.setMIUIStatusBarDarkFont(activity.getWindow(), this.mBarParams.f3978e);
            }
            if (ImmersiveOSUtils.isFlymeOS4Plus()) {
                a aVar3 = this.mBarParams;
                int i4 = aVar3.f3979f;
                if (i4 != 0) {
                    FlymeStatusBarFontUtils.setStatusBarDarkIcon(activity, i4);
                } else if (Build.VERSION.SDK_INT < 23) {
                    FlymeStatusBarFontUtils.setStatusBarDarkIcon(activity, aVar3.f3978e);
                }
            }
        }
    }

    public void buildParams() {
        this.mBarParams = new a();
    }

    public void release() {
        this.mBarParams = null;
    }

    public void setFlymeStatusBarFontColor(Context context, int i2) {
        this.mBarParams.f3979f = context.getResources().getColor(i2);
    }

    public void setTitleAlpha(View view, int i2, float f2) {
        if (view != null) {
            view.setBackgroundColor(StatusBarUtils.blendARGB(0, view.getContext().getResources().getColor(i2), f2));
        }
    }

    public void statusBarAlpha(float f2) {
        this.mBarParams.f3976c = f2;
    }

    public void statusBarColor(Context context, int i2) {
        statusBarColorInt(context.getResources().getColor(i2));
    }

    public void statusBarColorInt(int i2) {
        this.mBarParams.f3974a = i2;
    }

    public void statusBarDarkFont(boolean z, float f2) {
        if (!z) {
            this.mBarParams.f3979f = 0;
        }
        if (ImmersiveOSUtils.isSupportStatusBarDarkFont()) {
            if (ImmersiveOSUtils.isSpecialOS() && z) {
                a aVar = this.mBarParams;
                aVar.f3976c = f2;
                aVar.f3978e = false;
                return;
            }
            a aVar2 = this.mBarParams;
            aVar2.f3978e = z;
            aVar2.f3976c = 0.0f;
            return;
        }
        this.mBarParams.f3976c = f2;
    }
}
