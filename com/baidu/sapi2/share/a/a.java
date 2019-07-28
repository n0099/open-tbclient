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
    public Map<String, C0102a> e = new HashMap();

    /* renamed from: com.baidu.sapi2.share.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0102a {
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
                        C0102a c0102a = new C0102a();
                        c0102a.b = optJSONObject.optString("livinguname");
                        c0102a.c = optJSONObject.optString("type");
                        c0102a.d = optJSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 1L);
                        c0102a.a = optJSONObject.optInt("errno", -1);
                        Log.e(Log.TAG, "livingUname", c0102a.b, "type", c0102a.c);
                        if (!TextUtils.isEmpty(c0102a.b)) {
                            if (TextUtils.isEmpty(this.b)) {
                                j = c0102a.d;
                                this.b = c0102a.b;
                                this.c = optJSONObject;
                            }
                            if (optJSONObject.optInt("errno") == 0 && c0102a.d > j) {
                                j = c0102a.d;
                                this.b = c0102a.b;
                                this.c = optJSONObject;
                            }
                            if (TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(c0102a.c)) {
                                this.d = c0102a.c;
                            }
                            this.a.put(c0102a.b, Long.valueOf(c0102a.d));
                            this.e.put(c0102a.b, c0102a);
                        }
                    }
                }
            }
        } catch (JSONException e) {
        }
    }
}
