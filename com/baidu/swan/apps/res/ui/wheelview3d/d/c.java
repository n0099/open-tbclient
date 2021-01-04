package com.baidu.swan.apps.res.ui.wheelview3d.d;

import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes9.dex */
public final class c extends TimerTask {
    private final WheelView3d dDu;
    private int dDy = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int dDz = 0;
    private int offset;

    public c(WheelView3d wheelView3d, int i) {
        this.dDu = wheelView3d;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.dDy == Integer.MAX_VALUE) {
            this.dDy = this.offset;
        }
        this.dDz = (int) (this.dDy * 0.1f);
        if (this.dDz == 0) {
            if (this.dDy < 0) {
                this.dDz = -1;
            } else {
                this.dDz = 1;
            }
        }
        if (Math.abs(this.dDy) <= 1) {
            this.dDu.aLd();
            this.dDu.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.dDu.setTotalScrollY(this.dDu.getTotalScrollY() + this.dDz);
        if (!this.dDu.aLf()) {
            float itemHeight = this.dDu.getItemHeight();
            float f = (-this.dDu.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.dDu.getItemsCount() - 1) - this.dDu.getInitPosition());
            if (this.dDu.getTotalScrollY() <= f || this.dDu.getTotalScrollY() >= itemsCount) {
                this.dDu.setTotalScrollY(this.dDu.getTotalScrollY() - this.dDz);
                this.dDu.aLd();
                this.dDu.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.dDu.getHandler().sendEmptyMessage(1000);
        this.dDy -= this.dDz;
    }
}
