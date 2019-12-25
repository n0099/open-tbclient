package com.baidu.live.im.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.data.av;
import com.baidu.live.data.w;
import com.baidu.live.im.view.LandscapeImBarrageItemView;
import com.baidu.live.q.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class LandscapeImBarrageTrackView extends FrameLayout {
    private int aqM;
    private int aqN;
    private boolean aqO;
    private a arb;
    private List<View> arc;

    /* loaded from: classes2.dex */
    public interface a {
        void c(LandscapeImBarrageTrackView landscapeImBarrageTrackView);

        void d(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.arb = aVar;
    }

    public boolean vO() {
        return this.aqO;
    }

    public void setCanAddNext() {
        this.aqO = true;
    }

    public void b(av avVar, w wVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aqO = false;
        LandscapeImBarrageItemView c = c(avVar, wVar, aVar, str, str2, i);
        c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = c.getMeasuredWidth();
        c.aqY = getWidth() + c.getMeasuredWidth();
        c.aqX = ((c.aqY * 1.0f) / this.aqM) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(c, layoutParams);
    }

    public void vT() {
        if (this.arc != null && !this.arc.isEmpty()) {
            for (View view : this.arc) {
                removeView(view);
            }
            this.arc.clear();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            vP();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof LandscapeImBarrageItemView) && childAt.getVisibility() == 0) {
                a((LandscapeImBarrageItemView) childAt, currentTimeMillis);
            }
        }
    }

    private void a(LandscapeImBarrageItemView landscapeImBarrageItemView, long j) {
        int i;
        long j2 = j - landscapeImBarrageItemView.timeStamp;
        if (j2 > landscapeImBarrageItemView.aqX) {
            this.arc.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.aqM);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.aqN < getWidth()) {
            vP();
        }
    }

    public void release() {
        removeAllViews();
        if (this.arc != null) {
            this.arc.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.arc = new ArrayList();
        this.aqM = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.aqN = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }

    private LandscapeImBarrageItemView c(av avVar, w wVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setEffectInfo(wVar);
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setUIInfo(avVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.im.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.im.view.LandscapeImBarrageItemView.a
            public void d(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.arb != null) {
                    LandscapeImBarrageTrackView.this.arb.d(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void vP() {
        if (!this.aqO) {
            this.aqO = true;
            if (this.arb != null) {
                this.arb.c(this);
            }
        }
    }
}
