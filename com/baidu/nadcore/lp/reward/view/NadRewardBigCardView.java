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
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.txt.UnifyTextView;
import com.baidu.searchbox.common.security.PermissionStorage;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.R;
import com.baidu.tieba.a71;
import com.baidu.tieba.ak0;
import com.baidu.tieba.bs0;
import com.baidu.tieba.do0;
import com.baidu.tieba.e71;
import com.baidu.tieba.fk0;
import com.baidu.tieba.fq0;
import com.baidu.tieba.fs0;
import com.baidu.tieba.gm0;
import com.baidu.tieba.ho0;
import com.baidu.tieba.jq0;
import com.baidu.tieba.js0;
import com.baidu.tieba.kj0;
import com.baidu.tieba.mj0;
import com.baidu.tieba.n41;
import com.baidu.tieba.ok0;
import com.baidu.tieba.q91;
import com.baidu.tieba.qs0;
import com.baidu.tieba.ri0;
import com.baidu.tieba.rs0;
import com.baidu.tieba.ss0;
import com.baidu.tieba.x91;
import com.baidu.tieba.xr0;
import com.baidu.tieba.y91;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\u0010\u0088\u0001\u001a\u00030\u0087\u0001\u0012\f\b\u0002\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u0001\u0012\n\b\u0002\u0010\u008c\u0001\u001a\u00030\u008b\u0001¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0003¢\u0006\u0004\b\u0011\u0010\u0010J3\u0010\u0014\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0010J\r\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u0010J\u0019\u0010\u001e\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b \u0010\u001fJ\u001b\u0010#\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0!¢\u0006\u0004\b#\u0010$J!\u0010&\u001a\u00020\f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0%¢\u0006\u0004\b&\u0010'J\u0019\u0010(\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b(\u0010\u001fJ\u0019\u0010)\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b)\u0010\u001fJ\u001b\u0010*\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0!¢\u0006\u0004\b*\u0010$J\u0017\u0010+\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b+\u0010\u001fJ\u0019\u0010,\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b,\u0010\u001fJ\u0019\u0010-\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b-\u0010\u001fJ\u001b\u0010.\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0!¢\u0006\u0004\b.\u0010$J!\u0010/\u001a\u00020\f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0%¢\u0006\u0004\b/\u0010'J\u0019\u00100\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b0\u0010\u001fJ\u0015\u00102\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0004¢\u0006\u0004\b2\u00103J\u0015\u00105\u001a\u00020\f2\u0006\u00104\u001a\u00020\u0004¢\u0006\u0004\b5\u00103R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u00106R\u001d\u0010<\u001a\u0002078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001d\u0010A\u001a\u00020=8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u00109\u001a\u0004\b?\u0010@R\u001d\u0010D\u001a\u00020=8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u00109\u001a\u0004\bC\u0010@R\u001e\u0010E\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001d\u0010K\u001a\u00020G8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u00109\u001a\u0004\bI\u0010JR$\u0010L\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u001d\u0010R\u001a\u00020N8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u00109\u001a\u0004\bP\u0010QR\u0016\u0010S\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u001e\u0010U\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010FR\u001d\u0010Z\u001a\u00020V8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u00109\u001a\u0004\bX\u0010YR\u001d\u0010_\u001a\u00020[8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u00109\u001a\u0004\b]\u0010^R\u001d\u0010b\u001a\u00020N8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u00109\u001a\u0004\ba\u0010QR\u001d\u0010g\u001a\u00020c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u00109\u001a\u0004\be\u0010fR\u0018\u0010i\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010l\u001a\u00020k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010o\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u001e\u0010q\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010FR\u001d\u0010t\u001a\u00020N8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u00109\u001a\u0004\bs\u0010QR\u001d\u0010w\u001a\u00020N8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bu\u00109\u001a\u0004\bv\u0010QR\u0016\u0010x\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010{\u001a\u00020z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R$\u0010}\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010MR\u001e\u0010\u0080\u0001\u001a\u0002078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b~\u00109\u001a\u0004\b\u007f\u0010;R \u0010\u0083\u0001\u001a\u00020N8B@\u0002X\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0081\u0001\u00109\u001a\u0005\b\u0082\u0001\u0010QR \u0010\u0086\u0001\u001a\u00020N8B@\u0002X\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0084\u0001\u00109\u001a\u0005\b\u0085\u0001\u0010Q¨\u0006\u008f\u0001"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardBigCardView;", "Landroid/widget/FrameLayout;", "", "scheme", "", "checkRewardPanelPop", "(Ljava/lang/String;)Z", "getLogTime", "()Ljava/lang/String;", DnsModel.AREA_KEY, "Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;", "logType", "", "handleClick", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;)V", "initArrow", "()V", "initSwipeUp", PermissionStorage.PermissionItem.ITEM_EXT_1, PermissionStorage.PermissionItem.ITEM_EXT_2, "logAndCharge", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;Ljava/lang/String;)V", "", "showProgress", "onProgressChanged", "(F)V", "registerRewardTaskEvent", "release", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setAppInfo", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "setAvatar", "Lkotlin/Function0;", WebChromeClient.KEY_ARG_CALLBACK, "setBackBtnCallback", "(Lkotlin/Function0;)V", "Lkotlin/Function1;", "setBigCardShowProgress", "(Lkotlin/Function1;)V", "setBrandName", "setButton", "setCloseClickCallback", "setData", "setDetailButton", "setDownloadButton", "setPanelPopDismissCallback", "setShowPanelPopCallback", "setTitle", "isVisible", "setVisibility", "(Z)V", "autoPopup", "showPanelPop", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Landroid/widget/LinearLayout;", "appInfoView$delegate", "Lkotlin/Lazy;", "getAppInfoView", "()Landroid/widget/LinearLayout;", "appInfoView", "Lcom/baidu/nadcore/widget/AdImageView;", "arrow$delegate", "getArrow", "()Lcom/baidu/nadcore/widget/AdImageView;", "arrow", "avatar$delegate", "getAvatar", "avatar", "backBtnCallback", "Lkotlin/Function0;", "Landroid/animation/ValueAnimator;", "bigCardPopupAnimator$delegate", "getBigCardPopupAnimator", "()Landroid/animation/ValueAnimator;", "bigCardPopupAnimator", "bigCardShowProgress", "Lkotlin/Function1;", "Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "brandName$delegate", "getBrandName", "()Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "brandName", "chargeMode", "Ljava/lang/String;", "closeIconCallback", "Landroid/view/View;", "detailBtn$delegate", "getDetailBtn", "()Landroid/view/View;", "detailBtn", "Landroid/widget/TextView;", "detailBtnText$delegate", "getDetailBtnText", "()Landroid/widget/TextView;", "detailBtnText", "developerName$delegate", "getDeveloperName", "developerName", "Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton$delegate", "getDownloadButton", "()Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "downloadPresenter", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "", "loadStartTime", "J", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "panelPop", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "panelPopDismissCallback", "permissionView$delegate", "getPermissionView", "permissionView", "privacyView$delegate", "getPrivacyView", "privacyView", "shouldCharge", "Z", "Ljava/lang/Runnable;", "shouldChargeTask", "Ljava/lang/Runnable;", "showPanelPopCallback", "tagContainer$delegate", "getTagContainer", "tagContainer", "title$delegate", "getTitle", "title", "version$delegate", WebChromeClient.MSG_METHOD_GETVERSION, "version", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
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
    public q91 n;
    public js0 o;
    public kj0 p;
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

    private final AdImageView getArrow() {
        return (AdImageView) this.h.getValue();
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
            rs0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.ARROW.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.ARROW.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            js0 js0Var = NadRewardBigCardView.this.o;
            if (js0Var != null && (b = js0Var.b()) != null) {
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
            bs0 bs0Var;
            String str;
            rs0 b;
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
                        js0 js0Var = NadRewardBigCardView.this.o;
                        if (js0Var == null || (bs0Var = js0Var.m) == null || !bs0Var.g) {
                            NadRewardBigCardView.this.y(false);
                        } else {
                            js0 js0Var2 = NadRewardBigCardView.this.o;
                            if (js0Var2 != null && (b = js0Var2.b()) != null) {
                                str = b.d();
                            } else {
                                str = null;
                            }
                            ak0.c(str, NadRewardBigCardView.this.getContext());
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
    public static final class c extends ho0<ri0> {
        public c(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ho0
        public void onEvent(ri0 event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!(!Intrinsics.areEqual(event.a, "4"))) {
                js0 js0Var = NadRewardBigCardView.this.o;
                if (js0Var == null || js0Var.m()) {
                    if (event.h) {
                        js0 js0Var2 = NadRewardBigCardView.this.o;
                        if (js0Var2 == null) {
                            return;
                        }
                        NadRewardBigCardView.this.setDetailButton(js0Var2);
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
                            gradientDrawable.setColors(new int[]{a71.a(event.d, R.color.nad_reward_big_card_btn_color), a71.a(event.e, R.color.nad_reward_big_card_btn_color)});
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
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ js0 b;

        public d(UnifyTextView unifyTextView, js0 js0Var) {
            this.a = unifyTextView;
            this.b = js0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            qs0 qs0Var;
            Context context = this.a.getContext();
            js0 js0Var = this.b;
            if (js0Var != null && (qs0Var = js0Var.i) != null) {
                str = qs0Var.f;
            } else {
                str = null;
            }
            Toast.makeText(context, str, 0).show();
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements View.OnClickListener {
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ js0 b;

        public e(UnifyTextView unifyTextView, js0 js0Var) {
            this.a = unifyTextView;
            this.b = js0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            qs0 qs0Var;
            Context context = this.a.getContext();
            js0 js0Var = this.b;
            if (js0Var != null && (qs0Var = js0Var.i) != null) {
                str = qs0Var.d;
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
        public final /* synthetic */ js0 c;

        public f(UnifyTextView unifyTextView, NadRewardBigCardView nadRewardBigCardView, js0 js0Var) {
            this.a = unifyTextView;
            this.b = nadRewardBigCardView;
            this.c = js0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            qs0 qs0Var;
            qs0.b bVar;
            NadRewardBigCardView nadRewardBigCardView = this.b;
            String str2 = ClogBuilder.Area.APP_PRIVACY.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PRIVACY.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            js0 js0Var = this.c;
            if (js0Var != null && (qs0Var = js0Var.i) != null && (bVar = qs0Var.g) != null) {
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
        public final /* synthetic */ js0 c;

        public g(UnifyTextView unifyTextView, NadRewardBigCardView nadRewardBigCardView, js0 js0Var) {
            this.a = unifyTextView;
            this.b = nadRewardBigCardView;
            this.c = js0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            qs0 qs0Var;
            qs0.a aVar;
            NadRewardBigCardView nadRewardBigCardView = this.b;
            String str2 = ClogBuilder.Area.APP_PERMISSION.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PERMISSION.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            js0 js0Var = this.c;
            if (js0Var != null && (qs0Var = js0Var.i) != null && (aVar = qs0Var.h) != null) {
                str = aVar.b;
            } else {
                str = null;
            }
            nadRewardBigCardView.q(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements View.OnClickListener {
        public final /* synthetic */ js0 b;

        public h(js0 js0Var) {
            this.b = js0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            rs0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.AVATAR.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.AVATAR.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            js0 js0Var = this.b;
            if (js0Var != null && (b = js0Var.b()) != null) {
                str = b.d();
            } else {
                str = null;
            }
            nadRewardBigCardView.q(str2, logType, str);
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
            rs0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.NAME.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.NAME.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            js0 js0Var = this.b;
            if (js0Var != null && (b = js0Var.b()) != null) {
                str = b.d();
            } else {
                str = null;
            }
            nadRewardBigCardView.q(str2, logType, str);
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
            rs0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.AD_BTN_DETAIL.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.AD_BTN_DETAIL.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            js0 js0Var = this.b;
            if (js0Var != null && (b = js0Var.b()) != null) {
                str = b.d();
            } else {
                str = null;
            }
            nadRewardBigCardView.q(str2, logType, str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class k implements View.OnClickListener {
        public k(js0 js0Var) {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            kj0 kj0Var = NadRewardBigCardView.this.p;
            if (kj0Var != null) {
                kj0Var.l();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class l implements View.OnClickListener {
        public final /* synthetic */ js0 b;

        public l(js0 js0Var) {
            this.b = js0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            rs0 b;
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str2 = ClogBuilder.Area.TITTLE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.TITTLE.type");
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            js0 js0Var = this.b;
            if (js0Var != null && (b = js0Var.b()) != null) {
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
    public static final class n implements x91 {
        public final /* synthetic */ boolean b;

        public n(boolean z) {
            this.b = z;
        }

        @Override // com.baidu.tieba.x91
        public void a() {
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str = ClogBuilder.Area.DOWN_ARROW.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.DOWN_ARROW.type");
            NadRewardBigCardView.u(nadRewardBigCardView, str, ClogBuilder.LogType.FREE_CLICK, null, null, 12, null);
        }

        @Override // com.baidu.tieba.x91
        public void b() {
            Function0 function0 = NadRewardBigCardView.this.x;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }

        @Override // com.baidu.tieba.x91
        public void d() {
            Function0 function0 = NadRewardBigCardView.this.w;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }

        @Override // com.baidu.tieba.x91
        public void dismiss() {
            Function0 function0 = NadRewardBigCardView.this.v;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }

        @Override // com.baidu.tieba.x91
        public void f() {
            NadRewardBigCardView nadRewardBigCardView = NadRewardBigCardView.this;
            String str = ClogBuilder.Area.AD_BLANK.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.AD_BLANK.type");
            NadRewardBigCardView.u(nadRewardBigCardView, str, ClogBuilder.LogType.FREE_CLICK, null, null, 12, null);
        }

        @Override // com.baidu.tieba.x91
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

        @Override // com.baidu.tieba.x91
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
                View findViewById = NadRewardBigCardView.this.findViewById(R.id.obfuscated_res_0x7f092542);
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
        LayoutInflater from = LayoutInflater.from(context);
        fq0 a2 = jq0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        from.inflate(a2.p(), this);
    }

    public /* synthetic */ NadRewardBigCardView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void setAvatar(js0 js0Var) {
        String str;
        rs0 b2;
        AdImageView avatar = getAvatar();
        avatar.setBorder(1.0f, avatar.getResources().getColor(R.color.nad_reward_big_card_avatar_stroke));
        if (js0Var != null && (b2 = js0Var.b()) != null) {
            str = b2.a();
        } else {
            str = null;
        }
        avatar.o(str);
        avatar.setOnClickListener(new h(js0Var));
    }

    private final void setButton(js0 js0Var) {
        setDetailButton(js0Var);
        setDownloadButton(js0Var);
    }

    public final boolean p(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z || !ok0.o(str)) {
            return false;
        }
        return Intrinsics.areEqual(new fk0(str).a(), "rewardWebPanel");
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

    public final void setData(js0 js0Var) {
        this.o = js0Var;
        setAvatar(js0Var);
        setBrandName(js0Var);
        setTitle(js0Var);
        setButton(js0Var);
        setAppInfo(js0Var);
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
        q91 q91Var = this.n;
        if (q91Var != null) {
            q91Var.e();
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
        do0.a().b(this, new c(ri0.class));
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
    private final void setAppInfo(js0 js0Var) {
        qs0 qs0Var;
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
        qs0 qs0Var2;
        qs0.a aVar;
        String str5;
        boolean z6;
        qs0 qs0Var3;
        qs0.a aVar2;
        qs0 qs0Var4;
        qs0.a aVar3;
        String str6;
        qs0 qs0Var5;
        qs0.b bVar;
        String str7;
        boolean z7;
        qs0 qs0Var6;
        qs0.b bVar2;
        qs0 qs0Var7;
        qs0.b bVar3;
        String str8;
        qs0 qs0Var8;
        qs0 qs0Var9;
        String str9;
        qs0 qs0Var10;
        qs0 qs0Var11;
        LinearLayout appInfoView = getAppInfoView();
        String str10 = null;
        if (js0Var != null) {
            qs0Var = js0Var.i;
        } else {
            qs0Var = null;
        }
        if (mj0.a(qs0Var)) {
            appInfoView.setVisibility(0);
        } else {
            appInfoView.setVisibility(8);
        }
        UnifyTextView version = getVersion();
        if (js0Var != null && (qs0Var11 = js0Var.i) != null) {
            str = qs0Var11.f;
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
            if (js0Var != null && (qs0Var10 = js0Var.i) != null) {
                str9 = qs0Var10.f;
            } else {
                str9 = null;
            }
            version.setTextWithUnifiedPadding(str9, TextView.BufferType.NORMAL);
            version.setOnClickListener(new d(version, js0Var));
        }
        UnifyTextView developerName = getDeveloperName();
        if (js0Var != null && (qs0Var9 = js0Var.i) != null) {
            str2 = qs0Var9.d;
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
            if (js0Var != null && (qs0Var8 = js0Var.i) != null) {
                str8 = qs0Var8.d;
            } else {
                str8 = null;
            }
            developerName.setTextWithUnifiedPadding(str8, TextView.BufferType.NORMAL);
            developerName.setOnClickListener(new e(developerName, js0Var));
        }
        UnifyTextView privacyView = getPrivacyView();
        if (js0Var != null && (qs0Var7 = js0Var.i) != null && (bVar3 = qs0Var7.g) != null) {
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
            if (js0Var != null && (qs0Var6 = js0Var.i) != null && (bVar2 = qs0Var6.g) != null) {
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
                    if (js0Var != null && (qs0Var5 = js0Var.i) != null && (bVar = qs0Var5.g) != null) {
                        str6 = bVar.a;
                    } else {
                        str6 = null;
                    }
                    privacyView.setTextWithUnifiedPadding(str6, TextView.BufferType.NORMAL);
                    privacyView.setOnClickListener(new f(privacyView, this, js0Var));
                }
                UnifyTextView permissionView = getPermissionView();
                if (js0Var == null && (qs0Var4 = js0Var.i) != null && (aVar3 = qs0Var4.h) != null) {
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
                    if (js0Var != null && (qs0Var3 = js0Var.i) != null && (aVar2 = qs0Var3.h) != null) {
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
                    if (js0Var != null && (qs0Var2 = js0Var.i) != null && (aVar = qs0Var2.h) != null) {
                        str10 = aVar.a;
                    }
                    permissionView.setTextWithUnifiedPadding(str10, TextView.BufferType.NORMAL);
                    permissionView.setOnClickListener(new g(permissionView, this, js0Var));
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
        if (js0Var == null) {
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

    private final void setBrandName(js0 js0Var) {
        String str;
        boolean z;
        rs0 b2;
        rs0 b3;
        UnifyTextView brandName = getBrandName();
        String str2 = null;
        if (js0Var != null && (b3 = js0Var.b()) != null) {
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
            if (js0Var != null && (b2 = js0Var.b()) != null) {
                str2 = b2.b();
            }
            brandName.setText(str2);
        }
        brandName.setOnClickListener(new i(js0Var));
    }

    private final void setTitle(js0 js0Var) {
        String str;
        boolean z;
        rs0 b2;
        rs0 b3;
        UnifyTextView title = getTitle();
        String str2 = null;
        if (js0Var != null && (b3 = js0Var.b()) != null) {
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
            if (js0Var != null && (b2 = js0Var.b()) != null) {
                str2 = b2.g();
            }
            title.setText(str2);
        }
        title.setOnClickListener(new l(js0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDetailButton(js0 js0Var) {
        String str;
        boolean z;
        String str2;
        String str3;
        rs0 b2;
        rs0 b3;
        bs0 bs0Var;
        bs0 bs0Var2;
        rs0 b4;
        View detailBtn = getDetailBtn();
        Resources resources = detailBtn.getResources();
        fq0 a2 = jq0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension = resources.getDimension(a2.h());
        GradientDrawable gradientDrawable = new GradientDrawable();
        String str4 = null;
        if (js0Var != null && (b4 = js0Var.b()) != null) {
            str = b4.c();
        } else {
            str = null;
        }
        gradientDrawable.setColor(a71.a(str, R.color.nad_reward_big_card_btn_color));
        gradientDrawable.setCornerRadius(dimension);
        Unit unit = Unit.INSTANCE;
        detailBtn.setBackground(gradientDrawable);
        boolean z2 = true;
        if (js0Var != null) {
            z = js0Var.m();
        } else {
            z = true;
        }
        if (z) {
            detailBtn.setVisibility(0);
        } else {
            detailBtn.setVisibility(8);
        }
        detailBtn.setOnClickListener(new j(js0Var));
        TextView detailBtnText = getDetailBtnText();
        if (js0Var != null && (bs0Var2 = js0Var.m) != null && bs0Var2.g) {
            String str5 = ClogBuilder.Area.OPEN_BUTTON.type;
            Intrinsics.checkNotNullExpressionValue(str5, "ClogBuilder.Area.OPEN_BUTTON.type");
            u(this, str5, ClogBuilder.LogType.FREE_SHOW, null, null, 12, null);
        }
        if (js0Var != null && (bs0Var = js0Var.m) != null && bs0Var.g) {
            str3 = detailBtnText.getContext().getString(R.string.nad_reward_detail_btn_open_app);
        } else {
            if (js0Var != null && (b3 = js0Var.b()) != null) {
                str2 = b3.e();
            } else {
                str2 = null;
            }
            if (str2 != null && !StringsKt__StringsJVMKt.isBlank(str2)) {
                z2 = false;
            }
            if (!z2) {
                if (js0Var != null && (b2 = js0Var.b()) != null) {
                    str4 = b2.e();
                }
            } else {
                str4 = detailBtnText.getContext().getString(R.string.nad_reward_detail_btn_text);
            }
            str3 = str4;
        }
        detailBtnText.setText(str3);
    }

    private final void setDownloadButton(js0 js0Var) {
        String str;
        boolean z;
        boolean z2;
        Object obj;
        xr0 xr0Var;
        String str2;
        bs0 bs0Var;
        fs0 fs0Var;
        bs0 bs0Var2;
        bs0 bs0Var3;
        xr0 xr0Var2;
        ss0 c2;
        rs0 b2;
        kj0 kj0Var = this.p;
        if (kj0Var != null) {
            kj0Var.j();
        }
        String str3 = null;
        this.p = null;
        NadMiniVideoDownloadView downloadButton = getDownloadButton();
        Resources resources = downloadButton.getResources();
        fq0 a2 = jq0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension = resources.getDimension(a2.h());
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (js0Var != null && (b2 = js0Var.b()) != null) {
            str = b2.c();
        } else {
            str = null;
        }
        gradientDrawable.setColor(a71.a(str, R.color.nad_reward_big_card_btn_color));
        gradientDrawable.setCornerRadius(dimension);
        Unit unit = Unit.INSTANCE;
        downloadButton.setBackground(gradientDrawable);
        downloadButton.setBorderRadius(dimension);
        downloadButton.setProgressColor(ContextCompat.getColor(downloadButton.getContext(), R.color.nad_reward_big_card_btn_download_progress));
        if (js0Var != null && (c2 = js0Var.c()) != null) {
            z = c2.f();
        } else {
            z = false;
        }
        downloadButton.setIconArrowSwitch(z);
        if (js0Var != null) {
            z2 = js0Var.n();
        } else {
            z2 = false;
        }
        boolean z3 = true;
        if ((!z2 || js0Var == null || (bs0Var3 = js0Var.m) == null || (xr0Var2 = bs0Var3.p) == null || !xr0Var2.e) ? false : false) {
            downloadButton.setVisibility(0);
            obj = downloadButton;
        } else {
            downloadButton.setVisibility(8);
            obj = null;
        }
        if (obj != null) {
            if (js0Var != null && (bs0Var2 = js0Var.m) != null) {
                xr0Var = bs0Var2.p;
            } else {
                xr0Var = null;
            }
            if (js0Var != null && (fs0Var = js0Var.f) != null) {
                str2 = fs0Var.d;
            } else {
                str2 = null;
            }
            if (js0Var != null && (bs0Var = js0Var.m) != null) {
                str3 = bs0Var.t;
            }
            gm0 d2 = gm0.d(xr0Var, str2, str3);
            Intrinsics.checkNotNullExpressionValue(d2, "AdDownloadBean.from(adMo….enhanceModel?.btnScheme)");
            d2.q.a = ClogBuilder.Page.WELFAREBIGCARD.type;
            kj0 kj0Var2 = new kj0(d2, getDownloadButton());
            this.p = kj0Var2;
            Intrinsics.checkNotNull(kj0Var2);
            kj0Var2.z();
        }
        downloadButton.setOnClickListener(new k(js0Var));
    }

    public final void y(boolean z) {
        String str;
        boolean z2;
        fq0 a2;
        String str2;
        String str3;
        String str4;
        fs0 fs0Var;
        fs0 fs0Var2;
        fs0 fs0Var3;
        ss0 c2;
        long j2;
        ss0 c3;
        js0 js0Var = this.o;
        String str5 = null;
        if (js0Var != null) {
            str = js0Var.f();
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
                js0 js0Var2 = this.o;
                if (js0Var2 != null && (c3 = js0Var2.c()) != null) {
                    j2 = c3.d();
                } else {
                    j2 = 0;
                }
                handler.postDelayed(runnable, j2);
            }
        }
        q91 q91Var = new q91(getContext());
        js0 js0Var3 = this.o;
        this.q = (js0Var3 == null || (c2 = js0Var3.c()) == null || (r1 = c2.c()) == null) ? "0" : "0";
        q91Var.i(new n(z));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(jq0.a(), "NadRewardVideoLpRuntime.getUIProvider()");
        double dimension = 1 - (resources.getDimension(a2.q()) / e71.c.c(getContext()));
        js0 js0Var4 = this.o;
        if (js0Var4 != null) {
            str2 = js0Var4.f();
        } else {
            str2 = null;
        }
        js0 js0Var5 = this.o;
        if (js0Var5 != null && (fs0Var3 = js0Var5.f) != null) {
            str3 = fs0Var3.d;
        } else {
            str3 = null;
        }
        y91 y91Var = new y91(str2, dimension, 0, str3);
        y91Var.J(true);
        y91Var.I(false);
        y91Var.M(true);
        y91Var.L(!z);
        y91Var.A(z);
        y91Var.B(z);
        y91Var.C(true);
        js0 js0Var6 = this.o;
        if (js0Var6 != null && (fs0Var2 = js0Var6.f) != null) {
            str4 = fs0Var2.m;
        } else {
            str4 = null;
        }
        if (!TextUtils.isEmpty(str4)) {
            js0 js0Var7 = this.o;
            if (js0Var7 != null && (fs0Var = js0Var7.f) != null) {
                str5 = fs0Var.l;
            }
            y91Var.z(str5);
        }
        Unit unit = Unit.INSTANCE;
        q91Var.h(y91Var);
        q91Var.j();
        this.t = System.currentTimeMillis();
        Unit unit2 = Unit.INSTANCE;
        this.n = q91Var;
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
        bs0 bs0Var;
        String str3;
        rs0 b2;
        u(this, str, logType, null, null, 12, null);
        js0 js0Var = this.o;
        boolean z = false;
        if (js0Var != null && (bs0Var = js0Var.m) != null && !bs0Var.g) {
            if (js0Var != null && (b2 = js0Var.b()) != null) {
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
            ak0.c(str2, getContext());
        }
    }

    public final void r() {
        int a2;
        AdImageView arrow = getArrow();
        arrow.setImageResource(R.drawable.nad_reward_big_card_arrow);
        ViewGroup.LayoutParams layoutParams = arrow.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            js0 js0Var = this.o;
            if (js0Var != null && js0Var.m()) {
                a2 = e71.c.a(arrow.getContext(), 10.0f);
            } else {
                a2 = e71.c.a(arrow.getContext(), 25.0f);
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
        fs0 fs0Var;
        ClogBuilder u = new ClogBuilder().j(str).y(logType).u(ClogBuilder.Page.WELFAREBIGCARD);
        js0 js0Var = this.o;
        List<MonitorUrl> list = null;
        if (js0Var != null && (fs0Var = js0Var.f) != null) {
            str4 = fs0Var.d;
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
        n41.e(p);
        if (logType == ClogBuilder.LogType.CLICK) {
            js0 js0Var2 = this.o;
            if (js0Var2 != null) {
                list = js0Var2.e;
            }
            mj0.b(list);
        }
    }
}
