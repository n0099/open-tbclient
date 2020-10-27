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
    private TbImageView.c aks;
    private Path bxe;
    private int bxf;
    private boolean bxg;
    private boolean bxh;
    private boolean bxi;
    private Bitmap bxj;
    private Bitmap bxk;
    private Bitmap bxl;
    private Canvas bxm;
    private PaintFlagsDrawFilter bxn;
    private PorterDuffXfermode bxo;
    private PorterDuffXfermode bxp;
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
        this.bxe = new Path();
        this.bxf = 0;
        this.strokeColor = 0;
        this.bxg = false;
        this.bxh = false;
        this.bxi = true;
        this.bxo = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.bxp = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.aks = new TbImageView.c() { // from class: com.baidu.tbadk.core.view.BarImageView.1
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
                    BarImageView.this.Rz.mPaint.setColor(ap.getColor(R.color.white_alpha100));
                    BarImageView.this.Rz.mPaint.setStrokeWidth(com.baidu.adp.lib.util.l.getDimens(BarImageView.this.getContext(), R.dimen.tbds6));
                    BarImageView.this.Rz.mPaint.setStyle(Paint.Style.STROKE);
                    BarImageView.this.Rz.mPaint.setAntiAlias(true);
                    canvas.drawPath(path, BarImageView.this.Rz.mPaint);
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
        new Canvas(createBitmap).drawPath(this.mPath, z ? this.Rz.mBorderPaint : this.Rz.mPaint);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.Rz == null || this.Rz.mPaint == null) {
            super.onDraw(canvas);
        } else if (!this.bxg) {
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
            this.Rz.mBorderPaint.setStyle(Paint.Style.FILL);
            this.Rz.mBorderPaint.setColor(ap.getColor(this.strokeColor));
            this.bxl = f(measuredWidth, measuredHeight, true);
            this.mPath.reset();
            float strokeWith = getStrokeWith();
            float f6 = measuredWidth / 2;
            this.mPath.moveTo(f6, strokeWith);
            this.mPath.cubicTo((measuredWidth - strokeWith) - f, strokeWith, measuredWidth - strokeWith, strokeWith + f, measuredWidth - strokeWith, f6);
            this.mPath.cubicTo(measuredWidth - strokeWith, (measuredWidth - strokeWith) - f, (measuredWidth - strokeWith) - f, measuredWidth - strokeWith, f6, measuredWidth - strokeWith);
            this.mPath.cubicTo(strokeWith + f, measuredWidth - strokeWith, strokeWith, (measuredWidth - strokeWith) - f, strokeWith, f6);
            this.mPath.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f6, strokeWith);
            this.mPath.close();
            if (this.bxn == null) {
                this.bxn = new PaintFlagsDrawFilter(0, 3);
            }
            canvas.setDrawFilter(this.bxn);
            if (this.bxj == null) {
                this.bxj = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            }
            if (this.bxm == null) {
                this.bxm = new Canvas(this.bxj);
            }
            super.onDraw(this.bxm);
            this.bxk = f(measuredWidth, measuredHeight, false);
            if (this.bxi) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
                this.Rz.mBorderPaint.setStyle(Paint.Style.FILL);
                this.Rz.mBorderPaint.setColor(ap.getColor(this.strokeColor));
                canvas.drawBitmap(this.bxk, 0.0f, 0.0f, this.Rz.mBorderPaint);
                this.Rz.mBorderPaint.setXfermode(this.bxp);
                canvas.drawBitmap(this.bxl, 0.0f, 0.0f, this.Rz.mBorderPaint);
                this.Rz.mBorderPaint.setXfermode(null);
                if (saveLayer >= 1 && saveLayer <= canvas.getSaveCount()) {
                    canvas.restoreToCount(saveLayer);
                }
            }
            int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
            canvas.drawBitmap(this.bxk, 0.0f, 0.0f, this.Rz.mPaint);
            this.Rz.mPaint.setXfermode(this.bxo);
            canvas.drawBitmap(this.bxj, 0.0f, 0.0f, this.Rz.mPaint);
            this.Rz.mPaint.setXfermode(null);
            if (saveLayer2 >= 1 && saveLayer2 <= canvas.getSaveCount()) {
                canvas.restoreToCount(saveLayer2);
            }
            if (this.bxh) {
                a(canvas, measuredWidth, f);
            }
        }
    }

    public void setStrokeWith(int i) {
        this.bxf = i;
    }

    public int getStrokeWith() {
        return this.bxf;
    }

    private int getStrokeColorResId() {
        return this.strokeColor;
    }

    public void setStrokeColorResId(int i) {
        this.strokeColor = i;
    }

    public void setShowOval(boolean z) {
        this.bxg = z;
    }

    public void setShowInnerBorder(boolean z) {
        this.bxh = z;
    }

    public void setShowOuterBorder(boolean z) {
        this.bxi = z;
    }

    private void a(Canvas canvas, int i, float f) {
        this.bxe.reset();
        float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
        float f2 = i / 2;
        this.bxe.moveTo(f2, strokeWith);
        this.bxe.cubicTo((i - strokeWith) - f, strokeWith, i - strokeWith, strokeWith + f, i - strokeWith, f2);
        this.bxe.cubicTo(i - strokeWith, (i - strokeWith) - f, (i - strokeWith) - f, i - strokeWith, f2, i - strokeWith);
        this.bxe.cubicTo(strokeWith + f, i - strokeWith, strokeWith, (i - strokeWith) - f, strokeWith, f2);
        this.bxe.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f2, strokeWith);
        this.bxe.close();
        float strokeWidth = this.Rz.mBorderPaint.getStrokeWidth();
        this.Rz.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.Rz.mBorderPaint.setStrokeWidth(getStrokeWith() + 0.5f);
        this.Rz.mBorderPaint.setColor(ap.getColor(getStrokeColorResId()));
        canvas.drawPath(this.bxe, this.Rz.mBorderPaint);
        this.Rz.mBorderPaint.setStrokeWidth(strokeWidth);
    }
}
