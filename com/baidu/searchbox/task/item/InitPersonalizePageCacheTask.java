package com.baidu.searchbox.task.item;

import c.a.e.e.d.l;
import c.a.p0.s.r.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Personalized.DataRes;
/* loaded from: classes5.dex */
public class InitPersonalizePageCacheTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public static volatile DataRes dataResCache;
    public transient /* synthetic */ FieldHolder $fh;

    public InitPersonalizePageCacheTask() {
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

    public static synchronized void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            synchronized (InitPersonalizePageCacheTask.class) {
                if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                    if (dataResCache != null) {
                        return;
                    }
                    a.f();
                    l<byte[]> e2 = a.e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                    if (e2 == null) {
                        return;
                    }
                    byte[] bArr = e2.get("0");
                    if (bArr != null && bArr.length != 0) {
                        try {
                            dataResCache = (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                        } catch (IOException e3) {
                            BdLog.e(e3);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            init();
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "initPersonalizePageCache" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }
}
