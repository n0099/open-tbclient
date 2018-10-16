package com.baidu.searchbox.ng.ai.apps.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragment;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.res.ui.BdBaseImageView;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.searchbox.ng.ai.apps.view.Immersion.AiAppsImmersionHelper;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes2.dex */
public class AiAppsUIUtils {
    private static final boolean DEBUG = false;
    private static final int NO_ALPHA_STANDARD = 7;
    private static final int STANDARD_STATUSBAR_HEIGHT = 50;
    private static final String TAG = "AiAppsUIUtils";
    private static final int WITH_ALPHA_STANDARD = 9;
    private static DisplayMetrics sDisplayMetrics;
    private static final DisplayMetrics DISPLAY_METRICS = AiAppsRuntime.getAppContext().getResources().getDisplayMetrics();
    private static final float SCREEN_DENSITY = DISPLAY_METRICS.density;

    /* JADX WARN: Removed duplicated region for block: B:40:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getAiAppWindowHeight(Context context) {
        int i;
        AiAppsFragment aiAppsFragment;
        int i2;
        int i3;
        boolean z;
        int i4;
        WindowConfig curWindowConfig;
        int i5;
        boolean z2 = true;
        if (context == null) {
            return 0;
        }
        int displayHeight = getDisplayHeight(context);
        int statusBarHeight = getStatusBarHeight();
        try {
            i = context.getResources().getDimensionPixelSize(R.dimen.aiapps_normal_base_action_bar_height);
        } catch (Resources.NotFoundException e) {
            i = 0;
        }
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            aiAppsFragment = null;
            i2 = i;
            i3 = 0;
        } else {
            AiAppsBaseFragment topFragment = aiAppsFragmentManager.getTopFragment();
            if (topFragment == null || !topFragment.isShowActionBarShadow()) {
                i2 = i;
            } else {
                try {
                    int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.aiapps_action_bar_shadow_height);
                    if (dimensionPixelSize > 0) {
                        i += dimensionPixelSize;
                    }
                    i2 = i;
                } catch (Resources.NotFoundException e2) {
                    i2 = i;
                }
            }
            if (topFragment == null || !(topFragment instanceof AiAppsFragment)) {
                aiAppsFragment = null;
                i3 = 0;
            } else {
                aiAppsFragment = (AiAppsFragment) topFragment;
                if (aiAppsFragment.isTabFragment()) {
                    try {
                        i5 = context.getResources().getDimensionPixelSize(R.dimen.aiapps_bottom_tab_height);
                    } catch (Resources.NotFoundException e3) {
                        i5 = 0;
                    }
                    try {
                        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.aiapps_bottom_tab_shadow_height);
                        if (dimensionPixelSize2 > 0) {
                            i5 += dimensionPixelSize2;
                        }
                        i3 = i5;
                    } catch (Resources.NotFoundException e4) {
                        i3 = i5;
                        if (aiAppsFragment == null) {
                        }
                        z = false;
                        z2 = false;
                        i4 = displayHeight - i3;
                        if (!z) {
                        }
                        if (!z2) {
                        }
                        if (i4 <= 0) {
                        }
                    }
                } else {
                    i3 = 0;
                }
            }
        }
        if (aiAppsFragment == null && (curWindowConfig = aiAppsFragment.getCurWindowConfig()) != null && curWindowConfig.mEnableOpacityNavigationBar) {
            AiAppsImmersionHelper immersionHelper = aiAppsFragment.getImmersionHelper();
            z = immersionHelper != null && immersionHelper.isOccupyStatusBar();
        } else {
            z = false;
            z2 = false;
        }
        i4 = displayHeight - i3;
        if (!z) {
            i4 -= statusBarHeight;
        }
        if (!z2) {
            i4 -= i2;
        }
        if (i4 <= 0) {
            return i4;
        }
        return 0;
    }

    public static void isShowIconLabel(BdBaseImageView bdBaseImageView, TextView textView, String str) {
        if ("0".equals(str)) {
            bdBaseImageView.setVisibility(8);
            textView.setVisibility(8);
        } else if ("1".equals(String.valueOf(str))) {
            bdBaseImageView.setVisibility(0);
            textView.setVisibility(0);
            textView.setText(R.string.aiapps_history_aiapp_tag);
        } else if ("2".equals(String.valueOf(str))) {
            bdBaseImageView.setVisibility(0);
            textView.setVisibility(0);
            textView.setText(R.string.aiapps_history_aiapp_tag_trial);
        } else if ("3".equals(String.valueOf(str))) {
            bdBaseImageView.setVisibility(0);
            textView.setVisibility(0);
            textView.setText(R.string.aiapps_history_aiapp_tag_experience);
        }
    }

    public static void applyImmersion(Activity activity) {
        if (activity != null && AiAppsImmersionHelper.SUPPORT_IMMERSION) {
            new AiAppsImmersionHelper(activity).setImmersion(-1);
        }
    }

    @UiThread
    public static Bitmap getScreenshot() {
        AiAppsController aiAppsController = AiAppsController.getInstance();
        WebView bdWebViewBySlaveId = aiAppsController.getBdWebViewBySlaveId(aiAppsController.getSlaveWebViewId());
        if (bdWebViewBySlaveId == null || bdWebViewBySlaveId.getWidth() <= 0 || bdWebViewBySlaveId.getHeight() <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bdWebViewBySlaveId.getWidth(), bdWebViewBySlaveId.getHeight(), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(-1);
        bdWebViewBySlaveId.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static int getDisplayWidth(Context context) {
        initDisplayMetrics(AiAppsRuntime.getAppContext());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.widthPixels;
        }
        return 0;
    }

    public static int getDisplayHeight(Context context) {
        initDisplayMetrics(AiAppsRuntime.getAppContext());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.heightPixels;
        }
        return 0;
    }

    public static float getDensity(Context context) {
        initDisplayMetrics(AiAppsRuntime.getAppContext());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.density;
        }
        return 0.0f;
    }

    public static int getDensityDpi(Context context) {
        initDisplayMetrics(AiAppsRuntime.getAppContext());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.densityDpi;
        }
        return 0;
    }

    private static void initDisplayMetrics(Context context) {
        if (sDisplayMetrics == null) {
            Application appContext = AiAppsRuntime.getAppContext();
            if (appContext != null) {
                context = appContext;
            }
            if (context != null) {
                sDisplayMetrics = context.getResources().getDisplayMetrics();
            }
        }
    }

    public static int dp2px(float f) {
        return dip2px(AiAppsRuntime.getAppContext(), f);
    }

    public static float dp2pxf(float f) {
        return getDensity(AiAppsRuntime.getAppContext()) * f;
    }

    public static int px2dp(float f) {
        return px2dip(AiAppsRuntime.getAppContext(), f);
    }

    public static int dip2px(Context context, float f) {
        return (int) (getDensity(context) * f);
    }

    public static int px2dip(Context context, float f) {
        return (int) (f / getDensity(context));
    }

    public static float px2dpFloat(float f) {
        return f / getDensity(AiAppsRuntime.getAppContext());
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

    public static boolean isColorValid(Object obj) {
        boolean z = true;
        if (!(obj instanceof String)) {
            return obj instanceof Integer;
        }
        String valueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(valueOf)) {
            return false;
        }
        if (!valueOf.startsWith("#") || (valueOf.length() != 7 && valueOf.length() != 9)) {
            z = false;
        }
        return z;
    }

    public static int getStatusBarHeight() {
        int i = 0;
        int identifier = AiAppsRuntime.getAppContext().getResources().getIdentifier("status_bar_height", "dimen", HttpConstants.OS_TYPE_VALUE);
        if (identifier > 0) {
            try {
                i = AiAppsRuntime.getAppContext().getResources().getDimensionPixelSize(identifier);
            } catch (Exception e) {
            }
        }
        if (i == 0) {
            return (int) (25.0f * SCREEN_DENSITY);
        }
        return i;
    }

    public static int getNavigationBarHeight() {
        boolean hasPermanentMenuKey = ViewConfiguration.get(AiAppsRuntime.getAppContext()).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return 0;
        }
        Resources resources = AiAppsRuntime.getAppContext().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", HttpConstants.OS_TYPE_VALUE));
    }

    public static boolean isScreenPortrait() {
        return AiAppsRuntime.getAppContext().getResources().getConfiguration().orientation == 1;
    }

    public static boolean isScreenLand() {
        return AiAppsRuntime.getAppContext().getResources().getConfiguration().orientation == 2;
    }
}
