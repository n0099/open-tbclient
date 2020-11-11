package com.baidu.swan.apps.res.ui.wheelview3d.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes10.dex */
public final class c extends TimerTask {
    private final WheelView3d drl;
    private int offset;
    private int realTotalOffset = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int realOffset = 0;

    public c(WheelView3d wheelView3d, int i) {
        this.drl = wheelView3d;
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
            this.drl.cancelFuture();
            this.drl.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.drl.setTotalScrollY(this.drl.getTotalScrollY() + this.realOffset);
        if (!this.drl.isLoop()) {
            float itemHeight = this.drl.getItemHeight();
            float f = (-this.drl.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.drl.getItemsCount() - 1) - this.drl.getInitPosition());
            if (this.drl.getTotalScrollY() <= f || this.drl.getTotalScrollY() >= itemsCount) {
                this.drl.setTotalScrollY(this.drl.getTotalScrollY() - this.realOffset);
                this.drl.cancelFuture();
                this.drl.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.drl.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
