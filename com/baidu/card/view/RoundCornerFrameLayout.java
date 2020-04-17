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
    private RectF Fd;
    private float ahn;
    private Paint aho;
    private ImageView ahp;
    private ColorFilter ahq;
    private ColorFilter ahr;
    private Bitmap mMaskBitmap;
    private int mSkinType;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.ahp = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahp = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahp = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.Fd = new RectF();
        this.ahn = getResources().getDimension(R.dimen.tbds10);
        this.aho = new Paint();
        this.aho.setStrokeWidth(0.0f);
        this.aho.setStrokeCap(Paint.Cap.ROUND);
        this.aho.setAntiAlias(true);
        this.aho.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.ahp = new ImageView(getContext());
        this.ahp.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.ahn = f;
        if (this.mMaskBitmap != null) {
            this.mMaskBitmap.recycle();
            rQ();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ahp != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.ahq = new q(am.getColor(R.color.cp_bg_line_d));
            this.ahr = new q(am.getColor(R.color.cp_bg_line_e));
            this.ahp.setColorFilter(this.ahq);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.mMaskBitmap != null && !this.mMaskBitmap.isRecycled()) {
                this.mMaskBitmap.recycle();
            }
            rQ();
        }
    }

    public void aI(boolean z) {
        if (this.ahp != null) {
            this.ahp.setColorFilter(z ? this.ahr : this.ahq);
        }
    }

    private void rQ() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.Fd.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
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
            this.aho.setColor(-1);
            canvas.drawRoundRect(this.Fd, this.ahn, this.ahn, this.aho);
            this.ahp.setImageBitmap(this.mMaskBitmap);
            if (this.ahp.getParent() == null) {
                addView(this.ahp);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.ahp != null && view != this.ahp) {
            if (this.ahp.getParent() != null) {
                ((ViewGroup) this.ahp.getParent()).removeView(this.ahp);
            }
            super.addView(this.ahp);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.ahp != null) {
            if (this.ahp.getParent() != null) {
                ((ViewGroup) this.ahp.getParent()).removeView(this.ahp);
            }
            super.addView(this.ahp);
        }
    }
}
