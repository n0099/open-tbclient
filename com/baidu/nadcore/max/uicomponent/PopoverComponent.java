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
import com.repackage.am0;
import com.repackage.an0;
import com.repackage.cm0;
import com.repackage.dn0;
import com.repackage.f11;
import com.repackage.f51;
import com.repackage.fh0;
import com.repackage.h51;
import com.repackage.iy0;
import com.repackage.jm0;
import com.repackage.km0;
import com.repackage.lm0;
import com.repackage.ln0;
import com.repackage.mm0;
import com.repackage.qg0;
import com.repackage.qm0;
import com.repackage.rn0;
import com.repackage.t41;
import com.repackage.xm0;
import com.repackage.yl0;
import com.repackage.yx0;
import com.repackage.zl0;
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
    public h51<View> d;
    public dn0 e;
    public t41 f;
    public f11 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes2.dex */
    public final class a extends f51 {
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

        @Override // com.repackage.f51
        public void a(boolean z, long j) {
            km0 km0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) || (km0Var = (km0) this.a.l().q(km0.class)) == null) {
                return;
            }
            km0Var.d(240L, true);
        }

        @Override // com.repackage.f51
        public void b(ln0 clickInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clickInfo) == null) {
                Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
                if (clickInfo.c) {
                    if (TextUtils.isEmpty(clickInfo.a) || TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                        jm0 jm0Var = (jm0) this.a.l().q(jm0.class);
                        if (jm0Var != null) {
                            jm0Var.j(false, true, false);
                        }
                    } else {
                        qg0.c(clickInfo.a, this.a.getContext());
                    }
                    an0 an0Var = PopoverComponent.r(this.a).e;
                    if (an0Var != null) {
                        an0Var.a();
                        an0Var.b = clickInfo.b;
                        an0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                        this.a.F(an0Var);
                    }
                }
                this.a.l().l(new cm0(PopEventTypeEnum.CLICK_POP_UI));
            }
        }

        @Override // com.repackage.f51
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                km0 km0Var = (km0) this.a.l().q(km0.class);
                if (km0Var != null) {
                    km0Var.d(240L, false);
                }
                an0 an0Var = PopoverComponent.r(this.a).e;
                if (an0Var != null) {
                    an0Var.a();
                    an0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                    this.a.F(an0Var);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends f11.b {
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

        @Override // com.repackage.f11.b
        public void b() {
            WebViewContainer b;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h) {
                h51 h51Var = this.a.d;
                if (h51Var != null) {
                    h51Var.c(PopoverComponent.r(this.a).a != 3);
                }
                if (PopoverComponent.r(this.a).a == 3) {
                    jm0 jm0Var = (jm0) this.a.l().q(jm0.class);
                    lm0 lm0Var = (lm0) this.a.l().q(lm0.class);
                    int max = Math.max(0, this.a.i - ((lm0Var != null ? lm0Var.getVideoHeight() : 0) - ((jm0Var == null || (b = jm0Var.b()) == null) ? 0 : b.getTopMargin())));
                    if (jm0Var != null) {
                        jm0Var.f(false, true, true, max);
                    }
                }
                f11 f11Var = this.a.g;
                if (f11Var != null) {
                    f11Var.a();
                }
                this.a.g = null;
            }
        }

        @Override // com.repackage.f11.b
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
                this.a.x();
                f11 f11Var = this.a.g;
                if (f11Var != null) {
                    f11Var.e();
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

    public static final /* synthetic */ dn0 r(PopoverComponent popoverComponent) {
        dn0 dn0Var = popoverComponent.e;
        if (dn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return dn0Var;
    }

    public final void A(boolean z) {
        h51<View> h51Var;
        View realView;
        h51<View> h51Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (h51Var = this.d) == null || (realView = h51Var.getRealView()) == null || realView.getVisibility() != 0 || (h51Var2 = this.d) == null) {
            return;
        }
        h51Var2.b("0", z);
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f11 f11Var = this.g;
            if (f11Var != null) {
                f11Var.a();
            }
            this.g = null;
            dn0 dn0Var = this.e;
            if (dn0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            f11 f11Var2 = new f11(dn0Var.b * 1000, 1000L);
            f11Var2.d(new b(this));
            this.g = f11Var2;
        }
    }

    public final void C(JSONObject jSONObject) {
        dn0 a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || (a2 = dn0.f.a(jSONObject)) == null) {
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
        yx0.f(jSONObject3, "cmd_map", jSONObject2);
        dn0 dn0Var = this.e;
        if (dn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        t41 t41Var = this.f;
        dn0Var.c = t41Var != null ? t41Var.a(jSONObject3) : null;
        dn0 dn0Var2 = this.e;
        if (dn0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (dn0Var2.c == null) {
            return;
        }
        dn0 dn0Var3 = this.e;
        if (dn0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (dn0Var3.a != 2) {
            dn0 dn0Var4 = this.e;
            if (dn0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (dn0Var4.a != 3) {
                dn0 dn0Var5 = this.e;
                if (dn0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (dn0Var5.a == 1) {
                    this.d = null;
                    return;
                }
                return;
            }
        }
        dn0 dn0Var6 = this.e;
        if (dn0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (dn0Var6.c == null) {
            return;
        }
        dn0 dn0Var7 = this.e;
        if (dn0Var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        xm0 c2 = xm0.c(yx0.c(jSONObject.optString("download")));
        dn0Var7.d = c2;
        if (c2 != null) {
            c2.b = jSONObject.optString("deferred_cmd");
        }
        an0 an0Var = new an0();
        an0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
        an0Var.d = jSONObject.optString("ext_info");
        Unit unit = Unit.INSTANCE;
        dn0Var7.e = an0Var;
        t41 t41Var2 = this.f;
        h51<View> b2 = t41Var2 != null ? t41Var2.b(getContext()) : null;
        this.d = b2;
        if (b2 == null) {
            l().v(this);
            return;
        }
        if (b2 != null) {
            dn0 dn0Var8 = this.e;
            if (dn0Var8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            b2.setData(dn0Var8);
            b2.setCriusPopListener(new a(this));
        }
        h51<View> h51Var = this.d;
        View realView = h51Var != null ? h51Var.getRealView() : null;
        if (realView != null) {
            realView.measure(-2, -2);
        }
        this.i = realView != null ? realView.getMeasuredHeight() : 0;
    }

    public final void D(int i, int i2, int i3) {
        h51<View> h51Var;
        View realView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i, i2, i3) == null) {
            dn0 dn0Var = this.e;
            if (dn0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (dn0Var.a == 3 && (h51Var = this.d) != null && (realView = h51Var.getRealView()) != null && this.j && realView.getVisibility() == 0) {
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
                A(false);
            }
        }
    }

    public final void E(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            t41 t41Var = (t41) ServiceManager.getService(t41.a);
            this.f = t41Var;
            if (t41Var == null) {
                l().v(this);
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
                    rn0.g.a(yx0.c(str));
                }
                C(jSONObject);
                B();
            }
        }
    }

    public final void F(an0 an0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, an0Var) == null) {
            iy0.b(new ClogBuilder().z(an0Var.c).v(an0Var.a).j(an0Var.b).p(an0Var.d).k(an0Var.e).l(an0Var.f).m(an0Var.g));
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void b(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            super.b(intent);
            E(intent);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void c(fh0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.c(event);
            String a2 = event.a();
            if (Intrinsics.areEqual(a2, zl0.class.getSimpleName())) {
                z((zl0) event);
            } else if (Intrinsics.areEqual(a2, yl0.class.getSimpleName())) {
                yl0 yl0Var = (yl0) event;
                D(yl0Var.c(), yl0Var.d(), yl0Var.b());
            } else if (Intrinsics.areEqual(a2, am0.class.getSimpleName())) {
                y(((am0) event).b());
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void i(ViewGroup parent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            parent.post(new c(this));
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            f11 f11Var = this.g;
            if (f11Var != null) {
                f11Var.b();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onRelease();
            A(false);
            h51<View> h51Var = this.d;
            if (h51Var != null) {
                h51Var.a();
            }
            this.d = null;
            f11 f11Var = this.g;
            if (f11Var != null) {
                f11Var.a();
            }
            this.g = null;
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        f11 f11Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            lm0 lm0Var = (lm0) l().q(lm0.class);
            if (lm0Var == null || !lm0Var.k() || (f11Var = this.g) == null) {
                return;
            }
            f11Var.c();
        }
    }

    public final void x() {
        lm0 lm0Var;
        mm0 mm0Var;
        h51<View> h51Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (lm0Var = (lm0) l().q(lm0.class)) == null || (mm0Var = (mm0) l().q(mm0.class)) == null || (h51Var = this.d) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        dn0 dn0Var = this.e;
        if (dn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (dn0Var.a == 3) {
            layoutParams.gravity = 48;
        } else {
            layoutParams.gravity = 80;
        }
        dn0 dn0Var2 = this.e;
        if (dn0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        View g = dn0Var2.a == 3 ? mm0Var.b().g() : lm0Var.h();
        if (!(g instanceof ViewGroup)) {
            g = null;
        }
        h51Var.setContainer((ViewGroup) g, layoutParams);
    }

    public final void y(boolean z) {
        h51<View> h51Var;
        View realView;
        lm0 lm0Var;
        jm0 jm0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            dn0 dn0Var = this.e;
            if (dn0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (dn0Var.a != 3 || (h51Var = this.d) == null || (realView = h51Var.getRealView()) == null || realView.getVisibility() != 0 || (lm0Var = (lm0) l().q(lm0.class)) == null || (jm0Var = (jm0) l().q(jm0.class)) == null || !lm0Var.k()) {
                return;
            }
            int videoHeight = lm0Var.getVideoHeight() - jm0Var.b().getTopMargin();
            if (z || videoHeight >= this.i / 2) {
                jm0Var.f(videoHeight > this.i, true, true, Math.abs(videoHeight - this.i));
            }
        }
    }

    public final void z(zl0 zl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, zl0Var) == null) {
            int i = qm0.$EnumSwitchMapping$0[zl0Var.getType().ordinal()];
            if (i == 1) {
                f11 f11Var = this.g;
                if (f11Var != null) {
                    f11Var.c();
                }
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.j = true;
            } else {
                f11 f11Var2 = this.g;
                if (f11Var2 != null) {
                    f11Var2.b();
                }
            }
        }
    }
}
