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
/* loaded from: classes8.dex */
public class b {
    private static final boolean mIsDebug = com.baidu.swan.apps.b.DEBUG;
    private View dEI;
    private boolean dEL;
    private View dEM;
    private Context mContext;
    private volatile int mDuration;
    private View mMaskView;
    private Runnable mShowRunnable;
    private View mView;
    private WindowManager mWM;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable dEK = new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.b.1
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
    private WindowManager.LayoutParams dEJ = new WindowManager.LayoutParams();

    public b(Context context) {
        this.mContext = context;
        this.mWM = (WindowManager) this.mContext.getSystemService("window");
        this.dEJ.height = -2;
        this.dEJ.width = -2;
        this.dEJ.format = -3;
        this.dEJ.windowAnimations = a.i.toast_animation;
        this.dEJ.type = 2005;
        this.dEJ.setTitle("Toast");
        this.dEJ.flags = 168;
        this.dEJ.gravity = 81;
        this.dEJ.y = -30;
        this.mDuration = 2;
    }

    public void setView(@NonNull View view) {
        this.dEI = view;
        this.dEI.setClickable(true);
    }

    public void setMask(boolean z) {
        this.dEL = z;
    }

    public void setDuration(int i) {
        if (i <= 0) {
            i = 2;
        }
        this.mDuration = i;
    }

    public void je(@StyleRes int i) {
        if (this.dEJ != null) {
            this.dEJ.windowAnimations = i;
        }
    }

    public void jf(int i) {
        if (this.dEJ != null) {
            this.dEJ.type = i;
        }
    }

    public void setGravity(int i, int i2, int i3) {
        if (this.dEJ != null) {
            this.dEJ.gravity = i;
            this.dEJ.x = i2;
            this.dEJ.y = i3;
        }
    }

    public void a(@Nullable final d.a aVar) {
        if (this.dEI != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.agu();
                    }
                    b.this.cancel();
                }
            };
            this.dEI.setClickable(true);
            View findViewById = this.dEI.findViewById(a.f.clickable_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(onClickListener);
            } else {
                this.dEI.setOnClickListener(onClickListener);
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
                    if (b.this.dEL) {
                        if (b.this.mMaskView != null && (b.this.mMaskView.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) b.this.mMaskView.getParent()).removeView(b.this.mMaskView);
                        }
                        WindowManager.LayoutParams aIn = b.this.aIn();
                        b.this.dEM = new FrameLayout(b.this.mContext);
                        b.this.dEM.setClickable(true);
                        b.this.mWM.addView(b.this.dEM, aIn);
                        b.this.mMaskView = b.this.dEM;
                    }
                    if (b.this.dEI != null && (b.this.dEI.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) b.this.dEI.getParent()).removeView(b.this.dEI);
                    }
                    b.this.mWM.addView(b.this.dEI, b.this.dEJ);
                    b.this.mView = b.this.dEI;
                    b.this.mHandler.postDelayed(b.this.dEK, b.this.mDuration * 1000);
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
            this.mHandler.removeCallbacks(this.dEK);
            if (mIsDebug) {
                Log.d("ToastCustom", "cancel");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindowManager.LayoutParams aIn() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.verticalMargin = d.dm(this.mContext);
        layoutParams.flags = 2176;
        layoutParams.type = 2005;
        return layoutParams;
    }
}
