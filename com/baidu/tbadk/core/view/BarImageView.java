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
    private int Dc;
    private TbImageView.c agE;
    private Path dDH;
    private int dDI;
    private boolean dDJ;
    private boolean dDK;
    private boolean dDL;
    private Bitmap dDM;
    private Bitmap dDN;
    private Bitmap dDO;
    private Canvas dDP;
    private PaintFlagsDrawFilter dDQ;
    private PorterDuffXfermode dDR;
    private PorterDuffXfermode dDS;
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
        this.mDefaultBgId = R.drawable.pic_use_header_28_n;
        this.mPath = new Path();
        this.dDH = new Path();
        this.dDI = 0;
        this.Dc = 0;
        this.dDJ = false;
        this.dDK = false;
        this.dDL = true;
        this.dDR = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.dDS = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.agE = new TbImageView.c() { // from class: com.baidu.tbadk.core.view.BarImageView.1
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
                    BarImageView.this.Px.mPaint.setColor(am.getColor(R.color.white_alpha100));
                    BarImageView.this.Px.mPaint.setStrokeWidth(com.baidu.adp.lib.util.l.getDimens(BarImageView.this.getContext(), R.dimen.tbds6));
                    BarImageView.this.Px.mPaint.setStyle(Paint.Style.STROKE);
                    BarImageView.this.Px.mPaint.setAntiAlias(true);
                    canvas.drawPath(path, BarImageView.this.Px.mPaint);
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
        new Canvas(createBitmap).drawPath(this.mPath, z ? this.Px.mBorderPaint : this.Px.mPaint);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.Px == null || this.Px.mPaint == null) {
            super.onDraw(canvas);
        } else if (!this.dDJ) {
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
            this.Px.mBorderPaint.setStyle(Paint.Style.FILL);
            this.Px.mBorderPaint.setColor(am.getColor(this.Dc));
            this.dDO = j(measuredWidth, measuredHeight, true);
            this.mPath.reset();
            float strokeWith = getStrokeWith();
            float f5 = measuredWidth / 2;
            this.mPath.moveTo(f5, strokeWith);
            this.mPath.cubicTo((measuredWidth - strokeWith) - 14.0f, strokeWith, measuredWidth - strokeWith, 14.0f + strokeWith, measuredWidth - strokeWith, f5);
            this.mPath.cubicTo(measuredWidth - strokeWith, (measuredWidth - strokeWith) - 14.0f, (measuredWidth - strokeWith) - 14.0f, measuredWidth - strokeWith, f5, measuredWidth - strokeWith);
            this.mPath.cubicTo(strokeWith + 14.0f, measuredWidth - strokeWith, strokeWith, (measuredWidth - strokeWith) - 14.0f, strokeWith, f5);
            this.mPath.cubicTo(strokeWith, strokeWith + 14.0f, strokeWith + 14.0f, strokeWith, f5, strokeWith);
            this.mPath.close();
            if (this.dDQ == null) {
                this.dDQ = new PaintFlagsDrawFilter(0, 3);
            }
            canvas.setDrawFilter(this.dDQ);
            if (this.dDM == null) {
                this.dDM = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            }
            if (this.dDP == null) {
                this.dDP = new Canvas(this.dDM);
            }
            super.onDraw(this.dDP);
            this.dDN = j(measuredWidth, measuredHeight, false);
            if (this.dDL) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
                this.Px.mBorderPaint.setStyle(Paint.Style.FILL);
                this.Px.mBorderPaint.setColor(am.getColor(this.Dc));
                canvas.drawBitmap(this.dDN, 0.0f, 0.0f, this.Px.mBorderPaint);
                this.Px.mBorderPaint.setXfermode(this.dDS);
                canvas.drawBitmap(this.dDO, 0.0f, 0.0f, this.Px.mBorderPaint);
                this.Px.mBorderPaint.setXfermode(null);
                canvas.restoreToCount(saveLayer);
            }
            int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
            canvas.drawBitmap(this.dDN, 0.0f, 0.0f, this.Px.mPaint);
            this.Px.mPaint.setXfermode(this.dDR);
            canvas.drawBitmap(this.dDM, 0.0f, 0.0f, this.Px.mPaint);
            this.Px.mPaint.setXfermode(null);
            canvas.restoreToCount(saveLayer2);
            if (this.dDK) {
                a(canvas, measuredWidth, 14.0f);
            }
        }
    }

    public void setStrokeWith(int i) {
        this.dDI = i;
    }

    public int getStrokeWith() {
        return this.dDI;
    }

    private int getStrokeColorResId() {
        return this.Dc;
    }

    public void setStrokeColorResId(int i) {
        this.Dc = i;
    }

    public void setShowOval(boolean z) {
        this.dDJ = z;
    }

    public void setShowInnerBorder(boolean z) {
        this.dDK = z;
    }

    public void setShowOuterBorder(boolean z) {
        this.dDL = z;
    }

    private void a(Canvas canvas, int i, float f) {
        this.dDH.reset();
        float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
        float f2 = i / 2;
        this.dDH.moveTo(f2, strokeWith);
        this.dDH.cubicTo((i - strokeWith) - f, strokeWith, i - strokeWith, strokeWith + f, i - strokeWith, f2);
        this.dDH.cubicTo(i - strokeWith, (i - strokeWith) - f, (i - strokeWith) - f, i - strokeWith, f2, i - strokeWith);
        this.dDH.cubicTo(strokeWith + f, i - strokeWith, strokeWith, (i - strokeWith) - f, strokeWith, f2);
        this.dDH.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f2, strokeWith);
        this.dDH.close();
        float strokeWidth = this.Px.mBorderPaint.getStrokeWidth();
        this.Px.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.Px.mBorderPaint.setStrokeWidth(getStrokeWith() + 0.5f);
        this.Px.mBorderPaint.setColor(am.getColor(getStrokeColorResId()));
        canvas.drawPath(this.dDH, this.Px.mBorderPaint);
        this.Px.mBorderPaint.setStrokeWidth(strokeWidth);
    }
}
