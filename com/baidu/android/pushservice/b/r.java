package com.baidu.android.pushservice.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.util.PushDatabase;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    private static final String f704a = r.class.getSimpleName();
    private static volatile r b = null;
    private Context c;

    private r(Context context) {
        this.c = null;
        this.c = context.getApplicationContext();
        if (this.c == null) {
            Log.e(f704a, "Error occurs with mContext");
        }
    }

    public static r a(Context context) {
        if (b == null) {
            b = new r(context);
        }
        if (com.baidu.android.pushservice.b.a(context)) {
            Log.d(f704a, "Current packet name: " + context.getPackageName());
        }
        return b;
    }

    public String a() {
        JSONArray jSONArray = new JSONArray();
        SQLiteDatabase db = PushDatabase.getDb(this.c);
        PushDatabase.deleteOldBehaviors(db);
        List<b> appInfo = PushDatabase.getAppInfo(db);
        try {
            List<i> promptBehaviorInfo = PushDatabase.getPromptBehaviorInfo(db);
            if (promptBehaviorInfo.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("app_appid", "9527");
                JSONArray jSONArray2 = new JSONArray();
                for (i iVar : promptBehaviorInfo) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("action_name", iVar.d());
                    jSONObject2.put("timestamp", iVar.e());
                    jSONObject2.put("network_status", iVar.f());
                    jSONObject2.put("heart", iVar.a());
                    jSONArray2.put(jSONObject2);
                }
                jSONObject.put("push_action", jSONArray2);
                jSONArray.put(jSONObject);
            }
            if (appInfo != null) {
                for (b bVar : appInfo) {
                    JSONObject jSONObject3 = new JSONObject();
                    String a2 = bVar.a();
                    if (!TextUtils.isEmpty(bVar.d())) {
                        jSONObject3.put("app_package_name", bVar.d());
                    }
                    if (!TextUtils.isEmpty(bVar.e())) {
                        jSONObject3.put("app_name", bVar.e());
                    }
                    if (!TextUtils.isEmpty(bVar.f())) {
                        jSONObject3.put("app_cfrom", bVar.f());
                    }
                    if (bVar.g() != -1) {
                        jSONObject3.put("app_vercode", bVar.g());
                    }
                    if (!TextUtils.isEmpty(bVar.h())) {
                        jSONObject3.put("app_vername", bVar.h());
                    }
                    if (bVar.i() != -1) {
                        jSONObject3.put("app_push_version", bVar.i());
                    }
                    jSONObject3.put("app_appid", bVar.a());
                    if (!TextUtils.isEmpty(bVar.b())) {
                        jSONObject3.put("user_id_rsa", bVar.b());
                    }
                    if (!TextUtils.isEmpty(bVar.c())) {
                        jSONObject3.put(PushConstants.EXTRA_USER_ID, bVar.c());
                    }
                    JSONArray jSONArray3 = new JSONArray();
                    List<j> pushBehaviorInfoByAppId = PushDatabase.getPushBehaviorInfoByAppId(db, a2);
                    List<a> apiBehaviorInfoByAppId = PushDatabase.getApiBehaviorInfoByAppId(db, a2);
                    try {
                        for (j jVar : pushBehaviorInfoByAppId) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("action_name", jVar.d());
                            jSONObject4.put("timestamp", jVar.e());
                            jSONObject4.put("network_status", jVar.f());
                            if (jVar.j() != -1) {
                                jSONObject4.put("msg_type", jVar.j());
                            }
                            if (!TextUtils.isEmpty(jVar.a())) {
                                jSONObject4.put("msg_id", jVar.a());
                            }
                            if (jVar.b() > 0) {
                                jSONObject4.put("msg_len", jVar.b());
                            }
                            jSONObject4.put("err_code", jVar.g());
                            jSONArray3.put(jSONObject4);
                        }
                        for (a aVar : apiBehaviorInfoByAppId) {
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("action_name", aVar.d());
                            jSONObject5.put("timestamp", aVar.e());
                            jSONObject5.put("network_status", aVar.f());
                            jSONObject5.put("msg_result", aVar.a());
                            jSONObject5.put("request_id", aVar.b());
                            jSONObject5.put("err_code", aVar.g());
                            jSONArray3.put(jSONObject5);
                        }
                    } catch (JSONException e) {
                        if (com.baidu.android.pushservice.b.a(this.c)) {
                            Log.e(f704a, "error: JSONException");
                        }
                    }
                    if (jSONArray3.length() != 0) {
                        jSONObject3.put("push_action", jSONArray3);
                        jSONArray.put(jSONObject3);
                    }
                }
            }
        } catch (JSONException e2) {
            if (com.baidu.android.pushservice.b.a(this.c)) {
                Log.e(f704a, "error:" + e2.getMessage());
            }
        }
        String jSONArray4 = jSONArray.length() == 0 ? "" : jSONArray.toString();
        if (com.baidu.android.pushservice.b.a(this.c)) {
            Log.d(f704a, "用户行为统计信息:" + jSONArray4);
        }
        return jSONArray4;
    }

    public String b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject2.put("os_name", "Android");
            jSONObject2.put("manufacture", Build.MANUFACTURER);
            jSONObject2.put("model", Build.MODEL);
            jSONObject2.put("wise_cuid", CommonParam.getCUID(this.c));
            jSONObject2.put("firmware", Build.FINGERPRINT);
            jSONObject2.put("mem_size", m.b());
            jSONObject2.put("screen_width", m.a(this.c)[0]);
            jSONObject2.put("screen_height", m.a(this.c)[1]);
            jSONObject2.put("cpu_model", m.c());
            jSONObject2.put("cpu_feature", m.d());
            jSONObject2.put("screen_density", m.a(this.c)[2]);
            jSONObject.put("user_device", jSONObject2);
            TelephonyManager telephonyManager = (TelephonyManager) this.c.getSystemService("phone");
            if (telephonyManager != null) {
                jSONObject4.put("type", telephonyManager.getNetworkType());
                jSONObject4.put("detail", telephonyManager.getNetworkOperatorName());
            }
            jSONObject4.put("access_type", m.d(this.c));
            if (telephonyManager != null) {
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator) || networkOperator.length() < 4) {
                    jSONObject4.put("mcc", -1);
                    jSONObject4.put("mnc", -1);
                } else {
                    try {
                        jSONObject4.put("mcc", Integer.parseInt(networkOperator.substring(0, 3)));
                        jSONObject4.put("mnc", Integer.parseInt(networkOperator.substring(3)));
                    } catch (NumberFormatException e) {
                        if (com.baidu.android.pushservice.b.a(this.c)) {
                            Log.e(f704a, "error:" + e.getMessage());
                        }
                        jSONObject4.put("mcc", -1);
                        jSONObject4.put("mnc", -1);
                    }
                }
            }
            jSONObject4.put("user_ip", m.b(this.c));
            jSONObject.put("user_network", jSONObject4);
            jSONObject3.put("channel_id", PushSettings.a());
            jSONObject3.put("push_running_version", 13);
            jSONObject.put("push_channel", jSONObject3);
        } catch (JSONException e2) {
            if (com.baidu.android.pushservice.b.a(this.c)) {
                Log.e(f704a, "error:" + e2.getMessage());
            }
        }
        return jSONObject.toString();
    }
}
