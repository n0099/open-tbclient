package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class FragmentTabSwellingView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f12987e;

    /* renamed from: f  reason: collision with root package name */
    public Path f12988f;

    /* renamed from: g  reason: collision with root package name */
    public Path f12989g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f12990h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    public FragmentTabSwellingView(Context context) {
        this(context, null);
    }

    public final void a() {
        e();
        c();
        d();
        setLayerType(1, null);
    }

    public void b(int i) {
        if (i != 1 && i != 4) {
            this.f12987e.setColor(SkinManager.getColor(R.color.CAM_X0205));
            this.f12990h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
        } else {
            this.f12987e.setColor(SkinManager.getColor(R.color.CAM_X0206_1));
            this.f12990h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        }
        invalidate();
    }

    public final void c() {
        Paint paint = new Paint();
        this.f12987e = paint;
        paint.setColor(SkinManager.getColor(R.color.CAM_X0205));
        this.f12987e.setAntiAlias(true);
        this.f12987e.setStrokeWidth(1.0f);
        this.f12987e.setDither(true);
        this.f12987e.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f12990h = paint2;
        paint2.setAntiAlias(true);
        this.f12990h.setDither(true);
        this.f12990h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
    }

    public final void d() {
        this.f12988f = new Path();
        this.f12989g = new Path();
    }

    public final void e() {
        this.i = l.g(getContext().getApplicationContext(), R.dimen.tbds137);
        this.j = l.g(getContext().getApplicationContext(), R.dimen.tbds204);
        this.k = l.g(getContext().getApplicationContext(), R.dimen.tbds23);
        this.l = l.g(getContext().getApplicationContext(), R.dimen.tbds51);
        this.m = l.g(getContext().getApplicationContext(), R.dimen.tbds16);
        this.n = l.g(getContext().getApplicationContext(), R.dimen.tbds52);
        this.o = l.g(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() > l.k(getContext())) {
            return;
        }
        this.f12989g.reset();
        this.f12988f.reset();
        this.f12988f.moveTo(0.0f, getHeight() - this.i);
        this.f12988f.lineTo((getWidth() / 2) - (this.j / 2), getHeight() - this.i);
        this.f12988f.quadTo(((getWidth() / 2) - (this.j / 2)) + this.k, getHeight() - this.i, ((getWidth() / 2) - (this.j / 2)) + this.l, (getHeight() - this.i) - this.m);
        this.f12988f.quadTo(getWidth() / 2, (getHeight() - this.i) - this.n, ((getWidth() / 2) + (this.j / 2)) - this.l, (getHeight() - this.i) - this.m);
        this.f12988f.quadTo(((getWidth() / 2) + (this.j / 2)) - this.k, getHeight() - this.i, (getWidth() / 2) + (this.j / 2), getHeight() - this.i);
        this.f12988f.lineTo(getWidth(), getHeight() - this.i);
        this.f12988f.lineTo(getWidth(), getHeight());
        this.f12988f.lineTo(0.0f, getHeight());
        this.f12988f.close();
        this.f12989g.moveTo(0.0f, (getHeight() - this.i) + this.o);
        this.f12989g.lineTo((getWidth() / 2) - (this.j / 2), (getHeight() - this.i) + this.o);
        this.f12989g.quadTo(((getWidth() / 2) - (this.j / 2)) + this.k, (getHeight() - this.i) + this.o, ((getWidth() / 2) - (this.j / 2)) + this.l, ((getHeight() - this.i) - this.m) + this.o);
        this.f12989g.quadTo(getWidth() / 2, ((getHeight() - this.i) - this.n) + this.o, ((getWidth() / 2) + (this.j / 2)) - this.l, ((getHeight() - this.i) - this.m) + this.o);
        this.f12989g.quadTo(((getWidth() / 2) + (this.j / 2)) - this.k, (getHeight() - this.i) + this.o, (getWidth() / 2) + (this.j / 2), (getHeight() - this.i) + this.o);
        this.f12989g.lineTo(getWidth(), (getHeight() - this.i) + this.o);
        this.f12989g.lineTo(getWidth(), getHeight());
        this.f12989g.lineTo(0.0f, getHeight());
        this.f12989g.close();
        canvas.drawPath(this.f12989g, this.f12990h);
        canvas.drawPath(this.f12988f, this.f12987e);
    }

    public FragmentTabSwellingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FragmentTabSwellingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
