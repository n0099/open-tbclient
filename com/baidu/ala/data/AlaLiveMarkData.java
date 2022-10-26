package com.baidu.ala.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AlaLiveMarkData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String anchor_user_id;
    public int height;
    public long mark_id;
    public String mark_name;
    public String mark_pic;
    public int type;
    public int width;

    public AlaLiveMarkData() {
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

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.type = jSONObject.optInt("type");
        this.anchor_user_id = jSONObject.optString("anchor_user_id");
        this.mark_id = jSONObject.optLong("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
    }
}
