package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public AlaLiveUserInfoData auk;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.auk = new AlaLiveUserInfoData();
            this.auk.parserJson(jSONObject);
        }
    }
}
