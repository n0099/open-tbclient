package com.baidu.live.barrage.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.barrage.view.LandscapeImBarrageItemView;
import com.baidu.live.data.at;
import com.baidu.live.data.cg;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class LandscapeImBarrageTrackView extends FrameLayout {
    private int aFL;
    private int aFM;
    private boolean aFN;
    private a aFX;
    private List<View> aFY;

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
        this.aFX = aVar;
    }

    public boolean Dd() {
        return this.aFN;
    }

    public void setCanAddNext() {
        this.aFN = true;
    }

    public void b(cg cgVar, at atVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aFN = false;
        LandscapeImBarrageItemView c = c(cgVar, atVar, aVar, str, str2, i);
        c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = c.getMeasuredWidth();
        c.aFU = getWidth() + c.getMeasuredWidth();
        c.aFT = ((c.aFU * 1.0f) / this.aFL) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(c, layoutParams);
    }

    public void Df() {
        if (this.aFY != null && !this.aFY.isEmpty()) {
            for (View view : this.aFY) {
                removeView(view);
            }
            this.aFY.clear();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            De();
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
        if (j2 > landscapeImBarrageItemView.aFT) {
            this.aFY.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.aFL);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.aFM < getWidth()) {
            De();
        }
    }

    public void release() {
        removeAllViews();
        if (this.aFY != null) {
            this.aFY.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.aFY = new ArrayList();
        this.aFL = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aFM = getResources().getDimensionPixelOffset(a.d.sdk_ds120);
    }

    private LandscapeImBarrageItemView c(cg cgVar, at atVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setEffectInfo(atVar);
        landscapeImBarrageItemView.setUIInfo(cgVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.barrage.view.LandscapeImBarrageItemView.a
            public void b(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.aFX != null) {
                    LandscapeImBarrageTrackView.this.aFX.b(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void De() {
        if (!this.aFN) {
            this.aFN = true;
            if (this.aFX != null) {
                this.aFX.a(this);
            }
        }
    }
}
