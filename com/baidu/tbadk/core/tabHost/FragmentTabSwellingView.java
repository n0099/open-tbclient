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
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class FragmentTabSwellingView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f13317e;

    /* renamed from: f  reason: collision with root package name */
    public Path f13318f;

    /* renamed from: g  reason: collision with root package name */
    public Path f13319g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f13320h;
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
            this.f13317e.setColor(SkinManager.getColor(R.color.CAM_X0205));
            this.f13320h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
        } else {
            this.f13317e.setColor(SkinManager.getColor(R.color.CAM_X0206_1));
            this.f13320h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        }
        invalidate();
    }

    public final void c() {
        Paint paint = new Paint();
        this.f13317e = paint;
        paint.setColor(SkinManager.getColor(R.color.CAM_X0205));
        this.f13317e.setAntiAlias(true);
        this.f13317e.setStrokeWidth(1.0f);
        this.f13317e.setDither(true);
        this.f13317e.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f13320h = paint2;
        paint2.setAntiAlias(true);
        this.f13320h.setDither(true);
        this.f13320h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
    }

    public final void d() {
        this.f13318f = new Path();
        this.f13319g = new Path();
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
        this.f13319g.reset();
        this.f13318f.reset();
        this.f13318f.moveTo(0.0f, getHeight() - this.i);
        this.f13318f.lineTo((getWidth() / 2) - (this.j / 2), getHeight() - this.i);
        this.f13318f.quadTo(((getWidth() / 2) - (this.j / 2)) + this.k, getHeight() - this.i, ((getWidth() / 2) - (this.j / 2)) + this.l, (getHeight() - this.i) - this.m);
        this.f13318f.quadTo(getWidth() / 2, (getHeight() - this.i) - this.n, ((getWidth() / 2) + (this.j / 2)) - this.l, (getHeight() - this.i) - this.m);
        this.f13318f.quadTo(((getWidth() / 2) + (this.j / 2)) - this.k, getHeight() - this.i, (getWidth() / 2) + (this.j / 2), getHeight() - this.i);
        this.f13318f.lineTo(getWidth(), getHeight() - this.i);
        this.f13318f.lineTo(getWidth(), getHeight());
        this.f13318f.lineTo(0.0f, getHeight());
        this.f13318f.close();
        this.f13319g.moveTo(0.0f, (getHeight() - this.i) + this.o);
        this.f13319g.lineTo((getWidth() / 2) - (this.j / 2), (getHeight() - this.i) + this.o);
        this.f13319g.quadTo(((getWidth() / 2) - (this.j / 2)) + this.k, (getHeight() - this.i) + this.o, ((getWidth() / 2) - (this.j / 2)) + this.l, ((getHeight() - this.i) - this.m) + this.o);
        this.f13319g.quadTo(getWidth() / 2, ((getHeight() - this.i) - this.n) + this.o, ((getWidth() / 2) + (this.j / 2)) - this.l, ((getHeight() - this.i) - this.m) + this.o);
        this.f13319g.quadTo(((getWidth() / 2) + (this.j / 2)) - this.k, (getHeight() - this.i) + this.o, (getWidth() / 2) + (this.j / 2), (getHeight() - this.i) + this.o);
        this.f13319g.lineTo(getWidth(), (getHeight() - this.i) + this.o);
        this.f13319g.lineTo(getWidth(), getHeight());
        this.f13319g.lineTo(0.0f, getHeight());
        this.f13319g.close();
        canvas.drawPath(this.f13319g, this.f13320h);
        canvas.drawPath(this.f13318f, this.f13317e);
    }

    public FragmentTabSwellingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FragmentTabSwellingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
