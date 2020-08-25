package com.baidu.tbadk.core.data;

import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes2.dex */
public class cc {
    public int age;
    public String constellation;
    public long eeM;
    public int eeN;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eeM = jSONObject.optLong("birthday_time", 0L);
            this.eeN = jSONObject.optInt("birthday_show_status", 0);
            this.constellation = jSONObject.optString("constellation", "");
            this.age = jSONObject.optInt("age", 0);
        }
    }

    public void a(BirthdayInfo birthdayInfo) {
        if (birthdayInfo != null) {
            this.eeM = birthdayInfo.birthday_time.longValue();
            this.eeN = birthdayInfo.birthday_show_status.intValue();
            this.constellation = birthdayInfo.constellation;
            this.age = birthdayInfo.age.intValue();
        }
    }
}
