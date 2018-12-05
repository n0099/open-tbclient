package com.baidu.sapi2.share.face;

import android.text.TextUtils;
import com.baidu.sapi2.base.debug.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public String b;
    public JSONObject c;
    public String d;
    public Map<String, Long> a = new HashMap();
    public Map<String, C0131a> e = new HashMap();

    /* renamed from: com.baidu.sapi2.share.face.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0131a {
        public int a;
        public String b;
        public String c;
        public long d;
    }

    public void a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("list");
                if (optJSONArray.length() != 0) {
                    long j = 0;
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        C0131a c0131a = new C0131a();
                        c0131a.b = optJSONObject.optString("livinguname");
                        c0131a.c = optJSONObject.optString("type");
                        c0131a.d = optJSONObject.optLong("time", 1L);
                        c0131a.a = optJSONObject.optInt("errno", -1);
                        Log.e(Log.TAG, "livingUname", c0131a.b, "type", c0131a.c);
                        if (!TextUtils.isEmpty(c0131a.b)) {
                            if (TextUtils.isEmpty(this.b)) {
                                j = c0131a.d;
                                this.b = c0131a.b;
                                this.c = optJSONObject;
                            }
                            if (optJSONObject.optInt("errno") == 0 && c0131a.d > j) {
                                j = c0131a.d;
                                this.b = c0131a.b;
                                this.c = optJSONObject;
                            }
                            if (TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(c0131a.c)) {
                                this.d = c0131a.c;
                            }
                            this.a.put(c0131a.b, Long.valueOf(c0131a.d));
                            this.e.put(c0131a.b, c0131a);
                        }
                    }
                }
            }
        } catch (JSONException e) {
        }
    }
}
