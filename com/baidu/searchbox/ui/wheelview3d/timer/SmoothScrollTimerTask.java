package com.baidu.searchbox.ui.wheelview3d.timer;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes19.dex */
public final class SmoothScrollTimerTask extends TimerTask {
    private int offset;
    private final WheelView3d wheelView;
    private int realTotalOffset = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int realOffset = 0;

    public SmoothScrollTimerTask(WheelView3d wheelView3d, int i) {
        this.wheelView = wheelView3d;
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
            this.wheelView.cancelFuture();
            this.wheelView.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.wheelView.setTotalScrollY(this.wheelView.getTotalScrollY() + this.realOffset);
        if (!this.wheelView.isLoop()) {
            float itemHeight = this.wheelView.getItemHeight();
            float f = (-this.wheelView.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.wheelView.getItemsCount() - 1) - this.wheelView.getInitPosition());
            if (this.wheelView.getTotalScrollY() <= f || this.wheelView.getTotalScrollY() >= itemsCount) {
                this.wheelView.setTotalScrollY(this.wheelView.getTotalScrollY() - this.realOffset);
                this.wheelView.cancelFuture();
                this.wheelView.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.wheelView.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
