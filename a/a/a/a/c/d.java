package a.a.a.a.c;

import a.a.a.a.a.e;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends c {
    public d(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c.c
    public Pair<p, JSONObject> j(Object obj) {
        Object obj2;
        String sb;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Object c = a.a.a.a.a.c("com.bytedance.sdk.openadsdk.core.d.l", obj);
        if (c == null) {
            return null;
        }
        try {
            obj2 = c.getClass().getDeclaredMethod("aE", null).invoke(c, new Object[0]);
        } catch (Exception e) {
            a.a.a.a.v.d.a(e);
            obj2 = null;
        }
        if (obj2 == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(obj2.toString());
            JSONObject optJSONObject3 = jSONObject.optJSONObject(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            String optString = optJSONObject3 != null ? optJSONObject3.optString("url") : null;
            JSONArray optJSONArray = jSONObject.optJSONArray("image");
            if (optJSONArray == null) {
                sb = null;
            } else {
                StringBuilder sb2 = new StringBuilder();
                boolean z = true;
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString2 = optJSONArray.getJSONObject(i).optString("url");
                    if (!TextUtils.isEmpty(optString2)) {
                        if (z) {
                            z = false;
                        } else {
                            sb2.append(',');
                        }
                        sb2.append(optString2);
                    }
                }
                sb = sb2.toString();
            }
            String str = null;
            String str2 = null;
            JSONObject optJSONObject4 = jSONObject.optJSONObject("video");
            if (optJSONObject4 != null) {
                str = optJSONObject4.optString("video_url");
                str2 = optJSONObject4.optString("cover_url");
            }
            String str3 = null;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            int optInt = jSONObject.optInt("interaction_type", -1);
            if (optInt == 3) {
                JSONObject optJSONObject5 = jSONObject.optJSONObject("deep_link");
                if (optJSONObject5 != null) {
                    str5 = optJSONObject5.optString("deeplink_url");
                }
            } else if (optInt == 4 && (optJSONObject2 = jSONObject.optJSONObject("app")) != null) {
                str3 = optJSONObject2.optString("app_name");
                str4 = optJSONObject2.optString("package_name");
                str6 = optJSONObject2.optString("download_url");
            }
            if (str3 == null && (optJSONObject = jSONObject.optJSONObject("app_manage")) != null) {
                str3 = optJSONObject.optString("app_name");
                str4 = optJSONObject.optString("package_name");
            }
            return new Pair<>(new p(jSONObject.optString("source"), jSONObject.optString("title"), jSONObject.optString("description"), optString, str3, str4, str6, sb, str2, str, jSONObject.optString("target_url"), str5, null), jSONObject);
        } catch (JSONException e2) {
            a.a.a.a.v.d.a(e2);
            return null;
        }
    }
}
