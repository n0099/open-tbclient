package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.AlaShareInfo;
/* loaded from: classes3.dex */
public class AlaShareInfoData extends OrmObject {
    public String content;
    public long record_tid;
    public int share_count;
    public int share_user_count;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.content = jSONObject.optString("content");
            this.share_user_count = jSONObject.optInt("share_user_count");
            this.share_count = jSONObject.optInt("share_count");
            this.record_tid = jSONObject.optLong("record_tid");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void s(AlaShareInfo alaShareInfo) {
        if (alaShareInfo == null) {
            return;
        }
        try {
            this.content = alaShareInfo.content;
            this.share_user_count = alaShareInfo.share_user_count.intValue();
            this.share_count = alaShareInfo.share_count.intValue();
            this.record_tid = alaShareInfo.record_tid.longValue();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
