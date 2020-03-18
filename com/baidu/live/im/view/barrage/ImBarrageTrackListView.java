package com.baidu.live.im.view.barrage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import com.baidu.live.data.bb;
import com.baidu.live.data.z;
import com.baidu.live.im.view.LandscapeImBarrageTrackView;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes3.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> avF;
    private Queue<LandscapeImBarrageTrackView> avG;
    private Handler handler;
    private boolean isPlaying;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.im.view.barrage.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.avF != null && !ImBarrageTrackListView.this.avF.isEmpty() && ImBarrageTrackListView.this.isPlaying) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.avF) {
                        landscapeImBarrageTrackView.yk();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.avF = new ArrayList(i);
        this.avG = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.e.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.avF.add(landscapeImBarrageTrackView);
        }
    }

    public void yn() {
        if (this.avF != null && this.avG != null && !this.avF.isEmpty()) {
            this.avG.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.avF) {
                if (landscapeImBarrageTrackView != null) {
                    this.avG.offer(landscapeImBarrageTrackView);
                }
            }
            this.isPlaying = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.avF != null && !this.avF.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.avF) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean yj() {
        return (this.avG == null || this.avG.isEmpty()) ? false : true;
    }

    public void c(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.avG != null && !this.avG.contains(landscapeImBarrageTrackView)) {
            this.avG.offer(landscapeImBarrageTrackView);
        }
    }

    public void wD() {
        if (this.avF != null && !this.avF.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.avF) {
                landscapeImBarrageTrackView.post(new Runnable() { // from class: com.baidu.live.im.view.barrage.ImBarrageTrackListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        landscapeImBarrageTrackView.setVisibility(landscapeImBarrageTrackView.getTop() < 0 ? 4 : 0);
                    }
                });
            }
        }
    }

    public boolean c(bb bbVar, z zVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        if (this.avG == null || this.avG.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.avG.poll();
        if (poll != null && poll.yj()) {
            poll.a(bbVar, zVar, aVar, str, str2, i);
        }
        return !this.avG.isEmpty();
    }

    public void release() {
        this.isPlaying = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.avG != null && !this.avG.isEmpty()) {
            this.avG.clear();
        }
        if (this.avF != null && !this.avF.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.avF) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
