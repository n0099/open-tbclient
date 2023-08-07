package com.baidu.nadcore.max.uicomponent;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.nadcore.component.AbsComponentPlugin;
import com.baidu.nadcore.max.uiwidget.arrow.AdVideoImmersiveTipsView;
import com.baidu.nadcore.max.uiwidget.basic.WebViewContainer;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.b31;
import com.baidu.tieba.b71;
import com.baidu.tieba.cq0;
import com.baidu.tieba.dq0;
import com.baidu.tieba.eq0;
import com.baidu.tieba.fq0;
import com.baidu.tieba.hq0;
import com.baidu.tieba.jq0;
import com.baidu.tieba.ki0;
import com.baidu.tieba.nj0;
import com.baidu.tieba.up0;
import com.baidu.tieba.vp0;
import com.baidu.tieba.vr0;
import com.baidu.tieba.zp0;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\rJ\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\rJ\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\rJ\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u0015J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/ArrowGuideComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "", "progress", "duration", "handleTipsCountdown", "(II)V", "initGuideTipsView", "()V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/max/uiwidget/arrow/AdVideoImmersiveTipsView;", "guideView", "Lcom/baidu/nadcore/max/uiwidget/arrow/AdVideoImmersiveTipsView;", "", "hasShowGuideText", "Z", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class ArrowGuideComponent extends AbsComponentPlugin {
    public AdVideoImmersiveTipsView d;
    public boolean e;
    public vr0 f;

    /* loaded from: classes3.dex */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            hq0 hq0Var = (hq0) ArrowGuideComponent.this.d().r(hq0.class);
            if (hq0Var != null && hq0Var.j()) {
                fq0 fq0Var = (fq0) ArrowGuideComponent.this.d().r(fq0.class);
                if (fq0Var != null) {
                    fq0Var.i(false, true, false);
                }
            } else {
                fq0 fq0Var2 = (fq0) ArrowGuideComponent.this.d().r(fq0.class);
                if (fq0Var2 != null) {
                    fq0Var2.i(true, true, false);
                }
            }
            eq0 eq0Var = (eq0) ArrowGuideComponent.this.d().r(eq0.class);
            if (eq0Var != null) {
                String str = ClogBuilder.LogType.FREE_CLICK.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
                eq0Var.a(str, "learnmore");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrowGuideComponent.this.q();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        b71 animTimer;
        b71 countDownTimer;
        super.onPause();
        AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
        if (adVideoImmersiveTipsView != null && (countDownTimer = adVideoImmersiveTipsView.getCountDownTimer()) != null) {
            countDownTimer.b();
        }
        AdVideoImmersiveTipsView adVideoImmersiveTipsView2 = this.d;
        if (adVideoImmersiveTipsView2 != null && (animTimer = adVideoImmersiveTipsView2.getAnimTimer()) != null) {
            animTimer.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
        if (adVideoImmersiveTipsView != null) {
            adVideoImmersiveTipsView.j();
            ki0.g(adVideoImmersiveTipsView);
        }
        this.d = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void K(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.post(new b());
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        r(intent);
    }

    public final void r(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("map");
        String str = null;
        if (!(serializableExtra instanceof HashMap)) {
            serializableExtra = null;
        }
        HashMap hashMap = (HashMap) serializableExtra;
        if (hashMap != null) {
            Object obj = hashMap.get("cmd_policy");
            if (obj instanceof String) {
                str = obj;
            }
            String str2 = str;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f = vr0.t.a(b31.c(str2));
        }
    }

    public final void k(vp0 vp0Var) {
        b71 animTimer;
        b71 countDownTimer;
        b71 animTimer2;
        int i = jq0.$EnumSwitchMapping$0[vp0Var.getType().ordinal()];
        if (i != 1) {
            if (i == 2) {
                AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
                if (adVideoImmersiveTipsView != null) {
                    adVideoImmersiveTipsView.m(false);
                }
                AdVideoImmersiveTipsView adVideoImmersiveTipsView2 = this.d;
                if (adVideoImmersiveTipsView2 != null && (animTimer2 = adVideoImmersiveTipsView2.getAnimTimer()) != null) {
                    animTimer2.b();
                }
                AdVideoImmersiveTipsView adVideoImmersiveTipsView3 = this.d;
                if (adVideoImmersiveTipsView3 != null) {
                    adVideoImmersiveTipsView3.i(0.0f);
                    return;
                }
                return;
            }
            return;
        }
        AdVideoImmersiveTipsView adVideoImmersiveTipsView4 = this.d;
        if (adVideoImmersiveTipsView4 != null && (countDownTimer = adVideoImmersiveTipsView4.getCountDownTimer()) != null) {
            countDownTimer.c();
        }
        AdVideoImmersiveTipsView adVideoImmersiveTipsView5 = this.d;
        if (adVideoImmersiveTipsView5 != null && (animTimer = adVideoImmersiveTipsView5.getAnimTimer()) != null) {
            animTimer.c();
        }
        AdVideoImmersiveTipsView adVideoImmersiveTipsView6 = this.d;
        if (adVideoImmersiveTipsView6 != null) {
            adVideoImmersiveTipsView6.i(1.0f);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        b71 animTimer;
        b71 animTimer2;
        b71 countDownTimer;
        super.onResume();
        hq0 hq0Var = (hq0) d().r(hq0.class);
        if (hq0Var != null && hq0Var.j()) {
            AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
            if (adVideoImmersiveTipsView != null && (countDownTimer = adVideoImmersiveTipsView.getCountDownTimer()) != null) {
                countDownTimer.c();
            }
            AdVideoImmersiveTipsView adVideoImmersiveTipsView2 = this.d;
            if (adVideoImmersiveTipsView2 != null && (animTimer2 = adVideoImmersiveTipsView2.getAnimTimer()) != null) {
                animTimer2.c();
                return;
            }
            return;
        }
        AdVideoImmersiveTipsView adVideoImmersiveTipsView3 = this.d;
        if (adVideoImmersiveTipsView3 != null) {
            adVideoImmersiveTipsView3.m(false);
        }
        AdVideoImmersiveTipsView adVideoImmersiveTipsView4 = this.d;
        if (adVideoImmersiveTipsView4 != null && (animTimer = adVideoImmersiveTipsView4.getAnimTimer()) != null) {
            animTimer.b();
        }
    }

    public final void p(int i, int i2) {
        hq0 hq0Var;
        int i3;
        int i4;
        int i5;
        fq0 fq0Var = (fq0) d().r(fq0.class);
        if (fq0Var != null && (hq0Var = (hq0) d().r(hq0.class)) != null) {
            if (!fq0Var.g()) {
                vr0 vr0Var = this.f;
                if (vr0Var != null) {
                    i3 = vr0Var.a();
                } else {
                    i3 = 0;
                }
                if (i3 > 0) {
                    if (!this.e) {
                        int k = hq0Var.k();
                        vr0 vr0Var2 = this.f;
                        if (vr0Var2 != null) {
                            i4 = vr0Var2.a();
                        } else {
                            i4 = -1;
                        }
                        if (k >= i4 && (i5 = i2 - i) <= 4) {
                            AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
                            if (adVideoImmersiveTipsView != null) {
                                adVideoImmersiveTipsView.l(i5);
                            }
                            this.e = true;
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            AdVideoImmersiveTipsView adVideoImmersiveTipsView2 = this.d;
            if (adVideoImmersiveTipsView2 != null) {
                adVideoImmersiveTipsView2.m(false);
            }
        }
    }

    public final void q() {
        fq0 fq0Var;
        WebViewContainer b2;
        int i;
        vr0 vr0Var = this.f;
        if ((vr0Var == null || !vr0Var.t()) && this.d == null && (fq0Var = (fq0) d().r(fq0.class)) != null && (b2 = fq0Var.b()) != null) {
            cq0 a2 = dq0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "NadMaxRuntime.getUIProvider()");
            a2.a();
            int i2 = -1;
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.nad_max_bottom, (ViewGroup) b2, true);
            Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(cont…youtId, parentView, true)");
            AdVideoImmersiveTipsView adVideoImmersiveTipsView = (AdVideoImmersiveTipsView) inflate.findViewById(R.id.max_bottom_tip);
            if (adVideoImmersiveTipsView != null) {
                adVideoImmersiveTipsView.setOutClickListener(new a());
                vr0 vr0Var2 = this.f;
                if (vr0Var2 != null) {
                    i2 = vr0Var2.i();
                }
                vr0 vr0Var3 = this.f;
                if (vr0Var3 != null) {
                    i = vr0Var3.j();
                } else {
                    i = 0;
                }
                adVideoImmersiveTipsView.h(i2, i);
                Unit unit = Unit.INSTANCE;
            } else {
                adVideoImmersiveTipsView = null;
            }
            this.d = adVideoImmersiveTipsView;
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void t(nj0 event) {
        up0 up0Var;
        Intrinsics.checkNotNullParameter(event, "event");
        super.t(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, zp0.class.getSimpleName())) {
            if (!(event instanceof zp0)) {
                event = null;
            }
            zp0 zp0Var = (zp0) event;
            if (zp0Var != null) {
                p(zp0Var.c(), zp0Var.b());
            }
        } else if (Intrinsics.areEqual(a2, vp0.class.getSimpleName())) {
            k((vp0) event);
        } else if (Intrinsics.areEqual(a2, up0.class.getSimpleName())) {
            if (!(event instanceof up0)) {
                event = null;
            }
            if (((up0) event) != null) {
                float c = up0Var.c() / (up0Var.d() - up0Var.b());
                AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
                if (adVideoImmersiveTipsView != null) {
                    adVideoImmersiveTipsView.i(c);
                }
            }
        }
    }
}
