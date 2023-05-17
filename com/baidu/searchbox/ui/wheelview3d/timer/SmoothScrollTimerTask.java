package com.baidu.searchbox.ui.wheelview3d.timer;

import com.baidu.searchbox.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public final class SmoothScrollTimerTask extends TimerTask {
    public int offset;
    public final WheelView3d wheelView;
    public int realTotalOffset = Integer.MAX_VALUE;
    public int realOffset = 0;

    public SmoothScrollTimerTask(WheelView3d wheelView3d, int i) {
        this.wheelView = wheelView3d;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.realTotalOffset == Integer.MAX_VALUE) {
            this.realTotalOffset = this.offset;
        }
        int i = this.realTotalOffset;
        int i2 = (int) (i * 0.1f);
        this.realOffset = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.realOffset = -1;
            } else {
                this.realOffset = 1;
            }
        }
        if (Math.abs(this.realTotalOffset) <= 1) {
            this.wheelView.cancelFuture();
            this.wheelView.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView3d wheelView3d = this.wheelView;
        wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() + this.realOffset);
        if (!this.wheelView.isLoop()) {
            float itemHeight = this.wheelView.getItemHeight();
            float itemsCount = ((this.wheelView.getItemsCount() - 1) - this.wheelView.getInitPosition()) * itemHeight;
            if (this.wheelView.getTotalScrollY() <= (-this.wheelView.getInitPosition()) * itemHeight || this.wheelView.getTotalScrollY() >= itemsCount) {
                WheelView3d wheelView3d2 = this.wheelView;
                wheelView3d2.setTotalScrollY(wheelView3d2.getTotalScrollY() - this.realOffset);
                this.wheelView.cancelFuture();
                this.wheelView.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.wheelView.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
