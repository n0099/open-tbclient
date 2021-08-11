package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.e.e.p.u;
import com.alipay.security.mobile.module.http.model.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes6.dex */
public class BdToast {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<Toast> n;
    public static HashMap<DefaultIcon, Integer> o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f47221a;

    /* renamed from: b  reason: collision with root package name */
    public Toast f47222b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f47223c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f47224d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f47225e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f47226f;

    /* renamed from: g  reason: collision with root package name */
    public int f47227g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47228h;

    /* renamed from: i  reason: collision with root package name */
    public int f47229i;

    /* renamed from: j  reason: collision with root package name */
    public int f47230j;
    public int k;
    public int l;
    public int m;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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
            SUCCESS = new DefaultIcon(c.f35984g, 0);
            FAILURE = new DefaultIcon("FAILURE", 1);
            DefaultIcon defaultIcon = new DefaultIcon("NOT", 2);
            NOT = defaultIcon;
            $VALUES = new DefaultIcon[]{SUCCESS, FAILURE, defaultIcon};
        }

        public DefaultIcon(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
        hashMap.put(DefaultIcon.SUCCESS, Integer.valueOf(R.drawable.icon_pure_toast_succeed40_svg));
        o.put(DefaultIcon.FAILURE, Integer.valueOf(R.drawable.icon_pure_toast_mistake40_svg));
        o.put(DefaultIcon.NOT, 0);
    }

    public BdToast(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47227g = -1;
        this.f47228h = false;
        this.f47229i = 16;
        this.f47230j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.f47221a = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.dialog_bdtoast, (ViewGroup) null);
        this.f47223c = viewGroup;
        this.f47224d = (ImageView) viewGroup.findViewById(R.id.toast_icon);
        this.f47225e = (TextView) this.f47223c.findViewById(R.id.toast_message);
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

    public static BdToast d(Context context, CharSequence charSequence, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, context, charSequence, i2)) == null) {
            BdToast bdToast = new BdToast(context);
            bdToast.p(charSequence);
            bdToast.j(i2);
            bdToast.a();
            return bdToast;
        }
        return (BdToast) invokeLLI.objValue;
    }

    public static BdToast e(Context context, CharSequence charSequence, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, null, context, charSequence, i2, i3)) == null) {
            BdToast bdToast = new BdToast(context);
            bdToast.p(charSequence);
            bdToast.j(i2);
            bdToast.b(i3);
            return bdToast;
        }
        return (BdToast) invokeLLII.objValue;
    }

    public static BdToast f(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, charSequence, defaultIcon)) == null) {
            int intValue = o.get(defaultIcon).intValue();
            BdToast bdToast = new BdToast(context);
            bdToast.p(charSequence);
            bdToast.m(intValue, true);
            bdToast.a();
            return bdToast;
        }
        return (BdToast) invokeLLL.objValue;
    }

    public static BdToast g(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(AdIconUtil.BAIDU_LOGO_ID, null, context, charSequence, defaultIcon, i2)) == null) {
            int intValue = o.get(defaultIcon).intValue();
            BdToast bdToast = new BdToast(context);
            bdToast.p(charSequence);
            bdToast.m(intValue, true);
            bdToast.j(i2);
            bdToast.a();
            return bdToast;
        }
        return (BdToast) invokeLLLI.objValue;
    }

    public static BdToast h(Context context, CharSequence charSequence, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            BdToast bdToast = new BdToast(context);
            bdToast.p(charSequence);
            bdToast.m(i2, z);
            bdToast.j(i3);
            bdToast.a();
            return bdToast;
        }
        return (BdToast) invokeCommon.objValue;
    }

    public static BdToast i(Context context, CharSequence charSequence, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, charSequence, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            BdToast bdToast = new BdToast(context);
            bdToast.p(charSequence);
            bdToast.m(i2, z);
            bdToast.a();
            return bdToast;
        }
        return (BdToast) invokeCommon.objValue;
    }

    public BdToast a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Toast toast = new Toast(this.f47221a);
            this.f47222b = toast;
            u.a(toast);
            s();
            int i2 = this.f47227g;
            if (i2 != -1) {
                if (this.f47228h) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f47224d, this.f47227g, R.color.CAM_X0101, null);
                } else {
                    SkinManager.setImageResource(this.f47224d, i2);
                }
                this.f47224d.setVisibility(0);
            } else {
                this.f47224d.setVisibility(8);
            }
            this.f47223c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(this.f47221a, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f47225e, R.color.CAM_X0101, 1);
            this.f47225e.setText(this.f47226f);
            this.f47222b.setGravity(this.f47229i, this.k, this.l);
            this.f47222b.setDuration(this.f47230j);
            r(this.m);
            this.f47222b.setView(this.f47223c);
            return this;
        }
        return (BdToast) invokeV.objValue;
    }

    public BdToast b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.f47222b = new Toast(this.f47221a);
            s();
            int i3 = this.f47227g;
            if (i3 != -1) {
                if (this.f47228h) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f47224d, this.f47227g, R.color.CAM_X0101, null);
                } else {
                    SkinManager.setImageResource(this.f47224d, i3);
                }
                this.f47224d.setVisibility(0);
            } else {
                this.f47224d.setVisibility(8);
            }
            SkinManager.setViewTextColor(this.f47225e, R.color.CAM_X0101, 1, i2);
            this.f47225e.setText(this.f47226f);
            this.f47222b.setGravity(this.f47229i, this.k, this.l);
            this.f47222b.setDuration(this.f47230j);
            r(this.m);
            this.f47222b.setView(this.f47223c);
            return this;
        }
        return (BdToast) invokeI.objValue;
    }

    public BdToast j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.f47230j = i2;
            return this;
        }
        return (BdToast) invokeI.objValue;
    }

    public void k(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
            this.f47225e.setLineSpacing(0.0f, f2);
        }
    }

    public BdToast l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.f47229i = i2;
            return this;
        }
        return (BdToast) invokeI.objValue;
    }

    public BdToast m(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            this.f47227g = i2;
            this.f47228h = z;
            return this;
        }
        return (BdToast) invokeCommon.objValue;
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.l = i2;
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.m = i2;
        }
    }

    public BdToast p(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence)) == null) {
            this.f47226f = charSequence;
            this.f47225e.setText(charSequence);
            return this;
        }
        return (BdToast) invokeL.objValue;
    }

    public BdToast q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            this.f47225e.setText(this.f47226f);
            this.f47222b.setGravity(this.f47229i, this.k, this.l);
            this.f47222b.setDuration(this.f47230j);
            this.f47222b.show();
            return this;
        }
        return (BdToast) invokeV.objValue;
    }

    public final void r(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f47223c.setPadding(i2, this.f47223c.getTop(), i2, this.f47223c.getBottom());
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SoftReference<Toast> softReference = n;
            if (softReference != null && softReference.get() != null) {
                n.get().cancel();
            }
            n = new SoftReference<>(this.f47222b);
        }
    }
}
