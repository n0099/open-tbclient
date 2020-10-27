package com.baidu.live.barrage.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.barrage.view.LandscapeImBarrageItemView;
import com.baidu.live.data.ar;
import com.baidu.live.data.ce;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class LandscapeImBarrageTrackView extends FrameLayout {
    private int aEV;
    private int aEW;
    private boolean aEX;
    private a aFh;
    private List<View> aFi;

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
        this.aFh = aVar;
    }

    public boolean CK() {
        return this.aEX;
    }

    public void setCanAddNext() {
        this.aEX = true;
    }

    public void b(ce ceVar, ar arVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aEX = false;
        LandscapeImBarrageItemView c = c(ceVar, arVar, aVar, str, str2, i);
        c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = c.getMeasuredWidth();
        c.aFe = getWidth() + c.getMeasuredWidth();
        c.aFd = ((c.aFe * 1.0f) / this.aEV) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(c, layoutParams);
    }

    public void CM() {
        if (this.aFi != null && !this.aFi.isEmpty()) {
            for (View view : this.aFi) {
                removeView(view);
            }
            this.aFi.clear();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            CL();
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
        if (j2 > landscapeImBarrageItemView.aFd) {
            this.aFi.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.aEV);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.aEW < getWidth()) {
            CL();
        }
    }

    public void release() {
        removeAllViews();
        if (this.aFi != null) {
            this.aFi.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.aFi = new ArrayList();
        this.aEV = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.aEW = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }

    private LandscapeImBarrageItemView c(ce ceVar, ar arVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setEffectInfo(arVar);
        landscapeImBarrageItemView.setUIInfo(ceVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.barrage.view.LandscapeImBarrageItemView.a
            public void b(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.aFh != null) {
                    LandscapeImBarrageTrackView.this.aFh.b(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void CL() {
        if (!this.aEX) {
            this.aEX = true;
            if (this.aFh != null) {
                this.aFh.a(this);
            }
        }
    }
}
