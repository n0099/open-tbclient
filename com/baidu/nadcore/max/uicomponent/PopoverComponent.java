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
import com.baidu.tieba.ad1;
import com.baidu.tieba.b31;
import com.baidu.tieba.b71;
import com.baidu.tieba.br0;
import com.baidu.tieba.er0;
import com.baidu.tieba.fq0;
import com.baidu.tieba.gq0;
import com.baidu.tieba.hq0;
import com.baidu.tieba.iq0;
import com.baidu.tieba.md1;
import com.baidu.tieba.mq0;
import com.baidu.tieba.nj0;
import com.baidu.tieba.od1;
import com.baidu.tieba.or0;
import com.baidu.tieba.q31;
import com.baidu.tieba.up0;
import com.baidu.tieba.vp0;
import com.baidu.tieba.vr0;
import com.baidu.tieba.wp0;
import com.baidu.tieba.yi0;
import com.baidu.tieba.yp0;
import com.baidu.tieba.yq0;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J'\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PopoverComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "", "scrollUp", "handleActionUp", "(Z)V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "withAnim", "hideAdPopOver", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initPopoverData", "(Lorg/json/JSONObject;)V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "", "currentY", "videoHeight", "minTopMargin", "onScroll", "(III)V", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/model/AdLpParams$AlsModel;", "alsModel", "sendActionAls", "(Lcom/baidu/nadcore/model/AdLpParams$AlsModel;)V", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "criusPopFactory", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "Landroid/view/View;", "criusPopView", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "hasShowPop", "Z", "hasStartCountDown", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popoverModel", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popviewHeight", "I", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "<init>", "PopOverListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class PopoverComponent extends AbsComponentPlugin {
    public od1<View> d;
    public er0 e;
    public ad1 f;
    public b71 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes3.dex */
    public final class a extends md1 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.md1
        public void a(boolean z, long j) {
            gq0 gq0Var = (gq0) PopoverComponent.this.d().r(gq0.class);
            if (gq0Var != null) {
                gq0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.md1
        public void b(or0 clickInfo) {
            Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
            if (clickInfo.c) {
                if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                    yi0.c(clickInfo.a, PopoverComponent.this.getContext());
                } else {
                    fq0 fq0Var = (fq0) PopoverComponent.this.d().r(fq0.class);
                    if (fq0Var != null) {
                        fq0Var.i(false, true, false);
                    }
                }
                br0 br0Var = PopoverComponent.r(PopoverComponent.this).e;
                if (br0Var != null) {
                    br0Var.a();
                    br0Var.b = clickInfo.b;
                    br0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                    PopoverComponent.this.O(br0Var);
                }
            }
            PopoverComponent.this.d().j(new yp0(PopEventTypeEnum.CLICK_POP_UI));
        }

        @Override // com.baidu.tieba.md1
        public void c() {
            gq0 gq0Var = (gq0) PopoverComponent.this.d().r(gq0.class);
            if (gq0Var != null) {
                gq0Var.d(240L, false);
            }
            br0 br0Var = PopoverComponent.r(PopoverComponent.this).e;
            if (br0Var != null) {
                br0Var.a();
                br0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                PopoverComponent.this.O(br0Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends b71.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.b71.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            if (!PopoverComponent.this.h) {
                return;
            }
            od1 od1Var = PopoverComponent.this.d;
            if (od1Var != null) {
                if (PopoverComponent.r(PopoverComponent.this).a != 3) {
                    z = true;
                } else {
                    z = false;
                }
                od1Var.c(z);
            }
            if (PopoverComponent.r(PopoverComponent.this).a == 3) {
                fq0 fq0Var = (fq0) PopoverComponent.this.d().r(fq0.class);
                hq0 hq0Var = (hq0) PopoverComponent.this.d().r(hq0.class);
                if (fq0Var != null && (b = fq0Var.b()) != null) {
                    i = b.getTopMargin();
                } else {
                    i = 0;
                }
                if (hq0Var != null) {
                    i2 = hq0Var.getVideoHeight();
                } else {
                    i2 = 0;
                }
                int max = Math.max(0, PopoverComponent.this.i - (i2 - i));
                if (fq0Var != null) {
                    fq0Var.f(false, true, true, max);
                }
            }
            b71 b71Var = PopoverComponent.this.g;
            if (b71Var != null) {
                b71Var.a();
            }
            PopoverComponent.this.g = null;
        }

        @Override // com.baidu.tieba.b71.b
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
            b71 b71Var = PopoverComponent.this.g;
            if (b71Var != null) {
                b71Var.e();
            }
        }
    }

    public final void J() {
        b71 b71Var = this.g;
        if (b71Var != null) {
            b71Var.a();
        }
        this.g = null;
        er0 er0Var = this.e;
        if (er0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        b71 b71Var2 = new b71(er0Var.b * 1000, 1000L);
        b71Var2.d(new b());
        this.g = b71Var2;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        b71 b71Var = this.g;
        if (b71Var != null) {
            b71Var.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        I(false);
        od1<View> od1Var = this.d;
        if (od1Var != null) {
            od1Var.a();
        }
        this.d = null;
        b71 b71Var = this.g;
        if (b71Var != null) {
            b71Var.a();
        }
        this.g = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        b71 b71Var;
        super.onResume();
        hq0 hq0Var = (hq0) d().r(hq0.class);
        if (hq0Var != null && hq0Var.j() && (b71Var = this.g) != null) {
            b71Var.c();
        }
    }

    public static final /* synthetic */ er0 r(PopoverComponent popoverComponent) {
        er0 er0Var = popoverComponent.e;
        if (er0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return er0Var;
    }

    public final void H(vp0 vp0Var) {
        int i = mq0.$EnumSwitchMapping$0[vp0Var.getType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.j = true;
                    return;
                }
                return;
            }
            b71 b71Var = this.g;
            if (b71Var != null) {
                b71Var.b();
                return;
            }
            return;
        }
        b71 b71Var2 = this.g;
        if (b71Var2 != null) {
            b71Var2.c();
        }
    }

    public final void I(boolean z) {
        View realView;
        od1<View> od1Var;
        od1<View> od1Var2 = this.d;
        if (od1Var2 != null && (realView = od1Var2.getRealView()) != null && realView.getVisibility() == 0 && (od1Var = this.d) != null) {
            od1Var.b("0", z);
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
        iq0 iq0Var;
        od1<View> od1Var;
        View videoHolder;
        hq0 hq0Var = (hq0) d().r(hq0.class);
        if (hq0Var != null && (iq0Var = (iq0) d().r(iq0.class)) != null && (od1Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            er0 er0Var = this.e;
            if (er0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (er0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            er0 er0Var2 = this.e;
            if (er0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (er0Var2.a == 3) {
                videoHolder = iq0Var.b().j();
            } else {
                videoHolder = hq0Var.getVideoHolder();
            }
            if (!(videoHolder instanceof ViewGroup)) {
                videoHolder = null;
            }
            od1Var.setContainer((ViewGroup) videoHolder, layoutParams);
        }
    }

    public final void E(boolean z) {
        od1<View> od1Var;
        View realView;
        hq0 hq0Var;
        fq0 fq0Var;
        boolean z2;
        er0 er0Var = this.e;
        if (er0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (er0Var.a != 3 || (od1Var = this.d) == null || (realView = od1Var.getRealView()) == null || realView.getVisibility() != 0 || (hq0Var = (hq0) d().r(hq0.class)) == null || (fq0Var = (fq0) d().r(fq0.class)) == null || !hq0Var.j()) {
            return;
        }
        int videoHeight = hq0Var.getVideoHeight() - fq0Var.b().getTopMargin();
        if (!z && videoHeight < this.i / 2) {
            return;
        }
        int abs = Math.abs(videoHeight - this.i);
        if (videoHeight > this.i) {
            z2 = true;
        } else {
            z2 = false;
        }
        fq0Var.f(z2, true, true, abs);
    }

    public final void L(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Object obj;
        od1<View> od1Var;
        er0 a2 = er0.f.a(jSONObject);
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
            b31.f(jSONObject3, "cmd_map", jSONObject2);
            er0 er0Var = this.e;
            if (er0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            ad1 ad1Var = this.f;
            View view2 = null;
            if (ad1Var != null) {
                obj = ad1Var.a(jSONObject3);
            } else {
                obj = null;
            }
            er0Var.c = obj;
            er0 er0Var2 = this.e;
            if (er0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (er0Var2.c == null) {
                return;
            }
            er0 er0Var3 = this.e;
            if (er0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (er0Var3.a != 2) {
                er0 er0Var4 = this.e;
                if (er0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (er0Var4.a != 3) {
                    er0 er0Var5 = this.e;
                    if (er0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (er0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            er0 er0Var6 = this.e;
            if (er0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (er0Var6.c == null) {
                return;
            }
            er0 er0Var7 = this.e;
            if (er0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            yq0 c2 = yq0.c(b31.c(jSONObject.optString("download")));
            er0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            br0 br0Var = new br0();
            br0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            br0Var.d = jSONObject.optString(MigrateStatisticUtils.EXT_INFO);
            Unit unit = Unit.INSTANCE;
            er0Var7.e = br0Var;
            ad1 ad1Var2 = this.f;
            if (ad1Var2 != null) {
                od1Var = ad1Var2.b(getContext());
            } else {
                od1Var = null;
            }
            this.d = od1Var;
            if (od1Var == null) {
                d().C(this);
                return;
            }
            if (od1Var != null) {
                er0 er0Var8 = this.e;
                if (er0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                od1Var.setData(er0Var8);
                od1Var.setCriusPopListener(new a());
            }
            od1<View> od1Var2 = this.d;
            if (od1Var2 != null) {
                view2 = od1Var2.getRealView();
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
        od1<View> od1Var;
        View realView;
        er0 er0Var = this.e;
        if (er0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (er0Var.a != 3 || (od1Var = this.d) == null || (realView = od1Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
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
        ad1 ad1Var = (ad1) ServiceManager.getService(ad1.a);
        this.f = ad1Var;
        if (ad1Var == null) {
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
                vr0.t.a(b31.c(str2));
            }
            L(jSONObject);
            J();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void t(nj0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.t(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, vp0.class.getSimpleName())) {
            H((vp0) event);
        } else if (Intrinsics.areEqual(a2, up0.class.getSimpleName())) {
            up0 up0Var = (up0) event;
            M(up0Var.c(), up0Var.d(), up0Var.b());
        } else if (Intrinsics.areEqual(a2, wp0.class.getSimpleName())) {
            E(((wp0) event).b());
        }
    }

    public final void O(br0 br0Var) {
        q31.e(new ClogBuilder().z(br0Var.c).v(br0Var.a).j(br0Var.b).p(br0Var.d).k(br0Var.e).l(br0Var.f).m(br0Var.g));
    }
}
