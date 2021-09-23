package c.a.p0.a.w1.i;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import c.a.p0.a.k;
import c.a.p0.a.w1.j.e;
import c.a.p0.a.w1.j.g;
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
    public static final boolean f9554e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f9555a;

    /* renamed from: b  reason: collision with root package name */
    public final View f9556b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.a.w1.k.a f9557c;

    /* renamed from: d  reason: collision with root package name */
    public Context f9558d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1543210780, "Lc/a/p0/a/w1/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1543210780, "Lc/a/p0/a/w1/i/c;");
                return;
            }
        }
        f9554e = k.f7085a;
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
        this.f9555a = -1;
        this.f9556b = view;
        this.f9558d = view.getContext();
    }

    public final c.a.p0.a.w1.k.a a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
            c.a.p0.a.w1.k.a aVar = this.f9557c;
            if (aVar != null) {
                return aVar;
            }
            if (view instanceof c.a.p0.a.w1.k.a) {
                c.a.p0.a.w1.k.a aVar2 = (c.a.p0.a.w1.k.a) view;
                this.f9557c = aVar2;
                return aVar2;
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    c.a.p0.a.w1.k.a a2 = a(viewGroup.getChildAt(i2));
                    if (a2 != null) {
                        this.f9557c = a2;
                        return a2;
                    }
                }
                return null;
            } else {
                return null;
            }
        }
        return (c.a.p0.a.w1.k.a) invokeL.objValue;
    }

    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            Context context = this.f9558d;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (g.f(activity) && this.f9556b.getFitsSystemWindows()) {
                    Rect rect = new Rect();
                    this.f9556b.getWindowVisibleDisplayFrame(rect);
                    i3 = rect.bottom - rect.top;
                    if (f9554e) {
                        String str = "TranslucentStatus && FitsSystemWindows = true, height: " + i3;
                    }
                }
                if (g.e(activity) && this.f9556b.getFitsSystemWindows()) {
                    Rect rect2 = new Rect();
                    this.f9556b.getWindowVisibleDisplayFrame(rect2);
                    i3 = rect2.bottom - rect2.top;
                    if (f9554e) {
                        String str2 = "systemUILayoutFullScreen && FitsSystemWindows = true, height: " + i3;
                    }
                }
            }
            if (f9554e) {
                String str3 = "onMeasure, width: " + i2 + " height: " + i3;
            }
            if (i3 < 0) {
                return;
            }
            int i4 = this.f9555a;
            if (i4 < 0) {
                if (f9554e) {
                    String str4 = "onMeasure, oldHeight < 0, oldHeight: " + this.f9555a;
                }
                this.f9555a = i3;
                return;
            }
            int i5 = i4 - i3;
            if (i5 == 0) {
                boolean z = f9554e;
                return;
            }
            this.f9555a = i3;
            c.a.p0.a.w1.k.a a2 = a(this.f9556b);
            if (a2 == null) {
                boolean z2 = f9554e;
                return;
            }
            int visibility = ((LinearLayout) a2).getVisibility();
            if (f9554e) {
                String str5 = "panel visibility: " + visibility;
            }
            if (Math.abs(i5) < e.g(this.f9556b.getContext())) {
                boolean z3 = f9554e;
            } else if (Math.abs(i5) > e.e(this.f9556b.getContext())) {
                boolean z4 = f9554e;
            } else if (i5 > 0) {
                if (f9554e) {
                    String str6 = "offset > 0, offset : " + i5 + ", panel->handleHide...";
                }
                a2.handleHide();
            } else {
                if (f9554e) {
                    String str7 = "offset < 0, offset : " + i5 + ", panel->handleShow...";
                }
                a2.handleShow();
            }
        }
    }
}
