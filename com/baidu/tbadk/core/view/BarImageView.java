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
    private TbImageView.c NU;
    private Path dee;
    private int def;
    private boolean deg;
    private boolean deh;
    private boolean dei;
    private Bitmap dej;
    private Bitmap dek;
    private Bitmap del;
    private Canvas dem;
    private PaintFlagsDrawFilter den;
    private PorterDuffXfermode deo;
    private PorterDuffXfermode dep;
    private int hw;
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
        this.dee = new Path();
        this.def = 0;
        this.hw = 0;
        this.deg = false;
        this.deh = false;
        this.dei = true;
        this.deo = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.dep = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.NU = new TbImageView.c() { // from class: com.baidu.tbadk.core.view.BarImageView.1
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
        } else if (!this.deg) {
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
            this.wy.mBorderPaint.setColor(am.getColor(this.hw));
            this.del = j(measuredWidth, measuredHeight, true);
            this.mPath.reset();
            float strokeWith = getStrokeWith();
            float f5 = measuredWidth / 2;
            this.mPath.moveTo(f5, strokeWith);
            this.mPath.cubicTo((measuredWidth - strokeWith) - 14.0f, strokeWith, measuredWidth - strokeWith, 14.0f + strokeWith, measuredWidth - strokeWith, f5);
            this.mPath.cubicTo(measuredWidth - strokeWith, (measuredWidth - strokeWith) - 14.0f, (measuredWidth - strokeWith) - 14.0f, measuredWidth - strokeWith, f5, measuredWidth - strokeWith);
            this.mPath.cubicTo(strokeWith + 14.0f, measuredWidth - strokeWith, strokeWith, (measuredWidth - strokeWith) - 14.0f, strokeWith, f5);
            this.mPath.cubicTo(strokeWith, strokeWith + 14.0f, strokeWith + 14.0f, strokeWith, f5, strokeWith);
            this.mPath.close();
            if (this.den == null) {
                this.den = new PaintFlagsDrawFilter(0, 3);
            }
            canvas.setDrawFilter(this.den);
            if (this.dej == null) {
                this.dej = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            }
            if (this.dem == null) {
                this.dem = new Canvas(this.dej);
            }
            super.onDraw(this.dem);
            this.dek = j(measuredWidth, measuredHeight, false);
            if (this.dei) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
                this.wy.mBorderPaint.setStyle(Paint.Style.FILL);
                this.wy.mBorderPaint.setColor(am.getColor(this.hw));
                canvas.drawBitmap(this.dek, 0.0f, 0.0f, this.wy.mBorderPaint);
                this.wy.mBorderPaint.setXfermode(this.dep);
                canvas.drawBitmap(this.del, 0.0f, 0.0f, this.wy.mBorderPaint);
                this.wy.mBorderPaint.setXfermode(null);
                canvas.restoreToCount(saveLayer);
            }
            int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
            canvas.drawBitmap(this.dek, 0.0f, 0.0f, this.wy.mPaint);
            this.wy.mPaint.setXfermode(this.deo);
            canvas.drawBitmap(this.dej, 0.0f, 0.0f, this.wy.mPaint);
            this.wy.mPaint.setXfermode(null);
            canvas.restoreToCount(saveLayer2);
            if (this.deh) {
                a(canvas, measuredWidth, 14.0f);
            }
        }
    }

    public void setStrokeWith(int i) {
        this.def = i;
    }

    public int getStrokeWith() {
        return this.def;
    }

    private int getStrokeColorResId() {
        return this.hw;
    }

    public void setStrokeColorResId(int i) {
        this.hw = i;
    }

    public void setShowOval(boolean z) {
        this.deg = z;
    }

    public void setShowInnerBorder(boolean z) {
        this.deh = z;
    }

    public void setShowOuterBorder(boolean z) {
        this.dei = z;
    }

    private void a(Canvas canvas, int i, float f) {
        this.dee.reset();
        float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
        float f2 = i / 2;
        this.dee.moveTo(f2, strokeWith);
        this.dee.cubicTo((i - strokeWith) - f, strokeWith, i - strokeWith, strokeWith + f, i - strokeWith, f2);
        this.dee.cubicTo(i - strokeWith, (i - strokeWith) - f, (i - strokeWith) - f, i - strokeWith, f2, i - strokeWith);
        this.dee.cubicTo(strokeWith + f, i - strokeWith, strokeWith, (i - strokeWith) - f, strokeWith, f2);
        this.dee.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f2, strokeWith);
        this.dee.close();
        float strokeWidth = this.wy.mBorderPaint.getStrokeWidth();
        this.wy.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.wy.mBorderPaint.setStrokeWidth(getStrokeWith() + 0.5f);
        this.wy.mBorderPaint.setColor(am.getColor(getStrokeColorResId()));
        canvas.drawPath(this.dee, this.wy.mBorderPaint);
        this.wy.mBorderPaint.setStrokeWidth(strokeWidth);
    }
}
