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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.b51;
import com.baidu.tieba.bp0;
import com.baidu.tieba.ir0;
import com.baidu.tieba.no0;
import com.baidu.tieba.oo0;
import com.baidu.tieba.sm0;
import com.baidu.tieba.wm0;
import com.baidu.tieba.y41;
import com.baidu.tieba.zm0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010\tJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\tJ\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\tJ\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\tJ\u0019\u0010\u0015\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\tJ\u0017\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "", "time", "", "generateTimeStr", "(Ljava/lang/Integer;)Ljava/lang/String;", "", "initCommonView", "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onDetach", "onStart", MissionEvent.MESSAGE_STOP, "registerBackForegroundEvent", "setCountDown", "(Ljava/lang/Integer;)V", "setDialogContentView", "Lcom/baidu/nadcore/model/LottieDialogRewardData;", "lottieRewardData", "setFestivalCoinData", "(Lcom/baidu/nadcore/model/LottieDialogRewardData;)V", "Landroid/widget/TextView;", "countDown", "Landroid/widget/TextView;", "Lcom/baidu/nadcore/lp/reward/util/MultipleStartCountDownTime;", "countDownComponent", "Lcom/baidu/nadcore/lp/reward/util/MultipleStartCountDownTime;", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadRewardLottieDialog extends NadRewardVideoDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView s;
    public bp0 t;
    public HashMap u;

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void C1() {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hashMap = this.u) == null) {
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
    public static final class a extends wm0<zm0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardLottieDialog b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NadRewardLottieDialog nadRewardLottieDialog, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardLottieDialog, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nadRewardLottieDialog;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wm0
        public void onEvent(zm0 event) {
            bp0 bp0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (event.a && (bp0Var = this.b.t) != null) {
                    bp0Var.h();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends bp0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardLottieDialog j;
        public final /* synthetic */ Ref.IntRef k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(NadRewardLottieDialog nadRewardLottieDialog, Ref.IntRef intRef, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardLottieDialog, intRef, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = nadRewardLottieDialog;
            this.k = intRef;
        }

        @Override // com.baidu.tieba.bp0
        public void l(long j) {
            String str;
            String l;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                super.l(j);
                Ref.IntRef intRef = this.k;
                int i = intRef.element;
                if (i <= 0) {
                    return;
                }
                intRef.element = i - 1;
                TextView textView = this.j.s;
                if (textView != null) {
                    oo0 O1 = this.j.O1();
                    if (O1 != null && (l = O1.l()) != null) {
                        str = StringsKt__StringsJVMKt.replace$default(l, "__REMAININGTIME__", this.j.p2(Integer.valueOf(this.k.element)), false, 4, (Object) null);
                    } else {
                        str = null;
                    }
                    textView.setText(str);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardLottieDialog a;

        public c(NadRewardLottieDialog nadRewardLottieDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardLottieDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardLottieDialog;
        }

        @Override // java.lang.Runnable
        public final void run() {
            bp0 bp0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bp0Var = this.a.t) != null) {
                bp0Var.m();
            }
        }
    }

    public NadRewardLottieDialog() {
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStop();
            bp0 bp0Var = this.t;
            if (bp0Var != null) {
                bp0Var.g();
            }
        }
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            sm0.a().b(this, new a(this, zm0.class));
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setStyle(0, R.style.obfuscated_res_0x7f1003e1);
        }
    }

    public final void s2(ir0 ir0Var) {
        oo0 O1;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, ir0Var) == null) && (O1 = O1()) != null) {
            O1.J(ir0Var);
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

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        ir0 r;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetach();
            oo0 O1 = O1();
            if (O1 != null && (r = O1.r()) != null) {
                bp0 bp0Var = this.t;
                if (bp0Var != null) {
                    i = (int) (bp0Var.j() / 1000);
                } else {
                    i = 0;
                }
                r.g(i);
            }
            sm0.a().unregister(this);
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog
    public void f2() {
        TextView textView;
        String str;
        boolean z;
        String str2;
        String str3;
        String str4;
        String str5;
        ir0 r;
        String str6;
        String l;
        Integer num;
        ir0 r2;
        ir0 r3;
        no0 s;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            P1().setLayoutResource(R.layout.nad_reward_lottie_dialog_content);
            View inflate = P1().inflate();
            Intrinsics.checkNotNullExpressionValue(inflate, "dialogStub.inflate()");
            e2(inflate);
            View findViewById = N1().findViewById(R.id.close_img);
            Intrinsics.checkNotNullExpressionValue(findViewById, "dialogContent.findViewById(R.id.close_img)");
            AdImageView adImageView = (AdImageView) findViewById;
            View findViewById2 = N1().findViewById(R.id.obfuscated_res_0x7f09235a);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "dialogContent.findViewById(R.id.title)");
            TextView textView2 = (TextView) findViewById2;
            View findViewById3 = N1().findViewById(R.id.coin_count);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "dialogContent.findViewById(R.id.coin_count)");
            TextView textView3 = (TextView) findViewById3;
            View findViewById4 = N1().findViewById(R.id.coin_desc);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "dialogContent.findViewById(R.id.coin_desc)");
            TextView textView4 = (TextView) findViewById4;
            View findViewById5 = N1().findViewById(R.id.button_container);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "dialogContent.findViewById(R.id.button_container)");
            LinearLayout linearLayout = (LinearLayout) findViewById5;
            this.s = (TextView) N1().findViewById(R.id.dialog_lottie_count_down);
            oo0 O1 = O1();
            Integer num2 = null;
            if (O1 != null && (s = O1.s()) != null) {
                String str7 = ClogBuilder.LogType.CLICK.type;
                Intrinsics.checkNotNullExpressionValue(str7, "ClogBuilder.LogType.CLICK.type");
                String str8 = ClogBuilder.Area.AD_BTN_DETAIL.type;
                Intrinsics.checkNotNullExpressionValue(str8, "ClogBuilder.Area.AD_BTN_DETAIL.type");
                textView = NadRewardVideoDialog.K1(this, s, str7, str8, "1", true, false, true, 32, null);
            } else {
                textView = null;
            }
            ViewGroup.LayoutParams layoutParams = M1().getLayoutParams();
            if (layoutParams != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.height = b51.c.c(getContext());
                layoutParams2.bottomMargin = ((b51.c.e(getContext()) / 2) + b51.c.a(getContext(), 42.0f)) * (-1);
                M1().setLayoutParams(layoutParams2);
                oo0 O12 = O1();
                if (O12 != null) {
                    str = O12.v();
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
                    oo0 O13 = O1();
                    if (O13 != null) {
                        str2 = O13.v();
                    } else {
                        str2 = null;
                    }
                    textView2.setText(str2);
                    oo0 O14 = O1();
                    if (O14 != null) {
                        str3 = O14.y();
                    } else {
                        str3 = null;
                    }
                    textView2.setTextColor(y41.a(str3, R.color.nad_lottie_dialog_text_default));
                }
                oo0 O15 = O1();
                String str9 = "";
                textView3.setText((O15 == null || (r3 = O15.r()) == null || (r1 = r3.c()) == null) ? "" : "");
                oo0 O16 = O1();
                if (O16 != null) {
                    str4 = O16.y();
                } else {
                    str4 = null;
                }
                textView3.setTextColor(y41.a(str4, R.color.nad_lottie_dialog_text_default));
                oo0 O17 = O1();
                textView4.setText((O17 == null || (r1 = O17.i()) == null) ? "" : "");
                oo0 O18 = O1();
                if (O18 != null) {
                    str5 = O18.y();
                } else {
                    str5 = null;
                }
                textView4.setTextColor(y41.a(str5, R.color.nad_lottie_dialog_text_default));
                TextView textView5 = this.s;
                if (textView5 != null) {
                    oo0 O19 = O1();
                    if (O19 != null && (l = O19.l()) != null) {
                        oo0 O110 = O1();
                        if (O110 != null && (r2 = O110.r()) != null) {
                            num = Integer.valueOf(r2.e());
                        } else {
                            num = null;
                        }
                        String replace$default = StringsKt__StringsJVMKt.replace$default(l, "__REMAININGTIME__", p2(num), false, 4, (Object) null);
                        if (replace$default != null) {
                            str9 = replace$default;
                        }
                    }
                    textView5.setText(str9);
                    oo0 O111 = O1();
                    if (O111 != null) {
                        str6 = O111.y();
                    } else {
                        str6 = null;
                    }
                    textView5.setTextColor(y41.a(str6, R.color.nad_lottie_dialog_text_default));
                }
                if (textView != null) {
                    textView.setTypeface(Typeface.defaultFromStyle(1));
                    textView.setTextSize(1, 17.0f);
                    textView.setGravity(17);
                    textView.setHeight(b51.c.a(textView.getContext(), 50.0f));
                    textView.setWidth(b51.c.a(textView.getContext(), 219.0f));
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams3.topMargin = b51.c.a(textView.getContext(), 16.0f);
                    linearLayout.addView(textView, 0, layoutParams3);
                }
                U1(adImageView);
                oo0 O112 = O1();
                if (O112 != null && (r = O112.r()) != null) {
                    num2 = Integer.valueOf(r.e());
                }
                r2(num2);
                q2();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        InterceptResult invokeL;
        String str;
        Window window;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bundle)) == null) {
            Dialog onCreateDialog = super.onCreateDialog(bundle);
            oo0 O1 = O1();
            if (O1 != null) {
                str = O1.m();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, "1") && (window = onCreateDialog.getWindow()) != null) {
                window.setWindowAnimations(R.style.obfuscated_res_0x7f1003e2);
            }
            return onCreateDialog;
        }
        return (Dialog) invokeL.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('0' char), (r5v0 java.lang.Integer)] */
    public final String p2(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, num)) == null) {
            if (num != null) {
                num.intValue();
                if (num.intValue() < 10) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('0');
                    sb.append(num);
                    return sb.toString();
                }
                return String.valueOf(num.intValue());
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public final void r2(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, num) == null) {
            Ref.IntRef intRef = new Ref.IntRef();
            if (num != null) {
                int intValue = num.intValue();
                intRef.element = intValue;
                this.t = new b(this, intRef, TimeUnit.SECONDS.toMillis(intValue), 1000L);
                Q1().removeCallbacksAndMessages(null);
                Q1().postDelayed(new c(this), 1000L);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        WindowManager.LayoutParams layoutParams;
        Window window;
        Window window2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
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
            k2(getContext());
        }
    }
}
