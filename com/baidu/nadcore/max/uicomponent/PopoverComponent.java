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
import com.baidu.tieba.ao0;
import com.baidu.tieba.bp0;
import com.baidu.tieba.c81;
import com.baidu.tieba.e81;
import com.baidu.tieba.ho0;
import com.baidu.tieba.i01;
import com.baidu.tieba.io0;
import com.baidu.tieba.ji0;
import com.baidu.tieba.jo0;
import com.baidu.tieba.jp0;
import com.baidu.tieba.ko0;
import com.baidu.tieba.m31;
import com.baidu.tieba.oo0;
import com.baidu.tieba.pp0;
import com.baidu.tieba.q71;
import com.baidu.tieba.vo0;
import com.baidu.tieba.wn0;
import com.baidu.tieba.xn0;
import com.baidu.tieba.yi0;
import com.baidu.tieba.yn0;
import com.baidu.tieba.yo0;
import com.baidu.tieba.yz0;
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
    public e81 d;
    public bp0 e;
    public q71 f;
    public m31 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes2.dex */
    public final class a extends c81 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PopoverComponent a;

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

        @Override // com.baidu.tieba.c81
        public void a(boolean z, long j) {
            io0 io0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) && (io0Var = (io0) this.a.j().p(io0.class)) != null) {
                io0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.c81
        public void b(jp0 clickInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clickInfo) == null) {
                Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
                if (clickInfo.c) {
                    if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                        ji0.c(clickInfo.a, this.a.getContext());
                    } else {
                        ho0 ho0Var = (ho0) this.a.j().p(ho0.class);
                        if (ho0Var != null) {
                            ho0Var.j(false, true, false);
                        }
                    }
                    yo0 yo0Var = PopoverComponent.p(this.a).e;
                    if (yo0Var != null) {
                        yo0Var.a();
                        yo0Var.b = clickInfo.b;
                        yo0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                        this.a.E(yo0Var);
                    }
                }
                this.a.j().k(new ao0(PopEventTypeEnum.CLICK_POP_UI));
            }
        }

        @Override // com.baidu.tieba.c81
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                io0 io0Var = (io0) this.a.j().p(io0.class);
                if (io0Var != null) {
                    io0Var.d(240L, false);
                }
                yo0 yo0Var = PopoverComponent.p(this.a).e;
                if (yo0Var != null) {
                    yo0Var.a();
                    yo0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                    this.a.E(yo0Var);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class b extends m31.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PopoverComponent a;

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

        @Override // com.baidu.tieba.m31.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h) {
                e81 e81Var = this.a.d;
                if (e81Var != null) {
                    if (PopoverComponent.p(this.a).a != 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    e81Var.c(z);
                }
                if (PopoverComponent.p(this.a).a == 3) {
                    ho0 ho0Var = (ho0) this.a.j().p(ho0.class);
                    jo0 jo0Var = (jo0) this.a.j().p(jo0.class);
                    if (ho0Var != null && (b = ho0Var.b()) != null) {
                        i = b.getTopMargin();
                    } else {
                        i = 0;
                    }
                    if (jo0Var != null) {
                        i2 = jo0Var.getVideoHeight();
                    } else {
                        i2 = 0;
                    }
                    int max = Math.max(0, this.a.i - (i2 - i));
                    if (ho0Var != null) {
                        ho0Var.f(false, true, true, max);
                    }
                }
                m31 m31Var = this.a.g;
                if (m31Var != null) {
                    m31Var.a();
                }
                this.a.g = null;
            }
        }

        @Override // com.baidu.tieba.m31.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.h = true;
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class c implements Runnable {
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
            m31 m31Var = this.a.g;
            if (m31Var != null) {
                m31Var.e();
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
            m31 m31Var = this.g;
            if (m31Var != null) {
                m31Var.b();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onRelease();
            z(false);
            e81 e81Var = this.d;
            if (e81Var != null) {
                e81Var.a();
            }
            this.d = null;
            m31 m31Var = this.g;
            if (m31Var != null) {
                m31Var.a();
            }
            this.g = null;
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        m31 m31Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            jo0 jo0Var = (jo0) j().p(jo0.class);
            if (jo0Var != null && jo0Var.k() && (m31Var = this.g) != null) {
                m31Var.c();
            }
        }
    }

    public static final /* synthetic */ bp0 p(PopoverComponent popoverComponent) {
        bp0 bp0Var = popoverComponent.e;
        if (bp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return bp0Var;
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
        e81 e81Var;
        View view2;
        e81 e81Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (e81Var = this.d) != null && (view2 = (View) e81Var.getRealView()) != null && view2.getVisibility() == 0 && (e81Var2 = this.d) != null) {
            e81Var2.b("0", z);
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m31 m31Var = this.g;
            if (m31Var != null) {
                m31Var.a();
            }
            this.g = null;
            bp0 bp0Var = this.e;
            if (bp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            m31 m31Var2 = new m31(bp0Var.b * 1000, 1000L);
            m31Var2.d(new b(this));
            this.g = m31Var2;
        }
    }

    public final void B(JSONObject jSONObject) {
        bp0 a2;
        boolean z;
        boolean z2;
        Object obj;
        e81 e81Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) && (a2 = bp0.f.a(jSONObject)) != null) {
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
            yz0.f(jSONObject3, "cmd_map", jSONObject2);
            bp0 bp0Var = this.e;
            if (bp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            q71 q71Var = this.f;
            View view2 = null;
            if (q71Var != null) {
                obj = q71Var.a(jSONObject3);
            } else {
                obj = null;
            }
            bp0Var.c = obj;
            bp0 bp0Var2 = this.e;
            if (bp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (bp0Var2.c == null) {
                return;
            }
            bp0 bp0Var3 = this.e;
            if (bp0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (bp0Var3.a != 2) {
                bp0 bp0Var4 = this.e;
                if (bp0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (bp0Var4.a != 3) {
                    bp0 bp0Var5 = this.e;
                    if (bp0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (bp0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            bp0 bp0Var6 = this.e;
            if (bp0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (bp0Var6.c == null) {
                return;
            }
            bp0 bp0Var7 = this.e;
            if (bp0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            vo0 c2 = vo0.c(yz0.c(jSONObject.optString("download")));
            bp0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            yo0 yo0Var = new yo0();
            yo0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            yo0Var.d = jSONObject.optString("ext_info");
            Unit unit = Unit.INSTANCE;
            bp0Var7.e = yo0Var;
            q71 q71Var2 = this.f;
            if (q71Var2 != null) {
                e81Var = q71Var2.b(getContext());
            } else {
                e81Var = null;
            }
            this.d = e81Var;
            if (e81Var == null) {
                j().u(this);
                return;
            }
            if (e81Var != null) {
                bp0 bp0Var8 = this.e;
                if (bp0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                e81Var.setData(bp0Var8);
                e81Var.setCriusPopListener(new a(this));
            }
            e81 e81Var2 = this.d;
            if (e81Var2 != null) {
                view2 = (View) e81Var2.getRealView();
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
        e81 e81Var;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3) == null) {
            bp0 bp0Var = this.e;
            if (bp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (bp0Var.a != 3 || (e81Var = this.d) == null || (view2 = (View) e81Var.getRealView()) == null || !this.j || view2.getVisibility() != 0) {
                return;
            }
            if (i < i2 && i > i3) {
                float f = i2;
                float f2 = 0.75f * f;
                float f3 = f - this.i;
                float f4 = i;
                if (f4 >= f3) {
                    view2.setAlpha(1.0f);
                    return;
                } else {
                    view2.setAlpha(Math.max(0.0f, 1 - ((f3 - f4) / (f3 - f2))));
                    return;
                }
            }
            z(false);
        }
    }

    public final void D(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            q71 q71Var = (q71) ServiceManager.getService(q71.a);
            this.f = q71Var;
            if (q71Var == null) {
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
                    pp0.f.a(yz0.c(str2));
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
            if (Intrinsics.areEqual(a2, xn0.class.getSimpleName())) {
                y((xn0) event);
            } else if (Intrinsics.areEqual(a2, wn0.class.getSimpleName())) {
                wn0 wn0Var = (wn0) event;
                C(wn0Var.c(), wn0Var.d(), wn0Var.b());
            } else if (Intrinsics.areEqual(a2, yn0.class.getSimpleName())) {
                x(((yn0) event).b());
            }
        }
    }

    public final void E(yo0 yo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yo0Var) == null) {
            i01.b(new ClogBuilder().z(yo0Var.c).v(yo0Var.a).j(yo0Var.b).p(yo0Var.d).k(yo0Var.e).l(yo0Var.f).m(yo0Var.g));
        }
    }

    public final void y(xn0 xn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, xn0Var) == null) {
            int i = oo0.$EnumSwitchMapping$0[xn0Var.getType().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.j = true;
                        return;
                    }
                    return;
                }
                m31 m31Var = this.g;
                if (m31Var != null) {
                    m31Var.b();
                    return;
                }
                return;
            }
            m31 m31Var2 = this.g;
            if (m31Var2 != null) {
                m31Var2.c();
            }
        }
    }

    public final void w() {
        jo0 jo0Var;
        ko0 ko0Var;
        e81 e81Var;
        View h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (jo0Var = (jo0) j().p(jo0.class)) != null && (ko0Var = (ko0) j().p(ko0.class)) != null && (e81Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            bp0 bp0Var = this.e;
            if (bp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (bp0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            bp0 bp0Var2 = this.e;
            if (bp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (bp0Var2.a == 3) {
                h = ko0Var.b().i();
            } else {
                h = jo0Var.h();
            }
            if (!(h instanceof ViewGroup)) {
                h = null;
            }
            e81Var.setContainer((ViewGroup) h, layoutParams);
        }
    }

    public final void x(boolean z) {
        e81 e81Var;
        View view2;
        jo0 jo0Var;
        ho0 ho0Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            bp0 bp0Var = this.e;
            if (bp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (bp0Var.a != 3 || (e81Var = this.d) == null || (view2 = (View) e81Var.getRealView()) == null || view2.getVisibility() != 0 || (jo0Var = (jo0) j().p(jo0.class)) == null || (ho0Var = (ho0) j().p(ho0.class)) == null || !jo0Var.k()) {
                return;
            }
            int videoHeight = jo0Var.getVideoHeight() - ho0Var.b().getTopMargin();
            if (!z && videoHeight < this.i / 2) {
                return;
            }
            int abs = Math.abs(videoHeight - this.i);
            if (videoHeight > this.i) {
                z2 = true;
            } else {
                z2 = false;
            }
            ho0Var.f(z2, true, true, abs);
        }
    }
}
