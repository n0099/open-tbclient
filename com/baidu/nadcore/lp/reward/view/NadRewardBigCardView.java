package com.baidu.nadcore.lp.reward.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
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
import androidx.core.content.ContextCompat;
import com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.txt.UnifyTextView;
import com.baidu.searchbox.common.security.PermissionStorage;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.R;
import com.baidu.tieba.ae0;
import com.baidu.tieba.bl0;
import com.baidu.tieba.ce0;
import com.baidu.tieba.cn0;
import com.baidu.tieba.dz0;
import com.baidu.tieba.hd0;
import com.baidu.tieba.in0;
import com.baidu.tieba.j41;
import com.baidu.tieba.jl0;
import com.baidu.tieba.pn0;
import com.baidu.tieba.q41;
import com.baidu.tieba.qe0;
import com.baidu.tieba.r41;
import com.baidu.tieba.rn0;
import com.baidu.tieba.s11;
import com.baidu.tieba.sn0;
import com.baidu.tieba.ti0;
import com.baidu.tieba.tm0;
import com.baidu.tieba.v01;
import com.baidu.tieba.w11;
import com.baidu.tieba.wg0;
import com.baidu.tieba.xi0;
import com.baidu.tieba.xk0;
import com.baidu.tieba.xm0;
import com.baidu.tieba.y01;
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
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001\u0012\f\b\u0002\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001\u0012\n\b\u0002\u0010\u0086\u0001\u001a\u00030\u0085\u0001¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0003¢\u0006\u0004\b\u000e\u0010\rJ3\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\rJ\r\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\rJ\u0019\u0010\u001b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ!\u0010 \u001a\u00020\t2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u001e¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\"\u0010\u001cJ\u0019\u0010#\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b#\u0010\u001cJ\u0017\u0010$\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b$\u0010\u001cJ\u0019\u0010%\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b%\u0010\u001cJ\u0019\u0010&\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b&\u0010\u001cJ\u0019\u0010'\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b'\u0010\u001cJ\u0019\u0010(\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b(\u0010\u001cJ\u0015\u0010+\u001a\u00020\t2\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020)¢\u0006\u0004\b.\u0010,R\u001d\u00104\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u00105R\u001d\u00108\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00103R\u001d\u0010=\u001a\u0002098B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00101\u001a\u0004\b;\u0010<R\u001d\u0010@\u001a\u0002098B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u00101\u001a\u0004\b?\u0010<R\u001d\u0010E\u001a\u00020A8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u00101\u001a\u0004\bC\u0010DR$\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u001d\u0010L\u001a\u00020H8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u00101\u001a\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001d\u0010S\u001a\u00020O8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u00101\u001a\u0004\bQ\u0010RR\u001d\u0010X\u001a\u00020T8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u00101\u001a\u0004\bV\u0010WR\u001d\u0010[\u001a\u00020H8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u00101\u001a\u0004\bZ\u0010KR\u001d\u0010`\u001a\u00020\\8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u00101\u001a\u0004\b^\u0010_R\u0018\u0010b\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u001d\u0010f\u001a\u00020H8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u00101\u001a\u0004\be\u0010KR\u0016\u0010h\u001a\u00020g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010k\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u001d\u0010o\u001a\u00020H8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bm\u00101\u001a\u0004\bn\u0010KR\u001d\u0010r\u001a\u00020H8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u00101\u001a\u0004\bq\u0010KR\u0016\u0010s\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010v\u001a\u00020u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u001d\u0010z\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u00101\u001a\u0004\by\u00103R\u001d\u0010}\u001a\u00020H8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b{\u00101\u001a\u0004\b|\u0010KR\u001e\u0010\u0080\u0001\u001a\u00020H8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b~\u00101\u001a\u0004\b\u007f\u0010K¨\u0006\u0089\u0001"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardBigCardView;", "Landroid/widget/FrameLayout;", "", "getLogTime", "()Ljava/lang/String;", DnsModel.AREA_KEY, "Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;", "logType", "scheme", "", "handleClick", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;)V", "initArrow", "()V", "initSwipeUp", PermissionStorage.PermissionItem.ITEM_EXT_1, PermissionStorage.PermissionItem.ITEM_EXT_2, "logAndCharge", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;Ljava/lang/String;)V", "", "showProgress", "onProgressChanged", "(F)V", "registerRewardTaskEvent", "release", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setAppInfo", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "setAvatar", "Lkotlin/Function1;", WebChromeClient.KEY_ARG_CALLBACK, "setBigCardShowProgress", "(Lkotlin/Function1;)V", "setBrandName", "setButton", "setData", "setDetailButton", "setDownloadButton", "setLayoutParams", "setTitle", "", "isVisible", "setVisibility", "(Z)V", "autoPopup", "showPanelPop", "Landroid/widget/LinearLayout;", "adInfoContainer$delegate", "Lkotlin/Lazy;", "getAdInfoContainer", "()Landroid/widget/LinearLayout;", "adInfoContainer", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "appInfoView$delegate", "getAppInfoView", "appInfoView", "Lcom/baidu/nadcore/widget/AdImageView;", "arrow$delegate", "getArrow", "()Lcom/baidu/nadcore/widget/AdImageView;", "arrow", "avatar$delegate", "getAvatar", "avatar", "Landroid/animation/ValueAnimator;", "bigCardPopupAnimator$delegate", "getBigCardPopupAnimator", "()Landroid/animation/ValueAnimator;", "bigCardPopupAnimator", "bigCardShowProgress", "Lkotlin/Function1;", "Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "brandName$delegate", "getBrandName", "()Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "brandName", "chargeMode", "Ljava/lang/String;", "Landroid/view/View;", "detailBtn$delegate", "getDetailBtn", "()Landroid/view/View;", "detailBtn", "Landroid/widget/TextView;", "detailBtnText$delegate", "getDetailBtnText", "()Landroid/widget/TextView;", "detailBtnText", "developerName$delegate", "getDeveloperName", "developerName", "Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton$delegate", "getDownloadButton", "()Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "downloadPresenter", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "featureView$delegate", "getFeatureView", "featureView", "", "loadStartTime", "J", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "panelPop", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "permissionView$delegate", "getPermissionView", "permissionView", "privacyView$delegate", "getPrivacyView", "privacyView", "shouldCharge", "Z", "Ljava/lang/Runnable;", "shouldChargeTask", "Ljava/lang/Runnable;", "tagContainer$delegate", "getTagContainer", "tagContainer", "title$delegate", "getTitle", "title", "version$delegate", WebChromeClient.MSG_METHOD_GETVERSION, "version", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
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
    public final Lazy o;
    public j41 p;
    public in0 q;
    public ae0 r;
    public String s;
    public boolean t;
    public Runnable u;
    public long v;
    public Function1<? super Float, Unit> w;
    public final Lazy x;

    @JvmOverloads
    public NadRewardBigCardView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public NadRewardBigCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final LinearLayout getAdInfoContainer() {
        return (LinearLayout) this.a.getValue();
    }

    private final LinearLayout getAppInfoView() {
        return (LinearLayout) this.j.getValue();
    }

    private final AdImageView getArrow() {
        return (AdImageView) this.i.getValue();
    }

    private final AdImageView getAvatar() {
        return (AdImageView) this.b.getValue();
    }

    private final ValueAnimator getBigCardPopupAnimator() {
        return (ValueAnimator) this.x.getValue();
    }

    private final UnifyTextView getBrandName() {
        return (UnifyTextView) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getDetailBtn() {
        return (View) this.f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getDetailBtnText() {
        return (TextView) this.g.getValue();
    }

    private final UnifyTextView getDeveloperName() {
        return (UnifyTextView) this.l.getValue();
    }

    private final NadMiniVideoDownloadView getDownloadButton() {
        return (NadMiniVideoDownloadView) this.h.getValue();
    }

    private final UnifyTextView getFeatureView() {
        return (UnifyTextView) this.o.getValue();
    }

    private final UnifyTextView getPermissionView() {
        return (UnifyTextView) this.n.getValue();
    }

    private final UnifyTextView getPrivacyView() {
        return (UnifyTextView) this.m.getValue();
    }

    private final LinearLayout getTagContainer() {
        return (LinearLayout) this.e.getValue();
    }

    private final UnifyTextView getTitle() {
        return (UnifyTextView) this.d.getValue();
    }

    private final UnifyTextView getVersion() {
        return (UnifyTextView) this.k.getValue();
    }

    /* loaded from: classes3.dex */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            rn0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.ARROW.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.ARROW.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            in0 in0Var = NadRewardBigCardView.this.q;
            if (in0Var != null && (b = in0Var.b()) != null) {
                str = b.e();
            } else {
                str = null;
            }
            nadRewardBigCardView.m(str2, logType, str);
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
            xm0 xm0Var;
            rn0 b;
            rn0 b2;
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
                        String str = null;
                        if (jl0.a.f()) {
                            in0 in0Var = NadRewardBigCardView.this.q;
                            if (in0Var != null && (b2 = in0Var.b()) != null) {
                                str = b2.e();
                            }
                            qe0.c(str, NadRewardBigCardView.this.getContext());
                        } else {
                            in0 in0Var2 = NadRewardBigCardView.this.q;
                            if (in0Var2 == null || (xm0Var = in0Var2.m) == null || !xm0Var.g) {
                                NadRewardBigCardView.this.u(false);
                            } else {
                                in0 in0Var3 = NadRewardBigCardView.this.q;
                                if (in0Var3 != null && (b = in0Var3.b()) != null) {
                                    str = b.e();
                                }
                                qe0.c(str, NadRewardBigCardView.this.getContext());
                            }
                        }
                        NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
                        String str2 = ClogBuilder.Area.SWIPE_UP.type;
                        Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.SWIPE_UP.type");
                        NadRewardBigCardView.q(nadRewardBigCardView, str2, ClogBuilder.LogType.CLICK, null, null, 12, null);
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
    public static final class c extends xi0<hd0> {
        public c(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi0
        public void onEvent(hd0 event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!Intrinsics.areEqual(event.a, "4")) {
                return;
            }
            in0 in0Var = NadRewardBigCardView.this.q;
            if (in0Var == null || in0Var.p()) {
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
                            gradientDrawable.setColors(new int[]{s11.a(event.d, R.color.nad_reward_big_card_btn_color), s11.a(event.e, R.color.nad_reward_big_card_btn_color)});
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
                    nadRewardBigCardView.p("", logType, "4", str2);
                    return;
                }
                in0 in0Var2 = NadRewardBigCardView.this.q;
                if (in0Var2 == null) {
                    return;
                }
                NadRewardBigCardView.this.setDetailButton(in0Var2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ in0 b;

        public d(UnifyTextView unifyTextView, in0 in0Var) {
            this.a = unifyTextView;
            this.b = in0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            pn0 pn0Var;
            v01 a = y01.a();
            Context context = this.a.getContext();
            in0 in0Var = this.b;
            if (in0Var != null && (pn0Var = in0Var.i) != null) {
                str = pn0Var.f;
            } else {
                str = null;
            }
            a.b(context, str, 0);
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ in0 b;

        public e(UnifyTextView unifyTextView, in0 in0Var) {
            this.a = unifyTextView;
            this.b = in0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            pn0 pn0Var;
            v01 a = y01.a();
            Context context = this.a.getContext();
            in0 in0Var = this.b;
            if (in0Var != null && (pn0Var = in0Var.i) != null) {
                str = pn0Var.d;
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
        public final /* synthetic */ in0 c;

        public f(UnifyTextView unifyTextView, NadRewardBigCardView nadRewardBigCardView, in0 in0Var) {
            this.a = unifyTextView;
            this.b = nadRewardBigCardView;
            this.c = in0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            pn0 pn0Var;
            pn0.c cVar;
            NadRewardBigCardView nadRewardBigCardView = this.b;
            String str2 = ClogBuilder.Area.APP_PRIVACY.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PRIVACY.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            in0 in0Var = this.c;
            if (in0Var != null && (pn0Var = in0Var.i) != null && (cVar = pn0Var.g) != null) {
                str = cVar.b;
            } else {
                str = null;
            }
            nadRewardBigCardView.m(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ NadRewardBigCardView b;
        public final /* synthetic */ in0 c;

        public g(UnifyTextView unifyTextView, NadRewardBigCardView nadRewardBigCardView, in0 in0Var) {
            this.a = unifyTextView;
            this.b = nadRewardBigCardView;
            this.c = in0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            pn0 pn0Var;
            pn0.b bVar;
            NadRewardBigCardView nadRewardBigCardView = this.b;
            String str2 = ClogBuilder.Area.APP_PERMISSION.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PERMISSION.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            in0 in0Var = this.c;
            if (in0Var != null && (pn0Var = in0Var.i) != null && (bVar = pn0Var.h) != null) {
                str = bVar.b;
            } else {
                str = null;
            }
            nadRewardBigCardView.m(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ NadRewardBigCardView b;
        public final /* synthetic */ in0 c;

        public h(UnifyTextView unifyTextView, NadRewardBigCardView nadRewardBigCardView, in0 in0Var) {
            this.a = unifyTextView;
            this.b = nadRewardBigCardView;
            this.c = in0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            pn0 pn0Var;
            pn0.a aVar;
            NadRewardBigCardView nadRewardBigCardView = this.b;
            String str2 = ClogBuilder.Area.APP_FEATURE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_FEATURE.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            in0 in0Var = this.c;
            if (in0Var != null && (pn0Var = in0Var.i) != null && (aVar = pn0Var.i) != null) {
                str = aVar.b;
            } else {
                str = null;
            }
            nadRewardBigCardView.m(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class i implements View.OnClickListener {
        public final /* synthetic */ in0 b;

        public i(in0 in0Var) {
            this.b = in0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            rn0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.AVATAR.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.AVATAR.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            in0 in0Var = this.b;
            if (in0Var != null && (b = in0Var.b()) != null) {
                str = b.e();
            } else {
                str = null;
            }
            nadRewardBigCardView.m(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class j implements View.OnClickListener {
        public final /* synthetic */ in0 b;

        public j(in0 in0Var) {
            this.b = in0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            rn0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.NAME.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.NAME.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            in0 in0Var = this.b;
            if (in0Var != null && (b = in0Var.b()) != null) {
                str = b.e();
            } else {
                str = null;
            }
            nadRewardBigCardView.m(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class k implements View.OnClickListener {
        public final /* synthetic */ in0 b;

        public k(in0 in0Var) {
            this.b = in0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            rn0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.AD_BTN_DETAIL.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.AD_BTN_DETAIL.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            in0 in0Var = this.b;
            if (in0Var != null && (b = in0Var.b()) != null) {
                str = b.e();
            } else {
                str = null;
            }
            nadRewardBigCardView.m(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class l implements View.OnClickListener {
        public l(in0 in0Var) {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            ae0 ae0Var = NadRewardBigCardView.this.r;
            if (ae0Var != null) {
                ae0Var.l();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class m implements View.OnClickListener {
        public final /* synthetic */ in0 b;

        public m(in0 in0Var) {
            this.b = in0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            rn0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.TITTLE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.TITTLE.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            in0 in0Var = this.b;
            if (in0Var != null && (b = in0Var.b()) != null) {
                str = b.e();
            } else {
                str = null;
            }
            nadRewardBigCardView.m(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NadRewardBigCardView.this.t = true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class o implements q41 {
        public final /* synthetic */ boolean b;

        public o(boolean z) {
            this.b = z;
        }

        @Override // com.baidu.tieba.q41
        public void a() {
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str = ClogBuilder.Area.DOWN_ARROW.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.DOWN_ARROW.type");
            NadRewardBigCardView.q(nadRewardBigCardView, str, ClogBuilder.LogType.FREE_CLICK, null, null, 12, null);
        }

        @Override // com.baidu.tieba.q41
        public void d() {
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str = ClogBuilder.Area.AD_BLANK.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.AD_BLANK.type");
            NadRewardBigCardView.q(nadRewardBigCardView, str, ClogBuilder.LogType.FREE_CLICK, null, null, 12, null);
        }

        @Override // com.baidu.tieba.q41
        public void b() {
            if (!this.b) {
                return;
            }
            if (TextUtils.equals(NadRewardBigCardView.this.s, "1") || TextUtils.equals(NadRewardBigCardView.this.s, "2")) {
                if (NadRewardBigCardView.this.t) {
                    NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
                    String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                    Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                    nadRewardBigCardView.p(str, ClogBuilder.LogType.CLICK, NadRewardBigCardView.this.getLogTime(), "1");
                    return;
                }
                NadRewardBigCardView nadRewardBigCardView2 = NadRewardBigCardView.this;
                String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                nadRewardBigCardView2.p(str2, ClogBuilder.LogType.FREE_CLICK, NadRewardBigCardView.this.getLogTime(), "1");
            }
        }

        @Override // com.baidu.tieba.q41
        public void c() {
            if (!this.b) {
                return;
            }
            if (TextUtils.equals(NadRewardBigCardView.this.s, "2") && NadRewardBigCardView.this.t) {
                NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                nadRewardBigCardView.p(str, ClogBuilder.LogType.CLICK, NadRewardBigCardView.this.getLogTime(), "2");
            }
            if (TextUtils.equals(NadRewardBigCardView.this.s, "1")) {
                NadRewardBigCardView nadRewardBigCardView2 = NadRewardBigCardView.this;
                String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                nadRewardBigCardView2.p(str2, ClogBuilder.LogType.FREE_CLICK, NadRewardBigCardView.this.getLogTime(), "2");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadRewardBigCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$adInfoContainer$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.obfuscated_res_0x7f0900b9);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_container)");
                return (LinearLayout) findViewById;
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$avatar$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdImageView invoke() {
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.obfuscated_res_0x7f090342);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.avatar)");
                return (AdImageView) findViewById;
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$brandName$2
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
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$title$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.obfuscated_res_0x7f092685);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
                return (UnifyTextView) findViewById;
            }
        });
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$tagContainer$2
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
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$detailBtn$2
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
        this.g = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$detailBtnText$2
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
        this.h = LazyKt__LazyJVMKt.lazy(new Function0<NadMiniVideoDownloadView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$downloadButton$2
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
        this.i = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$arrow$2
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
        this.j = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$appInfoView$2
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
        this.k = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$version$2
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
        this.l = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$developerName$2
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
        this.m = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$privacyView$2
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
        this.n = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$permissionView$2
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
        this.o = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$featureView$2
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
        this.s = "0";
        this.u = new n();
        this.x = LazyKt__LazyJVMKt.lazy(new Function0<ValueAnimator>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardBigCardView$bigCardPopupAnimator$2
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
                        NadRewardBigCardView.this.r(f.floatValue());
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
        xk0 a2 = bl0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        from.inflate(a2.v(), this);
    }

    public /* synthetic */ NadRewardBigCardView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void setAvatar(in0 in0Var) {
        String str;
        rn0 b2;
        AdImageView avatar = getAvatar();
        avatar.setBorder(1.0f, avatar.getResources().getColor(R.color.nad_reward_big_card_avatar_stroke));
        if (in0Var != null && (b2 = in0Var.b()) != null) {
            str = b2.a();
        } else {
            str = null;
        }
        avatar.u(str);
        avatar.setOnClickListener(new i(in0Var));
    }

    private final void setButton(in0 in0Var) {
        setDetailButton(in0Var);
        setDownloadButton(in0Var);
    }

    public final void r(float f2) {
        Function1<? super Float, Unit> function1;
        if (Math.abs(f2) >= 0.001d && (function1 = this.w) != null) {
            function1.invoke(Float.valueOf(f2));
        }
    }

    public final void setBigCardShowProgress(Function1<? super Float, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.w = callback;
    }

    public final void setData(in0 in0Var) {
        this.q = in0Var;
        setLayoutParams(in0Var);
        setAvatar(in0Var);
        setBrandName(in0Var);
        setTitle(in0Var);
        setButton(in0Var);
        setAppInfo(in0Var);
        s();
        n();
        o();
        this.t = false;
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
        j41 j41Var = this.p;
        if (j41Var != null) {
            j41Var.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getLogTime() {
        return String.valueOf((System.currentTimeMillis() - this.v) / 1000);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void o() {
        setClickable(true);
        setOnTouchListener(new b());
    }

    public final void s() {
        ti0.a().c(this, new c(hd0.class));
    }

    public final void t() {
        getBigCardPopupAnimator().cancel();
        ti0.a().a(this);
        ae0 ae0Var = this.r;
        if (ae0Var != null) {
            ae0Var.j();
        }
        getHandler().removeCallbacks(this.u);
    }

    public static /* synthetic */ void q(NadRewardBigCardView nadRewardBigCardView, String str, ClogBuilder.LogType logType, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        if ((i2 & 8) != 0) {
            str3 = "";
        }
        nadRewardBigCardView.p(str, logType, str2, str3);
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
    private final void setAppInfo(in0 in0Var) {
        pn0 pn0Var;
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
        pn0 pn0Var2;
        pn0.a aVar;
        String str6;
        boolean z8;
        pn0 pn0Var3;
        pn0.a aVar2;
        pn0 pn0Var4;
        pn0.a aVar3;
        String str7;
        pn0 pn0Var5;
        pn0.b bVar;
        String str8;
        boolean z9;
        pn0 pn0Var6;
        pn0.b bVar2;
        pn0 pn0Var7;
        pn0.b bVar3;
        String str9;
        pn0 pn0Var8;
        pn0.c cVar;
        String str10;
        boolean z10;
        pn0 pn0Var9;
        pn0.c cVar2;
        pn0 pn0Var10;
        pn0.c cVar3;
        String str11;
        pn0 pn0Var11;
        pn0 pn0Var12;
        String str12;
        pn0 pn0Var13;
        pn0 pn0Var14;
        LinearLayout appInfoView = getAppInfoView();
        String str13 = null;
        if (in0Var != null) {
            pn0Var = in0Var.i;
        } else {
            pn0Var = null;
        }
        if (ce0.a(pn0Var)) {
            appInfoView.setVisibility(0);
        } else {
            appInfoView.setVisibility(8);
        }
        UnifyTextView version = getVersion();
        if (in0Var != null && (pn0Var14 = in0Var.i) != null) {
            str = pn0Var14.f;
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
            if (in0Var != null && (pn0Var13 = in0Var.i) != null) {
                str12 = pn0Var13.f;
            } else {
                str12 = null;
            }
            version.setTextWithUnifiedPadding(str12, TextView.BufferType.NORMAL);
            version.setOnClickListener(new d(version, in0Var));
        }
        UnifyTextView developerName = getDeveloperName();
        if (in0Var != null && (pn0Var12 = in0Var.i) != null) {
            str2 = pn0Var12.d;
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
            if (in0Var != null && (pn0Var11 = in0Var.i) != null) {
                str11 = pn0Var11.d;
            } else {
                str11 = null;
            }
            developerName.setTextWithUnifiedPadding(str11, TextView.BufferType.NORMAL);
            developerName.setOnClickListener(new e(developerName, in0Var));
        }
        UnifyTextView privacyView = getPrivacyView();
        if (in0Var != null && (pn0Var10 = in0Var.i) != null && (cVar3 = pn0Var10.g) != null) {
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
            if (in0Var != null && (pn0Var9 = in0Var.i) != null && (cVar2 = pn0Var9.g) != null) {
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
                    if (in0Var != null && (pn0Var8 = in0Var.i) != null && (cVar = pn0Var8.g) != null) {
                        str9 = cVar.a;
                    } else {
                        str9 = null;
                    }
                    privacyView.setTextWithUnifiedPadding(str9, TextView.BufferType.NORMAL);
                    privacyView.setOnClickListener(new f(privacyView, this, in0Var));
                }
                UnifyTextView permissionView = getPermissionView();
                if (in0Var == null && (pn0Var7 = in0Var.i) != null && (bVar3 = pn0Var7.h) != null) {
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
                    if (in0Var != null && (pn0Var6 = in0Var.i) != null && (bVar2 = pn0Var6.h) != null) {
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
                            if (in0Var != null && (pn0Var5 = in0Var.i) != null && (bVar = pn0Var5.h) != null) {
                                str7 = bVar.a;
                            } else {
                                str7 = null;
                            }
                            permissionView.setTextWithUnifiedPadding(str7, TextView.BufferType.NORMAL);
                            permissionView.setOnClickListener(new g(permissionView, this, in0Var));
                        }
                        UnifyTextView featureView = getFeatureView();
                        if (in0Var == null && (pn0Var4 = in0Var.i) != null && (aVar3 = pn0Var4.i) != null) {
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
                            if (in0Var != null && (pn0Var3 = in0Var.i) != null && (aVar2 = pn0Var3.i) != null) {
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
                            if (in0Var != null && (pn0Var2 = in0Var.i) != null && (aVar = pn0Var2.i) != null) {
                                str13 = aVar.a;
                            }
                            featureView.setTextWithUnifiedPadding(str13, TextView.BufferType.NORMAL);
                            featureView.setOnClickListener(new h(featureView, this, in0Var));
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
                if (in0Var == null) {
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
        if (in0Var == null) {
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
        if (in0Var == null) {
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

    private final void setBrandName(in0 in0Var) {
        String str;
        boolean z;
        rn0 b2;
        rn0 b3;
        UnifyTextView brandName = getBrandName();
        String str2 = null;
        if (in0Var != null && (b3 = in0Var.b()) != null) {
            str = b3.c();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            if (in0Var != null && (b2 = in0Var.b()) != null) {
                str2 = b2.c();
            }
            brandName.setText(str2);
        }
        brandName.setOnClickListener(new j(in0Var));
    }

    private final void setTitle(in0 in0Var) {
        String str;
        boolean z;
        rn0 b2;
        rn0 b3;
        UnifyTextView title = getTitle();
        String str2 = null;
        if (in0Var != null && (b3 = in0Var.b()) != null) {
            str = b3.h();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            if (in0Var != null && (b2 = in0Var.b()) != null) {
                str2 = b2.h();
            }
            title.setText(str2);
        }
        title.setOnClickListener(new m(in0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDetailButton(in0 in0Var) {
        String str;
        boolean z;
        String str2;
        String str3;
        rn0 b2;
        rn0 b3;
        xm0 xm0Var;
        xm0 xm0Var2;
        rn0 b4;
        View detailBtn = getDetailBtn();
        Resources resources = detailBtn.getResources();
        xk0 a2 = bl0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension = resources.getDimension(a2.m());
        GradientDrawable gradientDrawable = new GradientDrawable();
        String str4 = null;
        if (in0Var != null && (b4 = in0Var.b()) != null) {
            str = b4.d();
        } else {
            str = null;
        }
        gradientDrawable.setColor(s11.a(str, R.color.nad_reward_big_card_btn_color));
        gradientDrawable.setCornerRadius(dimension);
        Unit unit = Unit.INSTANCE;
        detailBtn.setBackground(gradientDrawable);
        boolean z2 = true;
        if (in0Var != null) {
            z = in0Var.p();
        } else {
            z = true;
        }
        if (z) {
            detailBtn.setVisibility(0);
        } else {
            detailBtn.setVisibility(8);
        }
        detailBtn.setOnClickListener(new k(in0Var));
        TextView detailBtnText = getDetailBtnText();
        if (in0Var != null && (xm0Var2 = in0Var.m) != null && xm0Var2.g) {
            String str5 = ClogBuilder.Area.OPEN_BUTTON.type;
            Intrinsics.checkNotNullExpressionValue(str5, "ClogBuilder.Area.OPEN_BUTTON.type");
            q(this, str5, ClogBuilder.LogType.FREE_SHOW, null, null, 12, null);
        }
        if (in0Var != null && (xm0Var = in0Var.m) != null && xm0Var.g) {
            str3 = detailBtnText.getContext().getString(R.string.nad_reward_detail_btn_open_app);
        } else {
            if (in0Var != null && (b3 = in0Var.b()) != null) {
                str2 = b3.f();
            } else {
                str2 = null;
            }
            if (str2 != null && !StringsKt__StringsJVMKt.isBlank(str2)) {
                z2 = false;
            }
            if (!z2) {
                if (in0Var != null && (b2 = in0Var.b()) != null) {
                    str4 = b2.f();
                }
            } else {
                str4 = detailBtnText.getContext().getString(R.string.nad_reward_detail_btn_text);
            }
            str3 = str4;
        }
        detailBtnText.setText(str3);
    }

    private final void setDownloadButton(in0 in0Var) {
        String str;
        boolean z;
        boolean z2;
        Object obj;
        tm0 tm0Var;
        String str2;
        xm0 xm0Var;
        cn0 cn0Var;
        xm0 xm0Var2;
        xm0 xm0Var3;
        tm0 tm0Var2;
        sn0 c2;
        rn0 b2;
        ae0 ae0Var = this.r;
        if (ae0Var != null) {
            ae0Var.j();
        }
        String str3 = null;
        this.r = null;
        NadMiniVideoDownloadView downloadButton = getDownloadButton();
        Resources resources = downloadButton.getResources();
        xk0 a2 = bl0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension = resources.getDimension(a2.m());
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (in0Var != null && (b2 = in0Var.b()) != null) {
            str = b2.d();
        } else {
            str = null;
        }
        gradientDrawable.setColor(s11.a(str, R.color.nad_reward_big_card_btn_color));
        gradientDrawable.setCornerRadius(dimension);
        Unit unit = Unit.INSTANCE;
        downloadButton.setBackground(gradientDrawable);
        downloadButton.setBorderRadius(dimension);
        downloadButton.setProgressColor(ContextCompat.getColor(downloadButton.getContext(), R.color.nad_reward_big_card_btn_download_progress));
        if (in0Var != null && (c2 = in0Var.c()) != null) {
            z = c2.f();
        } else {
            z = false;
        }
        downloadButton.setIconArrowSwitch(z);
        if (in0Var != null) {
            z2 = in0Var.q();
        } else {
            z2 = false;
        }
        boolean z3 = true;
        if ((!z2 || in0Var == null || (xm0Var3 = in0Var.m) == null || (tm0Var2 = xm0Var3.p) == null || !tm0Var2.e) ? false : false) {
            downloadButton.setVisibility(0);
            obj = downloadButton;
        } else {
            downloadButton.setVisibility(8);
            obj = null;
        }
        if (obj != null) {
            if (in0Var != null && (xm0Var2 = in0Var.m) != null) {
                tm0Var = xm0Var2.p;
            } else {
                tm0Var = null;
            }
            if (in0Var != null && (cn0Var = in0Var.f) != null) {
                str2 = cn0Var.d;
            } else {
                str2 = null;
            }
            if (in0Var != null && (xm0Var = in0Var.m) != null) {
                str3 = xm0Var.t;
            }
            wg0 d2 = wg0.d(tm0Var, str2, str3);
            Intrinsics.checkNotNullExpressionValue(d2, "AdDownloadBean.from(adMo….enhanceModel?.btnScheme)");
            d2.q.a = ClogBuilder.Page.WELFAREBIGCARD.type;
            ae0 ae0Var2 = new ae0(d2, getDownloadButton());
            this.r = ae0Var2;
            Intrinsics.checkNotNull(ae0Var2);
            ae0Var2.z();
        }
        downloadButton.setOnClickListener(new l(in0Var));
    }

    public final void u(boolean z) {
        String str;
        boolean z2;
        xk0 a2;
        String str2;
        String str3;
        String str4;
        cn0 cn0Var;
        cn0 cn0Var2;
        cn0 cn0Var3;
        sn0 c2;
        long j2;
        sn0 c3;
        in0 in0Var = this.q;
        String str5 = null;
        if (in0Var != null) {
            str = in0Var.f();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            this.p = null;
            return;
        }
        if (z) {
            String str6 = ClogBuilder.Area.SWIPE_UP.type;
            Intrinsics.checkNotNullExpressionValue(str6, "ClogBuilder.Area.SWIPE_UP.type");
            q(this, str6, ClogBuilder.LogType.FREE_CLICK, null, null, 12, null);
            Handler handler = getHandler();
            if (handler != null) {
                Runnable runnable = this.u;
                in0 in0Var2 = this.q;
                if (in0Var2 != null && (c3 = in0Var2.c()) != null) {
                    j2 = c3.d();
                } else {
                    j2 = 0;
                }
                handler.postDelayed(runnable, j2);
            }
        }
        j41 j41Var = new j41(getContext());
        in0 in0Var3 = this.q;
        this.s = (in0Var3 == null || (c2 = in0Var3.c()) == null || (r1 = c2.c()) == null) ? "0" : "0";
        j41Var.j(new o(z));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(bl0.a(), "NadRewardVideoLpRuntime.getUIProvider()");
        double dimension = 1 - (resources.getDimension(a2.w()) / w11.c.c(getContext()));
        in0 in0Var4 = this.q;
        if (in0Var4 != null) {
            str2 = in0Var4.f();
        } else {
            str2 = null;
        }
        in0 in0Var5 = this.q;
        if (in0Var5 != null && (cn0Var3 = in0Var5.f) != null) {
            str3 = cn0Var3.d;
        } else {
            str3 = null;
        }
        r41 r41Var = new r41(str2, dimension, 0, str3);
        r41Var.O(true);
        r41Var.N(false);
        r41Var.R(true);
        r41Var.Q(!z);
        r41Var.F(z);
        r41Var.G(z);
        r41Var.H(true);
        in0 in0Var6 = this.q;
        if (in0Var6 != null && (cn0Var2 = in0Var6.f) != null) {
            str4 = cn0Var2.l;
        } else {
            str4 = null;
        }
        if (!TextUtils.isEmpty(str4)) {
            in0 in0Var7 = this.q;
            if (in0Var7 != null && (cn0Var = in0Var7.f) != null) {
                str5 = cn0Var.k;
            }
            r41Var.E(str5);
        }
        Unit unit = Unit.INSTANCE;
        j41Var.i(r41Var);
        j41Var.k();
        this.v = System.currentTimeMillis();
        Unit unit2 = Unit.INSTANCE;
        this.p = j41Var;
    }

    private final void setLayoutParams(in0 in0Var) {
        float f2;
        float f3;
        rn0 b2;
        String i2;
        Float floatOrNull;
        rn0 b3;
        String b4;
        Float floatOrNull2;
        if (in0Var != null && (b3 = in0Var.b()) != null && (b4 = b3.b()) != null && (floatOrNull2 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(b4)) != null) {
            f2 = floatOrNull2.floatValue();
        } else {
            f2 = 0.0f;
        }
        if (in0Var != null && (b2 = in0Var.b()) != null && (i2 = b2.i()) != null && (floatOrNull = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(i2)) != null) {
            f3 = floatOrNull.floatValue();
        } else {
            f3 = 0.0f;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        Context context = getContext();
        if (f2 <= 0.0f) {
            f2 = 117.0f;
        }
        layoutParams.bottomMargin = w11.c.a(context, f2);
        Context context2 = getContext();
        if (f3 <= 0.0f) {
            f3 = 26.0f;
        }
        layoutParams.topMargin = w11.c.a(context2, f3);
        getAdInfoContainer().setLayoutParams(layoutParams);
    }

    public final void m(String str, ClogBuilder.LogType logType, String str2) {
        xm0 xm0Var;
        String str3;
        rn0 b2;
        q(this, str, logType, null, null, 12, null);
        if (jl0.a.f()) {
            qe0.c(str2, getContext());
            return;
        }
        in0 in0Var = this.q;
        boolean z = false;
        if (in0Var != null && (xm0Var = in0Var.m) != null && !xm0Var.g) {
            jl0 jl0Var = jl0.a;
            if (in0Var != null && (b2 = in0Var.b()) != null) {
                str3 = b2.e();
            } else {
                str3 = null;
            }
            if (jl0Var.b(str3)) {
                u(false);
                return;
            }
        }
        if (!((str2 == null || str2.length() == 0) ? true : true)) {
            qe0.c(str2, getContext());
        }
    }

    public final void n() {
        int a2;
        AdImageView arrow = getArrow();
        arrow.setImageResource(R.drawable.nad_reward_big_card_arrow);
        ViewGroup.LayoutParams layoutParams = arrow.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            in0 in0Var = this.q;
            if (in0Var != null && in0Var.p()) {
                a2 = w11.c.a(arrow.getContext(), 10.0f);
            } else {
                a2 = w11.c.a(arrow.getContext(), 25.0f);
            }
            layoutParams2.bottomMargin = a2;
            arrow.setLayoutParams(layoutParams2);
            arrow.setOnClickListener(new a());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public final void p(String str, ClogBuilder.LogType logType, String str2, String str3) {
        String str4;
        boolean z;
        cn0 cn0Var;
        ClogBuilder u = new ClogBuilder().j(str).y(logType).u(ClogBuilder.Page.WELFAREBIGCARD);
        in0 in0Var = this.q;
        List<MonitorUrl> list = null;
        if (in0Var != null && (cn0Var = in0Var.f) != null) {
            str4 = cn0Var.d;
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
        dz0.e(p);
        if (logType == ClogBuilder.LogType.CLICK) {
            in0 in0Var2 = this.q;
            if (in0Var2 != null) {
                list = in0Var2.e;
            }
            ce0.b(list);
        }
    }
}
