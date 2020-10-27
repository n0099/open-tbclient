package com.baidu.live.tieba.view;

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
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.widget.TbClipImageView;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class BarImageView extends TbClipImageView {
    private float accuracy;
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
    private TbImageView.OnDrawListener mOnDrawListener;
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
        this.mDefaultId = SkinManager.getColor(a.d.sdk_cp_bg_line_e);
        this.mDefaultBgId = a.f.yuyin_sdk_icon_default_avatar100;
        this.mPath = new Path();
        this.bxe = new Path();
        this.bxf = 0;
        this.strokeColor = 0;
        this.accuracy = 14.0f;
        this.bxg = false;
        this.bxh = false;
        this.bxi = true;
        this.bxo = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.bxp = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.mOnDrawListener = new TbImageView.OnDrawListener() { // from class: com.baidu.live.tieba.view.BarImageView.1
            @Override // com.baidu.live.tbadk.widget.TbImageView.OnDrawListener
            public void onBeforeDraw(TbImageView tbImageView, Canvas canvas) {
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbImageView.getLayoutParams();
                    Path path = new Path();
                    path.reset();
                    int measuredWidth = tbImageView.getMeasuredWidth();
                    int i2 = (0 + measuredWidth) / 2;
                    int measuredHeight = tbImageView.getMeasuredHeight();
                    int i3 = (0 + measuredHeight) / 2;
                    path.moveTo(i2, 0);
                    path.quadTo(measuredWidth, 0 - BdUtilHelper.getDimens(BarImageView.this.getContext(), a.e.sdk_tbds6), measuredWidth, i3);
                    path.quadTo(measuredWidth, BdUtilHelper.getDimens(BarImageView.this.getContext(), a.e.sdk_tbds6) + measuredHeight, i2, measuredHeight);
                    path.quadTo(0, measuredHeight + BdUtilHelper.getDimens(BarImageView.this.getContext(), a.e.sdk_tbds6), 0, i3);
                    path.quadTo(0, 0 - BdUtilHelper.getDimens(BarImageView.this.getContext(), a.e.sdk_tbds6), i2, 0);
                    path.close();
                    BarImageView.this.mDrawer.mPaint.setColor(SkinManager.getColor(a.d.sdk_white_alpha100));
                    BarImageView.this.mDrawer.mPaint.setStrokeWidth(BdUtilHelper.getDimens(BarImageView.this.getContext(), a.e.sdk_tbds6));
                    BarImageView.this.mDrawer.mPaint.setStyle(Paint.Style.STROKE);
                    BarImageView.this.mDrawer.mPaint.setAntiAlias(true);
                    canvas.drawPath(path, BarImageView.this.mDrawer.mPaint);
                    canvas.clipPath(path);
                }
            }

            @Override // com.baidu.live.tbadk.widget.TbImageView.OnDrawListener
            public void onAfterDraw(TbImageView tbImageView, Canvas canvas) {
            }
        };
        init();
    }

    private void init() {
        setDrawerType(0);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultResource(this.mDefaultId);
        setDefaultErrorResource(a.f.sdk_icon_default_avatar100);
        setDefaultBgResource(this.mDefaultBgId);
    }

    private Bitmap f(int i, int i2, boolean z) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawPath(this.mPath, z ? this.mDrawer.mBorderPaint : this.mDrawer.mPaint);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.widget.TbImageView, com.baidu.live.adp.newwidget.imageview.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mDrawer == null || this.mDrawer.mPaint == null) {
            super.onDraw(canvas);
        } else if (!this.bxg) {
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
            this.mDrawer.mBorderPaint.setStyle(Paint.Style.FILL);
            this.mDrawer.mBorderPaint.setColor(SkinManager.getColor(this.strokeColor));
            this.bxl = f(measuredWidth, measuredHeight, true);
            this.mPath.reset();
            float strokeWith = getStrokeWith();
            float f5 = measuredWidth / 2;
            this.mPath.moveTo(f5, strokeWith);
            this.mPath.cubicTo((measuredWidth - strokeWith) - accuracy, strokeWith, measuredWidth - strokeWith, strokeWith + accuracy, measuredWidth - strokeWith, f5);
            this.mPath.cubicTo(measuredWidth - strokeWith, (measuredWidth - strokeWith) - accuracy, (measuredWidth - strokeWith) - accuracy, measuredWidth - strokeWith, f5, measuredWidth - strokeWith);
            this.mPath.cubicTo(strokeWith + accuracy, measuredWidth - strokeWith, strokeWith, (measuredWidth - strokeWith) - accuracy, strokeWith, f5);
            this.mPath.cubicTo(strokeWith, strokeWith + accuracy, strokeWith + accuracy, strokeWith, f5, strokeWith);
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
                this.mDrawer.mBorderPaint.setStyle(Paint.Style.FILL);
                this.mDrawer.mBorderPaint.setColor(SkinManager.getColor(this.strokeColor));
                canvas.drawBitmap(this.bxk, 0.0f, 0.0f, this.mDrawer.mBorderPaint);
                this.mDrawer.mBorderPaint.setXfermode(this.bxp);
                canvas.drawBitmap(this.bxl, 0.0f, 0.0f, this.mDrawer.mBorderPaint);
                this.mDrawer.mBorderPaint.setXfermode(null);
                if (saveLayer >= 1) {
                    canvas.restoreToCount(saveLayer);
                }
            }
            int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
            canvas.drawBitmap(this.bxk, 0.0f, 0.0f, this.mDrawer.mPaint);
            this.mDrawer.mPaint.setXfermode(this.bxo);
            canvas.drawBitmap(this.bxj, 0.0f, 0.0f, this.mDrawer.mPaint);
            this.mDrawer.mPaint.setXfermode(null);
            if (saveLayer2 >= 1) {
                canvas.restoreToCount(saveLayer2);
            }
            if (this.bxh) {
                a(canvas, measuredWidth, accuracy);
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
        float strokeWidth = this.mDrawer.mBorderPaint.getStrokeWidth();
        this.mDrawer.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mDrawer.mBorderPaint.setStrokeWidth(getStrokeWith() + 0.5f);
        this.mDrawer.mBorderPaint.setColor(SkinManager.getColor(getStrokeColorResId()));
        canvas.drawPath(this.bxe, this.mDrawer.mBorderPaint);
        this.mDrawer.mBorderPaint.setStrokeWidth(strokeWidth);
    }

    public void setAccuracyWith(float f) {
        this.accuracy = f;
    }

    public float getAccuracy() {
        return this.accuracy;
    }
}
