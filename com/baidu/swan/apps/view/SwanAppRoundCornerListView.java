package com.baidu.swan.apps.view;

import android.annotation.SuppressLint;
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
import com.baidu.tieba.am1;
import com.baidu.tieba.gj3;
/* loaded from: classes4.dex */
public class SwanAppRoundCornerListView extends ListView {
    public static final boolean f = am1.a;
    public static final float g = gj3.h(11.0f);
    public final Path a;
    public final Paint b;
    public final RectF c;
    public float[] d;
    public PorterDuffXfermode e;

    public SwanAppRoundCornerListView(Context context) {
        super(context);
        this.a = new Path();
        this.b = new Paint(1);
        this.c = new RectF();
        float f2 = g;
        this.d = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public SwanAppRoundCornerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Path();
        this.b = new Paint(1);
        this.c = new RectF();
        float f2 = g;
        this.d = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public SwanAppRoundCornerListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Path();
        this.b = new Paint(1);
        this.c = new RectF();
        float f2 = g;
        this.d = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.save();
        this.b.setColor(-1);
        this.b.setXfermode(this.e);
        canvas.drawPath(this.a, this.b);
        this.b.setXfermode(null);
        canvas.restore();
    }

    @SuppressLint({"BDThrowableCheck"})
    public void setListViewRadius(@NonNull float[] fArr) {
        if (fArr.length < 8) {
            if (!f) {
                return;
            }
            throw new IllegalStateException("radii[] needs 8 values");
        }
        this.d = new float[8];
        for (int i = 0; i < 8; i++) {
            this.d[i] = fArr[i];
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c.set(0.0f, 0.0f, i, i2 + 1);
        this.a.reset();
        this.a.addRoundRect(this.c, this.d, Path.Direction.CW);
        this.e = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    public void setListViewRadius(float f2, float f3, float f4, float f5) {
        setListViewRadius(new float[]{f2, f2, f3, f3, f4, f4, f5, f5});
    }
}
