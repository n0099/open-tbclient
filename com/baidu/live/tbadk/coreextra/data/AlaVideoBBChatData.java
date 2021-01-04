package com.baidu.live.tbadk.coreextra.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaVideoBBChatData extends BaseData {
    public long acceptPendantTime;
    public long acceptWindowTime;
    public long invitePendantTime;
    public boolean videoBBChatSwitch;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        this.videoBBChatSwitch = jSONObject.optInt("pub_show_switch") == 1;
        JSONObject optJSONObject = jSONObject.optJSONObject("pub_show_conf");
        if (optJSONObject != null) {
            this.invitePendantTime = optJSONObject.optLong("pub_show_requestTime");
            this.acceptWindowTime = optJSONObject.optLong("pub_show_alertTime");
            this.acceptPendantTime = optJSONObject.optLong("pub_show_receiveTime");
        }
    }
}
