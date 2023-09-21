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
import com.baidu.tieba.aq0;
import com.baidu.tieba.bj0;
import com.baidu.tieba.bq0;
import com.baidu.tieba.bs0;
import com.baidu.tieba.cq0;
import com.baidu.tieba.eq0;
import com.baidu.tieba.er0;
import com.baidu.tieba.h31;
import com.baidu.tieba.hr0;
import com.baidu.tieba.id1;
import com.baidu.tieba.k71;
import com.baidu.tieba.kr0;
import com.baidu.tieba.lq0;
import com.baidu.tieba.mq0;
import com.baidu.tieba.nq0;
import com.baidu.tieba.oq0;
import com.baidu.tieba.qj0;
import com.baidu.tieba.sq0;
import com.baidu.tieba.ud1;
import com.baidu.tieba.ur0;
import com.baidu.tieba.w31;
import com.baidu.tieba.wd1;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J'\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PopoverComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "", "scrollUp", "handleActionUp", "(Z)V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "withAnim", "hideAdPopOver", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initPopoverData", "(Lorg/json/JSONObject;)V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "", "currentY", "videoHeight", "minTopMargin", "onScroll", "(III)V", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/model/AdLpParams$AlsModel;", "alsModel", "sendActionAls", "(Lcom/baidu/nadcore/model/AdLpParams$AlsModel;)V", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "criusPopFactory", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "Landroid/view/View;", "criusPopView", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "hasShowPop", "Z", "hasStartCountDown", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popoverModel", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popviewHeight", "I", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "<init>", "PopOverListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class PopoverComponent extends AbsComponentPlugin {
    public wd1<View> d;
    public kr0 e;
    public id1 f;
    public k71 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes3.dex */
    public final class a extends ud1 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.ud1
        public void a(boolean z, long j) {
            mq0 mq0Var = (mq0) PopoverComponent.this.c().p(mq0.class);
            if (mq0Var != null) {
                mq0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.ud1
        public void b(ur0 clickInfo) {
            Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
            if (clickInfo.c) {
                if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                    bj0.c(clickInfo.a, PopoverComponent.this.getContext());
                } else {
                    lq0 lq0Var = (lq0) PopoverComponent.this.c().p(lq0.class);
                    if (lq0Var != null) {
                        lq0Var.i(false, true, false);
                    }
                }
                hr0 hr0Var = PopoverComponent.p(PopoverComponent.this).e;
                if (hr0Var != null) {
                    hr0Var.a();
                    hr0Var.b = clickInfo.b;
                    hr0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                    PopoverComponent.this.N(hr0Var);
                }
            }
            PopoverComponent.this.c().j(new eq0(PopEventTypeEnum.CLICK_POP_UI));
        }

        @Override // com.baidu.tieba.ud1
        public void c() {
            mq0 mq0Var = (mq0) PopoverComponent.this.c().p(mq0.class);
            if (mq0Var != null) {
                mq0Var.d(240L, false);
            }
            hr0 hr0Var = PopoverComponent.p(PopoverComponent.this).e;
            if (hr0Var != null) {
                hr0Var.a();
                hr0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                PopoverComponent.this.N(hr0Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends k71.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.k71.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            if (!PopoverComponent.this.h) {
                return;
            }
            wd1 wd1Var = PopoverComponent.this.d;
            if (wd1Var != null) {
                if (PopoverComponent.p(PopoverComponent.this).a != 3) {
                    z = true;
                } else {
                    z = false;
                }
                wd1Var.c(z);
            }
            if (PopoverComponent.p(PopoverComponent.this).a == 3) {
                lq0 lq0Var = (lq0) PopoverComponent.this.c().p(lq0.class);
                nq0 nq0Var = (nq0) PopoverComponent.this.c().p(nq0.class);
                if (lq0Var != null && (b = lq0Var.b()) != null) {
                    i = b.getTopMargin();
                } else {
                    i = 0;
                }
                if (nq0Var != null) {
                    i2 = nq0Var.getVideoHeight();
                } else {
                    i2 = 0;
                }
                int max = Math.max(0, PopoverComponent.this.i - (i2 - i));
                if (lq0Var != null) {
                    lq0Var.f(false, true, true, max);
                }
            }
            k71 k71Var = PopoverComponent.this.g;
            if (k71Var != null) {
                k71Var.a();
            }
            PopoverComponent.this.g = null;
        }

        @Override // com.baidu.tieba.k71.b
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
            k71 k71Var = PopoverComponent.this.g;
            if (k71Var != null) {
                k71Var.e();
            }
        }
    }

    public final void I() {
        k71 k71Var = this.g;
        if (k71Var != null) {
            k71Var.a();
        }
        this.g = null;
        kr0 kr0Var = this.e;
        if (kr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        k71 k71Var2 = new k71(kr0Var.b * 1000, 1000L);
        k71Var2.d(new b());
        this.g = k71Var2;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        k71 k71Var = this.g;
        if (k71Var != null) {
            k71Var.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        H(false);
        wd1<View> wd1Var = this.d;
        if (wd1Var != null) {
            wd1Var.a();
        }
        this.d = null;
        k71 k71Var = this.g;
        if (k71Var != null) {
            k71Var.a();
        }
        this.g = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        k71 k71Var;
        super.onResume();
        nq0 nq0Var = (nq0) c().p(nq0.class);
        if (nq0Var != null && nq0Var.j() && (k71Var = this.g) != null) {
            k71Var.c();
        }
    }

    public static final /* synthetic */ kr0 p(PopoverComponent popoverComponent) {
        kr0 kr0Var = popoverComponent.e;
        if (kr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return kr0Var;
    }

    public final void F(bq0 bq0Var) {
        int i = sq0.$EnumSwitchMapping$0[bq0Var.getType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.j = true;
                    return;
                }
                return;
            }
            k71 k71Var = this.g;
            if (k71Var != null) {
                k71Var.b();
                return;
            }
            return;
        }
        k71 k71Var2 = this.g;
        if (k71Var2 != null) {
            k71Var2.c();
        }
    }

    public final void H(boolean z) {
        View realView;
        wd1<View> wd1Var;
        wd1<View> wd1Var2 = this.d;
        if (wd1Var2 != null && (realView = wd1Var2.getRealView()) != null && realView.getVisibility() == 0 && (wd1Var = this.d) != null) {
            wd1Var.b("0", z);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void J(ViewGroup parent) {
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
        oq0 oq0Var;
        wd1<View> wd1Var;
        View videoHolder;
        nq0 nq0Var = (nq0) c().p(nq0.class);
        if (nq0Var != null && (oq0Var = (oq0) c().p(oq0.class)) != null && (wd1Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            kr0 kr0Var = this.e;
            if (kr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (kr0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            kr0 kr0Var2 = this.e;
            if (kr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (kr0Var2.a == 3) {
                videoHolder = oq0Var.b().j();
            } else {
                videoHolder = nq0Var.getVideoHolder();
            }
            if (!(videoHolder instanceof ViewGroup)) {
                videoHolder = null;
            }
            wd1Var.setContainer((ViewGroup) videoHolder, layoutParams);
        }
    }

    public final void E(boolean z) {
        wd1<View> wd1Var;
        View realView;
        nq0 nq0Var;
        lq0 lq0Var;
        boolean z2;
        kr0 kr0Var = this.e;
        if (kr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (kr0Var.a != 3 || (wd1Var = this.d) == null || (realView = wd1Var.getRealView()) == null || realView.getVisibility() != 0 || (nq0Var = (nq0) c().p(nq0.class)) == null || (lq0Var = (lq0) c().p(lq0.class)) == null || !nq0Var.j()) {
            return;
        }
        int videoHeight = nq0Var.getVideoHeight() - lq0Var.b().getTopMargin();
        if (!z && videoHeight < this.i / 2) {
            return;
        }
        int abs = Math.abs(videoHeight - this.i);
        if (videoHeight > this.i) {
            z2 = true;
        } else {
            z2 = false;
        }
        lq0Var.f(z2, true, true, abs);
    }

    public final void K(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Object obj;
        wd1<View> wd1Var;
        kr0 a2 = kr0.f.a(jSONObject);
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
            h31.f(jSONObject3, "cmd_map", jSONObject2);
            kr0 kr0Var = this.e;
            if (kr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            id1 id1Var = this.f;
            View view2 = null;
            if (id1Var != null) {
                obj = id1Var.a(jSONObject3);
            } else {
                obj = null;
            }
            kr0Var.c = obj;
            kr0 kr0Var2 = this.e;
            if (kr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (kr0Var2.c == null) {
                return;
            }
            kr0 kr0Var3 = this.e;
            if (kr0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (kr0Var3.a != 2) {
                kr0 kr0Var4 = this.e;
                if (kr0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (kr0Var4.a != 3) {
                    kr0 kr0Var5 = this.e;
                    if (kr0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (kr0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            kr0 kr0Var6 = this.e;
            if (kr0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (kr0Var6.c == null) {
                return;
            }
            kr0 kr0Var7 = this.e;
            if (kr0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            er0 c2 = er0.c(h31.c(jSONObject.optString("download")));
            kr0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            hr0 hr0Var = new hr0();
            hr0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            hr0Var.d = jSONObject.optString(MigrateStatisticUtils.EXT_INFO);
            Unit unit = Unit.INSTANCE;
            kr0Var7.e = hr0Var;
            id1 id1Var2 = this.f;
            if (id1Var2 != null) {
                wd1Var = id1Var2.b(getContext());
            } else {
                wd1Var = null;
            }
            this.d = wd1Var;
            if (wd1Var == null) {
                c().B(this);
                return;
            }
            if (wd1Var != null) {
                kr0 kr0Var8 = this.e;
                if (kr0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                wd1Var.setData(kr0Var8);
                wd1Var.setCriusPopListener(new a());
            }
            wd1<View> wd1Var2 = this.d;
            if (wd1Var2 != null) {
                view2 = wd1Var2.getRealView();
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
        wd1<View> wd1Var;
        View realView;
        kr0 kr0Var = this.e;
        if (kr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (kr0Var.a != 3 || (wd1Var = this.d) == null || (realView = wd1Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
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
        id1 id1Var = (id1) ServiceManager.getService(id1.a);
        this.f = id1Var;
        if (id1Var == null) {
            c().B(this);
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
                bs0.v.a(h31.c(str2));
            }
            K(jSONObject);
            I();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void s(qj0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.s(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, bq0.class.getSimpleName())) {
            F((bq0) event);
        } else if (Intrinsics.areEqual(a2, aq0.class.getSimpleName())) {
            aq0 aq0Var = (aq0) event;
            L(aq0Var.c(), aq0Var.d(), aq0Var.b());
        } else if (Intrinsics.areEqual(a2, cq0.class.getSimpleName())) {
            E(((cq0) event).b());
        }
    }

    public final void N(hr0 hr0Var) {
        w31.e(new ClogBuilder().z(hr0Var.c).v(hr0Var.a).j(hr0Var.b).p(hr0Var.d).k(hr0Var.e).l(hr0Var.f).m(hr0Var.g));
    }
}
