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
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class FragmentTabSwellingView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f12248e;

    /* renamed from: f  reason: collision with root package name */
    public Path f12249f;

    /* renamed from: g  reason: collision with root package name */
    public Path f12250g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f12251h;

    /* renamed from: i  reason: collision with root package name */
    public int f12252i;
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

    public void b(int i2) {
        if (i2 != 1 && i2 != 4) {
            this.f12248e.setColor(SkinManager.getColor(R.color.CAM_X0205));
            this.f12251h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
        } else {
            this.f12248e.setColor(SkinManager.getColor(R.color.CAM_X0206_1));
            this.f12251h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        }
        invalidate();
    }

    public final void c() {
        Paint paint = new Paint();
        this.f12248e = paint;
        paint.setColor(SkinManager.getColor(R.color.CAM_X0205));
        this.f12248e.setAntiAlias(true);
        this.f12248e.setStrokeWidth(1.0f);
        this.f12248e.setDither(true);
        this.f12248e.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f12251h = paint2;
        paint2.setAntiAlias(true);
        this.f12251h.setDither(true);
        this.f12251h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
    }

    public final void d() {
        this.f12249f = new Path();
        this.f12250g = new Path();
    }

    public final void e() {
        this.f12252i = l.g(getContext().getApplicationContext(), R.dimen.tbds137);
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
        this.f12250g.reset();
        this.f12249f.reset();
        this.f12249f.moveTo(0.0f, getHeight() - this.f12252i);
        this.f12249f.lineTo((getWidth() / 2) - (this.j / 2), getHeight() - this.f12252i);
        this.f12249f.quadTo(((getWidth() / 2) - (this.j / 2)) + this.k, getHeight() - this.f12252i, ((getWidth() / 2) - (this.j / 2)) + this.l, (getHeight() - this.f12252i) - this.m);
        this.f12249f.quadTo(getWidth() / 2, (getHeight() - this.f12252i) - this.n, ((getWidth() / 2) + (this.j / 2)) - this.l, (getHeight() - this.f12252i) - this.m);
        this.f12249f.quadTo(((getWidth() / 2) + (this.j / 2)) - this.k, getHeight() - this.f12252i, (getWidth() / 2) + (this.j / 2), getHeight() - this.f12252i);
        this.f12249f.lineTo(getWidth(), getHeight() - this.f12252i);
        this.f12249f.lineTo(getWidth(), getHeight());
        this.f12249f.lineTo(0.0f, getHeight());
        this.f12249f.close();
        this.f12250g.moveTo(0.0f, (getHeight() - this.f12252i) + this.o);
        this.f12250g.lineTo((getWidth() / 2) - (this.j / 2), (getHeight() - this.f12252i) + this.o);
        this.f12250g.quadTo(((getWidth() / 2) - (this.j / 2)) + this.k, (getHeight() - this.f12252i) + this.o, ((getWidth() / 2) - (this.j / 2)) + this.l, ((getHeight() - this.f12252i) - this.m) + this.o);
        this.f12250g.quadTo(getWidth() / 2, ((getHeight() - this.f12252i) - this.n) + this.o, ((getWidth() / 2) + (this.j / 2)) - this.l, ((getHeight() - this.f12252i) - this.m) + this.o);
        this.f12250g.quadTo(((getWidth() / 2) + (this.j / 2)) - this.k, (getHeight() - this.f12252i) + this.o, (getWidth() / 2) + (this.j / 2), (getHeight() - this.f12252i) + this.o);
        this.f12250g.lineTo(getWidth(), (getHeight() - this.f12252i) + this.o);
        this.f12250g.lineTo(getWidth(), getHeight());
        this.f12250g.lineTo(0.0f, getHeight());
        this.f12250g.close();
        canvas.drawPath(this.f12250g, this.f12251h);
        canvas.drawPath(this.f12249f, this.f12248e);
    }

    public FragmentTabSwellingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FragmentTabSwellingView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
