package c.a.p0.a.o0.i;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.o0.d;
import c.a.p0.a.p2.n0;
import c.a.p0.a.p2.q0;
import c.a.p0.a.x.g.g;
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
public final class c implements c.a.p0.a.o0.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f6608g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f6609h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public String f6610b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.a.x.g.f f6611c;

    /* renamed from: d  reason: collision with root package name */
    public int f6612d;

    /* renamed from: e  reason: collision with root package name */
    public ShowConfirmBarLayout f6613e;

    /* renamed from: f  reason: collision with root package name */
    public f f6614f;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f6615e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f6616f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f6617g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f6618h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f6619i;

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
            this.f6619i = cVar;
            this.f6615e = i2;
            this.f6616f = i3;
            this.f6617g = i4;
            this.f6618h = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6619i.D0(this.f6615e, this.f6616f, this.f6617g, this.f6618h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f6620e;

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
            this.f6620e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6620e.C0();
            }
        }
    }

    /* renamed from: c.a.p0.a.o0.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0404c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f6621e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f6622f;

        public RunnableC0404c(c cVar, int i2) {
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
            this.f6622f = cVar;
            this.f6621e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6622f.F0(this.f6621e);
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
                if (this.a.f6614f != null) {
                    this.a.f6614f.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f6623e;

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
            this.f6623e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6623e.w0();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1290480523, "Lc/a/p0/a/o0/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1290480523, "Lc/a/p0/a/o0/i/c;");
                return;
            }
        }
        f6608g = c.a.p0.a.a.a;
        f6609h = n0.g(38.0f);
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
            this.f6610b = (String) invoker.get("id");
        }
        this.a = str;
        this.f6611c = u0();
    }

    @Override // c.a.p0.a.o0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (c.a.p0.a.t1.e.L() == null) {
                aVar.a(false);
            } else {
                aVar.a(true);
            }
        }
    }

    public void A0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            q0.a0(new RunnableC0404c(this, i2));
        }
    }

    public final void B0(String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && f6608g) {
            String str3 = (" <<" + k0() + "-" + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String str4 = str3 + str2;
        }
    }

    public final void C0() {
        c.a.p0.a.x.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (fVar = this.f6611c) == null || this.f6612d == 0) {
            return;
        }
        this.f6612d = 0;
        if (fVar.r3().getScrollY() > 0) {
            this.f6611c.r3().setScrollY(0);
        }
    }

    public final void D0(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) || this.f6611c == null) {
            return;
        }
        c.a.p0.a.f.e.c i6 = c.a.p0.a.w0.f.U().i();
        if (this.f6612d == i4 || i6 == null) {
            return;
        }
        this.f6612d = i4;
        int i7 = this.f6613e == null ? 0 : f6609h;
        int height = ((this.f6611c.r3().getHeight() - i2) - i3) + i6.getWebViewScrollY();
        if (height - i5 < i4) {
            if (i5 > height) {
                this.f6611c.r3().setScrollY(i4 + i7);
            } else {
                this.f6611c.r3().setScrollY((i4 - height) + i5 + i7);
            }
        }
    }

    public void E0(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f6614f = fVar;
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
        if (this.f6613e == null) {
            ShowConfirmBarLayout showConfirmBarLayout = new ShowConfirmBarLayout(v0);
            this.f6613e = showConfirmBarLayout;
            showConfirmBarLayout.setOnConfirmButtonClickListener(new d(this));
            FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
            layoutParams.topMargin = (frameLayout.getHeight() - i2) - f6609h;
            frameLayout.addView(this.f6613e, layoutParams);
        }
    }

    @Override // c.a.p0.a.o0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.o0.d
    @Nullable
    public String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f6610b : (String) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Nullable
    public final c.a.p0.a.x.g.f u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            g V = c.a.p0.a.w0.f.U().V();
            if (V == null) {
                return null;
            }
            int k = V.k();
            for (int i2 = 0; i2 < k; i2++) {
                c.a.p0.a.x.g.d j2 = V.j(i2);
                if (j2 instanceof c.a.p0.a.x.g.f) {
                    c.a.p0.a.x.g.f fVar = (c.a.p0.a.x.g.f) j2;
                    if (TextUtils.equals(fVar.n3(), this.a)) {
                        return fVar;
                    }
                }
            }
            return null;
        }
        return (c.a.p0.a.x.g.f) invokeV.objValue;
    }

    @Nullable
    public final Activity v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            c.a.p0.a.t1.e L = c.a.p0.a.t1.e.L();
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
        ShowConfirmBarLayout showConfirmBarLayout = this.f6613e;
        if (showConfirmBarLayout == null || showConfirmBarLayout.getVisibility() != 0) {
            return;
        }
        ((FrameLayout) decorView.findViewById(16908290)).removeView(this.f6613e);
        this.f6613e = null;
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
