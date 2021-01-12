package com.baidu.card.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.o;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.Arrays;
/* loaded from: classes.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    private float[] aml;
    private Paint amm;
    private ImageView amn;
    private Bitmap amo;
    private ColorFilter amp;
    private ColorFilter amq;
    private int mSkinType;
    private RectF rectF;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.aml = new float[8];
        this.amn = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aml = new float[8];
        this.amn = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aml = new float[8];
        this.amn = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.rectF = new RectF();
        this.aml = com.baidu.tbadk.core.elementsMaven.a.aI(R.string.J_X05);
        this.amm = new Paint();
        this.amm.setStrokeWidth(0.0f);
        this.amm.setStrokeCap(Paint.Cap.ROUND);
        this.amm.setAntiAlias(true);
        this.amm.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.amn = new ImageView(getContext());
        this.amn.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        Arrays.fill(this.aml, f);
        if (this.amo != null) {
            this.amo.recycle();
            tG();
        }
    }

    public void setCornerId(int i) {
        this.aml = com.baidu.tbadk.core.elementsMaven.a.aI(i);
        if (this.amo != null) {
            this.amo.recycle();
            tG();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.amn != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.amp = new o(ao.getColor(R.color.CAM_X0201));
            this.amq = new o(ao.getColor(R.color.CAM_X0205));
            this.amn.setColorFilter(this.amp);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.amo != null && !this.amo.isRecycled()) {
                this.amo.recycle();
            }
            tG();
        }
    }

    public void aN(boolean z) {
        if (this.amn != null) {
            this.amn.setColorFilter(z ? this.amq : this.amp);
        }
    }

    private void tG() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.rectF.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            try {
                this.amo = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
            } catch (OutOfMemoryError e) {
                BdLog.e(e);
                System.gc();
                TbadkCoreApplication.getInst().onLowMemory();
                try {
                    this.amo = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
                } catch (OutOfMemoryError e2) {
                    BdLog.e(e);
                    System.gc();
                    TbadkCoreApplication.getInst().onLowMemory();
                    return;
                }
            }
            Canvas canvas = new Canvas(this.amo);
            canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
            this.amm.setColor(-1);
            Path path = new Path();
            path.addRoundRect(this.rectF, this.aml, Path.Direction.CW);
            canvas.drawPath(path, this.amm);
            this.amn.setImageBitmap(this.amo);
            if (this.amn.getParent() == null) {
                addView(this.amn);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.amn != null && view != this.amn) {
            if (this.amn.getParent() != null) {
                ((ViewGroup) this.amn.getParent()).removeView(this.amn);
            }
            super.addView(this.amn);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.amn != null) {
            if (this.amn.getParent() != null) {
                ((ViewGroup) this.amn.getParent()).removeView(this.amn);
            }
            super.addView(this.amn);
        }
    }
}
