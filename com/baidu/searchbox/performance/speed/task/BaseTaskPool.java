package com.baidu.searchbox.performance.speed.task;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class BaseTaskPool {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract List onAppCreateFirst(int i);

    public abstract List onAppCreateSecond(int i);

    public abstract List onPrivacyPolicyGranted(int i);

    public abstract List viewOnActivity();

    public abstract List viewOnAppCreateView();

    public BaseTaskPool() {
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

    public List getTaskList(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return null;
                            }
                            return viewOnActivity();
                        }
                        return viewOnAppCreateView();
                    }
                    return onPrivacyPolicyGranted(i2);
                }
                return onAppCreateSecond(i2);
            }
            return onAppCreateFirst(i2);
        }
        return (List) invokeII.objValue;
    }
}
