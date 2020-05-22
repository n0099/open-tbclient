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
/* loaded from: classes8.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    private RectF Fg;
    private float ahT;
    private Paint ahU;
    private ImageView ahV;
    private ColorFilter ahW;
    private ColorFilter ahX;
    private Bitmap mMaskBitmap;
    private int mSkinType;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.ahV = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahV = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahV = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.Fg = new RectF();
        this.ahT = getResources().getDimension(R.dimen.tbds10);
        this.ahU = new Paint();
        this.ahU.setStrokeWidth(0.0f);
        this.ahU.setStrokeCap(Paint.Cap.ROUND);
        this.ahU.setAntiAlias(true);
        this.ahU.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.ahV = new ImageView(getContext());
        this.ahV.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.ahT = f;
        if (this.mMaskBitmap != null) {
            this.mMaskBitmap.recycle();
            sa();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ahV != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.ahW = new q(am.getColor(R.color.cp_bg_line_d));
            this.ahX = new q(am.getColor(R.color.cp_bg_line_e));
            this.ahV.setColorFilter(this.ahW);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.mMaskBitmap != null && !this.mMaskBitmap.isRecycled()) {
                this.mMaskBitmap.recycle();
            }
            sa();
        }
    }

    public void aJ(boolean z) {
        if (this.ahV != null) {
            this.ahV.setColorFilter(z ? this.ahX : this.ahW);
        }
    }

    private void sa() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.Fg.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
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
            this.ahU.setColor(-1);
            canvas.drawRoundRect(this.Fg, this.ahT, this.ahT, this.ahU);
            this.ahV.setImageBitmap(this.mMaskBitmap);
            if (this.ahV.getParent() == null) {
                addView(this.ahV);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.ahV != null && view != this.ahV) {
            if (this.ahV.getParent() != null) {
                ((ViewGroup) this.ahV.getParent()).removeView(this.ahV);
            }
            super.addView(this.ahV);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.ahV != null) {
            if (this.ahV.getParent() != null) {
                ((ViewGroup) this.ahV.getParent()).removeView(this.ahV);
            }
            super.addView(this.ahV);
        }
    }
}
