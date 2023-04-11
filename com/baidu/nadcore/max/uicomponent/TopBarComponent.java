package com.baidu.nadcore.max.uicomponent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.nadcore.component.AbsComponentPlugin;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.account.AccountRestoreActivity;
import com.baidu.tieba.fh0;
import com.baidu.tieba.ko0;
import com.baidu.tieba.lo0;
import com.baidu.tieba.mo0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/TopBarComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "Landroid/view/ViewGroup;", "parent", "", "initCloseIcon", "(Landroid/view/ViewGroup;)V", "initTopBarView", "onCreateView", "onRelease", "()V", "Lcom/baidu/nadcore/widget/AdImageView;", "closeIcon", "Lcom/baidu/nadcore/widget/AdImageView;", "Landroid/widget/FrameLayout;", "topBarView", "Landroid/widget/FrameLayout;", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class TopBarComponent extends AbsComponentPlugin {
    public FrameLayout d;
    public AdImageView e;

    public final void p(ViewGroup viewGroup) {
    }

    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            mo0 mo0Var = (mo0) TopBarComponent.this.j().o(mo0.class);
            if (mo0Var != null) {
                String str = ClogBuilder.LogType.FREE_CLICK.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
                mo0Var.a(str, AccountRestoreActivity.JS_PROMPT_ACCOUNT_METHOD_EXIT);
            }
            TopBarComponent.this.b().finish();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements Runnable {
        public final /* synthetic */ ViewGroup b;

        public b(ViewGroup viewGroup) {
            this.b = viewGroup;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TopBarComponent.this.q(this.b);
            TopBarComponent.this.p(this.b);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        fh0.g(this.d);
        this.d = null;
        fh0.g(this.e);
        this.e = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void L(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.post(new b(parent));
    }

    public final void q(ViewGroup viewGroup) {
        FrameLayout frameLayout;
        if (this.d != null) {
            return;
        }
        ko0 a2 = lo0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadMaxRuntime.getUIProvider()");
        a2.b();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.nad_max_top, viewGroup, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(cont…e(layoutId, parent, true)");
        AdImageView adImageView = null;
        if (inflate != null) {
            frameLayout = (FrameLayout) inflate.findViewById(R.id.max_top_bar);
        } else {
            frameLayout = null;
        }
        this.d = frameLayout;
        if (inflate != null) {
            adImageView = (AdImageView) inflate.findViewById(R.id.max_top_close);
        }
        this.e = adImageView;
        if (adImageView != null) {
            adImageView.setOnClickListener(new a());
        }
    }
}
