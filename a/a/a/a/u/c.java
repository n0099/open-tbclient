package a.a.a.a.u;

import a.a.a.a.s.e;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends b {
    public c(e.a aVar) {
        super(aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00da A[Catch: JSONException -> 0x0115, TryCatch #1 {JSONException -> 0x0115, blocks: (B:13:0x002a, B:16:0x0039, B:18:0x0040, B:33:0x007a, B:35:0x0082, B:37:0x0093, B:43:0x00a5, B:45:0x00ad, B:51:0x00da, B:53:0x00e2, B:55:0x00ef, B:46:0x00bf, B:48:0x00c7, B:21:0x004a, B:22:0x0051, B:24:0x0057, B:31:0x0072, B:30:0x006f, B:29:0x006a, B:32:0x0075), top: B:62:0x002a }] */
    @Override // a.a.a.a.u.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<o, JSONObject> c(Object obj) {
        Object obj2;
        String sb;
        String str;
        String str2;
        String optString;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Object a2 = a.a.a.a.a.a("com.bytedance.sdk.openadsdk.core.d.l", obj);
        if (a2 == null) {
            return null;
        }
        try {
            obj2 = a2.getClass().getDeclaredMethod("aE", null).invoke(a2, new Object[0]);
        } catch (Exception e2) {
            a.a.a.a.v.d.a(e2);
            obj2 = null;
        }
        if (obj2 == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(obj2.toString());
            JSONObject optJSONObject3 = jSONObject.optJSONObject("icon");
            String optString2 = optJSONObject3 != null ? optJSONObject3.optString("url") : null;
            JSONArray optJSONArray = jSONObject.optJSONArray("image");
            if (optJSONArray == null) {
                sb = null;
            } else {
                StringBuilder sb2 = new StringBuilder();
                boolean z = true;
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString3 = optJSONArray.getJSONObject(i).optString("url");
                    if (!TextUtils.isEmpty(optString3)) {
                        if (z) {
                            z = false;
                        } else {
                            sb2.append(',');
                        }
                        sb2.append(optString3);
                    }
                }
                sb = sb2.toString();
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("video");
            if (optJSONObject4 != null) {
                String optString4 = optJSONObject4.optString("video_url");
                str = optJSONObject4.optString("cover_url");
                str2 = optString4;
            } else {
                str = null;
                str2 = null;
            }
            int optInt = jSONObject.optInt("interaction_type", -1);
            if (optInt != 3) {
                if (optInt == 4 && (optJSONObject2 = jSONObject.optJSONObject("app")) != null) {
                    str3 = optJSONObject2.optString(DpStatConstants.KEY_APP_NAME);
                    str4 = optJSONObject2.optString("package_name");
                    str5 = optJSONObject2.optString("download_url");
                    optString = null;
                    if (str3 == null || (optJSONObject = jSONObject.optJSONObject("app_manage")) == null) {
                        str6 = str3;
                        str7 = str4;
                    } else {
                        String optString5 = optJSONObject.optString(DpStatConstants.KEY_APP_NAME);
                        str7 = optJSONObject.optString("package_name");
                        str6 = optString5;
                    }
                    return new Pair<>(new o(jSONObject.optString("source"), jSONObject.optString("title"), jSONObject.optString("description"), optString2, str6, str7, str5, sb, str, str2, jSONObject.optString("target_url"), optString, null), jSONObject);
                }
                str3 = null;
                str4 = null;
                str5 = null;
                optString = null;
                if (str3 == null) {
                }
                str6 = str3;
                str7 = str4;
                return new Pair<>(new o(jSONObject.optString("source"), jSONObject.optString("title"), jSONObject.optString("description"), optString2, str6, str7, str5, sb, str, str2, jSONObject.optString("target_url"), optString, null), jSONObject);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("deep_link");
            if (optJSONObject5 != null) {
                optString = optJSONObject5.optString("deeplink_url");
                str3 = null;
                str4 = null;
                str5 = null;
                if (str3 == null) {
                }
                str6 = str3;
                str7 = str4;
                return new Pair<>(new o(jSONObject.optString("source"), jSONObject.optString("title"), jSONObject.optString("description"), optString2, str6, str7, str5, sb, str, str2, jSONObject.optString("target_url"), optString, null), jSONObject);
            }
            str3 = null;
            str4 = null;
            str5 = null;
            optString = null;
            if (str3 == null) {
            }
            str6 = str3;
            str7 = str4;
            return new Pair<>(new o(jSONObject.optString("source"), jSONObject.optString("title"), jSONObject.optString("description"), optString2, str6, str7, str5, sb, str, str2, jSONObject.optString("target_url"), optString, null), jSONObject);
        } catch (JSONException e3) {
            a.a.a.a.v.d.a(e3);
            return null;
        }
    }
}
