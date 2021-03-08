package com.baidu.swan.apps.res.ui.wheelview3d.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class c extends TimerTask {
    private final WheelView3d dCo;
    private int dCs = Integer.MAX_VALUE;
    private int dCt = 0;
    private int offset;

    public c(WheelView3d wheelView3d, int i) {
        this.dCo = wheelView3d;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.dCs == Integer.MAX_VALUE) {
            this.dCs = this.offset;
        }
        this.dCt = (int) (this.dCs * 0.1f);
        if (this.dCt == 0) {
            if (this.dCs < 0) {
                this.dCt = -1;
            } else {
                this.dCt = 1;
            }
        }
        if (Math.abs(this.dCs) <= 1) {
            this.dCo.aHG();
            this.dCo.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.dCo.setTotalScrollY(this.dCo.getTotalScrollY() + this.dCt);
        if (!this.dCo.aHI()) {
            float itemHeight = this.dCo.getItemHeight();
            float f = (-this.dCo.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.dCo.getItemsCount() - 1) - this.dCo.getInitPosition());
            if (this.dCo.getTotalScrollY() <= f || this.dCo.getTotalScrollY() >= itemsCount) {
                this.dCo.setTotalScrollY(this.dCo.getTotalScrollY() - this.dCt);
                this.dCo.aHG();
                this.dCo.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.dCo.getHandler().sendEmptyMessage(1000);
        this.dCs -= this.dCt;
    }
}
