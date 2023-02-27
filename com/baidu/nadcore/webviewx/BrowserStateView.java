package com.baidu.nadcore.webviewx;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class BrowserStateView extends FrameLayout {
    public View a;
    public View b;
    public LayoutInflater c;
    public int d;
    public int e;
    public View.OnClickListener f;

    /* loaded from: classes2.dex */
    public enum ViewState {
        LOADING,
        ERROR
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ViewState.values().length];
            a = iArr;
            try {
                iArr[ViewState.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ViewState.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public BrowserStateView(@NonNull Context context) {
        this(context, null);
    }

    public void a(ViewState viewState) {
        View view2;
        int i = a.a[viewState.ordinal()];
        if (i != 1) {
            if (i == 2 && (view2 = this.a) != null) {
                view2.setVisibility(8);
                return;
            }
            return;
        }
        View view3 = this.b;
        if (view3 != null) {
            view3.setVisibility(8);
        }
    }

    public void e(ViewState viewState) {
        View view2;
        int i = a.a[viewState.ordinal()];
        if (i != 1) {
            if (i == 2 && (view2 = this.a) != null) {
                view2.setVisibility(0);
                return;
            }
            return;
        }
        View view3 = this.b;
        if (view3 != null) {
            view3.setVisibility(0);
        }
    }

    public void setErrorViewClickListener(View.OnClickListener onClickListener) {
        this.f = onClickListener;
        View view2 = this.a;
        if (view2 != null) {
            view2.setOnClickListener(onClickListener);
        }
    }

    public BrowserStateView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public void setViewForState(int i, ViewState viewState) {
        if (this.c == null) {
            this.c = LayoutInflater.from(getContext());
        }
        setViewForState(this.c.inflate(i, (ViewGroup) this, false), viewState);
    }

    public final void b() {
        this.e = R.layout.nad_widget_errorview;
        this.d = R.layout.nad_widget_loadingview;
        this.c = LayoutInflater.from(getContext());
        d();
        c();
    }

    public final void c() {
        View inflate = this.c.inflate(this.e, (ViewGroup) this, false);
        this.a = inflate;
        addView(inflate, inflate.getLayoutParams());
        this.a.setVisibility(8);
    }

    public final void d() {
        View inflate = this.c.inflate(this.d, (ViewGroup) this, false);
        this.b = inflate;
        addView(inflate, inflate.getLayoutParams());
        this.b.setVisibility(8);
    }

    public void setViewForState(View view2, ViewState viewState) {
        if (view2 != null) {
            int i = a.a[viewState.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    View view3 = this.a;
                    if (view3 != null) {
                        removeView(view3);
                    }
                    this.a = view2;
                    addView(view2);
                    this.a.setOnClickListener(this.f);
                }
            } else {
                View view4 = this.b;
                if (view4 != null) {
                    removeView(view4);
                }
                this.b = view2;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                addView(this.b, layoutParams);
            }
            view2.setVisibility(8);
        }
    }
}
