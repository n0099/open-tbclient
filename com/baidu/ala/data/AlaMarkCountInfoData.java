package com.baidu.ala.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AlaMarkCountInfoData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long user_enter_effect_count;
    public long user_mark_count;
    public long user_wear_effect_count;
    public long user_wear_mark_count;

    public AlaMarkCountInfoData() {
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
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.user_mark_count = jSONObject.optLong("user_mark_count");
        this.user_wear_mark_count = jSONObject.optLong("user_wear_mark_count");
        this.user_enter_effect_count = jSONObject.optLong("user_enter_effect_count");
        this.user_wear_effect_count = jSONObject.optLong("user_wear_effect_count");
    }
}
