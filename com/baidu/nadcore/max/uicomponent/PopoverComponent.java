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
import com.baidu.tieba.bj0;
import com.baidu.tieba.bq0;
import com.baidu.tieba.br0;
import com.baidu.tieba.e31;
import com.baidu.tieba.er0;
import com.baidu.tieba.fd1;
import com.baidu.tieba.g71;
import com.baidu.tieba.hr0;
import com.baidu.tieba.iq0;
import com.baidu.tieba.jq0;
import com.baidu.tieba.kq0;
import com.baidu.tieba.lq0;
import com.baidu.tieba.pq0;
import com.baidu.tieba.qj0;
import com.baidu.tieba.rd1;
import com.baidu.tieba.rr0;
import com.baidu.tieba.t31;
import com.baidu.tieba.td1;
import com.baidu.tieba.xp0;
import com.baidu.tieba.yp0;
import com.baidu.tieba.yr0;
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
    public td1<View> d;
    public hr0 e;
    public fd1 f;
    public g71 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes3.dex */
    public final class a extends rd1 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.rd1
        public void a(boolean z, long j) {
            jq0 jq0Var = (jq0) PopoverComponent.this.d().r(jq0.class);
            if (jq0Var != null) {
                jq0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.rd1
        public void b(rr0 clickInfo) {
            Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
            if (clickInfo.c) {
                if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                    bj0.c(clickInfo.a, PopoverComponent.this.getContext());
                } else {
                    iq0 iq0Var = (iq0) PopoverComponent.this.d().r(iq0.class);
                    if (iq0Var != null) {
                        iq0Var.i(false, true, false);
                    }
                }
                er0 er0Var = PopoverComponent.r(PopoverComponent.this).e;
                if (er0Var != null) {
                    er0Var.a();
                    er0Var.b = clickInfo.b;
                    er0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                    PopoverComponent.this.O(er0Var);
                }
            }
            PopoverComponent.this.d().j(new bq0(PopEventTypeEnum.CLICK_POP_UI));
        }

        @Override // com.baidu.tieba.rd1
        public void c() {
            jq0 jq0Var = (jq0) PopoverComponent.this.d().r(jq0.class);
            if (jq0Var != null) {
                jq0Var.d(240L, false);
            }
            er0 er0Var = PopoverComponent.r(PopoverComponent.this).e;
            if (er0Var != null) {
                er0Var.a();
                er0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                PopoverComponent.this.O(er0Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends g71.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.g71.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            if (!PopoverComponent.this.h) {
                return;
            }
            td1 td1Var = PopoverComponent.this.d;
            if (td1Var != null) {
                if (PopoverComponent.r(PopoverComponent.this).a != 3) {
                    z = true;
                } else {
                    z = false;
                }
                td1Var.c(z);
            }
            if (PopoverComponent.r(PopoverComponent.this).a == 3) {
                iq0 iq0Var = (iq0) PopoverComponent.this.d().r(iq0.class);
                kq0 kq0Var = (kq0) PopoverComponent.this.d().r(kq0.class);
                if (iq0Var != null && (b = iq0Var.b()) != null) {
                    i = b.getTopMargin();
                } else {
                    i = 0;
                }
                if (kq0Var != null) {
                    i2 = kq0Var.getVideoHeight();
                } else {
                    i2 = 0;
                }
                int max = Math.max(0, PopoverComponent.this.i - (i2 - i));
                if (iq0Var != null) {
                    iq0Var.f(false, true, true, max);
                }
            }
            g71 g71Var = PopoverComponent.this.g;
            if (g71Var != null) {
                g71Var.a();
            }
            PopoverComponent.this.g = null;
        }

        @Override // com.baidu.tieba.g71.b
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
            g71 g71Var = PopoverComponent.this.g;
            if (g71Var != null) {
                g71Var.e();
            }
        }
    }

    public final void J() {
        g71 g71Var = this.g;
        if (g71Var != null) {
            g71Var.a();
        }
        this.g = null;
        hr0 hr0Var = this.e;
        if (hr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        g71 g71Var2 = new g71(hr0Var.b * 1000, 1000L);
        g71Var2.d(new b());
        this.g = g71Var2;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        g71 g71Var = this.g;
        if (g71Var != null) {
            g71Var.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        I(false);
        td1<View> td1Var = this.d;
        if (td1Var != null) {
            td1Var.a();
        }
        this.d = null;
        g71 g71Var = this.g;
        if (g71Var != null) {
            g71Var.a();
        }
        this.g = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        g71 g71Var;
        super.onResume();
        kq0 kq0Var = (kq0) d().r(kq0.class);
        if (kq0Var != null && kq0Var.j() && (g71Var = this.g) != null) {
            g71Var.c();
        }
    }

    public static final /* synthetic */ hr0 r(PopoverComponent popoverComponent) {
        hr0 hr0Var = popoverComponent.e;
        if (hr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return hr0Var;
    }

    public final void F(yp0 yp0Var) {
        int i = pq0.$EnumSwitchMapping$0[yp0Var.getType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.j = true;
                    return;
                }
                return;
            }
            g71 g71Var = this.g;
            if (g71Var != null) {
                g71Var.b();
                return;
            }
            return;
        }
        g71 g71Var2 = this.g;
        if (g71Var2 != null) {
            g71Var2.c();
        }
    }

    public final void I(boolean z) {
        View realView;
        td1<View> td1Var;
        td1<View> td1Var2 = this.d;
        if (td1Var2 != null && (realView = td1Var2.getRealView()) != null && realView.getVisibility() == 0 && (td1Var = this.d) != null) {
            td1Var.b("0", z);
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
        N(intent);
    }

    public final void D() {
        lq0 lq0Var;
        td1<View> td1Var;
        View videoHolder;
        kq0 kq0Var = (kq0) d().r(kq0.class);
        if (kq0Var != null && (lq0Var = (lq0) d().r(lq0.class)) != null && (td1Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            hr0 hr0Var = this.e;
            if (hr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (hr0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            hr0 hr0Var2 = this.e;
            if (hr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (hr0Var2.a == 3) {
                videoHolder = lq0Var.b().j();
            } else {
                videoHolder = kq0Var.getVideoHolder();
            }
            if (!(videoHolder instanceof ViewGroup)) {
                videoHolder = null;
            }
            td1Var.setContainer((ViewGroup) videoHolder, layoutParams);
        }
    }

    public final void E(boolean z) {
        td1<View> td1Var;
        View realView;
        kq0 kq0Var;
        iq0 iq0Var;
        boolean z2;
        hr0 hr0Var = this.e;
        if (hr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (hr0Var.a != 3 || (td1Var = this.d) == null || (realView = td1Var.getRealView()) == null || realView.getVisibility() != 0 || (kq0Var = (kq0) d().r(kq0.class)) == null || (iq0Var = (iq0) d().r(iq0.class)) == null || !kq0Var.j()) {
            return;
        }
        int videoHeight = kq0Var.getVideoHeight() - iq0Var.b().getTopMargin();
        if (!z && videoHeight < this.i / 2) {
            return;
        }
        int abs = Math.abs(videoHeight - this.i);
        if (videoHeight > this.i) {
            z2 = true;
        } else {
            z2 = false;
        }
        iq0Var.f(z2, true, true, abs);
    }

    public final void L(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Object obj;
        td1<View> td1Var;
        hr0 a2 = hr0.f.a(jSONObject);
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
            e31.f(jSONObject3, "cmd_map", jSONObject2);
            hr0 hr0Var = this.e;
            if (hr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            fd1 fd1Var = this.f;
            View view2 = null;
            if (fd1Var != null) {
                obj = fd1Var.a(jSONObject3);
            } else {
                obj = null;
            }
            hr0Var.c = obj;
            hr0 hr0Var2 = this.e;
            if (hr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (hr0Var2.c == null) {
                return;
            }
            hr0 hr0Var3 = this.e;
            if (hr0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (hr0Var3.a != 2) {
                hr0 hr0Var4 = this.e;
                if (hr0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (hr0Var4.a != 3) {
                    hr0 hr0Var5 = this.e;
                    if (hr0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (hr0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            hr0 hr0Var6 = this.e;
            if (hr0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (hr0Var6.c == null) {
                return;
            }
            hr0 hr0Var7 = this.e;
            if (hr0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            br0 c2 = br0.c(e31.c(jSONObject.optString("download")));
            hr0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            er0 er0Var = new er0();
            er0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            er0Var.d = jSONObject.optString(MigrateStatisticUtils.EXT_INFO);
            Unit unit = Unit.INSTANCE;
            hr0Var7.e = er0Var;
            fd1 fd1Var2 = this.f;
            if (fd1Var2 != null) {
                td1Var = fd1Var2.b(getContext());
            } else {
                td1Var = null;
            }
            this.d = td1Var;
            if (td1Var == null) {
                d().C(this);
                return;
            }
            if (td1Var != null) {
                hr0 hr0Var8 = this.e;
                if (hr0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                td1Var.setData(hr0Var8);
                td1Var.setCriusPopListener(new a());
            }
            td1<View> td1Var2 = this.d;
            if (td1Var2 != null) {
                view2 = td1Var2.getRealView();
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
        td1<View> td1Var;
        View realView;
        hr0 hr0Var = this.e;
        if (hr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (hr0Var.a != 3 || (td1Var = this.d) == null || (realView = td1Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
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
        fd1 fd1Var = (fd1) ServiceManager.getService(fd1.a);
        this.f = fd1Var;
        if (fd1Var == null) {
            d().C(this);
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
                yr0.t.a(e31.c(str2));
            }
            L(jSONObject);
            J();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void t(qj0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.t(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, yp0.class.getSimpleName())) {
            F((yp0) event);
        } else if (Intrinsics.areEqual(a2, xp0.class.getSimpleName())) {
            xp0 xp0Var = (xp0) event;
            M(xp0Var.c(), xp0Var.d(), xp0Var.b());
        } else if (Intrinsics.areEqual(a2, zp0.class.getSimpleName())) {
            E(((zp0) event).b());
        }
    }

    public final void O(er0 er0Var) {
        t31.e(new ClogBuilder().z(er0Var.c).v(er0Var.a).j(er0Var.b).p(er0Var.d).k(er0Var.e).l(er0Var.f).m(er0Var.g));
    }
}
