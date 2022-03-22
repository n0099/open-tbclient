package c.a.n0.a.p1.i;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import c.a.n0.a.p1.j.e;
import c.a.n0.a.p1.j.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f5769e;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public final View f5770b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.a.p1.k.a f5771c;

    /* renamed from: d  reason: collision with root package name */
    public Context f5772d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-632513129, "Lc/a/n0/a/p1/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-632513129, "Lc/a/n0/a/p1/i/c;");
                return;
            }
        }
        f5769e = c.a.n0.a.a.a;
    }

    public c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.f5770b = view;
        this.f5772d = view.getContext();
    }

    public final c.a.n0.a.p1.k.a a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
            c.a.n0.a.p1.k.a aVar = this.f5771c;
            if (aVar != null) {
                return aVar;
            }
            if (view instanceof c.a.n0.a.p1.k.a) {
                c.a.n0.a.p1.k.a aVar2 = (c.a.n0.a.p1.k.a) view;
                this.f5771c = aVar2;
                return aVar2;
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    c.a.n0.a.p1.k.a a = a(viewGroup.getChildAt(i));
                    if (a != null) {
                        this.f5771c = a;
                        return a;
                    }
                }
                return null;
            } else {
                return null;
            }
        }
        return (c.a.n0.a.p1.k.a) invokeL.objValue;
    }

    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            Context context = this.f5772d;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (g.f(activity) && this.f5770b.getFitsSystemWindows()) {
                    Rect rect = new Rect();
                    this.f5770b.getWindowVisibleDisplayFrame(rect);
                    i2 = rect.bottom - rect.top;
                    if (f5769e) {
                        Log.d("SPSwitchRootLayout", "TranslucentStatus && FitsSystemWindows = true, height: " + i2);
                    }
                }
                if (g.e(activity) && this.f5770b.getFitsSystemWindows()) {
                    Rect rect2 = new Rect();
                    this.f5770b.getWindowVisibleDisplayFrame(rect2);
                    i2 = rect2.bottom - rect2.top;
                    if (f5769e) {
                        Log.d("SPSwitchRootLayout", "systemUILayoutFullScreen && FitsSystemWindows = true, height: " + i2);
                    }
                }
            }
            if (f5769e) {
                Log.d("SPSwitchRootLayout", "onMeasure, width: " + i + " height: " + i2);
            }
            if (i2 < 0) {
                return;
            }
            int i3 = this.a;
            if (i3 < 0) {
                if (f5769e) {
                    Log.d("SPSwitchRootLayout", "onMeasure, oldHeight < 0, oldHeight: " + this.a);
                }
                this.a = i2;
                return;
            }
            int i4 = i3 - i2;
            if (i4 == 0) {
                if (f5769e) {
                    Log.d("SPSwitchRootLayout", "offset == 0, break;");
                    return;
                }
                return;
            }
            this.a = i2;
            c.a.n0.a.p1.k.a a = a(this.f5770b);
            if (a == null) {
                if (f5769e) {
                    Log.d("SPSwitchRootLayout", "cannot find the valid panel layout, give up!");
                    return;
                }
                return;
            }
            int visibility = ((LinearLayout) a).getVisibility();
            if (f5769e) {
                Log.d("SPSwitchRootLayout", "panel visibility: " + visibility);
            }
            if (Math.abs(i4) < e.g(this.f5770b.getContext())) {
                if (f5769e) {
                    Log.d("SPSwitchRootLayout", "layout change min, not caused by softinput/panel switch!");
                }
            } else if (Math.abs(i4) > e.e(this.f5770b.getContext())) {
                if (f5769e) {
                    Log.d("SPSwitchRootLayout", "layout change max , but not caused by softinput/panel switch!");
                }
            } else if (i4 > 0) {
                if (f5769e) {
                    Log.d("SPSwitchRootLayout", "offset > 0, offset : " + i4 + ", panel->handleHide...");
                }
                a.handleHide();
            } else {
                if (f5769e) {
                    Log.d("SPSwitchRootLayout", "offset < 0, offset : " + i4 + ", panel->handleShow...");
                }
                a.handleShow();
            }
        }
    }
}
