package com.baidu.live.barrage.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import com.baidu.live.barrage.view.LandscapeImBarrageTrackView;
import com.baidu.live.data.ao;
import com.baidu.live.data.bz;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes4.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aBC;
    private boolean aBD;
    private Queue<LandscapeImBarrageTrackView> aBE;
    private Handler handler;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.aBC != null && !ImBarrageTrackListView.this.aBC.isEmpty() && ImBarrageTrackListView.this.aBD) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.aBC) {
                        landscapeImBarrageTrackView.BJ();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.aBC = new ArrayList(i);
        this.aBE = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.e.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.aBC.add(landscapeImBarrageTrackView);
        }
    }

    public void BG() {
        if (this.aBC != null && this.aBE != null && !this.aBC.isEmpty()) {
            this.aBE.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aBC) {
                if (landscapeImBarrageTrackView != null) {
                    this.aBE.offer(landscapeImBarrageTrackView);
                }
            }
            this.aBD = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.aBC != null && !this.aBC.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aBC) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean BH() {
        return (this.aBE == null || this.aBE.isEmpty()) ? false : true;
    }

    public void b(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.aBE != null && !this.aBE.contains(landscapeImBarrageTrackView)) {
            this.aBE.offer(landscapeImBarrageTrackView);
        }
    }

    public void Bp() {
        if (this.aBC != null && !this.aBC.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aBC) {
                landscapeImBarrageTrackView.post(new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        landscapeImBarrageTrackView.setVisibility(landscapeImBarrageTrackView.getTop() < 0 ? 4 : 0);
                    }
                });
            }
        }
    }

    public boolean a(bz bzVar, ao aoVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        if (this.aBE == null || this.aBE.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.aBE.poll();
        if (poll != null && poll.BH()) {
            poll.b(bzVar, aoVar, aVar, str, str2, i);
        }
        return !this.aBE.isEmpty();
    }

    public void release() {
        this.aBD = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.aBE != null && !this.aBE.isEmpty()) {
            this.aBE.clear();
        }
        if (this.aBC != null && !this.aBC.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aBC) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
