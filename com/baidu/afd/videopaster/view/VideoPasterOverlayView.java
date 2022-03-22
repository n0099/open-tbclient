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
import c.a.d.f.p.n;
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
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class VideoPasterOverlayView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int s;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24101b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24102c;

    /* renamed from: d  reason: collision with root package name */
    public View f24103d;

    /* renamed from: e  reason: collision with root package name */
    public View f24104e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f24105f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24106g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24107h;
    public b i;
    public Context j;
    public int k;
    public boolean l;
    public int m;
    public int n;
    public String o;
    public boolean p;
    public c.a.e.m.e.a q;
    public View.OnClickListener r;

    /* loaded from: classes3.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.obfuscated_res_0x7f092354) {
                    if (this.a.i != null) {
                        this.a.i.d();
                    }
                } else if (view.getId() == R.id.obfuscated_res_0x7f092355) {
                    if (this.a.i != null) {
                        this.a.i.c();
                    }
                } else if (view.getId() == R.id.obfuscated_res_0x7f092353) {
                    if (this.a.i != null) {
                        this.a.i.e();
                        this.a.p = true;
                    }
                } else if (view.getId() == R.id.obfuscated_res_0x7f092352) {
                    if (this.a.i != null) {
                        this.a.i.a();
                        this.a.p = true;
                    }
                } else if (view.getId() != R.id.obfuscated_res_0x7f092351 || this.a.i == null) {
                } else {
                    this.a.i.b();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
        s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070270);
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
        this.l = false;
        this.m = 0;
        this.n = 0;
        this.p = false;
        this.r = new a(this);
        this.j = context;
        this.k = e(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0889, (ViewGroup) null);
        this.f24104e = inflate;
        this.f24103d = inflate.findViewById(R.id.obfuscated_res_0x7f092352);
        this.a = (TextView) this.f24104e.findViewById(R.id.obfuscated_res_0x7f092355);
        this.f24101b = (TextView) this.f24104e.findViewById(R.id.obfuscated_res_0x7f092354);
        this.f24102c = (TextView) this.f24104e.findViewById(R.id.obfuscated_res_0x7f092353);
        this.f24105f = (ImageView) this.f24104e.findViewById(R.id.obfuscated_res_0x7f092351);
        this.f24102c.setOnClickListener(this.r);
        this.f24101b.setOnClickListener(this.r);
        this.f24103d.setOnClickListener(this.r);
        this.f24105f.setOnClickListener(this.r);
        this.a.setOnClickListener(this.r);
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
            this.f24105f.setVisibility(0);
            this.f24101b.setPadding(s, 0, 0, 0);
            this.f24102c.setPadding(0, 0, s, 0);
            this.f24104e.setPadding(0, 0, 0, 0);
            p();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24105f.setVisibility(8);
            this.f24101b.setPadding(0, 0, 0, 0);
            this.f24102c.setPadding(0, 0, 0, 0);
            boolean f2 = f(this.j);
            if (this.f24106g && this.f24107h && f2) {
                this.f24104e.setPadding(0, 0, 0, this.k);
            } else {
                this.f24104e.setPadding(0, 0, 0, 0);
            }
            p();
        }
    }

    public final int e(Context context) {
        InterceptResult invokeL;
        Resources resources;
        int identifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (!f(context) || (identifier = (resources = context.getResources()).getIdentifier(SapiSystemBarTintManager.SystemBarConfig.f27943h, EMABTest.TYPE_DIMEN, "android")) <= 0) {
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
            this.f24106g = true;
            n(this.q, true, this.f24107h);
            if (this.l) {
                o(this.m, this.n, this.o);
            }
        }
    }

    @Override // android.view.View
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f24104e : (View) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f24106g = false;
            n(this.q, false, this.f24107h);
            if (this.p && !this.f24107h) {
                this.p = false;
            } else if (this.l) {
                o(this.m, this.n, this.o);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.l = false;
            this.o = "";
            this.m = 0;
            this.n = 0;
            this.p = false;
        }
    }

    public final void j(int i, int i2, String str) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, str) == null) || (context = this.j) == null || i == 0 || i2 == 0) {
            return;
        }
        int k = n.k(context);
        int i3 = 0;
        if (TextUtils.equals(str, "HOME")) {
            k -= n.f(this.j, R.dimen.tbds88);
            i3 = (int) (k * 0.5625d);
        } else if (TextUtils.equals(str, "VIDEO_LIST")) {
            i3 = (int) (k * (this.f24107h ? 0.875f : 0.5625f));
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
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f24104e.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = i3;
        this.f24104e.setLayoutParams(layoutParams);
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public void n(c.a.e.m.e.a aVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || aVar == null) {
            return;
        }
        this.q = aVar;
        this.f24106g = z;
        this.f24107h = z2;
        this.a.setText(aVar.f2693d);
        this.f24102c.setText(aVar.b());
        if (z && !z2) {
            c();
        } else {
            d();
        }
    }

    public void o(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i, i2, str) == null) {
            this.l = true;
            this.m = i;
            this.n = i2;
            this.o = str;
            if (this.f24106g) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f24104e.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.f24104e.setLayoutParams(layoutParams);
                return;
            }
            j(i, i2, str);
        }
    }

    public final void p() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (context = this.j) == null || this.f24103d == null || !f(context)) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f24103d.getLayoutParams();
        if (this.f24106g) {
            if (this.f24107h) {
                layoutParams.setMargins(0, 0, 0, this.k);
            } else {
                int i = this.k;
                layoutParams.setMargins(i, 0, i, 0);
            }
        } else {
            layoutParams.setMargins(0, 0, 0, 0);
        }
        this.f24103d.setLayoutParams(layoutParams);
    }

    public void setCountDownNum(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || this.f24101b == null || i <= 0) {
            return;
        }
        if (i < 10) {
            str = "0" + i;
        } else {
            str = "" + i;
        }
        this.f24101b.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14e1));
    }

    public void setOverlayViewCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
            this.i = bVar;
        }
    }
}
