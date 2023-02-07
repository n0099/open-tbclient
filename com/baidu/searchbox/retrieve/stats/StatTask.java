package com.baidu.searchbox.retrieve.stats;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import com.baidu.searchbox.retrieve.stats.service.StatTaskManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class StatTask implements IStatTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public StatTask() {
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

    @Override // com.baidu.searchbox.retrieve.inter.statistics.IStatTask
    public void recordActiveUploadData(boolean z, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2, str3, str4}) == null) {
            StatTaskManager.getInstance().recordActiveUploadData(z, str, str2, str3, str4);
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.statistics.IStatTask
    public void recordDispatchRetrieveData(boolean z, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, str2, str3, str4}) == null) {
            StatTaskManager.getInstance().recordDispatchRetrieveData(z, str, str2, str3, str4);
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.statistics.IStatTask
    public void recordCheckRetrieveData(boolean z, boolean z2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3, str4}) == null) {
            StatTaskManager.getInstance().recordCheckRetrieveData(z, z2, str, str2, str3, str4);
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.statistics.IStatTask
    public void recordReceiveRetrieveData(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            StatTaskManager.getInstance().recordReceiveRetrieveData(z);
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.statistics.IStatTask
    public void recordUploadRetrieveData(String str, boolean z, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4, str5, str6, jSONObject}) == null) {
            StatTaskManager.getInstance().recordUploadRetrieveData(str, z, str2, str3, str4, str5, str6, jSONObject);
        }
    }
}
