package com.baidu.nadcore.lp.reward.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
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
import com.baidu.tieba.d61;
import com.baidu.tieba.ep0;
import com.baidu.tieba.fp0;
import com.baidu.tieba.ik0;
import com.baidu.tieba.lp0;
import com.baidu.tieba.mp0;
import com.baidu.tieba.o31;
import com.baidu.tieba.uj0;
import com.baidu.tieba.zj0;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0010\u0018\u00002\u00020\u0001:\u0002\u009a\u0001B\b¢\u0006\u0005\b\u0099\u0001\u0010\u0014JQ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0011J\u0015\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001d\u0010\u0014J+\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00122\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010%J\u0019\u0010(\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b(\u0010)J\u0019\u0010+\u001a\u00020*2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b+\u0010,J+\u00102\u001a\u0002012\u0006\u0010.\u001a\u00020-2\b\u00100\u001a\u0004\u0018\u00010/2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0012H\u0016¢\u0006\u0004\b4\u0010\u0014J\u0015\u00107\u001a\u00020\u00122\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J\u0015\u0010:\u001a\u00020\u00122\u0006\u00106\u001a\u000209¢\u0006\u0004\b:\u0010;J#\u0010=\u001a\u00020\u00122\u0014\u00106\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00120<¢\u0006\u0004\b=\u0010>J\u001f\u0010A\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0012H\u0016¢\u0006\u0004\bC\u0010\u0014J\u001b\u0010E\u001a\u00020\u00122\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00120D¢\u0006\u0004\bE\u0010FJ\u0015\u0010G\u001a\u00020\u00122\u0006\u00106\u001a\u000209¢\u0006\u0004\bG\u0010;J\u001b\u0010I\u001a\u00020\u00122\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00120D¢\u0006\u0004\bI\u0010FJ\u001b\u0010J\u001a\u00020\u00122\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00120D¢\u0006\u0004\bJ\u0010FJ!\u0010N\u001a\u00020\u00122\u0006\u0010L\u001a\u00020K2\b\u0010M\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\bN\u0010OJ\u0017\u0010R\u001a\u00020\u00122\b\u0010Q\u001a\u0004\u0018\u00010P¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\u0012H\u0002¢\u0006\u0004\bT\u0010\u0014J\u001b\u0010V\u001a\u00020\u0012*\u00020\f2\u0006\u00100\u001a\u00020UH\u0002¢\u0006\u0004\bV\u0010WR\u0018\u0010X\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010Z\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R&\u0010\\\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0012\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\"\u0010_\u001a\u00020^8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010e\u001a\u0002018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010l\u001a\u0004\u0018\u00010k8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001e\u0010r\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\"\u0010u\u001a\u00020t8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\"\u0010{\u001a\u00020\u00198\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0004\b\u007f\u0010\u001cR\u001a\u0010\u0080\u0001\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010[R%\u0010@\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b@\u0010\u0081\u0001\u001a\u0005\b\u0082\u0001\u0010\u0016\"\u0005\b\u0083\u0001\u0010%R \u0010\u0084\u0001\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010sR*\u0010\u0086\u0001\u001a\u00030\u0085\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R&\u0010\u008c\u0001\u001a\u0002018\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b\u008c\u0001\u0010f\u001a\u0005\b\u008d\u0001\u0010h\"\u0005\b\u008e\u0001\u0010jR \u0010\u008f\u0001\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010sR&\u0010\u0090\u0001\u001a\u00020\u00198\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b\u0090\u0001\u0010|\u001a\u0005\b\u0091\u0001\u0010~\"\u0005\b\u0092\u0001\u0010\u001cR)\u0010\u0093\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001¨\u0006\u009b\u0001"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "Landroidx/fragment/app/DialogFragment;", "Lcom/baidu/nadcore/lp/reward/data/NadDialogButtonData;", "buttonData", "", "type", DnsModel.AREA_KEY, "btnIndex", "", "shouldCharge", "closeDialog", "isLottieDialogMainBtn", "Landroid/widget/TextView;", "buildButton", "(Lcom/baidu/nadcore/lp/reward/data/NadDialogButtonData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)Landroid/widget/TextView;", "scheme", "checkRewardPanelPop", "(Ljava/lang/String;)Z", "", "dismiss", "()V", "getTaskCenterPolicy", "()Ljava/lang/String;", "btnCmd", "handleLocalCmd", "Lcom/baidu/nadcore/widget/AdImageView;", "icon", "initCloseIcon", "(Lcom/baidu/nadcore/widget/AdImageView;)V", "initCommonView", "logWelfareDialog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/DialogInterface;", "dialog", GameAssistConstKt.TYPE_CALLBACK_CANCEL, "(Landroid/content/DialogInterface;)V", "onConvertClick", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onDetach", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog$DialogClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAfterClickListener", "(Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog$DialogClickListener;)V", "Landroid/view/View$OnClickListener;", "setCloseBtnClickListener", "(Landroid/view/View$OnClickListener;)V", "Lkotlin/Function1;", "setConvertClickListener", "(Lkotlin/Function1;)V", "rewardDataJson", "ext", "setData", "(Ljava/lang/String;Ljava/lang/String;)V", "setDialogContentView", "Lkotlin/Function0;", "setDialogDismissListener", "(Lkotlin/Function0;)V", "setDownloadBtnClickListener", WebChromeClient.KEY_ARG_CALLBACK, "setLottieBtnClkListener", "setSuspendRightAnsListener", "Landroidx/fragment/app/FragmentManager;", "manager", "tag", "show", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "Landroid/content/Context;", "context", "startBgLottie", "(Landroid/content/Context;)V", "stopAnimation", "Landroid/widget/FrameLayout;", "setBottomBtnStyle", "(Landroid/widget/TextView;Landroid/widget/FrameLayout;)V", "afterClickListener", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog$DialogClickListener;", "closeBtnClickListener", "Landroid/view/View$OnClickListener;", "convertClickListener", "Lkotlin/Function1;", "Lcom/airbnb/lottie/LottieAnimationView;", "dialogBgLottie", "Lcom/airbnb/lottie/LottieAnimationView;", "getDialogBgLottie", "()Lcom/airbnb/lottie/LottieAnimationView;", "setDialogBgLottie", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "dialogContent", "Landroid/view/View;", "getDialogContent", "()Landroid/view/View;", "setDialogContent", "(Landroid/view/View;)V", "Lcom/baidu/nadcore/lp/reward/data/NadRewardDialogData;", "dialogData", "Lcom/baidu/nadcore/lp/reward/data/NadRewardDialogData;", "getDialogData", "()Lcom/baidu/nadcore/lp/reward/data/NadRewardDialogData;", "setDialogData", "(Lcom/baidu/nadcore/lp/reward/data/NadRewardDialogData;)V", "dialogDismissListener", "Lkotlin/Function0;", "Landroid/view/ViewStub;", "dialogStub", "Landroid/view/ViewStub;", "getDialogStub", "()Landroid/view/ViewStub;", "setDialogStub", "(Landroid/view/ViewStub;)V", "dialogTopImg", "Lcom/baidu/nadcore/widget/AdImageView;", "getDialogTopImg", "()Lcom/baidu/nadcore/widget/AdImageView;", "setDialogTopImg", "downloadBtnClickListener", "Ljava/lang/String;", "getExt", "setExt", "lottieBtnClickListener", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "setMainHandler", "(Landroid/os/Handler;)V", "rootContainerView", "getRootContainerView", "setRootContainerView", "suspendRightAnsListener", "topImg", "getTopImg", "setTopImg", "upperLimit", "Z", "getUpperLimit", "()Z", "setUpperLimit", "(Z)V", "<init>", "DialogClickListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
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
    public mp0 n;
    public Handler o = new Handler(Looper.getMainLooper());
    public String p = "";
    public boolean q;
    public HashMap r;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public void H1() {
        HashMap hashMap = this.r;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H1();
    }

    /* loaded from: classes3.dex */
    public static final class b implements fp0 {
        public final /* synthetic */ Context a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ TextView c;

        @Override // com.baidu.tieba.fp0
        public void a() {
        }

        public b(Context context, Context context2, TextView textView) {
            this.a = context;
            this.b = context2;
            this.c = textView;
        }

        @Override // com.baidu.tieba.fp0
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
    public static final class c implements fp0 {
        public final /* synthetic */ Context a;
        public final /* synthetic */ View b;

        @Override // com.baidu.tieba.fp0
        public void a() {
        }

        public c(Context context, View view2) {
            this.a = context;
            this.b = view2;
        }

        @Override // com.baidu.tieba.fp0
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
        public final /* synthetic */ lp0 e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ boolean g;

        public d(String str, String str2, String str3, lp0 lp0Var, boolean z, boolean z2) {
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = lp0Var;
            this.f = z;
            this.g = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            a aVar;
            String str;
            NadRewardVideoDialog.this.b2(this.b, this.c, this.d);
            if (!NadRewardVideoDialog.this.Y1(this.e.b())) {
                if (!NadRewardVideoDialog.this.Q1(this.e.b())) {
                    uj0.c(this.e.b(), NadRewardVideoDialog.this.getContext());
                } else {
                    Function1 function1 = NadRewardVideoDialog.this.k;
                    if (function1 != null) {
                        mp0 T1 = NadRewardVideoDialog.this.T1();
                        if (T1 != null) {
                            str = T1.k();
                        } else {
                            str = null;
                        }
                        Unit unit = (Unit) function1.invoke(str);
                    }
                }
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
            NadRewardVideoDialog.c2(nadRewardVideoDialog, str, "close", null, 4, null);
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
            nadRewardVideoDialog.d2(str);
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
            nadRewardVideoDialog.d2(str);
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
            nadRewardVideoDialog.d2(str);
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
            NadRewardVideoDialog.this.R1().setComposition(lottieComposition);
            NadRewardVideoDialog.this.R1().playAnimation();
            NadRewardVideoDialog.this.R1().setVisibility(0);
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
            NadRewardVideoDialog.this.R1().setVisibility(8);
        }
    }

    public final LottieAnimationView R1() {
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogBgLottie");
        }
        return lottieAnimationView;
    }

    public final View S1() {
        View view2 = this.f;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        return view2;
    }

    public final mp0 T1() {
        return this.n;
    }

    public final ViewStub U1() {
        ViewStub viewStub = this.e;
        if (viewStub == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogStub");
        }
        return viewStub;
    }

    public final Handler V1() {
        return this.o;
    }

    public final AdImageView X1() {
        AdImageView adImageView = this.b;
        if (adImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topImg");
        }
        return adImageView;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        Function0<Unit> function0 = this.h;
        if (function0 != null) {
            function0.invoke();
        }
        this.o.removeCallbacksAndMessages(null);
        q2();
    }

    public final void q2() {
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

    public final void f2(TextView textView, FrameLayout frameLayout) {
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setTextSize(1, 14.0f);
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

    public void i2(String rewardDataJson, String ext) {
        Intrinsics.checkNotNullParameter(rewardDataJson, "rewardDataJson");
        Intrinsics.checkNotNullParameter(ext, "ext");
        mp0 mp0Var = new mp0(rewardDataJson);
        this.n = mp0Var;
        this.p = ext;
        Intrinsics.checkNotNull(mp0Var);
        this.q = mp0Var.A();
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
        c2(this, str2, null, null, 6, null);
    }

    public final boolean Q1(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z || !ik0.o(str)) {
            return false;
        }
        return Intrinsics.areEqual(new zj0(str).a(), "rewardWebPanel");
    }

    public final void e2(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.j = listener;
    }

    public final void g2(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.g = listener;
    }

    public final void h2(Function1<? super String, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.k = listener;
    }

    public final void j2(View view2) {
        Intrinsics.checkNotNullParameter(view2, "<set-?>");
        this.f = view2;
    }

    public final void l2(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.h = listener;
    }

    public final void m2(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.i = listener;
    }

    public final void n2(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.m = callback;
    }

    public final void o2(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.l = callback;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        String str = ClogBuilder.LogType.FREE_CLICK.type;
        Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
        c2(this, str, "blank", null, 4, null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.obfuscated_res_0x7f1003e5);
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

    public final void p2(Context context) {
        String str;
        int i2;
        if (context != null) {
            q2();
            mp0 mp0Var = this.n;
            if (mp0Var != null) {
                str = mp0Var.c();
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

    public static /* synthetic */ TextView P1(NadRewardVideoDialog nadRewardVideoDialog, lp0 lp0Var, String str, String str2, String str3, boolean z, boolean z2, boolean z3, int i2, Object obj) {
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
            return nadRewardVideoDialog.O1(lp0Var, str4, str5, str6, z4, z5, z6);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildButton");
    }

    public static /* synthetic */ void c2(NadRewardVideoDialog nadRewardVideoDialog, String str, String str2, String str3, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                str2 = "";
            }
            if ((i2 & 4) != 0) {
                str3 = "";
            }
            nadRewardVideoDialog.b2(str, str2, str3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logWelfareDialog");
    }

    public final TextView O1(lp0 buttonData, String type, String area, String btnIndex, boolean z, boolean z2, boolean z3) {
        boolean z4;
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(buttonData, "buttonData");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(btnIndex, "btnIndex");
        TextView textView = new TextView(getContext());
        String a2 = buttonData.a();
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        boolean z5 = true;
        if (a2 != null && a2.length() != 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!z4) {
            ep0.a().c(a2, new c(context, textView));
        }
        if (!TextUtils.isEmpty(buttonData.e())) {
            textView.setTextColor(Color.parseColor(buttonData.e()));
        }
        Context context2 = getContext();
        if (context2 != null) {
            String c2 = buttonData.c();
            if (c2 != null && c2.length() != 0) {
                z5 = false;
            }
            if (!z5) {
                ep0.a().c(c2, new b(context2, context2, textView));
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

    public final String W1() {
        String q;
        mp0 mp0Var;
        String w;
        String replace$default;
        mp0 mp0Var2 = this.n;
        byte[] bArr = null;
        if (mp0Var2 != null && (q = mp0Var2.q()) != null && (mp0Var = this.n) != null && (w = mp0Var.w()) != null && (replace$default = StringsKt__StringsJVMKt.replace$default(w, "__INVOKECOIN__", q, false, 4, (Object) null)) != null) {
            Charset charset = Charsets.UTF_8;
            if (replace$default != null) {
                byte[] bytes = replace$default.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                bArr = bytes;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        byte[] B64Encode = Base64Encoder.B64Encode(bArr);
        Intrinsics.checkNotNullExpressionValue(B64Encode, "Base64Encoder.B64Encode(…yteArray()\n            })");
        return new String(B64Encode, Charsets.UTF_8);
    }

    public final boolean Y1(String str) {
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
                        mp0 mp0Var = this.n;
                        if (mp0Var != null) {
                            str2 = mp0Var.t();
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
                        mp0 mp0Var2 = this.n;
                        if (mp0Var2 != null) {
                            str2 = mp0Var2.B();
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

    public final void Z1(AdImageView icon) {
        String str;
        boolean z;
        Intrinsics.checkNotNullParameter(icon, "icon");
        mp0 mp0Var = this.n;
        String str2 = null;
        if (mp0Var != null) {
            str = mp0Var.h();
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
            mp0 mp0Var2 = this.n;
            if (mp0Var2 != null) {
                str2 = mp0Var2.h();
            }
            icon.o(str2);
        }
        icon.setOnClickListener(new e());
    }

    public void a2() {
        boolean z;
        boolean z2;
        mp0 mp0Var = this.n;
        if (mp0Var != null) {
            AdImageView adImageView = this.b;
            if (adImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topImg");
            }
            String z3 = mp0Var.z();
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
                adImageView.o(mp0Var.z());
            }
            AdImageView adImageView3 = this.c;
            if (adImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogTopImg");
            }
            String o = mp0Var.o();
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
                adImageView2.o(mp0Var.o());
            }
            View view2 = this.f;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TL_BR);
            gradientDrawable.setCornerRadius(d61.c.a(getContext(), 18.0f));
            gradientDrawable.setColors(new int[]{mp0Var.d(), mp0Var.b()});
            gradientDrawable.setStroke(d61.c.a(getContext(), 2.0f), mp0Var.e());
            Unit unit = Unit.INSTANCE;
            view2.setBackground(gradientDrawable);
        }
    }

    public final void b2(String str, String str2, String str3) {
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
            mp0 mp0Var = this.n;
            if (mp0Var != null) {
                str4 = mp0Var.p();
            } else {
                str4 = null;
            }
            clogBuilder.l(String.valueOf(str4));
            o31.b(clogBuilder);
        }
    }

    public final void d2(String str) {
        String str2;
        String str3;
        View.OnClickListener onClickListener;
        String str4 = ClogBuilder.LogType.CLICK.type;
        Intrinsics.checkNotNullExpressionValue(str4, "ClogBuilder.LogType.CLICK.type");
        c2(this, str4, str, null, 4, null);
        a aVar = this.j;
        if (aVar != null) {
            aVar.a();
        }
        mp0 mp0Var = this.n;
        if (mp0Var != null && mp0Var.E()) {
            mp0 mp0Var2 = this.n;
            if (mp0Var2 != null && mp0Var2.D() && (onClickListener = this.i) != null) {
                onClickListener.onClick(getView());
            }
            dismiss();
            return;
        }
        mp0 mp0Var3 = this.n;
        String str5 = null;
        if (mp0Var3 != null && mp0Var3.C()) {
            mp0 mp0Var4 = this.n;
            if (mp0Var4 != null) {
                str2 = mp0Var4.k();
            } else {
                str2 = null;
            }
            if (!Q1(str2)) {
                mp0 mp0Var5 = this.n;
                if (mp0Var5 != null) {
                    str3 = mp0Var5.k();
                } else {
                    str3 = null;
                }
                uj0.c(str3, getContext());
            }
        }
        Function1<? super String, Unit> function1 = this.k;
        if (function1 != null) {
            mp0 mp0Var6 = this.n;
            if (mp0Var6 != null) {
                str5 = mp0Var6.k();
            }
            function1.invoke(str5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x023d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k2() {
        View view2;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        AdImageView adImageView;
        LinearLayout linearLayout;
        TextView textView;
        LinearLayout linearLayout2;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        mp0 mp0Var;
        TextView textView7;
        TextView textView8;
        mp0 mp0Var2;
        String str;
        int i2;
        boolean z;
        int i3;
        mp0 mp0Var3;
        String str2;
        boolean z2;
        mp0 mp0Var4;
        String str3;
        boolean z3;
        TextView textView9;
        boolean z4;
        LinearLayout linearLayout3;
        String str4;
        String str5;
        lp0 f2;
        lp0 g2;
        mp0 mp0Var5;
        lp0 g3;
        String b2;
        lp0 s;
        lp0 j2;
        String str6;
        boolean z5;
        ViewStub viewStub = this.e;
        if (viewStub == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogStub");
        }
        viewStub.setLayoutResource(R.layout.nad_reward_video_dialog_content);
        ViewStub viewStub2 = this.e;
        if (viewStub2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogStub");
        }
        View inflate = viewStub2.inflate();
        Intrinsics.checkNotNullExpressionValue(inflate, "dialogStub.inflate()");
        this.f = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        View findViewById = inflate.findViewById(R.id.close_img);
        Intrinsics.checkNotNullExpressionValue(findViewById, "dialogContent.findViewById(R.id.close_img)");
        AdImageView adImageView2 = (AdImageView) findViewById;
        View view3 = this.f;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        View findViewById2 = view3.findViewById(R.id.obfuscated_res_0x7f090314);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "dialogContent.findViewById(R.id.avatar)");
        AdImageView adImageView3 = (AdImageView) findViewById2;
        View view4 = this.f;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        View findViewById3 = view4.findViewById(R.id.obfuscated_res_0x7f0924ae);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "dialogContent.findViewById(R.id.title)");
        TextView textView10 = (TextView) findViewById3;
        View view5 = this.f;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        View findViewById4 = view5.findViewById(R.id.obfuscated_res_0x7f092224);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "dialogContent.findViewById(R.id.sub_title)");
        TextView textView11 = (TextView) findViewById4;
        View view6 = this.f;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        View findViewById5 = view6.findViewById(R.id.button_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "dialogContent.findViewById(R.id.button_container)");
        LinearLayout linearLayout4 = (LinearLayout) findViewById5;
        View view7 = this.f;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        View findViewById6 = view7.findViewById(R.id.bottom_btn_container);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "dialogContent.findViewBy….id.bottom_btn_container)");
        LinearLayout linearLayout5 = (LinearLayout) findViewById6;
        View view8 = this.f;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        View findViewById7 = view8.findViewById(R.id.left_container);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "dialogContent.findViewById(R.id.left_container)");
        FrameLayout frameLayout3 = (FrameLayout) findViewById7;
        View view9 = this.f;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        View findViewById8 = view9.findViewById(R.id.right_container);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "dialogContent.findViewById(R.id.right_container)");
        FrameLayout frameLayout4 = (FrameLayout) findViewById8;
        View view10 = this.f;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        }
        View findViewById9 = view10.findViewById(R.id.bottom_divider);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "dialogContent.findViewById(R.id.bottom_divider)");
        mp0 mp0Var6 = this.n;
        String str7 = null;
        if (mp0Var6 != null && (j2 = mp0Var6.j()) != null) {
            mp0 mp0Var7 = this.n;
            Intrinsics.checkNotNull(mp0Var7);
            boolean z6 = !mp0Var7.D();
            mp0 mp0Var8 = this.n;
            Intrinsics.checkNotNull(mp0Var8);
            if (mp0Var8.D()) {
                str6 = ClogBuilder.LogType.FREE_CLICK.type;
            } else {
                str6 = ClogBuilder.LogType.CLICK.type;
            }
            String str8 = str6;
            Intrinsics.checkNotNullExpressionValue(str8, "if (dialogData!!.isDownl…CK.type\n                }");
            String str9 = ClogBuilder.Area.AD_BTN_DETAIL.type;
            Intrinsics.checkNotNullExpressionValue(str9, "ClogBuilder.Area.AD_BTN_DETAIL.type");
            mp0 mp0Var9 = this.n;
            Intrinsics.checkNotNull(mp0Var9);
            if (!mp0Var9.D()) {
                mp0 mp0Var10 = this.n;
                Intrinsics.checkNotNull(mp0Var10);
                if (!mp0Var10.E()) {
                    z5 = false;
                    view2 = findViewById9;
                    frameLayout = frameLayout4;
                    frameLayout2 = frameLayout3;
                    adImageView = adImageView2;
                    linearLayout = linearLayout5;
                    textView = P1(this, j2, str8, str9, null, z6, z5, false, 72, null);
                }
            }
            z5 = true;
            view2 = findViewById9;
            frameLayout = frameLayout4;
            frameLayout2 = frameLayout3;
            adImageView = adImageView2;
            linearLayout = linearLayout5;
            textView = P1(this, j2, str8, str9, null, z6, z5, false, 72, null);
        } else {
            view2 = findViewById9;
            frameLayout = frameLayout4;
            frameLayout2 = frameLayout3;
            adImageView = adImageView2;
            linearLayout = linearLayout5;
            textView = null;
        }
        mp0 mp0Var11 = this.n;
        if (mp0Var11 != null && (s = mp0Var11.s()) != null) {
            linearLayout2 = linearLayout;
            textView2 = textView;
            textView3 = P1(this, s, null, null, "1", false, false, false, 118, null);
        } else {
            linearLayout2 = linearLayout;
            textView2 = textView;
            textView3 = null;
        }
        if (!this.q) {
            mp0 mp0Var12 = this.n;
            if (mp0Var12 != null && mp0Var12.w() != null && (mp0Var5 = this.n) != null && (g3 = mp0Var5.g()) != null && (b2 = g3.b()) != null) {
                StringsKt__StringsJVMKt.replace$default(b2, "__TASKCENTERPOLICY__", W1(), false, 4, (Object) null);
            }
            mp0 mp0Var13 = this.n;
            if (mp0Var13 != null && (g2 = mp0Var13.g()) != null) {
                textView4 = textView2;
                textView5 = textView3;
                textView6 = P1(this, g2, null, null, "2", false, false, false, 118, null);
                mp0Var = this.n;
                if (mp0Var == null && (f2 = mp0Var.f()) != null) {
                    String str10 = ClogBuilder.Area.AD_LEAVE.type;
                    Intrinsics.checkNotNullExpressionValue(str10, "ClogBuilder.Area.AD_LEAVE.type");
                    textView7 = textView6;
                    textView8 = P1(this, f2, null, str10, null, false, false, false, 122, null);
                } else {
                    textView7 = textView6;
                    textView8 = null;
                }
                mp0Var2 = this.n;
                if (mp0Var2 == null) {
                    str = mp0Var2.a();
                } else {
                    str = null;
                }
                if (str == null && str.length() != 0) {
                    i2 = 1;
                    z = false;
                } else {
                    i2 = 1;
                    z = true;
                }
                if (!(!z)) {
                    i3 = 0;
                    adImageView3.setVisibility(0);
                } else {
                    i3 = 0;
                    adImageView3.setVisibility(8);
                    adImageView3 = null;
                }
                if (adImageView3 != null) {
                    mp0 mp0Var14 = this.n;
                    if (mp0Var14 != null) {
                        str5 = mp0Var14.a();
                    } else {
                        str5 = null;
                    }
                    adImageView3.o(str5);
                    adImageView3.setOnClickListener(new f());
                    Unit unit = Unit.INSTANCE;
                }
                mp0Var3 = this.n;
                if (mp0Var3 == null) {
                    str2 = mp0Var3.x();
                } else {
                    str2 = null;
                }
                if (str2 == null && !StringsKt__StringsJVMKt.isBlank(str2)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!(!z2)) {
                    textView10.setVisibility(i3);
                } else {
                    textView10.setVisibility(8);
                    textView10 = null;
                }
                if (textView10 != null) {
                    mp0 mp0Var15 = this.n;
                    if (mp0Var15 != null) {
                        str4 = mp0Var15.x();
                    } else {
                        str4 = null;
                    }
                    textView10.setText(str4);
                    textView10.setOnClickListener(new g());
                    Unit unit2 = Unit.INSTANCE;
                }
                mp0Var4 = this.n;
                if (mp0Var4 == null) {
                    str3 = mp0Var4.v();
                } else {
                    str3 = null;
                }
                if (str3 == null && str3.length() != 0) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (!(!z3)) {
                    textView11.setVisibility(i3);
                } else {
                    textView11.setVisibility(8);
                    textView11 = null;
                }
                if (textView11 != null) {
                    mp0 mp0Var16 = this.n;
                    if (mp0Var16 != null) {
                        str7 = mp0Var16.v();
                    }
                    textView11.setText(str7);
                    textView11.setOnClickListener(new h());
                    Unit unit3 = Unit.INSTANCE;
                }
                if (textView5 != null) {
                    textView5.setTypeface(Typeface.defaultFromStyle(i2));
                    textView5.setTextSize(i2, 17.0f);
                    textView5.setGravity(17);
                    textView5.setHeight(d61.c.a(textView5.getContext(), 50.0f));
                    textView5.setWidth(d61.c.a(textView5.getContext(), 219.0f));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.topMargin = d61.c.a(textView5.getContext(), 15.0f);
                    linearLayout4.addView(textView5, i3, layoutParams);
                    Unit unit4 = Unit.INSTANCE;
                }
                if (textView4 != null) {
                    TextView textView12 = textView4;
                    textView12.setTypeface(Typeface.defaultFromStyle(i2));
                    textView12.setTextSize(i2, 12.0f);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 17;
                    linearLayout4.addView(textView12, i3, layoutParams2);
                    Unit unit5 = Unit.INSTANCE;
                }
                textView9 = textView7;
                if (textView9 == null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (!z4) {
                    view2.setVisibility(i3);
                } else {
                    view2.setVisibility(8);
                }
                if (textView8 == null) {
                    f2(textView8, frameLayout2);
                    linearLayout3 = linearLayout2;
                    linearLayout3.setVisibility(i3);
                    Unit unit6 = Unit.INSTANCE;
                } else {
                    linearLayout3 = linearLayout2;
                }
                if (textView9 != null) {
                    f2(textView9, frameLayout);
                    linearLayout3.setVisibility(i3);
                    Unit unit7 = Unit.INSTANCE;
                }
                Z1(adImageView);
            }
        }
        textView4 = textView2;
        textView5 = textView3;
        textView6 = null;
        mp0Var = this.n;
        if (mp0Var == null) {
        }
        textView7 = textView6;
        textView8 = null;
        mp0Var2 = this.n;
        if (mp0Var2 == null) {
        }
        if (str == null) {
        }
        i2 = 1;
        z = true;
        if (!(!z)) {
        }
        if (adImageView3 != null) {
        }
        mp0Var3 = this.n;
        if (mp0Var3 == null) {
        }
        if (str2 == null) {
        }
        z2 = true;
        if (!(!z2)) {
        }
        if (textView10 != null) {
        }
        mp0Var4 = this.n;
        if (mp0Var4 == null) {
        }
        if (str3 == null) {
        }
        z3 = true;
        if (!(!z3)) {
        }
        if (textView11 != null) {
        }
        if (textView5 != null) {
        }
        if (textView4 != null) {
        }
        textView9 = textView7;
        if (textView9 == null) {
        }
        if (!z4) {
        }
        if (textView8 == null) {
        }
        if (textView9 != null) {
        }
        Z1(adImageView);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        boolean z = true;
        View rootView = inflater.inflate(R.layout.nad_reward_video_dialog, viewGroup, true);
        View findViewById = rootView.findViewById(R.id.obfuscated_res_0x7f091edb);
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
            k2();
            a2();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            return rootView;
        }
        dismiss();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return rootView;
    }
}
