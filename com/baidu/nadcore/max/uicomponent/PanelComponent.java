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
import com.baidu.tieba.a21;
import com.baidu.tieba.am0;
import com.baidu.tieba.be0;
import com.baidu.tieba.bm0;
import com.baidu.tieba.ef0;
import com.baidu.tieba.fm0;
import com.baidu.tieba.in0;
import com.baidu.tieba.jm0;
import com.baidu.tieba.ly0;
import com.baidu.tieba.nn0;
import com.baidu.tieba.o21;
import com.baidu.tieba.pe0;
import com.baidu.tieba.pl0;
import com.baidu.tieba.pn0;
import com.baidu.tieba.rl0;
import com.baidu.tieba.sm0;
import com.baidu.tieba.t11;
import com.baidu.tieba.vm0;
import com.baidu.tieba.w81;
import com.baidu.tieba.wl0;
import com.baidu.tieba.wm0;
import com.baidu.tieba.xl0;
import com.baidu.tieba.xm0;
import com.baidu.tieba.y81;
import com.baidu.tieba.yl0;
import com.baidu.tieba.zl0;
import com.baidu.tieba.zm0;
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
    public pn0 d;
    public xm0 e;
    public wm0 f;
    public View g;
    public TextView h;
    public RelativeLayout i;
    public LinearLayout j;
    public AdImageView k;
    public TextView l;
    public TextView m;
    public View n;
    public y81<View> o;
    public boolean p;
    public AlphaAnimation q;
    public o21 r;
    public int s;
    public boolean t;
    public Integer u;
    public View v;
    public final Lazy w = LazyKt__LazyJVMKt.lazy(new Function0<PanelComponent$panelService$2.a>() { // from class: com.baidu.nadcore.max.uicomponent.PanelComponent$panelService$2
        {
            super(0);
        }

        /* loaded from: classes3.dex */
        public static final class a implements am0 {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.am0
            public void d(long j, boolean z) {
                PanelComponent.this.X(j, z);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return new a();
        }
    });

    public final am0 O() {
        return (am0) this.w.getValue();
    }

    /* loaded from: classes3.dex */
    public final class a extends w81 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.w81
        public void a(String str) {
            yl0 yl0Var = (yl0) PanelComponent.this.g().q(yl0.class);
            if (yl0Var != null) {
                String str2 = ClogBuilder.LogType.FREE_CLICK.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.LogType.FREE_CLICK.type");
                if (str == null) {
                    str = "";
                }
                yl0Var.a(str2, str);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.tieba.w81
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(in0 clickBean) {
            boolean z;
            boolean z2;
            yl0 yl0Var;
            String str;
            Intrinsics.checkNotNullParameter(clickBean, "clickBean");
            if (clickBean.c) {
                wm0 wm0Var = PanelComponent.this.f;
                if (wm0Var == null || wm0Var.a != 1) {
                    pn0 pn0Var = PanelComponent.this.d;
                    if (pn0Var != null) {
                        z = pn0Var.t();
                    } else {
                        z = false;
                    }
                    if (!z) {
                        z2 = false;
                        if (!z2) {
                            wm0 wm0Var2 = PanelComponent.this.f;
                            if (wm0Var2 != null) {
                                str = wm0Var2.t;
                            } else {
                                str = null;
                            }
                            pe0.c(str, PanelComponent.this.b());
                        } else {
                            zl0 zl0Var = (zl0) PanelComponent.this.g().q(zl0.class);
                            if (zl0Var != null) {
                                zl0Var.i(false, true, false);
                            }
                        }
                        PanelComponent.this.g().j(new rl0(PanelEventTypeEnum.CLICK_PANEL_UI));
                        yl0Var = (yl0) PanelComponent.this.g().q(yl0.class);
                        if (yl0Var == null) {
                            String str2 = ClogBuilder.LogType.FREE_CLICK.type;
                            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.LogType.FREE_CLICK.type");
                            yl0Var.a(str2, NativeConstants.ID_BUTTON);
                            return;
                        }
                        return;
                    }
                }
                z2 = true;
                if (!z2) {
                }
                PanelComponent.this.g().j(new rl0(PanelEventTypeEnum.CLICK_PANEL_UI));
                yl0Var = (yl0) PanelComponent.this.g().q(yl0.class);
                if (yl0Var == null) {
                }
            } else {
                PanelComponent.this.g().j(new rl0(PanelEventTypeEnum.CLICK_PANEL_UI));
            }
        }

        @Override // com.baidu.tieba.w81
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
            zl0 zl0Var;
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
            pn0 pn0Var = PanelComponent.this.d;
            if (pn0Var != null && !pn0Var.t() && (zl0Var = (zl0) PanelComponent.this.g().q(zl0.class)) != null) {
                zl0Var.i(false, true, false);
            }
            PanelComponent.this.g().j(new rl0(PanelEventTypeEnum.CLICK_PANEL_UI));
            yl0 yl0Var = (yl0) PanelComponent.this.g().q(yl0.class);
            if (yl0Var != null) {
                String str2 = ClogBuilder.LogType.FREE_CLICK.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.LogType.FREE_CLICK.type");
                yl0Var.a(str2, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends o21.b {
        @Override // com.baidu.tieba.o21.b
        public void e() {
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // com.baidu.tieba.o21.b
        public void f(long j) {
            float rint = (float) Math.rint(((float) (100000 - j)) / 1000);
            if (PanelComponent.this.p) {
                o21 o21Var = PanelComponent.this.r;
                if (o21Var != null) {
                    o21Var.a();
                }
                PanelComponent.this.r = null;
                return;
            }
            y81 y81Var = PanelComponent.this.o;
            if (y81Var != null) {
                y81Var.update((int) rint);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements View.OnApplyWindowInsetsListener {
        public d() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
            View w;
            int i;
            Integer num = PanelComponent.this.u;
            if (num != null) {
                if (num.intValue() != a21.d(PanelComponent.this.d())) {
                    PanelComponent panelComponent = PanelComponent.this;
                    panelComponent.u = Integer.valueOf(a21.d(panelComponent.d()));
                    if (PanelComponent.this.t && (w = PanelComponent.w(PanelComponent.this)) != null) {
                        int paddingLeft = w.getPaddingLeft();
                        int paddingTop = w.getPaddingTop();
                        int paddingRight = w.getPaddingRight();
                        int i2 = PanelComponent.this.s;
                        Integer num2 = PanelComponent.this.u;
                        if (num2 != null) {
                            i = num2.intValue();
                        } else {
                            i = 0;
                        }
                        w.setPadding(paddingLeft, paddingTop, paddingRight, i2 + i);
                    }
                } else {
                    PanelComponent.this.t = true;
                }
            } else {
                PanelComponent panelComponent2 = PanelComponent.this;
                panelComponent2.u = Integer.valueOf(a21.d(panelComponent2.d()));
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
            PanelComponent.this.N();
            o21 o21Var = PanelComponent.this.r;
            if (o21Var != null) {
                o21Var.e();
            }
        }
    }

    public final void N() {
        bm0 bm0Var = (bm0) g().q(bm0.class);
        if (bm0Var != null) {
            View view2 = this.g;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
            }
            be0.g(view2);
            FrameLayout videoHolder = bm0Var.getVideoHolder();
            if (videoHolder != null) {
                videoHolder.addView(view2);
            }
        }
    }

    public final void R() {
        o21 o21Var = new o21(100000L, 1000L);
        o21Var.d(new c());
        this.r = o21Var;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onDestroy() {
        View view2;
        super.onDestroy();
        if (a21.f() && Build.VERSION.SDK_INT >= 20 && (view2 = this.v) != null) {
            view2.setOnApplyWindowInsetsListener(null);
        }
        o21 o21Var = this.r;
        if (o21Var != null) {
            o21Var.a();
        }
        this.r = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        o21 o21Var = this.r;
        if (o21Var != null) {
            o21Var.b();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        y81<View> y81Var = this.o;
        if (y81Var != null) {
            y81Var.a();
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
        be0.g(view2);
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        o21 o21Var;
        super.onResume();
        bm0 bm0Var = (bm0) g().q(bm0.class);
        if (bm0Var != null && bm0Var.j() && (o21Var = this.r) != null) {
            o21Var.c();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void y() {
        super.y();
        g().w(am0.class, O());
    }

    public static final /* synthetic */ View w(PanelComponent panelComponent) {
        View view2 = panelComponent.g;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
        }
        return view2;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void L(ViewGroup parent) {
        View view2;
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.v = parent;
        if (a21.f() && Build.VERSION.SDK_INT >= 20 && (view2 = this.v) != null) {
            view2.setOnApplyWindowInsetsListener(new d());
        }
        parent.post(new e());
    }

    public final void P(pl0 pl0Var) {
        o21 o21Var;
        int i = fm0.$EnumSwitchMapping$0[pl0Var.b().ordinal()];
        if (i != 1) {
            if (i == 2 && (o21Var = this.r) != null) {
                o21Var.b();
                return;
            }
            return;
        }
        o21 o21Var2 = this.r;
        if (o21Var2 != null) {
            o21Var2.c();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        V();
        W(intent);
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void s(ef0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.s(event);
        if (Intrinsics.areEqual(event.a(), pl0.class.getSimpleName())) {
            P((pl0) event);
        }
    }

    public final void Q() {
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
    public final void S(JSONObject jSONObject) {
        int i;
        sm0 c2;
        List<zm0> list;
        boolean z;
        View view2;
        y81<View> y81Var;
        y81<View> y81Var2;
        y81<View> y81Var3;
        y81<View> y81Var4;
        String appStr;
        y81<View> y81Var5;
        wm0 a2 = wm0.v.a(jSONObject);
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
                        c2 = sm0.c(ly0.c(jSONObject.optString("download")));
                        a2.p = c2;
                        if (c2 != null) {
                            c2.b = jSONObject.optString("deferred_cmd");
                        }
                        vm0 vm0Var = new vm0();
                        vm0Var.a = ClogBuilder.Page.PAGE_VIDEO_IMMERSIVE_LP.type;
                        vm0Var.d = jSONObject.optString(MigrateStatisticUtils.EXT_INFO);
                        Unit unit = Unit.INSTANCE;
                        a2.q = vm0Var;
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
                        y81Var = (y81) view2.findViewById(R.id.max_ebtn);
                        this.o = y81Var;
                        if (y81Var != null) {
                            View view3 = this.g;
                            if (view3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
                            }
                            y81Var.setBtnPlaceholder(view3.findViewById(R.id.ad_video_btn_placeholder));
                        }
                        y81Var2 = this.o;
                        if (y81Var2 != null) {
                            y81Var2.setVisible(0);
                        }
                        y81Var3 = this.o;
                        if (y81Var3 != null) {
                            y81Var3.setBtnIconNightModeEnable(false);
                        }
                        y81Var4 = this.o;
                        if (y81Var4 != null) {
                            y81Var4.setEnhanceBtnListener(new a());
                        }
                        appStr = jSONObject.optString("app_info");
                        Intrinsics.checkNotNullExpressionValue(appStr, "appStr");
                        if (appStr.length() <= 0) {
                            z2 = false;
                        }
                        if (z2) {
                            a2.s = nn0.d(ly0.c(appStr));
                        }
                        y81Var5 = this.o;
                        if (y81Var5 == null) {
                            y81Var5.setData(a2);
                            return;
                        }
                        return;
                    }
                    optString.equals("detail");
                }
                i = 0;
                a2.a = i;
                c2 = sm0.c(ly0.c(jSONObject.optString("download")));
                a2.p = c2;
                if (c2 != null) {
                }
                vm0 vm0Var2 = new vm0();
                vm0Var2.a = ClogBuilder.Page.PAGE_VIDEO_IMMERSIVE_LP.type;
                vm0Var2.d = jSONObject.optString(MigrateStatisticUtils.EXT_INFO);
                Unit unit2 = Unit.INSTANCE;
                a2.q = vm0Var2;
                list = a2.o;
                if (list == null) {
                }
                z = true;
                if (z) {
                }
                view2 = this.g;
                if (view2 == null) {
                }
                y81Var = (y81) view2.findViewById(R.id.max_ebtn);
                this.o = y81Var;
                if (y81Var != null) {
                }
                y81Var2 = this.o;
                if (y81Var2 != null) {
                }
                y81Var3 = this.o;
                if (y81Var3 != null) {
                }
                y81Var4 = this.o;
                if (y81Var4 != null) {
                }
                appStr = jSONObject.optString("app_info");
                Intrinsics.checkNotNullExpressionValue(appStr, "appStr");
                if (appStr.length() <= 0) {
                }
                if (z2) {
                }
                y81Var5 = this.o;
                if (y81Var5 == null) {
                }
            }
        }
    }

    public final void T() {
        String str;
        xm0 xm0Var = this.e;
        if (xm0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelModel");
        }
        if (!TextUtils.isEmpty(xm0Var.c)) {
            TextView textView = this.l;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorAvatarText");
            }
            textView.setVisibility(8);
            AdImageView adImageView = this.k;
            if (adImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorAvatar");
            }
            xm0 xm0Var2 = this.e;
            if (xm0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelModel");
            }
            adImageView.r(xm0Var2.c);
            AdImageView adImageView2 = this.k;
            if (adImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorAvatar");
            }
            adImageView2.setVisibility(0);
        } else {
            xm0 xm0Var3 = this.e;
            if (xm0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelModel");
            }
            if (!TextUtils.isEmpty(xm0Var3.b)) {
                AdImageView adImageView3 = this.k;
                if (adImageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authorAvatar");
                }
                adImageView3.setVisibility(8);
                TextView textView2 = this.l;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authorAvatarText");
                }
                xm0 xm0Var4 = this.e;
                if (xm0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelModel");
                }
                String str2 = xm0Var4.b;
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
        xm0 xm0Var5 = this.e;
        if (xm0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelModel");
        }
        if (!TextUtils.isEmpty(xm0Var5.b)) {
            TextView textView5 = this.m;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorName");
            }
            xm0 xm0Var6 = this.e;
            if (xm0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelModel");
            }
            textView5.setText(xm0Var6.b);
        }
        xm0 xm0Var7 = this.e;
        if (xm0Var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelModel");
        }
        if (!TextUtils.isEmpty(xm0Var7.a)) {
            TextView textView6 = this.h;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
            }
            xm0 xm0Var8 = this.e;
            if (xm0Var8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelModel");
            }
            textView6.setText(xm0Var8.a);
            return;
        }
        TextView textView7 = this.h;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
        }
        textView7.setVisibility(8);
    }

    public final void U(JSONObject jSONObject) {
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
        int f = jm0.a.f(t11.c.c(b()) / t11.c.e(b()), areEqual);
        View view2 = this.n;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelBgView");
        }
        view2.getLayoutParams().height = f;
    }

    public final void W(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("map");
        String str = null;
        if (!(serializableExtra instanceof HashMap)) {
            serializableExtra = null;
        }
        HashMap hashMap = (HashMap) serializableExtra;
        if (hashMap != null) {
            JSONObject jSONObject = new JSONObject(hashMap);
            xm0 a2 = xm0.d.a(jSONObject);
            if (a2 != null) {
                this.e = a2;
                Object obj = hashMap.get("cmd_policy");
                if (obj instanceof String) {
                    str = obj;
                }
                String str2 = str;
                if (!TextUtils.isEmpty(str2)) {
                    this.d = pn0.v.a(ly0.c(str2));
                }
                U(jSONObject);
                T();
                S(jSONObject);
                Q();
                R();
                return;
            }
            g().C(this);
        }
    }

    public final void V() {
        wl0 a2 = xl0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadMaxRuntime.getUIProvider()");
        a2.c();
        View inflate = LayoutInflater.from(b()).inflate(R.layout.nad_max_over_info_vertical, (ViewGroup) null);
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

    public final void X(long j, boolean z) {
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
