package com.baidu.frontia.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class FrontiaPushMessageReceiver extends BroadcastReceiver {
    public static final String TAG = FrontiaPushMessageReceiver.class.getSimpleName();

    public abstract void onBind(Context context, int i, String str, String str2, String str3, String str4);

    public abstract void onDelTags(Context context, int i, List<String> list, List<String> list2, String str);

    public abstract void onListTags(Context context, int i, List<String> list, String str);

    public abstract void onMessage(Context context, String str, String str2);

    public abstract void onNotificationClicked(Context context, String str, String str2, String str3);

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int i = 0;
        if (intent.getAction().equals("com.baidu.android.pushservice.action.MESSAGE")) {
            if (intent.getExtras() == null) {
                return;
            }
            onMessage(context, intent.getExtras().getString("message_string"), intent.getStringExtra("extra_extra_custom_content"));
        } else if (!intent.getAction().equals("com.baidu.android.pushservice.action.RECEIVE")) {
            if (intent.getAction().equals("com.baidu.android.pushservice.action.notification.CLICK")) {
                onNotificationClicked(context, intent.getStringExtra("notification_title"), intent.getStringExtra("notification_content"), intent.getStringExtra("extra_extra_custom_content"));
            }
        } else {
            String stringExtra = intent.getStringExtra("method");
            int intExtra = intent.getIntExtra("error_msg", 0);
            String str = intent.getByteArrayExtra("content") != null ? new String(intent.getByteArrayExtra("content")) : "";
            try {
                if (stringExtra.equals("method_bind")) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    String string = jSONObject.getString("request_id");
                    JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                    onBind(context, intExtra, jSONObject2.getString("appid"), jSONObject2.getString("user_id"), jSONObject2.getString("channel_id"), string);
                } else if (stringExtra.equals("method_unbind")) {
                    onUnbind(context, intExtra, new JSONObject(str).getString("request_id"));
                } else if (stringExtra.equals("method_set_tags")) {
                    JSONObject jSONObject3 = new JSONObject(str);
                    String string2 = jSONObject3.getString("request_id");
                    JSONArray jSONArray = jSONObject3.getJSONObject("response_params").getJSONArray("details");
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    while (i < jSONArray.length()) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i);
                        String string3 = jSONObject4.getString("tag");
                        if (jSONObject4.getInt("result") == 0) {
                            arrayList.add(string3);
                        } else {
                            arrayList2.add(string3);
                        }
                        i++;
                    }
                    onSetTags(context, intExtra, arrayList, arrayList2, string2);
                } else if (!stringExtra.equals("method_del_tags")) {
                    if (stringExtra.equals("method_listtags")) {
                        onListTags(context, intExtra, intent.getStringArrayListExtra("tags_list"), new JSONObject(str).getString("request_id"));
                    }
                } else {
                    JSONObject jSONObject5 = new JSONObject(str);
                    String string4 = jSONObject5.getString("request_id");
                    JSONArray jSONArray2 = jSONObject5.getJSONObject("response_params").getJSONArray("details");
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    while (i < jSONArray2.length()) {
                        JSONObject jSONObject6 = jSONArray2.getJSONObject(i);
                        String string5 = jSONObject6.getString("tag");
                        if (jSONObject6.getInt("result") == 0) {
                            arrayList3.add(string5);
                        } else {
                            arrayList4.add(string5);
                        }
                        i++;
                    }
                    onDelTags(context, intExtra, arrayList3, arrayList4, string4);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract void onSetTags(Context context, int i, List<String> list, List<String> list2, String str);

    public abstract void onUnbind(Context context, int i, String str);
}
