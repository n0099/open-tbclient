package com.baidu.swan.apps.ap;

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
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.u.c.b;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
/* loaded from: classes10.dex */
public class ah {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final DisplayMetrics bTb = com.baidu.swan.apps.t.a.asf().getResources().getDisplayMetrics();
    private static final float bTc = bTb.density;
    private static DisplayMetrics sDisplayMetrics;

    public static Pair<Integer, Integer> tM(String str) {
        long j;
        Pair<Integer, Integer> avh;
        if (!DEBUG) {
            j = 0;
        } else {
            j = System.currentTimeMillis();
        }
        if (com.baidu.swan.apps.runtime.d.aCW().aCU() == null) {
            avh = ad.aIt();
        } else {
            avh = com.baidu.swan.apps.v.f.avu().avh();
        }
        int intValue = ((Integer) avh.first).intValue();
        int aj = aj(((Integer) avh.second).intValue(), str);
        if (DEBUG) {
            Log.d("SwanAppUIUtils", "preGuessWebViewSize cost - " + (System.currentTimeMillis() - j) + "ms");
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(aj));
    }

    private static int aj(int i, String str) {
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Context appContext = AppRuntime.getAppContext();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        try {
            i3 = getStatusBarHeight();
            i4 = appContext.getResources().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
            i5 = appContext.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
            i2 = appContext.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_shadow_height) + i5;
        } catch (Resources.NotFoundException e) {
            i2 = i5;
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        boolean z5 = false;
        boolean z6 = false;
        if (TextUtils.isEmpty(str)) {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
        } else {
            String sc = com.baidu.swan.apps.scheme.actions.k.j.sc(ai.delAllParamsFromUrl(str));
            SwanAppConfigData auZ = com.baidu.swan.apps.v.f.avu().auZ();
            b.a abu = com.baidu.swan.apps.runtime.e.aDa().abu();
            com.baidu.swan.apps.runtime.config.c a2 = com.baidu.swan.apps.v.f.avu().a(sc, auZ, d.C0438d.bG(abu.getAppId(), abu.getVersion()).getPath() + File.separator);
            if (com.baidu.swan.apps.runtime.config.c.a(a2)) {
                z5 = true;
                z6 = a(a2, appContext);
            }
            boolean tT = ak.tT(sc);
            boolean z7 = a2.dfT;
            z = z5;
            z2 = z7;
            z3 = tT;
            z4 = z6;
        }
        int i6 = z3 ? i - i2 : i;
        if (!z) {
            i6 -= i4;
        }
        if (!z4) {
            i6 -= i3;
        }
        if (z2) {
            i6 -= J(50.0f);
        }
        if (DEBUG) {
            int cJ = ac.cJ(appContext);
            int aIr = ad.aIr();
            StringBuilder sb = new StringBuilder();
            sb.append("screenHeight:").append(i).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("notchHeight:").append(cJ).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("navHeight:").append(aIr).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("preGuessWebViewHeight:").append(i6).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("pageUrl:").append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("hasTab:").append(z3).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("bottomBarHeight:").append(i2).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("isTransparentBar:").append(z).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("actionBarHeight:").append(i4).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("isOccupyStatusBar:").append(z4).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("statusBarHeight:").append(i3).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("canPullToRefresh:").append(z2);
            Log.d("SwanAppUIUtils", sb.toString());
        }
        return Math.max(i6, 0);
    }

    private static boolean a(@NonNull com.baidu.swan.apps.runtime.config.c cVar, Context context) {
        return com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION && (TextUtils.equals(cVar.dfW, "custom") || !ac.cH(context));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int cM(Context context) {
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
        int cN = cN(context);
        try {
            i = context.getResources().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        } catch (Resources.NotFoundException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            i = 0;
        }
        com.baidu.swan.apps.core.d.f abs = com.baidu.swan.apps.v.f.avu().abs();
        if (abs != null) {
            com.baidu.swan.apps.core.d.c akH = abs.akH();
            if (akH instanceof com.baidu.swan.apps.core.d.e) {
                eVar = (com.baidu.swan.apps.core.d.e) akH;
                if (eVar == null && com.baidu.swan.apps.runtime.config.c.a(eVar.ajW())) {
                    com.baidu.swan.apps.view.a.b ajX = eVar.ajX();
                    if (ajX == null || !ajX.aJi()) {
                        z = true;
                        z2 = false;
                    } else {
                        z = true;
                    }
                } else {
                    z2 = false;
                    z = false;
                }
                i2 = displayHeight - cN;
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
        i2 = displayHeight - cN;
        if (!z2) {
        }
        if (!z) {
        }
        if (i2 <= 0) {
        }
    }

    public static int cN(Context context) {
        com.baidu.swan.apps.core.d.c akH;
        int i;
        Resources.NotFoundException e;
        com.baidu.swan.apps.core.d.f abs = com.baidu.swan.apps.v.f.avu().abs();
        if (context == null || abs == null || (akH = abs.akH()) == null || !(akH instanceof com.baidu.swan.apps.core.d.e) || !((com.baidu.swan.apps.core.d.e) akH).ajw()) {
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
            new com.baidu.swan.apps.view.a.b(activity).a(-1, false, true, true);
        }
    }

    public static void T(Activity activity) {
        if (activity != null && com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION) {
            new com.baidu.swan.apps.view.a.b(activity).a(-1, true, false, true);
        }
    }

    @UiThread
    public static Bitmap aIu() {
        return u(1.0f, 1.0f);
    }

    @UiThread
    public static Bitmap u(float f, float f2) {
        com.baidu.swan.apps.v.f avu = com.baidu.swan.apps.v.f.avu();
        AbsoluteLayout pg = avu.pg(avu.akr());
        if (pg == null || pg.getWidth() <= 0 || pg.getHeight() <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) (pg.getWidth() * f), (int) (pg.getHeight() * f2), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(-1);
        pg.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    @UiThread
    public static Bitmap c(View view, int i, int i2) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static Bitmap aIv() {
        return U(com.baidu.swan.apps.v.f.avu().ave());
    }

    private static Bitmap U(Activity activity) {
        if (activity == null) {
            return null;
        }
        View findViewById = activity.findViewById(16908290);
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
        return null;
    }

    public static int getDisplayWidth(@Nullable Context context) {
        initDisplayMetrics(com.baidu.swan.apps.t.a.asf());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.widthPixels;
        }
        return 0;
    }

    public static int getDisplayHeight(Context context) {
        initDisplayMetrics(com.baidu.swan.apps.t.a.asf());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.heightPixels;
        }
        return 0;
    }

    public static int cO(Context context) {
        return !cP(context) ? V((Activity) context) ? getDisplayHeight(context) : getDisplayWidth(context) : isScreenLand() ? getDisplayHeight(context) : getDisplayWidth(context);
    }

    private static boolean V(Activity activity) {
        if (activity == null) {
            return false;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        return defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3;
    }

    public static boolean cP(Context context) {
        return Build.VERSION.SDK_INT >= 24 && (context instanceof Activity) && ((Activity) context).isInMultiWindowMode();
    }

    public static float getDensity(Context context) {
        initDisplayMetrics(com.baidu.swan.apps.t.a.asf());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.density;
        }
        return 0.0f;
    }

    public static int getDensityDpi(Context context) {
        initDisplayMetrics(com.baidu.swan.apps.t.a.asf());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.densityDpi;
        }
        return 0;
    }

    private static void initDisplayMetrics(Context context) {
        if (sDisplayMetrics == null) {
            Application asf = com.baidu.swan.apps.t.a.asf();
            if (asf != null) {
                context = asf;
            }
            if (context != null) {
                sDisplayMetrics = context.getResources().getDisplayMetrics();
            }
        }
    }

    public static int J(float f) {
        return dip2px(com.baidu.swan.apps.t.a.asf(), f);
    }

    public static float K(float f) {
        return getDensity(com.baidu.swan.apps.t.a.asf()) * f;
    }

    public static int L(float f) {
        return px2dip(com.baidu.swan.apps.t.a.asf(), f);
    }

    public static int dip2px(Context context, float f) {
        return (int) (getDensity(context) * f);
    }

    public static int px2dip(Context context, float f) {
        return (int) (f / getDensity(context));
    }

    public static float px2dpFloat(float f) {
        return f / getDensity(com.baidu.swan.apps.t.a.asf());
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
        int identifier = com.baidu.swan.apps.t.a.asf().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            try {
                i = com.baidu.swan.apps.t.a.asf().getResources().getDimensionPixelSize(identifier);
            } catch (Exception e) {
            }
        }
        if (i == 0) {
            return (int) (25.0f * bTc);
        }
        return i;
    }

    public static int getNavigationBarHeight() {
        boolean hasPermanentMenuKey = ViewConfiguration.get(com.baidu.swan.apps.t.a.asf()).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return 0;
        }
        Resources resources = com.baidu.swan.apps.t.a.asf().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static boolean isScreenPortrait() {
        return com.baidu.swan.apps.t.a.asf().getResources().getConfiguration().orientation == 1;
    }

    public static boolean isScreenLand() {
        return com.baidu.swan.apps.t.a.asf().getResources().getConfiguration().orientation == 2;
    }

    public static int getInternalDimensionSize(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public static int getActionBarHeight() {
        return com.baidu.swan.apps.t.a.asf().getResources().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
    }
}
