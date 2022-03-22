package c.a.p0.h1;

import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.AdMixFloor;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? UbsABTestHelper.isFrsFunAdSdkTest() : invokeV.booleanValue;
    }

    public static boolean e(FrsTabInfo frsTabInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, frsTabInfo, i)) == null) {
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                return false;
            }
            if (frsTabInfo != null && 505 == frsTabInfo.tab_id.intValue() && 91 == frsTabInfo.tab_type.intValue()) {
                return false;
            }
            return ((frsTabInfo != null && 502 == frsTabInfo.tab_id.intValue() && 91 == frsTabInfo.tab_type.intValue()) || i == 2) ? false : true;
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{list, Boolean.valueOf(z), str}) == null) {
            int e2 = c.a.p0.g1.b.j().e();
            if (z) {
                i = c.a.p0.g1.b.j().f() - 1;
                for (n nVar : list) {
                    if (nVar instanceof ThreadData) {
                        if (((ThreadData) nVar).getIs_top() != 1) {
                            break;
                        }
                        i++;
                    }
                }
            } else {
                i = this.a;
            }
            this.a = c(i, e2, list, str);
        }
    }

    public final int c(int i, int i2, List<n> list, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), list, str})) == null) {
            if (list == null || list.size() == 0 || i > list.size() - 1) {
                return 0;
            }
            for (int i3 = 0; i3 < list.size(); i3++) {
                ThreadData threadData = new ThreadData();
                c.a.p0.a4.k0.n nVar = new c.a.p0.a4.k0.n();
                nVar.k(true);
                threadData.funAdData = nVar;
                nVar.j(str);
                list.add(i, threadData);
                i = i + i2 + 1;
                if (i > list.size() - 1) {
                    return (i - (list.size() - 1)) - 1;
                }
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public void g(List<n> list, List<AdMixFloor> list2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, list2, Boolean.valueOf(z), str}) == null) {
            if (((AdMixFloor) ListUtils.getItem(list2, 0)) == null) {
                return;
            }
            int i = 0;
            for (int i2 = 0; z && i2 < list.size(); i2++) {
                n nVar = list.get(i2);
                if (nVar instanceof ThreadData) {
                    if (((ThreadData) nVar).getIs_top() != 1) {
                        break;
                    }
                    i++;
                }
            }
            for (int i3 = 0; i3 < list2.size(); i3++) {
                AdMixFloor adMixFloor = list2.get(i3);
                if (adMixFloor.ad_type.intValue() != 1) {
                    ThreadData threadData = new ThreadData();
                    c.a.p0.a4.k0.n nVar2 = new c.a.p0.a4.k0.n();
                    nVar2.k(true);
                    threadData.funAdData = nVar2;
                    nVar2.j(str);
                    ListUtils.add(list, (adMixFloor.floor_num.intValue() + i) - 1, threadData);
                }
            }
        }
    }
}
