package com.baidu.searchbox.ng.ai.apps.view.Immersion;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsColorUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.searchbox.ng.ai.apps.view.Immersion.AiAppsImmersionConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class AiAppsImmersionHelper {
    private static final boolean DEBUG = false;
    private static final int DEFAULT_FLAG = 5120;
    private static final int HIDE_NAV_FLAG = 5120;
    public static final int INVALID_COLOR = 1;
    private static final int MEIZU = 2;
    private static final int NORMAL_PHONE = 0;
    private static final int STATUS_BAR_ALPHA_BELOW_M = 45;
    public static final boolean SUPPORT_IMMERSION = isSupportImmersion();
    private static final String TAG = "AiAppsImmersionHelper";
    private static final String VIEW_TAG = "IMMERSION_VIEW";
    private static final int XIAOMI = 1;
    private static int sRomType;
    private boolean isOccupyStatusBar;
    @NonNull
    private Activity mActivity;
    private View.OnSystemUiVisibilityChangeListener mChangeLisenter;
    @Nullable
    private View mContentView;
    @Nullable
    private View mCurStatusBarView;
    private AiAppsImmersionConfig mImmersionConfig;
    @NonNull
    private ViewGroup mRootView;
    private int mStatusBarViewBg;

    static {
        sRomType = 0;
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            sRomType = 1;
        } else if (TextUtils.equals(Build.MANUFACTURER, "Meizu")) {
            sRomType = 2;
        }
    }

    public AiAppsImmersionHelper(@NonNull Activity activity) {
        this(activity, (ViewGroup) activity.findViewById(16908290));
    }

    public AiAppsImmersionHelper(@NonNull Activity activity, @NonNull ViewGroup viewGroup) {
        this.mStatusBarViewBg = 1;
        this.mActivity = activity;
        this.mRootView = viewGroup;
        this.mContentView = this.mRootView.getChildAt(0);
    }

    public void setImmersion(int i) {
        setImmersion(i, AiAppsColorUtils.isLightColor(i), false);
    }

    public void setImmersion(int i, boolean z, boolean z2) {
        AiAppsImmersionConfig createConfig;
        if (SUPPORT_IMMERSION) {
            if (i == 1) {
                if (this.mStatusBarViewBg != 1) {
                    reset();
                }
                this.mStatusBarViewBg = i;
                createConfig = getConfig();
            } else {
                this.mStatusBarViewBg = i;
                createConfig = createConfig(i, getStatusBarColor(i), z, z2);
                this.mImmersionConfig = createConfig;
            }
            this.isOccupyStatusBar = z2;
            setImmersion(createConfig);
        }
    }

    public void resetWithCurImmersion() {
        setImmersion(getConfig());
    }

    public void reset() {
        this.mImmersionConfig = null;
        this.mStatusBarViewBg = 1;
    }

    @NonNull
    public AiAppsImmersionConfig getConfig() {
        if (this.mImmersionConfig == null) {
            createDefaultConfig();
        }
        return this.mImmersionConfig;
    }

    @Nullable
    public View getCurStatusBarView() {
        return this.mCurStatusBarView;
    }

    public boolean isOccupyStatusBar() {
        return this.isOccupyStatusBar;
    }

    private void setImmersion(@NonNull AiAppsImmersionConfig aiAppsImmersionConfig) {
        if (sRomType == 2) {
            setMEIZUStatusBar(aiAppsImmersionConfig);
        } else {
            setWindowFlag();
            updateUI(aiAppsImmersionConfig);
        }
        if (this.mContentView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
            if (aiAppsImmersionConfig.isOccupyStatusBar) {
                layoutParams.topMargin = 0;
            } else {
                layoutParams.topMargin = AiAppsUIUtils.getStatusBarHeight();
            }
            this.mContentView.setLayoutParams(layoutParams);
        }
    }

    private void setWindowFlag() {
        Window window = this.mActivity.getWindow();
        if (Build.VERSION.SDK_INT >= 21) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            switch (sRomType) {
                case 1:
                    setMIUISetStatusBarLightMode(window, getConfig().useLightStatusBar);
                    return;
                default:
                    return;
            }
        } else if (Build.VERSION.SDK_INT >= 19) {
            window.addFlags(67108864);
        }
    }

    private void updateUI(AiAppsImmersionConfig aiAppsImmersionConfig) {
        int i;
        int i2;
        Window window = this.mActivity.getWindow();
        if (aiAppsImmersionConfig.isShowNavBar) {
        }
        if (aiAppsImmersionConfig.useLightStatusBar) {
            i = 13312;
        } else {
            i = 5120;
        }
        if (!aiAppsImmersionConfig.isShowStatusBar) {
            i2 = i & (-257);
        } else {
            i2 = i | 256;
        }
        int i3 = aiAppsImmersionConfig.customStatusBarViewBg;
        if (i3 == 1) {
            i3 = getDefaultStatusBarViewBg();
        }
        window.getDecorView().setSystemUiVisibility(i2);
        if (Build.VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(aiAppsImmersionConfig.statusBarColor);
        }
        View statusBarView = getStatusBarView(aiAppsImmersionConfig);
        if (statusBarView != null) {
            statusBarView.setBackgroundColor(i3);
        }
        if (this.mChangeLisenter == null) {
            this.mChangeLisenter = new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.searchbox.ng.ai.apps.view.Immersion.AiAppsImmersionHelper.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i4) {
                }
            };
            window.getDecorView().setOnSystemUiVisibilityChangeListener(this.mChangeLisenter);
        }
    }

    private void setMEIZUStatusBar(AiAppsImmersionConfig aiAppsImmersionConfig) {
        int i;
        try {
            Window window = this.mActivity.getWindow();
            window.addFlags(67108864);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i2 = declaredField.getInt(null);
            int i3 = declaredField2.getInt(attributes);
            if (aiAppsImmersionConfig.useLightStatusBar) {
                i = i2 | i3;
            } else {
                i = (i2 ^ (-1)) & i3;
            }
            declaredField2.setInt(attributes, i);
            window.setAttributes(attributes);
            int i4 = aiAppsImmersionConfig.customStatusBarViewBg;
            if (i4 == 1) {
                i4 = getDefaultStatusBarViewBg();
            }
            View statusBarView = getStatusBarView(aiAppsImmersionConfig);
            if (statusBarView != null) {
                statusBarView.setBackgroundColor(i4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean setMIUISetStatusBarLightMode(Window window, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                if (z) {
                    method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i));
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Nullable
    private View getStatusBarView(@NonNull AiAppsImmersionConfig aiAppsImmersionConfig) {
        if (this.mCurStatusBarView != null) {
            if (!aiAppsImmersionConfig.isShowStatusBar) {
                this.mRootView.removeView(this.mCurStatusBarView);
                this.mCurStatusBarView = null;
                return null;
            }
            return this.mCurStatusBarView;
        } else if (!aiAppsImmersionConfig.isShowStatusBar) {
            this.mCurStatusBarView = null;
            return null;
        } else {
            int statusBarHeight = AiAppsUIUtils.getStatusBarHeight();
            View view = new View(this.mActivity);
            view.setTag(VIEW_TAG);
            view.setId(R.id.aiapps_immersion_custom_statusbar_view);
            this.mRootView.addView(view, new ViewGroup.LayoutParams(-1, statusBarHeight));
            this.mCurStatusBarView = view;
            return view;
        }
    }

    private void createDefaultConfig() {
        int defaultStatusBarViewBg = getDefaultStatusBarViewBg();
        this.mImmersionConfig = createConfig(defaultStatusBarViewBg, getStatusBarColor(defaultStatusBarViewBg), false, false);
    }

    private AiAppsImmersionConfig createConfig(int i, int i2, boolean z, boolean z2) {
        return AiAppsImmersionConfig.Builder.newBuilder().useLightStatusBar(z).showStatusBar(true).showNavBar(false).setStatusBarColor(i2).setCustomStatusBarViewBg(i).occupyStatusBar(z2).build();
    }

    private int getDefaultStatusBarViewBg() {
        return Build.VERSION.SDK_INT >= 21 ? this.mActivity.getResources().getColor(R.color.aiapps_statusbar_immersion_bg) : this.mActivity.getResources().getColor(R.color.aiapps_statusbar_immersion_bg_below_lollipop);
    }

    private int getStatusBarColor(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return 0;
        }
        return calculateStatusColor(i, 45);
    }

    private static int calculateStatusColor(int i, int i2) {
        if (i2 != 0) {
            float f = 1.0f - (i2 / 255.0f);
            return (((int) ((((i >> 16) & 255) * f) + 0.5d)) << 16) | (-16777216) | (((int) ((((i >> 8) & 255) * f) + 0.5d)) << 8) | ((int) ((f * (i & 255)) + 0.5d));
        }
        return i;
    }

    private static boolean isSupportImmersion() {
        return Build.VERSION.SDK_INT >= 21;
    }
}
