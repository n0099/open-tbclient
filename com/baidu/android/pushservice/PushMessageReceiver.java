package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes.dex */
public abstract class PushMessageReceiver extends BroadcastReceiver {
    public static final String TAG = "PushMessageReceiver";

    public abstract void onBind(Context context, int i, String str, String str2, String str3, String str4);

    public abstract void onDelTags(Context context, int i, List<String> list, List<String> list2, String str);

    public abstract void onListTags(Context context, int i, List<String> list, String str);

    public abstract void onMessage(Context context, String str, String str2);

    public abstract void onNotificationArrived(Context context, String str, String str2, String str3);

    public abstract void onNotificationClicked(Context context, String str, String str2, String str3);

    public abstract void onSetTags(Context context, int i, List<String> list, List<String> list2, String str);

    public abstract void onUnbind(Context context, int i, String str);

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null) {
            if (intent.getAction().equals("com.baidu.tieba.secret")) {
                handleMethod(context, intent.getStringExtra(PushConstants.EXTRA_METHOD), intent.getStringExtra(LegoListActivityConfig.PARAMS));
            }
            Log.d(TAG, " PushMessageListener new  !!!!!");
            Log.d(TAG, " PushMessageReceiver call PushMessageReceiverUtil : " + intent.toUri(0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage<Intent>(CmdConfigCustom.CMD_PUSH_PUSHMESSAGERECEIVER_ONRECEIVE, intent) { // from class: com.baidu.android.pushservice.PushMessageReceiver.1
            });
            return;
        }
        Log.d(TAG, " PushMessageReceiver return !!!!!");
    }

    private void handleMethod(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str2.split("!@!");
                if (str.equals("onBind")) {
                    onBind(context, Integer.parseInt(split[0]), split[1], split[2], split[3], split[4]);
                } else if (str.equals("onUnbind")) {
                    onUnbind(context, Integer.parseInt(split[0]), split[1]);
                } else if (!str.equals("onListTags") && !str.equals("onSetTags") && !str.equals("onDelTags")) {
                    if (str.equals("onMessage")) {
                        onMessage(context, split[0], split[1]);
                    } else if (str.equals("onNotificationClicked")) {
                        onNotificationClicked(context, split[0], split[1], split[2]);
                    } else if (str.equals("onNotificationArrived")) {
                        onNotificationArrived(context, split[0], split[1], split[2]);
                    }
                } else {
                    int parseInt = Integer.parseInt(split[0]);
                    JSONArray jSONArray = new JSONArray(split[1]);
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.getString(i));
                    }
                    if (str.equals("onListTags")) {
                        onListTags(context, parseInt, arrayList, split[2]);
                        return;
                    }
                    JSONArray jSONArray2 = new JSONArray(split[2]);
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        arrayList2.add(jSONArray2.getString(i2));
                    }
                    if (str.equals("onSetTags")) {
                        onSetTags(context, parseInt, arrayList, arrayList2, split[2]);
                    } else {
                        onDelTags(context, parseInt, arrayList, arrayList2, split[2]);
                    }
                }
            } catch (Exception e) {
                Log.e(TAG, "handleMethod exception: " + e);
            }
        }
    }

    public void onCheckBindState(Context context, int i, String str, boolean z) {
    }
}
