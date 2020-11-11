package com.baidu.live.yuyinbarrage.view;

import android.widget.LinearLayout;
import java.util.List;
/* loaded from: classes4.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aFF;

    public void setCanAddNext() {
        if (this.aFF != null && !this.aFF.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aFF) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }
}
