package com.baidu.searchbox.suspension.activity;

import android.app.Activity;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes20.dex */
public abstract class SuspensionViewAdapter {
    public static final int DEFAULT_X = (int) (AppRuntime.getAppContext().getResources().getDisplayMetrics().density * 10.0f);
    public static final int DEFAULT_Y = (int) (AppRuntime.getAppContext().getResources().getDisplayMetrics().density * 50.0f);
    private View mSuspensionView;
    private int mX = DEFAULT_X;
    private int mY = DEFAULT_Y;

    protected abstract View createView();

    public abstract boolean filterActivity(Activity activity);

    public abstract int getHeight();

    public abstract int getWidth();

    public void setXY(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    public int getX(int i) {
        return this.mX;
    }

    public int getY(int i) {
        return this.mY;
    }

    public void removeView() {
        if (this.mSuspensionView != null) {
            WindowManager.LayoutParams suspensionLayoutParams = getSuspensionLayoutParams(this.mSuspensionView);
            if (suspensionLayoutParams != null) {
                this.mX = suspensionLayoutParams.x;
                this.mY = suspensionLayoutParams.y;
            }
            this.mSuspensionView.setVisibility(8);
            ((SuspensionWindowController) this.mSuspensionView.getTag(R.id.suspension_window_controller)).removeHoverLayout(this.mSuspensionView);
            this.mSuspensionView = null;
        }
    }

    public void showView(Activity activity) {
        removeView();
        this.mSuspensionView = createView();
        SuspensionWindowController suspensionWindowController = new SuspensionWindowController(activity, activity.getWindowManager());
        this.mSuspensionView.setTag(R.id.suspension_window_controller, suspensionWindowController);
        suspensionWindowController.addHoverLayout(this.mX, this.mY, getWidth(), getHeight(), this.mSuspensionView);
    }

    private WindowManager.LayoutParams getSuspensionLayoutParams(View view) {
        ViewGroup.LayoutParams layoutParams = view == null ? null : view.getLayoutParams();
        if (layoutParams == null || !(layoutParams instanceof WindowManager.LayoutParams)) {
            return null;
        }
        return (WindowManager.LayoutParams) layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public static class SuspensionWindowController {
        private Activity mActivity;
        private WindowManager mWindowManager;

        public SuspensionWindowController(Activity activity, WindowManager windowManager) {
            this.mActivity = activity;
            this.mWindowManager = windowManager;
        }

        public void addHoverLayout(final int i, final int i2, final int i3, final int i4, final View view) {
            if (!this.mActivity.isDestroyed()) {
                IBinder windowToken = this.mActivity.getWindow().getDecorView().getWindowToken();
                if (windowToken == null) {
                    this.mActivity.getWindow().getDecorView().post(new Runnable() { // from class: com.baidu.searchbox.suspension.activity.SuspensionViewAdapter.SuspensionWindowController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            IBinder windowToken2 = SuspensionWindowController.this.mActivity.getWindow().getDecorView().getWindowToken();
                            if (windowToken2 != null) {
                                SuspensionWindowController.this.addHoverLayoutInner(i, i2, i3, i4, view, windowToken2);
                            }
                        }
                    });
                } else {
                    addHoverLayoutInner(i, i2, i3, i4, view, windowToken);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addHoverLayoutInner(int i, int i2, int i3, int i4, View view, IBinder iBinder) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(i3, i4, 1003, 552, -3);
            layoutParams.gravity = 83;
            layoutParams.x = i;
            layoutParams.y = i2;
            layoutParams.token = iBinder;
            this.mWindowManager.addView(view, layoutParams);
        }

        public void removeHoverLayout(View view) {
            try {
                this.mWindowManager.removeViewImmediate(view);
            } catch (Exception e) {
            }
        }
    }
}
