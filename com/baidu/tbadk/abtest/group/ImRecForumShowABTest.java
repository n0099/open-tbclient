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
/* loaded from: classes2.dex */
public class ImRecForumShowABTest extends AbsGroupUbsABTest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId ABTEST_GROUP_KEY;
    public static final String TYPE_A = "12_8_rec_forum_a";
    public static final String TYPE_B = "12_8_rec_forum";
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<String> mABTestList;
    public UsbAbTestSwitch mCurrentUsbAbTest;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1697933843, "Lcom/baidu/tbadk/abtest/group/ImRecForumShowABTest;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1697933843, "Lcom/baidu/tbadk/abtest/group/ImRecForumShowABTest;");
                return;
            }
        }
        ABTEST_GROUP_KEY = BdUniqueId.gen();
    }

    public ImRecForumShowABTest() {
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
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.mABTestList = arrayList;
        arrayList.add(TYPE_A);
        this.mABTestList.add(TYPE_B);
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
