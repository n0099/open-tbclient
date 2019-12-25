package com.baidu.swan.apps.res.widget.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.b.d;
/* loaded from: classes9.dex */
public class b {
    private static final boolean mIsDebug = com.baidu.swan.apps.b.DEBUG;
    private Context mContext;
    private volatile int mDuration;
    private boolean mMask;
    private View mMaskView;
    private View mNextMaskView;
    private View mNextView;
    private Runnable mShowRunnable;
    private View mView;
    private WindowManager mWM;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mCancelRunnable = new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mView != null) {
                if (b.this.mView.getParent() != null) {
                    b.this.mWM.removeView(b.this.mView);
                }
                b.this.mView = null;
            }
            if (b.this.mMaskView != null) {
                if (b.this.mMaskView.getParent() != null) {
                    b.this.mWM.removeView(b.this.mMaskView);
                }
                b.this.mMaskView = null;
            }
        }
    };
    private WindowManager.LayoutParams mWinParams = new WindowManager.LayoutParams();

    public b(Context context) {
        this.mContext = context;
        this.mWM = (WindowManager) this.mContext.getSystemService("window");
        this.mWinParams.height = -2;
        this.mWinParams.width = -2;
        this.mWinParams.format = -3;
        this.mWinParams.windowAnimations = a.i.toast_animation;
        this.mWinParams.type = 2005;
        this.mWinParams.setTitle("Toast");
        this.mWinParams.flags = 168;
        this.mWinParams.gravity = 81;
        this.mWinParams.y = -30;
        this.mDuration = 2;
    }

    public void setView(@NonNull View view) {
        this.mNextView = view;
        this.mNextView.setClickable(true);
    }

    public void setMask(boolean z) {
        this.mMask = z;
    }

    public void setDuration(int i) {
        if (i <= 0) {
            i = 2;
        }
        this.mDuration = i;
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

    public void a(@Nullable final d.a aVar) {
        if (this.mNextView != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.onToastClick();
                    }
                    b.this.cancel();
                }
            };
            this.mNextView.setClickable(true);
            View findViewById = this.mNextView.findViewById(a.f.clickable_toast_click_area);
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
        this.mShowRunnable = new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.b.3
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                try {
                    if (b.this.mMask) {
                        if (b.this.mMaskView != null && (b.this.mMaskView.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) b.this.mMaskView.getParent()).removeView(b.this.mMaskView);
                        }
                        WindowManager.LayoutParams createMaskParams = b.this.createMaskParams();
                        b.this.mNextMaskView = new FrameLayout(b.this.mContext);
                        b.this.mNextMaskView.setClickable(true);
                        b.this.mWM.addView(b.this.mNextMaskView, createMaskParams);
                        b.this.mMaskView = b.this.mNextMaskView;
                    }
                    if (b.this.mNextView != null && (b.this.mNextView.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) b.this.mNextView.getParent()).removeView(b.this.mNextView);
                    }
                    b.this.mWM.addView(b.this.mNextView, b.this.mWinParams);
                    b.this.mView = b.this.mNextView;
                    b.this.mHandler.postDelayed(b.this.mCancelRunnable, b.this.mDuration * 1000);
                    if (b.mIsDebug) {
                        Log.d("ToastCustom", "add mView");
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
            this.mHandler.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.b.4
                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    try {
                        if (b.this.mView != null) {
                            if (b.this.mView.getParent() != null) {
                                b.this.mWM.removeViewImmediate(b.this.mView);
                            }
                            if (b.mIsDebug) {
                                Log.d("ToastCustom", "remove mView");
                            }
                            b.this.mView = null;
                        }
                        if (b.this.mMaskView != null) {
                            if (b.this.mMaskView.getParent() != null) {
                                b.this.mWM.removeViewImmediate(b.this.mMaskView);
                            }
                            if (b.mIsDebug) {
                                Log.d("ToastCustom", "remove mMaskView");
                            }
                            b.this.mMaskView = null;
                        }
                    } finally {
                        if (z) {
                        }
                    }
                }
            });
            this.mHandler.removeCallbacks(this.mCancelRunnable);
            if (mIsDebug) {
                Log.d("ToastCustom", UgcUBCUtils.UGC_TIME_CANCEL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindowManager.LayoutParams createMaskParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.verticalMargin = d.getSwanAppStatusBarAndActionBarHeight(this.mContext);
        layoutParams.flags = 2176;
        layoutParams.type = 2005;
        return layoutParams;
    }
}
