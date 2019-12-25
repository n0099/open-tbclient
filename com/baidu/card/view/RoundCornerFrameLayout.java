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
import com.airbnb.lottie.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    private float Oc;
    private Paint Oe;
    private ImageView Of;
    private ColorFilter Og;
    private ColorFilter Oh;
    private RectF jE;
    private Bitmap mMaskBitmap;
    private int mSkinType;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.Of = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Of = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Of = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.jE = new RectF();
        this.Oc = getResources().getDimension(R.dimen.tbds10);
        this.Oe = new Paint();
        this.Oe.setStrokeWidth(0.0f);
        this.Oe.setStrokeCap(Paint.Cap.ROUND);
        this.Oe.setAntiAlias(true);
        this.Oe.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.Of = new ImageView(getContext());
        this.Of.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.Oc = f;
        if (this.mMaskBitmap != null) {
            this.mMaskBitmap.recycle();
            nf();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Of != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.Og = new q(am.getColor(R.color.cp_bg_line_d));
            this.Oh = new q(am.getColor(R.color.cp_bg_line_e));
            this.Of.setColorFilter(this.Og);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.mMaskBitmap != null && !this.mMaskBitmap.isRecycled()) {
                this.mMaskBitmap.recycle();
            }
            nf();
        }
    }

    public void ag(boolean z) {
        if (this.Of != null) {
            this.Of.setColorFilter(z ? this.Oh : this.Og);
        }
    }

    private void nf() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.jE.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
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
            this.Oe.setColor(-1);
            canvas.drawRoundRect(this.jE, this.Oc, this.Oc, this.Oe);
            this.Of.setImageBitmap(this.mMaskBitmap);
            if (this.Of.getParent() == null) {
                addView(this.Of);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.Of != null && view != this.Of) {
            if (this.Of.getParent() != null) {
                ((ViewGroup) this.Of.getParent()).removeView(this.Of);
            }
            super.addView(this.Of);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.Of != null) {
            if (this.Of.getParent() != null) {
                ((ViewGroup) this.Of.getParent()).removeView(this.Of);
            }
            super.addView(this.Of);
        }
    }
}
