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
    public int f13458e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f13459f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f13460g;

    public PublishProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13458e = 0;
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        this.f13459f = new Paint(1);
        this.f13460g = new Rect();
        b();
    }

    public void b() {
        int color = SkinManager.getColor(R.color.CAM_X0302);
        setBackgroundColor(color);
        getBackground().setAlpha(168);
        this.f13459f.setColor(color);
        this.f13459f.setAlpha(168);
        postInvalidate();
    }

    public int c(int i) {
        if (i < 0) {
            return 0;
        }
        if (i > 100) {
            return 100;
        }
        int i2 = this.f13458e;
        if (i == i2) {
            return i2;
        }
        this.f13458e = i;
        postInvalidate();
        return this.f13458e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f13460g.set(0, 0, (int) (getWidth() * (this.f13458e / 100.0f)), getHeight());
        canvas.drawRect(this.f13460g, this.f13459f);
    }

    public PublishProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13458e = 0;
        a(context, attributeSet);
    }
}
