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
    public static final boolean j = k.f46875a;
    public static final float k = n0.h(11.0f);

    /* renamed from: e  reason: collision with root package name */
    public final Path f11411e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f11412f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f11413g;

    /* renamed from: h  reason: collision with root package name */
    public float[] f11414h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuffXfermode f11415i;

    public SwanAppRoundCornerListView(Context context) {
        super(context);
        this.f11411e = new Path();
        this.f11412f = new Paint(1);
        this.f11413g = new RectF();
        float f2 = k;
        this.f11414h = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.save();
        this.f11412f.setColor(-1);
        this.f11412f.setXfermode(this.f11415i);
        canvas.drawPath(this.f11411e, this.f11412f);
        this.f11412f.setXfermode(null);
        canvas.restore();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f11413g.set(0.0f, 0.0f, i2, i3 + 1);
        this.f11411e.reset();
        this.f11411e.addRoundRect(this.f11413g, this.f11414h, Path.Direction.CW);
        this.f11415i = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
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
        this.f11414h = new float[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.f11414h[i2] = fArr[i2];
        }
    }

    public SwanAppRoundCornerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11411e = new Path();
        this.f11412f = new Paint(1);
        this.f11413g = new RectF();
        float f2 = k;
        this.f11414h = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public SwanAppRoundCornerListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11411e = new Path();
        this.f11412f = new Paint(1);
        this.f11413g = new RectF();
        float f2 = k;
        this.f11414h = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
    }
}
