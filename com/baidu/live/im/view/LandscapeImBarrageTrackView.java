package com.baidu.live.im.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.data.ab;
import com.baidu.live.data.be;
import com.baidu.live.im.view.LandscapeImBarrageItemView;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class LandscapeImBarrageTrackView extends FrameLayout {
    private a aOS;
    private int aOT;
    private int aOU;
    private boolean aOV;
    private List<View> aOW;

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
        this.aOS = aVar;
    }

    public boolean Da() {
        return this.aOV;
    }

    public void setCanAddNext() {
        this.aOV = true;
    }

    public void a(be beVar, ab abVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aOV = false;
        LandscapeImBarrageItemView b = b(beVar, abVar, aVar, str, str2, i);
        b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = b.getMeasuredWidth();
        b.aOP = getWidth() + b.getMeasuredWidth();
        b.aOO = ((b.aOP * 1.0f) / this.aOT) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(b, layoutParams);
    }

    public void Db() {
        if (this.aOW != null && !this.aOW.isEmpty()) {
            for (View view : this.aOW) {
                removeView(view);
            }
            this.aOW.clear();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            Dc();
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
        if (j2 > landscapeImBarrageItemView.aOO) {
            this.aOW.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.aOT);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.aOU < getWidth()) {
            Dc();
        }
    }

    public void release() {
        removeAllViews();
        if (this.aOW != null) {
            this.aOW.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.aOW = new ArrayList();
        this.aOT = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.aOU = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }

    private LandscapeImBarrageItemView b(be beVar, ab abVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setEffectInfo(abVar);
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setUIInfo(beVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.im.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.im.view.LandscapeImBarrageItemView.a
            public void c(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.aOS != null) {
                    LandscapeImBarrageTrackView.this.aOS.c(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void Dc() {
        if (!this.aOV) {
            this.aOV = true;
            if (this.aOS != null) {
                this.aOS.a(this);
            }
        }
    }
}
