package com.baidu.live.challenge;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public long alaId;
    public String avatar;
    public int axt;
    public boolean axu;
    public long axv;
    public long axw;
    public long charmCount;
    public int liveStatus;
    public String portrait;
    public long userId;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.alaId = jSONObject.optLong("ala_id");
            this.userName = jSONObject.optString("user_name");
            this.portrait = jSONObject.optString("bd_portrait");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.charmCount = jSONObject.optLong("charm_count");
            this.liveStatus = jSONObject.optInt("live_status");
            this.axt = jSONObject.optInt("pk_status");
            this.axu = jSONObject.optInt("can_challenge") == 1;
            this.axv = jSONObject.optLong("challenge_end_time");
            this.axw = jSONObject.optLong("challenge_time");
        }
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof d) && this.userId == ((d) obj).userId;
    }
}
