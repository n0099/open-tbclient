package com.baidu.live.im.view.barrage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import com.baidu.live.data.af;
import com.baidu.live.data.bj;
import com.baidu.live.im.view.LandscapeImBarrageTrackView;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes3.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aVx;
    private Queue<LandscapeImBarrageTrackView> aVy;
    private Handler handler;
    private boolean isPlaying;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.im.view.barrage.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.aVx != null && !ImBarrageTrackListView.this.aVx.isEmpty() && ImBarrageTrackListView.this.isPlaying) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.aVx) {
                        landscapeImBarrageTrackView.Ez();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.aVx = new ArrayList(i);
        this.aVy = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.e.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.aVx.add(landscapeImBarrageTrackView);
        }
    }

    public void ED() {
        if (this.aVx != null && this.aVy != null && !this.aVx.isEmpty()) {
            this.aVy.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aVx) {
                if (landscapeImBarrageTrackView != null) {
                    this.aVy.offer(landscapeImBarrageTrackView);
                }
            }
            this.isPlaying = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.aVx != null && !this.aVx.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aVx) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean Ey() {
        return (this.aVy == null || this.aVy.isEmpty()) ? false : true;
    }

    public void c(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.aVy != null && !this.aVy.contains(landscapeImBarrageTrackView)) {
            this.aVy.offer(landscapeImBarrageTrackView);
        }
    }

    public void CJ() {
        if (this.aVx != null && !this.aVx.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aVx) {
                landscapeImBarrageTrackView.post(new Runnable() { // from class: com.baidu.live.im.view.barrage.ImBarrageTrackListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        landscapeImBarrageTrackView.setVisibility(landscapeImBarrageTrackView.getTop() < 0 ? 4 : 0);
                    }
                });
            }
        }
    }

    public boolean c(bj bjVar, af afVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        if (this.aVy == null || this.aVy.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.aVy.poll();
        if (poll != null && poll.Ey()) {
            poll.a(bjVar, afVar, aVar, str, str2, i);
        }
        return !this.aVy.isEmpty();
    }

    public void release() {
        this.isPlaying = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.aVy != null && !this.aVy.isEmpty()) {
            this.aVy.clear();
        }
        if (this.aVx != null && !this.aVx.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aVx) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
