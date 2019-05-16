package com.baidu.card.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.airbnb.lottie.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    private ColorFilter YA;
    private float Yv;
    private Paint Yw;
    private ImageView Yx;
    private Bitmap Yy;
    private ColorFilter Yz;
    private int mSkinType;
    private RectF qc;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.Yx = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Yx = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Yx = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.qc = new RectF();
        this.Yv = getResources().getDimension(R.dimen.tbds20);
        this.Yw = new Paint();
        this.Yw.setStrokeWidth(0.0f);
        this.Yw.setStrokeCap(Paint.Cap.ROUND);
        this.Yw.setAntiAlias(true);
        this.Yw.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.Yx = new ImageView(getContext());
        this.Yx.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.Yv = f;
        if (this.Yy != null) {
            this.Yy.recycle();
            qD();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Yx != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.Yz = new k(al.getColor(R.color.cp_bg_line_d));
            this.YA = new k(al.getColor(R.color.cp_bg_line_e));
            this.Yx.setColorFilter(this.Yz);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.Yy != null && !this.Yy.isRecycled()) {
                this.Yy.recycle();
            }
            qD();
        }
    }

    public void aB(boolean z) {
        if (this.Yx != null) {
            this.Yx.setColorFilter(z ? this.YA : this.Yz);
        }
    }

    private void qD() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.qc.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            try {
                this.Yy = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
            } catch (OutOfMemoryError e) {
                BdLog.e(e);
                System.gc();
                TbadkCoreApplication.getInst().onLowMemory();
                try {
                    this.Yy = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
                } catch (OutOfMemoryError e2) {
                    BdLog.e(e);
                    System.gc();
                    TbadkCoreApplication.getInst().onLowMemory();
                    return;
                }
            }
            Canvas canvas = new Canvas(this.Yy);
            canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
            this.Yw.setColor(-1);
            canvas.drawRoundRect(this.qc, this.Yv, this.Yv, this.Yw);
            this.Yx.setImageBitmap(this.Yy);
            if (this.Yx.getParent() == null) {
                addView(this.Yx);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.Yx != null && view != this.Yx) {
            if (this.Yx.getParent() != null) {
                ((ViewGroup) this.Yx.getParent()).removeView(this.Yx);
            }
            super.addView(this.Yx);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.Yx != null) {
            if (this.Yx.getParent() != null) {
                ((ViewGroup) this.Yx.getParent()).removeView(this.Yx);
            }
            super.addView(this.Yx);
        }
    }
}
