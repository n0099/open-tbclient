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
import com.baidu.tieba.ap0;
import com.baidu.tieba.b81;
import com.baidu.tieba.d81;
import com.baidu.tieba.go0;
import com.baidu.tieba.h01;
import com.baidu.tieba.ho0;
import com.baidu.tieba.ii0;
import com.baidu.tieba.io0;
import com.baidu.tieba.ip0;
import com.baidu.tieba.jo0;
import com.baidu.tieba.l31;
import com.baidu.tieba.no0;
import com.baidu.tieba.op0;
import com.baidu.tieba.p71;
import com.baidu.tieba.uo0;
import com.baidu.tieba.vn0;
import com.baidu.tieba.wn0;
import com.baidu.tieba.xi0;
import com.baidu.tieba.xn0;
import com.baidu.tieba.xo0;
import com.baidu.tieba.xz0;
import com.baidu.tieba.zn0;
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
    public d81<View> d;
    public ap0 e;
    public p71 f;
    public l31 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes2.dex */
    public final class a extends b81 {
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

        @Override // com.baidu.tieba.b81
        public void a(boolean z, long j) {
            ho0 ho0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) || (ho0Var = (ho0) this.a.j().p(ho0.class)) == null) {
                return;
            }
            ho0Var.d(240L, true);
        }

        @Override // com.baidu.tieba.b81
        public void b(ip0 clickInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clickInfo) == null) {
                Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
                if (clickInfo.c) {
                    if (TextUtils.isEmpty(clickInfo.a) || TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                        go0 go0Var = (go0) this.a.j().p(go0.class);
                        if (go0Var != null) {
                            go0Var.j(false, true, false);
                        }
                    } else {
                        ii0.c(clickInfo.a, this.a.getContext());
                    }
                    xo0 xo0Var = PopoverComponent.p(this.a).e;
                    if (xo0Var != null) {
                        xo0Var.a();
                        xo0Var.b = clickInfo.b;
                        xo0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                        this.a.E(xo0Var);
                    }
                }
                this.a.j().k(new zn0(PopEventTypeEnum.CLICK_POP_UI));
            }
        }

        @Override // com.baidu.tieba.b81
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ho0 ho0Var = (ho0) this.a.j().p(ho0.class);
                if (ho0Var != null) {
                    ho0Var.d(240L, false);
                }
                xo0 xo0Var = PopoverComponent.p(this.a).e;
                if (xo0Var != null) {
                    xo0Var.a();
                    xo0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                    this.a.E(xo0Var);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends l31.b {
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

        @Override // com.baidu.tieba.l31.b
        public void b() {
            WebViewContainer b;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h) {
                d81 d81Var = this.a.d;
                if (d81Var != null) {
                    d81Var.c(PopoverComponent.p(this.a).a != 3);
                }
                if (PopoverComponent.p(this.a).a == 3) {
                    go0 go0Var = (go0) this.a.j().p(go0.class);
                    io0 io0Var = (io0) this.a.j().p(io0.class);
                    int max = Math.max(0, this.a.i - ((io0Var != null ? io0Var.getVideoHeight() : 0) - ((go0Var == null || (b = go0Var.b()) == null) ? 0 : b.getTopMargin())));
                    if (go0Var != null) {
                        go0Var.f(false, true, true, max);
                    }
                }
                l31 l31Var = this.a.g;
                if (l31Var != null) {
                    l31Var.a();
                }
                this.a.g = null;
            }
        }

        @Override // com.baidu.tieba.l31.b
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
                l31 l31Var = this.a.g;
                if (l31Var != null) {
                    l31Var.e();
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

    public static final /* synthetic */ ap0 p(PopoverComponent popoverComponent) {
        ap0 ap0Var = popoverComponent.e;
        if (ap0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return ap0Var;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            l31 l31Var = this.g;
            if (l31Var != null) {
                l31Var.a();
            }
            this.g = null;
            ap0 ap0Var = this.e;
            if (ap0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            l31 l31Var2 = new l31(ap0Var.b * 1000, 1000L);
            l31Var2.d(new b(this));
            this.g = l31Var2;
        }
    }

    public final void B(JSONObject jSONObject) {
        ap0 a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || (a2 = ap0.f.a(jSONObject)) == null) {
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
        xz0.f(jSONObject3, "cmd_map", jSONObject2);
        ap0 ap0Var = this.e;
        if (ap0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        p71 p71Var = this.f;
        ap0Var.c = p71Var != null ? p71Var.a(jSONObject3) : null;
        ap0 ap0Var2 = this.e;
        if (ap0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (ap0Var2.c == null) {
            return;
        }
        ap0 ap0Var3 = this.e;
        if (ap0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (ap0Var3.a != 2) {
            ap0 ap0Var4 = this.e;
            if (ap0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (ap0Var4.a != 3) {
                ap0 ap0Var5 = this.e;
                if (ap0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (ap0Var5.a == 1) {
                    this.d = null;
                    return;
                }
                return;
            }
        }
        ap0 ap0Var6 = this.e;
        if (ap0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (ap0Var6.c == null) {
            return;
        }
        ap0 ap0Var7 = this.e;
        if (ap0Var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        uo0 c2 = uo0.c(xz0.c(jSONObject.optString("download")));
        ap0Var7.d = c2;
        if (c2 != null) {
            c2.b = jSONObject.optString("deferred_cmd");
        }
        xo0 xo0Var = new xo0();
        xo0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
        xo0Var.d = jSONObject.optString("ext_info");
        Unit unit = Unit.INSTANCE;
        ap0Var7.e = xo0Var;
        p71 p71Var2 = this.f;
        d81<View> b2 = p71Var2 != null ? p71Var2.b(getContext()) : null;
        this.d = b2;
        if (b2 == null) {
            j().u(this);
            return;
        }
        if (b2 != null) {
            ap0 ap0Var8 = this.e;
            if (ap0Var8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            b2.setData(ap0Var8);
            b2.setCriusPopListener(new a(this));
        }
        d81<View> d81Var = this.d;
        View realView = d81Var != null ? d81Var.getRealView() : null;
        if (realView != null) {
            realView.measure(-2, -2);
        }
        this.i = realView != null ? realView.getMeasuredHeight() : 0;
    }

    public final void C(int i, int i2, int i3) {
        d81<View> d81Var;
        View realView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3) == null) {
            ap0 ap0Var = this.e;
            if (ap0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (ap0Var.a == 3 && (d81Var = this.d) != null && (realView = d81Var.getRealView()) != null && this.j && realView.getVisibility() == 0) {
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
            p71 p71Var = (p71) ServiceManager.getService(p71.a);
            this.f = p71Var;
            if (p71Var == null) {
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
                    op0.f.a(xz0.c(str));
                }
                B(jSONObject);
                A();
            }
        }
    }

    public final void E(xo0 xo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xo0Var) == null) {
            h01.b(new ClogBuilder().z(xo0Var.c).v(xo0Var.a).j(xo0Var.b).p(xo0Var.d).k(xo0Var.e).l(xo0Var.f).m(xo0Var.g));
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void b(xi0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.b(event);
            String a2 = event.a();
            if (Intrinsics.areEqual(a2, wn0.class.getSimpleName())) {
                y((wn0) event);
            } else if (Intrinsics.areEqual(a2, vn0.class.getSimpleName())) {
                vn0 vn0Var = (vn0) event;
                C(vn0Var.c(), vn0Var.d(), vn0Var.b());
            } else if (Intrinsics.areEqual(a2, xn0.class.getSimpleName())) {
                x(((xn0) event).b());
            }
        }
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

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPause();
            l31 l31Var = this.g;
            if (l31Var != null) {
                l31Var.b();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onRelease();
            z(false);
            d81<View> d81Var = this.d;
            if (d81Var != null) {
                d81Var.a();
            }
            this.d = null;
            l31 l31Var = this.g;
            if (l31Var != null) {
                l31Var.a();
            }
            this.g = null;
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        l31 l31Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            io0 io0Var = (io0) j().p(io0.class);
            if (io0Var == null || !io0Var.k() || (l31Var = this.g) == null) {
                return;
            }
            l31Var.c();
        }
    }

    public final void w() {
        io0 io0Var;
        jo0 jo0Var;
        d81<View> d81Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (io0Var = (io0) j().p(io0.class)) == null || (jo0Var = (jo0) j().p(jo0.class)) == null || (d81Var = this.d) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        ap0 ap0Var = this.e;
        if (ap0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (ap0Var.a == 3) {
            layoutParams.gravity = 48;
        } else {
            layoutParams.gravity = 80;
        }
        ap0 ap0Var2 = this.e;
        if (ap0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        View i = ap0Var2.a == 3 ? jo0Var.b().i() : io0Var.h();
        if (!(i instanceof ViewGroup)) {
            i = null;
        }
        d81Var.setContainer((ViewGroup) i, layoutParams);
    }

    public final void x(boolean z) {
        d81<View> d81Var;
        View realView;
        io0 io0Var;
        go0 go0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            ap0 ap0Var = this.e;
            if (ap0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (ap0Var.a != 3 || (d81Var = this.d) == null || (realView = d81Var.getRealView()) == null || realView.getVisibility() != 0 || (io0Var = (io0) j().p(io0.class)) == null || (go0Var = (go0) j().p(go0.class)) == null || !io0Var.k()) {
                return;
            }
            int videoHeight = io0Var.getVideoHeight() - go0Var.b().getTopMargin();
            if (z || videoHeight >= this.i / 2) {
                go0Var.f(videoHeight > this.i, true, true, Math.abs(videoHeight - this.i));
            }
        }
    }

    public final void y(wn0 wn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, wn0Var) == null) {
            int i = no0.$EnumSwitchMapping$0[wn0Var.getType().ordinal()];
            if (i == 1) {
                l31 l31Var = this.g;
                if (l31Var != null) {
                    l31Var.c();
                }
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.j = true;
            } else {
                l31 l31Var2 = this.g;
                if (l31Var2 != null) {
                    l31Var2.b();
                }
            }
        }
    }

    public final void z(boolean z) {
        d81<View> d81Var;
        View realView;
        d81<View> d81Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (d81Var = this.d) == null || (realView = d81Var.getRealView()) == null || realView.getVisibility() != 0 || (d81Var2 = this.d) == null) {
            return;
        }
        d81Var2.b("0", z);
    }
}
