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
    private a avk;
    private int avl;
    private int avm;
    private boolean avn;
    private List<View> avo;

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
        this.avk = aVar;
    }

    public boolean yj() {
        return this.avn;
    }

    public void setCanAddNext() {
        this.avn = true;
    }

    public void a(bb bbVar, z zVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.avn = false;
        LandscapeImBarrageItemView b = b(bbVar, zVar, aVar, str, str2, i);
        b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = b.getMeasuredWidth();
        b.avh = getWidth() + b.getMeasuredWidth();
        b.avg = ((b.avh * 1.0f) / this.avl) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(b, layoutParams);
    }

    public void yk() {
        if (this.avo != null && !this.avo.isEmpty()) {
            for (View view : this.avo) {
                removeView(view);
            }
            this.avo.clear();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            yl();
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
        if (j2 > landscapeImBarrageItemView.avg) {
            this.avo.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.avl);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.avm < getWidth()) {
            yl();
        }
    }

    public void release() {
        removeAllViews();
        if (this.avo != null) {
            this.avo.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.avo = new ArrayList();
        this.avl = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.avm = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }

    private LandscapeImBarrageItemView b(bb bbVar, z zVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setEffectInfo(zVar);
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setUIInfo(bbVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.im.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.im.view.LandscapeImBarrageItemView.a
            public void c(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.avk != null) {
                    LandscapeImBarrageTrackView.this.avk.c(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void yl() {
        if (!this.avn) {
            this.avn = true;
            if (this.avk != null) {
                this.avk.a(this);
            }
        }
    }
}
