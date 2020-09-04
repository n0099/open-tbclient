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
    private int aBc;
    private int aBd;
    private boolean aBe;
    private a aBo;
    private List<View> aBp;

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
        this.aBo = aVar;
    }

    public boolean Bs() {
        return this.aBe;
    }

    public void setCanAddNext() {
        this.aBe = true;
    }

    public void b(br brVar, aj ajVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aBe = false;
        LandscapeImBarrageItemView c = c(brVar, ajVar, aVar, str, str2, i);
        c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = c.getMeasuredWidth();
        c.aBl = getWidth() + c.getMeasuredWidth();
        c.aBk = ((c.aBl * 1.0f) / this.aBc) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(c, layoutParams);
    }

    public void Bu() {
        if (this.aBp != null && !this.aBp.isEmpty()) {
            for (View view : this.aBp) {
                removeView(view);
            }
            this.aBp.clear();
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
        if (j2 > landscapeImBarrageItemView.aBk) {
            this.aBp.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.aBc);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.aBd < getWidth()) {
            Bt();
        }
    }

    public void release() {
        removeAllViews();
        if (this.aBp != null) {
            this.aBp.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.aBp = new ArrayList();
        this.aBc = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.aBd = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }

    private LandscapeImBarrageItemView c(br brVar, aj ajVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setEffectInfo(ajVar);
        landscapeImBarrageItemView.setUIInfo(brVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.barrage.view.LandscapeImBarrageItemView.a
            public void b(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.aBo != null) {
                    LandscapeImBarrageTrackView.this.aBo.b(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void Bt() {
        if (!this.aBe) {
            this.aBe = true;
            if (this.aBo != null) {
                this.aBo.a(this);
            }
        }
    }
}
