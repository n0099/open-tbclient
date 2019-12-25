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
    private TbImageView.c Nn;
    private Path cZo;
    private int cZp;
    private boolean cZq;
    private boolean cZr;
    private boolean cZs;
    private Bitmap cZt;
    private Bitmap cZu;
    private Bitmap cZv;
    private Canvas cZw;
    private PaintFlagsDrawFilter cZx;
    private PorterDuffXfermode cZy;
    private PorterDuffXfermode cZz;
    private int ht;
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
        this.mDefaultBgId = am.kd(R.drawable.pic_use_header_28_n);
        this.mPath = new Path();
        this.cZo = new Path();
        this.cZp = 0;
        this.ht = 0;
        this.cZq = false;
        this.cZr = false;
        this.cZs = true;
        this.cZy = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.cZz = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.Nn = new TbImageView.c() { // from class: com.baidu.tbadk.core.view.BarImageView.1
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
                    BarImageView.this.wb.mPaint.setColor(am.getColor(R.color.white_alpha100));
                    BarImageView.this.wb.mPaint.setStrokeWidth(com.baidu.adp.lib.util.l.getDimens(BarImageView.this.getContext(), R.dimen.tbds6));
                    BarImageView.this.wb.mPaint.setStyle(Paint.Style.STROKE);
                    BarImageView.this.wb.mPaint.setAntiAlias(true);
                    canvas.drawPath(path, BarImageView.this.wb.mPaint);
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

    private Bitmap i(int i, int i2, boolean z) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawPath(this.mPath, z ? this.wb.mBorderPaint : this.wb.mPaint);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.wb == null || this.wb.mPaint == null) {
            super.onDraw(canvas);
        } else if (!this.cZq) {
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
            this.wb.mBorderPaint.setStyle(Paint.Style.FILL);
            this.wb.mBorderPaint.setColor(am.getColor(this.ht));
            this.cZv = i(measuredWidth, measuredHeight, true);
            this.mPath.reset();
            float strokeWith = getStrokeWith();
            float f5 = measuredWidth / 2;
            this.mPath.moveTo(f5, strokeWith);
            this.mPath.cubicTo((measuredWidth - strokeWith) - 14.0f, strokeWith, measuredWidth - strokeWith, 14.0f + strokeWith, measuredWidth - strokeWith, f5);
            this.mPath.cubicTo(measuredWidth - strokeWith, (measuredWidth - strokeWith) - 14.0f, (measuredWidth - strokeWith) - 14.0f, measuredWidth - strokeWith, f5, measuredWidth - strokeWith);
            this.mPath.cubicTo(strokeWith + 14.0f, measuredWidth - strokeWith, strokeWith, (measuredWidth - strokeWith) - 14.0f, strokeWith, f5);
            this.mPath.cubicTo(strokeWith, strokeWith + 14.0f, strokeWith + 14.0f, strokeWith, f5, strokeWith);
            this.mPath.close();
            if (this.cZx == null) {
                this.cZx = new PaintFlagsDrawFilter(0, 3);
            }
            canvas.setDrawFilter(this.cZx);
            if (this.cZt == null) {
                this.cZt = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            }
            if (this.cZw == null) {
                this.cZw = new Canvas(this.cZt);
            }
            super.onDraw(this.cZw);
            this.cZu = i(measuredWidth, measuredHeight, false);
            if (this.cZs) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
                this.wb.mBorderPaint.setStyle(Paint.Style.FILL);
                this.wb.mBorderPaint.setColor(am.getColor(this.ht));
                canvas.drawBitmap(this.cZu, 0.0f, 0.0f, this.wb.mBorderPaint);
                this.wb.mBorderPaint.setXfermode(this.cZz);
                canvas.drawBitmap(this.cZv, 0.0f, 0.0f, this.wb.mBorderPaint);
                this.wb.mBorderPaint.setXfermode(null);
                canvas.restoreToCount(saveLayer);
            }
            int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
            canvas.drawBitmap(this.cZu, 0.0f, 0.0f, this.wb.mPaint);
            this.wb.mPaint.setXfermode(this.cZy);
            canvas.drawBitmap(this.cZt, 0.0f, 0.0f, this.wb.mPaint);
            this.wb.mPaint.setXfermode(null);
            canvas.restoreToCount(saveLayer2);
            if (this.cZr) {
                a(canvas, measuredWidth, 14.0f);
            }
        }
    }

    public void setStrokeWith(int i) {
        this.cZp = i;
    }

    public int getStrokeWith() {
        return this.cZp;
    }

    private int getStrokeColorResId() {
        return this.ht;
    }

    public void setStrokeColorResId(int i) {
        this.ht = i;
    }

    public void setShowOval(boolean z) {
        this.cZq = z;
    }

    public void setShowInnerBorder(boolean z) {
        this.cZr = z;
    }

    public void setShowOuterBorder(boolean z) {
        this.cZs = z;
    }

    private void a(Canvas canvas, int i, float f) {
        this.cZo.reset();
        float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
        float f2 = i / 2;
        this.cZo.moveTo(f2, strokeWith);
        this.cZo.cubicTo((i - strokeWith) - f, strokeWith, i - strokeWith, strokeWith + f, i - strokeWith, f2);
        this.cZo.cubicTo(i - strokeWith, (i - strokeWith) - f, (i - strokeWith) - f, i - strokeWith, f2, i - strokeWith);
        this.cZo.cubicTo(strokeWith + f, i - strokeWith, strokeWith, (i - strokeWith) - f, strokeWith, f2);
        this.cZo.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f2, strokeWith);
        this.cZo.close();
        float strokeWidth = this.wb.mBorderPaint.getStrokeWidth();
        this.wb.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.wb.mBorderPaint.setStrokeWidth(getStrokeWith() + 0.5f);
        this.wb.mBorderPaint.setColor(am.getColor(getStrokeColorResId()));
        canvas.drawPath(this.cZo, this.wb.mBorderPaint);
        this.wb.mBorderPaint.setStrokeWidth(strokeWidth);
    }
}
