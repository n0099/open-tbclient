package com.baidu.swan.apps.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ListView;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
import d.a.l0.a.v2.n0;
/* loaded from: classes3.dex */
public class SwanAppRoundCornerListView extends ListView {
    public static final boolean j = k.f43199a;
    public static final float k = n0.h(11.0f);

    /* renamed from: e  reason: collision with root package name */
    public final Path f11349e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f11350f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f11351g;

    /* renamed from: h  reason: collision with root package name */
    public float[] f11352h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuffXfermode f11353i;

    public SwanAppRoundCornerListView(Context context) {
        super(context);
        this.f11349e = new Path();
        this.f11350f = new Paint(1);
        this.f11351g = new RectF();
        float f2 = k;
        this.f11352h = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.save();
        this.f11350f.setColor(-1);
        this.f11350f.setXfermode(this.f11353i);
        canvas.drawPath(this.f11349e, this.f11350f);
        this.f11350f.setXfermode(null);
        canvas.restore();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f11351g.set(0.0f, 0.0f, i2, i3 + 1);
        this.f11349e.reset();
        this.f11349e.addRoundRect(this.f11351g, this.f11352h, Path.Direction.CW);
        this.f11353i = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    public void setListViewRadius(float f2, float f3, float f4, float f5) {
        setListViewRadius(new float[]{f2, f2, f3, f3, f4, f4, f5, f5});
    }

    public void setListViewRadius(@NonNull float[] fArr) {
        if (fArr.length < 8) {
            if (j) {
                throw new IllegalStateException("radii[] needs 8 values");
            }
            return;
        }
        this.f11352h = new float[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.f11352h[i2] = fArr[i2];
        }
    }

    public SwanAppRoundCornerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11349e = new Path();
        this.f11350f = new Paint(1);
        this.f11351g = new RectF();
        float f2 = k;
        this.f11352h = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public SwanAppRoundCornerListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11349e = new Path();
        this.f11350f = new Paint(1);
        this.f11351g = new RectF();
        float f2 = k;
        this.f11352h = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
    }
}
