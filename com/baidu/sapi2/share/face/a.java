package com.baidu.sapi2.share.face;

import android.text.TextUtils;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
    public Map<String, C0070a> e = new HashMap();

    /* renamed from: com.baidu.sapi2.share.face.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0070a {
        public int a;
        public String b;
        public String c;
        public long d;
    }

    public void a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray(IntentConfig.LIST);
                if (optJSONArray.length() != 0) {
                    long j = 0;
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        C0070a c0070a = new C0070a();
                        c0070a.b = optJSONObject.optString("livinguname");
                        c0070a.c = optJSONObject.optString("type");
                        c0070a.d = optJSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 1L);
                        c0070a.a = optJSONObject.optInt("errno", -1);
                        Log.e(Log.TAG, "livingUname", c0070a.b, "type", c0070a.c);
                        if (!TextUtils.isEmpty(c0070a.b)) {
                            if (TextUtils.isEmpty(this.b)) {
                                j = c0070a.d;
                                this.b = c0070a.b;
                                this.c = optJSONObject;
                            }
                            if (optJSONObject.optInt("errno") == 0 && c0070a.d > j) {
                                j = c0070a.d;
                                this.b = c0070a.b;
                                this.c = optJSONObject;
                            }
                            if (TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(c0070a.c)) {
                                this.d = c0070a.c;
                            }
                            this.a.put(c0070a.b, Long.valueOf(c0070a.d));
                            this.e.put(c0070a.b, c0070a);
                        }
                    }
                }
            }
        } catch (JSONException e) {
        }
    }
}
