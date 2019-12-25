package com.baidu.live.im.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import com.baidu.live.data.av;
import com.baidu.live.data.w;
import com.baidu.live.im.view.LandscapeImBarrageTrackView;
import com.baidu.live.q.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes2.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aqH;
    private Queue<LandscapeImBarrageTrackView> aqI;
    private Handler handler;
    private boolean isPlaying;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.im.view.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.aqH != null && !ImBarrageTrackListView.this.aqH.isEmpty() && ImBarrageTrackListView.this.isPlaying) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.aqH) {
                        landscapeImBarrageTrackView.vT();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.aqH = new ArrayList(i);
        this.aqI = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.e.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.aqH.add(landscapeImBarrageTrackView);
        }
    }

    public void vN() {
        if (this.aqH != null && this.aqI != null && !this.aqH.isEmpty()) {
            this.aqI.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aqH) {
                if (landscapeImBarrageTrackView != null) {
                    this.aqI.offer(landscapeImBarrageTrackView);
                }
            }
            this.isPlaying = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.aqH != null && !this.aqH.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aqH) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean vO() {
        return (this.aqI == null || this.aqI.isEmpty()) ? false : true;
    }

    public void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.aqI != null && !this.aqI.contains(landscapeImBarrageTrackView)) {
            this.aqI.offer(landscapeImBarrageTrackView);
        }
    }

    public void uD() {
        if (this.aqH != null && !this.aqH.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aqH) {
                landscapeImBarrageTrackView.post(new Runnable() { // from class: com.baidu.live.im.view.ImBarrageTrackListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        landscapeImBarrageTrackView.setVisibility(landscapeImBarrageTrackView.getTop() < 0 ? 4 : 0);
                    }
                });
            }
        }
    }

    public boolean a(av avVar, w wVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        if (this.aqI == null || this.aqI.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.aqI.poll();
        if (poll != null && poll.vO()) {
            poll.b(avVar, wVar, aVar, str, str2, i);
        }
        return !this.aqI.isEmpty();
    }

    public void release() {
        this.isPlaying = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.aqI != null && !this.aqI.isEmpty()) {
            this.aqI.clear();
        }
        if (this.aqH != null && !this.aqH.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aqH) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
