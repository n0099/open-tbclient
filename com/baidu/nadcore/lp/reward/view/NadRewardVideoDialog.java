package com.baidu.nadcore.lp.reward.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.utils.ExtensionsKt;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tieba.R;
import com.baidu.tieba.ap0;
import com.baidu.tieba.ip0;
import com.baidu.tieba.mp0;
import com.baidu.tieba.p61;
import com.baidu.tieba.so0;
import com.baidu.tieba.to0;
import com.baidu.tieba.w31;
import com.baidu.tieba.zo0;
import com.baidu.util.Base64Encoder;
import com.baidu.webkit.sdk.WebChromeClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.nio.charset.Charset;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0010\u0018\u00002\u00020\u0001:\u0002\u009a\u0001B\b¢\u0006\u0005\b\u0099\u0001\u0010\u0011JQ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u0011J+\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010#J\u0019\u0010&\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J\u0019\u0010)\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b)\u0010*J+\u00100\u001a\u00020/2\u0006\u0010,\u001a\u00020+2\b\u0010.\u001a\u0004\u0018\u00010-2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u000fH\u0016¢\u0006\u0004\b2\u0010\u0011J\u0015\u00105\u001a\u00020\u000f2\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\u0015\u00108\u001a\u00020\u000f2\u0006\u00104\u001a\u000207¢\u0006\u0004\b8\u00109J#\u0010;\u001a\u00020\u000f2\u0014\u00104\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000f0:¢\u0006\u0004\b;\u0010<J\u001f\u0010?\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u0004H\u0016¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u000fH\u0016¢\u0006\u0004\bA\u0010\u0011J\u001b\u0010C\u001a\u00020\u000f2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000f0B¢\u0006\u0004\bC\u0010DJ\u0015\u0010E\u001a\u00020\u000f2\u0006\u00104\u001a\u000207¢\u0006\u0004\bE\u00109J\u001b\u0010G\u001a\u00020\u000f2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000f0B¢\u0006\u0004\bG\u0010DJ\u001b\u0010H\u001a\u00020\u000f2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000f0B¢\u0006\u0004\bH\u0010DJ!\u0010L\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020I2\b\u0010K\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\bL\u0010MJ\u0017\u0010P\u001a\u00020\u000f2\b\u0010O\u001a\u0004\u0018\u00010N¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\u000fH\u0002¢\u0006\u0004\bR\u0010\u0011J#\u0010V\u001a\u00020\u000f*\u00020\f2\u0006\u0010.\u001a\u00020S2\u0006\u0010U\u001a\u00020TH\u0002¢\u0006\u0004\bV\u0010WR\u0018\u0010X\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010Z\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R&\u0010\\\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000f\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\"\u0010_\u001a\u00020^8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010e\u001a\u00020/8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010l\u001a\u0004\u0018\u00010k8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001e\u0010r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\"\u0010u\u001a\u00020t8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\"\u0010{\u001a\u00020\u00178\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0004\b\u007f\u0010\u001aR\u001a\u0010\u0080\u0001\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010[R%\u0010>\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b>\u0010\u0081\u0001\u001a\u0005\b\u0082\u0001\u0010\u0013\"\u0005\b\u0083\u0001\u0010#R \u0010\u0084\u0001\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010sR*\u0010\u0086\u0001\u001a\u00030\u0085\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R&\u0010\u008c\u0001\u001a\u00020/8\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b\u008c\u0001\u0010f\u001a\u0005\b\u008d\u0001\u0010h\"\u0005\b\u008e\u0001\u0010jR \u0010\u008f\u0001\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010sR&\u0010\u0090\u0001\u001a\u00020\u00178\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b\u0090\u0001\u0010|\u001a\u0005\b\u0091\u0001\u0010~\"\u0005\b\u0092\u0001\u0010\u001aR)\u0010\u0093\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001¨\u0006\u009b\u0001"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "Landroidx/fragment/app/DialogFragment;", "Lcom/baidu/nadcore/lp/reward/data/NadDialogButtonData;", "buttonData", "", "type", DnsModel.AREA_KEY, "btnIndex", "", "shouldCharge", "closeDialog", "isLottieDialogMainBtn", "Landroid/widget/TextView;", "buildButton", "(Lcom/baidu/nadcore/lp/reward/data/NadDialogButtonData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)Landroid/widget/TextView;", "", "dismiss", "()V", "getTaskCenterPolicy", "()Ljava/lang/String;", "btnCmd", "handleLocalCmd", "(Ljava/lang/String;)Z", "Lcom/baidu/nadcore/widget/AdImageView;", "icon", "initCloseIcon", "(Lcom/baidu/nadcore/widget/AdImageView;)V", "initCommonView", "logWelfareDialog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/DialogInterface;", "dialog", GameAssistConstKt.TYPE_CALLBACK_CANCEL, "(Landroid/content/DialogInterface;)V", "onConvertClick", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onDetach", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog$DialogClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAfterClickListener", "(Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog$DialogClickListener;)V", "Landroid/view/View$OnClickListener;", "setCloseBtnClickListener", "(Landroid/view/View$OnClickListener;)V", "Lkotlin/Function1;", "setConvertClickListener", "(Lkotlin/Function1;)V", "rewardDataJson", "ext", "setData", "(Ljava/lang/String;Ljava/lang/String;)V", "setDialogContentView", "Lkotlin/Function0;", "setDialogDismissListener", "(Lkotlin/Function0;)V", "setDownloadBtnClickListener", WebChromeClient.KEY_ARG_CALLBACK, "setLottieBtnClkListener", "setSuspendRightAnsListener", "Landroidx/fragment/app/FragmentManager;", "manager", "tag", "show", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "Landroid/content/Context;", "context", "startBgLottie", "(Landroid/content/Context;)V", "stopAnimation", "Landroid/widget/FrameLayout;", "", "bottomTextSize", "setBottomBtnStyle", "(Landroid/widget/TextView;Landroid/widget/FrameLayout;F)V", "afterClickListener", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog$DialogClickListener;", "closeBtnClickListener", "Landroid/view/View$OnClickListener;", "convertClickListener", "Lkotlin/Function1;", "Lcom/airbnb/lottie/LottieAnimationView;", "dialogBgLottie", "Lcom/airbnb/lottie/LottieAnimationView;", "getDialogBgLottie", "()Lcom/airbnb/lottie/LottieAnimationView;", "setDialogBgLottie", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "dialogContent", "Landroid/view/View;", "getDialogContent", "()Landroid/view/View;", "setDialogContent", "(Landroid/view/View;)V", "Lcom/baidu/nadcore/lp/reward/data/NadRewardDialogData;", "dialogData", "Lcom/baidu/nadcore/lp/reward/data/NadRewardDialogData;", "getDialogData", "()Lcom/baidu/nadcore/lp/reward/data/NadRewardDialogData;", "setDialogData", "(Lcom/baidu/nadcore/lp/reward/data/NadRewardDialogData;)V", "dialogDismissListener", "Lkotlin/Function0;", "Landroid/view/ViewStub;", "dialogStub", "Landroid/view/ViewStub;", "getDialogStub", "()Landroid/view/ViewStub;", "setDialogStub", "(Landroid/view/ViewStub;)V", "dialogTopImg", "Lcom/baidu/nadcore/widget/AdImageView;", "getDialogTopImg", "()Lcom/baidu/nadcore/widget/AdImageView;", "setDialogTopImg", "downloadBtnClickListener", "Ljava/lang/String;", "getExt", "setExt", "lottieBtnClickListener", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "setMainHandler", "(Landroid/os/Handler;)V", "rootContainerView", "getRootContainerView", "setRootContainerView", "suspendRightAnsListener", "topImg", "getTopImg", "setTopImg", "upperLimit", "Z", "getUpperLimit", "()Z", "setUpperLimit", "(Z)V", "<init>", "DialogClickListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public class NadRewardVideoDialog extends DialogFragment {
    public View a;
    public AdImageView b;
    public AdImageView c;
    public LottieAnimationView d;
    public ViewStub e;
    public View f;
    public View.OnClickListener g;
    public Function0<Unit> h;
    public View.OnClickListener i;
    public a j;
    public Function1<? super String, Unit> k;
    public Function0<Unit> l;
    public Function0<Unit> m;
    public ap0 n;
    public Handler o = new Handler(Looper.getMainLooper());
    public String p = "";
    public boolean q;
    public HashMap r;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public void c2() {
        HashMap hashMap = this.r;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c2();
    }

    /* loaded from: classes3.dex */
    public static final class b implements to0 {
        public final /* synthetic */ Context a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ TextView c;

        @Override // com.baidu.tieba.to0
        public void a() {
        }

        public b(Context context, Context context2, TextView textView) {
            this.a = context;
            this.b = context2;
            this.c = textView;
        }

        @Override // com.baidu.tieba.to0
        public void b(Bitmap bitmap) {
            if (bitmap != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.a.getResources(), bitmap);
                bitmapDrawable.setBounds(0, 0, ExtensionsKt.d(10, this.b), ExtensionsKt.d(10, this.b));
                this.c.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.c.setCompoundDrawablePadding(ExtensionsKt.d(2, this.b));
                return;
            }
            a();
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements to0 {
        public final /* synthetic */ Context a;
        public final /* synthetic */ View b;

        @Override // com.baidu.tieba.to0
        public void a() {
        }

        public c(Context context, View view2) {
            this.a = context;
            this.b = view2;
        }

        @Override // com.baidu.tieba.to0
        public void b(Bitmap bitmap) {
            if (bitmap != null) {
                this.b.setBackground(new BitmapDrawable(this.a.getResources(), bitmap));
                return;
            }
            a();
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements View.OnClickListener {
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ zo0 e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ boolean g;

        public d(String str, String str2, String str3, zo0 zo0Var, boolean z, boolean z2) {
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = zo0Var;
            this.f = z;
            this.g = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            a aVar;
            Function1 function1;
            NadRewardVideoDialog.this.u2(this.b, this.c, this.d);
            if (!NadRewardVideoDialog.this.r2(this.e.b()) && (function1 = NadRewardVideoDialog.this.k) != null) {
                Unit unit = (Unit) function1.invoke(this.e.b());
            }
            if (this.f && (aVar = NadRewardVideoDialog.this.j) != null) {
                aVar.a();
            }
            if (this.g) {
                NadRewardVideoDialog.this.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardVideoDialog nadRewardVideoDialog = NadRewardVideoDialog.this;
            String str = ClogBuilder.LogType.FREE_CLICK.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
            NadRewardVideoDialog.v2(nadRewardVideoDialog, str, "close", null, 4, null);
            NadRewardVideoDialog.this.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardVideoDialog nadRewardVideoDialog = NadRewardVideoDialog.this;
            String str = ClogBuilder.Area.AVATAR.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.AVATAR.type");
            nadRewardVideoDialog.w2(str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardVideoDialog nadRewardVideoDialog = NadRewardVideoDialog.this;
            String str = ClogBuilder.Area.NAME.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.NAME.type");
            nadRewardVideoDialog.w2(str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardVideoDialog nadRewardVideoDialog = NadRewardVideoDialog.this;
            String str = ClogBuilder.Area.TITTLE.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.TITTLE.type");
            nadRewardVideoDialog.w2(str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class i<T> implements LottieListener<LottieComposition> {
        public final /* synthetic */ Context b;

        public i(Context context) {
            this.b = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(LottieComposition lottieComposition) {
            NadRewardVideoDialog.this.k2().setComposition(lottieComposition);
            NadRewardVideoDialog.this.k2().playAnimation();
            NadRewardVideoDialog.this.k2().setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public static final class j<T> implements LottieListener<Throwable> {
        public final /* synthetic */ Context b;

        public j(Context context) {
            this.b = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(Throwable th) {
            NadRewardVideoDialog.this.k2().setVisibility(8);
        }
    }

    public final void J2() {
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogBgLottie");
        }
        lottieAnimationView.cancelAnimation();
        LottieAnimationView lottieAnimationView2 = this.d;
        if (lottieAnimationView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogBgLottie");
        }
        lottieAnimationView2.setVisibility(8);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        dismissAllowingStateLoss();
    }

    public final LottieAnimationView k2() {
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogBgLottie");
        }
        return lottieAnimationView;
    }

    public final View l2() {
        View view2 = this.f;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        return view2;
    }

    public final ap0 m2() {
        return this.n;
    }

    public final ViewStub n2() {
        ViewStub viewStub = this.e;
        if (viewStub == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogStub");
        }
        return viewStub;
    }

    public final Handler o2() {
        return this.o;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        Function0<Unit> function0 = this.h;
        if (function0 != null) {
            function0.invoke();
        }
        this.o.removeCallbacksAndMessages(null);
        J2();
    }

    public final AdImageView q2() {
        AdImageView adImageView = this.b;
        if (adImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topImg");
        }
        return adImageView;
    }

    public final void A2(Function1<? super String, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.k = listener;
    }

    public final void C2(View view2) {
        Intrinsics.checkNotNullParameter(view2, "<set-?>");
        this.f = view2;
    }

    public final void E2(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.h = listener;
    }

    public final void F2(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.i = listener;
    }

    public final void G2(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.m = callback;
    }

    public final void H2(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.l = callback;
    }

    public final void I2(Context context) {
        String str;
        int i2;
        if (context != null) {
            J2();
            ap0 ap0Var = this.n;
            if (ap0Var != null) {
                str = ap0Var.c();
            } else {
                str = null;
            }
            if (str != null) {
                i2 = str.hashCode();
            } else {
                i2 = 0;
            }
            LottieCompositionFactory.fromUrl(context, str, String.valueOf(i2)).addListener(new i(context)).addFailureListener(new j(context));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        String str = ClogBuilder.LogType.FREE_CLICK.type;
        Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
        v2(this, str, "blank", null, 4, null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.obfuscated_res_0x7f1003f2);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        WindowManager.LayoutParams layoutParams;
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.gravity = 17;
        }
        Window window2 = onCreateDialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams);
        }
        return onCreateDialog;
    }

    public final void x2(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.j = listener;
    }

    public final void z2(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.g = listener;
    }

    public void B2(String rewardDataJson, String ext) {
        Intrinsics.checkNotNullParameter(rewardDataJson, "rewardDataJson");
        Intrinsics.checkNotNullParameter(ext, "ext");
        ap0 ap0Var = new ap0(rewardDataJson);
        this.n = ap0Var;
        this.p = ext;
        Intrinsics.checkNotNull(ap0Var);
        this.q = ap0Var.A();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        try {
            super.show(manager, str);
        } catch (Exception unused) {
            dismiss();
        }
        String str2 = ClogBuilder.LogType.FREE_SHOW.type;
        Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.LogType.FREE_SHOW.type");
        v2(this, str2, null, null, 6, null);
    }

    public static /* synthetic */ TextView j2(NadRewardVideoDialog nadRewardVideoDialog, zo0 zo0Var, String str, String str2, String str3, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        String str4;
        String str5;
        boolean z4;
        boolean z5;
        if (obj == null) {
            if ((i2 & 2) != 0) {
                str4 = ClogBuilder.LogType.FREE_CLICK.type;
                Intrinsics.checkNotNullExpressionValue(str4, "ClogBuilder.LogType.FREE_CLICK.type");
            } else {
                str4 = str;
            }
            String str6 = "";
            if ((i2 & 4) != 0) {
                str5 = "";
            } else {
                str5 = str2;
            }
            if ((i2 & 8) == 0) {
                str6 = str3;
            }
            boolean z6 = false;
            if ((i2 & 16) != 0) {
                z4 = false;
            } else {
                z4 = z;
            }
            if ((i2 & 32) != 0) {
                z5 = true;
            } else {
                z5 = z2;
            }
            if ((i2 & 64) == 0) {
                z6 = z3;
            }
            return nadRewardVideoDialog.i2(zo0Var, str4, str5, str6, z4, z5, z6);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildButton");
    }

    public static /* synthetic */ void v2(NadRewardVideoDialog nadRewardVideoDialog, String str, String str2, String str3, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                str2 = "";
            }
            if ((i2 & 4) != 0) {
                str3 = "";
            }
            nadRewardVideoDialog.u2(str, str2, str3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logWelfareDialog");
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x029a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void D2() {
        View view2;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        TextView textView;
        TextView textView2;
        AdImageView adImageView;
        AdImageView adImageView2;
        TextView textView3;
        float f2;
        TextView textView4;
        TextView textView5;
        float f3;
        TextView textView6;
        TextView textView7;
        ap0 ap0Var;
        TextView textView8;
        TextView textView9;
        ap0 ap0Var2;
        String str;
        boolean z;
        int i2;
        AdImageView adImageView3;
        ap0 ap0Var3;
        String str2;
        boolean z2;
        TextView textView10;
        ap0 ap0Var4;
        String str3;
        boolean z3;
        TextView textView11;
        LinearLayout linearLayout3;
        TextView textView12;
        float f4;
        LinearLayout linearLayout4;
        String str4;
        String str5;
        zo0 f5;
        zo0 g2;
        ap0 ap0Var5;
        zo0 g3;
        String b2;
        zo0 s;
        zo0 j2;
        String str6;
        boolean z4;
        ViewStub viewStub = this.e;
        if (viewStub == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogStub");
        }
        ip0 a2 = mp0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        viewStub.setLayoutResource(a2.d());
        ViewStub viewStub2 = this.e;
        if (viewStub2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogStub");
        }
        View inflate = viewStub2.inflate();
        Intrinsics.checkNotNullExpressionValue(inflate, "dialogStub.inflate()");
        this.f = inflate;
        Resources resources = getResources();
        ip0 a3 = mp0.a();
        Intrinsics.checkNotNullExpressionValue(a3, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension = resources.getDimension(a3.h());
        Resources resources2 = getResources();
        ip0 a4 = mp0.a();
        Intrinsics.checkNotNullExpressionValue(a4, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension2 = resources2.getDimension(a4.j());
        Resources resources3 = getResources();
        ip0 a5 = mp0.a();
        Intrinsics.checkNotNullExpressionValue(a5, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension3 = resources3.getDimension(a5.w());
        View view3 = this.f;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        View findViewById = view3.findViewById(R.id.close_img);
        Intrinsics.checkNotNullExpressionValue(findViewById, "dialogContent.findViewById(R.id.close_img)");
        AdImageView adImageView4 = (AdImageView) findViewById;
        View view4 = this.f;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        View findViewById2 = view4.findViewById(R.id.obfuscated_res_0x7f090315);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "dialogContent.findViewById(R.id.avatar)");
        AdImageView adImageView5 = (AdImageView) findViewById2;
        View view5 = this.f;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        View findViewById3 = view5.findViewById(R.id.obfuscated_res_0x7f09259d);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "dialogContent.findViewById(R.id.title)");
        TextView textView13 = (TextView) findViewById3;
        View view6 = this.f;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        View findViewById4 = view6.findViewById(R.id.obfuscated_res_0x7f092307);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "dialogContent.findViewById(R.id.sub_title)");
        TextView textView14 = (TextView) findViewById4;
        View view7 = this.f;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        View findViewById5 = view7.findViewById(R.id.button_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "dialogContent.findViewById(R.id.button_container)");
        LinearLayout linearLayout5 = (LinearLayout) findViewById5;
        View view8 = this.f;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        View findViewById6 = view8.findViewById(R.id.bottom_btn_container);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "dialogContent.findViewBy….id.bottom_btn_container)");
        LinearLayout linearLayout6 = (LinearLayout) findViewById6;
        View view9 = this.f;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        View findViewById7 = view9.findViewById(R.id.left_container);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "dialogContent.findViewById(R.id.left_container)");
        FrameLayout frameLayout3 = (FrameLayout) findViewById7;
        View view10 = this.f;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        View findViewById8 = view10.findViewById(R.id.right_container);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "dialogContent.findViewById(R.id.right_container)");
        FrameLayout frameLayout4 = (FrameLayout) findViewById8;
        View view11 = this.f;
        if (view11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        View findViewById9 = view11.findViewById(R.id.bottom_divider);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "dialogContent.findViewById(R.id.bottom_divider)");
        ap0 ap0Var6 = this.n;
        String str7 = null;
        boolean z5 = true;
        if (ap0Var6 != null && (j2 = ap0Var6.j()) != null) {
            ap0 ap0Var7 = this.n;
            Intrinsics.checkNotNull(ap0Var7);
            boolean z6 = !ap0Var7.C();
            ap0 ap0Var8 = this.n;
            Intrinsics.checkNotNull(ap0Var8);
            if (ap0Var8.C()) {
                str6 = ClogBuilder.LogType.FREE_CLICK.type;
            } else {
                str6 = ClogBuilder.LogType.CLICK.type;
            }
            Intrinsics.checkNotNullExpressionValue(str6, "if (dialogData!!.isDownl…CK.type\n                }");
            String str8 = ClogBuilder.Area.AD_BTN_DETAIL.type;
            String str9 = str6;
            Intrinsics.checkNotNullExpressionValue(str8, "ClogBuilder.Area.AD_BTN_DETAIL.type");
            ap0 ap0Var9 = this.n;
            Intrinsics.checkNotNull(ap0Var9);
            if (!ap0Var9.C()) {
                ap0 ap0Var10 = this.n;
                Intrinsics.checkNotNull(ap0Var10);
                if (!ap0Var10.D()) {
                    z4 = false;
                    view2 = findViewById9;
                    frameLayout = frameLayout4;
                    frameLayout2 = frameLayout3;
                    linearLayout = linearLayout6;
                    linearLayout2 = linearLayout5;
                    textView = textView14;
                    textView2 = textView13;
                    adImageView = adImageView4;
                    adImageView2 = adImageView5;
                    textView3 = j2(this, j2, str9, str8, null, z6, z4, false, 72, null);
                }
            }
            z4 = true;
            view2 = findViewById9;
            frameLayout = frameLayout4;
            frameLayout2 = frameLayout3;
            linearLayout = linearLayout6;
            linearLayout2 = linearLayout5;
            textView = textView14;
            textView2 = textView13;
            adImageView = adImageView4;
            adImageView2 = adImageView5;
            textView3 = j2(this, j2, str9, str8, null, z6, z4, false, 72, null);
        } else {
            view2 = findViewById9;
            frameLayout = frameLayout4;
            frameLayout2 = frameLayout3;
            linearLayout = linearLayout6;
            linearLayout2 = linearLayout5;
            textView = textView14;
            textView2 = textView13;
            adImageView = adImageView4;
            adImageView2 = adImageView5;
            textView3 = null;
        }
        ap0 ap0Var11 = this.n;
        if (ap0Var11 != null && (s = ap0Var11.s()) != null) {
            f2 = dimension3;
            textView4 = textView3;
            textView5 = j2(this, s, null, null, "1", false, false, false, 118, null);
        } else {
            f2 = dimension3;
            textView4 = textView3;
            textView5 = null;
        }
        if (!this.q) {
            ap0 ap0Var12 = this.n;
            if (ap0Var12 != null && ap0Var12.w() != null && (ap0Var5 = this.n) != null && (g3 = ap0Var5.g()) != null && (b2 = g3.b()) != null) {
                StringsKt__StringsJVMKt.replace$default(b2, "__TASKCENTERPOLICY__", p2(), false, 4, (Object) null);
            }
            ap0 ap0Var13 = this.n;
            if (ap0Var13 != null && (g2 = ap0Var13.g()) != null) {
                f3 = dimension;
                textView6 = textView5;
                textView7 = j2(this, g2, null, null, "2", false, false, false, 118, null);
                ap0Var = this.n;
                if (ap0Var == null && (f5 = ap0Var.f()) != null) {
                    String str10 = ClogBuilder.Area.AD_LEAVE.type;
                    Intrinsics.checkNotNullExpressionValue(str10, "ClogBuilder.Area.AD_LEAVE.type");
                    textView8 = textView7;
                    textView9 = j2(this, f5, null, str10, null, false, false, false, 122, null);
                } else {
                    textView8 = textView7;
                    textView9 = null;
                }
                ap0Var2 = this.n;
                if (ap0Var2 == null) {
                    str = ap0Var2.a();
                } else {
                    str = null;
                }
                if (str == null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (!(!z)) {
                    i2 = 0;
                    adImageView2.setVisibility(0);
                    adImageView3 = adImageView2;
                } else {
                    i2 = 0;
                    adImageView2.setVisibility(8);
                    adImageView3 = null;
                }
                if (adImageView3 != null) {
                    ap0 ap0Var14 = this.n;
                    if (ap0Var14 != null) {
                        str5 = ap0Var14.a();
                    } else {
                        str5 = null;
                    }
                    adImageView3.r(str5);
                    adImageView3.setOnClickListener(new f());
                    Unit unit = Unit.INSTANCE;
                }
                ap0Var3 = this.n;
                if (ap0Var3 == null) {
                    str2 = ap0Var3.x();
                } else {
                    str2 = null;
                }
                if (str2 == null && !StringsKt__StringsJVMKt.isBlank(str2)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!(!z2)) {
                    TextView textView15 = textView2;
                    textView15.setVisibility(i2);
                    textView10 = textView15;
                } else {
                    textView2.setVisibility(8);
                    textView10 = null;
                }
                if (textView10 != null) {
                    ap0 ap0Var15 = this.n;
                    if (ap0Var15 != null) {
                        str4 = ap0Var15.x();
                    } else {
                        str4 = null;
                    }
                    textView10.setText(str4);
                    textView10.setOnClickListener(new g());
                    Unit unit2 = Unit.INSTANCE;
                }
                ap0Var4 = this.n;
                if (ap0Var4 == null) {
                    str3 = ap0Var4.v();
                } else {
                    str3 = null;
                }
                if (str3 == null && str3.length() != 0) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (!(!z3)) {
                    TextView textView16 = textView;
                    textView16.setVisibility(i2);
                    textView11 = textView16;
                } else {
                    textView.setVisibility(8);
                    textView11 = null;
                }
                if (textView11 != null) {
                    ap0 ap0Var16 = this.n;
                    if (ap0Var16 != null) {
                        str7 = ap0Var16.v();
                    }
                    textView11.setText(str7);
                    textView11.setOnClickListener(new h());
                    Unit unit3 = Unit.INSTANCE;
                }
                if (textView6 == null) {
                    textView6.setTypeface(Typeface.defaultFromStyle(1));
                    textView6.setTextSize(i2, dimension2);
                    textView6.setGravity(17);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    Resources resources4 = textView6.getResources();
                    ip0 a6 = mp0.a();
                    Intrinsics.checkNotNullExpressionValue(a6, "NadRewardVideoLpRuntime.getUIProvider()");
                    layoutParams.topMargin = resources4.getDimensionPixelSize(a6.k());
                    linearLayout3 = linearLayout2;
                    linearLayout3.addView(textView6, i2, layoutParams);
                    Unit unit4 = Unit.INSTANCE;
                } else {
                    linearLayout3 = linearLayout2;
                }
                if (textView4 != null) {
                    textView4.setTypeface(Typeface.defaultFromStyle(1));
                    textView4.setTextSize(i2, f3);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 17;
                    linearLayout3.addView(textView4, i2, layoutParams2);
                    Unit unit5 = Unit.INSTANCE;
                }
                textView12 = textView8;
                if (textView12 == null) {
                    z5 = false;
                }
                if (!z5) {
                    view2.setVisibility(i2);
                } else {
                    view2.setVisibility(8);
                }
                if (textView9 == null) {
                    f4 = f2;
                    y2(textView9, frameLayout2, f4);
                    linearLayout4 = linearLayout;
                    linearLayout4.setVisibility(i2);
                    Unit unit6 = Unit.INSTANCE;
                } else {
                    f4 = f2;
                    linearLayout4 = linearLayout;
                }
                if (textView12 != null) {
                    y2(textView12, frameLayout, f4);
                    linearLayout4.setVisibility(i2);
                    Unit unit7 = Unit.INSTANCE;
                }
                s2(adImageView);
            }
        }
        f3 = dimension;
        textView6 = textView5;
        textView7 = null;
        ap0Var = this.n;
        if (ap0Var == null) {
        }
        textView8 = textView7;
        textView9 = null;
        ap0Var2 = this.n;
        if (ap0Var2 == null) {
        }
        if (str == null) {
        }
        z = true;
        if (!(!z)) {
        }
        if (adImageView3 != null) {
        }
        ap0Var3 = this.n;
        if (ap0Var3 == null) {
        }
        if (str2 == null) {
        }
        z2 = true;
        if (!(!z2)) {
        }
        if (textView10 != null) {
        }
        ap0Var4 = this.n;
        if (ap0Var4 == null) {
        }
        if (str3 == null) {
        }
        z3 = true;
        if (!(!z3)) {
        }
        if (textView11 != null) {
        }
        if (textView6 == null) {
        }
        if (textView4 != null) {
        }
        textView12 = textView8;
        if (textView12 == null) {
        }
        if (!z5) {
        }
        if (textView9 == null) {
        }
        if (textView12 != null) {
        }
        s2(adImageView);
    }

    public final TextView i2(zo0 buttonData, String type, String area, String btnIndex, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        Function0<Unit> function0;
        Drawable drawable;
        Intrinsics.checkNotNullParameter(buttonData, "buttonData");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(btnIndex, "btnIndex");
        TextView textView = new TextView(getContext());
        String a2 = buttonData.a();
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        boolean z6 = true;
        if (a2 != null && a2.length() != 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!z4) {
            so0.a().c(a2, new c(context, textView));
        }
        if (!TextUtils.isEmpty(buttonData.e())) {
            textView.setTextColor(Color.parseColor(buttonData.e()));
        }
        Context context2 = getContext();
        if (buttonData.c().length() > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            if (context2 != null) {
                drawable = ContextCompat.getDrawable(context2, R.drawable.nad_reward_dialog_convert_btn_default);
            } else {
                drawable = null;
            }
            if (drawable != null) {
                drawable.setBounds(0, 0, ExtensionsKt.d(10, context2), ExtensionsKt.d(10, context2));
            }
            textView.setCompoundDrawables(null, null, drawable, null);
            if (context2 != null) {
                textView.setCompoundDrawablePadding(ExtensionsKt.d(2, context2));
            }
        }
        if (context2 != null) {
            String c2 = buttonData.c();
            if (c2 != null && c2.length() != 0) {
                z6 = false;
            }
            if (!z6) {
                so0.a().c(c2, new b(context2, context2, textView));
            }
        }
        textView.setText(buttonData.d());
        textView.setIncludeFontPadding(false);
        textView.setOnClickListener(new d(type, area, btnIndex, buttonData, z, z2));
        if (z3 && (function0 = this.m) != null) {
            function0.invoke();
        }
        return textView;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ip0 a2 = mp0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        boolean z = true;
        View rootView = inflater.inflate(a2.g(), viewGroup, true);
        View findViewById = rootView.findViewById(R.id.obfuscated_res_0x7f091fb6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.root_view)");
        this.a = findViewById;
        View findViewById2 = rootView.findViewById(R.id.top_img);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.top_img)");
        this.b = (AdImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.dialog_top_img);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.dialog_top_img)");
        this.c = (AdImageView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.dialog_bg_lottie);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.dialog_bg_lottie)");
        this.d = (LottieAnimationView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.dialog_content);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.dialog_content)");
        this.e = (ViewStub) findViewById5;
        if (this.p.length() != 0) {
            z = false;
        }
        if (!z && this.n != null) {
            D2();
            t2();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            return rootView;
        }
        dismiss();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return rootView;
    }

    public final String p2() {
        boolean z;
        String q;
        ap0 ap0Var;
        String w;
        ap0 ap0Var2 = this.n;
        String str = null;
        if (ap0Var2 != null && (q = ap0Var2.q()) != null && (ap0Var = this.n) != null && (w = ap0Var.w()) != null) {
            str = StringsKt__StringsJVMKt.replace$default(w, "__INVOKECOIN__", q, false, 4, (Object) null);
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return "";
        }
        Charset charset = Charsets.UTF_8;
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return Base64Encoder.B64Encode(bytes).toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final boolean r2(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (str != null) {
            String str2 = null;
            switch (str.hashCode()) {
                case -1077350185:
                    if (str.equals("__LEAVE__")) {
                        View.OnClickListener onClickListener = this.g;
                        if (onClickListener == null) {
                            return true;
                        }
                        onClickListener.onClick(getView());
                        return true;
                    }
                    break;
                case 72359676:
                    if (str.equals("__RIGHT__")) {
                        Context context = getContext();
                        ap0 ap0Var = this.n;
                        if (ap0Var != null) {
                            str2 = ap0Var.t();
                        }
                        Toast.makeText(context, str2, 0).show();
                        Function0<Unit> function0 = this.l;
                        if (function0 == null) {
                            return true;
                        }
                        function0.invoke();
                        return true;
                    }
                    break;
                case 446830939:
                    if (str.equals("__CONTINUEPLAY__")) {
                        return true;
                    }
                    break;
                case 480127565:
                    if (str.equals("__WRONG__")) {
                        Context context2 = getContext();
                        ap0 ap0Var2 = this.n;
                        if (ap0Var2 != null) {
                            str2 = ap0Var2.B();
                        }
                        Toast.makeText(context2, str2, 0).show();
                        return true;
                    }
                    break;
                case 1522490442:
                    if (str.equals("__STARTDOWNLOAD__")) {
                        View.OnClickListener onClickListener2 = this.i;
                        if (onClickListener2 == null) {
                            return true;
                        }
                        onClickListener2.onClick(getView());
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    public final void s2(AdImageView icon) {
        String str;
        boolean z;
        Intrinsics.checkNotNullParameter(icon, "icon");
        ap0 ap0Var = this.n;
        String str2 = null;
        if (ap0Var != null) {
            str = ap0Var.h();
        } else {
            str = null;
        }
        if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            icon.setImageDrawable(ContextCompat.getDrawable(icon.getContext(), R.drawable.nad_reward_video_lp_close_btn));
        } else {
            ap0 ap0Var2 = this.n;
            if (ap0Var2 != null) {
                str2 = ap0Var2.h();
            }
            icon.r(str2);
        }
        icon.setOnClickListener(new e());
    }

    public void t2() {
        boolean z;
        boolean z2;
        ap0 ap0Var = this.n;
        if (ap0Var != null) {
            AdImageView adImageView = this.b;
            if (adImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topImg");
            }
            String z3 = ap0Var.z();
            if (z3 != null && z3.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            AdImageView adImageView2 = null;
            if (!z) {
                adImageView.setVisibility(0);
            } else {
                adImageView.setVisibility(8);
                adImageView = null;
            }
            if (adImageView != null) {
                adImageView.r(ap0Var.z());
            }
            AdImageView adImageView3 = this.c;
            if (adImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogTopImg");
            }
            String o = ap0Var.o();
            if (o != null && o.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                adImageView3.setVisibility(0);
                adImageView2 = adImageView3;
            } else {
                adImageView3.setVisibility(8);
            }
            if (adImageView2 != null) {
                adImageView2.r(ap0Var.o());
            }
            View view2 = this.f;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TL_BR);
            gradientDrawable.setCornerRadius(p61.c.a(getContext(), 18.0f));
            gradientDrawable.setColors(new int[]{ap0Var.d(), ap0Var.b()});
            gradientDrawable.setStroke(p61.c.a(getContext(), 2.0f), ap0Var.e());
            Unit unit = Unit.INSTANCE;
            view2.setBackground(gradientDrawable);
        }
    }

    public final void u2(String str, String str2, String str3) {
        boolean z;
        String str4;
        if (this.p.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z && this.n != null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.u(ClogBuilder.Page.WELFAREPANEL);
            clogBuilder.z(str);
            clogBuilder.p(this.p);
            clogBuilder.j(str2);
            clogBuilder.k(str3);
            ap0 ap0Var = this.n;
            if (ap0Var != null) {
                str4 = ap0Var.p();
            } else {
                str4 = null;
            }
            clogBuilder.l(String.valueOf(str4));
            w31.e(clogBuilder);
        }
    }

    public final void w2(String str) {
        String str2;
        View.OnClickListener onClickListener;
        String str3 = ClogBuilder.LogType.CLICK.type;
        Intrinsics.checkNotNullExpressionValue(str3, "ClogBuilder.LogType.CLICK.type");
        v2(this, str3, str, null, 4, null);
        a aVar = this.j;
        if (aVar != null) {
            aVar.a();
        }
        ap0 ap0Var = this.n;
        if (ap0Var != null && ap0Var.D()) {
            ap0 ap0Var2 = this.n;
            if (ap0Var2 != null && ap0Var2.C() && (onClickListener = this.i) != null) {
                onClickListener.onClick(getView());
            }
            dismiss();
            return;
        }
        Function1<? super String, Unit> function1 = this.k;
        if (function1 != null) {
            ap0 ap0Var3 = this.n;
            if (ap0Var3 != null) {
                str2 = ap0Var3.k();
            } else {
                str2 = null;
            }
            function1.invoke(str2);
        }
    }

    public final void y2(TextView textView, FrameLayout frameLayout, float f2) {
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setTextSize(0, f2);
        textView.setGravity(17);
        ViewParent parent = textView.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(textView);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        frameLayout.addView(textView, layoutParams);
        frameLayout.setVisibility(0);
    }
}
