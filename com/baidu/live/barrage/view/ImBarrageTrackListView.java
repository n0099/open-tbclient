package com.baidu.live.barrage.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import com.baidu.live.barrage.view.LandscapeImBarrageTrackView;
import com.baidu.live.data.at;
import com.baidu.live.data.cg;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes4.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aDU;
    private boolean aDV;
    private Queue<LandscapeImBarrageTrackView> aDW;
    private Handler handler;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.aDU != null && !ImBarrageTrackListView.this.aDU.isEmpty() && ImBarrageTrackListView.this.aDV) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.aDU) {
                        landscapeImBarrageTrackView.Cw();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.aDU = new ArrayList(i);
        this.aDW = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.d.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.aDU.add(landscapeImBarrageTrackView);
        }
    }

    public void Ct() {
        if (this.aDU != null && this.aDW != null && !this.aDU.isEmpty()) {
            this.aDW.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aDU) {
                if (landscapeImBarrageTrackView != null) {
                    this.aDW.offer(landscapeImBarrageTrackView);
                }
            }
            this.aDV = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.aDU != null && !this.aDU.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aDU) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean Cu() {
        return (this.aDW == null || this.aDW.isEmpty()) ? false : true;
    }

    public void b(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.aDW != null && !this.aDW.contains(landscapeImBarrageTrackView)) {
            this.aDW.offer(landscapeImBarrageTrackView);
        }
    }

    public void Cc() {
        if (this.aDU != null && !this.aDU.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aDU) {
                landscapeImBarrageTrackView.post(new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        landscapeImBarrageTrackView.setVisibility(landscapeImBarrageTrackView.getTop() < 0 ? 4 : 0);
                    }
                });
            }
        }
    }

    public boolean a(cg cgVar, at atVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        if (this.aDW == null || this.aDW.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.aDW.poll();
        if (poll != null && poll.Cu()) {
            poll.b(cgVar, atVar, aVar, str, str2, i);
        }
        return !this.aDW.isEmpty();
    }

    public void release() {
        this.aDV = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.aDW != null && !this.aDW.isEmpty()) {
            this.aDW.clear();
        }
        if (this.aDU != null && !this.aDU.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aDU) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
