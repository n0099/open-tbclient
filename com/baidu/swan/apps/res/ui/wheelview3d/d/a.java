package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes11.dex */
public final class a extends TimerTask {
    private final WheelView3d bNF;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView3d wheelView3d, float f) {
        this.bNF = wheelView3d;
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
            this.bNF.cancelFuture();
            this.bNF.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.bNF.setTotalScrollY(this.bNF.getTotalScrollY() - i);
        if (!this.bNF.isLoop()) {
            float itemHeight = this.bNF.getItemHeight();
            float f = (-this.bNF.getInitPosition()) * itemHeight;
            float itemsCount = ((this.bNF.getItemsCount() - 1) - this.bNF.getInitPosition()) * itemHeight;
            if (this.bNF.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.bNF.getTotalScrollY() + i;
            } else if (this.bNF.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.bNF.getTotalScrollY() + i;
            }
            if (this.bNF.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.bNF.setTotalScrollY((int) f);
            } else if (this.bNF.getTotalScrollY() >= itemsCount) {
                this.bNF.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.bNF.getHandler().sendEmptyMessage(1000);
    }
}
