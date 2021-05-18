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
    public Path A0;
    public int B0;
    public int C0;
    public boolean D0;
    public boolean E0;
    public boolean K0;
    public Bitmap L0;
    public Bitmap M0;
    public Bitmap N0;
    public Canvas O0;
    public PaintFlagsDrawFilter P0;
    public PorterDuffXfermode Q0;
    public PorterDuffXfermode R0;
    public int x0;
    public int y0;
    public Path z0;

    public BarImageView(Context context) {
        this(context, null, 0);
    }

    private int getStrokeColorResId() {
        return this.C0;
    }

    public final void G() {
        setDrawerType(0);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultResource(this.x0);
        setDefaultBgResource(this.y0);
    }

    public final void d0(Canvas canvas, int i2, float f2) {
        this.A0.reset();
        float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
        float f3 = i2 / 2;
        this.A0.moveTo(f3, strokeWith);
        float f4 = i2 - strokeWith;
        float f5 = f4 - f2;
        float f6 = f2 + strokeWith;
        this.A0.cubicTo(f5, strokeWith, f4, f6, f4, f3);
        this.A0.cubicTo(f4, f5, f5, f4, f3, f4);
        this.A0.cubicTo(f6, f4, strokeWith, f5, strokeWith, f3);
        this.A0.cubicTo(strokeWith, f6, f6, strokeWith, f3, strokeWith);
        this.A0.close();
        float strokeWidth = this.f2186i.f39344c.getStrokeWidth();
        this.f2186i.f39344c.setStyle(Paint.Style.STROKE);
        this.f2186i.f39344c.setStrokeWidth(getStrokeWith() + 0.5f);
        this.f2186i.f39344c.setColor(SkinManager.getColor(getStrokeColorResId()));
        canvas.drawPath(this.A0, this.f2186i.f39344c);
        this.f2186i.f39344c.setStrokeWidth(strokeWidth);
    }

    public final Bitmap e0(int i2, int i3, boolean z) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawPath(this.z0, z ? this.f2186i.f39344c : this.f2186i.f39343b);
        return createBitmap;
    }

    public int getStrokeWith() {
        return this.B0;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        float f5;
        a aVar = this.f2186i;
        if (aVar != null && aVar.f39343b != null) {
            if (!this.D0) {
                super.onDraw(canvas);
                return;
            }
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f6 = (measuredWidth * 14) / IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER;
            this.z0.reset();
            float f7 = measuredWidth;
            float f8 = (f7 + 0.0f) / 2.0f;
            float f9 = measuredHeight;
            float f10 = (f9 + 0.0f) / 2.0f;
            this.z0.moveTo(f8, 0.0f);
            float f11 = f7 - f6;
            this.z0.cubicTo(f11, 0.0f, f7, f6, f7, f10);
            this.z0.cubicTo(f7, f11, f11, f7, f8, f9);
            this.z0.cubicTo(f6, f7, 0.0f, f11, 0.0f, f10);
            this.z0.cubicTo(0.0f, f6, f6, 0.0f, f8, 0.0f);
            this.z0.close();
            this.f2186i.f39344c.setStyle(Paint.Style.FILL);
            this.f2186i.f39344c.setColor(SkinManager.getColor(this.C0));
            this.N0 = e0(measuredWidth, measuredHeight, true);
            this.z0.reset();
            float strokeWith = getStrokeWith();
            float f12 = measuredWidth / 2;
            this.z0.moveTo(f12, strokeWith);
            float f13 = f7 - strokeWith;
            float f14 = f13 - f6;
            float f15 = strokeWith + f6;
            this.z0.cubicTo(f14, strokeWith, f13, f15, f13, f12);
            this.z0.cubicTo(f13, f14, f14, f13, f12, f13);
            this.z0.cubicTo(f15, f13, strokeWith, f14, strokeWith, f12);
            this.z0.cubicTo(strokeWith, f15, f15, strokeWith, f12, strokeWith);
            this.z0.close();
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
            this.f2186i.f39344c.setStyle(Paint.Style.STROKE);
            super.onDraw(this.O0);
            this.M0 = e0(measuredWidth, measuredHeight, false);
            if (this.K0) {
                f2 = f9;
                f5 = 0.0f;
                f3 = f7;
                f4 = f6;
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, f7, f2, null, 31);
                this.f2186i.f39344c.setStyle(Paint.Style.FILL);
                this.f2186i.f39344c.setColor(SkinManager.getColor(this.C0));
                canvas.drawBitmap(this.M0, 0.0f, 0.0f, this.f2186i.f39344c);
                this.f2186i.f39344c.setXfermode(this.R0);
                canvas.drawBitmap(this.N0, 0.0f, 0.0f, this.f2186i.f39344c);
                this.f2186i.f39344c.setXfermode(null);
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
            canvas.drawBitmap(this.M0, f5, f5, this.f2186i.f39343b);
            this.f2186i.f39343b.setXfermode(this.Q0);
            canvas.drawBitmap(this.L0, f5, f5, this.f2186i.f39343b);
            this.f2186i.f39343b.setXfermode(null);
            if (saveLayer2 >= 1 && saveLayer2 <= canvas.getSaveCount()) {
                canvas.restoreToCount(saveLayer2);
            }
            if (this.E0) {
                d0(canvas, measuredWidth, f4);
                return;
            }
            return;
        }
        super.onDraw(canvas);
    }

    public void setShowInnerBorder(boolean z) {
        this.E0 = z;
    }

    public void setShowOuterBorder(boolean z) {
        this.K0 = z;
    }

    public void setShowOval(boolean z) {
        this.D0 = z;
    }

    public void setStrokeColorResId(int i2) {
        this.C0 = i2;
    }

    public void setStrokeWith(int i2) {
        this.B0 = i2;
    }

    public BarImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BarImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.x0 = SkinManager.getColor(R.color.CAM_X0209);
        this.y0 = R.drawable.pic_use_header_28_n;
        this.z0 = new Path();
        this.A0 = new Path();
        this.B0 = 0;
        this.C0 = 0;
        this.D0 = false;
        this.E0 = false;
        this.K0 = true;
        this.Q0 = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.R0 = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        G();
    }
}
