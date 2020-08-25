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
/* loaded from: classes15.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    private RectF Gl;
    private float akA;
    private Paint akB;
    private ImageView akC;
    private ColorFilter akD;
    private ColorFilter akE;
    private Bitmap mMaskBitmap;
    private int mSkinType;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.akC = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akC = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akC = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.Gl = new RectF();
        this.akA = getResources().getDimension(R.dimen.tbds10);
        this.akB = new Paint();
        this.akB.setStrokeWidth(0.0f);
        this.akB.setStrokeCap(Paint.Cap.ROUND);
        this.akB.setAntiAlias(true);
        this.akB.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.akC = new ImageView(getContext());
        this.akC.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.akA = f;
        if (this.mMaskBitmap != null) {
            this.mMaskBitmap.recycle();
            uk();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.akC != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.akD = new q(ap.getColor(R.color.cp_bg_line_d));
            this.akE = new q(ap.getColor(R.color.cp_bg_line_e));
            this.akC.setColorFilter(this.akD);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.mMaskBitmap != null && !this.mMaskBitmap.isRecycled()) {
                this.mMaskBitmap.recycle();
            }
            uk();
        }
    }

    public void aO(boolean z) {
        if (this.akC != null) {
            this.akC.setColorFilter(z ? this.akE : this.akD);
        }
    }

    private void uk() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.Gl.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
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
            this.akB.setColor(-1);
            canvas.drawRoundRect(this.Gl, this.akA, this.akA, this.akB);
            this.akC.setImageBitmap(this.mMaskBitmap);
            if (this.akC.getParent() == null) {
                addView(this.akC);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.akC != null && view != this.akC) {
            if (this.akC.getParent() != null) {
                ((ViewGroup) this.akC.getParent()).removeView(this.akC);
            }
            super.addView(this.akC);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.akC != null) {
            if (this.akC.getParent() != null) {
                ((ViewGroup) this.akC.getParent()).removeView(this.akC);
            }
            super.addView(this.akC);
        }
    }
}
