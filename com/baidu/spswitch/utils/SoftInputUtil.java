package com.baidu.spswitch.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import com.baidu.spswitch.IPanelHeightTarget;
import com.baidu.spswitch.R;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class SoftInputUtil {
    public static final String TAG = "SoftInputUtil";
    public static WeakReference<ViewGroup> sContentViewRef;
    public static final boolean DEBUG = SPConfig.isDebug();
    public static int sMinSoftInputHeight = 0;
    public static int sMaxSoftInputHeight = 0;
    public static int sMinPanelHeight = 0;
    public static int sMaxPanelHeight = 0;
    public static int sLastSaveSoftInputHeight = 0;

    /* loaded from: classes2.dex */
    public interface OnSoftInputShowingListener {
        void onSoftInputShowing(boolean z);
    }

    /* loaded from: classes2.dex */
    public static class SoftInputStatusListener implements ViewTreeObserver.OnGlobalLayoutListener {
        public final Activity mActivity;
        public final ViewGroup mContentView;
        public boolean mLastSoftInputShowing;
        public final IPanelHeightTarget mPanelHeightTarget;
        public int mPreviousDisplayHeight = 0;
        public final OnSoftInputShowingListener mSoftInputShowingListener;
        public int maxOverlayLayoutHeight;

        public SoftInputStatusListener(Activity activity, ViewGroup viewGroup, IPanelHeightTarget iPanelHeightTarget, OnSoftInputShowingListener onSoftInputShowingListener) {
            this.mActivity = activity;
            this.mSoftInputShowingListener = onSoftInputShowingListener;
            this.mContentView = viewGroup;
            this.mPanelHeightTarget = iPanelHeightTarget;
        }

        private void calculateSoftInputHeight(int i2) {
            int abs;
            View view;
            if (SoftInputUtil.DEBUG) {
                Log.d(SoftInputUtil.TAG, "****** calculateSoftInputHeight ******");
            }
            if (SoftInputUtil.DEBUG) {
                Log.d(SoftInputUtil.TAG, "displayHeight: " + i2 + ", previousDisplayHeight: " + this.mPreviousDisplayHeight);
            }
            if (this.mPreviousDisplayHeight == 0) {
                this.mPreviousDisplayHeight = i2;
                int validPanelHeight = SoftInputUtil.getValidPanelHeight(getContext());
                if (SoftInputUtil.DEBUG) {
                    Log.d(SoftInputUtil.TAG, "previous display height = 0, refresh Height : " + validPanelHeight);
                }
                this.mPanelHeightTarget.refreshHeight(validPanelHeight);
            }
            if (SPSwitchConflictUtil.isHandleByPlaceholder(this.mContentView.getContext())) {
                abs = ((View) this.mContentView.getParent()).getHeight() - i2;
                if (SoftInputUtil.DEBUG) {
                    Log.d(SoftInputUtil.TAG, "handle by placeholder, action bar overlay layout height " + view.getHeight() + ", display height: " + i2 + ", softInputHeight: " + abs);
                }
            } else {
                abs = Math.abs(i2 - this.mPreviousDisplayHeight);
            }
            if (abs <= SoftInputUtil.getMinSoftInputHeight(getContext())) {
                if (SoftInputUtil.DEBUG) {
                    Log.d(SoftInputUtil.TAG, "softInputHeight is invalid, too small. softInputHeight: " + abs);
                }
                if (Math.abs(abs) == UIUtils.getStatusBarHeight(this.mContentView.getContext())) {
                    this.mPreviousDisplayHeight -= abs;
                    return;
                }
                return;
            }
            Log.d(SoftInputUtil.TAG, String.format("pre display height: %d, display height: %d, softinput: %d ", Integer.valueOf(this.mPreviousDisplayHeight), Integer.valueOf(i2), Integer.valueOf(abs)));
            if (SoftInputUtil.saveSoftInputHeight(getContext(), abs)) {
                int validPanelHeight2 = SoftInputUtil.getValidPanelHeight(getContext());
                if (this.mPanelHeightTarget.getHeight() != validPanelHeight2) {
                    if (SoftInputUtil.DEBUG) {
                        Log.d(SoftInputUtil.TAG, "panel height changed, new height: " + validPanelHeight2);
                    }
                    this.mPanelHeightTarget.refreshHeight(validPanelHeight2);
                } else if (SoftInputUtil.DEBUG) {
                    Log.d(SoftInputUtil.TAG, "panel no need to refresh, panelHeight: " + this.mPanelHeightTarget.getHeight() + ", validPanelHeight: " + validPanelHeight2);
                }
            }
        }

        private void calculateSoftInputShowing(int i2) {
            boolean z;
            if (SoftInputUtil.DEBUG) {
                Log.d(SoftInputUtil.TAG, "###### calculateSoftInputShowing ######");
            }
            View view = (View) this.mContentView.getParent();
            int height = view.getHeight() - view.getPaddingTop();
            if (SPSwitchConflictUtil.isHandleByPlaceholder(this.mContentView.getContext())) {
                z = height > i2;
            } else {
                int i3 = this.maxOverlayLayoutHeight;
                if (i3 == 0) {
                    z = this.mLastSoftInputShowing;
                } else {
                    z = i2 < i3 - SoftInputUtil.getMinSoftInputHeight(getContext());
                }
                this.maxOverlayLayoutHeight = Math.max(this.maxOverlayLayoutHeight, height);
            }
            if (SoftInputUtil.DEBUG) {
                Log.d(SoftInputUtil.TAG, "maxOverlayLayoutHeight: " + this.maxOverlayLayoutHeight + ", isSoftInputShowing : " + z + ", mLastSoftInputShowing : " + this.mLastSoftInputShowing);
            }
            if (this.mLastSoftInputShowing != z) {
                if (SoftInputUtil.DEBUG) {
                    Log.d(SoftInputUtil.TAG, String.format("displayHeight %d, actionBarOverlayLayoutHeight %d, softinput showing: %B", Integer.valueOf(i2), Integer.valueOf(height), Boolean.valueOf(z)));
                }
                this.mPanelHeightTarget.onSoftInputShowing(z);
                OnSoftInputShowingListener onSoftInputShowingListener = this.mSoftInputShowingListener;
                if (onSoftInputShowingListener != null) {
                    onSoftInputShowingListener.onSoftInputShowing(z);
                }
            }
            this.mLastSoftInputShowing = z;
        }

        private Context getContext() {
            return this.mContentView.getContext();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i2;
            View childAt = this.mContentView.getChildAt(0);
            Rect rect = new Rect();
            if (childAt == null) {
                if (SoftInputUtil.DEBUG) {
                    Log.d(SoftInputUtil.TAG, "SoftInputUtil, user root view not ready so ignore layout changed");
                }
                i2 = -1;
            } else if (!SPSwitchConflictUtil.isHandleByPlaceholder(this.mContentView.getContext()) && (!ViewUtil.isSystemUILayoutFullScreen(this.mActivity) || !ViewUtil.isFitsSystemWindows(this.mActivity))) {
                i2 = childAt.getHeight();
                if (SoftInputUtil.DEBUG) {
                    Log.d(SoftInputUtil.TAG, "#onGlobalLayout#, displayHeight calc by userRootView.getHeight()");
                }
            } else {
                childAt.getWindowVisibleDisplayFrame(rect);
                i2 = rect.bottom - rect.top;
                if (SoftInputUtil.DEBUG) {
                    Log.d(SoftInputUtil.TAG, "#onGlobalLayout#, displayHeight calc by getWindowVisibleDisplayFrame");
                }
            }
            if (i2 == -1) {
                return;
            }
            if (SoftInputUtil.DEBUG) {
                Log.d(SoftInputUtil.TAG, "displayHeight: " + i2);
            }
            calculateSoftInputHeight(i2);
            calculateSoftInputShowing(i2);
        }
    }

    public static ViewTreeObserver.OnGlobalLayoutListener attach(Activity activity, ViewGroup viewGroup, IPanelHeightTarget iPanelHeightTarget, OnSoftInputShowingListener onSoftInputShowingListener) {
        if (viewGroup == null) {
            viewGroup = (ViewGroup) activity.findViewById(16908290);
        }
        SoftInputStatusListener softInputStatusListener = new SoftInputStatusListener(activity, viewGroup, iPanelHeightTarget, onSoftInputShowingListener);
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(softInputStatusListener);
        sContentViewRef = new WeakReference<>(viewGroup);
        return softInputStatusListener;
    }

    public static void detach(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        ((ViewGroup) activity.findViewById(16908290)).getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static ViewGroup getContentView() {
        WeakReference<ViewGroup> weakReference = sContentViewRef;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static int getMaxPanelHeight(Resources resources) {
        if (sMaxPanelHeight == 0) {
            sMaxPanelHeight = resources.getDimensionPixelSize(R.dimen.max_panel_height);
        }
        return sMaxPanelHeight;
    }

    public static int getMaxSoftInputHeight(Context context) {
        if (sMaxSoftInputHeight == 0) {
            sMaxSoftInputHeight = context.getResources().getDimensionPixelSize(R.dimen.max_softinput_height);
        }
        return sMaxSoftInputHeight;
    }

    public static int getMinPanelHeight(Resources resources) {
        if (sMinPanelHeight == 0) {
            sMinPanelHeight = resources.getDimensionPixelSize(R.dimen.min_panel_height);
        }
        return sMinPanelHeight;
    }

    public static int getMinSoftInputHeight(Context context) {
        if (sMinSoftInputHeight == 0) {
            sMinSoftInputHeight = context.getResources().getDimensionPixelSize(R.dimen.min_softinput_height);
        }
        return sMinSoftInputHeight;
    }

    public static int getSoftInputHeight(Context context) {
        if (sLastSaveSoftInputHeight == 0) {
            sLastSaveSoftInputHeight = SoftInputSharedPreferences.get(context, getMinPanelHeight(context.getResources()));
        }
        return sLastSaveSoftInputHeight;
    }

    public static int getValidPanelHeight(Context context) {
        return Math.min(getMaxPanelHeight(context.getResources()), Math.max(getMinPanelHeight(context.getResources()), getSoftInputHeight(context)));
    }

    public static void hideSoftInput(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static boolean saveSoftInputHeight(Context context, int i2) {
        if (sLastSaveSoftInputHeight != i2 && i2 >= 0) {
            sLastSaveSoftInputHeight = i2;
            if (DEBUG) {
                Log.d(TAG, "save softInput height: " + i2);
            }
            return SoftInputSharedPreferences.save(context, i2);
        }
        return false;
    }

    public static void setContentView(ViewGroup viewGroup) {
        sContentViewRef = new WeakReference<>(viewGroup);
    }

    public static void showSoftInput(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }

    public static void showSoftInputDelay(final View view, long j) {
        view.postDelayed(new Runnable() { // from class: com.baidu.spswitch.utils.SoftInputUtil.1
            @Override // java.lang.Runnable
            public void run() {
                SoftInputUtil.showSoftInput(view);
            }
        }, j);
    }
}
