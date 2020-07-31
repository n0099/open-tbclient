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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BarImageView extends TbClipImageView {
    private float accuracy;
    private TbImageView.c aik;
    private Path eeY;
    private int eeZ;
    private boolean efa;
    private boolean efb;
    private boolean efc;
    private Bitmap efd;
    private Bitmap efe;
    private Bitmap eff;
    private Canvas efg;
    private PaintFlagsDrawFilter efh;
    private PorterDuffXfermode efi;
    private PorterDuffXfermode efj;
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
        this.mDefaultId = ao.getColor(R.color.cp_bg_line_j);
        this.mDefaultBgId = R.drawable.pic_use_header_28_n;
        this.mPath = new Path();
        this.eeY = new Path();
        this.eeZ = 0;
        this.strokeColor = 0;
        this.accuracy = 14.0f;
        this.efa = false;
        this.efb = false;
        this.efc = true;
        this.efi = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.efj = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.aik = new TbImageView.c() { // from class: com.baidu.tbadk.core.view.BarImageView.1
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
                    BarImageView.this.Ql.mPaint.setColor(ao.getColor(R.color.white_alpha100));
                    BarImageView.this.Ql.mPaint.setStrokeWidth(com.baidu.adp.lib.util.l.getDimens(BarImageView.this.getContext(), R.dimen.tbds6));
                    BarImageView.this.Ql.mPaint.setStyle(Paint.Style.STROKE);
                    BarImageView.this.Ql.mPaint.setAntiAlias(true);
                    canvas.drawPath(path, BarImageView.this.Ql.mPaint);
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
        new Canvas(createBitmap).drawPath(this.mPath, z ? this.Ql.mBorderPaint : this.Ql.mPaint);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.Ql == null || this.Ql.mPaint == null) {
            super.onDraw(canvas);
        } else if (!this.efa) {
            super.onDraw(canvas);
        } else {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float accuracy = getAccuracy();
            this.mPath.reset();
            float f = measuredWidth;
            float f2 = (0.0f + f) / 2.0f;
            float f3 = measuredHeight;
            float f4 = (0.0f + f3) / 2.0f;
            this.mPath.moveTo(f2, 0.0f);
            this.mPath.cubicTo(measuredWidth - accuracy, 0.0f, measuredWidth, accuracy, f, f4);
            this.mPath.cubicTo(measuredWidth, measuredWidth - accuracy, measuredWidth - accuracy, measuredWidth, f2, f3);
            this.mPath.cubicTo(accuracy, measuredWidth, 0.0f, measuredWidth - accuracy, 0.0f, f4);
            this.mPath.cubicTo(0.0f, accuracy, accuracy, 0.0f, f2, 0.0f);
            this.mPath.close();
            this.Ql.mBorderPaint.setStyle(Paint.Style.FILL);
            this.Ql.mBorderPaint.setColor(ao.getColor(this.strokeColor));
            this.eff = j(measuredWidth, measuredHeight, true);
            this.mPath.reset();
            float strokeWith = getStrokeWith();
            float f5 = measuredWidth / 2;
            this.mPath.moveTo(f5, strokeWith);
            this.mPath.cubicTo((measuredWidth - strokeWith) - accuracy, strokeWith, measuredWidth - strokeWith, strokeWith + accuracy, measuredWidth - strokeWith, f5);
            this.mPath.cubicTo(measuredWidth - strokeWith, (measuredWidth - strokeWith) - accuracy, (measuredWidth - strokeWith) - accuracy, measuredWidth - strokeWith, f5, measuredWidth - strokeWith);
            this.mPath.cubicTo(strokeWith + accuracy, measuredWidth - strokeWith, strokeWith, (measuredWidth - strokeWith) - accuracy, strokeWith, f5);
            this.mPath.cubicTo(strokeWith, strokeWith + accuracy, strokeWith + accuracy, strokeWith, f5, strokeWith);
            this.mPath.close();
            if (this.efh == null) {
                this.efh = new PaintFlagsDrawFilter(0, 3);
            }
            canvas.setDrawFilter(this.efh);
            if (this.efd == null) {
                this.efd = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            }
            if (this.efg == null) {
                this.efg = new Canvas(this.efd);
            }
            super.onDraw(this.efg);
            this.efe = j(measuredWidth, measuredHeight, false);
            if (this.efc) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
                this.Ql.mBorderPaint.setStyle(Paint.Style.FILL);
                this.Ql.mBorderPaint.setColor(ao.getColor(this.strokeColor));
                canvas.drawBitmap(this.efe, 0.0f, 0.0f, this.Ql.mBorderPaint);
                this.Ql.mBorderPaint.setXfermode(this.efj);
                canvas.drawBitmap(this.eff, 0.0f, 0.0f, this.Ql.mBorderPaint);
                this.Ql.mBorderPaint.setXfermode(null);
                if (saveLayer >= 1 && saveLayer <= canvas.getSaveCount()) {
                    canvas.restoreToCount(saveLayer);
                }
            }
            int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
            canvas.drawBitmap(this.efe, 0.0f, 0.0f, this.Ql.mPaint);
            this.Ql.mPaint.setXfermode(this.efi);
            canvas.drawBitmap(this.efd, 0.0f, 0.0f, this.Ql.mPaint);
            this.Ql.mPaint.setXfermode(null);
            if (saveLayer2 >= 1 && saveLayer2 <= canvas.getSaveCount()) {
                canvas.restoreToCount(saveLayer2);
            }
            if (this.efb) {
                a(canvas, measuredWidth, accuracy);
            }
        }
    }

    public void setStrokeWith(int i) {
        this.eeZ = i;
    }

    public int getStrokeWith() {
        return this.eeZ;
    }

    private int getStrokeColorResId() {
        return this.strokeColor;
    }

    public void setStrokeColorResId(int i) {
        this.strokeColor = i;
    }

    public void setShowOval(boolean z) {
        this.efa = z;
    }

    public void setShowInnerBorder(boolean z) {
        this.efb = z;
    }

    public void setShowOuterBorder(boolean z) {
        this.efc = z;
    }

    private void a(Canvas canvas, int i, float f) {
        this.eeY.reset();
        float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
        float f2 = i / 2;
        this.eeY.moveTo(f2, strokeWith);
        this.eeY.cubicTo((i - strokeWith) - f, strokeWith, i - strokeWith, strokeWith + f, i - strokeWith, f2);
        this.eeY.cubicTo(i - strokeWith, (i - strokeWith) - f, (i - strokeWith) - f, i - strokeWith, f2, i - strokeWith);
        this.eeY.cubicTo(strokeWith + f, i - strokeWith, strokeWith, (i - strokeWith) - f, strokeWith, f2);
        this.eeY.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f2, strokeWith);
        this.eeY.close();
        float strokeWidth = this.Ql.mBorderPaint.getStrokeWidth();
        this.Ql.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.Ql.mBorderPaint.setStrokeWidth(getStrokeWith() + 0.5f);
        this.Ql.mBorderPaint.setColor(ao.getColor(getStrokeColorResId()));
        canvas.drawPath(this.eeY, this.Ql.mBorderPaint);
        this.Ql.mBorderPaint.setStrokeWidth(strokeWidth);
    }

    public void setAccuracyWith(float f) {
        this.accuracy = f;
    }

    public float getAccuracy() {
        return this.accuracy;
    }
}
