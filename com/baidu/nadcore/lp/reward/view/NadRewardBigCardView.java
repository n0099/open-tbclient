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
import com.baidu.tieba.al0;
import com.baidu.tieba.an0;
import com.baidu.tieba.az0;
import com.baidu.tieba.be0;
import com.baidu.tieba.g41;
import com.baidu.tieba.gd0;
import com.baidu.tieba.gn0;
import com.baidu.tieba.nn0;
import com.baidu.tieba.on0;
import com.baidu.tieba.p11;
import com.baidu.tieba.pe0;
import com.baidu.tieba.pn0;
import com.baidu.tieba.s01;
import com.baidu.tieba.si0;
import com.baidu.tieba.sm0;
import com.baidu.tieba.t11;
import com.baidu.tieba.v01;
import com.baidu.tieba.vg0;
import com.baidu.tieba.wi0;
import com.baidu.tieba.wk0;
import com.baidu.tieba.wm0;
import com.baidu.tieba.zd0;
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
    public g41 o;
    public gn0 p;
    public zd0 q;
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
            on0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.ARROW.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.ARROW.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            gn0 gn0Var = NadRewardBigCardView.this.p;
            if (gn0Var != null && (b = gn0Var.b()) != null) {
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
            on0 b;
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
                        gn0 gn0Var = NadRewardBigCardView.this.p;
                        if (gn0Var != null && (b = gn0Var.b()) != null) {
                            str = b.d();
                        } else {
                            str = null;
                        }
                        pe0.c(str, NadRewardBigCardView.this.getContext());
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
    public static final class c extends wi0<gd0> {
        public c(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wi0
        public void onEvent(gd0 event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!Intrinsics.areEqual(event.a, "4")) {
                return;
            }
            gn0 gn0Var = NadRewardBigCardView.this.p;
            if (gn0Var == null || gn0Var.o()) {
                if (!event.h) {
                    String str = event.g;
                    if (str != null) {
                        NadRewardBigCardView.this.getDetailBtnText().setText(str);
                    }
                    if (event.d != null && event.e != null) {
                        Drawable background = NadRewardBigCardView.this.getDetailBtn().getBackground();
                        if (background != null) {
                            GradientDrawable gradientDrawable = (GradientDrawable) background;
                            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                            gradientDrawable.setColors(new int[]{p11.a(event.d, R.color.nad_reward_big_card_btn_color), p11.a(event.e, R.color.nad_reward_big_card_btn_color)});
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
                    return;
                }
                gn0 gn0Var2 = NadRewardBigCardView.this.p;
                if (gn0Var2 == null) {
                    return;
                }
                NadRewardBigCardView.this.setDetailButton(gn0Var2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ gn0 b;

        public d(UnifyTextView unifyTextView, gn0 gn0Var) {
            this.a = unifyTextView;
            this.b = gn0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            nn0 nn0Var;
            s01 a = v01.a();
            Context context = this.a.getContext();
            gn0 gn0Var = this.b;
            if (gn0Var != null && (nn0Var = gn0Var.i) != null) {
                str = nn0Var.f;
            } else {
                str = null;
            }
            a.b(context, str, 0);
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ gn0 b;

        public e(UnifyTextView unifyTextView, gn0 gn0Var) {
            this.a = unifyTextView;
            this.b = gn0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            nn0 nn0Var;
            s01 a = v01.a();
            Context context = this.a.getContext();
            gn0 gn0Var = this.b;
            if (gn0Var != null && (nn0Var = gn0Var.i) != null) {
                str = nn0Var.d;
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
        public final /* synthetic */ gn0 c;

        public f(UnifyTextView unifyTextView, NadRewardBigCardView nadRewardBigCardView, gn0 gn0Var) {
            this.a = unifyTextView;
            this.b = nadRewardBigCardView;
            this.c = gn0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            nn0 nn0Var;
            nn0.c cVar;
            NadRewardBigCardView nadRewardBigCardView = this.b;
            String str2 = ClogBuilder.Area.APP_PRIVACY.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PRIVACY.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            gn0 gn0Var = this.c;
            if (gn0Var != null && (nn0Var = gn0Var.i) != null && (cVar = nn0Var.g) != null) {
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
        public final /* synthetic */ gn0 c;

        public g(UnifyTextView unifyTextView, NadRewardBigCardView nadRewardBigCardView, gn0 gn0Var) {
            this.a = unifyTextView;
            this.b = nadRewardBigCardView;
            this.c = gn0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            nn0 nn0Var;
            nn0.b bVar;
            NadRewardBigCardView nadRewardBigCardView = this.b;
            String str2 = ClogBuilder.Area.APP_PERMISSION.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PERMISSION.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            gn0 gn0Var = this.c;
            if (gn0Var != null && (nn0Var = gn0Var.i) != null && (bVar = nn0Var.h) != null) {
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
        public final /* synthetic */ gn0 c;

        public h(UnifyTextView unifyTextView, NadRewardBigCardView nadRewardBigCardView, gn0 gn0Var) {
            this.a = unifyTextView;
            this.b = nadRewardBigCardView;
            this.c = gn0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            nn0 nn0Var;
            nn0.a aVar;
            NadRewardBigCardView nadRewardBigCardView = this.b;
            String str2 = ClogBuilder.Area.APP_FEATURE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_FEATURE.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            gn0 gn0Var = this.c;
            if (gn0Var != null && (nn0Var = gn0Var.i) != null && (aVar = nn0Var.i) != null) {
                str = aVar.b;
            } else {
                str = null;
            }
            nadRewardBigCardView.i(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class i implements View.OnClickListener {
        public final /* synthetic */ gn0 b;

        public i(gn0 gn0Var) {
            this.b = gn0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            on0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.AVATAR.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.AVATAR.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            gn0 gn0Var = this.b;
            if (gn0Var != null && (b = gn0Var.b()) != null) {
                str = b.d();
            } else {
                str = null;
            }
            nadRewardBigCardView.i(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class j implements View.OnClickListener {
        public final /* synthetic */ gn0 b;

        public j(gn0 gn0Var) {
            this.b = gn0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            on0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.NAME.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.NAME.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            gn0 gn0Var = this.b;
            if (gn0Var != null && (b = gn0Var.b()) != null) {
                str = b.d();
            } else {
                str = null;
            }
            nadRewardBigCardView.i(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class k implements View.OnClickListener {
        public final /* synthetic */ gn0 b;

        public k(gn0 gn0Var) {
            this.b = gn0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            on0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.AD_BTN_DETAIL.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.AD_BTN_DETAIL.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            gn0 gn0Var = this.b;
            if (gn0Var != null && (b = gn0Var.b()) != null) {
                str = b.d();
            } else {
                str = null;
            }
            nadRewardBigCardView.i(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class l implements View.OnClickListener {
        public l(gn0 gn0Var) {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            zd0 zd0Var = NadRewardBigCardView.this.q;
            if (zd0Var != null) {
                zd0Var.m();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class m implements View.OnClickListener {
        public final /* synthetic */ gn0 b;

        public m(gn0 gn0Var) {
            this.b = gn0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            on0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.TITTLE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.TITTLE.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            gn0 gn0Var = this.b;
            if (gn0Var != null && (b = gn0Var.b()) != null) {
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
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.obfuscated_res_0x7f09032e);
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
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.obfuscated_res_0x7f0925fe);
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
        wk0 a2 = al0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        from.inflate(a2.s(), this);
    }

    public /* synthetic */ NadRewardBigCardView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void setAvatar(gn0 gn0Var) {
        String str;
        on0 b2;
        AdImageView avatar = getAvatar();
        avatar.setBorder(1.0f, avatar.getResources().getColor(R.color.nad_reward_big_card_avatar_stroke));
        if (gn0Var != null && (b2 = gn0Var.b()) != null) {
            str = b2.a();
        } else {
            str = null;
        }
        avatar.r(str);
        avatar.setOnClickListener(new i(gn0Var));
    }

    private final void setButton(gn0 gn0Var) {
        setDetailButton(gn0Var);
        setDownloadButton(gn0Var);
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

    public final void setData(gn0 gn0Var) {
        this.p = gn0Var;
        setAvatar(gn0Var);
        setBrandName(gn0Var);
        setTitle(gn0Var);
        setButton(gn0Var);
        setAppInfo(gn0Var);
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
        g41 g41Var = this.o;
        if (g41Var != null) {
            g41Var.f();
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
    private final void setAppInfo(gn0 gn0Var) {
        nn0 nn0Var;
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
        nn0 nn0Var2;
        nn0.a aVar;
        String str6;
        boolean z8;
        nn0 nn0Var3;
        nn0.a aVar2;
        nn0 nn0Var4;
        nn0.a aVar3;
        String str7;
        nn0 nn0Var5;
        nn0.b bVar;
        String str8;
        boolean z9;
        nn0 nn0Var6;
        nn0.b bVar2;
        nn0 nn0Var7;
        nn0.b bVar3;
        String str9;
        nn0 nn0Var8;
        nn0.c cVar;
        String str10;
        boolean z10;
        nn0 nn0Var9;
        nn0.c cVar2;
        nn0 nn0Var10;
        nn0.c cVar3;
        String str11;
        nn0 nn0Var11;
        nn0 nn0Var12;
        String str12;
        nn0 nn0Var13;
        nn0 nn0Var14;
        LinearLayout appInfoView = getAppInfoView();
        String str13 = null;
        if (gn0Var != null) {
            nn0Var = gn0Var.i;
        } else {
            nn0Var = null;
        }
        if (be0.a(nn0Var)) {
            appInfoView.setVisibility(0);
        } else {
            appInfoView.setVisibility(8);
        }
        UnifyTextView version = getVersion();
        if (gn0Var != null && (nn0Var14 = gn0Var.i) != null) {
            str = nn0Var14.f;
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
            if (gn0Var != null && (nn0Var13 = gn0Var.i) != null) {
                str12 = nn0Var13.f;
            } else {
                str12 = null;
            }
            version.setTextWithUnifiedPadding(str12, TextView.BufferType.NORMAL);
            version.setOnClickListener(new d(version, gn0Var));
        }
        UnifyTextView developerName = getDeveloperName();
        if (gn0Var != null && (nn0Var12 = gn0Var.i) != null) {
            str2 = nn0Var12.d;
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
            if (gn0Var != null && (nn0Var11 = gn0Var.i) != null) {
                str11 = nn0Var11.d;
            } else {
                str11 = null;
            }
            developerName.setTextWithUnifiedPadding(str11, TextView.BufferType.NORMAL);
            developerName.setOnClickListener(new e(developerName, gn0Var));
        }
        UnifyTextView privacyView = getPrivacyView();
        if (gn0Var != null && (nn0Var10 = gn0Var.i) != null && (cVar3 = nn0Var10.g) != null) {
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
            if (gn0Var != null && (nn0Var9 = gn0Var.i) != null && (cVar2 = nn0Var9.g) != null) {
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
                    if (gn0Var != null && (nn0Var8 = gn0Var.i) != null && (cVar = nn0Var8.g) != null) {
                        str9 = cVar.a;
                    } else {
                        str9 = null;
                    }
                    privacyView.setTextWithUnifiedPadding(str9, TextView.BufferType.NORMAL);
                    privacyView.setOnClickListener(new f(privacyView, this, gn0Var));
                }
                UnifyTextView permissionView = getPermissionView();
                if (gn0Var == null && (nn0Var7 = gn0Var.i) != null && (bVar3 = nn0Var7.h) != null) {
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
                    if (gn0Var != null && (nn0Var6 = gn0Var.i) != null && (bVar2 = nn0Var6.h) != null) {
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
                            if (gn0Var != null && (nn0Var5 = gn0Var.i) != null && (bVar = nn0Var5.h) != null) {
                                str7 = bVar.a;
                            } else {
                                str7 = null;
                            }
                            permissionView.setTextWithUnifiedPadding(str7, TextView.BufferType.NORMAL);
                            permissionView.setOnClickListener(new g(permissionView, this, gn0Var));
                        }
                        UnifyTextView featureView = getFeatureView();
                        if (gn0Var == null && (nn0Var4 = gn0Var.i) != null && (aVar3 = nn0Var4.i) != null) {
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
                            if (gn0Var != null && (nn0Var3 = gn0Var.i) != null && (aVar2 = nn0Var3.i) != null) {
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
                            if (gn0Var != null && (nn0Var2 = gn0Var.i) != null && (aVar = nn0Var2.i) != null) {
                                str13 = aVar.a;
                            }
                            featureView.setTextWithUnifiedPadding(str13, TextView.BufferType.NORMAL);
                            featureView.setOnClickListener(new h(featureView, this, gn0Var));
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
                if (gn0Var == null) {
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
        if (gn0Var == null) {
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
        if (gn0Var == null) {
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

    private final void setBrandName(gn0 gn0Var) {
        String str;
        boolean z;
        on0 b2;
        on0 b3;
        UnifyTextView brandName = getBrandName();
        String str2 = null;
        if (gn0Var != null && (b3 = gn0Var.b()) != null) {
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
            if (gn0Var != null && (b2 = gn0Var.b()) != null) {
                str2 = b2.b();
            }
            brandName.setText(str2);
        }
        brandName.setOnClickListener(new j(gn0Var));
    }

    private final void setTitle(gn0 gn0Var) {
        String str;
        boolean z;
        on0 b2;
        on0 b3;
        UnifyTextView title = getTitle();
        String str2 = null;
        if (gn0Var != null && (b3 = gn0Var.b()) != null) {
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
            if (gn0Var != null && (b2 = gn0Var.b()) != null) {
                str2 = b2.g();
            }
            title.setText(str2);
        }
        title.setOnClickListener(new m(gn0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDetailButton(gn0 gn0Var) {
        String str;
        boolean z;
        String str2;
        String str3;
        on0 b2;
        on0 b3;
        wm0 wm0Var;
        wm0 wm0Var2;
        on0 b4;
        View detailBtn = getDetailBtn();
        Resources resources = detailBtn.getResources();
        wk0 a2 = al0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension = resources.getDimension(a2.i());
        GradientDrawable gradientDrawable = new GradientDrawable();
        String str4 = null;
        if (gn0Var != null && (b4 = gn0Var.b()) != null) {
            str = b4.c();
        } else {
            str = null;
        }
        gradientDrawable.setColor(p11.a(str, R.color.nad_reward_big_card_btn_color));
        gradientDrawable.setCornerRadius(dimension);
        Unit unit = Unit.INSTANCE;
        detailBtn.setBackground(gradientDrawable);
        boolean z2 = true;
        if (gn0Var != null) {
            z = gn0Var.o();
        } else {
            z = true;
        }
        if (z) {
            detailBtn.setVisibility(0);
        } else {
            detailBtn.setVisibility(8);
        }
        detailBtn.setOnClickListener(new k(gn0Var));
        TextView detailBtnText = getDetailBtnText();
        if (gn0Var != null && (wm0Var2 = gn0Var.m) != null && wm0Var2.g) {
            String str5 = ClogBuilder.Area.OPEN_BUTTON.type;
            Intrinsics.checkNotNullExpressionValue(str5, "ClogBuilder.Area.OPEN_BUTTON.type");
            m(this, str5, ClogBuilder.LogType.FREE_SHOW, null, null, 12, null);
        }
        if (gn0Var != null && (wm0Var = gn0Var.m) != null && wm0Var.g) {
            str3 = detailBtnText.getContext().getString(R.string.nad_reward_detail_btn_open_app);
        } else {
            if (gn0Var != null && (b3 = gn0Var.b()) != null) {
                str2 = b3.e();
            } else {
                str2 = null;
            }
            if (str2 != null && !StringsKt__StringsJVMKt.isBlank(str2)) {
                z2 = false;
            }
            if (!z2) {
                if (gn0Var != null && (b2 = gn0Var.b()) != null) {
                    str4 = b2.e();
                }
            } else {
                str4 = detailBtnText.getContext().getString(R.string.nad_reward_detail_btn_text);
            }
            str3 = str4;
        }
        detailBtnText.setText(str3);
    }

    private final void setDownloadButton(gn0 gn0Var) {
        String str;
        boolean z;
        boolean z2;
        Object obj;
        sm0 sm0Var;
        String str2;
        wm0 wm0Var;
        an0 an0Var;
        wm0 wm0Var2;
        wm0 wm0Var3;
        sm0 sm0Var2;
        pn0 c2;
        on0 b2;
        zd0 zd0Var = this.q;
        if (zd0Var != null) {
            zd0Var.k();
        }
        String str3 = null;
        this.q = null;
        NadMiniVideoDownloadView downloadButton = getDownloadButton();
        Resources resources = downloadButton.getResources();
        wk0 a2 = al0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension = resources.getDimension(a2.i());
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (gn0Var != null && (b2 = gn0Var.b()) != null) {
            str = b2.c();
        } else {
            str = null;
        }
        gradientDrawable.setColor(p11.a(str, R.color.nad_reward_big_card_btn_color));
        gradientDrawable.setCornerRadius(dimension);
        Unit unit = Unit.INSTANCE;
        downloadButton.setBackground(gradientDrawable);
        downloadButton.setBorderRadius(dimension);
        downloadButton.setProgressColor(ContextCompat.getColor(downloadButton.getContext(), R.color.nad_reward_big_card_btn_download_progress));
        if (gn0Var != null && (c2 = gn0Var.c()) != null) {
            z = c2.e();
        } else {
            z = false;
        }
        downloadButton.setIconArrowSwitch(z);
        if (gn0Var != null) {
            z2 = gn0Var.p();
        } else {
            z2 = false;
        }
        boolean z3 = true;
        if ((!z2 || gn0Var == null || (wm0Var3 = gn0Var.m) == null || (sm0Var2 = wm0Var3.p) == null || !sm0Var2.e) ? false : false) {
            downloadButton.setVisibility(0);
            obj = downloadButton;
        } else {
            downloadButton.setVisibility(8);
            obj = null;
        }
        if (obj != null) {
            if (gn0Var != null && (wm0Var2 = gn0Var.m) != null) {
                sm0Var = wm0Var2.p;
            } else {
                sm0Var = null;
            }
            if (gn0Var != null && (an0Var = gn0Var.f) != null) {
                str2 = an0Var.d;
            } else {
                str2 = null;
            }
            if (gn0Var != null && (wm0Var = gn0Var.m) != null) {
                str3 = wm0Var.t;
            }
            vg0 d2 = vg0.d(sm0Var, str2, str3);
            Intrinsics.checkNotNullExpressionValue(d2, "AdDownloadBean.from(adMo….enhanceModel?.btnScheme)");
            d2.q.a = ClogBuilder.Page.WELFAREBIGCARD.type;
            zd0 zd0Var2 = new zd0(d2, getDownloadButton());
            this.q = zd0Var2;
            Intrinsics.checkNotNull(zd0Var2);
            zd0Var2.z();
        }
        downloadButton.setOnClickListener(new l(gn0Var));
    }

    public final void i(String str, ClogBuilder.LogType logType, String str2) {
        m(this, str, logType, null, null, 12, null);
        pe0.c(str2, getContext());
    }

    public final void j() {
        int a2;
        AdImageView arrow = getArrow();
        arrow.setImageResource(R.drawable.nad_reward_big_card_arrow);
        ViewGroup.LayoutParams layoutParams = arrow.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            gn0 gn0Var = this.p;
            if (gn0Var != null && gn0Var.o()) {
                a2 = t11.c.a(arrow.getContext(), 10.0f);
            } else {
                a2 = t11.c.a(arrow.getContext(), 25.0f);
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
        si0.a().c(this, new c(gd0.class));
    }

    public final void p() {
        getBigCardPopupAnimator().cancel();
    }

    public final void l(String str, ClogBuilder.LogType logType, String str2, String str3) {
        String str4;
        boolean z;
        an0 an0Var;
        ClogBuilder u = new ClogBuilder().j(str).y(logType).u(ClogBuilder.Page.WELFAREBIGCARD);
        gn0 gn0Var = this.p;
        List<MonitorUrl> list = null;
        if (gn0Var != null && (an0Var = gn0Var.f) != null) {
            str4 = an0Var.d;
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
        az0.e(p);
        if (logType == ClogBuilder.LogType.CLICK) {
            gn0 gn0Var2 = this.p;
            if (gn0Var2 != null) {
                list = gn0Var2.e;
            }
            be0.b(list);
        }
    }
}
