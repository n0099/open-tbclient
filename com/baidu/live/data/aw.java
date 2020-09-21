package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class aw {
    public String aJT;
    public String aJU;
    public long endTime;
    public int flag;
    public long serverTime;
    public long startTime;
    public int type;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.aJT = jSONObject.optString(AlaLiveStickerInfo.STICKER_ID);
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.serverTime = jSONObject.optLong("server_time");
            this.aJU = jSONObject.optString("punish_key");
            this.flag = jSONObject.optInt(FrsActivityConfig.FLAG);
        }
    }
}
