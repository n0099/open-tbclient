package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public AlaLiveUserInfoData aIl;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aIl = new AlaLiveUserInfoData();
            this.aIl.parserJson(jSONObject);
        }
    }
}
