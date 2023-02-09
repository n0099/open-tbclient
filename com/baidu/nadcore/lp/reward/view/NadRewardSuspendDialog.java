package com.baidu.nadcore.lp.reward.view;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.b51;
import com.baidu.tieba.no0;
import com.baidu.tieba.oo0;
import com.baidu.tieba.y41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J!\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "", "handleDialogAutoDismiss", "()V", "initCommonView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "setDialogContentView", "Landroidx/fragment/app/FragmentManager;", "manager", "", "tag", "show", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "Ljava/lang/Runnable;", "dismissRunnable", "Ljava/lang/Runnable;", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadRewardSuspendDialog extends NadRewardVideoDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable s;
    public HashMap t;

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void C1() {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hashMap = this.t) == null) {
            return;
        }
        hashMap.clear();
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        C1();
    }

    /* loaded from: classes2.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardSuspendDialog a;

        public a(NadRewardSuspendDialog nadRewardSuspendDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardSuspendDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardSuspendDialog;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.dismiss();
            }
        }
    }

    public NadRewardSuspendDialog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.V1();
            ViewGroup.LayoutParams layoutParams = S1().getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(layoutParams, "topImg.layoutParams");
            layoutParams.height = b51.c.a(getContext(), 83.0f);
            S1().setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void f2() {
        TextView textView;
        TextView textView2;
        String str;
        boolean z;
        String str2;
        no0 u;
        no0 s;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            P1().setLayoutResource(R.layout.nad_reward_suspend_dialog_content);
            View inflate = P1().inflate();
            Intrinsics.checkNotNullExpressionValue(inflate, "dialogStub.inflate()");
            e2(inflate);
            View findViewById = N1().findViewById(R.id.close_img);
            Intrinsics.checkNotNullExpressionValue(findViewById, "dialogContent.findViewById(R.id.close_img)");
            AdImageView adImageView = (AdImageView) findViewById;
            View findViewById2 = N1().findViewById(R.id.obfuscated_res_0x7f09235b);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "dialogContent.findViewById(R.id.title)");
            TextView textView3 = (TextView) findViewById2;
            View findViewById3 = N1().findViewById(R.id.btn_container);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "dialogContent.findViewById(R.id.btn_container)");
            LinearLayout linearLayout = (LinearLayout) findViewById3;
            oo0 O1 = O1();
            String str3 = null;
            if (O1 != null && (s = O1.s()) != null) {
                textView = NadRewardVideoDialog.K1(this, s, null, null, "1", false, false, false, 118, null);
            } else {
                textView = null;
            }
            oo0 O12 = O1();
            if (O12 != null && (u = O12.u()) != null) {
                textView2 = NadRewardVideoDialog.K1(this, u, null, null, "2", false, false, false, 118, null);
            } else {
                textView2 = null;
            }
            oo0 O13 = O1();
            if (O13 != null) {
                str = O13.v();
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
                oo0 O14 = O1();
                if (O14 != null) {
                    str2 = O14.v();
                } else {
                    str2 = null;
                }
                textView3.setText(str2);
                oo0 O15 = O1();
                if (O15 != null) {
                    str3 = O15.y();
                }
                textView3.setTextColor(y41.a(str3, R.color.nad_reward_dialog_title_default));
            }
            if (textView2 != null) {
                textView2.setTypeface(Typeface.defaultFromStyle(1));
                textView2.setTextSize(1, 17.0f);
                textView2.setGravity(17);
                textView2.setHeight(b51.c.a(textView2.getContext(), 50.0f));
                textView2.setWidth(b51.c.a(textView2.getContext(), 219.0f));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = b51.c.a(textView2.getContext(), 10.0f);
                linearLayout.addView(textView2, 0, layoutParams);
            }
            if (textView != null) {
                textView.setTypeface(Typeface.defaultFromStyle(1));
                textView.setTextSize(1, 17.0f);
                textView.setGravity(17);
                textView.setHeight(b51.c.a(textView.getContext(), 50.0f));
                textView.setWidth(b51.c.a(textView.getContext(), 219.0f));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.topMargin = b51.c.a(textView.getContext(), 10.0f);
                linearLayout.addView(textView, 0, layoutParams2);
            }
            U1(adImageView);
            m2();
        }
    }

    public final void m2() {
        oo0 O1;
        int i;
        String n;
        Integer intOrNull;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (O1 = O1()) != null && O1.F()) {
            oo0 O12 = O1();
            if (O12 != null && (n = O12.n()) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(n)) != null) {
                i = intOrNull.intValue();
            } else {
                i = -1;
            }
            if (i == -1) {
                return;
            }
            this.s = new a(this);
            Handler Q1 = Q1();
            Runnable runnable = this.s;
            Intrinsics.checkNotNull(runnable);
            Q1.postDelayed(runnable, i * 1000);
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setStyle(0, R.style.obfuscated_res_0x7f1003e1);
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, manager, str) == null) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            try {
                super.show(manager, str);
            } catch (Exception unused) {
                dismiss();
            }
        }
    }
}
