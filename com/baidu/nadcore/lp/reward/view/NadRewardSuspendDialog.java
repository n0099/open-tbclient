package com.baidu.nadcore.lp.reward.view;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.b41;
import com.baidu.tieba.jn0;
import com.baidu.tieba.kn0;
import com.baidu.tieba.x31;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J!\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "", "handleDialogAutoDismiss", "()V", "initCommonView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "setDialogContentView", "Landroidx/fragment/app/FragmentManager;", "manager", "", "tag", "show", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "Ljava/lang/Runnable;", "dismissRunnable", "Ljava/lang/Runnable;", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadRewardSuspendDialog extends NadRewardVideoDialog {
    public Runnable s;
    public HashMap t;

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void E1() {
        HashMap hashMap = this.t;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        E1();
    }

    /* loaded from: classes2.dex */
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NadRewardSuspendDialog.this.dismiss();
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void X1() {
        super.X1();
        ViewGroup.LayoutParams layoutParams = U1().getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "topImg.layoutParams");
        layoutParams.height = b41.c.a(getContext(), 83.0f);
        U1().setLayoutParams(layoutParams);
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void h2() {
        TextView textView;
        TextView textView2;
        String str;
        boolean z;
        String str2;
        jn0 u;
        jn0 s;
        R1().setLayoutResource(R.layout.nad_reward_suspend_dialog_content);
        View inflate = R1().inflate();
        Intrinsics.checkNotNullExpressionValue(inflate, "dialogStub.inflate()");
        g2(inflate);
        View findViewById = P1().findViewById(R.id.close_img);
        Intrinsics.checkNotNullExpressionValue(findViewById, "dialogContent.findViewById(R.id.close_img)");
        AdImageView adImageView = (AdImageView) findViewById;
        View findViewById2 = P1().findViewById(R.id.obfuscated_res_0x7f0923f2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "dialogContent.findViewById(R.id.title)");
        TextView textView3 = (TextView) findViewById2;
        View findViewById3 = P1().findViewById(R.id.btn_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "dialogContent.findViewById(R.id.btn_container)");
        LinearLayout linearLayout = (LinearLayout) findViewById3;
        kn0 Q1 = Q1();
        String str3 = null;
        if (Q1 != null && (s = Q1.s()) != null) {
            textView = NadRewardVideoDialog.M1(this, s, null, null, "1", false, false, false, 118, null);
        } else {
            textView = null;
        }
        kn0 Q12 = Q1();
        if (Q12 != null && (u = Q12.u()) != null) {
            textView2 = NadRewardVideoDialog.M1(this, u, null, null, "2", false, false, false, 118, null);
        } else {
            textView2 = null;
        }
        kn0 Q13 = Q1();
        if (Q13 != null) {
            str = Q13.v();
        } else {
            str = null;
        }
        if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            kn0 Q14 = Q1();
            if (Q14 != null) {
                str2 = Q14.v();
            } else {
                str2 = null;
            }
            textView3.setText(str2);
            kn0 Q15 = Q1();
            if (Q15 != null) {
                str3 = Q15.y();
            }
            textView3.setTextColor(x31.a(str3, R.color.nad_reward_dialog_title_default));
        }
        if (textView2 != null) {
            textView2.setTypeface(Typeface.defaultFromStyle(1));
            textView2.setTextSize(1, 17.0f);
            textView2.setGravity(17);
            textView2.setHeight(b41.c.a(textView2.getContext(), 50.0f));
            textView2.setWidth(b41.c.a(textView2.getContext(), 219.0f));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = b41.c.a(textView2.getContext(), 10.0f);
            linearLayout.addView(textView2, 0, layoutParams);
        }
        if (textView != null) {
            textView.setTypeface(Typeface.defaultFromStyle(1));
            textView.setTextSize(1, 17.0f);
            textView.setGravity(17);
            textView.setHeight(b41.c.a(textView.getContext(), 50.0f));
            textView.setWidth(b41.c.a(textView.getContext(), 219.0f));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = b41.c.a(textView.getContext(), 10.0f);
            linearLayout.addView(textView, 0, layoutParams2);
        }
        W1(adImageView);
        o2();
    }

    public final void o2() {
        int i;
        String n;
        Integer intOrNull;
        kn0 Q1 = Q1();
        if (Q1 != null && Q1.F()) {
            kn0 Q12 = Q1();
            if (Q12 != null && (n = Q12.n()) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(n)) != null) {
                i = intOrNull.intValue();
            } else {
                i = -1;
            }
            if (i == -1) {
                return;
            }
            this.s = new a();
            Handler S1 = S1();
            Runnable runnable = this.s;
            Intrinsics.checkNotNull(runnable);
            S1.postDelayed(runnable, i * 1000);
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.obfuscated_res_0x7f1003e8);
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        try {
            super.show(manager, str);
        } catch (Exception unused) {
            dismiss();
        }
    }
}
