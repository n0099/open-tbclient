package com.baidu.swan.apps.al.d.b;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.swan.apps.b;
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    /* renamed from: com.baidu.swan.apps.al.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0334a {
        public static final a dbc = new a();
    }

    private a() {
    }

    public static a aEn() {
        return C0334a.dbc;
    }

    public void b(Activity activity, float f) {
        if (activity != null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.screenBrightness = f;
            activity.getWindow().setAttributes(attributes);
        }
    }

    public float L(Activity activity) {
        if (activity != null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            if (attributes.screenBrightness < 0.0f) {
                return cv(activity);
            }
            return attributes.screenBrightness;
        }
        return -1.0f;
    }

    private static float cv(Context context) {
        int i = 0;
        try {
            i = Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i * 0.003921569f;
    }

    public void h(Activity activity, boolean z) {
        Window window;
        if (activity != null && (window = activity.getWindow()) != null) {
            if (z) {
                window.addFlags(128);
            } else {
                window.clearFlags(128);
            }
        }
    }
}
