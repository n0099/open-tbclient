package com.baidu.searchbox.player.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes4.dex */
public class BdViewOpUtils {
    public static final long DELAY_MILLIS = 300;
    public static final String KEY_DISPLAY_CUTOUT_MODE = "activity_layoutInDisplayCutoutMode";
    public static final String KEY_SYSTEM_UI_VISIBILITY = "activity_mSystemUiVisibility";
    public static final int SYSTEM_UI_FLAG_NONE = -1;
    public static final String TAG = "BdViewOpUtils";

    public static int getImmersiveSystemUiVisibility() {
        if (Build.VERSION.SDK_INT >= 19) {
            return 5638;
        }
        return 1542;
    }

    @Nullable
    public static ViewGroup getDecorView(@Nullable Activity activity) {
        if (activity != null) {
            return (ViewGroup) activity.getWindow().getDecorView();
        }
        return null;
    }

    public static int getDisplayCutoutMode(Activity activity) {
        if (activity.getIntent() == null) {
            return 0;
        }
        return activity.getIntent().getIntExtra(KEY_DISPLAY_CUTOUT_MODE, 0);
    }

    public static int getSystemUiVisibility(@Nullable Activity activity) {
        if (activity == null || activity.getIntent() == null) {
            return -1;
        }
        return activity.getIntent().getIntExtra(KEY_SYSTEM_UI_VISIBILITY, -1);
    }

    public static boolean hasChild(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean hasParent(View view2) {
        if (view2 != null && view2.getParent() != null) {
            return true;
        }
        return false;
    }

    public static boolean hasPermanentMenuKey(Context context) {
        if (context != null) {
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        return false;
    }

    public static boolean isParent(View view2) {
        if (view2 == null || view2.getParent() == null) {
            return false;
        }
        return true;
    }

    public static boolean isZeroSize(View view2) {
        if (view2 != null && view2.getWidth() != 0 && view2.getHeight() != 0) {
            return false;
        }
        return true;
    }

    public static boolean removeChilds(ViewGroup viewGroup) {
        if (viewGroup != null) {
            BdVideoLog.d(TAG, "removeChilds " + viewGroup.hashCode());
            viewGroup.removeAllViews();
            return true;
        }
        return false;
    }

    public static void restoreSystemUiVisibility(@Nullable final Activity activity) {
        if (!hasPermanentMenuKey(activity)) {
            return;
        }
        final ViewGroup decorView = getDecorView(activity);
        int systemUiVisibility = getSystemUiVisibility(activity);
        if (decorView != null && systemUiVisibility != -1) {
            decorView.postDelayed(new Runnable() { // from class: com.baidu.searchbox.player.utils.BdViewOpUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    int immersiveSystemUiVisibility = BdViewOpUtils.getImmersiveSystemUiVisibility();
                    int systemUiVisibility2 = decorView.getSystemUiVisibility();
                    int systemUiVisibility3 = BdViewOpUtils.getSystemUiVisibility(activity);
                    if (immersiveSystemUiVisibility != systemUiVisibility2) {
                        systemUiVisibility3 |= systemUiVisibility2;
                    }
                    BdVideoLog.d(BdViewOpUtils.TAG, "RESTORE KEY_SYSTEM_UI_VISIBILITY=" + systemUiVisibility3);
                    decorView.setSystemUiVisibility(systemUiVisibility3);
                }
            }, 300L);
        }
    }

    public static void showSystemUi(View view2) {
        if (view2 != null) {
            view2.setSystemUiVisibility(0);
        }
    }

    public static boolean attachDecor(Activity activity, View view2) {
        if (activity != null && view2 != null) {
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            removeView(view2);
            viewGroup.removeView(view2);
            viewGroup.addView(view2);
            if (hasPermanentMenuKey(activity)) {
                saveSystemUiVisibility(activity);
                setSystemUiVisibility(viewGroup, true);
            }
            return true;
        }
        return false;
    }

    public static void fixFullScreen4Notch(Activity activity, boolean z) {
        if (activity == null || Build.VERSION.SDK_INT < 28) {
            return;
        }
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            saveDisplayCutoutMode(activity, attributes.layoutInDisplayCutoutMode);
            attributes.layoutInDisplayCutoutMode = 1;
        } else {
            attributes.layoutInDisplayCutoutMode = getDisplayCutoutMode(activity);
        }
        window.setAttributes(attributes);
    }

    public static boolean isAttachDecor(Activity activity, View view2) {
        if (activity == null || view2 == null || ((ViewGroup) activity.getWindow().getDecorView()).indexOfChild(view2) == -1) {
            return false;
        }
        return true;
    }

    public static boolean isParentView(View view2, ViewGroup viewGroup) {
        if (view2 == null || viewGroup == null || viewGroup != ((ViewGroup) view2.getParent())) {
            return false;
        }
        return true;
    }

    public static void saveDisplayCutoutMode(Activity activity, int i) {
        if (activity.getIntent() != null) {
            activity.getIntent().putExtra(KEY_DISPLAY_CUTOUT_MODE, i);
        }
    }

    public static void setSystemUiVisibility(View view2, boolean z) {
        BdVideoLog.d(TAG, "setSystemUiVisibility immersive: " + z);
        if (view2 == null) {
            return;
        }
        if (z) {
            view2.setSystemUiVisibility(getImmersiveSystemUiVisibility());
        } else {
            view2.setSystemUiVisibility(0);
        }
    }

    public static boolean attachView(View view2, ViewGroup viewGroup) {
        if (view2 != null && viewGroup != null && viewGroup.getParent() != null) {
            BdVideoLog.d(TAG, "attachView " + view2.hashCode() + " " + viewGroup.hashCode());
            try {
                viewGroup.addView(view2);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void fixFullScreen4Notch(Dialog dialog, boolean z) {
        if (dialog == null || Build.VERSION.SDK_INT < 28) {
            return;
        }
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.layoutInDisplayCutoutMode = 1;
        } else {
            attributes.layoutInDisplayCutoutMode = 0;
        }
        window.setAttributes(attributes);
    }

    public static boolean removeView(View view2) {
        if (view2 != null && view2.getParent() != null && (view2.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            if (viewGroup.indexOfChild(view2) != -1) {
                try {
                    BdVideoLog.d(TAG, "removeView " + view2.hashCode());
                    viewGroup.removeView(view2);
                    return true;
                } catch (Exception e) {
                    BdVideoLog.e("removeView(" + System.identityHashCode(view2) + SmallTailInfo.EMOTION_SUFFIX, e);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static void saveSystemUiVisibility(@Nullable Activity activity) {
        ViewGroup decorView;
        if (activity != null && activity.getIntent() != null && (decorView = getDecorView(activity)) != null) {
            BdVideoLog.d(TAG, "SAVE KEY_SYSTEM_UI_VISIBILITY=" + decorView.getSystemUiVisibility());
            activity.getIntent().putExtra(KEY_SYSTEM_UI_VISIBILITY, decorView.getSystemUiVisibility());
        }
    }
}
