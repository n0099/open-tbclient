package com.baidu.live.im.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import com.baidu.live.data.az;
import com.baidu.live.data.y;
import com.baidu.live.im.view.LandscapeImBarrageTrackView;
import com.baidu.live.r.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes2.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> art;
    private Queue<LandscapeImBarrageTrackView> aru;
    private Handler handler;
    private boolean isPlaying;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.im.view.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.art != null && !ImBarrageTrackListView.this.art.isEmpty() && ImBarrageTrackListView.this.isPlaying) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.art) {
                        landscapeImBarrageTrackView.wk();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.art = new ArrayList(i);
        this.aru = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.e.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.art.add(landscapeImBarrageTrackView);
        }
    }

    public void we() {
        if (this.art != null && this.aru != null && !this.art.isEmpty()) {
            this.aru.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.art) {
                if (landscapeImBarrageTrackView != null) {
                    this.aru.offer(landscapeImBarrageTrackView);
                }
            }
            this.isPlaying = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.art != null && !this.art.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.art) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean wf() {
        return (this.aru == null || this.aru.isEmpty()) ? false : true;
    }

    public void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.aru != null && !this.aru.contains(landscapeImBarrageTrackView)) {
            this.aru.offer(landscapeImBarrageTrackView);
        }
    }

    public void uU() {
        if (this.art != null && !this.art.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.art) {
                landscapeImBarrageTrackView.post(new Runnable() { // from class: com.baidu.live.im.view.ImBarrageTrackListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        landscapeImBarrageTrackView.setVisibility(landscapeImBarrageTrackView.getTop() < 0 ? 4 : 0);
                    }
                });
            }
        }
    }

    public boolean a(az azVar, y yVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        if (this.aru == null || this.aru.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.aru.poll();
        if (poll != null && poll.wf()) {
            poll.b(azVar, yVar, aVar, str, str2, i);
        }
        return !this.aru.isEmpty();
    }

    public void release() {
        this.isPlaying = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.aru != null && !this.aru.isEmpty()) {
            this.aru.clear();
        }
        if (this.art != null && !this.art.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.art) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
