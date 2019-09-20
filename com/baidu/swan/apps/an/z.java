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
    private static DisplayMetrics baI;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final DisplayMetrics baJ = com.baidu.swan.apps.u.a.Eo().getResources().getDisplayMetrics();
    private static final float baK = baJ.density;

    public static int bQ(Context context) {
        int i;
        boolean z;
        com.baidu.swan.apps.core.d.d dVar;
        boolean z2 = true;
        if (context == null) {
            return 0;
        }
        int displayHeight = getDisplayHeight(context);
        int statusBarHeight = getStatusBarHeight();
        int bR = bR(context);
        try {
            i = context.getResources().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        } catch (Resources.NotFoundException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            i = 0;
        }
        com.baidu.swan.apps.core.d.e vN = com.baidu.swan.apps.w.e.GJ().vN();
        com.baidu.swan.apps.core.d.d dVar2 = null;
        if (vN != null) {
            com.baidu.swan.apps.core.d.b Av = vN.Av();
            if (!(Av instanceof com.baidu.swan.apps.core.d.d)) {
                dVar = null;
            } else {
                dVar = (com.baidu.swan.apps.core.d.d) Av;
            }
            if (Av != null && Av.zG()) {
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
        if (dVar2 == null || !com.baidu.swan.apps.ae.a.d.a(dVar2.zO())) {
            z = false;
            z2 = false;
        } else {
            com.baidu.swan.apps.view.a.b Am = dVar2.Am();
            z = Am != null && Am.Qd();
        }
        int i2 = displayHeight - bR;
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

    public static int bR(Context context) {
        com.baidu.swan.apps.core.d.b Av;
        int i;
        Resources.NotFoundException e;
        com.baidu.swan.apps.core.d.e vN = com.baidu.swan.apps.w.e.GJ().vN();
        if (context == null || vN == null || (Av = vN.Av()) == null || !(Av instanceof com.baidu.swan.apps.core.d.d) || !((com.baidu.swan.apps.core.d.d) Av).zA()) {
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
        if (activity != null && com.baidu.swan.apps.view.a.b.aOa) {
            new com.baidu.swan.apps.view.a.b(activity).eH(-1);
        }
    }

    @UiThread
    public static Bitmap PE() {
        com.baidu.swan.apps.w.e GJ = com.baidu.swan.apps.w.e.GJ();
        AbsoluteLayout fg = GJ.fg(GJ.Ag());
        if (fg == null || fg.getWidth() <= 0 || fg.getHeight() <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(fg.getWidth(), fg.getHeight(), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(-1);
        fg.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static Bitmap am(View view) {
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
        bV(com.baidu.swan.apps.u.a.Eo());
        if (baI != null) {
            return baI.widthPixels;
        }
        return 0;
    }

    public static int getDisplayHeight(Context context) {
        bV(com.baidu.swan.apps.u.a.Eo());
        if (baI != null) {
            return baI.heightPixels;
        }
        return 0;
    }

    public static int bS(Context context) {
        return PF() ? getDisplayWidth(context) : getDisplayHeight(context);
    }

    public static float bT(Context context) {
        bV(com.baidu.swan.apps.u.a.Eo());
        if (baI != null) {
            return baI.density;
        }
        return 0.0f;
    }

    public static int bU(Context context) {
        bV(com.baidu.swan.apps.u.a.Eo());
        if (baI != null) {
            return baI.densityDpi;
        }
        return 0;
    }

    private static void bV(Context context) {
        if (baI == null) {
            Application Eo = com.baidu.swan.apps.u.a.Eo();
            if (Eo != null) {
                context = Eo;
            }
            if (context != null) {
                baI = context.getResources().getDisplayMetrics();
            }
        }
    }

    public static int ad(float f) {
        return dip2px(com.baidu.swan.apps.u.a.Eo(), f);
    }

    public static float ae(float f) {
        return bT(com.baidu.swan.apps.u.a.Eo()) * f;
    }

    public static int af(float f) {
        return px2dip(com.baidu.swan.apps.u.a.Eo(), f);
    }

    public static int dip2px(Context context, float f) {
        return (int) (bT(context) * f);
    }

    public static int px2dip(Context context, float f) {
        return (int) (f / bT(context));
    }

    public static float ag(float f) {
        return f / bT(com.baidu.swan.apps.u.a.Eo());
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
        int identifier = com.baidu.swan.apps.u.a.Eo().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            try {
                i = com.baidu.swan.apps.u.a.Eo().getResources().getDimensionPixelSize(identifier);
            } catch (Exception e) {
            }
        }
        if (i == 0) {
            return (int) (25.0f * baK);
        }
        return i;
    }

    public static int getNavigationBarHeight() {
        boolean hasPermanentMenuKey = ViewConfiguration.get(com.baidu.swan.apps.u.a.Eo()).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return 0;
        }
        Resources resources = com.baidu.swan.apps.u.a.Eo().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static boolean PF() {
        return com.baidu.swan.apps.u.a.Eo().getResources().getConfiguration().orientation == 1;
    }

    public static boolean PG() {
        return com.baidu.swan.apps.u.a.Eo().getResources().getConfiguration().orientation == 2;
    }

    public static int PH() {
        return com.baidu.swan.apps.u.a.Eo().getResources().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
    }
}
