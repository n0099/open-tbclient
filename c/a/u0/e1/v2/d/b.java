package c.a.u0.e1.v2.d;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import c.a.u0.e1.c1;
import c.a.u0.e1.d1;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: TabBarLogic.java */
/* loaded from: classes8.dex */
public final /* synthetic */ class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (c.a.t0.b.d.u()) {
                return new a();
            }
            return new c();
        }
        return (d) invokeV.objValue;
    }

    @ColorInt
    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return SkinManager.getColor(c.a.t0.b.d.u() ? c1.CAM_X0108 : c1.CAM_X0107);
        }
        return invokeV.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return UtilHelper.getDimenPixelSize(c.a.t0.b.d.u() ? d1.T_X07 : d1.tbds42);
        }
        return invokeV.intValue;
    }
}
