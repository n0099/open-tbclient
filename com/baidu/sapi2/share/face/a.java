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
    public Map<String, C0100a> e = new HashMap();

    /* renamed from: com.baidu.sapi2.share.face.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0100a {
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
                        C0100a c0100a = new C0100a();
                        c0100a.b = optJSONObject.optString("livinguname");
                        c0100a.c = optJSONObject.optString("type");
                        c0100a.d = optJSONObject.optLong("time", 1L);
                        c0100a.a = optJSONObject.optInt("errno", -1);
                        Log.e(Log.TAG, "livingUname", c0100a.b, "type", c0100a.c);
                        if (!TextUtils.isEmpty(c0100a.b)) {
                            if (TextUtils.isEmpty(this.b)) {
                                j = c0100a.d;
                                this.b = c0100a.b;
                                this.c = optJSONObject;
                            }
                            if (optJSONObject.optInt("errno") == 0 && c0100a.d > j) {
                                j = c0100a.d;
                                this.b = c0100a.b;
                                this.c = optJSONObject;
                            }
                            if (TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(c0100a.c)) {
                                this.d = c0100a.c;
                            }
                            this.a.put(c0100a.b, Long.valueOf(c0100a.d));
                            this.e.put(c0100a.b, c0100a);
                        }
                    }
                }
            }
        } catch (JSONException e) {
        }
    }
}
