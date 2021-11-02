package b.a.p0.a.y0.j;

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
import b.a.p0.a.g1.h;
import b.a.p0.a.g1.i;
import b.a.p0.a.k;
import b.a.p0.a.p.e.d;
import b.a.p0.a.v2.q0;
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
    public static final boolean f9050i;
    public static final ViewGroup.LayoutParams j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f9051a;

    /* renamed from: b  reason: collision with root package name */
    public View f9052b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f9053c;

    /* renamed from: d  reason: collision with root package name */
    public int f9054d;

    /* renamed from: e  reason: collision with root package name */
    public int f9055e;

    /* renamed from: f  reason: collision with root package name */
    public String f9056f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC0464b f9057g;

    /* renamed from: h  reason: collision with root package name */
    public c f9058h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9059e;

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
            this.f9059e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9059e.f9052b == null) {
                return;
            }
            this.f9059e.f9052b.requestFocus();
        }
    }

    /* renamed from: b.a.p0.a.y0.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0464b {
        void onCustomViewHidden();
    }

    /* loaded from: classes.dex */
    public static class c implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Activity f9060a;

        /* renamed from: b  reason: collision with root package name */
        public String f9061b;

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
            this.f9060a = activity;
            this.f9061b = str;
        }

        @Override // b.a.p0.a.g1.h
        public void a(d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) && TextUtils.equals(dVar.b(), this.f9061b)) {
                b.f(this.f9060a, true);
                ((ViewGroup) this.f9060a.getWindow().getDecorView()).setSystemUiVisibility(4098);
            }
        }

        @Override // b.a.p0.a.g1.h
        public void b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            }
        }

        @Override // b.a.p0.a.g1.h
        public void c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            }
        }

        @Override // b.a.p0.a.g1.h
        public void d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-494814368, "Lb/a/p0/a/y0/j/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-494814368, "Lb/a/p0/a/y0/j/b;");
                return;
            }
        }
        f9050i = k.f6397a;
        j = new FrameLayout.LayoutParams(-1, -1);
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
        this.f9051a = context;
        this.f9056f = str;
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
                if (f9050i) {
                    String str2 = "addComponentToFullScreen: " + str;
                }
                b.a.p0.a.c0.b.a b2 = b.a.p0.a.c0.d.a.b(this.f9056f, str);
                if (b2 == null) {
                    return;
                }
                if ("coverView".equals(b2.n().f4055e) || "coverImage".equals(b2.n().f4055e)) {
                    if (this.f9053c == null) {
                        return;
                    }
                    SwanAppComponentContainerView m = b2.m();
                    if (m == null) {
                        return;
                    }
                    ViewParent parent = m.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(m);
                        this.f9053c.addView(m);
                    }
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f9052b == null) {
            return;
        }
        boolean z = f9050i;
        Context context = this.f9051a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            i.f(this.f9058h);
            this.f9058h = null;
            f(activity, false);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            viewGroup.removeView(this.f9053c);
            this.f9053c = null;
            this.f9052b = null;
            InterfaceC0464b interfaceC0464b = this.f9057g;
            if (interfaceC0464b != null) {
                interfaceC0464b.onCustomViewHidden();
            }
            activity.setRequestedOrientation(this.f9054d);
            viewGroup.setSystemUiVisibility(this.f9055e);
        }
    }

    @UiThread
    public synchronized void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                if (f9050i) {
                    String str2 = "removeComponentFromFullScreen: " + str;
                }
                b.a.p0.a.c0.b.a b2 = b.a.p0.a.c0.d.a.b(this.f9056f, str);
                if (b2 == null) {
                    return;
                }
                if ("coverView".equals(b2.n().f4055e) || "coverImage".equals(b2.n().f4055e)) {
                    SwanAppComponentContainerView m = b2.m();
                    if (m == null) {
                        return;
                    }
                    ViewParent parent = m.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(m);
                        b2.insert();
                    }
                }
            }
        }
    }

    public void g(View view, int i2, @Nullable InterfaceC0464b interfaceC0464b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, view, i2, interfaceC0464b) == null) {
            boolean z = f9050i;
            Context context = this.f9051a;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                if (this.f9052b != null) {
                    if (interfaceC0464b != null) {
                        interfaceC0464b.onCustomViewHidden();
                        this.f9057g = interfaceC0464b;
                        return;
                    }
                    return;
                }
                this.f9054d = activity.getRequestedOrientation();
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
                this.f9053c = swanAppInlineFullScreenContainer;
                swanAppInlineFullScreenContainer.addView(view, j);
                viewGroup.addView(this.f9053c, j);
                this.f9052b = view;
                f(activity, true);
                activity.setRequestedOrientation(i2);
                if (b.a.p0.a.c1.a.H().a() && (activity instanceof SwanAppActivity)) {
                    ((SwanAppActivity) activity).onNightModeCoverChanged(true, false);
                }
                this.f9055e = viewGroup.getSystemUiVisibility();
                viewGroup.setSystemUiVisibility(4098);
                if (this.f9058h == null) {
                    this.f9058h = new c(activity, this.f9056f);
                }
                i.e(this.f9058h);
                q0.X(new a(this));
            }
        }
    }
}
