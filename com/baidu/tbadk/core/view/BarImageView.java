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
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import d.a.c.f.a.a;
/* loaded from: classes3.dex */
public class BarImageView extends TbClipImageView {
    public int C0;
    public int D0;
    public Path E0;
    public Path F0;
    public int G0;
    public int H0;
    public boolean I0;
    public boolean J0;
    public boolean K0;
    public Bitmap L0;
    public Bitmap M0;
    public Bitmap N0;
    public Canvas O0;
    public PaintFlagsDrawFilter P0;
    public PorterDuffXfermode Q0;
    public PorterDuffXfermode R0;

    public BarImageView(Context context) {
        this(context, null, 0);
    }

    private int getStrokeColorResId() {
        return this.H0;
    }

    public final void G() {
        setDrawerType(0);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultResource(this.C0);
        setDefaultBgResource(this.D0);
    }

    public final void c0(Canvas canvas, int i2, float f2) {
        this.F0.reset();
        float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
        float f3 = i2 / 2;
        this.F0.moveTo(f3, strokeWith);
        float f4 = i2 - strokeWith;
        float f5 = f4 - f2;
        float f6 = f2 + strokeWith;
        this.F0.cubicTo(f5, strokeWith, f4, f6, f4, f3);
        this.F0.cubicTo(f4, f5, f5, f4, f3, f4);
        this.F0.cubicTo(f6, f4, strokeWith, f5, strokeWith, f3);
        this.F0.cubicTo(strokeWith, f6, f6, strokeWith, f3, strokeWith);
        this.F0.close();
        float strokeWidth = this.f2204i.f42764c.getStrokeWidth();
        this.f2204i.f42764c.setStyle(Paint.Style.STROKE);
        this.f2204i.f42764c.setStrokeWidth(getStrokeWith() + 0.5f);
        this.f2204i.f42764c.setColor(SkinManager.getColor(getStrokeColorResId()));
        canvas.drawPath(this.F0, this.f2204i.f42764c);
        this.f2204i.f42764c.setStrokeWidth(strokeWidth);
    }

    public final Bitmap d0(int i2, int i3, boolean z) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawPath(this.E0, z ? this.f2204i.f42764c : this.f2204i.f42763b);
        return createBitmap;
    }

    public int getStrokeWith() {
        return this.G0;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        float f5;
        a aVar = this.f2204i;
        if (aVar != null && aVar.f42763b != null) {
            if (!this.I0) {
                super.onDraw(canvas);
                return;
            }
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f6 = (measuredWidth * 14) / IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER;
            this.E0.reset();
            float f7 = measuredWidth;
            float f8 = (f7 + 0.0f) / 2.0f;
            float f9 = measuredHeight;
            float f10 = (f9 + 0.0f) / 2.0f;
            this.E0.moveTo(f8, 0.0f);
            float f11 = f7 - f6;
            this.E0.cubicTo(f11, 0.0f, f7, f6, f7, f10);
            this.E0.cubicTo(f7, f11, f11, f7, f8, f9);
            this.E0.cubicTo(f6, f7, 0.0f, f11, 0.0f, f10);
            this.E0.cubicTo(0.0f, f6, f6, 0.0f, f8, 0.0f);
            this.E0.close();
            this.f2204i.f42764c.setStyle(Paint.Style.FILL);
            this.f2204i.f42764c.setColor(SkinManager.getColor(this.H0));
            this.N0 = d0(measuredWidth, measuredHeight, true);
            this.E0.reset();
            float strokeWith = getStrokeWith();
            float f12 = measuredWidth / 2;
            this.E0.moveTo(f12, strokeWith);
            float f13 = f7 - strokeWith;
            float f14 = f13 - f6;
            float f15 = strokeWith + f6;
            this.E0.cubicTo(f14, strokeWith, f13, f15, f13, f12);
            this.E0.cubicTo(f13, f14, f14, f13, f12, f13);
            this.E0.cubicTo(f15, f13, strokeWith, f14, strokeWith, f12);
            this.E0.cubicTo(strokeWith, f15, f15, strokeWith, f12, strokeWith);
            this.E0.close();
            if (this.P0 == null) {
                this.P0 = new PaintFlagsDrawFilter(0, 3);
            }
            canvas.setDrawFilter(this.P0);
            if (this.L0 == null) {
                this.L0 = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            }
            if (this.O0 == null) {
                this.O0 = new Canvas(this.L0);
            }
            this.f2204i.f42764c.setStyle(Paint.Style.STROKE);
            super.onDraw(this.O0);
            this.M0 = d0(measuredWidth, measuredHeight, false);
            if (this.K0) {
                f2 = f9;
                f5 = 0.0f;
                f3 = f7;
                f4 = f6;
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, f7, f2, null, 31);
                this.f2204i.f42764c.setStyle(Paint.Style.FILL);
                this.f2204i.f42764c.setColor(SkinManager.getColor(this.H0));
                canvas.drawBitmap(this.M0, 0.0f, 0.0f, this.f2204i.f42764c);
                this.f2204i.f42764c.setXfermode(this.R0);
                canvas.drawBitmap(this.N0, 0.0f, 0.0f, this.f2204i.f42764c);
                this.f2204i.f42764c.setXfermode(null);
                if (saveLayer >= 1 && saveLayer <= canvas.getSaveCount()) {
                    canvas.restoreToCount(saveLayer);
                }
            } else {
                f2 = f9;
                f3 = f7;
                f4 = f6;
                f5 = 0.0f;
            }
            int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, f3, f2, null, 31);
            canvas.drawBitmap(this.M0, f5, f5, this.f2204i.f42763b);
            this.f2204i.f42763b.setXfermode(this.Q0);
            canvas.drawBitmap(this.L0, f5, f5, this.f2204i.f42763b);
            this.f2204i.f42763b.setXfermode(null);
            if (saveLayer2 >= 1 && saveLayer2 <= canvas.getSaveCount()) {
                canvas.restoreToCount(saveLayer2);
            }
            if (this.J0) {
                c0(canvas, measuredWidth, f4);
                return;
            }
            return;
        }
        super.onDraw(canvas);
    }

    public void setShowInnerBorder(boolean z) {
        this.J0 = z;
    }

    public void setShowOuterBorder(boolean z) {
        this.K0 = z;
    }

    public void setShowOval(boolean z) {
        this.I0 = z;
    }

    public void setStrokeColorResId(int i2) {
        this.H0 = i2;
    }

    public void setStrokeWith(int i2) {
        this.G0 = i2;
    }

    public BarImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BarImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.C0 = SkinManager.getColor(R.color.CAM_X0209);
        this.D0 = R.drawable.pic_use_header_28_n;
        this.E0 = new Path();
        this.F0 = new Path();
        this.G0 = 0;
        this.H0 = 0;
        this.I0 = false;
        this.J0 = false;
        this.K0 = true;
        this.Q0 = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.R0 = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        G();
    }
}
