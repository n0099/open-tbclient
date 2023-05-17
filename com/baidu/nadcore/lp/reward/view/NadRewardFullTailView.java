package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.txt.UnifyTextView;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.R;
import com.baidu.tieba.dq0;
import com.baidu.tieba.e21;
import com.baidu.tieba.f21;
import com.baidu.tieba.go0;
import com.baidu.tieba.hq0;
import com.baidu.tieba.j41;
import com.baidu.tieba.ki0;
import com.baidu.tieba.lq0;
import com.baidu.tieba.oq0;
import com.baidu.tieba.p41;
import com.baidu.tieba.qk0;
import com.baidu.tieba.qq0;
import com.baidu.tieba.sq0;
import com.baidu.tieba.t41;
import com.baidu.tieba.uq0;
import com.baidu.tieba.wh0;
import com.baidu.tieba.xi0;
import com.baidu.tieba.yh0;
import com.baidu.tieba.zp0;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010]\u001a\u00020\\\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010^\u0012\b\b\u0002\u0010a\u001a\u00020`¢\u0006\u0004\bb\u0010cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0011J\u001d\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u0011J\u0017\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001c\u0010\u0011J\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010!R\u001d\u0010'\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010,\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+R\u001d\u00101\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010$\u001a\u0004\b/\u00100R\u001d\u00106\u001a\u0002028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010$\u001a\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001d\u0010<\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010$\u001a\u0004\b;\u0010&R\u001d\u0010?\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010$\u001a\u0004\b>\u0010+R\u001d\u0010B\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010$\u001a\u0004\bA\u00100R\u001d\u0010E\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010$\u001a\u0004\bD\u00100R\u001d\u0010H\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010$\u001a\u0004\bG\u00100R\u001d\u0010M\u001a\u00020I8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010$\u001a\u0004\bK\u0010LR\u001d\u0010P\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010$\u001a\u0004\bO\u0010&R\u001e\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u001d\u0010U\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010$\u001a\u0004\bT\u00100R\u001d\u0010X\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010$\u001a\u0004\bW\u00100R\u001d\u0010[\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010$\u001a\u0004\bZ\u00100¨\u0006d"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardFullTailView;", "Lcom/baidu/tieba/go0;", "Landroid/widget/RelativeLayout;", "Landroid/view/ViewGroup;", "getView", "()Landroid/view/ViewGroup;", "", DnsModel.AREA_KEY, "Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;", "logType", "scheme", "", "handleClick", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;)V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setAppInfo", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "setAvatar", "setData", "setDownloadButton", "setMoreButton", "Lkotlin/Function0;", WebChromeClient.KEY_ARG_CALLBACK, "setOnReplayClickListener", "(Lkotlin/Function0;)V", "setReplayButton", "setSubTitle", "setTitle", "", "isVisible", "setVisibility", "(Z)V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Landroid/widget/LinearLayout;", "appInfoView$delegate", "Lkotlin/Lazy;", "getAppInfoView", "()Landroid/widget/LinearLayout;", "appInfoView", "Lcom/baidu/nadcore/widget/AdImageView;", "avatar$delegate", "getAvatar", "()Lcom/baidu/nadcore/widget/AdImageView;", "avatar", "Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "developerName$delegate", "getDeveloperName", "()Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "developerName", "Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton$delegate", "getDownloadButton", "()Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "downloadPresenter", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "moreBtnContainer$delegate", "getMoreBtnContainer", "moreBtnContainer", "moreBtnIcon$delegate", "getMoreBtnIcon", "moreBtnIcon", "moreBtnText$delegate", "getMoreBtnText", "moreBtnText", "permissionView$delegate", "getPermissionView", "permissionView", "privacyView$delegate", "getPrivacyView", "privacyView", "Landroid/widget/ImageView;", "replayBtnIcon$delegate", "getReplayBtnIcon", "()Landroid/widget/ImageView;", "replayBtnIcon", "replayButton$delegate", "getReplayButton", "replayButton", "replayClickListener", "Lkotlin/Function0;", "subTitle$delegate", "getSubTitle", "subTitle", "title$delegate", "getTitle", "title", "version$delegate", WebChromeClient.MSG_METHOD_GETVERSION, "version", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRewardFullTailView extends RelativeLayout implements go0 {
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
    public lq0 o;
    public Function0<Unit> p;
    public wh0 q;

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

    @Override // com.baidu.tieba.go0
    public ViewGroup getView() {
        return this;
    }

    /* loaded from: classes3.dex */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ lq0 b;

        public a(UnifyTextView unifyTextView, lq0 lq0Var) {
            this.a = unifyTextView;
            this.b = lq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            Context context = this.a.getContext();
            sq0 sq0Var = this.b.i;
            if (sq0Var != null) {
                str = sq0Var.f;
            } else {
                str = null;
            }
            Toast.makeText(context, str, 0).show();
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ lq0 b;

        public b(UnifyTextView unifyTextView, lq0 lq0Var) {
            this.a = unifyTextView;
            this.b = lq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            Context context = this.a.getContext();
            sq0 sq0Var = this.b.i;
            if (sq0Var != null) {
                str = sq0Var.d;
            } else {
                str = null;
            }
            Toast.makeText(context, str, 0).show();
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ NadRewardFullTailView b;
        public final /* synthetic */ lq0 c;

        public c(UnifyTextView unifyTextView, NadRewardFullTailView nadRewardFullTailView, lq0 lq0Var) {
            this.a = unifyTextView;
            this.b = nadRewardFullTailView;
            this.c = lq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            sq0.b bVar;
            NadRewardFullTailView nadRewardFullTailView = this.b;
            String str2 = ClogBuilder.Area.APP_PRIVACY.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PRIVACY.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            sq0 sq0Var = this.c.i;
            if (sq0Var != null && (bVar = sq0Var.g) != null) {
                str = bVar.b;
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
        public final /* synthetic */ lq0 c;

        public d(UnifyTextView unifyTextView, NadRewardFullTailView nadRewardFullTailView, lq0 lq0Var) {
            this.a = unifyTextView;
            this.b = nadRewardFullTailView;
            this.c = lq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            sq0.a aVar;
            NadRewardFullTailView nadRewardFullTailView = this.b;
            String str2 = ClogBuilder.Area.APP_PERMISSION.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PERMISSION.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            sq0 sq0Var = this.c.i;
            if (sq0Var != null && (aVar = sq0Var.h) != null) {
                str = aVar.b;
            } else {
                str = null;
            }
            nadRewardFullTailView.d(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements View.OnClickListener {
        public final /* synthetic */ lq0 b;

        public e(lq0 lq0Var) {
            this.b = lq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            qq0 qq0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            oq0 oq0Var = this.b.j;
            if (oq0Var != null && (qq0Var = oq0Var.i) != null) {
                str = qq0Var.f;
            } else {
                str = null;
            }
            nadRewardFullTailView.d("icon", logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements View.OnClickListener {
        public final /* synthetic */ lq0 b;

        public f(lq0 lq0Var) {
            this.b = lq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            wh0 wh0Var = NadRewardFullTailView.this.q;
            if (wh0Var != null) {
                wh0Var.m();
            }
            yh0.b(this.b.e);
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements View.OnClickListener {
        public final /* synthetic */ lq0 b;

        public g(lq0 lq0Var) {
            this.b = lq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            qq0 qq0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            oq0 oq0Var = this.b.j;
            if (oq0Var != null && (qq0Var = oq0Var.i) != null) {
                str = qq0Var.y;
            } else {
                str = null;
            }
            nadRewardFullTailView.d("morebtn", logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardFullTailView.this.d("replaybtn", ClogBuilder.LogType.FREE_CLICK, null);
            Function0 function0 = NadRewardFullTailView.this.p;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class i implements View.OnClickListener {
        public final /* synthetic */ lq0 b;

        public i(lq0 lq0Var) {
            this.b = lq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            qq0 qq0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            oq0 oq0Var = this.b.j;
            if (oq0Var != null && (qq0Var = oq0Var.i) != null) {
                str = qq0Var.f;
            } else {
                str = null;
            }
            nadRewardFullTailView.d("tail_subtitle", logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class j implements View.OnClickListener {
        public final /* synthetic */ lq0 b;

        public j(lq0 lq0Var) {
            this.b = lq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            qq0 qq0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            oq0 oq0Var = this.b.j;
            if (oq0Var != null && (qq0Var = oq0Var.i) != null) {
                str = qq0Var.f;
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
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.obfuscated_res_0x7f090317);
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
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.obfuscated_res_0x7f09246f);
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
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.obfuscated_res_0x7f0921e6);
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
        LayoutInflater.from(context).inflate(R.layout.nad_reward_full_tail, this);
        setBackgroundColor(ContextCompat.getColor(context, R.color.nad_reward_full_tail_bg_color));
    }

    public /* synthetic */ NadRewardFullTailView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void setAvatar(lq0 lq0Var) {
        String str;
        qq0 qq0Var;
        AdImageView avatar = getAvatar();
        oq0 oq0Var = lq0Var.j;
        if (oq0Var != null && (qq0Var = oq0Var.i) != null) {
            str = qq0Var.d;
        } else {
            str = null;
        }
        avatar.o(str);
        avatar.setOnClickListener(new e(lq0Var));
    }

    private final void setReplayButton(lq0 lq0Var) {
        int i2;
        getReplayButton().setOnClickListener(new h());
        ImageView replayBtnIcon = getReplayBtnIcon();
        uq0 c2 = lq0Var.c();
        if (c2 != null && c2.f()) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        replayBtnIcon.setVisibility(i2);
    }

    @Override // com.baidu.tieba.go0
    public void setData(lq0 adModel) {
        Intrinsics.checkNotNullParameter(adModel, "adModel");
        this.o = adModel;
        setAvatar(adModel);
        setTitle(adModel);
        setSubTitle(adModel);
        setDownloadButton(adModel);
        setReplayButton(adModel);
        setMoreButton(adModel);
        setAppInfo(adModel);
    }

    @Override // com.baidu.tieba.go0
    public void setOnReplayClickListener(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.p = callback;
    }

    @Override // com.baidu.tieba.go0
    public void setVisibility(boolean z) {
        int i2;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        setVisibility(i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setAppInfo(lq0 lq0Var) {
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
        sq0 sq0Var;
        String str4;
        boolean z5;
        UnifyTextView unifyTextView4;
        sq0.a aVar;
        String str5;
        boolean z6;
        sq0.a aVar2;
        sq0.a aVar3;
        String str6;
        sq0.b bVar;
        String str7;
        boolean z7;
        sq0.b bVar2;
        sq0.b bVar3;
        String str8;
        String str9;
        LinearLayout appInfoView = getAppInfoView();
        if (yh0.a(lq0Var.i)) {
            appInfoView.setVisibility(0);
        } else {
            appInfoView.setVisibility(8);
        }
        UnifyTextView version = getVersion();
        sq0 sq0Var2 = lq0Var.i;
        String str10 = null;
        if (sq0Var2 != null) {
            str = sq0Var2.f;
        } else {
            str = null;
        }
        boolean z8 = true;
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
            sq0 sq0Var3 = lq0Var.i;
            if (sq0Var3 != null) {
                str9 = sq0Var3.f;
            } else {
                str9 = null;
            }
            version.setTextWithUnifiedPadding(str9, TextView.BufferType.NORMAL);
            version.setOnClickListener(new a(version, lq0Var));
        }
        UnifyTextView developerName = getDeveloperName();
        sq0 sq0Var4 = lq0Var.i;
        if (sq0Var4 != null) {
            str2 = sq0Var4.d;
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
            sq0 sq0Var5 = lq0Var.i;
            if (sq0Var5 != null) {
                str8 = sq0Var5.d;
            } else {
                str8 = null;
            }
            developerName.setTextWithUnifiedPadding(str8, TextView.BufferType.NORMAL);
            developerName.setOnClickListener(new b(developerName, lq0Var));
        }
        UnifyTextView privacyView = getPrivacyView();
        sq0 sq0Var6 = lq0Var.i;
        if (sq0Var6 != null && (bVar3 = sq0Var6.g) != null) {
            str3 = bVar3.a;
        } else {
            str3 = null;
        }
        if (str3 != null && str3.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            sq0 sq0Var7 = lq0Var.i;
            if (sq0Var7 != null && (bVar2 = sq0Var7.g) != null) {
                str7 = bVar2.b;
            } else {
                str7 = null;
            }
            if (str7 != null && str7.length() != 0) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (z7) {
                z4 = false;
                if (!z4) {
                    privacyView.setVisibility(0);
                    unifyTextView3 = privacyView;
                } else {
                    privacyView.setVisibility(8);
                    unifyTextView3 = null;
                }
                if (unifyTextView3 != null) {
                    sq0 sq0Var8 = lq0Var.i;
                    if (sq0Var8 != null && (bVar = sq0Var8.g) != null) {
                        str6 = bVar.a;
                    } else {
                        str6 = null;
                    }
                    privacyView.setTextWithUnifiedPadding(str6, TextView.BufferType.NORMAL);
                    privacyView.setOnClickListener(new c(privacyView, this, lq0Var));
                }
                UnifyTextView permissionView = getPermissionView();
                sq0Var = lq0Var.i;
                if (sq0Var == null && (aVar3 = sq0Var.h) != null) {
                    str4 = aVar3.a;
                } else {
                    str4 = null;
                }
                if (str4 == null && str4.length() != 0) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (z5) {
                    sq0 sq0Var9 = lq0Var.i;
                    if (sq0Var9 != null && (aVar2 = sq0Var9.h) != null) {
                        str5 = aVar2.b;
                    } else {
                        str5 = null;
                    }
                    if (str5 != null && str5.length() != 0) {
                        z6 = false;
                    } else {
                        z6 = true;
                    }
                    if (z6) {
                        z8 = false;
                    }
                }
                if (!z8) {
                    permissionView.setVisibility(0);
                    unifyTextView4 = permissionView;
                } else {
                    permissionView.setVisibility(8);
                    unifyTextView4 = null;
                }
                if (unifyTextView4 == null) {
                    sq0 sq0Var10 = lq0Var.i;
                    if (sq0Var10 != null && (aVar = sq0Var10.h) != null) {
                        str10 = aVar.a;
                    }
                    permissionView.setTextWithUnifiedPadding(str10, TextView.BufferType.NORMAL);
                    permissionView.setOnClickListener(new d(permissionView, this, lq0Var));
                    return;
                }
                return;
            }
        }
        z4 = true;
        if (!z4) {
        }
        if (unifyTextView3 != null) {
        }
        UnifyTextView permissionView2 = getPermissionView();
        sq0Var = lq0Var.i;
        if (sq0Var == null) {
        }
        str4 = null;
        if (str4 == null) {
        }
        z5 = true;
        if (z5) {
        }
        if (!z8) {
        }
        if (unifyTextView4 == null) {
        }
    }

    private final void setDownloadButton(lq0 lq0Var) {
        String str;
        boolean z;
        String str2;
        Object obj;
        zp0 zp0Var;
        dq0 dq0Var;
        zp0 zp0Var2;
        qq0 qq0Var;
        qq0 qq0Var2;
        wh0 wh0Var = this.q;
        if (wh0Var != null) {
            wh0Var.k();
        }
        String str3 = null;
        this.q = null;
        NadMiniVideoDownloadView downloadButton = getDownloadButton();
        int a2 = t41.c.a(downloadButton.getContext(), 16.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        oq0 oq0Var = lq0Var.j;
        if (oq0Var != null && (qq0Var2 = oq0Var.i) != null) {
            str = qq0Var2.h;
        } else {
            str = null;
        }
        gradientDrawable.setColor(p41.a(str, R.color.nad_reward_full_tail_btn_color));
        float f2 = a2;
        gradientDrawable.setCornerRadius(f2);
        Unit unit = Unit.INSTANCE;
        downloadButton.setBackground(gradientDrawable);
        downloadButton.setBorderRadius(f2);
        downloadButton.setTextSize(12.0f);
        downloadButton.setTextColor(ContextCompat.getColor(downloadButton.getContext(), R.color.nad_reward_full_tail_btn_text_color));
        downloadButton.setProgressColor(ContextCompat.getColor(downloadButton.getContext(), R.color.nad_reward_full_tail_btn_download_progress));
        uq0 c2 = lq0Var.c();
        if (c2 != null) {
            z = c2.f();
        } else {
            z = false;
        }
        downloadButton.setIconArrowSwitch(z);
        oq0 oq0Var2 = lq0Var.j;
        if (oq0Var2 != null && (qq0Var = oq0Var2.i) != null) {
            str2 = qq0Var.b;
        } else {
            str2 = null;
        }
        boolean z2 = true;
        if ((!Intrinsics.areEqual(str2, "download") || (dq0Var = lq0Var.m) == null || (zp0Var2 = dq0Var.p) == null || !zp0Var2.e) ? false : false) {
            downloadButton.setVisibility(0);
            obj = downloadButton;
        } else {
            downloadButton.setVisibility(8);
            obj = null;
        }
        if (obj != null) {
            dq0 dq0Var2 = lq0Var.m;
            if (dq0Var2 != null) {
                zp0Var = dq0Var2.p;
            } else {
                zp0Var = null;
            }
            String str4 = lq0Var.f.d;
            dq0 dq0Var3 = lq0Var.m;
            if (dq0Var3 != null) {
                str3 = dq0Var3.t;
            }
            qk0 d2 = qk0.d(zp0Var, str4, str3);
            Intrinsics.checkNotNullExpressionValue(d2, "AdDownloadBean.from(adMo….enhanceModel?.btnScheme)");
            d2.q.a = ClogBuilder.Page.WELFARETAIL.type;
            wh0 wh0Var2 = new wh0(d2, getDownloadButton());
            this.q = wh0Var2;
            Intrinsics.checkNotNull(wh0Var2);
            wh0Var2.A();
        }
        downloadButton.setOnClickListener(new f(lq0Var));
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0043, code lost:
        if (r1 == false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setMoreButton(lq0 lq0Var) {
        boolean z;
        LinearLayout linearLayout;
        AdImageView moreBtnIcon;
        oq0 oq0Var;
        String str;
        boolean z2;
        UnifyTextView moreBtnText;
        oq0 oq0Var2;
        String str2;
        oq0 oq0Var3;
        String str3;
        boolean z3;
        qq0 qq0Var;
        qq0 qq0Var2;
        qq0 qq0Var3;
        String str4;
        qq0 qq0Var4;
        qq0 qq0Var5;
        String str5;
        qq0 qq0Var6;
        String str6;
        boolean z4;
        String str7;
        boolean z5;
        qq0 qq0Var7;
        qq0 qq0Var8;
        LinearLayout moreBtnContainer = getMoreBtnContainer();
        String str8 = null;
        if (!lq0Var.h().d()) {
            oq0 oq0Var4 = lq0Var.j;
            if (oq0Var4 != null && (qq0Var8 = oq0Var4.i) != null) {
                str6 = qq0Var8.w;
            } else {
                str6 = null;
            }
            if (str6 != null && str6.length() != 0) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4) {
                oq0 oq0Var5 = lq0Var.j;
                if (oq0Var5 != null && (qq0Var7 = oq0Var5.i) != null) {
                    str7 = qq0Var7.x;
                } else {
                    str7 = null;
                }
                if (str7 != null && str7.length() != 0) {
                    z5 = false;
                } else {
                    z5 = true;
                }
            }
            z = true;
            if (!z) {
                moreBtnContainer.setVisibility(0);
                linearLayout = moreBtnContainer;
            } else {
                moreBtnContainer.setVisibility(8);
                linearLayout = null;
            }
            if (linearLayout != null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(t41.c.a(moreBtnContainer.getContext(), 17.0f));
                oq0 oq0Var6 = lq0Var.j;
                if (oq0Var6 != null && (qq0Var6 = oq0Var6.i) != null) {
                    str5 = qq0Var6.z;
                } else {
                    str5 = null;
                }
                gradientDrawable.setStroke(2, p41.a(str5, R.color.nad_reward_full_tail_more_btn_border));
                gradientDrawable.setAlpha((int) 127.5d);
                Unit unit = Unit.INSTANCE;
                linearLayout.setBackground(gradientDrawable);
            }
            moreBtnContainer.setOnClickListener(new g(lq0Var));
            moreBtnIcon = getMoreBtnIcon();
            oq0Var = lq0Var.j;
            if (oq0Var == null && (qq0Var5 = oq0Var.i) != null) {
                str = qq0Var5.w;
            } else {
                str = null;
            }
            if (str == null && str.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!(!z2)) {
                moreBtnIcon.setVisibility(0);
            } else {
                moreBtnIcon.setVisibility(8);
                moreBtnIcon = null;
            }
            if (moreBtnIcon != null) {
                oq0 oq0Var7 = lq0Var.j;
                if (oq0Var7 != null && (qq0Var4 = oq0Var7.i) != null) {
                    str4 = qq0Var4.w;
                } else {
                    str4 = null;
                }
                moreBtnIcon.o(str4);
            }
            moreBtnText = getMoreBtnText();
            oq0Var2 = lq0Var.j;
            if (oq0Var2 == null && (qq0Var3 = oq0Var2.i) != null) {
                str2 = qq0Var3.A;
            } else {
                str2 = null;
            }
            moreBtnText.setTextColor(p41.a(str2, 17170443));
            oq0Var3 = lq0Var.j;
            if (oq0Var3 == null && (qq0Var2 = oq0Var3.i) != null) {
                str3 = qq0Var2.x;
            } else {
                str3 = null;
            }
            if (str3 == null && str3.length() != 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!(!z3)) {
                moreBtnText.setVisibility(0);
            } else {
                moreBtnText.setVisibility(8);
                moreBtnText = null;
            }
            if (moreBtnText == null) {
                oq0 oq0Var8 = lq0Var.j;
                if (oq0Var8 != null && (qq0Var = oq0Var8.i) != null) {
                    str8 = qq0Var.x;
                }
                moreBtnText.setText(str8);
                return;
            }
            return;
        }
        z = false;
        if (!z) {
        }
        if (linearLayout != null) {
        }
        moreBtnContainer.setOnClickListener(new g(lq0Var));
        moreBtnIcon = getMoreBtnIcon();
        oq0Var = lq0Var.j;
        if (oq0Var == null) {
        }
        str = null;
        if (str == null) {
        }
        z2 = true;
        if (!(!z2)) {
        }
        if (moreBtnIcon != null) {
        }
        moreBtnText = getMoreBtnText();
        oq0Var2 = lq0Var.j;
        if (oq0Var2 == null) {
        }
        str2 = null;
        moreBtnText.setTextColor(p41.a(str2, 17170443));
        oq0Var3 = lq0Var.j;
        if (oq0Var3 == null) {
        }
        str3 = null;
        if (str3 == null) {
        }
        z3 = true;
        if (!(!z3)) {
        }
        if (moreBtnText == null) {
        }
    }

    private final void setSubTitle(lq0 lq0Var) {
        String str;
        boolean z;
        qq0 qq0Var;
        qq0 qq0Var2;
        UnifyTextView subTitle = getSubTitle();
        oq0 oq0Var = lq0Var.j;
        String str2 = null;
        if (oq0Var != null && (qq0Var2 = oq0Var.i) != null) {
            str = qq0Var2.m;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            oq0 oq0Var2 = lq0Var.j;
            if (oq0Var2 != null && (qq0Var = oq0Var2.i) != null) {
                str2 = qq0Var.m;
            }
            subTitle.setText(str2);
        }
        subTitle.setOnClickListener(new i(lq0Var));
    }

    private final void setTitle(lq0 lq0Var) {
        String str;
        boolean z;
        qq0 qq0Var;
        qq0 qq0Var2;
        UnifyTextView title = getTitle();
        oq0 oq0Var = lq0Var.j;
        String str2 = null;
        if (oq0Var != null && (qq0Var2 = oq0Var.i) != null) {
            str = qq0Var2.l;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            oq0 oq0Var2 = lq0Var.j;
            if (oq0Var2 != null && (qq0Var = oq0Var2.i) != null) {
                str2 = qq0Var.l;
            }
            title.setText(str2);
        }
        title.setOnClickListener(new j(lq0Var));
    }

    public final void d(String str, ClogBuilder.LogType logType, String str2) {
        String str3;
        lq0 lq0Var;
        dq0 dq0Var;
        zp0 zp0Var;
        String str4;
        boolean z;
        String str5;
        String str6;
        dq0 dq0Var2;
        zp0 zp0Var2;
        dq0 dq0Var3;
        zp0 zp0Var3;
        dq0 dq0Var4;
        zp0 zp0Var4;
        lq0 lq0Var2;
        List<MonitorUrl> list;
        boolean z2;
        hq0 hq0Var;
        ClogBuilder u = new ClogBuilder().j(str).y(logType).u(ClogBuilder.Page.WELFARETAIL);
        lq0 lq0Var3 = this.o;
        String str7 = null;
        if (lq0Var3 != null && (hq0Var = lq0Var3.f) != null) {
            str3 = hq0Var.d;
        } else {
            str3 = null;
        }
        e21.b(u.p(str3));
        boolean z3 = false;
        if (logType == ClogBuilder.LogType.CLICK && (lq0Var2 = this.o) != null && (list = lq0Var2.e) != null) {
            ArrayList<MonitorUrl> arrayList = new ArrayList();
            for (Object obj : list) {
                String str8 = ((MonitorUrl) obj).clickUrl;
                if (str8 != null && !StringsKt__StringsJVMKt.isBlank(str8)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    arrayList.add(obj);
                }
            }
            for (MonitorUrl monitorUrl : arrayList) {
                f21.b(monitorUrl.clickUrl);
            }
        }
        if ((Intrinsics.areEqual(str, "icon") || Intrinsics.areEqual(str, "name") || Intrinsics.areEqual(str, "tail_subtitle")) && (lq0Var = this.o) != null && (dq0Var = lq0Var.m) != null && (zp0Var = dq0Var.p) != null && zp0Var.e) {
            if (lq0Var != null && dq0Var != null && zp0Var != null) {
                str4 = zp0Var.b;
            } else {
                str4 = null;
            }
            if (str4 != null && str4.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                lq0 lq0Var4 = this.o;
                if (lq0Var4 != null && (dq0Var4 = lq0Var4.m) != null && (zp0Var4 = dq0Var4.p) != null) {
                    str5 = zp0Var4.a;
                } else {
                    str5 = null;
                }
                if (!((str5 == null || str5.length() == 0) ? true : true)) {
                    lq0 lq0Var5 = this.o;
                    if (lq0Var5 != null && (dq0Var3 = lq0Var5.m) != null && (zp0Var3 = dq0Var3.p) != null) {
                        str6 = zp0Var3.a;
                    } else {
                        str6 = null;
                    }
                    if (j41.d(str6)) {
                        Context context = getContext();
                        lq0 lq0Var6 = this.o;
                        if (lq0Var6 != null && (dq0Var2 = lq0Var6.m) != null && (zp0Var2 = dq0Var2.p) != null) {
                            str7 = zp0Var2.a;
                        }
                        Intrinsics.checkNotNull(str7);
                        xi0.b(context, str7);
                        return;
                    }
                }
            }
            if (Intrinsics.areEqual(str2, "__CONVERT_CMD__")) {
                lq0 lq0Var7 = this.o;
                Intrinsics.checkNotNull(lq0Var7);
                lq0 lq0Var8 = this.o;
                if (lq0Var8 != null) {
                    str7 = lq0Var8.f();
                }
                ki0.c(j41.b(lq0Var7, str7), getContext());
                return;
            }
            lq0 lq0Var9 = this.o;
            Intrinsics.checkNotNull(lq0Var9);
            ki0.c(j41.b(lq0Var9, str2), getContext());
            return;
        }
        ki0.c(str2, getContext());
    }
}
