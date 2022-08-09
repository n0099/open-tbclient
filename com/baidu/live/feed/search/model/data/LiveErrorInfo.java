package com.baidu.live.feed.search.model.data;

import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveErrorInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String errMsg;
    public int errno;
    public String logId;
    public long serverTime;
    public long time;
    public String userMsg;

    public LiveErrorInfo() {
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

    public void loadFromJSON(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.errno = jSONObject.optInt("errno");
        this.errMsg = jSONObject.optString("errmsg");
        this.userMsg = jSONObject.optString(VideoFinishResult.KEY_ERROR_USER_MSG);
        this.serverTime = jSONObject.optLong("server_time");
        this.time = jSONObject.optLong("time");
        this.logId = jSONObject.optString("logId");
    }
}
