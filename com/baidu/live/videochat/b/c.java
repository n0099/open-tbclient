package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    public AlaLiveUserInfoData aLL;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aLL = new AlaLiveUserInfoData();
            this.aLL.parserJson(jSONObject);
        }
    }
}
