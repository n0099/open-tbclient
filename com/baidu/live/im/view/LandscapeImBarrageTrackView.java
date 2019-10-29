package com.baidu.live.im.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.data.ao;
import com.baidu.live.data.u;
import com.baidu.live.im.view.LandscapeImBarrageItemView;
import com.baidu.live.k.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class LandscapeImBarrageTrackView extends FrameLayout {
    private int ajg;
    private int ajh;
    private boolean aji;
    private a ajw;
    private List<View> ajx;

    /* loaded from: classes6.dex */
    public interface a {
        void c(LandscapeImBarrageTrackView landscapeImBarrageTrackView);

        void d(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.ajw = aVar;
    }

    public boolean tR() {
        return this.aji;
    }

    public void setCanAddNext() {
        this.aji = true;
    }

    public void b(ao aoVar, u uVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aji = false;
        LandscapeImBarrageItemView c = c(aoVar, uVar, aVar, str, str2, i);
        c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = c.getMeasuredWidth();
        c.ajt = getWidth() + c.getMeasuredWidth();
        c.ajs = ((c.ajt * 1.0f) / this.ajg) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(c, layoutParams);
    }

    public void tX() {
        if (this.ajx != null && !this.ajx.isEmpty()) {
            for (View view : this.ajx) {
                removeView(view);
            }
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            tS();
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
        if (j2 > landscapeImBarrageItemView.ajs) {
            this.ajx.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.ajg);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.ajh < getWidth()) {
            tS();
        }
    }

    public void release() {
        removeAllViews();
    }

    private void init() {
        setBackgroundColor(0);
        this.ajx = new ArrayList();
        this.ajg = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.ajh = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }

    private LandscapeImBarrageItemView c(ao aoVar, u uVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setEffectInfo(uVar);
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setUIInfo(aoVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.im.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.im.view.LandscapeImBarrageItemView.a
            public void d(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.ajw != null) {
                    LandscapeImBarrageTrackView.this.ajw.d(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void tS() {
        if (!this.aji) {
            this.aji = true;
            if (this.ajw != null) {
                this.ajw.c(this);
            }
        }
    }
}
