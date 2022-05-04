package com.baidu.afd.videopaster.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oi;
import com.repackage.xp;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class VideoPasterOverlayView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public TextView c;
    public View d;
    public View e;
    public ImageView f;
    public boolean g;
    public boolean h;
    public b i;
    public Context j;
    public int k;
    public boolean l;
    public View.OnClickListener m;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPasterOverlayView a;

        public a(VideoPasterOverlayView videoPasterOverlayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPasterOverlayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPasterOverlayView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092332) {
                    if (this.a.i != null) {
                        this.a.i.d();
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092333) {
                    if (this.a.i != null) {
                        this.a.i.c();
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092331) {
                    if (this.a.i != null) {
                        this.a.i.e();
                        this.a.l = true;
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092330) {
                    if (this.a.i != null) {
                        this.a.i.a();
                        this.a.l = true;
                    }
                } else if (view2.getId() != R.id.obfuscated_res_0x7f09232f || this.a.i == null) {
                } else {
                    this.a.i.b();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-775043415, "Lcom/baidu/afd/videopaster/view/VideoPasterOverlayView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-775043415, "Lcom/baidu/afd/videopaster/view/VideoPasterOverlayView;");
                return;
            }
        }
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07027c);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 0;
        this.m = new a(this);
        this.j = context;
        this.k = e(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d087f, (ViewGroup) null);
        this.e = inflate;
        this.d = inflate.findViewById(R.id.obfuscated_res_0x7f092330);
        this.a = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f092333);
        this.b = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f092332);
        this.c = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f092331);
        this.f = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f09232f);
        this.c.setOnClickListener(this.m);
        this.b.setOnClickListener(this.m);
        this.d.setOnClickListener(this.m);
        this.f.setOnClickListener(this.m);
        this.a.setOnClickListener(this.m);
    }

    private String getNavBarOverride() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod(SharedPreferenceManager.OPERATION_GET_PERFIX, String.class);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f.setVisibility(0);
            this.b.setPadding(n, 0, 0, 0);
            this.c.setPadding(0, 0, n, 0);
            this.e.setPadding(0, 0, 0, 0);
            m();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f.setVisibility(8);
            this.b.setPadding(0, 0, 0, 0);
            this.c.setPadding(0, 0, 0, 0);
            boolean f = f(this.j);
            if (this.g && this.h && f) {
                this.e.setPadding(0, 0, 0, this.k);
            } else {
                this.e.setPadding(0, 0, 0, 0);
            }
            m();
        }
    }

    public final int e(Context context) {
        InterceptResult invokeL;
        Resources resources;
        int identifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (!f(context) || (identifier = (resources = context.getResources()).getIdentifier(SapiSystemBarTintManager.SystemBarConfig.h, EMABTest.TYPE_DIMEN, "android")) <= 0) {
                return 0;
            }
            return resources.getDimensionPixelSize(identifier);
        }
        return invokeL.intValue;
    }

    public final boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(SapiSystemBarTintManager.SystemBarConfig.k, "bool", "android");
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                String navBarOverride = getNavBarOverride();
                if ("1".equals(navBarOverride)) {
                    return false;
                }
                if ("0".equals(navBarOverride)) {
                    return true;
                }
                return z;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        return invokeL.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // android.view.View
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public final void h(int i, int i2, String str) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, str) == null) || (context = this.j) == null || i == 0 || i2 == 0) {
            return;
        }
        int k = oi.k(context);
        int i3 = 0;
        if (TextUtils.equals(str, "HOME")) {
            k -= oi.f(this.j, R.dimen.tbds88);
            i3 = (int) (k * 0.5625d);
        } else if (TextUtils.equals(str, "VIDEO_LIST")) {
            i3 = (int) (k * (this.h ? 0.875f : 0.5625f));
        } else {
            k = 0;
        }
        if (i3 == 0) {
            return;
        }
        if (i / i2 > k / i3) {
            i3 = (i2 * k) / i;
        }
        if (i3 <= 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = i3;
        this.e.setLayoutParams(layoutParams);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void k(xp xpVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{xpVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || xpVar == null) {
            return;
        }
        this.g = z;
        this.h = z2;
        this.a.setText(xpVar.d);
        this.c.setText(xpVar.b());
        if (z && !z2) {
            c();
        } else {
            d();
        }
    }

    public void l(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048586, this, i, i2, str) == null) {
            if (this.g) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.e.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.e.setLayoutParams(layoutParams);
                return;
            }
            h(i, i2, str);
        }
    }

    public final void m() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (context = this.j) == null || this.d == null || !f(context)) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.d.getLayoutParams();
        if (this.g) {
            if (this.h) {
                layoutParams.setMargins(0, 0, 0, this.k);
            } else {
                int i = this.k;
                layoutParams.setMargins(i, 0, i, 0);
            }
        } else {
            layoutParams.setMargins(0, 0, 0, 0);
        }
        this.d.setLayoutParams(layoutParams);
    }

    public void setCountDownNum(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || this.b == null || i <= 0) {
            return;
        }
        if (i < 10) {
            str = "0" + i;
        } else {
            str = "" + i;
        }
        this.b.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14e9));
    }

    public void setOverlayViewCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.i = bVar;
        }
    }
}
