package com.baidu.searchbox.datachannel;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class DataChannel {

    /* loaded from: classes3.dex */
    public static class Registry {
        public static ReceiverAddListener receiverAddListener;

        /* loaded from: classes3.dex */
        public interface ReceiverAddListener {
            void addReceiver();
        }

        public static void registerNAReceiver(String str, String str2, @NonNull String str3, @NonNull NAReceiverCallback nAReceiverCallback) {
            if (nAReceiverCallback != null && !TextUtils.isEmpty(str3)) {
                if (TextUtils.isEmpty(str)) {
                    str = Contract.DEFAULT_HOST;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = Contract.DEFAULT_PAGE;
                }
                Context appContext = AppRuntime.getAppContext();
                NAReceiver nAReceiver = new NAReceiver(nAReceiverCallback, str, str2, str3);
                ReceiverManager.getInstance().addReceiver(nAReceiver);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(str3);
                LocalBroadcastManager.getInstance(appContext).registerReceiver(nAReceiver, intentFilter);
                if (Contract.DEBUG) {
                    Log.d(Contract.TAG, "Registry registerNAReceiver ## " + nAReceiver.toString());
                }
                ReceiverAddListener receiverAddListener2 = receiverAddListener;
                if (receiverAddListener2 != null) {
                    receiverAddListener2.addReceiver();
                }
            } else if (Contract.DEBUG) {
                Log.d(Contract.TAG, "Registry registerNAReceiver invalid param");
            }
        }

        public static void setListener(ReceiverAddListener receiverAddListener2) {
            receiverAddListener = receiverAddListener2;
        }

        public static void unregisterAllReceiver() {
            if (Contract.DEBUG) {
                Log.d(Contract.TAG, "Registry unregister all receivers");
            }
            Context appContext = AppRuntime.getAppContext();
            for (BaseBroadcastReceiver baseBroadcastReceiver : ReceiverManager.getInstance().removeAllReceivers()) {
                LocalBroadcastManager.getInstance(appContext).unregisterReceiver(baseBroadcastReceiver);
                if (Contract.DEBUG) {
                    Log.d(Contract.TAG, "Registry unregisterReceiver ## " + baseBroadcastReceiver.toString());
                }
            }
        }

        public static boolean unregisterReceiver(String str, String str2, @NonNull String str3) {
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                str = Contract.DEFAULT_HOST;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = Contract.DEFAULT_PAGE;
            }
            if (Contract.DEBUG) {
                Log.d(Contract.TAG, "Registry unregisterReceiver ## host=" + str + " page=" + str2 + " action=" + str3);
            }
            Context appContext = AppRuntime.getAppContext();
            for (BaseBroadcastReceiver baseBroadcastReceiver : ReceiverManager.getInstance().removeReceivers(str, str2, str3)) {
                LocalBroadcastManager.getInstance(appContext).unregisterReceiver(baseBroadcastReceiver);
                if (Contract.DEBUG) {
                    Log.d(Contract.TAG, "Registry unregisterReceiver ## " + baseBroadcastReceiver.toString());
                }
                baseBroadcastReceiver.release();
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static class Sender {
        public static Process process;

        /* loaded from: classes3.dex */
        public interface Process {
            void sendThroughProcess(String str, String str2);
        }

        public static void sendBroadcast(Context context, String str, String str2) {
            if (context == null || TextUtils.isEmpty(str)) {
                return;
            }
            if (Contract.DEBUG) {
                Log.d(Contract.TAG, "Sender sendBroadcast ## action:" + str + " data:" + String.valueOf(str2));
            }
            Intent intent = new Intent(str);
            intent.putExtra("data", str2);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            Process process2 = process;
            if (process2 != null) {
                process2.sendThroughProcess(str, str2);
            }
        }

        public static void sendBroadcastLocal(Context context, String str, String str2) {
            if (context == null || TextUtils.isEmpty(str)) {
                return;
            }
            if (Contract.DEBUG) {
                Log.d(Contract.TAG, "Sender sendBroadcast ## action:" + str + " data:" + String.valueOf(str2));
            }
            Intent intent = new Intent(str);
            intent.putExtra("data", str2);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }

        public static void setProcess(Process process2) {
            process = process2;
        }
    }
}
