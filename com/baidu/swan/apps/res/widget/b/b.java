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
    private WindowManager aPT;
    private View aPU;
    private boolean aPX;
    private View aPY;
    private boolean azt;
    private Context mContext;
    private volatile int mDuration;
    private View mMaskView;
    private Runnable mShowRunnable;
    private View mView;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable aPW = new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mView != null) {
                if (b.this.mView.getParent() != null) {
                    b.this.aPT.removeView(b.this.mView);
                }
                b.this.mView = null;
            }
            if (b.this.mMaskView != null) {
                if (b.this.mMaskView.getParent() != null) {
                    b.this.aPT.removeView(b.this.mMaskView);
                }
                b.this.mMaskView = null;
            }
        }
    };
    private WindowManager.LayoutParams aPV = new WindowManager.LayoutParams();

    public b(Context context) {
        this.mContext = context;
        this.aPT = (WindowManager) this.mContext.getSystemService("window");
        this.aPV.height = -2;
        this.aPV.width = -2;
        this.aPV.format = -3;
        this.aPV.windowAnimations = a.i.toast_animation;
        this.aPV.type = 2005;
        this.aPV.setTitle("Toast");
        this.aPV.flags = 168;
        this.aPV.gravity = 81;
        this.aPV.y = -30;
        this.mDuration = 2;
        this.azt = com.baidu.swan.apps.b.DEBUG;
    }

    public void setView(@NonNull View view) {
        this.aPU = view;
        this.aPU.setClickable(true);
    }

    public void setMask(boolean z) {
        this.aPX = z;
    }

    public void setDuration(int i) {
        if (i <= 0) {
            i = 2;
        }
        this.mDuration = i;
    }

    public void dD(@StyleRes int i) {
        if (this.aPV != null) {
            this.aPV.windowAnimations = i;
        }
    }

    public void dE(int i) {
        if (this.aPV != null) {
            this.aPV.type = i;
        }
    }

    public void setGravity(int i, int i2, int i3) {
        if (this.aPV != null) {
            this.aPV.gravity = i;
            this.aPV.x = i2;
            this.aPV.y = i3;
        }
    }

    public void a(@Nullable final d.a aVar) {
        if (this.aPU != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.LX();
                    }
                    b.this.cancel();
                }
            };
            this.aPU.setClickable(true);
            View findViewById = this.aPU.findViewById(a.f.clickable_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(onClickListener);
            } else {
                this.aPU.setOnClickListener(onClickListener);
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
                    if (b.this.aPX) {
                        if (b.this.mMaskView != null && (b.this.mMaskView.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) b.this.mMaskView.getParent()).removeView(b.this.mMaskView);
                        }
                        WindowManager.LayoutParams LJ = b.this.LJ();
                        b.this.aPY = new FrameLayout(b.this.mContext);
                        b.this.aPY.setClickable(true);
                        b.this.aPT.addView(b.this.aPY, LJ);
                        b.this.mMaskView = b.this.aPY;
                    }
                    if (b.this.aPU != null && (b.this.aPU.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) b.this.aPU.getParent()).removeView(b.this.aPU);
                    }
                    b.this.aPT.addView(b.this.aPU, b.this.aPV);
                    b.this.mView = b.this.aPU;
                    b.this.mHandler.postDelayed(b.this.aPW, b.this.mDuration * 1000);
                    if (b.this.azt) {
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
                                b.this.aPT.removeViewImmediate(b.this.mView);
                            }
                            if (b.this.azt) {
                                Log.d("ToastCustom", "remove mView");
                            }
                            b.this.mView = null;
                        }
                        if (b.this.mMaskView != null) {
                            if (b.this.mMaskView.getParent() != null) {
                                b.this.aPT.removeViewImmediate(b.this.mMaskView);
                            }
                            if (b.this.azt) {
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
            this.mHandler.removeCallbacks(this.aPW);
            if (this.azt) {
                Log.d("ToastCustom", "cancel");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindowManager.LayoutParams LJ() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.verticalMargin = d.bx(this.mContext);
        layoutParams.flags = 2176;
        layoutParams.type = 2005;
        return layoutParams;
    }
}
