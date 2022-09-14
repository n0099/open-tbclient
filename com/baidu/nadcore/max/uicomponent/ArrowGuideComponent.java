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
import com.baidu.tieba.bp0;
import com.baidu.tieba.in0;
import com.baidu.tieba.jh0;
import com.baidu.tieba.jn0;
import com.baidu.tieba.ki0;
import com.baidu.tieba.kz0;
import com.baidu.tieba.nn0;
import com.baidu.tieba.qn0;
import com.baidu.tieba.rn0;
import com.baidu.tieba.sn0;
import com.baidu.tieba.tn0;
import com.baidu.tieba.vn0;
import com.baidu.tieba.xn0;
import com.baidu.tieba.y21;
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
    public bp0 f;

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
                vn0 vn0Var = (vn0) this.a.j().p(vn0.class);
                if (vn0Var == null || !vn0Var.k()) {
                    tn0 tn0Var = (tn0) this.a.j().p(tn0.class);
                    if (tn0Var != null) {
                        tn0Var.j(true, true, false);
                    }
                } else {
                    tn0 tn0Var2 = (tn0) this.a.j().p(tn0.class);
                    if (tn0Var2 != null) {
                        tn0Var2.j(false, true, false);
                    }
                }
                sn0 sn0Var = (sn0) this.a.j().p(sn0.class);
                if (sn0Var != null) {
                    String str = ClogBuilder.LogType.FREE_CLICK.type;
                    Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
                    sn0Var.a(str, "learnmore");
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
    public void b(ki0 event) {
        in0 in0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.b(event);
            String a2 = event.a();
            if (Intrinsics.areEqual(a2, nn0.class.getSimpleName())) {
                if (!(event instanceof nn0)) {
                    event = null;
                }
                nn0 nn0Var = (nn0) event;
                if (nn0Var != null) {
                    n(nn0Var.c(), nn0Var.b());
                }
            } else if (Intrinsics.areEqual(a2, jn0.class.getSimpleName())) {
                m((jn0) event);
            } else if (Intrinsics.areEqual(a2, in0.class.getSimpleName())) {
                if (!(event instanceof in0)) {
                    event = null;
                }
                if (((in0) event) != null) {
                    float c = in0Var.c() / (in0Var.d() - in0Var.b());
                    AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
                    if (adVideoImmersiveTipsView != null) {
                        adVideoImmersiveTipsView.i(c);
                    }
                }
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void g(ViewGroup parent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            parent.post(new b(this));
        }
    }

    public final void m(jn0 jn0Var) {
        y21 animTimer;
        y21 countDownTimer;
        y21 animTimer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jn0Var) == null) {
            int i = xn0.$EnumSwitchMapping$0[jn0Var.getType().ordinal()];
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
        tn0 tn0Var;
        vn0 vn0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) || (tn0Var = (tn0) j().p(tn0.class)) == null || (vn0Var = (vn0) j().p(vn0.class)) == null) {
            return;
        }
        if (!tn0Var.g()) {
            bp0 bp0Var = this.f;
            if ((bp0Var != null ? bp0Var.a() : 0) > 0) {
                if (this.e) {
                    return;
                }
                int l = vn0Var.l();
                bp0 bp0Var2 = this.f;
                if (l >= (bp0Var2 != null ? bp0Var2.a() : -1) && (i3 = i2 - i) <= 4) {
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
        tn0 tn0Var;
        WebViewContainer b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            bp0 bp0Var = this.f;
            if ((bp0Var == null || !bp0Var.d()) && this.d == null && (tn0Var = (tn0) j().p(tn0.class)) != null && (b2 = tn0Var.b()) != null) {
                qn0 a2 = rn0.a();
                Intrinsics.checkNotNullExpressionValue(a2, "NadMaxRuntime.getUIProvider()");
                a2.a();
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05fc, (ViewGroup) b2, true);
                Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(cont…youtId, parentView, true)");
                AdVideoImmersiveTipsView adVideoImmersiveTipsView = (AdVideoImmersiveTipsView) inflate.findViewById(R.id.obfuscated_res_0x7f0914cd);
                if (adVideoImmersiveTipsView != null) {
                    adVideoImmersiveTipsView.setOutClickListener(new a(this));
                    bp0 bp0Var2 = this.f;
                    int b3 = bp0Var2 != null ? bp0Var2.b() : -1;
                    bp0 bp0Var3 = this.f;
                    adVideoImmersiveTipsView.h(b3, bp0Var3 != null ? bp0Var3.c() : 0);
                    Unit unit = Unit.INSTANCE;
                } else {
                    adVideoImmersiveTipsView = null;
                }
                this.d = adVideoImmersiveTipsView;
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            super.onNewIntent(intent);
            p(intent);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        y21 animTimer;
        y21 countDownTimer;
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
                jh0.e(adVideoImmersiveTipsView);
            }
            this.d = null;
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        y21 animTimer;
        y21 animTimer2;
        y21 countDownTimer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            vn0 vn0Var = (vn0) j().p(vn0.class);
            if (vn0Var != null && vn0Var.k()) {
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
                this.f = bp0.f.a(kz0.c(str));
            }
        }
    }
}
