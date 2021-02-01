package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes9.dex */
public final class c extends TimerTask {
    private final WheelView3d dAN;
    private int dAR = Integer.MAX_VALUE;
    private int dAS = 0;
    private int offset;

    public c(WheelView3d wheelView3d, int i) {
        this.dAN = wheelView3d;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.dAR == Integer.MAX_VALUE) {
            this.dAR = this.offset;
        }
        this.dAS = (int) (this.dAR * 0.1f);
        if (this.dAS == 0) {
            if (this.dAR < 0) {
                this.dAS = -1;
            } else {
                this.dAS = 1;
            }
        }
        if (Math.abs(this.dAR) <= 1) {
            this.dAN.aHD();
            this.dAN.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.dAN.setTotalScrollY(this.dAN.getTotalScrollY() + this.dAS);
        if (!this.dAN.aHF()) {
            float itemHeight = this.dAN.getItemHeight();
            float f = (-this.dAN.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.dAN.getItemsCount() - 1) - this.dAN.getInitPosition());
            if (this.dAN.getTotalScrollY() <= f || this.dAN.getTotalScrollY() >= itemsCount) {
                this.dAN.setTotalScrollY(this.dAN.getTotalScrollY() - this.dAS);
                this.dAN.aHD();
                this.dAN.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.dAN.getHandler().sendEmptyMessage(1000);
        this.dAR -= this.dAS;
    }
}
