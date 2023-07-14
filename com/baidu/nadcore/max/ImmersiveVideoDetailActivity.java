package com.baidu.nadcore.max;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.nadcore.component.ComponentArchManager;
import com.baidu.nadcore.max.component.AlsComponent;
import com.baidu.nadcore.max.uicomponent.ArrowGuideComponent;
import com.baidu.nadcore.max.uicomponent.NestedScrollComponent;
import com.baidu.nadcore.max.uicomponent.PanelComponent;
import com.baidu.nadcore.max.uicomponent.PopoverComponent;
import com.baidu.nadcore.max.uicomponent.TopBarComponent;
import com.baidu.nadcore.max.uicomponent.VideoViewComponent;
import com.baidu.nadcore.max.uicomponent.WebViewComponent;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.tieba.dr0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/baidu/nadcore/max/ImmersiveVideoDetailActivity;", "Lcom/baidu/nadcore/appframework/BaseActivity;", "", "initComponentManager", "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreateEx", "(Landroid/os/Bundle;)V", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "Landroid/content/Intent;", "intent", "onNewIntentEx", "(Landroid/content/Intent;)V", "preCreate", "(Landroid/os/Bundle;)Z", "Lcom/baidu/nadcore/component/ComponentArchManager;", "componentManager", "Lcom/baidu/nadcore/component/ComponentArchManager;", "Landroid/widget/FrameLayout;", "rootView", "Landroid/widget/FrameLayout;", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class ImmersiveVideoDetailActivity extends BaseActivity {
    public ComponentArchManager u;
    public FrameLayout v;

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void A1(Bundle bundle) {
        super.A1(bundle);
        setContentView(R.layout.nad_max_activity);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f091f6b);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.rootview)");
        this.v = (FrameLayout) findViewById;
        getWindow().setFormat(-3);
        N1();
        ComponentArchManager componentArchManager = this.u;
        if (componentArchManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("componentManager");
        }
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        componentArchManager.m(intent);
        ComponentArchManager componentArchManager2 = this.u;
        if (componentArchManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("componentManager");
        }
        FrameLayout frameLayout = this.v;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        componentArchManager2.b(frameLayout);
        ComponentArchManager componentArchManager3 = this.u;
        if (componentArchManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("componentManager");
        }
        dr0 dr0Var = (dr0) componentArchManager3.r(dr0.class);
        if (dr0Var != null) {
            String str = ClogBuilder.LogType.VIDEO_LP_PV.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.VIDEO_LP_PV.type");
            dr0Var.a(str, "");
        }
        setSlideCancelActivityTransparent(false);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void D1(Intent intent) {
        super.D1(intent);
        if (intent != null) {
            ComponentArchManager componentArchManager = this.u;
            if (componentArchManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("componentManager");
            }
            componentArchManager.m(intent);
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public boolean L1(Bundle bundle) {
        if (!super.L1(bundle)) {
            return false;
        }
        getWindow().setSoftInputMode(19);
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT == 26) {
            setEnableSliding(false);
            setCurrentActivityNoTransparent();
        } else {
            setEnableSliding(true);
            setSlideCancelActivityTransparent(true);
        }
        return true;
    }

    public final void N1() {
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        ComponentArchManager componentArchManager = new ComponentArchManager(this, lifecycle);
        this.u = componentArchManager;
        if (componentArchManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("componentManager");
        }
        ComponentArchManager.t(componentArchManager, new AlsComponent(), false, 2, null);
        ComponentArchManager componentArchManager2 = this.u;
        if (componentArchManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("componentManager");
        }
        ComponentArchManager.t(componentArchManager2, new WebViewComponent(), false, 2, null);
        ComponentArchManager componentArchManager3 = this.u;
        if (componentArchManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("componentManager");
        }
        ComponentArchManager.t(componentArchManager3, new VideoViewComponent(), false, 2, null);
        ComponentArchManager componentArchManager4 = this.u;
        if (componentArchManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("componentManager");
        }
        ComponentArchManager.t(componentArchManager4, new NestedScrollComponent(), false, 2, null);
        ComponentArchManager componentArchManager5 = this.u;
        if (componentArchManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("componentManager");
        }
        ComponentArchManager.t(componentArchManager5, new TopBarComponent(), false, 2, null);
        ComponentArchManager componentArchManager6 = this.u;
        if (componentArchManager6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("componentManager");
        }
        ComponentArchManager.t(componentArchManager6, new PanelComponent(), false, 2, null);
        ComponentArchManager componentArchManager7 = this.u;
        if (componentArchManager7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("componentManager");
        }
        ComponentArchManager.t(componentArchManager7, new PopoverComponent(), false, 2, null);
        ComponentArchManager componentArchManager8 = this.u;
        if (componentArchManager8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("componentManager");
        }
        ComponentArchManager.t(componentArchManager8, new ArrowGuideComponent(), false, 2, null);
        Lifecycle lifecycle2 = getLifecycle();
        ComponentArchManager componentArchManager9 = this.u;
        if (componentArchManager9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("componentManager");
        }
        lifecycle2.addObserver(componentArchManager9);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onKeyDown(i, event);
        ComponentArchManager componentArchManager = this.u;
        if (componentArchManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("componentManager");
        }
        return componentArchManager.o(i, event);
    }
}
