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
import com.thunder.livesdk.system.ThunderNetStateService;
/* loaded from: classes5.dex */
public class LivenessCircleProgressView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Paint f2340a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f2341b;
    private Paint c;
    private int d;
    private RectF e;
    private int f;

    public LivenessCircleProgressView(@NonNull Context context) {
        super(context);
        a();
    }

    public LivenessCircleProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        this.f = 12;
        this.f2340a = new Paint();
        this.f2340a.setColor(Color.argb((int) ThunderNetStateService.NetState.SYSNET_UNKNOWN, 255, 255, 255));
        this.f2340a.setAntiAlias(true);
        this.f2340a.setStrokeWidth(this.f);
        this.f2340a.setStyle(Paint.Style.STROKE);
        this.f2341b = new Paint();
        this.f2341b.setColor(Color.argb(255, 255, 255, 255));
        this.f2341b.setAntiAlias(true);
        this.f2341b.setStrokeWidth(this.f);
        this.f2341b.setStyle(Paint.Style.STROKE);
        this.c = new Paint();
        this.c.setColor(Color.rgb(255, 255, 255));
        this.c.setAntiAlias(true);
        this.c.setTextSize(getResources().getDimensionPixelSize(R.dimen.rim_text_size_20));
        this.c.setTextAlign(Paint.Align.CENTER);
        this.e = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - (this.f / 2), this.f2340a);
        this.e.left = this.f / 2;
        this.e.top = this.f / 2;
        this.e.right = getWidth() - (this.f / 2);
        this.e.bottom = getHeight() - (this.f / 2);
        canvas.drawArc(this.e, -90.0f, 360.0f * (this.d / 100.0f), false, this.f2341b);
        canvas.drawText(this.d + "%", getWidth() / 2, getHeight() / 2, this.c);
    }

    public void updateProgress(int i) {
        this.d = i;
        invalidate();
    }
}
