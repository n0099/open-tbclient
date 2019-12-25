package com.baidu.searchbox.datachannel;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes11.dex */
public class Sender {
    public static boolean sendBroadcast(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (Contract.DEBUG) {
            Log.d(Contract.TAG, "Sender sendBroadcast ## action:" + str + " data:" + String.valueOf(str2));
        }
        Intent intent = new Intent(str);
        intent.putExtra("data", str2);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        return true;
    }
}
