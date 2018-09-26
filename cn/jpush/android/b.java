package cn.jpush.android;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.i;
import cn.jpush.android.a.l;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.c;
import cn.jpush.android.service.e;
/* loaded from: classes3.dex */
public final class b {
    public static int a(Context context) {
        return i.getInt(context, "notification_num", JPushInterface.a);
    }

    public static String a(Context context, int i) {
        return i.getString(context, "pluginPlatformRegid" + i, null);
    }

    public static void a(Context context, int i, String str) {
        i.f(context, "pluginPlatformRegid" + i, str);
    }

    public static void a(Context context, int i, boolean z) {
        if (z) {
            int b = l.b();
            if (i < b) {
                c.a(context, b - i);
            }
            i.d(context, "notification_num", i);
            return;
        }
        Bundle bundle = new Bundle();
        e.a(context, bundle, "intent.MULTI_PROCESS");
        bundle.putInt("multi_type", 2);
        bundle.putInt("notification_maxnum", i);
        cn.jiguang.api.e.b(context, a.a, bundle);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (z || cn.jiguang.api.e.bd()) {
            i.f(context, "jpush_save_custom_builder" + str, str2);
            return;
        }
        Bundle bundle = new Bundle();
        e.a(context, bundle, "intent.MULTI_PROCESS");
        bundle.putInt("multi_type", 1);
        bundle.putString("notification_buidler_id", str);
        bundle.putString("notification_buidler", str2);
        cn.jiguang.api.e.b(context, a.a, bundle);
    }

    public static void a(Context context, String str, boolean z) {
        if (z || cn.jiguang.api.e.bd()) {
            i.f(context, "setting_silence_push_time", str);
            return;
        }
        Bundle bundle = new Bundle();
        e.a(context, bundle, "intent.MULTI_PROCESS");
        bundle.putInt("multi_type", 4);
        bundle.putString("silence_push_time", str);
        cn.jiguang.api.e.b(context, a.a, bundle);
    }

    public static String b(Context context) {
        return i.getString(context, "setting_push_time", "");
    }

    public static void b(Context context, int i, boolean z) {
        i.c(context, "pluginPlatformRegidupload" + i, z);
    }

    public static void b(Context context, String str, boolean z) {
        if (z || cn.jiguang.api.e.bd()) {
            i.f(context, "setting_push_time", str);
            return;
        }
        Bundle bundle = new Bundle();
        e.a(context, bundle, "intent.MULTI_PROCESS");
        bundle.putInt("multi_type", 3);
        bundle.putString("enable_push_time", str);
        cn.jiguang.api.e.b(context, a.a, bundle);
    }

    public static boolean b(Context context, int i) {
        return i.getBoolean(context, "pluginPlatformRegidupload" + i, false);
    }
}
