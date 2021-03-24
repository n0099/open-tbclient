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
    public Paint f6086a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f6087b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f6088c;

    /* renamed from: d  reason: collision with root package name */
    public int f6089d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f6090e;

    /* renamed from: f  reason: collision with root package name */
    public int f6091f;

    public LivenessCircleProgressView(@NonNull Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f6091f = 12;
        Paint paint = new Paint();
        this.f6086a = paint;
        paint.setColor(Color.argb(127, 255, 255, 255));
        this.f6086a.setAntiAlias(true);
        this.f6086a.setStrokeWidth(this.f6091f);
        this.f6086a.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f6087b = paint2;
        paint2.setColor(Color.argb(255, 255, 255, 255));
        this.f6087b.setAntiAlias(true);
        this.f6087b.setStrokeWidth(this.f6091f);
        this.f6087b.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint();
        this.f6088c = paint3;
        paint3.setColor(Color.rgb(255, 255, 255));
        this.f6088c.setAntiAlias(true);
        this.f6088c.setTextSize(getResources().getDimensionPixelSize(R.dimen.rim_text_size_20));
        this.f6088c.setTextAlign(Paint.Align.CENTER);
        this.f6090e = new RectF();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - (this.f6091f / 2), this.f6086a);
        RectF rectF = this.f6090e;
        int i = this.f6091f;
        rectF.left = i / 2;
        rectF.top = i / 2;
        rectF.right = getWidth() - (this.f6091f / 2);
        this.f6090e.bottom = getHeight() - (this.f6091f / 2);
        canvas.drawArc(this.f6090e, -90.0f, (this.f6089d / 100.0f) * 360.0f, false, this.f6087b);
        canvas.drawText(this.f6089d + "%", getWidth() / 2, getHeight() / 2, this.f6088c);
    }

    public void updateProgress(int i) {
        this.f6089d = i;
        invalidate();
    }

    public LivenessCircleProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
