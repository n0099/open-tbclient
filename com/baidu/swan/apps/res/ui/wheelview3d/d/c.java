package com.baidu.swan.apps.res.ui.wheelview3d.d;

import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class c extends TimerTask {
    private final WheelView3d dyI;
    private int dyM = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int dyN = 0;
    private int offset;

    public c(WheelView3d wheelView3d, int i) {
        this.dyI = wheelView3d;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.dyM == Integer.MAX_VALUE) {
            this.dyM = this.offset;
        }
        this.dyN = (int) (this.dyM * 0.1f);
        if (this.dyN == 0) {
            if (this.dyM < 0) {
                this.dyN = -1;
            } else {
                this.dyN = 1;
            }
        }
        if (Math.abs(this.dyM) <= 1) {
            this.dyI.aHk();
            this.dyI.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.dyI.setTotalScrollY(this.dyI.getTotalScrollY() + this.dyN);
        if (!this.dyI.aHm()) {
            float itemHeight = this.dyI.getItemHeight();
            float f = (-this.dyI.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.dyI.getItemsCount() - 1) - this.dyI.getInitPosition());
            if (this.dyI.getTotalScrollY() <= f || this.dyI.getTotalScrollY() >= itemsCount) {
                this.dyI.setTotalScrollY(this.dyI.getTotalScrollY() - this.dyN);
                this.dyI.aHk();
                this.dyI.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.dyI.getHandler().sendEmptyMessage(1000);
        this.dyM -= this.dyN;
    }
}
