package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.txt.UnifyTextView;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.R;
import com.baidu.tieba.as0;
import com.baidu.tieba.cj0;
import com.baidu.tieba.cs0;
import com.baidu.tieba.fr0;
import com.baidu.tieba.gp0;
import com.baidu.tieba.il0;
import com.baidu.tieba.jp0;
import com.baidu.tieba.jr0;
import com.baidu.tieba.m61;
import com.baidu.tieba.mi0;
import com.baidu.tieba.np0;
import com.baidu.tieba.nr0;
import com.baidu.tieba.oi0;
import com.baidu.tieba.p51;
import com.baidu.tieba.q61;
import com.baidu.tieba.s51;
import com.baidu.tieba.tr0;
import com.baidu.tieba.vp0;
import com.baidu.tieba.wr0;
import com.baidu.tieba.x31;
import com.baidu.tieba.y31;
import com.baidu.tieba.yr0;
import com.baidu.webkit.sdk.WebChromeClient;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010`\u001a\u00020_\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010a\u0012\b\b\u0002\u0010d\u001a\u00020c¢\u0006\u0004\be\u0010fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0011J\u001d\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u0011J\u0017\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001c\u0010\u0011J\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010!R\u001d\u0010'\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010,\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+R\u001d\u00101\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010$\u001a\u0004\b/\u00100R\u001d\u00106\u001a\u0002028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010$\u001a\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001d\u0010<\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010$\u001a\u0004\b;\u00100R\u001d\u0010?\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010$\u001a\u0004\b>\u0010&R\u001d\u0010B\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010$\u001a\u0004\bA\u0010+R\u001d\u0010E\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010$\u001a\u0004\bD\u00100R\u001d\u0010H\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010$\u001a\u0004\bG\u00100R\u001d\u0010K\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010$\u001a\u0004\bJ\u00100R\u001d\u0010P\u001a\u00020L8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010$\u001a\u0004\bN\u0010OR\u001d\u0010S\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010$\u001a\u0004\bR\u0010&R\u001e\u0010T\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u001d\u0010X\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010$\u001a\u0004\bW\u00100R\u001d\u0010[\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010$\u001a\u0004\bZ\u00100R\u001d\u0010^\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010$\u001a\u0004\b]\u00100¨\u0006g"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardFullTailView;", "Lcom/baidu/tieba/gp0;", "Landroid/widget/RelativeLayout;", "Landroid/view/ViewGroup;", "getView", "()Landroid/view/ViewGroup;", "", DnsModel.AREA_KEY, "Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;", "logType", "scheme", "", "handleClick", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;)V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setAppInfo", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "setAvatar", "setData", "setDownloadButton", "setMoreButton", "Lkotlin/Function0;", WebChromeClient.KEY_ARG_CALLBACK, "setOnReplayClickListener", "(Lkotlin/Function0;)V", "setReplayButton", "setSubTitle", "setTitle", "", "isVisible", "setVisibility", "(Z)V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Landroid/widget/LinearLayout;", "appInfoView$delegate", "Lkotlin/Lazy;", "getAppInfoView", "()Landroid/widget/LinearLayout;", "appInfoView", "Lcom/baidu/nadcore/widget/AdImageView;", "avatar$delegate", "getAvatar", "()Lcom/baidu/nadcore/widget/AdImageView;", "avatar", "Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "developerName$delegate", "getDeveloperName", "()Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "developerName", "Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton$delegate", "getDownloadButton", "()Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "downloadPresenter", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "featureView$delegate", "getFeatureView", "featureView", "moreBtnContainer$delegate", "getMoreBtnContainer", "moreBtnContainer", "moreBtnIcon$delegate", "getMoreBtnIcon", "moreBtnIcon", "moreBtnText$delegate", "getMoreBtnText", "moreBtnText", "permissionView$delegate", "getPermissionView", "permissionView", "privacyView$delegate", "getPrivacyView", "privacyView", "Landroid/widget/ImageView;", "replayBtnIcon$delegate", "getReplayBtnIcon", "()Landroid/widget/ImageView;", "replayBtnIcon", "replayButton$delegate", "getReplayButton", "replayButton", "replayClickListener", "Lkotlin/Function0;", "subTitle$delegate", "getSubTitle", "subTitle", "title$delegate", "getTitle", "title", "version$delegate", WebChromeClient.MSG_METHOD_GETVERSION, "version", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRewardFullTailView extends RelativeLayout implements gp0 {
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
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public tr0 p;
    public Function0<Unit> q;
    public mi0 r;

    @JvmOverloads
    public NadRewardFullTailView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public NadRewardFullTailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final LinearLayout getAppInfoView() {
        return (LinearLayout) this.j.getValue();
    }

    private final AdImageView getAvatar() {
        return (AdImageView) this.a.getValue();
    }

    private final UnifyTextView getDeveloperName() {
        return (UnifyTextView) this.l.getValue();
    }

    private final NadMiniVideoDownloadView getDownloadButton() {
        return (NadMiniVideoDownloadView) this.d.getValue();
    }

    private final UnifyTextView getFeatureView() {
        return (UnifyTextView) this.o.getValue();
    }

    private final LinearLayout getMoreBtnContainer() {
        return (LinearLayout) this.g.getValue();
    }

    private final AdImageView getMoreBtnIcon() {
        return (AdImageView) this.h.getValue();
    }

    private final UnifyTextView getMoreBtnText() {
        return (UnifyTextView) this.i.getValue();
    }

    private final UnifyTextView getPermissionView() {
        return (UnifyTextView) this.n.getValue();
    }

    private final UnifyTextView getPrivacyView() {
        return (UnifyTextView) this.m.getValue();
    }

    private final ImageView getReplayBtnIcon() {
        return (ImageView) this.f.getValue();
    }

    private final LinearLayout getReplayButton() {
        return (LinearLayout) this.e.getValue();
    }

    private final UnifyTextView getSubTitle() {
        return (UnifyTextView) this.c.getValue();
    }

    private final UnifyTextView getTitle() {
        return (UnifyTextView) this.b.getValue();
    }

    private final UnifyTextView getVersion() {
        return (UnifyTextView) this.k.getValue();
    }

    @Override // com.baidu.tieba.gp0
    public ViewGroup getView() {
        return this;
    }

    /* loaded from: classes3.dex */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ tr0 b;

        public a(UnifyTextView unifyTextView, tr0 tr0Var) {
            this.a = unifyTextView;
            this.b = tr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            as0 as0Var;
            p51 a = s51.a();
            Context context = this.a.getContext();
            tr0 tr0Var = this.b;
            if (tr0Var != null && (as0Var = tr0Var.i) != null) {
                str = as0Var.f;
            } else {
                str = null;
            }
            a.b(context, str, 0);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ tr0 b;

        public b(UnifyTextView unifyTextView, tr0 tr0Var) {
            this.a = unifyTextView;
            this.b = tr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            as0 as0Var;
            p51 a = s51.a();
            Context context = this.a.getContext();
            tr0 tr0Var = this.b;
            if (tr0Var != null && (as0Var = tr0Var.i) != null) {
                str = as0Var.d;
            } else {
                str = null;
            }
            a.b(context, str, 0);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ NadRewardFullTailView b;
        public final /* synthetic */ tr0 c;

        public c(UnifyTextView unifyTextView, NadRewardFullTailView nadRewardFullTailView, tr0 tr0Var) {
            this.a = unifyTextView;
            this.b = nadRewardFullTailView;
            this.c = tr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            as0.c cVar;
            NadRewardFullTailView nadRewardFullTailView = this.b;
            String str2 = ClogBuilder.Area.APP_PRIVACY.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PRIVACY.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            as0 as0Var = this.c.i;
            if (as0Var != null && (cVar = as0Var.g) != null) {
                str = cVar.b;
            } else {
                str = null;
            }
            nadRewardFullTailView.d(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ NadRewardFullTailView b;
        public final /* synthetic */ tr0 c;

        public d(UnifyTextView unifyTextView, NadRewardFullTailView nadRewardFullTailView, tr0 tr0Var) {
            this.a = unifyTextView;
            this.b = nadRewardFullTailView;
            this.c = tr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            as0.b bVar;
            NadRewardFullTailView nadRewardFullTailView = this.b;
            String str2 = ClogBuilder.Area.APP_PERMISSION.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PERMISSION.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            as0 as0Var = this.c.i;
            if (as0Var != null && (bVar = as0Var.h) != null) {
                str = bVar.b;
            } else {
                str = null;
            }
            nadRewardFullTailView.d(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ NadRewardFullTailView b;
        public final /* synthetic */ tr0 c;

        public e(UnifyTextView unifyTextView, NadRewardFullTailView nadRewardFullTailView, tr0 tr0Var) {
            this.a = unifyTextView;
            this.b = nadRewardFullTailView;
            this.c = tr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            as0.a aVar;
            NadRewardFullTailView nadRewardFullTailView = this.b;
            String str2 = ClogBuilder.Area.APP_FEATURE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_FEATURE.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            as0 as0Var = this.c.i;
            if (as0Var != null && (aVar = as0Var.i) != null) {
                str = aVar.b;
            } else {
                str = null;
            }
            nadRewardFullTailView.d(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements View.OnClickListener {
        public final /* synthetic */ tr0 b;

        public f(tr0 tr0Var) {
            this.b = tr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            yr0 yr0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            wr0 wr0Var = this.b.j;
            if (wr0Var != null && (yr0Var = wr0Var.i) != null) {
                str = yr0Var.h();
            } else {
                str = null;
            }
            nadRewardFullTailView.d("icon", logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements View.OnClickListener {
        public final /* synthetic */ tr0 b;

        public g(tr0 tr0Var) {
            this.b = tr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            mi0 mi0Var = NadRewardFullTailView.this.r;
            if (mi0Var != null) {
                mi0Var.l();
            }
            oi0.b(this.b.e);
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements View.OnClickListener {
        public final /* synthetic */ tr0 b;

        public h(tr0 tr0Var) {
            this.b = tr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            yr0 yr0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            wr0 wr0Var = this.b.j;
            if (wr0Var != null && (yr0Var = wr0Var.i) != null) {
                str = yr0Var.z;
            } else {
                str = null;
            }
            nadRewardFullTailView.d("morebtn", logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardFullTailView.this.d("replaybtn", ClogBuilder.LogType.FREE_CLICK, null);
            Function0 function0 = NadRewardFullTailView.this.q;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class j implements View.OnClickListener {
        public final /* synthetic */ tr0 b;

        public j(tr0 tr0Var) {
            this.b = tr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            yr0 yr0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            wr0 wr0Var = this.b.j;
            if (wr0Var != null && (yr0Var = wr0Var.i) != null) {
                str = yr0Var.h();
            } else {
                str = null;
            }
            nadRewardFullTailView.d("tail_subtitle", logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class k implements View.OnClickListener {
        public final /* synthetic */ tr0 b;

        public k(tr0 tr0Var) {
            this.b = tr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            yr0 yr0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            wr0 wr0Var = this.b.j;
            if (wr0Var != null && (yr0Var = wr0Var.i) != null) {
                str = yr0Var.h();
            } else {
                str = null;
            }
            nadRewardFullTailView.d("name", logType, str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadRewardFullTailView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$avatar$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdImageView invoke() {
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.obfuscated_res_0x7f09031c);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.avatar)");
                return (AdImageView) findViewById;
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$title$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.obfuscated_res_0x7f0925d1);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
                return (UnifyTextView) findViewById;
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$subTitle$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.obfuscated_res_0x7f09233c);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.sub_title)");
                return (UnifyTextView) findViewById;
            }
        });
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<NadMiniVideoDownloadView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$downloadButton$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NadMiniVideoDownloadView invoke() {
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.download_btn);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.download_btn)");
                return (NadMiniVideoDownloadView) findViewById;
            }
        });
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$replayButton$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.replay_btn);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.replay_btn)");
                return (LinearLayout) findViewById;
            }
        });
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$replayBtnIcon$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.replay_btn_icon);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.replay_btn_icon)");
                return (ImageView) findViewById;
            }
        });
        this.g = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$moreBtnContainer$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.more_btn_container);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.more_btn_container)");
                return (LinearLayout) findViewById;
            }
        });
        this.h = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$moreBtnIcon$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdImageView invoke() {
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.more_btn_icon);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.more_btn_icon)");
                return (AdImageView) findViewById;
            }
        });
        this.i = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$moreBtnText$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.more_btn_text);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.more_btn_text)");
                return (UnifyTextView) findViewById;
            }
        });
        this.j = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$appInfoView$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.app_info_container);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.app_info_container)");
                return (LinearLayout) findViewById;
            }
        });
        this.k = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$version$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.ad_version);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_version)");
                return (UnifyTextView) findViewById;
            }
        });
        this.l = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$developerName$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.ad_author_full_name);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_author_full_name)");
                return (UnifyTextView) findViewById;
            }
        });
        this.m = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$privacyView$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.ad_privacy);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_privacy)");
                return (UnifyTextView) findViewById;
            }
        });
        this.n = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$permissionView$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.ad_permission);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_permission)");
                return (UnifyTextView) findViewById;
            }
        });
        this.o = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$featureView$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.ad_feature);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_feature)");
                return (UnifyTextView) findViewById;
            }
        });
        LayoutInflater from = LayoutInflater.from(context);
        jp0 a2 = np0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        from.inflate(a2.c(), this);
        setBackgroundColor(ContextCompat.getColor(context, R.color.nad_reward_full_tail_bg_color));
    }

    public /* synthetic */ NadRewardFullTailView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void setAvatar(tr0 tr0Var) {
        String str;
        yr0 yr0Var;
        AdImageView avatar = getAvatar();
        wr0 wr0Var = tr0Var.j;
        if (wr0Var != null && (yr0Var = wr0Var.i) != null) {
            str = yr0Var.d;
        } else {
            str = null;
        }
        avatar.r(str);
        avatar.setOnClickListener(new f(tr0Var));
    }

    private final void setReplayButton(tr0 tr0Var) {
        int i2;
        getReplayButton().setOnClickListener(new i());
        ImageView replayBtnIcon = getReplayBtnIcon();
        cs0 c2 = tr0Var.c();
        if (c2 != null && c2.e()) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        replayBtnIcon.setVisibility(i2);
    }

    @Override // com.baidu.tieba.gp0
    public void setData(tr0 adModel) {
        Intrinsics.checkNotNullParameter(adModel, "adModel");
        this.p = adModel;
        setAvatar(adModel);
        setTitle(adModel);
        setSubTitle(adModel);
        setDownloadButton(adModel);
        setReplayButton(adModel);
        setMoreButton(adModel);
        setAppInfo(adModel);
        setClickable(true);
    }

    @Override // com.baidu.tieba.gp0
    public void setOnReplayClickListener(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.q = callback;
    }

    @Override // com.baidu.tieba.gp0
    public void setVisibility(boolean z) {
        int i2;
        tr0 tr0Var;
        if (z && (tr0Var = this.p) != null) {
            setMoreButton(tr0Var);
        }
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        setVisibility(i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:150:0x0186, code lost:
        if (r1 == false) goto L119;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setAppInfo(tr0 tr0Var) {
        String str;
        boolean z;
        UnifyTextView unifyTextView;
        String str2;
        boolean z2;
        UnifyTextView unifyTextView2;
        String str3;
        boolean z3;
        boolean z4;
        UnifyTextView unifyTextView3;
        as0 as0Var;
        String str4;
        boolean z5;
        boolean z6;
        UnifyTextView unifyTextView4;
        as0 as0Var2;
        String str5;
        boolean z7;
        as0 as0Var3;
        as0.a aVar;
        String str6;
        boolean z8;
        as0.a aVar2;
        as0.a aVar3;
        String str7;
        as0.b bVar;
        String str8;
        boolean z9;
        as0.b bVar2;
        as0.b bVar3;
        String str9;
        as0.c cVar;
        String str10;
        boolean z10;
        as0.c cVar2;
        as0.c cVar3;
        String str11;
        String str12;
        LinearLayout appInfoView = getAppInfoView();
        if (oi0.a(tr0Var.i)) {
            appInfoView.setVisibility(0);
        } else {
            appInfoView.setVisibility(8);
        }
        UnifyTextView version = getVersion();
        as0 as0Var4 = tr0Var.i;
        String str13 = null;
        if (as0Var4 != null) {
            str = as0Var4.f;
        } else {
            str = null;
        }
        boolean z11 = true;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            version.setVisibility(0);
            unifyTextView = version;
        } else {
            version.setVisibility(8);
            unifyTextView = null;
        }
        if (unifyTextView != null) {
            as0 as0Var5 = tr0Var.i;
            if (as0Var5 != null) {
                str12 = as0Var5.f;
            } else {
                str12 = null;
            }
            version.setTextWithUnifiedPadding(str12, TextView.BufferType.NORMAL);
            version.setOnClickListener(new a(version, tr0Var));
        }
        UnifyTextView developerName = getDeveloperName();
        as0 as0Var6 = tr0Var.i;
        if (as0Var6 != null) {
            str2 = as0Var6.d;
        } else {
            str2 = null;
        }
        if (str2 != null && str2.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            developerName.setVisibility(0);
            unifyTextView2 = developerName;
        } else {
            developerName.setVisibility(8);
            unifyTextView2 = null;
        }
        if (unifyTextView2 != null) {
            as0 as0Var7 = tr0Var.i;
            if (as0Var7 != null) {
                str11 = as0Var7.d;
            } else {
                str11 = null;
            }
            developerName.setTextWithUnifiedPadding(str11, TextView.BufferType.NORMAL);
            developerName.setOnClickListener(new b(developerName, tr0Var));
        }
        UnifyTextView privacyView = getPrivacyView();
        as0 as0Var8 = tr0Var.i;
        if (as0Var8 != null && (cVar3 = as0Var8.g) != null) {
            str3 = cVar3.a;
        } else {
            str3 = null;
        }
        if (str3 != null && str3.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            as0 as0Var9 = tr0Var.i;
            if (as0Var9 != null && (cVar2 = as0Var9.g) != null) {
                str10 = cVar2.b;
            } else {
                str10 = null;
            }
            if (str10 != null && str10.length() != 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z10) {
                z4 = true;
                if (!z4) {
                    privacyView.setVisibility(0);
                    unifyTextView3 = privacyView;
                } else {
                    privacyView.setVisibility(8);
                    unifyTextView3 = null;
                }
                if (unifyTextView3 != null) {
                    as0 as0Var10 = tr0Var.i;
                    if (as0Var10 != null && (cVar = as0Var10.g) != null) {
                        str9 = cVar.a;
                    } else {
                        str9 = null;
                    }
                    privacyView.setTextWithUnifiedPadding(str9, TextView.BufferType.NORMAL);
                    privacyView.setOnClickListener(new c(privacyView, this, tr0Var));
                }
                UnifyTextView permissionView = getPermissionView();
                as0Var = tr0Var.i;
                if (as0Var == null && (bVar3 = as0Var.h) != null) {
                    str4 = bVar3.a;
                } else {
                    str4 = null;
                }
                if (str4 == null && str4.length() != 0) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (!z5) {
                    as0 as0Var11 = tr0Var.i;
                    if (as0Var11 != null && (bVar2 = as0Var11.h) != null) {
                        str8 = bVar2.b;
                    } else {
                        str8 = null;
                    }
                    if (str8 != null && str8.length() != 0) {
                        z9 = false;
                    } else {
                        z9 = true;
                    }
                    if (!z9) {
                        z6 = true;
                        if (z6) {
                            permissionView.setVisibility(0);
                            unifyTextView4 = permissionView;
                        } else {
                            permissionView.setVisibility(8);
                            unifyTextView4 = null;
                        }
                        if (unifyTextView4 != null) {
                            as0 as0Var12 = tr0Var.i;
                            if (as0Var12 != null && (bVar = as0Var12.h) != null) {
                                str7 = bVar.a;
                            } else {
                                str7 = null;
                            }
                            permissionView.setTextWithUnifiedPadding(str7, TextView.BufferType.NORMAL);
                            permissionView.setOnClickListener(new d(permissionView, this, tr0Var));
                        }
                        UnifyTextView featureView = getFeatureView();
                        as0Var2 = tr0Var.i;
                        if (as0Var2 == null && (aVar3 = as0Var2.i) != null) {
                            str5 = aVar3.a;
                        } else {
                            str5 = null;
                        }
                        if (str5 == null && str5.length() != 0) {
                            z7 = false;
                        } else {
                            z7 = true;
                        }
                        if (!z7) {
                            as0 as0Var13 = tr0Var.i;
                            if (as0Var13 != null && (aVar2 = as0Var13.i) != null) {
                                str6 = aVar2.b;
                            } else {
                                str6 = null;
                            }
                            if (str6 != null && str6.length() != 0) {
                                z8 = false;
                            } else {
                                z8 = true;
                            }
                        }
                        z11 = false;
                        if (z11) {
                            featureView.setVisibility(0);
                        } else {
                            featureView.setVisibility(8);
                        }
                        as0Var3 = tr0Var.i;
                        if (as0Var3 != null && (aVar = as0Var3.i) != null) {
                            str13 = aVar.a;
                        }
                        featureView.setTextWithUnifiedPadding(str13, TextView.BufferType.NORMAL);
                        featureView.setOnClickListener(new e(featureView, this, tr0Var));
                    }
                }
                z6 = false;
                if (z6) {
                }
                if (unifyTextView4 != null) {
                }
                UnifyTextView featureView2 = getFeatureView();
                as0Var2 = tr0Var.i;
                if (as0Var2 == null) {
                }
                str5 = null;
                if (str5 == null) {
                }
                z7 = true;
                if (!z7) {
                }
                z11 = false;
                if (z11) {
                }
                as0Var3 = tr0Var.i;
                if (as0Var3 != null) {
                    str13 = aVar.a;
                }
                featureView2.setTextWithUnifiedPadding(str13, TextView.BufferType.NORMAL);
                featureView2.setOnClickListener(new e(featureView2, this, tr0Var));
            }
        }
        z4 = false;
        if (!z4) {
        }
        if (unifyTextView3 != null) {
        }
        UnifyTextView permissionView2 = getPermissionView();
        as0Var = tr0Var.i;
        if (as0Var == null) {
        }
        str4 = null;
        if (str4 == null) {
        }
        z5 = true;
        if (!z5) {
        }
        z6 = false;
        if (z6) {
        }
        if (unifyTextView4 != null) {
        }
        UnifyTextView featureView22 = getFeatureView();
        as0Var2 = tr0Var.i;
        if (as0Var2 == null) {
        }
        str5 = null;
        if (str5 == null) {
        }
        z7 = true;
        if (!z7) {
        }
        z11 = false;
        if (z11) {
        }
        as0Var3 = tr0Var.i;
        if (as0Var3 != null) {
        }
        featureView22.setTextWithUnifiedPadding(str13, TextView.BufferType.NORMAL);
        featureView22.setOnClickListener(new e(featureView22, this, tr0Var));
    }

    private final void setDownloadButton(tr0 tr0Var) {
        String str;
        boolean z;
        String str2;
        Object obj;
        fr0 fr0Var;
        jr0 jr0Var;
        fr0 fr0Var2;
        yr0 yr0Var;
        yr0 yr0Var2;
        mi0 mi0Var = this.r;
        if (mi0Var != null) {
            mi0Var.j();
        }
        String str3 = null;
        this.r = null;
        NadMiniVideoDownloadView downloadButton = getDownloadButton();
        Resources resources = downloadButton.getResources();
        jp0 a2 = np0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension = resources.getDimension(a2.i());
        GradientDrawable gradientDrawable = new GradientDrawable();
        wr0 wr0Var = tr0Var.j;
        if (wr0Var != null && (yr0Var2 = wr0Var.i) != null) {
            str = yr0Var2.i;
        } else {
            str = null;
        }
        gradientDrawable.setColor(m61.a(str, R.color.nad_reward_full_tail_btn_color));
        gradientDrawable.setCornerRadius(dimension);
        Unit unit = Unit.INSTANCE;
        downloadButton.setBackground(gradientDrawable);
        downloadButton.setBorderRadius(dimension);
        downloadButton.setTextColor(ContextCompat.getColor(downloadButton.getContext(), R.color.nad_reward_full_tail_btn_text_color));
        downloadButton.setProgressColor(ContextCompat.getColor(downloadButton.getContext(), R.color.nad_reward_full_tail_btn_download_progress));
        cs0 c2 = tr0Var.c();
        if (c2 != null) {
            z = c2.e();
        } else {
            z = false;
        }
        downloadButton.setIconArrowSwitch(z);
        wr0 wr0Var2 = tr0Var.j;
        if (wr0Var2 != null && (yr0Var = wr0Var2.i) != null) {
            str2 = yr0Var.b;
        } else {
            str2 = null;
        }
        boolean z2 = true;
        if ((!Intrinsics.areEqual(str2, "download") || (jr0Var = tr0Var.m) == null || (fr0Var2 = jr0Var.p) == null || !fr0Var2.e) ? false : false) {
            downloadButton.setVisibility(0);
            obj = downloadButton;
        } else {
            downloadButton.setVisibility(8);
            obj = null;
        }
        if (obj != null) {
            jr0 jr0Var2 = tr0Var.m;
            if (jr0Var2 != null) {
                fr0Var = jr0Var2.p;
            } else {
                fr0Var = null;
            }
            String str4 = tr0Var.f.d;
            jr0 jr0Var3 = tr0Var.m;
            if (jr0Var3 != null) {
                str3 = jr0Var3.t;
            }
            il0 d2 = il0.d(fr0Var, str4, str3);
            Intrinsics.checkNotNullExpressionValue(d2, "AdDownloadBean.from(adMo….enhanceModel?.btnScheme)");
            d2.q.a = ClogBuilder.Page.WELFARETAIL.type;
            mi0 mi0Var2 = new mi0(d2, getDownloadButton());
            this.r = mi0Var2;
            Intrinsics.checkNotNull(mi0Var2);
            mi0Var2.z();
        }
        downloadButton.setOnClickListener(new g(tr0Var));
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setMoreButton(tr0 tr0Var) {
        String str;
        boolean z;
        boolean z2;
        LinearLayout linearLayout;
        AdImageView moreBtnIcon;
        wr0 wr0Var;
        String str2;
        boolean z3;
        UnifyTextView moreBtnText;
        wr0 wr0Var2;
        String str3;
        wr0 wr0Var3;
        String str4;
        boolean z4;
        yr0 yr0Var;
        yr0 yr0Var2;
        yr0 yr0Var3;
        String str5;
        yr0 yr0Var4;
        yr0 yr0Var5;
        String str6;
        yr0 yr0Var6;
        String str7;
        boolean z5;
        yr0 yr0Var7;
        yr0 yr0Var8;
        LinearLayout moreBtnContainer = getMoreBtnContainer();
        wr0 wr0Var4 = tr0Var.j;
        String str8 = null;
        if (wr0Var4 != null && (yr0Var8 = wr0Var4.i) != null) {
            str = yr0Var8.x;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            wr0 wr0Var5 = tr0Var.j;
            if (wr0Var5 != null && (yr0Var7 = wr0Var5.i) != null) {
                str7 = yr0Var7.y;
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
                    gradientDrawable.setCornerRadius(q61.c.a(moreBtnContainer.getContext(), 17.0f));
                    wr0 wr0Var6 = tr0Var.j;
                    if (wr0Var6 != null && (yr0Var6 = wr0Var6.i) != null) {
                        str6 = yr0Var6.A;
                    } else {
                        str6 = null;
                    }
                    gradientDrawable.setStroke(2, m61.a(str6, R.color.nad_reward_full_tail_more_btn_border));
                    gradientDrawable.setAlpha((int) 127.5d);
                    Unit unit = Unit.INSTANCE;
                    linearLayout.setBackground(gradientDrawable);
                }
                moreBtnContainer.setOnClickListener(new h(tr0Var));
                moreBtnIcon = getMoreBtnIcon();
                wr0Var = tr0Var.j;
                if (wr0Var == null && (yr0Var5 = wr0Var.i) != null) {
                    str2 = yr0Var5.x;
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
                    wr0 wr0Var7 = tr0Var.j;
                    if (wr0Var7 != null && (yr0Var4 = wr0Var7.i) != null) {
                        str5 = yr0Var4.x;
                    } else {
                        str5 = null;
                    }
                    moreBtnIcon.r(str5);
                }
                moreBtnText = getMoreBtnText();
                wr0Var2 = tr0Var.j;
                if (wr0Var2 == null && (yr0Var3 = wr0Var2.i) != null) {
                    str3 = yr0Var3.B;
                } else {
                    str3 = null;
                }
                moreBtnText.setTextColor(m61.a(str3, 17170443));
                wr0Var3 = tr0Var.j;
                if (wr0Var3 == null && (yr0Var2 = wr0Var3.i) != null) {
                    str4 = yr0Var2.y;
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
                    wr0 wr0Var8 = tr0Var.j;
                    if (wr0Var8 != null && (yr0Var = wr0Var8.i) != null) {
                        str8 = yr0Var.y;
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
        moreBtnContainer.setOnClickListener(new h(tr0Var));
        moreBtnIcon = getMoreBtnIcon();
        wr0Var = tr0Var.j;
        if (wr0Var == null) {
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
        wr0Var2 = tr0Var.j;
        if (wr0Var2 == null) {
        }
        str3 = null;
        moreBtnText.setTextColor(m61.a(str3, 17170443));
        wr0Var3 = tr0Var.j;
        if (wr0Var3 == null) {
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

    private final void setSubTitle(tr0 tr0Var) {
        String str;
        boolean z;
        yr0 yr0Var;
        yr0 yr0Var2;
        UnifyTextView subTitle = getSubTitle();
        wr0 wr0Var = tr0Var.j;
        String str2 = null;
        if (wr0Var != null && (yr0Var2 = wr0Var.i) != null) {
            str = yr0Var2.n;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            wr0 wr0Var2 = tr0Var.j;
            if (wr0Var2 != null && (yr0Var = wr0Var2.i) != null) {
                str2 = yr0Var.n;
            }
            subTitle.setText(str2);
        }
        subTitle.setOnClickListener(new j(tr0Var));
    }

    private final void setTitle(tr0 tr0Var) {
        String str;
        boolean z;
        yr0 yr0Var;
        yr0 yr0Var2;
        UnifyTextView title = getTitle();
        wr0 wr0Var = tr0Var.j;
        String str2 = null;
        if (wr0Var != null && (yr0Var2 = wr0Var.i) != null) {
            str = yr0Var2.c;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            wr0 wr0Var2 = tr0Var.j;
            if (wr0Var2 != null && (yr0Var = wr0Var2.i) != null) {
                str2 = yr0Var.c;
            }
            title.setTextWithUnifiedPadding(str2, TextView.BufferType.NORMAL);
        }
        title.setOnClickListener(new k(tr0Var));
    }

    public final void d(String str, ClogBuilder.LogType logType, String str2) {
        String str3;
        tr0 tr0Var;
        List<MonitorUrl> list;
        boolean z;
        nr0 nr0Var;
        ClogBuilder u = new ClogBuilder().j(str).y(logType).u(ClogBuilder.Page.WELFARETAIL);
        tr0 tr0Var2 = this.p;
        if (tr0Var2 != null && (nr0Var = tr0Var2.f) != null) {
            str3 = nr0Var.d;
        } else {
            str3 = null;
        }
        x31.e(u.p(str3));
        if (logType == ClogBuilder.LogType.CLICK && (tr0Var = this.p) != null && (list = tr0Var.e) != null) {
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
                y31.b(monitorUrl.clickUrl);
            }
        }
        if ((Intrinsics.areEqual(str, "icon") || Intrinsics.areEqual(str, "name") || Intrinsics.areEqual(str, "tail_subtitle")) && this.p != null) {
            vp0 vp0Var = vp0.a;
            Context context = getContext();
            tr0 tr0Var3 = this.p;
            Intrinsics.checkNotNull(tr0Var3);
            vp0.e(vp0Var, context, tr0Var3, null, 4, null);
            return;
        }
        cj0.c(str2, getContext());
    }
}
