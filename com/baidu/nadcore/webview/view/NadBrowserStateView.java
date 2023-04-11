package com.baidu.nadcore.webview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.cm0;
import com.baidu.tieba.u81;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00012B\u001b\u0012\u0006\u0010-\u001a\u00020,\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b0\u00101J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\tJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010$¨\u00063"}, d2 = {"Lcom/baidu/nadcore/webview/view/NadBrowserStateView;", "Landroid/widget/FrameLayout;", "Lcom/baidu/nadcore/webview/view/NadBrowserStateView$ViewState;", "state", "Landroid/view/View;", "getView", "(Lcom/baidu/nadcore/webview/view/NadBrowserStateView$ViewState;)Landroid/view/View;", "", "hideState", "(Lcom/baidu/nadcore/webview/view/NadBrowserStateView$ViewState;)V", "initErrorView", "()V", "initLoadingView", "", "newProgress", "onProgressChange", "(I)V", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setErrorViewClickListener", "(Landroid/view/View$OnClickListener;)V", NativeConstants.TYPE_VIEW, "setViewForState", "(Landroid/view/View;Lcom/baidu/nadcore/webview/view/NadBrowserStateView$ViewState;)V", "layoutRes", "(ILcom/baidu/nadcore/webview/view/NadBrowserStateView$ViewState;)V", "showState", "", "useNaviLoadingView", "()Z", "mDefaultErrorResId", "I", "mDefaultLoadingResId", "mErrorClickListener", "Landroid/view/View$OnClickListener;", "mErrorView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "mInflater", "Landroid/view/LayoutInflater;", "Landroid/widget/ProgressBar;", "mLoadingBar", "Landroid/widget/ProgressBar;", "mLoadingView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ViewState", "lib-webview_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadBrowserStateView extends FrameLayout {
    public View a;
    public View b;
    public ProgressBar c;
    public LayoutInflater d;
    public int e;
    public int f;
    public View.OnClickListener g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/nadcore/webview/view/NadBrowserStateView$ViewState;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "LOADING", "ERROR", "lib-webview_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public enum ViewState {
        LOADING,
        ERROR
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadBrowserStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        this.f = R.layout.nad_widget_errorview;
        if (g()) {
            i = R.layout.nad_widget_navi_loading_view;
        } else {
            i = R.layout.nad_widget_loadingview;
        }
        this.e = i;
        this.d = LayoutInflater.from(context);
        d();
        c();
    }

    public final void setViewForState(int i, ViewState viewState) {
        if (this.d == null) {
            this.d = LayoutInflater.from(getContext());
        }
        LayoutInflater layoutInflater = this.d;
        Intrinsics.checkNotNull(layoutInflater);
        setViewForState(layoutInflater.inflate(i, (ViewGroup) this, false), viewState);
    }

    public /* synthetic */ NadBrowserStateView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final View a(ViewState viewState) {
        if (viewState != null) {
            int i = u81.$EnumSwitchMapping$0[viewState.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return this.a;
                }
            } else {
                return this.b;
            }
        }
        return null;
    }

    public final void b(ViewState viewState) {
        View view2;
        if (viewState != null) {
            int i = u81.$EnumSwitchMapping$3[viewState.ordinal()];
            if (i != 1) {
                if (i == 2 && (view2 = this.a) != null) {
                    Intrinsics.checkNotNull(view2);
                    view2.setVisibility(8);
                    return;
                }
                return;
            }
            View view3 = this.b;
            if (view3 != null) {
                Intrinsics.checkNotNull(view3);
                view3.setVisibility(8);
            }
        }
    }

    public final void e(int i) {
        ProgressBar progressBar = this.c;
        if (progressBar != null) {
            progressBar.setProgress(i);
        }
    }

    public final void f(ViewState viewState) {
        View view2;
        if (viewState != null) {
            int i = u81.$EnumSwitchMapping$2[viewState.ordinal()];
            if (i != 1) {
                if (i == 2 && (view2 = this.a) != null) {
                    Intrinsics.checkNotNull(view2);
                    view2.setVisibility(0);
                    return;
                }
                return;
            }
            View view3 = this.b;
            if (view3 != null) {
                Intrinsics.checkNotNull(view3);
                view3.setVisibility(0);
            }
        }
    }

    public final void setErrorViewClickListener(View.OnClickListener onClickListener) {
        this.g = onClickListener;
        View view2 = this.a;
        if (view2 != null) {
            Intrinsics.checkNotNull(view2);
            view2.setOnClickListener(onClickListener);
        }
    }

    public final void c() {
        View view2;
        LayoutInflater layoutInflater = this.d;
        ViewGroup.LayoutParams layoutParams = null;
        if (layoutInflater != null) {
            view2 = layoutInflater.inflate(this.f, (ViewGroup) this, false);
        } else {
            view2 = null;
        }
        this.a = view2;
        if (view2 != null) {
            layoutParams = view2.getLayoutParams();
        }
        addView(view2, layoutParams);
        View view3 = this.a;
        if (view3 != null) {
            view3.setVisibility(8);
        }
    }

    public final boolean g() {
        if (cm0.b().a().a("nairobi_use_navi_loading_view", 1) == 1) {
            return true;
        }
        return false;
    }

    public final void d() {
        View view2;
        ProgressBar progressBar;
        LayoutInflater layoutInflater = this.d;
        ViewGroup.LayoutParams layoutParams = null;
        if (layoutInflater != null) {
            view2 = layoutInflater.inflate(this.e, (ViewGroup) this, false);
        } else {
            view2 = null;
        }
        this.b = view2;
        if (g()) {
            View view3 = this.b;
            if (view3 != null) {
                progressBar = (ProgressBar) view3.findViewById(R.id.nad_container_progress_bar);
            } else {
                progressBar = null;
            }
            this.c = progressBar;
        }
        View view4 = this.b;
        if (view4 != null) {
            layoutParams = view4.getLayoutParams();
        }
        addView(view4, layoutParams);
        View view5 = this.b;
        if (view5 != null) {
            view5.setVisibility(8);
        }
    }

    public final void setViewForState(View view2, ViewState viewState) {
        if (view2 != null) {
            if (viewState != null) {
                int i = u81.$EnumSwitchMapping$1[viewState.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        View view3 = this.a;
                        if (view3 != null) {
                            removeView(view3);
                        }
                        this.a = view2;
                        addView(view2);
                        View view4 = this.a;
                        Intrinsics.checkNotNull(view4);
                        view4.setOnClickListener(this.g);
                    }
                } else {
                    View view5 = this.b;
                    if (view5 != null) {
                        removeView(view5);
                    }
                    this.b = view2;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.gravity = 17;
                    addView(this.b, layoutParams);
                }
            }
            view2.setVisibility(8);
        }
    }
}
