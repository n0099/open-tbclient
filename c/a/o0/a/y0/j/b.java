package c.a.o0.a.y0.j;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.g1.h;
import c.a.o0.a.g1.i;
import c.a.o0.a.k;
import c.a.o0.a.p.e.d;
import c.a.o0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f9779i;

    /* renamed from: j  reason: collision with root package name */
    public static final ViewGroup.LayoutParams f9780j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f9781a;

    /* renamed from: b  reason: collision with root package name */
    public View f9782b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f9783c;

    /* renamed from: d  reason: collision with root package name */
    public int f9784d;

    /* renamed from: e  reason: collision with root package name */
    public int f9785e;

    /* renamed from: f  reason: collision with root package name */
    public String f9786f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC0467b f9787g;

    /* renamed from: h  reason: collision with root package name */
    public c f9788h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9789e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9789e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9789e.f9782b == null) {
                return;
            }
            this.f9789e.f9782b.requestFocus();
        }
    }

    /* renamed from: c.a.o0.a.y0.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0467b {
        void onCustomViewHidden();
    }

    /* loaded from: classes.dex */
    public static class c implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Activity f9790a;

        /* renamed from: b  reason: collision with root package name */
        public String f9791b;

        public c(Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9790a = activity;
            this.f9791b = str;
        }

        @Override // c.a.o0.a.g1.h
        public void a(d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) && TextUtils.equals(dVar.c(), this.f9791b)) {
                b.f(this.f9790a, true);
                ((ViewGroup) this.f9790a.getWindow().getDecorView()).setSystemUiVisibility(4098);
            }
        }

        @Override // c.a.o0.a.g1.h
        public void b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            }
        }

        @Override // c.a.o0.a.g1.h
        public void c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            }
        }

        @Override // c.a.o0.a.g1.h
        public void d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1134431264, "Lc/a/o0/a/y0/j/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1134431264, "Lc/a/o0/a/y0/j/b;");
                return;
            }
        }
        f9779i = k.f7049a;
        f9780j = new FrameLayout.LayoutParams(-1, -1);
    }

    public b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9781a = context;
        this.f9786f = str;
    }

    public static void f(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, z) == null) {
            activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
        }
    }

    @UiThread
    public synchronized void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            synchronized (this) {
                if (f9779i) {
                    String str2 = "addComponentToFullScreen: " + str;
                }
                c.a.o0.a.c0.b.a b2 = c.a.o0.a.c0.d.a.b(this.f9786f, str);
                if (b2 == null) {
                    return;
                }
                if ("coverView".equals(b2.n().f4628e) || "coverImage".equals(b2.n().f4628e)) {
                    if (this.f9783c == null) {
                        return;
                    }
                    SwanAppComponentContainerView m = b2.m();
                    if (m == null) {
                        return;
                    }
                    ViewParent parent = m.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(m);
                        this.f9783c.addView(m);
                    }
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f9782b == null) {
            return;
        }
        boolean z = f9779i;
        Context context = this.f9781a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            i.f(this.f9788h);
            this.f9788h = null;
            f(activity, false);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            viewGroup.removeView(this.f9783c);
            this.f9783c = null;
            this.f9782b = null;
            InterfaceC0467b interfaceC0467b = this.f9787g;
            if (interfaceC0467b != null) {
                interfaceC0467b.onCustomViewHidden();
            }
            activity.setRequestedOrientation(this.f9784d);
            viewGroup.setSystemUiVisibility(this.f9785e);
        }
    }

    @UiThread
    public synchronized void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                if (f9779i) {
                    String str2 = "removeComponentFromFullScreen: " + str;
                }
                c.a.o0.a.c0.b.a b2 = c.a.o0.a.c0.d.a.b(this.f9786f, str);
                if (b2 == null) {
                    return;
                }
                if ("coverView".equals(b2.n().f4628e) || "coverImage".equals(b2.n().f4628e)) {
                    SwanAppComponentContainerView m = b2.m();
                    if (m == null) {
                        return;
                    }
                    ViewParent parent = m.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(m);
                        b2.w();
                    }
                }
            }
        }
    }

    public void g(View view, int i2, @Nullable InterfaceC0467b interfaceC0467b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, view, i2, interfaceC0467b) == null) {
            boolean z = f9779i;
            Context context = this.f9781a;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                if (this.f9782b != null) {
                    if (interfaceC0467b != null) {
                        interfaceC0467b.onCustomViewHidden();
                        this.f9787g = interfaceC0467b;
                        return;
                    }
                    return;
                }
                this.f9784d = activity.getRequestedOrientation();
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
                this.f9783c = swanAppInlineFullScreenContainer;
                swanAppInlineFullScreenContainer.addView(view, f9780j);
                viewGroup.addView(this.f9783c, f9780j);
                this.f9782b = view;
                f(activity, true);
                activity.setRequestedOrientation(i2);
                if (c.a.o0.a.c1.a.H().a() && (activity instanceof SwanAppActivity)) {
                    ((SwanAppActivity) activity).onNightModeCoverChanged(true, false);
                }
                this.f9785e = viewGroup.getSystemUiVisibility();
                viewGroup.setSystemUiVisibility(4098);
                if (this.f9788h == null) {
                    this.f9788h = new c(activity, this.f9786f);
                }
                i.e(this.f9788h);
                q0.X(new a(this));
            }
        }
    }
}
