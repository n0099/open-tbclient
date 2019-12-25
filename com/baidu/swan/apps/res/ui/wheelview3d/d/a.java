package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes9.dex */
public final class a extends TimerTask {
    private final WheelView3d bIP;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView3d wheelView3d, float f) {
        this.bIP = wheelView3d;
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
            this.bIP.cancelFuture();
            this.bIP.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.bIP.setTotalScrollY(this.bIP.getTotalScrollY() - i);
        if (!this.bIP.isLoop()) {
            float itemHeight = this.bIP.getItemHeight();
            float f = (-this.bIP.getInitPosition()) * itemHeight;
            float itemsCount = ((this.bIP.getItemsCount() - 1) - this.bIP.getInitPosition()) * itemHeight;
            if (this.bIP.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.bIP.getTotalScrollY() + i;
            } else if (this.bIP.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.bIP.getTotalScrollY() + i;
            }
            if (this.bIP.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.bIP.setTotalScrollY((int) f);
            } else if (this.bIP.getTotalScrollY() >= itemsCount) {
                this.bIP.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.bIP.getHandler().sendEmptyMessage(1000);
    }
}
