package a.a.a.a.u;

import a.a.a.a.s.e;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c {
    public d(e.a aVar) {
        super(aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00dd A[Catch: JSONException -> 0x011b, TryCatch #1 {JSONException -> 0x011b, blocks: (B:13:0x002a, B:16:0x003a, B:18:0x0041, B:33:0x007b, B:35:0x0084, B:37:0x0096, B:43:0x00a8, B:45:0x00b0, B:51:0x00dd, B:53:0x00e5, B:55:0x00f2, B:46:0x00c2, B:48:0x00ca, B:21:0x004b, B:22:0x0052, B:24:0x0058, B:31:0x0073, B:30:0x0070, B:29:0x006b, B:32:0x0076), top: B:62:0x002a }] */
    @Override // a.a.a.a.u.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<p, JSONObject> c(Object obj) {
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
                    return new Pair<>(new p(jSONObject.optString("source"), jSONObject.optString("title"), jSONObject.optString("description"), optString2, str6, str7, str5, sb, str, str2, jSONObject.optString("target_url"), optString, null), jSONObject);
                }
                str3 = null;
                str4 = null;
                str5 = null;
                optString = null;
                if (str3 == null) {
                }
                str6 = str3;
                str7 = str4;
                return new Pair<>(new p(jSONObject.optString("source"), jSONObject.optString("title"), jSONObject.optString("description"), optString2, str6, str7, str5, sb, str, str2, jSONObject.optString("target_url"), optString, null), jSONObject);
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
                return new Pair<>(new p(jSONObject.optString("source"), jSONObject.optString("title"), jSONObject.optString("description"), optString2, str6, str7, str5, sb, str, str2, jSONObject.optString("target_url"), optString, null), jSONObject);
            }
            str3 = null;
            str4 = null;
            str5 = null;
            optString = null;
            if (str3 == null) {
            }
            str6 = str3;
            str7 = str4;
            return new Pair<>(new p(jSONObject.optString("source"), jSONObject.optString("title"), jSONObject.optString("description"), optString2, str6, str7, str5, sb, str, str2, jSONObject.optString("target_url"), optString, null), jSONObject);
        } catch (JSONException e3) {
            a.a.a.a.v.d.a(e3);
            return null;
        }
    }
}
