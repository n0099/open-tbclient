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
import com.airbnb.lottie.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    private float YP;
    private Paint YQ;
    private ImageView YR;
    private Bitmap YS;
    private ColorFilter YT;
    private ColorFilter YU;
    private int mSkinType;
    private RectF qe;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.YR = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YR = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.YR = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.qe = new RectF();
        this.YP = getResources().getDimension(R.dimen.tbds20);
        this.YQ = new Paint();
        this.YQ.setStrokeWidth(0.0f);
        this.YQ.setStrokeCap(Paint.Cap.ROUND);
        this.YQ.setAntiAlias(true);
        this.YQ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.YR = new ImageView(getContext());
        this.YR.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.YP = f;
        if (this.YS != null) {
            this.YS.recycle();
            rb();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.YR != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.YT = new k(am.getColor(R.color.cp_bg_line_d));
            this.YU = new k(am.getColor(R.color.cp_bg_line_e));
            this.YR.setColorFilter(this.YT);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.YS != null && !this.YS.isRecycled()) {
                this.YS.recycle();
            }
            rb();
        }
    }

    public void aE(boolean z) {
        if (this.YR != null) {
            this.YR.setColorFilter(z ? this.YU : this.YT);
        }
    }

    private void rb() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.qe.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            try {
                this.YS = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
            } catch (OutOfMemoryError e) {
                BdLog.e(e);
                System.gc();
                TbadkCoreApplication.getInst().onLowMemory();
                try {
                    this.YS = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
                } catch (OutOfMemoryError e2) {
                    BdLog.e(e);
                    System.gc();
                    TbadkCoreApplication.getInst().onLowMemory();
                    return;
                }
            }
            Canvas canvas = new Canvas(this.YS);
            canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
            this.YQ.setColor(-1);
            canvas.drawRoundRect(this.qe, this.YP, this.YP, this.YQ);
            this.YR.setImageBitmap(this.YS);
            if (this.YR.getParent() == null) {
                addView(this.YR);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.YR != null && view != this.YR) {
            if (this.YR.getParent() != null) {
                ((ViewGroup) this.YR.getParent()).removeView(this.YR);
            }
            super.addView(this.YR);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.YR != null) {
            if (this.YR.getParent() != null) {
                ((ViewGroup) this.YR.getParent()).removeView(this.YR);
            }
            super.addView(this.YR);
        }
    }
}
