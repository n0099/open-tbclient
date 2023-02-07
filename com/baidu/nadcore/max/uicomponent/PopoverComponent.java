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
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.fr0;
import com.baidu.tieba.hp0;
import com.baidu.tieba.ip0;
import com.baidu.tieba.jp0;
import com.baidu.tieba.kd1;
import com.baidu.tieba.lj0;
import com.baidu.tieba.lp0;
import com.baidu.tieba.lq0;
import com.baidu.tieba.md1;
import com.baidu.tieba.n21;
import com.baidu.tieba.oq0;
import com.baidu.tieba.rq0;
import com.baidu.tieba.sp0;
import com.baidu.tieba.t51;
import com.baidu.tieba.tp0;
import com.baidu.tieba.up0;
import com.baidu.tieba.vp0;
import com.baidu.tieba.wi0;
import com.baidu.tieba.y11;
import com.baidu.tieba.yc1;
import com.baidu.tieba.zp0;
import com.baidu.tieba.zq0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J'\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PopoverComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "", "scrollUp", "handleActionUp", "(Z)V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "withAnim", "hideAdPopOver", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initPopoverData", "(Lorg/json/JSONObject;)V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", IntentData.KEY, "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "", "currentY", "videoHeight", "minTopMargin", "onScroll", "(III)V", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/model/AdLpParams$AlsModel;", "alsModel", "sendActionAls", "(Lcom/baidu/nadcore/model/AdLpParams$AlsModel;)V", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "criusPopFactory", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "Landroid/view/View;", "criusPopView", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "hasShowPop", "Z", "hasStartCountDown", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popoverModel", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popviewHeight", "I", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "<init>", "PopOverListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PopoverComponent extends AbsComponentPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public md1<View> d;
    public rq0 e;
    public yc1 f;
    public t51 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes2.dex */
    public final class a extends kd1 {
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

        @Override // com.baidu.tieba.kd1
        public void a(boolean z, long j) {
            tp0 tp0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) && (tp0Var = (tp0) this.a.b().j(tp0.class)) != null) {
                tp0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.kd1
        public void b(zq0 clickInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clickInfo) == null) {
                Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
                if (clickInfo.c) {
                    if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                        wi0.c(clickInfo.a, this.a.getContext());
                    } else {
                        sp0 sp0Var = (sp0) this.a.b().j(sp0.class);
                        if (sp0Var != null) {
                            sp0Var.j(false, true, false);
                        }
                    }
                    oq0 oq0Var = PopoverComponent.l(this.a).e;
                    if (oq0Var != null) {
                        oq0Var.a();
                        oq0Var.b = clickInfo.b;
                        oq0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                        this.a.F(oq0Var);
                    }
                }
                this.a.b().d(new lp0(PopEventTypeEnum.CLICK_POP_UI));
            }
        }

        @Override // com.baidu.tieba.kd1
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                tp0 tp0Var = (tp0) this.a.b().j(tp0.class);
                if (tp0Var != null) {
                    tp0Var.d(240L, false);
                }
                oq0 oq0Var = PopoverComponent.l(this.a).e;
                if (oq0Var != null) {
                    oq0Var.a();
                    oq0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                    this.a.F(oq0Var);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends t51.b {
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

        @Override // com.baidu.tieba.t51.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h) {
                md1 md1Var = this.a.d;
                if (md1Var != null) {
                    if (PopoverComponent.l(this.a).a != 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    md1Var.c(z);
                }
                if (PopoverComponent.l(this.a).a == 3) {
                    sp0 sp0Var = (sp0) this.a.b().j(sp0.class);
                    up0 up0Var = (up0) this.a.b().j(up0.class);
                    if (sp0Var != null && (b = sp0Var.b()) != null) {
                        i = b.getTopMargin();
                    } else {
                        i = 0;
                    }
                    if (up0Var != null) {
                        i2 = up0Var.getVideoHeight();
                    } else {
                        i2 = 0;
                    }
                    int max = Math.max(0, this.a.i - (i2 - i));
                    if (sp0Var != null) {
                        sp0Var.f(false, true, true, max);
                    }
                }
                t51 t51Var = this.a.g;
                if (t51Var != null) {
                    t51Var.a();
                }
                this.a.g = null;
            }
        }

        @Override // com.baidu.tieba.t51.b
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.w();
            t51 t51Var = this.a.g;
            if (t51Var != null) {
                t51Var.e();
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

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPause();
            t51 t51Var = this.g;
            if (t51Var != null) {
                t51Var.b();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onRelease();
            z(false);
            md1<View> md1Var = this.d;
            if (md1Var != null) {
                md1Var.a();
            }
            this.d = null;
            t51 t51Var = this.g;
            if (t51Var != null) {
                t51Var.a();
            }
            this.g = null;
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        t51 t51Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            up0 up0Var = (up0) b().j(up0.class);
            if (up0Var != null && up0Var.k() && (t51Var = this.g) != null) {
                t51Var.c();
            }
        }
    }

    public static final /* synthetic */ rq0 l(PopoverComponent popoverComponent) {
        rq0 rq0Var = popoverComponent.e;
        if (rq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return rq0Var;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void C(ViewGroup parent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            parent.post(new c(this));
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            super.onNewIntent(intent);
            E(intent);
        }
    }

    public final void z(boolean z) {
        md1<View> md1Var;
        View realView;
        md1<View> md1Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (md1Var = this.d) != null && (realView = md1Var.getRealView()) != null && realView.getVisibility() == 0 && (md1Var2 = this.d) != null) {
            md1Var2.b("0", z);
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            t51 t51Var = this.g;
            if (t51Var != null) {
                t51Var.a();
            }
            this.g = null;
            rq0 rq0Var = this.e;
            if (rq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            t51 t51Var2 = new t51(rq0Var.b * 1000, 1000L);
            t51Var2.d(new b(this));
            this.g = t51Var2;
        }
    }

    public final void B(JSONObject jSONObject) {
        rq0 a2;
        boolean z;
        boolean z2;
        Object obj;
        md1<View> md1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) && (a2 = rq0.f.a(jSONObject)) != null) {
            this.e = a2;
            String cmdStr = jSONObject.optString("cmd_map");
            Intrinsics.checkNotNullExpressionValue(cmdStr, "cmdStr");
            int i = 0;
            if (cmdStr.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
            String popoverStr = jSONObject.optString("popover");
            Intrinsics.checkNotNullExpressionValue(popoverStr, "popoverStr");
            if (popoverStr.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(cmdStr);
            JSONObject jSONObject3 = new JSONObject(popoverStr);
            y11.f(jSONObject3, "cmd_map", jSONObject2);
            rq0 rq0Var = this.e;
            if (rq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            yc1 yc1Var = this.f;
            View view2 = null;
            if (yc1Var != null) {
                obj = yc1Var.a(jSONObject3);
            } else {
                obj = null;
            }
            rq0Var.c = obj;
            rq0 rq0Var2 = this.e;
            if (rq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (rq0Var2.c == null) {
                return;
            }
            rq0 rq0Var3 = this.e;
            if (rq0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (rq0Var3.a != 2) {
                rq0 rq0Var4 = this.e;
                if (rq0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (rq0Var4.a != 3) {
                    rq0 rq0Var5 = this.e;
                    if (rq0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (rq0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            rq0 rq0Var6 = this.e;
            if (rq0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (rq0Var6.c == null) {
                return;
            }
            rq0 rq0Var7 = this.e;
            if (rq0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            lq0 c2 = lq0.c(y11.c(jSONObject.optString("download")));
            rq0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            oq0 oq0Var = new oq0();
            oq0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            oq0Var.d = jSONObject.optString("ext_info");
            Unit unit = Unit.INSTANCE;
            rq0Var7.e = oq0Var;
            yc1 yc1Var2 = this.f;
            if (yc1Var2 != null) {
                md1Var = yc1Var2.b(getContext());
            } else {
                md1Var = null;
            }
            this.d = md1Var;
            if (md1Var == null) {
                b().q(this);
                return;
            }
            if (md1Var != null) {
                rq0 rq0Var8 = this.e;
                if (rq0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                md1Var.setData(rq0Var8);
                md1Var.setCriusPopListener(new a(this));
            }
            md1<View> md1Var2 = this.d;
            if (md1Var2 != null) {
                view2 = md1Var2.getRealView();
            }
            if (view2 != null) {
                view2.measure(-2, -2);
            }
            if (view2 != null) {
                i = view2.getMeasuredHeight();
            }
            this.i = i;
        }
    }

    public final void D(int i, int i2, int i3) {
        md1<View> md1Var;
        View realView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i, i2, i3) == null) {
            rq0 rq0Var = this.e;
            if (rq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (rq0Var.a != 3 || (md1Var = this.d) == null || (realView = md1Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
                return;
            }
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
            z(false);
        }
    }

    public final void E(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            yc1 yc1Var = (yc1) ServiceManager.getService(yc1.a);
            this.f = yc1Var;
            if (yc1Var == null) {
                b().q(this);
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra("map");
            String str = null;
            if (!(serializableExtra instanceof HashMap)) {
                serializableExtra = null;
            }
            HashMap hashMap = (HashMap) serializableExtra;
            if (hashMap != null) {
                JSONObject jSONObject = new JSONObject(hashMap);
                Object obj = hashMap.get("cmd_policy");
                if (obj instanceof String) {
                    str = obj;
                }
                String str2 = str;
                if (!TextUtils.isEmpty(str2)) {
                    fr0.n.a(y11.c(str2));
                }
                B(jSONObject);
                A();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void o(lj0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.o(event);
            String a2 = event.a();
            if (Intrinsics.areEqual(a2, ip0.class.getSimpleName())) {
                y((ip0) event);
            } else if (Intrinsics.areEqual(a2, hp0.class.getSimpleName())) {
                hp0 hp0Var = (hp0) event;
                D(hp0Var.c(), hp0Var.d(), hp0Var.b());
            } else if (Intrinsics.areEqual(a2, jp0.class.getSimpleName())) {
                x(((jp0) event).b());
            }
        }
    }

    public final void F(oq0 oq0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, oq0Var) == null) {
            n21.b(new ClogBuilder().z(oq0Var.c).v(oq0Var.a).j(oq0Var.b).p(oq0Var.d).k(oq0Var.e).l(oq0Var.f).m(oq0Var.g));
        }
    }

    public final void y(ip0 ip0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ip0Var) == null) {
            int i = zp0.$EnumSwitchMapping$0[ip0Var.getType().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.j = true;
                        return;
                    }
                    return;
                }
                t51 t51Var = this.g;
                if (t51Var != null) {
                    t51Var.b();
                    return;
                }
                return;
            }
            t51 t51Var2 = this.g;
            if (t51Var2 != null) {
                t51Var2.c();
            }
        }
    }

    public final void w() {
        up0 up0Var;
        vp0 vp0Var;
        md1<View> md1Var;
        View h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (up0Var = (up0) b().j(up0.class)) != null && (vp0Var = (vp0) b().j(vp0.class)) != null && (md1Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            rq0 rq0Var = this.e;
            if (rq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (rq0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            rq0 rq0Var2 = this.e;
            if (rq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (rq0Var2.a == 3) {
                h = vp0Var.b().l();
            } else {
                h = up0Var.h();
            }
            if (!(h instanceof ViewGroup)) {
                h = null;
            }
            md1Var.setContainer((ViewGroup) h, layoutParams);
        }
    }

    public final void x(boolean z) {
        md1<View> md1Var;
        View realView;
        up0 up0Var;
        sp0 sp0Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            rq0 rq0Var = this.e;
            if (rq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (rq0Var.a != 3 || (md1Var = this.d) == null || (realView = md1Var.getRealView()) == null || realView.getVisibility() != 0 || (up0Var = (up0) b().j(up0.class)) == null || (sp0Var = (sp0) b().j(sp0.class)) == null || !up0Var.k()) {
                return;
            }
            int videoHeight = up0Var.getVideoHeight() - sp0Var.b().getTopMargin();
            if (!z && videoHeight < this.i / 2) {
                return;
            }
            int abs = Math.abs(videoHeight - this.i);
            if (videoHeight > this.i) {
                z2 = true;
            } else {
                z2 = false;
            }
            sp0Var.f(z2, true, true, abs);
        }
    }
}
