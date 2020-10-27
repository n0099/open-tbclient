package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public AlaLiveUserInfoData aNs;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNs = new AlaLiveUserInfoData();
            this.aNs.parserJson(jSONObject);
        }
    }
}
