package com.baidu.down.statistic;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.utils.IdentityManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class TaskSpeedStat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long did;
    public String docid;
    public long endWriteTimeMillis;
    public List<ThreadSpeedStat> mSpeedStatThreadList;
    public boolean speedStatEnable;
    public long startTimeMillis;
    public long startWriteTimeMillis;
    public int status;

    public TaskSpeedStat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.speedStatEnable = false;
        this.startWriteTimeMillis = -1L;
        this.endWriteTimeMillis = -1L;
    }

    public void addThreadSpeedStat(ThreadSpeedStat threadSpeedStat) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadSpeedStat) == null) || this.mSpeedStatThreadList.contains(threadSpeedStat)) {
            return;
        }
        this.mSpeedStatThreadList.add(threadSpeedStat);
    }

    public String generateCqid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return IdentityManager.getInstance(context).getEncodedUid() + this.docid + this.did + System.currentTimeMillis();
        }
        return (String) invokeL.objValue;
    }

    public List<ThreadSpeedStat> getSpeedStatThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSpeedStatThreadList : (List) invokeV.objValue;
    }

    public void initThreadSpeedStat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.speedStatEnable = z;
            this.mSpeedStatThreadList = new ArrayList();
            this.startTimeMillis = System.currentTimeMillis();
        }
    }
}
