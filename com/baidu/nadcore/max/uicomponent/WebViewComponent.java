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
import com.baidu.tieba.e71;
import com.baidu.tieba.hr0;
import com.baidu.tieba.nr0;
import com.baidu.tieba.pk0;
import com.baidu.tieba.qr0;
import com.baidu.tieba.rr0;
import com.baidu.tieba.sr0;
import com.baidu.tieba.ss0;
import com.baidu.tieba.tr0;
import com.baidu.tieba.uq0;
import com.baidu.tieba.ur0;
import com.baidu.tieba.y31;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\bL\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\tJ\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\tJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\u0006J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u0006J\u000f\u0010#\u001a\u00020\u0007H\u0016¢\u0006\u0004\b#\u0010\tJ\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020$H\u0016¢\u0006\u0004\b'\u0010&J\u000f\u0010(\u001a\u00020$H\u0016¢\u0006\u0004\b(\u0010&J\u001f\u0010)\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0016H\u0016¢\u0006\u0004\b)\u0010\u0018J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\rH\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0004H\u0016¢\u0006\u0004\b-\u0010\u0006J\u000f\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\b.\u0010\u0006J\u000f\u0010/\u001a\u00020\u0004H\u0016¢\u0006\u0004\b/\u0010\u0006J\u000f\u00100\u001a\u00020\u0004H\u0016¢\u0006\u0004\b0\u0010\u0006J\u000f\u00101\u001a\u00020\u0004H\u0016¢\u0006\u0004\b1\u0010\u0006J\u0017\u00102\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\rH\u0002¢\u0006\u0004\b2\u0010,J\u0017\u00104\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u000203H\u0016¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0014H\u0002¢\u0006\u0004\b7\u00108R\u001d\u0010>\u001a\u0002098B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001d\u0010C\u001a\u00020?8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010;\u001a\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001d\u0010K\u001a\u00020G8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010;\u001a\u0004\bI\u0010J¨\u0006M"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/WebViewComponent;", "Lcom/baidu/tieba/qr0;", "Lcom/baidu/tieba/rr0;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "doFinish", "()V", "", "enableUpdateTitle", "()Z", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "Lcom/baidu/nadcore/webview/extend/NadFontSizeChangeMessage;", "event", "handleFontSizeChange", "(Lcom/baidu/nadcore/webview/extend/NadFontSizeChangeMessage;)Z", "", "keyCode", "Landroid/view/KeyEvent;", "handleKeyDown", "(ILandroid/view/KeyEvent;)Z", "handleLoadUrl", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "handleNestedScrollEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "handleSetContentView", "Landroid/widget/LinearLayout;", "initBrowserLayout", "()Landroid/widget/LinearLayout;", "initWebView", "injectService", "needAppendPublicParam", "", "obtainHost", "()Ljava/lang/String;", "obtainNid", "obtainPageTitle", "onKeyDown", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "onStart", MissionEvent.MESSAGE_STOP, "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "visibility", "setUIVisible", "(I)V", "Lcom/baidu/nadcore/max/webviewab/WrappedPageDialogsHandler;", "bdPageDialogsHandler$delegate", "Lkotlin/Lazy;", "getBdPageDialogsHandler", "()Lcom/baidu/nadcore/max/webviewab/WrappedPageDialogsHandler;", "bdPageDialogsHandler", "Lcom/baidu/nadcore/max/webviewab/WrappedContainer;", "browserContainer$delegate", "getBrowserContainer", "()Lcom/baidu/nadcore/max/webviewab/WrappedContainer;", "browserContainer", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/max/service/IWebViewService;", "webviewService$delegate", "getWebviewService", "()Lcom/baidu/nadcore/max/service/IWebViewService;", "webviewService", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class WebViewComponent extends AbsComponentPlugin implements qr0, rr0 {
    public final Lazy d = LazyKt__LazyJVMKt.lazy(new Function0<tr0>() { // from class: com.baidu.nadcore.max.uicomponent.WebViewComponent$browserContainer$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final tr0 invoke() {
            WebViewComponent webViewComponent = WebViewComponent.this;
            return new tr0(webViewComponent, webViewComponent);
        }
    });
    public final Lazy e = LazyKt__LazyJVMKt.lazy(new Function0<ur0>() { // from class: com.baidu.nadcore.max.uicomponent.WebViewComponent$bdPageDialogsHandler$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ur0 invoke() {
            return new ur0(WebViewComponent.this.q(), WebViewComponent.this.getContext());
        }
    });
    public final Lazy f = LazyKt__LazyJVMKt.lazy(new Function0<WebViewComponent$webviewService$2.a>() { // from class: com.baidu.nadcore.max.uicomponent.WebViewComponent$webviewService$2
        {
            super(0);
        }

        /* loaded from: classes3.dex */
        public static final class a implements hr0 {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.hr0
            public void e(int i) {
                WebViewComponent.this.v(i);
            }

            @Override // com.baidu.tieba.hr0
            public tr0 b() {
                return WebViewComponent.this.q();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return new a();
        }
    });

    @Override // com.baidu.tieba.hb1
    public boolean G() {
        return true;
    }

    @Override // com.baidu.tieba.ib1
    public boolean j1() {
        return false;
    }

    @Override // com.baidu.tieba.ib1
    public boolean k1() {
        return false;
    }

    @Override // com.baidu.tieba.hb1
    public void l() {
    }

    public final ur0 o() {
        return (ur0) this.e.getValue();
    }

    public final tr0 q() {
        return (tr0) this.d.getValue();
    }

    public final hr0 r() {
        return (hr0) this.f.getValue();
    }

    @Override // com.baidu.tieba.ib1
    public boolean u0() {
        return true;
    }

    public final void v(int i) {
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
            View j = WebViewComponent.this.q().j();
            if (j != null) {
                i = j.getMeasuredWidth();
            } else {
                i = 0;
            }
            View j2 = WebViewComponent.this.q().j();
            if (j2 != null) {
                i2 = j2.getMeasuredHeight();
            } else {
                i2 = 0;
            }
            outline.setRoundRect(new Rect(0, 0, i, i2), e71.c.a(WebViewComponent.this.getContext(), 18.0f));
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void B() {
        super.B();
        d().u(hr0.class, r());
    }

    @Override // com.baidu.tieba.hb1
    public Activity getActivity() {
        return b();
    }

    @Override // com.baidu.tieba.hb1
    public Intent getIntent() {
        Intent intent = b().getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "hostActivity.intent");
        return intent;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        q().f();
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        d().j(new ar0(WebEventTypeEnum.WEB_DESTROY));
        super.onRelease();
        o().a();
        q().d();
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        super.onResume();
        q().g();
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onStart() {
        super.onStart();
        q().h();
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onStop() {
        super.onStop();
        q().i();
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        u(intent);
        if (!sr0.a.a(q(), getContext(), getIntent())) {
            return;
        }
        t();
    }

    public final void s(uq0 uq0Var) {
        int i = nr0.$EnumSwitchMapping$0[uq0Var.getType().ordinal()];
        if (i != 1) {
            if (i == 2) {
                v(0);
                o().b();
                return;
            }
            return;
        }
        v(8);
        o().c(false);
    }

    public final void u(Intent intent) {
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
                ss0.t.a(y31.c(str2));
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void x(pk0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.x(event);
        if (Intrinsics.areEqual(event.a(), uq0.class.getSimpleName())) {
            s((uq0) event);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public boolean onKeyDown(int i, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (q().e(i, event)) {
            return true;
        }
        return super.onKeyDown(i, event);
    }

    public final void t() {
        q().a();
        q().c();
        d().j(new ar0(WebEventTypeEnum.WEB_INIT_SUCCESS));
        if (Build.VERSION.SDK_INT >= 21) {
            View j = q().j();
            if (j != null) {
                j.setOutlineProvider(new a());
            }
            View j2 = q().j();
            if (j2 != null) {
                j2.setClipToOutline(true);
            }
        }
        View j3 = q().j();
        if (j3 != null) {
            j3.setPadding(j3.getPaddingLeft(), j3.getPaddingTop(), j3.getPaddingRight(), e71.c.a(getContext(), 49.0f));
        }
    }
}
