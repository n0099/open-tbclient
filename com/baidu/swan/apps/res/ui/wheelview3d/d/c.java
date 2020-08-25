package com.baidu.swan.apps.res.ui.wheelview3d.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class c extends TimerTask {
    private final WheelView3d cOF;
    private int offset;
    private int realTotalOffset = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int realOffset = 0;

    public c(WheelView3d wheelView3d, int i) {
        this.cOF = wheelView3d;
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
            this.cOF.cancelFuture();
            this.cOF.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.cOF.setTotalScrollY(this.cOF.getTotalScrollY() + this.realOffset);
        if (!this.cOF.isLoop()) {
            float itemHeight = this.cOF.getItemHeight();
            float f = (-this.cOF.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.cOF.getItemsCount() - 1) - this.cOF.getInitPosition());
            if (this.cOF.getTotalScrollY() <= f || this.cOF.getTotalScrollY() >= itemsCount) {
                this.cOF.setTotalScrollY(this.cOF.getTotalScrollY() - this.realOffset);
                this.cOF.cancelFuture();
                this.cOF.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.cOF.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
