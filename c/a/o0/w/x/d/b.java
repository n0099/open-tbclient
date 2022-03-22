package c.a.o0.w.x.d;

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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static int a;

    /* renamed from: b  reason: collision with root package name */
    public static int f11537b;

    /* renamed from: c  reason: collision with root package name */
    public static int f11538c;

    /* renamed from: d  reason: collision with root package name */
    public static int f11539d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final ViewGroup f11540b;

        /* renamed from: c  reason: collision with root package name */
        public final c.a.o0.w.x.b f11541c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f11542d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f11543e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f11544f;

        /* renamed from: g  reason: collision with root package name */
        public final int f11545g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f11546h;
        public final InterfaceC0867b i;
        public final int j;
        public boolean k;
        public int l;

        public a(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, c.a.o0.w.x.b bVar, InterfaceC0867b interfaceC0867b, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), viewGroup, bVar, interfaceC0867b, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0;
            this.k = false;
            this.f11540b = viewGroup;
            this.f11541c = bVar;
            this.f11542d = z;
            this.f11543e = z2;
            this.f11544f = z3;
            this.f11545g = c.a(viewGroup.getContext());
            this.i = interfaceC0867b;
            this.j = i;
        }

        private Context getContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.f11540b.getContext() : (Context) invokeV.objValue;
        }

        public final void a(int i) {
            int abs;
            int h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a == 0) {
                    this.a = i;
                    this.f11541c.refreshHeight(b.h(getContext()));
                    return;
                }
                if (c.a.o0.w.x.d.a.a(this.f11542d, this.f11543e, this.f11544f)) {
                    abs = ((View) this.f11540b.getParent()).getHeight() - i;
                } else {
                    abs = Math.abs(i - this.a);
                }
                if (abs <= b.f(getContext())) {
                    int height = ((View) this.f11540b.getParent()).getHeight() - i;
                    if (i >= this.a) {
                        return;
                    }
                    abs = height - this.f11545g;
                }
                if (abs == this.f11545g || !b.i(getContext(), abs) || this.f11541c.getHeight() == (h2 = b.h(getContext()))) {
                    return;
                }
                this.f11541c.refreshHeight(h2);
            }
        }

        public final void b(int i) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                View view = (View) this.f11540b.getParent();
                int height = view.getHeight() - view.getPaddingTop();
                if (c.a.o0.w.x.d.a.a(this.f11542d, this.f11543e, this.f11544f)) {
                    if (this.f11543e || height - i != this.f11545g) {
                        z = height > i;
                    } else {
                        z = this.f11546h;
                    }
                } else {
                    int i2 = this.f11540b.getResources().getDisplayMetrics().heightPixels;
                    int i3 = this.l;
                    if (i3 == 0) {
                        z = this.f11546h;
                    } else {
                        z = i < i3 - b.f(getContext());
                    }
                    this.l = Math.max(this.l, height);
                }
                if (this.f11546h != z) {
                    this.f11541c.a(z);
                    InterfaceC0867b interfaceC0867b = this.i;
                    if (interfaceC0867b != null) {
                        interfaceC0867b.a(z);
                    }
                }
                this.f11546h = z;
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(13)
        public void onGlobalLayout() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                View childAt = this.f11540b.getChildAt(0);
                View view = (View) this.f11540b.getParent();
                Rect rect = new Rect();
                if (this.f11543e) {
                    view.getWindowVisibleDisplayFrame(rect);
                    i = rect.bottom - rect.top;
                    if (!this.k) {
                        this.k = i == this.j;
                    }
                    if (!this.k) {
                        i += this.f11545g;
                    }
                } else if (childAt != null) {
                    childAt.getWindowVisibleDisplayFrame(rect);
                    i = rect.bottom - rect.top;
                } else {
                    i = -1;
                }
                if (i == -1) {
                    return;
                }
                a(i);
                b(i);
                this.a = i;
            }
        }
    }

    /* renamed from: c.a.o0.w.x.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0867b {
        void a(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1562160891, "Lc/a/o0/w/x/d/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1562160891, "Lc/a/o0/w/x/d/b;");
        }
    }

    @TargetApi(13)
    public static ViewTreeObserver.OnGlobalLayoutListener b(Activity activity, c.a.o0.w.x.b bVar, InterfaceC0867b interfaceC0867b) {
        InterceptResult invokeLLL;
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, activity, bVar, interfaceC0867b)) == null) {
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
            a aVar = new a(b2, c2, a2, viewGroup, bVar, interfaceC0867b, height);
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
                int l = c.a.o0.r.j0.b.k().l("key_last_keyboard_height", g(context.getResources()));
                a = l;
                if (l > 0) {
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
            if (f11537b == 0) {
                f11537b = resources.getDimensionPixelSize(R.dimen.max_editor_panel_height);
            }
            return f11537b;
        }
        return invokeL.intValue;
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (f11539d == 0) {
                f11539d = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702c1);
            }
            return f11539d;
        }
        return invokeL.intValue;
    }

    public static int g(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, resources)) == null) {
            if (f11538c == 0) {
                f11538c = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702c1);
            }
            return f11538c;
        }
        return invokeL.intValue;
    }

    public static int h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? Math.min(e(context.getResources()), Math.max(g(context.getResources()), d(context))) : invokeL.intValue;
    }

    public static boolean i(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, context, i)) == null) {
            if (a != i && i > 0) {
                a = i;
                TbadkCoreApplication.getInst().setKeyboardHeight(a);
                c.a.o0.r.j0.b.k().w("key_last_keyboard_height", i);
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
