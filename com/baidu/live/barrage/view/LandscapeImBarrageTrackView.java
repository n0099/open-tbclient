package com.baidu.live.barrage.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.barrage.view.LandscapeImBarrageItemView;
import com.baidu.live.data.ah;
import com.baidu.live.data.bp;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class LandscapeImBarrageTrackView extends FrameLayout {
    private int avY;
    private int avZ;
    private boolean awa;
    private a awk;
    private List<View> awl;

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
        this.awk = aVar;
    }

    public boolean vU() {
        return this.awa;
    }

    public void setCanAddNext() {
        this.awa = true;
    }

    public void b(bp bpVar, ah ahVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.awa = false;
        LandscapeImBarrageItemView c = c(bpVar, ahVar, aVar, str, str2, i);
        c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = c.getMeasuredWidth();
        c.awh = getWidth() + c.getMeasuredWidth();
        c.awg = ((c.awh * 1.0f) / this.avY) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(c, layoutParams);
    }

    public void vW() {
        if (this.awl != null && !this.awl.isEmpty()) {
            for (View view : this.awl) {
                removeView(view);
            }
            this.awl.clear();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            vV();
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
        if (j2 > landscapeImBarrageItemView.awg) {
            this.awl.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.avY);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.avZ < getWidth()) {
            vV();
        }
    }

    public void release() {
        removeAllViews();
        if (this.awl != null) {
            this.awl.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.awl = new ArrayList();
        this.avY = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.avZ = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }

    private LandscapeImBarrageItemView c(bp bpVar, ah ahVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setEffectInfo(ahVar);
        landscapeImBarrageItemView.setUIInfo(bpVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.barrage.view.LandscapeImBarrageItemView.a
            public void b(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.awk != null) {
                    LandscapeImBarrageTrackView.this.awk.b(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void vV() {
        if (!this.awa) {
            this.awa = true;
            if (this.awk != null) {
                this.awk.a(this);
            }
        }
    }
}
