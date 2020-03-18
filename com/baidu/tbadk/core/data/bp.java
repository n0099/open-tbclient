package com.baidu.tbadk.core.data;

import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes.dex */
public class bp {
    public int age;
    public long cVa;
    public int cVb;
    public String constellation;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cVa = jSONObject.optLong("birthday_time", 0L);
            this.cVb = jSONObject.optInt("birthday_show_status", 0);
            this.constellation = jSONObject.optString("constellation", "");
            this.age = jSONObject.optInt("age", 0);
        }
    }

    public void a(BirthdayInfo birthdayInfo) {
        if (birthdayInfo != null) {
            this.cVa = birthdayInfo.birthday_time.longValue();
            this.cVb = birthdayInfo.birthday_show_status.intValue();
            this.constellation = birthdayInfo.constellation;
            this.age = birthdayInfo.age.intValue();
        }
    }
}
