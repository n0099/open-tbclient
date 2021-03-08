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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BarImageView extends TbClipImageView {
    private Path bLX;
    private int bLY;
    private boolean bLZ;
    private boolean bMa;
    private boolean bMb;
    private Bitmap bMc;
    private Bitmap bMd;
    private Bitmap bMe;
    private Canvas bMf;
    private PaintFlagsDrawFilter bMg;
    private PorterDuffXfermode bMh;
    private PorterDuffXfermode bMi;
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
        this.mDefaultId = ap.getColor(R.color.CAM_X0209);
        this.mDefaultBgId = R.drawable.pic_use_header_28_n;
        this.mPath = new Path();
        this.bLX = new Path();
        this.bLY = 0;
        this.strokeColor = 0;
        this.bLZ = false;
        this.bMa = false;
        this.bMb = true;
        this.bMh = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.bMi = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
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
        new Canvas(createBitmap).drawPath(this.mPath, z ? this.TR.mBorderPaint : this.TR.mPaint);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.TR == null || this.TR.mPaint == null) {
            super.onDraw(canvas);
        } else if (!this.bLZ) {
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
            this.TR.mBorderPaint.setStyle(Paint.Style.FILL);
            this.TR.mBorderPaint.setColor(ap.getColor(this.strokeColor));
            this.bMe = f(measuredWidth, measuredHeight, true);
            this.mPath.reset();
            float strokeWith = getStrokeWith();
            float f6 = measuredWidth / 2;
            this.mPath.moveTo(f6, strokeWith);
            this.mPath.cubicTo((measuredWidth - strokeWith) - f, strokeWith, measuredWidth - strokeWith, strokeWith + f, measuredWidth - strokeWith, f6);
            this.mPath.cubicTo(measuredWidth - strokeWith, (measuredWidth - strokeWith) - f, (measuredWidth - strokeWith) - f, measuredWidth - strokeWith, f6, measuredWidth - strokeWith);
            this.mPath.cubicTo(strokeWith + f, measuredWidth - strokeWith, strokeWith, (measuredWidth - strokeWith) - f, strokeWith, f6);
            this.mPath.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f6, strokeWith);
            this.mPath.close();
            if (this.bMg == null) {
                this.bMg = new PaintFlagsDrawFilter(0, 3);
            }
            canvas.setDrawFilter(this.bMg);
            if (this.bMc == null) {
                this.bMc = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            }
            if (this.bMf == null) {
                this.bMf = new Canvas(this.bMc);
            }
            this.TR.mBorderPaint.setStyle(Paint.Style.STROKE);
            super.onDraw(this.bMf);
            this.bMd = f(measuredWidth, measuredHeight, false);
            if (this.bMb) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
                this.TR.mBorderPaint.setStyle(Paint.Style.FILL);
                this.TR.mBorderPaint.setColor(ap.getColor(this.strokeColor));
                canvas.drawBitmap(this.bMd, 0.0f, 0.0f, this.TR.mBorderPaint);
                this.TR.mBorderPaint.setXfermode(this.bMi);
                canvas.drawBitmap(this.bMe, 0.0f, 0.0f, this.TR.mBorderPaint);
                this.TR.mBorderPaint.setXfermode(null);
                if (saveLayer >= 1 && saveLayer <= canvas.getSaveCount()) {
                    canvas.restoreToCount(saveLayer);
                }
            }
            int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
            canvas.drawBitmap(this.bMd, 0.0f, 0.0f, this.TR.mPaint);
            this.TR.mPaint.setXfermode(this.bMh);
            canvas.drawBitmap(this.bMc, 0.0f, 0.0f, this.TR.mPaint);
            this.TR.mPaint.setXfermode(null);
            if (saveLayer2 >= 1 && saveLayer2 <= canvas.getSaveCount()) {
                canvas.restoreToCount(saveLayer2);
            }
            if (this.bMa) {
                a(canvas, measuredWidth, f);
            }
        }
    }

    public void setStrokeWith(int i) {
        this.bLY = i;
    }

    public int getStrokeWith() {
        return this.bLY;
    }

    private int getStrokeColorResId() {
        return this.strokeColor;
    }

    public void setStrokeColorResId(int i) {
        this.strokeColor = i;
    }

    public void setShowOval(boolean z) {
        this.bLZ = z;
    }

    public void setShowInnerBorder(boolean z) {
        this.bMa = z;
    }

    public void setShowOuterBorder(boolean z) {
        this.bMb = z;
    }

    private void a(Canvas canvas, int i, float f) {
        this.bLX.reset();
        float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
        float f2 = i / 2;
        this.bLX.moveTo(f2, strokeWith);
        this.bLX.cubicTo((i - strokeWith) - f, strokeWith, i - strokeWith, strokeWith + f, i - strokeWith, f2);
        this.bLX.cubicTo(i - strokeWith, (i - strokeWith) - f, (i - strokeWith) - f, i - strokeWith, f2, i - strokeWith);
        this.bLX.cubicTo(strokeWith + f, i - strokeWith, strokeWith, (i - strokeWith) - f, strokeWith, f2);
        this.bLX.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f2, strokeWith);
        this.bLX.close();
        float strokeWidth = this.TR.mBorderPaint.getStrokeWidth();
        this.TR.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.TR.mBorderPaint.setStrokeWidth(getStrokeWith() + 0.5f);
        this.TR.mBorderPaint.setColor(ap.getColor(getStrokeColorResId()));
        canvas.drawPath(this.bLX, this.TR.mBorderPaint);
        this.TR.mBorderPaint.setStrokeWidth(strokeWidth);
    }
}
