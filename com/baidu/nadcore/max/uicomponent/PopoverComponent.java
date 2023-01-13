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
import com.baidu.tieba.b91;
import com.baidu.tieba.bp0;
import com.baidu.tieba.cj0;
import com.baidu.tieba.cp0;
import com.baidu.tieba.dp0;
import com.baidu.tieba.dq0;
import com.baidu.tieba.e11;
import com.baidu.tieba.ep0;
import com.baidu.tieba.ip0;
import com.baidu.tieba.j41;
import com.baidu.tieba.jq0;
import com.baidu.tieba.n81;
import com.baidu.tieba.ni0;
import com.baidu.tieba.pp0;
import com.baidu.tieba.qo0;
import com.baidu.tieba.ro0;
import com.baidu.tieba.so0;
import com.baidu.tieba.sp0;
import com.baidu.tieba.u01;
import com.baidu.tieba.uo0;
import com.baidu.tieba.vp0;
import com.baidu.tieba.z81;
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
    public b91<View> d;
    public vp0 e;
    public n81 f;
    public j41 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes2.dex */
    public final class a extends z81 {
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

        @Override // com.baidu.tieba.z81
        public void a(boolean z, long j) {
            cp0 cp0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) && (cp0Var = (cp0) this.a.b().j(cp0.class)) != null) {
                cp0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.z81
        public void b(dq0 clickInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clickInfo) == null) {
                Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
                if (clickInfo.c) {
                    if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                        ni0.c(clickInfo.a, this.a.getContext());
                    } else {
                        bp0 bp0Var = (bp0) this.a.b().j(bp0.class);
                        if (bp0Var != null) {
                            bp0Var.j(false, true, false);
                        }
                    }
                    sp0 sp0Var = PopoverComponent.j(this.a).e;
                    if (sp0Var != null) {
                        sp0Var.a();
                        sp0Var.b = clickInfo.b;
                        sp0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                        this.a.E(sp0Var);
                    }
                }
                this.a.b().d(new uo0(PopEventTypeEnum.CLICK_POP_UI));
            }
        }

        @Override // com.baidu.tieba.z81
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                cp0 cp0Var = (cp0) this.a.b().j(cp0.class);
                if (cp0Var != null) {
                    cp0Var.d(240L, false);
                }
                sp0 sp0Var = PopoverComponent.j(this.a).e;
                if (sp0Var != null) {
                    sp0Var.a();
                    sp0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                    this.a.E(sp0Var);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends j41.b {
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

        @Override // com.baidu.tieba.j41.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h) {
                b91 b91Var = this.a.d;
                if (b91Var != null) {
                    if (PopoverComponent.j(this.a).a != 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    b91Var.c(z);
                }
                if (PopoverComponent.j(this.a).a == 3) {
                    bp0 bp0Var = (bp0) this.a.b().j(bp0.class);
                    dp0 dp0Var = (dp0) this.a.b().j(dp0.class);
                    if (bp0Var != null && (b = bp0Var.b()) != null) {
                        i = b.getTopMargin();
                    } else {
                        i = 0;
                    }
                    if (dp0Var != null) {
                        i2 = dp0Var.getVideoHeight();
                    } else {
                        i2 = 0;
                    }
                    int max = Math.max(0, this.a.i - (i2 - i));
                    if (bp0Var != null) {
                        bp0Var.f(false, true, true, max);
                    }
                }
                j41 j41Var = this.a.g;
                if (j41Var != null) {
                    j41Var.a();
                }
                this.a.g = null;
            }
        }

        @Override // com.baidu.tieba.j41.b
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
            this.a.t();
            j41 j41Var = this.a.g;
            if (j41Var != null) {
                j41Var.e();
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
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            j41 j41Var = this.g;
            if (j41Var != null) {
                j41Var.b();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onRelease();
            y(false);
            b91<View> b91Var = this.d;
            if (b91Var != null) {
                b91Var.a();
            }
            this.d = null;
            j41 j41Var = this.g;
            if (j41Var != null) {
                j41Var.a();
            }
            this.g = null;
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        j41 j41Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            dp0 dp0Var = (dp0) b().j(dp0.class);
            if (dp0Var != null && dp0Var.k() && (j41Var = this.g) != null) {
                j41Var.c();
            }
        }
    }

    public static final /* synthetic */ vp0 j(PopoverComponent popoverComponent) {
        vp0 vp0Var = popoverComponent.e;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return vp0Var;
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
        if (interceptable == null || interceptable.invokeL(1048582, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            super.onNewIntent(intent);
            D(intent);
        }
    }

    public final void y(boolean z) {
        b91<View> b91Var;
        View realView;
        b91<View> b91Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (b91Var = this.d) != null && (realView = b91Var.getRealView()) != null && realView.getVisibility() == 0 && (b91Var2 = this.d) != null) {
            b91Var2.b("0", z);
        }
    }

    public final void A(JSONObject jSONObject) {
        vp0 a2;
        boolean z;
        boolean z2;
        Object obj;
        b91<View> b91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && (a2 = vp0.f.a(jSONObject)) != null) {
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
            u01.f(jSONObject3, "cmd_map", jSONObject2);
            vp0 vp0Var = this.e;
            if (vp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            n81 n81Var = this.f;
            View view2 = null;
            if (n81Var != null) {
                obj = n81Var.a(jSONObject3);
            } else {
                obj = null;
            }
            vp0Var.c = obj;
            vp0 vp0Var2 = this.e;
            if (vp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (vp0Var2.c == null) {
                return;
            }
            vp0 vp0Var3 = this.e;
            if (vp0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (vp0Var3.a != 2) {
                vp0 vp0Var4 = this.e;
                if (vp0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (vp0Var4.a != 3) {
                    vp0 vp0Var5 = this.e;
                    if (vp0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (vp0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            vp0 vp0Var6 = this.e;
            if (vp0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (vp0Var6.c == null) {
                return;
            }
            vp0 vp0Var7 = this.e;
            if (vp0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            pp0 c2 = pp0.c(u01.c(jSONObject.optString("download")));
            vp0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            sp0 sp0Var = new sp0();
            sp0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            sp0Var.d = jSONObject.optString("ext_info");
            Unit unit = Unit.INSTANCE;
            vp0Var7.e = sp0Var;
            n81 n81Var2 = this.f;
            if (n81Var2 != null) {
                b91Var = n81Var2.b(getContext());
            } else {
                b91Var = null;
            }
            this.d = b91Var;
            if (b91Var == null) {
                b().q(this);
                return;
            }
            if (b91Var != null) {
                vp0 vp0Var8 = this.e;
                if (vp0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                b91Var.setData(vp0Var8);
                b91Var.setCriusPopListener(new a(this));
            }
            b91<View> b91Var2 = this.d;
            if (b91Var2 != null) {
                view2 = b91Var2.getRealView();
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

    public final void B(int i, int i2, int i3) {
        b91<View> b91Var;
        View realView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3) == null) {
            vp0 vp0Var = this.e;
            if (vp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (vp0Var.a != 3 || (b91Var = this.d) == null || (realView = b91Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
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
            y(false);
        }
    }

    public final void D(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            n81 n81Var = (n81) ServiceManager.getService(n81.a);
            this.f = n81Var;
            if (n81Var == null) {
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
                    jq0.f.a(u01.c(str2));
                }
                A(jSONObject);
                z();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void o(cj0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.o(event);
            String a2 = event.a();
            if (Intrinsics.areEqual(a2, ro0.class.getSimpleName())) {
                x((ro0) event);
            } else if (Intrinsics.areEqual(a2, qo0.class.getSimpleName())) {
                qo0 qo0Var = (qo0) event;
                B(qo0Var.c(), qo0Var.d(), qo0Var.b());
            } else if (Intrinsics.areEqual(a2, so0.class.getSimpleName())) {
                w(((so0) event).b());
            }
        }
    }

    public final void E(sp0 sp0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sp0Var) == null) {
            e11.b(new ClogBuilder().z(sp0Var.c).v(sp0Var.a).j(sp0Var.b).p(sp0Var.d).k(sp0Var.e).l(sp0Var.f).m(sp0Var.g));
        }
    }

    public final void x(ro0 ro0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ro0Var) == null) {
            int i = ip0.$EnumSwitchMapping$0[ro0Var.getType().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.j = true;
                        return;
                    }
                    return;
                }
                j41 j41Var = this.g;
                if (j41Var != null) {
                    j41Var.b();
                    return;
                }
                return;
            }
            j41 j41Var2 = this.g;
            if (j41Var2 != null) {
                j41Var2.c();
            }
        }
    }

    public final void t() {
        dp0 dp0Var;
        ep0 ep0Var;
        b91<View> b91Var;
        View h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (dp0Var = (dp0) b().j(dp0.class)) != null && (ep0Var = (ep0) b().j(ep0.class)) != null && (b91Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            vp0 vp0Var = this.e;
            if (vp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (vp0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            vp0 vp0Var2 = this.e;
            if (vp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (vp0Var2.a == 3) {
                h = ep0Var.b().i();
            } else {
                h = dp0Var.h();
            }
            if (!(h instanceof ViewGroup)) {
                h = null;
            }
            b91Var.setContainer((ViewGroup) h, layoutParams);
        }
    }

    public final void w(boolean z) {
        b91<View> b91Var;
        View realView;
        dp0 dp0Var;
        bp0 bp0Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            vp0 vp0Var = this.e;
            if (vp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (vp0Var.a != 3 || (b91Var = this.d) == null || (realView = b91Var.getRealView()) == null || realView.getVisibility() != 0 || (dp0Var = (dp0) b().j(dp0.class)) == null || (bp0Var = (bp0) b().j(bp0.class)) == null || !dp0Var.k()) {
                return;
            }
            int videoHeight = dp0Var.getVideoHeight() - bp0Var.b().getTopMargin();
            if (!z && videoHeight < this.i / 2) {
                return;
            }
            int abs = Math.abs(videoHeight - this.i);
            if (videoHeight > this.i) {
                z2 = true;
            } else {
                z2 = false;
            }
            bp0Var.f(z2, true, true, abs);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            j41 j41Var = this.g;
            if (j41Var != null) {
                j41Var.a();
            }
            this.g = null;
            vp0 vp0Var = this.e;
            if (vp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            j41 j41Var2 = new j41(vp0Var.b * 1000, 1000L);
            j41Var2.d(new b(this));
            this.g = j41Var2;
        }
    }
}
