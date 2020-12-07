package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public AlaLiveUserInfoData aPJ;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aPJ = new AlaLiveUserInfoData();
            this.aPJ.parserJson(jSONObject);
        }
    }
}
