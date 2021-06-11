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
    public Paint f6094a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f6095b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f6096c;

    /* renamed from: d  reason: collision with root package name */
    public int f6097d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f6098e;

    /* renamed from: f  reason: collision with root package name */
    public int f6099f;

    public LivenessCircleProgressView(@NonNull Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f6099f = 12;
        Paint paint = new Paint();
        this.f6094a = paint;
        paint.setColor(Color.argb(127, 255, 255, 255));
        this.f6094a.setAntiAlias(true);
        this.f6094a.setStrokeWidth(this.f6099f);
        this.f6094a.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f6095b = paint2;
        paint2.setColor(Color.argb(255, 255, 255, 255));
        this.f6095b.setAntiAlias(true);
        this.f6095b.setStrokeWidth(this.f6099f);
        this.f6095b.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint();
        this.f6096c = paint3;
        paint3.setColor(Color.rgb(255, 255, 255));
        this.f6096c.setAntiAlias(true);
        this.f6096c.setTextSize(getResources().getDimensionPixelSize(R.dimen.rim_text_size_20));
        this.f6096c.setTextAlign(Paint.Align.CENTER);
        this.f6098e = new RectF();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - (this.f6099f / 2), this.f6094a);
        RectF rectF = this.f6098e;
        int i2 = this.f6099f;
        rectF.left = i2 / 2;
        rectF.top = i2 / 2;
        rectF.right = getWidth() - (this.f6099f / 2);
        this.f6098e.bottom = getHeight() - (this.f6099f / 2);
        canvas.drawArc(this.f6098e, -90.0f, (this.f6097d / 100.0f) * 360.0f, false, this.f6095b);
        canvas.drawText(this.f6097d + "%", getWidth() / 2, getHeight() / 2, this.f6096c);
    }

    public void updateProgress(int i2) {
        this.f6097d = i2;
        invalidate();
    }

    public LivenessCircleProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
