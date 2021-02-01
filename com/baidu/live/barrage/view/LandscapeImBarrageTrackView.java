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
/* loaded from: classes11.dex */
public class LandscapeImBarrageTrackView extends FrameLayout {
    private int aDX;
    private int aDY;
    private boolean aDZ;
    private a aEj;
    private List<View> aEk;

    /* loaded from: classes11.dex */
    public interface a {
        void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView);

        void b(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.aEj = aVar;
    }

    public boolean Ai() {
        return this.aDZ;
    }

    public void setCanAddNext() {
        this.aDZ = true;
    }

    public void b(cr crVar, ba baVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aDZ = false;
        LandscapeImBarrageItemView c = c(crVar, baVar, aVar, str, str2, i);
        c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = c.getMeasuredWidth();
        c.aEg = getWidth() + c.getMeasuredWidth();
        c.aEf = ((c.aEg * 1.0f) / this.aDX) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(c, layoutParams);
    }

    public void Ak() {
        if (this.aEk != null && !this.aEk.isEmpty()) {
            for (View view : this.aEk) {
                removeView(view);
            }
            this.aEk.clear();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            Aj();
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
        if (j2 > landscapeImBarrageItemView.aEf) {
            this.aEk.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.aDX);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.aDY < getWidth()) {
            Aj();
        }
    }

    public void release() {
        removeAllViews();
        if (this.aEk != null) {
            this.aEk.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.aEk = new ArrayList();
        this.aDX = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aDY = getResources().getDimensionPixelOffset(a.d.sdk_ds120);
    }

    private LandscapeImBarrageItemView c(cr crVar, ba baVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setEffectInfo(baVar);
        landscapeImBarrageItemView.setUIInfo(crVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.barrage.view.LandscapeImBarrageItemView.a
            public void b(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.aEj != null) {
                    LandscapeImBarrageTrackView.this.aEj.b(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void Aj() {
        if (!this.aDZ) {
            this.aDZ = true;
            if (this.aEj != null) {
                this.aEj.a(this);
            }
        }
    }
}
