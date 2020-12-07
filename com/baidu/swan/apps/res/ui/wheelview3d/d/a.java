package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes25.dex */
public final class a extends TimerTask {
    private final WheelView3d dwG;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView3d wheelView3d, float f) {
        this.dwG = wheelView3d;
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
            this.dwG.cancelFuture();
            this.dwG.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.dwG.setTotalScrollY(this.dwG.getTotalScrollY() - i);
        if (!this.dwG.isLoop()) {
            float itemHeight = this.dwG.getItemHeight();
            float f = (-this.dwG.getInitPosition()) * itemHeight;
            float itemsCount = ((this.dwG.getItemsCount() - 1) - this.dwG.getInitPosition()) * itemHeight;
            if (this.dwG.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.dwG.getTotalScrollY() + i;
            } else if (this.dwG.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.dwG.getTotalScrollY() + i;
            }
            if (this.dwG.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.dwG.setTotalScrollY((int) f);
            } else if (this.dwG.getTotalScrollY() >= itemsCount) {
                this.dwG.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.dwG.getHandler().sendEmptyMessage(1000);
    }
}
