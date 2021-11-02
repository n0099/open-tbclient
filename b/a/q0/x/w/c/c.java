package b.a.q0.x.w.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import b.a.q0.x.w.d.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f14237a;

    /* renamed from: b  reason: collision with root package name */
    public final View f14238b;

    /* renamed from: c  reason: collision with root package name */
    public final int f14239c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f14240d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.x.w.a f14241e;

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
        this.f14237a = -1;
        this.f14238b = view;
        this.f14239c = b.a.q0.x.w.d.c.a(view.getContext());
        this.f14240d = d.c((Activity) view.getContext());
    }

    public final b.a.q0.x.w.a a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view)) != null) {
            return (b.a.q0.x.w.a) invokeL.objValue;
        }
        b.a.q0.x.w.a aVar = this.f14241e;
        if (aVar != null) {
            return aVar;
        }
        if (view instanceof b.a.q0.x.w.a) {
            b.a.q0.x.w.a aVar2 = (b.a.q0.x.w.a) view;
            this.f14241e = aVar2;
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
                b.a.q0.x.w.a a2 = a(viewGroup.getChildAt(i2));
                if (a2 != null) {
                    this.f14241e = a2;
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
            if (this.f14240d && Build.VERSION.SDK_INT >= 16 && this.f14238b.getFitsSystemWindows()) {
                Rect rect = new Rect();
                this.f14238b.getWindowVisibleDisplayFrame(rect);
                i3 = rect.bottom - rect.top;
            }
            String str = "onMeasure, width: " + i2 + " height: " + i3;
            if (i3 < 0) {
                return;
            }
            int i4 = this.f14237a;
            if (i4 < 0) {
                this.f14237a = i3;
                return;
            }
            int i5 = i4 - i3;
            if (i5 == 0) {
                String str2 = "" + i5 + " == 0 break;";
            } else if (Math.abs(i5) == this.f14239c) {
                String.format("offset just equal statusBar height %d", Integer.valueOf(i5));
            } else {
                this.f14237a = i3;
                b.a.q0.x.w.a a2 = a(this.f14238b);
                if (a2 != null && Math.abs(i5) >= b.a.q0.x.w.d.b.f(this.f14238b.getContext())) {
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
