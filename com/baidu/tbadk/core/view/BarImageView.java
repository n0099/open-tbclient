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
    private int Ft;
    private TbImageView.b alw;
    private Path bGM;
    private int bGN;
    private boolean bGO;
    private boolean bGP;
    private boolean bGQ;
    private Bitmap bGR;
    private Bitmap bGS;
    private Bitmap bGT;
    private Canvas bGU;
    private PaintFlagsDrawFilter bGV;
    private PorterDuffXfermode bGW;
    private PorterDuffXfermode bGX;
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
        this.mDefaultId = ap.getColor(R.color.CAM_X0209);
        this.mDefaultBgId = R.drawable.pic_use_header_28_n;
        this.mPath = new Path();
        this.bGM = new Path();
        this.bGN = 0;
        this.Ft = 0;
        this.bGO = false;
        this.bGP = false;
        this.bGQ = true;
        this.bGW = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.bGX = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.alw = new TbImageView.b() { // from class: com.baidu.tbadk.core.view.BarImageView.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
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
                    BarImageView.this.Su.mPaint.setColor(ap.getColor(R.color.white_alpha100));
                    BarImageView.this.Su.mPaint.setStrokeWidth(com.baidu.adp.lib.util.l.getDimens(BarImageView.this.getContext(), R.dimen.tbds6));
                    BarImageView.this.Su.mPaint.setStyle(Paint.Style.STROKE);
                    BarImageView.this.Su.mPaint.setAntiAlias(true);
                    canvas.drawPath(path, BarImageView.this.Su.mPaint);
                    canvas.clipPath(path);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
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
        new Canvas(createBitmap).drawPath(this.mPath, z ? this.Su.mBorderPaint : this.Su.mPaint);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.Su == null || this.Su.mPaint == null) {
            super.onDraw(canvas);
        } else if (!this.bGO) {
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
            this.Su.mBorderPaint.setStyle(Paint.Style.FILL);
            this.Su.mBorderPaint.setColor(ap.getColor(this.Ft));
            this.bGT = f(measuredWidth, measuredHeight, true);
            this.mPath.reset();
            float strokeWith = getStrokeWith();
            float f6 = measuredWidth / 2;
            this.mPath.moveTo(f6, strokeWith);
            this.mPath.cubicTo((measuredWidth - strokeWith) - f, strokeWith, measuredWidth - strokeWith, strokeWith + f, measuredWidth - strokeWith, f6);
            this.mPath.cubicTo(measuredWidth - strokeWith, (measuredWidth - strokeWith) - f, (measuredWidth - strokeWith) - f, measuredWidth - strokeWith, f6, measuredWidth - strokeWith);
            this.mPath.cubicTo(strokeWith + f, measuredWidth - strokeWith, strokeWith, (measuredWidth - strokeWith) - f, strokeWith, f6);
            this.mPath.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f6, strokeWith);
            this.mPath.close();
            if (this.bGV == null) {
                this.bGV = new PaintFlagsDrawFilter(0, 3);
            }
            canvas.setDrawFilter(this.bGV);
            if (this.bGR == null) {
                this.bGR = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            }
            if (this.bGU == null) {
                this.bGU = new Canvas(this.bGR);
            }
            super.onDraw(this.bGU);
            this.bGS = f(measuredWidth, measuredHeight, false);
            if (this.bGQ) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
                this.Su.mBorderPaint.setStyle(Paint.Style.FILL);
                this.Su.mBorderPaint.setColor(ap.getColor(this.Ft));
                canvas.drawBitmap(this.bGS, 0.0f, 0.0f, this.Su.mBorderPaint);
                this.Su.mBorderPaint.setXfermode(this.bGX);
                canvas.drawBitmap(this.bGT, 0.0f, 0.0f, this.Su.mBorderPaint);
                this.Su.mBorderPaint.setXfermode(null);
                if (saveLayer >= 1 && saveLayer <= canvas.getSaveCount()) {
                    canvas.restoreToCount(saveLayer);
                }
            }
            int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
            canvas.drawBitmap(this.bGS, 0.0f, 0.0f, this.Su.mPaint);
            this.Su.mPaint.setXfermode(this.bGW);
            canvas.drawBitmap(this.bGR, 0.0f, 0.0f, this.Su.mPaint);
            this.Su.mPaint.setXfermode(null);
            if (saveLayer2 >= 1 && saveLayer2 <= canvas.getSaveCount()) {
                canvas.restoreToCount(saveLayer2);
            }
            if (this.bGP) {
                a(canvas, measuredWidth, f);
            }
        }
    }

    public void setStrokeWith(int i) {
        this.bGN = i;
    }

    public int getStrokeWith() {
        return this.bGN;
    }

    private int getStrokeColorResId() {
        return this.Ft;
    }

    public void setStrokeColorResId(int i) {
        this.Ft = i;
    }

    public void setShowOval(boolean z) {
        this.bGO = z;
    }

    public void setShowInnerBorder(boolean z) {
        this.bGP = z;
    }

    public void setShowOuterBorder(boolean z) {
        this.bGQ = z;
    }

    private void a(Canvas canvas, int i, float f) {
        this.bGM.reset();
        float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
        float f2 = i / 2;
        this.bGM.moveTo(f2, strokeWith);
        this.bGM.cubicTo((i - strokeWith) - f, strokeWith, i - strokeWith, strokeWith + f, i - strokeWith, f2);
        this.bGM.cubicTo(i - strokeWith, (i - strokeWith) - f, (i - strokeWith) - f, i - strokeWith, f2, i - strokeWith);
        this.bGM.cubicTo(strokeWith + f, i - strokeWith, strokeWith, (i - strokeWith) - f, strokeWith, f2);
        this.bGM.cubicTo(strokeWith, strokeWith + f, strokeWith + f, strokeWith, f2, strokeWith);
        this.bGM.close();
        float strokeWidth = this.Su.mBorderPaint.getStrokeWidth();
        this.Su.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.Su.mBorderPaint.setStrokeWidth(getStrokeWith() + 0.5f);
        this.Su.mBorderPaint.setColor(ap.getColor(getStrokeColorResId()));
        canvas.drawPath(this.bGM, this.Su.mBorderPaint);
        this.Su.mBorderPaint.setStrokeWidth(strokeWidth);
    }
}
