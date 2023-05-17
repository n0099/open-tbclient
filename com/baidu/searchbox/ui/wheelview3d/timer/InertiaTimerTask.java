package com.baidu.searchbox.ui.wheelview3d.timer;

import com.baidu.searchbox.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public final class InertiaTimerTask extends TimerTask {
    public float mCurrentVelocityY = 2.1474836E9f;
    public final float mFirstVelocityY;
    public final WheelView3d mWheelView;

    public InertiaTimerTask(WheelView3d wheelView3d, float f) {
        this.mWheelView = wheelView3d;
        this.mFirstVelocityY = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.mCurrentVelocityY == 2.1474836E9f) {
            float f = 2000.0f;
            if (Math.abs(this.mFirstVelocityY) > 2000.0f) {
                if (this.mFirstVelocityY <= 0.0f) {
                    f = -2000.0f;
                }
                this.mCurrentVelocityY = f;
            } else {
                this.mCurrentVelocityY = this.mFirstVelocityY;
            }
        }
        if (Math.abs(this.mCurrentVelocityY) >= 0.0f && Math.abs(this.mCurrentVelocityY) <= 20.0f) {
            this.mWheelView.cancelFuture();
            this.mWheelView.getHandler().sendEmptyMessage(2000);
            return;
        }
        WheelView3d wheelView3d = this.mWheelView;
        float f2 = (int) (this.mCurrentVelocityY / 100.0f);
        wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() - f2);
        if (!this.mWheelView.isLoop()) {
            float itemHeight = this.mWheelView.getItemHeight();
            float f3 = (-this.mWheelView.getInitPosition()) * itemHeight;
            float itemsCount = ((this.mWheelView.getItemsCount() - 1) - this.mWheelView.getInitPosition()) * itemHeight;
            double d = itemHeight * 0.25d;
            if (this.mWheelView.getTotalScrollY() - d < f3) {
                f3 = this.mWheelView.getTotalScrollY() + f2;
            } else if (this.mWheelView.getTotalScrollY() + d > itemsCount) {
                itemsCount = this.mWheelView.getTotalScrollY() + f2;
            }
            if (this.mWheelView.getTotalScrollY() <= f3) {
                this.mCurrentVelocityY = 40.0f;
                this.mWheelView.setTotalScrollY((int) f3);
            } else if (this.mWheelView.getTotalScrollY() >= itemsCount) {
                this.mWheelView.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        float f4 = this.mCurrentVelocityY;
        if (f4 < 0.0f) {
            this.mCurrentVelocityY = f4 + 20.0f;
        } else {
            this.mCurrentVelocityY = f4 - 20.0f;
        }
        this.mWheelView.getHandler().sendEmptyMessage(1000);
    }
}
