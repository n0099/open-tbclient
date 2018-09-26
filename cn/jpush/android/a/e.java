package cn.jpush.android.a;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class e {
    public static void a(String str, int i, String str2, Context context) {
        if (cn.jiguang.api.e.bf() && context != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("action:reportActionResult - messageId: " + str + ", code: " + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + m.a(i));
            if (!TextUtils.isEmpty(str2)) {
                stringBuffer.append(" report content: " + str2);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msg_id", str);
                jSONObject.put("result", i);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("data", str2);
                }
                cn.jiguang.api.e.c(jSONObject, "msg_status");
                cn.jiguang.api.e.a(context, jSONObject, cn.jpush.android.a.a);
            } catch (JSONException e) {
            }
        }
    }

    public static void a(String str, String str2, byte b, int i, Context context) {
        if (cn.jiguang.api.e.bf() && context != null) {
            new StringBuffer().append("action:reportThirdSDKMsgActionResult - messageId: " + str + ", code: " + i);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msg_id", str);
                jSONObject.put("tmsg_id", str2);
                jSONObject.put("result", i);
                jSONObject.put("sdk_type", (int) b);
                cn.jiguang.api.e.c(jSONObject, "third_msg_status");
                cn.jiguang.api.e.a(context, jSONObject, cn.jpush.android.a.a);
            } catch (JSONException e) {
            }
        }
    }
}
