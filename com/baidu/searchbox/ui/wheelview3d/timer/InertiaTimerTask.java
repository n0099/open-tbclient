package com.baidu.searchbox.ui.wheelview3d.timer;

import com.baidu.searchbox.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes10.dex */
public final class InertiaTimerTask extends TimerTask {
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;
    private final WheelView3d mWheelView;

    public InertiaTimerTask(WheelView3d wheelView3d, float f) {
        this.mWheelView = wheelView3d;
        this.mFirstVelocityY = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.mCurrentVelocityY == 2.1474836E9f) {
            if (Math.abs(this.mFirstVelocityY) > 2000.0f) {
                this.mCurrentVelocityY = this.mFirstVelocityY <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.mCurrentVelocityY = this.mFirstVelocityY;
            }
        }
        if (Math.abs(this.mCurrentVelocityY) >= 0.0f && Math.abs(this.mCurrentVelocityY) <= 20.0f) {
            this.mWheelView.cancelFuture();
            this.mWheelView.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.mWheelView.setTotalScrollY(this.mWheelView.getTotalScrollY() - i);
        if (!this.mWheelView.isLoop()) {
            float itemHeight = this.mWheelView.getItemHeight();
            float f = (-this.mWheelView.getInitPosition()) * itemHeight;
            float itemsCount = ((this.mWheelView.getItemsCount() - 1) - this.mWheelView.getInitPosition()) * itemHeight;
            if (this.mWheelView.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.mWheelView.getTotalScrollY() + i;
            } else if (this.mWheelView.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.mWheelView.getTotalScrollY() + i;
            }
            if (this.mWheelView.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.mWheelView.setTotalScrollY((int) f);
            } else if (this.mWheelView.getTotalScrollY() >= itemsCount) {
                this.mWheelView.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.mWheelView.getHandler().sendEmptyMessage(1000);
    }
}
