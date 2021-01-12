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
    private static final boolean dBc = com.baidu.swan.apps.b.DEBUG;
    private View dBd;
    private boolean dBg;
    private View dBh;
    private Context mContext;
    private volatile int mDuration;
    private View mMaskView;
    private Runnable mShowRunnable;
    private View mView;
    private WindowManager mWM;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable dBf = new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.b.1
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
    private WindowManager.LayoutParams dBe = new WindowManager.LayoutParams();

    public b(Context context) {
        this.mContext = context;
        this.mWM = (WindowManager) this.mContext.getSystemService("window");
        this.dBe.height = -2;
        this.dBe.width = -2;
        this.dBe.format = -3;
        this.dBe.windowAnimations = a.i.toast_animation;
        this.dBe.type = 2005;
        this.dBe.setTitle("Toast");
        this.dBe.flags = 168;
        this.dBe.gravity = 81;
        this.dBe.y = -30;
        this.mDuration = 2;
    }

    public void setView(@NonNull View view) {
        this.dBd = view;
        this.dBd.setClickable(true);
    }

    public void setMask(boolean z) {
        this.dBg = z;
    }

    public void setDuration(int i) {
        if (i <= 0) {
            i = 2;
        }
        this.mDuration = i;
    }

    public void ja(@StyleRes int i) {
        if (this.dBe != null) {
            this.dBe.windowAnimations = i;
        }
    }

    public void jb(int i) {
        if (this.dBe != null) {
            this.dBe.type = i;
        }
    }

    public void setGravity(int i, int i2, int i3) {
        if (this.dBe != null) {
            this.dBe.gravity = i;
            this.dBe.x = i2;
            this.dBe.y = i3;
        }
    }

    public void a(@Nullable final d.a aVar) {
        if (this.dBd != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.afT();
                    }
                    b.this.cancel();
                }
            };
            this.dBd.setClickable(true);
            View findViewById = this.dBd.findViewById(a.f.clickable_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(onClickListener);
            } else {
                this.dBd.setOnClickListener(onClickListener);
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
                    if (b.this.dBg) {
                        if (b.this.mMaskView != null && (b.this.mMaskView.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) b.this.mMaskView.getParent()).removeView(b.this.mMaskView);
                        }
                        WindowManager.LayoutParams aHR = b.this.aHR();
                        b.this.dBh = new FrameLayout(b.this.mContext);
                        b.this.dBh.setClickable(true);
                        b.this.mWM.addView(b.this.dBh, aHR);
                        b.this.mMaskView = b.this.dBh;
                    }
                    if (b.this.dBd != null && (b.this.dBd.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) b.this.dBd.getParent()).removeView(b.this.dBd);
                    }
                    b.this.mWM.addView(b.this.dBd, b.this.dBe);
                    b.this.mView = b.this.dBd;
                    b.this.mHandler.postDelayed(b.this.dBf, b.this.mDuration * 1000);
                    if (b.dBc) {
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
                            if (b.dBc) {
                                Log.d("ToastCustom", "remove mView");
                            }
                            b.this.mView = null;
                        }
                        if (b.this.mMaskView != null) {
                            if (b.this.mMaskView.getParent() != null) {
                                b.this.mWM.removeViewImmediate(b.this.mMaskView);
                            }
                            if (b.dBc) {
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
            this.mHandler.removeCallbacks(this.dBf);
            if (dBc) {
                Log.d("ToastCustom", "cancel");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindowManager.LayoutParams aHR() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.verticalMargin = d.m27do(this.mContext);
        layoutParams.flags = 2176;
        layoutParams.type = 2005;
        return layoutParams;
    }
}
