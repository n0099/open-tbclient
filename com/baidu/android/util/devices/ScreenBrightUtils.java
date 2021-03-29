package com.baidu.android.util.devices;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
/* loaded from: classes.dex */
public class ScreenBrightUtils {
    public static final int BRIGHT_MIN = 50;
    public static final String TAG = "BdBrightUtils";
    public static int mBrightLevel = -1;

    public static int getActivityBrightness(Activity activity) {
        if (activity != null) {
            float f2 = activity.getWindow().getAttributes().screenBrightness;
            int screenBrightness = f2 < 0.0f ? getScreenBrightness(activity) : (int) (f2 * 255.0f);
            int i = mBrightLevel;
            return (i < 0 || screenBrightness > 50) ? screenBrightness : i;
        }
        return -1;
    }

    public static int getScreenBrightness(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static float getWinBrightness(Activity activity) {
        if (activity != null) {
            return (int) (activity.getWindow().getAttributes().screenBrightness * 255.0f);
        }
        return -1.0f;
    }

    public static boolean isAutoBrightness(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness_mode") == 1;
        } catch (Settings.SettingNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static int limitRange(int i, int i2, int i3) {
        if (i < i2) {
            i = i2;
        }
        return i > i3 ? i3 : i;
    }

    public static void saveBrightness(Activity activity, int i) {
        Uri uriFor = Settings.System.getUriFor("screen_brightness");
        ContentResolver contentResolver = activity.getContentResolver();
        Settings.System.putInt(contentResolver, "screen_brightness", i);
        contentResolver.notifyChange(uriFor, null);
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

    public static void setWinBrightness(Activity activity, int i) {
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

    public static void startAutoBrightness(Activity activity) {
        Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", 1);
    }

    public static void stopAutoBrightness(Activity activity) {
        Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", 0);
    }
}
