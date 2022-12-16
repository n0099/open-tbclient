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
import com.baidu.tieba.dp0;
import com.baidu.tieba.e41;
import com.baidu.tieba.eq0;
import com.baidu.tieba.i81;
import com.baidu.tieba.ii0;
import com.baidu.tieba.kp0;
import com.baidu.tieba.lo0;
import com.baidu.tieba.mo0;
import com.baidu.tieba.no0;
import com.baidu.tieba.np0;
import com.baidu.tieba.p01;
import com.baidu.tieba.po0;
import com.baidu.tieba.qp0;
import com.baidu.tieba.u81;
import com.baidu.tieba.w81;
import com.baidu.tieba.wo0;
import com.baidu.tieba.xi0;
import com.baidu.tieba.xo0;
import com.baidu.tieba.yo0;
import com.baidu.tieba.yp0;
import com.baidu.tieba.z01;
import com.baidu.tieba.zo0;
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
    public w81<View> d;
    public qp0 e;
    public i81 f;
    public e41 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes2.dex */
    public final class a extends u81 {
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

        @Override // com.baidu.tieba.u81
        public void a(boolean z, long j) {
            xo0 xo0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) && (xo0Var = (xo0) this.a.b().j(xo0.class)) != null) {
                xo0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.u81
        public void b(yp0 clickInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clickInfo) == null) {
                Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
                if (clickInfo.c) {
                    if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                        ii0.c(clickInfo.a, this.a.getContext());
                    } else {
                        wo0 wo0Var = (wo0) this.a.b().j(wo0.class);
                        if (wo0Var != null) {
                            wo0Var.j(false, true, false);
                        }
                    }
                    np0 np0Var = PopoverComponent.j(this.a).e;
                    if (np0Var != null) {
                        np0Var.a();
                        np0Var.b = clickInfo.b;
                        np0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                        this.a.E(np0Var);
                    }
                }
                this.a.b().d(new po0(PopEventTypeEnum.CLICK_POP_UI));
            }
        }

        @Override // com.baidu.tieba.u81
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                xo0 xo0Var = (xo0) this.a.b().j(xo0.class);
                if (xo0Var != null) {
                    xo0Var.d(240L, false);
                }
                np0 np0Var = PopoverComponent.j(this.a).e;
                if (np0Var != null) {
                    np0Var.a();
                    np0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                    this.a.E(np0Var);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends e41.b {
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

        @Override // com.baidu.tieba.e41.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h) {
                w81 w81Var = this.a.d;
                if (w81Var != null) {
                    if (PopoverComponent.j(this.a).a != 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    w81Var.c(z);
                }
                if (PopoverComponent.j(this.a).a == 3) {
                    wo0 wo0Var = (wo0) this.a.b().j(wo0.class);
                    yo0 yo0Var = (yo0) this.a.b().j(yo0.class);
                    if (wo0Var != null && (b = wo0Var.b()) != null) {
                        i = b.getTopMargin();
                    } else {
                        i = 0;
                    }
                    if (yo0Var != null) {
                        i2 = yo0Var.getVideoHeight();
                    } else {
                        i2 = 0;
                    }
                    int max = Math.max(0, this.a.i - (i2 - i));
                    if (wo0Var != null) {
                        wo0Var.f(false, true, true, max);
                    }
                }
                e41 e41Var = this.a.g;
                if (e41Var != null) {
                    e41Var.a();
                }
                this.a.g = null;
            }
        }

        @Override // com.baidu.tieba.e41.b
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
            e41 e41Var = this.a.g;
            if (e41Var != null) {
                e41Var.e();
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
            e41 e41Var = this.g;
            if (e41Var != null) {
                e41Var.b();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onRelease();
            y(false);
            w81<View> w81Var = this.d;
            if (w81Var != null) {
                w81Var.a();
            }
            this.d = null;
            e41 e41Var = this.g;
            if (e41Var != null) {
                e41Var.a();
            }
            this.g = null;
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        e41 e41Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            yo0 yo0Var = (yo0) b().j(yo0.class);
            if (yo0Var != null && yo0Var.k() && (e41Var = this.g) != null) {
                e41Var.c();
            }
        }
    }

    public static final /* synthetic */ qp0 j(PopoverComponent popoverComponent) {
        qp0 qp0Var = popoverComponent.e;
        if (qp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return qp0Var;
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
        w81<View> w81Var;
        View realView;
        w81<View> w81Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (w81Var = this.d) != null && (realView = w81Var.getRealView()) != null && realView.getVisibility() == 0 && (w81Var2 = this.d) != null) {
            w81Var2.b("0", z);
        }
    }

    public final void A(JSONObject jSONObject) {
        qp0 a2;
        boolean z;
        boolean z2;
        Object obj;
        w81<View> w81Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && (a2 = qp0.f.a(jSONObject)) != null) {
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
            p01.f(jSONObject3, "cmd_map", jSONObject2);
            qp0 qp0Var = this.e;
            if (qp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            i81 i81Var = this.f;
            View view2 = null;
            if (i81Var != null) {
                obj = i81Var.a(jSONObject3);
            } else {
                obj = null;
            }
            qp0Var.c = obj;
            qp0 qp0Var2 = this.e;
            if (qp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (qp0Var2.c == null) {
                return;
            }
            qp0 qp0Var3 = this.e;
            if (qp0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (qp0Var3.a != 2) {
                qp0 qp0Var4 = this.e;
                if (qp0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (qp0Var4.a != 3) {
                    qp0 qp0Var5 = this.e;
                    if (qp0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (qp0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            qp0 qp0Var6 = this.e;
            if (qp0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (qp0Var6.c == null) {
                return;
            }
            qp0 qp0Var7 = this.e;
            if (qp0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            kp0 c2 = kp0.c(p01.c(jSONObject.optString("download")));
            qp0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            np0 np0Var = new np0();
            np0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            np0Var.d = jSONObject.optString("ext_info");
            Unit unit = Unit.INSTANCE;
            qp0Var7.e = np0Var;
            i81 i81Var2 = this.f;
            if (i81Var2 != null) {
                w81Var = i81Var2.b(getContext());
            } else {
                w81Var = null;
            }
            this.d = w81Var;
            if (w81Var == null) {
                b().q(this);
                return;
            }
            if (w81Var != null) {
                qp0 qp0Var8 = this.e;
                if (qp0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                w81Var.setData(qp0Var8);
                w81Var.setCriusPopListener(new a(this));
            }
            w81<View> w81Var2 = this.d;
            if (w81Var2 != null) {
                view2 = w81Var2.getRealView();
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
        w81<View> w81Var;
        View realView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3) == null) {
            qp0 qp0Var = this.e;
            if (qp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (qp0Var.a != 3 || (w81Var = this.d) == null || (realView = w81Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
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
            i81 i81Var = (i81) ServiceManager.getService(i81.a);
            this.f = i81Var;
            if (i81Var == null) {
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
                    eq0.f.a(p01.c(str2));
                }
                A(jSONObject);
                z();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void o(xi0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.o(event);
            String a2 = event.a();
            if (Intrinsics.areEqual(a2, mo0.class.getSimpleName())) {
                x((mo0) event);
            } else if (Intrinsics.areEqual(a2, lo0.class.getSimpleName())) {
                lo0 lo0Var = (lo0) event;
                B(lo0Var.c(), lo0Var.d(), lo0Var.b());
            } else if (Intrinsics.areEqual(a2, no0.class.getSimpleName())) {
                w(((no0) event).b());
            }
        }
    }

    public final void E(np0 np0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, np0Var) == null) {
            z01.b(new ClogBuilder().z(np0Var.c).v(np0Var.a).j(np0Var.b).p(np0Var.d).k(np0Var.e).l(np0Var.f).m(np0Var.g));
        }
    }

    public final void x(mo0 mo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, mo0Var) == null) {
            int i = dp0.$EnumSwitchMapping$0[mo0Var.getType().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.j = true;
                        return;
                    }
                    return;
                }
                e41 e41Var = this.g;
                if (e41Var != null) {
                    e41Var.b();
                    return;
                }
                return;
            }
            e41 e41Var2 = this.g;
            if (e41Var2 != null) {
                e41Var2.c();
            }
        }
    }

    public final void t() {
        yo0 yo0Var;
        zo0 zo0Var;
        w81<View> w81Var;
        View h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (yo0Var = (yo0) b().j(yo0.class)) != null && (zo0Var = (zo0) b().j(zo0.class)) != null && (w81Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            qp0 qp0Var = this.e;
            if (qp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (qp0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            qp0 qp0Var2 = this.e;
            if (qp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (qp0Var2.a == 3) {
                h = zo0Var.b().i();
            } else {
                h = yo0Var.h();
            }
            if (!(h instanceof ViewGroup)) {
                h = null;
            }
            w81Var.setContainer((ViewGroup) h, layoutParams);
        }
    }

    public final void w(boolean z) {
        w81<View> w81Var;
        View realView;
        yo0 yo0Var;
        wo0 wo0Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            qp0 qp0Var = this.e;
            if (qp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (qp0Var.a != 3 || (w81Var = this.d) == null || (realView = w81Var.getRealView()) == null || realView.getVisibility() != 0 || (yo0Var = (yo0) b().j(yo0.class)) == null || (wo0Var = (wo0) b().j(wo0.class)) == null || !yo0Var.k()) {
                return;
            }
            int videoHeight = yo0Var.getVideoHeight() - wo0Var.b().getTopMargin();
            if (!z && videoHeight < this.i / 2) {
                return;
            }
            int abs = Math.abs(videoHeight - this.i);
            if (videoHeight > this.i) {
                z2 = true;
            } else {
                z2 = false;
            }
            wo0Var.f(z2, true, true, abs);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            e41 e41Var = this.g;
            if (e41Var != null) {
                e41Var.a();
            }
            this.g = null;
            qp0 qp0Var = this.e;
            if (qp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            e41 e41Var2 = new e41(qp0Var.b * 1000, 1000L);
            e41Var2.d(new b(this));
            this.g = e41Var2;
        }
    }
}
