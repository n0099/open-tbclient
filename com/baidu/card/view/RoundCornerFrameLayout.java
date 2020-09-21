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
/* loaded from: classes20.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    private RectF Gl;
    private float alb;
    private Paint alc;
    private ImageView ald;
    private ColorFilter ale;
    private ColorFilter alf;
    private Bitmap mMaskBitmap;
    private int mSkinType;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.ald = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ald = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ald = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.Gl = new RectF();
        this.alb = getResources().getDimension(R.dimen.tbds10);
        this.alc = new Paint();
        this.alc.setStrokeWidth(0.0f);
        this.alc.setStrokeCap(Paint.Cap.ROUND);
        this.alc.setAntiAlias(true);
        this.alc.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.ald = new ImageView(getContext());
        this.ald.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.alb = f;
        if (this.mMaskBitmap != null) {
            this.mMaskBitmap.recycle();
            uq();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ald != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.ale = new q(ap.getColor(R.color.cp_bg_line_d));
            this.alf = new q(ap.getColor(R.color.cp_bg_line_e));
            this.ald.setColorFilter(this.ale);
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
        if (this.ald != null) {
            this.ald.setColorFilter(z ? this.alf : this.ale);
        }
    }

    private void uq() {
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
            this.alc.setColor(-1);
            canvas.drawRoundRect(this.Gl, this.alb, this.alb, this.alc);
            this.ald.setImageBitmap(this.mMaskBitmap);
            if (this.ald.getParent() == null) {
                addView(this.ald);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.ald != null && view != this.ald) {
            if (this.ald.getParent() != null) {
                ((ViewGroup) this.ald.getParent()).removeView(this.ald);
            }
            super.addView(this.ald);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.ald != null) {
            if (this.ald.getParent() != null) {
                ((ViewGroup) this.ald.getParent()).removeView(this.ald);
            }
            super.addView(this.ald);
        }
    }
}
