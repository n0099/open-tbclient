package com.baidu.live.data;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PersonUserData implements Serializable {
    public static final int PERSON_FANS_TYPE = 0;
    public static final int PERSON_FOLLOWS_TYPE = 1;
    public static final int PERSON_PLAYBACKS_TYPE = 2;
    public AlaLocationData location_info;
    public w login_user_info;
    public AlaRelationData relation_info;
    public w user_info;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
        if (optJSONObject != null) {
            this.user_info = new w();
            this.user_info.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("login_user_info");
        if (optJSONObject2 != null) {
            this.login_user_info = new w();
            this.login_user_info.parserJson(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("location_info");
        if (optJSONObject3 != null) {
            this.location_info = new AlaLocationData();
            this.location_info.parserJson(optJSONObject3);
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("relation_info");
        if (optJSONObject4 != null) {
            this.relation_info = new AlaRelationData();
            this.relation_info.parserJson(optJSONObject4);
        }
    }
}
