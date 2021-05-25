package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public abstract class LoadingLayout extends FrameLayout {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f11151h = k.f43199a;

    /* renamed from: e  reason: collision with root package name */
    public View f11152e;

    /* renamed from: f  reason: collision with root package name */
    public ILoadingLayout$State f11153f;

    /* renamed from: g  reason: collision with root package name */
    public ILoadingLayout$State f11154g;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11155a;

        static {
            int[] iArr = new int[ILoadingLayout$State.values().length];
            f11155a = iArr;
            try {
                iArr[ILoadingLayout$State.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11155a[ILoadingLayout$State.RELEASE_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11155a[ILoadingLayout$State.PULL_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11155a[ILoadingLayout$State.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11155a[ILoadingLayout$State.NO_MORE_DATA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11155a[ILoadingLayout$State.RELEASE_TO_LONG_REFRESH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public LoadingLayout(Context context) {
        this(context, null);
    }

    public abstract View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet);

    public void b(Context context, AttributeSet attributeSet) {
        View a2 = a(context, this, attributeSet);
        this.f11152e = a2;
        if (a2 == null) {
            if (f11151h) {
                throw new NullPointerException("Loading view can not be null.");
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
        addView(this.f11152e, new FrameLayout.LayoutParams(-1, layoutParams != null ? layoutParams.height : -2));
    }

    public void c() {
    }

    public void d(float f2) {
    }

    public void e(int i2) {
    }

    public void f(boolean z, String str, Runnable runnable) {
        runnable.run();
    }

    public void g() {
    }

    public int getCanRefreshPullLength() {
        return getContentSize();
    }

    public abstract int getContentSize();

    public ILoadingLayout$State getPreState() {
        return this.f11154g;
    }

    public int getRefreshingHeight() {
        return getContentSize();
    }

    public ILoadingLayout$State getState() {
        return this.f11153f;
    }

    public void h() {
    }

    public void i() {
    }

    public void j() {
    }

    public void k() {
    }

    public void l(ILoadingLayout$State iLoadingLayout$State, ILoadingLayout$State iLoadingLayout$State2) {
        switch (a.f11155a[iLoadingLayout$State.ordinal()]) {
            case 1:
                k();
                return;
            case 2:
                j();
                return;
            case 3:
                g();
                return;
            case 4:
                h();
                return;
            case 5:
                c();
                return;
            case 6:
                i();
                return;
            default:
                return;
        }
    }

    public void m(boolean z) {
        View view;
        ViewGroup.LayoutParams layoutParams;
        if (z == (getVisibility() == 0) || (view = this.f11152e) == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        if (z) {
            layoutParams.height = -2;
        } else {
            layoutParams.height = 0;
        }
        requestLayout();
        setVisibility(z ? 0 : 4);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        View view = this.f11152e;
        if (view != null) {
            view.setBackgroundColor(i2);
        }
    }

    public void setHeaderBackgroundColor(int i2) {
        View view = this.f11152e;
        if (view != null) {
            view.setBackgroundColor(i2);
        }
    }

    public void setHeaderBackgroundResource(int i2) {
        View view = this.f11152e;
        if (view != null) {
            view.setBackgroundColor(getResources().getColor(i2));
        }
    }

    public void setHeaderBigBackground(int i2) {
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
    }

    public void setLoadingDrawable(Drawable drawable) {
    }

    public void setPullLabel(CharSequence charSequence) {
    }

    public void setRefreshingLabel(CharSequence charSequence) {
    }

    public void setReleaseLabel(CharSequence charSequence) {
    }

    public void setState(ILoadingLayout$State iLoadingLayout$State) {
        ILoadingLayout$State iLoadingLayout$State2 = this.f11153f;
        if (iLoadingLayout$State2 != iLoadingLayout$State) {
            this.f11154g = iLoadingLayout$State2;
            this.f11153f = iLoadingLayout$State;
            l(iLoadingLayout$State, iLoadingLayout$State2);
        }
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.f11153f = iLoadingLayout$State;
        this.f11154g = iLoadingLayout$State;
        b(context, attributeSet);
    }
}
