package com.baidu.searchbox.suspensionwindow.cancelwindow;

import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.searchbox.suspensionwindow.R;
import com.baidu.searchbox.suspensionwindow.cancelwindow.SpreadView;
import com.baidu.searchbox.suspensionwindow.util.DeviceUtil;
/* loaded from: classes11.dex */
public class CancelWindowManager implements SpreadView.OnStateChangeListener {
    private TextView mCancelHint;
    private WindowManager.LayoutParams mCancelLayoutParams;
    private View mCancelRootView;
    private SpreadView mCancelSpreadView;
    private WindowManager mCancelWindowManager;
    private Rect mCancelWindowRect;
    @ColorInt
    private int mColor;
    private int mDuration;
    private float mFactor;
    private int mHeight;
    private boolean mIsCancelWindowShowing;
    private int mWidth;

    private CancelWindowManager() {
        this.mWidth = 402;
        this.mHeight = 402;
        this.mDuration = 200;
        this.mFactor = 0.93333334f;
        this.mColor = -502961;
    }

    /* loaded from: classes11.dex */
    static class InstanceHolder {
        static CancelWindowManager INSTANCE = new CancelWindowManager();

        InstanceHolder() {
        }
    }

    public static CancelWindowManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void initCancelWindow(Context context, int i) {
        if (this.mCancelWindowManager == null) {
            if (!(context instanceof Application)) {
                context = context.getApplicationContext();
            }
            this.mCancelWindowManager = (WindowManager) context.getSystemService("window");
            this.mCancelLayoutParams = new WindowManager.LayoutParams();
            this.mCancelLayoutParams.format = 1;
            this.mCancelLayoutParams.flags = 552;
            this.mCancelLayoutParams.windowAnimations = 0;
            WindowManager.LayoutParams layoutParams = this.mCancelLayoutParams;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.suspension_ball_cancel_window_width);
            this.mWidth = dimensionPixelSize;
            layoutParams.width = dimensionPixelSize;
            WindowManager.LayoutParams layoutParams2 = this.mCancelLayoutParams;
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.suspension_ball_cancel_window_height);
            this.mHeight = dimensionPixelOffset;
            layoutParams2.height = dimensionPixelOffset;
            this.mCancelLayoutParams.gravity = 8388693;
            this.mCancelLayoutParams.type = i;
            this.mCancelRootView = DeviceUtil.inflate(context, R.layout.view_cancel_window);
            this.mCancelWindowManager.addView(this.mCancelRootView, this.mCancelLayoutParams);
            this.mCancelHint = (TextView) this.mCancelRootView.findViewById(R.id.tvCancelHint);
            this.mCancelSpreadView = (SpreadView) this.mCancelRootView.findViewById(R.id.svCancelBg);
            this.mCancelSpreadView.setFillColor(this.mColor);
            this.mCancelSpreadView.setOnStateChangeListener(this);
            this.mCancelSpreadView.setRadius(Math.min(this.mWidth, this.mHeight) * this.mFactor);
            this.mCancelSpreadView.setDuration(this.mDuration);
            this.mCancelWindowRect = new Rect();
            this.mCancelRootView.post(new Runnable() { // from class: com.baidu.searchbox.suspensionwindow.cancelwindow.CancelWindowManager.1
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[2];
                    CancelWindowManager.this.mCancelRootView.getLocationOnScreen(iArr);
                    CancelWindowManager.this.mCancelWindowRect.left = iArr[0];
                    CancelWindowManager.this.mCancelWindowRect.top = iArr[1];
                    CancelWindowManager.this.mCancelWindowRect.right = CancelWindowManager.this.mCancelWindowRect.left + CancelWindowManager.this.mWidth;
                    CancelWindowManager.this.mCancelWindowRect.bottom = CancelWindowManager.this.mCancelWindowRect.top + CancelWindowManager.this.mHeight;
                }
            });
        }
    }

    public boolean isCancelWindowShowing() {
        return this.mIsCancelWindowShowing;
    }

    public void show() {
        if (!this.mIsCancelWindowShowing) {
            this.mIsCancelWindowShowing = true;
            this.mColor = this.mCancelSpreadView.getContext().getResources().getColor(R.color.suspension_ball_cancel_window_bg_color);
            this.mCancelSpreadView.setFillColor(this.mColor);
            this.mCancelSpreadView.setRadius(Math.min(this.mWidth, this.mHeight) * this.mFactor);
            this.mCancelSpreadView.setDuration(this.mDuration);
            this.mCancelSpreadView.startFromLocation(new int[]{this.mWidth, this.mHeight});
            this.mCancelHint.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.mCancelHint.getContext().getResources().getDrawable(R.drawable.suspension_ball_cancel_window_icon_focus), (Drawable) null, (Drawable) null);
            this.mCancelHint.setTextColor(this.mCancelHint.getContext().getResources().getColor(R.color.suspension_ball_cancel_window_text_color));
        }
    }

    public void hide() {
        if (this.mIsCancelWindowShowing) {
            this.mIsCancelWindowShowing = false;
            this.mCancelSpreadView.setDuration(this.mDuration);
            this.mCancelSpreadView.startToLocation();
        }
    }

    public void toggle() {
        if (this.mIsCancelWindowShowing) {
            hide();
        } else {
            show();
        }
    }

    public void focus() {
        if (this.mIsCancelWindowShowing) {
            this.mCancelHint.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.mCancelHint.getContext().getResources().getDrawable(R.drawable.suspension_ball_cancel_window_icon_focus), (Drawable) null, (Drawable) null);
            this.mCancelSpreadView.setRadius(Math.min(this.mWidth, this.mHeight));
            this.mCancelSpreadView.setDuration(0);
            this.mCancelSpreadView.startFromLocation(new int[]{this.mWidth, this.mHeight});
        }
    }

    public void unfocus() {
        if (this.mIsCancelWindowShowing) {
            this.mCancelHint.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.mCancelHint.getContext().getResources().getDrawable(R.drawable.suspension_ball_cancel_window_icon), (Drawable) null, (Drawable) null);
            this.mCancelSpreadView.setRadius(Math.min(this.mWidth, this.mHeight) * this.mFactor);
            this.mCancelSpreadView.setDuration(0);
            this.mCancelSpreadView.startFromLocation(new int[]{this.mWidth, this.mHeight});
        }
    }

    public Rect getCancelWindowRect() {
        return this.mCancelWindowRect;
    }

    @Override // com.baidu.searchbox.suspensionwindow.cancelwindow.SpreadView.OnStateChangeListener
    public void onStateChange(int i) {
        switch (i) {
            case 1:
                this.mCancelRootView.setVisibility(0);
                return;
            case 2:
                this.mCancelHint.setVisibility(0);
                return;
            case 3:
                this.mCancelHint.setVisibility(4);
                return;
            case 4:
                this.mCancelRootView.setVisibility(4);
                return;
            default:
                return;
        }
    }
}
