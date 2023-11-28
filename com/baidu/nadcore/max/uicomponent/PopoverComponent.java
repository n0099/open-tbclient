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
import com.baidu.tieba.bm0;
import com.baidu.tieba.bz0;
import com.baidu.tieba.cm0;
import com.baidu.tieba.dm0;
import com.baidu.tieba.ff0;
import com.baidu.tieba.hm0;
import com.baidu.tieba.jn0;
import com.baidu.tieba.my0;
import com.baidu.tieba.n81;
import com.baidu.tieba.p21;
import com.baidu.tieba.pl0;
import com.baidu.tieba.qe0;
import com.baidu.tieba.ql0;
import com.baidu.tieba.qn0;
import com.baidu.tieba.rl0;
import com.baidu.tieba.tl0;
import com.baidu.tieba.tm0;
import com.baidu.tieba.w81;
import com.baidu.tieba.wm0;
import com.baidu.tieba.y81;
import com.baidu.tieba.zm0;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J'\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PopoverComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "", "scrollUp", "handleActionUp", "(Z)V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "withAnim", "hideAdPopOver", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initPopoverData", "(Lorg/json/JSONObject;)V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "", "currentY", "videoHeight", "minTopMargin", "onScroll", "(III)V", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/model/AdLpParams$AlsModel;", "alsModel", "sendActionAls", "(Lcom/baidu/nadcore/model/AdLpParams$AlsModel;)V", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "criusPopFactory", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "Landroid/view/View;", "criusPopView", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "hasShowPop", "Z", "hasStartCountDown", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popoverModel", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popviewHeight", "I", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "<init>", "PopOverListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class PopoverComponent extends AbsComponentPlugin {
    public y81<View> d;
    public zm0 e;
    public n81 f;
    public p21 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes3.dex */
    public final class a extends w81 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.w81
        public void a(boolean z, long j) {
            bm0 bm0Var = (bm0) PopoverComponent.this.f().q(bm0.class);
            if (bm0Var != null) {
                bm0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.w81
        public void b(jn0 clickInfo) {
            Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
            if (clickInfo.c) {
                if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                    qe0.c(clickInfo.a, PopoverComponent.this.b());
                } else {
                    am0 am0Var = (am0) PopoverComponent.this.f().q(am0.class);
                    if (am0Var != null) {
                        am0Var.i(false, true, false);
                    }
                }
                wm0 wm0Var = PopoverComponent.r(PopoverComponent.this).e;
                if (wm0Var != null) {
                    wm0Var.a();
                    wm0Var.b = clickInfo.b;
                    wm0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                    PopoverComponent.this.P(wm0Var);
                }
            }
            PopoverComponent.this.f().i(new tl0(PopEventTypeEnum.CLICK_POP_UI));
        }

        @Override // com.baidu.tieba.w81
        public void c() {
            bm0 bm0Var = (bm0) PopoverComponent.this.f().q(bm0.class);
            if (bm0Var != null) {
                bm0Var.d(240L, false);
            }
            wm0 wm0Var = PopoverComponent.r(PopoverComponent.this).e;
            if (wm0Var != null) {
                wm0Var.a();
                wm0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                PopoverComponent.this.P(wm0Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends p21.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.p21.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            if (!PopoverComponent.this.h) {
                return;
            }
            y81 y81Var = PopoverComponent.this.d;
            if (y81Var != null) {
                if (PopoverComponent.r(PopoverComponent.this).a != 3) {
                    z = true;
                } else {
                    z = false;
                }
                y81Var.c(z);
            }
            if (PopoverComponent.r(PopoverComponent.this).a == 3) {
                am0 am0Var = (am0) PopoverComponent.this.f().q(am0.class);
                cm0 cm0Var = (cm0) PopoverComponent.this.f().q(cm0.class);
                if (am0Var != null && (b = am0Var.b()) != null) {
                    i = b.getTopMargin();
                } else {
                    i = 0;
                }
                if (cm0Var != null) {
                    i2 = cm0Var.getVideoHeight();
                } else {
                    i2 = 0;
                }
                int max = Math.max(0, PopoverComponent.this.i - (i2 - i));
                if (am0Var != null) {
                    am0Var.f(false, true, true, max);
                }
            }
            p21 p21Var = PopoverComponent.this.g;
            if (p21Var != null) {
                p21Var.a();
            }
            PopoverComponent.this.g = null;
        }

        @Override // com.baidu.tieba.p21.b
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
            p21 p21Var = PopoverComponent.this.g;
            if (p21Var != null) {
                p21Var.e();
            }
        }
    }

    public final void K() {
        p21 p21Var = this.g;
        if (p21Var != null) {
            p21Var.a();
        }
        this.g = null;
        zm0 zm0Var = this.e;
        if (zm0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        p21 p21Var2 = new p21(zm0Var.b * 1000, 1000L);
        p21Var2.d(new b());
        this.g = p21Var2;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        p21 p21Var = this.g;
        if (p21Var != null) {
            p21Var.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        J(false);
        y81<View> y81Var = this.d;
        if (y81Var != null) {
            y81Var.a();
        }
        this.d = null;
        p21 p21Var = this.g;
        if (p21Var != null) {
            p21Var.a();
        }
        this.g = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        p21 p21Var;
        super.onResume();
        cm0 cm0Var = (cm0) f().q(cm0.class);
        if (cm0Var != null && cm0Var.j() && (p21Var = this.g) != null) {
            p21Var.c();
        }
    }

    public static final /* synthetic */ zm0 r(PopoverComponent popoverComponent) {
        zm0 zm0Var = popoverComponent.e;
        if (zm0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return zm0Var;
    }

    public final void I(ql0 ql0Var) {
        int i = hm0.$EnumSwitchMapping$0[ql0Var.b().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.j = true;
                    return;
                }
                return;
            }
            p21 p21Var = this.g;
            if (p21Var != null) {
                p21Var.b();
                return;
            }
            return;
        }
        p21 p21Var2 = this.g;
        if (p21Var2 != null) {
            p21Var2.c();
        }
    }

    public final void J(boolean z) {
        View realView;
        y81<View> y81Var;
        y81<View> y81Var2 = this.d;
        if (y81Var2 != null && (realView = y81Var2.getRealView()) != null && realView.getVisibility() == 0 && (y81Var = this.d) != null) {
            y81Var.b("0", z);
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
        dm0 dm0Var;
        y81<View> y81Var;
        View videoHolder;
        cm0 cm0Var = (cm0) f().q(cm0.class);
        if (cm0Var != null && (dm0Var = (dm0) f().q(dm0.class)) != null && (y81Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            zm0 zm0Var = this.e;
            if (zm0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (zm0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            zm0 zm0Var2 = this.e;
            if (zm0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (zm0Var2.a == 3) {
                videoHolder = dm0Var.b().j();
            } else {
                videoHolder = cm0Var.getVideoHolder();
            }
            if (!(videoHolder instanceof ViewGroup)) {
                videoHolder = null;
            }
            y81Var.setContainer((ViewGroup) videoHolder, layoutParams);
        }
    }

    public final void G(boolean z) {
        y81<View> y81Var;
        View realView;
        cm0 cm0Var;
        am0 am0Var;
        boolean z2;
        zm0 zm0Var = this.e;
        if (zm0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (zm0Var.a != 3 || (y81Var = this.d) == null || (realView = y81Var.getRealView()) == null || realView.getVisibility() != 0 || (cm0Var = (cm0) f().q(cm0.class)) == null || (am0Var = (am0) f().q(am0.class)) == null || !cm0Var.j()) {
            return;
        }
        int videoHeight = cm0Var.getVideoHeight() - am0Var.b().getTopMargin();
        if (!z && videoHeight < this.i / 2) {
            return;
        }
        int abs = Math.abs(videoHeight - this.i);
        if (videoHeight > this.i) {
            z2 = true;
        } else {
            z2 = false;
        }
        am0Var.f(z2, true, true, abs);
    }

    public final void M(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Object obj;
        y81<View> y81Var;
        zm0 a2 = zm0.f.a(jSONObject);
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
            my0.f(jSONObject3, "cmd_map", jSONObject2);
            zm0 zm0Var = this.e;
            if (zm0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            n81 n81Var = this.f;
            View view2 = null;
            if (n81Var != null) {
                obj = n81Var.a(jSONObject3);
            } else {
                obj = null;
            }
            zm0Var.c = obj;
            zm0 zm0Var2 = this.e;
            if (zm0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (zm0Var2.c == null) {
                return;
            }
            zm0 zm0Var3 = this.e;
            if (zm0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (zm0Var3.a != 2) {
                zm0 zm0Var4 = this.e;
                if (zm0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (zm0Var4.a != 3) {
                    zm0 zm0Var5 = this.e;
                    if (zm0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (zm0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            zm0 zm0Var6 = this.e;
            if (zm0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (zm0Var6.c == null) {
                return;
            }
            zm0 zm0Var7 = this.e;
            if (zm0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            tm0 c2 = tm0.c(my0.c(jSONObject.optString("download")));
            zm0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            wm0 wm0Var = new wm0();
            wm0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            wm0Var.d = jSONObject.optString(MigrateStatisticUtils.EXT_INFO);
            Unit unit = Unit.INSTANCE;
            zm0Var7.e = wm0Var;
            n81 n81Var2 = this.f;
            if (n81Var2 != null) {
                y81Var = n81Var2.b(b());
            } else {
                y81Var = null;
            }
            this.d = y81Var;
            if (y81Var == null) {
                f().B(this);
                return;
            }
            if (y81Var != null) {
                zm0 zm0Var8 = this.e;
                if (zm0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                y81Var.setData(zm0Var8);
                y81Var.setCriusPopListener(new a());
            }
            y81<View> y81Var2 = this.d;
            if (y81Var2 != null) {
                view2 = y81Var2.getRealView();
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
        y81<View> y81Var;
        View realView;
        zm0 zm0Var = this.e;
        if (zm0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (zm0Var.a != 3 || (y81Var = this.d) == null || (realView = y81Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
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
        n81 n81Var = (n81) ServiceManager.getService(n81.a);
        this.f = n81Var;
        if (n81Var == null) {
            f().B(this);
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
                qn0.v.a(my0.c(str2));
            }
            M(jSONObject);
            K();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void s(ff0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.s(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, ql0.class.getSimpleName())) {
            I((ql0) event);
        } else if (Intrinsics.areEqual(a2, pl0.class.getSimpleName())) {
            pl0 pl0Var = (pl0) event;
            N(pl0Var.c(), pl0Var.d(), pl0Var.b());
        } else if (Intrinsics.areEqual(a2, rl0.class.getSimpleName())) {
            G(((rl0) event).b());
        }
    }

    public final void P(wm0 wm0Var) {
        bz0.e(new ClogBuilder().z(wm0Var.c).v(wm0Var.a).j(wm0Var.b).p(wm0Var.d).k(wm0Var.e).l(wm0Var.f).m(wm0Var.g));
    }
}
