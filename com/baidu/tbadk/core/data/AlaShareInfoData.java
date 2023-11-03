package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.AlaShareInfo;
/* loaded from: classes4.dex */
public class AlaShareInfoData extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String content;
    public long record_tid;
    public int share_count;
    public int share_user_count;

    public AlaShareInfoData() {
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

    public void O(AlaShareInfo alaShareInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, alaShareInfo) != null) || alaShareInfo == null) {
            return;
        }
        try {
            this.content = alaShareInfo.content;
            this.share_user_count = alaShareInfo.share_user_count.intValue();
            this.share_count = alaShareInfo.share_count.intValue();
            this.record_tid = alaShareInfo.record_tid.longValue();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            this.content = jSONObject.optString("content");
            this.share_user_count = jSONObject.optInt("share_user_count");
            this.share_count = jSONObject.optInt("share_count");
            this.record_tid = jSONObject.optLong("record_tid");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
