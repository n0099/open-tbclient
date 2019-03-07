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
    private float aaA;
    private Paint aaB;
    private ImageView aaC;
    private Bitmap aaD;
    private ColorFilter aaE;
    private ColorFilter aaF;
    private int mSkinType;
    private RectF sz;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.aaC = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaC = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aaC = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.sz = new RectF();
        this.aaA = getResources().getDimension(d.e.tbds20);
        this.aaB = new Paint();
        this.aaB.setStrokeWidth(0.0f);
        this.aaB.setStrokeCap(Paint.Cap.ROUND);
        this.aaB.setAntiAlias(true);
        this.aaB.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.aaC = new ImageView(getContext());
        this.aaC.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.aaA = f;
        if (this.aaD != null) {
            this.aaD.recycle();
            rI();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aaC != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.aaE = new k(al.getColor(d.C0236d.cp_bg_line_d));
            this.aaF = new k(al.getColor(d.C0236d.cp_bg_line_e));
            this.aaC.setColorFilter(this.aaE);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.aaD != null && !this.aaD.isRecycled()) {
                this.aaD.recycle();
            }
            rI();
        }
    }

    public void aJ(boolean z) {
        if (this.aaC != null) {
            this.aaC.setColorFilter(z ? this.aaF : this.aaE);
        }
    }

    private void rI() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.sz.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            try {
                this.aaD = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
            } catch (OutOfMemoryError e) {
                BdLog.e(e);
                System.gc();
                TbadkCoreApplication.getInst().onLowMemory();
                try {
                    this.aaD = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
                } catch (OutOfMemoryError e2) {
                    BdLog.e(e);
                    System.gc();
                    TbadkCoreApplication.getInst().onLowMemory();
                    return;
                }
            }
            Canvas canvas = new Canvas(this.aaD);
            canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
            this.aaB.setColor(-1);
            canvas.drawRoundRect(this.sz, this.aaA, this.aaA, this.aaB);
            this.aaC.setImageBitmap(this.aaD);
            if (this.aaC.getParent() == null) {
                addView(this.aaC);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.aaC != null && view != this.aaC) {
            if (this.aaC.getParent() != null) {
                ((ViewGroup) this.aaC.getParent()).removeView(this.aaC);
            }
            super.addView(this.aaC);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.aaC != null) {
            if (this.aaC.getParent() != null) {
                ((ViewGroup) this.aaC.getParent()).removeView(this.aaC);
            }
            super.addView(this.aaC);
        }
    }
}
