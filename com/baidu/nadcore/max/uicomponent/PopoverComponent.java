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
import com.baidu.tieba.ce1;
import com.baidu.tieba.es0;
import com.baidu.tieba.fq0;
import com.baidu.tieba.gq0;
import com.baidu.tieba.hq0;
import com.baidu.tieba.jk0;
import com.baidu.tieba.jq0;
import com.baidu.tieba.jr0;
import com.baidu.tieba.mr0;
import com.baidu.tieba.o31;
import com.baidu.tieba.oe1;
import com.baidu.tieba.pr0;
import com.baidu.tieba.qe1;
import com.baidu.tieba.qq0;
import com.baidu.tieba.rq0;
import com.baidu.tieba.sq0;
import com.baidu.tieba.tq0;
import com.baidu.tieba.uj0;
import com.baidu.tieba.v61;
import com.baidu.tieba.xq0;
import com.baidu.tieba.xr0;
import com.baidu.tieba.z21;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J'\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PopoverComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "", "scrollUp", "handleActionUp", "(Z)V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "withAnim", "hideAdPopOver", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initPopoverData", "(Lorg/json/JSONObject;)V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "", "currentY", "videoHeight", "minTopMargin", "onScroll", "(III)V", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/model/AdLpParams$AlsModel;", "alsModel", "sendActionAls", "(Lcom/baidu/nadcore/model/AdLpParams$AlsModel;)V", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "criusPopFactory", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "Landroid/view/View;", "criusPopView", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "hasShowPop", "Z", "hasStartCountDown", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popoverModel", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popviewHeight", "I", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "<init>", "PopOverListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class PopoverComponent extends AbsComponentPlugin {
    public qe1<View> d;
    public pr0 e;
    public ce1 f;
    public v61 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes3.dex */
    public final class a extends oe1 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.oe1
        public void a(boolean z, long j) {
            rq0 rq0Var = (rq0) PopoverComponent.this.j().q(rq0.class);
            if (rq0Var != null) {
                rq0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.oe1
        public void b(xr0 clickInfo) {
            Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
            if (clickInfo.c) {
                if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                    uj0.c(clickInfo.a, PopoverComponent.this.getContext());
                } else {
                    qq0 qq0Var = (qq0) PopoverComponent.this.j().q(qq0.class);
                    if (qq0Var != null) {
                        qq0Var.j(false, true, false);
                    }
                }
                mr0 mr0Var = PopoverComponent.s(PopoverComponent.this).e;
                if (mr0Var != null) {
                    mr0Var.a();
                    mr0Var.b = clickInfo.b;
                    mr0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                    PopoverComponent.this.N(mr0Var);
                }
            }
            PopoverComponent.this.j().g(new jq0(PopEventTypeEnum.CLICK_POP_UI));
        }

        @Override // com.baidu.tieba.oe1
        public void c() {
            rq0 rq0Var = (rq0) PopoverComponent.this.j().q(rq0.class);
            if (rq0Var != null) {
                rq0Var.d(240L, false);
            }
            mr0 mr0Var = PopoverComponent.s(PopoverComponent.this).e;
            if (mr0Var != null) {
                mr0Var.a();
                mr0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                PopoverComponent.this.N(mr0Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends v61.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.v61.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            if (!PopoverComponent.this.h) {
                return;
            }
            qe1 qe1Var = PopoverComponent.this.d;
            if (qe1Var != null) {
                if (PopoverComponent.s(PopoverComponent.this).a != 3) {
                    z = true;
                } else {
                    z = false;
                }
                qe1Var.c(z);
            }
            if (PopoverComponent.s(PopoverComponent.this).a == 3) {
                qq0 qq0Var = (qq0) PopoverComponent.this.j().q(qq0.class);
                sq0 sq0Var = (sq0) PopoverComponent.this.j().q(sq0.class);
                if (qq0Var != null && (b = qq0Var.b()) != null) {
                    i = b.getTopMargin();
                } else {
                    i = 0;
                }
                if (sq0Var != null) {
                    i2 = sq0Var.getVideoHeight();
                } else {
                    i2 = 0;
                }
                int max = Math.max(0, PopoverComponent.this.i - (i2 - i));
                if (qq0Var != null) {
                    qq0Var.f(false, true, true, max);
                }
            }
            v61 v61Var = PopoverComponent.this.g;
            if (v61Var != null) {
                v61Var.a();
            }
            PopoverComponent.this.g = null;
        }

        @Override // com.baidu.tieba.v61.b
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
            v61 v61Var = PopoverComponent.this.g;
            if (v61Var != null) {
                v61Var.e();
            }
        }
    }

    public final void I() {
        v61 v61Var = this.g;
        if (v61Var != null) {
            v61Var.a();
        }
        this.g = null;
        pr0 pr0Var = this.e;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        v61 v61Var2 = new v61(pr0Var.b * 1000, 1000L);
        v61Var2.d(new b());
        this.g = v61Var2;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        v61 v61Var = this.g;
        if (v61Var != null) {
            v61Var.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        H(false);
        qe1<View> qe1Var = this.d;
        if (qe1Var != null) {
            qe1Var.a();
        }
        this.d = null;
        v61 v61Var = this.g;
        if (v61Var != null) {
            v61Var.a();
        }
        this.g = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        v61 v61Var;
        super.onResume();
        sq0 sq0Var = (sq0) j().q(sq0.class);
        if (sq0Var != null && sq0Var.k() && (v61Var = this.g) != null) {
            v61Var.c();
        }
    }

    public static final /* synthetic */ pr0 s(PopoverComponent popoverComponent) {
        pr0 pr0Var = popoverComponent.e;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return pr0Var;
    }

    public final void G(gq0 gq0Var) {
        int i = xq0.$EnumSwitchMapping$0[gq0Var.getType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.j = true;
                    return;
                }
                return;
            }
            v61 v61Var = this.g;
            if (v61Var != null) {
                v61Var.b();
                return;
            }
            return;
        }
        v61 v61Var2 = this.g;
        if (v61Var2 != null) {
            v61Var2.c();
        }
    }

    public final void H(boolean z) {
        View realView;
        qe1<View> qe1Var;
        qe1<View> qe1Var2 = this.d;
        if (qe1Var2 != null && (realView = qe1Var2.getRealView()) != null && realView.getVisibility() == 0 && (qe1Var = this.d) != null) {
            qe1Var.b("0", z);
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
        tq0 tq0Var;
        qe1<View> qe1Var;
        View h;
        sq0 sq0Var = (sq0) j().q(sq0.class);
        if (sq0Var != null && (tq0Var = (tq0) j().q(tq0.class)) != null && (qe1Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            pr0 pr0Var = this.e;
            if (pr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (pr0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            pr0 pr0Var2 = this.e;
            if (pr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (pr0Var2.a == 3) {
                h = tq0Var.b().l();
            } else {
                h = sq0Var.h();
            }
            if (!(h instanceof ViewGroup)) {
                h = null;
            }
            qe1Var.setContainer((ViewGroup) h, layoutParams);
        }
    }

    public final void E(boolean z) {
        qe1<View> qe1Var;
        View realView;
        sq0 sq0Var;
        qq0 qq0Var;
        boolean z2;
        pr0 pr0Var = this.e;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (pr0Var.a != 3 || (qe1Var = this.d) == null || (realView = qe1Var.getRealView()) == null || realView.getVisibility() != 0 || (sq0Var = (sq0) j().q(sq0.class)) == null || (qq0Var = (qq0) j().q(qq0.class)) == null || !sq0Var.k()) {
            return;
        }
        int videoHeight = sq0Var.getVideoHeight() - qq0Var.b().getTopMargin();
        if (!z && videoHeight < this.i / 2) {
            return;
        }
        int abs = Math.abs(videoHeight - this.i);
        if (videoHeight > this.i) {
            z2 = true;
        } else {
            z2 = false;
        }
        qq0Var.f(z2, true, true, abs);
    }

    public final void J(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Object obj;
        qe1<View> qe1Var;
        pr0 a2 = pr0.f.a(jSONObject);
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
            z21.f(jSONObject3, "cmd_map", jSONObject2);
            pr0 pr0Var = this.e;
            if (pr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            ce1 ce1Var = this.f;
            View view2 = null;
            if (ce1Var != null) {
                obj = ce1Var.a(jSONObject3);
            } else {
                obj = null;
            }
            pr0Var.c = obj;
            pr0 pr0Var2 = this.e;
            if (pr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (pr0Var2.c == null) {
                return;
            }
            pr0 pr0Var3 = this.e;
            if (pr0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (pr0Var3.a != 2) {
                pr0 pr0Var4 = this.e;
                if (pr0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (pr0Var4.a != 3) {
                    pr0 pr0Var5 = this.e;
                    if (pr0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (pr0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            pr0 pr0Var6 = this.e;
            if (pr0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (pr0Var6.c == null) {
                return;
            }
            pr0 pr0Var7 = this.e;
            if (pr0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            jr0 c2 = jr0.c(z21.c(jSONObject.optString("download")));
            pr0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            mr0 mr0Var = new mr0();
            mr0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            mr0Var.d = jSONObject.optString(MigrateStatisticUtils.EXT_INFO);
            Unit unit = Unit.INSTANCE;
            pr0Var7.e = mr0Var;
            ce1 ce1Var2 = this.f;
            if (ce1Var2 != null) {
                qe1Var = ce1Var2.b(getContext());
            } else {
                qe1Var = null;
            }
            this.d = qe1Var;
            if (qe1Var == null) {
                j().v(this);
                return;
            }
            if (qe1Var != null) {
                pr0 pr0Var8 = this.e;
                if (pr0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                qe1Var.setData(pr0Var8);
                qe1Var.setCriusPopListener(new a());
            }
            qe1<View> qe1Var2 = this.d;
            if (qe1Var2 != null) {
                view2 = qe1Var2.getRealView();
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
        qe1<View> qe1Var;
        View realView;
        pr0 pr0Var = this.e;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (pr0Var.a != 3 || (qe1Var = this.d) == null || (realView = qe1Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
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
        ce1 ce1Var = (ce1) ServiceManager.getService(ce1.a);
        this.f = ce1Var;
        if (ce1Var == null) {
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
                es0.q.a(z21.c(str2));
            }
            J(jSONObject);
            I();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void w(jk0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.w(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, gq0.class.getSimpleName())) {
            G((gq0) event);
        } else if (Intrinsics.areEqual(a2, fq0.class.getSimpleName())) {
            fq0 fq0Var = (fq0) event;
            L(fq0Var.c(), fq0Var.d(), fq0Var.b());
        } else if (Intrinsics.areEqual(a2, hq0.class.getSimpleName())) {
            E(((hq0) event).b());
        }
    }

    public final void N(mr0 mr0Var) {
        o31.b(new ClogBuilder().z(mr0Var.c).v(mr0Var.a).j(mr0Var.b).p(mr0Var.d).k(mr0Var.e).l(mr0Var.f).m(mr0Var.g));
    }
}
