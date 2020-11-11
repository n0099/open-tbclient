package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public AlaLiveUserInfoData aOv;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOv = new AlaLiveUserInfoData();
            this.aOv.parserJson(jSONObject);
        }
    }
}
