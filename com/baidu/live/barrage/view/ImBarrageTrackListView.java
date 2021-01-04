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
/* loaded from: classes11.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aGR;
    private boolean aGS;
    private Queue<LandscapeImBarrageTrackView> aGT;
    private Handler handler;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.aGR != null && !ImBarrageTrackListView.this.aGR.isEmpty() && ImBarrageTrackListView.this.aGS) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.aGR) {
                        landscapeImBarrageTrackView.Dv();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.aGR = new ArrayList(i);
        this.aGT = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.d.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.aGR.add(landscapeImBarrageTrackView);
        }
    }

    public void Ds() {
        if (this.aGR != null && this.aGT != null && !this.aGR.isEmpty()) {
            this.aGT.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aGR) {
                if (landscapeImBarrageTrackView != null) {
                    this.aGT.offer(landscapeImBarrageTrackView);
                }
            }
            this.aGS = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.aGR != null && !this.aGR.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aGR) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean Dt() {
        return (this.aGT == null || this.aGT.isEmpty()) ? false : true;
    }

    public void b(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.aGT != null && !this.aGT.contains(landscapeImBarrageTrackView)) {
            this.aGT.offer(landscapeImBarrageTrackView);
        }
    }

    public void Db() {
        if (this.aGR != null && !this.aGR.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aGR) {
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
        if (this.aGT == null || this.aGT.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.aGT.poll();
        if (poll != null && poll.Dt()) {
            poll.b(ckVar, awVar, aVar, str, str2, i);
        }
        return !this.aGT.isEmpty();
    }

    public void release() {
        this.aGS = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.aGT != null && !this.aGT.isEmpty()) {
            this.aGT.clear();
        }
        if (this.aGR != null && !this.aGR.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aGR) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
