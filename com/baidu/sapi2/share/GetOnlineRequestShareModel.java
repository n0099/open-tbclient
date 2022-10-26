package com.baidu.sapi2.share;

import com.baidu.sapi2.share.ShareStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetOnlineRequestShareModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_INTER_FLOW_NO = "0";
    public static final String FROM_INTER_FLOW_YES = "1";
    public transient /* synthetic */ FieldHolder $fh;
    public String app;
    public String bduss;
    public String pkg;

    public GetOnlineRequestShareModel() {
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

    public GetOnlineRequestShareModel(ShareStorage.StorageModel storageModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {storageModel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (storageModel == null) {
            return;
        }
        this.app = storageModel.app;
        this.pkg = storageModel.pkg;
        this.bduss = storageModel.bduss;
    }

    public static JSONObject parseModel2JsonObject(GetOnlineRequestShareModel getOnlineRequestShareModel) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, getOnlineRequestShareModel)) == null) {
            if (getOnlineRequestShareModel == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                String str3 = "";
                if (getOnlineRequestShareModel.app == null) {
                    str = "";
                } else {
                    str = getOnlineRequestShareModel.app;
                }
                jSONObject.put("app", str);
                if (getOnlineRequestShareModel.pkg == null) {
                    str2 = "";
                } else {
                    str2 = getOnlineRequestShareModel.pkg;
                }
                jSONObject.put("pkg", str2);
                if (getOnlineRequestShareModel.bduss != null) {
                    str3 = getOnlineRequestShareModel.bduss;
                }
                jSONObject.put("bduss", str3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
