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
/* loaded from: classes2.dex */
public class BarImageView extends TbClipImageView {
    private TbImageView.c ajz;
    private int eoA;
    private boolean eoB;
    private boolean eoC;
    private boolean eoD;
    private Bitmap eoE;
    private Bitmap eoF;
    private Bitmap eoG;
    private Canvas eoH;
    private PaintFlagsDrawFilter eoI;
    private PorterDuffXfermode eoJ;
    private PorterDuffXfermode eoK;
    private Path eoz;
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
        this.eoz = new Path();
        this.eoA = 0;
        this.strokeColor = 0;
        this.eoB = false;
        this.eoC = false;
        this.eoD = true;
        this.eoJ = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.eoK = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.ajz = new TbImageView.c() { // from class: com.baidu.tbadk.core.view.BarImageView.1
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
                    BarImageView.this.QP.mPaint.setColor(ap.getColor(R.color.white_alpha100));
                    BarImageView.this.QP.mPaint.setStrokeWidth(com.baidu.adp.lib.util.l.getDimens(BarImageView.this.getContext(), R.dimen.tbds6));
                    BarImageView.this.QP.mPaint.setStyle(Paint.Style.STROKE);
                    BarImageView.this.QP.mPaint.setAntiAlias(true);
                    canvas.drawPath(path, BarImageView.this.QP.mPaint);
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
        new Canvas(createBitmap).drawPath(this.mPath, z ? this.QP.mBorderPaint : this.QP.mPaint);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.QP == null || this.QP.mPaint == null) {
            super.onDraw(canvas);
        } else if (!this.eoB) {
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
            this.QP.mBorderPaint.setStyle(Paint.Style.FILL);
            this.QP.mBorderPaint.setColor(ap.getColor(this.strokeColor));
            this.eoG = j(measuredWidth, measuredHeight, true);
            this.mPath.reset();
            float strokeWith = getStrokeWith();
            float f6 = measuredWidth / 2;
            this.mPath.moveTo(f6, strokeWith);
            this.mPath.cubicTo((measuredWidth - strokeWith) - f, strokeWith, measuredWidth - strokeWith, strokeWith + f, measuredWidth - strokeWith, f6);
            this.mPath.cubicTo(measuredWidth - strokeWith, (measuredWidth - strokeWith) - f, (measuredWidth - strokeWith) - f, measuredWidth - strokeWith, f6, measuredWidth - strokeWith);
            this.mPath.cubicTo(strokeWith + f, measuredWidth - strokeWith, strokeWith, (measuredWidth - strokeWith) - f, strokeWith, f6);
            this.mPath.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f6, strokeWith);
            this.mPath.close();
            if (this.eoI == null) {
                this.eoI = new PaintFlagsDrawFilter(0, 3);
            }
            canvas.setDrawFilter(this.eoI);
            if (this.eoE == null) {
                this.eoE = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            }
            if (this.eoH == null) {
                this.eoH = new Canvas(this.eoE);
            }
            super.onDraw(this.eoH);
            this.eoF = j(measuredWidth, measuredHeight, false);
            if (this.eoD) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
                this.QP.mBorderPaint.setStyle(Paint.Style.FILL);
                this.QP.mBorderPaint.setColor(ap.getColor(this.strokeColor));
                canvas.drawBitmap(this.eoF, 0.0f, 0.0f, this.QP.mBorderPaint);
                this.QP.mBorderPaint.setXfermode(this.eoK);
                canvas.drawBitmap(this.eoG, 0.0f, 0.0f, this.QP.mBorderPaint);
                this.QP.mBorderPaint.setXfermode(null);
                if (saveLayer >= 1 && saveLayer <= canvas.getSaveCount()) {
                    canvas.restoreToCount(saveLayer);
                }
            }
            int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
            canvas.drawBitmap(this.eoF, 0.0f, 0.0f, this.QP.mPaint);
            this.QP.mPaint.setXfermode(this.eoJ);
            canvas.drawBitmap(this.eoE, 0.0f, 0.0f, this.QP.mPaint);
            this.QP.mPaint.setXfermode(null);
            if (saveLayer2 >= 1 && saveLayer2 <= canvas.getSaveCount()) {
                canvas.restoreToCount(saveLayer2);
            }
            if (this.eoC) {
                a(canvas, measuredWidth, f);
            }
        }
    }

    public void setStrokeWith(int i) {
        this.eoA = i;
    }

    public int getStrokeWith() {
        return this.eoA;
    }

    private int getStrokeColorResId() {
        return this.strokeColor;
    }

    public void setStrokeColorResId(int i) {
        this.strokeColor = i;
    }

    public void setShowOval(boolean z) {
        this.eoB = z;
    }

    public void setShowInnerBorder(boolean z) {
        this.eoC = z;
    }

    public void setShowOuterBorder(boolean z) {
        this.eoD = z;
    }

    private void a(Canvas canvas, int i, float f) {
        this.eoz.reset();
        float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
        float f2 = i / 2;
        this.eoz.moveTo(f2, strokeWith);
        this.eoz.cubicTo((i - strokeWith) - f, strokeWith, i - strokeWith, strokeWith + f, i - strokeWith, f2);
        this.eoz.cubicTo(i - strokeWith, (i - strokeWith) - f, (i - strokeWith) - f, i - strokeWith, f2, i - strokeWith);
        this.eoz.cubicTo(strokeWith + f, i - strokeWith, strokeWith, (i - strokeWith) - f, strokeWith, f2);
        this.eoz.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f2, strokeWith);
        this.eoz.close();
        float strokeWidth = this.QP.mBorderPaint.getStrokeWidth();
        this.QP.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.QP.mBorderPaint.setStrokeWidth(getStrokeWith() + 0.5f);
        this.QP.mBorderPaint.setColor(ap.getColor(getStrokeColorResId()));
        canvas.drawPath(this.eoz, this.QP.mBorderPaint);
        this.QP.mBorderPaint.setStrokeWidth(strokeWidth);
    }
}
