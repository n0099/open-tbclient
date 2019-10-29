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
    private float IO;
    private Paint IP;
    private ImageView IQ;
    private Bitmap IR;
    private ColorFilter IS;
    private ColorFilter IT;
    private RectF iu;
    private int mSkinType;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.IQ = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.IQ = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.IQ = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.iu = new RectF();
        this.IO = getResources().getDimension(R.dimen.tbds20);
        this.IP = new Paint();
        this.IP.setStrokeWidth(0.0f);
        this.IP.setStrokeCap(Paint.Cap.ROUND);
        this.IP.setAntiAlias(true);
        this.IP.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.IQ = new ImageView(getContext());
        this.IQ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.IO = f;
        if (this.IR != null) {
            this.IR.recycle();
            mg();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.IQ != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.IS = new k(am.getColor(R.color.cp_bg_line_d));
            this.IT = new k(am.getColor(R.color.cp_bg_line_e));
            this.IQ.setColorFilter(this.IS);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.IR != null && !this.IR.isRecycled()) {
                this.IR.recycle();
            }
            mg();
        }
    }

    public void Z(boolean z) {
        if (this.IQ != null) {
            this.IQ.setColorFilter(z ? this.IT : this.IS);
        }
    }

    private void mg() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.iu.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            try {
                this.IR = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
            } catch (OutOfMemoryError e) {
                BdLog.e(e);
                System.gc();
                TbadkCoreApplication.getInst().onLowMemory();
                try {
                    this.IR = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
                } catch (OutOfMemoryError e2) {
                    BdLog.e(e);
                    System.gc();
                    TbadkCoreApplication.getInst().onLowMemory();
                    return;
                }
            }
            Canvas canvas = new Canvas(this.IR);
            canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
            this.IP.setColor(-1);
            canvas.drawRoundRect(this.iu, this.IO, this.IO, this.IP);
            this.IQ.setImageBitmap(this.IR);
            if (this.IQ.getParent() == null) {
                addView(this.IQ);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.IQ != null && view != this.IQ) {
            if (this.IQ.getParent() != null) {
                ((ViewGroup) this.IQ.getParent()).removeView(this.IQ);
            }
            super.addView(this.IQ);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.IQ != null) {
            if (this.IQ.getParent() != null) {
                ((ViewGroup) this.IQ.getParent()).removeView(this.IQ);
            }
            super.addView(this.IQ);
        }
    }
}
