package com.baidu.live.barrage.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.barrage.view.LandscapeImBarrageItemView;
import com.baidu.live.data.aj;
import com.baidu.live.data.br;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class LandscapeImBarrageTrackView extends FrameLayout {
    private int aBa;
    private int aBb;
    private boolean aBc;
    private a aBm;
    private List<View> aBn;

    /* loaded from: classes7.dex */
    public interface a {
        void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView);

        void b(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.aBm = aVar;
    }

    public boolean Bs() {
        return this.aBc;
    }

    public void setCanAddNext() {
        this.aBc = true;
    }

    public void b(br brVar, aj ajVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aBc = false;
        LandscapeImBarrageItemView c = c(brVar, ajVar, aVar, str, str2, i);
        c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = c.getMeasuredWidth();
        c.aBj = getWidth() + c.getMeasuredWidth();
        c.aBi = ((c.aBj * 1.0f) / this.aBa) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(c, layoutParams);
    }

    public void Bu() {
        if (this.aBn != null && !this.aBn.isEmpty()) {
            for (View view : this.aBn) {
                removeView(view);
            }
            this.aBn.clear();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            Bt();
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
        if (j2 > landscapeImBarrageItemView.aBi) {
            this.aBn.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.aBa);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.aBb < getWidth()) {
            Bt();
        }
    }

    public void release() {
        removeAllViews();
        if (this.aBn != null) {
            this.aBn.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.aBn = new ArrayList();
        this.aBa = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.aBb = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }

    private LandscapeImBarrageItemView c(br brVar, aj ajVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setEffectInfo(ajVar);
        landscapeImBarrageItemView.setUIInfo(brVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.barrage.view.LandscapeImBarrageItemView.a
            public void b(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.aBm != null) {
                    LandscapeImBarrageTrackView.this.aBm.b(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void Bt() {
        if (!this.aBc) {
            this.aBc = true;
            if (this.aBm != null) {
                this.aBm.a(this);
            }
        }
    }
}
