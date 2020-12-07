package com.baidu.android.util.devices;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
/* loaded from: classes6.dex */
public class ScreenBrightUtils {
    public static final int BRIGHT_MIN = 50;
    private static final String TAG = "BdBrightUtils";
    private static int mBrightLevel = -1;

    public static boolean isAutoBrightness(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness_mode") == 1;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getScreenBrightness(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getActivityBrightness(Activity activity) {
        int i;
        if (activity != null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            if (attributes.screenBrightness < 0.0f) {
                i = getScreenBrightness(activity);
            } else {
                i = (int) (attributes.screenBrightness * 255.0f);
            }
            if (mBrightLevel >= 0 && i <= 50) {
                return mBrightLevel;
            }
            return i;
        }
        return -1;
    }

    public static float getWinBrightness(Activity activity) {
        if (activity != null) {
            return (int) (activity.getWindow().getAttributes().screenBrightness * 255.0f);
        }
        return -1.0f;
    }

    private static void setWinBrightness(Activity activity, int i) {
        if (activity != null) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.screenBrightness = i;
            window.setAttributes(attributes);
        }
    }

    public static void setWinDefBrightness(Activity activity) {
        setWinBrightness(activity, -1);
    }

    public static void setBrightness(Activity activity, int i) {
        if (activity != null) {
            mBrightLevel = limitRange(i, 0, 255);
            int limitRange = limitRange(i, 50, 255);
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.screenBrightness = Float.valueOf(limitRange).floatValue() * 0.003921569f;
            activity.getWindow().setAttributes(attributes);
        }
    }

    public static void stopAutoBrightness(Activity activity) {
        Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", 0);
    }

    public static void startAutoBrightness(Activity activity) {
        Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", 1);
    }

    public static void saveBrightness(Activity activity, int i) {
        Uri uriFor = Settings.System.getUriFor("screen_brightness");
        ContentResolver contentResolver = activity.getContentResolver();
        Settings.System.putInt(contentResolver, "screen_brightness", i);
        contentResolver.notifyChange(uriFor, null);
    }

    private static int limitRange(int i, int i2, int i3) {
        int i4 = i < i2 ? i2 : i;
        return i4 > i3 ? i3 : i4;
    }
}
