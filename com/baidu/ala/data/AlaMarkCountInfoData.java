package com.baidu.ala.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaMarkCountInfoData extends OrmObject implements Serializable {
    public long user_enter_effect_count;
    public long user_mark_count;
    public long user_wear_effect_count;
    public long user_wear_mark_count;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.user_mark_count = jSONObject.optLong("user_mark_count");
            this.user_wear_mark_count = jSONObject.optLong("user_wear_mark_count");
            this.user_enter_effect_count = jSONObject.optLong("user_enter_effect_count");
            this.user_wear_effect_count = jSONObject.optLong("user_wear_effect_count");
        }
    }
}
