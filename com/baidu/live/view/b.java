package com.baidu.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.u.a;
import com.baidu.live.view.c;
/* loaded from: classes3.dex */
public class b extends c {
    private int bhJ;
    private int mLevel;

    public b(Context context, AlaLiveMarkData alaLiveMarkData, int i, boolean z, c.a aVar) {
        this(context, alaLiveMarkData, i, z, 1.0f, aVar);
    }

    public b(Context context, AlaLiveMarkData alaLiveMarkData, int i, boolean z, float f, c.a aVar) {
        super(context, alaLiveMarkData, z, f, aVar);
        this.mLevel = i;
        this.bhJ = (int) (context.getResources().getDimensionPixelSize(a.e.sdk_tbfontsize22) * f);
    }

    @Override // com.baidu.live.view.c, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable cachedDrawable = getCachedDrawable();
        if (cachedDrawable != null) {
            canvas.save();
            canvas.translate(f, (((i5 - i3) - cachedDrawable.getBounds().bottom) / 2) + i3);
            cachedDrawable.draw(canvas);
            if (this.bhT) {
                b(canvas, cachedDrawable);
            }
            canvas.restore();
        }
    }

    private void b(Canvas canvas, Drawable drawable) {
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setTextSize(this.bhJ);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        canvas.drawText(this.mLevel + "", drawable.getBounds().right / 2, (int) (((drawable.getBounds().bottom / 2) - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), paint);
    }
}
