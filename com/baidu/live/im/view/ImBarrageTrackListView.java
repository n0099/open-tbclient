package com.baidu.live.im.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import com.baidu.live.data.ao;
import com.baidu.live.data.u;
import com.baidu.live.im.view.LandscapeImBarrageTrackView;
import com.baidu.live.k.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes6.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aiI;
    private boolean aiJ;
    private Queue<LandscapeImBarrageTrackView> aiK;
    private Handler handler;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.im.view.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.aiI != null && !ImBarrageTrackListView.this.aiI.isEmpty() && ImBarrageTrackListView.this.aiJ) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.aiI) {
                        landscapeImBarrageTrackView.tY();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.aiI = new ArrayList(i);
        this.aiK = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.e.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.aiI.add(landscapeImBarrageTrackView);
        }
    }

    public void tR() {
        if (this.aiI != null && this.aiK != null && !this.aiI.isEmpty()) {
            this.aiK.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aiI) {
                if (landscapeImBarrageTrackView != null) {
                    this.aiK.offer(landscapeImBarrageTrackView);
                }
            }
            this.aiJ = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.aiI != null && !this.aiI.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aiI) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean tS() {
        return (this.aiK == null || this.aiK.isEmpty()) ? false : true;
    }

    public void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.aiK != null && !this.aiK.contains(landscapeImBarrageTrackView)) {
            this.aiK.offer(landscapeImBarrageTrackView);
        }
    }

    public void sL() {
        if (this.aiI != null && !this.aiI.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aiI) {
                landscapeImBarrageTrackView.post(new Runnable() { // from class: com.baidu.live.im.view.ImBarrageTrackListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        landscapeImBarrageTrackView.setVisibility(landscapeImBarrageTrackView.getTop() < 0 ? 4 : 0);
                    }
                });
            }
        }
    }

    public boolean a(ao aoVar, u uVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        if (this.aiK == null || this.aiK.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.aiK.poll();
        if (poll != null && poll.tS()) {
            poll.b(aoVar, uVar, aVar, str, str2, i);
        }
        return !this.aiK.isEmpty();
    }

    public void release() {
        this.aiJ = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.aiK != null && !this.aiK.isEmpty()) {
            this.aiK.clear();
        }
        if (this.aiI != null && !this.aiI.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aiI) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
