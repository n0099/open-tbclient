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
    private Path bGN;
    private int bGO;
    private boolean bGP;
    private boolean bGQ;
    private boolean bGR;
    private Bitmap bGS;
    private Bitmap bGT;
    private Bitmap bGU;
    private Canvas bGV;
    private PaintFlagsDrawFilter bGW;
    private PorterDuffXfermode bGX;
    private PorterDuffXfermode bGY;
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
        this.bGN = new Path();
        this.bGO = 0;
        this.strokeColor = 0;
        this.bGP = false;
        this.bGQ = false;
        this.bGR = true;
        this.bGX = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.bGY = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
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
        new Canvas(createBitmap).drawPath(this.mPath, z ? this.Sv.mBorderPaint : this.Sv.mPaint);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.Sv == null || this.Sv.mPaint == null) {
            super.onDraw(canvas);
        } else if (!this.bGP) {
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
            this.Sv.mBorderPaint.setStyle(Paint.Style.FILL);
            this.Sv.mBorderPaint.setColor(ao.getColor(this.strokeColor));
            this.bGU = f(measuredWidth, measuredHeight, true);
            this.mPath.reset();
            float strokeWith = getStrokeWith();
            float f6 = measuredWidth / 2;
            this.mPath.moveTo(f6, strokeWith);
            this.mPath.cubicTo((measuredWidth - strokeWith) - f, strokeWith, measuredWidth - strokeWith, strokeWith + f, measuredWidth - strokeWith, f6);
            this.mPath.cubicTo(measuredWidth - strokeWith, (measuredWidth - strokeWith) - f, (measuredWidth - strokeWith) - f, measuredWidth - strokeWith, f6, measuredWidth - strokeWith);
            this.mPath.cubicTo(strokeWith + f, measuredWidth - strokeWith, strokeWith, (measuredWidth - strokeWith) - f, strokeWith, f6);
            this.mPath.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f6, strokeWith);
            this.mPath.close();
            if (this.bGW == null) {
                this.bGW = new PaintFlagsDrawFilter(0, 3);
            }
            canvas.setDrawFilter(this.bGW);
            if (this.bGS == null) {
                this.bGS = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            }
            if (this.bGV == null) {
                this.bGV = new Canvas(this.bGS);
            }
            super.onDraw(this.bGV);
            this.bGT = f(measuredWidth, measuredHeight, false);
            if (this.bGR) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
                this.Sv.mBorderPaint.setStyle(Paint.Style.FILL);
                this.Sv.mBorderPaint.setColor(ao.getColor(this.strokeColor));
                canvas.drawBitmap(this.bGT, 0.0f, 0.0f, this.Sv.mBorderPaint);
                this.Sv.mBorderPaint.setXfermode(this.bGY);
                canvas.drawBitmap(this.bGU, 0.0f, 0.0f, this.Sv.mBorderPaint);
                this.Sv.mBorderPaint.setXfermode(null);
                if (saveLayer >= 1 && saveLayer <= canvas.getSaveCount()) {
                    canvas.restoreToCount(saveLayer);
                }
            }
            int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
            canvas.drawBitmap(this.bGT, 0.0f, 0.0f, this.Sv.mPaint);
            this.Sv.mPaint.setXfermode(this.bGX);
            canvas.drawBitmap(this.bGS, 0.0f, 0.0f, this.Sv.mPaint);
            this.Sv.mPaint.setXfermode(null);
            if (saveLayer2 >= 1 && saveLayer2 <= canvas.getSaveCount()) {
                canvas.restoreToCount(saveLayer2);
            }
            if (this.bGQ) {
                a(canvas, measuredWidth, f);
            }
        }
    }

    public void setStrokeWith(int i) {
        this.bGO = i;
    }

    public int getStrokeWith() {
        return this.bGO;
    }

    private int getStrokeColorResId() {
        return this.strokeColor;
    }

    public void setStrokeColorResId(int i) {
        this.strokeColor = i;
    }

    public void setShowOval(boolean z) {
        this.bGP = z;
    }

    public void setShowInnerBorder(boolean z) {
        this.bGQ = z;
    }

    public void setShowOuterBorder(boolean z) {
        this.bGR = z;
    }

    private void a(Canvas canvas, int i, float f) {
        this.bGN.reset();
        float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
        float f2 = i / 2;
        this.bGN.moveTo(f2, strokeWith);
        this.bGN.cubicTo((i - strokeWith) - f, strokeWith, i - strokeWith, strokeWith + f, i - strokeWith, f2);
        this.bGN.cubicTo(i - strokeWith, (i - strokeWith) - f, (i - strokeWith) - f, i - strokeWith, f2, i - strokeWith);
        this.bGN.cubicTo(strokeWith + f, i - strokeWith, strokeWith, (i - strokeWith) - f, strokeWith, f2);
        this.bGN.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f2, strokeWith);
        this.bGN.close();
        float strokeWidth = this.Sv.mBorderPaint.getStrokeWidth();
        this.Sv.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.Sv.mBorderPaint.setStrokeWidth(getStrokeWith() + 0.5f);
        this.Sv.mBorderPaint.setColor(ao.getColor(getStrokeColorResId()));
        canvas.drawPath(this.bGN, this.Sv.mBorderPaint);
        this.Sv.mBorderPaint.setStrokeWidth(strokeWidth);
    }
}
