package cn.jpush.android.api;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import cn.jpush.android.d.f;
import cn.jpush.android.service.PushReceiver;
import cn.jpush.android.ui.PopWinActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MultiActionsNotificationBuilder extends DefaultPushNotificationBuilder {
    private static final String NOTI_ACT_EXTRA_STR = "notification_action_extra_string";
    private static final String NOTI_ACT_RES_ID = "notification_action_res_id";
    private static final String NOTI_ACT_TEXT = "notification_action_text";
    private static final String TAG = "MultiActionsNotificationBuilder";
    private JSONArray actionJSONArray = new JSONArray();
    protected Context mContext;

    public MultiActionsNotificationBuilder(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PushNotificationBuilder parseFromPreference(String str) {
        MultiActionsNotificationBuilder multiActionsNotificationBuilder = new MultiActionsNotificationBuilder(cn.jpush.android.a.e);
        try {
            multiActionsNotificationBuilder.actionJSONArray = new JSONArray(str);
        } catch (JSONException e) {
            f.c(TAG, "Parse builder from preference failed!");
            e.printStackTrace();
        }
        return multiActionsNotificationBuilder;
    }

    public void addJPushAction(int i, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NOTI_ACT_RES_ID, i);
            jSONObject.put(NOTI_ACT_TEXT, str);
            jSONObject.put(NOTI_ACT_EXTRA_STR, str2);
            this.actionJSONArray.put(jSONObject);
        } catch (JSONException e) {
            f.c(TAG, "Construct action failed!");
            e.printStackTrace();
        }
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder
    @TargetApi(11)
    Notification getNotification(Notification.Builder builder) {
        PendingIntent broadcast;
        if (Build.VERSION.SDK_INT >= 16) {
            for (int i = 0; i < this.actionJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = this.actionJSONArray.getJSONObject(i);
                    Intent intent = new Intent("cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION_PROXY");
                    intent.putExtra(JPushInterface.EXTRA_NOTIFICATION_ACTION_EXTRA, jSONObject.getString(NOTI_ACT_EXTRA_STR));
                    if (cn.jiguang.api.e.bB()) {
                        intent.setClass(this.mContext, PopWinActivity.class);
                        intent.putExtra("isNotification", true);
                        broadcast = PendingIntent.getActivity(this.mContext, i, intent, 134217728);
                    } else {
                        intent.setClass(this.mContext, PushReceiver.class);
                        broadcast = PendingIntent.getBroadcast(this.mContext, i, intent, 134217728);
                    }
                    builder.addAction(jSONObject.getInt(NOTI_ACT_RES_ID), jSONObject.getString(NOTI_ACT_TEXT), broadcast).setAutoCancel(true);
                } catch (JSONException e) {
                    f.c(TAG, "Parse Action from preference preference failed!");
                    e.printStackTrace();
                }
            }
            return builder.build();
        }
        return builder.getNotification();
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder
    public String toString() {
        return this.actionJSONArray.toString();
    }
}
