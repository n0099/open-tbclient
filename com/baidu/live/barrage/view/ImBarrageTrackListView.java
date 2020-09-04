package com.baidu.live.barrage.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import com.baidu.live.barrage.view.LandscapeImBarrageTrackView;
import com.baidu.live.data.aj;
import com.baidu.live.data.br;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes7.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aAW;
    private boolean aAX;
    private Queue<LandscapeImBarrageTrackView> aAY;
    private Handler handler;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.aAW != null && !ImBarrageTrackListView.this.aAW.isEmpty() && ImBarrageTrackListView.this.aAX) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.aAW) {
                        landscapeImBarrageTrackView.Bu();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.aAW = new ArrayList(i);
        this.aAY = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.e.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.aAW.add(landscapeImBarrageTrackView);
        }
    }

    public void Br() {
        if (this.aAW != null && this.aAY != null && !this.aAW.isEmpty()) {
            this.aAY.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aAW) {
                if (landscapeImBarrageTrackView != null) {
                    this.aAY.offer(landscapeImBarrageTrackView);
                }
            }
            this.aAX = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.aAW != null && !this.aAW.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aAW) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean Bs() {
        return (this.aAY == null || this.aAY.isEmpty()) ? false : true;
    }

    public void b(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.aAY != null && !this.aAY.contains(landscapeImBarrageTrackView)) {
            this.aAY.offer(landscapeImBarrageTrackView);
        }
    }

    public void Ba() {
        if (this.aAW != null && !this.aAW.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aAW) {
                landscapeImBarrageTrackView.post(new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        landscapeImBarrageTrackView.setVisibility(landscapeImBarrageTrackView.getTop() < 0 ? 4 : 0);
                    }
                });
            }
        }
    }

    public boolean a(br brVar, aj ajVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        if (this.aAY == null || this.aAY.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.aAY.poll();
        if (poll != null && poll.Bs()) {
            poll.b(brVar, ajVar, aVar, str, str2, i);
        }
        return !this.aAY.isEmpty();
    }

    public void release() {
        this.aAX = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.aAY != null && !this.aAY.isEmpty()) {
            this.aAY.clear();
        }
        if (this.aAW != null && !this.aAW.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aAW) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
