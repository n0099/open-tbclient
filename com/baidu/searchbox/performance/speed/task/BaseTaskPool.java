package com.baidu.searchbox.performance.speed.task;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class BaseTaskPool {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BaseTaskPool() {
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

    public abstract List<LaunchTask> afterSuperCreate(boolean z);

    public List<LaunchTask> getTaskList(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return null;
                            }
                            return onSecondaryPageEnter(z);
                        }
                        return onPrivacyPolicyGranted(z);
                    }
                    return onUiReady(z);
                }
                return onAppCreate(z);
            }
            return afterSuperCreate(z);
        }
        return (List) invokeCommon.objValue;
    }

    public abstract List<LaunchTask> onAppCreate(boolean z);

    public abstract List<LaunchTask> onPrivacyPolicyGranted(boolean z);

    public abstract List<LaunchTask> onSecondaryPageEnter(boolean z);

    public abstract List<LaunchTask> onUiReady(boolean z);
}
