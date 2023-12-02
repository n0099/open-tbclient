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
import com.baidu.tieba.aj0;
import com.baidu.tieba.bl0;
import com.baidu.tieba.gl0;
import com.baidu.tieba.ok0;
import com.baidu.tieba.pk0;
import com.baidu.tieba.s11;
import com.baidu.tieba.ti0;
import com.baidu.tieba.w11;
import com.baidu.tieba.wn0;
import com.baidu.tieba.xi0;
import com.baidu.tieba.xk0;
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
    public gl0 t;
    public HashMap u;

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void G2() {
        HashMap hashMap = this.u;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        G2();
    }

    /* loaded from: classes3.dex */
    public static final class a extends xi0<aj0> {
        public a(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi0
        public void onEvent(aj0 event) {
            gl0 gl0Var;
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.a && (gl0Var = NadRewardLottieDialog.this.t) != null) {
                gl0Var.i();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends gl0 {
        public final /* synthetic */ Ref.IntRef k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref.IntRef intRef, long j, long j2) {
            super(j, j2);
            this.k = intRef;
        }

        @Override // com.baidu.tieba.gl0
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
                pk0 Q2 = NadRewardLottieDialog.this.Q2();
                if (Q2 != null && (l = Q2.l()) != null) {
                    str = StringsKt__StringsJVMKt.replace$default(l, "__REMAININGTIME__", NadRewardLottieDialog.this.r3(Integer.valueOf(this.k.element)), false, 4, (Object) null);
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
            gl0 gl0Var = NadRewardLottieDialog.this.t;
            if (gl0Var != null) {
                gl0Var.n();
            }
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void X2() {
        super.X2();
        ViewGroup.LayoutParams layoutParams = U2().getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "topImg.layoutParams");
        layoutParams.height = w11.c.a(getContext(), 83.0f);
        U2().setLayoutParams(layoutParams);
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        wn0 r;
        int i;
        super.onDetach();
        pk0 Q2 = Q2();
        if (Q2 != null && (r = Q2.r()) != null) {
            gl0 gl0Var = this.t;
            if (gl0Var != null) {
                i = (int) (gl0Var.k() / 1000);
            } else {
                i = 0;
            }
            r.g(i);
        }
        ti0.a().a(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        gl0 gl0Var = this.t;
        if (gl0Var != null) {
            gl0Var.h();
        }
    }

    public final void s3() {
        ti0.a().c(this, new a(aj0.class));
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.obfuscated_res_0x7f100406);
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String str;
        Window window;
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        pk0 Q2 = Q2();
        if (Q2 != null) {
            str = Q2.m();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "1") && (window = onCreateDialog.getWindow()) != null) {
            window.setWindowAnimations(R.style.obfuscated_res_0x7f100407);
        }
        return onCreateDialog;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: char : ?: SGET   com.huawei.hms.common.internal.TransactionIdCreater.FILL_BYTE char), (r3v0 java.lang.Integer)] */
    public final String r3(Integer num) {
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

    public final void u3(wn0 wn0Var) {
        pk0 Q2 = Q2();
        if (Q2 != null) {
            Q2.H(wn0Var);
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void h3() {
        AdImageView adImageView;
        LinearLayout linearLayout;
        TextView textView;
        String str;
        boolean z;
        String str2;
        String str3;
        String str4;
        String str5;
        wn0 r;
        String str6;
        String l;
        Integer num;
        wn0 r2;
        wn0 r3;
        ok0 s;
        ViewStub R2 = R2();
        xk0 a2 = bl0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        R2.setLayoutResource(a2.C());
        View inflate = R2().inflate();
        Intrinsics.checkNotNullExpressionValue(inflate, "dialogStub.inflate()");
        g3(inflate);
        Resources resources = getResources();
        xk0 a3 = bl0.a();
        Intrinsics.checkNotNullExpressionValue(a3, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension = resources.getDimension(a3.l());
        View findViewById = P2().findViewById(R.id.close_img);
        Intrinsics.checkNotNullExpressionValue(findViewById, "dialogContent.findViewById(R.id.close_img)");
        AdImageView adImageView2 = (AdImageView) findViewById;
        View findViewById2 = P2().findViewById(R.id.obfuscated_res_0x7f092685);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "dialogContent.findViewById(R.id.title)");
        TextView textView2 = (TextView) findViewById2;
        View findViewById3 = P2().findViewById(R.id.coin_count);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "dialogContent.findViewById(R.id.coin_count)");
        TextView textView3 = (TextView) findViewById3;
        View findViewById4 = P2().findViewById(R.id.coin_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "dialogContent.findViewById(R.id.coin_desc)");
        TextView textView4 = (TextView) findViewById4;
        View findViewById5 = P2().findViewById(R.id.button_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "dialogContent.findViewById(R.id.button_container)");
        LinearLayout linearLayout2 = (LinearLayout) findViewById5;
        this.s = (TextView) P2().findViewById(R.id.dialog_lottie_count_down);
        pk0 Q2 = Q2();
        Integer num2 = null;
        if (Q2 != null && (s = Q2.s()) != null) {
            String str7 = ClogBuilder.LogType.CLICK.type;
            Intrinsics.checkNotNullExpressionValue(str7, "ClogBuilder.LogType.CLICK.type");
            String str8 = ClogBuilder.Area.AD_BTN_DETAIL.type;
            Intrinsics.checkNotNullExpressionValue(str8, "ClogBuilder.Area.AD_BTN_DETAIL.type");
            adImageView = adImageView2;
            linearLayout = linearLayout2;
            textView = NadRewardVideoDialog.N2(this, s, str7, str8, "1", true, false, true, 32, null);
        } else {
            adImageView = adImageView2;
            linearLayout = linearLayout2;
            textView = null;
        }
        ViewGroup.LayoutParams layoutParams = O2().getLayoutParams();
        if (layoutParams != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.height = w11.c.c(getContext());
            layoutParams2.bottomMargin = ((w11.c.e(getContext()) / 2) + w11.c.a(getContext(), 42.0f)) * (-1);
            O2().setLayoutParams(layoutParams2);
            pk0 Q22 = Q2();
            if (Q22 != null) {
                str = Q22.v();
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
                pk0 Q23 = Q2();
                if (Q23 != null) {
                    str2 = Q23.v();
                } else {
                    str2 = null;
                }
                textView2.setText(str2);
                pk0 Q24 = Q2();
                if (Q24 != null) {
                    str3 = Q24.y();
                } else {
                    str3 = null;
                }
                textView2.setTextColor(s11.a(str3, R.color.nad_lottie_dialog_text_default));
            }
            pk0 Q25 = Q2();
            String str9 = "";
            textView3.setText((Q25 == null || (r3 = Q25.r()) == null || (r1 = r3.c()) == null) ? "" : "");
            pk0 Q26 = Q2();
            if (Q26 != null) {
                str4 = Q26.y();
            } else {
                str4 = null;
            }
            textView3.setTextColor(s11.a(str4, R.color.nad_lottie_dialog_text_default));
            pk0 Q27 = Q2();
            textView4.setText((Q27 == null || (r1 = Q27.i()) == null) ? "" : "");
            pk0 Q28 = Q2();
            if (Q28 != null) {
                str5 = Q28.y();
            } else {
                str5 = null;
            }
            textView4.setTextColor(s11.a(str5, R.color.nad_lottie_dialog_text_default));
            TextView textView5 = this.s;
            if (textView5 != null) {
                pk0 Q29 = Q2();
                if (Q29 != null && (l = Q29.l()) != null) {
                    pk0 Q210 = Q2();
                    if (Q210 != null && (r2 = Q210.r()) != null) {
                        num = Integer.valueOf(r2.e());
                    } else {
                        num = null;
                    }
                    String replace$default = StringsKt__StringsJVMKt.replace$default(l, "__REMAININGTIME__", r3(num), false, 4, (Object) null);
                    if (replace$default != null) {
                        str9 = replace$default;
                    }
                }
                textView5.setText(str9);
                pk0 Q211 = Q2();
                if (Q211 != null) {
                    str6 = Q211.y();
                } else {
                    str6 = null;
                }
                textView5.setTextColor(s11.a(str6, R.color.nad_lottie_dialog_text_default));
            }
            if (textView != null) {
                textView.setTypeface(Typeface.defaultFromStyle(1));
                textView.setTextSize(0, dimension);
                textView.setGravity(17);
                linearLayout.addView(textView, 0, new LinearLayout.LayoutParams(-1, -1));
            }
            W2(adImageView);
            pk0 Q212 = Q2();
            if (Q212 != null && (r = Q212.r()) != null) {
                num2 = Integer.valueOf(r.e());
            }
            t3(num2);
            s3();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
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
        m3(getContext());
    }

    public final void t3(Integer num) {
        Ref.IntRef intRef = new Ref.IntRef();
        if (num != null) {
            int intValue = num.intValue();
            intRef.element = intValue;
            this.t = new b(intRef, TimeUnit.SECONDS.toMillis(intValue), 1000L);
            S2().removeCallbacksAndMessages(null);
            S2().postDelayed(new c(), 1000L);
        }
    }
}
