package c.a.p0.a.y0.i;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.h0.g.g;
import c.a.p0.a.k;
import c.a.p0.a.y0.d;
import c.a.p0.a.z2.n0;
import c.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes.dex */
public final class c implements c.a.p0.a.y0.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f8808g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f8809h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public String f8810b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.a.h0.g.f f8811c;

    /* renamed from: d  reason: collision with root package name */
    public int f8812d;

    /* renamed from: e  reason: collision with root package name */
    public ShowConfirmBarLayout f8813e;

    /* renamed from: f  reason: collision with root package name */
    public f f8814f;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f8815e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8816f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8817g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8818h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f8819i;

        public a(c cVar, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8819i = cVar;
            this.f8815e = i2;
            this.f8816f = i3;
            this.f8817g = i4;
            this.f8818h = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8819i.D0(this.f8815e, this.f8816f, this.f8817g, this.f8818h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f8820e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8820e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8820e.C0();
            }
        }
    }

    /* renamed from: c.a.p0.a.y0.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0534c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f8821e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f8822f;

        public RunnableC0534c(c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8822f = cVar;
            this.f8821e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8822f.F0(this.f8821e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements ShowConfirmBarLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.B0("onConfirmBtnClick", null);
                if (this.a.f8814f != null) {
                    this.a.f8814f.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f8823e;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8823e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8823e.w0();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1005378305, "Lc/a/p0/a/y0/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1005378305, "Lc/a/p0/a/y0/i/c;");
                return;
            }
        }
        f8808g = k.a;
        f8809h = n0.g(38.0f);
    }

    public c(ZeusPluginFactory.Invoker invoker, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invoker, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (invoker != null) {
            this.f8810b = (String) invoker.get("id");
        }
        this.a = str;
        this.f8811c = u0();
    }

    @Override // c.a.p0.a.y0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (c.a.p0.a.d2.e.L() == null) {
                aVar.a(false);
            } else {
                aVar.a(true);
            }
        }
    }

    public void A0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            q0.a0(new RunnableC0534c(this, i2));
        }
    }

    public final void B0(String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && f8808g) {
            String str3 = (" <<" + k0() + "-" + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String str4 = str3 + str2;
        }
    }

    public final void C0() {
        c.a.p0.a.h0.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (fVar = this.f8811c) == null || this.f8812d == 0) {
            return;
        }
        this.f8812d = 0;
        if (fVar.y3().getScrollY() > 0) {
            this.f8811c.y3().setScrollY(0);
        }
    }

    public final void D0(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) || this.f8811c == null) {
            return;
        }
        c.a.p0.a.p.e.c h2 = c.a.p0.a.g1.f.U().h();
        if (this.f8812d == i4 || h2 == null) {
            return;
        }
        this.f8812d = i4;
        int i6 = this.f8813e == null ? 0 : f8809h;
        int height = ((this.f8811c.y3().getHeight() - i2) - i3) + h2.getWebViewScrollY();
        if (height - i5 < i4) {
            if (i5 > height) {
                this.f8811c.y3().setScrollY(i4 + i6);
            } else {
                this.f8811c.y3().setScrollY((i4 - height) + i5 + i6);
            }
        }
    }

    public void E0(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f8814f = fVar;
        }
    }

    public final void F0(int i2) {
        Activity v0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (v0 = v0()) == null) {
            return;
        }
        View decorView = v0.getWindow().getDecorView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (this.f8813e == null) {
            ShowConfirmBarLayout showConfirmBarLayout = new ShowConfirmBarLayout(v0);
            this.f8813e = showConfirmBarLayout;
            showConfirmBarLayout.setOnConfirmButtonClickListener(new d(this));
            FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
            layoutParams.topMargin = (frameLayout.getHeight() - i2) - f8809h;
            frameLayout.addView(this.f8813e, layoutParams);
        }
    }

    @Override // c.a.p0.a.y0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.y0.d
    @Nullable
    public String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f8810b : (String) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Nullable
    public final c.a.p0.a.h0.g.f u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            g V = c.a.p0.a.g1.f.U().V();
            if (V == null) {
                return null;
            }
            int k2 = V.k();
            for (int i2 = 0; i2 < k2; i2++) {
                c.a.p0.a.h0.g.d j2 = V.j(i2);
                if (j2 instanceof c.a.p0.a.h0.g.f) {
                    c.a.p0.a.h0.g.f fVar = (c.a.p0.a.h0.g.f) j2;
                    if (TextUtils.equals(fVar.u3(), this.a)) {
                        return fVar;
                    }
                }
            }
            return null;
        }
        return (c.a.p0.a.h0.g.f) invokeV.objValue;
    }

    @Nullable
    public final Activity v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            c.a.p0.a.d2.e L = c.a.p0.a.d2.e.L();
            if (L == null) {
                return null;
            }
            return L.getActivity();
        }
        return (Activity) invokeV.objValue;
    }

    public final void w0() {
        Activity v0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (v0 = v0()) == null) {
            return;
        }
        View decorView = v0.getWindow().getDecorView();
        ShowConfirmBarLayout showConfirmBarLayout = this.f8813e;
        if (showConfirmBarLayout == null || showConfirmBarLayout.getVisibility() != 0) {
            return;
        }
        ((FrameLayout) decorView.findViewById(16908290)).removeView(this.f8813e);
        this.f8813e = null;
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            q0.a0(new e(this));
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            q0.a0(new b(this));
        }
    }

    public void z0(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048591, this, i2, i3, i4, i5) == null) {
            q0.a0(new a(this, i2, i3, i4, i5));
        }
    }
}
