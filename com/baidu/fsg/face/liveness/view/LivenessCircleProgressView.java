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
    public Paint f6087a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f6088b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f6089c;

    /* renamed from: d  reason: collision with root package name */
    public int f6090d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f6091e;

    /* renamed from: f  reason: collision with root package name */
    public int f6092f;

    public LivenessCircleProgressView(@NonNull Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f6092f = 12;
        Paint paint = new Paint();
        this.f6087a = paint;
        paint.setColor(Color.argb(127, 255, 255, 255));
        this.f6087a.setAntiAlias(true);
        this.f6087a.setStrokeWidth(this.f6092f);
        this.f6087a.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f6088b = paint2;
        paint2.setColor(Color.argb(255, 255, 255, 255));
        this.f6088b.setAntiAlias(true);
        this.f6088b.setStrokeWidth(this.f6092f);
        this.f6088b.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint();
        this.f6089c = paint3;
        paint3.setColor(Color.rgb(255, 255, 255));
        this.f6089c.setAntiAlias(true);
        this.f6089c.setTextSize(getResources().getDimensionPixelSize(R.dimen.rim_text_size_20));
        this.f6089c.setTextAlign(Paint.Align.CENTER);
        this.f6091e = new RectF();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - (this.f6092f / 2), this.f6087a);
        RectF rectF = this.f6091e;
        int i = this.f6092f;
        rectF.left = i / 2;
        rectF.top = i / 2;
        rectF.right = getWidth() - (this.f6092f / 2);
        this.f6091e.bottom = getHeight() - (this.f6092f / 2);
        canvas.drawArc(this.f6091e, -90.0f, (this.f6090d / 100.0f) * 360.0f, false, this.f6088b);
        canvas.drawText(this.f6090d + "%", getWidth() / 2, getHeight() / 2, this.f6089c);
    }

    public void updateProgress(int i) {
        this.f6090d = i;
        invalidate();
    }

    public LivenessCircleProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
