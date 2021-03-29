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
        public int f3884a;

        /* renamed from: b  reason: collision with root package name */
        public int f3885b;

        /* renamed from: c  reason: collision with root package name */
        public float f3886c;

        /* renamed from: d  reason: collision with root package name */
        public View f3887d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3888e;

        /* renamed from: f  reason: collision with root package name */
        public int f3889f;

        public a() {
            this.f3884a = 0;
            this.f3885b = -16777216;
            this.f3886c = 0.0f;
            this.f3888e = false;
        }
    }

    public StatusBarManager() {
        buildParams();
    }

    private void setupStatusBarView(Activity activity) {
        a aVar = this.mBarParams;
        if (aVar.f3887d == null) {
            aVar.f3887d = new View(activity);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(activity));
        layoutParams.gravity = 48;
        this.mBarParams.f3887d.setLayoutParams(layoutParams);
        a aVar2 = this.mBarParams;
        aVar2.f3887d.setBackgroundColor(StatusBarUtils.blendARGB(aVar2.f3884a, aVar2.f3885b, aVar2.f3886c));
        this.mBarParams.f3887d.setVisibility(0);
        ViewGroup viewGroup = (ViewGroup) this.mBarParams.f3887d.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.mBarParams.f3887d);
        }
        ((ViewGroup) activity.getWindow().getDecorView()).addView(this.mBarParams.f3887d);
    }

    public void apply(Activity activity) {
        if (activity == null) {
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 27) {
            activity.getWindow().clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            r2 = this.mBarParams.f3888e ? 9472 : 1280;
            Window window = activity.getWindow();
            a aVar = this.mBarParams;
            window.setStatusBarColor(StatusBarUtils.blendARGB(aVar.f3884a, aVar.f3885b, aVar.f3886c));
            activity.getWindow().getDecorView().setSystemUiVisibility(r2);
        } else if (i >= 19) {
            int i2 = 256;
            if (i >= 21 && !ImmersiveOSUtils.isEMUI3_1()) {
                activity.getWindow().clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                activity.getWindow().addFlags(Integer.MIN_VALUE);
                r2 = (Build.VERSION.SDK_INT < 23 || !this.mBarParams.f3888e) ? 1280 : 1280;
                Window window2 = activity.getWindow();
                a aVar2 = this.mBarParams;
                window2.setStatusBarColor(StatusBarUtils.blendARGB(aVar2.f3884a, aVar2.f3885b, aVar2.f3886c));
                i2 = r2;
            } else {
                activity.getWindow().addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                setupStatusBarView(activity);
            }
            activity.getWindow().getDecorView().setSystemUiVisibility(i2);
            if (ImmersiveOSUtils.isMIUI6Plus()) {
                StatusBarUtils.setMIUIStatusBarDarkFont(activity.getWindow(), this.mBarParams.f3888e);
            }
            if (ImmersiveOSUtils.isFlymeOS4Plus()) {
                a aVar3 = this.mBarParams;
                int i3 = aVar3.f3889f;
                if (i3 != 0) {
                    FlymeStatusBarFontUtils.setStatusBarDarkIcon(activity, i3);
                } else if (Build.VERSION.SDK_INT < 23) {
                    FlymeStatusBarFontUtils.setStatusBarDarkIcon(activity, aVar3.f3888e);
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

    public void setFlymeStatusBarFontColor(Context context, int i) {
        this.mBarParams.f3889f = context.getResources().getColor(i);
    }

    public void setTitleAlpha(View view, int i, float f2) {
        if (view != null) {
            view.setBackgroundColor(StatusBarUtils.blendARGB(0, view.getContext().getResources().getColor(i), f2));
        }
    }

    public void statusBarAlpha(float f2) {
        this.mBarParams.f3886c = f2;
    }

    public void statusBarColor(Context context, int i) {
        statusBarColorInt(context.getResources().getColor(i));
    }

    public void statusBarColorInt(int i) {
        this.mBarParams.f3884a = i;
    }

    public void statusBarDarkFont(boolean z, float f2) {
        if (!z) {
            this.mBarParams.f3889f = 0;
        }
        if (ImmersiveOSUtils.isSupportStatusBarDarkFont()) {
            if (ImmersiveOSUtils.isSpecialOS() && z) {
                a aVar = this.mBarParams;
                aVar.f3886c = f2;
                aVar.f3888e = false;
                return;
            }
            a aVar2 = this.mBarParams;
            aVar2.f3888e = z;
            aVar2.f3886c = 0.0f;
            return;
        }
        this.mBarParams.f3886c = f2;
    }
}
