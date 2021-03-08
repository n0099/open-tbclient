package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class a extends TimerTask {
    private float dCp = 2.1474836E9f;
    private final float dCq;
    private final WheelView3d dCr;

    public a(WheelView3d wheelView3d, float f) {
        this.dCr = wheelView3d;
        this.dCq = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.dCp == 2.1474836E9f) {
            if (Math.abs(this.dCq) > 2000.0f) {
                this.dCp = this.dCq <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.dCp = this.dCq;
            }
        }
        if (Math.abs(this.dCp) >= 0.0f && Math.abs(this.dCp) <= 20.0f) {
            this.dCr.aHG();
            this.dCr.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.dCp / 100.0f);
        this.dCr.setTotalScrollY(this.dCr.getTotalScrollY() - i);
        if (!this.dCr.aHI()) {
            float itemHeight = this.dCr.getItemHeight();
            float f = (-this.dCr.getInitPosition()) * itemHeight;
            float itemsCount = ((this.dCr.getItemsCount() - 1) - this.dCr.getInitPosition()) * itemHeight;
            if (this.dCr.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.dCr.getTotalScrollY() + i;
            } else if (this.dCr.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.dCr.getTotalScrollY() + i;
            }
            if (this.dCr.getTotalScrollY() <= f) {
                this.dCp = 40.0f;
                this.dCr.setTotalScrollY((int) f);
            } else if (this.dCr.getTotalScrollY() >= itemsCount) {
                this.dCr.setTotalScrollY((int) itemsCount);
                this.dCp = -40.0f;
            }
        }
        if (this.dCp < 0.0f) {
            this.dCp += 20.0f;
        } else {
            this.dCp -= 20.0f;
        }
        this.dCr.getHandler().sendEmptyMessage(1000);
    }
}
