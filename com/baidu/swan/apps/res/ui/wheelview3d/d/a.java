package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {
    private final WheelView3d cQK;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView3d wheelView3d, float f) {
        this.cQK = wheelView3d;
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
            this.cQK.cancelFuture();
            this.cQK.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.cQK.setTotalScrollY(this.cQK.getTotalScrollY() - i);
        if (!this.cQK.isLoop()) {
            float itemHeight = this.cQK.getItemHeight();
            float f = (-this.cQK.getInitPosition()) * itemHeight;
            float itemsCount = ((this.cQK.getItemsCount() - 1) - this.cQK.getInitPosition()) * itemHeight;
            if (this.cQK.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.cQK.getTotalScrollY() + i;
            } else if (this.cQK.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.cQK.getTotalScrollY() + i;
            }
            if (this.cQK.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.cQK.setTotalScrollY((int) f);
            } else if (this.cQK.getTotalScrollY() >= itemsCount) {
                this.cQK.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.cQK.getHandler().sendEmptyMessage(1000);
    }
}
