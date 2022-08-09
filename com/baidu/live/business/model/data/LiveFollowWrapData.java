package com.baidu.live.business.model.data;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.la0;
import com.repackage.oa0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveFollowWrapData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int errCode;
    public String errMsg;
    public List<LiveFollowEntity> followList;
    public List<LiveFollowEntity> livingFollowList;

    public LiveFollowWrapData() {
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
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.errCode = jSONObject.optInt("inner_errno");
        this.errMsg = jSONObject.optString("inner_msg");
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.followList = new ArrayList();
            this.livingFollowList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    LiveFollowEntity liveFollowEntity = new LiveFollowEntity();
                    liveFollowEntity.parserJson(optJSONObject2);
                    this.followList.add(liveFollowEntity);
                    this.livingFollowList.add(liveFollowEntity);
                }
            }
        }
        if (la0.c(this.followList) || (optJSONObject = jSONObject.optJSONObject("more")) == null) {
            return;
        }
        String optString = optJSONObject.optString("scheme");
        if (oa0.a(optString)) {
            return;
        }
        LiveFollowEntity liveFollowEntity2 = new LiveFollowEntity();
        liveFollowEntity2.cmd = optString;
        liveFollowEntity2.isMore = true;
        LiveHostInfo liveHostInfo = new LiveHostInfo();
        liveHostInfo.name = optJSONObject.optString("txt");
        liveFollowEntity2.hostInfo = liveHostInfo;
        this.followList.add(liveFollowEntity2);
    }
}
