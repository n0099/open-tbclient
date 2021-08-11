package com.baidu.searchbox.taskmanager;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.searchbox.performance.speed.task.BaseTaskPool;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.task.item.CheckRepackagingTask;
import com.baidu.searchbox.task.item.FetchDnsTask;
import com.baidu.searchbox.task.item.FrescoTask;
import com.baidu.searchbox.task.item.InitReceiverTask;
import com.baidu.searchbox.task.item.LeakCanaryTask;
import com.baidu.searchbox.task.item.NPSInitTask;
import com.baidu.searchbox.task.item.PreloadClassTask;
import com.baidu.searchbox.task.item.StrictModeTask;
import com.baidu.searchbox.task.item.WebkitTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ApplicationTaskPool extends BaseTaskPool {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ApplicationTaskPool() {
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

    @Override // com.baidu.searchbox.performance.speed.task.BaseTaskPool
    public List<LaunchTask> onAppCreate(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            ArrayList arrayList = new ArrayList();
            if (z) {
                arrayList.add(new PreloadClassTask());
                arrayList.add(new FetchDnsTask());
                arrayList.add(new InitReceiverTask());
                SpeedStats.getInstance().getLaunchType();
            } else {
                arrayList.add(new LeakCanaryTask());
                arrayList.add(new NPSInitTask());
                arrayList.add(new WebkitTask());
                arrayList.add(new FrescoTask());
                arrayList.add(new StrictModeTask());
            }
            return arrayList;
        }
        return (List) invokeZ.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.BaseTaskPool
    public List<LaunchTask> onUiReady(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            ArrayList arrayList = new ArrayList();
            if (z) {
                arrayList.add(new CheckRepackagingTask());
            }
            return arrayList;
        }
        return (List) invokeZ.objValue;
    }
}
