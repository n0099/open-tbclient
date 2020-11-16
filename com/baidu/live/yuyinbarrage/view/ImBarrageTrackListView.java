package com.baidu.live.yuyinbarrage.view;

import android.widget.LinearLayout;
import java.util.List;
/* loaded from: classes4.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aDU;

    public void setCanAddNext() {
        if (this.aDU != null && !this.aDU.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aDU) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }
}
