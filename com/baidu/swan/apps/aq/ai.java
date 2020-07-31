package com.baidu.swan.apps.aq;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsoluteLayout;
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.u.c.b;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
/* loaded from: classes7.dex */
public class ai {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final DisplayMetrics bEO = com.baidu.swan.apps.t.a.ahj().getResources().getDisplayMetrics();
    private static final float bEP = bEO.density;
    private static DisplayMetrics sDisplayMetrics;

    public static Pair<Integer, Integer> qF(String str) {
        long j;
        Pair<Integer, Integer> ake;
        if (!DEBUG) {
            j = 0;
        } else {
            j = System.currentTimeMillis();
        }
        if (com.baidu.swan.apps.runtime.d.arr().arp() == null) {
            ake = ac.awR();
        } else {
            ake = com.baidu.swan.apps.v.f.akr().ake();
        }
        int intValue = ((Integer) ake.first).intValue();
        int Y = Y(((Integer) ake.second).intValue(), str);
        if (DEBUG) {
            Log.d("SwanAppUIUtils", "preGuessWebViewSize cost - " + (System.currentTimeMillis() - j) + "ms");
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(Y));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0184  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int Y(int i, String str) {
        Resources.NotFoundException notFoundException;
        int i2;
        int i3;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Context appContext = AppRuntime.getAppContext();
        try {
            i3 = getStatusBarHeight();
            try {
                i2 = appContext.getResources().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
                try {
                    int dimensionPixelSize = appContext.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                    try {
                        i4 = appContext.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_shadow_height) + dimensionPixelSize;
                    } catch (Resources.NotFoundException e) {
                        i4 = dimensionPixelSize;
                        notFoundException = e;
                        if (DEBUG) {
                            notFoundException.printStackTrace();
                        }
                        if (TextUtils.isEmpty(str)) {
                        }
                        if (!z) {
                        }
                        if (!z3) {
                        }
                        if (!z2) {
                        }
                        if (DEBUG) {
                        }
                        return Math.max(r3, 0);
                    }
                } catch (Resources.NotFoundException e2) {
                    notFoundException = e2;
                    i4 = 0;
                }
            } catch (Resources.NotFoundException e3) {
                notFoundException = e3;
                i2 = 0;
                i4 = 0;
            }
        } catch (Resources.NotFoundException e4) {
            notFoundException = e4;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        if (TextUtils.isEmpty(str)) {
            String oZ = com.baidu.swan.apps.scheme.actions.k.j.oZ(aj.delAllParamsFromUrl(str));
            SwanAppConfigData ajW = com.baidu.swan.apps.v.f.akr().ajW();
            b.a Se = com.baidu.swan.apps.runtime.e.arv().Se();
            com.baidu.swan.apps.runtime.config.c a = com.baidu.swan.apps.v.f.akr().a(oZ, ajW, d.C0380d.bq(Se.getAppId(), Se.getVersion()).getPath() + File.separator);
            if (com.baidu.swan.apps.runtime.config.c.a(a)) {
                z5 = true;
                z4 = a(a, appContext);
            } else {
                z4 = false;
                z5 = false;
            }
            z3 = z5;
            z = al.qL(oZ);
            z2 = z4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        int i5 = !z ? i - i4 : i;
        if (!z3) {
            i5 -= i2;
        }
        if (!z2) {
            i5 -= i3;
        }
        if (DEBUG) {
            int cx = ab.cx(appContext);
            int awP = ac.awP();
            StringBuilder sb = new StringBuilder();
            sb.append("screenHeight:").append(i).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("notchHeight:").append(cx).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("navHeight:").append(awP).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("preGuessWebViewHeight:").append(i5).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("pageUrl:").append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("hasTab:").append(z).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("bottomBarHeight:").append(i4).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("isTransparentBar:").append(z3).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("actionBarHeight:").append(i2).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("isOccupyStatusBar:").append(z2).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("statusBarHeight:").append(i3);
            Log.d("SwanAppUIUtils", sb.toString());
        }
        return Math.max(i5, 0);
    }

    private static boolean a(@NonNull com.baidu.swan.apps.runtime.config.c cVar, Context context) {
        return com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION && (TextUtils.equals(cVar.cIL, "custom") || !ab.cv(context));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int cA(Context context) {
        int i;
        com.baidu.swan.apps.core.d.e eVar;
        boolean z;
        int i2;
        boolean z2 = true;
        if (context == null) {
            return 0;
        }
        int displayHeight = getDisplayHeight(context);
        int statusBarHeight = getStatusBarHeight();
        int cB = cB(context);
        try {
            i = context.getResources().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        } catch (Resources.NotFoundException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            i = 0;
        }
        com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc != null) {
            com.baidu.swan.apps.core.d.c aaZ = Sc.aaZ();
            if (aaZ instanceof com.baidu.swan.apps.core.d.e) {
                eVar = (com.baidu.swan.apps.core.d.e) aaZ;
                if (eVar == null && com.baidu.swan.apps.runtime.config.c.a(eVar.aar())) {
                    com.baidu.swan.apps.view.a.b aas = eVar.aas();
                    if (aas == null || !aas.axH()) {
                        z = true;
                        z2 = false;
                    } else {
                        z = true;
                    }
                } else {
                    z2 = false;
                    z = false;
                }
                i2 = displayHeight - cB;
                if (!z2) {
                    i2 -= statusBarHeight;
                }
                if (!z) {
                    i2 -= i;
                }
                if (i2 <= 0) {
                    return i2;
                }
                return 0;
            }
        }
        eVar = null;
        if (eVar == null) {
        }
        z2 = false;
        z = false;
        i2 = displayHeight - cB;
        if (!z2) {
        }
        if (!z) {
        }
        if (i2 <= 0) {
        }
    }

    public static int cB(Context context) {
        com.baidu.swan.apps.core.d.c aaZ;
        int i;
        Resources.NotFoundException e;
        com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (context == null || Sc == null || (aaZ = Sc.aaZ()) == null || !(aaZ instanceof com.baidu.swan.apps.core.d.e) || !((com.baidu.swan.apps.core.d.e) aaZ).ZR()) {
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

    public static void R(Activity activity) {
        if (activity != null && com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION) {
            new com.baidu.swan.apps.view.a.b(activity).a(-1, false, true, true);
        }
    }

    public static void S(Activity activity) {
        if (activity != null && com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION) {
            new com.baidu.swan.apps.view.a.b(activity).a(-1, true, false, true);
        }
    }

    @UiThread
    public static Bitmap awS() {
        return p(1.0f, 1.0f);
    }

    @UiThread
    public static Bitmap p(float f, float f2) {
        com.baidu.swan.apps.v.f akr = com.baidu.swan.apps.v.f.akr();
        AbsoluteLayout mb = akr.mb(akr.aaL());
        if (mb == null || mb.getWidth() <= 0 || mb.getHeight() <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) (mb.getWidth() * f), (int) (mb.getHeight() * f2), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(-1);
        mb.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    @UiThread
    public static Bitmap d(View view, int i, int i2) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static Bitmap awT() {
        SwanAppActivity akb = com.baidu.swan.apps.v.f.akr().akb();
        if (akb != null) {
            View findViewById = akb.findViewById(16908290);
            Bitmap bitmap = null;
            for (int i = 1; i < 3; i++) {
                try {
                    findViewById.setDrawingCacheEnabled(true);
                    Bitmap drawingCache = findViewById.getDrawingCache();
                    if (drawingCache != null) {
                        bitmap = Bitmap.createScaledBitmap(drawingCache, drawingCache.getWidth() / i, drawingCache.getHeight() / i, false);
                    }
                    findViewById.setDrawingCacheEnabled(false);
                } catch (NullPointerException | OutOfMemoryError e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (bitmap != null) {
                    return bitmap;
                }
            }
        }
        return null;
    }

    public static int getDisplayWidth(@Nullable Context context) {
        initDisplayMetrics(com.baidu.swan.apps.t.a.ahj());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.widthPixels;
        }
        return 0;
    }

    public static int getDisplayHeight(Context context) {
        initDisplayMetrics(com.baidu.swan.apps.t.a.ahj());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.heightPixels;
        }
        return 0;
    }

    public static int cC(Context context) {
        return !cD(context) ? T((Activity) context) ? getDisplayHeight(context) : getDisplayWidth(context) : isScreenLand() ? getDisplayHeight(context) : getDisplayWidth(context);
    }

    private static boolean T(Activity activity) {
        if (activity == null) {
            return false;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        return defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3;
    }

    public static boolean cD(Context context) {
        return Build.VERSION.SDK_INT >= 24 && (context instanceof Activity) && ((Activity) context).isInMultiWindowMode();
    }

    public static float getDensity(Context context) {
        initDisplayMetrics(com.baidu.swan.apps.t.a.ahj());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.density;
        }
        return 0.0f;
    }

    public static int getDensityDpi(Context context) {
        initDisplayMetrics(com.baidu.swan.apps.t.a.ahj());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.densityDpi;
        }
        return 0;
    }

    private static void initDisplayMetrics(Context context) {
        if (sDisplayMetrics == null) {
            Application ahj = com.baidu.swan.apps.t.a.ahj();
            if (ahj != null) {
                context = ahj;
            }
            if (context != null) {
                sDisplayMetrics = context.getResources().getDisplayMetrics();
            }
        }
    }

    public static int D(float f) {
        return dip2px(com.baidu.swan.apps.t.a.ahj(), f);
    }

    public static float E(float f) {
        return getDensity(com.baidu.swan.apps.t.a.ahj()) * f;
    }

    public static int F(float f) {
        return px2dip(com.baidu.swan.apps.t.a.ahj(), f);
    }

    public static int dip2px(Context context, float f) {
        return (int) (getDensity(context) * f);
    }

    public static int px2dip(Context context, float f) {
        return (int) (f / getDensity(context));
    }

    public static float px2dpFloat(float f) {
        return f / getDensity(com.baidu.swan.apps.t.a.ahj());
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
        int identifier = com.baidu.swan.apps.t.a.ahj().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            try {
                i = com.baidu.swan.apps.t.a.ahj().getResources().getDimensionPixelSize(identifier);
            } catch (Exception e) {
            }
        }
        if (i == 0) {
            return (int) (25.0f * bEP);
        }
        return i;
    }

    public static int getNavigationBarHeight() {
        boolean hasPermanentMenuKey = ViewConfiguration.get(com.baidu.swan.apps.t.a.ahj()).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return 0;
        }
        Resources resources = com.baidu.swan.apps.t.a.ahj().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static boolean isScreenPortrait() {
        return com.baidu.swan.apps.t.a.ahj().getResources().getConfiguration().orientation == 1;
    }

    public static boolean isScreenLand() {
        return com.baidu.swan.apps.t.a.ahj().getResources().getConfiguration().orientation == 2;
    }

    public static int getInternalDimensionSize(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public static int getActionBarHeight() {
        return com.baidu.swan.apps.t.a.ahj().getResources().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
    }
}
