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
import com.baidu.tieba.es0;
import com.baidu.tieba.fq0;
import com.baidu.tieba.gq0;
import com.baidu.tieba.ij0;
import com.baidu.tieba.jk0;
import com.baidu.tieba.kq0;
import com.baidu.tieba.nq0;
import com.baidu.tieba.oq0;
import com.baidu.tieba.pq0;
import com.baidu.tieba.qq0;
import com.baidu.tieba.sq0;
import com.baidu.tieba.uq0;
import com.baidu.tieba.v61;
import com.baidu.tieba.z21;
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
    public es0 f;

    /* loaded from: classes3.dex */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            sq0 sq0Var = (sq0) ArrowGuideComponent.this.j().q(sq0.class);
            if (sq0Var != null && sq0Var.k()) {
                qq0 qq0Var = (qq0) ArrowGuideComponent.this.j().q(qq0.class);
                if (qq0Var != null) {
                    qq0Var.j(false, true, false);
                }
            } else {
                qq0 qq0Var2 = (qq0) ArrowGuideComponent.this.j().q(qq0.class);
                if (qq0Var2 != null) {
                    qq0Var2.j(true, true, false);
                }
            }
            pq0 pq0Var = (pq0) ArrowGuideComponent.this.j().q(pq0.class);
            if (pq0Var != null) {
                String str = ClogBuilder.LogType.FREE_CLICK.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
                pq0Var.a(str, "learnmore");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrowGuideComponent.this.r();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        v61 animTimer;
        v61 countDownTimer;
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
            ij0.g(adVideoImmersiveTipsView);
        }
        this.d = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void P(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.post(new b());
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        s(intent);
    }

    public final void s(Intent intent) {
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
            this.f = es0.q.a(z21.c(str2));
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        v61 animTimer;
        v61 animTimer2;
        v61 countDownTimer;
        super.onResume();
        sq0 sq0Var = (sq0) j().q(sq0.class);
        if (sq0Var != null && sq0Var.k()) {
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

    public final void p(gq0 gq0Var) {
        v61 animTimer;
        v61 countDownTimer;
        v61 animTimer2;
        int i = uq0.$EnumSwitchMapping$0[gq0Var.getType().ordinal()];
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

    public final void q(int i, int i2) {
        sq0 sq0Var;
        int i3;
        int i4;
        int i5;
        qq0 qq0Var = (qq0) j().q(qq0.class);
        if (qq0Var != null && (sq0Var = (sq0) j().q(sq0.class)) != null) {
            if (!qq0Var.g()) {
                es0 es0Var = this.f;
                if (es0Var != null) {
                    i3 = es0Var.a();
                } else {
                    i3 = 0;
                }
                if (i3 > 0) {
                    if (!this.e) {
                        int l = sq0Var.l();
                        es0 es0Var2 = this.f;
                        if (es0Var2 != null) {
                            i4 = es0Var2.a();
                        } else {
                            i4 = -1;
                        }
                        if (l >= i4 && (i5 = i2 - i) <= 4) {
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

    public final void r() {
        qq0 qq0Var;
        WebViewContainer b2;
        int i;
        es0 es0Var = this.f;
        if ((es0Var == null || !es0Var.q()) && this.d == null && (qq0Var = (qq0) j().q(qq0.class)) != null && (b2 = qq0Var.b()) != null) {
            nq0 a2 = oq0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "NadMaxRuntime.getUIProvider()");
            a2.a();
            int i2 = -1;
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.nad_max_bottom, (ViewGroup) b2, true);
            Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(cont…youtId, parentView, true)");
            AdVideoImmersiveTipsView adVideoImmersiveTipsView = (AdVideoImmersiveTipsView) inflate.findViewById(R.id.max_bottom_tip);
            if (adVideoImmersiveTipsView != null) {
                adVideoImmersiveTipsView.setOutClickListener(new a());
                es0 es0Var2 = this.f;
                if (es0Var2 != null) {
                    i2 = es0Var2.i();
                }
                es0 es0Var3 = this.f;
                if (es0Var3 != null) {
                    i = es0Var3.j();
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
    public void w(jk0 event) {
        fq0 fq0Var;
        Intrinsics.checkNotNullParameter(event, "event");
        super.w(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, kq0.class.getSimpleName())) {
            if (!(event instanceof kq0)) {
                event = null;
            }
            kq0 kq0Var = (kq0) event;
            if (kq0Var != null) {
                q(kq0Var.c(), kq0Var.b());
            }
        } else if (Intrinsics.areEqual(a2, gq0.class.getSimpleName())) {
            p((gq0) event);
        } else if (Intrinsics.areEqual(a2, fq0.class.getSimpleName())) {
            if (!(event instanceof fq0)) {
                event = null;
            }
            if (((fq0) event) != null) {
                float c = fq0Var.c() / (fq0Var.d() - fq0Var.b());
                AdVideoImmersiveTipsView adVideoImmersiveTipsView = this.d;
                if (adVideoImmersiveTipsView != null) {
                    adVideoImmersiveTipsView.i(c);
                }
            }
        }
    }
}
