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
    private float aaB;
    private Paint aaC;
    private ImageView aaD;
    private Bitmap aaE;
    private ColorFilter aaF;
    private ColorFilter aaG;
    private int mSkinType;
    private RectF sz;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.aaD = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaD = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aaD = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.sz = new RectF();
        this.aaB = getResources().getDimension(d.e.tbds20);
        this.aaC = new Paint();
        this.aaC.setStrokeWidth(0.0f);
        this.aaC.setStrokeCap(Paint.Cap.ROUND);
        this.aaC.setAntiAlias(true);
        this.aaC.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.aaD = new ImageView(getContext());
        this.aaD.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.aaB = f;
        if (this.aaE != null) {
            this.aaE.recycle();
            rI();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aaD != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.aaF = new k(al.getColor(d.C0277d.cp_bg_line_d));
            this.aaG = new k(al.getColor(d.C0277d.cp_bg_line_e));
            this.aaD.setColorFilter(this.aaF);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.aaE != null && !this.aaE.isRecycled()) {
                this.aaE.recycle();
            }
            rI();
        }
    }

    public void aJ(boolean z) {
        if (this.aaD != null) {
            this.aaD.setColorFilter(z ? this.aaG : this.aaF);
        }
    }

    private void rI() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.sz.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            try {
                this.aaE = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
            } catch (OutOfMemoryError e) {
                BdLog.e(e);
                System.gc();
                TbadkCoreApplication.getInst().onLowMemory();
                try {
                    this.aaE = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
                } catch (OutOfMemoryError e2) {
                    BdLog.e(e);
                    System.gc();
                    TbadkCoreApplication.getInst().onLowMemory();
                    return;
                }
            }
            Canvas canvas = new Canvas(this.aaE);
            canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
            this.aaC.setColor(-1);
            canvas.drawRoundRect(this.sz, this.aaB, this.aaB, this.aaC);
            this.aaD.setImageBitmap(this.aaE);
            if (this.aaD.getParent() == null) {
                addView(this.aaD);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.aaD != null && view != this.aaD) {
            if (this.aaD.getParent() != null) {
                ((ViewGroup) this.aaD.getParent()).removeView(this.aaD);
            }
            super.addView(this.aaD);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.aaD != null) {
            if (this.aaD.getParent() != null) {
                ((ViewGroup) this.aaD.getParent()).removeView(this.aaD);
            }
            super.addView(this.aaD);
        }
    }
}
