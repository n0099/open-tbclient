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
    public Paint f12979e;

    /* renamed from: f  reason: collision with root package name */
    public Path f12980f;

    /* renamed from: g  reason: collision with root package name */
    public Path f12981g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f12982h;
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
            this.f12979e.setColor(SkinManager.getColor(R.color.CAM_X0205));
            this.f12982h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
        } else {
            this.f12979e.setColor(SkinManager.getColor(R.color.CAM_X0206_1));
            this.f12982h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        }
        invalidate();
    }

    public final void c() {
        Paint paint = new Paint();
        this.f12979e = paint;
        paint.setColor(SkinManager.getColor(R.color.CAM_X0205));
        this.f12979e.setAntiAlias(true);
        this.f12979e.setStrokeWidth(1.0f);
        this.f12979e.setDither(true);
        this.f12979e.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f12982h = paint2;
        paint2.setAntiAlias(true);
        this.f12982h.setDither(true);
        this.f12982h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
    }

    public final void d() {
        this.f12980f = new Path();
        this.f12981g = new Path();
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
        this.f12981g.reset();
        this.f12980f.reset();
        this.f12980f.moveTo(0.0f, getHeight() - this.i);
        this.f12980f.lineTo((getWidth() / 2) - (this.j / 2), getHeight() - this.i);
        this.f12980f.quadTo(((getWidth() / 2) - (this.j / 2)) + this.k, getHeight() - this.i, ((getWidth() / 2) - (this.j / 2)) + this.l, (getHeight() - this.i) - this.m);
        this.f12980f.quadTo(getWidth() / 2, (getHeight() - this.i) - this.n, ((getWidth() / 2) + (this.j / 2)) - this.l, (getHeight() - this.i) - this.m);
        this.f12980f.quadTo(((getWidth() / 2) + (this.j / 2)) - this.k, getHeight() - this.i, (getWidth() / 2) + (this.j / 2), getHeight() - this.i);
        this.f12980f.lineTo(getWidth(), getHeight() - this.i);
        this.f12980f.lineTo(getWidth(), getHeight());
        this.f12980f.lineTo(0.0f, getHeight());
        this.f12980f.close();
        this.f12981g.moveTo(0.0f, (getHeight() - this.i) + this.o);
        this.f12981g.lineTo((getWidth() / 2) - (this.j / 2), (getHeight() - this.i) + this.o);
        this.f12981g.quadTo(((getWidth() / 2) - (this.j / 2)) + this.k, (getHeight() - this.i) + this.o, ((getWidth() / 2) - (this.j / 2)) + this.l, ((getHeight() - this.i) - this.m) + this.o);
        this.f12981g.quadTo(getWidth() / 2, ((getHeight() - this.i) - this.n) + this.o, ((getWidth() / 2) + (this.j / 2)) - this.l, ((getHeight() - this.i) - this.m) + this.o);
        this.f12981g.quadTo(((getWidth() / 2) + (this.j / 2)) - this.k, (getHeight() - this.i) + this.o, (getWidth() / 2) + (this.j / 2), (getHeight() - this.i) + this.o);
        this.f12981g.lineTo(getWidth(), (getHeight() - this.i) + this.o);
        this.f12981g.lineTo(getWidth(), getHeight());
        this.f12981g.lineTo(0.0f, getHeight());
        this.f12981g.close();
        canvas.drawPath(this.f12981g, this.f12982h);
        canvas.drawPath(this.f12980f, this.f12979e);
    }

    public FragmentTabSwellingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FragmentTabSwellingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
