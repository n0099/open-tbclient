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
import d.a.a0.a.i;
/* loaded from: classes2.dex */
public class RoundWebview extends SapiWebView {

    /* renamed from: a  reason: collision with root package name */
    public float f9924a;

    /* renamed from: b  reason: collision with root package name */
    public float f9925b;

    /* renamed from: c  reason: collision with root package name */
    public float f9926c;

    /* renamed from: d  reason: collision with root package name */
    public float f9927d;

    /* renamed from: e  reason: collision with root package name */
    public int f9928e;

    /* renamed from: f  reason: collision with root package name */
    public int f9929f;

    /* renamed from: g  reason: collision with root package name */
    public int f9930g;

    /* renamed from: h  reason: collision with root package name */
    public int f9931h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f9932i;
    public Paint j;
    public float[] k;

    public RoundWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9924a = 0.0f;
        this.f9925b = 0.0f;
        this.f9926c = 0.0f;
        this.f9927d = 0.0f;
        this.k = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        Paint paint = new Paint();
        this.f9932i = paint;
        paint.setColor(-1);
        this.f9932i.setAntiAlias(true);
        this.f9932i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.j = paint2;
        paint2.setXfermode(null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.sapi_sdk_RoundWebview);
        this.f9924a = obtainStyledAttributes.getDimension(i.sapi_sdk_RoundWebview_sapi_sdk_top_left, 0.0f);
        this.f9925b = obtainStyledAttributes.getDimension(i.sapi_sdk_RoundWebview_sapi_sdk_top_right, 0.0f);
        this.f9926c = obtainStyledAttributes.getDimension(i.sapi_sdk_RoundWebview_sapi_sdk_bottom_left, 0.0f);
        float dimension = obtainStyledAttributes.getDimension(i.sapi_sdk_RoundWebview_sapi_sdk_bottom_right, 0.0f);
        this.f9927d = dimension;
        a(this.f9924a, this.f9925b, dimension, this.f9926c);
    }

    @Override // com.baidu.sapi2.SapiWebView, android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        this.f9930g = getScrollX();
        this.f9931h = getScrollY();
        Path path = new Path();
        int i2 = this.f9931h;
        path.addRoundRect(new RectF(0.0f, i2, this.f9930g + this.f9928e, i2 + this.f9929f), this.k, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f9928e = getMeasuredWidth();
        this.f9929f = getMeasuredHeight();
    }

    public RoundWebview(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9924a = 0.0f;
        this.f9925b = 0.0f;
        this.f9926c = 0.0f;
        this.f9927d = 0.0f;
        this.k = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        a(context, attributeSet);
    }

    public void a(float f2, float f3, float f4, float f5) {
        float[] fArr = this.k;
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
