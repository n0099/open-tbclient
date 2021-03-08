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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.Arrays;
/* loaded from: classes.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    private float[] ant;
    private Paint anu;
    private ImageView anv;
    private Bitmap anw;
    private ColorFilter anx;
    private ColorFilter any;
    private int mSkinType;
    private RectF rectF;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.ant = new float[8];
        this.anv = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ant = new float[8];
        this.anv = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ant = new float[8];
        this.anv = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.rectF = new RectF();
        this.ant = com.baidu.tbadk.core.elementsMaven.a.aI(R.string.J_X05);
        this.anu = new Paint();
        this.anu.setStrokeWidth(0.0f);
        this.anu.setStrokeCap(Paint.Cap.ROUND);
        this.anu.setAntiAlias(true);
        this.anu.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.anv = new ImageView(getContext());
        this.anv.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        Arrays.fill(this.ant, f);
        if (this.anw != null) {
            this.anw.recycle();
            tD();
        }
    }

    public void setCornerId(int i) {
        this.ant = com.baidu.tbadk.core.elementsMaven.a.aI(i);
        if (this.anw != null) {
            this.anw.recycle();
            tD();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.anv != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.anx = new o(ap.getColor(R.color.CAM_X0201));
            this.any = new o(ap.getColor(R.color.CAM_X0205));
            this.anv.setColorFilter(this.anx);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.anw != null && !this.anw.isRecycled()) {
                this.anw.recycle();
            }
            tD();
        }
    }

    public void aN(boolean z) {
        if (this.anv != null) {
            this.anv.setColorFilter(z ? this.any : this.anx);
        }
    }

    private void tD() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.rectF.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            try {
                this.anw = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
            } catch (OutOfMemoryError e) {
                BdLog.e(e);
                System.gc();
                TbadkCoreApplication.getInst().onLowMemory();
                try {
                    this.anw = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
                } catch (OutOfMemoryError e2) {
                    BdLog.e(e);
                    System.gc();
                    TbadkCoreApplication.getInst().onLowMemory();
                    return;
                }
            }
            Canvas canvas = new Canvas(this.anw);
            canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
            this.anu.setColor(-1);
            Path path = new Path();
            path.addRoundRect(this.rectF, this.ant, Path.Direction.CW);
            canvas.drawPath(path, this.anu);
            this.anv.setImageBitmap(this.anw);
            if (this.anv.getParent() == null) {
                addView(this.anv);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.anv != null && view != this.anv) {
            if (this.anv.getParent() != null) {
                ((ViewGroup) this.anv.getParent()).removeView(this.anv);
            }
            super.addView(this.anv);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.anv != null) {
            if (this.anv.getParent() != null) {
                ((ViewGroup) this.anv.getParent()).removeView(this.anv);
            }
            super.addView(this.anv);
        }
    }
}
