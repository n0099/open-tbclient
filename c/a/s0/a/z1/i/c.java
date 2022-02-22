package c.a.s0.a.z1.i;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import c.a.s0.a.k;
import c.a.s0.a.z1.j.e;
import c.a.s0.a.z1.j.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f10153e;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public final View f10154b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.a.z1.k.a f10155c;

    /* renamed from: d  reason: collision with root package name */
    public Context f10156d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(298002684, "Lc/a/s0/a/z1/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(298002684, "Lc/a/s0/a/z1/i/c;");
                return;
            }
        }
        f10153e = k.a;
    }

    public c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.f10154b = view;
        this.f10156d = view.getContext();
    }

    public final c.a.s0.a.z1.k.a a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
            c.a.s0.a.z1.k.a aVar = this.f10155c;
            if (aVar != null) {
                return aVar;
            }
            if (view instanceof c.a.s0.a.z1.k.a) {
                c.a.s0.a.z1.k.a aVar2 = (c.a.s0.a.z1.k.a) view;
                this.f10155c = aVar2;
                return aVar2;
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    c.a.s0.a.z1.k.a a = a(viewGroup.getChildAt(i2));
                    if (a != null) {
                        this.f10155c = a;
                        return a;
                    }
                }
                return null;
            } else {
                return null;
            }
        }
        return (c.a.s0.a.z1.k.a) invokeL.objValue;
    }

    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            Context context = this.f10156d;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (g.f(activity) && this.f10154b.getFitsSystemWindows()) {
                    Rect rect = new Rect();
                    this.f10154b.getWindowVisibleDisplayFrame(rect);
                    i3 = rect.bottom - rect.top;
                    if (f10153e) {
                        String str = "TranslucentStatus && FitsSystemWindows = true, height: " + i3;
                    }
                }
                if (g.e(activity) && this.f10154b.getFitsSystemWindows()) {
                    Rect rect2 = new Rect();
                    this.f10154b.getWindowVisibleDisplayFrame(rect2);
                    i3 = rect2.bottom - rect2.top;
                    if (f10153e) {
                        String str2 = "systemUILayoutFullScreen && FitsSystemWindows = true, height: " + i3;
                    }
                }
            }
            if (f10153e) {
                String str3 = "onMeasure, width: " + i2 + " height: " + i3;
            }
            if (i3 < 0) {
                return;
            }
            int i4 = this.a;
            if (i4 < 0) {
                if (f10153e) {
                    String str4 = "onMeasure, oldHeight < 0, oldHeight: " + this.a;
                }
                this.a = i3;
                return;
            }
            int i5 = i4 - i3;
            if (i5 == 0) {
                boolean z = f10153e;
                return;
            }
            this.a = i3;
            c.a.s0.a.z1.k.a a = a(this.f10154b);
            if (a == null) {
                boolean z2 = f10153e;
                return;
            }
            int visibility = ((LinearLayout) a).getVisibility();
            if (f10153e) {
                String str5 = "panel visibility: " + visibility;
            }
            if (Math.abs(i5) < e.g(this.f10154b.getContext())) {
                boolean z3 = f10153e;
            } else if (Math.abs(i5) > e.e(this.f10154b.getContext())) {
                boolean z4 = f10153e;
            } else if (i5 > 0) {
                if (f10153e) {
                    String str6 = "offset > 0, offset : " + i5 + ", panel->handleHide...";
                }
                a.handleHide();
            } else {
                if (f10153e) {
                    String str7 = "offset < 0, offset : " + i5 + ", panel->handleShow...";
                }
                a.handleShow();
            }
        }
    }
}
