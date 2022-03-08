package com.baidu.tbadk.abtest.group;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UsbAbTestSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class AuthVideoIconABTest extends AbsGroupUbsABTest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId ABTEST_GROUP_KEY;
    public static final String VIDEO_AUTHOR = "12_11_tieba_videofeed_v_a";
    public static final String VIDEO_AUTHOR_A = "12_11_tieba_videofeed_v_b";
    public static final String VIDEO_AUTHOR_B = "12_11_tieba_videofeed_v_c";
    public static final String VIDEO_AUTHOR_C = "12_11_tieba_videofeed_v_d";
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<String> mABTestList;
    public UsbAbTestSwitch mCurrentUsbAbTest;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1159199003, "Lcom/baidu/tbadk/abtest/group/AuthVideoIconABTest;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1159199003, "Lcom/baidu/tbadk/abtest/group/AuthVideoIconABTest;");
                return;
            }
        }
        ABTEST_GROUP_KEY = BdUniqueId.gen();
    }

    public AuthVideoIconABTest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ArrayList<String> arrayList = new ArrayList<>(4);
        this.mABTestList = arrayList;
        arrayList.add(VIDEO_AUTHOR);
        this.mABTestList.add(VIDEO_AUTHOR_A);
        this.mABTestList.add(VIDEO_AUTHOR_B);
        this.mABTestList.add(VIDEO_AUTHOR_C);
    }

    @Override // com.baidu.tbadk.abtest.group.AbsGroupUbsABTest
    public ArrayList<String> getABTestKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mABTestList : (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.abtest.group.AbsGroupUbsABTest
    public UsbAbTestSwitch getCurrentUsbAbTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCurrentUsbAbTest : (UsbAbTestSwitch) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.abtest.group.AbsGroupUbsABTest
    public BdUniqueId getGroupKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ABTEST_GROUP_KEY : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.abtest.group.AbsGroupUbsABTest
    public void setCurrentUsbAbTest(UsbAbTestSwitch usbAbTestSwitch) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, usbAbTestSwitch) == null) {
            this.mCurrentUsbAbTest = usbAbTestSwitch;
        }
    }
}
