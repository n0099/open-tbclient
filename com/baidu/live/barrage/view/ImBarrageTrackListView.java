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
/* loaded from: classes10.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aFr;
    private boolean aFs;
    private Queue<LandscapeImBarrageTrackView> aFt;
    private Handler handler;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.aFr != null && !ImBarrageTrackListView.this.aFr.isEmpty() && ImBarrageTrackListView.this.aFs) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.aFr) {
                        landscapeImBarrageTrackView.An();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.aFr = new ArrayList(i);
        this.aFt = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.d.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.aFr.add(landscapeImBarrageTrackView);
        }
    }

    public void Ak() {
        if (this.aFr != null && this.aFt != null && !this.aFr.isEmpty()) {
            this.aFt.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aFr) {
                if (landscapeImBarrageTrackView != null) {
                    this.aFt.offer(landscapeImBarrageTrackView);
                }
            }
            this.aFs = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.aFr != null && !this.aFr.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aFr) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean Al() {
        return (this.aFt == null || this.aFt.isEmpty()) ? false : true;
    }

    public void b(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.aFt != null && !this.aFt.contains(landscapeImBarrageTrackView)) {
            this.aFt.offer(landscapeImBarrageTrackView);
        }
    }

    public void zT() {
        if (this.aFr != null && !this.aFr.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aFr) {
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
        if (this.aFt == null || this.aFt.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.aFt.poll();
        if (poll != null && poll.Al()) {
            poll.b(crVar, baVar, aVar, str, str2, i);
        }
        return !this.aFt.isEmpty();
    }

    public void release() {
        this.aFs = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.aFt != null && !this.aFt.isEmpty()) {
            this.aFt.clear();
        }
        if (this.aFr != null && !this.aFr.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aFr) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
