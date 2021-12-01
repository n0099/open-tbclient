package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class EnterForePvThread extends Thread {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE_NORMAL = "1";
    public static final String TYPE_PB_NOT_EXIST = "2";
    public transient /* synthetic */ FieldHolder $fh;
    public String mOpType;

    public EnterForePvThread() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOpType = "1";
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.run();
            if (TbadkCoreApplication.getInst().checkInterrupt()) {
                return;
            }
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.IN_PV_ADDRESS);
            netWork.addPostData("st_type", TbConfig.ST_TYPE_ENTER_FORE);
            netWork.addPostData(HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
            netWork.addPostData("android_sdk", String.valueOf(Build.VERSION.SDK_INT));
            netWork.addPostData("op_type", this.mOpType);
            netWork.postNetData();
        }
    }

    public void setOpType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.mOpType = str;
        }
    }
}
