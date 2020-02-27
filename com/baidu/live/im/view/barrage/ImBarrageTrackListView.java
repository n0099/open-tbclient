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
    private List<LandscapeImBarrageTrackView> avu;
    private Queue<LandscapeImBarrageTrackView> avv;
    private Handler handler;
    private boolean isPlaying;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.im.view.barrage.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.avu != null && !ImBarrageTrackListView.this.avu.isEmpty() && ImBarrageTrackListView.this.isPlaying) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.avu) {
                        landscapeImBarrageTrackView.yf();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.avu = new ArrayList(i);
        this.avv = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.e.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.avu.add(landscapeImBarrageTrackView);
        }
    }

    public void yi() {
        if (this.avu != null && this.avv != null && !this.avu.isEmpty()) {
            this.avv.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.avu) {
                if (landscapeImBarrageTrackView != null) {
                    this.avv.offer(landscapeImBarrageTrackView);
                }
            }
            this.isPlaying = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.avu != null && !this.avu.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.avu) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean ye() {
        return (this.avv == null || this.avv.isEmpty()) ? false : true;
    }

    public void c(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.avv != null && !this.avv.contains(landscapeImBarrageTrackView)) {
            this.avv.offer(landscapeImBarrageTrackView);
        }
    }

    public void wy() {
        if (this.avu != null && !this.avu.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.avu) {
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
        if (this.avv == null || this.avv.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.avv.poll();
        if (poll != null && poll.ye()) {
            poll.a(bbVar, zVar, aVar, str, str2, i);
        }
        return !this.avv.isEmpty();
    }

    public void release() {
        this.isPlaying = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.avv != null && !this.avv.isEmpty()) {
            this.avv.clear();
        }
        if (this.avu != null && !this.avu.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.avu) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
