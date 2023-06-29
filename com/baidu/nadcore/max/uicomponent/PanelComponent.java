package com.baidu.nadcore.max.uicomponent;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.nadcore.component.AbsComponentPlugin;
import com.baidu.nadcore.max.event.PanelEventTypeEnum;
import com.baidu.nadcore.max.uicomponent.PanelComponent$panelService$2;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.as0;
import com.baidu.tieba.c31;
import com.baidu.tieba.dr0;
import com.baidu.tieba.fs0;
import com.baidu.tieba.g61;
import com.baidu.tieba.hs0;
import com.baidu.tieba.jq0;
import com.baidu.tieba.lj0;
import com.baidu.tieba.lq0;
import com.baidu.tieba.m61;
import com.baidu.tieba.mk0;
import com.baidu.tieba.mr0;
import com.baidu.tieba.pr0;
import com.baidu.tieba.qq0;
import com.baidu.tieba.qr0;
import com.baidu.tieba.rq0;
import com.baidu.tieba.rr0;
import com.baidu.tieba.se1;
import com.baidu.tieba.sq0;
import com.baidu.tieba.tq0;
import com.baidu.tieba.tr0;
import com.baidu.tieba.ue1;
import com.baidu.tieba.uq0;
import com.baidu.tieba.vq0;
import com.baidu.tieba.xj0;
import com.baidu.tieba.y61;
import com.baidu.tieba.zq0;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001]B\u0007¢\u0006\u0004\b\\\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u0017\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001f\u0010\u001bJ\u0017\u0010!\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u001d\u0010'\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b2\u0010.R\u001e\u00105\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bE\u0010AR\u0016\u0010F\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u001d\u0010M\u001a\u00020H8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0018\u0010N\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010AR\u0018\u0010P\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bU\u0010.R\u0018\u0010W\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Z\u001a\u00020Y8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006^"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PanelComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "initClickListener", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initEnhanceData", "(Lorg/json/JSONObject;)V", "initPanelInfo", "initPanelPosition", "initPanelUI", "injectService", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", MissionEvent.MESSAGE_DESTROY, "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "", "duration", "", MapBundleKey.MapObjKey.OBJ_SL_VISI, "setUserInfoAreaVisible", "(JZ)V", "Lcom/baidu/nadcore/widget/AdImageView;", "authorAvatar", "Lcom/baidu/nadcore/widget/AdImageView;", "Landroid/widget/TextView;", "authorAvatarText", "Landroid/widget/TextView;", "Landroid/widget/LinearLayout;", "authorContainer", "Landroid/widget/LinearLayout;", "authorName", "Lcom/baidu/nadcore/widget/uiwidget/IEnhancementBtnView;", "Landroid/view/View;", "enhanceButtonView", "Lcom/baidu/nadcore/widget/uiwidget/IEnhancementBtnView;", "Lcom/baidu/nadcore/model/AdLpParams$EnhanceModel;", "enhanceModel", "Lcom/baidu/nadcore/model/AdLpParams$EnhanceModel;", "isFinishEnhanceAnim", "Z", "isNagivationBarChange", "", "navigationBarHeight", "Ljava/lang/Integer;", "panelBgView", "Landroid/view/View;", "Lcom/baidu/nadcore/model/AdLpParams$PanelModel;", "panelModel", "Lcom/baidu/nadcore/model/AdLpParams$PanelModel;", "panelRoot", "panelRootBottom", "I", "Lcom/baidu/nadcore/max/service/IPanelService;", "panelService$delegate", "Lkotlin/Lazy;", "getPanelService", "()Lcom/baidu/nadcore/max/service/IPanelService;", "panelService", "parentRoot", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "title", "Landroid/view/animation/AlphaAnimation;", "userInfoAreaAnimation", "Landroid/view/animation/AlphaAnimation;", "Landroid/widget/RelativeLayout;", "userInfoContainer", "Landroid/widget/RelativeLayout;", "<init>", "EnhanceBtnListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class PanelComponent extends AbsComponentPlugin {
    public hs0 d;
    public rr0 e;
    public qr0 f;
    public View g;
    public TextView h;
    public RelativeLayout i;
    public LinearLayout j;
    public AdImageView k;
    public TextView l;
    public TextView m;
    public View n;
    public ue1<View> o;
    public boolean p;
    public AlphaAnimation q;
    public y61 r;
    public int s;
    public boolean t;
    public Integer u;
    public View v;
    public final Lazy w = LazyKt__LazyJVMKt.lazy(new Function0<PanelComponent$panelService$2.a>() { // from class: com.baidu.nadcore.max.uicomponent.PanelComponent$panelService$2
        {
            super(0);
        }

        /* loaded from: classes3.dex */
        public static final class a implements uq0 {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.uq0
            public void d(long j, boolean z) {
                PanelComponent.this.W(j, z);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return new a();
        }
    });

    public final uq0 M() {
        return (uq0) this.w.getValue();
    }

    /* loaded from: classes3.dex */
    public final class a extends se1 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.se1
        public void a(String str) {
            sq0 sq0Var = (sq0) PanelComponent.this.j().q(sq0.class);
            if (sq0Var != null) {
                String str2 = ClogBuilder.LogType.FREE_CLICK.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.LogType.FREE_CLICK.type");
                if (str == null) {
                    str = "";
                }
                sq0Var.a(str2, str);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.tieba.se1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(as0 clickBean) {
            boolean z;
            boolean z2;
            sq0 sq0Var;
            String str;
            Intrinsics.checkNotNullParameter(clickBean, "clickBean");
            if (clickBean.c) {
                qr0 qr0Var = PanelComponent.this.f;
                if (qr0Var == null || qr0Var.a != 1) {
                    hs0 hs0Var = PanelComponent.this.d;
                    if (hs0Var != null) {
                        z = hs0Var.q();
                    } else {
                        z = false;
                    }
                    if (!z) {
                        z2 = false;
                        if (!z2) {
                            qr0 qr0Var2 = PanelComponent.this.f;
                            if (qr0Var2 != null) {
                                str = qr0Var2.t;
                            } else {
                                str = null;
                            }
                            xj0.c(str, PanelComponent.this.getContext());
                        } else {
                            tq0 tq0Var = (tq0) PanelComponent.this.j().q(tq0.class);
                            if (tq0Var != null) {
                                tq0Var.j(false, true, false);
                            }
                        }
                        PanelComponent.this.j().g(new lq0(PanelEventTypeEnum.CLICK_PANEL_UI));
                        sq0Var = (sq0) PanelComponent.this.j().q(sq0.class);
                        if (sq0Var == null) {
                            String str2 = ClogBuilder.LogType.FREE_CLICK.type;
                            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.LogType.FREE_CLICK.type");
                            sq0Var.a(str2, NativeConstants.ID_BUTTON);
                            return;
                        }
                        return;
                    }
                }
                z2 = true;
                if (!z2) {
                }
                PanelComponent.this.j().g(new lq0(PanelEventTypeEnum.CLICK_PANEL_UI));
                sq0Var = (sq0) PanelComponent.this.j().q(sq0.class);
                if (sq0Var == null) {
                }
            } else {
                PanelComponent.this.j().g(new lq0(PanelEventTypeEnum.CLICK_PANEL_UI));
            }
        }

        @Override // com.baidu.tieba.se1
        public void d() {
            PanelComponent.this.p = true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View v) {
            String str;
            tq0 tq0Var;
            Intrinsics.checkNotNullExpressionValue(v, "v");
            int id = v.getId();
            if (id == R.id.ad_video_title) {
                str = "title";
            } else if (id != R.id.ad_author_avatar && id != R.id.ad_author_avatar_txt) {
                if (id == R.id.ad_author_name) {
                    str = "name";
                } else {
                    return;
                }
            } else {
                str = "icon";
            }
            hs0 hs0Var = PanelComponent.this.d;
            if (hs0Var != null && !hs0Var.q() && (tq0Var = (tq0) PanelComponent.this.j().q(tq0.class)) != null) {
                tq0Var.j(false, true, false);
            }
            PanelComponent.this.j().g(new lq0(PanelEventTypeEnum.CLICK_PANEL_UI));
            sq0 sq0Var = (sq0) PanelComponent.this.j().q(sq0.class);
            if (sq0Var != null) {
                String str2 = ClogBuilder.LogType.FREE_CLICK.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.LogType.FREE_CLICK.type");
                sq0Var.a(str2, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends y61.b {
        @Override // com.baidu.tieba.y61.b
        public void e() {
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // com.baidu.tieba.y61.b
        public void f(long j) {
            float rint = (float) Math.rint(((float) (100000 - j)) / 1000);
            if (PanelComponent.this.p) {
                y61 y61Var = PanelComponent.this.r;
                if (y61Var != null) {
                    y61Var.a();
                }
                PanelComponent.this.r = null;
                return;
            }
            ue1 ue1Var = PanelComponent.this.o;
            if (ue1Var != null) {
                ue1Var.update((int) rint);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements View.OnApplyWindowInsetsListener {
        public d() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
            View u;
            int i;
            Integer num = PanelComponent.this.u;
            if (num != null) {
                if (num.intValue() != m61.d(PanelComponent.this.b())) {
                    PanelComponent panelComponent = PanelComponent.this;
                    panelComponent.u = Integer.valueOf(m61.d(panelComponent.b()));
                    if (PanelComponent.this.t && (u = PanelComponent.u(PanelComponent.this)) != null) {
                        int paddingLeft = u.getPaddingLeft();
                        int paddingTop = u.getPaddingTop();
                        int paddingRight = u.getPaddingRight();
                        int i2 = PanelComponent.this.s;
                        Integer num2 = PanelComponent.this.u;
                        if (num2 != null) {
                            i = num2.intValue();
                        } else {
                            i = 0;
                        }
                        u.setPadding(paddingLeft, paddingTop, paddingRight, i2 + i);
                    }
                } else {
                    PanelComponent.this.t = true;
                }
            } else {
                PanelComponent panelComponent2 = PanelComponent.this;
                panelComponent2.u = Integer.valueOf(m61.d(panelComponent2.b()));
            }
            return view2.onApplyWindowInsets(windowInsets);
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            PanelComponent.this.L();
            y61 y61Var = PanelComponent.this.r;
            if (y61Var != null) {
                y61Var.e();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void A() {
        super.A();
        j().t(uq0.class, M());
    }

    public final void L() {
        vq0 vq0Var = (vq0) j().q(vq0.class);
        if (vq0Var != null) {
            View view2 = this.g;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
            }
            lj0.g(view2);
            FrameLayout h = vq0Var.h();
            if (h != null) {
                h.addView(view2);
            }
        }
    }

    public final void Q() {
        y61 y61Var = new y61(100000L, 1000L);
        y61Var.d(new c());
        this.r = y61Var;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onDestroy() {
        View view2;
        super.onDestroy();
        if (m61.f() && Build.VERSION.SDK_INT >= 20 && (view2 = this.v) != null) {
            view2.setOnApplyWindowInsetsListener(null);
        }
        y61 y61Var = this.r;
        if (y61Var != null) {
            y61Var.a();
        }
        this.r = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        y61 y61Var = this.r;
        if (y61Var != null) {
            y61Var.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        ue1<View> ue1Var = this.o;
        if (ue1Var != null) {
            ue1Var.a();
        }
        this.o = null;
        AlphaAnimation alphaAnimation = this.q;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
        this.q = null;
        View view2 = this.g;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
        }
        lj0.g(view2);
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        y61 y61Var;
        super.onResume();
        vq0 vq0Var = (vq0) j().q(vq0.class);
        if (vq0Var != null && vq0Var.k() && (y61Var = this.r) != null) {
            y61Var.c();
        }
    }

    public static final /* synthetic */ View u(PanelComponent panelComponent) {
        View view2 = panelComponent.g;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
        }
        return view2;
    }

    public final void N(jq0 jq0Var) {
        y61 y61Var;
        int i = zq0.$EnumSwitchMapping$0[jq0Var.getType().ordinal()];
        if (i != 1) {
            if (i == 2 && (y61Var = this.r) != null) {
                y61Var.b();
                return;
            }
            return;
        }
        y61 y61Var2 = this.r;
        if (y61Var2 != null) {
            y61Var2.c();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void P(ViewGroup parent) {
        View view2;
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.v = parent;
        if (m61.f() && Build.VERSION.SDK_INT >= 20 && (view2 = this.v) != null) {
            view2.setOnApplyWindowInsetsListener(new d());
        }
        parent.post(new e());
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        U();
        V(intent);
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void x(mk0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.x(event);
        if (Intrinsics.areEqual(event.a(), jq0.class.getSimpleName())) {
            N((jq0) event);
        }
    }

    public final void O() {
        b bVar = new b();
        AdImageView adImageView = this.k;
        if (adImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorAvatar");
        }
        adImageView.setOnClickListener(bVar);
        TextView textView = this.l;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorAvatarText");
        }
        textView.setOnClickListener(bVar);
        TextView textView2 = this.m;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorName");
        }
        textView2.setOnClickListener(bVar);
        TextView textView3 = this.h;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
        }
        textView3.setOnClickListener(bVar);
        View view2 = this.g;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
        }
        view2.setOnClickListener(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void R(JSONObject jSONObject) {
        int i;
        mr0 c2;
        List<tr0> list;
        boolean z;
        View view2;
        ue1<View> ue1Var;
        ue1<View> ue1Var2;
        ue1<View> ue1Var3;
        ue1<View> ue1Var4;
        String appStr;
        ue1<View> ue1Var5;
        qr0 a2 = qr0.u.a(jSONObject);
        if (a2 != null) {
            this.f = a2;
            if (a2 != null) {
                String optString = jSONObject.optString("type");
                boolean z2 = true;
                if (optString != null) {
                    int hashCode = optString.hashCode();
                    if (hashCode != -1335224239) {
                        if (hashCode != -1183693704) {
                            if (hashCode == 1427818632 && optString.equals("download")) {
                                i = 2;
                            }
                        } else if (optString.equals(DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST)) {
                            i = 1;
                        }
                        a2.a = i;
                        c2 = mr0.c(c31.c(jSONObject.optString("download")));
                        a2.p = c2;
                        if (c2 != null) {
                            c2.b = jSONObject.optString("deferred_cmd");
                        }
                        pr0 pr0Var = new pr0();
                        pr0Var.a = ClogBuilder.Page.PAGE_VIDEO_IMMERSIVE_LP.type;
                        pr0Var.d = jSONObject.optString(MigrateStatisticUtils.EXT_INFO);
                        Unit unit = Unit.INSTANCE;
                        a2.q = pr0Var;
                        list = a2.o;
                        if (list == null && !list.isEmpty()) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            this.p = true;
                        }
                        view2 = this.g;
                        if (view2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
                        }
                        ue1Var = (ue1) view2.findViewById(R.id.max_ebtn);
                        this.o = ue1Var;
                        if (ue1Var != null) {
                            View view3 = this.g;
                            if (view3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
                            }
                            ue1Var.setBtnPlaceholder(view3.findViewById(R.id.ad_video_btn_placeholder));
                        }
                        ue1Var2 = this.o;
                        if (ue1Var2 != null) {
                            ue1Var2.setVisible(0);
                        }
                        ue1Var3 = this.o;
                        if (ue1Var3 != null) {
                            ue1Var3.setBtnIconNightModeEnable(false);
                        }
                        ue1Var4 = this.o;
                        if (ue1Var4 != null) {
                            ue1Var4.setEnhanceBtnListener(new a());
                        }
                        appStr = jSONObject.optString("app_info");
                        Intrinsics.checkNotNullExpressionValue(appStr, "appStr");
                        if (appStr.length() <= 0) {
                            z2 = false;
                        }
                        if (z2) {
                            a2.s = fs0.c(c31.c(appStr));
                        }
                        ue1Var5 = this.o;
                        if (ue1Var5 == null) {
                            ue1Var5.setData(a2);
                            return;
                        }
                        return;
                    }
                    optString.equals("detail");
                }
                i = 0;
                a2.a = i;
                c2 = mr0.c(c31.c(jSONObject.optString("download")));
                a2.p = c2;
                if (c2 != null) {
                }
                pr0 pr0Var2 = new pr0();
                pr0Var2.a = ClogBuilder.Page.PAGE_VIDEO_IMMERSIVE_LP.type;
                pr0Var2.d = jSONObject.optString(MigrateStatisticUtils.EXT_INFO);
                Unit unit2 = Unit.INSTANCE;
                a2.q = pr0Var2;
                list = a2.o;
                if (list == null) {
                }
                z = true;
                if (z) {
                }
                view2 = this.g;
                if (view2 == null) {
                }
                ue1Var = (ue1) view2.findViewById(R.id.max_ebtn);
                this.o = ue1Var;
                if (ue1Var != null) {
                }
                ue1Var2 = this.o;
                if (ue1Var2 != null) {
                }
                ue1Var3 = this.o;
                if (ue1Var3 != null) {
                }
                ue1Var4 = this.o;
                if (ue1Var4 != null) {
                }
                appStr = jSONObject.optString("app_info");
                Intrinsics.checkNotNullExpressionValue(appStr, "appStr");
                if (appStr.length() <= 0) {
                }
                if (z2) {
                }
                ue1Var5 = this.o;
                if (ue1Var5 == null) {
                }
            }
        }
    }

    public final void S() {
        String str;
        rr0 rr0Var = this.e;
        if (rr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelModel");
        }
        if (!TextUtils.isEmpty(rr0Var.c)) {
            TextView textView = this.l;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorAvatarText");
            }
            textView.setVisibility(8);
            AdImageView adImageView = this.k;
            if (adImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorAvatar");
            }
            rr0 rr0Var2 = this.e;
            if (rr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelModel");
            }
            adImageView.o(rr0Var2.c);
            AdImageView adImageView2 = this.k;
            if (adImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorAvatar");
            }
            adImageView2.setVisibility(0);
        } else {
            rr0 rr0Var3 = this.e;
            if (rr0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelModel");
            }
            if (!TextUtils.isEmpty(rr0Var3.b)) {
                AdImageView adImageView3 = this.k;
                if (adImageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authorAvatar");
                }
                adImageView3.setVisibility(8);
                TextView textView2 = this.l;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authorAvatarText");
                }
                rr0 rr0Var4 = this.e;
                if (rr0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelModel");
                }
                String str2 = rr0Var4.b;
                if (str2 != null) {
                    if (str2 != null) {
                        str = str2.substring(0, 1);
                        Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    str = null;
                }
                textView2.setText(str);
                TextView textView3 = this.l;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authorAvatarText");
                }
                textView3.setVisibility(0);
            } else {
                AdImageView adImageView4 = this.k;
                if (adImageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authorAvatar");
                }
                adImageView4.setVisibility(8);
                TextView textView4 = this.l;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authorAvatarText");
                }
                textView4.setVisibility(8);
            }
        }
        rr0 rr0Var5 = this.e;
        if (rr0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelModel");
        }
        if (!TextUtils.isEmpty(rr0Var5.b)) {
            TextView textView5 = this.m;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorName");
            }
            rr0 rr0Var6 = this.e;
            if (rr0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelModel");
            }
            textView5.setText(rr0Var6.b);
        }
        rr0 rr0Var7 = this.e;
        if (rr0Var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelModel");
        }
        if (!TextUtils.isEmpty(rr0Var7.a)) {
            TextView textView6 = this.h;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
            }
            rr0 rr0Var8 = this.e;
            if (rr0Var8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelModel");
            }
            textView6.setText(rr0Var8.a);
            return;
        }
        TextView textView7 = this.h;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
        }
        textView7.setVisibility(8);
    }

    public final void T(JSONObject jSONObject) {
        boolean z;
        String optString = jSONObject.optString(WriteActivityConfig.VIDEO_INFO);
        if (optString != null && optString.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        boolean areEqual = Intrinsics.areEqual("1", new JSONObject(optString).optString("video_stretch_switch", "0"));
        int f = dr0.a.f(g61.c.c(getContext()) / g61.c.e(getContext()), areEqual);
        View view2 = this.n;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelBgView");
        }
        view2.getLayoutParams().height = f;
    }

    public final void V(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("map");
        String str = null;
        if (!(serializableExtra instanceof HashMap)) {
            serializableExtra = null;
        }
        HashMap hashMap = (HashMap) serializableExtra;
        if (hashMap != null) {
            JSONObject jSONObject = new JSONObject(hashMap);
            rr0 a2 = rr0.d.a(jSONObject);
            if (a2 != null) {
                this.e = a2;
                Object obj = hashMap.get("cmd_policy");
                if (obj instanceof String) {
                    str = obj;
                }
                String str2 = str;
                if (!TextUtils.isEmpty(str2)) {
                    this.d = hs0.q.a(c31.c(str2));
                }
                T(jSONObject);
                S();
                R(jSONObject);
                O();
                Q();
                return;
            }
            j().v(this);
        }
    }

    public final void U() {
        qq0 a2 = rq0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadMaxRuntime.getUIProvider()");
        a2.c();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.nad_max_over_info_vertical, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(cont…).inflate(layoutId, null)");
        this.g = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
        }
        this.s = inflate.getPaddingBottom();
        View view2 = this.g;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
        }
        View findViewById = view2.findViewById(R.id.ad_video_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_video_title)");
        this.h = (TextView) findViewById;
        View findViewById2 = view2.findViewById(R.id.ad_video_info);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.ad_video_info)");
        this.i = (RelativeLayout) findViewById2;
        View findViewById3 = view2.findViewById(R.id.ad_author_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.ad_author_container)");
        this.j = (LinearLayout) findViewById3;
        View findViewById4 = view2.findViewById(R.id.ad_author_avatar);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.ad_author_avatar)");
        this.k = (AdImageView) findViewById4;
        View findViewById5 = view2.findViewById(R.id.ad_author_avatar_txt);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.ad_author_avatar_txt)");
        this.l = (TextView) findViewById5;
        View findViewById6 = view2.findViewById(R.id.ad_author_name);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.ad_author_name)");
        this.m = (TextView) findViewById6;
        View findViewById7 = view2.findViewById(R.id.ad_panel_constant_bg);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.ad_panel_constant_bg)");
        this.n = findViewById7;
    }

    public final void W(long j, boolean z) {
        AlphaAnimation alphaAnimation;
        AlphaAnimation alphaAnimation2 = this.q;
        if (alphaAnimation2 != null) {
            alphaAnimation2.cancel();
        }
        this.q = null;
        if (z) {
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        } else {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        }
        this.q = alphaAnimation;
        if (alphaAnimation != null) {
            alphaAnimation.setDuration(j);
        }
        AlphaAnimation alphaAnimation3 = this.q;
        if (alphaAnimation3 != null) {
            alphaAnimation3.setFillAfter(true);
        }
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userInfoContainer");
        }
        relativeLayout.startAnimation(this.q);
    }
}
