package com.baidu.tbadk.abtest.group;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.UsbAbTestSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ThreadCardGroupUbsABTest extends AbsGroupUbsABTest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId ABTEST_GROUP_KEY;
    public static final String SID_A = "70_2";
    public static final String SID_B = "70_3";
    public static final String SID_C = "70_4";
    public static final String SID_D = "70_5";
    public static final String SID_E = "70_6";
    public static final String SID_F = "71_2";
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList mABTestList;
    public UsbAbTestSwitch mCurrentUsbAbTest;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1890838782, "Lcom/baidu/tbadk/abtest/group/ThreadCardGroupUbsABTest;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1890838782, "Lcom/baidu/tbadk/abtest/group/ThreadCardGroupUbsABTest;");
                return;
            }
        }
        ABTEST_GROUP_KEY = BdUniqueId.gen();
    }

    public static UsbAbTestSwitch getCurrentCardInfoUbsABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return UbsABTestHelper.getUbsABTestByGroupKey(ABTEST_GROUP_KEY);
        }
        return (UsbAbTestSwitch) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.abtest.group.AbsGroupUbsABTest
    public ArrayList getABTestKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mABTestList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.abtest.group.AbsGroupUbsABTest
    public UsbAbTestSwitch getCurrentUsbAbTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCurrentUsbAbTest;
        }
        return (UsbAbTestSwitch) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.abtest.group.AbsGroupUbsABTest
    public BdUniqueId getGroupKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ABTEST_GROUP_KEY;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public ThreadCardGroupUbsABTest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.mABTestList = arrayList;
        arrayList.add(SID_A);
        this.mABTestList.add(SID_B);
        this.mABTestList.add(SID_C);
        this.mABTestList.add(SID_D);
        this.mABTestList.add(SID_E);
        this.mABTestList.add(SID_F);
    }

    public static boolean isCardInfoUbsABTest(UsbAbTestSwitch usbAbTestSwitch, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, usbAbTestSwitch, strArr)) == null) {
            return UbsABTestHelper.isABTestByKeys(usbAbTestSwitch, strArr);
        }
        return invokeLL.booleanValue;
    }

    public static boolean isCardInfoUbsABTest(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, strArr)) == null) {
            return isCardInfoUbsABTest(getCurrentCardInfoUbsABTest(), strArr);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.abtest.group.AbsGroupUbsABTest
    public void setCurrentUsbAbTest(UsbAbTestSwitch usbAbTestSwitch) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, usbAbTestSwitch) == null) {
            this.mCurrentUsbAbTest = usbAbTestSwitch;
        }
    }
}
