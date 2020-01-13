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
/* loaded from: classes6.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    private float Oh;
    private Paint Oi;
    private ImageView Oj;
    private ColorFilter Ok;
    private ColorFilter Ol;
    private RectF jD;
    private Bitmap mMaskBitmap;
    private int mSkinType;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.Oj = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Oj = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Oj = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.jD = new RectF();
        this.Oh = getResources().getDimension(R.dimen.tbds10);
        this.Oi = new Paint();
        this.Oi.setStrokeWidth(0.0f);
        this.Oi.setStrokeCap(Paint.Cap.ROUND);
        this.Oi.setAntiAlias(true);
        this.Oi.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.Oj = new ImageView(getContext());
        this.Oj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.Oh = f;
        if (this.mMaskBitmap != null) {
            this.mMaskBitmap.recycle();
            ng();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Oj != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.Ok = new q(am.getColor(R.color.cp_bg_line_d));
            this.Ol = new q(am.getColor(R.color.cp_bg_line_e));
            this.Oj.setColorFilter(this.Ok);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.mMaskBitmap != null && !this.mMaskBitmap.isRecycled()) {
                this.mMaskBitmap.recycle();
            }
            ng();
        }
    }

    public void ag(boolean z) {
        if (this.Oj != null) {
            this.Oj.setColorFilter(z ? this.Ol : this.Ok);
        }
    }

    private void ng() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.jD.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
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
            this.Oi.setColor(-1);
            canvas.drawRoundRect(this.jD, this.Oh, this.Oh, this.Oi);
            this.Oj.setImageBitmap(this.mMaskBitmap);
            if (this.Oj.getParent() == null) {
                addView(this.Oj);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.Oj != null && view != this.Oj) {
            if (this.Oj.getParent() != null) {
                ((ViewGroup) this.Oj.getParent()).removeView(this.Oj);
            }
            super.addView(this.Oj);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.Oj != null) {
            if (this.Oj.getParent() != null) {
                ((ViewGroup) this.Oj.getParent()).removeView(this.Oj);
            }
            super.addView(this.Oj);
        }
    }
}
