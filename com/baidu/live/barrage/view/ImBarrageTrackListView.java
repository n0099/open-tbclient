package com.baidu.live.barrage.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import com.baidu.live.barrage.view.LandscapeImBarrageTrackView;
import com.baidu.live.data.ar;
import com.baidu.live.data.ce;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes4.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aEP;
    private boolean aEQ;
    private Queue<LandscapeImBarrageTrackView> aER;
    private Handler handler;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.aEP != null && !ImBarrageTrackListView.this.aEP.isEmpty() && ImBarrageTrackListView.this.aEQ) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.aEP) {
                        landscapeImBarrageTrackView.CM();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.aEP = new ArrayList(i);
        this.aER = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.e.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.aEP.add(landscapeImBarrageTrackView);
        }
    }

    public void CJ() {
        if (this.aEP != null && this.aER != null && !this.aEP.isEmpty()) {
            this.aER.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aEP) {
                if (landscapeImBarrageTrackView != null) {
                    this.aER.offer(landscapeImBarrageTrackView);
                }
            }
            this.aEQ = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.aEP != null && !this.aEP.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aEP) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean CK() {
        return (this.aER == null || this.aER.isEmpty()) ? false : true;
    }

    public void b(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.aER != null && !this.aER.contains(landscapeImBarrageTrackView)) {
            this.aER.offer(landscapeImBarrageTrackView);
        }
    }

    public void Cs() {
        if (this.aEP != null && !this.aEP.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aEP) {
                landscapeImBarrageTrackView.post(new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageTrackListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        landscapeImBarrageTrackView.setVisibility(landscapeImBarrageTrackView.getTop() < 0 ? 4 : 0);
                    }
                });
            }
        }
    }

    public boolean a(ce ceVar, ar arVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        if (this.aER == null || this.aER.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.aER.poll();
        if (poll != null && poll.CK()) {
            poll.b(ceVar, arVar, aVar, str, str2, i);
        }
        return !this.aER.isEmpty();
    }

    public void release() {
        this.aEQ = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.aER != null && !this.aER.isEmpty()) {
            this.aER.clear();
        }
        if (this.aEP != null && !this.aEP.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aEP) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
