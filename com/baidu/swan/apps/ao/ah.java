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
    private static final DisplayMetrics dPg = com.baidu.swan.apps.t.a.awW().getResources().getDisplayMetrics();
    private static final float dPh = dPg.density;
    private static DisplayMetrics sDisplayMetrics;

    public static Pair<Integer, Integer> uc(String str) {
        long j;
        Pair<Integer, Integer> azY;
        if (!DEBUG) {
            j = 0;
        } else {
            j = System.currentTimeMillis();
        }
        if (com.baidu.swan.apps.runtime.d.aIG().aIE() == null) {
            azY = ad.aOd();
        } else {
            azY = com.baidu.swan.apps.v.f.aAl().azY();
        }
        int intValue = ((Integer) azY.first).intValue();
        int aw = aw(((Integer) azY.second).intValue(), str);
        if (DEBUG) {
            Log.d("SwanAppUIUtils", "preGuessWebViewSize cost - " + (System.currentTimeMillis() - j) + "ms");
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(aw));
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
    private static int aw(int i, String str) {
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
            String sq = com.baidu.swan.apps.scheme.actions.k.j.sq(ai.delAllParamsFromUrl(str));
            SwanAppConfigData azQ = com.baidu.swan.apps.v.f.aAl().azQ();
            b.a afZ = com.baidu.swan.apps.runtime.e.aIK().afZ();
            com.baidu.swan.apps.runtime.config.c a2 = com.baidu.swan.apps.v.f.aAl().a(sq, azQ, d.C0446d.bL(afZ.getAppId(), afZ.getVersion()).getPath() + File.separator);
            if (com.baidu.swan.apps.runtime.config.c.a(a2)) {
                z4 = true;
                z5 = a(a2, appContext);
            } else {
                z5 = false;
                z4 = false;
            }
            z2 = ak.uj(sq);
            z = a2.dFF;
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
            i5 -= P(50.0f);
        }
        if (DEBUG) {
            int dG = ac.dG(appContext);
            int aOb = ad.aOb();
            StringBuilder sb = new StringBuilder();
            sb.append("screenHeight:").append(i).append(",");
            sb.append("notchHeight:").append(dG).append(",");
            sb.append("navHeight:").append(aOb).append(",");
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
        return com.baidu.swan.apps.view.a.b.dAU && (TextUtils.equals(cVar.dFI, "custom") || !ac.dB(context));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int dJ(Context context) {
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
        int dK = dK(context);
        try {
            i = context.getResources().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        } catch (Resources.NotFoundException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            i = 0;
        }
        com.baidu.swan.apps.core.d.f afX = com.baidu.swan.apps.v.f.aAl().afX();
        if (afX != null) {
            com.baidu.swan.apps.core.d.c apx = afX.apx();
            if (apx instanceof com.baidu.swan.apps.core.d.e) {
                eVar = (com.baidu.swan.apps.core.d.e) apx;
                if (eVar == null && com.baidu.swan.apps.runtime.config.c.a(eVar.aoJ())) {
                    com.baidu.swan.apps.view.a.b aoM = eVar.aoM();
                    if (aoM == null || !aoM.aOT()) {
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
                i2 = displayHeight - dK;
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
        i2 = displayHeight - dK;
        if (!z) {
        }
        if (!z2) {
        }
        if (i2 <= 0) {
        }
    }

    public static int dK(Context context) {
        com.baidu.swan.apps.core.d.c apx;
        int i;
        com.baidu.swan.apps.core.d.f afX = com.baidu.swan.apps.v.f.aAl().afX();
        if (context == null || afX == null || (apx = afX.apx()) == null || !(apx instanceof com.baidu.swan.apps.core.d.e) || !((com.baidu.swan.apps.core.d.e) apx).aog()) {
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

    public static void N(Activity activity) {
        if (activity != null && com.baidu.swan.apps.view.a.b.dAU) {
            new com.baidu.swan.apps.view.a.b(activity).a(-1, false, true, true);
        }
    }

    public static void O(Activity activity) {
        if (activity != null && com.baidu.swan.apps.view.a.b.dAU) {
            new com.baidu.swan.apps.view.a.b(activity).a(-1, true, false, true);
        }
    }

    @UiThread
    public static Bitmap aOe() {
        return v(1.0f, 1.0f);
    }

    @UiThread
    public static Bitmap v(float f, float f2) {
        com.baidu.swan.apps.v.f aAl = com.baidu.swan.apps.v.f.aAl();
        AbsoluteLayout po = aAl.po(aAl.apg());
        if (po == null || po.getWidth() <= 0 || po.getHeight() <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) (po.getWidth() * f), (int) (po.getHeight() * f2), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(-1);
        po.draw(new Canvas(createBitmap));
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

    public static Bitmap aOf() {
        return P(com.baidu.swan.apps.v.f.aAl().azV());
    }

    private static Bitmap P(Activity activity) {
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
        initDisplayMetrics(com.baidu.swan.apps.t.a.awW());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.widthPixels;
        }
        return 0;
    }

    public static int getDisplayHeight(Context context) {
        initDisplayMetrics(com.baidu.swan.apps.t.a.awW());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.heightPixels;
        }
        return 0;
    }

    public static int dL(Context context) {
        return !dM(context) ? Q((Activity) context) ? getDisplayHeight(context) : getDisplayWidth(context) : isScreenLand() ? getDisplayHeight(context) : getDisplayWidth(context);
    }

    private static boolean Q(Activity activity) {
        if (activity == null) {
            return false;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        return defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3;
    }

    public static boolean dM(Context context) {
        return Build.VERSION.SDK_INT >= 24 && (context instanceof Activity) && ((Activity) context).isInMultiWindowMode();
    }

    public static float getDensity(Context context) {
        initDisplayMetrics(com.baidu.swan.apps.t.a.awW());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.density;
        }
        return 0.0f;
    }

    public static int getDensityDpi(Context context) {
        initDisplayMetrics(com.baidu.swan.apps.t.a.awW());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.densityDpi;
        }
        return 0;
    }

    private static void initDisplayMetrics(Context context) {
        if (sDisplayMetrics == null) {
            Application awW = com.baidu.swan.apps.t.a.awW();
            if (awW != null) {
                context = awW;
            }
            if (context != null) {
                sDisplayMetrics = context.getResources().getDisplayMetrics();
            }
        }
    }

    public static int P(float f) {
        return dip2px(com.baidu.swan.apps.t.a.awW(), f);
    }

    public static float Q(float f) {
        return getDensity(com.baidu.swan.apps.t.a.awW()) * f;
    }

    public static int R(float f) {
        return px2dip(com.baidu.swan.apps.t.a.awW(), f);
    }

    public static int dip2px(Context context, float f) {
        return (int) (getDensity(context) * f);
    }

    public static int px2dip(Context context, float f) {
        return (int) (f / getDensity(context));
    }

    public static float px2dpFloat(float f) {
        return f / getDensity(com.baidu.swan.apps.t.a.awW());
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
        int identifier = com.baidu.swan.apps.t.a.awW().getResources().getIdentifier("status_bar_height", "dimen", HttpConstants.OS_TYPE_VALUE);
        if (identifier > 0) {
            try {
                i = com.baidu.swan.apps.t.a.awW().getResources().getDimensionPixelSize(identifier);
            } catch (Exception e) {
            }
        }
        if (i == 0) {
            return (int) (25.0f * dPh);
        }
        return i;
    }

    public static int getNavigationBarHeight() {
        boolean hasPermanentMenuKey = ViewConfiguration.get(com.baidu.swan.apps.t.a.awW()).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return 0;
        }
        Resources resources = com.baidu.swan.apps.t.a.awW().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", HttpConstants.OS_TYPE_VALUE));
    }

    public static boolean isScreenPortrait() {
        return com.baidu.swan.apps.t.a.awW().getResources().getConfiguration().orientation == 1;
    }

    public static boolean isScreenLand() {
        return com.baidu.swan.apps.t.a.awW().getResources().getConfiguration().orientation == 2;
    }

    public static int b(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", HttpConstants.OS_TYPE_VALUE);
        if (identifier <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public static int getActionBarHeight() {
        return com.baidu.swan.apps.t.a.awW().getResources().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
    }
}
