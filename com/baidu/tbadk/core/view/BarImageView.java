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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BarImageView extends TbClipImageView {
    private TbImageView.c NT;
    private Path ddE;
    private int ddF;
    private boolean ddG;
    private boolean ddH;
    private boolean ddI;
    private Bitmap ddJ;
    private Bitmap ddK;
    private Bitmap ddL;
    private Canvas ddM;
    private PaintFlagsDrawFilter ddN;
    private PorterDuffXfermode ddO;
    private PorterDuffXfermode ddP;
    private int hx;
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
        this.mDefaultId = am.getColor(R.color.cp_bg_line_j);
        this.mDefaultBgId = am.ku(R.drawable.pic_use_header_28_n);
        this.mPath = new Path();
        this.ddE = new Path();
        this.ddF = 0;
        this.hx = 0;
        this.ddG = false;
        this.ddH = false;
        this.ddI = true;
        this.ddO = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.ddP = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.NT = new TbImageView.c() { // from class: com.baidu.tbadk.core.view.BarImageView.1
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
                    BarImageView.this.wy.mPaint.setColor(am.getColor(R.color.white_alpha100));
                    BarImageView.this.wy.mPaint.setStrokeWidth(com.baidu.adp.lib.util.l.getDimens(BarImageView.this.getContext(), R.dimen.tbds6));
                    BarImageView.this.wy.mPaint.setStyle(Paint.Style.STROKE);
                    BarImageView.this.wy.mPaint.setAntiAlias(true);
                    canvas.drawPath(path, BarImageView.this.wy.mPaint);
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
        new Canvas(createBitmap).drawPath(this.mPath, z ? this.wy.mBorderPaint : this.wy.mPaint);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.wy == null || this.wy.mPaint == null) {
            super.onDraw(canvas);
        } else if (!this.ddG) {
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
            this.wy.mBorderPaint.setStyle(Paint.Style.FILL);
            this.wy.mBorderPaint.setColor(am.getColor(this.hx));
            this.ddL = j(measuredWidth, measuredHeight, true);
            this.mPath.reset();
            float strokeWith = getStrokeWith();
            float f5 = measuredWidth / 2;
            this.mPath.moveTo(f5, strokeWith);
            this.mPath.cubicTo((measuredWidth - strokeWith) - 14.0f, strokeWith, measuredWidth - strokeWith, 14.0f + strokeWith, measuredWidth - strokeWith, f5);
            this.mPath.cubicTo(measuredWidth - strokeWith, (measuredWidth - strokeWith) - 14.0f, (measuredWidth - strokeWith) - 14.0f, measuredWidth - strokeWith, f5, measuredWidth - strokeWith);
            this.mPath.cubicTo(strokeWith + 14.0f, measuredWidth - strokeWith, strokeWith, (measuredWidth - strokeWith) - 14.0f, strokeWith, f5);
            this.mPath.cubicTo(strokeWith, strokeWith + 14.0f, strokeWith + 14.0f, strokeWith, f5, strokeWith);
            this.mPath.close();
            if (this.ddN == null) {
                this.ddN = new PaintFlagsDrawFilter(0, 3);
            }
            canvas.setDrawFilter(this.ddN);
            if (this.ddJ == null) {
                this.ddJ = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            }
            if (this.ddM == null) {
                this.ddM = new Canvas(this.ddJ);
            }
            super.onDraw(this.ddM);
            this.ddK = j(measuredWidth, measuredHeight, false);
            if (this.ddI) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
                this.wy.mBorderPaint.setStyle(Paint.Style.FILL);
                this.wy.mBorderPaint.setColor(am.getColor(this.hx));
                canvas.drawBitmap(this.ddK, 0.0f, 0.0f, this.wy.mBorderPaint);
                this.wy.mBorderPaint.setXfermode(this.ddP);
                canvas.drawBitmap(this.ddL, 0.0f, 0.0f, this.wy.mBorderPaint);
                this.wy.mBorderPaint.setXfermode(null);
                canvas.restoreToCount(saveLayer);
            }
            int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
            canvas.drawBitmap(this.ddK, 0.0f, 0.0f, this.wy.mPaint);
            this.wy.mPaint.setXfermode(this.ddO);
            canvas.drawBitmap(this.ddJ, 0.0f, 0.0f, this.wy.mPaint);
            this.wy.mPaint.setXfermode(null);
            canvas.restoreToCount(saveLayer2);
            if (this.ddH) {
                a(canvas, measuredWidth, 14.0f);
            }
        }
    }

    public void setStrokeWith(int i) {
        this.ddF = i;
    }

    public int getStrokeWith() {
        return this.ddF;
    }

    private int getStrokeColorResId() {
        return this.hx;
    }

    public void setStrokeColorResId(int i) {
        this.hx = i;
    }

    public void setShowOval(boolean z) {
        this.ddG = z;
    }

    public void setShowInnerBorder(boolean z) {
        this.ddH = z;
    }

    public void setShowOuterBorder(boolean z) {
        this.ddI = z;
    }

    private void a(Canvas canvas, int i, float f) {
        this.ddE.reset();
        float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
        float f2 = i / 2;
        this.ddE.moveTo(f2, strokeWith);
        this.ddE.cubicTo((i - strokeWith) - f, strokeWith, i - strokeWith, strokeWith + f, i - strokeWith, f2);
        this.ddE.cubicTo(i - strokeWith, (i - strokeWith) - f, (i - strokeWith) - f, i - strokeWith, f2, i - strokeWith);
        this.ddE.cubicTo(strokeWith + f, i - strokeWith, strokeWith, (i - strokeWith) - f, strokeWith, f2);
        this.ddE.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f2, strokeWith);
        this.ddE.close();
        float strokeWidth = this.wy.mBorderPaint.getStrokeWidth();
        this.wy.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.wy.mBorderPaint.setStrokeWidth(getStrokeWith() + 0.5f);
        this.wy.mBorderPaint.setColor(am.getColor(getStrokeColorResId()));
        canvas.drawPath(this.ddE, this.wy.mBorderPaint);
        this.wy.mBorderPaint.setStrokeWidth(strokeWidth);
    }
}
