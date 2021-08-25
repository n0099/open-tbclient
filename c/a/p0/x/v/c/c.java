package c.a.p0.x.v.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import c.a.p0.x.v.d.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f15122a;

    /* renamed from: b  reason: collision with root package name */
    public final View f15123b;

    /* renamed from: c  reason: collision with root package name */
    public final int f15124c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f15125d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.x.v.a f15126e;

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
        this.f15122a = -1;
        this.f15123b = view;
        this.f15124c = c.a.p0.x.v.d.c.a(view.getContext());
        this.f15125d = d.c((Activity) view.getContext());
    }

    public final c.a.p0.x.v.a a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view)) != null) {
            return (c.a.p0.x.v.a) invokeL.objValue;
        }
        c.a.p0.x.v.a aVar = this.f15126e;
        if (aVar != null) {
            return aVar;
        }
        if (view instanceof c.a.p0.x.v.a) {
            c.a.p0.x.v.a aVar2 = (c.a.p0.x.v.a) view;
            this.f15126e = aVar2;
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
                c.a.p0.x.v.a a2 = a(viewGroup.getChildAt(i2));
                if (a2 != null) {
                    this.f15126e = a2;
                    return a2;
                }
                i2++;
            }
        }
    }

    @TargetApi(16)
    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            if (this.f15125d && Build.VERSION.SDK_INT >= 16 && this.f15123b.getFitsSystemWindows()) {
                Rect rect = new Rect();
                this.f15123b.getWindowVisibleDisplayFrame(rect);
                i3 = rect.bottom - rect.top;
            }
            String str = "onMeasure, width: " + i2 + " height: " + i3;
            if (i3 < 0) {
                return;
            }
            int i4 = this.f15122a;
            if (i4 < 0) {
                this.f15122a = i3;
                return;
            }
            int i5 = i4 - i3;
            if (i5 == 0) {
                String str2 = "" + i5 + " == 0 break;";
            } else if (Math.abs(i5) == this.f15124c) {
                String.format("offset just equal statusBar height %d", Integer.valueOf(i5));
            } else {
                this.f15122a = i3;
                c.a.p0.x.v.a a2 = a(this.f15123b);
                if (a2 != null && Math.abs(i5) >= c.a.p0.x.v.d.b.f(this.f15123b.getContext())) {
                    if (i5 > 0) {
                        a2.handleHide();
                    } else if (a2.isKeyboardShowing() && a2.isVisible()) {
                        a2.handleShow();
                    }
                }
            }
        }
    }
}
