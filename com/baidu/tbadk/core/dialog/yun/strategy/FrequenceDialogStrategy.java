package com.baidu.tbadk.core.dialog.yun.strategy;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.fw4;
import com.baidu.tieba.gw4;
import com.baidu.tieba.ky4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class FrequenceDialogStrategy implements gw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final ky4 a;

    @Keep
    /* loaded from: classes3.dex */
    public static class Data {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String dialogName;
        public int frequence;

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
                }
            }
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
                return;
            }
        }
        this.a = fw4.a();
    }

    @Override // com.baidu.tieba.gw4
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

    @Override // com.baidu.tieba.gw4
    public boolean b(@NonNull Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            Data data = (Data) DataExt.toEntity(map, Data.class);
            if (data.frequence == 0) {
                return true;
            }
            String str = ky4.o("KEY_FREQUENCE_DIALOG_STRATEGY_COUNTER") + "_" + data.dialogName;
            int l = this.a.l(str, 0);
            if (l >= data.frequence) {
                return false;
            }
            this.a.w(str, l + 1);
            return true;
        }
        return invokeL.booleanValue;
    }
}
