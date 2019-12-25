package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes9.dex */
public final class c extends TimerTask {
    private final WheelView3d bIO;
    private int offset;
    private int realTotalOffset = Integer.MAX_VALUE;
    private int realOffset = 0;

    public c(WheelView3d wheelView3d, int i) {
        this.bIO = wheelView3d;
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
            this.bIO.cancelFuture();
            this.bIO.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.bIO.setTotalScrollY(this.bIO.getTotalScrollY() + this.realOffset);
        if (!this.bIO.isLoop()) {
            float itemHeight = this.bIO.getItemHeight();
            float f = (-this.bIO.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.bIO.getItemsCount() - 1) - this.bIO.getInitPosition());
            if (this.bIO.getTotalScrollY() <= f || this.bIO.getTotalScrollY() >= itemsCount) {
                this.bIO.setTotalScrollY(this.bIO.getTotalScrollY() - this.realOffset);
                this.bIO.cancelFuture();
                this.bIO.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.bIO.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
