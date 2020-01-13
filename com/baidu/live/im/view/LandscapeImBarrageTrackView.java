package com.baidu.live.im.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.data.az;
import com.baidu.live.data.y;
import com.baidu.live.im.view.LandscapeImBarrageItemView;
import com.baidu.live.r.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class LandscapeImBarrageTrackView extends FrameLayout {
    private boolean arA;
    private a arN;
    private List<View> arO;
    private int ary;
    private int arz;

    /* loaded from: classes2.dex */
    public interface a {
        void c(LandscapeImBarrageTrackView landscapeImBarrageTrackView);

        void d(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.arN = aVar;
    }

    public boolean wf() {
        return this.arA;
    }

    public void setCanAddNext() {
        this.arA = true;
    }

    public void b(az azVar, y yVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.arA = false;
        LandscapeImBarrageItemView c = c(azVar, yVar, aVar, str, str2, i);
        c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = c.getMeasuredWidth();
        c.arK = getWidth() + c.getMeasuredWidth();
        c.arJ = ((c.arK * 1.0f) / this.ary) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(c, layoutParams);
    }

    public void wk() {
        if (this.arO != null && !this.arO.isEmpty()) {
            for (View view : this.arO) {
                removeView(view);
            }
            this.arO.clear();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            wg();
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
        if (j2 > landscapeImBarrageItemView.arJ) {
            this.arO.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.ary);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.arz < getWidth()) {
            wg();
        }
    }

    public void release() {
        removeAllViews();
        if (this.arO != null) {
            this.arO.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.arO = new ArrayList();
        this.ary = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.arz = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }

    private LandscapeImBarrageItemView c(az azVar, y yVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setEffectInfo(yVar);
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setUIInfo(azVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.im.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.im.view.LandscapeImBarrageItemView.a
            public void d(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.arN != null) {
                    LandscapeImBarrageTrackView.this.arN.d(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void wg() {
        if (!this.arA) {
            this.arA = true;
            if (this.arN != null) {
                this.arN.c(this);
            }
        }
    }
}
