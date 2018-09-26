package cn.jiguang.g;

import android.content.Context;
import android.support.v4.app.NotificationManagerCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import cn.jiguang.d.d.aa;
import com.baidu.baiduarsdk.ArBridge;
import com.tencent.tauth.AuthActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class h {
    private static final SparseArray<String> a;
    private static long b;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(0, "OK");
        a.put(-1001, "Exceed buffer size. Please contact support.");
        a.put(NotificationManagerCompat.IMPORTANCE_UNSPECIFIED, "Connection failed. Please check your connection and retry later!");
        a.put(-998, "Sending failed or timeout. Please Retry later!");
        a.put(-997, "Receiving failed or timeout. Please Retry later!");
        a.put(-996, "Connection is closed. Please Retry later!");
        a.put(-994, "Response timeout. Please Retry later!");
        a.put(-993, "Invalid socket. Please Retry later!");
        a.put(11, "Failed to register!");
        a.put(ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC, "Your appKey and android package name are not matched. Please double check them according to Application you created on Portal.");
        a.put(1006, "You android package name is not exist, Please register your pacakge name in Portal.");
        a.put(1007, "Invalid Imei, Register again.");
        a.put(1008, "Invalid appKey, Please get your Appkey from JIGUANG web console!");
        a.put(1009, "Your appKey is related to a non-Android App.Please use your Android App's appKey, or add an Android app for this appKey.");
        a.put(10000, "Receiver data parse error");
        a.put(102, "102 - Incorrect password");
        a.put(108, "108 - Incorrect uid");
        a.put(1012, "Server reject this connection, will clear cache and restart connect.");
        b = 0L;
    }

    public static String a(int i) {
        if (a.get(i) == null) {
            return null;
        }
        return a.get(i);
    }

    public static JSONObject a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AuthActivity.ACTION_KEY, "rmv");
            jSONObject.put("appid", str);
            aa.a((Context) null, jSONObject, "app_add_rmv");
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public static JSONObject h(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AuthActivity.ACTION_KEY, "add");
            jSONObject.put("appid", str);
            aa.a((Context) null, jSONObject, "app_add_rmv");
            jSONObject.put("install_type", i);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
