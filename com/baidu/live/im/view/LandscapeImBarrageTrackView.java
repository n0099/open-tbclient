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
    private a auZ;
    private int ava;
    private int avb;
    private boolean avc;
    private List<View> avd;

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
        this.auZ = aVar;
    }

    public boolean ye() {
        return this.avc;
    }

    public void setCanAddNext() {
        this.avc = true;
    }

    public void a(bb bbVar, z zVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.avc = false;
        LandscapeImBarrageItemView b = b(bbVar, zVar, aVar, str, str2, i);
        b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = b.getMeasuredWidth();
        b.auW = getWidth() + b.getMeasuredWidth();
        b.auV = ((b.auW * 1.0f) / this.ava) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(b, layoutParams);
    }

    public void yf() {
        if (this.avd != null && !this.avd.isEmpty()) {
            for (View view : this.avd) {
                removeView(view);
            }
            this.avd.clear();
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
        if (j2 > landscapeImBarrageItemView.auV) {
            this.avd.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.ava);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.avb < getWidth()) {
            yg();
        }
    }

    public void release() {
        removeAllViews();
        if (this.avd != null) {
            this.avd.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.avd = new ArrayList();
        this.ava = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.avb = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }

    private LandscapeImBarrageItemView b(bb bbVar, z zVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setEffectInfo(zVar);
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setUIInfo(bbVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.im.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.im.view.LandscapeImBarrageItemView.a
            public void c(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.auZ != null) {
                    LandscapeImBarrageTrackView.this.auZ.c(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void yg() {
        if (!this.avc) {
            this.avc = true;
            if (this.auZ != null) {
                this.auZ.a(this);
            }
        }
    }
}
