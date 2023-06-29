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
import com.baidu.tieba.ar0;
import com.baidu.tieba.as0;
import com.baidu.tieba.c31;
import com.baidu.tieba.fe1;
import com.baidu.tieba.hs0;
import com.baidu.tieba.iq0;
import com.baidu.tieba.jq0;
import com.baidu.tieba.kq0;
import com.baidu.tieba.mk0;
import com.baidu.tieba.mq0;
import com.baidu.tieba.mr0;
import com.baidu.tieba.pr0;
import com.baidu.tieba.r31;
import com.baidu.tieba.re1;
import com.baidu.tieba.sr0;
import com.baidu.tieba.te1;
import com.baidu.tieba.tq0;
import com.baidu.tieba.uq0;
import com.baidu.tieba.vq0;
import com.baidu.tieba.wq0;
import com.baidu.tieba.xj0;
import com.baidu.tieba.y61;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J'\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PopoverComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "", "scrollUp", "handleActionUp", "(Z)V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "withAnim", "hideAdPopOver", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initPopoverData", "(Lorg/json/JSONObject;)V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "", "currentY", "videoHeight", "minTopMargin", "onScroll", "(III)V", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/model/AdLpParams$AlsModel;", "alsModel", "sendActionAls", "(Lcom/baidu/nadcore/model/AdLpParams$AlsModel;)V", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "criusPopFactory", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "Landroid/view/View;", "criusPopView", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "hasShowPop", "Z", "hasStartCountDown", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popoverModel", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popviewHeight", "I", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "<init>", "PopOverListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class PopoverComponent extends AbsComponentPlugin {
    public te1<View> d;
    public sr0 e;
    public fe1 f;
    public y61 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes3.dex */
    public final class a extends re1 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.re1
        public void a(boolean z, long j) {
            uq0 uq0Var = (uq0) PopoverComponent.this.j().q(uq0.class);
            if (uq0Var != null) {
                uq0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.re1
        public void b(as0 clickInfo) {
            Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
            if (clickInfo.c) {
                if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                    xj0.c(clickInfo.a, PopoverComponent.this.getContext());
                } else {
                    tq0 tq0Var = (tq0) PopoverComponent.this.j().q(tq0.class);
                    if (tq0Var != null) {
                        tq0Var.j(false, true, false);
                    }
                }
                pr0 pr0Var = PopoverComponent.s(PopoverComponent.this).e;
                if (pr0Var != null) {
                    pr0Var.a();
                    pr0Var.b = clickInfo.b;
                    pr0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                    PopoverComponent.this.N(pr0Var);
                }
            }
            PopoverComponent.this.j().g(new mq0(PopEventTypeEnum.CLICK_POP_UI));
        }

        @Override // com.baidu.tieba.re1
        public void c() {
            uq0 uq0Var = (uq0) PopoverComponent.this.j().q(uq0.class);
            if (uq0Var != null) {
                uq0Var.d(240L, false);
            }
            pr0 pr0Var = PopoverComponent.s(PopoverComponent.this).e;
            if (pr0Var != null) {
                pr0Var.a();
                pr0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                PopoverComponent.this.N(pr0Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends y61.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.y61.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            if (!PopoverComponent.this.h) {
                return;
            }
            te1 te1Var = PopoverComponent.this.d;
            if (te1Var != null) {
                if (PopoverComponent.s(PopoverComponent.this).a != 3) {
                    z = true;
                } else {
                    z = false;
                }
                te1Var.c(z);
            }
            if (PopoverComponent.s(PopoverComponent.this).a == 3) {
                tq0 tq0Var = (tq0) PopoverComponent.this.j().q(tq0.class);
                vq0 vq0Var = (vq0) PopoverComponent.this.j().q(vq0.class);
                if (tq0Var != null && (b = tq0Var.b()) != null) {
                    i = b.getTopMargin();
                } else {
                    i = 0;
                }
                if (vq0Var != null) {
                    i2 = vq0Var.getVideoHeight();
                } else {
                    i2 = 0;
                }
                int max = Math.max(0, PopoverComponent.this.i - (i2 - i));
                if (tq0Var != null) {
                    tq0Var.f(false, true, true, max);
                }
            }
            y61 y61Var = PopoverComponent.this.g;
            if (y61Var != null) {
                y61Var.a();
            }
            PopoverComponent.this.g = null;
        }

        @Override // com.baidu.tieba.y61.b
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
            PopoverComponent.this.D();
            y61 y61Var = PopoverComponent.this.g;
            if (y61Var != null) {
                y61Var.e();
            }
        }
    }

    public final void I() {
        y61 y61Var = this.g;
        if (y61Var != null) {
            y61Var.a();
        }
        this.g = null;
        sr0 sr0Var = this.e;
        if (sr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        y61 y61Var2 = new y61(sr0Var.b * 1000, 1000L);
        y61Var2.d(new b());
        this.g = y61Var2;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        y61 y61Var = this.g;
        if (y61Var != null) {
            y61Var.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        H(false);
        te1<View> te1Var = this.d;
        if (te1Var != null) {
            te1Var.a();
        }
        this.d = null;
        y61 y61Var = this.g;
        if (y61Var != null) {
            y61Var.a();
        }
        this.g = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        y61 y61Var;
        super.onResume();
        vq0 vq0Var = (vq0) j().q(vq0.class);
        if (vq0Var != null && vq0Var.k() && (y61Var = this.g) != null) {
            y61Var.c();
        }
    }

    public static final /* synthetic */ sr0 s(PopoverComponent popoverComponent) {
        sr0 sr0Var = popoverComponent.e;
        if (sr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return sr0Var;
    }

    public final void G(jq0 jq0Var) {
        int i = ar0.$EnumSwitchMapping$0[jq0Var.getType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.j = true;
                    return;
                }
                return;
            }
            y61 y61Var = this.g;
            if (y61Var != null) {
                y61Var.b();
                return;
            }
            return;
        }
        y61 y61Var2 = this.g;
        if (y61Var2 != null) {
            y61Var2.c();
        }
    }

    public final void H(boolean z) {
        View realView;
        te1<View> te1Var;
        te1<View> te1Var2 = this.d;
        if (te1Var2 != null && (realView = te1Var2.getRealView()) != null && realView.getVisibility() == 0 && (te1Var = this.d) != null) {
            te1Var.b("0", z);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void P(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.post(new c());
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        M(intent);
    }

    public final void D() {
        wq0 wq0Var;
        te1<View> te1Var;
        View h;
        vq0 vq0Var = (vq0) j().q(vq0.class);
        if (vq0Var != null && (wq0Var = (wq0) j().q(wq0.class)) != null && (te1Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            sr0 sr0Var = this.e;
            if (sr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (sr0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            sr0 sr0Var2 = this.e;
            if (sr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (sr0Var2.a == 3) {
                h = wq0Var.b().l();
            } else {
                h = vq0Var.h();
            }
            if (!(h instanceof ViewGroup)) {
                h = null;
            }
            te1Var.setContainer((ViewGroup) h, layoutParams);
        }
    }

    public final void E(boolean z) {
        te1<View> te1Var;
        View realView;
        vq0 vq0Var;
        tq0 tq0Var;
        boolean z2;
        sr0 sr0Var = this.e;
        if (sr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (sr0Var.a != 3 || (te1Var = this.d) == null || (realView = te1Var.getRealView()) == null || realView.getVisibility() != 0 || (vq0Var = (vq0) j().q(vq0.class)) == null || (tq0Var = (tq0) j().q(tq0.class)) == null || !vq0Var.k()) {
            return;
        }
        int videoHeight = vq0Var.getVideoHeight() - tq0Var.b().getTopMargin();
        if (!z && videoHeight < this.i / 2) {
            return;
        }
        int abs = Math.abs(videoHeight - this.i);
        if (videoHeight > this.i) {
            z2 = true;
        } else {
            z2 = false;
        }
        tq0Var.f(z2, true, true, abs);
    }

    public final void J(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Object obj;
        te1<View> te1Var;
        sr0 a2 = sr0.f.a(jSONObject);
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
            c31.f(jSONObject3, "cmd_map", jSONObject2);
            sr0 sr0Var = this.e;
            if (sr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            fe1 fe1Var = this.f;
            View view2 = null;
            if (fe1Var != null) {
                obj = fe1Var.a(jSONObject3);
            } else {
                obj = null;
            }
            sr0Var.c = obj;
            sr0 sr0Var2 = this.e;
            if (sr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (sr0Var2.c == null) {
                return;
            }
            sr0 sr0Var3 = this.e;
            if (sr0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (sr0Var3.a != 2) {
                sr0 sr0Var4 = this.e;
                if (sr0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (sr0Var4.a != 3) {
                    sr0 sr0Var5 = this.e;
                    if (sr0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (sr0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            sr0 sr0Var6 = this.e;
            if (sr0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (sr0Var6.c == null) {
                return;
            }
            sr0 sr0Var7 = this.e;
            if (sr0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            mr0 c2 = mr0.c(c31.c(jSONObject.optString("download")));
            sr0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            pr0 pr0Var = new pr0();
            pr0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            pr0Var.d = jSONObject.optString(MigrateStatisticUtils.EXT_INFO);
            Unit unit = Unit.INSTANCE;
            sr0Var7.e = pr0Var;
            fe1 fe1Var2 = this.f;
            if (fe1Var2 != null) {
                te1Var = fe1Var2.b(getContext());
            } else {
                te1Var = null;
            }
            this.d = te1Var;
            if (te1Var == null) {
                j().v(this);
                return;
            }
            if (te1Var != null) {
                sr0 sr0Var8 = this.e;
                if (sr0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                te1Var.setData(sr0Var8);
                te1Var.setCriusPopListener(new a());
            }
            te1<View> te1Var2 = this.d;
            if (te1Var2 != null) {
                view2 = te1Var2.getRealView();
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

    public final void L(int i, int i2, int i3) {
        te1<View> te1Var;
        View realView;
        sr0 sr0Var = this.e;
        if (sr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (sr0Var.a != 3 || (te1Var = this.d) == null || (realView = te1Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
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
        H(false);
    }

    public final void M(Intent intent) {
        fe1 fe1Var = (fe1) ServiceManager.getService(fe1.a);
        this.f = fe1Var;
        if (fe1Var == null) {
            j().v(this);
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
                hs0.q.a(c31.c(str2));
            }
            J(jSONObject);
            I();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void x(mk0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.x(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, jq0.class.getSimpleName())) {
            G((jq0) event);
        } else if (Intrinsics.areEqual(a2, iq0.class.getSimpleName())) {
            iq0 iq0Var = (iq0) event;
            L(iq0Var.c(), iq0Var.d(), iq0Var.b());
        } else if (Intrinsics.areEqual(a2, kq0.class.getSimpleName())) {
            E(((kq0) event).b());
        }
    }

    public final void N(pr0 pr0Var) {
        r31.b(new ClogBuilder().z(pr0Var.c).v(pr0Var.a).j(pr0Var.b).p(pr0Var.d).k(pr0Var.e).l(pr0Var.f).m(pr0Var.g));
    }
}
