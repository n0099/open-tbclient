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
import java.util.Arrays;
/* loaded from: classes20.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    private RectF GD;
    private Paint alA;
    private ImageView alB;
    private ColorFilter alC;
    private ColorFilter alD;
    private float[] alz;
    private Bitmap mMaskBitmap;
    private int mSkinType;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.alz = new float[8];
        this.alB = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alz = new float[8];
        this.alB = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alz = new float[8];
        this.alB = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.GD = new RectF();
        this.alz = com.baidu.tbadk.core.elementsMaven.a.aD(R.string.J_X05);
        this.alA = new Paint();
        this.alA.setStrokeWidth(0.0f);
        this.alA.setStrokeCap(Paint.Cap.ROUND);
        this.alA.setAntiAlias(true);
        this.alA.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.alB = new ImageView(getContext());
        this.alB.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        Arrays.fill(this.alz, f);
        if (this.mMaskBitmap != null) {
            this.mMaskBitmap.recycle();
            up();
        }
    }

    public void setCornerId(int i) {
        this.alz = com.baidu.tbadk.core.elementsMaven.a.aD(i);
        if (this.mMaskBitmap != null) {
            this.mMaskBitmap.recycle();
            up();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.alB != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.alC = new q(ap.getColor(R.color.CAM_X0201));
            this.alD = new q(ap.getColor(R.color.CAM_X0205));
            this.alB.setColorFilter(this.alC);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.mMaskBitmap != null && !this.mMaskBitmap.isRecycled()) {
                this.mMaskBitmap.recycle();
            }
            up();
        }
    }

    public void aQ(boolean z) {
        if (this.alB != null) {
            this.alB.setColorFilter(z ? this.alD : this.alC);
        }
    }

    private void up() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.GD.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
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
            this.alA.setColor(-1);
            Path path = new Path();
            path.addRoundRect(this.GD, this.alz, Path.Direction.CW);
            canvas.drawPath(path, this.alA);
            this.alB.setImageBitmap(this.mMaskBitmap);
            if (this.alB.getParent() == null) {
                addView(this.alB);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.alB != null && view != this.alB) {
            if (this.alB.getParent() != null) {
                ((ViewGroup) this.alB.getParent()).removeView(this.alB);
            }
            super.addView(this.alB);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.alB != null) {
            if (this.alB.getParent() != null) {
                ((ViewGroup) this.alB.getParent()).removeView(this.alB);
            }
            super.addView(this.alB);
        }
    }
}
