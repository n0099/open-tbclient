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
    private float OH;
    private Paint OI;
    private ImageView OJ;
    private ColorFilter OL;
    private ColorFilter OM;
    private RectF jH;
    private Bitmap mMaskBitmap;
    private int mSkinType;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.OJ = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OJ = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.OJ = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.jH = new RectF();
        this.OH = getResources().getDimension(R.dimen.tbds10);
        this.OI = new Paint();
        this.OI.setStrokeWidth(0.0f);
        this.OI.setStrokeCap(Paint.Cap.ROUND);
        this.OI.setAntiAlias(true);
        this.OI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.OJ = new ImageView(getContext());
        this.OJ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.OH = f;
        if (this.mMaskBitmap != null) {
            this.mMaskBitmap.recycle();
            nx();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.OJ != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.OL = new q(am.getColor(R.color.cp_bg_line_d));
            this.OM = new q(am.getColor(R.color.cp_bg_line_e));
            this.OJ.setColorFilter(this.OL);
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
        if (this.OJ != null) {
            this.OJ.setColorFilter(z ? this.OM : this.OL);
        }
    }

    private void nx() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.jH.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
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
            this.OI.setColor(-1);
            canvas.drawRoundRect(this.jH, this.OH, this.OH, this.OI);
            this.OJ.setImageBitmap(this.mMaskBitmap);
            if (this.OJ.getParent() == null) {
                addView(this.OJ);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.OJ != null && view != this.OJ) {
            if (this.OJ.getParent() != null) {
                ((ViewGroup) this.OJ.getParent()).removeView(this.OJ);
            }
            super.addView(this.OJ);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.OJ != null) {
            if (this.OJ.getParent() != null) {
                ((ViewGroup) this.OJ.getParent()).removeView(this.OJ);
            }
            super.addView(this.OJ);
        }
    }
}
