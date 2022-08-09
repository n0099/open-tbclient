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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.component.AbsComponentPlugin;
import com.baidu.nadcore.max.event.WebEventTypeEnum;
import com.baidu.nadcore.webview.container.base.AbsContainer;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bh0;
import com.repackage.cm0;
import com.repackage.h31;
import com.repackage.jm0;
import com.repackage.on0;
import com.repackage.p01;
import com.repackage.pm0;
import com.repackage.r21;
import com.repackage.s21;
import com.repackage.t21;
import com.repackage.wl0;
import com.repackage.xx0;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\bS\u0010\nJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001a\u0010\u000eJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001e\u0010\u000eJ\u0019\u0010!\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0011\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010\nJ\u000f\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b'\u0010\nJ\u000f\u0010(\u001a\u00020\fH\u0016¢\u0006\u0004\b(\u0010\u000eJ\u000f\u0010)\u001a\u00020\fH\u0016¢\u0006\u0004\b)\u0010\u000eJ\u000f\u0010*\u001a\u00020\u001fH\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u001fH\u0016¢\u0006\u0004\b,\u0010+J\u000f\u0010-\u001a\u00020\u001fH\u0016¢\u0006\u0004\b-\u0010+J\u000f\u0010.\u001a\u00020\u001fH\u0016¢\u0006\u0004\b.\u0010+J\u000f\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b0\u00101J\u001f\u00102\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b2\u0010\u0019J\u0017\u00103\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b3\u0010\bJ\u000f\u00104\u001a\u00020\u0006H\u0016¢\u0006\u0004\b4\u0010\nJ\u000f\u00105\u001a\u00020\u0006H\u0016¢\u0006\u0004\b5\u0010\nJ\u000f\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u0010\nJ\u000f\u00107\u001a\u00020\u0006H\u0016¢\u0006\u0004\b7\u0010\nJ\u000f\u00108\u001a\u00020\u0006H\u0016¢\u0006\u0004\b8\u0010\nJ\u0017\u00109\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b9\u0010\bJ\u0017\u0010;\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020:H\u0016¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u0014H\u0002¢\u0006\u0004\b>\u0010?R\u001d\u0010E\u001a\u00020@8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001d\u0010J\u001a\u00020F8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010B\u001a\u0004\bH\u0010IR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u001d\u0010R\u001a\u00020N8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010B\u001a\u0004\bP\u0010Q¨\u0006T"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/WebViewComponent;", "Lcom/repackage/s21;", "Lcom/repackage/t21;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "Landroid/content/Intent;", IntentData.KEY, "", "addSpeedLogOnCreateBegin", "(Landroid/content/Intent;)V", "addSpeedLogOnCreateEnd", "()V", "doFinish", "", "enableUpdateTitle", "()Z", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "getIntent", "()Landroid/content/Intent;", "", "keyCode", "Landroid/view/KeyEvent;", "event", "handleKeyDown", "(ILandroid/view/KeyEvent;)Z", "handleLoadUrl", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "handleNestedScrollEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "handleSetContentView", "", "favorData", "handleUpdateFavorUI", "(Ljava/lang/String;)Z", "Landroid/widget/LinearLayout;", "initBrowserLayout", "()Landroid/widget/LinearLayout;", "initWebView", "injectService", "needAddSpeedLogInBase", "needAppendPublicParam", "obtainDemoteFavorUrl", "()Ljava/lang/String;", "obtainHost", "obtainNid", "obtainPageTitle", "Lorg/json/JSONObject;", "obtainSuspensionBallData", "()Lorg/json/JSONObject;", "onKeyDown", "onNewIntent", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "onStart", MissionEvent.MESSAGE_STOP, "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "visibility", "setUIVisible", "(I)V", "Lcom/baidu/nadcore/webview/container/base/AbsContainer;", "baseBrowserContainer$delegate", "Lkotlin/Lazy;", "getBaseBrowserContainer", "()Lcom/baidu/nadcore/webview/container/base/AbsContainer;", "baseBrowserContainer", "Lcom/baidu/nadcore/webview/listener/BdPageDialogsHandler;", "bdPageDialogsHandler$delegate", "getBdPageDialogsHandler", "()Lcom/baidu/nadcore/webview/listener/BdPageDialogsHandler;", "bdPageDialogsHandler", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/max/service/IWebViewService;", "webviewService$delegate", "getWebviewService", "()Lcom/baidu/nadcore/max/service/IWebViewService;", "webviewService", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class WebViewComponent extends AbsComponentPlugin implements s21, t21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;

    /* loaded from: classes2.dex */
    public static final class a implements AbsContainer.b {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-618036580, "Lcom/baidu/nadcore/max/uicomponent/WebViewComponent$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-618036580, "Lcom/baidu/nadcore/max/uicomponent/WebViewComponent$a;");
                    return;
                }
            }
            a = new a();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebViewComponent a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b(WebViewComponent webViewComponent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webViewComponent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webViewComponent;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view2, Outline outline) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, outline) == null) {
                Intrinsics.checkNotNullParameter(view2, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                View i = this.a.n().i();
                Intrinsics.checkNotNullExpressionValue(i, "baseBrowserContainer.containerLayout");
                int measuredWidth = i.getMeasuredWidth();
                View i2 = this.a.n().i();
                Intrinsics.checkNotNullExpressionValue(i2, "baseBrowserContainer.containerLayout");
                outline.setRoundRect(new Rect(0, 0, measuredWidth, i2.getMeasuredHeight()), p01.c.a(this.a.getContext(), 18.0f));
            }
        }
    }

    public WebViewComponent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = LazyKt__LazyJVMKt.lazy(new WebViewComponent$baseBrowserContainer$2(this));
        this.e = LazyKt__LazyJVMKt.lazy(new WebViewComponent$bdPageDialogsHandler$2(this));
        this.f = LazyKt__LazyJVMKt.lazy(new WebViewComponent$webviewService$2(this));
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void b(bh0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.b(event);
            if (Intrinsics.areEqual(event.a(), wl0.class.getSimpleName())) {
                r((wl0) event);
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.d();
            j().s(jm0.class, p());
        }
    }

    @Override // com.repackage.s21
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            n().f(a.a);
        }
    }

    @Override // com.repackage.s21
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? i() : (Activity) invokeV.objValue;
    }

    @Override // com.repackage.s21
    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Intent intent = i().getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "hostActivity.intent");
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    public final AbsContainer n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (AbsContainer) this.d.getValue() : (AbsContainer) invokeV.objValue;
    }

    public final h31 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (h31) this.e.getValue() : (h31) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public boolean onKeyDown(int i, KeyEvent event) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i, event)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (n().onKeyDown(i, event)) {
                return true;
            }
            return super.onKeyDown(i, event);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            t(intent);
            int b2 = r21.b(getContext().getApplicationContext(), null);
            if (4 == b2 || b2 == 0 || 2 == b2 || 1 == b2) {
                return;
            }
            s();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            n().r();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            j().k(new cm0(WebEventTypeEnum.WEB_DESTROY));
            super.onRelease();
            o().i();
            n().q();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            n().t();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onStart();
            n().u();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStop();
            n().v();
        }
    }

    public final jm0 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (jm0) this.f.getValue() : (jm0) invokeV.objValue;
    }

    @Override // com.repackage.s21
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void r(wl0 wl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, wl0Var) == null) {
            int i = pm0.$EnumSwitchMapping$0[wl0Var.getType().ordinal()];
            if (i == 1) {
                u(8);
                o().o(false);
            } else if (i != 2) {
            } else {
                u(0);
                o().l();
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            n().y("1");
            n().z(false);
            n().p();
            j().k(new cm0(WebEventTypeEnum.WEB_INIT_SUCCESS));
            if (Build.VERSION.SDK_INT >= 21) {
                View i = n().i();
                Intrinsics.checkNotNullExpressionValue(i, "baseBrowserContainer.containerLayout");
                i.setOutlineProvider(new b(this));
                View i2 = n().i();
                Intrinsics.checkNotNullExpressionValue(i2, "baseBrowserContainer.containerLayout");
                i2.setClipToOutline(true);
            }
            View it = n().i();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            it.setPadding(it.getPaddingLeft(), it.getPaddingTop(), it.getPaddingRight(), p01.c.a(getContext(), 49.0f));
        }
    }

    public final void t(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, intent) == null) {
            Serializable serializableExtra = intent.getSerializableExtra("map");
            if (!(serializableExtra instanceof HashMap)) {
                serializableExtra = null;
            }
            HashMap hashMap = (HashMap) serializableExtra;
            if (hashMap != null) {
                Object obj = hashMap.get("cmd_policy");
                String str = obj instanceof String ? obj : null;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                on0.g.a(xx0.c(str));
            }
        }
    }

    public final void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
        }
    }

    @Override // com.repackage.t21
    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
