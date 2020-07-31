package com.baidu.tbadk.core.data;

import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes.dex */
public class cb {
    public int age;
    public String constellation;
    public long dVm;
    public int dVn;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dVm = jSONObject.optLong("birthday_time", 0L);
            this.dVn = jSONObject.optInt("birthday_show_status", 0);
            this.constellation = jSONObject.optString("constellation", "");
            this.age = jSONObject.optInt("age", 0);
        }
    }

    public void a(BirthdayInfo birthdayInfo) {
        if (birthdayInfo != null) {
            this.dVm = birthdayInfo.birthday_time.longValue();
            this.dVn = birthdayInfo.birthday_show_status.intValue();
            this.constellation = birthdayInfo.constellation;
            this.age = birthdayInfo.age.intValue();
        }
    }
}
