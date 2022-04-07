package com.baidu.nadcore.max.uicomponent;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.component.AbsComponentPlugin;
import com.baidu.nadcore.max.event.PopEventTypeEnum;
import com.baidu.nadcore.max.uiwidget.basic.WebViewContainer;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d51;
import com.repackage.ez0;
import com.repackage.fi0;
import com.repackage.fn0;
import com.repackage.gn0;
import com.repackage.hn0;
import com.repackage.ho0;
import com.repackage.in0;
import com.repackage.mn0;
import com.repackage.no0;
import com.repackage.p51;
import com.repackage.q11;
import com.repackage.qh0;
import com.repackage.r51;
import com.repackage.tn0;
import com.repackage.um0;
import com.repackage.uy0;
import com.repackage.vm0;
import com.repackage.wm0;
import com.repackage.wn0;
import com.repackage.ym0;
import com.repackage.zn0;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J'\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PopoverComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "", "scrollUp", "handleActionUp", "(Z)V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "withAnim", "hideAdPopOver", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initPopoverData", "(Lorg/json/JSONObject;)V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "", "currentY", "videoHeight", "minTopMargin", "onScroll", "(III)V", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/model/AdLpParams$AlsModel;", "alsModel", "sendActionAls", "(Lcom/baidu/nadcore/model/AdLpParams$AlsModel;)V", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "criusPopFactory", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "Landroid/view/View;", "criusPopView", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "hasShowPop", "Z", "hasStartCountDown", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popoverModel", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popviewHeight", "I", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "<init>", "PopOverListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PopoverComponent extends AbsComponentPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r51<View> d;
    public zn0 e;
    public d51 f;
    public q11 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes2.dex */
    public final class a extends p51 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PopoverComponent a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(PopoverComponent popoverComponent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {popoverComponent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = popoverComponent;
        }

        @Override // com.repackage.p51
        public void a(boolean z, long j) {
            gn0 gn0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) || (gn0Var = (gn0) this.a.j().q(gn0.class)) == null) {
                return;
            }
            gn0Var.d(240L, true);
        }

        @Override // com.repackage.p51
        public void b(ho0 clickInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clickInfo) == null) {
                Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
                if (clickInfo.c) {
                    if (TextUtils.isEmpty(clickInfo.a) || TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                        fn0 fn0Var = (fn0) this.a.j().q(fn0.class);
                        if (fn0Var != null) {
                            fn0Var.j(false, true, false);
                        }
                    } else {
                        qh0.c(clickInfo.a, this.a.getContext());
                    }
                    wn0 wn0Var = PopoverComponent.p(this.a).e;
                    if (wn0Var != null) {
                        wn0Var.a();
                        wn0Var.b = clickInfo.b;
                        wn0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                        this.a.D(wn0Var);
                    }
                }
                this.a.j().l(new ym0(PopEventTypeEnum.CLICK_POP_UI));
            }
        }

        @Override // com.repackage.p51
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                gn0 gn0Var = (gn0) this.a.j().q(gn0.class);
                if (gn0Var != null) {
                    gn0Var.d(240L, false);
                }
                wn0 wn0Var = PopoverComponent.p(this.a).e;
                if (wn0Var != null) {
                    wn0Var.a();
                    wn0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                    this.a.D(wn0Var);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends q11.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PopoverComponent a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b(PopoverComponent popoverComponent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {popoverComponent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = popoverComponent;
        }

        @Override // com.repackage.q11.b
        public void b() {
            WebViewContainer b;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h) {
                r51 r51Var = this.a.d;
                if (r51Var != null) {
                    r51Var.c(PopoverComponent.p(this.a).a != 3);
                }
                if (PopoverComponent.p(this.a).a == 3) {
                    fn0 fn0Var = (fn0) this.a.j().q(fn0.class);
                    hn0 hn0Var = (hn0) this.a.j().q(hn0.class);
                    int max = Math.max(0, this.a.i - ((hn0Var != null ? hn0Var.getVideoHeight() : 0) - ((fn0Var == null || (b = fn0Var.b()) == null) ? 0 : b.getTopMargin())));
                    if (fn0Var != null) {
                        fn0Var.f(false, true, true, max);
                    }
                }
                q11 q11Var = this.a.g;
                if (q11Var != null) {
                    q11Var.a();
                }
                this.a.g = null;
            }
        }

        @Override // com.repackage.q11.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.h = true;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PopoverComponent a;

        public c(PopoverComponent popoverComponent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {popoverComponent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = popoverComponent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.v();
                q11 q11Var = this.a.g;
                if (q11Var != null) {
                    q11Var.e();
                }
            }
        }
    }

    public PopoverComponent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static final /* synthetic */ zn0 p(PopoverComponent popoverComponent) {
        zn0 zn0Var = popoverComponent.e;
        if (zn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return zn0Var;
    }

    public final void A(JSONObject jSONObject) {
        zn0 a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || (a2 = zn0.f.a(jSONObject)) == null) {
            return;
        }
        this.e = a2;
        String cmdStr = jSONObject.optString("cmd_map");
        Intrinsics.checkNotNullExpressionValue(cmdStr, "cmdStr");
        if (cmdStr.length() == 0) {
            return;
        }
        String popoverStr = jSONObject.optString("popover");
        Intrinsics.checkNotNullExpressionValue(popoverStr, "popoverStr");
        if (popoverStr.length() == 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject(cmdStr);
        JSONObject jSONObject3 = new JSONObject(popoverStr);
        uy0.f(jSONObject3, "cmd_map", jSONObject2);
        zn0 zn0Var = this.e;
        if (zn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        d51 d51Var = this.f;
        zn0Var.c = d51Var != null ? d51Var.a(jSONObject3) : null;
        zn0 zn0Var2 = this.e;
        if (zn0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (zn0Var2.c == null) {
            return;
        }
        zn0 zn0Var3 = this.e;
        if (zn0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (zn0Var3.a != 2) {
            zn0 zn0Var4 = this.e;
            if (zn0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (zn0Var4.a != 3) {
                zn0 zn0Var5 = this.e;
                if (zn0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (zn0Var5.a == 1) {
                    this.d = null;
                    return;
                }
                return;
            }
        }
        zn0 zn0Var6 = this.e;
        if (zn0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (zn0Var6.c == null) {
            return;
        }
        zn0 zn0Var7 = this.e;
        if (zn0Var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        tn0 c2 = tn0.c(uy0.c(jSONObject.optString("download")));
        zn0Var7.d = c2;
        if (c2 != null) {
            c2.b = jSONObject.optString("deferred_cmd");
        }
        wn0 wn0Var = new wn0();
        wn0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
        wn0Var.d = jSONObject.optString("ext_info");
        Unit unit = Unit.INSTANCE;
        zn0Var7.e = wn0Var;
        d51 d51Var2 = this.f;
        r51<View> b2 = d51Var2 != null ? d51Var2.b(getContext()) : null;
        this.d = b2;
        if (b2 == null) {
            j().v(this);
            return;
        }
        if (b2 != null) {
            zn0 zn0Var8 = this.e;
            if (zn0Var8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            b2.setData(zn0Var8);
            b2.setCriusPopListener(new a(this));
        }
        r51<View> r51Var = this.d;
        View realView = r51Var != null ? r51Var.getRealView() : null;
        if (realView != null) {
            realView.measure(-2, -2);
        }
        this.i = realView != null ? realView.getMeasuredHeight() : 0;
    }

    public final void B(int i, int i2, int i3) {
        r51<View> r51Var;
        View realView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3) == null) {
            zn0 zn0Var = this.e;
            if (zn0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (zn0Var.a == 3 && (r51Var = this.d) != null && (realView = r51Var.getRealView()) != null && this.j && realView.getVisibility() == 0) {
                if (i < i2 && i > i3) {
                    float f = i2;
                    float f2 = 0.75f * f;
                    float f3 = f - this.i;
                    float f4 = i;
                    if (f4 >= f3) {
                        realView.setAlpha(1.0f);
                        return;
                    } else {
                        realView.setAlpha(Math.max(0.0f, 1 - ((f3 - f4) / (f3 - f2))));
                        return;
                    }
                }
                y(false);
            }
        }
    }

    public final void C(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
            d51 d51Var = (d51) ServiceManager.getService(d51.a);
            this.f = d51Var;
            if (d51Var == null) {
                j().v(this);
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra("map");
            if (!(serializableExtra instanceof HashMap)) {
                serializableExtra = null;
            }
            HashMap hashMap = (HashMap) serializableExtra;
            if (hashMap != null) {
                JSONObject jSONObject = new JSONObject(hashMap);
                Object obj = hashMap.get("cmd_policy");
                String str = obj instanceof String ? obj : null;
                if (!TextUtils.isEmpty(str)) {
                    no0.g.a(uy0.c(str));
                }
                A(jSONObject);
                z();
            }
        }
    }

    public final void D(wn0 wn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wn0Var) == null) {
            ez0.b(new ClogBuilder().t(wn0Var.c).r(wn0Var.a).h(wn0Var.b).n(wn0Var.d).i(wn0Var.e).j(wn0Var.f).k(wn0Var.g));
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void b(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            super.b(intent);
            C(intent);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void c(fi0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.c(event);
            String a2 = event.a();
            if (Intrinsics.areEqual(a2, vm0.class.getSimpleName())) {
                x((vm0) event);
            } else if (Intrinsics.areEqual(a2, um0.class.getSimpleName())) {
                um0 um0Var = (um0) event;
                B(um0Var.c(), um0Var.d(), um0Var.b());
            } else if (Intrinsics.areEqual(a2, wm0.class.getSimpleName())) {
                w(((wm0) event).b());
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void h(ViewGroup parent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            parent.post(new c(this));
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            q11 q11Var = this.g;
            if (q11Var != null) {
                q11Var.b();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onRelease();
            y(false);
            r51<View> r51Var = this.d;
            if (r51Var != null) {
                r51Var.a();
            }
            this.d = null;
            q11 q11Var = this.g;
            if (q11Var != null) {
                q11Var.a();
            }
            this.g = null;
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        q11 q11Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            hn0 hn0Var = (hn0) j().q(hn0.class);
            if (hn0Var == null || !hn0Var.k() || (q11Var = this.g) == null) {
                return;
            }
            q11Var.c();
        }
    }

    public final void v() {
        hn0 hn0Var;
        in0 in0Var;
        r51<View> r51Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (hn0Var = (hn0) j().q(hn0.class)) == null || (in0Var = (in0) j().q(in0.class)) == null || (r51Var = this.d) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        zn0 zn0Var = this.e;
        if (zn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (zn0Var.a == 3) {
            layoutParams.gravity = 48;
        } else {
            layoutParams.gravity = 80;
        }
        zn0 zn0Var2 = this.e;
        if (zn0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        View g = zn0Var2.a == 3 ? in0Var.b().g() : hn0Var.h();
        if (!(g instanceof ViewGroup)) {
            g = null;
        }
        r51Var.setContainer((ViewGroup) g, layoutParams);
    }

    public final void w(boolean z) {
        r51<View> r51Var;
        View realView;
        hn0 hn0Var;
        fn0 fn0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            zn0 zn0Var = this.e;
            if (zn0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (zn0Var.a != 3 || (r51Var = this.d) == null || (realView = r51Var.getRealView()) == null || realView.getVisibility() != 0 || (hn0Var = (hn0) j().q(hn0.class)) == null || (fn0Var = (fn0) j().q(fn0.class)) == null || !hn0Var.k()) {
                return;
            }
            int videoHeight = hn0Var.getVideoHeight() - fn0Var.b().getTopMargin();
            if (z || videoHeight >= this.i / 2) {
                fn0Var.f(videoHeight > this.i, true, true, Math.abs(videoHeight - this.i));
            }
        }
    }

    public final void x(vm0 vm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, vm0Var) == null) {
            int i = mn0.$EnumSwitchMapping$0[vm0Var.getType().ordinal()];
            if (i == 1) {
                q11 q11Var = this.g;
                if (q11Var != null) {
                    q11Var.c();
                }
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.j = true;
            } else {
                q11 q11Var2 = this.g;
                if (q11Var2 != null) {
                    q11Var2.b();
                }
            }
        }
    }

    public final void y(boolean z) {
        r51<View> r51Var;
        View realView;
        r51<View> r51Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (r51Var = this.d) == null || (realView = r51Var.getRealView()) == null || realView.getVisibility() != 0 || (r51Var2 = this.d) == null) {
            return;
        }
        r51Var2.b("0", z);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            q11 q11Var = this.g;
            if (q11Var != null) {
                q11Var.a();
            }
            this.g = null;
            zn0 zn0Var = this.e;
            if (zn0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            q11 q11Var2 = new q11(zn0Var.b * 1000, 1000L);
            q11Var2.d(new b(this));
            this.g = q11Var2;
        }
    }
}
