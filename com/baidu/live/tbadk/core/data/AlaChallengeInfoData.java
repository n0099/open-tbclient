package com.baidu.live.tbadk.core.data;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaChallengeInfoData implements Serializable {
    private static final long serialVersionUID = -7697481412505420403L;
    public long challenge_id;
    public String ext;
    public String rival_hls_url;
    public String rival_rtmp_url;
    public String rival_session;
    public long winning_num;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.challenge_id = jSONObject.optLong("challenge_id");
            this.winning_num = jSONObject.optLong("winning_num");
            this.rival_session = jSONObject.optString("rival_session");
            this.rival_rtmp_url = jSONObject.optString("rival_rtmp_url");
            this.rival_hls_url = jSONObject.optString("rival_hls_url");
            this.ext = jSONObject.optString("ext");
        }
    }
}
