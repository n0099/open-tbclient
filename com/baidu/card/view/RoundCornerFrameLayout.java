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
    private float Il;
    private Paint Im;
    private ImageView In;
    private Bitmap Io;
    private ColorFilter Ip;
    private ColorFilter Iq;
    private RectF hQ;
    private int mSkinType;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.In = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.In = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.In = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.hQ = new RectF();
        this.Il = getResources().getDimension(R.dimen.tbds20);
        this.Im = new Paint();
        this.Im.setStrokeWidth(0.0f);
        this.Im.setStrokeCap(Paint.Cap.ROUND);
        this.Im.setAntiAlias(true);
        this.Im.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.In = new ImageView(getContext());
        this.In.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.Il = f;
        if (this.Io != null) {
            this.Io.recycle();
            mg();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.In != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.Ip = new k(am.getColor(R.color.cp_bg_line_d));
            this.Iq = new k(am.getColor(R.color.cp_bg_line_e));
            this.In.setColorFilter(this.Ip);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.Io != null && !this.Io.isRecycled()) {
                this.Io.recycle();
            }
            mg();
        }
    }

    public void Z(boolean z) {
        if (this.In != null) {
            this.In.setColorFilter(z ? this.Iq : this.Ip);
        }
    }

    private void mg() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.hQ.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            try {
                this.Io = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
            } catch (OutOfMemoryError e) {
                BdLog.e(e);
                System.gc();
                TbadkCoreApplication.getInst().onLowMemory();
                try {
                    this.Io = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
                } catch (OutOfMemoryError e2) {
                    BdLog.e(e);
                    System.gc();
                    TbadkCoreApplication.getInst().onLowMemory();
                    return;
                }
            }
            Canvas canvas = new Canvas(this.Io);
            canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
            this.Im.setColor(-1);
            canvas.drawRoundRect(this.hQ, this.Il, this.Il, this.Im);
            this.In.setImageBitmap(this.Io);
            if (this.In.getParent() == null) {
                addView(this.In);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.In != null && view != this.In) {
            if (this.In.getParent() != null) {
                ((ViewGroup) this.In.getParent()).removeView(this.In);
            }
            super.addView(this.In);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.In != null) {
            if (this.In.getParent() != null) {
                ((ViewGroup) this.In.getParent()).removeView(this.In);
            }
            super.addView(this.In);
        }
    }
}
