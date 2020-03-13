package com.baidu.tbadk.core.data;

import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes.dex */
public class bp {
    public int age;
    public long cUN;
    public int cUO;
    public String constellation;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cUN = jSONObject.optLong("birthday_time", 0L);
            this.cUO = jSONObject.optInt("birthday_show_status", 0);
            this.constellation = jSONObject.optString("constellation", "");
            this.age = jSONObject.optInt("age", 0);
        }
    }

    public void a(BirthdayInfo birthdayInfo) {
        if (birthdayInfo != null) {
            this.cUN = birthdayInfo.birthday_time.longValue();
            this.cUO = birthdayInfo.birthday_show_status.intValue();
            this.constellation = birthdayInfo.constellation;
            this.age = birthdayInfo.age.intValue();
        }
    }
}
