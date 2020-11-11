package com.baidu.live.barrage.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import com.baidu.live.barrage.view.LandscapeImBarrageTrackView;
import com.baidu.live.data.at;
import com.baidu.live.data.cg;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes4.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aFF;
    private boolean aFG;
    private Queue<LandscapeImBarrageTrackView> aFH;
    private Handler handler;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.aFF != null && !ImBarrageTrackListView.this.aFF.isEmpty() && ImBarrageTrackListView.this.aFG) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.aFF) {
                        landscapeImBarrageTrackView.Df();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.aFF = new ArrayList(i);
        this.aFH = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.d.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.aFF.add(landscapeImBarrageTrackView);
        }
    }

    public void Dc() {
        if (this.aFF != null && this.aFH != null && !this.aFF.isEmpty()) {
            this.aFH.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aFF) {
                if (landscapeImBarrageTrackView != null) {
                    this.aFH.offer(landscapeImBarrageTrackView);
                }
            }
            this.aFG = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.aFF != null && !this.aFF.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aFF) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean Dd() {
        return (this.aFH == null || this.aFH.isEmpty()) ? false : true;
    }

    public void b(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.aFH != null && !this.aFH.contains(landscapeImBarrageTrackView)) {
            this.aFH.offer(landscapeImBarrageTrackView);
        }
    }

    public void CL() {
        if (this.aFF != null && !this.aFF.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aFF) {
                landscapeImBarrageTrackView.post(new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        landscapeImBarrageTrackView.setVisibility(landscapeImBarrageTrackView.getTop() < 0 ? 4 : 0);
                    }
                });
            }
        }
    }

    public boolean a(cg cgVar, at atVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        if (this.aFH == null || this.aFH.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.aFH.poll();
        if (poll != null && poll.Dd()) {
            poll.b(cgVar, atVar, aVar, str, str2, i);
        }
        return !this.aFH.isEmpty();
    }

    public void release() {
        this.aFG = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.aFH != null && !this.aFH.isEmpty()) {
            this.aFH.clear();
        }
        if (this.aFF != null && !this.aFF.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aFF) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
