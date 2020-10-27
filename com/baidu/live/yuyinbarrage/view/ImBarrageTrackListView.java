package com.baidu.live.yuyinbarrage.view;

import android.widget.LinearLayout;
import java.util.List;
/* loaded from: classes4.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aEP;

    public void setCanAddNext() {
        if (this.aEP != null && !this.aEP.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aEP) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }
}
