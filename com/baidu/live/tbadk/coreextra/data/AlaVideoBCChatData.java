package com.baidu.live.tbadk.coreextra.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaVideoBCChatData extends BaseData {
    public boolean videoBCChatSwitch = false;
    public int audienceWaitTime = 0;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        this.videoBCChatSwitch = jSONObject.optInt("pub_show_two_switch", 0) == 1;
    }

    public boolean isShowEnter() {
        return this.videoBCChatSwitch;
    }
}
