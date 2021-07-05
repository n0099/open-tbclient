package com.baidu.ala.gift;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AlaDynamicGiftZip implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int isLandScape;
    public int isNeedDownload;
    public String zipDownloadUrl;
    public String zipMD5;
    public String zipName;

    public AlaDynamicGiftZip() {
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

    public boolean isLandScape() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isLandScape == 1 : invokeV.booleanValue;
    }

    public boolean isNeedDownload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isNeedDownload == 1 : invokeV.booleanValue;
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.zipMD5 = jSONObject.optString("zip_md5");
        this.zipDownloadUrl = jSONObject.optString("zip_url");
        this.zipName = jSONObject.optString("zip_name");
        this.isLandScape = jSONObject.optInt("is_landscape");
        this.isNeedDownload = jSONObject.optInt("need_download");
    }
}
