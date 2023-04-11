package com.baidu.tbadk.core.dialog.yun.strategy;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.jv4;
import com.baidu.tieba.k25;
import com.baidu.tieba.ng8;
import com.baidu.tieba.z15;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class FrequenceDialogStrategy implements z15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    /* loaded from: classes3.dex */
    public static class Data {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String dialogName;
        public long endTimestamp;
        public int frequence;
        public long startTimestamp;

        public Data() {
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
            this.startTimestamp = 0L;
            this.endTimestamp = Long.MAX_VALUE;
        }
    }

    public FrequenceDialogStrategy() {
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

    @Override // com.baidu.tieba.z15
    @NonNull
    public Map<String, Object> a(@NonNull DialogStrategiesData dialogStrategiesData, @NonNull Map<String, Object> map, @NonNull Map<String, Object> map2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, dialogStrategiesData, map, map2)) == null) {
            HashMap hashMap = new HashMap(map);
            hashMap.put("dialogName", dialogStrategiesData.getDialogName());
            return hashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.z15
    public boolean b(@NonNull Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            boolean z = false;
            try {
                Data data = (Data) DataExt.toEntity(map, Data.class);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis >= data.startTimestamp && currentTimeMillis <= data.endTimestamp) {
                    if (data.frequence == 0) {
                        return true;
                    }
                    int n = k25.b.n(k25.a.a(data.dialogName), 0);
                    if (n < data.frequence) {
                        z = true;
                    }
                    if (!z) {
                        ng8 yunDialogLog = YunDialogLog.getInstance();
                        yunDialogLog.c("YunDialogManager", "云弹窗 " + data.dialogName + " 命中频次超限限制，当前已展示次数：" + n + "，配置展现次数：" + data.frequence);
                    }
                    return z;
                }
                ng8 yunDialogLog2 = YunDialogLog.getInstance();
                yunDialogLog2.c("YunDialogManager", "云弹窗 " + data.dialogName + " 命中频次时间限制，当前时间戳：" + currentTimeMillis + " 配置时间：" + data.startTimestamp + " - " + data.endTimestamp);
                return false;
            } catch (Exception e) {
                if (!jv4.e() && !jv4.h() && !TbadkApplication.getInst().isDebugMode()) {
                    YunDialogLog.getInstance().c("YunDialogManager", "云弹窗频次策略解析失败");
                    return false;
                }
                throw e;
            }
        }
        return invokeL.booleanValue;
    }
}
