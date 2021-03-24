package com.baidu.tbadk.core.data;

import java.io.Serializable;
import org.json.JSONObject;
import tbclient.AlaChallengeInfo;
/* loaded from: classes3.dex */
public class AlaChallengeInfoData implements Serializable {
    public static final long serialVersionUID = -7697481412505420403L;
    public long challenge_id;
    public String ext;
    public String rival_hls_url;
    public String rival_rtmp_url;
    public String rival_session;
    public long winning_num;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.challenge_id = jSONObject.optLong("challenge_id");
        this.winning_num = jSONObject.optLong("winning_num");
        this.rival_session = jSONObject.optString("rival_session");
        this.rival_rtmp_url = jSONObject.optString("rival_rtmp_url");
        this.rival_hls_url = jSONObject.optString("rival_hls_url");
        this.ext = jSONObject.optString("ext");
    }

    public void parserProtobuf(AlaChallengeInfo alaChallengeInfo) {
        if (alaChallengeInfo == null) {
            return;
        }
        this.challenge_id = alaChallengeInfo.challenge_id.longValue();
        this.winning_num = alaChallengeInfo.winning_num.longValue();
        this.rival_session = alaChallengeInfo.rival_session;
        this.rival_rtmp_url = alaChallengeInfo.rival_rtmp_url;
        this.rival_hls_url = alaChallengeInfo.rival_hls_url;
        this.ext = alaChallengeInfo.ext;
    }
}
