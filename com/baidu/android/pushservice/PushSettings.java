package com.baidu.android.pushservice;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
/* loaded from: classes.dex */
public class PushSettings {

    /* renamed from: a  reason: collision with root package name */
    public static Context f294a;

    public static String a() {
        if (f294a == null) {
            Log.e("PushSettings", "mContext == null");
            return "";
        }
        return Settings.System.getString(f294a.getContentResolver(), "com.baidu.pushservice.channel_id");
    }

    public static void a(String str) {
        if (f294a == null) {
            Log.e("PushSettings", "setChannelId mContext == null");
        } else {
            Settings.System.putString(f294a.getContentResolver(), "com.baidu.pushservice.channel_id", str);
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            Log.e("PushSettings", "getConnectState, context == null");
            return true;
        }
        try {
            return Settings.System.getInt(context.getContentResolver(), "com.baidu.pushservice.PushSettings.connect_state") == 1;
        } catch (Settings.SettingNotFoundException e) {
            Log.w("PushSettings", "com.baidu.pushservice.PushSettings.connect_state setting is not set.");
            return true;
        }
    }

    public static String b() {
        if (f294a == null) {
            Log.e("PushSettings", "getChannelToken mContext == null");
            return "";
        }
        return Settings.System.getString(f294a.getContentResolver(), "com.baidu.pushservice.channel_token");
    }

    public static void b(String str) {
        if (f294a == null) {
            Log.e("PushSettings", "setChannelToken mContext == null");
        } else {
            Settings.System.putString(f294a.getContentResolver(), "com.baidu.pushservice.channel_token", str);
        }
    }

    public static boolean c() {
        if (f294a == null) {
            return false;
        }
        try {
            return Settings.System.getInt(f294a.getContentResolver(), "com.baidu.android.pushservice.PushSettings.debug_mode") == 1;
        } catch (Settings.SettingNotFoundException e) {
            return false;
        }
    }

    public static void enableDebugMode(Context context, boolean z) {
        if (context == null) {
            Log.e("PushSettings", "enableDebugMode context == null");
        } else if (z) {
            Settings.System.putInt(context.getContentResolver(), "com.baidu.android.pushservice.PushSettings.debug_mode", 1);
        } else {
            Settings.System.putInt(context.getContentResolver(), "com.baidu.android.pushservice.PushSettings.debug_mode", 0);
        }
    }
}
