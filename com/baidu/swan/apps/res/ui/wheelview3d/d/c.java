package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes11.dex */
public final class c extends TimerTask {
    private final WheelView3d bNF;
    private int offset;
    private int realTotalOffset = Integer.MAX_VALUE;
    private int realOffset = 0;

    public c(WheelView3d wheelView3d, int i) {
        this.bNF = wheelView3d;
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
            this.bNF.cancelFuture();
            this.bNF.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.bNF.setTotalScrollY(this.bNF.getTotalScrollY() + this.realOffset);
        if (!this.bNF.isLoop()) {
            float itemHeight = this.bNF.getItemHeight();
            float f = (-this.bNF.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.bNF.getItemsCount() - 1) - this.bNF.getInitPosition());
            if (this.bNF.getTotalScrollY() <= f || this.bNF.getTotalScrollY() >= itemsCount) {
                this.bNF.setTotalScrollY(this.bNF.getTotalScrollY() - this.realOffset);
                this.bNF.cancelFuture();
                this.bNF.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.bNF.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
