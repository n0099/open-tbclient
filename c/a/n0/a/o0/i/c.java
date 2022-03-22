package c.a.n0.a.o0.i;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.o0.d;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.x.g.g;
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
public final class c implements c.a.n0.a.o0.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f5549g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f5550h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public String f5551b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.a.x.g.f f5552c;

    /* renamed from: d  reason: collision with root package name */
    public int f5553d;

    /* renamed from: e  reason: collision with root package name */
    public ShowConfirmBarLayout f5554e;

    /* renamed from: f  reason: collision with root package name */
    public f f5555f;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5556b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f5557c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f5558d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5559e;

        public a(c cVar, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5559e = cVar;
            this.a = i;
            this.f5556b = i2;
            this.f5557c = i3;
            this.f5558d = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5559e.D0(this.a, this.f5556b, this.f5557c, this.f5558d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C0();
            }
        }
    }

    /* renamed from: c.a.n0.a.o0.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0392c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f5560b;

        public RunnableC0392c(c cVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5560b = cVar;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5560b.F0(this.a);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (this.a.f5555f != null) {
                    this.a.f5555f.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w0();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1548645961, "Lc/a/n0/a/o0/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1548645961, "Lc/a/n0/a/o0/i/c;");
                return;
            }
        }
        f5549g = c.a.n0.a.a.a;
        f5550h = n0.g(38.0f);
    }

    public c(ZeusPluginFactory.Invoker invoker, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invoker, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (invoker != null) {
            this.f5551b = (String) invoker.get("id");
        }
        this.a = str;
        this.f5552c = u0();
    }

    @Override // c.a.n0.a.o0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (c.a.n0.a.t1.e.L() == null) {
                aVar.a(false);
            } else {
                aVar.a(true);
            }
        }
    }

    public void A0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            q0.a0(new RunnableC0392c(this, i));
        }
    }

    public final void B0(String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && f5549g) {
            String str3 = (" <<" + k0() + "-" + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }

    public final void C0() {
        c.a.n0.a.x.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (fVar = this.f5552c) == null || this.f5553d == 0) {
            return;
        }
        this.f5553d = 0;
        if (fVar.v3().getScrollY() > 0) {
            this.f5552c.v3().setScrollY(0);
        }
    }

    public final void D0(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) || this.f5552c == null) {
            return;
        }
        c.a.n0.a.f.e.c i5 = c.a.n0.a.w0.f.U().i();
        if (this.f5553d == i3 || i5 == null) {
            return;
        }
        this.f5553d = i3;
        int i6 = this.f5554e == null ? 0 : f5550h;
        int height = ((this.f5552c.v3().getHeight() - i) - i2) + i5.getWebViewScrollY();
        if (height - i4 < i3) {
            if (i4 > height) {
                this.f5552c.v3().setScrollY(i3 + i6);
            } else {
                this.f5552c.v3().setScrollY((i3 - height) + i4 + i6);
            }
        }
    }

    public void E0(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f5555f = fVar;
        }
    }

    public final void F0(int i) {
        Activity v0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || (v0 = v0()) == null) {
            return;
        }
        View decorView = v0.getWindow().getDecorView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (this.f5554e == null) {
            ShowConfirmBarLayout showConfirmBarLayout = new ShowConfirmBarLayout(v0);
            this.f5554e = showConfirmBarLayout;
            showConfirmBarLayout.setOnConfirmButtonClickListener(new d(this));
            FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
            layoutParams.topMargin = (frameLayout.getHeight() - i) - f5550h;
            frameLayout.addView(this.f5554e, layoutParams);
        }
    }

    @Override // c.a.n0.a.o0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.o0.d
    @Nullable
    public String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f5551b : (String) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Nullable
    public final c.a.n0.a.x.g.f u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            g V = c.a.n0.a.w0.f.U().V();
            if (V == null) {
                return null;
            }
            int k = V.k();
            for (int i = 0; i < k; i++) {
                c.a.n0.a.x.g.d j = V.j(i);
                if (j instanceof c.a.n0.a.x.g.f) {
                    c.a.n0.a.x.g.f fVar = (c.a.n0.a.x.g.f) j;
                    if (TextUtils.equals(fVar.r3(), this.a)) {
                        return fVar;
                    }
                }
            }
            return null;
        }
        return (c.a.n0.a.x.g.f) invokeV.objValue;
    }

    @Nullable
    public final Activity v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
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
        ShowConfirmBarLayout showConfirmBarLayout = this.f5554e;
        if (showConfirmBarLayout == null || showConfirmBarLayout.getVisibility() != 0) {
            return;
        }
        ((FrameLayout) decorView.findViewById(16908290)).removeView(this.f5554e);
        this.f5554e = null;
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

    public void z0(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048591, this, i, i2, i3, i4) == null) {
            q0.a0(new a(this, i, i2, i3, i4));
        }
    }
}
