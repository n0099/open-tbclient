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
import com.repackage.an0;
import com.repackage.b41;
import com.repackage.gg0;
import com.repackage.gm0;
import com.repackage.hl0;
import com.repackage.hx0;
import com.repackage.il0;
import com.repackage.jl0;
import com.repackage.jm0;
import com.repackage.ll0;
import com.repackage.mm0;
import com.repackage.n01;
import com.repackage.n41;
import com.repackage.p41;
import com.repackage.rx0;
import com.repackage.sl0;
import com.repackage.tl0;
import com.repackage.ul0;
import com.repackage.um0;
import com.repackage.vg0;
import com.repackage.vl0;
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
    public p41<View> d;
    public mm0 e;
    public b41 f;
    public n01 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes2.dex */
    public final class a extends n41 {
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

        @Override // com.repackage.n41
        public void a(boolean z, long j) {
            tl0 tl0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) || (tl0Var = (tl0) this.a.j().q(tl0.class)) == null) {
                return;
            }
            tl0Var.d(240L, true);
        }

        @Override // com.repackage.n41
        public void b(um0 clickInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clickInfo) == null) {
                Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
                if (clickInfo.c) {
                    if (TextUtils.isEmpty(clickInfo.a) || TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                        sl0 sl0Var = (sl0) this.a.j().q(sl0.class);
                        if (sl0Var != null) {
                            sl0Var.j(false, true, false);
                        }
                    } else {
                        gg0.c(clickInfo.a, this.a.getContext());
                    }
                    jm0 jm0Var = PopoverComponent.p(this.a).e;
                    if (jm0Var != null) {
                        jm0Var.a();
                        jm0Var.b = clickInfo.b;
                        jm0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                        this.a.D(jm0Var);
                    }
                }
                this.a.j().l(new ll0(PopEventTypeEnum.CLICK_POP_UI));
            }
        }

        @Override // com.repackage.n41
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                tl0 tl0Var = (tl0) this.a.j().q(tl0.class);
                if (tl0Var != null) {
                    tl0Var.d(240L, false);
                }
                jm0 jm0Var = PopoverComponent.p(this.a).e;
                if (jm0Var != null) {
                    jm0Var.a();
                    jm0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                    this.a.D(jm0Var);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends n01.b {
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

        @Override // com.repackage.n01.b
        public void b() {
            WebViewContainer b;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h) {
                p41 p41Var = this.a.d;
                if (p41Var != null) {
                    p41Var.c(PopoverComponent.p(this.a).a != 3);
                }
                if (PopoverComponent.p(this.a).a == 3) {
                    sl0 sl0Var = (sl0) this.a.j().q(sl0.class);
                    ul0 ul0Var = (ul0) this.a.j().q(ul0.class);
                    int max = Math.max(0, this.a.i - ((ul0Var != null ? ul0Var.getVideoHeight() : 0) - ((sl0Var == null || (b = sl0Var.b()) == null) ? 0 : b.getTopMargin())));
                    if (sl0Var != null) {
                        sl0Var.f(false, true, true, max);
                    }
                }
                n01 n01Var = this.a.g;
                if (n01Var != null) {
                    n01Var.a();
                }
                this.a.g = null;
            }
        }

        @Override // com.repackage.n01.b
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
                n01 n01Var = this.a.g;
                if (n01Var != null) {
                    n01Var.e();
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

    public static final /* synthetic */ mm0 p(PopoverComponent popoverComponent) {
        mm0 mm0Var = popoverComponent.e;
        if (mm0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return mm0Var;
    }

    public final void A(JSONObject jSONObject) {
        mm0 a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || (a2 = mm0.f.a(jSONObject)) == null) {
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
        hx0.f(jSONObject3, "cmd_map", jSONObject2);
        mm0 mm0Var = this.e;
        if (mm0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        b41 b41Var = this.f;
        mm0Var.c = b41Var != null ? b41Var.a(jSONObject3) : null;
        mm0 mm0Var2 = this.e;
        if (mm0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (mm0Var2.c == null) {
            return;
        }
        mm0 mm0Var3 = this.e;
        if (mm0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (mm0Var3.a != 2) {
            mm0 mm0Var4 = this.e;
            if (mm0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (mm0Var4.a != 3) {
                mm0 mm0Var5 = this.e;
                if (mm0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (mm0Var5.a == 1) {
                    this.d = null;
                    return;
                }
                return;
            }
        }
        mm0 mm0Var6 = this.e;
        if (mm0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (mm0Var6.c == null) {
            return;
        }
        mm0 mm0Var7 = this.e;
        if (mm0Var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        gm0 c2 = gm0.c(hx0.c(jSONObject.optString("download")));
        mm0Var7.d = c2;
        if (c2 != null) {
            c2.b = jSONObject.optString("deferred_cmd");
        }
        jm0 jm0Var = new jm0();
        jm0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
        jm0Var.d = jSONObject.optString("ext_info");
        Unit unit = Unit.INSTANCE;
        mm0Var7.e = jm0Var;
        b41 b41Var2 = this.f;
        p41<View> b2 = b41Var2 != null ? b41Var2.b(getContext()) : null;
        this.d = b2;
        if (b2 == null) {
            j().v(this);
            return;
        }
        if (b2 != null) {
            mm0 mm0Var8 = this.e;
            if (mm0Var8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            b2.setData(mm0Var8);
            b2.setCriusPopListener(new a(this));
        }
        p41<View> p41Var = this.d;
        View realView = p41Var != null ? p41Var.getRealView() : null;
        if (realView != null) {
            realView.measure(-2, -2);
        }
        this.i = realView != null ? realView.getMeasuredHeight() : 0;
    }

    public final void B(int i, int i2, int i3) {
        p41<View> p41Var;
        View realView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3) == null) {
            mm0 mm0Var = this.e;
            if (mm0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (mm0Var.a == 3 && (p41Var = this.d) != null && (realView = p41Var.getRealView()) != null && this.j && realView.getVisibility() == 0) {
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
            b41 b41Var = (b41) ServiceManager.getService(b41.a);
            this.f = b41Var;
            if (b41Var == null) {
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
                    an0.g.a(hx0.c(str));
                }
                A(jSONObject);
                z();
            }
        }
    }

    public final void D(jm0 jm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jm0Var) == null) {
            rx0.c(new ClogBuilder().x(jm0Var.c).t(jm0Var.a).h(jm0Var.b).n(jm0Var.d).i(jm0Var.e).j(jm0Var.f).k(jm0Var.g));
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
    public void c(vg0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.c(event);
            String a2 = event.a();
            if (Intrinsics.areEqual(a2, il0.class.getSimpleName())) {
                x((il0) event);
            } else if (Intrinsics.areEqual(a2, hl0.class.getSimpleName())) {
                hl0 hl0Var = (hl0) event;
                B(hl0Var.c(), hl0Var.d(), hl0Var.b());
            } else if (Intrinsics.areEqual(a2, jl0.class.getSimpleName())) {
                w(((jl0) event).b());
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
            n01 n01Var = this.g;
            if (n01Var != null) {
                n01Var.b();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onRelease();
            y(false);
            p41<View> p41Var = this.d;
            if (p41Var != null) {
                p41Var.a();
            }
            this.d = null;
            n01 n01Var = this.g;
            if (n01Var != null) {
                n01Var.a();
            }
            this.g = null;
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        n01 n01Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            ul0 ul0Var = (ul0) j().q(ul0.class);
            if (ul0Var == null || !ul0Var.k() || (n01Var = this.g) == null) {
                return;
            }
            n01Var.c();
        }
    }

    public final void v() {
        ul0 ul0Var;
        vl0 vl0Var;
        p41<View> p41Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (ul0Var = (ul0) j().q(ul0.class)) == null || (vl0Var = (vl0) j().q(vl0.class)) == null || (p41Var = this.d) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        mm0 mm0Var = this.e;
        if (mm0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (mm0Var.a == 3) {
            layoutParams.gravity = 48;
        } else {
            layoutParams.gravity = 80;
        }
        mm0 mm0Var2 = this.e;
        if (mm0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        View g = mm0Var2.a == 3 ? vl0Var.b().g() : ul0Var.h();
        if (!(g instanceof ViewGroup)) {
            g = null;
        }
        p41Var.setContainer((ViewGroup) g, layoutParams);
    }

    public final void w(boolean z) {
        p41<View> p41Var;
        View realView;
        ul0 ul0Var;
        sl0 sl0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            mm0 mm0Var = this.e;
            if (mm0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (mm0Var.a != 3 || (p41Var = this.d) == null || (realView = p41Var.getRealView()) == null || realView.getVisibility() != 0 || (ul0Var = (ul0) j().q(ul0.class)) == null || (sl0Var = (sl0) j().q(sl0.class)) == null || !ul0Var.k()) {
                return;
            }
            int videoHeight = ul0Var.getVideoHeight() - sl0Var.b().getTopMargin();
            if (z || videoHeight >= this.i / 2) {
                sl0Var.f(videoHeight > this.i, true, true, Math.abs(videoHeight - this.i));
            }
        }
    }

    public final void x(il0 il0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, il0Var) == null) {
            int i = zl0.$EnumSwitchMapping$0[il0Var.getType().ordinal()];
            if (i == 1) {
                n01 n01Var = this.g;
                if (n01Var != null) {
                    n01Var.c();
                }
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.j = true;
            } else {
                n01 n01Var2 = this.g;
                if (n01Var2 != null) {
                    n01Var2.b();
                }
            }
        }
    }

    public final void y(boolean z) {
        p41<View> p41Var;
        View realView;
        p41<View> p41Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (p41Var = this.d) == null || (realView = p41Var.getRealView()) == null || realView.getVisibility() != 0 || (p41Var2 = this.d) == null) {
            return;
        }
        p41Var2.b("0", z);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            n01 n01Var = this.g;
            if (n01Var != null) {
                n01Var.a();
            }
            this.g = null;
            mm0 mm0Var = this.e;
            if (mm0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            n01 n01Var2 = new n01(mm0Var.b * 1000, 1000L);
            n01Var2.d(new b(this));
            this.g = n01Var2;
        }
    }
}
