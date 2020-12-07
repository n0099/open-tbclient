package com.baidu.live.yuyinbarrage.view;

import android.widget.LinearLayout;
import java.util.List;
/* loaded from: classes4.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aGA;

    public void setCanAddNext() {
        if (this.aGA != null && !this.aGA.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aGA) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }
}
