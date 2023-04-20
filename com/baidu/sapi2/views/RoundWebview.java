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
import com.baidu.tieba.le1;
/* loaded from: classes2.dex */
public class RoundWebview extends SapiWebView {
    public float a;
    public float b;
    public float c;
    public float d;
    public int e;
    public int f;
    public int g;
    public int h;
    public Paint i;
    public Paint j;
    public float[] k;

    public RoundWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.k = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        a(context, attributeSet);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.e = getMeasuredWidth();
        this.f = getMeasuredHeight();
    }

    public RoundWebview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.k = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        Paint paint = new Paint();
        this.i = paint;
        paint.setColor(-1);
        this.i.setAntiAlias(true);
        this.i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.j = paint2;
        paint2.setXfermode(null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, le1.sapi_sdk_RoundWebview);
        this.a = obtainStyledAttributes.getDimension(2, 0.0f);
        this.b = obtainStyledAttributes.getDimension(3, 0.0f);
        this.c = obtainStyledAttributes.getDimension(0, 0.0f);
        float dimension = obtainStyledAttributes.getDimension(1, 0.0f);
        this.d = dimension;
        a(this.a, this.b, dimension, this.c);
    }

    public void a(float f, float f2, float f3, float f4) {
        float[] fArr = this.k;
        fArr[0] = f;
        fArr[1] = f;
        fArr[2] = f2;
        fArr[3] = f2;
        fArr[4] = f3;
        fArr[5] = f3;
        fArr[6] = f4;
        fArr[7] = f4;
    }

    @Override // com.baidu.sapi2.SapiWebView, android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        this.g = getScrollX();
        this.h = getScrollY();
        Path path = new Path();
        int i = this.h;
        path.addRoundRect(new RectF(0.0f, i, this.g + this.e, i + this.f), this.k, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
