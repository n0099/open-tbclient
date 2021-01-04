package com.baidu.live.barrage.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.live.barrage.view.LandscapeImBarrageItemView;
import com.baidu.live.data.aw;
import com.baidu.live.data.ck;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class LandscapeImBarrageTrackView extends FrameLayout {
    private int aGX;
    private int aGY;
    private boolean aGZ;
    private a aHj;
    private List<View> aHk;

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
        this.aHj = aVar;
    }

    public boolean Dt() {
        return this.aGZ;
    }

    public void setCanAddNext() {
        this.aGZ = true;
    }

    public void b(ck ckVar, aw awVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aGZ = false;
        LandscapeImBarrageItemView c = c(ckVar, awVar, aVar, str, str2, i);
        c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = c.getMeasuredWidth();
        c.aHg = getWidth() + c.getMeasuredWidth();
        c.aHf = ((c.aHg * 1.0f) / this.aGX) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(c, layoutParams);
    }

    public void Dv() {
        if (this.aHk != null && !this.aHk.isEmpty()) {
            for (View view : this.aHk) {
                removeView(view);
            }
            this.aHk.clear();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            Du();
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
        if (j2 > landscapeImBarrageItemView.aHf) {
            this.aHk.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.aGX);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.aGY < getWidth()) {
            Du();
        }
    }

    public void release() {
        removeAllViews();
        if (this.aHk != null) {
            this.aHk.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.aHk = new ArrayList();
        this.aGX = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aGY = getResources().getDimensionPixelOffset(a.d.sdk_ds120);
    }

    private LandscapeImBarrageItemView c(ck ckVar, aw awVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setEffectInfo(awVar);
        landscapeImBarrageItemView.setUIInfo(ckVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.barrage.view.LandscapeImBarrageItemView.a
            public void b(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.aHj != null) {
                    LandscapeImBarrageTrackView.this.aHj.b(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void Du() {
        if (!this.aGZ) {
            this.aGZ = true;
            if (this.aHj != null) {
                this.aHj.a(this);
            }
        }
    }
}
