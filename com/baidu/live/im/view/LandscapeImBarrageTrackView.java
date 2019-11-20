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
    private int aiO;
    private int aiP;
    private boolean aiQ;
    private a aje;
    private List<View> ajf;

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
        this.aje = aVar;
    }

    public boolean tS() {
        return this.aiQ;
    }

    public void setCanAddNext() {
        this.aiQ = true;
    }

    public void b(ao aoVar, u uVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aiQ = false;
        LandscapeImBarrageItemView c = c(aoVar, uVar, aVar, str, str2, i);
        c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = c.getMeasuredWidth();
        c.ajb = getWidth() + c.getMeasuredWidth();
        c.aja = ((c.ajb * 1.0f) / this.aiO) * 1000.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -1);
        layoutParams.leftMargin = getWidth();
        addView(c, layoutParams);
    }

    public void tY() {
        if (this.ajf != null && !this.ajf.isEmpty()) {
            for (View view : this.ajf) {
                removeView(view);
            }
            this.ajf.clear();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            tT();
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
        if (j2 > landscapeImBarrageItemView.aja) {
            this.ajf.add(landscapeImBarrageItemView);
            return;
        }
        int i2 = (int) (((((float) j2) * 1.0f) / 1000.0f) * this.aiO);
        if (i2 < getWidth()) {
            i = getWidth() - i2;
        } else {
            i = -(i2 - getWidth());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) landscapeImBarrageItemView.getLayoutParams();
        layoutParams.leftMargin = i;
        landscapeImBarrageItemView.setLayoutParams(layoutParams);
        if (indexOfChild(landscapeImBarrageItemView) == getChildCount() - 1 && landscapeImBarrageItemView.getMeasuredWidth() + i + this.aiP < getWidth()) {
            tT();
        }
    }

    public void release() {
        removeAllViews();
        if (this.ajf != null) {
            this.ajf.clear();
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.ajf = new ArrayList();
        this.aiO = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.aiP = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }

    private LandscapeImBarrageItemView c(ao aoVar, u uVar, com.baidu.live.data.a aVar, String str, String str2, int i) {
        LandscapeImBarrageItemView landscapeImBarrageItemView = new LandscapeImBarrageItemView(getContext());
        landscapeImBarrageItemView.setEffectInfo(uVar);
        landscapeImBarrageItemView.setDisplayInfo(aVar, str2, str, i);
        landscapeImBarrageItemView.setUIInfo(aoVar, false);
        landscapeImBarrageItemView.setCallback(new LandscapeImBarrageItemView.a() { // from class: com.baidu.live.im.view.LandscapeImBarrageTrackView.1
            @Override // com.baidu.live.im.view.LandscapeImBarrageItemView.a
            public void d(com.baidu.live.data.a aVar2) {
                if (LandscapeImBarrageTrackView.this.aje != null) {
                    LandscapeImBarrageTrackView.this.aje.d(aVar2);
                }
            }
        });
        return landscapeImBarrageItemView;
    }

    private void tT() {
        if (!this.aiQ) {
            this.aiQ = true;
            if (this.aje != null) {
                this.aje.c(this);
            }
        }
    }
}
