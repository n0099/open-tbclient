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
import d.a.y.a.i;
/* loaded from: classes2.dex */
public class RoundWebview extends SapiWebView {

    /* renamed from: a  reason: collision with root package name */
    public float f10925a;

    /* renamed from: b  reason: collision with root package name */
    public float f10926b;

    /* renamed from: c  reason: collision with root package name */
    public float f10927c;

    /* renamed from: d  reason: collision with root package name */
    public float f10928d;

    /* renamed from: e  reason: collision with root package name */
    public int f10929e;

    /* renamed from: f  reason: collision with root package name */
    public int f10930f;

    /* renamed from: g  reason: collision with root package name */
    public int f10931g;

    /* renamed from: h  reason: collision with root package name */
    public int f10932h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f10933i;
    public Paint j;
    public float[] k;

    public RoundWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10925a = 0.0f;
        this.f10926b = 0.0f;
        this.f10927c = 0.0f;
        this.f10928d = 0.0f;
        this.k = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        Paint paint = new Paint();
        this.f10933i = paint;
        paint.setColor(-1);
        this.f10933i.setAntiAlias(true);
        this.f10933i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.j = paint2;
        paint2.setXfermode(null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.sapi_sdk_RoundWebview);
        this.f10925a = obtainStyledAttributes.getDimension(i.sapi_sdk_RoundWebview_sapi_sdk_top_left, 0.0f);
        this.f10926b = obtainStyledAttributes.getDimension(i.sapi_sdk_RoundWebview_sapi_sdk_top_right, 0.0f);
        this.f10927c = obtainStyledAttributes.getDimension(i.sapi_sdk_RoundWebview_sapi_sdk_bottom_left, 0.0f);
        float dimension = obtainStyledAttributes.getDimension(i.sapi_sdk_RoundWebview_sapi_sdk_bottom_right, 0.0f);
        this.f10928d = dimension;
        a(this.f10925a, this.f10926b, dimension, this.f10927c);
    }

    @Override // com.baidu.sapi2.SapiWebView, android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        this.f10931g = getScrollX();
        this.f10932h = getScrollY();
        Path path = new Path();
        int i2 = this.f10932h;
        path.addRoundRect(new RectF(0.0f, i2, this.f10931g + this.f10929e, i2 + this.f10930f), this.k, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f10929e = getMeasuredWidth();
        this.f10930f = getMeasuredHeight();
    }

    public RoundWebview(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f10925a = 0.0f;
        this.f10926b = 0.0f;
        this.f10927c = 0.0f;
        this.f10928d = 0.0f;
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
