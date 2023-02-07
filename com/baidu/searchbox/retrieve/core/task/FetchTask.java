package com.baidu.searchbox.retrieve.core.task;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.searchbox.retrieve.upload.FetchTaskObj;
import com.baidu.searchbox.retrieve.upload.FetchUploadManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FetchTask implements IFetchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FetchTask() {
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

    @Override // com.baidu.searchbox.retrieve.inter.IFetchTask
    public void reportDispatch(String str, String str2, String str3, JSONObject jSONObject, String str4) {
        String jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, str2, str3, jSONObject, str4) == null) {
            if (jSONObject == null) {
                jSONObject2 = "";
            } else {
                jSONObject2 = jSONObject.toString();
            }
            FetchUploadManager.getInstance().uploadReportContent(new FetchTaskObj(str, "1", str2, str3, str4, jSONObject2, ""));
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.IFetchTask
    public void reportDispatchCheckFail(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        String jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4, jSONObject) == null) {
            if (jSONObject == null) {
                jSONObject2 = "";
            } else {
                jSONObject2 = jSONObject.toString();
            }
            FetchUploadManager.getInstance().uploadReportContent(new FetchTaskObj(str, "-1", str2, str3, str4, jSONObject2, ""));
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.IFetchTask
    public void reportTaskCheckFail(String str, String str2, String str3, JSONObject jSONObject) {
        String jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3, jSONObject) == null) {
            if (jSONObject == null) {
                jSONObject2 = "";
            } else {
                jSONObject2 = jSONObject.toString();
            }
            FetchUploadManager.getInstance().uploadReportContent(new FetchTaskObj(str, "2", str2, str3, "", jSONObject2, ""));
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.IFetchTask
    public void reportTaskDone(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            FetchTaskObj fetchTaskObj = new FetchTaskObj(str, "4", str2, str3, str4, "", str6);
            fetchTaskObj.setFileID(str5);
            FetchUploadManager.getInstance().uploadReportContent(fetchTaskObj);
        }
    }
}
