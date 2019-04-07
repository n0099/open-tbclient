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
    private WindowManager aNf;
    private View aNg;
    private boolean aNj;
    private View aNk;
    private boolean axV;
    private Context mContext;
    private volatile int mDuration;
    private View mMaskView;
    private Runnable mShowRunnable;
    private View mView;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable aNi = new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mView != null) {
                if (b.this.mView.getParent() != null) {
                    b.this.aNf.removeView(b.this.mView);
                }
                b.this.mView = null;
            }
            if (b.this.mMaskView != null) {
                if (b.this.mMaskView.getParent() != null) {
                    b.this.aNf.removeView(b.this.mMaskView);
                }
                b.this.mMaskView = null;
            }
        }
    };
    private WindowManager.LayoutParams aNh = new WindowManager.LayoutParams();

    public b(Context context) {
        this.mContext = context;
        this.aNf = (WindowManager) this.mContext.getSystemService("window");
        this.aNh.height = -2;
        this.aNh.width = -2;
        this.aNh.format = -3;
        this.aNh.windowAnimations = a.i.toast_animation;
        this.aNh.type = 2005;
        this.aNh.setTitle("Toast");
        this.aNh.flags = 168;
        this.aNh.gravity = 81;
        this.aNh.y = -30;
        this.mDuration = 2;
        this.axV = com.baidu.swan.apps.b.DEBUG;
    }

    public void setView(@NonNull View view) {
        this.aNg = view;
        this.aNg.setClickable(true);
    }

    public void setMask(boolean z) {
        this.aNj = z;
    }

    public void setDuration(int i) {
        if (i <= 0) {
            i = 2;
        }
        this.mDuration = i;
    }

    public void dp(@StyleRes int i) {
        if (this.aNh != null) {
            this.aNh.windowAnimations = i;
        }
    }

    public void dq(int i) {
        if (this.aNh != null) {
            this.aNh.type = i;
        }
    }

    public void setGravity(int i, int i2, int i3) {
        if (this.aNh != null) {
            this.aNh.gravity = i;
            this.aNh.x = i2;
            this.aNh.y = i3;
        }
    }

    public void a(@Nullable final d.a aVar) {
        if (this.aNg != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.IP();
                    }
                    b.this.cancel();
                }
            };
            this.aNg.setClickable(true);
            View findViewById = this.aNg.findViewById(a.f.clickable_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(onClickListener);
            } else {
                this.aNg.setOnClickListener(onClickListener);
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
                    if (b.this.aNj) {
                        if (b.this.mMaskView != null && (b.this.mMaskView.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) b.this.mMaskView.getParent()).removeView(b.this.mMaskView);
                        }
                        WindowManager.LayoutParams IB = b.this.IB();
                        b.this.aNk = new FrameLayout(b.this.mContext);
                        b.this.aNk.setClickable(true);
                        b.this.aNf.addView(b.this.aNk, IB);
                        b.this.mMaskView = b.this.aNk;
                    }
                    if (b.this.aNg != null && (b.this.aNg.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) b.this.aNg.getParent()).removeView(b.this.aNg);
                    }
                    b.this.aNf.addView(b.this.aNg, b.this.aNh);
                    b.this.mView = b.this.aNg;
                    b.this.mHandler.postDelayed(b.this.aNi, b.this.mDuration * 1000);
                    if (b.this.axV) {
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
                                b.this.aNf.removeViewImmediate(b.this.mView);
                            }
                            if (b.this.axV) {
                                Log.d("ToastCustom", "remove mView");
                            }
                            b.this.mView = null;
                        }
                        if (b.this.mMaskView != null) {
                            if (b.this.mMaskView.getParent() != null) {
                                b.this.aNf.removeViewImmediate(b.this.mMaskView);
                            }
                            if (b.this.axV) {
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
            this.mHandler.removeCallbacks(this.aNi);
            if (this.axV) {
                Log.d("ToastCustom", "cancel");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindowManager.LayoutParams IB() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.verticalMargin = d.bY(this.mContext);
        layoutParams.flags = 2176;
        layoutParams.type = 2005;
        return layoutParams;
    }
}
