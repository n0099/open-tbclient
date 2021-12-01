package com.baidu.searchbox.devicescore;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class ScoreMetaBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ScoreMetaBuilder() {
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

    public static ScoreMetaData buildLaunchSpeedMetaData(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j2)) == null) {
            ScoreMetaData scoreMetaData = new ScoreMetaData();
            scoreMetaData.type = IDeviceScore.TYPE_LAUNCH_SPEED;
            HashMap hashMap = new HashMap(1);
            scoreMetaData.params = hashMap;
            hashMap.put(ParamKeys.KEY_LAUNCH_SPEED_LAUNCH_TS, Long.valueOf(j2));
            return scoreMetaData;
        }
        return (ScoreMetaData) invokeJ.objValue;
    }
}
