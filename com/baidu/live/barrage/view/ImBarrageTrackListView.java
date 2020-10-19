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
    private List<LandscapeImBarrageTrackView> aEH;
    private boolean aEI;
    private Queue<LandscapeImBarrageTrackView> aEJ;
    private Handler handler;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.aEH != null && !ImBarrageTrackListView.this.aEH.isEmpty() && ImBarrageTrackListView.this.aEI) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.aEH) {
                        landscapeImBarrageTrackView.CG();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.aEH = new ArrayList(i);
        this.aEJ = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.e.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.aEH.add(landscapeImBarrageTrackView);
        }
    }

    public void CD() {
        if (this.aEH != null && this.aEJ != null && !this.aEH.isEmpty()) {
            this.aEJ.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aEH) {
                if (landscapeImBarrageTrackView != null) {
                    this.aEJ.offer(landscapeImBarrageTrackView);
                }
            }
            this.aEI = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.aEH != null && !this.aEH.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aEH) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean CE() {
        return (this.aEJ == null || this.aEJ.isEmpty()) ? false : true;
    }

    public void b(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.aEJ != null && !this.aEJ.contains(landscapeImBarrageTrackView)) {
            this.aEJ.offer(landscapeImBarrageTrackView);
        }
    }

    public void Cm() {
        if (this.aEH != null && !this.aEH.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aEH) {
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
        if (this.aEJ == null || this.aEJ.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.aEJ.poll();
        if (poll != null && poll.CE()) {
            poll.b(bzVar, aoVar, aVar, str, str2, i);
        }
        return !this.aEJ.isEmpty();
    }

    public void release() {
        this.aEI = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.aEJ != null && !this.aEJ.isEmpty()) {
            this.aEJ.clear();
        }
        if (this.aEH != null && !this.aEH.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aEH) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
