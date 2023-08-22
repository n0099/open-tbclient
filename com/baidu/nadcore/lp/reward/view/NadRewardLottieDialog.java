package com.baidu.nadcore.lp.reward.view;

import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.ap0;
import com.baidu.tieba.cs0;
import com.baidu.tieba.en0;
import com.baidu.tieba.i61;
import com.baidu.tieba.in0;
import com.baidu.tieba.ip0;
import com.baidu.tieba.ln0;
import com.baidu.tieba.m61;
import com.baidu.tieba.mp0;
import com.baidu.tieba.qp0;
import com.baidu.tieba.zo0;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010\tJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\tJ\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\tJ\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\tJ\u0019\u0010\u0015\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\tJ\u0017\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "", "time", "", "generateTimeStr", "(Ljava/lang/Integer;)Ljava/lang/String;", "", "initCommonView", "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onDetach", "onStart", MissionEvent.MESSAGE_STOP, "registerBackForegroundEvent", "setCountDown", "(Ljava/lang/Integer;)V", "setDialogContentView", "Lcom/baidu/nadcore/model/LottieDialogRewardData;", "lottieRewardData", "setFestivalCoinData", "(Lcom/baidu/nadcore/model/LottieDialogRewardData;)V", "Landroid/widget/TextView;", "countDown", "Landroid/widget/TextView;", "Lcom/baidu/nadcore/lp/reward/util/MultipleStartCountDownTime;", "countDownComponent", "Lcom/baidu/nadcore/lp/reward/util/MultipleStartCountDownTime;", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRewardLottieDialog extends NadRewardVideoDialog {
    public TextView s;
    public qp0 t;
    public HashMap u;

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void U1() {
        HashMap hashMap = this.u;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        U1();
    }

    /* loaded from: classes3.dex */
    public static final class a extends in0<ln0> {
        public a(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.in0
        public void onEvent(ln0 event) {
            qp0 qp0Var;
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.a && (qp0Var = NadRewardLottieDialog.this.t) != null) {
                qp0Var.i();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends qp0 {
        public final /* synthetic */ Ref.IntRef k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref.IntRef intRef, long j, long j2) {
            super(j, j2);
            this.k = intRef;
        }

        @Override // com.baidu.tieba.qp0
        public void m(long j) {
            String str;
            String l;
            super.m(j);
            Ref.IntRef intRef = this.k;
            int i = intRef.element;
            if (i <= 0) {
                return;
            }
            intRef.element = i - 1;
            TextView textView = NadRewardLottieDialog.this.s;
            if (textView != null) {
                ap0 g2 = NadRewardLottieDialog.this.g2();
                if (g2 != null && (l = g2.l()) != null) {
                    str = StringsKt__StringsJVMKt.replace$default(l, "__REMAININGTIME__", NadRewardLottieDialog.this.H2(Integer.valueOf(this.k.element)), false, 4, (Object) null);
                } else {
                    str = null;
                }
                textView.setText(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            qp0 qp0Var = NadRewardLottieDialog.this.t;
            if (qp0Var != null) {
                qp0Var.n();
            }
        }
    }

    public final void I2() {
        en0.a().b(this, new a(ln0.class));
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void n2() {
        super.n2();
        ViewGroup.LayoutParams layoutParams = k2().getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "topImg.layoutParams");
        layoutParams.height = m61.c.a(getContext(), 83.0f);
        k2().setLayoutParams(layoutParams);
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        cs0 r;
        int i;
        super.onDetach();
        ap0 g2 = g2();
        if (g2 != null && (r = g2.r()) != null) {
            qp0 qp0Var = this.t;
            if (qp0Var != null) {
                i = (int) (qp0Var.k() / 1000);
            } else {
                i = 0;
            }
            r.g(i);
        }
        en0.a().unregister(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        qp0 qp0Var = this.t;
        if (qp0Var != null) {
            qp0Var.h();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: char : ?: SGET   com.huawei.hms.common.internal.TransactionIdCreater.FILL_BYTE char), (r3v0 java.lang.Integer)] */
    public final String H2(Integer num) {
        if (num != null) {
            num.intValue();
            if (num.intValue() < 10) {
                StringBuilder sb = new StringBuilder();
                sb.append(TransactionIdCreater.FILL_BYTE);
                sb.append(num);
                return sb.toString();
            }
            return String.valueOf(num.intValue());
        }
        return "";
    }

    public final void K2(cs0 cs0Var) {
        ap0 g2 = g2();
        if (g2 != null) {
            g2.H(cs0Var);
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.obfuscated_res_0x7f100400);
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String str;
        Window window;
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        ap0 g2 = g2();
        if (g2 != null) {
            str = g2.m();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "1") && (window = onCreateDialog.getWindow()) != null) {
            window.setWindowAnimations(R.style.obfuscated_res_0x7f100401);
        }
        return onCreateDialog;
    }

    public final void J2(Integer num) {
        Ref.IntRef intRef = new Ref.IntRef();
        if (num != null) {
            int intValue = num.intValue();
            intRef.element = intValue;
            this.t = new b(intRef, TimeUnit.SECONDS.toMillis(intValue), 1000L);
            i2().removeCallbacksAndMessages(null);
            i2().postDelayed(new c(), 1000L);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        WindowManager.LayoutParams layoutParams;
        Window window;
        Window window2;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window2 = dialog.getWindow()) != null) {
            layoutParams = window2.getAttributes();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.gravity = 17;
        }
        if (layoutParams != null) {
            layoutParams.width = -1;
        }
        if (layoutParams != null) {
            layoutParams.height = -1;
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setAttributes(layoutParams);
        }
        C2(getContext());
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void x2() {
        AdImageView adImageView;
        LinearLayout linearLayout;
        TextView textView;
        String str;
        boolean z;
        String str2;
        String str3;
        String str4;
        String str5;
        cs0 r;
        String str6;
        String l;
        Integer num;
        cs0 r2;
        cs0 r3;
        zo0 s;
        ViewStub h2 = h2();
        ip0 a2 = mp0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        h2.setLayoutResource(a2.y());
        View inflate = h2().inflate();
        Intrinsics.checkNotNullExpressionValue(inflate, "dialogStub.inflate()");
        w2(inflate);
        Resources resources = getResources();
        ip0 a3 = mp0.a();
        Intrinsics.checkNotNullExpressionValue(a3, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension = resources.getDimension(a3.i());
        View findViewById = f2().findViewById(R.id.close_img);
        Intrinsics.checkNotNullExpressionValue(findViewById, "dialogContent.findViewById(R.id.close_img)");
        AdImageView adImageView2 = (AdImageView) findViewById;
        View findViewById2 = f2().findViewById(R.id.obfuscated_res_0x7f09258f);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "dialogContent.findViewById(R.id.title)");
        TextView textView2 = (TextView) findViewById2;
        View findViewById3 = f2().findViewById(R.id.coin_count);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "dialogContent.findViewById(R.id.coin_count)");
        TextView textView3 = (TextView) findViewById3;
        View findViewById4 = f2().findViewById(R.id.coin_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "dialogContent.findViewById(R.id.coin_desc)");
        TextView textView4 = (TextView) findViewById4;
        View findViewById5 = f2().findViewById(R.id.button_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "dialogContent.findViewById(R.id.button_container)");
        LinearLayout linearLayout2 = (LinearLayout) findViewById5;
        this.s = (TextView) f2().findViewById(R.id.dialog_lottie_count_down);
        ap0 g2 = g2();
        Integer num2 = null;
        if (g2 != null && (s = g2.s()) != null) {
            String str7 = ClogBuilder.LogType.CLICK.type;
            Intrinsics.checkNotNullExpressionValue(str7, "ClogBuilder.LogType.CLICK.type");
            String str8 = ClogBuilder.Area.AD_BTN_DETAIL.type;
            Intrinsics.checkNotNullExpressionValue(str8, "ClogBuilder.Area.AD_BTN_DETAIL.type");
            adImageView = adImageView2;
            linearLayout = linearLayout2;
            textView = NadRewardVideoDialog.c2(this, s, str7, str8, "1", true, false, true, 32, null);
        } else {
            adImageView = adImageView2;
            linearLayout = linearLayout2;
            textView = null;
        }
        ViewGroup.LayoutParams layoutParams = e2().getLayoutParams();
        if (layoutParams != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.height = m61.c.c(getContext());
            layoutParams2.bottomMargin = ((m61.c.e(getContext()) / 2) + m61.c.a(getContext(), 42.0f)) * (-1);
            e2().setLayoutParams(layoutParams2);
            ap0 g22 = g2();
            if (g22 != null) {
                str = g22.v();
            } else {
                str = null;
            }
            if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                ap0 g23 = g2();
                if (g23 != null) {
                    str2 = g23.v();
                } else {
                    str2 = null;
                }
                textView2.setText(str2);
                ap0 g24 = g2();
                if (g24 != null) {
                    str3 = g24.y();
                } else {
                    str3 = null;
                }
                textView2.setTextColor(i61.a(str3, R.color.nad_lottie_dialog_text_default));
            }
            ap0 g25 = g2();
            String str9 = "";
            textView3.setText((g25 == null || (r3 = g25.r()) == null || (r1 = r3.c()) == null) ? "" : "");
            ap0 g26 = g2();
            if (g26 != null) {
                str4 = g26.y();
            } else {
                str4 = null;
            }
            textView3.setTextColor(i61.a(str4, R.color.nad_lottie_dialog_text_default));
            ap0 g27 = g2();
            textView4.setText((g27 == null || (r1 = g27.i()) == null) ? "" : "");
            ap0 g28 = g2();
            if (g28 != null) {
                str5 = g28.y();
            } else {
                str5 = null;
            }
            textView4.setTextColor(i61.a(str5, R.color.nad_lottie_dialog_text_default));
            TextView textView5 = this.s;
            if (textView5 != null) {
                ap0 g29 = g2();
                if (g29 != null && (l = g29.l()) != null) {
                    ap0 g210 = g2();
                    if (g210 != null && (r2 = g210.r()) != null) {
                        num = Integer.valueOf(r2.e());
                    } else {
                        num = null;
                    }
                    String replace$default = StringsKt__StringsJVMKt.replace$default(l, "__REMAININGTIME__", H2(num), false, 4, (Object) null);
                    if (replace$default != null) {
                        str9 = replace$default;
                    }
                }
                textView5.setText(str9);
                ap0 g211 = g2();
                if (g211 != null) {
                    str6 = g211.y();
                } else {
                    str6 = null;
                }
                textView5.setTextColor(i61.a(str6, R.color.nad_lottie_dialog_text_default));
            }
            if (textView != null) {
                textView.setTypeface(Typeface.defaultFromStyle(1));
                textView.setTextSize(0, dimension);
                textView.setGravity(17);
                linearLayout.addView(textView, 0, new LinearLayout.LayoutParams(-1, -1));
            }
            m2(adImageView);
            ap0 g212 = g2();
            if (g212 != null && (r = g212.r()) != null) {
                num2 = Integer.valueOf(r.e());
            }
            J2(num2);
            I2();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
}
