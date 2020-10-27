package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes10.dex */
public final class a extends TimerTask {
    private final WheelView3d dlr;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView3d wheelView3d, float f) {
        this.dlr = wheelView3d;
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
            this.dlr.cancelFuture();
            this.dlr.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.dlr.setTotalScrollY(this.dlr.getTotalScrollY() - i);
        if (!this.dlr.isLoop()) {
            float itemHeight = this.dlr.getItemHeight();
            float f = (-this.dlr.getInitPosition()) * itemHeight;
            float itemsCount = ((this.dlr.getItemsCount() - 1) - this.dlr.getInitPosition()) * itemHeight;
            if (this.dlr.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.dlr.getTotalScrollY() + i;
            } else if (this.dlr.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.dlr.getTotalScrollY() + i;
            }
            if (this.dlr.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.dlr.setTotalScrollY((int) f);
            } else if (this.dlr.getTotalScrollY() >= itemsCount) {
                this.dlr.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.dlr.getHandler().sendEmptyMessage(1000);
    }
}
