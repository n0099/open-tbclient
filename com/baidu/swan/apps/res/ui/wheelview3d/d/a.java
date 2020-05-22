package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes11.dex */
public final class a extends TimerTask {
    private final WheelView3d cyl;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView3d wheelView3d, float f) {
        this.cyl = wheelView3d;
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
            this.cyl.cancelFuture();
            this.cyl.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.cyl.setTotalScrollY(this.cyl.getTotalScrollY() - i);
        if (!this.cyl.isLoop()) {
            float itemHeight = this.cyl.getItemHeight();
            float f = (-this.cyl.getInitPosition()) * itemHeight;
            float itemsCount = ((this.cyl.getItemsCount() - 1) - this.cyl.getInitPosition()) * itemHeight;
            if (this.cyl.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.cyl.getTotalScrollY() + i;
            } else if (this.cyl.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.cyl.getTotalScrollY() + i;
            }
            if (this.cyl.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.cyl.setTotalScrollY((int) f);
            } else if (this.cyl.getTotalScrollY() >= itemsCount) {
                this.cyl.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.cyl.getHandler().sendEmptyMessage(1000);
    }
}
