package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes9.dex */
public final class a extends TimerTask {
    private float dDv = 2.1474836E9f;
    private final float dDw;
    private final WheelView3d dDx;

    public a(WheelView3d wheelView3d, float f) {
        this.dDx = wheelView3d;
        this.dDw = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.dDv == 2.1474836E9f) {
            if (Math.abs(this.dDw) > 2000.0f) {
                this.dDv = this.dDw <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.dDv = this.dDw;
            }
        }
        if (Math.abs(this.dDv) >= 0.0f && Math.abs(this.dDv) <= 20.0f) {
            this.dDx.aLd();
            this.dDx.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.dDv / 100.0f);
        this.dDx.setTotalScrollY(this.dDx.getTotalScrollY() - i);
        if (!this.dDx.aLf()) {
            float itemHeight = this.dDx.getItemHeight();
            float f = (-this.dDx.getInitPosition()) * itemHeight;
            float itemsCount = ((this.dDx.getItemsCount() - 1) - this.dDx.getInitPosition()) * itemHeight;
            if (this.dDx.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.dDx.getTotalScrollY() + i;
            } else if (this.dDx.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.dDx.getTotalScrollY() + i;
            }
            if (this.dDx.getTotalScrollY() <= f) {
                this.dDv = 40.0f;
                this.dDx.setTotalScrollY((int) f);
            } else if (this.dDx.getTotalScrollY() >= itemsCount) {
                this.dDx.setTotalScrollY((int) itemsCount);
                this.dDv = -40.0f;
            }
        }
        if (this.dDv < 0.0f) {
            this.dDv += 20.0f;
        } else {
            this.dDv -= 20.0f;
        }
        this.dDx.getHandler().sendEmptyMessage(1000);
    }
}
