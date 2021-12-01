package c.a.p0.a.z1.j;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static int a;

    /* renamed from: b  reason: collision with root package name */
    public static int f9098b;

    /* renamed from: c  reason: collision with root package name */
    public static int f9099c;

    /* renamed from: d  reason: collision with root package name */
    public static int f9100d;

    /* renamed from: e  reason: collision with root package name */
    public static int f9101e;

    /* renamed from: f  reason: collision with root package name */
    public static int f9102f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f9103g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f9104e;

        public a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9104e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.m(this.f9104e);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSoftInputShowing(boolean z);
    }

    /* loaded from: classes.dex */
    public static class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final c.a.p0.a.z1.k.b f9105e;

        /* renamed from: f  reason: collision with root package name */
        public final ViewGroup f9106f;

        /* renamed from: g  reason: collision with root package name */
        public final b f9107g;

        /* renamed from: h  reason: collision with root package name */
        public int f9108h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f9109i;

        /* renamed from: j  reason: collision with root package name */
        public final Activity f9110j;

        /* renamed from: k  reason: collision with root package name */
        public int f9111k;

        public c(Activity activity, ViewGroup viewGroup, c.a.p0.a.z1.k.b bVar, b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, viewGroup, bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9108h = 0;
            this.f9110j = activity;
            this.f9107g = bVar2;
            this.f9106f = viewGroup;
            this.f9105e = bVar;
        }

        private Context getContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.f9106f.getContext() : (Context) invokeV.objValue;
        }

        public final void a(int i2) {
            int abs;
            int j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f9108h == 0) {
                    this.f9108h = i2;
                    this.f9105e.refreshHeight(e.j(getContext()));
                }
                if (c.a.p0.a.z1.j.b.e(this.f9106f.getContext())) {
                    abs = ((View) this.f9106f.getParent()).getHeight() - i2;
                } else {
                    abs = Math.abs(i2 - this.f9108h);
                }
                if (abs > e.g(getContext())) {
                    if (!e.l(getContext(), abs) || this.f9105e.getHeight() == (j2 = e.j(getContext()))) {
                        return;
                    }
                    this.f9105e.refreshHeight(j2);
                } else if (Math.abs(abs) == e.i(this.f9106f.getContext())) {
                    this.f9108h -= abs;
                }
            }
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                View view = (View) this.f9106f.getParent();
                int height = view.getHeight() - view.getPaddingTop();
                boolean z = true;
                if (!c.a.p0.a.z1.j.b.e(this.f9106f.getContext())) {
                    int i3 = this.f9111k;
                    if (i3 == 0) {
                        z = this.f9109i;
                    } else if (i2 >= i3 - e.g(getContext())) {
                        z = false;
                    }
                    this.f9111k = Math.max(this.f9111k, height);
                } else if (height <= i2) {
                    z = false;
                }
                if (this.f9109i != z) {
                    this.f9105e.onSoftInputShowing(z);
                    b bVar = this.f9107g;
                    if (bVar != null) {
                        bVar.onSoftInputShowing(z);
                    }
                }
                this.f9109i = z;
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                View childAt = this.f9106f.getChildAt(0);
                Rect rect = new Rect();
                if (childAt == null) {
                    i2 = -1;
                } else if (!c.a.p0.a.z1.j.b.e(this.f9106f.getContext()) && (!g.e(this.f9110j) || !g.c(this.f9110j))) {
                    i2 = childAt.getHeight();
                } else {
                    childAt.getWindowVisibleDisplayFrame(rect);
                    i2 = rect.bottom - rect.top;
                }
                if (i2 == -1) {
                    return;
                }
                a(i2);
                b(i2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-89215620, "Lc/a/p0/a/z1/j/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-89215620, "Lc/a/p0/a/z1/j/e;");
        }
    }

    public static ViewTreeObserver.OnGlobalLayoutListener c(Activity activity, ViewGroup viewGroup, c.a.p0.a.z1.k.b bVar, b bVar2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, activity, viewGroup, bVar, bVar2)) == null) {
            if (viewGroup == null) {
                viewGroup = (ViewGroup) activity.findViewById(16908290);
            }
            c cVar = new c(activity, viewGroup, bVar, bVar2);
            viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(cVar);
            return cVar;
        }
        return (ViewTreeObserver.OnGlobalLayoutListener) invokeLLLL.objValue;
    }

    public static int d(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, resources)) == null) {
            if (f9100d == 0) {
                f9100d = resources.getDimensionPixelSize(c.a.p0.a.d.aiapps_max_panel_height);
            }
            return f9100d;
        }
        return invokeL.intValue;
    }

    public static int e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (f9098b == 0) {
                f9098b = context.getResources().getDimensionPixelSize(c.a.p0.a.d.aiapps_max_softinput_height);
            }
            return f9098b;
        }
        return invokeL.intValue;
    }

    public static int f(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, resources)) == null) {
            if (f9099c == 0) {
                f9099c = resources.getDimensionPixelSize(c.a.p0.a.d.aiapps_min_panel_height);
            }
            return f9099c;
        }
        return invokeL.intValue;
    }

    public static int g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (a == 0) {
                a = context.getResources().getDimensionPixelSize(c.a.p0.a.d.aiapps_min_softinput_height);
            }
            return a;
        }
        return invokeL.intValue;
    }

    public static int h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (f9101e == 0) {
                f9101e = c.a.p0.a.z1.h.e.a(context, f(context.getResources()));
            }
            return f9101e;
        }
        return invokeL.intValue;
    }

    public static synchronized int i(Context context) {
        InterceptResult invokeL;
        int i2;
        int identifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            synchronized (e.class) {
                if (!f9103g && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                    f9102f = context.getResources().getDimensionPixelSize(identifier);
                    f9103g = true;
                }
                i2 = f9102f;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static int j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) ? Math.min(d(context.getResources()), Math.max(f(context.getResources()), h(context))) : invokeL.intValue;
    }

    public static void k(@NonNull View view) {
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, view) == null) || (inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static boolean l(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, context, i2)) == null) {
            if (f9101e != i2 && i2 >= 0) {
                f9101e = i2;
                return c.a.p0.a.z1.h.e.b(context, i2);
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static void m(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, view) == null) {
            view.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(view, 0);
            }
        }
    }

    public static void n(View view, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65550, null, view, j2) == null) {
            view.postDelayed(new a(view), j2);
        }
    }
}
