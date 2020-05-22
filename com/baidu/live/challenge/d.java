package com.baidu.live.challenge;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public long alaId;
    public boolean aum;
    public long aun;
    public long auo;
    public String avatar;
    public long charmCount;
    public long userId;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.alaId = jSONObject.optLong("ala_id");
            this.userName = jSONObject.optString("user_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.charmCount = jSONObject.optLong("charm_count");
            this.aum = jSONObject.optInt("can_challenge") == 1;
            this.aun = jSONObject.optLong("challenge_end_time");
            this.auo = jSONObject.optLong("challenge_time");
        }
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof d) && this.userId == ((d) obj).userId;
    }
}
