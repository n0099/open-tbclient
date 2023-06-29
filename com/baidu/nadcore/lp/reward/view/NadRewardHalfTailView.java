package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
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
import com.baidu.nadcore.widget.txt.UnifyTextView;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.R;
import com.baidu.tieba.bs0;
import com.baidu.tieba.c61;
import com.baidu.tieba.ds0;
import com.baidu.tieba.g61;
import com.baidu.tieba.hs0;
import com.baidu.tieba.qi0;
import com.baidu.tieba.r31;
import com.baidu.tieba.rs0;
import com.baidu.tieba.s31;
import com.baidu.tieba.sp0;
import com.baidu.tieba.tn0;
import com.baidu.tieba.ur0;
import com.baidu.tieba.xj0;
import com.baidu.tieba.xn0;
import com.baidu.tieba.yr0;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010R\u001a\u00020Q\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010S\u0012\b\b\u0002\u0010V\u001a\u00020U¢\u0006\u0004\bW\u0010XJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0014\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u001b\u0010\u0019\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u001b\u0010\u0013J\u0019\u0010\u001c\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u0013J\u0019\u0010\u001d\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u001d\u0010\u0013R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001eR\u001d\u0010$\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001d\u0010+\u001a\u00020'8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010!\u001a\u0004\b)\u0010*R\u001d\u0010.\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010!\u001a\u0004\b-\u0010#R\u001d\u00103\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010!\u001a\u0004\b1\u00102R\u001d\u00108\u001a\u0002048B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010!\u001a\u0004\b6\u00107R\u001d\u0010;\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010!\u001a\u0004\b:\u0010#R\u001d\u0010@\u001a\u00020<8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010!\u001a\u0004\b>\u0010?R\u001d\u0010C\u001a\u0002048B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010!\u001a\u0004\bB\u00107R\u001d\u0010H\u001a\u00020D8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010!\u001a\u0004\bF\u0010GR\u001e\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u001d\u0010M\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010!\u001a\u0004\bL\u00102R\u001d\u0010P\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010!\u001a\u0004\bO\u00102¨\u0006Y"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardHalfTailView;", "Landroid/widget/RelativeLayout;", "", DnsModel.AREA_KEY, "Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;", "logType", "scheme", "", "handleClick", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;)V", "Lcom/baidu/nadcore/lp/reward/inerface/IClickInterceptor;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "registerClickInterceptor", "(Lcom/baidu/nadcore/lp/reward/inerface/IClickInterceptor;)V", "registerRewardTaskEvent", "()V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setAvatar", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "setData", "setDetailButton", "setMoreButton", "Lkotlin/Function0;", WebChromeClient.KEY_ARG_CALLBACK, "setOnReplayClickListener", "(Lkotlin/Function0;)V", "setReplayButton", "setSubTitle", "setTitle", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Lcom/baidu/nadcore/widget/AdImageView;", "avatar$delegate", "Lkotlin/Lazy;", "getAvatar", "()Lcom/baidu/nadcore/widget/AdImageView;", "avatar", "clickInterceptor", "Lcom/baidu/nadcore/lp/reward/inerface/IClickInterceptor;", "Landroid/view/View;", "detailBtn$delegate", "getDetailBtn", "()Landroid/view/View;", "detailBtn", "detailBtnIcon$delegate", "getDetailBtnIcon", "detailBtnIcon", "Landroid/widget/TextView;", "detailBtnText$delegate", "getDetailBtnText", "()Landroid/widget/TextView;", "detailBtnText", "Landroid/widget/LinearLayout;", "moreBtnContainer$delegate", "getMoreBtnContainer", "()Landroid/widget/LinearLayout;", "moreBtnContainer", "moreBtnIcon$delegate", "getMoreBtnIcon", "moreBtnIcon", "Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "moreBtnText$delegate", "getMoreBtnText", "()Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "moreBtnText", "replayBtn$delegate", "getReplayBtn", "replayBtn", "Landroid/widget/ImageView;", "replayBtnIcon$delegate", "getReplayBtnIcon", "()Landroid/widget/ImageView;", "replayBtnIcon", "replayClickListener", "Lkotlin/Function0;", "subTitle$delegate", "getSubTitle", "subTitle", "title$delegate", "getTitle", "title", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
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
    public yr0 l;
    public Function0<Unit> m;
    public sp0 n;

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

    private final TextView getSubTitle() {
        return (TextView) this.c.getValue();
    }

    private final TextView getTitle() {
        return (TextView) this.b.getValue();
    }

    /* loaded from: classes3.dex */
    public static final class a extends xn0<qi0> {
        public a(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xn0
        public void onEvent(qi0 event) {
            String str;
            ur0 ur0Var;
            Intrinsics.checkNotNullParameter(event, "event");
            if (!Intrinsics.areEqual(event.a, "4")) {
                return;
            }
            if (!event.h) {
                String str2 = event.f;
                if (str2 != null) {
                    NadRewardHalfTailView.this.getDetailBtnIcon().o(str2);
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
                        gradientDrawable.setColors(new int[]{c61.a(event.d, R.color.nad_reward_full_tail_btn_color), c61.a(event.e, R.color.nad_reward_full_tail_btn_color)});
                        NadRewardHalfTailView.this.getDetailBtn().setBackground(gradientDrawable);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                    }
                }
                ClogBuilder u = new ClogBuilder().y(ClogBuilder.LogType.REWARD_SHOW_TASK).u(ClogBuilder.Page.WELFARETAIL);
                yr0 yr0Var = NadRewardHalfTailView.this.l;
                if (yr0Var != null && (ur0Var = yr0Var.f) != null) {
                    str = ur0Var.d;
                } else {
                    str = null;
                }
                r31.b(u.p(str).k("4").l(event.c));
                return;
            }
            yr0 yr0Var2 = NadRewardHalfTailView.this.l;
            if (yr0Var2 == null) {
                return;
            }
            NadRewardHalfTailView.this.setDetailButton(yr0Var2);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements View.OnClickListener {
        public final /* synthetic */ yr0 b;

        public b(yr0 yr0Var) {
            this.b = yr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            bs0 bs0Var;
            ds0 ds0Var;
            NadRewardHalfTailView nadRewardHalfTailView = NadRewardHalfTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            yr0 yr0Var = this.b;
            if (yr0Var != null && (bs0Var = yr0Var.j) != null && (ds0Var = bs0Var.i) != null) {
                str = ds0Var.f;
            } else {
                str = null;
            }
            nadRewardHalfTailView.h("icon", logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements View.OnClickListener {
        public final /* synthetic */ yr0 b;

        public c(yr0 yr0Var) {
            this.b = yr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            bs0 bs0Var;
            ds0 ds0Var;
            NadRewardHalfTailView nadRewardHalfTailView = NadRewardHalfTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            yr0 yr0Var = this.b;
            if (yr0Var != null && (bs0Var = yr0Var.j) != null && (ds0Var = bs0Var.i) != null) {
                str = ds0Var.f;
            } else {
                str = null;
            }
            nadRewardHalfTailView.h("detailbtn", logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements View.OnClickListener {
        public final /* synthetic */ yr0 b;

        public d(yr0 yr0Var) {
            this.b = yr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            bs0 bs0Var;
            ds0 ds0Var;
            NadRewardHalfTailView nadRewardHalfTailView = NadRewardHalfTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            yr0 yr0Var = this.b;
            if (yr0Var != null && (bs0Var = yr0Var.j) != null && (ds0Var = bs0Var.i) != null) {
                str = ds0Var.y;
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
        public final /* synthetic */ yr0 b;

        public f(yr0 yr0Var) {
            this.b = yr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            bs0 bs0Var;
            ds0 ds0Var;
            NadRewardHalfTailView nadRewardHalfTailView = NadRewardHalfTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            yr0 yr0Var = this.b;
            if (yr0Var != null && (bs0Var = yr0Var.j) != null && (ds0Var = bs0Var.i) != null) {
                str = ds0Var.f;
            } else {
                str = null;
            }
            nadRewardHalfTailView.h("tail_subtitle", logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements View.OnClickListener {
        public final /* synthetic */ yr0 b;

        public g(yr0 yr0Var) {
            this.b = yr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            bs0 bs0Var;
            ds0 ds0Var;
            NadRewardHalfTailView nadRewardHalfTailView = NadRewardHalfTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            yr0 yr0Var = this.b;
            if (yr0Var != null && (bs0Var = yr0Var.j) != null && (ds0Var = bs0Var.i) != null) {
                str = ds0Var.f;
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
                View findViewById = NadRewardHalfTailView.this.findViewById(R.id.obfuscated_res_0x7f090315);
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
                View findViewById = NadRewardHalfTailView.this.findViewById(R.id.obfuscated_res_0x7f09250e);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
                return (TextView) findViewById;
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$subTitle$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View findViewById = NadRewardHalfTailView.this.findViewById(R.id.obfuscated_res_0x7f092284);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.sub_title)");
                return (TextView) findViewById;
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
        LayoutInflater.from(context).inflate(R.layout.nad_reward_half_tail, this);
    }

    public /* synthetic */ NadRewardHalfTailView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setAvatar(yr0 yr0Var) {
        String str;
        bs0 bs0Var;
        ds0 ds0Var;
        AdImageView avatar = getAvatar();
        if (yr0Var != null && (bs0Var = yr0Var.j) != null && (ds0Var = bs0Var.i) != null) {
            str = ds0Var.d;
        } else {
            str = null;
        }
        avatar.o(str);
        avatar.setOnClickListener(new b(yr0Var));
    }

    private final void setReplayButton(yr0 yr0Var) {
        int i;
        hs0 c2;
        getReplayBtn().setOnClickListener(new e());
        ImageView replayBtnIcon = getReplayBtnIcon();
        if (yr0Var != null && (c2 = yr0Var.c()) != null && c2.f()) {
            i = 8;
        } else {
            i = 0;
        }
        replayBtnIcon.setVisibility(i);
    }

    public final void i(sp0 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.n = listener;
    }

    public final void setData(yr0 yr0Var) {
        this.l = yr0Var;
        setAvatar(yr0Var);
        setTitle(yr0Var);
        setSubTitle(yr0Var);
        setDetailButton(yr0Var);
        setReplayButton(yr0Var);
        setMoreButton(yr0Var);
        j();
    }

    public final void setOnReplayClickListener(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.m = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDetailButton(yr0 yr0Var) {
        String str;
        String str2;
        String str3;
        boolean z;
        String str4;
        bs0 bs0Var;
        ds0 ds0Var;
        bs0 bs0Var2;
        ds0 ds0Var2;
        String str5;
        String str6;
        bs0 bs0Var3;
        ds0 ds0Var3;
        bs0 bs0Var4;
        ds0 ds0Var4;
        bs0 bs0Var5;
        ds0 ds0Var5;
        hs0 c2;
        bs0 bs0Var6;
        ds0 ds0Var6;
        bs0 bs0Var7;
        ds0 ds0Var7;
        bs0 bs0Var8;
        ds0 ds0Var8;
        View detailBtn = getDetailBtn();
        int a2 = g61.c.a(detailBtn.getContext(), 16.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        String str7 = null;
        if (yr0Var != null && (bs0Var8 = yr0Var.j) != null && (ds0Var8 = bs0Var8.i) != null) {
            str = ds0Var8.h;
        } else {
            str = null;
        }
        gradientDrawable.setColor(c61.a(str, R.color.nad_reward_full_tail_btn_color));
        gradientDrawable.setCornerRadius(a2);
        Unit unit = Unit.INSTANCE;
        detailBtn.setBackground(gradientDrawable);
        if (yr0Var != null && (bs0Var7 = yr0Var.j) != null && (ds0Var7 = bs0Var7.i) != null) {
            str2 = ds0Var7.b;
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
        detailBtn.setOnClickListener(new c(yr0Var));
        AdImageView detailBtnIcon = getDetailBtnIcon();
        if (yr0Var != null && (bs0Var6 = yr0Var.j) != null && (ds0Var6 = bs0Var6.i) != null && ds0Var6.C) {
            detailBtnIcon.setImageResource(R.drawable.nad_reward_detail_btn_dp_icon);
            r31.b(new ClogBuilder().j("openbtn").y(ClogBuilder.LogType.FREE_SHOW).u(ClogBuilder.Page.WELFAREMAXLP).p(yr0Var.f.d));
        } else {
            if (yr0Var != null && (bs0Var2 = yr0Var.j) != null && (ds0Var2 = bs0Var2.i) != null) {
                str3 = ds0Var2.i;
            } else {
                str3 = null;
            }
            if (str3 != null && !StringsKt__StringsJVMKt.isBlank(str3)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (yr0Var != null && (bs0Var = yr0Var.j) != null && (ds0Var = bs0Var.i) != null) {
                    str4 = ds0Var.i;
                } else {
                    str4 = null;
                }
                detailBtnIcon.o(str4);
            } else {
                detailBtnIcon.setImageResource(R.drawable.nad_reward_detail_btn_icon);
            }
        }
        detailBtnIcon.setVisibility((yr0Var == null || (c2 = yr0Var.c()) == null || !c2.f()) ? 0 : 0);
        TextView detailBtnText = getDetailBtnText();
        if (yr0Var != null && (bs0Var5 = yr0Var.j) != null && (ds0Var5 = bs0Var5.i) != null && ds0Var5.C) {
            str6 = detailBtnText.getContext().getString(R.string.nad_reward_detail_btn_open_app);
        } else {
            if (yr0Var != null && (bs0Var4 = yr0Var.j) != null && (ds0Var4 = bs0Var4.i) != null) {
                str5 = ds0Var4.g;
            } else {
                str5 = null;
            }
            if (!((str5 == null || StringsKt__StringsJVMKt.isBlank(str5)) ? true : true)) {
                if (yr0Var != null && (bs0Var3 = yr0Var.j) != null && (ds0Var3 = bs0Var3.i) != null) {
                    str7 = ds0Var3.g;
                }
            } else {
                str7 = detailBtnText.getContext().getString(R.string.nad_reward_detail_btn_text);
            }
            str6 = str7;
        }
        detailBtnText.setText(str6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x004b, code lost:
        if (r4 == false) goto L108;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setMoreButton(yr0 yr0Var) {
        String str;
        boolean z;
        boolean z2;
        String str2;
        boolean z3;
        bs0 bs0Var;
        ds0 ds0Var;
        bs0 bs0Var2;
        ds0 ds0Var2;
        LinearLayout linearLayout;
        AdImageView moreBtnIcon;
        String str3;
        boolean z4;
        UnifyTextView moreBtnText;
        String str4;
        String str5;
        boolean z5;
        bs0 bs0Var3;
        ds0 ds0Var3;
        bs0 bs0Var4;
        ds0 ds0Var4;
        bs0 bs0Var5;
        ds0 ds0Var5;
        String str6;
        bs0 bs0Var6;
        ds0 ds0Var6;
        bs0 bs0Var7;
        ds0 ds0Var7;
        String str7;
        bs0 bs0Var8;
        ds0 ds0Var8;
        rs0 h;
        LinearLayout moreBtnContainer = getMoreBtnContainer();
        String str8 = null;
        if (yr0Var == null || (h = yr0Var.h()) == null || !h.d()) {
            if (yr0Var != null && (bs0Var2 = yr0Var.j) != null && (ds0Var2 = bs0Var2.i) != null) {
                str = ds0Var2.w;
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (yr0Var != null && (bs0Var = yr0Var.j) != null && (ds0Var = bs0Var.i) != null) {
                    str2 = ds0Var.x;
                } else {
                    str2 = null;
                }
                if (str2 != null && str2.length() != 0) {
                    z3 = false;
                } else {
                    z3 = true;
                }
            }
            z2 = true;
            if (!z2) {
                moreBtnContainer.setVisibility(0);
                linearLayout = moreBtnContainer;
            } else {
                moreBtnContainer.setVisibility(8);
                linearLayout = null;
            }
            if (linearLayout != null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(g61.c.a(moreBtnContainer.getContext(), 17.0f));
                if (yr0Var != null && (bs0Var8 = yr0Var.j) != null && (ds0Var8 = bs0Var8.i) != null) {
                    str7 = ds0Var8.z;
                } else {
                    str7 = null;
                }
                gradientDrawable.setStroke(2, c61.a(str7, R.color.nad_reward_half_tail_more_btn_border));
                Unit unit = Unit.INSTANCE;
                linearLayout.setBackground(gradientDrawable);
            }
            moreBtnContainer.setOnClickListener(new d(yr0Var));
            moreBtnIcon = getMoreBtnIcon();
            if (yr0Var == null && (bs0Var7 = yr0Var.j) != null && (ds0Var7 = bs0Var7.i) != null) {
                str3 = ds0Var7.w;
            } else {
                str3 = null;
            }
            if (str3 == null && str3.length() != 0) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (!(!z4)) {
                moreBtnIcon.setVisibility(0);
            } else {
                moreBtnIcon.setVisibility(8);
                moreBtnIcon = null;
            }
            if (moreBtnIcon != null) {
                if (yr0Var != null && (bs0Var6 = yr0Var.j) != null && (ds0Var6 = bs0Var6.i) != null) {
                    str6 = ds0Var6.w;
                } else {
                    str6 = null;
                }
                moreBtnIcon.o(str6);
            }
            moreBtnText = getMoreBtnText();
            if (yr0Var == null && (bs0Var5 = yr0Var.j) != null && (ds0Var5 = bs0Var5.i) != null) {
                str4 = ds0Var5.A;
            } else {
                str4 = null;
            }
            moreBtnText.setTextColor(c61.a(str4, R.color.nad_reward_half_tail_more_text_color));
            if (yr0Var == null && (bs0Var4 = yr0Var.j) != null && (ds0Var4 = bs0Var4.i) != null) {
                str5 = ds0Var4.x;
            } else {
                str5 = null;
            }
            if (str5 == null && str5.length() != 0) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (!(true ^ z5)) {
                moreBtnText.setVisibility(0);
            } else {
                moreBtnText.setVisibility(8);
                moreBtnText = null;
            }
            if (moreBtnText == null) {
                if (yr0Var != null && (bs0Var3 = yr0Var.j) != null && (ds0Var3 = bs0Var3.i) != null) {
                    str8 = ds0Var3.x;
                }
                moreBtnText.setText(str8);
                return;
            }
            return;
        }
        z2 = false;
        if (!z2) {
        }
        if (linearLayout != null) {
        }
        moreBtnContainer.setOnClickListener(new d(yr0Var));
        moreBtnIcon = getMoreBtnIcon();
        if (yr0Var == null) {
        }
        str3 = null;
        if (str3 == null) {
        }
        z4 = true;
        if (!(!z4)) {
        }
        if (moreBtnIcon != null) {
        }
        moreBtnText = getMoreBtnText();
        if (yr0Var == null) {
        }
        str4 = null;
        moreBtnText.setTextColor(c61.a(str4, R.color.nad_reward_half_tail_more_text_color));
        if (yr0Var == null) {
        }
        str5 = null;
        if (str5 == null) {
        }
        z5 = true;
        if (!(true ^ z5)) {
        }
        if (moreBtnText == null) {
        }
    }

    private final void setSubTitle(yr0 yr0Var) {
        String str;
        boolean z;
        bs0 bs0Var;
        ds0 ds0Var;
        bs0 bs0Var2;
        ds0 ds0Var2;
        TextView subTitle = getSubTitle();
        String str2 = null;
        if (yr0Var != null && (bs0Var2 = yr0Var.j) != null && (ds0Var2 = bs0Var2.i) != null) {
            str = ds0Var2.m;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            if (yr0Var != null && (bs0Var = yr0Var.j) != null && (ds0Var = bs0Var.i) != null) {
                str2 = ds0Var.m;
            }
            subTitle.setText(str2);
        }
        subTitle.setOnClickListener(new f(yr0Var));
    }

    private final void setTitle(yr0 yr0Var) {
        String str;
        boolean z;
        bs0 bs0Var;
        ds0 ds0Var;
        bs0 bs0Var2;
        ds0 ds0Var2;
        TextView title = getTitle();
        String str2 = null;
        if (yr0Var != null && (bs0Var2 = yr0Var.j) != null && (ds0Var2 = bs0Var2.i) != null) {
            str = ds0Var2.l;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            if (yr0Var != null && (bs0Var = yr0Var.j) != null && (ds0Var = bs0Var.i) != null) {
                str2 = ds0Var.l;
            }
            title.setText(str2);
        }
        title.setOnClickListener(new g(yr0Var));
    }

    public final void h(String str, ClogBuilder.LogType logType, String str2) {
        String str3;
        yr0 yr0Var;
        List<MonitorUrl> list;
        boolean z;
        ur0 ur0Var;
        bs0 bs0Var;
        ds0 ds0Var;
        sp0 sp0Var;
        yr0 yr0Var2 = this.l;
        boolean z2 = true;
        if (yr0Var2 != null && (bs0Var = yr0Var2.j) != null && (ds0Var = bs0Var.i) != null && !ds0Var.C && (sp0Var = this.n) != null && sp0Var.a(str, logType, str2)) {
            return;
        }
        ClogBuilder u = new ClogBuilder().j(str).y(logType).u(ClogBuilder.Page.WELFARETAIL);
        yr0 yr0Var3 = this.l;
        if (yr0Var3 != null && (ur0Var = yr0Var3.f) != null) {
            str3 = ur0Var.d;
        } else {
            str3 = null;
        }
        r31.b(u.p(str3));
        if (logType == ClogBuilder.LogType.CLICK && (yr0Var = this.l) != null && (list = yr0Var.e) != null) {
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
                s31.b(monitorUrl.clickUrl);
            }
        }
        if (str2 != null && str2.length() != 0) {
            z2 = false;
        }
        if (!z2) {
            xj0.c(str2, getContext());
        }
    }

    public final void j() {
        tn0.a().b(this, new a(qi0.class));
    }
}
