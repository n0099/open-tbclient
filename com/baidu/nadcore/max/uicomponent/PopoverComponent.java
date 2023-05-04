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
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.cc1;
import com.baidu.tieba.eq0;
import com.baidu.tieba.fo0;
import com.baidu.tieba.go0;
import com.baidu.tieba.ho0;
import com.baidu.tieba.ji0;
import com.baidu.tieba.jo0;
import com.baidu.tieba.jp0;
import com.baidu.tieba.mp0;
import com.baidu.tieba.o11;
import com.baidu.tieba.oc1;
import com.baidu.tieba.pp0;
import com.baidu.tieba.qc1;
import com.baidu.tieba.qo0;
import com.baidu.tieba.ro0;
import com.baidu.tieba.so0;
import com.baidu.tieba.to0;
import com.baidu.tieba.uh0;
import com.baidu.tieba.v41;
import com.baidu.tieba.xo0;
import com.baidu.tieba.xp0;
import com.baidu.tieba.z01;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J'\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PopoverComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "", "scrollUp", "handleActionUp", "(Z)V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "withAnim", "hideAdPopOver", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initPopoverData", "(Lorg/json/JSONObject;)V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "", "currentY", "videoHeight", "minTopMargin", "onScroll", "(III)V", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/model/AdLpParams$AlsModel;", "alsModel", "sendActionAls", "(Lcom/baidu/nadcore/model/AdLpParams$AlsModel;)V", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "criusPopFactory", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "Landroid/view/View;", "criusPopView", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "hasShowPop", "Z", "hasStartCountDown", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popoverModel", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popviewHeight", "I", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "<init>", "PopOverListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PopoverComponent extends AbsComponentPlugin {
    public qc1<View> d;
    public pp0 e;
    public cc1 f;
    public v41 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes2.dex */
    public final class a extends oc1 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.oc1
        public void a(boolean z, long j) {
            ro0 ro0Var = (ro0) PopoverComponent.this.l().r(ro0.class);
            if (ro0Var != null) {
                ro0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.oc1
        public void b(xp0 clickInfo) {
            Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
            if (clickInfo.c) {
                if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                    uh0.c(clickInfo.a, PopoverComponent.this.getContext());
                } else {
                    qo0 qo0Var = (qo0) PopoverComponent.this.l().r(qo0.class);
                    if (qo0Var != null) {
                        qo0Var.j(false, true, false);
                    }
                }
                mp0 mp0Var = PopoverComponent.t(PopoverComponent.this).e;
                if (mp0Var != null) {
                    mp0Var.a();
                    mp0Var.b = clickInfo.b;
                    mp0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                    PopoverComponent.this.O(mp0Var);
                }
            }
            PopoverComponent.this.l().i(new jo0(PopEventTypeEnum.CLICK_POP_UI));
        }

        @Override // com.baidu.tieba.oc1
        public void c() {
            ro0 ro0Var = (ro0) PopoverComponent.this.l().r(ro0.class);
            if (ro0Var != null) {
                ro0Var.d(240L, false);
            }
            mp0 mp0Var = PopoverComponent.t(PopoverComponent.this).e;
            if (mp0Var != null) {
                mp0Var.a();
                mp0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                PopoverComponent.this.O(mp0Var);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends v41.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.v41.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            if (!PopoverComponent.this.h) {
                return;
            }
            qc1 qc1Var = PopoverComponent.this.d;
            if (qc1Var != null) {
                if (PopoverComponent.t(PopoverComponent.this).a != 3) {
                    z = true;
                } else {
                    z = false;
                }
                qc1Var.c(z);
            }
            if (PopoverComponent.t(PopoverComponent.this).a == 3) {
                qo0 qo0Var = (qo0) PopoverComponent.this.l().r(qo0.class);
                so0 so0Var = (so0) PopoverComponent.this.l().r(so0.class);
                if (qo0Var != null && (b = qo0Var.b()) != null) {
                    i = b.getTopMargin();
                } else {
                    i = 0;
                }
                if (so0Var != null) {
                    i2 = so0Var.getVideoHeight();
                } else {
                    i2 = 0;
                }
                int max = Math.max(0, PopoverComponent.this.i - (i2 - i));
                if (qo0Var != null) {
                    qo0Var.f(false, true, true, max);
                }
            }
            v41 v41Var = PopoverComponent.this.g;
            if (v41Var != null) {
                v41Var.a();
            }
            PopoverComponent.this.g = null;
        }

        @Override // com.baidu.tieba.v41.b
        public void e() {
            PopoverComponent.this.h = true;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            PopoverComponent.this.E();
            v41 v41Var = PopoverComponent.this.g;
            if (v41Var != null) {
                v41Var.e();
            }
        }
    }

    public final void J() {
        v41 v41Var = this.g;
        if (v41Var != null) {
            v41Var.a();
        }
        this.g = null;
        pp0 pp0Var = this.e;
        if (pp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        v41 v41Var2 = new v41(pp0Var.b * 1000, 1000L);
        v41Var2.d(new b());
        this.g = v41Var2;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        v41 v41Var = this.g;
        if (v41Var != null) {
            v41Var.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        I(false);
        qc1<View> qc1Var = this.d;
        if (qc1Var != null) {
            qc1Var.a();
        }
        this.d = null;
        v41 v41Var = this.g;
        if (v41Var != null) {
            v41Var.a();
        }
        this.g = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        v41 v41Var;
        super.onResume();
        so0 so0Var = (so0) l().r(so0.class);
        if (so0Var != null && so0Var.k() && (v41Var = this.g) != null) {
            v41Var.c();
        }
    }

    public static final /* synthetic */ pp0 t(PopoverComponent popoverComponent) {
        pp0 pp0Var = popoverComponent.e;
        if (pp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return pp0Var;
    }

    public final void H(go0 go0Var) {
        int i = xo0.$EnumSwitchMapping$0[go0Var.getType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.j = true;
                    return;
                }
                return;
            }
            v41 v41Var = this.g;
            if (v41Var != null) {
                v41Var.b();
                return;
            }
            return;
        }
        v41 v41Var2 = this.g;
        if (v41Var2 != null) {
            v41Var2.c();
        }
    }

    public final void I(boolean z) {
        View realView;
        qc1<View> qc1Var;
        qc1<View> qc1Var2 = this.d;
        if (qc1Var2 != null && (realView = qc1Var2.getRealView()) != null && realView.getVisibility() == 0 && (qc1Var = this.d) != null) {
            qc1Var.b("0", z);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void Q(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.post(new c());
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        N(intent);
    }

    public final void E() {
        to0 to0Var;
        qc1<View> qc1Var;
        View h;
        so0 so0Var = (so0) l().r(so0.class);
        if (so0Var != null && (to0Var = (to0) l().r(to0.class)) != null && (qc1Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            pp0 pp0Var = this.e;
            if (pp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (pp0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            pp0 pp0Var2 = this.e;
            if (pp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (pp0Var2.a == 3) {
                h = to0Var.b().l();
            } else {
                h = so0Var.h();
            }
            if (!(h instanceof ViewGroup)) {
                h = null;
            }
            qc1Var.setContainer((ViewGroup) h, layoutParams);
        }
    }

    public final void F(boolean z) {
        qc1<View> qc1Var;
        View realView;
        so0 so0Var;
        qo0 qo0Var;
        boolean z2;
        pp0 pp0Var = this.e;
        if (pp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (pp0Var.a != 3 || (qc1Var = this.d) == null || (realView = qc1Var.getRealView()) == null || realView.getVisibility() != 0 || (so0Var = (so0) l().r(so0.class)) == null || (qo0Var = (qo0) l().r(qo0.class)) == null || !so0Var.k()) {
            return;
        }
        int videoHeight = so0Var.getVideoHeight() - qo0Var.b().getTopMargin();
        if (!z && videoHeight < this.i / 2) {
            return;
        }
        int abs = Math.abs(videoHeight - this.i);
        if (videoHeight > this.i) {
            z2 = true;
        } else {
            z2 = false;
        }
        qo0Var.f(z2, true, true, abs);
    }

    public final void K(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Object obj;
        qc1<View> qc1Var;
        pp0 a2 = pp0.f.a(jSONObject);
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
            z01.f(jSONObject3, "cmd_map", jSONObject2);
            pp0 pp0Var = this.e;
            if (pp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            cc1 cc1Var = this.f;
            View view2 = null;
            if (cc1Var != null) {
                obj = cc1Var.a(jSONObject3);
            } else {
                obj = null;
            }
            pp0Var.c = obj;
            pp0 pp0Var2 = this.e;
            if (pp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (pp0Var2.c == null) {
                return;
            }
            pp0 pp0Var3 = this.e;
            if (pp0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (pp0Var3.a != 2) {
                pp0 pp0Var4 = this.e;
                if (pp0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (pp0Var4.a != 3) {
                    pp0 pp0Var5 = this.e;
                    if (pp0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (pp0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            pp0 pp0Var6 = this.e;
            if (pp0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (pp0Var6.c == null) {
                return;
            }
            pp0 pp0Var7 = this.e;
            if (pp0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            jp0 c2 = jp0.c(z01.c(jSONObject.optString("download")));
            pp0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            mp0 mp0Var = new mp0();
            mp0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            mp0Var.d = jSONObject.optString("ext_info");
            Unit unit = Unit.INSTANCE;
            pp0Var7.e = mp0Var;
            cc1 cc1Var2 = this.f;
            if (cc1Var2 != null) {
                qc1Var = cc1Var2.b(getContext());
            } else {
                qc1Var = null;
            }
            this.d = qc1Var;
            if (qc1Var == null) {
                l().w(this);
                return;
            }
            if (qc1Var != null) {
                pp0 pp0Var8 = this.e;
                if (pp0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                qc1Var.setData(pp0Var8);
                qc1Var.setCriusPopListener(new a());
            }
            qc1<View> qc1Var2 = this.d;
            if (qc1Var2 != null) {
                view2 = qc1Var2.getRealView();
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

    public final void M(int i, int i2, int i3) {
        qc1<View> qc1Var;
        View realView;
        pp0 pp0Var = this.e;
        if (pp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (pp0Var.a != 3 || (qc1Var = this.d) == null || (realView = qc1Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
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
        I(false);
    }

    public final void N(Intent intent) {
        cc1 cc1Var = (cc1) ServiceManager.getService(cc1.a);
        this.f = cc1Var;
        if (cc1Var == null) {
            l().w(this);
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
                eq0.q.a(z01.c(str2));
            }
            K(jSONObject);
            J();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void x(ji0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.x(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, go0.class.getSimpleName())) {
            H((go0) event);
        } else if (Intrinsics.areEqual(a2, fo0.class.getSimpleName())) {
            fo0 fo0Var = (fo0) event;
            M(fo0Var.c(), fo0Var.d(), fo0Var.b());
        } else if (Intrinsics.areEqual(a2, ho0.class.getSimpleName())) {
            F(((ho0) event).b());
        }
    }

    public final void O(mp0 mp0Var) {
        o11.b(new ClogBuilder().z(mp0Var.c).v(mp0Var.a).j(mp0Var.b).p(mp0Var.d).k(mp0Var.e).l(mp0Var.f).m(mp0Var.g));
    }
}
