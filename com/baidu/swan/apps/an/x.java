package com.baidu.swan.apps.an;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsoluteLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class x {
    private static DisplayMetrics aWs;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final DisplayMetrics aWt = com.baidu.swan.apps.u.a.Cy().getResources().getDisplayMetrics();
    private static final float aWu = aWt.density;

    public static int co(Context context) {
        int i;
        boolean z;
        com.baidu.swan.apps.core.c.d dVar;
        boolean z2 = true;
        if (context == null) {
            return 0;
        }
        int displayHeight = getDisplayHeight(context);
        int statusBarHeight = getStatusBarHeight();
        int cp = cp(context);
        try {
            i = context.getResources().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        } catch (Resources.NotFoundException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            i = 0;
        }
        com.baidu.swan.apps.core.c.e uz = com.baidu.swan.apps.w.e.Ec().uz();
        com.baidu.swan.apps.core.c.d dVar2 = null;
        if (uz != null) {
            com.baidu.swan.apps.core.c.b yO = uz.yO();
            if (!(yO instanceof com.baidu.swan.apps.core.c.d)) {
                dVar = null;
            } else {
                dVar = (com.baidu.swan.apps.core.c.d) yO;
            }
            if (yO != null && yO.yc()) {
                try {
                    int dimensionPixelSize = context.getResources().getDimensionPixelSize(a.d.aiapps_action_bar_shadow_height);
                    if (dimensionPixelSize > 0) {
                        i += dimensionPixelSize;
                    }
                    dVar2 = dVar;
                } catch (Resources.NotFoundException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
            dVar2 = dVar;
        }
        if (dVar2 == null || !com.baidu.swan.apps.ae.a.d.a(dVar2.yk())) {
            z = false;
            z2 = false;
        } else {
            com.baidu.swan.apps.view.a.b yH = dVar2.yH();
            z = yH != null && yH.MB();
        }
        int i2 = displayHeight - cp;
        if (!z) {
            i2 -= statusBarHeight;
        }
        if (!z2) {
            i2 -= i;
        }
        if (i2 > 0) {
            return i2;
        }
        return 0;
    }

    public static int cp(Context context) {
        com.baidu.swan.apps.core.c.b yO;
        int i;
        Resources.NotFoundException e;
        com.baidu.swan.apps.core.c.e uz = com.baidu.swan.apps.w.e.Ec().uz();
        if (context == null || uz == null || (yO = uz.yO()) == null || !(yO instanceof com.baidu.swan.apps.core.c.d) || !((com.baidu.swan.apps.core.c.d) yO).xY()) {
            return 0;
        }
        try {
            i = context.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
        } catch (Resources.NotFoundException e2) {
            i = 0;
            e = e2;
        }
        try {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_shadow_height);
            if (dimensionPixelSize > 0) {
                return i + dimensionPixelSize;
            }
            return i;
        } catch (Resources.NotFoundException e3) {
            e = e3;
            if (DEBUG) {
                e.printStackTrace();
                return i;
            }
            return i;
        }
    }

    public static void a(BdBaseImageView bdBaseImageView, TextView textView, String str) {
        if ("0".equals(str)) {
            bdBaseImageView.setVisibility(8);
            textView.setVisibility(8);
        } else if ("1".equals(String.valueOf(str))) {
            bdBaseImageView.setVisibility(0);
            textView.setVisibility(0);
            textView.setText(a.h.aiapps_history_aiapp_tag);
        } else if ("2".equals(String.valueOf(str))) {
            bdBaseImageView.setVisibility(0);
            textView.setVisibility(0);
            textView.setText(a.h.aiapps_history_aiapp_tag_trial);
        } else if ("3".equals(String.valueOf(str))) {
            bdBaseImageView.setVisibility(0);
            textView.setVisibility(0);
            textView.setText(a.h.aiapps_history_aiapp_tag_experience);
        }
    }

    public static void O(Activity activity) {
        if (activity != null && com.baidu.swan.apps.view.a.b.aKW) {
            new com.baidu.swan.apps.view.a.b(activity).es(-1);
        }
    }

    @UiThread
    public static Bitmap Mf() {
        com.baidu.swan.apps.w.e Ec = com.baidu.swan.apps.w.e.Ec();
        AbsoluteLayout eO = Ec.eO(Ec.yB());
        if (eO == null || eO.getWidth() <= 0 || eO.getHeight() <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(eO.getWidth(), eO.getHeight(), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(-1);
        eO.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static Bitmap ah(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        rootView.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(rootView.getDrawingCache());
        rootView.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static int getDisplayWidth(Context context) {
        cs(com.baidu.swan.apps.u.a.Cy());
        if (aWs != null) {
            return aWs.widthPixels;
        }
        return 0;
    }

    public static int getDisplayHeight(Context context) {
        cs(com.baidu.swan.apps.u.a.Cy());
        if (aWs != null) {
            return aWs.heightPixels;
        }
        return 0;
    }

    public static float cq(Context context) {
        cs(com.baidu.swan.apps.u.a.Cy());
        if (aWs != null) {
            return aWs.density;
        }
        return 0.0f;
    }

    public static int cr(Context context) {
        cs(com.baidu.swan.apps.u.a.Cy());
        if (aWs != null) {
            return aWs.densityDpi;
        }
        return 0;
    }

    private static void cs(Context context) {
        if (aWs == null) {
            Application Cy = com.baidu.swan.apps.u.a.Cy();
            if (Cy != null) {
                context = Cy;
            }
            if (context != null) {
                aWs = context.getResources().getDisplayMetrics();
            }
        }
    }

    public static int ad(float f) {
        return dip2px(com.baidu.swan.apps.u.a.Cy(), f);
    }

    public static int ae(float f) {
        return px2dip(com.baidu.swan.apps.u.a.Cy(), f);
    }

    public static int dip2px(Context context, float f) {
        return (int) (cq(context) * f);
    }

    public static int px2dip(Context context, float f) {
        return (int) (f / cq(context));
    }

    public static float af(float f) {
        return f / cq(com.baidu.swan.apps.u.a.Cy());
    }

    public static int a(TextView textView) {
        if (textView == null) {
            return 0;
        }
        Paint paint = new Paint();
        paint.setTextSize(textView.getTextSize());
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        if (TextUtils.isEmpty(textView.getText())) {
            return 0;
        }
        return (int) (Math.ceil(fontMetrics.descent - fontMetrics.ascent) + 2.0d);
    }

    public static int b(TextView textView) {
        if (textView == null) {
            return 0;
        }
        Paint paint = new Paint();
        paint.setTextSize(textView.getTextSize());
        if (TextUtils.isEmpty(textView.getText())) {
            return 0;
        }
        return (int) paint.measureText(textView.getText().toString());
    }

    public static int getStatusBarHeight() {
        int i = 0;
        int identifier = com.baidu.swan.apps.u.a.Cy().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            try {
                i = com.baidu.swan.apps.u.a.Cy().getResources().getDimensionPixelSize(identifier);
            } catch (Exception e) {
            }
        }
        if (i == 0) {
            return (int) (25.0f * aWu);
        }
        return i;
    }

    public static int getNavigationBarHeight() {
        boolean hasPermanentMenuKey = ViewConfiguration.get(com.baidu.swan.apps.u.a.Cy()).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return 0;
        }
        Resources resources = com.baidu.swan.apps.u.a.Cy().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static boolean Mg() {
        return com.baidu.swan.apps.u.a.Cy().getResources().getConfiguration().orientation == 1;
    }

    public static int Mh() {
        Application Cy = com.baidu.swan.apps.u.a.Cy();
        Resources resources = Cy.getResources();
        if (Build.VERSION.SDK_INT < 14 || !hasNavBar(Cy)) {
            return 0;
        }
        return getInternalDimensionSize(resources, Mg() ? "navigation_bar_height" : "navigation_bar_height_landscape");
    }

    private static int getInternalDimensionSize(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    @TargetApi(14)
    public static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            boolean z = resources.getBoolean(identifier);
            String navBarOverride = getNavBarOverride();
            if ("1".equals(navBarOverride)) {
                return false;
            }
            if ("0".equals(navBarOverride)) {
                return true;
            }
            return z;
        }
        return ViewConfiguration.get(context).hasPermanentMenuKey() ? false : true;
    }

    private static String getNavBarOverride() {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES).getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable th) {
                if (DEBUG) {
                    Log.i("SwanAppUIUtils", th.toString());
                }
            }
        }
        return null;
    }
}
