package c.a.q0.x.w.d;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static int a;

    /* renamed from: b  reason: collision with root package name */
    public static int f13718b;

    /* renamed from: c  reason: collision with root package name */
    public static int f13719c;

    /* renamed from: d  reason: collision with root package name */
    public static int f13720d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f13721e;

        /* renamed from: f  reason: collision with root package name */
        public final ViewGroup f13722f;

        /* renamed from: g  reason: collision with root package name */
        public final c.a.q0.x.w.b f13723g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f13724h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f13725i;

        /* renamed from: j  reason: collision with root package name */
        public final boolean f13726j;

        /* renamed from: k  reason: collision with root package name */
        public final int f13727k;
        public boolean l;
        public final InterfaceC0834b m;
        public final int n;
        public boolean o;
        public int p;

        public a(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, c.a.q0.x.w.b bVar, InterfaceC0834b interfaceC0834b, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), viewGroup, bVar, interfaceC0834b, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13721e = 0;
            this.o = false;
            this.f13722f = viewGroup;
            this.f13723g = bVar;
            this.f13724h = z;
            this.f13725i = z2;
            this.f13726j = z3;
            this.f13727k = c.a(viewGroup.getContext());
            this.m = interfaceC0834b;
            this.n = i2;
        }

        private Context getContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.f13722f.getContext() : (Context) invokeV.objValue;
        }

        public final void a(int i2) {
            int abs;
            int h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f13721e == 0) {
                    this.f13721e = i2;
                    this.f13723g.refreshHeight(b.h(getContext()));
                    return;
                }
                if (c.a.q0.x.w.d.a.a(this.f13724h, this.f13725i, this.f13726j)) {
                    abs = ((View) this.f13722f.getParent()).getHeight() - i2;
                } else {
                    abs = Math.abs(i2 - this.f13721e);
                }
                if (abs <= b.f(getContext())) {
                    int height = ((View) this.f13722f.getParent()).getHeight() - i2;
                    if (i2 >= this.f13721e) {
                        return;
                    }
                    abs = height - this.f13727k;
                }
                if (abs == this.f13727k || !b.i(getContext(), abs) || this.f13723g.getHeight() == (h2 = b.h(getContext()))) {
                    return;
                }
                this.f13723g.refreshHeight(h2);
            }
        }

        public final void b(int i2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                View view = (View) this.f13722f.getParent();
                int height = view.getHeight() - view.getPaddingTop();
                if (c.a.q0.x.w.d.a.a(this.f13724h, this.f13725i, this.f13726j)) {
                    if (this.f13725i || height - i2 != this.f13727k) {
                        z = height > i2;
                    } else {
                        z = this.l;
                    }
                } else {
                    int i3 = this.f13722f.getResources().getDisplayMetrics().heightPixels;
                    int i4 = this.p;
                    if (i4 == 0) {
                        z = this.l;
                    } else {
                        z = i2 < i4 - b.f(getContext());
                    }
                    this.p = Math.max(this.p, height);
                }
                if (this.l != z) {
                    this.f13723g.onKeyboardShowing(z);
                    InterfaceC0834b interfaceC0834b = this.m;
                    if (interfaceC0834b != null) {
                        interfaceC0834b.onKeyboardShowing(z);
                    }
                }
                this.l = z;
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(13)
        public void onGlobalLayout() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                View childAt = this.f13722f.getChildAt(0);
                View view = (View) this.f13722f.getParent();
                Rect rect = new Rect();
                if (this.f13725i) {
                    view.getWindowVisibleDisplayFrame(rect);
                    i2 = rect.bottom - rect.top;
                    if (!this.o) {
                        this.o = i2 == this.n;
                    }
                    if (!this.o) {
                        i2 += this.f13727k;
                    }
                } else if (childAt != null) {
                    childAt.getWindowVisibleDisplayFrame(rect);
                    i2 = rect.bottom - rect.top;
                } else {
                    i2 = -1;
                }
                if (i2 == -1) {
                    return;
                }
                a(i2);
                b(i2);
                this.f13721e = i2;
            }
        }
    }

    /* renamed from: c.a.q0.x.w.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0834b {
        void onKeyboardShowing(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-317560643, "Lc/a/q0/x/w/d/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-317560643, "Lc/a/q0/x/w/d/b;");
        }
    }

    @TargetApi(13)
    public static ViewTreeObserver.OnGlobalLayoutListener b(Activity activity, c.a.q0.x.w.b bVar, InterfaceC0834b interfaceC0834b) {
        InterceptResult invokeLLL;
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, activity, bVar, interfaceC0834b)) == null) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            boolean b2 = d.b(activity);
            boolean c2 = d.c(activity);
            boolean a2 = d.a(activity);
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point = new Point();
                defaultDisplay.getSize(point);
                height = point.y;
            } else {
                height = defaultDisplay.getHeight();
            }
            a aVar = new a(b2, c2, a2, viewGroup, bVar, interfaceC0834b, height);
            viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
            return aVar;
        }
        return (ViewTreeObserver.OnGlobalLayoutListener) invokeLLL.objValue;
    }

    @TargetApi(16)
    public static void c(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, activity, onGlobalLayoutListener) == null) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            if (Build.VERSION.SDK_INT >= 16) {
                viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            } else {
                viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
            }
        }
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (a == 0) {
                int k2 = c.a.q0.s.e0.b.j().k("key_last_keyboard_height", g(context.getResources()));
                a = k2;
                if (k2 > 0) {
                    TbadkCoreApplication.getInst().setKeyboardHeight(a);
                }
            }
            return a;
        }
        return invokeL.intValue;
    }

    public static int e(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, resources)) == null) {
            if (f13718b == 0) {
                f13718b = resources.getDimensionPixelSize(R.dimen.max_editor_panel_height);
            }
            return f13718b;
        }
        return invokeL.intValue;
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (f13720d == 0) {
                f13720d = context.getResources().getDimensionPixelSize(R.dimen.ds460);
            }
            return f13720d;
        }
        return invokeL.intValue;
    }

    public static int g(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, resources)) == null) {
            if (f13719c == 0) {
                f13719c = resources.getDimensionPixelSize(R.dimen.ds460);
            }
            return f13719c;
        }
        return invokeL.intValue;
    }

    public static int h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? Math.min(e(context.getResources()), Math.max(g(context.getResources()), d(context))) : invokeL.intValue;
    }

    public static boolean i(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, context, i2)) == null) {
            if (a != i2 && i2 > 0) {
                a = i2;
                TbadkCoreApplication.getInst().setKeyboardHeight(a);
                c.a.q0.s.e0.b.j().v("key_last_keyboard_height", i2);
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static void j(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, view) == null) {
            view.requestFocus();
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
        }
    }
}
