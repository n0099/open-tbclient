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
    private int aBI;
    private int aBJ;
    private boolean aBK;
    private a aBU;
    private List<View> aBV;

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
        this.aBU = aVar;
    }

    public boolean BH() {
        return this.aBK;
    }

    public void setCanAddNext() {
        this.aBK = true;
    }

    public void b(bz bzVar, ao aoVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aBK = false;
        LandscapeImBarrageItemView c = c(bzVar, aoVar, aVar, str, str2, i);
        c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = c.getMeasuredWidth();
        c.aBR = getWidth() + c.getMeasuredWidth();
        c.aBQ = ((c.aBR * 1.0f) / this.aBI) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(c, layoutParams);
    }

    public void BJ() {
        if (this.aBV != null && !this.aBV.isEmpty()) {
            for (View view : this.aBV) {
                removeView(view);
            }
            this.aBV.clear();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            BI();
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
        if (j2 > landscapeImBarrageItemView.aBQ) {
            this.aBV.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.aBI);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.aBJ < getWidth()) {
            BI();
        }
    }

    public void release() {
        removeAllViews();
        if (this.aBV != null) {
            this.aBV.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.aBV = new ArrayList();
        this.aBI = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.aBJ = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }

    private LandscapeImBarrageItemView c(bz bzVar, ao aoVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setEffectInfo(aoVar);
        landscapeImBarrageItemView.setUIInfo(bzVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.barrage.view.LandscapeImBarrageItemView.a
            public void b(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.aBU != null) {
                    LandscapeImBarrageTrackView.this.aBU.b(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void BI() {
        if (!this.aBK) {
            this.aBK = true;
            if (this.aBU != null) {
                this.aBU.a(this);
            }
        }
    }
}
