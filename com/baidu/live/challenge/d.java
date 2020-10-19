package com.baidu.live.challenge;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public int aGk;
    public int aGl;
    public boolean aGm;
    public long aGn;
    public long aGo;
    public long alaId;
    public String avatar;
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
            this.aGk = jSONObject.optInt("pk_status");
            this.aGm = jSONObject.optInt("can_challenge") == 1;
            this.aGn = jSONObject.optLong("challenge_end_time");
            this.aGo = jSONObject.optLong("challenge_time");
            this.aGl = jSONObject.optInt("is_pking");
        }
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof d) && this.userId == ((d) obj).userId;
    }
}
