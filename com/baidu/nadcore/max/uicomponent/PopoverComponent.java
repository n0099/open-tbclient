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
import com.baidu.tieba.bq0;
import com.baidu.tieba.co0;
import com.baidu.tieba.do0;
import com.baidu.tieba.eo0;
import com.baidu.tieba.gi0;
import com.baidu.tieba.go0;
import com.baidu.tieba.gp0;
import com.baidu.tieba.jp0;
import com.baidu.tieba.l11;
import com.baidu.tieba.lc1;
import com.baidu.tieba.mp0;
import com.baidu.tieba.nc1;
import com.baidu.tieba.no0;
import com.baidu.tieba.oo0;
import com.baidu.tieba.po0;
import com.baidu.tieba.qo0;
import com.baidu.tieba.rh0;
import com.baidu.tieba.s41;
import com.baidu.tieba.uo0;
import com.baidu.tieba.up0;
import com.baidu.tieba.w01;
import com.baidu.tieba.zb1;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J'\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PopoverComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "", "scrollUp", "handleActionUp", "(Z)V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "withAnim", "hideAdPopOver", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initPopoverData", "(Lorg/json/JSONObject;)V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "", "currentY", "videoHeight", "minTopMargin", "onScroll", "(III)V", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/model/AdLpParams$AlsModel;", "alsModel", "sendActionAls", "(Lcom/baidu/nadcore/model/AdLpParams$AlsModel;)V", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "criusPopFactory", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "Landroid/view/View;", "criusPopView", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "hasShowPop", "Z", "hasStartCountDown", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popoverModel", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popviewHeight", "I", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "<init>", "PopOverListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PopoverComponent extends AbsComponentPlugin {
    public nc1<View> d;
    public mp0 e;
    public zb1 f;
    public s41 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes2.dex */
    public final class a extends lc1 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.lc1
        public void a(boolean z, long j) {
            oo0 oo0Var = (oo0) PopoverComponent.this.j().o(oo0.class);
            if (oo0Var != null) {
                oo0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.lc1
        public void b(up0 clickInfo) {
            Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
            if (clickInfo.c) {
                if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                    rh0.c(clickInfo.a, PopoverComponent.this.getContext());
                } else {
                    no0 no0Var = (no0) PopoverComponent.this.j().o(no0.class);
                    if (no0Var != null) {
                        no0Var.j(false, true, false);
                    }
                }
                jp0 jp0Var = PopoverComponent.q(PopoverComponent.this).e;
                if (jp0Var != null) {
                    jp0Var.a();
                    jp0Var.b = clickInfo.b;
                    jp0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                    PopoverComponent.this.J(jp0Var);
                }
            }
            PopoverComponent.this.j().g(new go0(PopEventTypeEnum.CLICK_POP_UI));
        }

        @Override // com.baidu.tieba.lc1
        public void c() {
            oo0 oo0Var = (oo0) PopoverComponent.this.j().o(oo0.class);
            if (oo0Var != null) {
                oo0Var.d(240L, false);
            }
            jp0 jp0Var = PopoverComponent.q(PopoverComponent.this).e;
            if (jp0Var != null) {
                jp0Var.a();
                jp0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                PopoverComponent.this.J(jp0Var);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends s41.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.s41.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            if (PopoverComponent.this.h) {
                nc1 nc1Var = PopoverComponent.this.d;
                if (nc1Var != null) {
                    if (PopoverComponent.q(PopoverComponent.this).a != 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    nc1Var.c(z);
                }
                if (PopoverComponent.q(PopoverComponent.this).a == 3) {
                    no0 no0Var = (no0) PopoverComponent.this.j().o(no0.class);
                    po0 po0Var = (po0) PopoverComponent.this.j().o(po0.class);
                    if (no0Var != null && (b = no0Var.b()) != null) {
                        i = b.getTopMargin();
                    } else {
                        i = 0;
                    }
                    if (po0Var != null) {
                        i2 = po0Var.getVideoHeight();
                    } else {
                        i2 = 0;
                    }
                    int max = Math.max(0, PopoverComponent.this.i - (i2 - i));
                    if (no0Var != null) {
                        no0Var.f(false, true, true, max);
                    }
                }
                s41 s41Var = PopoverComponent.this.g;
                if (s41Var != null) {
                    s41Var.a();
                }
                PopoverComponent.this.g = null;
            }
        }

        @Override // com.baidu.tieba.s41.b
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
            s41 s41Var = PopoverComponent.this.g;
            if (s41Var != null) {
                s41Var.e();
            }
        }
    }

    public final void F() {
        s41 s41Var = this.g;
        if (s41Var != null) {
            s41Var.a();
        }
        this.g = null;
        mp0 mp0Var = this.e;
        if (mp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        s41 s41Var2 = new s41(mp0Var.b * 1000, 1000L);
        s41Var2.d(new b());
        this.g = s41Var2;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        s41 s41Var = this.g;
        if (s41Var != null) {
            s41Var.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        E(false);
        nc1<View> nc1Var = this.d;
        if (nc1Var != null) {
            nc1Var.a();
        }
        this.d = null;
        s41 s41Var = this.g;
        if (s41Var != null) {
            s41Var.a();
        }
        this.g = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        s41 s41Var;
        super.onResume();
        po0 po0Var = (po0) j().o(po0.class);
        if (po0Var != null && po0Var.k() && (s41Var = this.g) != null) {
            s41Var.c();
        }
    }

    public static final /* synthetic */ mp0 q(PopoverComponent popoverComponent) {
        mp0 mp0Var = popoverComponent.e;
        if (mp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return mp0Var;
    }

    public final void D(do0 do0Var) {
        int i = uo0.$EnumSwitchMapping$0[do0Var.getType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.j = true;
                    return;
                }
                return;
            }
            s41 s41Var = this.g;
            if (s41Var != null) {
                s41Var.b();
                return;
            }
            return;
        }
        s41 s41Var2 = this.g;
        if (s41Var2 != null) {
            s41Var2.c();
        }
    }

    public final void E(boolean z) {
        View realView;
        nc1<View> nc1Var;
        nc1<View> nc1Var2 = this.d;
        if (nc1Var2 != null && (realView = nc1Var2.getRealView()) != null && realView.getVisibility() == 0 && (nc1Var = this.d) != null) {
            nc1Var.b("0", z);
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
        qo0 qo0Var;
        nc1<View> nc1Var;
        View h;
        po0 po0Var = (po0) j().o(po0.class);
        if (po0Var != null && (qo0Var = (qo0) j().o(qo0.class)) != null && (nc1Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            mp0 mp0Var = this.e;
            if (mp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (mp0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            mp0 mp0Var2 = this.e;
            if (mp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (mp0Var2.a == 3) {
                h = qo0Var.b().l();
            } else {
                h = po0Var.h();
            }
            if (!(h instanceof ViewGroup)) {
                h = null;
            }
            nc1Var.setContainer((ViewGroup) h, layoutParams);
        }
    }

    public final void C(boolean z) {
        nc1<View> nc1Var;
        View realView;
        po0 po0Var;
        no0 no0Var;
        boolean z2;
        mp0 mp0Var = this.e;
        if (mp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (mp0Var.a != 3 || (nc1Var = this.d) == null || (realView = nc1Var.getRealView()) == null || realView.getVisibility() != 0 || (po0Var = (po0) j().o(po0.class)) == null || (no0Var = (no0) j().o(no0.class)) == null || !po0Var.k()) {
            return;
        }
        int videoHeight = po0Var.getVideoHeight() - no0Var.b().getTopMargin();
        if (!z && videoHeight < this.i / 2) {
            return;
        }
        int abs = Math.abs(videoHeight - this.i);
        if (videoHeight > this.i) {
            z2 = true;
        } else {
            z2 = false;
        }
        no0Var.f(z2, true, true, abs);
    }

    public final void G(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Object obj;
        nc1<View> nc1Var;
        mp0 a2 = mp0.f.a(jSONObject);
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
            w01.f(jSONObject3, "cmd_map", jSONObject2);
            mp0 mp0Var = this.e;
            if (mp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            zb1 zb1Var = this.f;
            View view2 = null;
            if (zb1Var != null) {
                obj = zb1Var.a(jSONObject3);
            } else {
                obj = null;
            }
            mp0Var.c = obj;
            mp0 mp0Var2 = this.e;
            if (mp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (mp0Var2.c == null) {
                return;
            }
            mp0 mp0Var3 = this.e;
            if (mp0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (mp0Var3.a != 2) {
                mp0 mp0Var4 = this.e;
                if (mp0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (mp0Var4.a != 3) {
                    mp0 mp0Var5 = this.e;
                    if (mp0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (mp0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            mp0 mp0Var6 = this.e;
            if (mp0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (mp0Var6.c == null) {
                return;
            }
            mp0 mp0Var7 = this.e;
            if (mp0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            gp0 c2 = gp0.c(w01.c(jSONObject.optString("download")));
            mp0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            jp0 jp0Var = new jp0();
            jp0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            jp0Var.d = jSONObject.optString("ext_info");
            Unit unit = Unit.INSTANCE;
            mp0Var7.e = jp0Var;
            zb1 zb1Var2 = this.f;
            if (zb1Var2 != null) {
                nc1Var = zb1Var2.b(getContext());
            } else {
                nc1Var = null;
            }
            this.d = nc1Var;
            if (nc1Var == null) {
                j().t(this);
                return;
            }
            if (nc1Var != null) {
                mp0 mp0Var8 = this.e;
                if (mp0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                nc1Var.setData(mp0Var8);
                nc1Var.setCriusPopListener(new a());
            }
            nc1<View> nc1Var2 = this.d;
            if (nc1Var2 != null) {
                view2 = nc1Var2.getRealView();
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
        nc1<View> nc1Var;
        View realView;
        mp0 mp0Var = this.e;
        if (mp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (mp0Var.a != 3 || (nc1Var = this.d) == null || (realView = nc1Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
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
        zb1 zb1Var = (zb1) ServiceManager.getService(zb1.a);
        this.f = zb1Var;
        if (zb1Var == null) {
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
                bq0.q.a(w01.c(str2));
            }
            G(jSONObject);
            F();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void u(gi0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.u(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, do0.class.getSimpleName())) {
            D((do0) event);
        } else if (Intrinsics.areEqual(a2, co0.class.getSimpleName())) {
            co0 co0Var = (co0) event;
            H(co0Var.c(), co0Var.d(), co0Var.b());
        } else if (Intrinsics.areEqual(a2, eo0.class.getSimpleName())) {
            C(((eo0) event).b());
        }
    }

    public final void J(jp0 jp0Var) {
        l11.b(new ClogBuilder().z(jp0Var.c).v(jp0Var.a).j(jp0Var.b).p(jp0Var.d).k(jp0Var.e).l(jp0Var.f).m(jp0Var.g));
    }
}
