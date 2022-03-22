package c.a.o0.w.x.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import c.a.o0.w.x.d.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public final View f11533b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11534c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f11535d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.w.x.a f11536e;

    public c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.f11533b = view;
        this.f11534c = c.a.o0.w.x.d.c.a(view.getContext());
        this.f11535d = d.c((Activity) view.getContext());
    }

    public final c.a.o0.w.x.a a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view)) != null) {
            return (c.a.o0.w.x.a) invokeL.objValue;
        }
        c.a.o0.w.x.a aVar = this.f11536e;
        if (aVar != null) {
            return aVar;
        }
        if (view instanceof c.a.o0.w.x.a) {
            c.a.o0.w.x.a aVar2 = (c.a.o0.w.x.a) view;
            this.f11536e = aVar2;
            return aVar2;
        } else if (!(view instanceof ViewGroup)) {
            return null;
        } else {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    return null;
                }
                c.a.o0.w.x.a a = a(viewGroup.getChildAt(i));
                if (a != null) {
                    this.f11536e = a;
                    return a;
                }
                i++;
            }
        }
    }

    @TargetApi(16)
    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            if (this.f11535d && Build.VERSION.SDK_INT >= 16 && this.f11533b.getFitsSystemWindows()) {
                Rect rect = new Rect();
                this.f11533b.getWindowVisibleDisplayFrame(rect);
                i2 = rect.bottom - rect.top;
            }
            Log.d("KPSRootLayoutHandler", "onMeasure, width: " + i + " height: " + i2);
            if (i2 < 0) {
                return;
            }
            int i3 = this.a;
            if (i3 < 0) {
                this.a = i2;
                return;
            }
            int i4 = i3 - i2;
            if (i4 == 0) {
                Log.d("KPSRootLayoutHandler", "" + i4 + " == 0 break;");
            } else if (Math.abs(i4) == this.f11534c) {
                Log.w("KPSRootLayoutHandler", String.format("offset just equal statusBar height %d", Integer.valueOf(i4)));
            } else {
                this.a = i2;
                c.a.o0.w.x.a a = a(this.f11533b);
                if (a == null) {
                    Log.w("KPSRootLayoutHandler", "can't find the valid panel conflict layout, give up!");
                } else if (Math.abs(i4) < c.a.o0.w.x.d.b.f(this.f11533b.getContext())) {
                    Log.w("KPSRootLayoutHandler", "system bottom-menu-bar(such as HuaWei Mate7) causes layout changed");
                } else if (i4 > 0) {
                    a.handleHide();
                } else if (a.b() && a.isVisible()) {
                    a.handleShow();
                }
            }
        }
    }
}
