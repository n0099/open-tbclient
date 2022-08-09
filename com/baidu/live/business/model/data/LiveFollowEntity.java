package com.baidu.live.business.model.data;

import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveFollowEntity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String audienceCount;
    public String cmd;
    public String feedId;
    public LiveHostInfo hostInfo;
    public boolean isMore;
    public int liveStatus;
    public String liveTag;
    public boolean needLogShow;
    public String nid;
    public String roomId;
    public LiveStatInfo statInfo;
    public String title;

    public LiveFollowEntity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isMore = false;
        this.needLogShow = true;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.isMore = false;
        this.feedId = jSONObject.optString("feed_id");
        this.nid = jSONObject.optString("nid");
        this.roomId = jSONObject.optString("room_id");
        this.title = jSONObject.optString("title");
        this.liveStatus = jSONObject.optInt(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
        this.liveTag = jSONObject.optString("live_tag");
        this.cmd = jSONObject.optString("cmd");
        this.audienceCount = jSONObject.optString("audience_count");
        JSONObject optJSONObject = jSONObject.optJSONObject("host");
        if (optJSONObject != null) {
            LiveHostInfo liveHostInfo = new LiveHostInfo();
            this.hostInfo = liveHostInfo;
            liveHostInfo.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("stat");
        if (optJSONObject2 != null) {
            LiveStatInfo liveStatInfo = new LiveStatInfo();
            this.statInfo = liveStatInfo;
            liveStatInfo.parserJson(optJSONObject2);
        }
    }
}
