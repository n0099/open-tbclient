package com.baidu.live.yuyinbarrage.view;

import android.widget.LinearLayout;
import java.util.List;
/* loaded from: classes10.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aCe;

    public void setCanAddNext() {
        if (this.aCe != null && !this.aCe.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aCe) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }
}
