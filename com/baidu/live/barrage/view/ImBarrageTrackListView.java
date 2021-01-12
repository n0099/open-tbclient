package com.baidu.live.barrage.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import com.baidu.live.barrage.view.LandscapeImBarrageTrackView;
import com.baidu.live.data.aw;
import com.baidu.live.data.ck;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes10.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aCe;
    private boolean aCf;
    private Queue<LandscapeImBarrageTrackView> aCg;
    private Handler handler;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.aCe != null && !ImBarrageTrackListView.this.aCe.isEmpty() && ImBarrageTrackListView.this.aCf) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.aCe) {
                        landscapeImBarrageTrackView.zA();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.aCe = new ArrayList(i);
        this.aCg = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.d.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.aCe.add(landscapeImBarrageTrackView);
        }
    }

    public void zx() {
        if (this.aCe != null && this.aCg != null && !this.aCe.isEmpty()) {
            this.aCg.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aCe) {
                if (landscapeImBarrageTrackView != null) {
                    this.aCg.offer(landscapeImBarrageTrackView);
                }
            }
            this.aCf = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.aCe != null && !this.aCe.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aCe) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean zy() {
        return (this.aCg == null || this.aCg.isEmpty()) ? false : true;
    }

    public void b(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.aCg != null && !this.aCg.contains(landscapeImBarrageTrackView)) {
            this.aCg.offer(landscapeImBarrageTrackView);
        }
    }

    public void zg() {
        if (this.aCe != null && !this.aCe.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aCe) {
                landscapeImBarrageTrackView.post(new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        landscapeImBarrageTrackView.setVisibility(landscapeImBarrageTrackView.getTop() < 0 ? 4 : 0);
                    }
                });
            }
        }
    }

    public boolean a(ck ckVar, aw awVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        if (this.aCg == null || this.aCg.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.aCg.poll();
        if (poll != null && poll.zy()) {
            poll.b(ckVar, awVar, aVar, str, str2, i);
        }
        return !this.aCg.isEmpty();
    }

    public void release() {
        this.aCf = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.aCg != null && !this.aCg.isEmpty()) {
            this.aCg.clear();
        }
        if (this.aCe != null && !this.aCe.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aCe) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
