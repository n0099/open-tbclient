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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    private RectF FG;
    private float ajq;
    private Paint ajr;
    private ImageView ajs;
    private ColorFilter ajt;
    private ColorFilter aju;
    private Bitmap mMaskBitmap;
    private int mSkinType;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.ajs = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajs = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajs = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.FG = new RectF();
        this.ajq = getResources().getDimension(R.dimen.tbds10);
        this.ajr = new Paint();
        this.ajr.setStrokeWidth(0.0f);
        this.ajr.setStrokeCap(Paint.Cap.ROUND);
        this.ajr.setAntiAlias(true);
        this.ajr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.ajs = new ImageView(getContext());
        this.ajs.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.ajq = f;
        if (this.mMaskBitmap != null) {
            this.mMaskBitmap.recycle();
            sv();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ajs != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.ajt = new q(an.getColor(R.color.cp_bg_line_d));
            this.aju = new q(an.getColor(R.color.cp_bg_line_e));
            this.ajs.setColorFilter(this.ajt);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.mMaskBitmap != null && !this.mMaskBitmap.isRecycled()) {
                this.mMaskBitmap.recycle();
            }
            sv();
        }
    }

    public void aK(boolean z) {
        if (this.ajs != null) {
            this.ajs.setColorFilter(z ? this.aju : this.ajt);
        }
    }

    private void sv() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.FG.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
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
            this.ajr.setColor(-1);
            canvas.drawRoundRect(this.FG, this.ajq, this.ajq, this.ajr);
            this.ajs.setImageBitmap(this.mMaskBitmap);
            if (this.ajs.getParent() == null) {
                addView(this.ajs);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.ajs != null && view != this.ajs) {
            if (this.ajs.getParent() != null) {
                ((ViewGroup) this.ajs.getParent()).removeView(this.ajs);
            }
            super.addView(this.ajs);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.ajs != null) {
            if (this.ajs.getParent() != null) {
                ((ViewGroup) this.ajs.getParent()).removeView(this.ajs);
            }
            super.addView(this.ajs);
        }
    }
}
