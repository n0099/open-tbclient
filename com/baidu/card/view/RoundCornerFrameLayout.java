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
    private float Yu;
    private Paint Yv;
    private ImageView Yw;
    private Bitmap Yx;
    private ColorFilter Yy;
    private ColorFilter Yz;
    private int mSkinType;
    private RectF qc;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.Yw = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Yw = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Yw = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.qc = new RectF();
        this.Yu = getResources().getDimension(R.dimen.tbds20);
        this.Yv = new Paint();
        this.Yv.setStrokeWidth(0.0f);
        this.Yv.setStrokeCap(Paint.Cap.ROUND);
        this.Yv.setAntiAlias(true);
        this.Yv.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.Yw = new ImageView(getContext());
        this.Yw.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.Yu = f;
        if (this.Yx != null) {
            this.Yx.recycle();
            qD();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Yw != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.Yy = new k(al.getColor(R.color.cp_bg_line_d));
            this.Yz = new k(al.getColor(R.color.cp_bg_line_e));
            this.Yw.setColorFilter(this.Yy);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.Yx != null && !this.Yx.isRecycled()) {
                this.Yx.recycle();
            }
            qD();
        }
    }

    public void aB(boolean z) {
        if (this.Yw != null) {
            this.Yw.setColorFilter(z ? this.Yz : this.Yy);
        }
    }

    private void qD() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.qc.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            try {
                this.Yx = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
            } catch (OutOfMemoryError e) {
                BdLog.e(e);
                System.gc();
                TbadkCoreApplication.getInst().onLowMemory();
                try {
                    this.Yx = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
                } catch (OutOfMemoryError e2) {
                    BdLog.e(e);
                    System.gc();
                    TbadkCoreApplication.getInst().onLowMemory();
                    return;
                }
            }
            Canvas canvas = new Canvas(this.Yx);
            canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
            this.Yv.setColor(-1);
            canvas.drawRoundRect(this.qc, this.Yu, this.Yu, this.Yv);
            this.Yw.setImageBitmap(this.Yx);
            if (this.Yw.getParent() == null) {
                addView(this.Yw);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.Yw != null && view != this.Yw) {
            if (this.Yw.getParent() != null) {
                ((ViewGroup) this.Yw.getParent()).removeView(this.Yw);
            }
            super.addView(this.Yw);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.Yw != null) {
            if (this.Yw.getParent() != null) {
                ((ViewGroup) this.Yw.getParent()).removeView(this.Yw);
            }
            super.addView(this.Yw);
        }
    }
}
