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
    private WindowManager aQr;
    private View aQs;
    private boolean aQv;
    private View aQw;
    private boolean azR;
    private Context mContext;
    private volatile int mDuration;
    private View mMaskView;
    private Runnable mShowRunnable;
    private View mView;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable aQu = new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mView != null) {
                if (b.this.mView.getParent() != null) {
                    b.this.aQr.removeView(b.this.mView);
                }
                b.this.mView = null;
            }
            if (b.this.mMaskView != null) {
                if (b.this.mMaskView.getParent() != null) {
                    b.this.aQr.removeView(b.this.mMaskView);
                }
                b.this.mMaskView = null;
            }
        }
    };
    private WindowManager.LayoutParams aQt = new WindowManager.LayoutParams();

    public b(Context context) {
        this.mContext = context;
        this.aQr = (WindowManager) this.mContext.getSystemService("window");
        this.aQt.height = -2;
        this.aQt.width = -2;
        this.aQt.format = -3;
        this.aQt.windowAnimations = a.i.toast_animation;
        this.aQt.type = 2005;
        this.aQt.setTitle("Toast");
        this.aQt.flags = 168;
        this.aQt.gravity = 81;
        this.aQt.y = -30;
        this.mDuration = 2;
        this.azR = com.baidu.swan.apps.b.DEBUG;
    }

    public void setView(@NonNull View view) {
        this.aQs = view;
        this.aQs.setClickable(true);
    }

    public void setMask(boolean z) {
        this.aQv = z;
    }

    public void setDuration(int i) {
        if (i <= 0) {
            i = 2;
        }
        this.mDuration = i;
    }

    public void dE(@StyleRes int i) {
        if (this.aQt != null) {
            this.aQt.windowAnimations = i;
        }
    }

    public void dF(int i) {
        if (this.aQt != null) {
            this.aQt.type = i;
        }
    }

    public void setGravity(int i, int i2, int i3) {
        if (this.aQt != null) {
            this.aQt.gravity = i;
            this.aQt.x = i2;
            this.aQt.y = i3;
        }
    }

    public void a(@Nullable final d.a aVar) {
        if (this.aQs != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.Mb();
                    }
                    b.this.cancel();
                }
            };
            this.aQs.setClickable(true);
            View findViewById = this.aQs.findViewById(a.f.clickable_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(onClickListener);
            } else {
                this.aQs.setOnClickListener(onClickListener);
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
                    if (b.this.aQv) {
                        if (b.this.mMaskView != null && (b.this.mMaskView.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) b.this.mMaskView.getParent()).removeView(b.this.mMaskView);
                        }
                        WindowManager.LayoutParams LN = b.this.LN();
                        b.this.aQw = new FrameLayout(b.this.mContext);
                        b.this.aQw.setClickable(true);
                        b.this.aQr.addView(b.this.aQw, LN);
                        b.this.mMaskView = b.this.aQw;
                    }
                    if (b.this.aQs != null && (b.this.aQs.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) b.this.aQs.getParent()).removeView(b.this.aQs);
                    }
                    b.this.aQr.addView(b.this.aQs, b.this.aQt);
                    b.this.mView = b.this.aQs;
                    b.this.mHandler.postDelayed(b.this.aQu, b.this.mDuration * 1000);
                    if (b.this.azR) {
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
                                b.this.aQr.removeViewImmediate(b.this.mView);
                            }
                            if (b.this.azR) {
                                Log.d("ToastCustom", "remove mView");
                            }
                            b.this.mView = null;
                        }
                        if (b.this.mMaskView != null) {
                            if (b.this.mMaskView.getParent() != null) {
                                b.this.aQr.removeViewImmediate(b.this.mMaskView);
                            }
                            if (b.this.azR) {
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
            this.mHandler.removeCallbacks(this.aQu);
            if (this.azR) {
                Log.d("ToastCustom", "cancel");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindowManager.LayoutParams LN() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.verticalMargin = d.bx(this.mContext);
        layoutParams.flags = 2176;
        layoutParams.type = 2005;
        return layoutParams;
    }
}
