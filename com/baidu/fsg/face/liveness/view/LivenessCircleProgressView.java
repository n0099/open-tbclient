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
    public Paint f6051a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f6052b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f6053c;

    /* renamed from: d  reason: collision with root package name */
    public int f6054d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f6055e;

    /* renamed from: f  reason: collision with root package name */
    public int f6056f;

    public LivenessCircleProgressView(@NonNull Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f6056f = 12;
        Paint paint = new Paint();
        this.f6051a = paint;
        paint.setColor(Color.argb(127, 255, 255, 255));
        this.f6051a.setAntiAlias(true);
        this.f6051a.setStrokeWidth(this.f6056f);
        this.f6051a.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f6052b = paint2;
        paint2.setColor(Color.argb(255, 255, 255, 255));
        this.f6052b.setAntiAlias(true);
        this.f6052b.setStrokeWidth(this.f6056f);
        this.f6052b.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint();
        this.f6053c = paint3;
        paint3.setColor(Color.rgb(255, 255, 255));
        this.f6053c.setAntiAlias(true);
        this.f6053c.setTextSize(getResources().getDimensionPixelSize(R.dimen.rim_text_size_20));
        this.f6053c.setTextAlign(Paint.Align.CENTER);
        this.f6055e = new RectF();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - (this.f6056f / 2), this.f6051a);
        RectF rectF = this.f6055e;
        int i2 = this.f6056f;
        rectF.left = i2 / 2;
        rectF.top = i2 / 2;
        rectF.right = getWidth() - (this.f6056f / 2);
        this.f6055e.bottom = getHeight() - (this.f6056f / 2);
        canvas.drawArc(this.f6055e, -90.0f, (this.f6054d / 100.0f) * 360.0f, false, this.f6052b);
        canvas.drawText(this.f6054d + "%", getWidth() / 2, getHeight() / 2, this.f6053c);
    }

    public void updateProgress(int i2) {
        this.f6054d = i2;
        invalidate();
    }

    public LivenessCircleProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
