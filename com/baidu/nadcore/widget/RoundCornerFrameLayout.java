package com.baidu.nadcore.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tieba.ab1;
/* loaded from: classes2.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    public Path a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;

    public RoundCornerFrameLayout(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f) {
            c();
            canvas.clipPath(this.a);
        }
        super.onDraw(canvas);
    }

    public void setCornerRadius(int i) {
        boolean z;
        if (this.b != i) {
            this.b = i;
        }
        if (this.b > 0) {
            z = true;
        } else {
            z = false;
        }
        this.f = z;
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = false;
        d(context, attributeSet, i);
        e();
    }

    public final void d(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ab1.RoundCornerRelativeLayout);
        int dimension = (int) obtainStyledAttributes.getDimension(0, 0.0f);
        if (dimension > 0) {
            setCornerRadius(dimension);
        }
        obtainStyledAttributes.recycle();
    }

    public final boolean c() {
        if (getWidth() == this.d && getHeight() == this.e && this.c == this.b) {
            return false;
        }
        this.d = getWidth();
        this.e = getHeight();
        this.c = this.b;
        if (this.a == null) {
            Path path = new Path();
            this.a = path;
            path.setFillType(Path.FillType.EVEN_ODD);
        }
        Path path2 = this.a;
        RectF rectF = new RectF(0.0f, 0.0f, this.d, this.e);
        int i = this.b;
        path2.addRoundRect(rectF, i, i, Path.Direction.CW);
        return true;
    }

    public final void e() {
        Path path = new Path();
        this.a = path;
        path.setFillType(Path.FillType.EVEN_ODD);
    }
}
