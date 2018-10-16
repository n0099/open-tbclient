package com.baidu.searchbox.ng.ai.apps.system.brightness.utils;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
/* loaded from: classes2.dex */
public class AiAppsBrightnessManager {
    private static final boolean DEBUG = false;
    private static final String TAG = "BrightnessManager";

    /* loaded from: classes2.dex */
    private static class SingletonHolder {
        public static final AiAppsBrightnessManager sInstance = new AiAppsBrightnessManager();

        private SingletonHolder() {
        }
    }

    private AiAppsBrightnessManager() {
    }

    public static AiAppsBrightnessManager getInstance() {
        return SingletonHolder.sInstance;
    }

    public void setBrightness(Activity activity, float f) {
        if (activity != null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.screenBrightness = f;
            activity.getWindow().setAttributes(attributes);
        }
    }

    public float getBrightness(Activity activity) {
        if (activity != null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            if (attributes.screenBrightness < 0.0f) {
                return getScreenBrightness(activity);
            }
            return attributes.screenBrightness;
        }
        return -1.0f;
    }

    private static float getScreenBrightness(Context context) {
        int i = 0;
        try {
            i = Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i * 0.003921569f;
    }

    public void setScreenOn(Activity activity, boolean z) {
        if (activity != null) {
            Window window = activity.getWindow();
            if (z) {
                window.addFlags(128);
            } else {
                window.clearFlags(128);
            }
        }
    }
}
