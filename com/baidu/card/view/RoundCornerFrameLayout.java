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
    private float[] amb;
    private Paint amc;
    private ImageView amd;
    private Bitmap ame;
    private ColorFilter amf;
    private ColorFilter amg;
    private int mSkinType;
    private RectF rectF;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.amb = new float[8];
        this.amd = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amb = new float[8];
        this.amd = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amb = new float[8];
        this.amd = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.rectF = new RectF();
        this.amb = com.baidu.tbadk.core.elementsMaven.a.aI(R.string.J_X05);
        this.amc = new Paint();
        this.amc.setStrokeWidth(0.0f);
        this.amc.setStrokeCap(Paint.Cap.ROUND);
        this.amc.setAntiAlias(true);
        this.amc.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.amd = new ImageView(getContext());
        this.amd.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        Arrays.fill(this.amb, f);
        if (this.ame != null) {
            this.ame.recycle();
            tD();
        }
    }

    public void setCornerId(int i) {
        this.amb = com.baidu.tbadk.core.elementsMaven.a.aI(i);
        if (this.ame != null) {
            this.ame.recycle();
            tD();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.amd != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.amf = new o(ap.getColor(R.color.CAM_X0201));
            this.amg = new o(ap.getColor(R.color.CAM_X0205));
            this.amd.setColorFilter(this.amf);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.ame != null && !this.ame.isRecycled()) {
                this.ame.recycle();
            }
            tD();
        }
    }

    public void aN(boolean z) {
        if (this.amd != null) {
            this.amd.setColorFilter(z ? this.amg : this.amf);
        }
    }

    private void tD() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.rectF.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            try {
                this.ame = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
            } catch (OutOfMemoryError e) {
                BdLog.e(e);
                System.gc();
                TbadkCoreApplication.getInst().onLowMemory();
                try {
                    this.ame = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
                } catch (OutOfMemoryError e2) {
                    BdLog.e(e);
                    System.gc();
                    TbadkCoreApplication.getInst().onLowMemory();
                    return;
                }
            }
            Canvas canvas = new Canvas(this.ame);
            canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
            this.amc.setColor(-1);
            Path path = new Path();
            path.addRoundRect(this.rectF, this.amb, Path.Direction.CW);
            canvas.drawPath(path, this.amc);
            this.amd.setImageBitmap(this.ame);
            if (this.amd.getParent() == null) {
                addView(this.amd);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.amd != null && view != this.amd) {
            if (this.amd.getParent() != null) {
                ((ViewGroup) this.amd.getParent()).removeView(this.amd);
            }
            super.addView(this.amd);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.amd != null) {
            if (this.amd.getParent() != null) {
                ((ViewGroup) this.amd.getParent()).removeView(this.amd);
            }
            super.addView(this.amd);
        }
    }
}
