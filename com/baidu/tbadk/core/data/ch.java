package com.baidu.tbadk.core.data;

import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes.dex */
public class ch {
    public int age;
    public String constellation;
    public long eUv;
    public int eUw;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eUv = jSONObject.optLong("birthday_time", 0L);
            this.eUw = jSONObject.optInt("birthday_show_status", 0);
            this.constellation = jSONObject.optString("constellation", "");
            this.age = jSONObject.optInt("age", 0);
        }
    }

    public void a(BirthdayInfo birthdayInfo) {
        if (birthdayInfo != null) {
            this.eUv = birthdayInfo.birthday_time.longValue();
            this.eUw = birthdayInfo.birthday_show_status.intValue();
            this.constellation = birthdayInfo.constellation;
            this.age = birthdayInfo.age.intValue();
        }
    }
}
