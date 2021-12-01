package c.a.q0.x.w.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import c.a.q0.x.w.d.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public final View f13714b;

    /* renamed from: c  reason: collision with root package name */
    public final int f13715c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f13716d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.x.w.a f13717e;

    public c(View view) {
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
        this.a = -1;
        this.f13714b = view;
        this.f13715c = c.a.q0.x.w.d.c.a(view.getContext());
        this.f13716d = d.c((Activity) view.getContext());
    }

    public final c.a.q0.x.w.a a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view)) != null) {
            return (c.a.q0.x.w.a) invokeL.objValue;
        }
        c.a.q0.x.w.a aVar = this.f13717e;
        if (aVar != null) {
            return aVar;
        }
        if (view instanceof c.a.q0.x.w.a) {
            c.a.q0.x.w.a aVar2 = (c.a.q0.x.w.a) view;
            this.f13717e = aVar2;
            return aVar2;
        } else if (!(view instanceof ViewGroup)) {
            return null;
        } else {
            int i2 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i2 >= viewGroup.getChildCount()) {
                    return null;
                }
                c.a.q0.x.w.a a = a(viewGroup.getChildAt(i2));
                if (a != null) {
                    this.f13717e = a;
                    return a;
                }
                i2++;
            }
        }
    }

    @TargetApi(16)
    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            if (this.f13716d && Build.VERSION.SDK_INT >= 16 && this.f13714b.getFitsSystemWindows()) {
                Rect rect = new Rect();
                this.f13714b.getWindowVisibleDisplayFrame(rect);
                i3 = rect.bottom - rect.top;
            }
            String str = "onMeasure, width: " + i2 + " height: " + i3;
            if (i3 < 0) {
                return;
            }
            int i4 = this.a;
            if (i4 < 0) {
                this.a = i3;
                return;
            }
            int i5 = i4 - i3;
            if (i5 == 0) {
                String str2 = "" + i5 + " == 0 break;";
            } else if (Math.abs(i5) == this.f13715c) {
                String.format("offset just equal statusBar height %d", Integer.valueOf(i5));
            } else {
                this.a = i3;
                c.a.q0.x.w.a a = a(this.f13714b);
                if (a != null && Math.abs(i5) >= c.a.q0.x.w.d.b.f(this.f13714b.getContext())) {
                    if (i5 > 0) {
                        a.handleHide();
                    } else if (a.isKeyboardShowing() && a.isVisible()) {
                        a.handleShow();
                    }
                }
            }
        }
    }
}
