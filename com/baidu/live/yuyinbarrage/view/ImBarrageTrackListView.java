package com.baidu.live.yuyinbarrage.view;

import android.widget.LinearLayout;
import java.util.List;
/* loaded from: classes11.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aGR;

    public void setCanAddNext() {
        if (this.aGR != null && !this.aGR.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aGR) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }
}
