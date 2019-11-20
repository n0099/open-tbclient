package com.baidu.swan.apps.an;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsoluteLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
/* loaded from: classes2.dex */
public class z {
    private static DisplayMetrics bsQ;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final DisplayMetrics bsR = com.baidu.swan.apps.u.a.Jj().getResources().getDisplayMetrics();
    private static final float bsS = bsR.density;

    public static int bR(Context context) {
        int i;
        boolean z;
        com.baidu.swan.apps.core.d.d dVar;
        boolean z2 = true;
        if (context == null) {
            return 0;
        }
        int displayHeight = getDisplayHeight(context);
        int statusBarHeight = getStatusBarHeight();
        int bS = bS(context);
        try {
            i = context.getResources().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        } catch (Resources.NotFoundException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            i = 0;
        }
        com.baidu.swan.apps.core.d.e AI = com.baidu.swan.apps.w.e.LE().AI();
        com.baidu.swan.apps.core.d.d dVar2 = null;
        if (AI != null) {
            com.baidu.swan.apps.core.d.b Fr = AI.Fr();
            if (!(Fr instanceof com.baidu.swan.apps.core.d.d)) {
                dVar = null;
            } else {
                dVar = (com.baidu.swan.apps.core.d.d) Fr;
            }
            if (Fr != null && Fr.EC()) {
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
        if (dVar2 == null || !com.baidu.swan.apps.ae.a.d.a(dVar2.EK())) {
            z = false;
            z2 = false;
        } else {
            com.baidu.swan.apps.view.a.b Fi = dVar2.Fi();
            z = Fi != null && Fi.UR();
        }
        int i2 = displayHeight - bS;
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

    public static int bS(Context context) {
        com.baidu.swan.apps.core.d.b Fr;
        int i;
        Resources.NotFoundException e;
        com.baidu.swan.apps.core.d.e AI = com.baidu.swan.apps.w.e.LE().AI();
        if (context == null || AI == null || (Fr = AI.Fr()) == null || !(Fr instanceof com.baidu.swan.apps.core.d.d) || !((com.baidu.swan.apps.core.d.d) Fr).Ew()) {
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
        if (activity != null && com.baidu.swan.apps.view.a.b.bgQ) {
            new com.baidu.swan.apps.view.a.b(activity).fB(-1);
        }
    }

    @UiThread
    public static Bitmap Us() {
        com.baidu.swan.apps.w.e LE = com.baidu.swan.apps.w.e.LE();
        AbsoluteLayout fN = LE.fN(LE.Fc());
        if (fN == null || fN.getWidth() <= 0 || fN.getHeight() <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(fN.getWidth(), fN.getHeight(), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(-1);
        fN.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static Bitmap as(View view) {
        if (view != null) {
            try {
                View rootView = view.getRootView();
                rootView.setDrawingCacheEnabled(true);
                Bitmap createBitmap = Bitmap.createBitmap(rootView.getDrawingCache());
                rootView.setDrawingCacheEnabled(false);
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
        bV(com.baidu.swan.apps.u.a.Jj());
        if (bsQ != null) {
            return bsQ.widthPixels;
        }
        return 0;
    }

    public static int getDisplayHeight(Context context) {
        bV(com.baidu.swan.apps.u.a.Jj());
        if (bsQ != null) {
            return bsQ.heightPixels;
        }
        return 0;
    }

    public static int bT(Context context) {
        return Ut() ? getDisplayWidth(context) : getDisplayHeight(context);
    }

    public static float getDensity(Context context) {
        bV(com.baidu.swan.apps.u.a.Jj());
        if (bsQ != null) {
            return bsQ.density;
        }
        return 0.0f;
    }

    public static int bU(Context context) {
        bV(com.baidu.swan.apps.u.a.Jj());
        if (bsQ != null) {
            return bsQ.densityDpi;
        }
        return 0;
    }

    private static void bV(Context context) {
        if (bsQ == null) {
            Application Jj = com.baidu.swan.apps.u.a.Jj();
            if (Jj != null) {
                context = Jj;
            }
            if (context != null) {
                bsQ = context.getResources().getDisplayMetrics();
            }
        }
    }

    public static int S(float f) {
        return dip2px(com.baidu.swan.apps.u.a.Jj(), f);
    }

    public static float T(float f) {
        return getDensity(com.baidu.swan.apps.u.a.Jj()) * f;
    }

    public static int U(float f) {
        return px2dip(com.baidu.swan.apps.u.a.Jj(), f);
    }

    public static int dip2px(Context context, float f) {
        return (int) (getDensity(context) * f);
    }

    public static int px2dip(Context context, float f) {
        return (int) (f / getDensity(context));
    }

    public static float V(float f) {
        return f / getDensity(com.baidu.swan.apps.u.a.Jj());
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
        int identifier = com.baidu.swan.apps.u.a.Jj().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            try {
                i = com.baidu.swan.apps.u.a.Jj().getResources().getDimensionPixelSize(identifier);
            } catch (Exception e) {
            }
        }
        if (i == 0) {
            return (int) (25.0f * bsS);
        }
        return i;
    }

    public static int getNavigationBarHeight() {
        boolean hasPermanentMenuKey = ViewConfiguration.get(com.baidu.swan.apps.u.a.Jj()).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return 0;
        }
        Resources resources = com.baidu.swan.apps.u.a.Jj().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static boolean Ut() {
        return com.baidu.swan.apps.u.a.Jj().getResources().getConfiguration().orientation == 1;
    }

    public static boolean Uu() {
        return com.baidu.swan.apps.u.a.Jj().getResources().getConfiguration().orientation == 2;
    }

    public static int Uv() {
        return com.baidu.swan.apps.u.a.Jj().getResources().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
    }
}
