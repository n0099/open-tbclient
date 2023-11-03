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
import com.baidu.tieba.am0;
import com.baidu.tieba.az0;
import com.baidu.tieba.bm0;
import com.baidu.tieba.cm0;
import com.baidu.tieba.ef0;
import com.baidu.tieba.gm0;
import com.baidu.tieba.in0;
import com.baidu.tieba.ly0;
import com.baidu.tieba.m81;
import com.baidu.tieba.o21;
import com.baidu.tieba.ol0;
import com.baidu.tieba.pe0;
import com.baidu.tieba.pl0;
import com.baidu.tieba.pn0;
import com.baidu.tieba.ql0;
import com.baidu.tieba.sl0;
import com.baidu.tieba.sm0;
import com.baidu.tieba.v81;
import com.baidu.tieba.vm0;
import com.baidu.tieba.x81;
import com.baidu.tieba.ym0;
import com.baidu.tieba.zl0;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J'\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PopoverComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "", "scrollUp", "handleActionUp", "(Z)V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "withAnim", "hideAdPopOver", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initPopoverData", "(Lorg/json/JSONObject;)V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "", "currentY", "videoHeight", "minTopMargin", "onScroll", "(III)V", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/model/AdLpParams$AlsModel;", "alsModel", "sendActionAls", "(Lcom/baidu/nadcore/model/AdLpParams$AlsModel;)V", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "criusPopFactory", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "Landroid/view/View;", "criusPopView", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "hasShowPop", "Z", "hasStartCountDown", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popoverModel", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popviewHeight", "I", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "<init>", "PopOverListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class PopoverComponent extends AbsComponentPlugin {
    public x81<View> d;
    public ym0 e;
    public m81 f;
    public o21 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes3.dex */
    public final class a extends v81 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.v81
        public void a(boolean z, long j) {
            am0 am0Var = (am0) PopoverComponent.this.g().q(am0.class);
            if (am0Var != null) {
                am0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.v81
        public void b(in0 clickInfo) {
            Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
            if (clickInfo.c) {
                if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                    pe0.c(clickInfo.a, PopoverComponent.this.b());
                } else {
                    zl0 zl0Var = (zl0) PopoverComponent.this.g().q(zl0.class);
                    if (zl0Var != null) {
                        zl0Var.i(false, true, false);
                    }
                }
                vm0 vm0Var = PopoverComponent.r(PopoverComponent.this).e;
                if (vm0Var != null) {
                    vm0Var.a();
                    vm0Var.b = clickInfo.b;
                    vm0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                    PopoverComponent.this.P(vm0Var);
                }
            }
            PopoverComponent.this.g().j(new sl0(PopEventTypeEnum.CLICK_POP_UI));
        }

        @Override // com.baidu.tieba.v81
        public void c() {
            am0 am0Var = (am0) PopoverComponent.this.g().q(am0.class);
            if (am0Var != null) {
                am0Var.d(240L, false);
            }
            vm0 vm0Var = PopoverComponent.r(PopoverComponent.this).e;
            if (vm0Var != null) {
                vm0Var.a();
                vm0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                PopoverComponent.this.P(vm0Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends o21.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.o21.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            if (!PopoverComponent.this.h) {
                return;
            }
            x81 x81Var = PopoverComponent.this.d;
            if (x81Var != null) {
                if (PopoverComponent.r(PopoverComponent.this).a != 3) {
                    z = true;
                } else {
                    z = false;
                }
                x81Var.c(z);
            }
            if (PopoverComponent.r(PopoverComponent.this).a == 3) {
                zl0 zl0Var = (zl0) PopoverComponent.this.g().q(zl0.class);
                bm0 bm0Var = (bm0) PopoverComponent.this.g().q(bm0.class);
                if (zl0Var != null && (b = zl0Var.b()) != null) {
                    i = b.getTopMargin();
                } else {
                    i = 0;
                }
                if (bm0Var != null) {
                    i2 = bm0Var.getVideoHeight();
                } else {
                    i2 = 0;
                }
                int max = Math.max(0, PopoverComponent.this.i - (i2 - i));
                if (zl0Var != null) {
                    zl0Var.f(false, true, true, max);
                }
            }
            o21 o21Var = PopoverComponent.this.g;
            if (o21Var != null) {
                o21Var.a();
            }
            PopoverComponent.this.g = null;
        }

        @Override // com.baidu.tieba.o21.b
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
            o21 o21Var = PopoverComponent.this.g;
            if (o21Var != null) {
                o21Var.e();
            }
        }
    }

    public final void K() {
        o21 o21Var = this.g;
        if (o21Var != null) {
            o21Var.a();
        }
        this.g = null;
        ym0 ym0Var = this.e;
        if (ym0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        o21 o21Var2 = new o21(ym0Var.b * 1000, 1000L);
        o21Var2.d(new b());
        this.g = o21Var2;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        o21 o21Var = this.g;
        if (o21Var != null) {
            o21Var.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        J(false);
        x81<View> x81Var = this.d;
        if (x81Var != null) {
            x81Var.a();
        }
        this.d = null;
        o21 o21Var = this.g;
        if (o21Var != null) {
            o21Var.a();
        }
        this.g = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        o21 o21Var;
        super.onResume();
        bm0 bm0Var = (bm0) g().q(bm0.class);
        if (bm0Var != null && bm0Var.j() && (o21Var = this.g) != null) {
            o21Var.c();
        }
    }

    public static final /* synthetic */ ym0 r(PopoverComponent popoverComponent) {
        ym0 ym0Var = popoverComponent.e;
        if (ym0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return ym0Var;
    }

    public final void I(pl0 pl0Var) {
        int i = gm0.$EnumSwitchMapping$0[pl0Var.b().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.j = true;
                    return;
                }
                return;
            }
            o21 o21Var = this.g;
            if (o21Var != null) {
                o21Var.b();
                return;
            }
            return;
        }
        o21 o21Var2 = this.g;
        if (o21Var2 != null) {
            o21Var2.c();
        }
    }

    public final void J(boolean z) {
        View realView;
        x81<View> x81Var;
        x81<View> x81Var2 = this.d;
        if (x81Var2 != null && (realView = x81Var2.getRealView()) != null && realView.getVisibility() == 0 && (x81Var = this.d) != null) {
            x81Var.b("0", z);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void L(ViewGroup parent) {
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
        cm0 cm0Var;
        x81<View> x81Var;
        View videoHolder;
        bm0 bm0Var = (bm0) g().q(bm0.class);
        if (bm0Var != null && (cm0Var = (cm0) g().q(cm0.class)) != null && (x81Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            ym0 ym0Var = this.e;
            if (ym0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (ym0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            ym0 ym0Var2 = this.e;
            if (ym0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (ym0Var2.a == 3) {
                videoHolder = cm0Var.b().j();
            } else {
                videoHolder = bm0Var.getVideoHolder();
            }
            if (!(videoHolder instanceof ViewGroup)) {
                videoHolder = null;
            }
            x81Var.setContainer((ViewGroup) videoHolder, layoutParams);
        }
    }

    public final void G(boolean z) {
        x81<View> x81Var;
        View realView;
        bm0 bm0Var;
        zl0 zl0Var;
        boolean z2;
        ym0 ym0Var = this.e;
        if (ym0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (ym0Var.a != 3 || (x81Var = this.d) == null || (realView = x81Var.getRealView()) == null || realView.getVisibility() != 0 || (bm0Var = (bm0) g().q(bm0.class)) == null || (zl0Var = (zl0) g().q(zl0.class)) == null || !bm0Var.j()) {
            return;
        }
        int videoHeight = bm0Var.getVideoHeight() - zl0Var.b().getTopMargin();
        if (!z && videoHeight < this.i / 2) {
            return;
        }
        int abs = Math.abs(videoHeight - this.i);
        if (videoHeight > this.i) {
            z2 = true;
        } else {
            z2 = false;
        }
        zl0Var.f(z2, true, true, abs);
    }

    public final void M(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Object obj;
        x81<View> x81Var;
        ym0 a2 = ym0.f.a(jSONObject);
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
            ly0.f(jSONObject3, "cmd_map", jSONObject2);
            ym0 ym0Var = this.e;
            if (ym0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            m81 m81Var = this.f;
            View view2 = null;
            if (m81Var != null) {
                obj = m81Var.a(jSONObject3);
            } else {
                obj = null;
            }
            ym0Var.c = obj;
            ym0 ym0Var2 = this.e;
            if (ym0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (ym0Var2.c == null) {
                return;
            }
            ym0 ym0Var3 = this.e;
            if (ym0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (ym0Var3.a != 2) {
                ym0 ym0Var4 = this.e;
                if (ym0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (ym0Var4.a != 3) {
                    ym0 ym0Var5 = this.e;
                    if (ym0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (ym0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            ym0 ym0Var6 = this.e;
            if (ym0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (ym0Var6.c == null) {
                return;
            }
            ym0 ym0Var7 = this.e;
            if (ym0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            sm0 c2 = sm0.c(ly0.c(jSONObject.optString("download")));
            ym0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            vm0 vm0Var = new vm0();
            vm0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            vm0Var.d = jSONObject.optString(MigrateStatisticUtils.EXT_INFO);
            Unit unit = Unit.INSTANCE;
            ym0Var7.e = vm0Var;
            m81 m81Var2 = this.f;
            if (m81Var2 != null) {
                x81Var = m81Var2.b(b());
            } else {
                x81Var = null;
            }
            this.d = x81Var;
            if (x81Var == null) {
                g().C(this);
                return;
            }
            if (x81Var != null) {
                ym0 ym0Var8 = this.e;
                if (ym0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                x81Var.setData(ym0Var8);
                x81Var.setCriusPopListener(new a());
            }
            x81<View> x81Var2 = this.d;
            if (x81Var2 != null) {
                view2 = x81Var2.getRealView();
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
        x81<View> x81Var;
        View realView;
        ym0 ym0Var = this.e;
        if (ym0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (ym0Var.a != 3 || (x81Var = this.d) == null || (realView = x81Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
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
        m81 m81Var = (m81) ServiceManager.getService(m81.a);
        this.f = m81Var;
        if (m81Var == null) {
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
                pn0.v.a(ly0.c(str2));
            }
            M(jSONObject);
            K();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void s(ef0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.s(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, pl0.class.getSimpleName())) {
            I((pl0) event);
        } else if (Intrinsics.areEqual(a2, ol0.class.getSimpleName())) {
            ol0 ol0Var = (ol0) event;
            N(ol0Var.c(), ol0Var.d(), ol0Var.b());
        } else if (Intrinsics.areEqual(a2, ql0.class.getSimpleName())) {
            G(((ql0) event).b());
        }
    }

    public final void P(vm0 vm0Var) {
        az0.e(new ClogBuilder().z(vm0Var.c).v(vm0Var.a).j(vm0Var.b).p(vm0Var.d).k(vm0Var.e).l(vm0Var.f).m(vm0Var.g));
    }
}
