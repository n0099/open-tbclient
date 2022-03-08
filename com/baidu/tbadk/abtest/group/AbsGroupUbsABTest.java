package com.baidu.tbadk.abtest.group;

import c.a.d.o.e.n;
import c.a.q0.r.r.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.UsbAbTestSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class AbsGroupUbsABTest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AbsGroupUbsABTest() {
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

    public static void setCardInfoUbsABTest(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || list == null) {
            return;
        }
        HashMap hashMap = new HashMap(UbsABTestHelper.getUbsABTestMap());
        for (n nVar : list) {
            if (nVar instanceof a) {
                a aVar = (a) nVar;
                for (Map.Entry entry : hashMap.entrySet()) {
                    aVar.setABTest((BdUniqueId) entry.getKey(), (UsbAbTestSwitch) entry.getValue());
                }
            }
        }
    }

    public abstract ArrayList<String> getABTestKeys();

    public abstract UsbAbTestSwitch getCurrentUsbAbTest();

    public abstract BdUniqueId getGroupKey();

    public abstract void setCurrentUsbAbTest(UsbAbTestSwitch usbAbTestSwitch);

    public static void setCardInfoUbsABTest(IThreadCardUbsABTest... iThreadCardUbsABTestArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, iThreadCardUbsABTestArr) == null) || iThreadCardUbsABTestArr == null) {
            return;
        }
        HashMap hashMap = new HashMap(UbsABTestHelper.getUbsABTestMap());
        for (IThreadCardUbsABTest iThreadCardUbsABTest : iThreadCardUbsABTestArr) {
            if (iThreadCardUbsABTest != null) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    iThreadCardUbsABTest.setABTest((BdUniqueId) entry.getKey(), (UsbAbTestSwitch) entry.getValue());
                }
            }
        }
    }
}
