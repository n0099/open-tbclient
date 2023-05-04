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
import com.baidu.tieba.ak0;
import com.baidu.tieba.aq0;
import com.baidu.tieba.cq0;
import com.baidu.tieba.d41;
import com.baidu.tieba.eq0;
import com.baidu.tieba.gh0;
import com.baidu.tieba.hi0;
import com.baidu.tieba.ih0;
import com.baidu.tieba.jp0;
import com.baidu.tieba.np0;
import com.baidu.tieba.o11;
import com.baidu.tieba.p11;
import com.baidu.tieba.qn0;
import com.baidu.tieba.rp0;
import com.baidu.tieba.t31;
import com.baidu.tieba.uh0;
import com.baidu.tieba.vp0;
import com.baidu.tieba.yp0;
import com.baidu.tieba.z31;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010]\u001a\u00020\\\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010^\u0012\b\b\u0002\u0010a\u001a\u00020`¢\u0006\u0004\bb\u0010cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0011J\u001d\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u0011J\u0017\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001c\u0010\u0011J\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010!R\u001d\u0010'\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010,\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+R\u001d\u00101\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010$\u001a\u0004\b/\u00100R\u001d\u00106\u001a\u0002028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010$\u001a\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001d\u0010<\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010$\u001a\u0004\b;\u0010&R\u001d\u0010?\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010$\u001a\u0004\b>\u0010+R\u001d\u0010B\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010$\u001a\u0004\bA\u00100R\u001d\u0010E\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010$\u001a\u0004\bD\u00100R\u001d\u0010H\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010$\u001a\u0004\bG\u00100R\u001d\u0010M\u001a\u00020I8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010$\u001a\u0004\bK\u0010LR\u001d\u0010P\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010$\u001a\u0004\bO\u0010&R\u001e\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u001d\u0010U\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010$\u001a\u0004\bT\u00100R\u001d\u0010X\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010$\u001a\u0004\bW\u00100R\u001d\u0010[\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010$\u001a\u0004\bZ\u00100¨\u0006d"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardFullTailView;", "Lcom/baidu/tieba/qn0;", "Landroid/widget/RelativeLayout;", "Landroid/view/ViewGroup;", "getView", "()Landroid/view/ViewGroup;", "", DnsModel.AREA_KEY, "Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;", "logType", "scheme", "", "handleClick", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;)V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setAppInfo", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "setAvatar", "setData", "setDownloadButton", "setMoreButton", "Lkotlin/Function0;", WebChromeClient.KEY_ARG_CALLBACK, "setOnReplayClickListener", "(Lkotlin/Function0;)V", "setReplayButton", "setSubTitle", "setTitle", "", "isVisible", "setVisibility", "(Z)V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Landroid/widget/LinearLayout;", "appInfoView$delegate", "Lkotlin/Lazy;", "getAppInfoView", "()Landroid/widget/LinearLayout;", "appInfoView", "Lcom/baidu/nadcore/widget/AdImageView;", "avatar$delegate", "getAvatar", "()Lcom/baidu/nadcore/widget/AdImageView;", "avatar", "Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "developerName$delegate", "getDeveloperName", "()Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "developerName", "Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton$delegate", "getDownloadButton", "()Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "downloadPresenter", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "moreBtnContainer$delegate", "getMoreBtnContainer", "moreBtnContainer", "moreBtnIcon$delegate", "getMoreBtnIcon", "moreBtnIcon", "moreBtnText$delegate", "getMoreBtnText", "moreBtnText", "permissionView$delegate", "getPermissionView", "permissionView", "privacyView$delegate", "getPrivacyView", "privacyView", "Landroid/widget/ImageView;", "replayBtnIcon$delegate", "getReplayBtnIcon", "()Landroid/widget/ImageView;", "replayBtnIcon", "replayButton$delegate", "getReplayButton", "replayButton", "replayClickListener", "Lkotlin/Function0;", "subTitle$delegate", "getSubTitle", "subTitle", "title$delegate", "getTitle", "title", "version$delegate", WebChromeClient.MSG_METHOD_GETVERSION, "version", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadRewardFullTailView extends RelativeLayout implements qn0 {
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
    public vp0 o;
    public Function0<Unit> p;
    public gh0 q;

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

    @Override // com.baidu.tieba.qn0
    public ViewGroup getView() {
        return this;
    }

    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ vp0 b;

        public a(UnifyTextView unifyTextView, vp0 vp0Var) {
            this.a = unifyTextView;
            this.b = vp0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            Context context = this.a.getContext();
            cq0 cq0Var = this.b.i;
            if (cq0Var != null) {
                str = cq0Var.f;
            } else {
                str = null;
            }
            Toast.makeText(context, str, 0).show();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ vp0 b;

        public b(UnifyTextView unifyTextView, vp0 vp0Var) {
            this.a = unifyTextView;
            this.b = vp0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            Context context = this.a.getContext();
            cq0 cq0Var = this.b.i;
            if (cq0Var != null) {
                str = cq0Var.d;
            } else {
                str = null;
            }
            Toast.makeText(context, str, 0).show();
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ NadRewardFullTailView b;
        public final /* synthetic */ vp0 c;

        public c(UnifyTextView unifyTextView, NadRewardFullTailView nadRewardFullTailView, vp0 vp0Var) {
            this.a = unifyTextView;
            this.b = nadRewardFullTailView;
            this.c = vp0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            cq0.b bVar;
            NadRewardFullTailView nadRewardFullTailView = this.b;
            String str2 = ClogBuilder.Area.APP_PRIVACY.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PRIVACY.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            cq0 cq0Var = this.c.i;
            if (cq0Var != null && (bVar = cq0Var.g) != null) {
                str = bVar.b;
            } else {
                str = null;
            }
            nadRewardFullTailView.d(str2, logType, str);
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ NadRewardFullTailView b;
        public final /* synthetic */ vp0 c;

        public d(UnifyTextView unifyTextView, NadRewardFullTailView nadRewardFullTailView, vp0 vp0Var) {
            this.a = unifyTextView;
            this.b = nadRewardFullTailView;
            this.c = vp0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            cq0.a aVar;
            NadRewardFullTailView nadRewardFullTailView = this.b;
            String str2 = ClogBuilder.Area.APP_PERMISSION.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PERMISSION.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            cq0 cq0Var = this.c.i;
            if (cq0Var != null && (aVar = cq0Var.h) != null) {
                str = aVar.b;
            } else {
                str = null;
            }
            nadRewardFullTailView.d(str2, logType, str);
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements View.OnClickListener {
        public final /* synthetic */ vp0 b;

        public e(vp0 vp0Var) {
            this.b = vp0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            aq0 aq0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            yp0 yp0Var = this.b.j;
            if (yp0Var != null && (aq0Var = yp0Var.i) != null) {
                str = aq0Var.f;
            } else {
                str = null;
            }
            nadRewardFullTailView.d("icon", logType, str);
        }
    }

    /* loaded from: classes2.dex */
    public static final class f implements View.OnClickListener {
        public final /* synthetic */ vp0 b;

        public f(vp0 vp0Var) {
            this.b = vp0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            gh0 gh0Var = NadRewardFullTailView.this.q;
            if (gh0Var != null) {
                gh0Var.m();
            }
            ih0.b(this.b.e);
        }
    }

    /* loaded from: classes2.dex */
    public static final class g implements View.OnClickListener {
        public final /* synthetic */ vp0 b;

        public g(vp0 vp0Var) {
            this.b = vp0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            aq0 aq0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            yp0 yp0Var = this.b.j;
            if (yp0Var != null && (aq0Var = yp0Var.i) != null) {
                str = aq0Var.y;
            } else {
                str = null;
            }
            nadRewardFullTailView.d("morebtn", logType, str);
        }
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public static final class i implements View.OnClickListener {
        public final /* synthetic */ vp0 b;

        public i(vp0 vp0Var) {
            this.b = vp0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            aq0 aq0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            yp0 yp0Var = this.b.j;
            if (yp0Var != null && (aq0Var = yp0Var.i) != null) {
                str = aq0Var.f;
            } else {
                str = null;
            }
            nadRewardFullTailView.d("tail_subtitle", logType, str);
        }
    }

    /* loaded from: classes2.dex */
    public static final class j implements View.OnClickListener {
        public final /* synthetic */ vp0 b;

        public j(vp0 vp0Var) {
            this.b = vp0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            aq0 aq0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            yp0 yp0Var = this.b.j;
            if (yp0Var != null && (aq0Var = yp0Var.i) != null) {
                str = aq0Var.f;
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
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.obfuscated_res_0x7f09030a);
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
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.obfuscated_res_0x7f09240b);
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
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.sub_title);
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

    private final void setAvatar(vp0 vp0Var) {
        String str;
        aq0 aq0Var;
        AdImageView avatar = getAvatar();
        yp0 yp0Var = vp0Var.j;
        if (yp0Var != null && (aq0Var = yp0Var.i) != null) {
            str = aq0Var.d;
        } else {
            str = null;
        }
        avatar.o(str);
        avatar.setOnClickListener(new e(vp0Var));
    }

    private final void setReplayButton(vp0 vp0Var) {
        int i2;
        getReplayButton().setOnClickListener(new h());
        ImageView replayBtnIcon = getReplayBtnIcon();
        eq0 c2 = vp0Var.c();
        if (c2 != null && c2.f()) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        replayBtnIcon.setVisibility(i2);
    }

    @Override // com.baidu.tieba.qn0
    public void setData(vp0 adModel) {
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

    @Override // com.baidu.tieba.qn0
    public void setOnReplayClickListener(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.p = callback;
    }

    @Override // com.baidu.tieba.qn0
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
    private final void setAppInfo(vp0 vp0Var) {
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
        cq0 cq0Var;
        String str4;
        boolean z5;
        UnifyTextView unifyTextView4;
        cq0.a aVar;
        String str5;
        boolean z6;
        cq0.a aVar2;
        cq0.a aVar3;
        String str6;
        cq0.b bVar;
        String str7;
        boolean z7;
        cq0.b bVar2;
        cq0.b bVar3;
        String str8;
        String str9;
        LinearLayout appInfoView = getAppInfoView();
        if (ih0.a(vp0Var.i)) {
            appInfoView.setVisibility(0);
        } else {
            appInfoView.setVisibility(8);
        }
        UnifyTextView version = getVersion();
        cq0 cq0Var2 = vp0Var.i;
        String str10 = null;
        if (cq0Var2 != null) {
            str = cq0Var2.f;
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
            cq0 cq0Var3 = vp0Var.i;
            if (cq0Var3 != null) {
                str9 = cq0Var3.f;
            } else {
                str9 = null;
            }
            version.setTextWithUnifiedPadding(str9, TextView.BufferType.NORMAL);
            version.setOnClickListener(new a(version, vp0Var));
        }
        UnifyTextView developerName = getDeveloperName();
        cq0 cq0Var4 = vp0Var.i;
        if (cq0Var4 != null) {
            str2 = cq0Var4.d;
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
            cq0 cq0Var5 = vp0Var.i;
            if (cq0Var5 != null) {
                str8 = cq0Var5.d;
            } else {
                str8 = null;
            }
            developerName.setTextWithUnifiedPadding(str8, TextView.BufferType.NORMAL);
            developerName.setOnClickListener(new b(developerName, vp0Var));
        }
        UnifyTextView privacyView = getPrivacyView();
        cq0 cq0Var6 = vp0Var.i;
        if (cq0Var6 != null && (bVar3 = cq0Var6.g) != null) {
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
            cq0 cq0Var7 = vp0Var.i;
            if (cq0Var7 != null && (bVar2 = cq0Var7.g) != null) {
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
                    cq0 cq0Var8 = vp0Var.i;
                    if (cq0Var8 != null && (bVar = cq0Var8.g) != null) {
                        str6 = bVar.a;
                    } else {
                        str6 = null;
                    }
                    privacyView.setTextWithUnifiedPadding(str6, TextView.BufferType.NORMAL);
                    privacyView.setOnClickListener(new c(privacyView, this, vp0Var));
                }
                UnifyTextView permissionView = getPermissionView();
                cq0Var = vp0Var.i;
                if (cq0Var == null && (aVar3 = cq0Var.h) != null) {
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
                    cq0 cq0Var9 = vp0Var.i;
                    if (cq0Var9 != null && (aVar2 = cq0Var9.h) != null) {
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
                    cq0 cq0Var10 = vp0Var.i;
                    if (cq0Var10 != null && (aVar = cq0Var10.h) != null) {
                        str10 = aVar.a;
                    }
                    permissionView.setTextWithUnifiedPadding(str10, TextView.BufferType.NORMAL);
                    permissionView.setOnClickListener(new d(permissionView, this, vp0Var));
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
        cq0Var = vp0Var.i;
        if (cq0Var == null) {
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

    private final void setDownloadButton(vp0 vp0Var) {
        String str;
        boolean z;
        String str2;
        Object obj;
        jp0 jp0Var;
        np0 np0Var;
        jp0 jp0Var2;
        aq0 aq0Var;
        aq0 aq0Var2;
        gh0 gh0Var = this.q;
        if (gh0Var != null) {
            gh0Var.k();
        }
        String str3 = null;
        this.q = null;
        NadMiniVideoDownloadView downloadButton = getDownloadButton();
        int a2 = d41.c.a(downloadButton.getContext(), 16.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        yp0 yp0Var = vp0Var.j;
        if (yp0Var != null && (aq0Var2 = yp0Var.i) != null) {
            str = aq0Var2.h;
        } else {
            str = null;
        }
        gradientDrawable.setColor(z31.a(str, R.color.nad_reward_full_tail_btn_color));
        float f2 = a2;
        gradientDrawable.setCornerRadius(f2);
        Unit unit = Unit.INSTANCE;
        downloadButton.setBackground(gradientDrawable);
        downloadButton.setBorderRadius(f2);
        downloadButton.setTextSize(12.0f);
        downloadButton.setTextColor(ContextCompat.getColor(downloadButton.getContext(), R.color.nad_reward_full_tail_btn_text_color));
        downloadButton.setProgressColor(ContextCompat.getColor(downloadButton.getContext(), R.color.nad_reward_full_tail_btn_download_progress));
        eq0 c2 = vp0Var.c();
        if (c2 != null) {
            z = c2.f();
        } else {
            z = false;
        }
        downloadButton.setIconArrowSwitch(z);
        yp0 yp0Var2 = vp0Var.j;
        if (yp0Var2 != null && (aq0Var = yp0Var2.i) != null) {
            str2 = aq0Var.b;
        } else {
            str2 = null;
        }
        boolean z2 = true;
        if ((!Intrinsics.areEqual(str2, "download") || (np0Var = vp0Var.m) == null || (jp0Var2 = np0Var.p) == null || !jp0Var2.e) ? false : false) {
            downloadButton.setVisibility(0);
            obj = downloadButton;
        } else {
            downloadButton.setVisibility(8);
            obj = null;
        }
        if (obj != null) {
            np0 np0Var2 = vp0Var.m;
            if (np0Var2 != null) {
                jp0Var = np0Var2.p;
            } else {
                jp0Var = null;
            }
            String str4 = vp0Var.f.d;
            np0 np0Var3 = vp0Var.m;
            if (np0Var3 != null) {
                str3 = np0Var3.t;
            }
            ak0 d2 = ak0.d(jp0Var, str4, str3);
            Intrinsics.checkNotNullExpressionValue(d2, "AdDownloadBean.from(adMo….enhanceModel?.btnScheme)");
            d2.q.a = ClogBuilder.Page.WELFARETAIL.type;
            gh0 gh0Var2 = new gh0(d2, getDownloadButton());
            this.q = gh0Var2;
            Intrinsics.checkNotNull(gh0Var2);
            gh0Var2.A();
        }
        downloadButton.setOnClickListener(new f(vp0Var));
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
    private final void setMoreButton(vp0 vp0Var) {
        boolean z;
        LinearLayout linearLayout;
        AdImageView moreBtnIcon;
        yp0 yp0Var;
        String str;
        boolean z2;
        UnifyTextView moreBtnText;
        yp0 yp0Var2;
        String str2;
        yp0 yp0Var3;
        String str3;
        boolean z3;
        aq0 aq0Var;
        aq0 aq0Var2;
        aq0 aq0Var3;
        String str4;
        aq0 aq0Var4;
        aq0 aq0Var5;
        String str5;
        aq0 aq0Var6;
        String str6;
        boolean z4;
        String str7;
        boolean z5;
        aq0 aq0Var7;
        aq0 aq0Var8;
        LinearLayout moreBtnContainer = getMoreBtnContainer();
        String str8 = null;
        if (!vp0Var.h().d()) {
            yp0 yp0Var4 = vp0Var.j;
            if (yp0Var4 != null && (aq0Var8 = yp0Var4.i) != null) {
                str6 = aq0Var8.w;
            } else {
                str6 = null;
            }
            if (str6 != null && str6.length() != 0) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4) {
                yp0 yp0Var5 = vp0Var.j;
                if (yp0Var5 != null && (aq0Var7 = yp0Var5.i) != null) {
                    str7 = aq0Var7.x;
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
                gradientDrawable.setCornerRadius(d41.c.a(moreBtnContainer.getContext(), 17.0f));
                yp0 yp0Var6 = vp0Var.j;
                if (yp0Var6 != null && (aq0Var6 = yp0Var6.i) != null) {
                    str5 = aq0Var6.z;
                } else {
                    str5 = null;
                }
                gradientDrawable.setStroke(2, z31.a(str5, R.color.nad_reward_full_tail_more_btn_border));
                gradientDrawable.setAlpha((int) 127.5d);
                Unit unit = Unit.INSTANCE;
                linearLayout.setBackground(gradientDrawable);
            }
            moreBtnContainer.setOnClickListener(new g(vp0Var));
            moreBtnIcon = getMoreBtnIcon();
            yp0Var = vp0Var.j;
            if (yp0Var == null && (aq0Var5 = yp0Var.i) != null) {
                str = aq0Var5.w;
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
                yp0 yp0Var7 = vp0Var.j;
                if (yp0Var7 != null && (aq0Var4 = yp0Var7.i) != null) {
                    str4 = aq0Var4.w;
                } else {
                    str4 = null;
                }
                moreBtnIcon.o(str4);
            }
            moreBtnText = getMoreBtnText();
            yp0Var2 = vp0Var.j;
            if (yp0Var2 == null && (aq0Var3 = yp0Var2.i) != null) {
                str2 = aq0Var3.A;
            } else {
                str2 = null;
            }
            moreBtnText.setTextColor(z31.a(str2, 17170443));
            yp0Var3 = vp0Var.j;
            if (yp0Var3 == null && (aq0Var2 = yp0Var3.i) != null) {
                str3 = aq0Var2.x;
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
                yp0 yp0Var8 = vp0Var.j;
                if (yp0Var8 != null && (aq0Var = yp0Var8.i) != null) {
                    str8 = aq0Var.x;
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
        moreBtnContainer.setOnClickListener(new g(vp0Var));
        moreBtnIcon = getMoreBtnIcon();
        yp0Var = vp0Var.j;
        if (yp0Var == null) {
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
        yp0Var2 = vp0Var.j;
        if (yp0Var2 == null) {
        }
        str2 = null;
        moreBtnText.setTextColor(z31.a(str2, 17170443));
        yp0Var3 = vp0Var.j;
        if (yp0Var3 == null) {
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

    private final void setSubTitle(vp0 vp0Var) {
        String str;
        boolean z;
        aq0 aq0Var;
        aq0 aq0Var2;
        UnifyTextView subTitle = getSubTitle();
        yp0 yp0Var = vp0Var.j;
        String str2 = null;
        if (yp0Var != null && (aq0Var2 = yp0Var.i) != null) {
            str = aq0Var2.m;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            yp0 yp0Var2 = vp0Var.j;
            if (yp0Var2 != null && (aq0Var = yp0Var2.i) != null) {
                str2 = aq0Var.m;
            }
            subTitle.setText(str2);
        }
        subTitle.setOnClickListener(new i(vp0Var));
    }

    private final void setTitle(vp0 vp0Var) {
        String str;
        boolean z;
        aq0 aq0Var;
        aq0 aq0Var2;
        UnifyTextView title = getTitle();
        yp0 yp0Var = vp0Var.j;
        String str2 = null;
        if (yp0Var != null && (aq0Var2 = yp0Var.i) != null) {
            str = aq0Var2.l;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            yp0 yp0Var2 = vp0Var.j;
            if (yp0Var2 != null && (aq0Var = yp0Var2.i) != null) {
                str2 = aq0Var.l;
            }
            title.setText(str2);
        }
        title.setOnClickListener(new j(vp0Var));
    }

    public final void d(String str, ClogBuilder.LogType logType, String str2) {
        String str3;
        vp0 vp0Var;
        np0 np0Var;
        jp0 jp0Var;
        String str4;
        boolean z;
        String str5;
        String str6;
        np0 np0Var2;
        jp0 jp0Var2;
        np0 np0Var3;
        jp0 jp0Var3;
        np0 np0Var4;
        jp0 jp0Var4;
        vp0 vp0Var2;
        List<MonitorUrl> list;
        boolean z2;
        rp0 rp0Var;
        ClogBuilder u = new ClogBuilder().j(str).y(logType).u(ClogBuilder.Page.WELFARETAIL);
        vp0 vp0Var3 = this.o;
        String str7 = null;
        if (vp0Var3 != null && (rp0Var = vp0Var3.f) != null) {
            str3 = rp0Var.d;
        } else {
            str3 = null;
        }
        o11.b(u.p(str3));
        boolean z3 = false;
        if (logType == ClogBuilder.LogType.CLICK && (vp0Var2 = this.o) != null && (list = vp0Var2.e) != null) {
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
                p11.b(monitorUrl.clickUrl);
            }
        }
        if ((Intrinsics.areEqual(str, "icon") || Intrinsics.areEqual(str, "name") || Intrinsics.areEqual(str, "tail_subtitle")) && (vp0Var = this.o) != null && (np0Var = vp0Var.m) != null && (jp0Var = np0Var.p) != null && jp0Var.e) {
            if (vp0Var != null && np0Var != null && jp0Var != null) {
                str4 = jp0Var.b;
            } else {
                str4 = null;
            }
            if (str4 != null && str4.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                vp0 vp0Var4 = this.o;
                if (vp0Var4 != null && (np0Var4 = vp0Var4.m) != null && (jp0Var4 = np0Var4.p) != null) {
                    str5 = jp0Var4.a;
                } else {
                    str5 = null;
                }
                if (!((str5 == null || str5.length() == 0) ? true : true)) {
                    vp0 vp0Var5 = this.o;
                    if (vp0Var5 != null && (np0Var3 = vp0Var5.m) != null && (jp0Var3 = np0Var3.p) != null) {
                        str6 = jp0Var3.a;
                    } else {
                        str6 = null;
                    }
                    if (t31.d(str6)) {
                        Context context = getContext();
                        vp0 vp0Var6 = this.o;
                        if (vp0Var6 != null && (np0Var2 = vp0Var6.m) != null && (jp0Var2 = np0Var2.p) != null) {
                            str7 = jp0Var2.a;
                        }
                        Intrinsics.checkNotNull(str7);
                        hi0.b(context, str7);
                        return;
                    }
                }
            }
            if (Intrinsics.areEqual(str2, "__CONVERT_CMD__")) {
                vp0 vp0Var7 = this.o;
                Intrinsics.checkNotNull(vp0Var7);
                vp0 vp0Var8 = this.o;
                if (vp0Var8 != null) {
                    str7 = vp0Var8.f();
                }
                uh0.c(t31.b(vp0Var7, str7), getContext());
                return;
            }
            vp0 vp0Var9 = this.o;
            Intrinsics.checkNotNull(vp0Var9);
            uh0.c(t31.b(vp0Var9, str2), getContext());
            return;
        }
        uh0.c(str2, getContext());
    }
}
