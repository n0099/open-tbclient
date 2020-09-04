package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class a extends TimerTask {
    private final WheelView3d cOK;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView3d wheelView3d, float f) {
        this.cOK = wheelView3d;
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
            this.cOK.cancelFuture();
            this.cOK.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.cOK.setTotalScrollY(this.cOK.getTotalScrollY() - i);
        if (!this.cOK.isLoop()) {
            float itemHeight = this.cOK.getItemHeight();
            float f = (-this.cOK.getInitPosition()) * itemHeight;
            float itemsCount = ((this.cOK.getItemsCount() - 1) - this.cOK.getInitPosition()) * itemHeight;
            if (this.cOK.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.cOK.getTotalScrollY() + i;
            } else if (this.cOK.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.cOK.getTotalScrollY() + i;
            }
            if (this.cOK.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.cOK.setTotalScrollY((int) f);
            } else if (this.cOK.getTotalScrollY() >= itemsCount) {
                this.cOK.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.cOK.getHandler().sendEmptyMessage(1000);
    }
}
