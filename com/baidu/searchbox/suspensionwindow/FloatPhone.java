package com.baidu.searchbox.suspensionwindow;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import com.baidu.searchbox.suspensionwindow.cancelwindow.CancelWindowManager;
import com.baidu.searchbox.suspensionwindow.permission.PermissionUtil;
/* loaded from: classes13.dex */
class FloatPhone extends FloatView {
    private final Context mContext;
    private boolean mIsInited = false;
    private final WindowManager.LayoutParams mLayoutParams = new WindowManager.LayoutParams();
    private View mView;
    private final WindowManager mWindowManager;
    private float mX;
    private float mY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatPhone(Context context) {
        this.mContext = context;
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mLayoutParams.format = 1;
        this.mLayoutParams.flags = 296;
        this.mLayoutParams.windowAnimations = 0;
    }

    @Override // com.baidu.searchbox.suspensionwindow.FloatView
    public void setSize(int i, int i2) {
        this.mLayoutParams.width = i;
        this.mLayoutParams.height = i2;
    }

    @Override // com.baidu.searchbox.suspensionwindow.FloatView
    public void setView(View view) {
        this.mView = view;
    }

    @Override // com.baidu.searchbox.suspensionwindow.FloatView
    public void setGravity(int i, float f, float f2) {
        this.mLayoutParams.gravity = i;
        this.mX = f;
        this.mY = f2;
        this.mLayoutParams.x = (int) this.mX;
        this.mLayoutParams.y = (int) this.mY;
    }

    @Override // com.baidu.searchbox.suspensionwindow.FloatView
    public void init() {
        if (!this.mIsInited && PermissionUtil.hasPermission(this.mContext)) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.mLayoutParams.type = 2038;
                } else {
                    this.mLayoutParams.type = 2002;
                }
                initCancelFloatWindow(this.mContext, this.mLayoutParams.type);
                this.mWindowManager.addView(this.mView, this.mLayoutParams);
            } catch (Exception e) {
                this.mWindowManager.removeView(this.mView);
            }
            this.mIsInited = true;
        }
    }

    @Override // com.baidu.searchbox.suspensionwindow.FloatView
    public boolean isInited() {
        return this.mIsInited;
    }

    @Override // com.baidu.searchbox.suspensionwindow.FloatView
    public void dismiss() {
        if (isViewAdded()) {
            this.mWindowManager.removeView(this.mView);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.searchbox.suspensionwindow.FloatView
    public void updateXY(float f, float f2) {
        if (isViewAdded()) {
            this.mX = f;
            this.mY = f2;
            this.mLayoutParams.x = (int) this.mX;
            this.mLayoutParams.y = (int) this.mY;
            this.mWindowManager.updateViewLayout(this.mView, this.mLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.searchbox.suspensionwindow.FloatView
    public void updateX(float f) {
        if (isViewAdded()) {
            this.mX = f;
            this.mLayoutParams.x = (int) this.mX;
            this.mWindowManager.updateViewLayout(this.mView, this.mLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.searchbox.suspensionwindow.FloatView
    public void updateY(float f) {
        if (isViewAdded()) {
            this.mY = f;
            this.mLayoutParams.y = (int) this.mY;
            this.mWindowManager.updateViewLayout(this.mView, this.mLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.searchbox.suspensionwindow.FloatView
    public float getX() {
        return this.mX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.searchbox.suspensionwindow.FloatView
    public float getY() {
        return this.mY;
    }

    boolean isViewAdded() {
        return this.mView != null && this.mView.isAttachedToWindow();
    }

    void initCancelFloatWindow(Context context, int i) {
        CancelWindowManager.getInstance().initCancelWindow(context, i);
    }
}
