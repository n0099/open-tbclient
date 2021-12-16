package com.baidu.ala.data;

import alaim.LiveMarkInfo;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class AlaLiveMarkData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_ANCHOR_USER_ID = "0";
    public static final int TYPE_USER_LABEL = 3;
    public static final int TYPE_USER_LEVEL = 1;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.type = jSONObject.optInt("type");
        this.anchor_user_id = jSONObject.optString("anchor_user_id");
        this.mark_id = jSONObject.optLong("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
    }

    public void parserProto(LiveMarkInfo liveMarkInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveMarkInfo) == null) || liveMarkInfo == null) {
            return;
        }
        Long l = liveMarkInfo.type;
        this.type = l == null ? 0 : l.intValue();
        this.anchor_user_id = String.valueOf(liveMarkInfo.anchor_user_id);
        this.mark_id = liveMarkInfo.mark_id.longValue();
        this.mark_name = liveMarkInfo.mark_name;
        this.mark_pic = liveMarkInfo.mark_pic;
        Long l2 = liveMarkInfo.width;
        this.width = l2 == null ? 0 : l2.intValue();
        Long l3 = liveMarkInfo.height;
        this.height = l3 != null ? l3.intValue() : 0;
    }
}
