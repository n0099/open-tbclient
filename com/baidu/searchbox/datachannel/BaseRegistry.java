package com.baidu.searchbox.datachannel;

import android.content.Context;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes12.dex */
public class BaseRegistry {
    public static boolean registerRNReceiver(String str, BaseBroadcastReceiver baseBroadcastReceiver) {
        Context appContext = AppRuntime.getAppContext();
        ReceiverManager.getInstance().addReceiver(baseBroadcastReceiver);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        LocalBroadcastManager.getInstance(appContext).registerReceiver(baseBroadcastReceiver, intentFilter);
        if (Contract.DEBUG) {
            Log.d(Contract.TAG, "Registry registerRNReceiver ## " + baseBroadcastReceiver.toString());
            return true;
        }
        return true;
    }

    public static void registerNAReceiver(String str, String str2, @NonNull String str3, @NonNull NAReceiverCallback nAReceiverCallback) {
        if (nAReceiverCallback == null || TextUtils.isEmpty(str3)) {
            if (Contract.DEBUG) {
                Log.d(Contract.TAG, "Registry registerNAReceiver invalid param");
                return;
            }
            return;
        }
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
    }

    public static void registerAPSReceiver(String str, String str2, @NonNull String str3, @NonNull APSReceiverCallback aPSReceiverCallback) {
        if (aPSReceiverCallback == null || TextUtils.isEmpty(str3)) {
            if (Contract.DEBUG) {
                Log.d(Contract.TAG, "Registry registerAPSReceiver invalid param");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = Contract.DEFAULT_HOST;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = Contract.DEFAULT_PAGE;
        }
        Context appContext = AppRuntime.getAppContext();
        APSReceiver aPSReceiver = new APSReceiver(aPSReceiverCallback, str, str2, str3);
        ReceiverManager.getInstance().addReceiver(aPSReceiver);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str3);
        LocalBroadcastManager.getInstance(appContext).registerReceiver(aPSReceiver, intentFilter);
        if (Contract.DEBUG) {
            Log.d(Contract.TAG, "Registry registerAPSReceiver ## " + aPSReceiver.toString());
        }
    }

    public static void unregisterReceiver(String str) {
        if (TextUtils.isEmpty(str)) {
            str = Contract.DEFAULT_HOST;
        }
        if (Contract.DEBUG) {
            Log.d(Contract.TAG, "Registry unregisterReceiver ## host=" + str);
        }
        Context appContext = AppRuntime.getAppContext();
        for (BaseBroadcastReceiver baseBroadcastReceiver : ReceiverManager.getInstance().removeReceivers(str)) {
            LocalBroadcastManager.getInstance(appContext).unregisterReceiver(baseBroadcastReceiver);
            if (Contract.DEBUG) {
                Log.d(Contract.TAG, "Registry unregisterReceiver ## " + baseBroadcastReceiver.toString());
            }
        }
    }

    public static void unregisterReceiver(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = Contract.DEFAULT_HOST;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = Contract.DEFAULT_PAGE;
        }
        if (Contract.DEBUG) {
            Log.d(Contract.TAG, "Registry unregisterReceiver ## host=" + str + " page=" + str2);
        }
        Context appContext = AppRuntime.getAppContext();
        for (BaseBroadcastReceiver baseBroadcastReceiver : ReceiverManager.getInstance().removeReceivers(str, str2)) {
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
}
