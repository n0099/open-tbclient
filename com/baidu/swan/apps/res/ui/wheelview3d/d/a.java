package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes7.dex */
public final class a extends TimerTask {
    private final WheelView3d cFI;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView3d wheelView3d, float f) {
        this.cFI = wheelView3d;
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
            this.cFI.cancelFuture();
            this.cFI.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.cFI.setTotalScrollY(this.cFI.getTotalScrollY() - i);
        if (!this.cFI.isLoop()) {
            float itemHeight = this.cFI.getItemHeight();
            float f = (-this.cFI.getInitPosition()) * itemHeight;
            float itemsCount = ((this.cFI.getItemsCount() - 1) - this.cFI.getInitPosition()) * itemHeight;
            if (this.cFI.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.cFI.getTotalScrollY() + i;
            } else if (this.cFI.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.cFI.getTotalScrollY() + i;
            }
            if (this.cFI.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.cFI.setTotalScrollY((int) f);
            } else if (this.cFI.getTotalScrollY() >= itemsCount) {
                this.cFI.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.cFI.getHandler().sendEmptyMessage(1000);
    }
}
