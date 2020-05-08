package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes11.dex */
public final class a extends TimerTask {
    private final WheelView3d cmI;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView3d wheelView3d, float f) {
        this.cmI = wheelView3d;
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
            this.cmI.cancelFuture();
            this.cmI.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.cmI.setTotalScrollY(this.cmI.getTotalScrollY() - i);
        if (!this.cmI.isLoop()) {
            float itemHeight = this.cmI.getItemHeight();
            float f = (-this.cmI.getInitPosition()) * itemHeight;
            float itemsCount = ((this.cmI.getItemsCount() - 1) - this.cmI.getInitPosition()) * itemHeight;
            if (this.cmI.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.cmI.getTotalScrollY() + i;
            } else if (this.cmI.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.cmI.getTotalScrollY() + i;
            }
            if (this.cmI.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.cmI.setTotalScrollY((int) f);
            } else if (this.cmI.getTotalScrollY() >= itemsCount) {
                this.cmI.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.cmI.getHandler().sendEmptyMessage(1000);
    }
}
