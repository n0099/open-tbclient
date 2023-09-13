package com.baidu.nadcore.lp.reward.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.txt.UnifyTextView;
import com.baidu.searchbox.common.security.PermissionStorage;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.R;
import com.baidu.tieba.as0;
import com.baidu.tieba.bs0;
import com.baidu.tieba.cj0;
import com.baidu.tieba.cs0;
import com.baidu.tieba.d91;
import com.baidu.tieba.fn0;
import com.baidu.tieba.fr0;
import com.baidu.tieba.il0;
import com.baidu.tieba.jn0;
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
import com.baidu.tieba.th0;
import com.baidu.tieba.tr0;
import com.baidu.tieba.x31;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010p\u001a\u00020o\u0012\n\b\u0002\u0010r\u001a\u0004\u0018\u00010q\u0012\b\b\u0002\u0010t\u001a\u00020s¢\u0006\u0004\bu\u0010vJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\f\u0010\u000bJ3\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\u000bJ\r\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u000bJ\u0019\u0010\u0019\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ!\u0010\u001e\u001a\u00020\u00072\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b \u0010\u001aJ\u0019\u0010!\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b!\u0010\u001aJ\u0017\u0010\"\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\"\u0010\u001aJ\u0019\u0010#\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b#\u0010\u001aJ\u0019\u0010$\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b$\u0010\u001aJ\u0019\u0010%\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b%\u0010\u001aJ\u0015\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010*R\u001d\u00100\u001a\u00020+8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001d\u00105\u001a\u0002018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u00104R\u001d\u00108\u001a\u0002018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010-\u001a\u0004\b7\u00104R\u001d\u0010=\u001a\u0002098B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010-\u001a\u0004\b;\u0010<R$\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u001d\u0010D\u001a\u00020@8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010-\u001a\u0004\bB\u0010CR\u001d\u0010I\u001a\u00020E8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010-\u001a\u0004\bG\u0010HR\u001d\u0010N\u001a\u00020J8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010-\u001a\u0004\bL\u0010MR\u001d\u0010Q\u001a\u00020@8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010-\u001a\u0004\bP\u0010CR\u001d\u0010V\u001a\u00020R8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010-\u001a\u0004\bT\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u001d\u0010\\\u001a\u00020@8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010-\u001a\u0004\b[\u0010CR\u0018\u0010^\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u001d\u0010b\u001a\u00020@8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010-\u001a\u0004\ba\u0010CR\u001d\u0010e\u001a\u00020@8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010-\u001a\u0004\bd\u0010CR\u001d\u0010h\u001a\u00020+8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010-\u001a\u0004\bg\u0010/R\u001d\u0010k\u001a\u00020@8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010-\u001a\u0004\bj\u0010CR\u001d\u0010n\u001a\u00020@8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bl\u0010-\u001a\u0004\bm\u0010C¨\u0006w"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardBigCardView;", "Landroid/widget/FrameLayout;", "", DnsModel.AREA_KEY, "Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;", "logType", "scheme", "", "handleClick", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;)V", "initArrow", "()V", "initSwipeUp", PermissionStorage.PermissionItem.ITEM_EXT_1, PermissionStorage.PermissionItem.ITEM_EXT_2, "logAndCharge", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;Ljava/lang/String;)V", "", "showProgress", "onProgressChanged", "(F)V", "registerRewardTaskEvent", "release", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setAppInfo", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "setAvatar", "Lkotlin/Function1;", WebChromeClient.KEY_ARG_CALLBACK, "setBigCardShowProgress", "(Lkotlin/Function1;)V", "setBrandName", "setButton", "setData", "setDetailButton", "setDownloadButton", "setTitle", "", "isVisible", "setVisibility", "(Z)V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Landroid/widget/LinearLayout;", "appInfoView$delegate", "Lkotlin/Lazy;", "getAppInfoView", "()Landroid/widget/LinearLayout;", "appInfoView", "Lcom/baidu/nadcore/widget/AdImageView;", "arrow$delegate", "getArrow", "()Lcom/baidu/nadcore/widget/AdImageView;", "arrow", "avatar$delegate", "getAvatar", "avatar", "Landroid/animation/ValueAnimator;", "bigCardPopupAnimator$delegate", "getBigCardPopupAnimator", "()Landroid/animation/ValueAnimator;", "bigCardPopupAnimator", "bigCardShowProgress", "Lkotlin/Function1;", "Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "brandName$delegate", "getBrandName", "()Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "brandName", "Landroid/view/View;", "detailBtn$delegate", "getDetailBtn", "()Landroid/view/View;", "detailBtn", "Landroid/widget/TextView;", "detailBtnText$delegate", "getDetailBtnText", "()Landroid/widget/TextView;", "detailBtnText", "developerName$delegate", "getDeveloperName", "developerName", "Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton$delegate", "getDownloadButton", "()Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "downloadPresenter", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "featureView$delegate", "getFeatureView", "featureView", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "panelPop", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "permissionView$delegate", "getPermissionView", "permissionView", "privacyView$delegate", "getPrivacyView", "privacyView", "tagContainer$delegate", "getTagContainer", "tagContainer", "title$delegate", "getTitle", "title", "version$delegate", WebChromeClient.MSG_METHOD_GETVERSION, "version", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRewardBigCardView extends FrameLayout {
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
    public d91 o;
    public tr0 p;
    public mi0 q;
    public Function1<? super Float, Unit> r;
    public final Lazy s;

    @JvmOverloads
    public NadRewardBigCardView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public NadRewardBigCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final LinearLayout getAppInfoView() {
        return (LinearLayout) this.i.getValue();
    }

    private final AdImageView getArrow() {
        return (AdImageView) this.h.getValue();
    }

    private final AdImageView getAvatar() {
        return (AdImageView) this.a.getValue();
    }

    private final ValueAnimator getBigCardPopupAnimator() {
        return (ValueAnimator) this.s.getValue();
    }

    private final UnifyTextView getBrandName() {
        return (UnifyTextView) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getDetailBtn() {
        return (View) this.e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getDetailBtnText() {
        return (TextView) this.f.getValue();
    }

    private final UnifyTextView getDeveloperName() {
        return (UnifyTextView) this.k.getValue();
    }

    private final NadMiniVideoDownloadView getDownloadButton() {
        return (NadMiniVideoDownloadView) this.g.getValue();
    }

    private final UnifyTextView getFeatureView() {
        return (UnifyTextView) this.n.getValue();
    }

    private final UnifyTextView getPermissionView() {
        return (UnifyTextView) this.m.getValue();
    }

    private final UnifyTextView getPrivacyView() {
        return (UnifyTextView) this.l.getValue();
    }

    private final LinearLayout getTagContainer() {
        return (LinearLayout) this.d.getValue();
    }

    private final UnifyTextView getTitle() {
        return (UnifyTextView) this.c.getValue();
    }

    private final UnifyTextView getVersion() {
        return (UnifyTextView) this.j.getValue();
    }

    /* loaded from: classes3.dex */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            bs0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.ARROW.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.ARROW.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            tr0 tr0Var = NadRewardBigCardView.this.p;
            if (tr0Var != null && (b = tr0Var.b()) != null) {
                str = b.d();
            } else {
                str = null;
            }
            nadRewardBigCardView.i(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements View.OnTouchListener {
        public float a;
        public float b;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            boolean z;
            String str;
            bs0 b;
            Intrinsics.checkNotNullParameter(v, "v");
            Intrinsics.checkNotNullParameter(event, "event");
            int action = event.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    float rawX = event.getRawX();
                    float rawY = event.getRawY();
                    if (Math.abs(rawY - this.a) / Math.abs(rawX - this.b) > 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (rawY - this.a < -60 && z) {
                        tr0 tr0Var = NadRewardBigCardView.this.p;
                        if (tr0Var != null && (b = tr0Var.b()) != null) {
                            str = b.d();
                        } else {
                            str = null;
                        }
                        cj0.c(str, NadRewardBigCardView.this.getContext());
                        NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
                        String str2 = ClogBuilder.Area.SWIPE_UP.type;
                        Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.SWIPE_UP.type");
                        NadRewardBigCardView.m(nadRewardBigCardView, str2, ClogBuilder.LogType.CLICK, null, null, 12, null);
                        return true;
                    }
                }
            } else {
                this.b = event.getRawX();
                this.a = event.getRawY();
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends jn0<th0> {
        public c(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jn0
        public void onEvent(th0 event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!(!Intrinsics.areEqual(event.a, "4"))) {
                tr0 tr0Var = NadRewardBigCardView.this.p;
                if (tr0Var == null || tr0Var.o()) {
                    if (event.h) {
                        tr0 tr0Var2 = NadRewardBigCardView.this.p;
                        if (tr0Var2 == null) {
                            return;
                        }
                        NadRewardBigCardView.this.setDetailButton(tr0Var2);
                        return;
                    }
                    String str = event.g;
                    if (str != null) {
                        NadRewardBigCardView.this.getDetailBtnText().setText(str);
                    }
                    if (event.d != null && event.e != null) {
                        Drawable background = NadRewardBigCardView.this.getDetailBtn().getBackground();
                        if (background != null) {
                            GradientDrawable gradientDrawable = (GradientDrawable) background;
                            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                            gradientDrawable.setColors(new int[]{m61.a(event.d, R.color.nad_reward_big_card_btn_color), m61.a(event.e, R.color.nad_reward_big_card_btn_color)});
                            NadRewardBigCardView.this.getDetailBtn().setBackground(gradientDrawable);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                        }
                    }
                    NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
                    ClogBuilder.LogType logType = ClogBuilder.LogType.REWARD_SHOW_TASK;
                    String str2 = event.c;
                    if (str2 == null) {
                        str2 = "0";
                    }
                    nadRewardBigCardView.l("", logType, "4", str2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ tr0 b;

        public d(UnifyTextView unifyTextView, tr0 tr0Var) {
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
    public static final class e implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ tr0 b;

        public e(UnifyTextView unifyTextView, tr0 tr0Var) {
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
    public static final class f implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ NadRewardBigCardView b;
        public final /* synthetic */ tr0 c;

        public f(UnifyTextView unifyTextView, NadRewardBigCardView nadRewardBigCardView, tr0 tr0Var) {
            this.a = unifyTextView;
            this.b = nadRewardBigCardView;
            this.c = tr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            as0 as0Var;
            as0.c cVar;
            NadRewardBigCardView nadRewardBigCardView = this.b;
            String str2 = ClogBuilder.Area.APP_PRIVACY.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PRIVACY.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            tr0 tr0Var = this.c;
            if (tr0Var != null && (as0Var = tr0Var.i) != null && (cVar = as0Var.g) != null) {
                str = cVar.b;
            } else {
                str = null;
            }
            nadRewardBigCardView.i(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ NadRewardBigCardView b;
        public final /* synthetic */ tr0 c;

        public g(UnifyTextView unifyTextView, NadRewardBigCardView nadRewardBigCardView, tr0 tr0Var) {
            this.a = unifyTextView;
            this.b = nadRewardBigCardView;
            this.c = tr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            as0 as0Var;
            as0.b bVar;
            NadRewardBigCardView nadRewardBigCardView = this.b;
            String str2 = ClogBuilder.Area.APP_PERMISSION.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PERMISSION.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            tr0 tr0Var = this.c;
            if (tr0Var != null && (as0Var = tr0Var.i) != null && (bVar = as0Var.h) != null) {
                str = bVar.b;
            } else {
                str = null;
            }
            nadRewardBigCardView.i(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ NadRewardBigCardView b;
        public final /* synthetic */ tr0 c;

        public h(UnifyTextView unifyTextView, NadRewardBigCardView nadRewardBigCardView, tr0 tr0Var) {
            this.a = unifyTextView;
            this.b = nadRewardBigCardView;
            this.c = tr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            as0 as0Var;
            as0.a aVar;
            NadRewardBigCardView nadRewardBigCardView = this.b;
            String str2 = ClogBuilder.Area.APP_FEATURE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_FEATURE.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            tr0 tr0Var = this.c;
            if (tr0Var != null && (as0Var = tr0Var.i) != null && (aVar = as0Var.i) != null) {
                str = aVar.b;
            } else {
                str = null;
            }
            nadRewardBigCardView.i(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class i implements View.OnClickListener {
        public final /* synthetic */ tr0 b;

        public i(tr0 tr0Var) {
            this.b = tr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            bs0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.AVATAR.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.AVATAR.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            tr0 tr0Var = this.b;
            if (tr0Var != null && (b = tr0Var.b()) != null) {
                str = b.d();
            } else {
                str = null;
            }
            nadRewardBigCardView.i(str2, logType, str);
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
            bs0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.NAME.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.NAME.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            tr0 tr0Var = this.b;
            if (tr0Var != null && (b = tr0Var.b()) != null) {
                str = b.d();
            } else {
                str = null;
            }
            nadRewardBigCardView.i(str2, logType, str);
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
            bs0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.AD_BTN_DETAIL.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.AD_BTN_DETAIL.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            tr0 tr0Var = this.b;
            if (tr0Var != null && (b = tr0Var.b()) != null) {
                str = b.d();
            } else {
                str = null;
            }
            nadRewardBigCardView.i(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class l implements View.OnClickListener {
        public l(tr0 tr0Var) {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            mi0 mi0Var = NadRewardBigCardView.this.q;
            if (mi0Var != null) {
                mi0Var.l();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class m implements View.OnClickListener {
        public final /* synthetic */ tr0 b;

        public m(tr0 tr0Var) {
            this.b = tr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            bs0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.TITTLE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.TITTLE.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            tr0 tr0Var = this.b;
            if (tr0Var != null && (b = tr0Var.b()) != null) {
                str = b.d();
            } else {
                str = null;
            }
            nadRewardBigCardView.i(str2, logType, str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadRewardBigCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$avatar$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdImageView invoke() {
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.obfuscated_res_0x7f09031c);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.avatar)");
                return (AdImageView) findViewById;
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$brandName$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.brand_name);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.brand_name)");
                return (UnifyTextView) findViewById;
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$title$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.obfuscated_res_0x7f0925d1);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
                return (UnifyTextView) findViewById;
            }
        });
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$tagContainer$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.tag_container);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tag_container)");
                return (LinearLayout) findViewById;
            }
        });
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$detailBtn$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.detail_btn);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.detail_btn)");
                return findViewById;
            }
        });
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$detailBtnText$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.detail_btn_text);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.detail_btn_text)");
                return (TextView) findViewById;
            }
        });
        this.g = LazyKt__LazyJVMKt.lazy(new Function0<NadMiniVideoDownloadView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$downloadButton$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NadMiniVideoDownloadView invoke() {
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.download_btn);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.download_btn)");
                return (NadMiniVideoDownloadView) findViewById;
            }
        });
        this.h = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$arrow$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdImageView invoke() {
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.arrow_image);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.arrow_image)");
                return (AdImageView) findViewById;
            }
        });
        this.i = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$appInfoView$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.app_info_container);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.app_info_container)");
                return (LinearLayout) findViewById;
            }
        });
        this.j = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$version$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.ad_version);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_version)");
                return (UnifyTextView) findViewById;
            }
        });
        this.k = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$developerName$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.ad_author_full_name);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_author_full_name)");
                return (UnifyTextView) findViewById;
            }
        });
        this.l = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$privacyView$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.ad_privacy);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_privacy)");
                return (UnifyTextView) findViewById;
            }
        });
        this.m = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$permissionView$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.ad_permission);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_permission)");
                return (UnifyTextView) findViewById;
            }
        });
        this.n = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$featureView$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.ad_feature);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_feature)");
                return (UnifyTextView) findViewById;
            }
        });
        this.s = LazyKt__LazyJVMKt.lazy(new Function0<ValueAnimator>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$bigCardPopupAnimator$2
            {
                super(0);
            }

            /* loaded from: classes3.dex */
            public static final class a implements ValueAnimator.AnimatorUpdateListener {
                public a() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator animation) {
                    Intrinsics.checkNotNullExpressionValue(animation, "animation");
                    Object animatedValue = animation.getAnimatedValue();
                    if (!(animatedValue instanceof Float)) {
                        animatedValue = null;
                    }
                    Float f = (Float) animatedValue;
                    if (f != null) {
                        NadRewardBigCardView.this.n(f.floatValue());
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ValueAnimator invoke() {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.setDuration(320L);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat.addUpdateListener(new a());
                return ofFloat;
            }
        });
        LayoutInflater from = LayoutInflater.from(context);
        jp0 a2 = np0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        from.inflate(a2.s(), this);
    }

    public /* synthetic */ NadRewardBigCardView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void setAvatar(tr0 tr0Var) {
        String str;
        bs0 b2;
        AdImageView avatar = getAvatar();
        avatar.setBorder(1.0f, avatar.getResources().getColor(R.color.nad_reward_big_card_avatar_stroke));
        if (tr0Var != null && (b2 = tr0Var.b()) != null) {
            str = b2.a();
        } else {
            str = null;
        }
        avatar.r(str);
        avatar.setOnClickListener(new i(tr0Var));
    }

    private final void setButton(tr0 tr0Var) {
        setDetailButton(tr0Var);
        setDownloadButton(tr0Var);
    }

    public final void n(float f2) {
        Function1<? super Float, Unit> function1;
        if (Math.abs(f2) >= 0.001d && (function1 = this.r) != null) {
            function1.invoke(Float.valueOf(f2));
        }
    }

    public final void setBigCardShowProgress(Function1<? super Float, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.r = callback;
    }

    public final void setData(tr0 tr0Var) {
        this.p = tr0Var;
        setAvatar(tr0Var);
        setBrandName(tr0Var);
        setTitle(tr0Var);
        setButton(tr0Var);
        setAppInfo(tr0Var);
        o();
        j();
        k();
    }

    public final void setVisibility(boolean z) {
        int i2;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        setVisibility(i2);
        if (z) {
            getBigCardPopupAnimator().start();
            return;
        }
        d91 d91Var = this.o;
        if (d91Var != null) {
            d91Var.f();
        }
    }

    public static /* synthetic */ void m(NadRewardBigCardView nadRewardBigCardView, String str, ClogBuilder.LogType logType, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        if ((i2 & 8) != 0) {
            str3 = "";
        }
        nadRewardBigCardView.l(str, logType, str2, str3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:171:0x01a2, code lost:
        if (r2 == false) goto L139;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:186:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setAppInfo(tr0 tr0Var) {
        as0 as0Var;
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
        String str4;
        boolean z5;
        boolean z6;
        UnifyTextView unifyTextView4;
        String str5;
        boolean z7;
        UnifyTextView unifyTextView5;
        as0 as0Var2;
        as0.a aVar;
        String str6;
        boolean z8;
        as0 as0Var3;
        as0.a aVar2;
        as0 as0Var4;
        as0.a aVar3;
        String str7;
        as0 as0Var5;
        as0.b bVar;
        String str8;
        boolean z9;
        as0 as0Var6;
        as0.b bVar2;
        as0 as0Var7;
        as0.b bVar3;
        String str9;
        as0 as0Var8;
        as0.c cVar;
        String str10;
        boolean z10;
        as0 as0Var9;
        as0.c cVar2;
        as0 as0Var10;
        as0.c cVar3;
        String str11;
        as0 as0Var11;
        as0 as0Var12;
        String str12;
        as0 as0Var13;
        as0 as0Var14;
        LinearLayout appInfoView = getAppInfoView();
        String str13 = null;
        if (tr0Var != null) {
            as0Var = tr0Var.i;
        } else {
            as0Var = null;
        }
        if (oi0.a(as0Var)) {
            appInfoView.setVisibility(0);
        } else {
            appInfoView.setVisibility(8);
        }
        UnifyTextView version = getVersion();
        if (tr0Var != null && (as0Var14 = tr0Var.i) != null) {
            str = as0Var14.f;
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
            if (tr0Var != null && (as0Var13 = tr0Var.i) != null) {
                str12 = as0Var13.f;
            } else {
                str12 = null;
            }
            version.setTextWithUnifiedPadding(str12, TextView.BufferType.NORMAL);
            version.setOnClickListener(new d(version, tr0Var));
        }
        UnifyTextView developerName = getDeveloperName();
        if (tr0Var != null && (as0Var12 = tr0Var.i) != null) {
            str2 = as0Var12.d;
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
            if (tr0Var != null && (as0Var11 = tr0Var.i) != null) {
                str11 = as0Var11.d;
            } else {
                str11 = null;
            }
            developerName.setTextWithUnifiedPadding(str11, TextView.BufferType.NORMAL);
            developerName.setOnClickListener(new e(developerName, tr0Var));
        }
        UnifyTextView privacyView = getPrivacyView();
        if (tr0Var != null && (as0Var10 = tr0Var.i) != null && (cVar3 = as0Var10.g) != null) {
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
            if (tr0Var != null && (as0Var9 = tr0Var.i) != null && (cVar2 = as0Var9.g) != null) {
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
                    if (tr0Var != null && (as0Var8 = tr0Var.i) != null && (cVar = as0Var8.g) != null) {
                        str9 = cVar.a;
                    } else {
                        str9 = null;
                    }
                    privacyView.setTextWithUnifiedPadding(str9, TextView.BufferType.NORMAL);
                    privacyView.setOnClickListener(new f(privacyView, this, tr0Var));
                }
                UnifyTextView permissionView = getPermissionView();
                if (tr0Var == null && (as0Var7 = tr0Var.i) != null && (bVar3 = as0Var7.h) != null) {
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
                    if (tr0Var != null && (as0Var6 = tr0Var.i) != null && (bVar2 = as0Var6.h) != null) {
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
                            if (tr0Var != null && (as0Var5 = tr0Var.i) != null && (bVar = as0Var5.h) != null) {
                                str7 = bVar.a;
                            } else {
                                str7 = null;
                            }
                            permissionView.setTextWithUnifiedPadding(str7, TextView.BufferType.NORMAL);
                            permissionView.setOnClickListener(new g(permissionView, this, tr0Var));
                        }
                        UnifyTextView featureView = getFeatureView();
                        if (tr0Var == null && (as0Var4 = tr0Var.i) != null && (aVar3 = as0Var4.i) != null) {
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
                            if (tr0Var != null && (as0Var3 = tr0Var.i) != null && (aVar2 = as0Var3.i) != null) {
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
                            unifyTextView5 = featureView;
                        } else {
                            featureView.setVisibility(8);
                            unifyTextView5 = null;
                        }
                        if (unifyTextView5 != null) {
                            if (tr0Var != null && (as0Var2 = tr0Var.i) != null && (aVar = as0Var2.i) != null) {
                                str13 = aVar.a;
                            }
                            featureView.setTextWithUnifiedPadding(str13, TextView.BufferType.NORMAL);
                            featureView.setOnClickListener(new h(featureView, this, tr0Var));
                            return;
                        }
                        return;
                    }
                }
                z6 = false;
                if (z6) {
                }
                if (unifyTextView4 != null) {
                }
                UnifyTextView featureView2 = getFeatureView();
                if (tr0Var == null) {
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
                if (unifyTextView5 != null) {
                }
            }
        }
        z4 = false;
        if (!z4) {
        }
        if (unifyTextView3 != null) {
        }
        UnifyTextView permissionView2 = getPermissionView();
        if (tr0Var == null) {
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
        if (tr0Var == null) {
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
        if (unifyTextView5 != null) {
        }
    }

    private final void setBrandName(tr0 tr0Var) {
        String str;
        boolean z;
        bs0 b2;
        bs0 b3;
        UnifyTextView brandName = getBrandName();
        String str2 = null;
        if (tr0Var != null && (b3 = tr0Var.b()) != null) {
            str = b3.b();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            if (tr0Var != null && (b2 = tr0Var.b()) != null) {
                str2 = b2.b();
            }
            brandName.setText(str2);
        }
        brandName.setOnClickListener(new j(tr0Var));
    }

    private final void setTitle(tr0 tr0Var) {
        String str;
        boolean z;
        bs0 b2;
        bs0 b3;
        UnifyTextView title = getTitle();
        String str2 = null;
        if (tr0Var != null && (b3 = tr0Var.b()) != null) {
            str = b3.g();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            if (tr0Var != null && (b2 = tr0Var.b()) != null) {
                str2 = b2.g();
            }
            title.setText(str2);
        }
        title.setOnClickListener(new m(tr0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDetailButton(tr0 tr0Var) {
        String str;
        boolean z;
        String str2;
        String str3;
        bs0 b2;
        bs0 b3;
        jr0 jr0Var;
        jr0 jr0Var2;
        bs0 b4;
        View detailBtn = getDetailBtn();
        Resources resources = detailBtn.getResources();
        jp0 a2 = np0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension = resources.getDimension(a2.i());
        GradientDrawable gradientDrawable = new GradientDrawable();
        String str4 = null;
        if (tr0Var != null && (b4 = tr0Var.b()) != null) {
            str = b4.c();
        } else {
            str = null;
        }
        gradientDrawable.setColor(m61.a(str, R.color.nad_reward_big_card_btn_color));
        gradientDrawable.setCornerRadius(dimension);
        Unit unit = Unit.INSTANCE;
        detailBtn.setBackground(gradientDrawable);
        boolean z2 = true;
        if (tr0Var != null) {
            z = tr0Var.o();
        } else {
            z = true;
        }
        if (z) {
            detailBtn.setVisibility(0);
        } else {
            detailBtn.setVisibility(8);
        }
        detailBtn.setOnClickListener(new k(tr0Var));
        TextView detailBtnText = getDetailBtnText();
        if (tr0Var != null && (jr0Var2 = tr0Var.m) != null && jr0Var2.g) {
            String str5 = ClogBuilder.Area.OPEN_BUTTON.type;
            Intrinsics.checkNotNullExpressionValue(str5, "ClogBuilder.Area.OPEN_BUTTON.type");
            m(this, str5, ClogBuilder.LogType.FREE_SHOW, null, null, 12, null);
        }
        if (tr0Var != null && (jr0Var = tr0Var.m) != null && jr0Var.g) {
            str3 = detailBtnText.getContext().getString(R.string.nad_reward_detail_btn_open_app);
        } else {
            if (tr0Var != null && (b3 = tr0Var.b()) != null) {
                str2 = b3.e();
            } else {
                str2 = null;
            }
            if (str2 != null && !StringsKt__StringsJVMKt.isBlank(str2)) {
                z2 = false;
            }
            if (!z2) {
                if (tr0Var != null && (b2 = tr0Var.b()) != null) {
                    str4 = b2.e();
                }
            } else {
                str4 = detailBtnText.getContext().getString(R.string.nad_reward_detail_btn_text);
            }
            str3 = str4;
        }
        detailBtnText.setText(str3);
    }

    private final void setDownloadButton(tr0 tr0Var) {
        String str;
        boolean z;
        boolean z2;
        Object obj;
        fr0 fr0Var;
        String str2;
        jr0 jr0Var;
        nr0 nr0Var;
        jr0 jr0Var2;
        jr0 jr0Var3;
        fr0 fr0Var2;
        cs0 c2;
        bs0 b2;
        mi0 mi0Var = this.q;
        if (mi0Var != null) {
            mi0Var.j();
        }
        String str3 = null;
        this.q = null;
        NadMiniVideoDownloadView downloadButton = getDownloadButton();
        Resources resources = downloadButton.getResources();
        jp0 a2 = np0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension = resources.getDimension(a2.i());
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (tr0Var != null && (b2 = tr0Var.b()) != null) {
            str = b2.c();
        } else {
            str = null;
        }
        gradientDrawable.setColor(m61.a(str, R.color.nad_reward_big_card_btn_color));
        gradientDrawable.setCornerRadius(dimension);
        Unit unit = Unit.INSTANCE;
        downloadButton.setBackground(gradientDrawable);
        downloadButton.setBorderRadius(dimension);
        downloadButton.setProgressColor(ContextCompat.getColor(downloadButton.getContext(), R.color.nad_reward_big_card_btn_download_progress));
        if (tr0Var != null && (c2 = tr0Var.c()) != null) {
            z = c2.e();
        } else {
            z = false;
        }
        downloadButton.setIconArrowSwitch(z);
        if (tr0Var != null) {
            z2 = tr0Var.p();
        } else {
            z2 = false;
        }
        boolean z3 = true;
        if ((!z2 || tr0Var == null || (jr0Var3 = tr0Var.m) == null || (fr0Var2 = jr0Var3.p) == null || !fr0Var2.e) ? false : false) {
            downloadButton.setVisibility(0);
            obj = downloadButton;
        } else {
            downloadButton.setVisibility(8);
            obj = null;
        }
        if (obj != null) {
            if (tr0Var != null && (jr0Var2 = tr0Var.m) != null) {
                fr0Var = jr0Var2.p;
            } else {
                fr0Var = null;
            }
            if (tr0Var != null && (nr0Var = tr0Var.f) != null) {
                str2 = nr0Var.d;
            } else {
                str2 = null;
            }
            if (tr0Var != null && (jr0Var = tr0Var.m) != null) {
                str3 = jr0Var.t;
            }
            il0 d2 = il0.d(fr0Var, str2, str3);
            Intrinsics.checkNotNullExpressionValue(d2, "AdDownloadBean.from(adMo….enhanceModel?.btnScheme)");
            d2.q.a = ClogBuilder.Page.WELFAREBIGCARD.type;
            mi0 mi0Var2 = new mi0(d2, getDownloadButton());
            this.q = mi0Var2;
            Intrinsics.checkNotNull(mi0Var2);
            mi0Var2.z();
        }
        downloadButton.setOnClickListener(new l(tr0Var));
    }

    public final void i(String str, ClogBuilder.LogType logType, String str2) {
        m(this, str, logType, null, null, 12, null);
        cj0.c(str2, getContext());
    }

    public final void j() {
        int a2;
        AdImageView arrow = getArrow();
        arrow.setImageResource(R.drawable.nad_reward_big_card_arrow);
        ViewGroup.LayoutParams layoutParams = arrow.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            tr0 tr0Var = this.p;
            if (tr0Var != null && tr0Var.o()) {
                a2 = q61.c.a(arrow.getContext(), 10.0f);
            } else {
                a2 = q61.c.a(arrow.getContext(), 25.0f);
            }
            layoutParams2.bottomMargin = a2;
            arrow.setLayoutParams(layoutParams2);
            arrow.setOnClickListener(new a());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void k() {
        setClickable(true);
        setOnTouchListener(new b());
    }

    public final void o() {
        fn0.a().b(this, new c(th0.class));
    }

    public final void p() {
        getBigCardPopupAnimator().cancel();
    }

    public final void l(String str, ClogBuilder.LogType logType, String str2, String str3) {
        String str4;
        boolean z;
        nr0 nr0Var;
        ClogBuilder u = new ClogBuilder().j(str).y(logType).u(ClogBuilder.Page.WELFAREBIGCARD);
        tr0 tr0Var = this.p;
        List<MonitorUrl> list = null;
        if (tr0Var != null && (nr0Var = tr0Var.f) != null) {
            str4 = nr0Var.d;
        } else {
            str4 = null;
        }
        ClogBuilder p = u.p(str4);
        boolean z2 = true;
        if (str2.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            p.k(str2);
        }
        if (str3.length() <= 0) {
            z2 = false;
        }
        if (z2) {
            p.l(str3);
        }
        x31.e(p);
        if (logType == ClogBuilder.LogType.CLICK) {
            tr0 tr0Var2 = this.p;
            if (tr0Var2 != null) {
                list = tr0Var2.e;
            }
            oi0.b(list);
        }
    }
}
