package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes10.dex */
public final class a extends TimerTask {
    private final WheelView3d bJz;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView3d wheelView3d, float f) {
        this.bJz = wheelView3d;
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
            this.bJz.cancelFuture();
            this.bJz.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.bJz.setTotalScrollY(this.bJz.getTotalScrollY() - i);
        if (!this.bJz.isLoop()) {
            float itemHeight = this.bJz.getItemHeight();
            float f = (-this.bJz.getInitPosition()) * itemHeight;
            float itemsCount = ((this.bJz.getItemsCount() - 1) - this.bJz.getInitPosition()) * itemHeight;
            if (this.bJz.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.bJz.getTotalScrollY() + i;
            } else if (this.bJz.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.bJz.getTotalScrollY() + i;
            }
            if (this.bJz.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.bJz.setTotalScrollY((int) f);
            } else if (this.bJz.getTotalScrollY() >= itemsCount) {
                this.bJz.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.bJz.getHandler().sendEmptyMessage(1000);
    }
}
