package com.baidu.live.barrage.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import com.baidu.live.barrage.view.LandscapeImBarrageTrackView;
import com.baidu.live.data.ah;
import com.baidu.live.data.bp;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes4.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> avS;
    private boolean avT;
    private Queue<LandscapeImBarrageTrackView> avU;
    private Handler handler;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.avS != null && !ImBarrageTrackListView.this.avS.isEmpty() && ImBarrageTrackListView.this.avT) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.avS) {
                        landscapeImBarrageTrackView.vW();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.avS = new ArrayList(i);
        this.avU = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.e.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.avS.add(landscapeImBarrageTrackView);
        }
    }

    public void vT() {
        if (this.avS != null && this.avU != null && !this.avS.isEmpty()) {
            this.avU.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.avS) {
                if (landscapeImBarrageTrackView != null) {
                    this.avU.offer(landscapeImBarrageTrackView);
                }
            }
            this.avT = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.avS != null && !this.avS.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.avS) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean vU() {
        return (this.avU == null || this.avU.isEmpty()) ? false : true;
    }

    public void b(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.avU != null && !this.avU.contains(landscapeImBarrageTrackView)) {
            this.avU.offer(landscapeImBarrageTrackView);
        }
    }

    public void vC() {
        if (this.avS != null && !this.avS.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.avS) {
                landscapeImBarrageTrackView.post(new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        landscapeImBarrageTrackView.setVisibility(landscapeImBarrageTrackView.getTop() < 0 ? 4 : 0);
                    }
                });
            }
        }
    }

    public boolean a(bp bpVar, ah ahVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        if (this.avU == null || this.avU.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.avU.poll();
        if (poll != null && poll.vU()) {
            poll.b(bpVar, ahVar, aVar, str, str2, i);
        }
        return !this.avU.isEmpty();
    }

    public void release() {
        this.avT = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.avU != null && !this.avU.isEmpty()) {
            this.avU.clear();
        }
        if (this.avS != null && !this.avS.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.avS) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
