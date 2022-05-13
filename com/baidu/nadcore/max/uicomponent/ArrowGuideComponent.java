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
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a21;
import com.repackage.cn0;
import com.repackage.dn0;
import com.repackage.en0;
import com.repackage.fn0;
import com.repackage.hh0;
import com.repackage.hn0;
import com.repackage.ii0;
import com.repackage.jn0;
import com.repackage.no0;
import com.repackage.um0;
import com.repackage.uy0;
import com.repackage.vm0;
import com.repackage.zm0;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\rJ\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\rJ\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\rJ\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u0015J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/ArrowGuideComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "", "progress", "duration", "handleTipsCountdown", "(II)V", "initGuideTipsView", "()V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/max/uiwidget/arrow/AdVideoImmersiveTipsView;", "guideView", "Lcom/baidu/nadcore/max/uiwidget/arrow/AdVideoImmersiveTipsView;", "", "hasShowGuideText", "Z", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ArrowGuideComponent extends AbsComponentPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdVideoImmersiveTipsView d;
    public boolean e;
    public no0 f;

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
                hn0 hn0Var = (hn0) this.a.j().q(hn0.class);
                if (hn0Var == null || !hn0Var.k()) {
                    fn0 fn0Var = (fn0) this.a.j().q(fn0.class);
                    if (fn0Var != null) {
                        fn0Var.j(true, true, false);
                    }
                } else {
                    fn0 fn0Var2 = (fn0) this.a.j().q(fn0.class);
                    if (fn0Var2 != null) {
                        fn0Var2.j(false, true, false);
                    }
                }
                en0 en0Var = (en0) this.a.j().q(en0.class);
                if (en0Var != null) {
                    String str = ClogBuilder.LogType.FREE_CLICK.type;
                    Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
                    en0Var.a(str, "learnmore");
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.o();
            }
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

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void b(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            super.b(intent);
            p(intent);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void c(ii0 event) {
        um0 um0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.c(event);
            String a2 = event.a();
            if (Intrinsics.areEqual(a2, zm0.class.getSimpleName())) {
                if (!(event instanceof zm0)) {
                    event = null;
                }
                zm0 zm0Var = (zm0) event;
                if (zm0Var != null) {
                    n(zm0Var.c(), zm0Var.b());
                }
            } else if (Intrinsics.areEqual(a2, vm0.class.getSimpleName())) {
                m((vm0) event);
            } else if (Intrinsics.areEqual(a2, um0.class.getSimpleName())) {
                if (!(event instanceof um0)) {
                    event = null;
                }
                if (((um0) event) != null) {
                    float c = um0Var.c() / (um0Var.d() - um0Var.b());
                    AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
                    if (adVideoImmersiveTipsView != null) {
                        adVideoImmersiveTipsView.i(c);
                    }
                }
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void h(ViewGroup parent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            parent.post(new b(this));
        }
    }

    public final void m(vm0 vm0Var) {
        a21 animTimer;
        a21 countDownTimer;
        a21 animTimer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, vm0Var) == null) {
            int i = jn0.$EnumSwitchMapping$0[vm0Var.getType().ordinal()];
            if (i == 1) {
                AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
                if (adVideoImmersiveTipsView != null && (countDownTimer = adVideoImmersiveTipsView.getCountDownTimer()) != null) {
                    countDownTimer.c();
                }
                AdVideoImmersiveTipsView adVideoImmersiveTipsView2 = this.d;
                if (adVideoImmersiveTipsView2 != null && (animTimer = adVideoImmersiveTipsView2.getAnimTimer()) != null) {
                    animTimer.c();
                }
                AdVideoImmersiveTipsView adVideoImmersiveTipsView3 = this.d;
                if (adVideoImmersiveTipsView3 != null) {
                    adVideoImmersiveTipsView3.i(1.0f);
                }
            } else if (i != 2) {
            } else {
                AdVideoImmersiveTipsView adVideoImmersiveTipsView4 = this.d;
                if (adVideoImmersiveTipsView4 != null) {
                    adVideoImmersiveTipsView4.m(false);
                }
                AdVideoImmersiveTipsView adVideoImmersiveTipsView5 = this.d;
                if (adVideoImmersiveTipsView5 != null && (animTimer2 = adVideoImmersiveTipsView5.getAnimTimer()) != null) {
                    animTimer2.b();
                }
                AdVideoImmersiveTipsView adVideoImmersiveTipsView6 = this.d;
                if (adVideoImmersiveTipsView6 != null) {
                    adVideoImmersiveTipsView6.i(0.0f);
                }
            }
        }
    }

    public final void n(int i, int i2) {
        fn0 fn0Var;
        hn0 hn0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) || (fn0Var = (fn0) j().q(fn0.class)) == null || (hn0Var = (hn0) j().q(hn0.class)) == null) {
            return;
        }
        if (!fn0Var.g()) {
            no0 no0Var = this.f;
            if ((no0Var != null ? no0Var.a() : 0) > 0) {
                if (this.e) {
                    return;
                }
                int l = hn0Var.l();
                no0 no0Var2 = this.f;
                if (l >= (no0Var2 != null ? no0Var2.a() : -1) && (i3 = i2 - i) <= 4) {
                    AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
                    if (adVideoImmersiveTipsView != null) {
                        adVideoImmersiveTipsView.l(i3);
                    }
                    this.e = true;
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

    public final void o() {
        fn0 fn0Var;
        WebViewContainer b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            no0 no0Var = this.f;
            if ((no0Var == null || !no0Var.d()) && this.d == null && (fn0Var = (fn0) j().q(fn0.class)) != null && (b2 = fn0Var.b()) != null) {
                cn0 a2 = dn0.a();
                Intrinsics.checkNotNullExpressionValue(a2, "NadMaxRuntime.getUIProvider()");
                a2.a();
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05ac, (ViewGroup) b2, true);
                Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(cont…youtId, parentView, true)");
                AdVideoImmersiveTipsView adVideoImmersiveTipsView = (AdVideoImmersiveTipsView) inflate.findViewById(R.id.obfuscated_res_0x7f0913c5);
                if (adVideoImmersiveTipsView != null) {
                    adVideoImmersiveTipsView.setOutClickListener(new a(this));
                    no0 no0Var2 = this.f;
                    int b3 = no0Var2 != null ? no0Var2.b() : -1;
                    no0 no0Var3 = this.f;
                    adVideoImmersiveTipsView.h(b3, no0Var3 != null ? no0Var3.c() : 0);
                    Unit unit = Unit.INSTANCE;
                } else {
                    adVideoImmersiveTipsView = null;
                }
                this.d = adVideoImmersiveTipsView;
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        a21 animTimer;
        a21 countDownTimer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
            AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
            if (adVideoImmersiveTipsView != null && (countDownTimer = adVideoImmersiveTipsView.getCountDownTimer()) != null) {
                countDownTimer.b();
            }
            AdVideoImmersiveTipsView adVideoImmersiveTipsView2 = this.d;
            if (adVideoImmersiveTipsView2 == null || (animTimer = adVideoImmersiveTipsView2.getAnimTimer()) == null) {
                return;
            }
            animTimer.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onRelease();
            AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
            if (adVideoImmersiveTipsView != null) {
                adVideoImmersiveTipsView.j();
                hh0.f(adVideoImmersiveTipsView);
            }
            this.d = null;
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        a21 animTimer;
        a21 animTimer2;
        a21 countDownTimer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            hn0 hn0Var = (hn0) j().q(hn0.class);
            if (hn0Var != null && hn0Var.k()) {
                AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
                if (adVideoImmersiveTipsView != null && (countDownTimer = adVideoImmersiveTipsView.getCountDownTimer()) != null) {
                    countDownTimer.c();
                }
                AdVideoImmersiveTipsView adVideoImmersiveTipsView2 = this.d;
                if (adVideoImmersiveTipsView2 == null || (animTimer2 = adVideoImmersiveTipsView2.getAnimTimer()) == null) {
                    return;
                }
                animTimer2.c();
                return;
            }
            AdVideoImmersiveTipsView adVideoImmersiveTipsView3 = this.d;
            if (adVideoImmersiveTipsView3 != null) {
                adVideoImmersiveTipsView3.m(false);
            }
            AdVideoImmersiveTipsView adVideoImmersiveTipsView4 = this.d;
            if (adVideoImmersiveTipsView4 == null || (animTimer = adVideoImmersiveTipsView4.getAnimTimer()) == null) {
                return;
            }
            animTimer.b();
        }
    }

    public final void p(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, intent) == null) {
            Serializable serializableExtra = intent.getSerializableExtra("map");
            if (!(serializableExtra instanceof HashMap)) {
                serializableExtra = null;
            }
            HashMap hashMap = (HashMap) serializableExtra;
            if (hashMap != null) {
                Object obj = hashMap.get("cmd_policy");
                String str = obj instanceof String ? obj : null;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f = no0.g.a(uy0.c(str));
            }
        }
    }
}
