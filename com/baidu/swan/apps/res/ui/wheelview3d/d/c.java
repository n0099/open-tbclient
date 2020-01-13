package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes10.dex */
public final class c extends TimerTask {
    private final WheelView3d bJy;
    private int offset;
    private int realTotalOffset = Integer.MAX_VALUE;
    private int realOffset = 0;

    public c(WheelView3d wheelView3d, int i) {
        this.bJy = wheelView3d;
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
            this.bJy.cancelFuture();
            this.bJy.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.bJy.setTotalScrollY(this.bJy.getTotalScrollY() + this.realOffset);
        if (!this.bJy.isLoop()) {
            float itemHeight = this.bJy.getItemHeight();
            float f = (-this.bJy.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.bJy.getItemsCount() - 1) - this.bJy.getInitPosition());
            if (this.bJy.getTotalScrollY() <= f || this.bJy.getTotalScrollY() >= itemsCount) {
                this.bJy.setTotalScrollY(this.bJy.getTotalScrollY() - this.realOffset);
                this.bJy.cancelFuture();
                this.bJy.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.bJy.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
