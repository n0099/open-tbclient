package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public AlaLiveUserInfoData aBG;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aBG = new AlaLiveUserInfoData();
            this.aBG.parserJson(jSONObject);
        }
    }
}
