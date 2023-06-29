package com.baidu.nadcore.lp.reward.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.txt.UnifyTextView;
import com.baidu.nadcore.widget.uiwidget.ExpandIconView;
import com.baidu.searchbox.common.security.PermissionStorage;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.R;
import com.baidu.tieba.c61;
import com.baidu.tieba.ck0;
import com.baidu.tieba.dm0;
import com.baidu.tieba.fs0;
import com.baidu.tieba.g61;
import com.baidu.tieba.gs0;
import com.baidu.tieba.hs0;
import com.baidu.tieba.jj0;
import com.baidu.tieba.lj0;
import com.baidu.tieba.lk0;
import com.baidu.tieba.mr0;
import com.baidu.tieba.p81;
import com.baidu.tieba.qi0;
import com.baidu.tieba.qr0;
import com.baidu.tieba.r31;
import com.baidu.tieba.tn0;
import com.baidu.tieba.ur0;
import com.baidu.tieba.v81;
import com.baidu.tieba.w81;
import com.baidu.tieba.xj0;
import com.baidu.tieba.xn0;
import com.baidu.tieba.yr0;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\u0010\u008a\u0001\u001a\u00030\u0089\u0001\u0012\f\b\u0002\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u0001\u0012\n\b\u0002\u0010\u008e\u0001\u001a\u00030\u008d\u0001¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0003¢\u0006\u0004\b\u0011\u0010\u0010J3\u0010\u0014\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0010J\r\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u0010J\u0019\u0010\u001e\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b \u0010\u001fJ\u001b\u0010#\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0!¢\u0006\u0004\b#\u0010$J!\u0010&\u001a\u00020\f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0%¢\u0006\u0004\b&\u0010'J\u0019\u0010(\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b(\u0010\u001fJ\u0019\u0010)\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b)\u0010\u001fJ\u001b\u0010*\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0!¢\u0006\u0004\b*\u0010$J\u0017\u0010+\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b+\u0010\u001fJ\u0019\u0010,\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b,\u0010\u001fJ\u0019\u0010-\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b-\u0010\u001fJ\u001b\u0010.\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0!¢\u0006\u0004\b.\u0010$J!\u0010/\u001a\u00020\f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0%¢\u0006\u0004\b/\u0010'J\u0019\u00100\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b0\u0010\u001fJ\u0015\u00102\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0004¢\u0006\u0004\b2\u00103J\u0015\u00105\u001a\u00020\f2\u0006\u00104\u001a\u00020\u0004¢\u0006\u0004\b5\u00103R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u00106R\u001d\u0010<\u001a\u0002078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001d\u0010A\u001a\u00020=8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u00109\u001a\u0004\b?\u0010@R\u001d\u0010F\u001a\u00020B8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u00109\u001a\u0004\bD\u0010ER\u001e\u0010G\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u001d\u0010M\u001a\u00020I8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u00109\u001a\u0004\bK\u0010LR$\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u001d\u0010T\u001a\u00020P8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u00109\u001a\u0004\bR\u0010SR\u0016\u0010U\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u001e\u0010W\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010HR\u001d\u0010\\\u001a\u00020X8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u00109\u001a\u0004\bZ\u0010[R\u001d\u0010a\u001a\u00020]8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u00109\u001a\u0004\b_\u0010`R\u001d\u0010d\u001a\u00020P8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u00109\u001a\u0004\bc\u0010SR\u001d\u0010i\u001a\u00020e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u00109\u001a\u0004\bg\u0010hR\u0018\u0010k\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010n\u001a\u00020m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010q\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u001e\u0010s\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010HR\u001d\u0010v\u001a\u00020P8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bt\u00109\u001a\u0004\bu\u0010SR\u001d\u0010y\u001a\u00020P8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bw\u00109\u001a\u0004\bx\u0010SR\u0016\u0010z\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010}\u001a\u00020|8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R$\u0010\u007f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010OR \u0010\u0082\u0001\u001a\u0002078B@\u0002X\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0080\u0001\u00109\u001a\u0005\b\u0081\u0001\u0010;R \u0010\u0085\u0001\u001a\u00020P8B@\u0002X\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0083\u0001\u00109\u001a\u0005\b\u0084\u0001\u0010SR \u0010\u0088\u0001\u001a\u00020P8B@\u0002X\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0086\u0001\u00109\u001a\u0005\b\u0087\u0001\u0010S¨\u0006\u0091\u0001"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardBigCardView;", "Landroid/widget/FrameLayout;", "", "scheme", "", "checkRewardPanelPop", "(Ljava/lang/String;)Z", "getLogTime", "()Ljava/lang/String;", DnsModel.AREA_KEY, "Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;", "logType", "", "handleClick", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;)V", "initArrow", "()V", "initSwipeUp", PermissionStorage.PermissionItem.ITEM_EXT_1, PermissionStorage.PermissionItem.ITEM_EXT_2, "logAndCharge", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;Ljava/lang/String;)V", "", "showProgress", "onProgressChanged", "(F)V", "registerRewardTaskEvent", "release", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setAppInfo", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "setAvatar", "Lkotlin/Function0;", WebChromeClient.KEY_ARG_CALLBACK, "setBackBtnCallback", "(Lkotlin/Function0;)V", "Lkotlin/Function1;", "setBigCardShowProgress", "(Lkotlin/Function1;)V", "setBrandName", "setButton", "setCloseClickCallback", "setData", "setDetailButton", "setDownloadButton", "setPanelPopDismissCallback", "setShowPanelPopCallback", "setTitle", "isVisible", "setVisibility", "(Z)V", "autoPopup", "showPanelPop", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Landroid/widget/LinearLayout;", "appInfoView$delegate", "Lkotlin/Lazy;", "getAppInfoView", "()Landroid/widget/LinearLayout;", "appInfoView", "Lcom/baidu/nadcore/widget/uiwidget/ExpandIconView;", "arrow$delegate", "getArrow", "()Lcom/baidu/nadcore/widget/uiwidget/ExpandIconView;", "arrow", "Lcom/baidu/nadcore/widget/AdImageView;", "avatar$delegate", "getAvatar", "()Lcom/baidu/nadcore/widget/AdImageView;", "avatar", "backBtnCallback", "Lkotlin/Function0;", "Landroid/animation/ValueAnimator;", "bigCardPopupAnimator$delegate", "getBigCardPopupAnimator", "()Landroid/animation/ValueAnimator;", "bigCardPopupAnimator", "bigCardShowProgress", "Lkotlin/Function1;", "Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "brandName$delegate", "getBrandName", "()Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "brandName", "chargeMode", "Ljava/lang/String;", "closeIconCallback", "Landroid/view/View;", "detailBtn$delegate", "getDetailBtn", "()Landroid/view/View;", "detailBtn", "Landroid/widget/TextView;", "detailBtnText$delegate", "getDetailBtnText", "()Landroid/widget/TextView;", "detailBtnText", "developerName$delegate", "getDeveloperName", "developerName", "Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton$delegate", "getDownloadButton", "()Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "downloadPresenter", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "", "loadStartTime", "J", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "panelPop", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "panelPopDismissCallback", "permissionView$delegate", "getPermissionView", "permissionView", "privacyView$delegate", "getPrivacyView", "privacyView", "shouldCharge", "Z", "Ljava/lang/Runnable;", "shouldChargeTask", "Ljava/lang/Runnable;", "showPanelPopCallback", "tagContainer$delegate", "getTagContainer", "tagContainer", "title$delegate", "getTitle", "title", "version$delegate", WebChromeClient.MSG_METHOD_GETVERSION, "version", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
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
    public p81 n;
    public yr0 o;
    public jj0 p;
    public String q;
    public boolean r;
    public Runnable s;
    public long t;
    public Function1<? super Boolean, Unit> u;
    public Function0<Unit> v;
    public Function0<Unit> w;
    public Function0<Unit> x;
    public Function1<? super Float, Unit> y;
    public final Lazy z;

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

    private final ExpandIconView getArrow() {
        return (ExpandIconView) this.h.getValue();
    }

    private final AdImageView getAvatar() {
        return (AdImageView) this.a.getValue();
    }

    private final ValueAnimator getBigCardPopupAnimator() {
        return (ValueAnimator) this.z.getValue();
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
            gs0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.ARROW.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.ARROW.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            yr0 yr0Var = NadRewardBigCardView.this.o;
            if (yr0Var != null && (b = yr0Var.b()) != null) {
                str = b.d();
            } else {
                str = null;
            }
            nadRewardBigCardView.q(str2, logType, str);
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
            qr0 qr0Var;
            String str;
            gs0 b;
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
                        yr0 yr0Var = NadRewardBigCardView.this.o;
                        if (yr0Var == null || (qr0Var = yr0Var.m) == null || !qr0Var.g) {
                            NadRewardBigCardView.this.y(false);
                        } else {
                            yr0 yr0Var2 = NadRewardBigCardView.this.o;
                            if (yr0Var2 != null && (b = yr0Var2.b()) != null) {
                                str = b.d();
                            } else {
                                str = null;
                            }
                            xj0.c(str, NadRewardBigCardView.this.getContext());
                        }
                        NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
                        String str2 = ClogBuilder.Area.SWIPE_UP.type;
                        Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.SWIPE_UP.type");
                        NadRewardBigCardView.u(nadRewardBigCardView, str2, ClogBuilder.LogType.CLICK, null, null, 12, null);
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
    public static final class c extends xn0<qi0> {
        public c(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xn0
        public void onEvent(qi0 event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!Intrinsics.areEqual(event.a, "4")) {
                return;
            }
            yr0 yr0Var = NadRewardBigCardView.this.o;
            if (yr0Var == null || yr0Var.l()) {
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
                            gradientDrawable.setColors(new int[]{c61.a(event.d, R.color.nad_reward_big_card_btn_color), c61.a(event.e, R.color.nad_reward_big_card_btn_color)});
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
                    nadRewardBigCardView.t("", logType, "4", str2);
                    return;
                }
                yr0 yr0Var2 = NadRewardBigCardView.this.o;
                if (yr0Var2 == null) {
                    return;
                }
                NadRewardBigCardView.this.setDetailButton(yr0Var2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ yr0 b;

        public d(UnifyTextView unifyTextView, yr0 yr0Var) {
            this.a = unifyTextView;
            this.b = yr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            fs0 fs0Var;
            Context context = this.a.getContext();
            yr0 yr0Var = this.b;
            if (yr0Var != null && (fs0Var = yr0Var.i) != null) {
                str = fs0Var.f;
            } else {
                str = null;
            }
            Toast.makeText(context, str, 0).show();
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ yr0 b;

        public e(UnifyTextView unifyTextView, yr0 yr0Var) {
            this.a = unifyTextView;
            this.b = yr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            fs0 fs0Var;
            Context context = this.a.getContext();
            yr0 yr0Var = this.b;
            if (yr0Var != null && (fs0Var = yr0Var.i) != null) {
                str = fs0Var.d;
            } else {
                str = null;
            }
            Toast.makeText(context, str, 0).show();
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ NadRewardBigCardView b;
        public final /* synthetic */ yr0 c;

        public f(UnifyTextView unifyTextView, NadRewardBigCardView nadRewardBigCardView, yr0 yr0Var) {
            this.a = unifyTextView;
            this.b = nadRewardBigCardView;
            this.c = yr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            fs0 fs0Var;
            fs0.b bVar;
            NadRewardBigCardView nadRewardBigCardView = this.b;
            String str2 = ClogBuilder.Area.APP_PRIVACY.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PRIVACY.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            yr0 yr0Var = this.c;
            if (yr0Var != null && (fs0Var = yr0Var.i) != null && (bVar = fs0Var.g) != null) {
                str = bVar.b;
            } else {
                str = null;
            }
            nadRewardBigCardView.q(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ NadRewardBigCardView b;
        public final /* synthetic */ yr0 c;

        public g(UnifyTextView unifyTextView, NadRewardBigCardView nadRewardBigCardView, yr0 yr0Var) {
            this.a = unifyTextView;
            this.b = nadRewardBigCardView;
            this.c = yr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            fs0 fs0Var;
            fs0.a aVar;
            NadRewardBigCardView nadRewardBigCardView = this.b;
            String str2 = ClogBuilder.Area.APP_PERMISSION.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PERMISSION.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            yr0 yr0Var = this.c;
            if (yr0Var != null && (fs0Var = yr0Var.i) != null && (aVar = fs0Var.h) != null) {
                str = aVar.b;
            } else {
                str = null;
            }
            nadRewardBigCardView.q(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements View.OnClickListener {
        public final /* synthetic */ yr0 b;

        public h(yr0 yr0Var) {
            this.b = yr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            gs0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.AVATAR.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.AVATAR.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            yr0 yr0Var = this.b;
            if (yr0Var != null && (b = yr0Var.b()) != null) {
                str = b.d();
            } else {
                str = null;
            }
            nadRewardBigCardView.q(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class i implements View.OnClickListener {
        public final /* synthetic */ yr0 b;

        public i(yr0 yr0Var) {
            this.b = yr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            gs0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.NAME.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.NAME.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            yr0 yr0Var = this.b;
            if (yr0Var != null && (b = yr0Var.b()) != null) {
                str = b.d();
            } else {
                str = null;
            }
            nadRewardBigCardView.q(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class j implements View.OnClickListener {
        public final /* synthetic */ yr0 b;

        public j(yr0 yr0Var) {
            this.b = yr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            gs0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.AD_BTN_DETAIL.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.AD_BTN_DETAIL.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            yr0 yr0Var = this.b;
            if (yr0Var != null && (b = yr0Var.b()) != null) {
                str = b.d();
            } else {
                str = null;
            }
            nadRewardBigCardView.q(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class k implements View.OnClickListener {
        public k(yr0 yr0Var) {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            jj0 jj0Var = NadRewardBigCardView.this.p;
            if (jj0Var != null) {
                jj0Var.m();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class l implements View.OnClickListener {
        public final /* synthetic */ yr0 b;

        public l(yr0 yr0Var) {
            this.b = yr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            gs0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.TITTLE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.TITTLE.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            yr0 yr0Var = this.b;
            if (yr0Var != null && (b = yr0Var.b()) != null) {
                str = b.d();
            } else {
                str = null;
            }
            nadRewardBigCardView.q(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NadRewardBigCardView.this.r = true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class n implements v81 {
        public final /* synthetic */ boolean b;

        public n(boolean z) {
            this.b = z;
        }

        @Override // com.baidu.tieba.v81
        public void a() {
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str = ClogBuilder.Area.DOWN_ARROW.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.DOWN_ARROW.type");
            NadRewardBigCardView.u(nadRewardBigCardView, str, ClogBuilder.LogType.FREE_CLICK, null, null, 12, null);
        }

        @Override // com.baidu.tieba.v81
        public void b() {
            Function0 function0 = NadRewardBigCardView.this.x;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }

        @Override // com.baidu.tieba.v81
        public void d() {
            Function0 function0 = NadRewardBigCardView.this.w;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }

        @Override // com.baidu.tieba.v81
        public void dismiss() {
            Function0 function0 = NadRewardBigCardView.this.v;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }

        @Override // com.baidu.tieba.v81
        public void f() {
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str = ClogBuilder.Area.AD_BLANK.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.AD_BLANK.type");
            NadRewardBigCardView.u(nadRewardBigCardView, str, ClogBuilder.LogType.FREE_CLICK, null, null, 12, null);
        }

        @Override // com.baidu.tieba.v81
        public void c() {
            if (!this.b) {
                return;
            }
            if (TextUtils.equals(NadRewardBigCardView.this.q, "1") || TextUtils.equals(NadRewardBigCardView.this.q, "2")) {
                if (NadRewardBigCardView.this.r) {
                    NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
                    String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                    Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                    nadRewardBigCardView.t(str, ClogBuilder.LogType.CLICK, NadRewardBigCardView.this.getLogTime(), "1");
                    return;
                }
                NadRewardBigCardView nadRewardBigCardView2 = NadRewardBigCardView.this;
                String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                nadRewardBigCardView2.t(str2, ClogBuilder.LogType.FREE_CLICK, NadRewardBigCardView.this.getLogTime(), "1");
            }
        }

        @Override // com.baidu.tieba.v81
        public void e() {
            if (!this.b) {
                return;
            }
            if (TextUtils.equals(NadRewardBigCardView.this.q, "2") && NadRewardBigCardView.this.r) {
                NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                nadRewardBigCardView.t(str, ClogBuilder.LogType.CLICK, NadRewardBigCardView.this.getLogTime(), "2");
            }
            if (TextUtils.equals(NadRewardBigCardView.this.q, "1")) {
                NadRewardBigCardView nadRewardBigCardView2 = NadRewardBigCardView.this;
                String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                nadRewardBigCardView2.t(str2, ClogBuilder.LogType.FREE_CLICK, NadRewardBigCardView.this.getLogTime(), "2");
            }
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
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.obfuscated_res_0x7f090315);
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
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.obfuscated_res_0x7f09250e);
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
        this.h = LazyKt__LazyJVMKt.lazy(new Function0<ExpandIconView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$arrow$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExpandIconView invoke() {
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.arrow_image);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.arrow_image)");
                return (ExpandIconView) findViewById;
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
        this.q = "0";
        this.s = new m();
        this.z = LazyKt__LazyJVMKt.lazy(new Function0<ValueAnimator>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$bigCardPopupAnimator$2
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
                        NadRewardBigCardView.this.v(f.floatValue());
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
        LayoutInflater.from(context).inflate(R.layout.nad_reward_big_card_layout, this);
    }

    public /* synthetic */ NadRewardBigCardView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void setAvatar(yr0 yr0Var) {
        String str;
        gs0 b2;
        AdImageView avatar = getAvatar();
        avatar.setBorder(1.0f, avatar.getResources().getColor(R.color.nad_reward_big_card_avatar_stroke));
        if (yr0Var != null && (b2 = yr0Var.b()) != null) {
            str = b2.a();
        } else {
            str = null;
        }
        avatar.o(str);
        avatar.setOnClickListener(new h(yr0Var));
    }

    private final void setButton(yr0 yr0Var) {
        setDetailButton(yr0Var);
        setDownloadButton(yr0Var);
    }

    public final boolean p(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z || !lk0.o(str)) {
            return false;
        }
        return Intrinsics.areEqual(new ck0(str).a(), "rewardWebPanel");
    }

    public final void setBackBtnCallback(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.w = callback;
    }

    public final void setBigCardShowProgress(Function1<? super Float, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.y = callback;
    }

    public final void setCloseClickCallback(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.x = callback;
    }

    public final void setData(yr0 yr0Var) {
        this.o = yr0Var;
        setAvatar(yr0Var);
        setBrandName(yr0Var);
        setTitle(yr0Var);
        setButton(yr0Var);
        setAppInfo(yr0Var);
        w();
        r();
        s();
        this.r = false;
    }

    public final void setPanelPopDismissCallback(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.v = callback;
    }

    public final void setShowPanelPopCallback(Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.u = callback;
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
        p81 p81Var = this.n;
        if (p81Var != null) {
            p81Var.e();
        }
    }

    public final void v(float f2) {
        Function1<? super Float, Unit> function1;
        if (Math.abs(f2) >= 0.001d && (function1 = this.y) != null) {
            function1.invoke(Float.valueOf(f2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getLogTime() {
        return String.valueOf((System.currentTimeMillis() - this.t) / 1000);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void s() {
        setClickable(true);
        setOnTouchListener(new b());
    }

    public final void w() {
        tn0.a().b(this, new c(qi0.class));
    }

    public final void x() {
        getBigCardPopupAnimator().cancel();
        getHandler().removeCallbacks(this.s);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setAppInfo(yr0 yr0Var) {
        fs0 fs0Var;
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
        UnifyTextView unifyTextView4;
        fs0 fs0Var2;
        fs0.a aVar;
        String str5;
        boolean z6;
        fs0 fs0Var3;
        fs0.a aVar2;
        fs0 fs0Var4;
        fs0.a aVar3;
        String str6;
        fs0 fs0Var5;
        fs0.b bVar;
        String str7;
        boolean z7;
        fs0 fs0Var6;
        fs0.b bVar2;
        fs0 fs0Var7;
        fs0.b bVar3;
        String str8;
        fs0 fs0Var8;
        fs0 fs0Var9;
        String str9;
        fs0 fs0Var10;
        fs0 fs0Var11;
        LinearLayout appInfoView = getAppInfoView();
        String str10 = null;
        if (yr0Var != null) {
            fs0Var = yr0Var.i;
        } else {
            fs0Var = null;
        }
        if (lj0.a(fs0Var)) {
            appInfoView.setVisibility(0);
        } else {
            appInfoView.setVisibility(8);
        }
        UnifyTextView version = getVersion();
        if (yr0Var != null && (fs0Var11 = yr0Var.i) != null) {
            str = fs0Var11.f;
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
            if (yr0Var != null && (fs0Var10 = yr0Var.i) != null) {
                str9 = fs0Var10.f;
            } else {
                str9 = null;
            }
            version.setTextWithUnifiedPadding(str9, TextView.BufferType.NORMAL);
            version.setOnClickListener(new d(version, yr0Var));
        }
        UnifyTextView developerName = getDeveloperName();
        if (yr0Var != null && (fs0Var9 = yr0Var.i) != null) {
            str2 = fs0Var9.d;
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
            if (yr0Var != null && (fs0Var8 = yr0Var.i) != null) {
                str8 = fs0Var8.d;
            } else {
                str8 = null;
            }
            developerName.setTextWithUnifiedPadding(str8, TextView.BufferType.NORMAL);
            developerName.setOnClickListener(new e(developerName, yr0Var));
        }
        UnifyTextView privacyView = getPrivacyView();
        if (yr0Var != null && (fs0Var7 = yr0Var.i) != null && (bVar3 = fs0Var7.g) != null) {
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
            if (yr0Var != null && (fs0Var6 = yr0Var.i) != null && (bVar2 = fs0Var6.g) != null) {
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
                    if (yr0Var != null && (fs0Var5 = yr0Var.i) != null && (bVar = fs0Var5.g) != null) {
                        str6 = bVar.a;
                    } else {
                        str6 = null;
                    }
                    privacyView.setTextWithUnifiedPadding(str6, TextView.BufferType.NORMAL);
                    privacyView.setOnClickListener(new f(privacyView, this, yr0Var));
                }
                UnifyTextView permissionView = getPermissionView();
                if (yr0Var == null && (fs0Var4 = yr0Var.i) != null && (aVar3 = fs0Var4.h) != null) {
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
                    if (yr0Var != null && (fs0Var3 = yr0Var.i) != null && (aVar2 = fs0Var3.h) != null) {
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
                    if (yr0Var != null && (fs0Var2 = yr0Var.i) != null && (aVar = fs0Var2.h) != null) {
                        str10 = aVar.a;
                    }
                    permissionView.setTextWithUnifiedPadding(str10, TextView.BufferType.NORMAL);
                    permissionView.setOnClickListener(new g(permissionView, this, yr0Var));
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
        if (yr0Var == null) {
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

    private final void setBrandName(yr0 yr0Var) {
        String str;
        boolean z;
        gs0 b2;
        gs0 b3;
        UnifyTextView brandName = getBrandName();
        String str2 = null;
        if (yr0Var != null && (b3 = yr0Var.b()) != null) {
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
            if (yr0Var != null && (b2 = yr0Var.b()) != null) {
                str2 = b2.b();
            }
            brandName.setText(str2);
        }
        brandName.setOnClickListener(new i(yr0Var));
    }

    private final void setTitle(yr0 yr0Var) {
        String str;
        boolean z;
        gs0 b2;
        gs0 b3;
        UnifyTextView title = getTitle();
        String str2 = null;
        if (yr0Var != null && (b3 = yr0Var.b()) != null) {
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
            if (yr0Var != null && (b2 = yr0Var.b()) != null) {
                str2 = b2.g();
            }
            title.setText(str2);
        }
        title.setOnClickListener(new l(yr0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDetailButton(yr0 yr0Var) {
        String str;
        boolean z;
        String str2;
        String str3;
        gs0 b2;
        gs0 b3;
        qr0 qr0Var;
        qr0 qr0Var2;
        gs0 b4;
        View detailBtn = getDetailBtn();
        int a2 = g61.c.a(detailBtn.getContext(), 16.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        String str4 = null;
        if (yr0Var != null && (b4 = yr0Var.b()) != null) {
            str = b4.c();
        } else {
            str = null;
        }
        gradientDrawable.setColor(c61.a(str, R.color.nad_reward_big_card_btn_color));
        gradientDrawable.setCornerRadius(a2);
        Unit unit = Unit.INSTANCE;
        detailBtn.setBackground(gradientDrawable);
        boolean z2 = true;
        if (yr0Var != null) {
            z = yr0Var.l();
        } else {
            z = true;
        }
        if (z) {
            detailBtn.setVisibility(0);
        } else {
            detailBtn.setVisibility(8);
        }
        detailBtn.setOnClickListener(new j(yr0Var));
        TextView detailBtnText = getDetailBtnText();
        if (yr0Var != null && (qr0Var2 = yr0Var.m) != null && qr0Var2.g) {
            String str5 = ClogBuilder.Area.OPEN_BUTTON.type;
            Intrinsics.checkNotNullExpressionValue(str5, "ClogBuilder.Area.OPEN_BUTTON.type");
            u(this, str5, ClogBuilder.LogType.FREE_SHOW, null, null, 12, null);
        }
        if (yr0Var != null && (qr0Var = yr0Var.m) != null && qr0Var.g) {
            str3 = detailBtnText.getContext().getString(R.string.nad_reward_detail_btn_open_app);
        } else {
            if (yr0Var != null && (b3 = yr0Var.b()) != null) {
                str2 = b3.e();
            } else {
                str2 = null;
            }
            if (str2 != null && !StringsKt__StringsJVMKt.isBlank(str2)) {
                z2 = false;
            }
            if (!z2) {
                if (yr0Var != null && (b2 = yr0Var.b()) != null) {
                    str4 = b2.e();
                }
            } else {
                str4 = detailBtnText.getContext().getString(R.string.nad_reward_detail_btn_text);
            }
            str3 = str4;
        }
        detailBtnText.setText(str3);
    }

    private final void setDownloadButton(yr0 yr0Var) {
        String str;
        boolean z;
        boolean z2;
        Object obj;
        mr0 mr0Var;
        String str2;
        qr0 qr0Var;
        ur0 ur0Var;
        qr0 qr0Var2;
        qr0 qr0Var3;
        mr0 mr0Var2;
        hs0 c2;
        gs0 b2;
        jj0 jj0Var = this.p;
        if (jj0Var != null) {
            jj0Var.k();
        }
        String str3 = null;
        this.p = null;
        NadMiniVideoDownloadView downloadButton = getDownloadButton();
        int a2 = g61.c.a(downloadButton.getContext(), 16.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (yr0Var != null && (b2 = yr0Var.b()) != null) {
            str = b2.c();
        } else {
            str = null;
        }
        gradientDrawable.setColor(c61.a(str, R.color.nad_reward_big_card_btn_color));
        float f2 = a2;
        gradientDrawable.setCornerRadius(f2);
        Unit unit = Unit.INSTANCE;
        downloadButton.setBackground(gradientDrawable);
        downloadButton.setBorderRadius(f2);
        downloadButton.setTextSize(12.0f);
        downloadButton.setProgressColor(ContextCompat.getColor(downloadButton.getContext(), R.color.nad_reward_big_card_btn_download_progress));
        if (yr0Var != null && (c2 = yr0Var.c()) != null) {
            z = c2.f();
        } else {
            z = false;
        }
        downloadButton.setIconArrowSwitch(z);
        if (yr0Var != null) {
            z2 = yr0Var.m();
        } else {
            z2 = false;
        }
        boolean z3 = true;
        if ((!z2 || yr0Var == null || (qr0Var3 = yr0Var.m) == null || (mr0Var2 = qr0Var3.p) == null || !mr0Var2.e) ? false : false) {
            downloadButton.setVisibility(0);
            obj = downloadButton;
        } else {
            downloadButton.setVisibility(8);
            obj = null;
        }
        if (obj != null) {
            if (yr0Var != null && (qr0Var2 = yr0Var.m) != null) {
                mr0Var = qr0Var2.p;
            } else {
                mr0Var = null;
            }
            if (yr0Var != null && (ur0Var = yr0Var.f) != null) {
                str2 = ur0Var.d;
            } else {
                str2 = null;
            }
            if (yr0Var != null && (qr0Var = yr0Var.m) != null) {
                str3 = qr0Var.t;
            }
            dm0 d2 = dm0.d(mr0Var, str2, str3);
            Intrinsics.checkNotNullExpressionValue(d2, "AdDownloadBean.from(adMo….enhanceModel?.btnScheme)");
            d2.q.a = ClogBuilder.Page.WELFAREBIGCARD.type;
            jj0 jj0Var2 = new jj0(d2, getDownloadButton());
            this.p = jj0Var2;
            Intrinsics.checkNotNull(jj0Var2);
            jj0Var2.A();
        }
        downloadButton.setOnClickListener(new k(yr0Var));
    }

    public final void y(boolean z) {
        String str;
        boolean z2;
        String str2;
        String str3;
        String str4;
        ur0 ur0Var;
        ur0 ur0Var2;
        ur0 ur0Var3;
        hs0 c2;
        long j2;
        hs0 c3;
        yr0 yr0Var = this.o;
        String str5 = null;
        if (yr0Var != null) {
            str = yr0Var.e();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            this.n = null;
            return;
        }
        if (z) {
            String str6 = ClogBuilder.Area.SWIPE_UP.type;
            Intrinsics.checkNotNullExpressionValue(str6, "ClogBuilder.Area.SWIPE_UP.type");
            u(this, str6, ClogBuilder.LogType.FREE_CLICK, null, null, 12, null);
            Handler handler = getHandler();
            if (handler != null) {
                Runnable runnable = this.s;
                yr0 yr0Var2 = this.o;
                if (yr0Var2 != null && (c3 = yr0Var2.c()) != null) {
                    j2 = c3.d();
                } else {
                    j2 = 0;
                }
                handler.postDelayed(runnable, j2);
            }
        }
        p81 p81Var = new p81(getContext());
        yr0 yr0Var3 = this.o;
        this.q = (yr0Var3 == null || (c2 = yr0Var3.c()) == null || (r4 = c2.c()) == null) ? "0" : "0";
        p81Var.i(new n(z));
        double a2 = 1 - (g61.c.a(getContext(), 41.0f) / g61.c.c(getContext()));
        yr0 yr0Var4 = this.o;
        if (yr0Var4 != null) {
            str2 = yr0Var4.e();
        } else {
            str2 = null;
        }
        yr0 yr0Var5 = this.o;
        if (yr0Var5 != null && (ur0Var3 = yr0Var5.f) != null) {
            str3 = ur0Var3.d;
        } else {
            str3 = null;
        }
        w81 w81Var = new w81(str2, a2, 0, str3);
        w81Var.A(false);
        w81Var.C(true);
        w81Var.B(!z);
        w81Var.w(z);
        w81Var.x(z);
        w81Var.y(true);
        yr0 yr0Var6 = this.o;
        if (yr0Var6 != null && (ur0Var2 = yr0Var6.f) != null) {
            str4 = ur0Var2.m;
        } else {
            str4 = null;
        }
        if (!TextUtils.isEmpty(str4)) {
            yr0 yr0Var7 = this.o;
            if (yr0Var7 != null && (ur0Var = yr0Var7.f) != null) {
                str5 = ur0Var.l;
            }
            w81Var.v(str5);
        }
        Unit unit = Unit.INSTANCE;
        p81Var.h(w81Var);
        p81Var.j();
        this.t = System.currentTimeMillis();
        Unit unit2 = Unit.INSTANCE;
        this.n = p81Var;
        Function1<? super Boolean, Unit> function1 = this.u;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
    }

    public static /* synthetic */ void u(NadRewardBigCardView nadRewardBigCardView, String str, ClogBuilder.LogType logType, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        if ((i2 & 8) != 0) {
            str3 = "";
        }
        nadRewardBigCardView.t(str, logType, str2, str3);
    }

    public final void q(String str, ClogBuilder.LogType logType, String str2) {
        qr0 qr0Var;
        String str3;
        gs0 b2;
        u(this, str, logType, null, null, 12, null);
        yr0 yr0Var = this.o;
        boolean z = false;
        if (yr0Var != null && (qr0Var = yr0Var.m) != null && !qr0Var.g) {
            if (yr0Var != null && (b2 = yr0Var.b()) != null) {
                str3 = b2.d();
            } else {
                str3 = null;
            }
            if (p(str3)) {
                y(false);
                return;
            }
        }
        if (!((str2 == null || str2.length() == 0) ? true : true)) {
            xj0.c(str2, getContext());
        }
    }

    public final void r() {
        int a2;
        ExpandIconView arrow = getArrow();
        ViewGroup.LayoutParams layoutParams = arrow.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            yr0 yr0Var = this.o;
            if (yr0Var != null && yr0Var.l()) {
                a2 = g61.c.a(arrow.getContext(), 10.0f);
            } else {
                a2 = g61.c.a(arrow.getContext(), 25.0f);
            }
            layoutParams2.bottomMargin = a2;
            arrow.setLayoutParams(layoutParams2);
            arrow.setOnClickListener(new a());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public final void t(String str, ClogBuilder.LogType logType, String str2, String str3) {
        String str4;
        boolean z;
        ur0 ur0Var;
        ClogBuilder u = new ClogBuilder().j(str).y(logType).u(ClogBuilder.Page.WELFAREBIGCARD);
        yr0 yr0Var = this.o;
        List<MonitorUrl> list = null;
        if (yr0Var != null && (ur0Var = yr0Var.f) != null) {
            str4 = ur0Var.d;
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
        r31.b(p);
        if (logType == ClogBuilder.LogType.CLICK) {
            yr0 yr0Var2 = this.o;
            if (yr0Var2 != null) {
                list = yr0Var2.e;
            }
            lj0.b(list);
        }
    }
}
