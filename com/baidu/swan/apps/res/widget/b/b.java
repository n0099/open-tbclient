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
    private WindowManager aNg;
    private View aNh;
    private boolean aNk;
    private View aNl;
    private boolean axW;
    private Context mContext;
    private volatile int mDuration;
    private View mMaskView;
    private Runnable mShowRunnable;
    private View mView;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable aNj = new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mView != null) {
                if (b.this.mView.getParent() != null) {
                    b.this.aNg.removeView(b.this.mView);
                }
                b.this.mView = null;
            }
            if (b.this.mMaskView != null) {
                if (b.this.mMaskView.getParent() != null) {
                    b.this.aNg.removeView(b.this.mMaskView);
                }
                b.this.mMaskView = null;
            }
        }
    };
    private WindowManager.LayoutParams aNi = new WindowManager.LayoutParams();

    public b(Context context) {
        this.mContext = context;
        this.aNg = (WindowManager) this.mContext.getSystemService("window");
        this.aNi.height = -2;
        this.aNi.width = -2;
        this.aNi.format = -3;
        this.aNi.windowAnimations = a.i.toast_animation;
        this.aNi.type = 2005;
        this.aNi.setTitle("Toast");
        this.aNi.flags = 168;
        this.aNi.gravity = 81;
        this.aNi.y = -30;
        this.mDuration = 2;
        this.axW = com.baidu.swan.apps.b.DEBUG;
    }

    public void setView(@NonNull View view) {
        this.aNh = view;
        this.aNh.setClickable(true);
    }

    public void setMask(boolean z) {
        this.aNk = z;
    }

    public void setDuration(int i) {
        if (i <= 0) {
            i = 2;
        }
        this.mDuration = i;
    }

    public void dp(@StyleRes int i) {
        if (this.aNi != null) {
            this.aNi.windowAnimations = i;
        }
    }

    public void dq(int i) {
        if (this.aNi != null) {
            this.aNi.type = i;
        }
    }

    public void setGravity(int i, int i2, int i3) {
        if (this.aNi != null) {
            this.aNi.gravity = i;
            this.aNi.x = i2;
            this.aNi.y = i3;
        }
    }

    public void a(@Nullable final d.a aVar) {
        if (this.aNh != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.IP();
                    }
                    b.this.cancel();
                }
            };
            this.aNh.setClickable(true);
            View findViewById = this.aNh.findViewById(a.f.clickable_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(onClickListener);
            } else {
                this.aNh.setOnClickListener(onClickListener);
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
                    if (b.this.aNk) {
                        if (b.this.mMaskView != null && (b.this.mMaskView.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) b.this.mMaskView.getParent()).removeView(b.this.mMaskView);
                        }
                        WindowManager.LayoutParams IB = b.this.IB();
                        b.this.aNl = new FrameLayout(b.this.mContext);
                        b.this.aNl.setClickable(true);
                        b.this.aNg.addView(b.this.aNl, IB);
                        b.this.mMaskView = b.this.aNl;
                    }
                    if (b.this.aNh != null && (b.this.aNh.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) b.this.aNh.getParent()).removeView(b.this.aNh);
                    }
                    b.this.aNg.addView(b.this.aNh, b.this.aNi);
                    b.this.mView = b.this.aNh;
                    b.this.mHandler.postDelayed(b.this.aNj, b.this.mDuration * 1000);
                    if (b.this.axW) {
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
                                b.this.aNg.removeViewImmediate(b.this.mView);
                            }
                            if (b.this.axW) {
                                Log.d("ToastCustom", "remove mView");
                            }
                            b.this.mView = null;
                        }
                        if (b.this.mMaskView != null) {
                            if (b.this.mMaskView.getParent() != null) {
                                b.this.aNg.removeViewImmediate(b.this.mMaskView);
                            }
                            if (b.this.axW) {
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
            this.mHandler.removeCallbacks(this.aNj);
            if (this.axW) {
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
