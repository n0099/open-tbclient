package com.baidu.live.data;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class y extends BaseData {
    public int aLf;
    public boolean aLg;
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
        this.aLg = jSONObject.optBoolean("is_change");
        this.aLf = jSONObject.optInt("open_time") - jSONObject.optInt("server_time");
    }
}
