package com.baidu.tbadk.core.data;

import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes.dex */
public class cc {
    public int age;
    public String constellation;
    public long etl;
    public int etm;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.etl = jSONObject.optLong("birthday_time", 0L);
            this.etm = jSONObject.optInt("birthday_show_status", 0);
            this.constellation = jSONObject.optString("constellation", "");
            this.age = jSONObject.optInt("age", 0);
        }
    }

    public void a(BirthdayInfo birthdayInfo) {
        if (birthdayInfo != null) {
            this.etl = birthdayInfo.birthday_time.longValue();
            this.etm = birthdayInfo.birthday_show_status.intValue();
            this.constellation = birthdayInfo.constellation;
            this.age = birthdayInfo.age.intValue();
        }
    }
}
