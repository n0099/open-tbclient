package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes11.dex */
public final class c extends TimerTask {
    private final WheelView3d bNQ;
    private int offset;
    private int realTotalOffset = Integer.MAX_VALUE;
    private int realOffset = 0;

    public c(WheelView3d wheelView3d, int i) {
        this.bNQ = wheelView3d;
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
            this.bNQ.cancelFuture();
            this.bNQ.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.bNQ.setTotalScrollY(this.bNQ.getTotalScrollY() + this.realOffset);
        if (!this.bNQ.isLoop()) {
            float itemHeight = this.bNQ.getItemHeight();
            float f = (-this.bNQ.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.bNQ.getItemsCount() - 1) - this.bNQ.getInitPosition());
            if (this.bNQ.getTotalScrollY() <= f || this.bNQ.getTotalScrollY() >= itemsCount) {
                this.bNQ.setTotalScrollY(this.bNQ.getTotalScrollY() - this.realOffset);
                this.bNQ.cancelFuture();
                this.bNQ.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.bNQ.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
