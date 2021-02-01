package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes9.dex */
public final class a extends TimerTask {
    private float dAO = 2.1474836E9f;
    private final float dAP;
    private final WheelView3d dAQ;

    public a(WheelView3d wheelView3d, float f) {
        this.dAQ = wheelView3d;
        this.dAP = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.dAO == 2.1474836E9f) {
            if (Math.abs(this.dAP) > 2000.0f) {
                this.dAO = this.dAP <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.dAO = this.dAP;
            }
        }
        if (Math.abs(this.dAO) >= 0.0f && Math.abs(this.dAO) <= 20.0f) {
            this.dAQ.aHD();
            this.dAQ.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.dAO / 100.0f);
        this.dAQ.setTotalScrollY(this.dAQ.getTotalScrollY() - i);
        if (!this.dAQ.aHF()) {
            float itemHeight = this.dAQ.getItemHeight();
            float f = (-this.dAQ.getInitPosition()) * itemHeight;
            float itemsCount = ((this.dAQ.getItemsCount() - 1) - this.dAQ.getInitPosition()) * itemHeight;
            if (this.dAQ.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.dAQ.getTotalScrollY() + i;
            } else if (this.dAQ.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.dAQ.getTotalScrollY() + i;
            }
            if (this.dAQ.getTotalScrollY() <= f) {
                this.dAO = 40.0f;
                this.dAQ.setTotalScrollY((int) f);
            } else if (this.dAQ.getTotalScrollY() >= itemsCount) {
                this.dAQ.setTotalScrollY((int) itemsCount);
                this.dAO = -40.0f;
            }
        }
        if (this.dAO < 0.0f) {
            this.dAO += 20.0f;
        } else {
            this.dAO -= 20.0f;
        }
        this.dAQ.getHandler().sendEmptyMessage(1000);
    }
}
