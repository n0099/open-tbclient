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
    public Map<String, C0101a> e = new HashMap();

    /* renamed from: com.baidu.sapi2.share.face.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0101a {
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
                        C0101a c0101a = new C0101a();
                        c0101a.b = optJSONObject.optString("livinguname");
                        c0101a.c = optJSONObject.optString("type");
                        c0101a.d = optJSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 1L);
                        c0101a.a = optJSONObject.optInt("errno", -1);
                        Log.e(Log.TAG, "livingUname", c0101a.b, "type", c0101a.c);
                        if (!TextUtils.isEmpty(c0101a.b)) {
                            if (TextUtils.isEmpty(this.b)) {
                                j = c0101a.d;
                                this.b = c0101a.b;
                                this.c = optJSONObject;
                            }
                            if (optJSONObject.optInt("errno") == 0 && c0101a.d > j) {
                                j = c0101a.d;
                                this.b = c0101a.b;
                                this.c = optJSONObject;
                            }
                            if (TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(c0101a.c)) {
                                this.d = c0101a.c;
                            }
                            this.a.put(c0101a.b, Long.valueOf(c0101a.d));
                            this.e.put(c0101a.b, c0101a);
                        }
                    }
                }
            }
        } catch (JSONException e) {
        }
    }
}
