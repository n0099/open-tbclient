package com.baidu.live.yuyinbarrage.view;

import android.widget.LinearLayout;
import java.util.List;
/* loaded from: classes10.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aFr;

    public void setCanAddNext() {
        if (this.aFr != null && !this.aFr.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aFr) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }
}
