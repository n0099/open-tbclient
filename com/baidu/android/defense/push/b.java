package com.baidu.android.defense.push;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import com.baidu.android.pushservice.PushConstants;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f506a = b.class.getSimpleName();

    private b() {
    }

    public static void a(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("moplus_psetting", 0).edit();
        edit.putInt("push_bind", i);
        edit.commit();
    }

    public static void a(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("moplus_psetting", 0).edit();
        edit.putLong("register_time", j);
        edit.commit();
    }

    public static void a(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("moplus_psetting", 0).edit();
        edit.putString("push_access_token", str);
        edit.commit();
    }

    public static void a(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("moplus_psetting", 0).edit();
        edit.putBoolean("registered", z);
        edit.commit();
    }

    public static boolean a(Context context) {
        return context.getSharedPreferences("moplus_psetting", 0).getInt("push_bind", 0) != 0;
    }

    public static int b(Context context) {
        return context.getSharedPreferences("moplus_psetting", 0).getInt("push_bind", 0);
    }

    public static void b(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("moplus_psetting", 0).edit();
        edit.putString("channel_id", str);
        edit.commit();
    }

    public static String c(Context context) {
        return context.getSharedPreferences("moplus_psetting", 0).getString("push_access_token", "");
    }

    public static void c(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("moplus_psetting", 0).edit();
        edit.putString(PushConstants.EXTRA_USER_ID, str);
        edit.commit();
    }

    public static String d(Context context) {
        return context.getSharedPreferences("moplus_psetting", 0).getString("channel_id", "");
    }

    public static String e(Context context) {
        return context.getSharedPreferences("moplus_psetting", 0).getString(PushConstants.EXTRA_USER_ID, "");
    }

    public static long f(Context context) {
        return context.getSharedPreferences("moplus_psetting", 0).getLong("register_time", 0L);
    }

    public static boolean g(Context context) {
        return context.getSharedPreferences("moplus_psetting", 0).getBoolean("registered", false);
    }

    public static void h(Context context) {
        a(context, true);
        a(context, System.currentTimeMillis());
    }

    public static long i(Context context) {
        return context.getSharedPreferences("moplus_psetting", 0).getLong("last_bind_time", 0L);
    }

    public static void j(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("moplus_psetting", 0).edit();
        edit.putLong("last_bind_time", System.currentTimeMillis());
        edit.commit();
    }

    public static boolean k(Context context) {
        boolean z = false;
        Iterator<ResolveInfo> it = context.getPackageManager().queryBroadcastReceivers(new Intent(PushConstants.ACTION_RECEIVE), 0).iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            ResolveInfo next = it.next();
            if (context.getPackageName().equals(next.activityInfo.packageName) && !PushMsgReceiver.class.getName().equals(next.activityInfo.name)) {
                z2 = true;
            }
            z = z2;
        }
    }
}
