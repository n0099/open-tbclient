package com.baidu.live.tbadk.core.data;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes7.dex */
public class AlaShareInfoData {
    public String content;
    public long record_tid;
    public int share_count;
    public int share_user_count;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.content = jSONObject.optString("content");
                this.share_user_count = jSONObject.optInt("share_user_count");
                this.share_count = jSONObject.optInt("share_count");
                this.record_tid = jSONObject.optLong("record_tid");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
