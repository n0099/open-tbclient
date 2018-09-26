package cn.jpush.android.data;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class JPushLocalNotification implements Serializable {
    private String f;
    private String g;
    private String h;
    private long i;
    private int a = 1;
    private String b = "";
    private String c = "00";
    private String d = "00";
    private long e = 0;
    private long j = 1;
    private int k = 1;
    private String l = "";
    private String m = "";

    private static void a(String str, String str2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.j == ((JPushLocalNotification) obj).j;
    }

    public long getBroadcastTime() {
        return this.e;
    }

    public long getBuilderId() {
        return this.i;
    }

    public String getContent() {
        return this.f;
    }

    public String getExtras() {
        return this.h;
    }

    public long getNotificationId() {
        return this.j;
    }

    public String getTitle() {
        return this.g;
    }

    public int hashCode() {
        return (int) (this.j ^ (this.j >>> 32));
    }

    public void setBroadcastTime(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i < 0 || i2 <= 0 || i2 > 12 || i3 <= 0 || i3 > 31 || i4 < 0 || i4 > 23 || i5 < 0 || i5 > 59 || i6 < 0 || i6 > 59) {
            cn.jpush.android.d.f.d("JPushLocalNotification", "Set time fail! Please check your args!");
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(i, i2 - 1, i3, i4, i5, i6);
        Date time = calendar.getTime();
        long currentTimeMillis = System.currentTimeMillis();
        if (time.getTime() < currentTimeMillis) {
            this.e = currentTimeMillis;
        } else {
            this.e = time.getTime();
        }
    }

    public void setBroadcastTime(long j) {
        this.e = j;
    }

    public void setBroadcastTime(Date date) {
        this.e = date.getTime();
    }

    public void setBuilderId(long j) {
        this.i = j;
    }

    public void setContent(String str) {
        this.f = str;
    }

    public void setExtras(String str) {
        this.h = str;
    }

    public void setNotificationId(long j) {
        this.j = (int) j;
    }

    public void setTitle(String str) {
        this.g = str;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x004c: IGET  (r4v0 long A[REMOVE]) = (r6v0 'this' cn.jpush.android.data.JPushLocalNotification A[IMMUTABLE_TYPE, THIS]) cn.jpush.android.data.JPushLocalNotification.j long)] */
    public String toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(this.h)) {
                jSONObject2.put("n_extras", new JSONObject(this.h));
            }
            a("n_content", this.f, jSONObject2);
            a("n_title", this.g, jSONObject2);
            a("n_content", this.f, jSONObject2);
            jSONObject2.put("ad_t", 0);
            jSONObject.put("m_content", jSONObject2);
            a("msg_id", new StringBuilder().append(this.j).toString(), jSONObject);
            a("content_type", this.m, jSONObject);
            a("override_msg_id", this.l, jSONObject);
            jSONObject.put("n_only", this.k);
            jSONObject.put("n_builder_id", this.i);
            jSONObject.put("show_type", 3);
            jSONObject.put("notificaion_type", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
