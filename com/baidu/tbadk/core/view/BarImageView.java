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
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BarImageView extends TbClipImageView {
    private int bLA;
    private boolean bLB;
    private boolean bLC;
    private boolean bLD;
    private Bitmap bLE;
    private Bitmap bLF;
    private Bitmap bLG;
    private Canvas bLH;
    private PaintFlagsDrawFilter bLI;
    private PorterDuffXfermode bLJ;
    private PorterDuffXfermode bLK;
    private Path bLz;
    private int mDefaultBgId;
    private int mDefaultId;
    private Path mPath;
    private int strokeColor;

    public BarImageView(Context context) {
        this(context, null, 0);
    }

    public BarImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BarImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDefaultId = ao.getColor(R.color.CAM_X0209);
        this.mDefaultBgId = R.drawable.pic_use_header_28_n;
        this.mPath = new Path();
        this.bLz = new Path();
        this.bLA = 0;
        this.strokeColor = 0;
        this.bLB = false;
        this.bLC = false;
        this.bLD = true;
        this.bLJ = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.bLK = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        init();
    }

    private void init() {
        setDrawerType(0);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultResource(this.mDefaultId);
        setDefaultBgResource(this.mDefaultBgId);
    }

    private Bitmap f(int i, int i2, boolean z) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawPath(this.mPath, z ? this.Sx.mBorderPaint : this.Sx.mPaint);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.Sx == null || this.Sx.mPaint == null) {
            super.onDraw(canvas);
        } else if (!this.bLB) {
            super.onDraw(canvas);
        } else {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f = (measuredWidth * 14) / IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER;
            this.mPath.reset();
            float f2 = measuredWidth;
            float f3 = (0.0f + f2) / 2.0f;
            float f4 = measuredHeight;
            float f5 = (0.0f + f4) / 2.0f;
            this.mPath.moveTo(f3, 0.0f);
            this.mPath.cubicTo(measuredWidth - f, 0.0f, measuredWidth, f, f2, f5);
            this.mPath.cubicTo(measuredWidth, measuredWidth - f, measuredWidth - f, measuredWidth, f3, f4);
            this.mPath.cubicTo(f, measuredWidth, 0.0f, measuredWidth - f, 0.0f, f5);
            this.mPath.cubicTo(0.0f, f, f, 0.0f, f3, 0.0f);
            this.mPath.close();
            this.Sx.mBorderPaint.setStyle(Paint.Style.FILL);
            this.Sx.mBorderPaint.setColor(ao.getColor(this.strokeColor));
            this.bLG = f(measuredWidth, measuredHeight, true);
            this.mPath.reset();
            float strokeWith = getStrokeWith();
            float f6 = measuredWidth / 2;
            this.mPath.moveTo(f6, strokeWith);
            this.mPath.cubicTo((measuredWidth - strokeWith) - f, strokeWith, measuredWidth - strokeWith, strokeWith + f, measuredWidth - strokeWith, f6);
            this.mPath.cubicTo(measuredWidth - strokeWith, (measuredWidth - strokeWith) - f, (measuredWidth - strokeWith) - f, measuredWidth - strokeWith, f6, measuredWidth - strokeWith);
            this.mPath.cubicTo(strokeWith + f, measuredWidth - strokeWith, strokeWith, (measuredWidth - strokeWith) - f, strokeWith, f6);
            this.mPath.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f6, strokeWith);
            this.mPath.close();
            if (this.bLI == null) {
                this.bLI = new PaintFlagsDrawFilter(0, 3);
            }
            canvas.setDrawFilter(this.bLI);
            if (this.bLE == null) {
                this.bLE = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            }
            if (this.bLH == null) {
                this.bLH = new Canvas(this.bLE);
            }
            super.onDraw(this.bLH);
            this.bLF = f(measuredWidth, measuredHeight, false);
            if (this.bLD) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
                this.Sx.mBorderPaint.setStyle(Paint.Style.FILL);
                this.Sx.mBorderPaint.setColor(ao.getColor(this.strokeColor));
                canvas.drawBitmap(this.bLF, 0.0f, 0.0f, this.Sx.mBorderPaint);
                this.Sx.mBorderPaint.setXfermode(this.bLK);
                canvas.drawBitmap(this.bLG, 0.0f, 0.0f, this.Sx.mBorderPaint);
                this.Sx.mBorderPaint.setXfermode(null);
                if (saveLayer >= 1 && saveLayer <= canvas.getSaveCount()) {
                    canvas.restoreToCount(saveLayer);
                }
            }
            int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
            canvas.drawBitmap(this.bLF, 0.0f, 0.0f, this.Sx.mPaint);
            this.Sx.mPaint.setXfermode(this.bLJ);
            canvas.drawBitmap(this.bLE, 0.0f, 0.0f, this.Sx.mPaint);
            this.Sx.mPaint.setXfermode(null);
            if (saveLayer2 >= 1 && saveLayer2 <= canvas.getSaveCount()) {
                canvas.restoreToCount(saveLayer2);
            }
            if (this.bLC) {
                a(canvas, measuredWidth, f);
            }
        }
    }

    public void setStrokeWith(int i) {
        this.bLA = i;
    }

    public int getStrokeWith() {
        return this.bLA;
    }

    private int getStrokeColorResId() {
        return this.strokeColor;
    }

    public void setStrokeColorResId(int i) {
        this.strokeColor = i;
    }

    public void setShowOval(boolean z) {
        this.bLB = z;
    }

    public void setShowInnerBorder(boolean z) {
        this.bLC = z;
    }

    public void setShowOuterBorder(boolean z) {
        this.bLD = z;
    }

    private void a(Canvas canvas, int i, float f) {
        this.bLz.reset();
        float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
        float f2 = i / 2;
        this.bLz.moveTo(f2, strokeWith);
        this.bLz.cubicTo((i - strokeWith) - f, strokeWith, i - strokeWith, strokeWith + f, i - strokeWith, f2);
        this.bLz.cubicTo(i - strokeWith, (i - strokeWith) - f, (i - strokeWith) - f, i - strokeWith, f2, i - strokeWith);
        this.bLz.cubicTo(strokeWith + f, i - strokeWith, strokeWith, (i - strokeWith) - f, strokeWith, f2);
        this.bLz.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f2, strokeWith);
        this.bLz.close();
        float strokeWidth = this.Sx.mBorderPaint.getStrokeWidth();
        this.Sx.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.Sx.mBorderPaint.setStrokeWidth(getStrokeWith() + 0.5f);
        this.Sx.mBorderPaint.setColor(ao.getColor(getStrokeColorResId()));
        canvas.drawPath(this.bLz, this.Sx.mBorderPaint);
        this.Sx.mBorderPaint.setStrokeWidth(strokeWidth);
    }
}
