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
    public Paint f12300e;

    /* renamed from: f  reason: collision with root package name */
    public Path f12301f;

    /* renamed from: g  reason: collision with root package name */
    public Path f12302g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f12303h;

    /* renamed from: i  reason: collision with root package name */
    public int f12304i;
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
            this.f12300e.setColor(SkinManager.getColor(R.color.CAM_X0205));
            this.f12303h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
        } else {
            this.f12300e.setColor(SkinManager.getColor(R.color.CAM_X0206_1));
            this.f12303h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        }
        invalidate();
    }

    public final void c() {
        Paint paint = new Paint();
        this.f12300e = paint;
        paint.setColor(SkinManager.getColor(R.color.CAM_X0205));
        this.f12300e.setAntiAlias(true);
        this.f12300e.setStrokeWidth(1.0f);
        this.f12300e.setDither(true);
        this.f12300e.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f12303h = paint2;
        paint2.setAntiAlias(true);
        this.f12303h.setDither(true);
        this.f12303h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
    }

    public final void d() {
        this.f12301f = new Path();
        this.f12302g = new Path();
    }

    public final void e() {
        this.f12304i = l.g(getContext().getApplicationContext(), R.dimen.tbds137);
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
        this.f12302g.reset();
        this.f12301f.reset();
        this.f12301f.moveTo(0.0f, getHeight() - this.f12304i);
        this.f12301f.lineTo((getWidth() / 2) - (this.j / 2), getHeight() - this.f12304i);
        this.f12301f.quadTo(((getWidth() / 2) - (this.j / 2)) + this.k, getHeight() - this.f12304i, ((getWidth() / 2) - (this.j / 2)) + this.l, (getHeight() - this.f12304i) - this.m);
        this.f12301f.quadTo(getWidth() / 2, (getHeight() - this.f12304i) - this.n, ((getWidth() / 2) + (this.j / 2)) - this.l, (getHeight() - this.f12304i) - this.m);
        this.f12301f.quadTo(((getWidth() / 2) + (this.j / 2)) - this.k, getHeight() - this.f12304i, (getWidth() / 2) + (this.j / 2), getHeight() - this.f12304i);
        this.f12301f.lineTo(getWidth(), getHeight() - this.f12304i);
        this.f12301f.lineTo(getWidth(), getHeight());
        this.f12301f.lineTo(0.0f, getHeight());
        this.f12301f.close();
        this.f12302g.moveTo(0.0f, (getHeight() - this.f12304i) + this.o);
        this.f12302g.lineTo((getWidth() / 2) - (this.j / 2), (getHeight() - this.f12304i) + this.o);
        this.f12302g.quadTo(((getWidth() / 2) - (this.j / 2)) + this.k, (getHeight() - this.f12304i) + this.o, ((getWidth() / 2) - (this.j / 2)) + this.l, ((getHeight() - this.f12304i) - this.m) + this.o);
        this.f12302g.quadTo(getWidth() / 2, ((getHeight() - this.f12304i) - this.n) + this.o, ((getWidth() / 2) + (this.j / 2)) - this.l, ((getHeight() - this.f12304i) - this.m) + this.o);
        this.f12302g.quadTo(((getWidth() / 2) + (this.j / 2)) - this.k, (getHeight() - this.f12304i) + this.o, (getWidth() / 2) + (this.j / 2), (getHeight() - this.f12304i) + this.o);
        this.f12302g.lineTo(getWidth(), (getHeight() - this.f12304i) + this.o);
        this.f12302g.lineTo(getWidth(), getHeight());
        this.f12302g.lineTo(0.0f, getHeight());
        this.f12302g.close();
        canvas.drawPath(this.f12302g, this.f12303h);
        canvas.drawPath(this.f12301f, this.f12300e);
    }

    public FragmentTabSwellingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FragmentTabSwellingView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
