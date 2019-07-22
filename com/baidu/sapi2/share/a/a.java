package com.baidu.sapi2.share.a;

import android.text.TextUtils;
import com.baidu.sapi2.utils.Log;
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
    public Map<String, C0097a> e = new HashMap();

    /* renamed from: com.baidu.sapi2.share.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0097a {
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
                        C0097a c0097a = new C0097a();
                        c0097a.b = optJSONObject.optString("livinguname");
                        c0097a.c = optJSONObject.optString("type");
                        c0097a.d = optJSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 1L);
                        c0097a.a = optJSONObject.optInt("errno", -1);
                        Log.e(Log.TAG, "livingUname", c0097a.b, "type", c0097a.c);
                        if (!TextUtils.isEmpty(c0097a.b)) {
                            if (TextUtils.isEmpty(this.b)) {
                                j = c0097a.d;
                                this.b = c0097a.b;
                                this.c = optJSONObject;
                            }
                            if (optJSONObject.optInt("errno") == 0 && c0097a.d > j) {
                                j = c0097a.d;
                                this.b = c0097a.b;
                                this.c = optJSONObject;
                            }
                            if (TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(c0097a.c)) {
                                this.d = c0097a.c;
                            }
                            this.a.put(c0097a.b, Long.valueOf(c0097a.d));
                            this.e.put(c0097a.b, c0097a);
                        }
                    }
                }
            }
        } catch (JSONException e) {
        }
    }
}
