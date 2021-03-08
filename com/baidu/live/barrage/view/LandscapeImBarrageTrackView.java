package com.baidu.live.barrage.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.live.barrage.view.LandscapeImBarrageItemView;
import com.baidu.live.data.ba;
import com.baidu.live.data.cr;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class LandscapeImBarrageTrackView extends FrameLayout {
    private a aFJ;
    private List<View> aFK;
    private int aFx;
    private int aFy;
    private boolean aFz;

    /* loaded from: classes10.dex */
    public interface a {
        void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView);

        void b(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.aFJ = aVar;
    }

    public boolean Al() {
        return this.aFz;
    }

    public void setCanAddNext() {
        this.aFz = true;
    }

    public void b(cr crVar, ba baVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aFz = false;
        LandscapeImBarrageItemView c = c(crVar, baVar, aVar, str, str2, i);
        c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = c.getMeasuredWidth();
        c.aFG = getWidth() + c.getMeasuredWidth();
        c.aFF = ((c.aFG * 1.0f) / this.aFx) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(c, layoutParams);
    }

    public void An() {
        if (this.aFK != null && !this.aFK.isEmpty()) {
            for (View view : this.aFK) {
                removeView(view);
            }
            this.aFK.clear();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            Am();
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
        if (j2 > landscapeImBarrageItemView.aFF) {
            this.aFK.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.aFx);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.aFy < getWidth()) {
            Am();
        }
    }

    public void release() {
        removeAllViews();
        if (this.aFK != null) {
            this.aFK.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.aFK = new ArrayList();
        this.aFx = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aFy = getResources().getDimensionPixelOffset(a.d.sdk_ds120);
    }

    private LandscapeImBarrageItemView c(cr crVar, ba baVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setEffectInfo(baVar);
        landscapeImBarrageItemView.setUIInfo(crVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.barrage.view.LandscapeImBarrageItemView.a
            public void b(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.aFJ != null) {
                    LandscapeImBarrageTrackView.this.aFJ.b(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void Am() {
        if (!this.aFz) {
            this.aFz = true;
            if (this.aFJ != null) {
                this.aFJ.a(this);
            }
        }
    }
}
