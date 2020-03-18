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
    private float OI;
    private Paint OJ;
    private ImageView OL;
    private ColorFilter OM;
    private ColorFilter OO;
    private RectF jG;
    private Bitmap mMaskBitmap;
    private int mSkinType;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.OL = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OL = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.OL = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.jG = new RectF();
        this.OI = getResources().getDimension(R.dimen.tbds10);
        this.OJ = new Paint();
        this.OJ.setStrokeWidth(0.0f);
        this.OJ.setStrokeCap(Paint.Cap.ROUND);
        this.OJ.setAntiAlias(true);
        this.OJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.OL = new ImageView(getContext());
        this.OL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.OI = f;
        if (this.mMaskBitmap != null) {
            this.mMaskBitmap.recycle();
            nx();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.OL != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.OM = new q(am.getColor(R.color.cp_bg_line_d));
            this.OO = new q(am.getColor(R.color.cp_bg_line_e));
            this.OL.setColorFilter(this.OM);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.mMaskBitmap != null && !this.mMaskBitmap.isRecycled()) {
                this.mMaskBitmap.recycle();
            }
            nx();
        }
    }

    public void aj(boolean z) {
        if (this.OL != null) {
            this.OL.setColorFilter(z ? this.OO : this.OM);
        }
    }

    private void nx() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.jG.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
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
            this.OJ.setColor(-1);
            canvas.drawRoundRect(this.jG, this.OI, this.OI, this.OJ);
            this.OL.setImageBitmap(this.mMaskBitmap);
            if (this.OL.getParent() == null) {
                addView(this.OL);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.OL != null && view != this.OL) {
            if (this.OL.getParent() != null) {
                ((ViewGroup) this.OL.getParent()).removeView(this.OL);
            }
            super.addView(this.OL);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.OL != null) {
            if (this.OL.getParent() != null) {
                ((ViewGroup) this.OL.getParent()).removeView(this.OL);
            }
            super.addView(this.OL);
        }
    }
}
