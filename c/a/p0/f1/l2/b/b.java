package c.a.p0.f1.l2.b;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: HeaderViewLogic.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (UbsABTestHelper.isFrsModifyABTestA()) {
                return new e();
            }
            return new d();
        }
        return (c) invokeV.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? UbsABTestHelper.isFrsModifyABTestA() : invokeV.booleanValue;
    }

    @NonNull
    public static TextView c(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
            if (b()) {
                TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090a18);
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(textView);
                d2.n(R.string.obfuscated_res_0x7f0f00a6);
                d2.f(R.color.CAM_X0604);
                c.a.o0.r.v.c.d(textView).v(R.color.CAM_X0619);
                return textView;
            }
            TextView textView2 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090d1b);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(textView2);
            d3.n(R.string.J_X01);
            d3.f(R.color.CAM_X0602);
            c.a.o0.r.v.c.d(textView2).v(R.color.CAM_X0617);
            textView2.bringToFront();
            return textView2;
        }
        return (TextView) invokeL.objValue;
    }

    public static void d(@NonNull View view, @NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, view, view2) == null) {
            if (b()) {
                c.a.o0.r.v.c.d(view2).o(new int[]{R.color.black_alpha0, R.color.black_alpha30});
                return;
            }
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(view);
            d2.n(R.string.J_X11);
            d2.s(R.array.Mask_X005);
        }
    }
}
