package com.baidu.tbadk.core.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.YyExt;
/* loaded from: classes4.dex */
public class YyExtData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isYyGame;
    public String mSid;
    public String mSsid;
    public String mTemplateId;
    public String mYyUid;

    public YyExtData() {
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

    public void parseProtoBuf(YyExt yyExt) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, yyExt) == null) || yyExt == null) {
            return;
        }
        this.mSid = yyExt.sid;
        this.mSsid = yyExt.ssid;
        this.mTemplateId = yyExt.template_id;
        this.mYyUid = yyExt.yy_uid;
        this.isYyGame = yyExt.is_yy_game.intValue() == 1;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.mSid = jSONObject.optString("sid");
        this.mSsid = jSONObject.optString("ssid");
        this.mTemplateId = jSONObject.optString("template_id");
        this.mYyUid = jSONObject.optString("yy_uid");
        this.isYyGame = jSONObject.optInt("is_yy_game") == 1;
    }
}
