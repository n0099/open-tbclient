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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    private float aaD;
    private Paint aaE;
    private ImageView aaF;
    private Bitmap aaG;
    private ColorFilter aaH;
    private ColorFilter aaI;
    private int mSkinType;
    private RectF sz;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.aaF = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaF = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aaF = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.sz = new RectF();
        this.aaD = getResources().getDimension(d.e.tbds20);
        this.aaE = new Paint();
        this.aaE.setStrokeWidth(0.0f);
        this.aaE.setStrokeCap(Paint.Cap.ROUND);
        this.aaE.setAntiAlias(true);
        this.aaE.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.aaF = new ImageView(getContext());
        this.aaF.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.aaD = f;
        if (this.aaG != null) {
            this.aaG.recycle();
            rI();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aaF != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.aaH = new k(al.getColor(d.C0277d.cp_bg_line_d));
            this.aaI = new k(al.getColor(d.C0277d.cp_bg_line_e));
            this.aaF.setColorFilter(this.aaH);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.aaG != null && !this.aaG.isRecycled()) {
                this.aaG.recycle();
            }
            rI();
        }
    }

    public void aJ(boolean z) {
        if (this.aaF != null) {
            this.aaF.setColorFilter(z ? this.aaI : this.aaH);
        }
    }

    private void rI() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.sz.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            try {
                this.aaG = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
            } catch (OutOfMemoryError e) {
                BdLog.e(e);
                System.gc();
                TbadkCoreApplication.getInst().onLowMemory();
                try {
                    this.aaG = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
                } catch (OutOfMemoryError e2) {
                    BdLog.e(e);
                    System.gc();
                    TbadkCoreApplication.getInst().onLowMemory();
                    return;
                }
            }
            Canvas canvas = new Canvas(this.aaG);
            canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
            this.aaE.setColor(-1);
            canvas.drawRoundRect(this.sz, this.aaD, this.aaD, this.aaE);
            this.aaF.setImageBitmap(this.aaG);
            if (this.aaF.getParent() == null) {
                addView(this.aaF);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.aaF != null && view != this.aaF) {
            if (this.aaF.getParent() != null) {
                ((ViewGroup) this.aaF.getParent()).removeView(this.aaF);
            }
            super.addView(this.aaF);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.aaF != null) {
            if (this.aaF.getParent() != null) {
                ((ViewGroup) this.aaF.getParent()).removeView(this.aaF);
            }
            super.addView(this.aaF);
        }
    }
}
