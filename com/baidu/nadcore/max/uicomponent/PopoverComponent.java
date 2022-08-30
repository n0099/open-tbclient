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
import com.baidu.tieba.am0;
import com.baidu.tieba.bn0;
import com.baidu.tieba.ch0;
import com.baidu.tieba.g11;
import com.baidu.tieba.hm0;
import com.baidu.tieba.im0;
import com.baidu.tieba.iy0;
import com.baidu.tieba.j51;
import com.baidu.tieba.jm0;
import com.baidu.tieba.jn0;
import com.baidu.tieba.km0;
import com.baidu.tieba.ng0;
import com.baidu.tieba.om0;
import com.baidu.tieba.pn0;
import com.baidu.tieba.v51;
import com.baidu.tieba.vm0;
import com.baidu.tieba.wl0;
import com.baidu.tieba.x51;
import com.baidu.tieba.xl0;
import com.baidu.tieba.yl0;
import com.baidu.tieba.ym0;
import com.baidu.tieba.yx0;
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
    public x51<View> d;
    public bn0 e;
    public j51 f;
    public g11 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes2.dex */
    public final class a extends v51 {
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

        @Override // com.baidu.tieba.v51
        public void a(boolean z, long j) {
            im0 im0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) || (im0Var = (im0) this.a.j().p(im0.class)) == null) {
                return;
            }
            im0Var.d(240L, true);
        }

        @Override // com.baidu.tieba.v51
        public void b(jn0 clickInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clickInfo) == null) {
                Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
                if (clickInfo.c) {
                    if (TextUtils.isEmpty(clickInfo.a) || TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                        hm0 hm0Var = (hm0) this.a.j().p(hm0.class);
                        if (hm0Var != null) {
                            hm0Var.j(false, true, false);
                        }
                    } else {
                        ng0.c(clickInfo.a, this.a.getContext());
                    }
                    ym0 ym0Var = PopoverComponent.p(this.a).e;
                    if (ym0Var != null) {
                        ym0Var.a();
                        ym0Var.b = clickInfo.b;
                        ym0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                        this.a.E(ym0Var);
                    }
                }
                this.a.j().k(new am0(PopEventTypeEnum.CLICK_POP_UI));
            }
        }

        @Override // com.baidu.tieba.v51
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                im0 im0Var = (im0) this.a.j().p(im0.class);
                if (im0Var != null) {
                    im0Var.d(240L, false);
                }
                ym0 ym0Var = PopoverComponent.p(this.a).e;
                if (ym0Var != null) {
                    ym0Var.a();
                    ym0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                    this.a.E(ym0Var);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends g11.b {
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

        @Override // com.baidu.tieba.g11.b
        public void b() {
            WebViewContainer b;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h) {
                x51 x51Var = this.a.d;
                if (x51Var != null) {
                    x51Var.c(PopoverComponent.p(this.a).a != 3);
                }
                if (PopoverComponent.p(this.a).a == 3) {
                    hm0 hm0Var = (hm0) this.a.j().p(hm0.class);
                    jm0 jm0Var = (jm0) this.a.j().p(jm0.class);
                    int max = Math.max(0, this.a.i - ((jm0Var != null ? jm0Var.getVideoHeight() : 0) - ((hm0Var == null || (b = hm0Var.b()) == null) ? 0 : b.getTopMargin())));
                    if (hm0Var != null) {
                        hm0Var.f(false, true, true, max);
                    }
                }
                g11 g11Var = this.a.g;
                if (g11Var != null) {
                    g11Var.a();
                }
                this.a.g = null;
            }
        }

        @Override // com.baidu.tieba.g11.b
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
                this.a.w();
                g11 g11Var = this.a.g;
                if (g11Var != null) {
                    g11Var.e();
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

    public static final /* synthetic */ bn0 p(PopoverComponent popoverComponent) {
        bn0 bn0Var = popoverComponent.e;
        if (bn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return bn0Var;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g11 g11Var = this.g;
            if (g11Var != null) {
                g11Var.a();
            }
            this.g = null;
            bn0 bn0Var = this.e;
            if (bn0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            g11 g11Var2 = new g11(bn0Var.b * 1000, 1000L);
            g11Var2.d(new b(this));
            this.g = g11Var2;
        }
    }

    public final void B(JSONObject jSONObject) {
        bn0 a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || (a2 = bn0.f.a(jSONObject)) == null) {
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
        bn0 bn0Var = this.e;
        if (bn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        j51 j51Var = this.f;
        bn0Var.c = j51Var != null ? j51Var.a(jSONObject3) : null;
        bn0 bn0Var2 = this.e;
        if (bn0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (bn0Var2.c == null) {
            return;
        }
        bn0 bn0Var3 = this.e;
        if (bn0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (bn0Var3.a != 2) {
            bn0 bn0Var4 = this.e;
            if (bn0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (bn0Var4.a != 3) {
                bn0 bn0Var5 = this.e;
                if (bn0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (bn0Var5.a == 1) {
                    this.d = null;
                    return;
                }
                return;
            }
        }
        bn0 bn0Var6 = this.e;
        if (bn0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (bn0Var6.c == null) {
            return;
        }
        bn0 bn0Var7 = this.e;
        if (bn0Var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        vm0 c2 = vm0.c(yx0.c(jSONObject.optString("download")));
        bn0Var7.d = c2;
        if (c2 != null) {
            c2.b = jSONObject.optString("deferred_cmd");
        }
        ym0 ym0Var = new ym0();
        ym0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
        ym0Var.d = jSONObject.optString("ext_info");
        Unit unit = Unit.INSTANCE;
        bn0Var7.e = ym0Var;
        j51 j51Var2 = this.f;
        x51<View> b2 = j51Var2 != null ? j51Var2.b(getContext()) : null;
        this.d = b2;
        if (b2 == null) {
            j().u(this);
            return;
        }
        if (b2 != null) {
            bn0 bn0Var8 = this.e;
            if (bn0Var8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            b2.setData(bn0Var8);
            b2.setCriusPopListener(new a(this));
        }
        x51<View> x51Var = this.d;
        View realView = x51Var != null ? x51Var.getRealView() : null;
        if (realView != null) {
            realView.measure(-2, -2);
        }
        this.i = realView != null ? realView.getMeasuredHeight() : 0;
    }

    public final void C(int i, int i2, int i3) {
        x51<View> x51Var;
        View realView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3) == null) {
            bn0 bn0Var = this.e;
            if (bn0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (bn0Var.a == 3 && (x51Var = this.d) != null && (realView = x51Var.getRealView()) != null && this.j && realView.getVisibility() == 0) {
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
    }

    public final void D(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            j51 j51Var = (j51) ServiceManager.getService(j51.a);
            this.f = j51Var;
            if (j51Var == null) {
                j().u(this);
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
                    pn0.g.a(yx0.c(str));
                }
                B(jSONObject);
                A();
            }
        }
    }

    public final void E(ym0 ym0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ym0Var) == null) {
            iy0.b(new ClogBuilder().z(ym0Var.c).v(ym0Var.a).j(ym0Var.b).p(ym0Var.d).k(ym0Var.e).l(ym0Var.f).m(ym0Var.g));
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void b(ch0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.b(event);
            String a2 = event.a();
            if (Intrinsics.areEqual(a2, xl0.class.getSimpleName())) {
                y((xl0) event);
            } else if (Intrinsics.areEqual(a2, wl0.class.getSimpleName())) {
                wl0 wl0Var = (wl0) event;
                C(wl0Var.c(), wl0Var.d(), wl0Var.b());
            } else if (Intrinsics.areEqual(a2, yl0.class.getSimpleName())) {
                x(((yl0) event).b());
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

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            super.onNewIntent(intent);
            D(intent);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPause();
            g11 g11Var = this.g;
            if (g11Var != null) {
                g11Var.b();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onRelease();
            z(false);
            x51<View> x51Var = this.d;
            if (x51Var != null) {
                x51Var.a();
            }
            this.d = null;
            g11 g11Var = this.g;
            if (g11Var != null) {
                g11Var.a();
            }
            this.g = null;
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        g11 g11Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            jm0 jm0Var = (jm0) j().p(jm0.class);
            if (jm0Var == null || !jm0Var.k() || (g11Var = this.g) == null) {
                return;
            }
            g11Var.c();
        }
    }

    public final void w() {
        jm0 jm0Var;
        km0 km0Var;
        x51<View> x51Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (jm0Var = (jm0) j().p(jm0.class)) == null || (km0Var = (km0) j().p(km0.class)) == null || (x51Var = this.d) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        bn0 bn0Var = this.e;
        if (bn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (bn0Var.a == 3) {
            layoutParams.gravity = 48;
        } else {
            layoutParams.gravity = 80;
        }
        bn0 bn0Var2 = this.e;
        if (bn0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        View i = bn0Var2.a == 3 ? km0Var.b().i() : jm0Var.h();
        if (!(i instanceof ViewGroup)) {
            i = null;
        }
        x51Var.setContainer((ViewGroup) i, layoutParams);
    }

    public final void x(boolean z) {
        x51<View> x51Var;
        View realView;
        jm0 jm0Var;
        hm0 hm0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            bn0 bn0Var = this.e;
            if (bn0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (bn0Var.a != 3 || (x51Var = this.d) == null || (realView = x51Var.getRealView()) == null || realView.getVisibility() != 0 || (jm0Var = (jm0) j().p(jm0.class)) == null || (hm0Var = (hm0) j().p(hm0.class)) == null || !jm0Var.k()) {
                return;
            }
            int videoHeight = jm0Var.getVideoHeight() - hm0Var.b().getTopMargin();
            if (z || videoHeight >= this.i / 2) {
                hm0Var.f(videoHeight > this.i, true, true, Math.abs(videoHeight - this.i));
            }
        }
    }

    public final void y(xl0 xl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, xl0Var) == null) {
            int i = om0.$EnumSwitchMapping$0[xl0Var.getType().ordinal()];
            if (i == 1) {
                g11 g11Var = this.g;
                if (g11Var != null) {
                    g11Var.c();
                }
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.j = true;
            } else {
                g11 g11Var2 = this.g;
                if (g11Var2 != null) {
                    g11Var2.b();
                }
            }
        }
    }

    public final void z(boolean z) {
        x51<View> x51Var;
        View realView;
        x51<View> x51Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (x51Var = this.d) == null || (realView = x51Var.getRealView()) == null || realView.getVisibility() != 0 || (x51Var2 = this.d) == null) {
            return;
        }
        x51Var2.b("0", z);
    }
}
