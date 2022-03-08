package c.a.r0.d1.l2.d;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: TabBarLogic.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (UbsABTestHelper.isFrsModifyABTestA()) {
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
            return SkinManager.getColor(UbsABTestHelper.isFrsModifyABTestA() ? R.color.CAM_X0108 : R.color.CAM_X0107);
        }
        return invokeV.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return UtilHelper.getDimenPixelSize(UbsABTestHelper.isFrsModifyABTestA() ? R.dimen.T_X07 : R.dimen.tbds42);
        }
        return invokeV.intValue;
    }
}
