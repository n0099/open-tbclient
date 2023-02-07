package com.baidu.searchbox.retrieve.core;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FetchReport {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FetchReport() {
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

    public static void reportDataNull() {
        IFetchTask iFetchTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (iFetchTask = (IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE)) != null) {
            iFetchTask.reportDispatchCheckFail("", "", "", "0", null);
        }
    }

    public static void reportDataError(String str, String str2, String str3, JSONObject jSONObject) {
        IFetchTask iFetchTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65537, null, str, str2, str3, jSONObject) == null) && (iFetchTask = (IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE)) != null) {
            iFetchTask.reportDispatchCheckFail(str, str2, str3, "1", jSONObject);
        }
    }

    public static void reportDispatch(String str, String str2, String str3, JSONObject jSONObject, String str4) {
        IFetchTask iFetchTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(65539, null, str, str2, str3, jSONObject, str4) == null) && (iFetchTask = (IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE)) != null) {
            iFetchTask.reportDispatch(str, str2, str3, jSONObject, str4);
        }
    }
}
