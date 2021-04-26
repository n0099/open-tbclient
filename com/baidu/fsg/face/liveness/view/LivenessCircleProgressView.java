package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes2.dex */
public class LivenessCircleProgressView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public Paint f6297a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f6298b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f6299c;

    /* renamed from: d  reason: collision with root package name */
    public int f6300d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f6301e;

    /* renamed from: f  reason: collision with root package name */
    public int f6302f;

    public LivenessCircleProgressView(@NonNull Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f6302f = 12;
        Paint paint = new Paint();
        this.f6297a = paint;
        paint.setColor(Color.argb(127, 255, 255, 255));
        this.f6297a.setAntiAlias(true);
        this.f6297a.setStrokeWidth(this.f6302f);
        this.f6297a.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f6298b = paint2;
        paint2.setColor(Color.argb(255, 255, 255, 255));
        this.f6298b.setAntiAlias(true);
        this.f6298b.setStrokeWidth(this.f6302f);
        this.f6298b.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint();
        this.f6299c = paint3;
        paint3.setColor(Color.rgb(255, 255, 255));
        this.f6299c.setAntiAlias(true);
        this.f6299c.setTextSize(getResources().getDimensionPixelSize(R.dimen.rim_text_size_20));
        this.f6299c.setTextAlign(Paint.Align.CENTER);
        this.f6301e = new RectF();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - (this.f6302f / 2), this.f6297a);
        RectF rectF = this.f6301e;
        int i2 = this.f6302f;
        rectF.left = i2 / 2;
        rectF.top = i2 / 2;
        rectF.right = getWidth() - (this.f6302f / 2);
        this.f6301e.bottom = getHeight() - (this.f6302f / 2);
        canvas.drawArc(this.f6301e, -90.0f, (this.f6300d / 100.0f) * 360.0f, false, this.f6298b);
        canvas.drawText(this.f6300d + "%", getWidth() / 2, getHeight() / 2, this.f6299c);
    }

    public void updateProgress(int i2) {
        this.f6300d = i2;
        invalidate();
    }

    public LivenessCircleProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
