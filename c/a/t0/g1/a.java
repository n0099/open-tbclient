package c.a.t0.g1;

import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.s0.s.q.e2;
import c.a.t0.x3.j0.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static a a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            if (z && d()) {
                return new a();
            }
            return null;
        }
        return (a) invokeZ.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a.s0.b.d.s() : invokeV.booleanValue;
    }

    public static boolean e(FrsTabInfo frsTabInfo, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, frsTabInfo, i2)) == null) {
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                return false;
            }
            if (frsTabInfo != null && 505 == frsTabInfo.tab_id.intValue() && 91 == frsTabInfo.tab_type.intValue()) {
                return false;
            }
            return ((frsTabInfo != null && 502 == frsTabInfo.tab_id.intValue() && 91 == frsTabInfo.tab_type.intValue()) || i2 == 2) ? false : true;
        }
        return invokeLI.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1;
        }
        return invokeV.booleanValue;
    }

    public void b(List<n> list, boolean z, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{list, Boolean.valueOf(z), str}) == null) {
            int e2 = c.a.t0.f1.a.i().e();
            if (z) {
                i2 = c.a.t0.f1.a.i().f() - 1;
                for (n nVar : list) {
                    if (nVar instanceof e2) {
                        if (((e2) nVar).t0() != 1) {
                            break;
                        }
                        i2++;
                    }
                }
            } else {
                i2 = this.a;
            }
            this.a = c(i2, e2, list, str);
        }
    }

    public final int c(int i2, int i3, List<n> list, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), list, str})) == null) {
            if (list == null || list.size() == 0 || i2 > list.size() - 1) {
                return 0;
            }
            for (int i4 = 0; i4 < list.size(); i4++) {
                e2 e2Var = new e2();
                o oVar = new o();
                oVar.k(true);
                e2Var.M2 = oVar;
                oVar.j(str);
                list.add(i2, e2Var);
                i2 = i2 + i3 + 1;
                if (i2 > list.size() - 1) {
                    return (i2 - (list.size() - 1)) - 1;
                }
            }
            return 0;
        }
        return invokeCommon.intValue;
    }
}
