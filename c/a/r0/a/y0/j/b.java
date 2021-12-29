package c.a.r0.a.y0.j;

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
import c.a.r0.a.g1.h;
import c.a.r0.a.g1.i;
import c.a.r0.a.k;
import c.a.r0.a.z2.q0;
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
    public static final boolean f9868i;

    /* renamed from: j  reason: collision with root package name */
    public static final ViewGroup.LayoutParams f9869j;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f9870b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f9871c;

    /* renamed from: d  reason: collision with root package name */
    public int f9872d;

    /* renamed from: e  reason: collision with root package name */
    public int f9873e;

    /* renamed from: f  reason: collision with root package name */
    public String f9874f;

    /* renamed from: g  reason: collision with root package name */
    public c f9875g;

    /* renamed from: h  reason: collision with root package name */
    public d f9876h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9877e;

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
            this.f9877e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9877e.f9870b == null) {
                return;
            }
            this.f9877e.f9870b.requestFocus();
        }
    }

    /* renamed from: c.a.r0.a.y0.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0619b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f9878e;

        public RunnableC0619b(b bVar, Activity activity) {
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
            this.f9878e = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.r2.d.b.a.c().e(this.f9878e, -1.0f);
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
        public String f9879b;

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
            this.f9879b = str;
        }

        @Override // c.a.r0.a.g1.h
        public void a(c.a.r0.a.p.e.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) && TextUtils.equals(dVar.c(), this.f9879b)) {
                b.f(this.a, true);
                ((ViewGroup) this.a.getWindow().getDecorView()).setSystemUiVisibility(4098);
            }
        }

        @Override // c.a.r0.a.g1.h
        public void b(c.a.r0.a.p.e.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            }
        }

        @Override // c.a.r0.a.g1.h
        public void c(c.a.r0.a.p.e.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            }
        }

        @Override // c.a.r0.a.g1.h
        public void d(c.a.r0.a.p.e.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-747183107, "Lc/a/r0/a/y0/j/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-747183107, "Lc/a/r0/a/y0/j/b;");
                return;
            }
        }
        f9868i = k.a;
        f9869j = new FrameLayout.LayoutParams(-1, -1);
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
        this.f9874f = str;
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
                if (f9868i) {
                    String str2 = "addComponentToFullScreen: " + str;
                }
                c.a.r0.a.c0.b.a b2 = c.a.r0.a.c0.d.a.b(this.f9874f, str);
                if (b2 == null) {
                    return;
                }
                if ("coverView".equals(b2.n().f5420e) || "coverImage".equals(b2.n().f5420e)) {
                    if (this.f9871c == null) {
                        return;
                    }
                    SwanAppComponentContainerView m = b2.m();
                    if (m == null) {
                        return;
                    }
                    ViewParent parent = m.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(m);
                        this.f9871c.addView(m);
                    }
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f9870b == null) {
            return;
        }
        boolean z = f9868i;
        Context context = this.a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            q0.a0(new RunnableC0619b(this, activity));
            i.f(this.f9876h);
            this.f9876h = null;
            f(activity, false);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            viewGroup.removeView(this.f9871c);
            this.f9871c = null;
            this.f9870b = null;
            c cVar = this.f9875g;
            if (cVar != null) {
                cVar.onCustomViewHidden();
            }
            activity.setRequestedOrientation(this.f9872d);
            viewGroup.setSystemUiVisibility(this.f9873e);
        }
    }

    @UiThread
    public synchronized void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                if (f9868i) {
                    String str2 = "removeComponentFromFullScreen: " + str;
                }
                c.a.r0.a.c0.b.a b2 = c.a.r0.a.c0.d.a.b(this.f9874f, str);
                if (b2 == null) {
                    return;
                }
                if ("coverView".equals(b2.n().f5420e) || "coverImage".equals(b2.n().f5420e)) {
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
            boolean z = f9868i;
            Context context = this.a;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                if (this.f9870b != null) {
                    if (cVar != null) {
                        cVar.onCustomViewHidden();
                        this.f9875g = cVar;
                        return;
                    }
                    return;
                }
                this.f9872d = activity.getRequestedOrientation();
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
                this.f9871c = swanAppInlineFullScreenContainer;
                swanAppInlineFullScreenContainer.addView(view, f9869j);
                viewGroup.addView(this.f9871c, f9869j);
                this.f9870b = view;
                f(activity, true);
                activity.setRequestedOrientation(i2);
                if (c.a.r0.a.c1.a.M().a() && (activity instanceof SwanAppActivity)) {
                    ((SwanAppActivity) activity).onNightModeCoverChanged(true, false);
                }
                this.f9873e = viewGroup.getSystemUiVisibility();
                viewGroup.setSystemUiVisibility(4098);
                if (this.f9876h == null) {
                    this.f9876h = new d(activity, this.f9874f);
                }
                i.e(this.f9876h);
                q0.a0(new a(this));
            }
        }
    }
}
