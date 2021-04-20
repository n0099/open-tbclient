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
    public Paint f6122a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f6123b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f6124c;

    /* renamed from: d  reason: collision with root package name */
    public int f6125d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f6126e;

    /* renamed from: f  reason: collision with root package name */
    public int f6127f;

    public LivenessCircleProgressView(@NonNull Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f6127f = 12;
        Paint paint = new Paint();
        this.f6122a = paint;
        paint.setColor(Color.argb(127, 255, 255, 255));
        this.f6122a.setAntiAlias(true);
        this.f6122a.setStrokeWidth(this.f6127f);
        this.f6122a.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f6123b = paint2;
        paint2.setColor(Color.argb(255, 255, 255, 255));
        this.f6123b.setAntiAlias(true);
        this.f6123b.setStrokeWidth(this.f6127f);
        this.f6123b.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint();
        this.f6124c = paint3;
        paint3.setColor(Color.rgb(255, 255, 255));
        this.f6124c.setAntiAlias(true);
        this.f6124c.setTextSize(getResources().getDimensionPixelSize(R.dimen.rim_text_size_20));
        this.f6124c.setTextAlign(Paint.Align.CENTER);
        this.f6126e = new RectF();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - (this.f6127f / 2), this.f6122a);
        RectF rectF = this.f6126e;
        int i = this.f6127f;
        rectF.left = i / 2;
        rectF.top = i / 2;
        rectF.right = getWidth() - (this.f6127f / 2);
        this.f6126e.bottom = getHeight() - (this.f6127f / 2);
        canvas.drawArc(this.f6126e, -90.0f, (this.f6125d / 100.0f) * 360.0f, false, this.f6123b);
        canvas.drawText(this.f6125d + "%", getWidth() / 2, getHeight() / 2, this.f6124c);
    }

    public void updateProgress(int i) {
        this.f6125d = i;
        invalidate();
    }

    public LivenessCircleProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
