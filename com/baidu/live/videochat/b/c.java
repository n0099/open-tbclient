package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public AlaLiveUserInfoData aIn;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aIn = new AlaLiveUserInfoData();
            this.aIn.parserJson(jSONObject);
        }
    }
}
