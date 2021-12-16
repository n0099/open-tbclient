package c.a.q0.a.y0.j;

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
import c.a.q0.a.g1.h;
import c.a.q0.a.g1.i;
import c.a.q0.a.k;
import c.a.q0.a.z2.q0;
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
    public static final boolean f9133i;

    /* renamed from: j  reason: collision with root package name */
    public static final ViewGroup.LayoutParams f9134j;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f9135b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f9136c;

    /* renamed from: d  reason: collision with root package name */
    public int f9137d;

    /* renamed from: e  reason: collision with root package name */
    public int f9138e;

    /* renamed from: f  reason: collision with root package name */
    public String f9139f;

    /* renamed from: g  reason: collision with root package name */
    public c f9140g;

    /* renamed from: h  reason: collision with root package name */
    public d f9141h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9142e;

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
            this.f9142e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9142e.f9135b == null) {
                return;
            }
            this.f9142e.f9135b.requestFocus();
        }
    }

    /* renamed from: c.a.q0.a.y0.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0569b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f9143e;

        public RunnableC0569b(b bVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9143e = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.r2.d.b.a.c().e(this.f9143e, -1.0f);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void onCustomViewHidden();
    }

    /* loaded from: classes.dex */
    public static class d implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Activity a;

        /* renamed from: b  reason: collision with root package name */
        public String f9144b;

        public d(Activity activity, String str) {
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
            this.a = activity;
            this.f9144b = str;
        }

        @Override // c.a.q0.a.g1.h
        public void a(c.a.q0.a.p.e.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) && TextUtils.equals(dVar.c(), this.f9144b)) {
                b.f(this.a, true);
                ((ViewGroup) this.a.getWindow().getDecorView()).setSystemUiVisibility(4098);
            }
        }

        @Override // c.a.q0.a.g1.h
        public void b(c.a.q0.a.p.e.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            }
        }

        @Override // c.a.q0.a.g1.h
        public void c(c.a.q0.a.p.e.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            }
        }

        @Override // c.a.q0.a.g1.h
        public void d(c.a.q0.a.p.e.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-876265826, "Lc/a/q0/a/y0/j/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-876265826, "Lc/a/q0/a/y0/j/b;");
                return;
            }
        }
        f9133i = k.a;
        f9134j = new FrameLayout.LayoutParams(-1, -1);
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
        this.a = context;
        this.f9139f = str;
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
                if (f9133i) {
                    String str2 = "addComponentToFullScreen: " + str;
                }
                c.a.q0.a.c0.b.a b2 = c.a.q0.a.c0.d.a.b(this.f9139f, str);
                if (b2 == null) {
                    return;
                }
                if ("coverView".equals(b2.n().f4685e) || "coverImage".equals(b2.n().f4685e)) {
                    if (this.f9136c == null) {
                        return;
                    }
                    SwanAppComponentContainerView m = b2.m();
                    if (m == null) {
                        return;
                    }
                    ViewParent parent = m.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(m);
                        this.f9136c.addView(m);
                    }
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f9135b == null) {
            return;
        }
        boolean z = f9133i;
        Context context = this.a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            q0.a0(new RunnableC0569b(this, activity));
            i.f(this.f9141h);
            this.f9141h = null;
            f(activity, false);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            viewGroup.removeView(this.f9136c);
            this.f9136c = null;
            this.f9135b = null;
            c cVar = this.f9140g;
            if (cVar != null) {
                cVar.onCustomViewHidden();
            }
            activity.setRequestedOrientation(this.f9137d);
            viewGroup.setSystemUiVisibility(this.f9138e);
        }
    }

    @UiThread
    public synchronized void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                if (f9133i) {
                    String str2 = "removeComponentFromFullScreen: " + str;
                }
                c.a.q0.a.c0.b.a b2 = c.a.q0.a.c0.d.a.b(this.f9139f, str);
                if (b2 == null) {
                    return;
                }
                if ("coverView".equals(b2.n().f4685e) || "coverImage".equals(b2.n().f4685e)) {
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

    public void g(View view, int i2, @Nullable c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, view, i2, cVar) == null) {
            boolean z = f9133i;
            Context context = this.a;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                if (this.f9135b != null) {
                    if (cVar != null) {
                        cVar.onCustomViewHidden();
                        this.f9140g = cVar;
                        return;
                    }
                    return;
                }
                this.f9137d = activity.getRequestedOrientation();
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
                this.f9136c = swanAppInlineFullScreenContainer;
                swanAppInlineFullScreenContainer.addView(view, f9134j);
                viewGroup.addView(this.f9136c, f9134j);
                this.f9135b = view;
                f(activity, true);
                activity.setRequestedOrientation(i2);
                if (c.a.q0.a.c1.a.M().a() && (activity instanceof SwanAppActivity)) {
                    ((SwanAppActivity) activity).onNightModeCoverChanged(true, false);
                }
                this.f9138e = viewGroup.getSystemUiVisibility();
                viewGroup.setSystemUiVisibility(4098);
                if (this.f9141h == null) {
                    this.f9141h = new d(activity, this.f9139f);
                }
                i.e(this.f9141h);
                q0.a0(new a(this));
            }
        }
    }
}
