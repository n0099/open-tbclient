package com.baidu.card.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.airbnb.lottie.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.Arrays;
/* loaded from: classes21.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    private RectF Hx;
    private Paint amA;
    private ImageView amB;
    private ColorFilter amC;
    private ColorFilter amD;
    private float[] amz;
    private Bitmap mMaskBitmap;
    private int mSkinType;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.amz = new float[8];
        this.amB = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amz = new float[8];
        this.amB = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amz = new float[8];
        this.amB = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.Hx = new RectF();
        this.amz = com.baidu.tbadk.core.elementsMaven.a.aH(R.string.J_X05);
        this.amA = new Paint();
        this.amA.setStrokeWidth(0.0f);
        this.amA.setStrokeCap(Paint.Cap.ROUND);
        this.amA.setAntiAlias(true);
        this.amA.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.amB = new ImageView(getContext());
        this.amB.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        Arrays.fill(this.amz, f);
        if (this.mMaskBitmap != null) {
            this.mMaskBitmap.recycle();
            us();
        }
    }

    public void setCornerId(int i) {
        this.amz = com.baidu.tbadk.core.elementsMaven.a.aH(i);
        if (this.mMaskBitmap != null) {
            this.mMaskBitmap.recycle();
            us();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.amB != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.amC = new q(ap.getColor(R.color.CAM_X0201));
            this.amD = new q(ap.getColor(R.color.CAM_X0205));
            this.amB.setColorFilter(this.amC);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.mMaskBitmap != null && !this.mMaskBitmap.isRecycled()) {
                this.mMaskBitmap.recycle();
            }
            us();
        }
    }

    public void aQ(boolean z) {
        if (this.amB != null) {
            this.amB.setColorFilter(z ? this.amD : this.amC);
        }
    }

    private void us() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.Hx.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            try {
                this.mMaskBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
            } catch (OutOfMemoryError e) {
                BdLog.e(e);
                System.gc();
                TbadkCoreApplication.getInst().onLowMemory();
                try {
                    this.mMaskBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
                } catch (OutOfMemoryError e2) {
                    BdLog.e(e);
                    System.gc();
                    TbadkCoreApplication.getInst().onLowMemory();
                    return;
                }
            }
            Canvas canvas = new Canvas(this.mMaskBitmap);
            canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
            this.amA.setColor(-1);
            Path path = new Path();
            path.addRoundRect(this.Hx, this.amz, Path.Direction.CW);
            canvas.drawPath(path, this.amA);
            this.amB.setImageBitmap(this.mMaskBitmap);
            if (this.amB.getParent() == null) {
                addView(this.amB);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.amB != null && view != this.amB) {
            if (this.amB.getParent() != null) {
                ((ViewGroup) this.amB.getParent()).removeView(this.amB);
            }
            super.addView(this.amB);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.amB != null) {
            if (this.amB.getParent() != null) {
                ((ViewGroup) this.amB.getParent()).removeView(this.amB);
            }
            super.addView(this.amB);
        }
    }
}
