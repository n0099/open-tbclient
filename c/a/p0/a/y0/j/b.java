package c.a.p0.a.y0.j;

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
import c.a.p0.a.g1.h;
import c.a.p0.a.g1.i;
import c.a.p0.a.k;
import c.a.p0.a.p.e.d;
import c.a.p0.a.v2.q0;
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
    public static final boolean f9807i;

    /* renamed from: j  reason: collision with root package name */
    public static final ViewGroup.LayoutParams f9808j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f9809a;

    /* renamed from: b  reason: collision with root package name */
    public View f9810b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f9811c;

    /* renamed from: d  reason: collision with root package name */
    public int f9812d;

    /* renamed from: e  reason: collision with root package name */
    public int f9813e;

    /* renamed from: f  reason: collision with root package name */
    public String f9814f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC0469b f9815g;

    /* renamed from: h  reason: collision with root package name */
    public c f9816h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9817e;

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
            this.f9817e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9817e.f9810b == null) {
                return;
            }
            this.f9817e.f9810b.requestFocus();
        }
    }

    /* renamed from: c.a.p0.a.y0.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0469b {
        void onCustomViewHidden();
    }

    /* loaded from: classes.dex */
    public static class c implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Activity f9818a;

        /* renamed from: b  reason: collision with root package name */
        public String f9819b;

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
            this.f9818a = activity;
            this.f9819b = str;
        }

        @Override // c.a.p0.a.g1.h
        public void a(d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) && TextUtils.equals(dVar.c(), this.f9819b)) {
                b.f(this.f9818a, true);
                ((ViewGroup) this.f9818a.getWindow().getDecorView()).setSystemUiVisibility(4098);
            }
        }

        @Override // c.a.p0.a.g1.h
        public void b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            }
        }

        @Override // c.a.p0.a.g1.h
        public void c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            }
        }

        @Override // c.a.p0.a.g1.h
        public void d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1005348545, "Lc/a/p0/a/y0/j/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1005348545, "Lc/a/p0/a/y0/j/b;");
                return;
            }
        }
        f9807i = k.f7077a;
        f9808j = new FrameLayout.LayoutParams(-1, -1);
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
        this.f9809a = context;
        this.f9814f = str;
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
                if (f9807i) {
                    String str2 = "addComponentToFullScreen: " + str;
                }
                c.a.p0.a.c0.b.a b2 = c.a.p0.a.c0.d.a.b(this.f9814f, str);
                if (b2 == null) {
                    return;
                }
                if ("coverView".equals(b2.n().f4656e) || "coverImage".equals(b2.n().f4656e)) {
                    if (this.f9811c == null) {
                        return;
                    }
                    SwanAppComponentContainerView m = b2.m();
                    if (m == null) {
                        return;
                    }
                    ViewParent parent = m.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(m);
                        this.f9811c.addView(m);
                    }
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f9810b == null) {
            return;
        }
        boolean z = f9807i;
        Context context = this.f9809a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            i.f(this.f9816h);
            this.f9816h = null;
            f(activity, false);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            viewGroup.removeView(this.f9811c);
            this.f9811c = null;
            this.f9810b = null;
            InterfaceC0469b interfaceC0469b = this.f9815g;
            if (interfaceC0469b != null) {
                interfaceC0469b.onCustomViewHidden();
            }
            activity.setRequestedOrientation(this.f9812d);
            viewGroup.setSystemUiVisibility(this.f9813e);
        }
    }

    @UiThread
    public synchronized void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                if (f9807i) {
                    String str2 = "removeComponentFromFullScreen: " + str;
                }
                c.a.p0.a.c0.b.a b2 = c.a.p0.a.c0.d.a.b(this.f9814f, str);
                if (b2 == null) {
                    return;
                }
                if ("coverView".equals(b2.n().f4656e) || "coverImage".equals(b2.n().f4656e)) {
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

    public void g(View view, int i2, @Nullable InterfaceC0469b interfaceC0469b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, view, i2, interfaceC0469b) == null) {
            boolean z = f9807i;
            Context context = this.f9809a;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                if (this.f9810b != null) {
                    if (interfaceC0469b != null) {
                        interfaceC0469b.onCustomViewHidden();
                        this.f9815g = interfaceC0469b;
                        return;
                    }
                    return;
                }
                this.f9812d = activity.getRequestedOrientation();
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
                this.f9811c = swanAppInlineFullScreenContainer;
                swanAppInlineFullScreenContainer.addView(view, f9808j);
                viewGroup.addView(this.f9811c, f9808j);
                this.f9810b = view;
                f(activity, true);
                activity.setRequestedOrientation(i2);
                if (c.a.p0.a.c1.a.H().a() && (activity instanceof SwanAppActivity)) {
                    ((SwanAppActivity) activity).onNightModeCoverChanged(true, false);
                }
                this.f9813e = viewGroup.getSystemUiVisibility();
                viewGroup.setSystemUiVisibility(4098);
                if (this.f9816h == null) {
                    this.f9816h = new c(activity, this.f9814f);
                }
                i.e(this.f9816h);
                q0.X(new a(this));
            }
        }
    }
}
