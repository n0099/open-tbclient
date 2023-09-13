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
import com.baidu.tieba.bq0;
import com.baidu.tieba.cj0;
import com.baidu.tieba.cq0;
import com.baidu.tieba.cs0;
import com.baidu.tieba.dq0;
import com.baidu.tieba.fq0;
import com.baidu.tieba.fr0;
import com.baidu.tieba.i31;
import com.baidu.tieba.ir0;
import com.baidu.tieba.jd1;
import com.baidu.tieba.l71;
import com.baidu.tieba.lr0;
import com.baidu.tieba.mq0;
import com.baidu.tieba.nq0;
import com.baidu.tieba.oq0;
import com.baidu.tieba.pq0;
import com.baidu.tieba.rj0;
import com.baidu.tieba.tq0;
import com.baidu.tieba.vd1;
import com.baidu.tieba.vr0;
import com.baidu.tieba.x31;
import com.baidu.tieba.xd1;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J'\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PopoverComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "", "scrollUp", "handleActionUp", "(Z)V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "withAnim", "hideAdPopOver", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initPopoverData", "(Lorg/json/JSONObject;)V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "", "currentY", "videoHeight", "minTopMargin", "onScroll", "(III)V", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/model/AdLpParams$AlsModel;", "alsModel", "sendActionAls", "(Lcom/baidu/nadcore/model/AdLpParams$AlsModel;)V", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "criusPopFactory", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "Landroid/view/View;", "criusPopView", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "hasShowPop", "Z", "hasStartCountDown", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popoverModel", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popviewHeight", "I", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "<init>", "PopOverListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class PopoverComponent extends AbsComponentPlugin {
    public xd1<View> d;
    public lr0 e;
    public jd1 f;
    public l71 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes3.dex */
    public final class a extends vd1 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.vd1
        public void a(boolean z, long j) {
            nq0 nq0Var = (nq0) PopoverComponent.this.c().q(nq0.class);
            if (nq0Var != null) {
                nq0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.vd1
        public void b(vr0 clickInfo) {
            Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
            if (clickInfo.c) {
                if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                    cj0.c(clickInfo.a, PopoverComponent.this.getContext());
                } else {
                    mq0 mq0Var = (mq0) PopoverComponent.this.c().q(mq0.class);
                    if (mq0Var != null) {
                        mq0Var.i(false, true, false);
                    }
                }
                ir0 ir0Var = PopoverComponent.q(PopoverComponent.this).e;
                if (ir0Var != null) {
                    ir0Var.a();
                    ir0Var.b = clickInfo.b;
                    ir0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                    PopoverComponent.this.N(ir0Var);
                }
            }
            PopoverComponent.this.c().j(new fq0(PopEventTypeEnum.CLICK_POP_UI));
        }

        @Override // com.baidu.tieba.vd1
        public void c() {
            nq0 nq0Var = (nq0) PopoverComponent.this.c().q(nq0.class);
            if (nq0Var != null) {
                nq0Var.d(240L, false);
            }
            ir0 ir0Var = PopoverComponent.q(PopoverComponent.this).e;
            if (ir0Var != null) {
                ir0Var.a();
                ir0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                PopoverComponent.this.N(ir0Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends l71.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.l71.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            if (!PopoverComponent.this.h) {
                return;
            }
            xd1 xd1Var = PopoverComponent.this.d;
            if (xd1Var != null) {
                if (PopoverComponent.q(PopoverComponent.this).a != 3) {
                    z = true;
                } else {
                    z = false;
                }
                xd1Var.c(z);
            }
            if (PopoverComponent.q(PopoverComponent.this).a == 3) {
                mq0 mq0Var = (mq0) PopoverComponent.this.c().q(mq0.class);
                oq0 oq0Var = (oq0) PopoverComponent.this.c().q(oq0.class);
                if (mq0Var != null && (b = mq0Var.b()) != null) {
                    i = b.getTopMargin();
                } else {
                    i = 0;
                }
                if (oq0Var != null) {
                    i2 = oq0Var.getVideoHeight();
                } else {
                    i2 = 0;
                }
                int max = Math.max(0, PopoverComponent.this.i - (i2 - i));
                if (mq0Var != null) {
                    mq0Var.f(false, true, true, max);
                }
            }
            l71 l71Var = PopoverComponent.this.g;
            if (l71Var != null) {
                l71Var.a();
            }
            PopoverComponent.this.g = null;
        }

        @Override // com.baidu.tieba.l71.b
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
            l71 l71Var = PopoverComponent.this.g;
            if (l71Var != null) {
                l71Var.e();
            }
        }
    }

    public final void I() {
        l71 l71Var = this.g;
        if (l71Var != null) {
            l71Var.a();
        }
        this.g = null;
        lr0 lr0Var = this.e;
        if (lr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        l71 l71Var2 = new l71(lr0Var.b * 1000, 1000L);
        l71Var2.d(new b());
        this.g = l71Var2;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        l71 l71Var = this.g;
        if (l71Var != null) {
            l71Var.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        H(false);
        xd1<View> xd1Var = this.d;
        if (xd1Var != null) {
            xd1Var.a();
        }
        this.d = null;
        l71 l71Var = this.g;
        if (l71Var != null) {
            l71Var.a();
        }
        this.g = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        l71 l71Var;
        super.onResume();
        oq0 oq0Var = (oq0) c().q(oq0.class);
        if (oq0Var != null && oq0Var.j() && (l71Var = this.g) != null) {
            l71Var.c();
        }
    }

    public static final /* synthetic */ lr0 q(PopoverComponent popoverComponent) {
        lr0 lr0Var = popoverComponent.e;
        if (lr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return lr0Var;
    }

    public final void G(cq0 cq0Var) {
        int i = tq0.$EnumSwitchMapping$0[cq0Var.getType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.j = true;
                    return;
                }
                return;
            }
            l71 l71Var = this.g;
            if (l71Var != null) {
                l71Var.b();
                return;
            }
            return;
        }
        l71 l71Var2 = this.g;
        if (l71Var2 != null) {
            l71Var2.c();
        }
    }

    public final void H(boolean z) {
        View realView;
        xd1<View> xd1Var;
        xd1<View> xd1Var2 = this.d;
        if (xd1Var2 != null && (realView = xd1Var2.getRealView()) != null && realView.getVisibility() == 0 && (xd1Var = this.d) != null) {
            xd1Var.b("0", z);
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
        pq0 pq0Var;
        xd1<View> xd1Var;
        View videoHolder;
        oq0 oq0Var = (oq0) c().q(oq0.class);
        if (oq0Var != null && (pq0Var = (pq0) c().q(pq0.class)) != null && (xd1Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            lr0 lr0Var = this.e;
            if (lr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (lr0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            lr0 lr0Var2 = this.e;
            if (lr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (lr0Var2.a == 3) {
                videoHolder = pq0Var.b().j();
            } else {
                videoHolder = oq0Var.getVideoHolder();
            }
            if (!(videoHolder instanceof ViewGroup)) {
                videoHolder = null;
            }
            xd1Var.setContainer((ViewGroup) videoHolder, layoutParams);
        }
    }

    public final void E(boolean z) {
        xd1<View> xd1Var;
        View realView;
        oq0 oq0Var;
        mq0 mq0Var;
        boolean z2;
        lr0 lr0Var = this.e;
        if (lr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (lr0Var.a != 3 || (xd1Var = this.d) == null || (realView = xd1Var.getRealView()) == null || realView.getVisibility() != 0 || (oq0Var = (oq0) c().q(oq0.class)) == null || (mq0Var = (mq0) c().q(mq0.class)) == null || !oq0Var.j()) {
            return;
        }
        int videoHeight = oq0Var.getVideoHeight() - mq0Var.b().getTopMargin();
        if (!z && videoHeight < this.i / 2) {
            return;
        }
        int abs = Math.abs(videoHeight - this.i);
        if (videoHeight > this.i) {
            z2 = true;
        } else {
            z2 = false;
        }
        mq0Var.f(z2, true, true, abs);
    }

    public final void K(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Object obj;
        xd1<View> xd1Var;
        lr0 a2 = lr0.f.a(jSONObject);
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
            i31.f(jSONObject3, "cmd_map", jSONObject2);
            lr0 lr0Var = this.e;
            if (lr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            jd1 jd1Var = this.f;
            View view2 = null;
            if (jd1Var != null) {
                obj = jd1Var.a(jSONObject3);
            } else {
                obj = null;
            }
            lr0Var.c = obj;
            lr0 lr0Var2 = this.e;
            if (lr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (lr0Var2.c == null) {
                return;
            }
            lr0 lr0Var3 = this.e;
            if (lr0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (lr0Var3.a != 2) {
                lr0 lr0Var4 = this.e;
                if (lr0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (lr0Var4.a != 3) {
                    lr0 lr0Var5 = this.e;
                    if (lr0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (lr0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            lr0 lr0Var6 = this.e;
            if (lr0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (lr0Var6.c == null) {
                return;
            }
            lr0 lr0Var7 = this.e;
            if (lr0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            fr0 c2 = fr0.c(i31.c(jSONObject.optString("download")));
            lr0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            ir0 ir0Var = new ir0();
            ir0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            ir0Var.d = jSONObject.optString(MigrateStatisticUtils.EXT_INFO);
            Unit unit = Unit.INSTANCE;
            lr0Var7.e = ir0Var;
            jd1 jd1Var2 = this.f;
            if (jd1Var2 != null) {
                xd1Var = jd1Var2.b(getContext());
            } else {
                xd1Var = null;
            }
            this.d = xd1Var;
            if (xd1Var == null) {
                c().B(this);
                return;
            }
            if (xd1Var != null) {
                lr0 lr0Var8 = this.e;
                if (lr0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                xd1Var.setData(lr0Var8);
                xd1Var.setCriusPopListener(new a());
            }
            xd1<View> xd1Var2 = this.d;
            if (xd1Var2 != null) {
                view2 = xd1Var2.getRealView();
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
        xd1<View> xd1Var;
        View realView;
        lr0 lr0Var = this.e;
        if (lr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (lr0Var.a != 3 || (xd1Var = this.d) == null || (realView = xd1Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
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
        jd1 jd1Var = (jd1) ServiceManager.getService(jd1.a);
        this.f = jd1Var;
        if (jd1Var == null) {
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
                cs0.v.a(i31.c(str2));
            }
            K(jSONObject);
            I();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void s(rj0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.s(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, cq0.class.getSimpleName())) {
            G((cq0) event);
        } else if (Intrinsics.areEqual(a2, bq0.class.getSimpleName())) {
            bq0 bq0Var = (bq0) event;
            L(bq0Var.c(), bq0Var.d(), bq0Var.b());
        } else if (Intrinsics.areEqual(a2, dq0.class.getSimpleName())) {
            E(((dq0) event).b());
        }
    }

    public final void N(ir0 ir0Var) {
        x31.e(new ClogBuilder().z(ir0Var.c).v(ir0Var.a).j(ir0Var.b).p(ir0Var.d).k(ir0Var.e).l(ir0Var.f).m(ir0Var.g));
    }
}
