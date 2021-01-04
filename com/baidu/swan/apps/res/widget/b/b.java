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
    private static final boolean dFO = com.baidu.swan.apps.b.DEBUG;
    private View dFP;
    private boolean dFS;
    private View dFT;
    private Context mContext;
    private volatile int mDuration;
    private View mMaskView;
    private Runnable mShowRunnable;
    private View mView;
    private WindowManager mWM;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable dFR = new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.b.1
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
    private WindowManager.LayoutParams dFQ = new WindowManager.LayoutParams();

    public b(Context context) {
        this.mContext = context;
        this.mWM = (WindowManager) this.mContext.getSystemService("window");
        this.dFQ.height = -2;
        this.dFQ.width = -2;
        this.dFQ.format = -3;
        this.dFQ.windowAnimations = a.i.toast_animation;
        this.dFQ.type = 2005;
        this.dFQ.setTitle("Toast");
        this.dFQ.flags = 168;
        this.dFQ.gravity = 81;
        this.dFQ.y = -30;
        this.mDuration = 2;
    }

    public void setView(@NonNull View view) {
        this.dFP = view;
        this.dFP.setClickable(true);
    }

    public void setMask(boolean z) {
        this.dFS = z;
    }

    public void setDuration(int i) {
        if (i <= 0) {
            i = 2;
        }
        this.mDuration = i;
    }

    public void kG(@StyleRes int i) {
        if (this.dFQ != null) {
            this.dFQ.windowAnimations = i;
        }
    }

    public void kH(int i) {
        if (this.dFQ != null) {
            this.dFQ.type = i;
        }
    }

    public void setGravity(int i, int i2, int i3) {
        if (this.dFQ != null) {
            this.dFQ.gravity = i;
            this.dFQ.x = i2;
            this.dFQ.y = i3;
        }
    }

    public void a(@Nullable final d.a aVar) {
        if (this.dFP != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.ajM();
                    }
                    b.this.cancel();
                }
            };
            this.dFP.setClickable(true);
            View findViewById = this.dFP.findViewById(a.f.clickable_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(onClickListener);
            } else {
                this.dFP.setOnClickListener(onClickListener);
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
                    if (b.this.dFS) {
                        if (b.this.mMaskView != null && (b.this.mMaskView.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) b.this.mMaskView.getParent()).removeView(b.this.mMaskView);
                        }
                        WindowManager.LayoutParams aLK = b.this.aLK();
                        b.this.dFT = new FrameLayout(b.this.mContext);
                        b.this.dFT.setClickable(true);
                        b.this.mWM.addView(b.this.dFT, aLK);
                        b.this.mMaskView = b.this.dFT;
                    }
                    if (b.this.dFP != null && (b.this.dFP.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) b.this.dFP.getParent()).removeView(b.this.dFP);
                    }
                    b.this.mWM.addView(b.this.dFP, b.this.dFQ);
                    b.this.mView = b.this.dFP;
                    b.this.mHandler.postDelayed(b.this.dFR, b.this.mDuration * 1000);
                    if (b.dFO) {
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
                            if (b.dFO) {
                                Log.d("ToastCustom", "remove mView");
                            }
                            b.this.mView = null;
                        }
                        if (b.this.mMaskView != null) {
                            if (b.this.mMaskView.getParent() != null) {
                                b.this.mWM.removeViewImmediate(b.this.mMaskView);
                            }
                            if (b.dFO) {
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
            this.mHandler.removeCallbacks(this.dFR);
            if (dFO) {
                Log.d("ToastCustom", "cancel");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindowManager.LayoutParams aLK() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.verticalMargin = d.dp(this.mContext);
        layoutParams.flags = 2176;
        layoutParams.type = 2005;
        return layoutParams;
    }
}
