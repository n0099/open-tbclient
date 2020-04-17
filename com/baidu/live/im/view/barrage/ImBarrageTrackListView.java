package com.baidu.live.im.view.barrage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import com.baidu.live.data.ab;
import com.baidu.live.data.be;
import com.baidu.live.im.view.LandscapeImBarrageTrackView;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes3.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aPi;
    private Queue<LandscapeImBarrageTrackView> aPj;
    private Handler handler;
    private boolean isPlaying;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.im.view.barrage.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.aPi != null && !ImBarrageTrackListView.this.aPi.isEmpty() && ImBarrageTrackListView.this.isPlaying) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.aPi) {
                        landscapeImBarrageTrackView.Dc();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.aPi = new ArrayList(i);
        this.aPj = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.e.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.aPi.add(landscapeImBarrageTrackView);
        }
    }

    public void Dg() {
        if (this.aPi != null && this.aPj != null && !this.aPi.isEmpty()) {
            this.aPj.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aPi) {
                if (landscapeImBarrageTrackView != null) {
                    this.aPj.offer(landscapeImBarrageTrackView);
                }
            }
            this.isPlaying = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.aPi != null && !this.aPi.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aPi) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean Db() {
        return (this.aPj == null || this.aPj.isEmpty()) ? false : true;
    }

    public void c(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.aPj != null && !this.aPj.contains(landscapeImBarrageTrackView)) {
            this.aPj.offer(landscapeImBarrageTrackView);
        }
    }

    public void Bn() {
        if (this.aPi != null && !this.aPi.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aPi) {
                landscapeImBarrageTrackView.post(new Runnable() { // from class: com.baidu.live.im.view.barrage.ImBarrageTrackListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        landscapeImBarrageTrackView.setVisibility(landscapeImBarrageTrackView.getTop() < 0 ? 4 : 0);
                    }
                });
            }
        }
    }

    public boolean c(be beVar, ab abVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        if (this.aPj == null || this.aPj.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.aPj.poll();
        if (poll != null && poll.Db()) {
            poll.a(beVar, abVar, aVar, str, str2, i);
        }
        return !this.aPj.isEmpty();
    }

    public void release() {
        this.isPlaying = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.aPj != null && !this.aPj.isEmpty()) {
            this.aPj.clear();
        }
        if (this.aPi != null && !this.aPi.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aPi) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
