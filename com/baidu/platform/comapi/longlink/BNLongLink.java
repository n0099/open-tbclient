package com.baidu.platform.comapi.longlink;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BNLongLink {
    public static /* synthetic */ Interceptable $ic;
    public static BNLongLinkInitCallBack a;
    public transient /* synthetic */ FieldHolder $fh;

    public BNLongLink() {
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

    public static void initLongLink() {
        BNLongLinkInitCallBack bNLongLinkInitCallBack;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (bNLongLinkInitCallBack = a) != null) {
            bNLongLinkInitCallBack.onLongLinkInit();
        }
    }

    public static void registerLongLinkInitCallBack(BNLongLinkInitCallBack bNLongLinkInitCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bNLongLinkInitCallBack) == null) {
            a = bNLongLinkInitCallBack;
        }
    }

    public static void unRegisterLongLinkInitCallBack(BNLongLinkInitCallBack bNLongLinkInitCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bNLongLinkInitCallBack) == null) {
            a = bNLongLinkInitCallBack;
        }
    }
}
