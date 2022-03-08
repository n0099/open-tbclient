package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Abstract;
/* loaded from: classes5.dex */
public class AbstractData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String duringTime;
    public String link;
    public String src;
    public String text;
    public int type;
    public String un;
    public String voiceMD5;

    public AbstractData() {
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

    public void parser(Abstract r5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, r5) == null) || r5 == null) {
            return;
        }
        this.type = r5.type.intValue();
        this.text = r5.text;
        this.link = r5.link;
        this.src = r5.src;
        this.un = r5.un;
        this.duringTime = r5.during_time;
        this.voiceMD5 = r5.voice_md5;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.type = jSONObject.optInt("type", 0);
            this.text = jSONObject.optString("text");
            this.link = jSONObject.optString("link");
            this.src = jSONObject.optString("src");
            this.un = jSONObject.optString("un");
            this.duringTime = jSONObject.optString("during_time");
            this.voiceMD5 = jSONObject.optString("voice_md5");
        } catch (Throwable unused) {
        }
    }
}
