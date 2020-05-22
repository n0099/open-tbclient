package com.baidu.live.im.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.data.af;
import com.baidu.live.data.bj;
import com.baidu.live.im.view.LandscapeImBarrageItemView;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class LandscapeImBarrageTrackView extends FrameLayout {
    private a aVb;
    private int aVc;
    private int aVd;
    private boolean aVe;
    private List<View> aVf;

    /* loaded from: classes3.dex */
    public interface a {
        void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView);

        void c(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.aVb = aVar;
    }

    public boolean Ey() {
        return this.aVe;
    }

    public void setCanAddNext() {
        this.aVe = true;
    }

    public void a(bj bjVar, af afVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aVe = false;
        LandscapeImBarrageItemView b = b(bjVar, afVar, aVar, str, str2, i);
        b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = b.getMeasuredWidth();
        b.aUY = getWidth() + b.getMeasuredWidth();
        b.aUX = ((b.aUY * 1.0f) / this.aVc) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(b, layoutParams);
    }

    public void Ez() {
        if (this.aVf != null && !this.aVf.isEmpty()) {
            for (View view : this.aVf) {
                removeView(view);
            }
            this.aVf.clear();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            EA();
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
        if (j2 > landscapeImBarrageItemView.aUX) {
            this.aVf.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.aVc);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.aVd < getWidth()) {
            EA();
        }
    }

    public void release() {
        removeAllViews();
        if (this.aVf != null) {
            this.aVf.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.aVf = new ArrayList();
        this.aVc = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.aVd = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }

    private LandscapeImBarrageItemView b(bj bjVar, af afVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setEffectInfo(afVar);
        landscapeImBarrageItemView.setUIInfo(bjVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.im.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.im.view.LandscapeImBarrageItemView.a
            public void c(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.aVb != null) {
                    LandscapeImBarrageTrackView.this.aVb.c(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void EA() {
        if (!this.aVe) {
            this.aVe = true;
            if (this.aVb != null) {
                this.aVb.a(this);
            }
        }
    }
}
