package c.a.p0.x.v.d;

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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f15127a;

    /* renamed from: b  reason: collision with root package name */
    public static int f15128b;

    /* renamed from: c  reason: collision with root package name */
    public static int f15129c;

    /* renamed from: d  reason: collision with root package name */
    public static int f15130d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f15131e;

        /* renamed from: f  reason: collision with root package name */
        public final ViewGroup f15132f;

        /* renamed from: g  reason: collision with root package name */
        public final c.a.p0.x.v.b f15133g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f15134h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f15135i;

        /* renamed from: j  reason: collision with root package name */
        public final boolean f15136j;
        public final int k;
        public boolean l;
        public final InterfaceC0720b m;
        public final int n;
        public boolean o;
        public int p;

        public a(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, c.a.p0.x.v.b bVar, InterfaceC0720b interfaceC0720b, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), viewGroup, bVar, interfaceC0720b, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15131e = 0;
            this.o = false;
            this.f15132f = viewGroup;
            this.f15133g = bVar;
            this.f15134h = z;
            this.f15135i = z2;
            this.f15136j = z3;
            this.k = c.a(viewGroup.getContext());
            this.m = interfaceC0720b;
            this.n = i2;
        }

        public final void a(int i2) {
            int abs;
            int h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f15131e == 0) {
                    this.f15131e = i2;
                    this.f15133g.refreshHeight(b.h(c()));
                    return;
                }
                if (c.a.p0.x.v.d.a.a(this.f15134h, this.f15135i, this.f15136j)) {
                    abs = ((View) this.f15132f.getParent()).getHeight() - i2;
                } else {
                    abs = Math.abs(i2 - this.f15131e);
                }
                if (abs <= b.f(c())) {
                    int height = ((View) this.f15132f.getParent()).getHeight() - i2;
                    if (i2 >= this.f15131e) {
                        return;
                    }
                    abs = height - this.k;
                }
                if (abs == this.k || !b.i(c(), abs) || this.f15133g.getHeight() == (h2 = b.h(c()))) {
                    return;
                }
                this.f15133g.refreshHeight(h2);
            }
        }

        public final void b(int i2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                View view = (View) this.f15132f.getParent();
                int height = view.getHeight() - view.getPaddingTop();
                if (c.a.p0.x.v.d.a.a(this.f15134h, this.f15135i, this.f15136j)) {
                    if (this.f15135i || height - i2 != this.k) {
                        z = height > i2;
                    } else {
                        z = this.l;
                    }
                } else {
                    int i3 = this.f15132f.getResources().getDisplayMetrics().heightPixels;
                    int i4 = this.p;
                    if (i4 == 0) {
                        z = this.l;
                    } else {
                        z = i2 < i4 - b.f(c());
                    }
                    this.p = Math.max(this.p, height);
                }
                if (this.l != z) {
                    this.f15133g.onKeyboardShowing(z);
                    InterfaceC0720b interfaceC0720b = this.m;
                    if (interfaceC0720b != null) {
                        interfaceC0720b.onKeyboardShowing(z);
                    }
                }
                this.l = z;
            }
        }

        public final Context c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15132f.getContext() : (Context) invokeV.objValue;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(13)
        public void onGlobalLayout() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                View childAt = this.f15132f.getChildAt(0);
                View view = (View) this.f15132f.getParent();
                Rect rect = new Rect();
                if (this.f15135i) {
                    view.getWindowVisibleDisplayFrame(rect);
                    i2 = rect.bottom - rect.top;
                    if (!this.o) {
                        this.o = i2 == this.n;
                    }
                    if (!this.o) {
                        i2 += this.k;
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
                this.f15131e = i2;
            }
        }
    }

    /* renamed from: c.a.p0.x.v.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0720b {
        void onKeyboardShowing(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1450761565, "Lc/a/p0/x/v/d/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1450761565, "Lc/a/p0/x/v/d/b;");
        }
    }

    @TargetApi(13)
    public static ViewTreeObserver.OnGlobalLayoutListener b(Activity activity, c.a.p0.x.v.b bVar, InterfaceC0720b interfaceC0720b) {
        InterceptResult invokeLLL;
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, activity, bVar, interfaceC0720b)) == null) {
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
            a aVar = new a(b2, c2, a2, viewGroup, bVar, interfaceC0720b, height);
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
            if (f15127a == 0) {
                int k = c.a.p0.s.d0.b.j().k("key_last_keyboard_height", g(context.getResources()));
                f15127a = k;
                if (k > 0) {
                    TbadkCoreApplication.getInst().setKeyboardHeight(f15127a);
                }
            }
            return f15127a;
        }
        return invokeL.intValue;
    }

    public static int e(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, resources)) == null) {
            if (f15128b == 0) {
                f15128b = resources.getDimensionPixelSize(R.dimen.max_editor_panel_height);
            }
            return f15128b;
        }
        return invokeL.intValue;
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            if (f15130d == 0) {
                f15130d = context.getResources().getDimensionPixelSize(R.dimen.ds460);
            }
            return f15130d;
        }
        return invokeL.intValue;
    }

    public static int g(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, resources)) == null) {
            if (f15129c == 0) {
                f15129c = resources.getDimensionPixelSize(R.dimen.ds460);
            }
            return f15129c;
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
            if (f15127a != i2 && i2 > 0) {
                f15127a = i2;
                TbadkCoreApplication.getInst().setKeyboardHeight(f15127a);
                c.a.p0.s.d0.b.j().v("key_last_keyboard_height", i2);
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
