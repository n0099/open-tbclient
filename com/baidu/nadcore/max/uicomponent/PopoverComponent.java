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
import com.baidu.tieba.aq0;
import com.baidu.tieba.bo0;
import com.baidu.tieba.co0;
import com.baidu.tieba.do0;
import com.baidu.tieba.fi0;
import com.baidu.tieba.fo0;
import com.baidu.tieba.fp0;
import com.baidu.tieba.ip0;
import com.baidu.tieba.k11;
import com.baidu.tieba.kc1;
import com.baidu.tieba.lp0;
import com.baidu.tieba.mc1;
import com.baidu.tieba.mo0;
import com.baidu.tieba.no0;
import com.baidu.tieba.oo0;
import com.baidu.tieba.po0;
import com.baidu.tieba.qh0;
import com.baidu.tieba.r41;
import com.baidu.tieba.to0;
import com.baidu.tieba.tp0;
import com.baidu.tieba.v01;
import com.baidu.tieba.yb1;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J'\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PopoverComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "", "scrollUp", "handleActionUp", "(Z)V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "withAnim", "hideAdPopOver", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initPopoverData", "(Lorg/json/JSONObject;)V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "", "currentY", "videoHeight", "minTopMargin", "onScroll", "(III)V", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/model/AdLpParams$AlsModel;", "alsModel", "sendActionAls", "(Lcom/baidu/nadcore/model/AdLpParams$AlsModel;)V", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "criusPopFactory", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "Landroid/view/View;", "criusPopView", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "hasShowPop", "Z", "hasStartCountDown", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popoverModel", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popviewHeight", "I", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "<init>", "PopOverListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PopoverComponent extends AbsComponentPlugin {
    public mc1<View> d;
    public lp0 e;
    public yb1 f;
    public r41 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes2.dex */
    public final class a extends kc1 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.kc1
        public void a(boolean z, long j) {
            no0 no0Var = (no0) PopoverComponent.this.b().k(no0.class);
            if (no0Var != null) {
                no0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.kc1
        public void b(tp0 clickInfo) {
            Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
            if (clickInfo.c) {
                if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                    qh0.c(clickInfo.a, PopoverComponent.this.getContext());
                } else {
                    mo0 mo0Var = (mo0) PopoverComponent.this.b().k(mo0.class);
                    if (mo0Var != null) {
                        mo0Var.j(false, true, false);
                    }
                }
                ip0 ip0Var = PopoverComponent.m(PopoverComponent.this).e;
                if (ip0Var != null) {
                    ip0Var.a();
                    ip0Var.b = clickInfo.b;
                    ip0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                    PopoverComponent.this.J(ip0Var);
                }
            }
            PopoverComponent.this.b().d(new fo0(PopEventTypeEnum.CLICK_POP_UI));
        }

        @Override // com.baidu.tieba.kc1
        public void c() {
            no0 no0Var = (no0) PopoverComponent.this.b().k(no0.class);
            if (no0Var != null) {
                no0Var.d(240L, false);
            }
            ip0 ip0Var = PopoverComponent.m(PopoverComponent.this).e;
            if (ip0Var != null) {
                ip0Var.a();
                ip0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                PopoverComponent.this.J(ip0Var);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends r41.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.r41.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            if (PopoverComponent.this.h) {
                mc1 mc1Var = PopoverComponent.this.d;
                if (mc1Var != null) {
                    if (PopoverComponent.m(PopoverComponent.this).a != 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    mc1Var.c(z);
                }
                if (PopoverComponent.m(PopoverComponent.this).a == 3) {
                    mo0 mo0Var = (mo0) PopoverComponent.this.b().k(mo0.class);
                    oo0 oo0Var = (oo0) PopoverComponent.this.b().k(oo0.class);
                    if (mo0Var != null && (b = mo0Var.b()) != null) {
                        i = b.getTopMargin();
                    } else {
                        i = 0;
                    }
                    if (oo0Var != null) {
                        i2 = oo0Var.getVideoHeight();
                    } else {
                        i2 = 0;
                    }
                    int max = Math.max(0, PopoverComponent.this.i - (i2 - i));
                    if (mo0Var != null) {
                        mo0Var.f(false, true, true, max);
                    }
                }
                r41 r41Var = PopoverComponent.this.g;
                if (r41Var != null) {
                    r41Var.a();
                }
                PopoverComponent.this.g = null;
            }
        }

        @Override // com.baidu.tieba.r41.b
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
            PopoverComponent.this.A();
            r41 r41Var = PopoverComponent.this.g;
            if (r41Var != null) {
                r41Var.e();
            }
        }
    }

    public final void E() {
        r41 r41Var = this.g;
        if (r41Var != null) {
            r41Var.a();
        }
        this.g = null;
        lp0 lp0Var = this.e;
        if (lp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        r41 r41Var2 = new r41(lp0Var.b * 1000, 1000L);
        r41Var2.d(new b());
        this.g = r41Var2;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        r41 r41Var = this.g;
        if (r41Var != null) {
            r41Var.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        D(false);
        mc1<View> mc1Var = this.d;
        if (mc1Var != null) {
            mc1Var.a();
        }
        this.d = null;
        r41 r41Var = this.g;
        if (r41Var != null) {
            r41Var.a();
        }
        this.g = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        r41 r41Var;
        super.onResume();
        oo0 oo0Var = (oo0) b().k(oo0.class);
        if (oo0Var != null && oo0Var.k() && (r41Var = this.g) != null) {
            r41Var.c();
        }
    }

    public static final /* synthetic */ lp0 m(PopoverComponent popoverComponent) {
        lp0 lp0Var = popoverComponent.e;
        if (lp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return lp0Var;
    }

    public final void C(co0 co0Var) {
        int i = to0.$EnumSwitchMapping$0[co0Var.getType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.j = true;
                    return;
                }
                return;
            }
            r41 r41Var = this.g;
            if (r41Var != null) {
                r41Var.b();
                return;
            }
            return;
        }
        r41 r41Var2 = this.g;
        if (r41Var2 != null) {
            r41Var2.c();
        }
    }

    public final void D(boolean z) {
        View realView;
        mc1<View> mc1Var;
        mc1<View> mc1Var2 = this.d;
        if (mc1Var2 != null && (realView = mc1Var2.getRealView()) != null && realView.getVisibility() == 0 && (mc1Var = this.d) != null) {
            mc1Var.b("0", z);
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
        H(intent);
    }

    public final void A() {
        po0 po0Var;
        mc1<View> mc1Var;
        View h;
        oo0 oo0Var = (oo0) b().k(oo0.class);
        if (oo0Var != null && (po0Var = (po0) b().k(po0.class)) != null && (mc1Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            lp0 lp0Var = this.e;
            if (lp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (lp0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            lp0 lp0Var2 = this.e;
            if (lp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (lp0Var2.a == 3) {
                h = po0Var.b().l();
            } else {
                h = oo0Var.h();
            }
            if (!(h instanceof ViewGroup)) {
                h = null;
            }
            mc1Var.setContainer((ViewGroup) h, layoutParams);
        }
    }

    public final void B(boolean z) {
        mc1<View> mc1Var;
        View realView;
        oo0 oo0Var;
        mo0 mo0Var;
        boolean z2;
        lp0 lp0Var = this.e;
        if (lp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (lp0Var.a != 3 || (mc1Var = this.d) == null || (realView = mc1Var.getRealView()) == null || realView.getVisibility() != 0 || (oo0Var = (oo0) b().k(oo0.class)) == null || (mo0Var = (mo0) b().k(mo0.class)) == null || !oo0Var.k()) {
            return;
        }
        int videoHeight = oo0Var.getVideoHeight() - mo0Var.b().getTopMargin();
        if (!z && videoHeight < this.i / 2) {
            return;
        }
        int abs = Math.abs(videoHeight - this.i);
        if (videoHeight > this.i) {
            z2 = true;
        } else {
            z2 = false;
        }
        mo0Var.f(z2, true, true, abs);
    }

    public final void F(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Object obj;
        mc1<View> mc1Var;
        lp0 a2 = lp0.f.a(jSONObject);
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
            v01.f(jSONObject3, "cmd_map", jSONObject2);
            lp0 lp0Var = this.e;
            if (lp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            yb1 yb1Var = this.f;
            View view2 = null;
            if (yb1Var != null) {
                obj = yb1Var.a(jSONObject3);
            } else {
                obj = null;
            }
            lp0Var.c = obj;
            lp0 lp0Var2 = this.e;
            if (lp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (lp0Var2.c == null) {
                return;
            }
            lp0 lp0Var3 = this.e;
            if (lp0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (lp0Var3.a != 2) {
                lp0 lp0Var4 = this.e;
                if (lp0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (lp0Var4.a != 3) {
                    lp0 lp0Var5 = this.e;
                    if (lp0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (lp0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            lp0 lp0Var6 = this.e;
            if (lp0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (lp0Var6.c == null) {
                return;
            }
            lp0 lp0Var7 = this.e;
            if (lp0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            fp0 c2 = fp0.c(v01.c(jSONObject.optString("download")));
            lp0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            ip0 ip0Var = new ip0();
            ip0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            ip0Var.d = jSONObject.optString("ext_info");
            Unit unit = Unit.INSTANCE;
            lp0Var7.e = ip0Var;
            yb1 yb1Var2 = this.f;
            if (yb1Var2 != null) {
                mc1Var = yb1Var2.b(getContext());
            } else {
                mc1Var = null;
            }
            this.d = mc1Var;
            if (mc1Var == null) {
                b().q(this);
                return;
            }
            if (mc1Var != null) {
                lp0 lp0Var8 = this.e;
                if (lp0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                mc1Var.setData(lp0Var8);
                mc1Var.setCriusPopListener(new a());
            }
            mc1<View> mc1Var2 = this.d;
            if (mc1Var2 != null) {
                view2 = mc1Var2.getRealView();
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

    public final void G(int i, int i2, int i3) {
        mc1<View> mc1Var;
        View realView;
        lp0 lp0Var = this.e;
        if (lp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (lp0Var.a != 3 || (mc1Var = this.d) == null || (realView = mc1Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
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
        D(false);
    }

    public final void H(Intent intent) {
        yb1 yb1Var = (yb1) ServiceManager.getService(yb1.a);
        this.f = yb1Var;
        if (yb1Var == null) {
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
                aq0.q.a(v01.c(str2));
            }
            F(jSONObject);
            E();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void r(fi0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.r(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, co0.class.getSimpleName())) {
            C((co0) event);
        } else if (Intrinsics.areEqual(a2, bo0.class.getSimpleName())) {
            bo0 bo0Var = (bo0) event;
            G(bo0Var.c(), bo0Var.d(), bo0Var.b());
        } else if (Intrinsics.areEqual(a2, do0.class.getSimpleName())) {
            B(((do0) event).b());
        }
    }

    public final void J(ip0 ip0Var) {
        k11.b(new ClogBuilder().z(ip0Var.c).v(ip0Var.a).j(ip0Var.b).p(ip0Var.d).k(ip0Var.e).l(ip0Var.f).m(ip0Var.g));
    }
}
