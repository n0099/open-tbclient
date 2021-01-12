package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class a extends TimerTask {
    private float dyJ = 2.1474836E9f;
    private final float dyK;
    private final WheelView3d dyL;

    public a(WheelView3d wheelView3d, float f) {
        this.dyL = wheelView3d;
        this.dyK = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.dyJ == 2.1474836E9f) {
            if (Math.abs(this.dyK) > 2000.0f) {
                this.dyJ = this.dyK <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.dyJ = this.dyK;
            }
        }
        if (Math.abs(this.dyJ) >= 0.0f && Math.abs(this.dyJ) <= 20.0f) {
            this.dyL.aHk();
            this.dyL.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.dyJ / 100.0f);
        this.dyL.setTotalScrollY(this.dyL.getTotalScrollY() - i);
        if (!this.dyL.aHm()) {
            float itemHeight = this.dyL.getItemHeight();
            float f = (-this.dyL.getInitPosition()) * itemHeight;
            float itemsCount = ((this.dyL.getItemsCount() - 1) - this.dyL.getInitPosition()) * itemHeight;
            if (this.dyL.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.dyL.getTotalScrollY() + i;
            } else if (this.dyL.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.dyL.getTotalScrollY() + i;
            }
            if (this.dyL.getTotalScrollY() <= f) {
                this.dyJ = 40.0f;
                this.dyL.setTotalScrollY((int) f);
            } else if (this.dyL.getTotalScrollY() >= itemsCount) {
                this.dyL.setTotalScrollY((int) itemsCount);
                this.dyJ = -40.0f;
            }
        }
        if (this.dyJ < 0.0f) {
            this.dyJ += 20.0f;
        } else {
            this.dyJ -= 20.0f;
        }
        this.dyL.getHandler().sendEmptyMessage(1000);
    }
}
