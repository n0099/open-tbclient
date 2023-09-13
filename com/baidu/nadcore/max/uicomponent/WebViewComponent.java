package com.baidu.nadcore.max.uicomponent;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.baidu.nadcore.component.AbsComponentPlugin;
import com.baidu.nadcore.max.event.WebEventTypeEnum;
import com.baidu.nadcore.max.uicomponent.WebViewComponent$webviewService$2;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ar0;
import com.baidu.tieba.br0;
import com.baidu.tieba.cq0;
import com.baidu.tieba.cr0;
import com.baidu.tieba.cs0;
import com.baidu.tieba.i31;
import com.baidu.tieba.iq0;
import com.baidu.tieba.pq0;
import com.baidu.tieba.q61;
import com.baidu.tieba.rj0;
import com.baidu.tieba.vq0;
import com.baidu.tieba.yq0;
import com.baidu.tieba.zq0;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\bL\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\tJ\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\tJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\u0006J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u0006J\u000f\u0010#\u001a\u00020\u0007H\u0016¢\u0006\u0004\b#\u0010\tJ\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020$H\u0016¢\u0006\u0004\b'\u0010&J\u000f\u0010(\u001a\u00020$H\u0016¢\u0006\u0004\b(\u0010&J\u001f\u0010)\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0016H\u0016¢\u0006\u0004\b)\u0010\u0018J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\rH\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0004H\u0016¢\u0006\u0004\b-\u0010\u0006J\u000f\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\b.\u0010\u0006J\u000f\u0010/\u001a\u00020\u0004H\u0016¢\u0006\u0004\b/\u0010\u0006J\u000f\u00100\u001a\u00020\u0004H\u0016¢\u0006\u0004\b0\u0010\u0006J\u000f\u00101\u001a\u00020\u0004H\u0016¢\u0006\u0004\b1\u0010\u0006J\u0017\u00102\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\rH\u0002¢\u0006\u0004\b2\u0010,J\u0017\u00104\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u000203H\u0016¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0014H\u0002¢\u0006\u0004\b7\u00108R\u001d\u0010>\u001a\u0002098B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001d\u0010C\u001a\u00020?8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010;\u001a\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001d\u0010K\u001a\u00020G8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010;\u001a\u0004\bI\u0010J¨\u0006M"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/WebViewComponent;", "Lcom/baidu/tieba/yq0;", "Lcom/baidu/tieba/zq0;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "doFinish", "()V", "", "enableUpdateTitle", "()Z", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "Lcom/baidu/nadcore/webview/extend/NadFontSizeChangeMessage;", "event", "handleFontSizeChange", "(Lcom/baidu/nadcore/webview/extend/NadFontSizeChangeMessage;)Z", "", "keyCode", "Landroid/view/KeyEvent;", "handleKeyDown", "(ILandroid/view/KeyEvent;)Z", "handleLoadUrl", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "handleNestedScrollEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "handleSetContentView", "Landroid/widget/LinearLayout;", "initBrowserLayout", "()Landroid/widget/LinearLayout;", "initWebView", "injectService", "needAppendPublicParam", "", "obtainHost", "()Ljava/lang/String;", "obtainNid", "obtainPageTitle", "onKeyDown", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "onStart", MissionEvent.MESSAGE_STOP, "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "visibility", "setUIVisible", "(I)V", "Lcom/baidu/nadcore/max/webviewab/WrappedPageDialogsHandler;", "bdPageDialogsHandler$delegate", "Lkotlin/Lazy;", "getBdPageDialogsHandler", "()Lcom/baidu/nadcore/max/webviewab/WrappedPageDialogsHandler;", "bdPageDialogsHandler", "Lcom/baidu/nadcore/max/webviewab/WrappedContainer;", "browserContainer$delegate", "getBrowserContainer", "()Lcom/baidu/nadcore/max/webviewab/WrappedContainer;", "browserContainer", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/max/service/IWebViewService;", "webviewService$delegate", "getWebviewService", "()Lcom/baidu/nadcore/max/service/IWebViewService;", "webviewService", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class WebViewComponent extends AbsComponentPlugin implements yq0, zq0 {
    public final Lazy d = LazyKt__LazyJVMKt.lazy(new Function0<br0>() { // from class: com.baidu.nadcore.max.uicomponent.WebViewComponent$browserContainer$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final br0 invoke() {
            WebViewComponent webViewComponent = WebViewComponent.this;
            return new br0(webViewComponent, webViewComponent);
        }
    });
    public final Lazy e = LazyKt__LazyJVMKt.lazy(new Function0<cr0>() { // from class: com.baidu.nadcore.max.uicomponent.WebViewComponent$bdPageDialogsHandler$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final cr0 invoke() {
            return new cr0(WebViewComponent.this.p(), WebViewComponent.this.getContext());
        }
    });
    public final Lazy f = LazyKt__LazyJVMKt.lazy(new Function0<WebViewComponent$webviewService$2.a>() { // from class: com.baidu.nadcore.max.uicomponent.WebViewComponent$webviewService$2
        {
            super(0);
        }

        /* loaded from: classes3.dex */
        public static final class a implements pq0 {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.pq0
            public void e(int i) {
                WebViewComponent.this.A(i);
            }

            @Override // com.baidu.tieba.pq0
            public br0 b() {
                return WebViewComponent.this.p();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return new a();
        }
    });

    public final void A(int i) {
    }

    @Override // com.baidu.tieba.ta1
    public boolean F() {
        return true;
    }

    @Override // com.baidu.tieba.ua1
    public boolean e1() {
        return false;
    }

    @Override // com.baidu.tieba.ua1
    public boolean f1() {
        return false;
    }

    @Override // com.baidu.tieba.ta1
    public void l() {
    }

    public final cr0 n() {
        return (cr0) this.e.getValue();
    }

    public final br0 p() {
        return (br0) this.d.getValue();
    }

    public final pq0 q() {
        return (pq0) this.f.getValue();
    }

    @Override // com.baidu.tieba.ua1
    public boolean t0() {
        return true;
    }

    /* loaded from: classes3.dex */
    public static final class a extends ViewOutlineProvider {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view2, Outline outline) {
            int i;
            int i2;
            Intrinsics.checkNotNullParameter(view2, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            View j = WebViewComponent.this.p().j();
            if (j != null) {
                i = j.getMeasuredWidth();
            } else {
                i = 0;
            }
            View j2 = WebViewComponent.this.p().j();
            if (j2 != null) {
                i2 = j2.getMeasuredHeight();
            } else {
                i2 = 0;
            }
            outline.setRoundRect(new Rect(0, 0, i, i2), q61.c.a(WebViewComponent.this.getContext(), 18.0f));
        }
    }

    @Override // com.baidu.tieba.ta1
    public Activity getActivity() {
        return b();
    }

    @Override // com.baidu.tieba.ta1
    public Intent getIntent() {
        Intent intent = b().getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "hostActivity.intent");
        return intent;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        p().f();
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        c().j(new iq0(WebEventTypeEnum.WEB_DESTROY));
        super.onRelease();
        n().a();
        p().d();
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        super.onResume();
        p().g();
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onStart() {
        super.onStart();
        p().h();
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onStop() {
        super.onStop();
        p().i();
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void x() {
        super.x();
        c().w(pq0.class, q());
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        w(intent);
        if (!ar0.a.a(p(), getContext(), getIntent())) {
            return;
        }
        v();
    }

    public final void r(cq0 cq0Var) {
        int i = vq0.$EnumSwitchMapping$0[cq0Var.getType().ordinal()];
        if (i != 1) {
            if (i == 2) {
                A(0);
                n().b();
                return;
            }
            return;
        }
        A(8);
        n().c(false);
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void s(rj0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.s(event);
        if (Intrinsics.areEqual(event.a(), cq0.class.getSimpleName())) {
            r((cq0) event);
        }
    }

    public final void w(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("map");
        String str = null;
        if (!(serializableExtra instanceof HashMap)) {
            serializableExtra = null;
        }
        HashMap hashMap = (HashMap) serializableExtra;
        if (hashMap != null) {
            Object obj = hashMap.get("cmd_policy");
            if (obj instanceof String) {
                str = obj;
            }
            String str2 = str;
            if (!TextUtils.isEmpty(str2)) {
                cs0.v.a(i31.c(str2));
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public boolean onKeyDown(int i, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (p().e(i, event)) {
            return true;
        }
        return super.onKeyDown(i, event);
    }

    public final void v() {
        p().a();
        p().c();
        c().j(new iq0(WebEventTypeEnum.WEB_INIT_SUCCESS));
        if (Build.VERSION.SDK_INT >= 21) {
            View j = p().j();
            if (j != null) {
                j.setOutlineProvider(new a());
            }
            View j2 = p().j();
            if (j2 != null) {
                j2.setClipToOutline(true);
            }
        }
        View j3 = p().j();
        if (j3 != null) {
            j3.setPadding(j3.getPaddingLeft(), j3.getPaddingTop(), j3.getPaddingRight(), q61.c.a(getContext(), 49.0f));
        }
    }
}
