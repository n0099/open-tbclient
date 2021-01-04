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
    private float[] anc;
    private Paint and;
    private ImageView ane;
    private Bitmap anf;
    private ColorFilter ang;
    private ColorFilter anh;
    private int mSkinType;
    private RectF rectF;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.anc = new float[8];
        this.ane = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anc = new float[8];
        this.ane = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anc = new float[8];
        this.ane = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.rectF = new RectF();
        this.anc = com.baidu.tbadk.core.elementsMaven.a.aI(R.string.J_X05);
        this.and = new Paint();
        this.and.setStrokeWidth(0.0f);
        this.and.setStrokeCap(Paint.Cap.ROUND);
        this.and.setAntiAlias(true);
        this.and.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.ane = new ImageView(getContext());
        this.ane.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        Arrays.fill(this.anc, f);
        if (this.anf != null) {
            this.anf.recycle();
            tR();
        }
    }

    public void setCornerId(int i) {
        this.anc = com.baidu.tbadk.core.elementsMaven.a.aI(i);
        if (this.anf != null) {
            this.anf.recycle();
            tR();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ane != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.ang = new o(ao.getColor(R.color.CAM_X0201));
            this.anh = new o(ao.getColor(R.color.CAM_X0205));
            this.ane.setColorFilter(this.ang);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.anf != null && !this.anf.isRecycled()) {
                this.anf.recycle();
            }
            tR();
        }
    }

    public void aN(boolean z) {
        if (this.ane != null) {
            this.ane.setColorFilter(z ? this.anh : this.ang);
        }
    }

    private void tR() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.rectF.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            try {
                this.anf = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
            } catch (OutOfMemoryError e) {
                BdLog.e(e);
                System.gc();
                TbadkCoreApplication.getInst().onLowMemory();
                try {
                    this.anf = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
                } catch (OutOfMemoryError e2) {
                    BdLog.e(e);
                    System.gc();
                    TbadkCoreApplication.getInst().onLowMemory();
                    return;
                }
            }
            Canvas canvas = new Canvas(this.anf);
            canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
            this.and.setColor(-1);
            Path path = new Path();
            path.addRoundRect(this.rectF, this.anc, Path.Direction.CW);
            canvas.drawPath(path, this.and);
            this.ane.setImageBitmap(this.anf);
            if (this.ane.getParent() == null) {
                addView(this.ane);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.ane != null && view != this.ane) {
            if (this.ane.getParent() != null) {
                ((ViewGroup) this.ane.getParent()).removeView(this.ane);
            }
            super.addView(this.ane);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.ane != null) {
            if (this.ane.getParent() != null) {
                ((ViewGroup) this.ane.getParent()).removeView(this.ane);
            }
            super.addView(this.ane);
        }
    }
}
