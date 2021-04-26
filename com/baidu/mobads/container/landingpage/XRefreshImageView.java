package com.baidu.mobads.container.landingpage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes2.dex */
public class XRefreshImageView extends ImageView {
    public final Context context;
    public final Paint paint;
    public RectF rect2;
    public int startAngle;

    public XRefreshImageView(Context context) {
        super(context);
        this.startAngle = 0;
        this.rect2 = new RectF();
        this.context = context;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    public static int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int dip2px = dip2px(this.context, 15.0f);
        int dip2px2 = dip2px(this.context, 4.0f);
        RectF rectF = this.rect2;
        int i2 = dip2px + 1 + (dip2px2 / 2);
        float f2 = width - i2;
        rectF.left = f2;
        rectF.top = f2;
        float f3 = width + i2;
        rectF.right = f3;
        rectF.bottom = f3;
        this.paint.setColor(-1907998);
        this.paint.setStrokeWidth(dip2px2);
        canvas.drawArc(this.rect2, this.startAngle + 0, 72.0f, false, this.paint);
        this.paint.setColor(-1594427658);
        canvas.drawArc(this.rect2, this.startAngle + 72, 270.0f, false, this.paint);
        int i3 = this.startAngle + 10;
        this.startAngle = i3;
        if (i3 >= 360) {
            this.startAngle = 0;
        }
        super.onDraw(canvas);
        invalidate();
    }
}
