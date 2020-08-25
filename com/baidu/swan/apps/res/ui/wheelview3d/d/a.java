package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class a extends TimerTask {
    private final WheelView3d cOG;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView3d wheelView3d, float f) {
        this.cOG = wheelView3d;
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
            this.cOG.cancelFuture();
            this.cOG.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.cOG.setTotalScrollY(this.cOG.getTotalScrollY() - i);
        if (!this.cOG.isLoop()) {
            float itemHeight = this.cOG.getItemHeight();
            float f = (-this.cOG.getInitPosition()) * itemHeight;
            float itemsCount = ((this.cOG.getItemsCount() - 1) - this.cOG.getInitPosition()) * itemHeight;
            if (this.cOG.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.cOG.getTotalScrollY() + i;
            } else if (this.cOG.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.cOG.getTotalScrollY() + i;
            }
            if (this.cOG.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.cOG.setTotalScrollY((int) f);
            } else if (this.cOG.getTotalScrollY() >= itemsCount) {
                this.cOG.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.cOG.getHandler().sendEmptyMessage(1000);
    }
}
