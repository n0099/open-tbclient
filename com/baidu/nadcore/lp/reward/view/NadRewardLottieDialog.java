package com.baidu.nadcore.lp.reward.view;

import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.d41;
import com.baidu.tieba.hq0;
import com.baidu.tieba.ln0;
import com.baidu.tieba.mn0;
import com.baidu.tieba.ql0;
import com.baidu.tieba.ul0;
import com.baidu.tieba.xl0;
import com.baidu.tieba.z31;
import com.baidu.tieba.zn0;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010\tJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\tJ\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\tJ\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\tJ\u0019\u0010\u0015\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\tJ\u0017\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "", "time", "", "generateTimeStr", "(Ljava/lang/Integer;)Ljava/lang/String;", "", "initCommonView", "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onDetach", "onStart", MissionEvent.MESSAGE_STOP, "registerBackForegroundEvent", "setCountDown", "(Ljava/lang/Integer;)V", "setDialogContentView", "Lcom/baidu/nadcore/model/LottieDialogRewardData;", "lottieRewardData", "setFestivalCoinData", "(Lcom/baidu/nadcore/model/LottieDialogRewardData;)V", "Landroid/widget/TextView;", "countDown", "Landroid/widget/TextView;", "Lcom/baidu/nadcore/lp/reward/util/MultipleStartCountDownTime;", "countDownComponent", "Lcom/baidu/nadcore/lp/reward/util/MultipleStartCountDownTime;", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadRewardLottieDialog extends NadRewardVideoDialog {
    public TextView s;
    public zn0 t;
    public HashMap u;

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void F1() {
        HashMap hashMap = this.u;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        F1();
    }

    /* loaded from: classes2.dex */
    public static final class a extends ul0<xl0> {
        public a(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ul0
        public void onEvent(xl0 event) {
            zn0 zn0Var;
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.a && (zn0Var = NadRewardLottieDialog.this.t) != null) {
                zn0Var.i();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends zn0 {
        public final /* synthetic */ Ref.IntRef k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref.IntRef intRef, long j, long j2) {
            super(j, j2);
            this.k = intRef;
        }

        @Override // com.baidu.tieba.zn0
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
                mn0 R1 = NadRewardLottieDialog.this.R1();
                if (R1 != null && (l = R1.l()) != null) {
                    str = StringsKt__StringsJVMKt.replace$default(l, "__REMAININGTIME__", NadRewardLottieDialog.this.s2(Integer.valueOf(this.k.element)), false, 4, (Object) null);
                } else {
                    str = null;
                }
                textView.setText(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            zn0 zn0Var = NadRewardLottieDialog.this.t;
            if (zn0Var != null) {
                zn0Var.n();
            }
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void Y1() {
        super.Y1();
        ViewGroup.LayoutParams layoutParams = V1().getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "topImg.layoutParams");
        layoutParams.height = d41.c.a(getContext(), 83.0f);
        V1().setLayoutParams(layoutParams);
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        hq0 r;
        int i;
        super.onDetach();
        mn0 R1 = R1();
        if (R1 != null && (r = R1.r()) != null) {
            zn0 zn0Var = this.t;
            if (zn0Var != null) {
                i = (int) (zn0Var.k() / 1000);
            } else {
                i = 0;
            }
            r.g(i);
        }
        ql0.a().unregister(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        zn0 zn0Var = this.t;
        if (zn0Var != null) {
            zn0Var.h();
        }
    }

    public final void t2() {
        ql0.a().b(this, new a(xl0.class));
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.obfuscated_res_0x7f1003e9);
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String str;
        Window window;
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        mn0 R1 = R1();
        if (R1 != null) {
            str = R1.m();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "1") && (window = onCreateDialog.getWindow()) != null) {
            window.setWindowAnimations(R.style.obfuscated_res_0x7f1003ea);
        }
        return onCreateDialog;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: char : ?: SGET   com.huawei.hms.common.internal.TransactionIdCreater.FILL_BYTE char), (r3v0 java.lang.Integer)] */
    public final String s2(Integer num) {
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

    public final void v2(hq0 hq0Var) {
        mn0 R1 = R1();
        if (R1 != null) {
            R1.J(hq0Var);
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void i2() {
        TextView textView;
        String str;
        boolean z;
        String str2;
        String str3;
        String str4;
        String str5;
        hq0 r;
        String str6;
        String l;
        Integer num;
        hq0 r2;
        hq0 r3;
        ln0 s;
        S1().setLayoutResource(R.layout.nad_reward_lottie_dialog_content);
        View inflate = S1().inflate();
        Intrinsics.checkNotNullExpressionValue(inflate, "dialogStub.inflate()");
        h2(inflate);
        View findViewById = Q1().findViewById(R.id.close_img);
        Intrinsics.checkNotNullExpressionValue(findViewById, "dialogContent.findViewById(R.id.close_img)");
        AdImageView adImageView = (AdImageView) findViewById;
        View findViewById2 = Q1().findViewById(R.id.obfuscated_res_0x7f09240b);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "dialogContent.findViewById(R.id.title)");
        TextView textView2 = (TextView) findViewById2;
        View findViewById3 = Q1().findViewById(R.id.coin_count);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "dialogContent.findViewById(R.id.coin_count)");
        TextView textView3 = (TextView) findViewById3;
        View findViewById4 = Q1().findViewById(R.id.coin_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "dialogContent.findViewById(R.id.coin_desc)");
        TextView textView4 = (TextView) findViewById4;
        View findViewById5 = Q1().findViewById(R.id.button_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "dialogContent.findViewById(R.id.button_container)");
        LinearLayout linearLayout = (LinearLayout) findViewById5;
        this.s = (TextView) Q1().findViewById(R.id.dialog_lottie_count_down);
        mn0 R1 = R1();
        Integer num2 = null;
        if (R1 != null && (s = R1.s()) != null) {
            String str7 = ClogBuilder.LogType.CLICK.type;
            Intrinsics.checkNotNullExpressionValue(str7, "ClogBuilder.LogType.CLICK.type");
            String str8 = ClogBuilder.Area.AD_BTN_DETAIL.type;
            Intrinsics.checkNotNullExpressionValue(str8, "ClogBuilder.Area.AD_BTN_DETAIL.type");
            textView = NadRewardVideoDialog.N1(this, s, str7, str8, "1", true, false, true, 32, null);
        } else {
            textView = null;
        }
        ViewGroup.LayoutParams layoutParams = P1().getLayoutParams();
        if (layoutParams != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.height = d41.c.c(getContext());
            layoutParams2.bottomMargin = ((d41.c.e(getContext()) / 2) + d41.c.a(getContext(), 42.0f)) * (-1);
            P1().setLayoutParams(layoutParams2);
            mn0 R12 = R1();
            if (R12 != null) {
                str = R12.v();
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
                mn0 R13 = R1();
                if (R13 != null) {
                    str2 = R13.v();
                } else {
                    str2 = null;
                }
                textView2.setText(str2);
                mn0 R14 = R1();
                if (R14 != null) {
                    str3 = R14.y();
                } else {
                    str3 = null;
                }
                textView2.setTextColor(z31.a(str3, R.color.nad_lottie_dialog_text_default));
            }
            mn0 R15 = R1();
            String str9 = "";
            textView3.setText((R15 == null || (r3 = R15.r()) == null || (r1 = r3.c()) == null) ? "" : "");
            mn0 R16 = R1();
            if (R16 != null) {
                str4 = R16.y();
            } else {
                str4 = null;
            }
            textView3.setTextColor(z31.a(str4, R.color.nad_lottie_dialog_text_default));
            mn0 R17 = R1();
            textView4.setText((R17 == null || (r1 = R17.i()) == null) ? "" : "");
            mn0 R18 = R1();
            if (R18 != null) {
                str5 = R18.y();
            } else {
                str5 = null;
            }
            textView4.setTextColor(z31.a(str5, R.color.nad_lottie_dialog_text_default));
            TextView textView5 = this.s;
            if (textView5 != null) {
                mn0 R19 = R1();
                if (R19 != null && (l = R19.l()) != null) {
                    mn0 R110 = R1();
                    if (R110 != null && (r2 = R110.r()) != null) {
                        num = Integer.valueOf(r2.e());
                    } else {
                        num = null;
                    }
                    String replace$default = StringsKt__StringsJVMKt.replace$default(l, "__REMAININGTIME__", s2(num), false, 4, (Object) null);
                    if (replace$default != null) {
                        str9 = replace$default;
                    }
                }
                textView5.setText(str9);
                mn0 R111 = R1();
                if (R111 != null) {
                    str6 = R111.y();
                } else {
                    str6 = null;
                }
                textView5.setTextColor(z31.a(str6, R.color.nad_lottie_dialog_text_default));
            }
            if (textView != null) {
                textView.setTypeface(Typeface.defaultFromStyle(1));
                textView.setTextSize(1, 17.0f);
                textView.setGravity(17);
                textView.setHeight(d41.c.a(textView.getContext(), 50.0f));
                textView.setWidth(d41.c.a(textView.getContext(), 219.0f));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.topMargin = d41.c.a(textView.getContext(), 16.0f);
                linearLayout.addView(textView, 0, layoutParams3);
            }
            X1(adImageView);
            mn0 R112 = R1();
            if (R112 != null && (r = R112.r()) != null) {
                num2 = Integer.valueOf(r.e());
            }
            u2(num2);
            t2();
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
        n2(getContext());
    }

    public final void u2(Integer num) {
        Ref.IntRef intRef = new Ref.IntRef();
        if (num != null) {
            int intValue = num.intValue();
            intRef.element = intValue;
            this.t = new b(intRef, TimeUnit.SECONDS.toMillis(intValue), 1000L);
            T1().removeCallbacksAndMessages(null);
            T1().postDelayed(new c(), 1000L);
        }
    }
}
