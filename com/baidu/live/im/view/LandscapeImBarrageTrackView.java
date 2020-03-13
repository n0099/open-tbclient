package com.baidu.live.im.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.data.bb;
import com.baidu.live.data.z;
import com.baidu.live.im.view.LandscapeImBarrageItemView;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class LandscapeImBarrageTrackView extends FrameLayout {
    private a ava;
    private int avb;
    private int avc;
    private boolean avd;
    private List<View> ave;

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
        this.ava = aVar;
    }

    public boolean ye() {
        return this.avd;
    }

    public void setCanAddNext() {
        this.avd = true;
    }

    public void a(bb bbVar, z zVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.avd = false;
        LandscapeImBarrageItemView b = b(bbVar, zVar, aVar, str, str2, i);
        b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = b.getMeasuredWidth();
        b.auX = getWidth() + b.getMeasuredWidth();
        b.auW = ((b.auX * 1.0f) / this.avb) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(b, layoutParams);
    }

    public void yf() {
        if (this.ave != null && !this.ave.isEmpty()) {
            for (View view : this.ave) {
                removeView(view);
            }
            this.ave.clear();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            yg();
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
        if (j2 > landscapeImBarrageItemView.auW) {
            this.ave.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.avb);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.avc < getWidth()) {
            yg();
        }
    }

    public void release() {
        removeAllViews();
        if (this.ave != null) {
            this.ave.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.ave = new ArrayList();
        this.avb = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.avc = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }

    private LandscapeImBarrageItemView b(bb bbVar, z zVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setEffectInfo(zVar);
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setUIInfo(bbVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.im.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.im.view.LandscapeImBarrageItemView.a
            public void c(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.ava != null) {
                    LandscapeImBarrageTrackView.this.ava.c(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void yg() {
        if (!this.avd) {
            this.avd = true;
            if (this.ava != null) {
                this.ava.a(this);
            }
        }
    }
}
