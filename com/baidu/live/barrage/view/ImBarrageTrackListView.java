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
    private List<LandscapeImBarrageTrackView> aAU;
    private boolean aAV;
    private Queue<LandscapeImBarrageTrackView> aAW;
    private Handler handler;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.aAU != null && !ImBarrageTrackListView.this.aAU.isEmpty() && ImBarrageTrackListView.this.aAV) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.aAU) {
                        landscapeImBarrageTrackView.Bu();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.aAU = new ArrayList(i);
        this.aAW = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.e.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.aAU.add(landscapeImBarrageTrackView);
        }
    }

    public void Br() {
        if (this.aAU != null && this.aAW != null && !this.aAU.isEmpty()) {
            this.aAW.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aAU) {
                if (landscapeImBarrageTrackView != null) {
                    this.aAW.offer(landscapeImBarrageTrackView);
                }
            }
            this.aAV = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.aAU != null && !this.aAU.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aAU) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean Bs() {
        return (this.aAW == null || this.aAW.isEmpty()) ? false : true;
    }

    public void b(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.aAW != null && !this.aAW.contains(landscapeImBarrageTrackView)) {
            this.aAW.offer(landscapeImBarrageTrackView);
        }
    }

    public void Ba() {
        if (this.aAU != null && !this.aAU.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aAU) {
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
        if (this.aAW == null || this.aAW.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.aAW.poll();
        if (poll != null && poll.Bs()) {
            poll.b(brVar, ajVar, aVar, str, str2, i);
        }
        return !this.aAW.isEmpty();
    }

    public void release() {
        this.aAV = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.aAW != null && !this.aAW.isEmpty()) {
            this.aAW.clear();
        }
        if (this.aAU != null && !this.aAU.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aAU) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
