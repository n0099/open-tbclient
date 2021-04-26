package com.baidu.ala.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes.dex */
public class AlaRoundRelativeLayout extends RelativeLayout {
    public float[] mRadius;
    public RectF mRectF;
    public float mRoundLayoutRadius;
    public Path mRoundPath;

    public AlaRoundRelativeLayout(Context context) {
        super(context);
        float g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
        this.mRoundLayoutRadius = g2;
        this.mRadius = new float[]{g2, g2, g2, g2, g2, g2, g2, g2};
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.mRoundPath = new Path();
        this.mRectF = new RectF();
    }

    private void setRoundPath() {
        this.mRoundPath.addRoundRect(this.mRectF, this.mRadius, Path.Direction.CW);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.clipPath(this.mRoundPath);
        super.draw(canvas);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.mRectF.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        setRoundPath();
    }

    public void setRoundLayoutRadius(float[] fArr) {
        if (fArr == null || fArr.length <= 0) {
            return;
        }
        this.mRadius = new float[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            this.mRadius[i2] = fArr[i2];
        }
        setRoundPath();
        invalidate();
    }

    public AlaRoundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
        this.mRoundLayoutRadius = g2;
        this.mRadius = new float[]{g2, g2, g2, g2, g2, g2, g2, g2};
        init();
    }

    public AlaRoundRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        float g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
        this.mRoundLayoutRadius = g2;
        this.mRadius = new float[]{g2, g2, g2, g2, g2, g2, g2, g2};
        init();
    }
}
