package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    public AlaLiveUserInfoData aOI;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOI = new AlaLiveUserInfoData();
            this.aOI.parserJson(jSONObject);
        }
    }
}
