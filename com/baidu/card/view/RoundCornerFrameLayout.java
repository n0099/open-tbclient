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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    private RectF GD;
    private float alu;
    private Paint alv;
    private ImageView alw;
    private ColorFilter alx;
    private ColorFilter aly;
    private Bitmap mMaskBitmap;
    private int mSkinType;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.alw = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alw = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alw = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.GD = new RectF();
        this.alu = getResources().getDimension(R.dimen.tbds10);
        this.alv = new Paint();
        this.alv.setStrokeWidth(0.0f);
        this.alv.setStrokeCap(Paint.Cap.ROUND);
        this.alv.setAntiAlias(true);
        this.alv.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.alw = new ImageView(getContext());
        this.alw.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.alu = f;
        if (this.mMaskBitmap != null) {
            this.mMaskBitmap.recycle();
            uq();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.alw != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.alx = new q(ap.getColor(R.color.cp_bg_line_d));
            this.aly = new q(ap.getColor(R.color.cp_bg_line_e));
            this.alw.setColorFilter(this.alx);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.mMaskBitmap != null && !this.mMaskBitmap.isRecycled()) {
                this.mMaskBitmap.recycle();
            }
            uq();
        }
    }

    public void aO(boolean z) {
        if (this.alw != null) {
            this.alw.setColorFilter(z ? this.aly : this.alx);
        }
    }

    private void uq() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.GD.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
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
            this.alv.setColor(-1);
            canvas.drawRoundRect(this.GD, this.alu, this.alu, this.alv);
            this.alw.setImageBitmap(this.mMaskBitmap);
            if (this.alw.getParent() == null) {
                addView(this.alw);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.alw != null && view != this.alw) {
            if (this.alw.getParent() != null) {
                ((ViewGroup) this.alw.getParent()).removeView(this.alw);
            }
            super.addView(this.alw);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.alw != null) {
            if (this.alw.getParent() != null) {
                ((ViewGroup) this.alw.getParent()).removeView(this.alw);
            }
            super.addView(this.alw);
        }
    }
}
