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
    public Paint f6151a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f6152b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f6153c;

    /* renamed from: d  reason: collision with root package name */
    public int f6154d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f6155e;

    /* renamed from: f  reason: collision with root package name */
    public int f6156f;

    public LivenessCircleProgressView(@NonNull Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f6156f = 12;
        Paint paint = new Paint();
        this.f6151a = paint;
        paint.setColor(Color.argb(127, 255, 255, 255));
        this.f6151a.setAntiAlias(true);
        this.f6151a.setStrokeWidth(this.f6156f);
        this.f6151a.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f6152b = paint2;
        paint2.setColor(Color.argb(255, 255, 255, 255));
        this.f6152b.setAntiAlias(true);
        this.f6152b.setStrokeWidth(this.f6156f);
        this.f6152b.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint();
        this.f6153c = paint3;
        paint3.setColor(Color.rgb(255, 255, 255));
        this.f6153c.setAntiAlias(true);
        this.f6153c.setTextSize(getResources().getDimensionPixelSize(R.dimen.rim_text_size_20));
        this.f6153c.setTextAlign(Paint.Align.CENTER);
        this.f6155e = new RectF();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - (this.f6156f / 2), this.f6151a);
        RectF rectF = this.f6155e;
        int i2 = this.f6156f;
        rectF.left = i2 / 2;
        rectF.top = i2 / 2;
        rectF.right = getWidth() - (this.f6156f / 2);
        this.f6155e.bottom = getHeight() - (this.f6156f / 2);
        canvas.drawArc(this.f6155e, -90.0f, (this.f6154d / 100.0f) * 360.0f, false, this.f6152b);
        canvas.drawText(this.f6154d + "%", getWidth() / 2, getHeight() / 2, this.f6153c);
    }

    public void updateProgress(int i2) {
        this.f6154d = i2;
        invalidate();
    }

    public LivenessCircleProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
