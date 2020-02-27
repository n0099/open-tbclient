package com.baidu.swan.apps.ao.d.b;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.swan.apps.b;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    /* renamed from: com.baidu.swan.apps.ao.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0206a {
        public static final a bWE = new a();
    }

    private a() {
    }

    public static a afL() {
        return C0206a.bWE;
    }

    public void b(Activity activity, float f) {
        if (activity != null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.screenBrightness = f;
            activity.getWindow().setAttributes(attributes);
        }
    }

    public float S(Activity activity) {
        if (activity != null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            if (attributes.screenBrightness < 0.0f) {
                return cz(activity);
            }
            return attributes.screenBrightness;
        }
        return -1.0f;
    }

    private static float cz(Context context) {
        int i = 0;
        try {
            i = Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i * 0.003921569f;
    }

    public void e(Activity activity, boolean z) {
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
