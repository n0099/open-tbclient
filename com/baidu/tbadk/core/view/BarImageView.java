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
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BarImageView extends TbClipImageView {
    private TbImageView.c akr;
    private Path buQ;
    private int buR;
    private boolean buS;
    private boolean buT;
    private boolean buU;
    private Bitmap buV;
    private Bitmap buW;
    private Bitmap buX;
    private Canvas buY;
    private PaintFlagsDrawFilter buZ;
    private PorterDuffXfermode bva;
    private PorterDuffXfermode bvb;
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
        this.mDefaultId = ap.getColor(R.color.cp_bg_line_j);
        this.mDefaultBgId = R.drawable.pic_use_header_28_n;
        this.mPath = new Path();
        this.buQ = new Path();
        this.buR = 0;
        this.strokeColor = 0;
        this.buS = false;
        this.buT = false;
        this.buU = true;
        this.bva = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.bvb = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.akr = new TbImageView.c() { // from class: com.baidu.tbadk.core.view.BarImageView.1
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
                    BarImageView.this.Ry.mPaint.setColor(ap.getColor(R.color.white_alpha100));
                    BarImageView.this.Ry.mPaint.setStrokeWidth(com.baidu.adp.lib.util.l.getDimens(BarImageView.this.getContext(), R.dimen.tbds6));
                    BarImageView.this.Ry.mPaint.setStyle(Paint.Style.STROKE);
                    BarImageView.this.Ry.mPaint.setAntiAlias(true);
                    canvas.drawPath(path, BarImageView.this.Ry.mPaint);
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

    private Bitmap f(int i, int i2, boolean z) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawPath(this.mPath, z ? this.Ry.mBorderPaint : this.Ry.mPaint);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.Ry == null || this.Ry.mPaint == null) {
            super.onDraw(canvas);
        } else if (!this.buS) {
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
            this.Ry.mBorderPaint.setStyle(Paint.Style.FILL);
            this.Ry.mBorderPaint.setColor(ap.getColor(this.strokeColor));
            this.buX = f(measuredWidth, measuredHeight, true);
            this.mPath.reset();
            float strokeWith = getStrokeWith();
            float f6 = measuredWidth / 2;
            this.mPath.moveTo(f6, strokeWith);
            this.mPath.cubicTo((measuredWidth - strokeWith) - f, strokeWith, measuredWidth - strokeWith, strokeWith + f, measuredWidth - strokeWith, f6);
            this.mPath.cubicTo(measuredWidth - strokeWith, (measuredWidth - strokeWith) - f, (measuredWidth - strokeWith) - f, measuredWidth - strokeWith, f6, measuredWidth - strokeWith);
            this.mPath.cubicTo(strokeWith + f, measuredWidth - strokeWith, strokeWith, (measuredWidth - strokeWith) - f, strokeWith, f6);
            this.mPath.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f6, strokeWith);
            this.mPath.close();
            if (this.buZ == null) {
                this.buZ = new PaintFlagsDrawFilter(0, 3);
            }
            canvas.setDrawFilter(this.buZ);
            if (this.buV == null) {
                this.buV = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            }
            if (this.buY == null) {
                this.buY = new Canvas(this.buV);
            }
            super.onDraw(this.buY);
            this.buW = f(measuredWidth, measuredHeight, false);
            if (this.buU) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
                this.Ry.mBorderPaint.setStyle(Paint.Style.FILL);
                this.Ry.mBorderPaint.setColor(ap.getColor(this.strokeColor));
                canvas.drawBitmap(this.buW, 0.0f, 0.0f, this.Ry.mBorderPaint);
                this.Ry.mBorderPaint.setXfermode(this.bvb);
                canvas.drawBitmap(this.buX, 0.0f, 0.0f, this.Ry.mBorderPaint);
                this.Ry.mBorderPaint.setXfermode(null);
                if (saveLayer >= 1 && saveLayer <= canvas.getSaveCount()) {
                    canvas.restoreToCount(saveLayer);
                }
            }
            int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
            canvas.drawBitmap(this.buW, 0.0f, 0.0f, this.Ry.mPaint);
            this.Ry.mPaint.setXfermode(this.bva);
            canvas.drawBitmap(this.buV, 0.0f, 0.0f, this.Ry.mPaint);
            this.Ry.mPaint.setXfermode(null);
            if (saveLayer2 >= 1 && saveLayer2 <= canvas.getSaveCount()) {
                canvas.restoreToCount(saveLayer2);
            }
            if (this.buT) {
                a(canvas, measuredWidth, f);
            }
        }
    }

    public void setStrokeWith(int i) {
        this.buR = i;
    }

    public int getStrokeWith() {
        return this.buR;
    }

    private int getStrokeColorResId() {
        return this.strokeColor;
    }

    public void setStrokeColorResId(int i) {
        this.strokeColor = i;
    }

    public void setShowOval(boolean z) {
        this.buS = z;
    }

    public void setShowInnerBorder(boolean z) {
        this.buT = z;
    }

    public void setShowOuterBorder(boolean z) {
        this.buU = z;
    }

    private void a(Canvas canvas, int i, float f) {
        this.buQ.reset();
        float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
        float f2 = i / 2;
        this.buQ.moveTo(f2, strokeWith);
        this.buQ.cubicTo((i - strokeWith) - f, strokeWith, i - strokeWith, strokeWith + f, i - strokeWith, f2);
        this.buQ.cubicTo(i - strokeWith, (i - strokeWith) - f, (i - strokeWith) - f, i - strokeWith, f2, i - strokeWith);
        this.buQ.cubicTo(strokeWith + f, i - strokeWith, strokeWith, (i - strokeWith) - f, strokeWith, f2);
        this.buQ.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f2, strokeWith);
        this.buQ.close();
        float strokeWidth = this.Ry.mBorderPaint.getStrokeWidth();
        this.Ry.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.Ry.mBorderPaint.setStrokeWidth(getStrokeWith() + 0.5f);
        this.Ry.mBorderPaint.setColor(ap.getColor(getStrokeColorResId()));
        canvas.drawPath(this.buQ, this.Ry.mBorderPaint);
        this.Ry.mBorderPaint.setStrokeWidth(strokeWidth);
    }
}
