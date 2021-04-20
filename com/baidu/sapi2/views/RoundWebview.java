package com.baidu.sapi2.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.baidu.sapi2.SapiWebView;
import d.b.x.a.i;
/* loaded from: classes2.dex */
public class RoundWebview extends SapiWebView {
    public float i0;
    public float j0;
    public float k0;
    public float l0;
    public int m0;
    public int n0;
    public int o0;
    public int p0;
    public Paint q0;
    public Paint r0;
    public float[] s0;

    public RoundWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i0 = 0.0f;
        this.j0 = 0.0f;
        this.k0 = 0.0f;
        this.l0 = 0.0f;
        this.s0 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        Paint paint = new Paint();
        this.q0 = paint;
        paint.setColor(-1);
        this.q0.setAntiAlias(true);
        this.q0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.r0 = paint2;
        paint2.setXfermode(null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.sapi_sdk_RoundWebview);
        this.i0 = obtainStyledAttributes.getDimension(i.sapi_sdk_RoundWebview_sapi_sdk_top_left, 0.0f);
        this.j0 = obtainStyledAttributes.getDimension(i.sapi_sdk_RoundWebview_sapi_sdk_top_right, 0.0f);
        this.k0 = obtainStyledAttributes.getDimension(i.sapi_sdk_RoundWebview_sapi_sdk_bottom_left, 0.0f);
        float dimension = obtainStyledAttributes.getDimension(i.sapi_sdk_RoundWebview_sapi_sdk_bottom_right, 0.0f);
        this.l0 = dimension;
        a(this.i0, this.j0, dimension, this.k0);
    }

    @Override // com.baidu.sapi2.SapiWebView, android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        this.o0 = getScrollX();
        this.p0 = getScrollY();
        Path path = new Path();
        int i = this.p0;
        path.addRoundRect(new RectF(0.0f, i, this.o0 + this.m0, i + this.n0), this.s0, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.m0 = getMeasuredWidth();
        this.n0 = getMeasuredHeight();
    }

    public RoundWebview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i0 = 0.0f;
        this.j0 = 0.0f;
        this.k0 = 0.0f;
        this.l0 = 0.0f;
        this.s0 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        a(context, attributeSet);
    }

    public void a(float f2, float f3, float f4, float f5) {
        float[] fArr = this.s0;
        fArr[0] = f2;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f3;
        fArr[4] = f4;
        fArr[5] = f4;
        fArr[6] = f5;
        fArr[7] = f5;
    }
}
