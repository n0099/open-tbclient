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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    private RectF FG;
    private float ajl;
    private Paint ajm;
    private ImageView ajn;
    private ColorFilter ajo;
    private ColorFilter ajp;
    private Bitmap mMaskBitmap;
    private int mSkinType;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.ajn = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajn = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajn = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.FG = new RectF();
        this.ajl = getResources().getDimension(R.dimen.tbds10);
        this.ajm = new Paint();
        this.ajm.setStrokeWidth(0.0f);
        this.ajm.setStrokeCap(Paint.Cap.ROUND);
        this.ajm.setAntiAlias(true);
        this.ajm.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.ajn = new ImageView(getContext());
        this.ajn.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.ajl = f;
        if (this.mMaskBitmap != null) {
            this.mMaskBitmap.recycle();
            sx();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ajn != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.ajo = new q(ao.getColor(R.color.cp_bg_line_d));
            this.ajp = new q(ao.getColor(R.color.cp_bg_line_e));
            this.ajn.setColorFilter(this.ajo);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.mMaskBitmap != null && !this.mMaskBitmap.isRecycled()) {
                this.mMaskBitmap.recycle();
            }
            sx();
        }
    }

    public void aN(boolean z) {
        if (this.ajn != null) {
            this.ajn.setColorFilter(z ? this.ajp : this.ajo);
        }
    }

    private void sx() {
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
            this.ajm.setColor(-1);
            canvas.drawRoundRect(this.FG, this.ajl, this.ajl, this.ajm);
            this.ajn.setImageBitmap(this.mMaskBitmap);
            if (this.ajn.getParent() == null) {
                addView(this.ajn);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.ajn != null && view != this.ajn) {
            if (this.ajn.getParent() != null) {
                ((ViewGroup) this.ajn.getParent()).removeView(this.ajn);
            }
            super.addView(this.ajn);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.ajn != null) {
            if (this.ajn.getParent() != null) {
                ((ViewGroup) this.ajn.getParent()).removeView(this.ajn);
            }
            super.addView(this.ajn);
        }
    }
}
