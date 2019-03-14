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
    private WindowManager aNc;
    private View aNd;
    private boolean aNg;
    private View aNh;
    private boolean axS;
    private Context mContext;
    private volatile int mDuration;
    private View mMaskView;
    private Runnable mShowRunnable;
    private View mView;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable aNf = new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mView != null) {
                if (b.this.mView.getParent() != null) {
                    b.this.aNc.removeView(b.this.mView);
                }
                b.this.mView = null;
            }
            if (b.this.mMaskView != null) {
                if (b.this.mMaskView.getParent() != null) {
                    b.this.aNc.removeView(b.this.mMaskView);
                }
                b.this.mMaskView = null;
            }
        }
    };
    private WindowManager.LayoutParams aNe = new WindowManager.LayoutParams();

    public b(Context context) {
        this.mContext = context;
        this.aNc = (WindowManager) this.mContext.getSystemService("window");
        this.aNe.height = -2;
        this.aNe.width = -2;
        this.aNe.format = -3;
        this.aNe.windowAnimations = a.i.toast_animation;
        this.aNe.type = 2005;
        this.aNe.setTitle("Toast");
        this.aNe.flags = 168;
        this.aNe.gravity = 81;
        this.aNe.y = -30;
        this.mDuration = 2;
        this.axS = com.baidu.swan.apps.b.DEBUG;
    }

    public void setView(@NonNull View view) {
        this.aNd = view;
        this.aNd.setClickable(true);
    }

    public void setMask(boolean z) {
        this.aNg = z;
    }

    public void setDuration(int i) {
        if (i <= 0) {
            i = 2;
        }
        this.mDuration = i;
    }

    public void dq(@StyleRes int i) {
        if (this.aNe != null) {
            this.aNe.windowAnimations = i;
        }
    }

    public void dr(int i) {
        if (this.aNe != null) {
            this.aNe.type = i;
        }
    }

    public void setGravity(int i, int i2, int i3) {
        if (this.aNe != null) {
            this.aNe.gravity = i;
            this.aNe.x = i2;
            this.aNe.y = i3;
        }
    }

    public void a(@Nullable final d.a aVar) {
        if (this.aNd != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.IR();
                    }
                    b.this.cancel();
                }
            };
            this.aNd.setClickable(true);
            View findViewById = this.aNd.findViewById(a.f.clickable_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(onClickListener);
            } else {
                this.aNd.setOnClickListener(onClickListener);
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
                    if (b.this.aNg) {
                        if (b.this.mMaskView != null && (b.this.mMaskView.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) b.this.mMaskView.getParent()).removeView(b.this.mMaskView);
                        }
                        WindowManager.LayoutParams ID = b.this.ID();
                        b.this.aNh = new FrameLayout(b.this.mContext);
                        b.this.aNh.setClickable(true);
                        b.this.aNc.addView(b.this.aNh, ID);
                        b.this.mMaskView = b.this.aNh;
                    }
                    if (b.this.aNd != null && (b.this.aNd.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) b.this.aNd.getParent()).removeView(b.this.aNd);
                    }
                    b.this.aNc.addView(b.this.aNd, b.this.aNe);
                    b.this.mView = b.this.aNd;
                    b.this.mHandler.postDelayed(b.this.aNf, b.this.mDuration * 1000);
                    if (b.this.axS) {
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
                                b.this.aNc.removeViewImmediate(b.this.mView);
                            }
                            if (b.this.axS) {
                                Log.d("ToastCustom", "remove mView");
                            }
                            b.this.mView = null;
                        }
                        if (b.this.mMaskView != null) {
                            if (b.this.mMaskView.getParent() != null) {
                                b.this.aNc.removeViewImmediate(b.this.mMaskView);
                            }
                            if (b.this.axS) {
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
            this.mHandler.removeCallbacks(this.aNf);
            if (this.axS) {
                Log.d("ToastCustom", "cancel");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindowManager.LayoutParams ID() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.verticalMargin = d.bY(this.mContext);
        layoutParams.flags = 2176;
        layoutParams.type = 2005;
        return layoutParams;
    }
}
