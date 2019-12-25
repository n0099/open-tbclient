package com.baidu.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.q.a;
import com.baidu.live.view.c;
/* loaded from: classes2.dex */
public class b extends c {
    private int azk;
    private int azl;

    public b(Context context, AlaLiveMarkData alaLiveMarkData, int i, boolean z, c.a aVar) {
        this(context, alaLiveMarkData, i, z, 1.0f, aVar);
    }

    public b(Context context, AlaLiveMarkData alaLiveMarkData, int i, boolean z, float f, c.a aVar) {
        super(context, alaLiveMarkData, z, f, aVar);
        this.azk = i;
        this.azl = (int) (context.getResources().getDimensionPixelSize(a.e.sdk_tbfontsize22) * f);
    }

    @Override // com.baidu.live.view.c, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable cachedDrawable = getCachedDrawable();
        if (cachedDrawable != null) {
            canvas.save();
            canvas.translate(f, (((i5 - i3) - cachedDrawable.getBounds().bottom) / 2) + i3);
            cachedDrawable.draw(canvas);
            if (this.azu) {
                b(canvas, cachedDrawable);
            }
            canvas.restore();
        }
    }

    private void b(Canvas canvas, Drawable drawable) {
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setTextSize(this.azl);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        canvas.drawText(this.azk + "", drawable.getBounds().right / 2, (int) (((drawable.getBounds().bottom / 2) - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), paint);
    }
}
