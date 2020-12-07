package com.baidu.live.barrage.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.barrage.view.LandscapeImBarrageItemView;
import com.baidu.live.data.au;
import com.baidu.live.data.ci;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class LandscapeImBarrageTrackView extends FrameLayout {
    private int aGG;
    private int aGH;
    private boolean aGI;
    private a aGS;
    private List<View> aGT;

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
        this.aGS = aVar;
    }

    public boolean Ee() {
        return this.aGI;
    }

    public void setCanAddNext() {
        this.aGI = true;
    }

    public void b(ci ciVar, au auVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aGI = false;
        LandscapeImBarrageItemView c = c(ciVar, auVar, aVar, str, str2, i);
        c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = c.getMeasuredWidth();
        c.aGP = getWidth() + c.getMeasuredWidth();
        c.aGO = ((c.aGP * 1.0f) / this.aGG) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(c, layoutParams);
    }

    public void Eg() {
        if (this.aGT != null && !this.aGT.isEmpty()) {
            for (View view : this.aGT) {
                removeView(view);
            }
            this.aGT.clear();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            Ef();
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
        if (j2 > landscapeImBarrageItemView.aGO) {
            this.aGT.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.aGG);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.aGH < getWidth()) {
            Ef();
        }
    }

    public void release() {
        removeAllViews();
        if (this.aGT != null) {
            this.aGT.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.aGT = new ArrayList();
        this.aGG = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aGH = getResources().getDimensionPixelOffset(a.d.sdk_ds120);
    }

    private LandscapeImBarrageItemView c(ci ciVar, au auVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setEffectInfo(auVar);
        landscapeImBarrageItemView.setUIInfo(ciVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.barrage.view.LandscapeImBarrageItemView.a
            public void b(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.aGS != null) {
                    LandscapeImBarrageTrackView.this.aGS.b(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void Ef() {
        if (!this.aGI) {
            this.aGI = true;
            if (this.aGS != null) {
                this.aGS.a(this);
            }
        }
    }
}
