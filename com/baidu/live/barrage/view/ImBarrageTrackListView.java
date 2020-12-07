package com.baidu.live.barrage.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import com.baidu.live.barrage.view.LandscapeImBarrageTrackView;
import com.baidu.live.data.au;
import com.baidu.live.data.ci;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes4.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aGA;
    private boolean aGB;
    private Queue<LandscapeImBarrageTrackView> aGC;
    private Handler handler;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.aGA != null && !ImBarrageTrackListView.this.aGA.isEmpty() && ImBarrageTrackListView.this.aGB) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.aGA) {
                        landscapeImBarrageTrackView.Eg();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.aGA = new ArrayList(i);
        this.aGC = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.d.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.aGA.add(landscapeImBarrageTrackView);
        }
    }

    public void Ed() {
        if (this.aGA != null && this.aGC != null && !this.aGA.isEmpty()) {
            this.aGC.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aGA) {
                if (landscapeImBarrageTrackView != null) {
                    this.aGC.offer(landscapeImBarrageTrackView);
                }
            }
            this.aGB = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.aGA != null && !this.aGA.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aGA) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean Ee() {
        return (this.aGC == null || this.aGC.isEmpty()) ? false : true;
    }

    public void b(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.aGC != null && !this.aGC.contains(landscapeImBarrageTrackView)) {
            this.aGC.offer(landscapeImBarrageTrackView);
        }
    }

    public void DM() {
        if (this.aGA != null && !this.aGA.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aGA) {
                landscapeImBarrageTrackView.post(new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        landscapeImBarrageTrackView.setVisibility(landscapeImBarrageTrackView.getTop() < 0 ? 4 : 0);
                    }
                });
            }
        }
    }

    public boolean a(ci ciVar, au auVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        if (this.aGC == null || this.aGC.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.aGC.poll();
        if (poll != null && poll.Ee()) {
            poll.b(ciVar, auVar, aVar, str, str2, i);
        }
        return !this.aGC.isEmpty();
    }

    public void release() {
        this.aGB = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.aGC != null && !this.aGC.isEmpty()) {
            this.aGC.clear();
        }
        if (this.aGA != null && !this.aGA.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aGA) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
