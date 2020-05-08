package com.baidu.tbadk.core.data;

import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes.dex */
public class bp {
    public int age;
    public String constellation;
    public long dup;
    public int duq;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dup = jSONObject.optLong("birthday_time", 0L);
            this.duq = jSONObject.optInt("birthday_show_status", 0);
            this.constellation = jSONObject.optString("constellation", "");
            this.age = jSONObject.optInt("age", 0);
        }
    }

    public void a(BirthdayInfo birthdayInfo) {
        if (birthdayInfo != null) {
            this.dup = birthdayInfo.birthday_time.longValue();
            this.duq = birthdayInfo.birthday_show_status.intValue();
            this.constellation = birthdayInfo.constellation;
            this.age = birthdayInfo.age.intValue();
        }
    }
}
