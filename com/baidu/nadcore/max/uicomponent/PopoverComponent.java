package com.baidu.nadcore.max.uicomponent;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.nadcore.component.AbsComponentPlugin;
import com.baidu.nadcore.max.event.PopEventTypeEnum;
import com.baidu.nadcore.max.uiwidget.basic.WebViewContainer;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.bl0;
import com.baidu.tieba.bm0;
import com.baidu.tieba.e81;
import com.baidu.tieba.em0;
import com.baidu.tieba.g81;
import com.baidu.tieba.hm0;
import com.baidu.tieba.il0;
import com.baidu.tieba.jl0;
import com.baidu.tieba.jy0;
import com.baidu.tieba.kl0;
import com.baidu.tieba.ll0;
import com.baidu.tieba.ne0;
import com.baidu.tieba.pl0;
import com.baidu.tieba.rm0;
import com.baidu.tieba.ux0;
import com.baidu.tieba.v71;
import com.baidu.tieba.x11;
import com.baidu.tieba.xk0;
import com.baidu.tieba.yd0;
import com.baidu.tieba.yk0;
import com.baidu.tieba.ym0;
import com.baidu.tieba.zk0;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J'\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PopoverComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "", "scrollUp", "handleActionUp", "(Z)V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "withAnim", "hideAdPopOver", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initPopoverData", "(Lorg/json/JSONObject;)V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "", "currentY", "videoHeight", "minTopMargin", "onScroll", "(III)V", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/model/AdLpParams$AlsModel;", "alsModel", "sendActionAls", "(Lcom/baidu/nadcore/model/AdLpParams$AlsModel;)V", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "criusPopFactory", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "Landroid/view/View;", "criusPopView", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "hasShowPop", "Z", "hasStartCountDown", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popoverModel", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popviewHeight", "I", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "<init>", "PopOverListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class PopoverComponent extends AbsComponentPlugin {
    public g81<View> d;
    public hm0 e;
    public v71 f;
    public x11 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes3.dex */
    public final class a extends e81 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.e81
        public void a(boolean z, long j) {
            jl0 jl0Var = (jl0) PopoverComponent.this.g().q(jl0.class);
            if (jl0Var != null) {
                jl0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.e81
        public void b(rm0 clickInfo) {
            Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
            if (clickInfo.c) {
                if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                    yd0.c(clickInfo.a, PopoverComponent.this.b());
                } else {
                    il0 il0Var = (il0) PopoverComponent.this.g().q(il0.class);
                    if (il0Var != null) {
                        il0Var.i(false, true, false);
                    }
                }
                em0 em0Var = PopoverComponent.s(PopoverComponent.this).e;
                if (em0Var != null) {
                    em0Var.a();
                    em0Var.b = clickInfo.b;
                    em0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                    PopoverComponent.this.P(em0Var);
                }
            }
            PopoverComponent.this.g().j(new bl0(PopEventTypeEnum.CLICK_POP_UI));
        }

        @Override // com.baidu.tieba.e81
        public void c() {
            jl0 jl0Var = (jl0) PopoverComponent.this.g().q(jl0.class);
            if (jl0Var != null) {
                jl0Var.d(240L, false);
            }
            em0 em0Var = PopoverComponent.s(PopoverComponent.this).e;
            if (em0Var != null) {
                em0Var.a();
                em0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                PopoverComponent.this.P(em0Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends x11.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.x11.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            if (!PopoverComponent.this.h) {
                return;
            }
            g81 g81Var = PopoverComponent.this.d;
            if (g81Var != null) {
                if (PopoverComponent.s(PopoverComponent.this).a != 3) {
                    z = true;
                } else {
                    z = false;
                }
                g81Var.c(z);
            }
            if (PopoverComponent.s(PopoverComponent.this).a == 3) {
                il0 il0Var = (il0) PopoverComponent.this.g().q(il0.class);
                kl0 kl0Var = (kl0) PopoverComponent.this.g().q(kl0.class);
                if (il0Var != null && (b = il0Var.b()) != null) {
                    i = b.getTopMargin();
                } else {
                    i = 0;
                }
                if (kl0Var != null) {
                    i2 = kl0Var.getVideoHeight();
                } else {
                    i2 = 0;
                }
                int max = Math.max(0, PopoverComponent.this.i - (i2 - i));
                if (il0Var != null) {
                    il0Var.f(false, true, true, max);
                }
            }
            x11 x11Var = PopoverComponent.this.g;
            if (x11Var != null) {
                x11Var.a();
            }
            PopoverComponent.this.g = null;
        }

        @Override // com.baidu.tieba.x11.b
        public void e() {
            PopoverComponent.this.h = true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            PopoverComponent.this.F();
            x11 x11Var = PopoverComponent.this.g;
            if (x11Var != null) {
                x11Var.e();
            }
        }
    }

    public final void L() {
        x11 x11Var = this.g;
        if (x11Var != null) {
            x11Var.a();
        }
        this.g = null;
        hm0 hm0Var = this.e;
        if (hm0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        x11 x11Var2 = new x11(hm0Var.b * 1000, 1000L);
        x11Var2.d(new b());
        this.g = x11Var2;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        x11 x11Var = this.g;
        if (x11Var != null) {
            x11Var.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        J(false);
        g81<View> g81Var = this.d;
        if (g81Var != null) {
            g81Var.a();
        }
        this.d = null;
        x11 x11Var = this.g;
        if (x11Var != null) {
            x11Var.a();
        }
        this.g = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        x11 x11Var;
        super.onResume();
        kl0 kl0Var = (kl0) g().q(kl0.class);
        if (kl0Var != null && kl0Var.j() && (x11Var = this.g) != null) {
            x11Var.c();
        }
    }

    public static final /* synthetic */ hm0 s(PopoverComponent popoverComponent) {
        hm0 hm0Var = popoverComponent.e;
        if (hm0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return hm0Var;
    }

    public final void I(yk0 yk0Var) {
        int i = pl0.$EnumSwitchMapping$0[yk0Var.b().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.j = true;
                    return;
                }
                return;
            }
            x11 x11Var = this.g;
            if (x11Var != null) {
                x11Var.b();
                return;
            }
            return;
        }
        x11 x11Var2 = this.g;
        if (x11Var2 != null) {
            x11Var2.c();
        }
    }

    public final void J(boolean z) {
        View realView;
        g81<View> g81Var;
        g81<View> g81Var2 = this.d;
        if (g81Var2 != null && (realView = g81Var2.getRealView()) != null && realView.getVisibility() == 0 && (g81Var = this.d) != null) {
            g81Var.b("0", z);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void K(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.post(new c());
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        O(intent);
    }

    public final void F() {
        ll0 ll0Var;
        g81<View> g81Var;
        View videoHolder;
        kl0 kl0Var = (kl0) g().q(kl0.class);
        if (kl0Var != null && (ll0Var = (ll0) g().q(ll0.class)) != null && (g81Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            hm0 hm0Var = this.e;
            if (hm0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (hm0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            hm0 hm0Var2 = this.e;
            if (hm0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (hm0Var2.a == 3) {
                videoHolder = ll0Var.b().j();
            } else {
                videoHolder = kl0Var.getVideoHolder();
            }
            if (!(videoHolder instanceof ViewGroup)) {
                videoHolder = null;
            }
            g81Var.setContainer((ViewGroup) videoHolder, layoutParams);
        }
    }

    public final void H(boolean z) {
        g81<View> g81Var;
        View realView;
        kl0 kl0Var;
        il0 il0Var;
        boolean z2;
        hm0 hm0Var = this.e;
        if (hm0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (hm0Var.a != 3 || (g81Var = this.d) == null || (realView = g81Var.getRealView()) == null || realView.getVisibility() != 0 || (kl0Var = (kl0) g().q(kl0.class)) == null || (il0Var = (il0) g().q(il0.class)) == null || !kl0Var.j()) {
            return;
        }
        int videoHeight = kl0Var.getVideoHeight() - il0Var.b().getTopMargin();
        if (!z && videoHeight < this.i / 2) {
            return;
        }
        int abs = Math.abs(videoHeight - this.i);
        if (videoHeight > this.i) {
            z2 = true;
        } else {
            z2 = false;
        }
        il0Var.f(z2, true, true, abs);
    }

    public final void M(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Object obj;
        g81<View> g81Var;
        hm0 a2 = hm0.f.a(jSONObject);
        if (a2 != null) {
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
            ux0.f(jSONObject3, "cmd_map", jSONObject2);
            hm0 hm0Var = this.e;
            if (hm0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            v71 v71Var = this.f;
            View view2 = null;
            if (v71Var != null) {
                obj = v71Var.a(jSONObject3);
            } else {
                obj = null;
            }
            hm0Var.c = obj;
            hm0 hm0Var2 = this.e;
            if (hm0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (hm0Var2.c == null) {
                return;
            }
            hm0 hm0Var3 = this.e;
            if (hm0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (hm0Var3.a != 2) {
                hm0 hm0Var4 = this.e;
                if (hm0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (hm0Var4.a != 3) {
                    hm0 hm0Var5 = this.e;
                    if (hm0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (hm0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            hm0 hm0Var6 = this.e;
            if (hm0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (hm0Var6.c == null) {
                return;
            }
            hm0 hm0Var7 = this.e;
            if (hm0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            bm0 c2 = bm0.c(ux0.c(jSONObject.optString("download")));
            hm0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            em0 em0Var = new em0();
            em0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            em0Var.d = jSONObject.optString(MigrateStatisticUtils.EXT_INFO);
            Unit unit = Unit.INSTANCE;
            hm0Var7.e = em0Var;
            v71 v71Var2 = this.f;
            if (v71Var2 != null) {
                g81Var = v71Var2.b(b());
            } else {
                g81Var = null;
            }
            this.d = g81Var;
            if (g81Var == null) {
                g().C(this);
                return;
            }
            if (g81Var != null) {
                hm0 hm0Var8 = this.e;
                if (hm0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                g81Var.setData(hm0Var8);
                g81Var.setCriusPopListener(new a());
            }
            g81<View> g81Var2 = this.d;
            if (g81Var2 != null) {
                view2 = g81Var2.getRealView();
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

    public final void N(int i, int i2, int i3) {
        g81<View> g81Var;
        View realView;
        hm0 hm0Var = this.e;
        if (hm0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (hm0Var.a != 3 || (g81Var = this.d) == null || (realView = g81Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
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
        J(false);
    }

    public final void O(Intent intent) {
        v71 v71Var = (v71) ServiceManager.getService(v71.a);
        this.f = v71Var;
        if (v71Var == null) {
            g().C(this);
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
                ym0.v.a(ux0.c(str2));
            }
            M(jSONObject);
            L();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void t(ne0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.t(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, yk0.class.getSimpleName())) {
            I((yk0) event);
        } else if (Intrinsics.areEqual(a2, xk0.class.getSimpleName())) {
            xk0 xk0Var = (xk0) event;
            N(xk0Var.c(), xk0Var.d(), xk0Var.b());
        } else if (Intrinsics.areEqual(a2, zk0.class.getSimpleName())) {
            H(((zk0) event).b());
        }
    }

    public final void P(em0 em0Var) {
        jy0.e(new ClogBuilder().z(em0Var.c).v(em0Var.a).j(em0Var.b).p(em0Var.d).k(em0Var.e).l(em0Var.f).m(em0Var.g));
    }
}
