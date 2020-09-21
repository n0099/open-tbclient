package com.baidu.tbadk.core.data;

import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes.dex */
public class cc {
    public int age;
    public String constellation;
    public long ehe;
    public int ehf;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ehe = jSONObject.optLong("birthday_time", 0L);
            this.ehf = jSONObject.optInt("birthday_show_status", 0);
            this.constellation = jSONObject.optString("constellation", "");
            this.age = jSONObject.optInt("age", 0);
        }
    }

    public void a(BirthdayInfo birthdayInfo) {
        if (birthdayInfo != null) {
            this.ehe = birthdayInfo.birthday_time.longValue();
            this.ehf = birthdayInfo.birthday_show_status.intValue();
            this.constellation = birthdayInfo.constellation;
            this.age = birthdayInfo.age.intValue();
        }
    }
}
