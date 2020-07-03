package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BarImageView extends TbClipImageView {
    private int DD;
    private TbImageView.c ais;
    private Path dYL;
    private int dYM;
    private boolean dYN;
    private boolean dYO;
    private boolean dYP;
    private Bitmap dYQ;
    private Bitmap dYR;
    private Bitmap dYS;
    private Canvas dYT;
    private PaintFlagsDrawFilter dYU;
    private PorterDuffXfermode dYV;
    private PorterDuffXfermode dYW;
    private int mDefaultBgId;
    private int mDefaultId;
    private Path mPath;

    public BarImageView(Context context) {
        this(context, null, 0);
    }

    public BarImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BarImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDefaultId = an.getColor(R.color.cp_bg_line_j);
        this.mDefaultBgId = R.drawable.pic_use_header_28_n;
        this.mPath = new Path();
        this.dYL = new Path();
        this.dYM = 0;
        this.DD = 0;
        this.dYN = false;
        this.dYO = false;
        this.dYP = true;
        this.dYV = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.dYW = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.ais = new TbImageView.c() { // from class: com.baidu.tbadk.core.view.BarImageView.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbImageView.getLayoutParams();
                    Path path = new Path();
                    path.reset();
                    int measuredWidth = tbImageView.getMeasuredWidth();
                    int i2 = (0 + measuredWidth) / 2;
                    int measuredHeight = tbImageView.getMeasuredHeight();
                    int i3 = (0 + measuredHeight) / 2;
                    path.moveTo(i2, 0);
                    path.quadTo(measuredWidth, 0 - com.baidu.adp.lib.util.l.getDimens(BarImageView.this.getContext(), R.dimen.tbds6), measuredWidth, i3);
                    path.quadTo(measuredWidth, com.baidu.adp.lib.util.l.getDimens(BarImageView.this.getContext(), R.dimen.tbds6) + measuredHeight, i2, measuredHeight);
                    path.quadTo(0, measuredHeight + com.baidu.adp.lib.util.l.getDimens(BarImageView.this.getContext(), R.dimen.tbds6), 0, i3);
                    path.quadTo(0, 0 - com.baidu.adp.lib.util.l.getDimens(BarImageView.this.getContext(), R.dimen.tbds6), i2, 0);
                    path.close();
                    BarImageView.this.Qm.mPaint.setColor(an.getColor(R.color.white_alpha100));
                    BarImageView.this.Qm.mPaint.setStrokeWidth(com.baidu.adp.lib.util.l.getDimens(BarImageView.this.getContext(), R.dimen.tbds6));
                    BarImageView.this.Qm.mPaint.setStyle(Paint.Style.STROKE);
                    BarImageView.this.Qm.mPaint.setAntiAlias(true);
                    canvas.drawPath(path, BarImageView.this.Qm.mPaint);
                    canvas.clipPath(path);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        init();
    }

    private void init() {
        setDrawerType(0);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultResource(this.mDefaultId);
        setDefaultErrorResource(R.drawable.icon_default_ba_120);
        setDefaultBgResource(this.mDefaultBgId);
    }

    private Bitmap j(int i, int i2, boolean z) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawPath(this.mPath, z ? this.Qm.mBorderPaint : this.Qm.mPaint);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.Qm == null || this.Qm.mPaint == null) {
            super.onDraw(canvas);
        } else if (!this.dYN) {
            super.onDraw(canvas);
        } else {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.mPath.reset();
            float f = measuredWidth;
            float f2 = (0.0f + f) / 2.0f;
            float f3 = measuredHeight;
            float f4 = (0.0f + f3) / 2.0f;
            this.mPath.moveTo(f2, 0.0f);
            this.mPath.cubicTo(measuredWidth - 14.0f, 0.0f, measuredWidth, 14.0f, f, f4);
            this.mPath.cubicTo(measuredWidth, measuredWidth - 14.0f, measuredWidth - 14.0f, measuredWidth, f2, f3);
            this.mPath.cubicTo(14.0f, measuredWidth, 0.0f, measuredWidth - 14.0f, 0.0f, f4);
            this.mPath.cubicTo(0.0f, 14.0f, 14.0f, 0.0f, f2, 0.0f);
            this.mPath.close();
            this.Qm.mBorderPaint.setStyle(Paint.Style.FILL);
            this.Qm.mBorderPaint.setColor(an.getColor(this.DD));
            this.dYS = j(measuredWidth, measuredHeight, true);
            this.mPath.reset();
            float strokeWith = getStrokeWith();
            float f5 = measuredWidth / 2;
            this.mPath.moveTo(f5, strokeWith);
            this.mPath.cubicTo((measuredWidth - strokeWith) - 14.0f, strokeWith, measuredWidth - strokeWith, 14.0f + strokeWith, measuredWidth - strokeWith, f5);
            this.mPath.cubicTo(measuredWidth - strokeWith, (measuredWidth - strokeWith) - 14.0f, (measuredWidth - strokeWith) - 14.0f, measuredWidth - strokeWith, f5, measuredWidth - strokeWith);
            this.mPath.cubicTo(strokeWith + 14.0f, measuredWidth - strokeWith, strokeWith, (measuredWidth - strokeWith) - 14.0f, strokeWith, f5);
            this.mPath.cubicTo(strokeWith, strokeWith + 14.0f, strokeWith + 14.0f, strokeWith, f5, strokeWith);
            this.mPath.close();
            if (this.dYU == null) {
                this.dYU = new PaintFlagsDrawFilter(0, 3);
            }
            canvas.setDrawFilter(this.dYU);
            if (this.dYQ == null) {
                this.dYQ = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            }
            if (this.dYT == null) {
                this.dYT = new Canvas(this.dYQ);
            }
            super.onDraw(this.dYT);
            this.dYR = j(measuredWidth, measuredHeight, false);
            if (this.dYP) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
                this.Qm.mBorderPaint.setStyle(Paint.Style.FILL);
                this.Qm.mBorderPaint.setColor(an.getColor(this.DD));
                canvas.drawBitmap(this.dYR, 0.0f, 0.0f, this.Qm.mBorderPaint);
                this.Qm.mBorderPaint.setXfermode(this.dYW);
                canvas.drawBitmap(this.dYS, 0.0f, 0.0f, this.Qm.mBorderPaint);
                this.Qm.mBorderPaint.setXfermode(null);
                canvas.restoreToCount(saveLayer);
            }
            int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
            canvas.drawBitmap(this.dYR, 0.0f, 0.0f, this.Qm.mPaint);
            this.Qm.mPaint.setXfermode(this.dYV);
            canvas.drawBitmap(this.dYQ, 0.0f, 0.0f, this.Qm.mPaint);
            this.Qm.mPaint.setXfermode(null);
            canvas.restoreToCount(saveLayer2);
            if (this.dYO) {
                a(canvas, measuredWidth, 14.0f);
            }
        }
    }

    public void setStrokeWith(int i) {
        this.dYM = i;
    }

    public int getStrokeWith() {
        return this.dYM;
    }

    private int getStrokeColorResId() {
        return this.DD;
    }

    public void setStrokeColorResId(int i) {
        this.DD = i;
    }

    public void setShowOval(boolean z) {
        this.dYN = z;
    }

    public void setShowInnerBorder(boolean z) {
        this.dYO = z;
    }

    public void setShowOuterBorder(boolean z) {
        this.dYP = z;
    }

    private void a(Canvas canvas, int i, float f) {
        this.dYL.reset();
        float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
        float f2 = i / 2;
        this.dYL.moveTo(f2, strokeWith);
        this.dYL.cubicTo((i - strokeWith) - f, strokeWith, i - strokeWith, strokeWith + f, i - strokeWith, f2);
        this.dYL.cubicTo(i - strokeWith, (i - strokeWith) - f, (i - strokeWith) - f, i - strokeWith, f2, i - strokeWith);
        this.dYL.cubicTo(strokeWith + f, i - strokeWith, strokeWith, (i - strokeWith) - f, strokeWith, f2);
        this.dYL.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f2, strokeWith);
        this.dYL.close();
        float strokeWidth = this.Qm.mBorderPaint.getStrokeWidth();
        this.Qm.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.Qm.mBorderPaint.setStrokeWidth(getStrokeWith() + 0.5f);
        this.Qm.mBorderPaint.setColor(an.getColor(getStrokeColorResId()));
        canvas.drawPath(this.dYL, this.Qm.mBorderPaint);
        this.Qm.mBorderPaint.setStrokeWidth(strokeWidth);
    }
}
