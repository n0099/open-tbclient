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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class VideoPasterOverlayView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int w;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f2575e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f2576f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f2577g;

    /* renamed from: h  reason: collision with root package name */
    public View f2578h;

    /* renamed from: i  reason: collision with root package name */
    public View f2579i;
    public ImageView j;
    public boolean k;
    public boolean l;
    public b m;
    public Context n;
    public int o;
    public boolean p;
    public int q;
    public int r;
    public String s;
    public boolean t;
    public d.a.e.m.e.a u;
    public View.OnClickListener v;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPasterOverlayView f2580e;

        public a(VideoPasterOverlayView videoPasterOverlayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPasterOverlayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2580e = videoPasterOverlayView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (this.f2580e.m != null) {
                        this.f2580e.m.c();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (this.f2580e.m != null) {
                        this.f2580e.m.a();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (this.f2580e.m != null) {
                        this.f2580e.m.d();
                        this.f2580e.t = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (this.f2580e.m != null) {
                        this.f2580e.m.onClickAd();
                        this.f2580e.t = true;
                    }
                } else if (view.getId() != R.id.video_paster_mask_back || this.f2580e.m == null) {
                } else {
                    this.f2580e.m.b();
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

        void onClickAd();
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
        w = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = 0;
        this.p = false;
        this.q = 0;
        this.r = 0;
        this.t = false;
        this.v = new a(this);
        this.n = context;
        this.o = e(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.f2579i = inflate;
        this.f2578h = inflate.findViewById(R.id.video_paster_mask_wrapper);
        this.f2575e = (TextView) this.f2579i.findViewById(R.id.video_paster_overlay_title);
        this.f2576f = (TextView) this.f2579i.findViewById(R.id.video_paster_overlay_time_and_close);
        this.f2577g = (TextView) this.f2579i.findViewById(R.id.video_paster_overlay_detail);
        this.j = (ImageView) this.f2579i.findViewById(R.id.video_paster_mask_back);
        this.f2577g.setOnClickListener(this.v);
        this.f2576f.setOnClickListener(this.v);
        this.f2578h.setOnClickListener(this.v);
        this.j.setOnClickListener(this.v);
        this.f2575e.setOnClickListener(this.v);
    }

    private String getNavBarOverride() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
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
            this.j.setVisibility(0);
            this.f2576f.setPadding(w, 0, 0, 0);
            this.f2577g.setPadding(0, 0, w, 0);
            this.f2579i.setPadding(0, 0, 0, 0);
            p();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.j.setVisibility(8);
            this.f2576f.setPadding(0, 0, 0, 0);
            this.f2577g.setPadding(0, 0, 0, 0);
            boolean f2 = f(this.n);
            if (this.k && this.l && f2) {
                this.f2579i.setPadding(0, 0, 0, this.o);
            } else {
                this.f2579i.setPadding(0, 0, 0, 0);
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
            if (!f(context) || (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) {
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
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
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
            this.k = true;
            n(this.u, true, this.l);
            if (this.p) {
                o(this.q, this.r, this.s);
            }
        }
    }

    @Override // android.view.View
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2579i : (View) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.k = false;
            n(this.u, false, this.l);
            if (this.t && !this.l) {
                this.t = false;
            } else if (this.p) {
                o(this.q, this.r, this.s);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.p = false;
            this.s = "";
            this.q = 0;
            this.r = 0;
            this.t = false;
        }
    }

    public final void j(int i2, int i3, String str) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, str) == null) || (context = this.n) == null || i2 == 0 || i3 == 0) {
            return;
        }
        int k = l.k(context);
        int i4 = 0;
        if (TextUtils.equals(str, "NEWINDEX")) {
            k -= l.g(this.n, R.dimen.tbds88);
            i4 = (int) (k * 0.5625d);
        } else if (TextUtils.equals(str, "VIDEO_LIST")) {
            i4 = (int) (k * (this.l ? 0.875f : 0.5625f));
        } else {
            k = 0;
        }
        if (i4 == 0) {
            return;
        }
        if (i2 / i3 > k / i4) {
            i4 = (i3 * k) / i2;
        }
        if (i4 <= 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2579i.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = i4;
        this.f2579i.setLayoutParams(layoutParams);
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
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

    public void n(d.a.e.m.e.a aVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || aVar == null) {
            return;
        }
        this.u = aVar;
        this.k = z;
        this.l = z2;
        this.f2575e.setText(aVar.f42516h);
        this.f2577g.setText(aVar.b());
        if (z && !z2) {
            c();
        } else {
            d();
        }
    }

    public void o(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, str) == null) {
            this.p = true;
            this.q = i2;
            this.r = i3;
            this.s = str;
            if (this.k) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2579i.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.f2579i.setLayoutParams(layoutParams);
                return;
            }
            j(i2, i3, str);
        }
    }

    public final void p() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (context = this.n) == null || this.f2578h == null || !f(context)) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2578h.getLayoutParams();
        if (this.k) {
            if (this.l) {
                layoutParams.setMargins(0, 0, 0, this.o);
            } else {
                int i2 = this.o;
                layoutParams.setMargins(i2, 0, i2, 0);
            }
        } else {
            layoutParams.setMargins(0, 0, 0, 0);
        }
        this.f2578h.setLayoutParams(layoutParams);
    }

    public void setCountDownNum(int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || this.f2576f == null || i2 <= 0) {
            return;
        }
        if (i2 < 10) {
            str = "0" + i2;
        } else {
            str = "" + i2;
        }
        this.f2576f.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
    }

    public void setOverlayViewCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
            this.m = bVar;
        }
    }
}
