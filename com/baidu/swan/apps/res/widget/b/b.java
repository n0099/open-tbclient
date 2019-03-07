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
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.widget.b.d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes2.dex */
public class b {
    private WindowManager aNb;
    private View aNc;
    private boolean aNf;
    private View aNg;
    private boolean axR;
    private Context mContext;
    private volatile int mDuration;
    private View mMaskView;
    private Runnable mShowRunnable;
    private View mView;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable aNe = new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mView != null) {
                if (b.this.mView.getParent() != null) {
                    b.this.aNb.removeView(b.this.mView);
                }
                b.this.mView = null;
            }
            if (b.this.mMaskView != null) {
                if (b.this.mMaskView.getParent() != null) {
                    b.this.aNb.removeView(b.this.mMaskView);
                }
                b.this.mMaskView = null;
            }
        }
    };
    private WindowManager.LayoutParams aNd = new WindowManager.LayoutParams();

    public b(Context context) {
        this.mContext = context;
        this.aNb = (WindowManager) this.mContext.getSystemService("window");
        this.aNd.height = -2;
        this.aNd.width = -2;
        this.aNd.format = -3;
        this.aNd.windowAnimations = b.i.toast_animation;
        this.aNd.type = PushConstants.NOTIFICATIONSERVICE_SEND_MESSAGE_BROADCAST;
        this.aNd.setTitle("Toast");
        this.aNd.flags = 168;
        this.aNd.gravity = 81;
        this.aNd.y = -30;
        this.mDuration = 2;
        this.axR = com.baidu.swan.apps.c.DEBUG;
    }

    public void setView(@NonNull View view) {
        this.aNc = view;
        this.aNc.setClickable(true);
    }

    public void setMask(boolean z) {
        this.aNf = z;
    }

    public void setDuration(int i) {
        if (i <= 0) {
            i = 2;
        }
        this.mDuration = i;
    }

    public void dq(@StyleRes int i) {
        if (this.aNd != null) {
            this.aNd.windowAnimations = i;
        }
    }

    public void dr(int i) {
        if (this.aNd != null) {
            this.aNd.type = i;
        }
    }

    public void setGravity(int i, int i2, int i3) {
        if (this.aNd != null) {
            this.aNd.gravity = i;
            this.aNd.x = i2;
            this.aNd.y = i3;
        }
    }

    public void a(@Nullable final d.a aVar) {
        if (this.aNc != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.IR();
                    }
                    b.this.cancel();
                }
            };
            this.aNc.setClickable(true);
            View findViewById = this.aNc.findViewById(b.f.clickable_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(onClickListener);
            } else {
                this.aNc.setOnClickListener(onClickListener);
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
                    if (b.this.aNf) {
                        if (b.this.mMaskView != null && (b.this.mMaskView.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) b.this.mMaskView.getParent()).removeView(b.this.mMaskView);
                        }
                        WindowManager.LayoutParams ID = b.this.ID();
                        b.this.aNg = new FrameLayout(b.this.mContext);
                        b.this.aNg.setClickable(true);
                        b.this.aNb.addView(b.this.aNg, ID);
                        b.this.mMaskView = b.this.aNg;
                    }
                    if (b.this.aNc != null && (b.this.aNc.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) b.this.aNc.getParent()).removeView(b.this.aNc);
                    }
                    b.this.aNb.addView(b.this.aNc, b.this.aNd);
                    b.this.mView = b.this.aNc;
                    b.this.mHandler.postDelayed(b.this.aNe, b.this.mDuration * 1000);
                    if (b.this.axR) {
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
                                b.this.aNb.removeViewImmediate(b.this.mView);
                            }
                            if (b.this.axR) {
                                Log.d("ToastCustom", "remove mView");
                            }
                            b.this.mView = null;
                        }
                        if (b.this.mMaskView != null) {
                            if (b.this.mMaskView.getParent() != null) {
                                b.this.aNb.removeViewImmediate(b.this.mMaskView);
                            }
                            if (b.this.axR) {
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
            this.mHandler.removeCallbacks(this.aNe);
            if (this.axR) {
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
        layoutParams.type = PushConstants.NOTIFICATIONSERVICE_SEND_MESSAGE_BROADCAST;
        return layoutParams;
    }
}
