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
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.b.d;
/* loaded from: classes2.dex */
public class b {
    private boolean aTf;
    private View bjA;
    private WindowManager bjv;
    private View bjw;
    private boolean bjz;
    private Context mContext;
    private volatile int mDuration;
    private View mMaskView;
    private Runnable mShowRunnable;
    private View mView;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable bjy = new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mView != null) {
                if (b.this.mView.getParent() != null) {
                    b.this.bjv.removeView(b.this.mView);
                }
                b.this.mView = null;
            }
            if (b.this.mMaskView != null) {
                if (b.this.mMaskView.getParent() != null) {
                    b.this.bjv.removeView(b.this.mMaskView);
                }
                b.this.mMaskView = null;
            }
        }
    };
    private WindowManager.LayoutParams bjx = new WindowManager.LayoutParams();

    public b(Context context) {
        this.mContext = context;
        this.bjv = (WindowManager) this.mContext.getSystemService("window");
        this.bjx.height = -2;
        this.bjx.width = -2;
        this.bjx.format = -3;
        this.bjx.windowAnimations = a.i.toast_animation;
        this.bjx.type = 2005;
        this.bjx.setTitle("Toast");
        this.bjx.flags = 168;
        this.bjx.gravity = 81;
        this.bjx.y = -30;
        this.mDuration = 2;
        this.aTf = com.baidu.swan.apps.b.DEBUG;
    }

    public void setView(@NonNull View view) {
        this.bjw = view;
        this.bjw.setClickable(true);
    }

    public void setMask(boolean z) {
        this.bjz = z;
    }

    public void setDuration(int i) {
        if (i <= 0) {
            i = 2;
        }
        this.mDuration = i;
    }

    public void ez(@StyleRes int i) {
        if (this.bjx != null) {
            this.bjx.windowAnimations = i;
        }
    }

    public void eA(int i) {
        if (this.bjx != null) {
            this.bjx.type = i;
        }
    }

    public void setGravity(int i, int i2, int i3) {
        if (this.bjx != null) {
            this.bjx.gravity = i;
            this.bjx.x = i2;
            this.bjx.y = i3;
        }
    }

    public void a(@Nullable final d.a aVar) {
        if (this.bjw != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.QT();
                    }
                    b.this.cancel();
                }
            };
            this.bjw.setClickable(true);
            View findViewById = this.bjw.findViewById(a.f.clickable_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(onClickListener);
            } else {
                this.bjw.setOnClickListener(onClickListener);
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
                    if (b.this.bjz) {
                        if (b.this.mMaskView != null && (b.this.mMaskView.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) b.this.mMaskView.getParent()).removeView(b.this.mMaskView);
                        }
                        WindowManager.LayoutParams QG = b.this.QG();
                        b.this.bjA = new FrameLayout(b.this.mContext);
                        b.this.bjA.setClickable(true);
                        b.this.bjv.addView(b.this.bjA, QG);
                        b.this.mMaskView = b.this.bjA;
                    }
                    if (b.this.bjw != null && (b.this.bjw.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) b.this.bjw.getParent()).removeView(b.this.bjw);
                    }
                    b.this.bjv.addView(b.this.bjw, b.this.bjx);
                    b.this.mView = b.this.bjw;
                    b.this.mHandler.postDelayed(b.this.bjy, b.this.mDuration * 1000);
                    if (b.this.aTf) {
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
                                b.this.bjv.removeViewImmediate(b.this.mView);
                            }
                            if (b.this.aTf) {
                                Log.d("ToastCustom", "remove mView");
                            }
                            b.this.mView = null;
                        }
                        if (b.this.mMaskView != null) {
                            if (b.this.mMaskView.getParent() != null) {
                                b.this.bjv.removeViewImmediate(b.this.mMaskView);
                            }
                            if (b.this.aTf) {
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
            this.mHandler.removeCallbacks(this.bjy);
            if (this.aTf) {
                Log.d("ToastCustom", "cancel");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindowManager.LayoutParams QG() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.verticalMargin = d.by(this.mContext);
        layoutParams.flags = 2176;
        layoutParams.type = 2005;
        return layoutParams;
    }
}
