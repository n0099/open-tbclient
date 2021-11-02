package com.baidu.ala.gift;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaDynamicGift implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaDynamicGiftConfigInfo configInfo;
    public String giftId;
    public String giftName;
    public AlaDynamicGiftZip giftZip;

    public AlaDynamicGift() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.giftId = "";
        this.giftName = "";
        this.giftZip = null;
        this.configInfo = null;
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.giftId = jSONObject.optString("gift_id");
        this.giftName = jSONObject.optString("gift_name");
        JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
        if (optJSONObject != null) {
            AlaDynamicGiftConfigInfo alaDynamicGiftConfigInfo = new AlaDynamicGiftConfigInfo();
            this.configInfo = alaDynamicGiftConfigInfo;
            alaDynamicGiftConfigInfo.parseJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
        if (optJSONObject2 != null) {
            AlaDynamicGiftZip alaDynamicGiftZip = new AlaDynamicGiftZip();
            this.giftZip = alaDynamicGiftZip;
            alaDynamicGiftZip.parseJson(optJSONObject2);
        }
    }
}
