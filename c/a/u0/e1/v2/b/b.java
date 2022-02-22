package c.a.u0.e1.v2.b;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import c.a.u0.e1.b1;
import c.a.u0.e1.c1;
import c.a.u0.e1.f1;
import c.a.u0.e1.i1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: HeaderViewLogic.java */
/* loaded from: classes8.dex */
public final /* synthetic */ class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (c.a.t0.b.d.u()) {
                return new e();
            }
            return new d();
        }
        return (c) invokeV.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a.t0.b.d.u() : invokeV.booleanValue;
    }

    @NonNull
    public static TextView c(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
            if (b()) {
                TextView textView = (TextView) view.findViewById(f1.forum_ad_icon);
                c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(textView);
                d2.n(i1.ad_icon_corner);
                d2.f(c1.CAM_X0604);
                c.a.t0.s.v.c.d(textView).v(c1.CAM_X0619);
                return textView;
            }
            TextView textView2 = (TextView) view.findViewById(f1.head_ad_lable_icon_layout);
            c.a.t0.s.v.c d3 = c.a.t0.s.v.c.d(textView2);
            d3.n(i1.J_X01);
            d3.f(c1.CAM_X0602);
            c.a.t0.s.v.c.d(textView2).v(c1.CAM_X0617);
            textView2.bringToFront();
            return textView2;
        }
        return (TextView) invokeL.objValue;
    }

    public static void d(@NonNull View view, @NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, view, view2) == null) {
            if (b()) {
                c.a.t0.s.v.c.d(view2).o(new int[]{c1.black_alpha0, c1.black_alpha30});
                return;
            }
            c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(view);
            d2.n(i1.J_X11);
            d2.s(b1.Mask_X005);
        }
    }
}
