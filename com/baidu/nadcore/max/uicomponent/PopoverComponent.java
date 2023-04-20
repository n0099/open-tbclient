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
import com.baidu.tieba.ac1;
import com.baidu.tieba.cq0;
import com.baidu.tieba.do0;
import com.baidu.tieba.eo0;
import com.baidu.tieba.fo0;
import com.baidu.tieba.hi0;
import com.baidu.tieba.ho0;
import com.baidu.tieba.hp0;
import com.baidu.tieba.kp0;
import com.baidu.tieba.m11;
import com.baidu.tieba.mc1;
import com.baidu.tieba.np0;
import com.baidu.tieba.oc1;
import com.baidu.tieba.oo0;
import com.baidu.tieba.po0;
import com.baidu.tieba.qo0;
import com.baidu.tieba.ro0;
import com.baidu.tieba.sh0;
import com.baidu.tieba.t41;
import com.baidu.tieba.vo0;
import com.baidu.tieba.vp0;
import com.baidu.tieba.x01;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J'\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PopoverComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "", "scrollUp", "handleActionUp", "(Z)V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "withAnim", "hideAdPopOver", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initPopoverData", "(Lorg/json/JSONObject;)V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "", "currentY", "videoHeight", "minTopMargin", "onScroll", "(III)V", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/model/AdLpParams$AlsModel;", "alsModel", "sendActionAls", "(Lcom/baidu/nadcore/model/AdLpParams$AlsModel;)V", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "criusPopFactory", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "Landroid/view/View;", "criusPopView", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "hasShowPop", "Z", "hasStartCountDown", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popoverModel", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popviewHeight", "I", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "<init>", "PopOverListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PopoverComponent extends AbsComponentPlugin {
    public oc1<View> d;
    public np0 e;
    public ac1 f;
    public t41 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes2.dex */
    public final class a extends mc1 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.mc1
        public void a(boolean z, long j) {
            po0 po0Var = (po0) PopoverComponent.this.j().o(po0.class);
            if (po0Var != null) {
                po0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.mc1
        public void b(vp0 clickInfo) {
            Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
            if (clickInfo.c) {
                if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                    sh0.c(clickInfo.a, PopoverComponent.this.getContext());
                } else {
                    oo0 oo0Var = (oo0) PopoverComponent.this.j().o(oo0.class);
                    if (oo0Var != null) {
                        oo0Var.j(false, true, false);
                    }
                }
                kp0 kp0Var = PopoverComponent.q(PopoverComponent.this).e;
                if (kp0Var != null) {
                    kp0Var.a();
                    kp0Var.b = clickInfo.b;
                    kp0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                    PopoverComponent.this.J(kp0Var);
                }
            }
            PopoverComponent.this.j().g(new ho0(PopEventTypeEnum.CLICK_POP_UI));
        }

        @Override // com.baidu.tieba.mc1
        public void c() {
            po0 po0Var = (po0) PopoverComponent.this.j().o(po0.class);
            if (po0Var != null) {
                po0Var.d(240L, false);
            }
            kp0 kp0Var = PopoverComponent.q(PopoverComponent.this).e;
            if (kp0Var != null) {
                kp0Var.a();
                kp0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                PopoverComponent.this.J(kp0Var);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends t41.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.t41.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            if (PopoverComponent.this.h) {
                oc1 oc1Var = PopoverComponent.this.d;
                if (oc1Var != null) {
                    if (PopoverComponent.q(PopoverComponent.this).a != 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    oc1Var.c(z);
                }
                if (PopoverComponent.q(PopoverComponent.this).a == 3) {
                    oo0 oo0Var = (oo0) PopoverComponent.this.j().o(oo0.class);
                    qo0 qo0Var = (qo0) PopoverComponent.this.j().o(qo0.class);
                    if (oo0Var != null && (b = oo0Var.b()) != null) {
                        i = b.getTopMargin();
                    } else {
                        i = 0;
                    }
                    if (qo0Var != null) {
                        i2 = qo0Var.getVideoHeight();
                    } else {
                        i2 = 0;
                    }
                    int max = Math.max(0, PopoverComponent.this.i - (i2 - i));
                    if (oo0Var != null) {
                        oo0Var.f(false, true, true, max);
                    }
                }
                t41 t41Var = PopoverComponent.this.g;
                if (t41Var != null) {
                    t41Var.a();
                }
                PopoverComponent.this.g = null;
            }
        }

        @Override // com.baidu.tieba.t41.b
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
            PopoverComponent.this.B();
            t41 t41Var = PopoverComponent.this.g;
            if (t41Var != null) {
                t41Var.e();
            }
        }
    }

    public final void F() {
        t41 t41Var = this.g;
        if (t41Var != null) {
            t41Var.a();
        }
        this.g = null;
        np0 np0Var = this.e;
        if (np0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        t41 t41Var2 = new t41(np0Var.b * 1000, 1000L);
        t41Var2.d(new b());
        this.g = t41Var2;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        t41 t41Var = this.g;
        if (t41Var != null) {
            t41Var.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        E(false);
        oc1<View> oc1Var = this.d;
        if (oc1Var != null) {
            oc1Var.a();
        }
        this.d = null;
        t41 t41Var = this.g;
        if (t41Var != null) {
            t41Var.a();
        }
        this.g = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        t41 t41Var;
        super.onResume();
        qo0 qo0Var = (qo0) j().o(qo0.class);
        if (qo0Var != null && qo0Var.k() && (t41Var = this.g) != null) {
            t41Var.c();
        }
    }

    public static final /* synthetic */ np0 q(PopoverComponent popoverComponent) {
        np0 np0Var = popoverComponent.e;
        if (np0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return np0Var;
    }

    public final void D(eo0 eo0Var) {
        int i = vo0.$EnumSwitchMapping$0[eo0Var.getType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.j = true;
                    return;
                }
                return;
            }
            t41 t41Var = this.g;
            if (t41Var != null) {
                t41Var.b();
                return;
            }
            return;
        }
        t41 t41Var2 = this.g;
        if (t41Var2 != null) {
            t41Var2.c();
        }
    }

    public final void E(boolean z) {
        View realView;
        oc1<View> oc1Var;
        oc1<View> oc1Var2 = this.d;
        if (oc1Var2 != null && (realView = oc1Var2.getRealView()) != null && realView.getVisibility() == 0 && (oc1Var = this.d) != null) {
            oc1Var.b("0", z);
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
        I(intent);
    }

    public final void B() {
        ro0 ro0Var;
        oc1<View> oc1Var;
        View h;
        qo0 qo0Var = (qo0) j().o(qo0.class);
        if (qo0Var != null && (ro0Var = (ro0) j().o(ro0.class)) != null && (oc1Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            np0 np0Var = this.e;
            if (np0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (np0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            np0 np0Var2 = this.e;
            if (np0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (np0Var2.a == 3) {
                h = ro0Var.b().l();
            } else {
                h = qo0Var.h();
            }
            if (!(h instanceof ViewGroup)) {
                h = null;
            }
            oc1Var.setContainer((ViewGroup) h, layoutParams);
        }
    }

    public final void C(boolean z) {
        oc1<View> oc1Var;
        View realView;
        qo0 qo0Var;
        oo0 oo0Var;
        boolean z2;
        np0 np0Var = this.e;
        if (np0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (np0Var.a != 3 || (oc1Var = this.d) == null || (realView = oc1Var.getRealView()) == null || realView.getVisibility() != 0 || (qo0Var = (qo0) j().o(qo0.class)) == null || (oo0Var = (oo0) j().o(oo0.class)) == null || !qo0Var.k()) {
            return;
        }
        int videoHeight = qo0Var.getVideoHeight() - oo0Var.b().getTopMargin();
        if (!z && videoHeight < this.i / 2) {
            return;
        }
        int abs = Math.abs(videoHeight - this.i);
        if (videoHeight > this.i) {
            z2 = true;
        } else {
            z2 = false;
        }
        oo0Var.f(z2, true, true, abs);
    }

    public final void G(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Object obj;
        oc1<View> oc1Var;
        np0 a2 = np0.f.a(jSONObject);
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
            x01.f(jSONObject3, "cmd_map", jSONObject2);
            np0 np0Var = this.e;
            if (np0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            ac1 ac1Var = this.f;
            View view2 = null;
            if (ac1Var != null) {
                obj = ac1Var.a(jSONObject3);
            } else {
                obj = null;
            }
            np0Var.c = obj;
            np0 np0Var2 = this.e;
            if (np0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (np0Var2.c == null) {
                return;
            }
            np0 np0Var3 = this.e;
            if (np0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (np0Var3.a != 2) {
                np0 np0Var4 = this.e;
                if (np0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (np0Var4.a != 3) {
                    np0 np0Var5 = this.e;
                    if (np0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (np0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            np0 np0Var6 = this.e;
            if (np0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (np0Var6.c == null) {
                return;
            }
            np0 np0Var7 = this.e;
            if (np0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            hp0 c2 = hp0.c(x01.c(jSONObject.optString("download")));
            np0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            kp0 kp0Var = new kp0();
            kp0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            kp0Var.d = jSONObject.optString("ext_info");
            Unit unit = Unit.INSTANCE;
            np0Var7.e = kp0Var;
            ac1 ac1Var2 = this.f;
            if (ac1Var2 != null) {
                oc1Var = ac1Var2.b(getContext());
            } else {
                oc1Var = null;
            }
            this.d = oc1Var;
            if (oc1Var == null) {
                j().t(this);
                return;
            }
            if (oc1Var != null) {
                np0 np0Var8 = this.e;
                if (np0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                oc1Var.setData(np0Var8);
                oc1Var.setCriusPopListener(new a());
            }
            oc1<View> oc1Var2 = this.d;
            if (oc1Var2 != null) {
                view2 = oc1Var2.getRealView();
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

    public final void H(int i, int i2, int i3) {
        oc1<View> oc1Var;
        View realView;
        np0 np0Var = this.e;
        if (np0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (np0Var.a != 3 || (oc1Var = this.d) == null || (realView = oc1Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
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
        E(false);
    }

    public final void I(Intent intent) {
        ac1 ac1Var = (ac1) ServiceManager.getService(ac1.a);
        this.f = ac1Var;
        if (ac1Var == null) {
            j().t(this);
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
                cq0.q.a(x01.c(str2));
            }
            G(jSONObject);
            F();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void u(hi0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.u(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, eo0.class.getSimpleName())) {
            D((eo0) event);
        } else if (Intrinsics.areEqual(a2, do0.class.getSimpleName())) {
            do0 do0Var = (do0) event;
            H(do0Var.c(), do0Var.d(), do0Var.b());
        } else if (Intrinsics.areEqual(a2, fo0.class.getSimpleName())) {
            C(((fo0) event).b());
        }
    }

    public final void J(kp0 kp0Var) {
        m11.b(new ClogBuilder().z(kp0Var.c).v(kp0Var.a).j(kp0Var.b).p(kp0Var.d).k(kp0Var.e).l(kp0Var.f).m(kp0Var.g));
    }
}
