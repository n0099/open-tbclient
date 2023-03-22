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
import com.baidu.tieba.aq0;
import com.baidu.tieba.ch0;
import com.baidu.tieba.di0;
import com.baidu.tieba.eh0;
import com.baidu.tieba.fp0;
import com.baidu.tieba.jp0;
import com.baidu.tieba.k11;
import com.baidu.tieba.l11;
import com.baidu.tieba.mn0;
import com.baidu.tieba.np0;
import com.baidu.tieba.p31;
import com.baidu.tieba.qh0;
import com.baidu.tieba.rp0;
import com.baidu.tieba.up0;
import com.baidu.tieba.v31;
import com.baidu.tieba.wj0;
import com.baidu.tieba.wp0;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010]\u001a\u00020\\\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010^\u0012\b\b\u0002\u0010a\u001a\u00020`¢\u0006\u0004\bb\u0010cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0011J\u001d\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u0011J\u0017\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001c\u0010\u0011J\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010!R\u001d\u0010'\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010,\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+R\u001d\u00101\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010$\u001a\u0004\b/\u00100R\u001d\u00106\u001a\u0002028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010$\u001a\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001d\u0010<\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010$\u001a\u0004\b;\u0010&R\u001d\u0010?\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010$\u001a\u0004\b>\u0010+R\u001d\u0010B\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010$\u001a\u0004\bA\u00100R\u001d\u0010E\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010$\u001a\u0004\bD\u00100R\u001d\u0010H\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010$\u001a\u0004\bG\u00100R\u001d\u0010M\u001a\u00020I8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010$\u001a\u0004\bK\u0010LR\u001d\u0010P\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010$\u001a\u0004\bO\u0010&R\u001e\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u001d\u0010U\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010$\u001a\u0004\bT\u00100R\u001d\u0010X\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010$\u001a\u0004\bW\u00100R\u001d\u0010[\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010$\u001a\u0004\bZ\u00100¨\u0006d"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardFullTailView;", "Lcom/baidu/tieba/mn0;", "Landroid/widget/RelativeLayout;", "Landroid/view/ViewGroup;", "getView", "()Landroid/view/ViewGroup;", "", DnsModel.AREA_KEY, "Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;", "logType", "scheme", "", "handleClick", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;)V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setAppInfo", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "setAvatar", "setData", "setDownloadButton", "setMoreButton", "Lkotlin/Function0;", WebChromeClient.KEY_ARG_CALLBACK, "setOnReplayClickListener", "(Lkotlin/Function0;)V", "setReplayButton", "setSubTitle", "setTitle", "", "isVisible", "setVisibility", "(Z)V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Landroid/widget/LinearLayout;", "appInfoView$delegate", "Lkotlin/Lazy;", "getAppInfoView", "()Landroid/widget/LinearLayout;", "appInfoView", "Lcom/baidu/nadcore/widget/AdImageView;", "avatar$delegate", "getAvatar", "()Lcom/baidu/nadcore/widget/AdImageView;", "avatar", "Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "developerName$delegate", "getDeveloperName", "()Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "developerName", "Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton$delegate", "getDownloadButton", "()Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "downloadPresenter", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "moreBtnContainer$delegate", "getMoreBtnContainer", "moreBtnContainer", "moreBtnIcon$delegate", "getMoreBtnIcon", "moreBtnIcon", "moreBtnText$delegate", "getMoreBtnText", "moreBtnText", "permissionView$delegate", "getPermissionView", "permissionView", "privacyView$delegate", "getPrivacyView", "privacyView", "Landroid/widget/ImageView;", "replayBtnIcon$delegate", "getReplayBtnIcon", "()Landroid/widget/ImageView;", "replayBtnIcon", "replayButton$delegate", "getReplayButton", "replayButton", "replayClickListener", "Lkotlin/Function0;", "subTitle$delegate", "getSubTitle", "subTitle", "title$delegate", "getTitle", "title", "version$delegate", WebChromeClient.MSG_METHOD_GETVERSION, "version", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadRewardFullTailView extends RelativeLayout implements mn0 {
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
    public rp0 o;
    public Function0<Unit> p;
    public ch0 q;

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

    @Override // com.baidu.tieba.mn0
    public ViewGroup getView() {
        return this;
    }

    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ rp0 b;

        public a(UnifyTextView unifyTextView, rp0 rp0Var) {
            this.a = unifyTextView;
            this.b = rp0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            Context context = this.a.getContext();
            yp0 yp0Var = this.b.i;
            if (yp0Var != null) {
                str = yp0Var.f;
            } else {
                str = null;
            }
            Toast.makeText(context, str, 0).show();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ rp0 b;

        public b(UnifyTextView unifyTextView, rp0 rp0Var) {
            this.a = unifyTextView;
            this.b = rp0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            Context context = this.a.getContext();
            yp0 yp0Var = this.b.i;
            if (yp0Var != null) {
                str = yp0Var.d;
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
        public final /* synthetic */ rp0 c;

        public c(UnifyTextView unifyTextView, NadRewardFullTailView nadRewardFullTailView, rp0 rp0Var) {
            this.a = unifyTextView;
            this.b = nadRewardFullTailView;
            this.c = rp0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            yp0.b bVar;
            NadRewardFullTailView nadRewardFullTailView = this.b;
            String str2 = ClogBuilder.Area.APP_PRIVACY.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PRIVACY.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            yp0 yp0Var = this.c.i;
            if (yp0Var != null && (bVar = yp0Var.g) != null) {
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
        public final /* synthetic */ rp0 c;

        public d(UnifyTextView unifyTextView, NadRewardFullTailView nadRewardFullTailView, rp0 rp0Var) {
            this.a = unifyTextView;
            this.b = nadRewardFullTailView;
            this.c = rp0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            yp0.a aVar;
            NadRewardFullTailView nadRewardFullTailView = this.b;
            String str2 = ClogBuilder.Area.APP_PERMISSION.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PERMISSION.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            yp0 yp0Var = this.c.i;
            if (yp0Var != null && (aVar = yp0Var.h) != null) {
                str = aVar.b;
            } else {
                str = null;
            }
            nadRewardFullTailView.d(str2, logType, str);
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements View.OnClickListener {
        public final /* synthetic */ rp0 b;

        public e(rp0 rp0Var) {
            this.b = rp0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            wp0 wp0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            up0 up0Var = this.b.j;
            if (up0Var != null && (wp0Var = up0Var.i) != null) {
                str = wp0Var.f;
            } else {
                str = null;
            }
            nadRewardFullTailView.d("icon", logType, str);
        }
    }

    /* loaded from: classes2.dex */
    public static final class f implements View.OnClickListener {
        public final /* synthetic */ rp0 b;

        public f(rp0 rp0Var) {
            this.b = rp0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            ch0 ch0Var = NadRewardFullTailView.this.q;
            if (ch0Var != null) {
                ch0Var.m();
            }
            eh0.b(this.b.e);
        }
    }

    /* loaded from: classes2.dex */
    public static final class g implements View.OnClickListener {
        public final /* synthetic */ rp0 b;

        public g(rp0 rp0Var) {
            this.b = rp0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            wp0 wp0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            up0 up0Var = this.b.j;
            if (up0Var != null && (wp0Var = up0Var.i) != null) {
                str = wp0Var.y;
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
        public final /* synthetic */ rp0 b;

        public i(rp0 rp0Var) {
            this.b = rp0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            wp0 wp0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            up0 up0Var = this.b.j;
            if (up0Var != null && (wp0Var = up0Var.i) != null) {
                str = wp0Var.f;
            } else {
                str = null;
            }
            nadRewardFullTailView.d("tail_subtitle", logType, str);
        }
    }

    /* loaded from: classes2.dex */
    public static final class j implements View.OnClickListener {
        public final /* synthetic */ rp0 b;

        public j(rp0 rp0Var) {
            this.b = rp0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            wp0 wp0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            up0 up0Var = this.b.j;
            if (up0Var != null && (wp0Var = up0Var.i) != null) {
                str = wp0Var.f;
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
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.obfuscated_res_0x7f090316);
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
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.obfuscated_res_0x7f0923fe);
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

    private final void setAvatar(rp0 rp0Var) {
        String str;
        wp0 wp0Var;
        AdImageView avatar = getAvatar();
        up0 up0Var = rp0Var.j;
        if (up0Var != null && (wp0Var = up0Var.i) != null) {
            str = wp0Var.d;
        } else {
            str = null;
        }
        avatar.o(str);
        avatar.setOnClickListener(new e(rp0Var));
    }

    private final void setReplayButton(rp0 rp0Var) {
        int i2;
        getReplayButton().setOnClickListener(new h());
        ImageView replayBtnIcon = getReplayBtnIcon();
        aq0 c2 = rp0Var.c();
        if (c2 != null && c2.f()) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        replayBtnIcon.setVisibility(i2);
    }

    @Override // com.baidu.tieba.mn0
    public void setData(rp0 adModel) {
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

    @Override // com.baidu.tieba.mn0
    public void setOnReplayClickListener(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.p = callback;
    }

    @Override // com.baidu.tieba.mn0
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
    private final void setAppInfo(rp0 rp0Var) {
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
        yp0 yp0Var;
        String str4;
        boolean z5;
        UnifyTextView unifyTextView4;
        yp0.a aVar;
        String str5;
        boolean z6;
        yp0.a aVar2;
        yp0.a aVar3;
        String str6;
        yp0.b bVar;
        String str7;
        boolean z7;
        yp0.b bVar2;
        yp0.b bVar3;
        String str8;
        String str9;
        LinearLayout appInfoView = getAppInfoView();
        if (eh0.a(rp0Var.i)) {
            appInfoView.setVisibility(0);
        } else {
            appInfoView.setVisibility(8);
        }
        UnifyTextView version = getVersion();
        yp0 yp0Var2 = rp0Var.i;
        String str10 = null;
        if (yp0Var2 != null) {
            str = yp0Var2.f;
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
            yp0 yp0Var3 = rp0Var.i;
            if (yp0Var3 != null) {
                str9 = yp0Var3.f;
            } else {
                str9 = null;
            }
            version.setTextWithUnifiedPadding(str9, TextView.BufferType.NORMAL);
            version.setOnClickListener(new a(version, rp0Var));
        }
        UnifyTextView developerName = getDeveloperName();
        yp0 yp0Var4 = rp0Var.i;
        if (yp0Var4 != null) {
            str2 = yp0Var4.d;
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
            yp0 yp0Var5 = rp0Var.i;
            if (yp0Var5 != null) {
                str8 = yp0Var5.d;
            } else {
                str8 = null;
            }
            developerName.setTextWithUnifiedPadding(str8, TextView.BufferType.NORMAL);
            developerName.setOnClickListener(new b(developerName, rp0Var));
        }
        UnifyTextView privacyView = getPrivacyView();
        yp0 yp0Var6 = rp0Var.i;
        if (yp0Var6 != null && (bVar3 = yp0Var6.g) != null) {
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
            yp0 yp0Var7 = rp0Var.i;
            if (yp0Var7 != null && (bVar2 = yp0Var7.g) != null) {
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
                    yp0 yp0Var8 = rp0Var.i;
                    if (yp0Var8 != null && (bVar = yp0Var8.g) != null) {
                        str6 = bVar.a;
                    } else {
                        str6 = null;
                    }
                    privacyView.setTextWithUnifiedPadding(str6, TextView.BufferType.NORMAL);
                    privacyView.setOnClickListener(new c(privacyView, this, rp0Var));
                }
                UnifyTextView permissionView = getPermissionView();
                yp0Var = rp0Var.i;
                if (yp0Var == null && (aVar3 = yp0Var.h) != null) {
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
                    yp0 yp0Var9 = rp0Var.i;
                    if (yp0Var9 != null && (aVar2 = yp0Var9.h) != null) {
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
                    yp0 yp0Var10 = rp0Var.i;
                    if (yp0Var10 != null && (aVar = yp0Var10.h) != null) {
                        str10 = aVar.a;
                    }
                    permissionView.setTextWithUnifiedPadding(str10, TextView.BufferType.NORMAL);
                    permissionView.setOnClickListener(new d(permissionView, this, rp0Var));
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
        yp0Var = rp0Var.i;
        if (yp0Var == null) {
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

    private final void setDownloadButton(rp0 rp0Var) {
        String str;
        boolean z;
        String str2;
        Object obj;
        fp0 fp0Var;
        jp0 jp0Var;
        fp0 fp0Var2;
        wp0 wp0Var;
        wp0 wp0Var2;
        ch0 ch0Var = this.q;
        if (ch0Var != null) {
            ch0Var.k();
        }
        String str3 = null;
        this.q = null;
        NadMiniVideoDownloadView downloadButton = getDownloadButton();
        int a2 = z31.c.a(downloadButton.getContext(), 16.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        up0 up0Var = rp0Var.j;
        if (up0Var != null && (wp0Var2 = up0Var.i) != null) {
            str = wp0Var2.h;
        } else {
            str = null;
        }
        gradientDrawable.setColor(v31.a(str, R.color.nad_reward_full_tail_btn_color));
        float f2 = a2;
        gradientDrawable.setCornerRadius(f2);
        Unit unit = Unit.INSTANCE;
        downloadButton.setBackground(gradientDrawable);
        downloadButton.setBorderRadius(f2);
        downloadButton.setTextSize(12.0f);
        downloadButton.setTextColor(ContextCompat.getColor(downloadButton.getContext(), R.color.nad_reward_full_tail_btn_text_color));
        downloadButton.setProgressColor(ContextCompat.getColor(downloadButton.getContext(), R.color.nad_reward_full_tail_btn_download_progress));
        aq0 c2 = rp0Var.c();
        if (c2 != null) {
            z = c2.f();
        } else {
            z = false;
        }
        downloadButton.setIconArrowSwitch(z);
        up0 up0Var2 = rp0Var.j;
        if (up0Var2 != null && (wp0Var = up0Var2.i) != null) {
            str2 = wp0Var.b;
        } else {
            str2 = null;
        }
        boolean z2 = true;
        if ((!Intrinsics.areEqual(str2, "download") || (jp0Var = rp0Var.m) == null || (fp0Var2 = jp0Var.p) == null || !fp0Var2.e) ? false : false) {
            downloadButton.setVisibility(0);
            obj = downloadButton;
        } else {
            downloadButton.setVisibility(8);
            obj = null;
        }
        if (obj != null) {
            jp0 jp0Var2 = rp0Var.m;
            if (jp0Var2 != null) {
                fp0Var = jp0Var2.p;
            } else {
                fp0Var = null;
            }
            String str4 = rp0Var.f.d;
            jp0 jp0Var3 = rp0Var.m;
            if (jp0Var3 != null) {
                str3 = jp0Var3.t;
            }
            wj0 d2 = wj0.d(fp0Var, str4, str3);
            Intrinsics.checkNotNullExpressionValue(d2, "AdDownloadBean.from(adMo….enhanceModel?.btnScheme)");
            d2.q.a = ClogBuilder.Page.WELFARETAIL.type;
            ch0 ch0Var2 = new ch0(d2, getDownloadButton());
            this.q = ch0Var2;
            Intrinsics.checkNotNull(ch0Var2);
            ch0Var2.A();
        }
        downloadButton.setOnClickListener(new f(rp0Var));
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
    private final void setMoreButton(rp0 rp0Var) {
        boolean z;
        LinearLayout linearLayout;
        AdImageView moreBtnIcon;
        up0 up0Var;
        String str;
        boolean z2;
        UnifyTextView moreBtnText;
        up0 up0Var2;
        String str2;
        up0 up0Var3;
        String str3;
        boolean z3;
        wp0 wp0Var;
        wp0 wp0Var2;
        wp0 wp0Var3;
        String str4;
        wp0 wp0Var4;
        wp0 wp0Var5;
        String str5;
        wp0 wp0Var6;
        String str6;
        boolean z4;
        String str7;
        boolean z5;
        wp0 wp0Var7;
        wp0 wp0Var8;
        LinearLayout moreBtnContainer = getMoreBtnContainer();
        String str8 = null;
        if (!rp0Var.h().d()) {
            up0 up0Var4 = rp0Var.j;
            if (up0Var4 != null && (wp0Var8 = up0Var4.i) != null) {
                str6 = wp0Var8.w;
            } else {
                str6 = null;
            }
            if (str6 != null && str6.length() != 0) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4) {
                up0 up0Var5 = rp0Var.j;
                if (up0Var5 != null && (wp0Var7 = up0Var5.i) != null) {
                    str7 = wp0Var7.x;
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
                gradientDrawable.setCornerRadius(z31.c.a(moreBtnContainer.getContext(), 17.0f));
                up0 up0Var6 = rp0Var.j;
                if (up0Var6 != null && (wp0Var6 = up0Var6.i) != null) {
                    str5 = wp0Var6.z;
                } else {
                    str5 = null;
                }
                gradientDrawable.setStroke(2, v31.a(str5, R.color.nad_reward_full_tail_more_btn_border));
                gradientDrawable.setAlpha((int) 127.5d);
                Unit unit = Unit.INSTANCE;
                linearLayout.setBackground(gradientDrawable);
            }
            moreBtnContainer.setOnClickListener(new g(rp0Var));
            moreBtnIcon = getMoreBtnIcon();
            up0Var = rp0Var.j;
            if (up0Var == null && (wp0Var5 = up0Var.i) != null) {
                str = wp0Var5.w;
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
                up0 up0Var7 = rp0Var.j;
                if (up0Var7 != null && (wp0Var4 = up0Var7.i) != null) {
                    str4 = wp0Var4.w;
                } else {
                    str4 = null;
                }
                moreBtnIcon.o(str4);
            }
            moreBtnText = getMoreBtnText();
            up0Var2 = rp0Var.j;
            if (up0Var2 == null && (wp0Var3 = up0Var2.i) != null) {
                str2 = wp0Var3.A;
            } else {
                str2 = null;
            }
            moreBtnText.setTextColor(v31.a(str2, 17170443));
            up0Var3 = rp0Var.j;
            if (up0Var3 == null && (wp0Var2 = up0Var3.i) != null) {
                str3 = wp0Var2.x;
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
                up0 up0Var8 = rp0Var.j;
                if (up0Var8 != null && (wp0Var = up0Var8.i) != null) {
                    str8 = wp0Var.x;
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
        moreBtnContainer.setOnClickListener(new g(rp0Var));
        moreBtnIcon = getMoreBtnIcon();
        up0Var = rp0Var.j;
        if (up0Var == null) {
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
        up0Var2 = rp0Var.j;
        if (up0Var2 == null) {
        }
        str2 = null;
        moreBtnText.setTextColor(v31.a(str2, 17170443));
        up0Var3 = rp0Var.j;
        if (up0Var3 == null) {
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

    private final void setSubTitle(rp0 rp0Var) {
        String str;
        boolean z;
        wp0 wp0Var;
        wp0 wp0Var2;
        UnifyTextView subTitle = getSubTitle();
        up0 up0Var = rp0Var.j;
        String str2 = null;
        if (up0Var != null && (wp0Var2 = up0Var.i) != null) {
            str = wp0Var2.m;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            up0 up0Var2 = rp0Var.j;
            if (up0Var2 != null && (wp0Var = up0Var2.i) != null) {
                str2 = wp0Var.m;
            }
            subTitle.setText(str2);
        }
        subTitle.setOnClickListener(new i(rp0Var));
    }

    private final void setTitle(rp0 rp0Var) {
        String str;
        boolean z;
        wp0 wp0Var;
        wp0 wp0Var2;
        UnifyTextView title = getTitle();
        up0 up0Var = rp0Var.j;
        String str2 = null;
        if (up0Var != null && (wp0Var2 = up0Var.i) != null) {
            str = wp0Var2.l;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            up0 up0Var2 = rp0Var.j;
            if (up0Var2 != null && (wp0Var = up0Var2.i) != null) {
                str2 = wp0Var.l;
            }
            title.setText(str2);
        }
        title.setOnClickListener(new j(rp0Var));
    }

    public final void d(String str, ClogBuilder.LogType logType, String str2) {
        String str3;
        rp0 rp0Var;
        jp0 jp0Var;
        fp0 fp0Var;
        String str4;
        boolean z;
        String str5;
        String str6;
        jp0 jp0Var2;
        fp0 fp0Var2;
        jp0 jp0Var3;
        fp0 fp0Var3;
        jp0 jp0Var4;
        fp0 fp0Var4;
        rp0 rp0Var2;
        List<MonitorUrl> list;
        boolean z2;
        np0 np0Var;
        ClogBuilder u = new ClogBuilder().j(str).y(logType).u(ClogBuilder.Page.WELFARETAIL);
        rp0 rp0Var3 = this.o;
        String str7 = null;
        if (rp0Var3 != null && (np0Var = rp0Var3.f) != null) {
            str3 = np0Var.d;
        } else {
            str3 = null;
        }
        k11.b(u.p(str3));
        boolean z3 = false;
        if (logType == ClogBuilder.LogType.CLICK && (rp0Var2 = this.o) != null && (list = rp0Var2.e) != null) {
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
                l11.b(monitorUrl.clickUrl);
            }
        }
        if ((Intrinsics.areEqual(str, "icon") || Intrinsics.areEqual(str, "name") || Intrinsics.areEqual(str, "tail_subtitle")) && (rp0Var = this.o) != null && (jp0Var = rp0Var.m) != null && (fp0Var = jp0Var.p) != null && fp0Var.e) {
            if (rp0Var != null && jp0Var != null && fp0Var != null) {
                str4 = fp0Var.b;
            } else {
                str4 = null;
            }
            if (str4 != null && str4.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                rp0 rp0Var4 = this.o;
                if (rp0Var4 != null && (jp0Var4 = rp0Var4.m) != null && (fp0Var4 = jp0Var4.p) != null) {
                    str5 = fp0Var4.a;
                } else {
                    str5 = null;
                }
                if (!((str5 == null || str5.length() == 0) ? true : true)) {
                    rp0 rp0Var5 = this.o;
                    if (rp0Var5 != null && (jp0Var3 = rp0Var5.m) != null && (fp0Var3 = jp0Var3.p) != null) {
                        str6 = fp0Var3.a;
                    } else {
                        str6 = null;
                    }
                    if (p31.d(str6)) {
                        Context context = getContext();
                        rp0 rp0Var6 = this.o;
                        if (rp0Var6 != null && (jp0Var2 = rp0Var6.m) != null && (fp0Var2 = jp0Var2.p) != null) {
                            str7 = fp0Var2.a;
                        }
                        Intrinsics.checkNotNull(str7);
                        di0.b(context, str7);
                        return;
                    }
                }
            }
            if (Intrinsics.areEqual(str2, "__CONVERT_CMD__")) {
                rp0 rp0Var7 = this.o;
                Intrinsics.checkNotNull(rp0Var7);
                rp0 rp0Var8 = this.o;
                if (rp0Var8 != null) {
                    str7 = rp0Var8.f();
                }
                qh0.c(p31.b(rp0Var7, str7), getContext());
                return;
            }
            rp0 rp0Var9 = this.o;
            Intrinsics.checkNotNull(rp0Var9);
            qh0.c(p31.b(rp0Var9, str2), getContext());
            return;
        }
        qh0.c(str2, getContext());
    }
}
