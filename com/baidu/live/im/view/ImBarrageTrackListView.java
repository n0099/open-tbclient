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
    private List<LandscapeImBarrageTrackView> aja;
    private boolean ajb;
    private Queue<LandscapeImBarrageTrackView> ajc;
    private Handler handler;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.im.view.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.aja != null && !ImBarrageTrackListView.this.aja.isEmpty() && ImBarrageTrackListView.this.ajb) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.aja) {
                        landscapeImBarrageTrackView.tX();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.aja = new ArrayList(i);
        this.ajc = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.e.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.aja.add(landscapeImBarrageTrackView);
        }
    }

    public void tQ() {
        if (this.aja != null && this.ajc != null && !this.aja.isEmpty()) {
            this.ajc.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aja) {
                if (landscapeImBarrageTrackView != null) {
                    this.ajc.offer(landscapeImBarrageTrackView);
                }
            }
            this.ajb = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.aja != null && !this.aja.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aja) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean tR() {
        return (this.ajc == null || this.ajc.isEmpty()) ? false : true;
    }

    public void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.ajc != null && !this.ajc.contains(landscapeImBarrageTrackView)) {
            this.ajc.offer(landscapeImBarrageTrackView);
        }
    }

    public void sK() {
        if (this.aja != null && !this.aja.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aja) {
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
        if (this.ajc == null || this.ajc.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.ajc.poll();
        if (poll != null && poll.tR()) {
            poll.b(aoVar, uVar, aVar, str, str2, i);
        }
        return !this.ajc.isEmpty();
    }

    public void release() {
        this.ajb = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.ajc != null && !this.ajc.isEmpty()) {
            this.ajc.clear();
        }
        if (this.aja != null && !this.aja.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aja) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
