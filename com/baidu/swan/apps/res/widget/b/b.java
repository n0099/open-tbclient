package com.baidu.swan.apps.res.widget.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.b.d;
/* loaded from: classes9.dex */
public class b {
    private static final boolean mIsDebug = com.baidu.swan.apps.b.DEBUG;
    private View dDh;
    private boolean dDk;
    private View dDl;
    private Context mContext;
    private volatile int mDuration;
    private View mMaskView;
    private Runnable mShowRunnable;
    private View mView;
    private WindowManager mWM;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable dDj = new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.b.1
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
    private WindowManager.LayoutParams dDi = new WindowManager.LayoutParams();

    public b(Context context) {
        this.mContext = context;
        this.mWM = (WindowManager) this.mContext.getSystemService("window");
        this.dDi.height = -2;
        this.dDi.width = -2;
        this.dDi.format = -3;
        this.dDi.windowAnimations = a.i.toast_animation;
        this.dDi.type = 2005;
        this.dDi.setTitle("Toast");
        this.dDi.flags = 168;
        this.dDi.gravity = 81;
        this.dDi.y = -30;
        this.mDuration = 2;
    }

    public void setView(@NonNull View view) {
        this.dDh = view;
        this.dDh.setClickable(true);
    }

    public void setMask(boolean z) {
        this.dDk = z;
    }

    public void setDuration(int i) {
        if (i <= 0) {
            i = 2;
        }
        this.mDuration = i;
    }

    public void jd(@StyleRes int i) {
        if (this.dDi != null) {
            this.dDi.windowAnimations = i;
        }
    }

    public void je(int i) {
        if (this.dDi != null) {
            this.dDi.type = i;
        }
    }

    public void setGravity(int i, int i2, int i3) {
        if (this.dDi != null) {
            this.dDi.gravity = i;
            this.dDi.x = i2;
            this.dDi.y = i3;
        }
    }

    public void a(@Nullable final d.a aVar) {
        if (this.dDh != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.agr();
                    }
                    b.this.cancel();
                }
            };
            this.dDh.setClickable(true);
            View findViewById = this.dDh.findViewById(a.f.clickable_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(onClickListener);
            } else {
                this.dDh.setOnClickListener(onClickListener);
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
                    if (b.this.dDk) {
                        if (b.this.mMaskView != null && (b.this.mMaskView.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) b.this.mMaskView.getParent()).removeView(b.this.mMaskView);
                        }
                        WindowManager.LayoutParams aIk = b.this.aIk();
                        b.this.dDl = new FrameLayout(b.this.mContext);
                        b.this.dDl.setClickable(true);
                        b.this.mWM.addView(b.this.dDl, aIk);
                        b.this.mMaskView = b.this.dDl;
                    }
                    if (b.this.dDh != null && (b.this.dDh.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) b.this.dDh.getParent()).removeView(b.this.dDh);
                    }
                    b.this.mWM.addView(b.this.dDh, b.this.dDi);
                    b.this.mView = b.this.dDh;
                    b.this.mHandler.postDelayed(b.this.dDj, b.this.mDuration * 1000);
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
            this.mHandler.removeCallbacks(this.dDj);
            if (mIsDebug) {
                Log.d("ToastCustom", "cancel");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindowManager.LayoutParams aIk() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.verticalMargin = d.dn(this.mContext);
        layoutParams.flags = 2176;
        layoutParams.type = 2005;
        return layoutParams;
    }
}
