package com.baidu.swan.apps.as;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsoluteLayout;
import android.widget.TextView;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
/* loaded from: classes11.dex */
public class af {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final DisplayMetrics brW = com.baidu.swan.apps.w.a.abO().getResources().getDisplayMetrics();
    private static final float brX = brW.density;
    private static DisplayMetrics sDisplayMetrics;

    public static int cv(Context context) {
        int i;
        boolean z;
        com.baidu.swan.apps.core.d.d dVar;
        boolean z2 = true;
        if (context == null) {
            return 0;
        }
        int displayHeight = getDisplayHeight(context);
        int statusBarHeight = getStatusBarHeight();
        int cw = cw(context);
        try {
            i = context.getResources().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        } catch (Resources.NotFoundException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            i = 0;
        }
        com.baidu.swan.apps.core.d.e Ou = com.baidu.swan.apps.y.f.aeK().Ou();
        com.baidu.swan.apps.core.d.d dVar2 = null;
        if (Ou != null) {
            com.baidu.swan.apps.core.d.b We = Ou.We();
            if (!(We instanceof com.baidu.swan.apps.core.d.d)) {
                dVar = null;
            } else {
                dVar = (com.baidu.swan.apps.core.d.d) We;
            }
            if (We != null && We.Vu()) {
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
        if (dVar2 == null || !com.baidu.swan.apps.runtime.config.c.a(dVar2.VA())) {
            z = false;
            z2 = false;
        } else {
            com.baidu.swan.apps.view.a.b VV = dVar2.VV();
            z = VV != null && VV.apH();
        }
        int i2 = displayHeight - cw;
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

    public static int cw(Context context) {
        com.baidu.swan.apps.core.d.b We;
        int i;
        Resources.NotFoundException e;
        com.baidu.swan.apps.core.d.e Ou = com.baidu.swan.apps.y.f.aeK().Ou();
        if (context == null || Ou == null || (We = Ou.We()) == null || !(We instanceof com.baidu.swan.apps.core.d.d) || !((com.baidu.swan.apps.core.d.d) We).Vm()) {
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

    public static void S(Activity activity) {
        if (activity != null && com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION) {
            new com.baidu.swan.apps.view.a.b(activity).c(-1, false, true);
        }
    }

    public static void T(Activity activity) {
        if (activity != null && com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION) {
            new com.baidu.swan.apps.view.a.b(activity).c(-1, true, false);
        }
    }

    @UiThread
    public static Bitmap apg() {
        return p(1.0f, 1.0f);
    }

    @UiThread
    public static Bitmap p(float f, float f2) {
        com.baidu.swan.apps.y.f aeK = com.baidu.swan.apps.y.f.aeK();
        AbsoluteLayout kf = aeK.kf(aeK.VQ());
        if (kf == null || kf.getWidth() <= 0 || kf.getHeight() <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) (kf.getWidth() * f), (int) (kf.getHeight() * f2), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(-1);
        kf.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static Bitmap aph() {
        SwanAppActivity aev = com.baidu.swan.apps.y.f.aeK().aev();
        if (aev != null) {
            View findViewById = aev.findViewById(16908290);
            try {
                findViewById.setDrawingCacheEnabled(true);
                Bitmap createBitmap = Bitmap.createBitmap(findViewById.getDrawingCache());
                findViewById.setDrawingCacheEnabled(false);
                return createBitmap;
            } catch (NullPointerException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static int getDisplayWidth(@Nullable Context context) {
        initDisplayMetrics(com.baidu.swan.apps.w.a.abO());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.widthPixels;
        }
        return 0;
    }

    public static int getDisplayHeight(Context context) {
        initDisplayMetrics(com.baidu.swan.apps.w.a.abO());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.heightPixels;
        }
        return 0;
    }

    public static int cx(Context context) {
        return !cy(context) ? U((Activity) context) ? getDisplayHeight(context) : getDisplayWidth(context) : isScreenLand() ? getDisplayHeight(context) : getDisplayWidth(context);
    }

    private static boolean U(Activity activity) {
        if (activity == null) {
            return false;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        return defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3;
    }

    public static boolean cy(Context context) {
        return Build.VERSION.SDK_INT >= 24 && (context instanceof Activity) && ((Activity) context).isInMultiWindowMode();
    }

    public static float getDensity(Context context) {
        initDisplayMetrics(com.baidu.swan.apps.w.a.abO());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.density;
        }
        return 0.0f;
    }

    public static int getDensityDpi(Context context) {
        initDisplayMetrics(com.baidu.swan.apps.w.a.abO());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.densityDpi;
        }
        return 0;
    }

    private static void initDisplayMetrics(Context context) {
        if (sDisplayMetrics == null) {
            Application abO = com.baidu.swan.apps.w.a.abO();
            if (abO != null) {
                context = abO;
            }
            if (context != null) {
                sDisplayMetrics = context.getResources().getDisplayMetrics();
            }
        }
    }

    public static int C(float f) {
        return dip2px(com.baidu.swan.apps.w.a.abO(), f);
    }

    public static float D(float f) {
        return getDensity(com.baidu.swan.apps.w.a.abO()) * f;
    }

    public static int E(float f) {
        return px2dip(com.baidu.swan.apps.w.a.abO(), f);
    }

    public static int dip2px(Context context, float f) {
        return (int) (getDensity(context) * f);
    }

    public static int px2dip(Context context, float f) {
        return (int) (f / getDensity(context));
    }

    public static float px2dpFloat(float f) {
        return f / getDensity(com.baidu.swan.apps.w.a.abO());
    }

    public static int getTextViewHeight(TextView textView) {
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

    public static int getTextViewWidth(TextView textView) {
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
        int identifier = com.baidu.swan.apps.w.a.abO().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            try {
                i = com.baidu.swan.apps.w.a.abO().getResources().getDimensionPixelSize(identifier);
            } catch (Exception e) {
            }
        }
        if (i == 0) {
            return (int) (25.0f * brX);
        }
        return i;
    }

    public static int getNavigationBarHeight() {
        boolean hasPermanentMenuKey = ViewConfiguration.get(com.baidu.swan.apps.w.a.abO()).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return 0;
        }
        Resources resources = com.baidu.swan.apps.w.a.abO().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static boolean isScreenLand() {
        return com.baidu.swan.apps.w.a.abO().getResources().getConfiguration().orientation == 2;
    }

    public static int getActionBarHeight() {
        return com.baidu.swan.apps.w.a.abO().getResources().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
    }
}
