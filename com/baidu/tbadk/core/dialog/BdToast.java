package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.d.f.p.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class BdToast {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<Toast> n;
    public static HashMap<DefaultIcon, Integer> o;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public Toast f29833b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f29834c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f29835d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29836e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f29837f;

    /* renamed from: g  reason: collision with root package name */
    public int f29838g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29839h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class DefaultIcon {
        public static final /* synthetic */ DefaultIcon[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DefaultIcon FAILURE;
        public static final DefaultIcon NOT;
        public static final DefaultIcon SUCCESS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(31898906, "Lcom/baidu/tbadk/core/dialog/BdToast$DefaultIcon;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(31898906, "Lcom/baidu/tbadk/core/dialog/BdToast$DefaultIcon;");
                    return;
                }
            }
            SUCCESS = new DefaultIcon("SUCCESS", 0);
            FAILURE = new DefaultIcon("FAILURE", 1);
            DefaultIcon defaultIcon = new DefaultIcon("NOT", 2);
            NOT = defaultIcon;
            $VALUES = new DefaultIcon[]{SUCCESS, FAILURE, defaultIcon};
        }

        public DefaultIcon(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static DefaultIcon valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DefaultIcon) Enum.valueOf(DefaultIcon.class, str) : (DefaultIcon) invokeL.objValue;
        }

        public static DefaultIcon[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DefaultIcon[]) $VALUES.clone() : (DefaultIcon[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-3450512, "Lcom/baidu/tbadk/core/dialog/BdToast;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-3450512, "Lcom/baidu/tbadk/core/dialog/BdToast;");
                return;
            }
        }
        HashMap<DefaultIcon, Integer> hashMap = new HashMap<>(2);
        o = hashMap;
        hashMap.put(DefaultIcon.SUCCESS, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f0809a1));
        o.put(DefaultIcon.FAILURE, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f08099f));
        o.put(DefaultIcon.NOT, 0);
    }

    public BdToast(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29838g = -1;
        this.f29839h = false;
        this.i = 16;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.a = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d022f, (ViewGroup) null);
        this.f29834c = viewGroup;
        this.f29835d = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09208b);
        this.f29836e = (TextView) this.f29834c.findViewById(R.id.obfuscated_res_0x7f09208e);
    }

    public static BdToast c(Context context, CharSequence charSequence) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, charSequence)) == null) {
            BdToast bdToast = new BdToast(context);
            bdToast.p(charSequence);
            bdToast.a();
            return bdToast;
        }
        return (BdToast) invokeLL.objValue;
    }

    public static BdToast d(Context context, CharSequence charSequence, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, context, charSequence, i)) == null) {
            BdToast bdToast = new BdToast(context);
            bdToast.p(charSequence);
            bdToast.j(i);
            bdToast.a();
            return bdToast;
        }
        return (BdToast) invokeLLI.objValue;
    }

    public static BdToast e(Context context, CharSequence charSequence, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, null, context, charSequence, i, i2)) == null) {
            BdToast bdToast = new BdToast(context);
            bdToast.p(charSequence);
            bdToast.j(i);
            bdToast.b(i2);
            return bdToast;
        }
        return (BdToast) invokeLLII.objValue;
    }

    public static BdToast f(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, context, charSequence, defaultIcon)) == null) {
            int intValue = o.get(defaultIcon).intValue();
            BdToast bdToast = new BdToast(context);
            bdToast.p(charSequence);
            bdToast.m(intValue, true);
            bdToast.a();
            return bdToast;
        }
        return (BdToast) invokeLLL.objValue;
    }

    public static BdToast g(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65542, null, context, charSequence, defaultIcon, i)) == null) {
            int intValue = o.get(defaultIcon).intValue();
            BdToast bdToast = new BdToast(context);
            bdToast.p(charSequence);
            bdToast.m(intValue, true);
            bdToast.j(i);
            bdToast.a();
            return bdToast;
        }
        return (BdToast) invokeLLLI.objValue;
    }

    public static BdToast h(Context context, CharSequence charSequence, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            BdToast bdToast = new BdToast(context);
            bdToast.p(charSequence);
            bdToast.m(i, z);
            bdToast.j(i2);
            bdToast.a();
            return bdToast;
        }
        return (BdToast) invokeCommon.objValue;
    }

    public static BdToast i(Context context, CharSequence charSequence, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, charSequence, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            BdToast bdToast = new BdToast(context);
            bdToast.p(charSequence);
            bdToast.m(i, z);
            bdToast.a();
            return bdToast;
        }
        return (BdToast) invokeCommon.objValue;
    }

    public BdToast a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Toast toast = new Toast(this.a);
            this.f29833b = toast;
            x.a(toast);
            s();
            int i = this.f29838g;
            if (i != -1) {
                if (this.f29839h) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f29835d, this.f29838g, R.color.CAM_X0101, null);
                } else {
                    SkinManager.setImageResource(this.f29835d, i);
                }
                this.f29835d.setVisibility(0);
            } else {
                this.f29835d.setVisibility(8);
            }
            this.f29834c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.a, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f29836e, R.color.CAM_X0101, 1);
            this.f29836e.setText(this.f29837f);
            this.f29833b.setGravity(this.i, this.k, this.l);
            this.f29833b.setDuration(this.j);
            r(this.m);
            this.f29833b.setView(this.f29834c);
            return this;
        }
        return (BdToast) invokeV.objValue;
    }

    public BdToast b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            this.f29833b = new Toast(this.a);
            s();
            int i2 = this.f29838g;
            if (i2 != -1) {
                if (this.f29839h) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f29835d, this.f29838g, R.color.CAM_X0101, null);
                } else {
                    SkinManager.setImageResource(this.f29835d, i2);
                }
                this.f29835d.setVisibility(0);
            } else {
                this.f29835d.setVisibility(8);
            }
            SkinManager.setViewTextColor(this.f29836e, R.color.CAM_X0101, 1, i);
            this.f29836e.setText(this.f29837f);
            this.f29833b.setGravity(this.i, this.k, this.l);
            this.f29833b.setDuration(this.j);
            r(this.m);
            this.f29833b.setView(this.f29834c);
            return this;
        }
        return (BdToast) invokeI.objValue;
    }

    public BdToast j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            this.j = i;
            return this;
        }
        return (BdToast) invokeI.objValue;
    }

    public void k(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
            this.f29836e.setLineSpacing(0.0f, f2);
        }
    }

    public BdToast l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            this.i = i;
            return this;
        }
        return (BdToast) invokeI.objValue;
    }

    public BdToast m(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            this.f29838g = i;
            this.f29839h = z;
            return this;
        }
        return (BdToast) invokeCommon.objValue;
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.l = i;
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m = i;
        }
    }

    public BdToast p(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence)) == null) {
            this.f29837f = charSequence;
            this.f29836e.setText(charSequence);
            return this;
        }
        return (BdToast) invokeL.objValue;
    }

    public BdToast q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            this.f29836e.setText(this.f29837f);
            this.f29833b.setGravity(this.i, this.k, this.l);
            this.f29833b.setDuration(this.j);
            this.f29833b.show();
            return this;
        }
        return (BdToast) invokeV.objValue;
    }

    public final void r(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || i <= 0) {
            return;
        }
        this.f29834c.setPadding(i, this.f29834c.getTop(), i, this.f29834c.getBottom());
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SoftReference<Toast> softReference = n;
            if (softReference != null && softReference.get() != null) {
                n.get().cancel();
            }
            n = new SoftReference<>(this.f29833b);
        }
    }
}
