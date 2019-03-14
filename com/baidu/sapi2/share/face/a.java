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
    public Map<String, C0099a> e = new HashMap();

    /* renamed from: com.baidu.sapi2.share.face.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0099a {
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
                        C0099a c0099a = new C0099a();
                        c0099a.b = optJSONObject.optString("livinguname");
                        c0099a.c = optJSONObject.optString("type");
                        c0099a.d = optJSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 1L);
                        c0099a.a = optJSONObject.optInt("errno", -1);
                        Log.e(Log.TAG, "livingUname", c0099a.b, "type", c0099a.c);
                        if (!TextUtils.isEmpty(c0099a.b)) {
                            if (TextUtils.isEmpty(this.b)) {
                                j = c0099a.d;
                                this.b = c0099a.b;
                                this.c = optJSONObject;
                            }
                            if (optJSONObject.optInt("errno") == 0 && c0099a.d > j) {
                                j = c0099a.d;
                                this.b = c0099a.b;
                                this.c = optJSONObject;
                            }
                            if (TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(c0099a.c)) {
                                this.d = c0099a.c;
                            }
                            this.a.put(c0099a.b, Long.valueOf(c0099a.d));
                            this.e.put(c0099a.b, c0099a);
                        }
                    }
                }
            }
        } catch (JSONException e) {
        }
    }
}
