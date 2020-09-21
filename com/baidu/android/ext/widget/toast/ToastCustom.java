package com.baidu.android.ext.widget.toast;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.toast.R;
/* loaded from: classes5.dex */
public class ToastCustom {
    public static final int CLICKABLE_TOAST_SHOW_TIME = 3;
    public static final int NORMAL_TOAST_SHOW_TIME = 2;
    private static final String TAG = "ToastCustom";
    private Context mContext;
    private volatile int mDuration;
    private boolean mIsDebug;
    private boolean mMask;
    private View mMaskView;
    private View mNextMaskView;
    private View mNextView;
    private Runnable mShowRunnable;
    private View mView;
    private WindowManager mWM;
    private UniversalToast.OnDismissListener onDismissListener;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mCancelRunnable = new Runnable() { // from class: com.baidu.android.ext.widget.toast.ToastCustom.1
        @Override // java.lang.Runnable
        public void run() {
            if (ToastCustom.this.mView != null) {
                if (ToastCustom.this.mView.getParent() != null) {
                    ToastCustom.this.mWM.removeView(ToastCustom.this.mView);
                    if (ToastCustom.this.onDismissListener != null) {
                        ToastCustom.this.onDismissListener.onDismiss();
                        ToastCustom.this.onDismissListener = null;
                    }
                }
                ToastCustom.this.mView = null;
            }
            if (ToastCustom.this.mMaskView != null) {
                if (ToastCustom.this.mMaskView.getParent() != null) {
                    ToastCustom.this.mWM.removeView(ToastCustom.this.mMaskView);
                }
                ToastCustom.this.mMaskView = null;
            }
        }
    };
    private WindowManager.LayoutParams mWinParams = new WindowManager.LayoutParams();

    public ToastCustom(Context context) {
        this.mContext = context;
        this.mWM = (WindowManager) this.mContext.getSystemService("window");
        this.mWinParams.height = -2;
        this.mWinParams.width = -2;
        this.mWinParams.format = -3;
        this.mWinParams.windowAnimations = R.style.toast_animation;
        this.mWinParams.type = 2005;
        this.mWinParams.setTitle("Toast");
        this.mWinParams.flags = 168;
        this.mWinParams.gravity = 81;
        this.mWinParams.y = -30;
        this.mDuration = 2;
        this.mIsDebug = false;
    }

    public static ToastCustom makeText(@NonNull Context context, CharSequence charSequence, int i) {
        ToastCustom toastCustom = new ToastCustom(context);
        toastCustom.mNextView = new TextView(context);
        ((TextView) toastCustom.mNextView).setText(charSequence);
        toastCustom.mDuration = i;
        return toastCustom;
    }

    public void setView(@NonNull View view) {
        this.mNextView = view;
        this.mNextView.setClickable(true);
    }

    public void setMask(boolean z) {
        this.mMask = z;
    }

    public void setText(CharSequence charSequence) {
        if (this.mNextView instanceof TextView) {
            ((TextView) this.mNextView).setText(charSequence);
        }
    }

    public void setText(@StringRes int i) {
        if (this.mNextView instanceof TextView) {
            ((TextView) this.mNextView).setText(i);
        }
    }

    public void setDuration(int i) {
        if (i <= 0) {
            i = 2;
        }
        this.mDuration = i;
    }

    public void setMargin(float f, float f2) {
        if (this.mWinParams != null) {
            this.mWinParams.verticalMargin = f2;
            this.mWinParams.horizontalMargin = f;
        }
    }

    public void setWindowParams(@NonNull WindowManager.LayoutParams layoutParams) {
        this.mWinParams = layoutParams;
    }

    public void setWindowAnimation(@StyleRes int i) {
        if (this.mWinParams != null) {
            this.mWinParams.windowAnimations = i;
        }
    }

    public void setWindowType(int i) {
        if (this.mWinParams != null) {
            this.mWinParams.type = i;
        }
    }

    public void setGravity(int i, int i2, int i3) {
        if (this.mWinParams != null) {
            this.mWinParams.gravity = i;
            this.mWinParams.x = i2;
            this.mWinParams.y = i3;
        }
    }

    public void setOnClick(@Nullable final UniversalToast.ToastCallback toastCallback) {
        if (this.mNextView != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.android.ext.widget.toast.ToastCustom.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (toastCallback != null) {
                        toastCallback.onToastClick();
                    }
                    ToastCustom.this.cancel();
                }
            };
            this.mNextView.setClickable(true);
            View findViewById = this.mNextView.findViewById(R.id.clickable_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(onClickListener);
            } else {
                this.mNextView.setOnClickListener(onClickListener);
            }
        }
    }

    public void show() {
        if (this.mShowRunnable != null) {
            this.mHandler.removeCallbacks(this.mShowRunnable);
        }
        this.mShowRunnable = new Runnable() { // from class: com.baidu.android.ext.widget.toast.ToastCustom.3
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                try {
                    if (ToastCustom.this.mMask) {
                        if (ToastCustom.this.mMaskView != null && (ToastCustom.this.mMaskView.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) ToastCustom.this.mMaskView.getParent()).removeView(ToastCustom.this.mMaskView);
                        }
                        WindowManager.LayoutParams createMaskParams = ToastCustom.this.createMaskParams();
                        ToastCustom.this.mNextMaskView = new FrameLayout(ToastCustom.this.mContext);
                        ToastCustom.this.mNextMaskView.setClickable(true);
                        ToastCustom.this.mWM.addView(ToastCustom.this.mNextMaskView, createMaskParams);
                        ToastCustom.this.mMaskView = ToastCustom.this.mNextMaskView;
                    }
                    if (ToastCustom.this.mNextView != null && (ToastCustom.this.mNextView.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) ToastCustom.this.mNextView.getParent()).removeView(ToastCustom.this.mNextView);
                    }
                    ToastCustom.this.mWM.addView(ToastCustom.this.mNextView, ToastCustom.this.mWinParams);
                    ToastCustom.this.mView = ToastCustom.this.mNextView;
                    ToastCustom.this.mHandler.postDelayed(ToastCustom.this.mCancelRunnable, ToastCustom.this.mDuration * 1000);
                    if (ToastCustom.this.mIsDebug) {
                        Log.d(ToastCustom.TAG, "add mView");
                    }
                } finally {
                    if (z) {
                    }
                }
            }
        };
        this.mHandler.post(this.mShowRunnable);
    }

    public void cancel() {
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.android.ext.widget.toast.ToastCustom.4
                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    try {
                        if (ToastCustom.this.mView != null) {
                            if (ToastCustom.this.mView.getParent() != null) {
                                ToastCustom.this.mWM.removeViewImmediate(ToastCustom.this.mView);
                            }
                            if (ToastCustom.this.onDismissListener != null) {
                                ToastCustom.this.onDismissListener.onDismiss();
                                ToastCustom.this.onDismissListener = null;
                            }
                            if (ToastCustom.this.mIsDebug) {
                                Log.d(ToastCustom.TAG, "remove mView");
                            }
                            ToastCustom.this.mView = null;
                        }
                        if (ToastCustom.this.mMaskView != null) {
                            if (ToastCustom.this.mMaskView.getParent() != null) {
                                ToastCustom.this.mWM.removeViewImmediate(ToastCustom.this.mMaskView);
                            }
                            if (ToastCustom.this.mIsDebug) {
                                Log.d(ToastCustom.TAG, "remove mMaskView");
                            }
                            ToastCustom.this.mMaskView = null;
                        }
                    } finally {
                        if (z) {
                        }
                    }
                }
            });
            this.mHandler.removeCallbacks(this.mCancelRunnable);
            if (this.mIsDebug) {
                Log.d(TAG, "cancel");
            }
        }
    }

    public void setOnDissmissListener(UniversalToast.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindowManager.LayoutParams createMaskParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.verticalMargin = UniversalToast.getSwanAppStatusBarAndActionBarHeight(this.mContext);
        layoutParams.flags = 2176;
        layoutParams.type = 2005;
        return layoutParams;
    }
}
