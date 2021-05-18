package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class PublishProgressBar extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f12405e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f12406f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f12407g;

    public PublishProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12405e = 0;
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        this.f12406f = new Paint(1);
        this.f12407g = new Rect();
        b();
    }

    public void b() {
        int color = SkinManager.getColor(R.color.CAM_X0302);
        setBackgroundColor(color);
        getBackground().setAlpha(168);
        this.f12406f.setColor(color);
        this.f12406f.setAlpha(168);
        postInvalidate();
    }

    public int c(int i2) {
        if (i2 < 0) {
            return 0;
        }
        if (i2 > 100) {
            return 100;
        }
        int i3 = this.f12405e;
        if (i2 == i3) {
            return i3;
        }
        this.f12405e = i2;
        postInvalidate();
        return this.f12405e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f12407g.set(0, 0, (int) (getWidth() * (this.f12405e / 100.0f)), getHeight());
        canvas.drawRect(this.f12407g, this.f12406f);
    }

    public PublishProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12405e = 0;
        a(context, attributeSet);
    }
}
