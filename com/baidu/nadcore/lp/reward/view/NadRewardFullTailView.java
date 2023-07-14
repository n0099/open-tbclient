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
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.txt.UnifyTextView;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.R;
import com.baidu.tieba.a71;
import com.baidu.tieba.ak0;
import com.baidu.tieba.bs0;
import com.baidu.tieba.dq0;
import com.baidu.tieba.e71;
import com.baidu.tieba.fq0;
import com.baidu.tieba.fs0;
import com.baidu.tieba.gm0;
import com.baidu.tieba.jq0;
import com.baidu.tieba.js0;
import com.baidu.tieba.kj0;
import com.baidu.tieba.mj0;
import com.baidu.tieba.ms0;
import com.baidu.tieba.n41;
import com.baidu.tieba.nk0;
import com.baidu.tieba.o41;
import com.baidu.tieba.os0;
import com.baidu.tieba.qs0;
import com.baidu.tieba.ss0;
import com.baidu.tieba.t61;
import com.baidu.tieba.xr0;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010]\u001a\u00020\\\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010^\u0012\b\b\u0002\u0010a\u001a\u00020`¢\u0006\u0004\bb\u0010cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0011J\u001d\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u0011J\u0017\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001c\u0010\u0011J\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010!R\u001d\u0010'\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010,\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+R\u001d\u00101\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010$\u001a\u0004\b/\u00100R\u001d\u00106\u001a\u0002028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010$\u001a\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001d\u0010<\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010$\u001a\u0004\b;\u0010&R\u001d\u0010?\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010$\u001a\u0004\b>\u0010+R\u001d\u0010B\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010$\u001a\u0004\bA\u00100R\u001d\u0010E\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010$\u001a\u0004\bD\u00100R\u001d\u0010H\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010$\u001a\u0004\bG\u00100R\u001d\u0010M\u001a\u00020I8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010$\u001a\u0004\bK\u0010LR\u001d\u0010P\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010$\u001a\u0004\bO\u0010&R\u001e\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u001d\u0010U\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010$\u001a\u0004\bT\u00100R\u001d\u0010X\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010$\u001a\u0004\bW\u00100R\u001d\u0010[\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010$\u001a\u0004\bZ\u00100¨\u0006d"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardFullTailView;", "Lcom/baidu/tieba/dq0;", "Landroid/widget/RelativeLayout;", "Landroid/view/ViewGroup;", "getView", "()Landroid/view/ViewGroup;", "", DnsModel.AREA_KEY, "Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;", "logType", "scheme", "", "handleClick", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;)V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setAppInfo", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "setAvatar", "setData", "setDownloadButton", "setMoreButton", "Lkotlin/Function0;", WebChromeClient.KEY_ARG_CALLBACK, "setOnReplayClickListener", "(Lkotlin/Function0;)V", "setReplayButton", "setSubTitle", "setTitle", "", "isVisible", "setVisibility", "(Z)V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Landroid/widget/LinearLayout;", "appInfoView$delegate", "Lkotlin/Lazy;", "getAppInfoView", "()Landroid/widget/LinearLayout;", "appInfoView", "Lcom/baidu/nadcore/widget/AdImageView;", "avatar$delegate", "getAvatar", "()Lcom/baidu/nadcore/widget/AdImageView;", "avatar", "Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "developerName$delegate", "getDeveloperName", "()Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "developerName", "Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton$delegate", "getDownloadButton", "()Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "downloadPresenter", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "moreBtnContainer$delegate", "getMoreBtnContainer", "moreBtnContainer", "moreBtnIcon$delegate", "getMoreBtnIcon", "moreBtnIcon", "moreBtnText$delegate", "getMoreBtnText", "moreBtnText", "permissionView$delegate", "getPermissionView", "permissionView", "privacyView$delegate", "getPrivacyView", "privacyView", "Landroid/widget/ImageView;", "replayBtnIcon$delegate", "getReplayBtnIcon", "()Landroid/widget/ImageView;", "replayBtnIcon", "replayButton$delegate", "getReplayButton", "replayButton", "replayClickListener", "Lkotlin/Function0;", "subTitle$delegate", "getSubTitle", "subTitle", "title$delegate", "getTitle", "title", "version$delegate", WebChromeClient.MSG_METHOD_GETVERSION, "version", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRewardFullTailView extends RelativeLayout implements dq0 {
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
    public js0 o;
    public Function0<Unit> p;
    public kj0 q;

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

    @Override // com.baidu.tieba.dq0
    public ViewGroup getView() {
        return this;
    }

    /* loaded from: classes3.dex */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ js0 b;

        public a(UnifyTextView unifyTextView, js0 js0Var) {
            this.a = unifyTextView;
            this.b = js0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            Context context = this.a.getContext();
            qs0 qs0Var = this.b.i;
            if (qs0Var != null) {
                str = qs0Var.f;
            } else {
                str = null;
            }
            Toast.makeText(context, str, 0).show();
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ js0 b;

        public b(UnifyTextView unifyTextView, js0 js0Var) {
            this.a = unifyTextView;
            this.b = js0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            Context context = this.a.getContext();
            qs0 qs0Var = this.b.i;
            if (qs0Var != null) {
                str = qs0Var.d;
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
        public final /* synthetic */ js0 c;

        public c(UnifyTextView unifyTextView, NadRewardFullTailView nadRewardFullTailView, js0 js0Var) {
            this.a = unifyTextView;
            this.b = nadRewardFullTailView;
            this.c = js0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            qs0.b bVar;
            NadRewardFullTailView nadRewardFullTailView = this.b;
            String str2 = ClogBuilder.Area.APP_PRIVACY.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PRIVACY.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            qs0 qs0Var = this.c.i;
            if (qs0Var != null && (bVar = qs0Var.g) != null) {
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
        public final /* synthetic */ js0 c;

        public d(UnifyTextView unifyTextView, NadRewardFullTailView nadRewardFullTailView, js0 js0Var) {
            this.a = unifyTextView;
            this.b = nadRewardFullTailView;
            this.c = js0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            qs0.a aVar;
            NadRewardFullTailView nadRewardFullTailView = this.b;
            String str2 = ClogBuilder.Area.APP_PERMISSION.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PERMISSION.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            qs0 qs0Var = this.c.i;
            if (qs0Var != null && (aVar = qs0Var.h) != null) {
                str = aVar.b;
            } else {
                str = null;
            }
            nadRewardFullTailView.d(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements View.OnClickListener {
        public final /* synthetic */ js0 b;

        public e(js0 js0Var) {
            this.b = js0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            os0 os0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            ms0 ms0Var = this.b.j;
            if (ms0Var != null && (os0Var = ms0Var.i) != null) {
                str = os0Var.f;
            } else {
                str = null;
            }
            nadRewardFullTailView.d("icon", logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements View.OnClickListener {
        public final /* synthetic */ js0 b;

        public f(js0 js0Var) {
            this.b = js0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            kj0 kj0Var = NadRewardFullTailView.this.q;
            if (kj0Var != null) {
                kj0Var.l();
            }
            mj0.b(this.b.e);
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements View.OnClickListener {
        public final /* synthetic */ js0 b;

        public g(js0 js0Var) {
            this.b = js0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            os0 os0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            ms0 ms0Var = this.b.j;
            if (ms0Var != null && (os0Var = ms0Var.i) != null) {
                str = os0Var.y;
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
        public final /* synthetic */ js0 b;

        public i(js0 js0Var) {
            this.b = js0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            os0 os0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            ms0 ms0Var = this.b.j;
            if (ms0Var != null && (os0Var = ms0Var.i) != null) {
                str = os0Var.f;
            } else {
                str = null;
            }
            nadRewardFullTailView.d("tail_subtitle", logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class j implements View.OnClickListener {
        public final /* synthetic */ js0 b;

        public j(js0 js0Var) {
            this.b = js0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            os0 os0Var;
            NadRewardFullTailView nadRewardFullTailView = NadRewardFullTailView.this;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            ms0 ms0Var = this.b.j;
            if (ms0Var != null && (os0Var = ms0Var.i) != null) {
                str = os0Var.f;
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
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.obfuscated_res_0x7f090315);
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
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.obfuscated_res_0x7f092542);
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
                View findViewById = NadRewardFullTailView.this.findViewById(R.id.obfuscated_res_0x7f0922b7);
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
        LayoutInflater from = LayoutInflater.from(context);
        fq0 a2 = jq0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        from.inflate(a2.c(), this);
        setBackgroundColor(ContextCompat.getColor(context, R.color.nad_reward_full_tail_bg_color));
    }

    public /* synthetic */ NadRewardFullTailView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void setAvatar(js0 js0Var) {
        String str;
        os0 os0Var;
        AdImageView avatar = getAvatar();
        ms0 ms0Var = js0Var.j;
        if (ms0Var != null && (os0Var = ms0Var.i) != null) {
            str = os0Var.d;
        } else {
            str = null;
        }
        avatar.o(str);
        avatar.setOnClickListener(new e(js0Var));
    }

    private final void setReplayButton(js0 js0Var) {
        int i2;
        getReplayButton().setOnClickListener(new h());
        ImageView replayBtnIcon = getReplayBtnIcon();
        ss0 c2 = js0Var.c();
        if (c2 != null && c2.f()) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        replayBtnIcon.setVisibility(i2);
    }

    @Override // com.baidu.tieba.dq0
    public void setData(js0 adModel) {
        Intrinsics.checkNotNullParameter(adModel, "adModel");
        this.o = adModel;
        setAvatar(adModel);
        setTitle(adModel);
        setSubTitle(adModel);
        setDownloadButton(adModel);
        setReplayButton(adModel);
        setMoreButton(adModel);
        setAppInfo(adModel);
        setClickable(true);
    }

    @Override // com.baidu.tieba.dq0
    public void setOnReplayClickListener(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.p = callback;
    }

    @Override // com.baidu.tieba.dq0
    public void setVisibility(boolean z) {
        int i2;
        js0 js0Var;
        if (z && (js0Var = this.o) != null) {
            setMoreButton(js0Var);
        }
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
    private final void setAppInfo(js0 js0Var) {
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
        qs0 qs0Var;
        String str4;
        boolean z5;
        UnifyTextView unifyTextView4;
        qs0.a aVar;
        String str5;
        boolean z6;
        qs0.a aVar2;
        qs0.a aVar3;
        String str6;
        qs0.b bVar;
        String str7;
        boolean z7;
        qs0.b bVar2;
        qs0.b bVar3;
        String str8;
        String str9;
        LinearLayout appInfoView = getAppInfoView();
        if (mj0.a(js0Var.i)) {
            appInfoView.setVisibility(0);
        } else {
            appInfoView.setVisibility(8);
        }
        UnifyTextView version = getVersion();
        qs0 qs0Var2 = js0Var.i;
        String str10 = null;
        if (qs0Var2 != null) {
            str = qs0Var2.f;
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
            qs0 qs0Var3 = js0Var.i;
            if (qs0Var3 != null) {
                str9 = qs0Var3.f;
            } else {
                str9 = null;
            }
            version.setTextWithUnifiedPadding(str9, TextView.BufferType.NORMAL);
            version.setOnClickListener(new a(version, js0Var));
        }
        UnifyTextView developerName = getDeveloperName();
        qs0 qs0Var4 = js0Var.i;
        if (qs0Var4 != null) {
            str2 = qs0Var4.d;
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
            qs0 qs0Var5 = js0Var.i;
            if (qs0Var5 != null) {
                str8 = qs0Var5.d;
            } else {
                str8 = null;
            }
            developerName.setTextWithUnifiedPadding(str8, TextView.BufferType.NORMAL);
            developerName.setOnClickListener(new b(developerName, js0Var));
        }
        UnifyTextView privacyView = getPrivacyView();
        qs0 qs0Var6 = js0Var.i;
        if (qs0Var6 != null && (bVar3 = qs0Var6.g) != null) {
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
            qs0 qs0Var7 = js0Var.i;
            if (qs0Var7 != null && (bVar2 = qs0Var7.g) != null) {
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
                    qs0 qs0Var8 = js0Var.i;
                    if (qs0Var8 != null && (bVar = qs0Var8.g) != null) {
                        str6 = bVar.a;
                    } else {
                        str6 = null;
                    }
                    privacyView.setTextWithUnifiedPadding(str6, TextView.BufferType.NORMAL);
                    privacyView.setOnClickListener(new c(privacyView, this, js0Var));
                }
                UnifyTextView permissionView = getPermissionView();
                qs0Var = js0Var.i;
                if (qs0Var == null && (aVar3 = qs0Var.h) != null) {
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
                    qs0 qs0Var9 = js0Var.i;
                    if (qs0Var9 != null && (aVar2 = qs0Var9.h) != null) {
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
                    qs0 qs0Var10 = js0Var.i;
                    if (qs0Var10 != null && (aVar = qs0Var10.h) != null) {
                        str10 = aVar.a;
                    }
                    permissionView.setTextWithUnifiedPadding(str10, TextView.BufferType.NORMAL);
                    permissionView.setOnClickListener(new d(permissionView, this, js0Var));
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
        qs0Var = js0Var.i;
        if (qs0Var == null) {
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

    private final void setDownloadButton(js0 js0Var) {
        String str;
        boolean z;
        String str2;
        Object obj;
        xr0 xr0Var;
        bs0 bs0Var;
        xr0 xr0Var2;
        os0 os0Var;
        os0 os0Var2;
        kj0 kj0Var = this.q;
        if (kj0Var != null) {
            kj0Var.j();
        }
        String str3 = null;
        this.q = null;
        NadMiniVideoDownloadView downloadButton = getDownloadButton();
        Resources resources = downloadButton.getResources();
        fq0 a2 = jq0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension = resources.getDimension(a2.h());
        GradientDrawable gradientDrawable = new GradientDrawable();
        ms0 ms0Var = js0Var.j;
        if (ms0Var != null && (os0Var2 = ms0Var.i) != null) {
            str = os0Var2.h;
        } else {
            str = null;
        }
        gradientDrawable.setColor(a71.a(str, R.color.nad_reward_full_tail_btn_color));
        gradientDrawable.setCornerRadius(dimension);
        Unit unit = Unit.INSTANCE;
        downloadButton.setBackground(gradientDrawable);
        downloadButton.setBorderRadius(dimension);
        downloadButton.setTextColor(ContextCompat.getColor(downloadButton.getContext(), R.color.nad_reward_full_tail_btn_text_color));
        downloadButton.setProgressColor(ContextCompat.getColor(downloadButton.getContext(), R.color.nad_reward_full_tail_btn_download_progress));
        ss0 c2 = js0Var.c();
        if (c2 != null) {
            z = c2.f();
        } else {
            z = false;
        }
        downloadButton.setIconArrowSwitch(z);
        ms0 ms0Var2 = js0Var.j;
        if (ms0Var2 != null && (os0Var = ms0Var2.i) != null) {
            str2 = os0Var.b;
        } else {
            str2 = null;
        }
        boolean z2 = true;
        if ((!Intrinsics.areEqual(str2, "download") || (bs0Var = js0Var.m) == null || (xr0Var2 = bs0Var.p) == null || !xr0Var2.e) ? false : false) {
            downloadButton.setVisibility(0);
            obj = downloadButton;
        } else {
            downloadButton.setVisibility(8);
            obj = null;
        }
        if (obj != null) {
            bs0 bs0Var2 = js0Var.m;
            if (bs0Var2 != null) {
                xr0Var = bs0Var2.p;
            } else {
                xr0Var = null;
            }
            String str4 = js0Var.f.d;
            bs0 bs0Var3 = js0Var.m;
            if (bs0Var3 != null) {
                str3 = bs0Var3.t;
            }
            gm0 d2 = gm0.d(xr0Var, str4, str3);
            Intrinsics.checkNotNullExpressionValue(d2, "AdDownloadBean.from(adMo….enhanceModel?.btnScheme)");
            d2.q.a = ClogBuilder.Page.WELFARETAIL.type;
            kj0 kj0Var2 = new kj0(d2, getDownloadButton());
            this.q = kj0Var2;
            Intrinsics.checkNotNull(kj0Var2);
            kj0Var2.z();
        }
        downloadButton.setOnClickListener(new f(js0Var));
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
    private final void setMoreButton(js0 js0Var) {
        String str;
        boolean z;
        boolean z2;
        LinearLayout linearLayout;
        AdImageView moreBtnIcon;
        ms0 ms0Var;
        String str2;
        boolean z3;
        UnifyTextView moreBtnText;
        ms0 ms0Var2;
        String str3;
        ms0 ms0Var3;
        String str4;
        boolean z4;
        os0 os0Var;
        os0 os0Var2;
        os0 os0Var3;
        String str5;
        os0 os0Var4;
        os0 os0Var5;
        String str6;
        os0 os0Var6;
        String str7;
        boolean z5;
        os0 os0Var7;
        os0 os0Var8;
        LinearLayout moreBtnContainer = getMoreBtnContainer();
        ms0 ms0Var4 = js0Var.j;
        String str8 = null;
        if (ms0Var4 != null && (os0Var8 = ms0Var4.i) != null) {
            str = os0Var8.w;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            ms0 ms0Var5 = js0Var.j;
            if (ms0Var5 != null && (os0Var7 = ms0Var5.i) != null) {
                str7 = os0Var7.x;
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
                    gradientDrawable.setCornerRadius(e71.c.a(moreBtnContainer.getContext(), 17.0f));
                    ms0 ms0Var6 = js0Var.j;
                    if (ms0Var6 != null && (os0Var6 = ms0Var6.i) != null) {
                        str6 = os0Var6.z;
                    } else {
                        str6 = null;
                    }
                    gradientDrawable.setStroke(2, a71.a(str6, R.color.nad_reward_full_tail_more_btn_border));
                    gradientDrawable.setAlpha((int) 127.5d);
                    Unit unit = Unit.INSTANCE;
                    linearLayout.setBackground(gradientDrawable);
                }
                moreBtnContainer.setOnClickListener(new g(js0Var));
                moreBtnIcon = getMoreBtnIcon();
                ms0Var = js0Var.j;
                if (ms0Var == null && (os0Var5 = ms0Var.i) != null) {
                    str2 = os0Var5.w;
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
                    ms0 ms0Var7 = js0Var.j;
                    if (ms0Var7 != null && (os0Var4 = ms0Var7.i) != null) {
                        str5 = os0Var4.w;
                    } else {
                        str5 = null;
                    }
                    moreBtnIcon.o(str5);
                }
                moreBtnText = getMoreBtnText();
                ms0Var2 = js0Var.j;
                if (ms0Var2 == null && (os0Var3 = ms0Var2.i) != null) {
                    str3 = os0Var3.A;
                } else {
                    str3 = null;
                }
                moreBtnText.setTextColor(a71.a(str3, 17170443));
                ms0Var3 = js0Var.j;
                if (ms0Var3 == null && (os0Var2 = ms0Var3.i) != null) {
                    str4 = os0Var2.x;
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
                    ms0 ms0Var8 = js0Var.j;
                    if (ms0Var8 != null && (os0Var = ms0Var8.i) != null) {
                        str8 = os0Var.x;
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
        moreBtnContainer.setOnClickListener(new g(js0Var));
        moreBtnIcon = getMoreBtnIcon();
        ms0Var = js0Var.j;
        if (ms0Var == null) {
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
        ms0Var2 = js0Var.j;
        if (ms0Var2 == null) {
        }
        str3 = null;
        moreBtnText.setTextColor(a71.a(str3, 17170443));
        ms0Var3 = js0Var.j;
        if (ms0Var3 == null) {
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

    private final void setSubTitle(js0 js0Var) {
        String str;
        boolean z;
        os0 os0Var;
        os0 os0Var2;
        UnifyTextView subTitle = getSubTitle();
        ms0 ms0Var = js0Var.j;
        String str2 = null;
        if (ms0Var != null && (os0Var2 = ms0Var.i) != null) {
            str = os0Var2.m;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            ms0 ms0Var2 = js0Var.j;
            if (ms0Var2 != null && (os0Var = ms0Var2.i) != null) {
                str2 = os0Var.m;
            }
            subTitle.setText(str2);
        }
        subTitle.setOnClickListener(new i(js0Var));
    }

    private final void setTitle(js0 js0Var) {
        String str;
        boolean z;
        os0 os0Var;
        os0 os0Var2;
        UnifyTextView title = getTitle();
        ms0 ms0Var = js0Var.j;
        String str2 = null;
        if (ms0Var != null && (os0Var2 = ms0Var.i) != null) {
            str = os0Var2.c;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            ms0 ms0Var2 = js0Var.j;
            if (ms0Var2 != null && (os0Var = ms0Var2.i) != null) {
                str2 = os0Var.c;
            }
            title.setTextWithUnifiedPadding(str2, TextView.BufferType.NORMAL);
        }
        title.setOnClickListener(new j(js0Var));
    }

    public final void d(String str, ClogBuilder.LogType logType, String str2) {
        String str3;
        js0 js0Var;
        bs0 bs0Var;
        xr0 xr0Var;
        String str4;
        boolean z;
        String str5;
        String str6;
        bs0 bs0Var2;
        xr0 xr0Var2;
        bs0 bs0Var3;
        xr0 xr0Var3;
        bs0 bs0Var4;
        xr0 xr0Var4;
        js0 js0Var2;
        List<MonitorUrl> list;
        boolean z2;
        fs0 fs0Var;
        ClogBuilder u = new ClogBuilder().j(str).y(logType).u(ClogBuilder.Page.WELFARETAIL);
        js0 js0Var3 = this.o;
        String str7 = null;
        if (js0Var3 != null && (fs0Var = js0Var3.f) != null) {
            str3 = fs0Var.d;
        } else {
            str3 = null;
        }
        n41.e(u.p(str3));
        boolean z3 = false;
        if (logType == ClogBuilder.LogType.CLICK && (js0Var2 = this.o) != null && (list = js0Var2.e) != null) {
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
                o41.b(monitorUrl.clickUrl);
            }
        }
        if ((Intrinsics.areEqual(str, "icon") || Intrinsics.areEqual(str, "name") || Intrinsics.areEqual(str, "tail_subtitle")) && (js0Var = this.o) != null && (bs0Var = js0Var.m) != null && (xr0Var = bs0Var.p) != null && xr0Var.e) {
            if (js0Var != null && bs0Var != null && xr0Var != null) {
                str4 = xr0Var.b;
            } else {
                str4 = null;
            }
            if (str4 != null && str4.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                js0 js0Var4 = this.o;
                if (js0Var4 != null && (bs0Var4 = js0Var4.m) != null && (xr0Var4 = bs0Var4.p) != null) {
                    str5 = xr0Var4.a;
                } else {
                    str5 = null;
                }
                if (!((str5 == null || str5.length() == 0) ? true : true)) {
                    js0 js0Var5 = this.o;
                    if (js0Var5 != null && (bs0Var3 = js0Var5.m) != null && (xr0Var3 = bs0Var3.p) != null) {
                        str6 = xr0Var3.a;
                    } else {
                        str6 = null;
                    }
                    if (t61.d(str6)) {
                        Context context = getContext();
                        js0 js0Var6 = this.o;
                        if (js0Var6 != null && (bs0Var2 = js0Var6.m) != null && (xr0Var2 = bs0Var2.p) != null) {
                            str7 = xr0Var2.a;
                        }
                        Intrinsics.checkNotNull(str7);
                        nk0.b(context, str7);
                        return;
                    }
                }
            }
            if (Intrinsics.areEqual(str2, "__CONVERT_CMD__")) {
                js0 js0Var7 = this.o;
                Intrinsics.checkNotNull(js0Var7);
                js0 js0Var8 = this.o;
                if (js0Var8 != null) {
                    str7 = js0Var8.g();
                }
                ak0.c(t61.b(js0Var7, str7), getContext());
                return;
            }
            js0 js0Var9 = this.o;
            Intrinsics.checkNotNull(js0Var9);
            ak0.c(t61.b(js0Var9, str2), getContext());
            return;
        }
        ak0.c(str2, getContext());
    }
}
