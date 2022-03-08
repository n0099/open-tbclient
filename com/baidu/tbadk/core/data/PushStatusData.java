package com.baidu.tbadk.core.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.PushStatus;
/* loaded from: classes5.dex */
public class PushStatusData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATUS_ALREADY_PUSH = 2;
    public static final int STATUS_NOT_PUSH = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public List<PushTypeData> mPushTypeDatas;
    public int mStatus;

    public PushStatusData() {
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

    public List<PushTypeData> getPushTypeDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mPushTypeDatas : (List) invokeV.objValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mStatus : invokeV.intValue;
    }

    public void parserProtobuf(PushStatus pushStatus) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pushStatus) == null) || pushStatus == null) {
            return;
        }
        this.mStatus = pushStatus.status.intValue();
        this.mPushTypeDatas = new ArrayList();
        int size = pushStatus.types.size();
        for (int i2 = 0; i2 < size; i2++) {
            PushTypeData pushTypeData = new PushTypeData();
            pushTypeData.parserProtobuf(pushStatus.types.get(i2));
            this.mPushTypeDatas.add(pushTypeData);
        }
    }

    public void setStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.mStatus = i2;
        }
    }
}
