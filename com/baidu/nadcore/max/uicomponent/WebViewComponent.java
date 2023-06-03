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
import com.baidu.tieba.br0;
import com.baidu.tieba.c61;
import com.baidu.tieba.cr0;
import com.baidu.tieba.dr0;
import com.baidu.tieba.ds0;
import com.baidu.tieba.er0;
import com.baidu.tieba.fq0;
import com.baidu.tieba.fr0;
import com.baidu.tieba.ik0;
import com.baidu.tieba.lq0;
import com.baidu.tieba.sq0;
import com.baidu.tieba.y21;
import com.baidu.tieba.yq0;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\bV\u0010\nJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001d\u0010\u000eJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\fH\u0016¢\u0006\u0004\b!\u0010\u000eJ\u0019\u0010$\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u0011\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010\nJ\u000f\u0010*\u001a\u00020\u0006H\u0016¢\u0006\u0004\b*\u0010\nJ\u000f\u0010+\u001a\u00020\fH\u0016¢\u0006\u0004\b+\u0010\u000eJ\u000f\u0010,\u001a\u00020\fH\u0016¢\u0006\u0004\b,\u0010\u000eJ\u000f\u0010-\u001a\u00020\"H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\"H\u0016¢\u0006\u0004\b/\u0010.J\u000f\u00100\u001a\u00020\"H\u0016¢\u0006\u0004\b0\u0010.J\u000f\u00101\u001a\u00020\"H\u0016¢\u0006\u0004\b1\u0010.J\u000f\u00103\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104J\u001f\u00105\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u001aH\u0016¢\u0006\u0004\b5\u0010\u001cJ\u0017\u00106\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b6\u0010\bJ\u000f\u00107\u001a\u00020\u0006H\u0016¢\u0006\u0004\b7\u0010\nJ\u000f\u00108\u001a\u00020\u0006H\u0016¢\u0006\u0004\b8\u0010\nJ\u000f\u00109\u001a\u00020\u0006H\u0016¢\u0006\u0004\b9\u0010\nJ\u000f\u0010:\u001a\u00020\u0006H\u0016¢\u0006\u0004\b:\u0010\nJ\u000f\u0010;\u001a\u00020\u0006H\u0016¢\u0006\u0004\b;\u0010\nJ\u0017\u0010<\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b<\u0010\bJ\u0017\u0010>\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u0018H\u0002¢\u0006\u0004\bA\u0010BR\u001d\u0010H\u001a\u00020C8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001d\u0010M\u001a\u00020I8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010E\u001a\u0004\bK\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u001d\u0010U\u001a\u00020Q8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010E\u001a\u0004\bS\u0010T¨\u0006W"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/WebViewComponent;", "Lcom/baidu/tieba/br0;", "Lcom/baidu/tieba/cr0;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "Landroid/content/Intent;", "intent", "", "addSpeedLogOnCreateBegin", "(Landroid/content/Intent;)V", "addSpeedLogOnCreateEnd", "()V", "doFinish", "", "enableUpdateTitle", "()Z", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "getIntent", "()Landroid/content/Intent;", "Lcom/baidu/nadcore/webview/extend/NadFontSizeChangeMessage;", "event", "handleFontSizeChange", "(Lcom/baidu/nadcore/webview/extend/NadFontSizeChangeMessage;)Z", "", "keyCode", "Landroid/view/KeyEvent;", "handleKeyDown", "(ILandroid/view/KeyEvent;)Z", "handleLoadUrl", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "handleNestedScrollEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "handleSetContentView", "", "favorData", "handleUpdateFavorUI", "(Ljava/lang/String;)Z", "Landroid/widget/LinearLayout;", "initBrowserLayout", "()Landroid/widget/LinearLayout;", "initWebView", "injectService", "needAddSpeedLogInBase", "needAppendPublicParam", "obtainDemoteFavorUrl", "()Ljava/lang/String;", "obtainHost", "obtainNid", "obtainPageTitle", "Lorg/json/JSONObject;", "obtainSuspensionBallData", "()Lorg/json/JSONObject;", "onKeyDown", "onNewIntent", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "onStart", MissionEvent.MESSAGE_STOP, "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "visibility", "setUIVisible", "(I)V", "Lcom/baidu/nadcore/max/webviewab/WrappedPageDialogsHandler;", "bdPageDialogsHandler$delegate", "Lkotlin/Lazy;", "getBdPageDialogsHandler", "()Lcom/baidu/nadcore/max/webviewab/WrappedPageDialogsHandler;", "bdPageDialogsHandler", "Lcom/baidu/nadcore/max/webviewab/WrappedContainer;", "browserContainer$delegate", "getBrowserContainer", "()Lcom/baidu/nadcore/max/webviewab/WrappedContainer;", "browserContainer", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/max/service/IWebViewService;", "webviewService$delegate", "getWebviewService", "()Lcom/baidu/nadcore/max/service/IWebViewService;", "webviewService", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class WebViewComponent extends AbsComponentPlugin implements br0, cr0 {
    public final Lazy d = LazyKt__LazyJVMKt.lazy(new Function0<er0>() { // from class: com.baidu.nadcore.max.uicomponent.WebViewComponent$browserContainer$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final er0 invoke() {
            WebViewComponent webViewComponent = WebViewComponent.this;
            return new er0(webViewComponent, webViewComponent);
        }
    });
    public final Lazy e = LazyKt__LazyJVMKt.lazy(new Function0<fr0>() { // from class: com.baidu.nadcore.max.uicomponent.WebViewComponent$bdPageDialogsHandler$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final fr0 invoke() {
            return new fr0(WebViewComponent.this.r(), WebViewComponent.this.getContext());
        }
    });
    public final Lazy f = LazyKt__LazyJVMKt.lazy(new Function0<WebViewComponent$webviewService$2.a>() { // from class: com.baidu.nadcore.max.uicomponent.WebViewComponent$webviewService$2
        {
            super(0);
        }

        /* loaded from: classes3.dex */
        public static final class a implements sq0 {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.sq0
            public void e(int i) {
                WebViewComponent.this.z(i);
            }

            @Override // com.baidu.tieba.sq0
            public er0 b() {
                return WebViewComponent.this.r();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return new a();
        }
    });

    @Override // com.baidu.tieba.aa1, com.baidu.tieba.lb1
    public void d() {
    }

    @Override // com.baidu.tieba.aa1, com.baidu.tieba.lb1
    public boolean f() {
        return true;
    }

    @Override // com.baidu.tieba.ba1, com.baidu.tieba.mb1
    public boolean g() {
        return false;
    }

    @Override // com.baidu.tieba.ba1
    public boolean k1() {
        return false;
    }

    public final fr0 q() {
        return (fr0) this.e.getValue();
    }

    public final er0 r() {
        return (er0) this.d.getValue();
    }

    public final sq0 s() {
        return (sq0) this.f.getValue();
    }

    @Override // com.baidu.tieba.ba1
    public boolean v0() {
        return true;
    }

    public final void z(int i) {
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
            View l = WebViewComponent.this.r().l();
            if (l != null) {
                i = l.getMeasuredWidth();
            } else {
                i = 0;
            }
            View l2 = WebViewComponent.this.r().l();
            if (l2 != null) {
                i2 = l2.getMeasuredHeight();
            } else {
                i2 = 0;
            }
            outline.setRoundRect(new Rect(0, 0, i, i2), c61.c.a(WebViewComponent.this.getContext(), 18.0f));
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void A() {
        super.A();
        j().t(sq0.class, s());
    }

    @Override // com.baidu.tieba.aa1, com.baidu.tieba.lb1
    public Activity getActivity() {
        return b();
    }

    @Override // com.baidu.tieba.aa1, com.baidu.tieba.lb1
    public Intent getIntent() {
        Intent intent = b().getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "hostActivity.intent");
        return intent;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        r().h();
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        j().g(new lq0(WebEventTypeEnum.WEB_DESTROY));
        super.onRelease();
        q().a();
        r().f();
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        super.onResume();
        r().i();
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onStart() {
        super.onStart();
        r().j();
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onStop() {
        super.onStop();
        r().k();
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        v(intent);
        if (!dr0.a.a(r(), getContext(), getIntent())) {
            return;
        }
        u();
    }

    public final void t(fq0 fq0Var) {
        int i = yq0.$EnumSwitchMapping$0[fq0Var.getType().ordinal()];
        if (i != 1) {
            if (i == 2) {
                z(0);
                q().b();
                return;
            }
            return;
        }
        z(8);
        q().c(false);
    }

    public final void v(Intent intent) {
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
                ds0.q.a(y21.c(str2));
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void w(ik0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.w(event);
        if (Intrinsics.areEqual(event.a(), fq0.class.getSimpleName())) {
            t((fq0) event);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public boolean onKeyDown(int i, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (r().g(i, event)) {
            return true;
        }
        return super.onKeyDown(i, event);
    }

    public final void u() {
        r().a();
        r().e();
        j().g(new lq0(WebEventTypeEnum.WEB_INIT_SUCCESS));
        if (Build.VERSION.SDK_INT >= 21) {
            View l = r().l();
            if (l != null) {
                l.setOutlineProvider(new a());
            }
            View l2 = r().l();
            if (l2 != null) {
                l2.setClipToOutline(true);
            }
        }
        View l3 = r().l();
        if (l3 != null) {
            l3.setPadding(l3.getPaddingLeft(), l3.getPaddingTop(), l3.getPaddingRight(), c61.c.a(getContext(), 49.0f));
        }
    }
}
