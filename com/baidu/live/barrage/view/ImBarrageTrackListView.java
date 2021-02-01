package com.baidu.live.barrage.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import com.baidu.live.barrage.view.LandscapeImBarrageTrackView;
import com.baidu.live.data.ba;
import com.baidu.live.data.cr;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes11.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aDR;
    private boolean aDS;
    private Queue<LandscapeImBarrageTrackView> aDT;
    private Handler handler;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.aDR != null && !ImBarrageTrackListView.this.aDR.isEmpty() && ImBarrageTrackListView.this.aDS) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.aDR) {
                        landscapeImBarrageTrackView.Ak();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.aDR = new ArrayList(i);
        this.aDT = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.d.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.aDR.add(landscapeImBarrageTrackView);
        }
    }

    public void Ah() {
        if (this.aDR != null && this.aDT != null && !this.aDR.isEmpty()) {
            this.aDT.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aDR) {
                if (landscapeImBarrageTrackView != null) {
                    this.aDT.offer(landscapeImBarrageTrackView);
                }
            }
            this.aDS = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.aDR != null && !this.aDR.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aDR) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean Ai() {
        return (this.aDT == null || this.aDT.isEmpty()) ? false : true;
    }

    public void b(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.aDT != null && !this.aDT.contains(landscapeImBarrageTrackView)) {
            this.aDT.offer(landscapeImBarrageTrackView);
        }
    }

    public void zQ() {
        if (this.aDR != null && !this.aDR.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aDR) {
                landscapeImBarrageTrackView.post(new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        landscapeImBarrageTrackView.setVisibility(landscapeImBarrageTrackView.getTop() < 0 ? 4 : 0);
                    }
                });
            }
        }
    }

    public boolean a(cr crVar, ba baVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        if (this.aDT == null || this.aDT.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.aDT.poll();
        if (poll != null && poll.Ai()) {
            poll.b(crVar, baVar, aVar, str, str2, i);
        }
        return !this.aDT.isEmpty();
    }

    public void release() {
        this.aDS = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.aDT != null && !this.aDT.isEmpty()) {
            this.aDT.clear();
        }
        if (this.aDR != null && !this.aDR.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aDR) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
