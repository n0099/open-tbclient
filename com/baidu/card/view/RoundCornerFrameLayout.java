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
    private float aaC;
    private Paint aaD;
    private ImageView aaE;
    private Bitmap aaF;
    private ColorFilter aaG;
    private ColorFilter aaH;
    private int mSkinType;
    private RectF sz;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.aaE = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaE = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aaE = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.sz = new RectF();
        this.aaC = getResources().getDimension(d.e.tbds20);
        this.aaD = new Paint();
        this.aaD.setStrokeWidth(0.0f);
        this.aaD.setStrokeCap(Paint.Cap.ROUND);
        this.aaD.setAntiAlias(true);
        this.aaD.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.aaE = new ImageView(getContext());
        this.aaE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.aaC = f;
        if (this.aaF != null) {
            this.aaF.recycle();
            rI();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aaE != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.aaG = new k(al.getColor(d.C0277d.cp_bg_line_d));
            this.aaH = new k(al.getColor(d.C0277d.cp_bg_line_e));
            this.aaE.setColorFilter(this.aaG);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.aaF != null && !this.aaF.isRecycled()) {
                this.aaF.recycle();
            }
            rI();
        }
    }

    public void aJ(boolean z) {
        if (this.aaE != null) {
            this.aaE.setColorFilter(z ? this.aaH : this.aaG);
        }
    }

    private void rI() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.sz.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            try {
                this.aaF = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
            } catch (OutOfMemoryError e) {
                BdLog.e(e);
                System.gc();
                TbadkCoreApplication.getInst().onLowMemory();
                try {
                    this.aaF = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
                } catch (OutOfMemoryError e2) {
                    BdLog.e(e);
                    System.gc();
                    TbadkCoreApplication.getInst().onLowMemory();
                    return;
                }
            }
            Canvas canvas = new Canvas(this.aaF);
            canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
            this.aaD.setColor(-1);
            canvas.drawRoundRect(this.sz, this.aaC, this.aaC, this.aaD);
            this.aaE.setImageBitmap(this.aaF);
            if (this.aaE.getParent() == null) {
                addView(this.aaE);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.aaE != null && view != this.aaE) {
            if (this.aaE.getParent() != null) {
                ((ViewGroup) this.aaE.getParent()).removeView(this.aaE);
            }
            super.addView(this.aaE);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.aaE != null) {
            if (this.aaE.getParent() != null) {
                ((ViewGroup) this.aaE.getParent()).removeView(this.aaE);
            }
            super.addView(this.aaE);
        }
    }
}
