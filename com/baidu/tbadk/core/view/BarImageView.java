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
    private TbImageView.c Nr;
    private boolean cZA;
    private boolean cZB;
    private boolean cZC;
    private Bitmap cZD;
    private Bitmap cZE;
    private Bitmap cZF;
    private Canvas cZG;
    private PaintFlagsDrawFilter cZH;
    private PorterDuffXfermode cZI;
    private PorterDuffXfermode cZJ;
    private Path cZy;
    private int cZz;
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
        this.cZy = new Path();
        this.cZz = 0;
        this.ht = 0;
        this.cZA = false;
        this.cZB = false;
        this.cZC = true;
        this.cZI = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.cZJ = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.Nr = new TbImageView.c() { // from class: com.baidu.tbadk.core.view.BarImageView.1
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
                    BarImageView.this.wf.mPaint.setColor(am.getColor(R.color.white_alpha100));
                    BarImageView.this.wf.mPaint.setStrokeWidth(com.baidu.adp.lib.util.l.getDimens(BarImageView.this.getContext(), R.dimen.tbds6));
                    BarImageView.this.wf.mPaint.setStyle(Paint.Style.STROKE);
                    BarImageView.this.wf.mPaint.setAntiAlias(true);
                    canvas.drawPath(path, BarImageView.this.wf.mPaint);
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
        new Canvas(createBitmap).drawPath(this.mPath, z ? this.wf.mBorderPaint : this.wf.mPaint);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.wf == null || this.wf.mPaint == null) {
            super.onDraw(canvas);
        } else if (!this.cZA) {
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
            this.wf.mBorderPaint.setStyle(Paint.Style.FILL);
            this.wf.mBorderPaint.setColor(am.getColor(this.ht));
            this.cZF = i(measuredWidth, measuredHeight, true);
            this.mPath.reset();
            float strokeWith = getStrokeWith();
            float f5 = measuredWidth / 2;
            this.mPath.moveTo(f5, strokeWith);
            this.mPath.cubicTo((measuredWidth - strokeWith) - 14.0f, strokeWith, measuredWidth - strokeWith, 14.0f + strokeWith, measuredWidth - strokeWith, f5);
            this.mPath.cubicTo(measuredWidth - strokeWith, (measuredWidth - strokeWith) - 14.0f, (measuredWidth - strokeWith) - 14.0f, measuredWidth - strokeWith, f5, measuredWidth - strokeWith);
            this.mPath.cubicTo(strokeWith + 14.0f, measuredWidth - strokeWith, strokeWith, (measuredWidth - strokeWith) - 14.0f, strokeWith, f5);
            this.mPath.cubicTo(strokeWith, strokeWith + 14.0f, strokeWith + 14.0f, strokeWith, f5, strokeWith);
            this.mPath.close();
            if (this.cZH == null) {
                this.cZH = new PaintFlagsDrawFilter(0, 3);
            }
            canvas.setDrawFilter(this.cZH);
            if (this.cZD == null) {
                this.cZD = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            }
            if (this.cZG == null) {
                this.cZG = new Canvas(this.cZD);
            }
            super.onDraw(this.cZG);
            this.cZE = i(measuredWidth, measuredHeight, false);
            if (this.cZC) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
                this.wf.mBorderPaint.setStyle(Paint.Style.FILL);
                this.wf.mBorderPaint.setColor(am.getColor(this.ht));
                canvas.drawBitmap(this.cZE, 0.0f, 0.0f, this.wf.mBorderPaint);
                this.wf.mBorderPaint.setXfermode(this.cZJ);
                canvas.drawBitmap(this.cZF, 0.0f, 0.0f, this.wf.mBorderPaint);
                this.wf.mBorderPaint.setXfermode(null);
                canvas.restoreToCount(saveLayer);
            }
            int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
            canvas.drawBitmap(this.cZE, 0.0f, 0.0f, this.wf.mPaint);
            this.wf.mPaint.setXfermode(this.cZI);
            canvas.drawBitmap(this.cZD, 0.0f, 0.0f, this.wf.mPaint);
            this.wf.mPaint.setXfermode(null);
            canvas.restoreToCount(saveLayer2);
            if (this.cZB) {
                a(canvas, measuredWidth, 14.0f);
            }
        }
    }

    public void setStrokeWith(int i) {
        this.cZz = i;
    }

    public int getStrokeWith() {
        return this.cZz;
    }

    private int getStrokeColorResId() {
        return this.ht;
    }

    public void setStrokeColorResId(int i) {
        this.ht = i;
    }

    public void setShowOval(boolean z) {
        this.cZA = z;
    }

    public void setShowInnerBorder(boolean z) {
        this.cZB = z;
    }

    public void setShowOuterBorder(boolean z) {
        this.cZC = z;
    }

    private void a(Canvas canvas, int i, float f) {
        this.cZy.reset();
        float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
        float f2 = i / 2;
        this.cZy.moveTo(f2, strokeWith);
        this.cZy.cubicTo((i - strokeWith) - f, strokeWith, i - strokeWith, strokeWith + f, i - strokeWith, f2);
        this.cZy.cubicTo(i - strokeWith, (i - strokeWith) - f, (i - strokeWith) - f, i - strokeWith, f2, i - strokeWith);
        this.cZy.cubicTo(strokeWith + f, i - strokeWith, strokeWith, (i - strokeWith) - f, strokeWith, f2);
        this.cZy.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f2, strokeWith);
        this.cZy.close();
        float strokeWidth = this.wf.mBorderPaint.getStrokeWidth();
        this.wf.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.wf.mBorderPaint.setStrokeWidth(getStrokeWith() + 0.5f);
        this.wf.mBorderPaint.setColor(am.getColor(getStrokeColorResId()));
        canvas.drawPath(this.cZy, this.wf.mBorderPaint);
        this.wf.mBorderPaint.setStrokeWidth(strokeWidth);
    }
}
