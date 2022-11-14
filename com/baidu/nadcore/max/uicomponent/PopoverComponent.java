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
import com.baidu.tieba.a11;
import com.baidu.tieba.ap0;
import com.baidu.tieba.ep0;
import com.baidu.tieba.f41;
import com.baidu.tieba.fq0;
import com.baidu.tieba.j81;
import com.baidu.tieba.ji0;
import com.baidu.tieba.lp0;
import com.baidu.tieba.mo0;
import com.baidu.tieba.no0;
import com.baidu.tieba.oo0;
import com.baidu.tieba.op0;
import com.baidu.tieba.q01;
import com.baidu.tieba.qo0;
import com.baidu.tieba.rp0;
import com.baidu.tieba.v81;
import com.baidu.tieba.x81;
import com.baidu.tieba.xo0;
import com.baidu.tieba.yi0;
import com.baidu.tieba.yo0;
import com.baidu.tieba.zo0;
import com.baidu.tieba.zp0;
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
    public x81<View> d;
    public rp0 e;
    public j81 f;
    public f41 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes2.dex */
    public final class a extends v81 {
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

        @Override // com.baidu.tieba.v81
        public void a(boolean z, long j) {
            yo0 yo0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) && (yo0Var = (yo0) this.a.j().p(yo0.class)) != null) {
                yo0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.v81
        public void b(zp0 clickInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clickInfo) == null) {
                Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
                if (clickInfo.c) {
                    if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                        ji0.c(clickInfo.a, this.a.getContext());
                    } else {
                        xo0 xo0Var = (xo0) this.a.j().p(xo0.class);
                        if (xo0Var != null) {
                            xo0Var.j(false, true, false);
                        }
                    }
                    op0 op0Var = PopoverComponent.p(this.a).e;
                    if (op0Var != null) {
                        op0Var.a();
                        op0Var.b = clickInfo.b;
                        op0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                        this.a.E(op0Var);
                    }
                }
                this.a.j().k(new qo0(PopEventTypeEnum.CLICK_POP_UI));
            }
        }

        @Override // com.baidu.tieba.v81
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                yo0 yo0Var = (yo0) this.a.j().p(yo0.class);
                if (yo0Var != null) {
                    yo0Var.d(240L, false);
                }
                op0 op0Var = PopoverComponent.p(this.a).e;
                if (op0Var != null) {
                    op0Var.a();
                    op0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                    this.a.E(op0Var);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends f41.b {
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

        @Override // com.baidu.tieba.f41.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h) {
                x81 x81Var = this.a.d;
                if (x81Var != null) {
                    if (PopoverComponent.p(this.a).a != 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    x81Var.c(z);
                }
                if (PopoverComponent.p(this.a).a == 3) {
                    xo0 xo0Var = (xo0) this.a.j().p(xo0.class);
                    zo0 zo0Var = (zo0) this.a.j().p(zo0.class);
                    if (xo0Var != null && (b = xo0Var.b()) != null) {
                        i = b.getTopMargin();
                    } else {
                        i = 0;
                    }
                    if (zo0Var != null) {
                        i2 = zo0Var.getVideoHeight();
                    } else {
                        i2 = 0;
                    }
                    int max = Math.max(0, this.a.i - (i2 - i));
                    if (xo0Var != null) {
                        xo0Var.f(false, true, true, max);
                    }
                }
                f41 f41Var = this.a.g;
                if (f41Var != null) {
                    f41Var.a();
                }
                this.a.g = null;
            }
        }

        @Override // com.baidu.tieba.f41.b
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
            f41 f41Var = this.a.g;
            if (f41Var != null) {
                f41Var.e();
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
            f41 f41Var = this.g;
            if (f41Var != null) {
                f41Var.b();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onRelease();
            z(false);
            x81<View> x81Var = this.d;
            if (x81Var != null) {
                x81Var.a();
            }
            this.d = null;
            f41 f41Var = this.g;
            if (f41Var != null) {
                f41Var.a();
            }
            this.g = null;
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        f41 f41Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            zo0 zo0Var = (zo0) j().p(zo0.class);
            if (zo0Var != null && zo0Var.k() && (f41Var = this.g) != null) {
                f41Var.c();
            }
        }
    }

    public static final /* synthetic */ rp0 p(PopoverComponent popoverComponent) {
        rp0 rp0Var = popoverComponent.e;
        if (rp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return rp0Var;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void g(ViewGroup parent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, parent) == null) {
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
            D(intent);
        }
    }

    public final void z(boolean z) {
        x81<View> x81Var;
        View realView;
        x81<View> x81Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (x81Var = this.d) != null && (realView = x81Var.getRealView()) != null && realView.getVisibility() == 0 && (x81Var2 = this.d) != null) {
            x81Var2.b("0", z);
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f41 f41Var = this.g;
            if (f41Var != null) {
                f41Var.a();
            }
            this.g = null;
            rp0 rp0Var = this.e;
            if (rp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            f41 f41Var2 = new f41(rp0Var.b * 1000, 1000L);
            f41Var2.d(new b(this));
            this.g = f41Var2;
        }
    }

    public final void B(JSONObject jSONObject) {
        rp0 a2;
        boolean z;
        boolean z2;
        Object obj;
        x81<View> x81Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) && (a2 = rp0.f.a(jSONObject)) != null) {
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
            q01.f(jSONObject3, "cmd_map", jSONObject2);
            rp0 rp0Var = this.e;
            if (rp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            j81 j81Var = this.f;
            View view2 = null;
            if (j81Var != null) {
                obj = j81Var.a(jSONObject3);
            } else {
                obj = null;
            }
            rp0Var.c = obj;
            rp0 rp0Var2 = this.e;
            if (rp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (rp0Var2.c == null) {
                return;
            }
            rp0 rp0Var3 = this.e;
            if (rp0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (rp0Var3.a != 2) {
                rp0 rp0Var4 = this.e;
                if (rp0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (rp0Var4.a != 3) {
                    rp0 rp0Var5 = this.e;
                    if (rp0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (rp0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            rp0 rp0Var6 = this.e;
            if (rp0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (rp0Var6.c == null) {
                return;
            }
            rp0 rp0Var7 = this.e;
            if (rp0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            lp0 c2 = lp0.c(q01.c(jSONObject.optString("download")));
            rp0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            op0 op0Var = new op0();
            op0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            op0Var.d = jSONObject.optString("ext_info");
            Unit unit = Unit.INSTANCE;
            rp0Var7.e = op0Var;
            j81 j81Var2 = this.f;
            if (j81Var2 != null) {
                x81Var = j81Var2.b(getContext());
            } else {
                x81Var = null;
            }
            this.d = x81Var;
            if (x81Var == null) {
                j().u(this);
                return;
            }
            if (x81Var != null) {
                rp0 rp0Var8 = this.e;
                if (rp0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                x81Var.setData(rp0Var8);
                x81Var.setCriusPopListener(new a(this));
            }
            x81<View> x81Var2 = this.d;
            if (x81Var2 != null) {
                view2 = x81Var2.getRealView();
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

    public final void C(int i, int i2, int i3) {
        x81<View> x81Var;
        View realView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3) == null) {
            rp0 rp0Var = this.e;
            if (rp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (rp0Var.a != 3 || (x81Var = this.d) == null || (realView = x81Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
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

    public final void D(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            j81 j81Var = (j81) ServiceManager.getService(j81.a);
            this.f = j81Var;
            if (j81Var == null) {
                j().u(this);
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
                    fq0.f.a(q01.c(str2));
                }
                B(jSONObject);
                A();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void b(yi0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.b(event);
            String a2 = event.a();
            if (Intrinsics.areEqual(a2, no0.class.getSimpleName())) {
                y((no0) event);
            } else if (Intrinsics.areEqual(a2, mo0.class.getSimpleName())) {
                mo0 mo0Var = (mo0) event;
                C(mo0Var.c(), mo0Var.d(), mo0Var.b());
            } else if (Intrinsics.areEqual(a2, oo0.class.getSimpleName())) {
                x(((oo0) event).b());
            }
        }
    }

    public final void E(op0 op0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, op0Var) == null) {
            a11.b(new ClogBuilder().z(op0Var.c).v(op0Var.a).j(op0Var.b).p(op0Var.d).k(op0Var.e).l(op0Var.f).m(op0Var.g));
        }
    }

    public final void y(no0 no0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, no0Var) == null) {
            int i = ep0.$EnumSwitchMapping$0[no0Var.getType().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.j = true;
                        return;
                    }
                    return;
                }
                f41 f41Var = this.g;
                if (f41Var != null) {
                    f41Var.b();
                    return;
                }
                return;
            }
            f41 f41Var2 = this.g;
            if (f41Var2 != null) {
                f41Var2.c();
            }
        }
    }

    public final void w() {
        zo0 zo0Var;
        ap0 ap0Var;
        x81<View> x81Var;
        View h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (zo0Var = (zo0) j().p(zo0.class)) != null && (ap0Var = (ap0) j().p(ap0.class)) != null && (x81Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            rp0 rp0Var = this.e;
            if (rp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (rp0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            rp0 rp0Var2 = this.e;
            if (rp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (rp0Var2.a == 3) {
                h = ap0Var.b().i();
            } else {
                h = zo0Var.h();
            }
            if (!(h instanceof ViewGroup)) {
                h = null;
            }
            x81Var.setContainer((ViewGroup) h, layoutParams);
        }
    }

    public final void x(boolean z) {
        x81<View> x81Var;
        View realView;
        zo0 zo0Var;
        xo0 xo0Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            rp0 rp0Var = this.e;
            if (rp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (rp0Var.a != 3 || (x81Var = this.d) == null || (realView = x81Var.getRealView()) == null || realView.getVisibility() != 0 || (zo0Var = (zo0) j().p(zo0.class)) == null || (xo0Var = (xo0) j().p(xo0.class)) == null || !zo0Var.k()) {
                return;
            }
            int videoHeight = zo0Var.getVideoHeight() - xo0Var.b().getTopMargin();
            if (!z && videoHeight < this.i / 2) {
                return;
            }
            int abs = Math.abs(videoHeight - this.i);
            if (videoHeight > this.i) {
                z2 = true;
            } else {
                z2 = false;
            }
            xo0Var.f(z2, true, true, abs);
        }
    }
}
