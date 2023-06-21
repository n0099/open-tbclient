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
import com.baidu.tieba.d61;
import com.baidu.tieba.hs0;
import com.baidu.tieba.lp0;
import com.baidu.tieba.mp0;
import com.baidu.tieba.qn0;
import com.baidu.tieba.un0;
import com.baidu.tieba.xn0;
import com.baidu.tieba.z51;
import com.baidu.tieba.zp0;
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
    public zp0 t;
    public HashMap u;

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void H1() {
        HashMap hashMap = this.u;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H1();
    }

    /* loaded from: classes3.dex */
    public static final class a extends un0<xn0> {
        public a(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.un0
        public void onEvent(xn0 event) {
            zp0 zp0Var;
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.a && (zp0Var = NadRewardLottieDialog.this.t) != null) {
                zp0Var.i();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends zp0 {
        public final /* synthetic */ Ref.IntRef k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref.IntRef intRef, long j, long j2) {
            super(j, j2);
            this.k = intRef;
        }

        @Override // com.baidu.tieba.zp0
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
                mp0 T1 = NadRewardLottieDialog.this.T1();
                if (T1 != null && (l = T1.l()) != null) {
                    str = StringsKt__StringsJVMKt.replace$default(l, "__REMAININGTIME__", NadRewardLottieDialog.this.u2(Integer.valueOf(this.k.element)), false, 4, (Object) null);
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
            zp0 zp0Var = NadRewardLottieDialog.this.t;
            if (zp0Var != null) {
                zp0Var.n();
            }
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void a2() {
        super.a2();
        ViewGroup.LayoutParams layoutParams = X1().getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "topImg.layoutParams");
        layoutParams.height = d61.c.a(getContext(), 83.0f);
        X1().setLayoutParams(layoutParams);
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        hs0 r;
        int i;
        super.onDetach();
        mp0 T1 = T1();
        if (T1 != null && (r = T1.r()) != null) {
            zp0 zp0Var = this.t;
            if (zp0Var != null) {
                i = (int) (zp0Var.k() / 1000);
            } else {
                i = 0;
            }
            r.g(i);
        }
        qn0.a().unregister(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        zp0 zp0Var = this.t;
        if (zp0Var != null) {
            zp0Var.h();
        }
    }

    public final void v2() {
        qn0.a().b(this, new a(xn0.class));
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.obfuscated_res_0x7f1003fe);
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String str;
        Window window;
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        mp0 T1 = T1();
        if (T1 != null) {
            str = T1.m();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "1") && (window = onCreateDialog.getWindow()) != null) {
            window.setWindowAnimations(R.style.obfuscated_res_0x7f1003ff);
        }
        return onCreateDialog;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: char : ?: SGET   com.huawei.hms.common.internal.TransactionIdCreater.FILL_BYTE char), (r3v0 java.lang.Integer)] */
    public final String u2(Integer num) {
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

    public final void x2(hs0 hs0Var) {
        mp0 T1 = T1();
        if (T1 != null) {
            T1.J(hs0Var);
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void k2() {
        TextView textView;
        String str;
        boolean z;
        String str2;
        String str3;
        String str4;
        String str5;
        hs0 r;
        String str6;
        String l;
        Integer num;
        hs0 r2;
        hs0 r3;
        lp0 s;
        U1().setLayoutResource(R.layout.nad_reward_lottie_dialog_content);
        View inflate = U1().inflate();
        Intrinsics.checkNotNullExpressionValue(inflate, "dialogStub.inflate()");
        j2(inflate);
        View findViewById = S1().findViewById(R.id.close_img);
        Intrinsics.checkNotNullExpressionValue(findViewById, "dialogContent.findViewById(R.id.close_img)");
        AdImageView adImageView = (AdImageView) findViewById;
        View findViewById2 = S1().findViewById(R.id.obfuscated_res_0x7f0924ae);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "dialogContent.findViewById(R.id.title)");
        TextView textView2 = (TextView) findViewById2;
        View findViewById3 = S1().findViewById(R.id.coin_count);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "dialogContent.findViewById(R.id.coin_count)");
        TextView textView3 = (TextView) findViewById3;
        View findViewById4 = S1().findViewById(R.id.coin_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "dialogContent.findViewById(R.id.coin_desc)");
        TextView textView4 = (TextView) findViewById4;
        View findViewById5 = S1().findViewById(R.id.button_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "dialogContent.findViewById(R.id.button_container)");
        LinearLayout linearLayout = (LinearLayout) findViewById5;
        this.s = (TextView) S1().findViewById(R.id.dialog_lottie_count_down);
        mp0 T1 = T1();
        Integer num2 = null;
        if (T1 != null && (s = T1.s()) != null) {
            String str7 = ClogBuilder.LogType.CLICK.type;
            Intrinsics.checkNotNullExpressionValue(str7, "ClogBuilder.LogType.CLICK.type");
            String str8 = ClogBuilder.Area.AD_BTN_DETAIL.type;
            Intrinsics.checkNotNullExpressionValue(str8, "ClogBuilder.Area.AD_BTN_DETAIL.type");
            textView = NadRewardVideoDialog.P1(this, s, str7, str8, "1", true, false, true, 32, null);
        } else {
            textView = null;
        }
        ViewGroup.LayoutParams layoutParams = R1().getLayoutParams();
        if (layoutParams != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.height = d61.c.c(getContext());
            layoutParams2.bottomMargin = ((d61.c.e(getContext()) / 2) + d61.c.a(getContext(), 42.0f)) * (-1);
            R1().setLayoutParams(layoutParams2);
            mp0 T12 = T1();
            if (T12 != null) {
                str = T12.v();
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
                mp0 T13 = T1();
                if (T13 != null) {
                    str2 = T13.v();
                } else {
                    str2 = null;
                }
                textView2.setText(str2);
                mp0 T14 = T1();
                if (T14 != null) {
                    str3 = T14.y();
                } else {
                    str3 = null;
                }
                textView2.setTextColor(z51.a(str3, R.color.nad_lottie_dialog_text_default));
            }
            mp0 T15 = T1();
            String str9 = "";
            textView3.setText((T15 == null || (r3 = T15.r()) == null || (r1 = r3.c()) == null) ? "" : "");
            mp0 T16 = T1();
            if (T16 != null) {
                str4 = T16.y();
            } else {
                str4 = null;
            }
            textView3.setTextColor(z51.a(str4, R.color.nad_lottie_dialog_text_default));
            mp0 T17 = T1();
            textView4.setText((T17 == null || (r1 = T17.i()) == null) ? "" : "");
            mp0 T18 = T1();
            if (T18 != null) {
                str5 = T18.y();
            } else {
                str5 = null;
            }
            textView4.setTextColor(z51.a(str5, R.color.nad_lottie_dialog_text_default));
            TextView textView5 = this.s;
            if (textView5 != null) {
                mp0 T19 = T1();
                if (T19 != null && (l = T19.l()) != null) {
                    mp0 T110 = T1();
                    if (T110 != null && (r2 = T110.r()) != null) {
                        num = Integer.valueOf(r2.e());
                    } else {
                        num = null;
                    }
                    String replace$default = StringsKt__StringsJVMKt.replace$default(l, "__REMAININGTIME__", u2(num), false, 4, (Object) null);
                    if (replace$default != null) {
                        str9 = replace$default;
                    }
                }
                textView5.setText(str9);
                mp0 T111 = T1();
                if (T111 != null) {
                    str6 = T111.y();
                } else {
                    str6 = null;
                }
                textView5.setTextColor(z51.a(str6, R.color.nad_lottie_dialog_text_default));
            }
            if (textView != null) {
                textView.setTypeface(Typeface.defaultFromStyle(1));
                textView.setTextSize(1, 17.0f);
                textView.setGravity(17);
                textView.setHeight(d61.c.a(textView.getContext(), 50.0f));
                textView.setWidth(d61.c.a(textView.getContext(), 219.0f));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.topMargin = d61.c.a(textView.getContext(), 16.0f);
                linearLayout.addView(textView, 0, layoutParams3);
            }
            Z1(adImageView);
            mp0 T112 = T1();
            if (T112 != null && (r = T112.r()) != null) {
                num2 = Integer.valueOf(r.e());
            }
            w2(num2);
            v2();
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
        p2(getContext());
    }

    public final void w2(Integer num) {
        Ref.IntRef intRef = new Ref.IntRef();
        if (num != null) {
            int intValue = num.intValue();
            intRef.element = intValue;
            this.t = new b(intRef, TimeUnit.SECONDS.toMillis(intValue), 1000L);
            V1().removeCallbacksAndMessages(null);
            V1().postDelayed(new c(), 1000L);
        }
    }
}
