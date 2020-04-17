package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public AlaLiveUserInfoData aue;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aue = new AlaLiveUserInfoData();
            this.aue.parserJson(jSONObject);
        }
    }
}
