package com.baidu.live.im.view.barrage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import com.baidu.live.data.ag;
import com.baidu.live.data.bo;
import com.baidu.live.im.view.LandscapeImBarrageTrackView;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes3.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aYe;
    private Queue<LandscapeImBarrageTrackView> aYf;
    private Handler handler;
    private boolean isPlaying;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.im.view.barrage.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.aYe != null && !ImBarrageTrackListView.this.aYe.isEmpty() && ImBarrageTrackListView.this.isPlaying) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.aYe) {
                        landscapeImBarrageTrackView.Fd();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.aYe = new ArrayList(i);
        this.aYf = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.e.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.aYe.add(landscapeImBarrageTrackView);
        }
    }

    public void Fh() {
        if (this.aYe != null && this.aYf != null && !this.aYe.isEmpty()) {
            this.aYf.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aYe) {
                if (landscapeImBarrageTrackView != null) {
                    this.aYf.offer(landscapeImBarrageTrackView);
                }
            }
            this.isPlaying = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.aYe != null && !this.aYe.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aYe) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean Fc() {
        return (this.aYf == null || this.aYf.isEmpty()) ? false : true;
    }

    public void c(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.aYf != null && !this.aYf.contains(landscapeImBarrageTrackView)) {
            this.aYf.offer(landscapeImBarrageTrackView);
        }
    }

    public void Dk() {
        if (this.aYe != null && !this.aYe.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aYe) {
                landscapeImBarrageTrackView.post(new Runnable() { // from class: com.baidu.live.im.view.barrage.ImBarrageTrackListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        landscapeImBarrageTrackView.setVisibility(landscapeImBarrageTrackView.getTop() < 0 ? 4 : 0);
                    }
                });
            }
        }
    }

    public boolean c(bo boVar, ag agVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        if (this.aYf == null || this.aYf.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.aYf.poll();
        if (poll != null && poll.Fc()) {
            poll.a(boVar, agVar, aVar, str, str2, i);
        }
        return !this.aYf.isEmpty();
    }

    public void release() {
        this.isPlaying = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.aYf != null && !this.aYf.isEmpty()) {
            this.aYf.clear();
        }
        if (this.aYe != null && !this.aYe.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aYe) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
