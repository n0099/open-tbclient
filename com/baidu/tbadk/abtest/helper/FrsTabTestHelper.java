package com.baidu.tbadk.abtest.helper;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xt4;
/* loaded from: classes2.dex */
public class FrsTabTestHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static String FRS_NEW_AREA_TAB_SORT_KEY = "key_frs_new_area_tab_sort_";
    public static int HAVE_NOT_RECORD_SORT = Integer.MAX_VALUE;
    public static final int HOT_TAB_ID = 1;
    public static final String HOT_TAB_NAME;
    public static final int NEW_AREA_TAB_ID = 503;
    public static final String NEW_AREA_TAB_NAME;
    public static String USER_LAST_ACCESS_KEY = "key_user_last_access_tab_";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(58797253, "Lcom/baidu/tbadk/abtest/helper/FrsTabTestHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(58797253, "Lcom/baidu/tbadk/abtest/helper/FrsTabTestHelper;");
                return;
            }
        }
        HOT_TAB_NAME = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0704);
        NEW_AREA_TAB_NAME = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0724);
    }

    public FrsTabTestHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String generateFrsNewAreaTabSortKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return FRS_NEW_AREA_TAB_SORT_KEY + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeV.objValue;
    }

    public static String generateUserLastAccessKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return USER_LAST_ACCESS_KEY + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeV.objValue;
    }

    public static int getDefaultShowTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (UbsABTestHelper.isFrsTabLocationTestA()) {
                return 1;
            }
            if (UbsABTestHelper.isFrsTabLocationTestB()) {
                return 503;
            }
            if (UbsABTestHelper.isFrsTabLocationTestC()) {
                return tabNameToIdMap(getUserLastAccessTab());
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public static int getFrsNewAreaTabSort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? xt4.k().l(generateFrsNewAreaTabSortKey(), HAVE_NOT_RECORD_SORT) : invokeV.intValue;
    }

    public static String getUserLastAccessTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? xt4.k().q(generateUserLastAccessKey(), HOT_TAB_NAME) : (String) invokeV.objValue;
    }

    public static void storeFrsNewAreaTabSort(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i) == null) {
            xt4.k().w(generateFrsNewAreaTabSortKey(), i);
        }
    }

    public static void storeUserLastAccessTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            if (HOT_TAB_NAME.equals(str) || NEW_AREA_TAB_NAME.equals(str)) {
                xt4.k().y(generateUserLastAccessKey(), str);
            }
        }
    }

    public static int tabNameToIdMap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? (!HOT_TAB_NAME.equals(str) && NEW_AREA_TAB_NAME.equals(str)) ? 503 : 1 : invokeL.intValue;
    }
}
