package com.baidu.live.barrage.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.barrage.view.LandscapeImBarrageItemView;
import com.baidu.live.data.ao;
import com.baidu.live.data.bz;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class LandscapeImBarrageTrackView extends FrameLayout {
    private int aEN;
    private int aEO;
    private boolean aEP;
    private a aEZ;
    private List<View> aFa;

    /* loaded from: classes4.dex */
    public interface a {
        void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView);

        void b(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.aEZ = aVar;
    }

    public boolean CE() {
        return this.aEP;
    }

    public void setCanAddNext() {
        this.aEP = true;
    }

    public void b(bz bzVar, ao aoVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aEP = false;
        LandscapeImBarrageItemView c = c(bzVar, aoVar, aVar, str, str2, i);
        c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = c.getMeasuredWidth();
        c.aEW = getWidth() + c.getMeasuredWidth();
        c.aEV = ((c.aEW * 1.0f) / this.aEN) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(c, layoutParams);
    }

    public void CG() {
        if (this.aFa != null && !this.aFa.isEmpty()) {
            for (View view : this.aFa) {
                removeView(view);
            }
            this.aFa.clear();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            CF();
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
        if (j2 > landscapeImBarrageItemView.aEV) {
            this.aFa.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.aEN);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.aEO < getWidth()) {
            CF();
        }
    }

    public void release() {
        removeAllViews();
        if (this.aFa != null) {
            this.aFa.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.aFa = new ArrayList();
        this.aEN = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.aEO = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }

    private LandscapeImBarrageItemView c(bz bzVar, ao aoVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setEffectInfo(aoVar);
        landscapeImBarrageItemView.setUIInfo(bzVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.barrage.view.LandscapeImBarrageItemView.a
            public void b(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.aEZ != null) {
                    LandscapeImBarrageTrackView.this.aEZ.b(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void CF() {
        if (!this.aEP) {
            this.aEP = true;
            if (this.aEZ != null) {
                this.aEZ.a(this);
            }
        }
    }
}
