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
    private WindowManager aPj;
    private View aPk;
    private boolean aPn;
    private View aPo;
    private boolean ayM;
    private Context mContext;
    private volatile int mDuration;
    private View mMaskView;
    private Runnable mShowRunnable;
    private View mView;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable aPm = new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mView != null) {
                if (b.this.mView.getParent() != null) {
                    b.this.aPj.removeView(b.this.mView);
                }
                b.this.mView = null;
            }
            if (b.this.mMaskView != null) {
                if (b.this.mMaskView.getParent() != null) {
                    b.this.aPj.removeView(b.this.mMaskView);
                }
                b.this.mMaskView = null;
            }
        }
    };
    private WindowManager.LayoutParams aPl = new WindowManager.LayoutParams();

    public b(Context context) {
        this.mContext = context;
        this.aPj = (WindowManager) this.mContext.getSystemService("window");
        this.aPl.height = -2;
        this.aPl.width = -2;
        this.aPl.format = -3;
        this.aPl.windowAnimations = a.i.toast_animation;
        this.aPl.type = 2005;
        this.aPl.setTitle("Toast");
        this.aPl.flags = 168;
        this.aPl.gravity = 81;
        this.aPl.y = -30;
        this.mDuration = 2;
        this.ayM = com.baidu.swan.apps.b.DEBUG;
    }

    public void setView(@NonNull View view) {
        this.aPk = view;
        this.aPk.setClickable(true);
    }

    public void setMask(boolean z) {
        this.aPn = z;
    }

    public void setDuration(int i) {
        if (i <= 0) {
            i = 2;
        }
        this.mDuration = i;
    }

    public void dA(@StyleRes int i) {
        if (this.aPl != null) {
            this.aPl.windowAnimations = i;
        }
    }

    public void dB(int i) {
        if (this.aPl != null) {
            this.aPl.type = i;
        }
    }

    public void setGravity(int i, int i2, int i3) {
        if (this.aPl != null) {
            this.aPl.gravity = i;
            this.aPl.x = i2;
            this.aPl.y = i3;
        }
    }

    public void a(@Nullable final d.a aVar) {
        if (this.aPk != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.Lk();
                    }
                    b.this.cancel();
                }
            };
            this.aPk.setClickable(true);
            View findViewById = this.aPk.findViewById(a.f.clickable_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(onClickListener);
            } else {
                this.aPk.setOnClickListener(onClickListener);
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
                    if (b.this.aPn) {
                        if (b.this.mMaskView != null && (b.this.mMaskView.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) b.this.mMaskView.getParent()).removeView(b.this.mMaskView);
                        }
                        WindowManager.LayoutParams KW = b.this.KW();
                        b.this.aPo = new FrameLayout(b.this.mContext);
                        b.this.aPo.setClickable(true);
                        b.this.aPj.addView(b.this.aPo, KW);
                        b.this.mMaskView = b.this.aPo;
                    }
                    if (b.this.aPk != null && (b.this.aPk.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) b.this.aPk.getParent()).removeView(b.this.aPk);
                    }
                    b.this.aPj.addView(b.this.aPk, b.this.aPl);
                    b.this.mView = b.this.aPk;
                    b.this.mHandler.postDelayed(b.this.aPm, b.this.mDuration * 1000);
                    if (b.this.ayM) {
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
                                b.this.aPj.removeViewImmediate(b.this.mView);
                            }
                            if (b.this.ayM) {
                                Log.d("ToastCustom", "remove mView");
                            }
                            b.this.mView = null;
                        }
                        if (b.this.mMaskView != null) {
                            if (b.this.mMaskView.getParent() != null) {
                                b.this.aPj.removeViewImmediate(b.this.mMaskView);
                            }
                            if (b.this.ayM) {
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
            this.mHandler.removeCallbacks(this.aPm);
            if (this.ayM) {
                Log.d("ToastCustom", "cancel");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindowManager.LayoutParams KW() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.verticalMargin = d.bx(this.mContext);
        layoutParams.flags = 2176;
        layoutParams.type = 2005;
        return layoutParams;
    }
}
