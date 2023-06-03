package com.baidu.swan.apps.res.ui.pullrefresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.is1;
/* loaded from: classes4.dex */
public abstract class LoadingLayout extends FrameLayout {
    public static final boolean d = is1.a;
    public View a;
    public ILoadingLayout$State b;
    public ILoadingLayout$State c;

    public abstract View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet);

    public void c() {
    }

    public void d(float f) {
    }

    public void e(int i) {
    }

    public void g() {
    }

    public abstract int getContentSize();

    public void h() {
    }

    public void i() {
    }

    public void j() {
    }

    public void k() {
    }

    public void setHeaderBigBackground(int i) {
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

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ILoadingLayout$State.values().length];
            a = iArr;
            try {
                iArr[ILoadingLayout$State.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ILoadingLayout$State.RELEASE_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ILoadingLayout$State.PULL_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ILoadingLayout$State.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ILoadingLayout$State.NO_MORE_DATA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ILoadingLayout$State.RELEASE_TO_LONG_REFRESH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public int getCanRefreshPullLength() {
        return getContentSize();
    }

    public ILoadingLayout$State getPreState() {
        return this.c;
    }

    public int getRefreshingHeight() {
        return getContentSize();
    }

    public ILoadingLayout$State getState() {
        return this.b;
    }

    public LoadingLayout(Context context) {
        this(context, null);
    }

    public void m(boolean z) {
        boolean z2;
        View view2;
        ViewGroup.LayoutParams layoutParams;
        int i = 0;
        if (getVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z != z2 && (view2 = this.a) != null && (layoutParams = view2.getLayoutParams()) != null) {
            if (z) {
                layoutParams.height = -2;
            } else {
                layoutParams.height = 0;
            }
            requestLayout();
            if (!z) {
                i = 4;
            }
            setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        View view2 = this.a;
        if (view2 != null) {
            view2.setBackgroundColor(i);
        }
    }

    public void setHeaderBackgroundColor(int i) {
        View view2 = this.a;
        if (view2 != null) {
            view2.setBackgroundColor(i);
        }
    }

    public void setHeaderBackgroundResource(int i) {
        View view2 = this.a;
        if (view2 != null) {
            view2.setBackgroundColor(getResources().getColor(i));
        }
    }

    public void setState(ILoadingLayout$State iLoadingLayout$State) {
        ILoadingLayout$State iLoadingLayout$State2 = this.b;
        if (iLoadingLayout$State2 != iLoadingLayout$State) {
            this.c = iLoadingLayout$State2;
            this.b = iLoadingLayout$State;
            l(iLoadingLayout$State, iLoadingLayout$State2);
        }
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"BDThrowableCheck"})
    public void b(Context context, AttributeSet attributeSet) {
        View a2 = a(context, this, attributeSet);
        this.a = a2;
        if (a2 == null) {
            if (!d) {
                return;
            }
            throw new NullPointerException("Loading view can not be null.");
        }
        int i = -2;
        ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
        if (layoutParams != null) {
            i = layoutParams.height;
        }
        addView(this.a, new FrameLayout.LayoutParams(-1, i));
    }

    public LoadingLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.b = iLoadingLayout$State;
        this.c = iLoadingLayout$State;
        b(context, attributeSet);
    }

    public void f(boolean z, String str, Runnable runnable) {
        runnable.run();
    }

    public void l(ILoadingLayout$State iLoadingLayout$State, ILoadingLayout$State iLoadingLayout$State2) {
        switch (a.a[iLoadingLayout$State.ordinal()]) {
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
}
