package com.baidu.nadcore.max.uicomponent;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.component.AbsComponentPlugin;
import com.baidu.nadcore.max.uiwidget.arrow.AdVideoImmersiveTipsView;
import com.baidu.nadcore.max.uiwidget.basic.WebViewContainer;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.fr0;
import com.baidu.tieba.hp0;
import com.baidu.tieba.ip0;
import com.baidu.tieba.ki0;
import com.baidu.tieba.lj0;
import com.baidu.tieba.mp0;
import com.baidu.tieba.pp0;
import com.baidu.tieba.qp0;
import com.baidu.tieba.rp0;
import com.baidu.tieba.sp0;
import com.baidu.tieba.t51;
import com.baidu.tieba.up0;
import com.baidu.tieba.wp0;
import com.baidu.tieba.y11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\rJ\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\rJ\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\rJ\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u0015J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/ArrowGuideComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "", "progress", "duration", "handleTipsCountdown", "(II)V", "initGuideTipsView", "()V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", IntentData.KEY, "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/max/uiwidget/arrow/AdVideoImmersiveTipsView;", "guideView", "Lcom/baidu/nadcore/max/uiwidget/arrow/AdVideoImmersiveTipsView;", "", "hasShowGuideText", "Z", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ArrowGuideComponent extends AbsComponentPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdVideoImmersiveTipsView d;
    public boolean e;
    public fr0 f;

    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ArrowGuideComponent a;

        public a(ArrowGuideComponent arrowGuideComponent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {arrowGuideComponent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = arrowGuideComponent;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                up0 up0Var = (up0) this.a.b().j(up0.class);
                if (up0Var != null && up0Var.k()) {
                    sp0 sp0Var = (sp0) this.a.b().j(sp0.class);
                    if (sp0Var != null) {
                        sp0Var.j(false, true, false);
                    }
                } else {
                    sp0 sp0Var2 = (sp0) this.a.b().j(sp0.class);
                    if (sp0Var2 != null) {
                        sp0Var2.j(true, true, false);
                    }
                }
                rp0 rp0Var = (rp0) this.a.b().j(rp0.class);
                if (rp0Var != null) {
                    String str = ClogBuilder.LogType.FREE_CLICK.type;
                    Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
                    rp0Var.a(str, "learnmore");
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ArrowGuideComponent a;

        public b(ArrowGuideComponent arrowGuideComponent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {arrowGuideComponent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = arrowGuideComponent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.k();
        }
    }

    public ArrowGuideComponent() {
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
        t51 animTimer;
        t51 countDownTimer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
            if (adVideoImmersiveTipsView != null && (countDownTimer = adVideoImmersiveTipsView.getCountDownTimer()) != null) {
                countDownTimer.b();
            }
            AdVideoImmersiveTipsView adVideoImmersiveTipsView2 = this.d;
            if (adVideoImmersiveTipsView2 != null && (animTimer = adVideoImmersiveTipsView2.getAnimTimer()) != null) {
                animTimer.b();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onRelease();
            AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
            if (adVideoImmersiveTipsView != null) {
                adVideoImmersiveTipsView.j();
                ki0.g(adVideoImmersiveTipsView);
            }
            this.d = null;
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void C(ViewGroup parent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            parent.post(new b(this));
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            super.onNewIntent(intent);
            l(intent);
        }
    }

    public final void i(ip0 ip0Var) {
        t51 animTimer;
        t51 countDownTimer;
        t51 animTimer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ip0Var) == null) {
            int i = wp0.$EnumSwitchMapping$0[ip0Var.getType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
                    if (adVideoImmersiveTipsView != null) {
                        adVideoImmersiveTipsView.m(false);
                    }
                    AdVideoImmersiveTipsView adVideoImmersiveTipsView2 = this.d;
                    if (adVideoImmersiveTipsView2 != null && (animTimer2 = adVideoImmersiveTipsView2.getAnimTimer()) != null) {
                        animTimer2.b();
                    }
                    AdVideoImmersiveTipsView adVideoImmersiveTipsView3 = this.d;
                    if (adVideoImmersiveTipsView3 != null) {
                        adVideoImmersiveTipsView3.i(0.0f);
                        return;
                    }
                    return;
                }
                return;
            }
            AdVideoImmersiveTipsView adVideoImmersiveTipsView4 = this.d;
            if (adVideoImmersiveTipsView4 != null && (countDownTimer = adVideoImmersiveTipsView4.getCountDownTimer()) != null) {
                countDownTimer.c();
            }
            AdVideoImmersiveTipsView adVideoImmersiveTipsView5 = this.d;
            if (adVideoImmersiveTipsView5 != null && (animTimer = adVideoImmersiveTipsView5.getAnimTimer()) != null) {
                animTimer.c();
            }
            AdVideoImmersiveTipsView adVideoImmersiveTipsView6 = this.d;
            if (adVideoImmersiveTipsView6 != null) {
                adVideoImmersiveTipsView6.i(1.0f);
            }
        }
    }

    public final void j(int i, int i2) {
        sp0 sp0Var;
        up0 up0Var;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) && (sp0Var = (sp0) b().j(sp0.class)) != null && (up0Var = (up0) b().j(up0.class)) != null) {
            if (!sp0Var.g()) {
                fr0 fr0Var = this.f;
                if (fr0Var != null) {
                    i3 = fr0Var.a();
                } else {
                    i3 = 0;
                }
                if (i3 > 0) {
                    if (!this.e) {
                        int l = up0Var.l();
                        fr0 fr0Var2 = this.f;
                        if (fr0Var2 != null) {
                            i4 = fr0Var2.a();
                        } else {
                            i4 = -1;
                        }
                        if (l >= i4 && (i5 = i2 - i) <= 4) {
                            AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
                            if (adVideoImmersiveTipsView != null) {
                                adVideoImmersiveTipsView.l(i5);
                            }
                            this.e = true;
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            AdVideoImmersiveTipsView adVideoImmersiveTipsView2 = this.d;
            if (adVideoImmersiveTipsView2 != null) {
                adVideoImmersiveTipsView2.m(false);
            }
        }
    }

    public final void k() {
        sp0 sp0Var;
        WebViewContainer b2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            fr0 fr0Var = this.f;
            if ((fr0Var == null || !fr0Var.n()) && this.d == null && (sp0Var = (sp0) b().j(sp0.class)) != null && (b2 = sp0Var.b()) != null) {
                pp0 a2 = qp0.a();
                Intrinsics.checkNotNullExpressionValue(a2, "NadMaxRuntime.getUIProvider()");
                a2.a();
                int i2 = -1;
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.nad_max_bottom, (ViewGroup) b2, true);
                Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(cont…youtId, parentView, true)");
                AdVideoImmersiveTipsView adVideoImmersiveTipsView = (AdVideoImmersiveTipsView) inflate.findViewById(R.id.max_bottom_tip);
                if (adVideoImmersiveTipsView != null) {
                    adVideoImmersiveTipsView.setOutClickListener(new a(this));
                    fr0 fr0Var2 = this.f;
                    if (fr0Var2 != null) {
                        i2 = fr0Var2.f();
                    }
                    fr0 fr0Var3 = this.f;
                    if (fr0Var3 != null) {
                        i = fr0Var3.g();
                    } else {
                        i = 0;
                    }
                    adVideoImmersiveTipsView.h(i2, i);
                    Unit unit = Unit.INSTANCE;
                } else {
                    adVideoImmersiveTipsView = null;
                }
                this.d = adVideoImmersiveTipsView;
            }
        }
    }

    public final void l(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            Serializable serializableExtra = intent.getSerializableExtra("map");
            String str = null;
            if (!(serializableExtra instanceof HashMap)) {
                serializableExtra = null;
            }
            HashMap hashMap = (HashMap) serializableExtra;
            if (hashMap != null) {
                Object obj = hashMap.get("cmd_policy");
                if (obj instanceof String) {
                    str = obj;
                }
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f = fr0.n.a(y11.c(str2));
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void o(lj0 event) {
        hp0 hp0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.o(event);
            String a2 = event.a();
            if (Intrinsics.areEqual(a2, mp0.class.getSimpleName())) {
                if (!(event instanceof mp0)) {
                    event = null;
                }
                mp0 mp0Var = (mp0) event;
                if (mp0Var != null) {
                    j(mp0Var.c(), mp0Var.b());
                }
            } else if (Intrinsics.areEqual(a2, ip0.class.getSimpleName())) {
                i((ip0) event);
            } else if (Intrinsics.areEqual(a2, hp0.class.getSimpleName())) {
                if (!(event instanceof hp0)) {
                    event = null;
                }
                if (((hp0) event) != null) {
                    float c = hp0Var.c() / (hp0Var.d() - hp0Var.b());
                    AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
                    if (adVideoImmersiveTipsView != null) {
                        adVideoImmersiveTipsView.i(c);
                    }
                }
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        t51 animTimer;
        t51 animTimer2;
        t51 countDownTimer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            up0 up0Var = (up0) b().j(up0.class);
            if (up0Var != null && up0Var.k()) {
                AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
                if (adVideoImmersiveTipsView != null && (countDownTimer = adVideoImmersiveTipsView.getCountDownTimer()) != null) {
                    countDownTimer.c();
                }
                AdVideoImmersiveTipsView adVideoImmersiveTipsView2 = this.d;
                if (adVideoImmersiveTipsView2 != null && (animTimer2 = adVideoImmersiveTipsView2.getAnimTimer()) != null) {
                    animTimer2.c();
                    return;
                }
                return;
            }
            AdVideoImmersiveTipsView adVideoImmersiveTipsView3 = this.d;
            if (adVideoImmersiveTipsView3 != null) {
                adVideoImmersiveTipsView3.m(false);
            }
            AdVideoImmersiveTipsView adVideoImmersiveTipsView4 = this.d;
            if (adVideoImmersiveTipsView4 != null && (animTimer = adVideoImmersiveTipsView4.getAnimTimer()) != null) {
                animTimer.b();
            }
        }
    }
}
