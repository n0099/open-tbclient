package com.baidu.live.im.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.data.ag;
import com.baidu.live.data.bo;
import com.baidu.live.im.view.LandscapeImBarrageItemView;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class LandscapeImBarrageTrackView extends FrameLayout {
    private a aXI;
    private int aXJ;
    private int aXK;
    private boolean aXL;
    private List<View> aXM;

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
        this.aXI = aVar;
    }

    public boolean Fc() {
        return this.aXL;
    }

    public void setCanAddNext() {
        this.aXL = true;
    }

    public void a(bo boVar, ag agVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aXL = false;
        LandscapeImBarrageItemView b = b(boVar, agVar, aVar, str, str2, i);
        b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = b.getMeasuredWidth();
        b.aXF = getWidth() + b.getMeasuredWidth();
        b.aXE = ((b.aXF * 1.0f) / this.aXJ) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(b, layoutParams);
    }

    public void Fd() {
        if (this.aXM != null && !this.aXM.isEmpty()) {
            for (View view : this.aXM) {
                removeView(view);
            }
            this.aXM.clear();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            Fe();
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
        if (j2 > landscapeImBarrageItemView.aXE) {
            this.aXM.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.aXJ);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.aXK < getWidth()) {
            Fe();
        }
    }

    public void release() {
        removeAllViews();
        if (this.aXM != null) {
            this.aXM.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.aXM = new ArrayList();
        this.aXJ = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.aXK = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }

    private LandscapeImBarrageItemView b(bo boVar, ag agVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setEffectInfo(agVar);
        landscapeImBarrageItemView.setUIInfo(boVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.im.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.im.view.LandscapeImBarrageItemView.a
            public void c(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.aXI != null) {
                    LandscapeImBarrageTrackView.this.aXI.c(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void Fe() {
        if (!this.aXL) {
            this.aXL = true;
            if (this.aXI != null) {
                this.aXI.a(this);
            }
        }
    }
}
