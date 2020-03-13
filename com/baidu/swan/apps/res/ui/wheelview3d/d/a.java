package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes11.dex */
public final class a extends TimerTask {
    private final WheelView3d bNG;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView3d wheelView3d, float f) {
        this.bNG = wheelView3d;
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
            this.bNG.cancelFuture();
            this.bNG.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.bNG.setTotalScrollY(this.bNG.getTotalScrollY() - i);
        if (!this.bNG.isLoop()) {
            float itemHeight = this.bNG.getItemHeight();
            float f = (-this.bNG.getInitPosition()) * itemHeight;
            float itemsCount = ((this.bNG.getItemsCount() - 1) - this.bNG.getInitPosition()) * itemHeight;
            if (this.bNG.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.bNG.getTotalScrollY() + i;
            } else if (this.bNG.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.bNG.getTotalScrollY() + i;
            }
            if (this.bNG.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.bNG.setTotalScrollY((int) f);
            } else if (this.bNG.getTotalScrollY() >= itemsCount) {
                this.bNG.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.bNG.getHandler().sendEmptyMessage(1000);
    }
}
