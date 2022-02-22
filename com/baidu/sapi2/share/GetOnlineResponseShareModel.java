package com.baidu.sapi2.share;

import com.baidu.sapi2.share.ShareStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GetOnlineResponseShareModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String app;
    public String bduss;
    public String pkg;

    public GetOnlineResponseShareModel() {
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

    public static JSONObject parseModel2JsonObject(GetOnlineResponseShareModel getOnlineResponseShareModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, getOnlineResponseShareModel)) == null) {
            if (getOnlineResponseShareModel == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                String str = "";
                jSONObject.put("app", getOnlineResponseShareModel.app == null ? "" : getOnlineResponseShareModel.app);
                jSONObject.put("pkg", getOnlineResponseShareModel.pkg == null ? "" : getOnlineResponseShareModel.pkg);
                if (getOnlineResponseShareModel.bduss != null) {
                    str = getOnlineResponseShareModel.bduss;
                }
                jSONObject.put("bduss", str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public GetOnlineResponseShareModel(ShareStorage.StorageModel storageModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {storageModel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
}
