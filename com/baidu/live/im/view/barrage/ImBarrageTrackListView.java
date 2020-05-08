package com.baidu.live.im.view.barrage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import com.baidu.live.data.ab;
import com.baidu.live.data.be;
import com.baidu.live.im.view.LandscapeImBarrageTrackView;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes3.dex */
public class ImBarrageTrackListView extends LinearLayout {
    private List<LandscapeImBarrageTrackView> aPo;
    private Queue<LandscapeImBarrageTrackView> aPp;
    private Handler handler;
    private boolean isPlaying;
    private Runnable runnable;

    public ImBarrageTrackListView(Context context, int i, LandscapeImBarrageTrackView.a aVar) {
        super(context);
        this.runnable = new Runnable() { // from class: com.baidu.live.im.view.barrage.ImBarrageTrackListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ImBarrageTrackListView.this.aPo != null && !ImBarrageTrackListView.this.aPo.isEmpty() && ImBarrageTrackListView.this.isPlaying) {
                    for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : ImBarrageTrackListView.this.aPo) {
                        landscapeImBarrageTrackView.Db();
                    }
                    ImBarrageTrackListView.this.handler.postDelayed(ImBarrageTrackListView.this.runnable, 16L);
                }
            }
        };
        setOrientation(1);
        this.handler = new Handler();
        this.aPo = new ArrayList(i);
        this.aPp = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            LandscapeImBarrageTrackView landscapeImBarrageTrackView = new LandscapeImBarrageTrackView(context);
            Resources resources = context.getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(a.e.sdk_ds56));
            if (i2 != 0) {
                layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            }
            landscapeImBarrageTrackView.setCallback(aVar);
            addView(landscapeImBarrageTrackView, layoutParams);
            this.aPo.add(landscapeImBarrageTrackView);
        }
    }

    public void Df() {
        if (this.aPo != null && this.aPp != null && !this.aPo.isEmpty()) {
            this.aPp.clear();
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aPo) {
                if (landscapeImBarrageTrackView != null) {
                    this.aPp.offer(landscapeImBarrageTrackView);
                }
            }
            this.isPlaying = true;
            if (this.handler != null) {
                this.handler.post(this.runnable);
            }
        }
    }

    public void setCanAddNext() {
        if (this.aPo != null && !this.aPo.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aPo) {
                landscapeImBarrageTrackView.setCanAddNext();
            }
        }
    }

    public boolean Da() {
        return (this.aPp == null || this.aPp.isEmpty()) ? false : true;
    }

    public void c(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
        if (this.aPp != null && !this.aPp.contains(landscapeImBarrageTrackView)) {
            this.aPp.offer(landscapeImBarrageTrackView);
        }
    }

    public void Bm() {
        if (this.aPo != null && !this.aPo.isEmpty()) {
            for (final LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aPo) {
                landscapeImBarrageTrackView.post(new Runnable() { // from class: com.baidu.live.im.view.barrage.ImBarrageTrackListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        landscapeImBarrageTrackView.setVisibility(landscapeImBarrageTrackView.getTop() < 0 ? 4 : 0);
                    }
                });
            }
        }
    }

    public boolean c(be beVar, ab abVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        if (this.aPp == null || this.aPp.isEmpty()) {
            return false;
        }
        LandscapeImBarrageTrackView poll = this.aPp.poll();
        if (poll != null && poll.Da()) {
            poll.a(beVar, abVar, aVar, str, str2, i);
        }
        return !this.aPp.isEmpty();
    }

    public void release() {
        this.isPlaying = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.aPp != null && !this.aPp.isEmpty()) {
            this.aPp.clear();
        }
        if (this.aPo != null && !this.aPo.isEmpty()) {
            for (LandscapeImBarrageTrackView landscapeImBarrageTrackView : this.aPo) {
                landscapeImBarrageTrackView.release();
            }
        }
    }
}
