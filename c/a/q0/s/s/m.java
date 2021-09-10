package c.a.q0.s.s;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f14479a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TBAlertConfig.a f14480e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f14481f;

        public a(TBAlertConfig.a aVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14480e = aVar;
            this.f14481f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                View.OnClickListener onClickListener = this.f14480e.f47486c;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                View.OnClickListener onClickListener2 = this.f14481f;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f14482a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f14483b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-555936782, "Lc/a/q0/s/s/m$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-555936782, "Lc/a/q0/s/s/m$b;");
                    return;
                }
            }
            int[] iArr = new int[TBAlertConfig.OperateBtnStyle.values().length];
            f14483b = iArr;
            try {
                iArr[TBAlertConfig.OperateBtnStyle.MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14483b[TBAlertConfig.OperateBtnStyle.ALERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14483b[TBAlertConfig.OperateBtnStyle.FORCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14483b[TBAlertConfig.OperateBtnStyle.SECONDARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[TBAlertConfig.OperateType.values().length];
            f14482a = iArr2;
            try {
                iArr2[TBAlertConfig.OperateType.ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14482a[TBAlertConfig.OperateType.TWO.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14482a[TBAlertConfig.OperateType.THREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1644112432, "Lc/a/q0/s/s/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1644112432, "Lc/a/q0/s/s/m;");
                return;
            }
        }
        f14479a = c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds96);
    }

    public static TextView a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            TextView textView = new TextView(context);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(textView);
            d2.A(R.dimen.T_X07);
            d2.y(R.color.CAM_X0301);
            d2.B(R.string.F_X01);
            d2.m(R.dimen.L_X02);
            d2.l(R.color.CAM_X0301);
            d2.o(R.string.J_X07);
            d2.i(17170445);
            textView.setMaxLines(1);
            textView.setSingleLine();
            textView.setGravity(17);
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView b(Activity activity, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, activity, z)) == null) ? z ? c(activity) : d(activity) : (TextView) invokeLZ.objValue;
    }

    public static TextView c(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            EMTextView eMTextView = new EMTextView(context);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(eMTextView);
            d2.A(R.dimen.T_X07);
            d2.x(R.dimen.M_T_X002);
            d2.w(R.color.CAM_X0107);
            d2.B(R.string.F_X01);
            return eMTextView;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            EMTextView eMTextView = new EMTextView(context);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(eMTextView);
            d2.A(R.dimen.T_X07);
            d2.x(R.dimen.M_T_X002);
            d2.w(R.color.CAM_X0108);
            d2.B(R.string.F_X01);
            return eMTextView;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            TextView textView = new TextView(context);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(textView);
            d2.A(R.dimen.T_X07);
            d2.y(R.color.CAM_X0101);
            d2.B(R.string.F_X01);
            d2.o(R.string.J_X07);
            d2.i(R.color.CAM_X0303);
            textView.setMaxLines(1);
            textView.setSingleLine();
            textView.setGravity(17);
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView f(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            TextView textView = new TextView(context);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(textView);
            d2.A(R.dimen.T_X07);
            d2.y(R.color.CAM_X0304);
            d2.B(R.string.F_X01);
            d2.m(R.dimen.L_X02);
            d2.l(R.color.CAM_X0304);
            d2.k(R.string.A_X07);
            d2.o(R.string.J_X07);
            d2.i(17170445);
            textView.setMaxLines(1);
            textView.setSingleLine();
            textView.setGravity(17);
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    public static View g(@NonNull Context context, @NonNull TBAlertConfig.a aVar, @Nullable View.OnClickListener onClickListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, aVar, onClickListener)) == null) ? h(context, aVar, onClickListener, false) : (View) invokeLLL.objValue;
    }

    public static View h(@NonNull Context context, @NonNull TBAlertConfig.a aVar, @Nullable View.OnClickListener onClickListener, boolean z) {
        InterceptResult invokeCommon;
        TextView f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, aVar, onClickListener, Boolean.valueOf(z)})) == null) {
            int i2 = b.f14483b[aVar.f47485b.ordinal()];
            if (i2 == 1) {
                f2 = f(context);
            } else if (i2 == 2) {
                f2 = a(context);
            } else if (i2 != 3) {
                f2 = i2 != 4 ? null : j(context);
            } else {
                f2 = e(context);
            }
            f2.setText(aVar.f47484a);
            if (z) {
                c.a.q0.s.u.c.d(f2).A(R.dimen.T_X08);
            }
            f2.setOnClickListener(new a(aVar, onClickListener));
            return f2;
        }
        return (View) invokeCommon.objValue;
    }

    public static View i(@NonNull Context context, @NonNull TBAlertConfig.b bVar, @Nullable View.OnClickListener onClickListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, context, bVar, onClickListener)) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setPadding(0, c.a.e.e.p.l.g(context, R.dimen.M_H_X008), 0, c.a.e.e.p.l.g(context, R.dimen.M_H_X008));
            linearLayout.setGravity(17);
            int i2 = b.f14482a[bVar.f47487a.ordinal()];
            boolean z = true;
            if (i2 == 1) {
                linearLayout.setOrientation(0);
                linearLayout.setWeightSum(837.0f);
                View g2 = g(context, bVar.f47488b, onClickListener);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, f14479a);
                layoutParams.weight = 494.0f;
                linearLayout.addView(g2, layoutParams);
            } else if (i2 == 2) {
                linearLayout.setOrientation(0);
                if (bVar.f47488b.f47484a.length() <= 6 && bVar.f47489c.f47484a.length() <= 6) {
                    z = false;
                }
                View h2 = h(context, bVar.f47488b, onClickListener, z);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, f14479a);
                layoutParams2.setMargins(c.a.e.e.p.l.g(context, R.dimen.M_W_X012), 0, c.a.e.e.p.l.g(context, R.dimen.M_W_X006) / 2, 0);
                layoutParams2.weight = 1.0f;
                linearLayout.addView(h2, layoutParams2);
                View h3 = h(context, bVar.f47489c, onClickListener, z);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, f14479a);
                layoutParams3.setMargins(c.a.e.e.p.l.g(context, R.dimen.M_W_X006) / 2, 0, c.a.e.e.p.l.g(context, R.dimen.M_W_X012), 0);
                layoutParams3.weight = 1.0f;
                linearLayout.addView(h3, layoutParams3);
            } else if (i2 == 3) {
                linearLayout.setOrientation(1);
                View g3 = g(context, bVar.f47488b, onClickListener);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, f14479a);
                layoutParams4.setMargins(c.a.e.e.p.l.g(context, R.dimen.M_W_X012), 0, c.a.e.e.p.l.g(context, R.dimen.M_W_X012), c.a.e.e.p.l.g(context, R.dimen.M_H_X005));
                linearLayout.addView(g3, layoutParams4);
                View g4 = g(context, bVar.f47489c, onClickListener);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, f14479a);
                layoutParams5.setMargins(c.a.e.e.p.l.g(context, R.dimen.M_W_X012), 0, c.a.e.e.p.l.g(context, R.dimen.M_W_X012), c.a.e.e.p.l.g(context, R.dimen.M_H_X005));
                linearLayout.addView(g4, layoutParams5);
                View g5 = g(context, bVar.f47490d, onClickListener);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, f14479a);
                layoutParams6.setMargins(c.a.e.e.p.l.g(context, R.dimen.M_W_X012), 0, c.a.e.e.p.l.g(context, R.dimen.M_W_X012), 0);
                linearLayout.addView(g5, layoutParams6);
            }
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            return linearLayout;
        }
        return (View) invokeLLL.objValue;
    }

    public static TextView j(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            TextView textView = new TextView(context);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(textView);
            d2.A(R.dimen.T_X07);
            d2.y(R.color.CAM_X0105);
            d2.B(R.string.F_X01);
            d2.m(R.dimen.L_X02);
            d2.l(R.color.CAM_X0902);
            d2.o(R.string.J_X07);
            d2.i(17170445);
            textView.setMaxLines(1);
            textView.setSingleLine();
            textView.setGravity(17);
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView k(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            EMTextView eMTextView = new EMTextView(context);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(eMTextView);
            d2.A(R.dimen.T_X05);
            d2.w(R.color.CAM_X0105);
            d2.B(R.string.F_X02);
            eMTextView.setMaxLines(1);
            eMTextView.setSingleLine();
            eMTextView.setGravity(17);
            return eMTextView;
        }
        return (TextView) invokeL.objValue;
    }
}
