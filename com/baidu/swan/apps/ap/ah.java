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
/* loaded from: classes7.dex */
public class ah {
    private static DisplayMetrics sDisplayMetrics;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final DisplayMetrics cfz = com.baidu.swan.apps.t.a.avS().getResources().getDisplayMetrics();
    private static final float cfA = cfz.density;

    public static Pair<Integer, Integer> uo(String str) {
        long j;
        Pair<Integer, Integer> ayT;
        if (!DEBUG) {
            j = 0;
        } else {
            j = System.currentTimeMillis();
        }
        if (com.baidu.swan.apps.runtime.d.aGI().aGG() == null) {
            ayT = ad.aMf();
        } else {
            ayT = com.baidu.swan.apps.v.f.azg().ayT();
        }
        int intValue = ((Integer) ayT.first).intValue();
        int ap = ap(((Integer) ayT.second).intValue(), str);
        if (DEBUG) {
            Log.d("SwanAppUIUtils", "preGuessWebViewSize cost - " + (System.currentTimeMillis() - j) + "ms");
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(ap));
    }

    private static int ap(int i, String str) {
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
            String sF = com.baidu.swan.apps.scheme.actions.k.j.sF(ai.delAllParamsFromUrl(str));
            SwanAppConfigData ayL = com.baidu.swan.apps.v.f.azg().ayL();
            b.a afg = com.baidu.swan.apps.runtime.e.aGM().afg();
            com.baidu.swan.apps.runtime.config.c a2 = com.baidu.swan.apps.v.f.azg().a(sF, ayL, d.C0462d.bM(afg.getAppId(), afg.getVersion()).getPath() + File.separator);
            if (com.baidu.swan.apps.runtime.config.c.a(a2)) {
                z5 = true;
                z6 = a(a2, appContext);
            }
            boolean uv = ak.uv(sF);
            boolean z7 = a2.dsI;
            z = z5;
            z2 = z7;
            z3 = uv;
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
            i6 -= M(50.0f);
        }
        if (DEBUG) {
            int cJ = ac.cJ(appContext);
            int aMd = ad.aMd();
            StringBuilder sb = new StringBuilder();
            sb.append("screenHeight:").append(i).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("notchHeight:").append(cJ).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("navHeight:").append(aMd).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
        return com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION && (TextUtils.equals(cVar.dsL, "custom") || !ac.cH(context));
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
        com.baidu.swan.apps.core.d.f afe = com.baidu.swan.apps.v.f.azg().afe();
        if (afe != null) {
            com.baidu.swan.apps.core.d.c aot = afe.aot();
            if (aot instanceof com.baidu.swan.apps.core.d.e) {
                eVar = (com.baidu.swan.apps.core.d.e) aot;
                if (eVar == null && com.baidu.swan.apps.runtime.config.c.a(eVar.anI())) {
                    com.baidu.swan.apps.view.a.b anJ = eVar.anJ();
                    if (anJ == null || !anJ.aMU()) {
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
        com.baidu.swan.apps.core.d.c aot;
        int i;
        Resources.NotFoundException e;
        com.baidu.swan.apps.core.d.f afe = com.baidu.swan.apps.v.f.azg().afe();
        if (context == null || afe == null || (aot = afe.aot()) == null || !(aot instanceof com.baidu.swan.apps.core.d.e) || !((com.baidu.swan.apps.core.d.e) aot).ani()) {
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
    public static Bitmap aMg() {
        return u(1.0f, 1.0f);
    }

    @UiThread
    public static Bitmap u(float f, float f2) {
        com.baidu.swan.apps.v.f azg = com.baidu.swan.apps.v.f.azg();
        AbsoluteLayout pH = azg.pH(azg.aod());
        if (pH == null || pH.getWidth() <= 0 || pH.getHeight() <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) (pH.getWidth() * f), (int) (pH.getHeight() * f2), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(-1);
        pH.draw(new Canvas(createBitmap));
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

    public static Bitmap aMh() {
        return T(com.baidu.swan.apps.v.f.azg().ayQ());
    }

    private static Bitmap T(Activity activity) {
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
        initDisplayMetrics(com.baidu.swan.apps.t.a.avS());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.widthPixels;
        }
        return 0;
    }

    public static int getDisplayHeight(Context context) {
        initDisplayMetrics(com.baidu.swan.apps.t.a.avS());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.heightPixels;
        }
        return 0;
    }

    public static int cO(Context context) {
        return !cP(context) ? U((Activity) context) ? getDisplayHeight(context) : getDisplayWidth(context) : isScreenLand() ? getDisplayHeight(context) : getDisplayWidth(context);
    }

    private static boolean U(Activity activity) {
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
        initDisplayMetrics(com.baidu.swan.apps.t.a.avS());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.density;
        }
        return 0.0f;
    }

    public static int getDensityDpi(Context context) {
        initDisplayMetrics(com.baidu.swan.apps.t.a.avS());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.densityDpi;
        }
        return 0;
    }

    private static void initDisplayMetrics(Context context) {
        if (sDisplayMetrics == null) {
            Application avS = com.baidu.swan.apps.t.a.avS();
            if (avS != null) {
                context = avS;
            }
            if (context != null) {
                sDisplayMetrics = context.getResources().getDisplayMetrics();
            }
        }
    }

    public static int M(float f) {
        return dip2px(com.baidu.swan.apps.t.a.avS(), f);
    }

    public static float N(float f) {
        return getDensity(com.baidu.swan.apps.t.a.avS()) * f;
    }

    public static int O(float f) {
        return px2dip(com.baidu.swan.apps.t.a.avS(), f);
    }

    public static int dip2px(Context context, float f) {
        return (int) (getDensity(context) * f);
    }

    public static int px2dip(Context context, float f) {
        return (int) (f / getDensity(context));
    }

    public static float px2dpFloat(float f) {
        return f / getDensity(com.baidu.swan.apps.t.a.avS());
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
        int identifier = com.baidu.swan.apps.t.a.avS().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            try {
                i = com.baidu.swan.apps.t.a.avS().getResources().getDimensionPixelSize(identifier);
            } catch (Exception e) {
            }
        }
        if (i == 0) {
            return (int) (25.0f * cfA);
        }
        return i;
    }

    public static int getNavigationBarHeight() {
        boolean hasPermanentMenuKey = ViewConfiguration.get(com.baidu.swan.apps.t.a.avS()).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return 0;
        }
        Resources resources = com.baidu.swan.apps.t.a.avS().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static boolean isScreenPortrait() {
        return com.baidu.swan.apps.t.a.avS().getResources().getConfiguration().orientation == 1;
    }

    public static boolean isScreenLand() {
        return com.baidu.swan.apps.t.a.avS().getResources().getConfiguration().orientation == 2;
    }

    public static int getInternalDimensionSize(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public static int getActionBarHeight() {
        return com.baidu.swan.apps.t.a.avS().getResources().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
    }
}
