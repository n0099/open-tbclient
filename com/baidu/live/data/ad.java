package com.baidu.live.data;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ad extends BaseData {
    public int aJx;
    public boolean aJy;
    public String aJz;
    public String iconUrl;
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
        this.aJy = jSONObject.optInt("is_change", 0) == 1;
        this.aJx = jSONObject.optInt("open_time") - jSONObject.optInt("server_time");
        this.aJz = jSONObject.optString("result_url");
        this.iconUrl = jSONObject.optString("icon_url");
    }
}
