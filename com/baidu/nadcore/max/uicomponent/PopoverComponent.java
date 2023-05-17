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
import com.baidu.tieba.cq0;
import com.baidu.tieba.e21;
import com.baidu.tieba.ed1;
import com.baidu.tieba.fq0;
import com.baidu.tieba.gd1;
import com.baidu.tieba.gp0;
import com.baidu.tieba.hp0;
import com.baidu.tieba.ip0;
import com.baidu.tieba.jp0;
import com.baidu.tieba.ki0;
import com.baidu.tieba.l51;
import com.baidu.tieba.np0;
import com.baidu.tieba.nq0;
import com.baidu.tieba.p11;
import com.baidu.tieba.sc1;
import com.baidu.tieba.uq0;
import com.baidu.tieba.vo0;
import com.baidu.tieba.wo0;
import com.baidu.tieba.xo0;
import com.baidu.tieba.zi0;
import com.baidu.tieba.zo0;
import com.baidu.tieba.zp0;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J'\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PopoverComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "", "scrollUp", "handleActionUp", "(Z)V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "withAnim", "hideAdPopOver", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initPopoverData", "(Lorg/json/JSONObject;)V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "", "currentY", "videoHeight", "minTopMargin", "onScroll", "(III)V", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/model/AdLpParams$AlsModel;", "alsModel", "sendActionAls", "(Lcom/baidu/nadcore/model/AdLpParams$AlsModel;)V", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "criusPopFactory", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "Landroid/view/View;", "criusPopView", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "hasShowPop", "Z", "hasStartCountDown", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popoverModel", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popviewHeight", "I", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "<init>", "PopOverListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class PopoverComponent extends AbsComponentPlugin {
    public gd1<View> d;
    public fq0 e;
    public sc1 f;
    public l51 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes3.dex */
    public final class a extends ed1 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.ed1
        public void a(boolean z, long j) {
            hp0 hp0Var = (hp0) PopoverComponent.this.j().q(hp0.class);
            if (hp0Var != null) {
                hp0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.ed1
        public void b(nq0 clickInfo) {
            Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
            if (clickInfo.c) {
                if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                    ki0.c(clickInfo.a, PopoverComponent.this.getContext());
                } else {
                    gp0 gp0Var = (gp0) PopoverComponent.this.j().q(gp0.class);
                    if (gp0Var != null) {
                        gp0Var.j(false, true, false);
                    }
                }
                cq0 cq0Var = PopoverComponent.s(PopoverComponent.this).e;
                if (cq0Var != null) {
                    cq0Var.a();
                    cq0Var.b = clickInfo.b;
                    cq0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                    PopoverComponent.this.N(cq0Var);
                }
            }
            PopoverComponent.this.j().g(new zo0(PopEventTypeEnum.CLICK_POP_UI));
        }

        @Override // com.baidu.tieba.ed1
        public void c() {
            hp0 hp0Var = (hp0) PopoverComponent.this.j().q(hp0.class);
            if (hp0Var != null) {
                hp0Var.d(240L, false);
            }
            cq0 cq0Var = PopoverComponent.s(PopoverComponent.this).e;
            if (cq0Var != null) {
                cq0Var.a();
                cq0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                PopoverComponent.this.N(cq0Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends l51.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.l51.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            if (!PopoverComponent.this.h) {
                return;
            }
            gd1 gd1Var = PopoverComponent.this.d;
            if (gd1Var != null) {
                if (PopoverComponent.s(PopoverComponent.this).a != 3) {
                    z = true;
                } else {
                    z = false;
                }
                gd1Var.c(z);
            }
            if (PopoverComponent.s(PopoverComponent.this).a == 3) {
                gp0 gp0Var = (gp0) PopoverComponent.this.j().q(gp0.class);
                ip0 ip0Var = (ip0) PopoverComponent.this.j().q(ip0.class);
                if (gp0Var != null && (b = gp0Var.b()) != null) {
                    i = b.getTopMargin();
                } else {
                    i = 0;
                }
                if (ip0Var != null) {
                    i2 = ip0Var.getVideoHeight();
                } else {
                    i2 = 0;
                }
                int max = Math.max(0, PopoverComponent.this.i - (i2 - i));
                if (gp0Var != null) {
                    gp0Var.f(false, true, true, max);
                }
            }
            l51 l51Var = PopoverComponent.this.g;
            if (l51Var != null) {
                l51Var.a();
            }
            PopoverComponent.this.g = null;
        }

        @Override // com.baidu.tieba.l51.b
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
            l51 l51Var = PopoverComponent.this.g;
            if (l51Var != null) {
                l51Var.e();
            }
        }
    }

    public final void I() {
        l51 l51Var = this.g;
        if (l51Var != null) {
            l51Var.a();
        }
        this.g = null;
        fq0 fq0Var = this.e;
        if (fq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        l51 l51Var2 = new l51(fq0Var.b * 1000, 1000L);
        l51Var2.d(new b());
        this.g = l51Var2;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        l51 l51Var = this.g;
        if (l51Var != null) {
            l51Var.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        H(false);
        gd1<View> gd1Var = this.d;
        if (gd1Var != null) {
            gd1Var.a();
        }
        this.d = null;
        l51 l51Var = this.g;
        if (l51Var != null) {
            l51Var.a();
        }
        this.g = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        l51 l51Var;
        super.onResume();
        ip0 ip0Var = (ip0) j().q(ip0.class);
        if (ip0Var != null && ip0Var.k() && (l51Var = this.g) != null) {
            l51Var.c();
        }
    }

    public static final /* synthetic */ fq0 s(PopoverComponent popoverComponent) {
        fq0 fq0Var = popoverComponent.e;
        if (fq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return fq0Var;
    }

    public final void G(wo0 wo0Var) {
        int i = np0.$EnumSwitchMapping$0[wo0Var.getType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.j = true;
                    return;
                }
                return;
            }
            l51 l51Var = this.g;
            if (l51Var != null) {
                l51Var.b();
                return;
            }
            return;
        }
        l51 l51Var2 = this.g;
        if (l51Var2 != null) {
            l51Var2.c();
        }
    }

    public final void H(boolean z) {
        View realView;
        gd1<View> gd1Var;
        gd1<View> gd1Var2 = this.d;
        if (gd1Var2 != null && (realView = gd1Var2.getRealView()) != null && realView.getVisibility() == 0 && (gd1Var = this.d) != null) {
            gd1Var.b("0", z);
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
        jp0 jp0Var;
        gd1<View> gd1Var;
        View h;
        ip0 ip0Var = (ip0) j().q(ip0.class);
        if (ip0Var != null && (jp0Var = (jp0) j().q(jp0.class)) != null && (gd1Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            fq0 fq0Var = this.e;
            if (fq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (fq0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            fq0 fq0Var2 = this.e;
            if (fq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (fq0Var2.a == 3) {
                h = jp0Var.b().l();
            } else {
                h = ip0Var.h();
            }
            if (!(h instanceof ViewGroup)) {
                h = null;
            }
            gd1Var.setContainer((ViewGroup) h, layoutParams);
        }
    }

    public final void E(boolean z) {
        gd1<View> gd1Var;
        View realView;
        ip0 ip0Var;
        gp0 gp0Var;
        boolean z2;
        fq0 fq0Var = this.e;
        if (fq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (fq0Var.a != 3 || (gd1Var = this.d) == null || (realView = gd1Var.getRealView()) == null || realView.getVisibility() != 0 || (ip0Var = (ip0) j().q(ip0.class)) == null || (gp0Var = (gp0) j().q(gp0.class)) == null || !ip0Var.k()) {
            return;
        }
        int videoHeight = ip0Var.getVideoHeight() - gp0Var.b().getTopMargin();
        if (!z && videoHeight < this.i / 2) {
            return;
        }
        int abs = Math.abs(videoHeight - this.i);
        if (videoHeight > this.i) {
            z2 = true;
        } else {
            z2 = false;
        }
        gp0Var.f(z2, true, true, abs);
    }

    public final void J(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Object obj;
        gd1<View> gd1Var;
        fq0 a2 = fq0.f.a(jSONObject);
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
            p11.f(jSONObject3, "cmd_map", jSONObject2);
            fq0 fq0Var = this.e;
            if (fq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            sc1 sc1Var = this.f;
            View view2 = null;
            if (sc1Var != null) {
                obj = sc1Var.a(jSONObject3);
            } else {
                obj = null;
            }
            fq0Var.c = obj;
            fq0 fq0Var2 = this.e;
            if (fq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (fq0Var2.c == null) {
                return;
            }
            fq0 fq0Var3 = this.e;
            if (fq0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (fq0Var3.a != 2) {
                fq0 fq0Var4 = this.e;
                if (fq0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (fq0Var4.a != 3) {
                    fq0 fq0Var5 = this.e;
                    if (fq0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (fq0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            fq0 fq0Var6 = this.e;
            if (fq0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (fq0Var6.c == null) {
                return;
            }
            fq0 fq0Var7 = this.e;
            if (fq0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            zp0 c2 = zp0.c(p11.c(jSONObject.optString("download")));
            fq0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            cq0 cq0Var = new cq0();
            cq0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            cq0Var.d = jSONObject.optString("ext_info");
            Unit unit = Unit.INSTANCE;
            fq0Var7.e = cq0Var;
            sc1 sc1Var2 = this.f;
            if (sc1Var2 != null) {
                gd1Var = sc1Var2.b(getContext());
            } else {
                gd1Var = null;
            }
            this.d = gd1Var;
            if (gd1Var == null) {
                j().v(this);
                return;
            }
            if (gd1Var != null) {
                fq0 fq0Var8 = this.e;
                if (fq0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                gd1Var.setData(fq0Var8);
                gd1Var.setCriusPopListener(new a());
            }
            gd1<View> gd1Var2 = this.d;
            if (gd1Var2 != null) {
                view2 = gd1Var2.getRealView();
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
        gd1<View> gd1Var;
        View realView;
        fq0 fq0Var = this.e;
        if (fq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (fq0Var.a != 3 || (gd1Var = this.d) == null || (realView = gd1Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
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
        sc1 sc1Var = (sc1) ServiceManager.getService(sc1.a);
        this.f = sc1Var;
        if (sc1Var == null) {
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
                uq0.q.a(p11.c(str2));
            }
            J(jSONObject);
            I();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void w(zi0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.w(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, wo0.class.getSimpleName())) {
            G((wo0) event);
        } else if (Intrinsics.areEqual(a2, vo0.class.getSimpleName())) {
            vo0 vo0Var = (vo0) event;
            L(vo0Var.c(), vo0Var.d(), vo0Var.b());
        } else if (Intrinsics.areEqual(a2, xo0.class.getSimpleName())) {
            E(((xo0) event).b());
        }
    }

    public final void N(cq0 cq0Var) {
        e21.b(new ClogBuilder().z(cq0Var.c).v(cq0Var.a).j(cq0Var.b).p(cq0Var.d).k(cq0Var.e).l(cq0Var.f).m(cq0Var.g));
    }
}
