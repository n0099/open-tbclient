package com.baidu.live.data;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class z extends BaseData {
    public int aGU;
    public boolean aGV;
    public int status = DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER;
    public String url;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.status = DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER;
            return;
        }
        this.url = jSONObject.optString("lottery_url");
        this.status = jSONObject.optInt("status");
        this.aGV = jSONObject.optBoolean("is_change");
        this.aGU = jSONObject.optInt("open_time") - jSONObject.optInt("server_time");
    }
}
