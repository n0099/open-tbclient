package com.baidu.swan.apps.res.ui.wheelview3d.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class c extends TimerTask {
    private final WheelView3d cOJ;
    private int offset;
    private int realTotalOffset = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int realOffset = 0;

    public c(WheelView3d wheelView3d, int i) {
        this.cOJ = wheelView3d;
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
            this.cOJ.cancelFuture();
            this.cOJ.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.cOJ.setTotalScrollY(this.cOJ.getTotalScrollY() + this.realOffset);
        if (!this.cOJ.isLoop()) {
            float itemHeight = this.cOJ.getItemHeight();
            float f = (-this.cOJ.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.cOJ.getItemsCount() - 1) - this.cOJ.getInitPosition());
            if (this.cOJ.getTotalScrollY() <= f || this.cOJ.getTotalScrollY() >= itemsCount) {
                this.cOJ.setTotalScrollY(this.cOJ.getTotalScrollY() - this.realOffset);
                this.cOJ.cancelFuture();
                this.cOJ.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.cOJ.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
