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
import com.baidu.tieba.aj0;
import com.baidu.tieba.b61;
import com.baidu.tieba.dq0;
import com.baidu.tieba.dr0;
import com.baidu.tieba.f21;
import com.baidu.tieba.id1;
import com.baidu.tieba.kr0;
import com.baidu.tieba.lp0;
import com.baidu.tieba.mp0;
import com.baidu.tieba.np0;
import com.baidu.tieba.pj0;
import com.baidu.tieba.pp0;
import com.baidu.tieba.pq0;
import com.baidu.tieba.sq0;
import com.baidu.tieba.u21;
import com.baidu.tieba.ud1;
import com.baidu.tieba.vq0;
import com.baidu.tieba.wd1;
import com.baidu.tieba.wp0;
import com.baidu.tieba.xp0;
import com.baidu.tieba.yp0;
import com.baidu.tieba.zp0;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J'\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PopoverComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "", "scrollUp", "handleActionUp", "(Z)V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "withAnim", "hideAdPopOver", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initPopoverData", "(Lorg/json/JSONObject;)V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "", "currentY", "videoHeight", "minTopMargin", "onScroll", "(III)V", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/model/AdLpParams$AlsModel;", "alsModel", "sendActionAls", "(Lcom/baidu/nadcore/model/AdLpParams$AlsModel;)V", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "criusPopFactory", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "Landroid/view/View;", "criusPopView", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "hasShowPop", "Z", "hasStartCountDown", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popoverModel", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popviewHeight", "I", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "<init>", "PopOverListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PopoverComponent extends AbsComponentPlugin {
    public wd1<View> d;
    public vq0 e;
    public id1 f;
    public b61 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes2.dex */
    public final class a extends ud1 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.ud1
        public void a(boolean z, long j) {
            xp0 xp0Var = (xp0) PopoverComponent.this.b().k(xp0.class);
            if (xp0Var != null) {
                xp0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.ud1
        public void b(dr0 clickInfo) {
            Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
            if (clickInfo.c) {
                if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                    aj0.c(clickInfo.a, PopoverComponent.this.getContext());
                } else {
                    wp0 wp0Var = (wp0) PopoverComponent.this.b().k(wp0.class);
                    if (wp0Var != null) {
                        wp0Var.j(false, true, false);
                    }
                }
                sq0 sq0Var = PopoverComponent.m(PopoverComponent.this).e;
                if (sq0Var != null) {
                    sq0Var.a();
                    sq0Var.b = clickInfo.b;
                    sq0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                    PopoverComponent.this.M(sq0Var);
                }
            }
            PopoverComponent.this.b().d(new pp0(PopEventTypeEnum.CLICK_POP_UI));
        }

        @Override // com.baidu.tieba.ud1
        public void c() {
            xp0 xp0Var = (xp0) PopoverComponent.this.b().k(xp0.class);
            if (xp0Var != null) {
                xp0Var.d(240L, false);
            }
            sq0 sq0Var = PopoverComponent.m(PopoverComponent.this).e;
            if (sq0Var != null) {
                sq0Var.a();
                sq0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                PopoverComponent.this.M(sq0Var);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends b61.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.b61.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            if (PopoverComponent.this.h) {
                wd1 wd1Var = PopoverComponent.this.d;
                if (wd1Var != null) {
                    if (PopoverComponent.m(PopoverComponent.this).a != 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    wd1Var.c(z);
                }
                if (PopoverComponent.m(PopoverComponent.this).a == 3) {
                    wp0 wp0Var = (wp0) PopoverComponent.this.b().k(wp0.class);
                    yp0 yp0Var = (yp0) PopoverComponent.this.b().k(yp0.class);
                    if (wp0Var != null && (b = wp0Var.b()) != null) {
                        i = b.getTopMargin();
                    } else {
                        i = 0;
                    }
                    if (yp0Var != null) {
                        i2 = yp0Var.getVideoHeight();
                    } else {
                        i2 = 0;
                    }
                    int max = Math.max(0, PopoverComponent.this.i - (i2 - i));
                    if (wp0Var != null) {
                        wp0Var.f(false, true, true, max);
                    }
                }
                b61 b61Var = PopoverComponent.this.g;
                if (b61Var != null) {
                    b61Var.a();
                }
                PopoverComponent.this.g = null;
            }
        }

        @Override // com.baidu.tieba.b61.b
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
            b61 b61Var = PopoverComponent.this.g;
            if (b61Var != null) {
                b61Var.e();
            }
        }
    }

    public final void E() {
        b61 b61Var = this.g;
        if (b61Var != null) {
            b61Var.a();
        }
        this.g = null;
        vq0 vq0Var = this.e;
        if (vq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        b61 b61Var2 = new b61(vq0Var.b * 1000, 1000L);
        b61Var2.d(new b());
        this.g = b61Var2;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        b61 b61Var = this.g;
        if (b61Var != null) {
            b61Var.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        D(false);
        wd1<View> wd1Var = this.d;
        if (wd1Var != null) {
            wd1Var.a();
        }
        this.d = null;
        b61 b61Var = this.g;
        if (b61Var != null) {
            b61Var.a();
        }
        this.g = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        b61 b61Var;
        super.onResume();
        yp0 yp0Var = (yp0) b().k(yp0.class);
        if (yp0Var != null && yp0Var.k() && (b61Var = this.g) != null) {
            b61Var.c();
        }
    }

    public static final /* synthetic */ vq0 m(PopoverComponent popoverComponent) {
        vq0 vq0Var = popoverComponent.e;
        if (vq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return vq0Var;
    }

    public final void C(mp0 mp0Var) {
        int i = dq0.$EnumSwitchMapping$0[mp0Var.getType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.j = true;
                    return;
                }
                return;
            }
            b61 b61Var = this.g;
            if (b61Var != null) {
                b61Var.b();
                return;
            }
            return;
        }
        b61 b61Var2 = this.g;
        if (b61Var2 != null) {
            b61Var2.c();
        }
    }

    public final void D(boolean z) {
        View realView;
        wd1<View> wd1Var;
        wd1<View> wd1Var2 = this.d;
        if (wd1Var2 != null && (realView = wd1Var2.getRealView()) != null && realView.getVisibility() == 0 && (wd1Var = this.d) != null) {
            wd1Var.b("0", z);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void H(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.post(new c());
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        L(intent);
    }

    public final void A() {
        zp0 zp0Var;
        wd1<View> wd1Var;
        View h;
        yp0 yp0Var = (yp0) b().k(yp0.class);
        if (yp0Var != null && (zp0Var = (zp0) b().k(zp0.class)) != null && (wd1Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            vq0 vq0Var = this.e;
            if (vq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (vq0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            vq0 vq0Var2 = this.e;
            if (vq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (vq0Var2.a == 3) {
                h = zp0Var.b().l();
            } else {
                h = yp0Var.h();
            }
            if (!(h instanceof ViewGroup)) {
                h = null;
            }
            wd1Var.setContainer((ViewGroup) h, layoutParams);
        }
    }

    public final void B(boolean z) {
        wd1<View> wd1Var;
        View realView;
        yp0 yp0Var;
        wp0 wp0Var;
        boolean z2;
        vq0 vq0Var = this.e;
        if (vq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (vq0Var.a != 3 || (wd1Var = this.d) == null || (realView = wd1Var.getRealView()) == null || realView.getVisibility() != 0 || (yp0Var = (yp0) b().k(yp0.class)) == null || (wp0Var = (wp0) b().k(wp0.class)) == null || !yp0Var.k()) {
            return;
        }
        int videoHeight = yp0Var.getVideoHeight() - wp0Var.b().getTopMargin();
        if (!z && videoHeight < this.i / 2) {
            return;
        }
        int abs = Math.abs(videoHeight - this.i);
        if (videoHeight > this.i) {
            z2 = true;
        } else {
            z2 = false;
        }
        wp0Var.f(z2, true, true, abs);
    }

    public final void G(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Object obj;
        wd1<View> wd1Var;
        vq0 a2 = vq0.f.a(jSONObject);
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
            f21.f(jSONObject3, "cmd_map", jSONObject2);
            vq0 vq0Var = this.e;
            if (vq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            id1 id1Var = this.f;
            View view2 = null;
            if (id1Var != null) {
                obj = id1Var.a(jSONObject3);
            } else {
                obj = null;
            }
            vq0Var.c = obj;
            vq0 vq0Var2 = this.e;
            if (vq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (vq0Var2.c == null) {
                return;
            }
            vq0 vq0Var3 = this.e;
            if (vq0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (vq0Var3.a != 2) {
                vq0 vq0Var4 = this.e;
                if (vq0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (vq0Var4.a != 3) {
                    vq0 vq0Var5 = this.e;
                    if (vq0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (vq0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            vq0 vq0Var6 = this.e;
            if (vq0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (vq0Var6.c == null) {
                return;
            }
            vq0 vq0Var7 = this.e;
            if (vq0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            pq0 c2 = pq0.c(f21.c(jSONObject.optString("download")));
            vq0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            sq0 sq0Var = new sq0();
            sq0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            sq0Var.d = jSONObject.optString("ext_info");
            Unit unit = Unit.INSTANCE;
            vq0Var7.e = sq0Var;
            id1 id1Var2 = this.f;
            if (id1Var2 != null) {
                wd1Var = id1Var2.b(getContext());
            } else {
                wd1Var = null;
            }
            this.d = wd1Var;
            if (wd1Var == null) {
                b().t(this);
                return;
            }
            if (wd1Var != null) {
                vq0 vq0Var8 = this.e;
                if (vq0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                wd1Var.setData(vq0Var8);
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

    public final void K(int i, int i2, int i3) {
        wd1<View> wd1Var;
        View realView;
        vq0 vq0Var = this.e;
        if (vq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (vq0Var.a != 3 || (wd1Var = this.d) == null || (realView = wd1Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
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

    public final void L(Intent intent) {
        id1 id1Var = (id1) ServiceManager.getService(id1.a);
        this.f = id1Var;
        if (id1Var == null) {
            b().t(this);
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
                kr0.q.a(f21.c(str2));
            }
            G(jSONObject);
            E();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void q(pj0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.q(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, mp0.class.getSimpleName())) {
            C((mp0) event);
        } else if (Intrinsics.areEqual(a2, lp0.class.getSimpleName())) {
            lp0 lp0Var = (lp0) event;
            K(lp0Var.c(), lp0Var.d(), lp0Var.b());
        } else if (Intrinsics.areEqual(a2, np0.class.getSimpleName())) {
            B(((np0) event).b());
        }
    }

    public final void M(sq0 sq0Var) {
        u21.b(new ClogBuilder().z(sq0Var.c).v(sq0Var.a).j(sq0Var.b).p(sq0Var.d).k(sq0Var.e).l(sq0Var.f).m(sq0Var.g));
    }
}
