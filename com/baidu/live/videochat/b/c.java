package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public AlaLiveUserInfoData aMK;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aMK = new AlaLiveUserInfoData();
            this.aMK.parserJson(jSONObject);
        }
    }
}
