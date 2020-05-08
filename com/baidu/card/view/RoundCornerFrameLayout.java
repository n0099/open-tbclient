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
    private RectF Fg;
    private float ahq;
    private Paint ahr;
    private ImageView ahs;
    private ColorFilter aht;
    private ColorFilter ahu;
    private Bitmap mMaskBitmap;
    private int mSkinType;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.ahs = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahs = null;
        this.mSkinType = 3;
        init();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahs = null;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.Fg = new RectF();
        this.ahq = getResources().getDimension(R.dimen.tbds10);
        this.ahr = new Paint();
        this.ahr.setStrokeWidth(0.0f);
        this.ahr.setStrokeCap(Paint.Cap.ROUND);
        this.ahr.setAntiAlias(true);
        this.ahr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.ahs = new ImageView(getContext());
        this.ahs.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void setCorner(float f) {
        this.ahq = f;
        if (this.mMaskBitmap != null) {
            this.mMaskBitmap.recycle();
            rQ();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ahs != null && this.mSkinType != i) {
            this.mSkinType = i;
            this.aht = new q(am.getColor(R.color.cp_bg_line_d));
            this.ahu = new q(am.getColor(R.color.cp_bg_line_e));
            this.ahs.setColorFilter(this.aht);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
            if (this.mMaskBitmap != null && !this.mMaskBitmap.isRecycled()) {
                this.mMaskBitmap.recycle();
            }
            rQ();
        }
    }

    public void aI(boolean z) {
        if (this.ahs != null) {
            this.ahs.setColorFilter(z ? this.ahu : this.aht);
        }
    }

    private void rQ() {
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.Fg.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
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
            this.ahr.setColor(-1);
            canvas.drawRoundRect(this.Fg, this.ahq, this.ahq, this.ahr);
            this.ahs.setImageBitmap(this.mMaskBitmap);
            if (this.ahs.getParent() == null) {
                addView(this.ahs);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.ahs != null && view != this.ahs) {
            if (this.ahs.getParent() != null) {
                ((ViewGroup) this.ahs.getParent()).removeView(this.ahs);
            }
            super.addView(this.ahs);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.ahs != null) {
            if (this.ahs.getParent() != null) {
                ((ViewGroup) this.ahs.getParent()).removeView(this.ahs);
            }
            super.addView(this.ahs);
        }
    }
}
