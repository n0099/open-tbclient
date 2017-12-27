package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.IntentCompat;
import android.support.v4.content.SharedPreferencesCompat;
/* loaded from: classes2.dex */
public class AppLaunchChecker {
    public static boolean hasStartedFromLauncher(Context context) {
        return context.getSharedPreferences("android.support.AppLaunchChecker", 0).getBoolean("startedFromLauncher", false);
    }

    public static void onActivityCreate(Activity activity) {
        Intent intent;
        SharedPreferences sharedPreferences = activity.getSharedPreferences("android.support.AppLaunchChecker", 0);
        if (!sharedPreferences.getBoolean("startedFromLauncher", false) && (intent = activity.getIntent()) != null && "android.intent.action.MAIN".equals(intent.getAction())) {
            if (intent.hasCategory("android.intent.category.LAUNCHER") || intent.hasCategory(IntentCompat.CATEGORY_LEANBACK_LAUNCHER)) {
                SharedPreferencesCompat.EditorCompat.getInstance().apply(sharedPreferences.edit().putBoolean("startedFromLauncher", true));
            }
        }
    }
}
