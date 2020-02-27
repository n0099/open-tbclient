package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes11.dex */
public final class c extends TimerTask {
    private final WheelView3d bND;
    private int offset;
    private int realTotalOffset = Integer.MAX_VALUE;
    private int realOffset = 0;

    public c(WheelView3d wheelView3d, int i) {
        this.bND = wheelView3d;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.realTotalOffset == Integer.MAX_VALUE) {
            this.realTotalOffset = this.offset;
        }
        this.realOffset = (int) (this.realTotalOffset * 0.1f);
        if (this.realOffset == 0) {
            if (this.realTotalOffset < 0) {
                this.realOffset = -1;
            } else {
                this.realOffset = 1;
            }
        }
        if (Math.abs(this.realTotalOffset) <= 1) {
            this.bND.cancelFuture();
            this.bND.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.bND.setTotalScrollY(this.bND.getTotalScrollY() + this.realOffset);
        if (!this.bND.isLoop()) {
            float itemHeight = this.bND.getItemHeight();
            float f = (-this.bND.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.bND.getItemsCount() - 1) - this.bND.getInitPosition());
            if (this.bND.getTotalScrollY() <= f || this.bND.getTotalScrollY() >= itemsCount) {
                this.bND.setTotalScrollY(this.bND.getTotalScrollY() - this.realOffset);
                this.bND.cancelFuture();
                this.bND.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.bND.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
