package com.baidu.swan.apps.ao;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.u.c.b;
import java.io.File;
/* loaded from: classes9.dex */
public class ah {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final DisplayMetrics ctj = com.baidu.swan.apps.t.a.aAs().getResources().getDisplayMetrics();
    private static final float ctk = ctj.density;
    private static DisplayMetrics sDisplayMetrics;

    public static Pair<Integer, Integer> uU(String str) {
        long j;
        Pair<Integer, Integer> aDu;
        if (!DEBUG) {
            j = 0;
        } else {
            j = System.currentTimeMillis();
        }
        if (com.baidu.swan.apps.runtime.d.aMh().aMf() == null) {
            aDu = ad.aRE();
        } else {
            aDu = com.baidu.swan.apps.v.f.aDH().aDu();
        }
        int intValue = ((Integer) aDu.first).intValue();
        int ar = ar(((Integer) aDu.second).intValue(), str);
        if (DEBUG) {
            Log.d("SwanAppUIUtils", "preGuessWebViewSize cost - " + (System.currentTimeMillis() - j) + "ms");
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(ar));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0198  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int ar(int i, String str) {
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
            i4 = getStatusBarHeight();
            try {
                i3 = appContext.getResources().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
                try {
                    i2 = appContext.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                } catch (Resources.NotFoundException e) {
                    e = e;
                    i2 = 0;
                }
            } catch (Resources.NotFoundException e2) {
                e = e2;
                i2 = 0;
                i3 = 0;
            }
        } catch (Resources.NotFoundException e3) {
            e = e3;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        try {
            i2 += appContext.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_shadow_height);
        } catch (Resources.NotFoundException e4) {
            e = e4;
            if (DEBUG) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(str)) {
            }
            if (!z2) {
            }
            if (!z4) {
            }
            if (!z3) {
            }
            if (z) {
            }
            if (DEBUG) {
            }
            return Math.max(r3, 0);
        }
        if (TextUtils.isEmpty(str)) {
            String tj = com.baidu.swan.apps.scheme.actions.k.j.tj(ai.delAllParamsFromUrl(str));
            SwanAppConfigData aDm = com.baidu.swan.apps.v.f.aDH().aDm();
            b.a ajv = com.baidu.swan.apps.runtime.e.aMl().ajv();
            com.baidu.swan.apps.runtime.config.c a2 = com.baidu.swan.apps.v.f.aDH().a(tj, aDm, d.C0466d.bS(ajv.getAppId(), ajv.getVersion()).getPath() + File.separator);
            if (com.baidu.swan.apps.runtime.config.c.a(a2)) {
                z4 = true;
                z5 = a(a2, appContext);
            } else {
                z5 = false;
                z4 = false;
            }
            z2 = ak.vb(tj);
            z = a2.dIn;
            z3 = z5;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
        }
        int i5 = !z2 ? i - i2 : i;
        if (!z4) {
            i5 -= i3;
        }
        if (!z3) {
            i5 -= i4;
        }
        if (z) {
            i5 -= O(50.0f);
        }
        if (DEBUG) {
            int dI = ac.dI(appContext);
            int aRC = ad.aRC();
            StringBuilder sb = new StringBuilder();
            sb.append("screenHeight:").append(i).append(",");
            sb.append("notchHeight:").append(dI).append(",");
            sb.append("navHeight:").append(aRC).append(",");
            sb.append("preGuessWebViewHeight:").append(i5).append(",");
            sb.append("pageUrl:").append(str).append(",");
            sb.append("hasTab:").append(z2).append(",");
            sb.append("bottomBarHeight:").append(i2).append(",");
            sb.append("isTransparentBar:").append(z4).append(",");
            sb.append("actionBarHeight:").append(i3).append(",");
            sb.append("isOccupyStatusBar:").append(z3).append(",");
            sb.append("statusBarHeight:").append(i4).append(",");
            sb.append("canPullToRefresh:").append(z);
            Log.d("SwanAppUIUtils", sb.toString());
        }
        return Math.max(i5, 0);
    }

    private static boolean a(@NonNull com.baidu.swan.apps.runtime.config.c cVar, Context context) {
        return com.baidu.swan.apps.view.a.b.dDB && (TextUtils.equals(cVar.dIq, "custom") || !ac.dD(context));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int dL(Context context) {
        int i;
        com.baidu.swan.apps.core.d.e eVar;
        boolean z;
        boolean z2;
        int i2;
        if (context == null) {
            return 0;
        }
        int displayHeight = getDisplayHeight(context);
        int statusBarHeight = getStatusBarHeight();
        int dM = dM(context);
        try {
            i = context.getResources().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        } catch (Resources.NotFoundException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            i = 0;
        }
        com.baidu.swan.apps.core.d.f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
        if (ajt != null) {
            com.baidu.swan.apps.core.d.c asU = ajt.asU();
            if (asU instanceof com.baidu.swan.apps.core.d.e) {
                eVar = (com.baidu.swan.apps.core.d.e) asU;
                if (eVar == null && com.baidu.swan.apps.runtime.config.c.a(eVar.asg())) {
                    com.baidu.swan.apps.view.a.b asj = eVar.asj();
                    if (asj == null || !asj.aSu()) {
                        z = false;
                        z2 = true;
                    } else {
                        z = true;
                        z2 = true;
                    }
                } else {
                    z = false;
                    z2 = false;
                }
                i2 = displayHeight - dM;
                if (!z) {
                    i2 -= statusBarHeight;
                }
                if (!z2) {
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
        z = false;
        z2 = false;
        i2 = displayHeight - dM;
        if (!z) {
        }
        if (!z2) {
        }
        if (i2 <= 0) {
        }
    }

    public static int dM(Context context) {
        com.baidu.swan.apps.core.d.c asU;
        int i;
        com.baidu.swan.apps.core.d.f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
        if (context == null || ajt == null || (asU = ajt.asU()) == null || !(asU instanceof com.baidu.swan.apps.core.d.e) || !((com.baidu.swan.apps.core.d.e) asU).arD()) {
            return 0;
        }
        try {
            i = context.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
        } catch (Resources.NotFoundException e) {
            e = e;
            i = 0;
        }
        try {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_shadow_height);
            if (dimensionPixelSize > 0) {
                return i + dimensionPixelSize;
            }
            return i;
        } catch (Resources.NotFoundException e2) {
            e = e2;
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

    public static void T(Activity activity) {
        if (activity != null && com.baidu.swan.apps.view.a.b.dDB) {
            new com.baidu.swan.apps.view.a.b(activity).a(-1, false, true, true);
        }
    }

    public static void U(Activity activity) {
        if (activity != null && com.baidu.swan.apps.view.a.b.dDB) {
            new com.baidu.swan.apps.view.a.b(activity).a(-1, true, false, true);
        }
    }

    @UiThread
    public static Bitmap aRF() {
        return u(1.0f, 1.0f);
    }

    @UiThread
    public static Bitmap u(float f, float f2) {
        com.baidu.swan.apps.v.f aDH = com.baidu.swan.apps.v.f.aDH();
        AbsoluteLayout qh = aDH.qh(aDH.asE());
        if (qh == null || qh.getWidth() <= 0 || qh.getHeight() <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) (qh.getWidth() * f), (int) (qh.getHeight() * f2), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(-1);
        qh.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    @UiThread
    public static Bitmap g(View view, int i, int i2) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static Bitmap aRG() {
        return V(com.baidu.swan.apps.v.f.aDH().aDr());
    }

    private static Bitmap V(Activity activity) {
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
        initDisplayMetrics(com.baidu.swan.apps.t.a.aAs());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.widthPixels;
        }
        return 0;
    }

    public static int getDisplayHeight(Context context) {
        initDisplayMetrics(com.baidu.swan.apps.t.a.aAs());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.heightPixels;
        }
        return 0;
    }

    public static int dN(Context context) {
        return !dO(context) ? W((Activity) context) ? getDisplayHeight(context) : getDisplayWidth(context) : isScreenLand() ? getDisplayHeight(context) : getDisplayWidth(context);
    }

    private static boolean W(Activity activity) {
        if (activity == null) {
            return false;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        return defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3;
    }

    public static boolean dO(Context context) {
        return Build.VERSION.SDK_INT >= 24 && (context instanceof Activity) && ((Activity) context).isInMultiWindowMode();
    }

    public static float getDensity(Context context) {
        initDisplayMetrics(com.baidu.swan.apps.t.a.aAs());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.density;
        }
        return 0.0f;
    }

    public static int getDensityDpi(Context context) {
        initDisplayMetrics(com.baidu.swan.apps.t.a.aAs());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.densityDpi;
        }
        return 0;
    }

    private static void initDisplayMetrics(Context context) {
        if (sDisplayMetrics == null) {
            Application aAs = com.baidu.swan.apps.t.a.aAs();
            if (aAs != null) {
                context = aAs;
            }
            if (context != null) {
                sDisplayMetrics = context.getResources().getDisplayMetrics();
            }
        }
    }

    public static int O(float f) {
        return dip2px(com.baidu.swan.apps.t.a.aAs(), f);
    }

    public static float P(float f) {
        return getDensity(com.baidu.swan.apps.t.a.aAs()) * f;
    }

    public static int Q(float f) {
        return px2dip(com.baidu.swan.apps.t.a.aAs(), f);
    }

    public static int dip2px(Context context, float f) {
        return (int) (getDensity(context) * f);
    }

    public static int px2dip(Context context, float f) {
        return (int) (f / getDensity(context));
    }

    public static float px2dpFloat(float f) {
        return f / getDensity(com.baidu.swan.apps.t.a.aAs());
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
        int identifier = com.baidu.swan.apps.t.a.aAs().getResources().getIdentifier("status_bar_height", "dimen", HttpConstants.OS_TYPE_VALUE);
        if (identifier > 0) {
            try {
                i = com.baidu.swan.apps.t.a.aAs().getResources().getDimensionPixelSize(identifier);
            } catch (Exception e) {
            }
        }
        if (i == 0) {
            return (int) (25.0f * ctk);
        }
        return i;
    }

    public static int getNavigationBarHeight() {
        boolean hasPermanentMenuKey = ViewConfiguration.get(com.baidu.swan.apps.t.a.aAs()).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return 0;
        }
        Resources resources = com.baidu.swan.apps.t.a.aAs().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", HttpConstants.OS_TYPE_VALUE));
    }

    public static boolean isScreenPortrait() {
        return com.baidu.swan.apps.t.a.aAs().getResources().getConfiguration().orientation == 1;
    }

    public static boolean isScreenLand() {
        return com.baidu.swan.apps.t.a.aAs().getResources().getConfiguration().orientation == 2;
    }

    public static int b(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", HttpConstants.OS_TYPE_VALUE);
        if (identifier <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public static int getActionBarHeight() {
        return com.baidu.swan.apps.t.a.aAs().getResources().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
    }
}
