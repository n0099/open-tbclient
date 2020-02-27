package com.baidu.searchbox.suspensionball;

import android.graphics.Rect;
import android.util.Log;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class BallInfo {
    int mBallCenterXCoordinate;
    int mBallCenterYCoordinate;
    Rect mLimitAreaPadding = new Rect();
    int mRadius;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.mRadius = AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.ball_default_radius);
        int displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(AppRuntime.getAppContext());
        int displayHeight = DeviceUtil.ScreenInfo.getDisplayHeight(AppRuntime.getAppContext());
        int statusBarHeight = DeviceUtil.ScreenInfo.getStatusBarHeight();
        int dimensionPixelSize = AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.top_bar_height);
        int dimensionPixelSize2 = AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.bottom_bar_height);
        int dimensionPixelSize3 = AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.horizontal_margin);
        this.mLimitAreaPadding.set(dimensionPixelSize3, statusBarHeight + dimensionPixelSize + dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize2 + dimensionPixelSize3);
        this.mBallCenterXCoordinate = SuspensionSpUtil.getInt(SuspensionSpUtil.SUSPENSION_BALL_XCOORDINATE, 0);
        this.mBallCenterYCoordinate = SuspensionSpUtil.getInt(SuspensionSpUtil.SUSPENSION_BALL_YCOORDINATE, 0);
        if (this.mBallCenterXCoordinate == 0 && this.mBallCenterYCoordinate == 0) {
            this.mBallCenterXCoordinate = (displayWidth - dimensionPixelSize3) - this.mRadius;
            this.mBallCenterYCoordinate = dimensionPixelSize + (((int) ((((displayHeight - statusBarHeight) - dimensionPixelSize) - dimensionPixelSize2) * 0.4f)) - this.mRadius) + statusBarHeight;
        }
        if (AppConfig.isDebug()) {
            Log.i("BallInfo", "statusBarHeight = " + statusBarHeight + " mBallCenterXCoordinate = " + this.mBallCenterXCoordinate + " mBallCenterYCoordinate = " + this.mBallCenterYCoordinate + " mLimitAreaPadding = " + this.mLimitAreaPadding + " mRadius = " + this.mRadius + " screenH = " + displayHeight);
        }
    }
}
