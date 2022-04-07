package com.baidu.searchbox.devicescore;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class ScoreMetaBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ScoreMetaBuilder() {
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

    public static ScoreMetaData buildLaunchSpeedMetaData(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) {
            ScoreMetaData scoreMetaData = new ScoreMetaData();
            scoreMetaData.type = IDeviceScore.TYPE_LAUNCH_SPEED;
            HashMap hashMap = new HashMap(1);
            scoreMetaData.params = hashMap;
            hashMap.put(ParamKeys.KEY_LAUNCH_SPEED_LAUNCH_TS, Long.valueOf(j));
            return scoreMetaData;
        }
        return (ScoreMetaData) invokeJ.objValue;
    }
}
