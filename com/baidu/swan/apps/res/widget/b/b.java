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
    private boolean aSN;
    private WindowManager bjd;
    private View bje;
    private boolean bjh;
    private View bji;
    private Context mContext;
    private volatile int mDuration;
    private View mMaskView;
    private Runnable mShowRunnable;
    private View mView;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable bjg = new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mView != null) {
                if (b.this.mView.getParent() != null) {
                    b.this.bjd.removeView(b.this.mView);
                }
                b.this.mView = null;
            }
            if (b.this.mMaskView != null) {
                if (b.this.mMaskView.getParent() != null) {
                    b.this.bjd.removeView(b.this.mMaskView);
                }
                b.this.mMaskView = null;
            }
        }
    };
    private WindowManager.LayoutParams bjf = new WindowManager.LayoutParams();

    public b(Context context) {
        this.mContext = context;
        this.bjd = (WindowManager) this.mContext.getSystemService("window");
        this.bjf.height = -2;
        this.bjf.width = -2;
        this.bjf.format = -3;
        this.bjf.windowAnimations = a.i.toast_animation;
        this.bjf.type = 2005;
        this.bjf.setTitle("Toast");
        this.bjf.flags = 168;
        this.bjf.gravity = 81;
        this.bjf.y = -30;
        this.mDuration = 2;
        this.aSN = com.baidu.swan.apps.b.DEBUG;
    }

    public void setView(@NonNull View view) {
        this.bje = view;
        this.bje.setClickable(true);
    }

    public void setMask(boolean z) {
        this.bjh = z;
    }

    public void setDuration(int i) {
        if (i <= 0) {
            i = 2;
        }
        this.mDuration = i;
    }

    public void ez(@StyleRes int i) {
        if (this.bjf != null) {
            this.bjf.windowAnimations = i;
        }
    }

    public void eA(int i) {
        if (this.bjf != null) {
            this.bjf.type = i;
        }
    }

    public void setGravity(int i, int i2, int i3) {
        if (this.bjf != null) {
            this.bjf.gravity = i;
            this.bjf.x = i2;
            this.bjf.y = i3;
        }
    }

    public void a(@Nullable final d.a aVar) {
        if (this.bje != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.QU();
                    }
                    b.this.cancel();
                }
            };
            this.bje.setClickable(true);
            View findViewById = this.bje.findViewById(a.f.clickable_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(onClickListener);
            } else {
                this.bje.setOnClickListener(onClickListener);
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
                    if (b.this.bjh) {
                        if (b.this.mMaskView != null && (b.this.mMaskView.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) b.this.mMaskView.getParent()).removeView(b.this.mMaskView);
                        }
                        WindowManager.LayoutParams QH = b.this.QH();
                        b.this.bji = new FrameLayout(b.this.mContext);
                        b.this.bji.setClickable(true);
                        b.this.bjd.addView(b.this.bji, QH);
                        b.this.mMaskView = b.this.bji;
                    }
                    if (b.this.bje != null && (b.this.bje.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) b.this.bje.getParent()).removeView(b.this.bje);
                    }
                    b.this.bjd.addView(b.this.bje, b.this.bjf);
                    b.this.mView = b.this.bje;
                    b.this.mHandler.postDelayed(b.this.bjg, b.this.mDuration * 1000);
                    if (b.this.aSN) {
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
                                b.this.bjd.removeViewImmediate(b.this.mView);
                            }
                            if (b.this.aSN) {
                                Log.d("ToastCustom", "remove mView");
                            }
                            b.this.mView = null;
                        }
                        if (b.this.mMaskView != null) {
                            if (b.this.mMaskView.getParent() != null) {
                                b.this.bjd.removeViewImmediate(b.this.mMaskView);
                            }
                            if (b.this.aSN) {
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
            this.mHandler.removeCallbacks(this.bjg);
            if (this.aSN) {
                Log.d("ToastCustom", "cancel");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindowManager.LayoutParams QH() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.verticalMargin = d.by(this.mContext);
        layoutParams.flags = 2176;
        layoutParams.type = 2005;
        return layoutParams;
    }
}
