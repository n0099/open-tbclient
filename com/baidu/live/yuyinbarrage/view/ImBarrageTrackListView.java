package com.baidu.live.yuyinbarrage.view;

import android.widget.LinearLayout;
import java.util.List;
/* loaded from: classes11.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aDR;

    public void setCanAddNext() {
        if (this.aDR != null && !this.aDR.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aDR) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }
}
