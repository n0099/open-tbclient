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
import com.baidu.tieba.ak0;
import com.baidu.tieba.as0;
import com.baidu.tieba.ds0;
import com.baidu.tieba.er0;
import com.baidu.tieba.fr0;
import com.baidu.tieba.gr0;
import com.baidu.tieba.hr0;
import com.baidu.tieba.je1;
import com.baidu.tieba.le1;
import com.baidu.tieba.lr0;
import com.baidu.tieba.ls0;
import com.baidu.tieba.n41;
import com.baidu.tieba.pk0;
import com.baidu.tieba.ss0;
import com.baidu.tieba.tq0;
import com.baidu.tieba.uq0;
import com.baidu.tieba.vq0;
import com.baidu.tieba.xd1;
import com.baidu.tieba.xq0;
import com.baidu.tieba.xr0;
import com.baidu.tieba.y31;
import com.baidu.tieba.y71;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J'\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PopoverComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "", "scrollUp", "handleActionUp", "(Z)V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "withAnim", "hideAdPopOver", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initPopoverData", "(Lorg/json/JSONObject;)V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "", "currentY", "videoHeight", "minTopMargin", "onScroll", "(III)V", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/model/AdLpParams$AlsModel;", "alsModel", "sendActionAls", "(Lcom/baidu/nadcore/model/AdLpParams$AlsModel;)V", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "criusPopFactory", "Lcom/baidu/nadcore/widget/ioc/IAdCriusPopViewFactory;", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "Landroid/view/View;", "criusPopView", "Lcom/baidu/nadcore/widget/uiwidget/ICriusPopView;", "hasShowPop", "Z", "hasStartCountDown", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popoverModel", "Lcom/baidu/nadcore/model/AdLpParams$PopoverModel;", "popviewHeight", "I", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "<init>", "PopOverListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class PopoverComponent extends AbsComponentPlugin {
    public le1<View> d;
    public ds0 e;
    public xd1 f;
    public y71 g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes3.dex */
    public final class a extends je1 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.je1
        public void a(boolean z, long j) {
            fr0 fr0Var = (fr0) PopoverComponent.this.d().r(fr0.class);
            if (fr0Var != null) {
                fr0Var.d(240L, true);
            }
        }

        @Override // com.baidu.tieba.je1
        public void b(ls0 clickInfo) {
            Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
            if (clickInfo.c) {
                if (!TextUtils.isEmpty(clickInfo.a) && !TextUtils.equals("AD_IMMERSIVE_VIDEO_SCROLL", clickInfo.a)) {
                    ak0.c(clickInfo.a, PopoverComponent.this.getContext());
                } else {
                    er0 er0Var = (er0) PopoverComponent.this.d().r(er0.class);
                    if (er0Var != null) {
                        er0Var.i(false, true, false);
                    }
                }
                as0 as0Var = PopoverComponent.r(PopoverComponent.this).e;
                if (as0Var != null) {
                    as0Var.a();
                    as0Var.b = clickInfo.b;
                    as0Var.c = ClogBuilder.LogType.FREE_CLICK.type;
                    PopoverComponent.this.N(as0Var);
                }
            }
            PopoverComponent.this.d().j(new xq0(PopEventTypeEnum.CLICK_POP_UI));
        }

        @Override // com.baidu.tieba.je1
        public void c() {
            fr0 fr0Var = (fr0) PopoverComponent.this.d().r(fr0.class);
            if (fr0Var != null) {
                fr0Var.d(240L, false);
            }
            as0 as0Var = PopoverComponent.r(PopoverComponent.this).e;
            if (as0Var != null) {
                as0Var.a();
                as0Var.c = ClogBuilder.LogType.FREE_SHOW.type;
                PopoverComponent.this.N(as0Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends y71.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.y71.b
        public void b() {
            int i;
            int i2;
            WebViewContainer b;
            boolean z;
            if (PopoverComponent.this.h) {
                le1 le1Var = PopoverComponent.this.d;
                if (le1Var != null) {
                    if (PopoverComponent.r(PopoverComponent.this).a != 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    le1Var.c(z);
                }
                if (PopoverComponent.r(PopoverComponent.this).a == 3) {
                    er0 er0Var = (er0) PopoverComponent.this.d().r(er0.class);
                    gr0 gr0Var = (gr0) PopoverComponent.this.d().r(gr0.class);
                    if (er0Var != null && (b = er0Var.b()) != null) {
                        i = b.getTopMargin();
                    } else {
                        i = 0;
                    }
                    if (gr0Var != null) {
                        i2 = gr0Var.getVideoHeight();
                    } else {
                        i2 = 0;
                    }
                    int max = Math.max(0, PopoverComponent.this.i - (i2 - i));
                    if (er0Var != null) {
                        er0Var.f(false, true, true, max);
                    }
                }
                y71 y71Var = PopoverComponent.this.g;
                if (y71Var != null) {
                    y71Var.a();
                }
                PopoverComponent.this.g = null;
            }
        }

        @Override // com.baidu.tieba.y71.b
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
            PopoverComponent.this.A();
            y71 y71Var = PopoverComponent.this.g;
            if (y71Var != null) {
                y71Var.e();
            }
        }
    }

    public final void I() {
        y71 y71Var = this.g;
        if (y71Var != null) {
            y71Var.a();
        }
        this.g = null;
        ds0 ds0Var = this.e;
        if (ds0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        y71 y71Var2 = new y71(ds0Var.b * 1000, 1000L);
        y71Var2.d(new b());
        this.g = y71Var2;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        y71 y71Var = this.g;
        if (y71Var != null) {
            y71Var.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        F(false);
        le1<View> le1Var = this.d;
        if (le1Var != null) {
            le1Var.a();
        }
        this.d = null;
        y71 y71Var = this.g;
        if (y71Var != null) {
            y71Var.a();
        }
        this.g = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        y71 y71Var;
        super.onResume();
        gr0 gr0Var = (gr0) d().r(gr0.class);
        if (gr0Var != null && gr0Var.j() && (y71Var = this.g) != null) {
            y71Var.c();
        }
    }

    public static final /* synthetic */ ds0 r(PopoverComponent popoverComponent) {
        ds0 ds0Var = popoverComponent.e;
        if (ds0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        return ds0Var;
    }

    public final void E(uq0 uq0Var) {
        int i = lr0.$EnumSwitchMapping$0[uq0Var.getType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.j = true;
                    return;
                }
                return;
            }
            y71 y71Var = this.g;
            if (y71Var != null) {
                y71Var.b();
                return;
            }
            return;
        }
        y71 y71Var2 = this.g;
        if (y71Var2 != null) {
            y71Var2.c();
        }
    }

    public final void F(boolean z) {
        View realView;
        le1<View> le1Var;
        le1<View> le1Var2 = this.d;
        if (le1Var2 != null && (realView = le1Var2.getRealView()) != null && realView.getVisibility() == 0 && (le1Var = this.d) != null) {
            le1Var.b("0", z);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void Q(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.post(new c());
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        M(intent);
    }

    public final void A() {
        hr0 hr0Var;
        le1<View> le1Var;
        View videoHolder;
        gr0 gr0Var = (gr0) d().r(gr0.class);
        if (gr0Var != null && (hr0Var = (hr0) d().r(hr0.class)) != null && (le1Var = this.d) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            ds0 ds0Var = this.e;
            if (ds0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (ds0Var.a == 3) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 80;
            }
            ds0 ds0Var2 = this.e;
            if (ds0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (ds0Var2.a == 3) {
                videoHolder = hr0Var.b().j();
            } else {
                videoHolder = gr0Var.getVideoHolder();
            }
            if (!(videoHolder instanceof ViewGroup)) {
                videoHolder = null;
            }
            le1Var.setContainer((ViewGroup) videoHolder, layoutParams);
        }
    }

    public final void D(boolean z) {
        le1<View> le1Var;
        View realView;
        gr0 gr0Var;
        er0 er0Var;
        boolean z2;
        ds0 ds0Var = this.e;
        if (ds0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (ds0Var.a != 3 || (le1Var = this.d) == null || (realView = le1Var.getRealView()) == null || realView.getVisibility() != 0 || (gr0Var = (gr0) d().r(gr0.class)) == null || (er0Var = (er0) d().r(er0.class)) == null || !gr0Var.j()) {
            return;
        }
        int videoHeight = gr0Var.getVideoHeight() - er0Var.b().getTopMargin();
        if (!z && videoHeight < this.i / 2) {
            return;
        }
        int abs = Math.abs(videoHeight - this.i);
        if (videoHeight > this.i) {
            z2 = true;
        } else {
            z2 = false;
        }
        er0Var.f(z2, true, true, abs);
    }

    public final void J(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Object obj;
        le1<View> le1Var;
        ds0 a2 = ds0.f.a(jSONObject);
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
            y31.f(jSONObject3, "cmd_map", jSONObject2);
            ds0 ds0Var = this.e;
            if (ds0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            xd1 xd1Var = this.f;
            View view2 = null;
            if (xd1Var != null) {
                obj = xd1Var.a(jSONObject3);
            } else {
                obj = null;
            }
            ds0Var.c = obj;
            ds0 ds0Var2 = this.e;
            if (ds0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (ds0Var2.c == null) {
                return;
            }
            ds0 ds0Var3 = this.e;
            if (ds0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (ds0Var3.a != 2) {
                ds0 ds0Var4 = this.e;
                if (ds0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                if (ds0Var4.a != 3) {
                    ds0 ds0Var5 = this.e;
                    if (ds0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                    }
                    if (ds0Var5.a == 1) {
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            ds0 ds0Var6 = this.e;
            if (ds0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            if (ds0Var6.c == null) {
                return;
            }
            ds0 ds0Var7 = this.e;
            if (ds0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
            }
            xr0 c2 = xr0.c(y31.c(jSONObject.optString("download")));
            ds0Var7.d = c2;
            if (c2 != null) {
                c2.b = jSONObject.optString("deferred_cmd");
            }
            as0 as0Var = new as0();
            as0Var.a = ClogBuilder.Page.NAVIDEO_POP.type;
            as0Var.d = jSONObject.optString(MigrateStatisticUtils.EXT_INFO);
            Unit unit = Unit.INSTANCE;
            ds0Var7.e = as0Var;
            xd1 xd1Var2 = this.f;
            if (xd1Var2 != null) {
                le1Var = xd1Var2.b(getContext());
            } else {
                le1Var = null;
            }
            this.d = le1Var;
            if (le1Var == null) {
                d().w(this);
                return;
            }
            if (le1Var != null) {
                ds0 ds0Var8 = this.e;
                if (ds0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
                }
                le1Var.setData(ds0Var8);
                le1Var.setCriusPopListener(new a());
            }
            le1<View> le1Var2 = this.d;
            if (le1Var2 != null) {
                view2 = le1Var2.getRealView();
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
        le1<View> le1Var;
        View realView;
        ds0 ds0Var = this.e;
        if (ds0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popoverModel");
        }
        if (ds0Var.a != 3 || (le1Var = this.d) == null || (realView = le1Var.getRealView()) == null || !this.j || realView.getVisibility() != 0) {
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
        F(false);
    }

    public final void M(Intent intent) {
        xd1 xd1Var = (xd1) ServiceManager.getService(xd1.a);
        this.f = xd1Var;
        if (xd1Var == null) {
            d().w(this);
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
                ss0.t.a(y31.c(str2));
            }
            J(jSONObject);
            I();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void x(pk0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.x(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, uq0.class.getSimpleName())) {
            E((uq0) event);
        } else if (Intrinsics.areEqual(a2, tq0.class.getSimpleName())) {
            tq0 tq0Var = (tq0) event;
            K(tq0Var.c(), tq0Var.d(), tq0Var.b());
        } else if (Intrinsics.areEqual(a2, vq0.class.getSimpleName())) {
            D(((vq0) event).b());
        }
    }

    public final void N(as0 as0Var) {
        n41.e(new ClogBuilder().z(as0Var.c).v(as0Var.a).j(as0Var.b).p(as0Var.d).k(as0Var.e).l(as0Var.f).m(as0Var.g));
    }
}
