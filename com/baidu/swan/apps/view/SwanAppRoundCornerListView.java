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
import d.a.h0.a.i2.h0;
/* loaded from: classes3.dex */
public class SwanAppRoundCornerListView extends ListView {
    public static final float j = h0.g(11.0f);

    /* renamed from: e  reason: collision with root package name */
    public final Path f12236e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f12237f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f12238g;

    /* renamed from: h  reason: collision with root package name */
    public float[] f12239h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuffXfermode f12240i;

    public SwanAppRoundCornerListView(Context context) {
        super(context);
        this.f12236e = new Path();
        this.f12237f = new Paint(1);
        this.f12238g = new RectF();
        float f2 = j;
        this.f12239h = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.save();
        this.f12237f.setColor(-1);
        this.f12237f.setXfermode(this.f12240i);
        canvas.drawPath(this.f12236e, this.f12237f);
        this.f12237f.setXfermode(null);
        canvas.restore();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f12238g.set(0.0f, 0.0f, i2, i3 + 1);
        this.f12236e.reset();
        this.f12236e.addRoundRect(this.f12238g, this.f12239h, Path.Direction.CW);
        this.f12240i = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    public void setListViewRadius(float f2, float f3, float f4, float f5) {
        setListViewRadius(new float[]{f2, f2, f3, f3, f4, f4, f5, f5});
    }

    public void setListViewRadius(@NonNull float[] fArr) {
        if (fArr.length >= 8) {
            this.f12239h = new float[8];
            for (int i2 = 0; i2 < 8; i2++) {
                this.f12239h[i2] = fArr[i2];
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException("radii[] needs 8 values");
    }

    public SwanAppRoundCornerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12236e = new Path();
        this.f12237f = new Paint(1);
        this.f12238g = new RectF();
        float f2 = j;
        this.f12239h = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public SwanAppRoundCornerListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12236e = new Path();
        this.f12237f = new Paint(1);
        this.f12238g = new RectF();
        float f2 = j;
        this.f12239h = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
    }
}
