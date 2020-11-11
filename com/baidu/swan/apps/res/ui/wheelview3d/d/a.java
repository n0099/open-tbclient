package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes10.dex */
public final class a extends TimerTask {
    private final WheelView3d drm;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView3d wheelView3d, float f) {
        this.drm = wheelView3d;
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
            this.drm.cancelFuture();
            this.drm.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.drm.setTotalScrollY(this.drm.getTotalScrollY() - i);
        if (!this.drm.isLoop()) {
            float itemHeight = this.drm.getItemHeight();
            float f = (-this.drm.getInitPosition()) * itemHeight;
            float itemsCount = ((this.drm.getItemsCount() - 1) - this.drm.getInitPosition()) * itemHeight;
            if (this.drm.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.drm.getTotalScrollY() + i;
            } else if (this.drm.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.drm.getTotalScrollY() + i;
            }
            if (this.drm.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.drm.setTotalScrollY((int) f);
            } else if (this.drm.getTotalScrollY() >= itemsCount) {
                this.drm.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.drm.getHandler().sendEmptyMessage(1000);
    }
}
