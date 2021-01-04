package com.baidu.tbadk.core.data;

import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes.dex */
public class cf {
    public int age;
    public String constellation;
    public long eWS;
    public int eWT;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eWS = jSONObject.optLong("birthday_time", 0L);
            this.eWT = jSONObject.optInt("birthday_show_status", 0);
            this.constellation = jSONObject.optString("constellation", "");
            this.age = jSONObject.optInt("age", 0);
        }
    }

    public void a(BirthdayInfo birthdayInfo) {
        if (birthdayInfo != null) {
            this.eWS = birthdayInfo.birthday_time.longValue();
            this.eWT = birthdayInfo.birthday_show_status.intValue();
            this.constellation = birthdayInfo.constellation;
            this.age = birthdayInfo.age.intValue();
        }
    }
}
