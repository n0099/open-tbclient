package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.txt.CenterTextView;
import com.baidu.nadcore.widget.txt.UnifyTextView;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.R;
import com.baidu.tieba.bl0;
import com.baidu.tieba.cn0;
import com.baidu.tieba.dz0;
import com.baidu.tieba.ez0;
import com.baidu.tieba.hd0;
import com.baidu.tieba.in0;
import com.baidu.tieba.ln0;
import com.baidu.tieba.nn0;
import com.baidu.tieba.qe0;
import com.baidu.tieba.s11;
import com.baidu.tieba.sk0;
import com.baidu.tieba.sn0;
import com.baidu.tieba.ti0;
import com.baidu.tieba.w11;
import com.baidu.tieba.xi0;
import com.baidu.tieba.xk0;
import com.baidu.webkit.sdk.WebChromeClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010U\u001a\u00020T\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010V\u0012\b\b\u0002\u0010Y\u001a\u00020X¢\u0006\u0004\bZ\u0010[J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0015\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0017\u0010\u0014J\u001b\u0010\u001a\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u001c\u0010\u0014J\u0019\u0010\u001d\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u001d\u0010\u0014J\u0019\u0010\u001e\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u001e\u0010\u0014R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001fR\u001d\u0010%\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010,\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\"\u001a\u0004\b*\u0010+R\u001d\u0010/\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\"\u001a\u0004\b.\u0010$R\u001d\u00104\u001a\u0002008B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\"\u001a\u0004\b2\u00103R\u001d\u00109\u001a\u0002058B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\"\u001a\u0004\b7\u00108R\u001d\u0010<\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\"\u001a\u0004\b;\u0010$R\u001d\u0010A\u001a\u00020=8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\"\u001a\u0004\b?\u0010@R\u001d\u0010D\u001a\u0002058B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\"\u001a\u0004\bC\u00108R\u001d\u0010I\u001a\u00020E8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\"\u001a\u0004\bG\u0010HR\u001e\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u001d\u0010P\u001a\u00020L8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\"\u001a\u0004\bN\u0010OR\u001d\u0010S\u001a\u0002008B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\"\u001a\u0004\bR\u00103¨\u0006\\"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardHalfTailView;", "Landroid/widget/RelativeLayout;", "", DnsModel.AREA_KEY, "Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;", "logType", "scheme", "", "handleClick", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;)V", "Lcom/baidu/nadcore/lp/reward/inerface/IClickInterceptor;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "registerClickInterceptor", "(Lcom/baidu/nadcore/lp/reward/inerface/IClickInterceptor;)V", "registerRewardTaskEvent", "()V", "release", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setAvatar", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "setData", "setDetailButton", "setMoreButton", "Lkotlin/Function0;", WebChromeClient.KEY_ARG_CALLBACK, "setOnReplayClickListener", "(Lkotlin/Function0;)V", "setReplayButton", "setSubTitle", "setTitle", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Lcom/baidu/nadcore/widget/AdImageView;", "avatar$delegate", "Lkotlin/Lazy;", "getAvatar", "()Lcom/baidu/nadcore/widget/AdImageView;", "avatar", "clickInterceptor", "Lcom/baidu/nadcore/lp/reward/inerface/IClickInterceptor;", "Landroid/view/View;", "detailBtn$delegate", "getDetailBtn", "()Landroid/view/View;", "detailBtn", "detailBtnIcon$delegate", "getDetailBtnIcon", "detailBtnIcon", "Landroid/widget/TextView;", "detailBtnText$delegate", "getDetailBtnText", "()Landroid/widget/TextView;", "detailBtnText", "Landroid/widget/LinearLayout;", "moreBtnContainer$delegate", "getMoreBtnContainer", "()Landroid/widget/LinearLayout;", "moreBtnContainer", "moreBtnIcon$delegate", "getMoreBtnIcon", "moreBtnIcon", "Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "moreBtnText$delegate", "getMoreBtnText", "()Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "moreBtnText", "replayBtn$delegate", "getReplayBtn", "replayBtn", "Landroid/widget/ImageView;", "replayBtnIcon$delegate", "getReplayBtnIcon", "()Landroid/widget/ImageView;", "replayBtnIcon", "replayClickListener", "Lkotlin/Function0;", "Lcom/baidu/nadcore/widget/txt/CenterTextView;", "subTitle$delegate", "getSubTitle", "()Lcom/baidu/nadcore/widget/txt/CenterTextView;", "subTitle", "title$delegate", "getTitle", "title", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRewardHalfTailView extends RelativeLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public in0 l;
    public Function0<Unit> m;
    public sk0 n;

    @JvmOverloads
    public NadRewardHalfTailView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public NadRewardHalfTailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final AdImageView getAvatar() {
        return (AdImageView) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getDetailBtn() {
        return (View) this.d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdImageView getDetailBtnIcon() {
        return (AdImageView) this.e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getDetailBtnText() {
        return (TextView) this.f.getValue();
    }

    private final LinearLayout getMoreBtnContainer() {
        return (LinearLayout) this.i.getValue();
    }

    private final AdImageView getMoreBtnIcon() {
        return (AdImageView) this.j.getValue();
    }

    private final UnifyTextView getMoreBtnText() {
        return (UnifyTextView) this.k.getValue();
    }

    private final LinearLayout getReplayBtn() {
        return (LinearLayout) this.g.getValue();
    }

    private final ImageView getReplayBtnIcon() {
        return (ImageView) this.h.getValue();
    }

    private final CenterTextView getSubTitle() {
        return (CenterTextView) this.c.getValue();
    }

    private final TextView getTitle() {
        return (TextView) this.b.getValue();
    }

    /* loaded from: classes3.dex */
    public static final class a extends xi0<hd0> {
        public a(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi0
        public void onEvent(hd0 event) {
            String str;
            cn0 cn0Var;
            Intrinsics.checkNotNullParameter(event, "event");
            if (!Intrinsics.areEqual(event.a, "4")) {
                return;
            }
            if (!event.h) {
                String str2 = event.f;
                if (str2 != null) {
                    NadRewardHalfTailView.this.getDetailBtnIcon().u(str2);
                }
                String str3 = event.g;
                if (str3 != null) {
                    NadRewardHalfTailView.this.getDetailBtnText().setText(str3);
                }
                if (event.d != null && event.e != null) {
                    Drawable background = NadRewardHalfTailView.this.getDetailBtn().getBackground();
                    if (background != null) {
                        GradientDrawable gradientDrawable = (GradientDrawable) background;
                        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                        gradientDrawable.setColors(new int[]{s11.a(event.d, R.color.nad_reward_full_tail_btn_color), s11.a(event.e, R.color.nad_reward_full_tail_btn_color)});
                        NadRewardHalfTailView.this.getDetailBtn().setBackground(gradientDrawable);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                    }
                }
                ClogBuilder u = new ClogBuilder().y(ClogBuilder.LogType.REWARD_SHOW_TASK).u(ClogBuilder.Page.WELFARETAIL);
                in0 in0Var = NadRewardHalfTailView.this.l;
                if (in0Var != null && (cn0Var = in0Var.f) != null) {
                    str = cn0Var.d;
                } else {
                    str = null;
                }
                dz0.e(u.p(str).k("4").l(event.c));
                return;
            }
            in0 in0Var2 = NadRewardHalfTailView.this.l;
            if (in0Var2 == null) {
                return;
            }
            NadRewardHalfTailView.this.setDetailButton(in0Var2);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements View.OnClickListener {
        public final /* synthetic */ in0 b;

        public b(in0 in0Var) {
            this.b = in0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            ln0 ln0Var;
            nn0 nn0Var;
            NadRewardHalfTailView nadRewardHalfTailView = NadRewardHalfTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            in0 in0Var = this.b;
            if (in0Var != null && (ln0Var = in0Var.j) != null && (nn0Var = ln0Var.i) != null) {
                str = nn0Var.h();
            } else {
                str = null;
            }
            nadRewardHalfTailView.h("icon", logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements View.OnClickListener {
        public final /* synthetic */ in0 b;

        public c(in0 in0Var) {
            this.b = in0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            ln0 ln0Var;
            nn0 nn0Var;
            NadRewardHalfTailView nadRewardHalfTailView = NadRewardHalfTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            in0 in0Var = this.b;
            if (in0Var != null && (ln0Var = in0Var.j) != null && (nn0Var = ln0Var.i) != null) {
                str = nn0Var.g;
            } else {
                str = null;
            }
            nadRewardHalfTailView.h("detailbtn", logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements View.OnClickListener {
        public final /* synthetic */ in0 b;

        public d(in0 in0Var) {
            this.b = in0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            ln0 ln0Var;
            nn0 nn0Var;
            NadRewardHalfTailView nadRewardHalfTailView = NadRewardHalfTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            in0 in0Var = this.b;
            if (in0Var != null && (ln0Var = in0Var.j) != null && (nn0Var = ln0Var.i) != null) {
                str = nn0Var.z;
            } else {
                str = null;
            }
            nadRewardHalfTailView.h("morebtn", logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardHalfTailView.this.h("replaybtn", ClogBuilder.LogType.FREE_CLICK, null);
            Function0 function0 = NadRewardHalfTailView.this.m;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements View.OnClickListener {
        public final /* synthetic */ in0 b;

        public f(in0 in0Var) {
            this.b = in0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            ln0 ln0Var;
            nn0 nn0Var;
            NadRewardHalfTailView nadRewardHalfTailView = NadRewardHalfTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            in0 in0Var = this.b;
            if (in0Var != null && (ln0Var = in0Var.j) != null && (nn0Var = ln0Var.i) != null) {
                str = nn0Var.h();
            } else {
                str = null;
            }
            nadRewardHalfTailView.h("tail_subtitle", logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements View.OnClickListener {
        public final /* synthetic */ in0 b;

        public g(in0 in0Var) {
            this.b = in0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            ln0 ln0Var;
            nn0 nn0Var;
            NadRewardHalfTailView nadRewardHalfTailView = NadRewardHalfTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            in0 in0Var = this.b;
            if (in0Var != null && (ln0Var = in0Var.j) != null && (nn0Var = ln0Var.i) != null) {
                str = nn0Var.h();
            } else {
                str = null;
            }
            nadRewardHalfTailView.h("name", logType, str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadRewardHalfTailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$avatar$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdImageView invoke() {
                View findViewById = NadRewardHalfTailView.this.findViewById(R.id.obfuscated_res_0x7f090342);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.avatar)");
                return (AdImageView) findViewById;
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$title$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View findViewById = NadRewardHalfTailView.this.findViewById(R.id.obfuscated_res_0x7f092685);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
                return (TextView) findViewById;
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<CenterTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$subTitle$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CenterTextView invoke() {
                View findViewById = NadRewardHalfTailView.this.findViewById(R.id.obfuscated_res_0x7f0923ec);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.sub_title)");
                return (CenterTextView) findViewById;
            }
        });
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$detailBtn$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View findViewById = NadRewardHalfTailView.this.findViewById(R.id.detail_btn);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.detail_btn)");
                return findViewById;
            }
        });
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$detailBtnIcon$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdImageView invoke() {
                View findViewById = NadRewardHalfTailView.this.findViewById(R.id.detail_btn_icon);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.detail_btn_icon)");
                return (AdImageView) findViewById;
            }
        });
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$detailBtnText$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View findViewById = NadRewardHalfTailView.this.findViewById(R.id.detail_btn_text);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.detail_btn_text)");
                return (TextView) findViewById;
            }
        });
        this.g = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$replayBtn$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View findViewById = NadRewardHalfTailView.this.findViewById(R.id.replay_btn);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.replay_btn)");
                return (LinearLayout) findViewById;
            }
        });
        this.h = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$replayBtnIcon$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View findViewById = NadRewardHalfTailView.this.findViewById(R.id.replay_btn_icon);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.replay_btn_icon)");
                return (ImageView) findViewById;
            }
        });
        this.i = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$moreBtnContainer$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View findViewById = NadRewardHalfTailView.this.findViewById(R.id.more_btn_container);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.more_btn_container)");
                return (LinearLayout) findViewById;
            }
        });
        this.j = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$moreBtnIcon$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdImageView invoke() {
                View findViewById = NadRewardHalfTailView.this.findViewById(R.id.more_btn_icon);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.more_btn_icon)");
                return (AdImageView) findViewById;
            }
        });
        this.k = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$moreBtnText$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                View findViewById = NadRewardHalfTailView.this.findViewById(R.id.more_btn_text);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.more_btn_text)");
                return (UnifyTextView) findViewById;
            }
        });
        LayoutInflater from = LayoutInflater.from(context);
        xk0 a2 = bl0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        from.inflate(a2.o(), this);
    }

    public /* synthetic */ NadRewardHalfTailView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setAvatar(in0 in0Var) {
        String str;
        ln0 ln0Var;
        nn0 nn0Var;
        AdImageView avatar = getAvatar();
        if (in0Var != null && (ln0Var = in0Var.j) != null && (nn0Var = ln0Var.i) != null) {
            str = nn0Var.d;
        } else {
            str = null;
        }
        avatar.u(str);
        avatar.setOnClickListener(new b(in0Var));
    }

    private final void setReplayButton(in0 in0Var) {
        int i;
        sn0 c2;
        getReplayBtn().setOnClickListener(new e());
        ImageView replayBtnIcon = getReplayBtnIcon();
        if (in0Var != null && (c2 = in0Var.c()) != null && c2.f()) {
            i = 8;
        } else {
            i = 0;
        }
        replayBtnIcon.setVisibility(i);
    }

    public final void i(sk0 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.n = listener;
    }

    public final void setData(in0 in0Var) {
        this.l = in0Var;
        setAvatar(in0Var);
        setTitle(in0Var);
        setSubTitle(in0Var);
        setDetailButton(in0Var);
        setReplayButton(in0Var);
        setMoreButton(in0Var);
        j();
    }

    public final void setOnReplayClickListener(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.m = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDetailButton(in0 in0Var) {
        String str;
        String str2;
        String str3;
        boolean z;
        String str4;
        ln0 ln0Var;
        nn0 nn0Var;
        ln0 ln0Var2;
        nn0 nn0Var2;
        String str5;
        String str6;
        ln0 ln0Var3;
        nn0 nn0Var3;
        ln0 ln0Var4;
        nn0 nn0Var4;
        ln0 ln0Var5;
        nn0 nn0Var5;
        sn0 c2;
        ln0 ln0Var6;
        nn0 nn0Var6;
        ln0 ln0Var7;
        nn0 nn0Var7;
        ln0 ln0Var8;
        nn0 nn0Var8;
        View detailBtn = getDetailBtn();
        Resources resources = detailBtn.getResources();
        xk0 a2 = bl0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension = resources.getDimension(a2.k());
        GradientDrawable gradientDrawable = new GradientDrawable();
        String str7 = null;
        if (in0Var != null && (ln0Var8 = in0Var.j) != null && (nn0Var8 = ln0Var8.i) != null) {
            str = nn0Var8.i;
        } else {
            str = null;
        }
        gradientDrawable.setColor(s11.a(str, R.color.nad_reward_full_tail_btn_color));
        gradientDrawable.setCornerRadius(dimension);
        Unit unit = Unit.INSTANCE;
        detailBtn.setBackground(gradientDrawable);
        if (in0Var != null && (ln0Var7 = in0Var.j) != null && (nn0Var7 = ln0Var7.i) != null) {
            str2 = nn0Var7.b;
        } else {
            str2 = null;
        }
        int i = 8;
        boolean z2 = false;
        if (Intrinsics.areEqual(str2, "detail")) {
            detailBtn.setVisibility(0);
        } else {
            detailBtn.setVisibility(8);
        }
        detailBtn.setOnClickListener(new c(in0Var));
        AdImageView detailBtnIcon = getDetailBtnIcon();
        if (in0Var != null && (ln0Var6 = in0Var.j) != null && (nn0Var6 = ln0Var6.i) != null && nn0Var6.D) {
            detailBtnIcon.setImageResource(R.drawable.nad_reward_detail_btn_dp_icon);
            dz0.e(new ClogBuilder().j("openbtn").y(ClogBuilder.LogType.FREE_SHOW).u(ClogBuilder.Page.WELFAREMAXLP).p(in0Var.f.d));
        } else {
            if (in0Var != null && (ln0Var2 = in0Var.j) != null && (nn0Var2 = ln0Var2.i) != null) {
                str3 = nn0Var2.j;
            } else {
                str3 = null;
            }
            if (str3 != null && !StringsKt__StringsJVMKt.isBlank(str3)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (in0Var != null && (ln0Var = in0Var.j) != null && (nn0Var = ln0Var.i) != null) {
                    str4 = nn0Var.j;
                } else {
                    str4 = null;
                }
                detailBtnIcon.u(str4);
            } else {
                detailBtnIcon.setImageResource(R.drawable.nad_reward_detail_btn_icon);
            }
        }
        detailBtnIcon.setVisibility((in0Var == null || (c2 = in0Var.c()) == null || !c2.f()) ? 0 : 0);
        TextView detailBtnText = getDetailBtnText();
        if (in0Var != null && (ln0Var5 = in0Var.j) != null && (nn0Var5 = ln0Var5.i) != null && nn0Var5.D) {
            str6 = detailBtnText.getContext().getString(R.string.nad_reward_detail_btn_open_app);
        } else {
            if (in0Var != null && (ln0Var4 = in0Var.j) != null && (nn0Var4 = ln0Var4.i) != null) {
                str5 = nn0Var4.h;
            } else {
                str5 = null;
            }
            if (!((str5 == null || StringsKt__StringsJVMKt.isBlank(str5)) ? true : true)) {
                if (in0Var != null && (ln0Var3 = in0Var.j) != null && (nn0Var3 = ln0Var3.i) != null) {
                    str7 = nn0Var3.h;
                }
            } else {
                str7 = detailBtnText.getContext().getString(R.string.nad_reward_detail_btn_text);
            }
            str6 = str7;
        }
        detailBtnText.setText(str6);
    }

    private final void setSubTitle(in0 in0Var) {
        String str;
        ln0 ln0Var;
        nn0 nn0Var;
        ln0 ln0Var2;
        nn0 nn0Var2;
        CenterTextView subTitle = getSubTitle();
        boolean z = false;
        subTitle.setTextBold(false);
        String str2 = null;
        if (in0Var != null && (ln0Var2 = in0Var.j) != null && (nn0Var2 = ln0Var2.i) != null) {
            str = nn0Var2.n;
        } else {
            str = null;
        }
        if (!((str == null || str.length() == 0) ? true : true)) {
            if (in0Var != null && (ln0Var = in0Var.j) != null && (nn0Var = ln0Var.i) != null) {
                str2 = nn0Var.n;
            }
            subTitle.setText(str2);
        }
        subTitle.setOnClickListener(new f(in0Var));
    }

    private final void setTitle(in0 in0Var) {
        String str;
        boolean z;
        ln0 ln0Var;
        nn0 nn0Var;
        ln0 ln0Var2;
        nn0 nn0Var2;
        TextView title = getTitle();
        String str2 = null;
        if (in0Var != null && (ln0Var2 = in0Var.j) != null && (nn0Var2 = ln0Var2.i) != null) {
            str = nn0Var2.c;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            if (in0Var != null && (ln0Var = in0Var.j) != null && (nn0Var = ln0Var.i) != null) {
                str2 = nn0Var.c;
            }
            title.setText(str2);
        }
        title.setOnClickListener(new g(in0Var));
    }

    public final void h(String str, ClogBuilder.LogType logType, String str2) {
        String str3;
        in0 in0Var;
        List<MonitorUrl> list;
        boolean z;
        cn0 cn0Var;
        ln0 ln0Var;
        nn0 nn0Var;
        sk0 sk0Var;
        in0 in0Var2 = this.l;
        boolean z2 = true;
        if (in0Var2 != null && (ln0Var = in0Var2.j) != null && (nn0Var = ln0Var.i) != null && !nn0Var.D && (sk0Var = this.n) != null && sk0Var.a(str, logType, str2)) {
            return;
        }
        ClogBuilder u = new ClogBuilder().j(str).y(logType).u(ClogBuilder.Page.WELFARETAIL);
        in0 in0Var3 = this.l;
        if (in0Var3 != null && (cn0Var = in0Var3.f) != null) {
            str3 = cn0Var.d;
        } else {
            str3 = null;
        }
        dz0.e(u.p(str3));
        if (logType == ClogBuilder.LogType.CLICK && (in0Var = this.l) != null && (list = in0Var.e) != null) {
            ArrayList<MonitorUrl> arrayList = new ArrayList();
            for (Object obj : list) {
                String str4 = ((MonitorUrl) obj).clickUrl;
                if (str4 != null && !StringsKt__StringsJVMKt.isBlank(str4)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    arrayList.add(obj);
                }
            }
            for (MonitorUrl monitorUrl : arrayList) {
                ez0.b(monitorUrl.clickUrl);
            }
        }
        if (str2 != null && str2.length() != 0) {
            z2 = false;
        }
        if (!z2) {
            qe0.c(str2, getContext());
        }
    }

    public final void j() {
        ti0.a().c(this, new a(hd0.class));
    }

    public final void k() {
        ti0.a().a(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setMoreButton(in0 in0Var) {
        String str;
        boolean z;
        boolean z2;
        LinearLayout linearLayout;
        AdImageView moreBtnIcon;
        String str2;
        boolean z3;
        UnifyTextView moreBtnText;
        String str3;
        String str4;
        boolean z4;
        ln0 ln0Var;
        nn0 nn0Var;
        ln0 ln0Var2;
        nn0 nn0Var2;
        ln0 ln0Var3;
        nn0 nn0Var3;
        String str5;
        ln0 ln0Var4;
        nn0 nn0Var4;
        ln0 ln0Var5;
        nn0 nn0Var5;
        String str6;
        ln0 ln0Var6;
        nn0 nn0Var6;
        String str7;
        boolean z5;
        ln0 ln0Var7;
        nn0 nn0Var7;
        ln0 ln0Var8;
        nn0 nn0Var8;
        LinearLayout moreBtnContainer = getMoreBtnContainer();
        String str8 = null;
        if (in0Var != null && (ln0Var8 = in0Var.j) != null && (nn0Var8 = ln0Var8.i) != null) {
            str = nn0Var8.x;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (in0Var != null && (ln0Var7 = in0Var.j) != null && (nn0Var7 = ln0Var7.i) != null) {
                str7 = nn0Var7.y;
            } else {
                str7 = null;
            }
            if (str7 != null && str7.length() != 0) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z5) {
                z2 = false;
                if (!z2) {
                    moreBtnContainer.setVisibility(0);
                    linearLayout = moreBtnContainer;
                } else {
                    moreBtnContainer.setVisibility(8);
                    linearLayout = null;
                }
                if (linearLayout != null) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(w11.c.a(moreBtnContainer.getContext(), 17.0f));
                    if (in0Var != null && (ln0Var6 = in0Var.j) != null && (nn0Var6 = ln0Var6.i) != null) {
                        str6 = nn0Var6.A;
                    } else {
                        str6 = null;
                    }
                    gradientDrawable.setStroke(2, s11.a(str6, R.color.nad_reward_half_tail_more_btn_border));
                    Unit unit = Unit.INSTANCE;
                    linearLayout.setBackground(gradientDrawable);
                }
                moreBtnContainer.setOnClickListener(new d(in0Var));
                moreBtnIcon = getMoreBtnIcon();
                if (in0Var == null && (ln0Var5 = in0Var.j) != null && (nn0Var5 = ln0Var5.i) != null) {
                    str2 = nn0Var5.x;
                } else {
                    str2 = null;
                }
                if (str2 == null && str2.length() != 0) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (!(!z3)) {
                    moreBtnIcon.setVisibility(0);
                } else {
                    moreBtnIcon.setVisibility(8);
                    moreBtnIcon = null;
                }
                if (moreBtnIcon != null) {
                    if (in0Var != null && (ln0Var4 = in0Var.j) != null && (nn0Var4 = ln0Var4.i) != null) {
                        str5 = nn0Var4.x;
                    } else {
                        str5 = null;
                    }
                    moreBtnIcon.u(str5);
                }
                moreBtnText = getMoreBtnText();
                if (in0Var == null && (ln0Var3 = in0Var.j) != null && (nn0Var3 = ln0Var3.i) != null) {
                    str3 = nn0Var3.B;
                } else {
                    str3 = null;
                }
                moreBtnText.setTextColor(s11.a(str3, R.color.nad_reward_half_tail_more_text_color));
                if (in0Var == null && (ln0Var2 = in0Var.j) != null && (nn0Var2 = ln0Var2.i) != null) {
                    str4 = nn0Var2.y;
                } else {
                    str4 = null;
                }
                if (str4 == null && str4.length() != 0) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (!(!z4)) {
                    moreBtnText.setVisibility(0);
                } else {
                    moreBtnText.setVisibility(8);
                    moreBtnText = null;
                }
                if (moreBtnText == null) {
                    if (in0Var != null && (ln0Var = in0Var.j) != null && (nn0Var = ln0Var.i) != null) {
                        str8 = nn0Var.y;
                    }
                    moreBtnText.setText(str8);
                    return;
                }
                return;
            }
        }
        z2 = true;
        if (!z2) {
        }
        if (linearLayout != null) {
        }
        moreBtnContainer.setOnClickListener(new d(in0Var));
        moreBtnIcon = getMoreBtnIcon();
        if (in0Var == null) {
        }
        str2 = null;
        if (str2 == null) {
        }
        z3 = true;
        if (!(!z3)) {
        }
        if (moreBtnIcon != null) {
        }
        moreBtnText = getMoreBtnText();
        if (in0Var == null) {
        }
        str3 = null;
        moreBtnText.setTextColor(s11.a(str3, R.color.nad_reward_half_tail_more_text_color));
        if (in0Var == null) {
        }
        str4 = null;
        if (str4 == null) {
        }
        z4 = true;
        if (!(!z4)) {
        }
        if (moreBtnText == null) {
        }
    }
}
