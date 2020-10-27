package com.baidu.prologue.a.c;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;
/* loaded from: classes19.dex */
public class j {
    public static final boolean DEBUG = com.baidu.prologue.a.b.a.cbs.get().Zu();

    public static boolean O(@NonNull Context context, @NonNull String str) {
        ResolveInfo next;
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities.size() > 0 && (next = queryIntentActivities.iterator().next()) != null) {
                String str2 = next.activityInfo.name;
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setComponent(new ComponentName(str, str2));
                intent2.setFlags(268435456);
                boolean z2 = true;
                try {
                    context.startActivity(intent2);
                } catch (ActivityNotFoundException e) {
                    z2 = false;
                }
                z = z2;
            }
            if (DEBUG && !z) {
                Log.e("OpenAppUtil", "openAppByPkgName: " + str + "  failed");
            }
        }
        return z;
    }

    public static boolean P(@NonNull Context context, @NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0) {
            return false;
        }
        intent.setPackage(queryIntentActivities.get(0).activityInfo.packageName);
        try {
            context.startActivity(intent);
            if (DEBUG) {
                Log.e("OpenAppUtil", "openAppByScheme success, match scheme size: " + queryIntentActivities.size());
            }
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }
}
