package com.baidu.tbadk.core.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.ShakeAdSwitch;
/* loaded from: classes3.dex */
public class ShakeAdSwitchData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String desc;
    public int isShow;
    public String title;

    public ShakeAdSwitchData() {
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

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.isShow = jSONObject.optInt("is_show", 0);
        this.title = jSONObject.optString("title", "");
        this.desc = jSONObject.optString("desc", "");
    }

    public void parserProtobuf(ShakeAdSwitch shakeAdSwitch) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shakeAdSwitch) != null) || shakeAdSwitch == null) {
            return;
        }
        this.isShow = shakeAdSwitch.is_show.intValue();
        this.title = shakeAdSwitch.title;
        this.desc = shakeAdSwitch.desc;
    }
}
