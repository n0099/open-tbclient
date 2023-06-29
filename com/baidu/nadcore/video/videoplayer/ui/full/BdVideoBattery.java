package com.baidu.nadcore.video.videoplayer.ui.full;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.a21;
import com.baidu.tieba.q71;
/* loaded from: classes3.dex */
public class BdVideoBattery extends View {
    public static final int d = q71.d(2.0f);
    public static final int e = q71.d(2.0f);
    public static final int f = q71.d(2.0f);
    public static final int g = q71.d(4.0f);
    public final Context a;
    public Bitmap b;
    public Paint c;

    public final void a() {
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(-1);
    }

    public BdVideoBattery(Context context) {
        super(context);
        this.a = context;
        a();
    }

    public void setImage(int i) {
        this.b = BitmapFactory.decodeResource(this.a.getResources(), i);
    }

    public BdVideoBattery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        a();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        setMeasuredDimension(this.b.getWidth(), this.b.getHeight());
    }

    public BdVideoBattery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        a();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Bitmap bitmap = this.b;
        float f2 = 0.0f;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
        float f3 = (float) (a21.a / 100.0d);
        if (f3 >= 0.0f) {
            if (f3 > 100.0f) {
                f2 = 100.0f;
            } else {
                f2 = f3;
            }
        }
        int i = measuredWidth - g;
        int i2 = f;
        canvas.drawRect(i2, d, i2 + ((i - i2) * f2), measuredHeight - e, this.c);
    }
}
