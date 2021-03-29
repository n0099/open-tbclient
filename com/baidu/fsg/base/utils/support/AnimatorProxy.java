package com.baidu.fsg.base.utils.support;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
/* loaded from: classes2.dex */
public final class AnimatorProxy extends Animation {
    public static final boolean NEEDS_PROXY;

    /* renamed from: a  reason: collision with root package name */
    public static final WeakHashMap<View, AnimatorProxy> f5421a;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<View> f5422b;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5427g;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float p;
    public float q;

    /* renamed from: c  reason: collision with root package name */
    public final Camera f5423c = new Camera();

    /* renamed from: d  reason: collision with root package name */
    public final RectF f5424d = new RectF();

    /* renamed from: e  reason: collision with root package name */
    public final RectF f5425e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    public final Matrix f5426f = new Matrix();

    /* renamed from: h  reason: collision with root package name */
    public float f5428h = 1.0f;
    public float n = 1.0f;
    public float o = 1.0f;

    static {
        NEEDS_PROXY = Integer.valueOf(Build.VERSION.SDK).intValue() < 11;
        f5421a = new WeakHashMap<>();
    }

    public AnimatorProxy(View view) {
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        this.f5422b = new WeakReference<>(view);
    }

    private void a() {
        View view = this.f5422b.get();
        if (view != null) {
            a(this.f5424d, view);
        }
    }

    private void b() {
        View view = this.f5422b.get();
        if (view == null || view.getParent() == null) {
            return;
        }
        RectF rectF = this.f5425e;
        a(rectF, view);
        rectF.union(this.f5424d);
        ((View) view.getParent()).invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    public static AnimatorProxy wrap(View view) {
        AnimatorProxy animatorProxy = f5421a.get(view);
        if (animatorProxy == null || animatorProxy != view.getAnimation()) {
            AnimatorProxy animatorProxy2 = new AnimatorProxy(view);
            f5421a.put(view, animatorProxy2);
            return animatorProxy2;
        }
        return animatorProxy;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        View view = this.f5422b.get();
        if (view != null) {
            transformation.setAlpha(this.f5428h);
            a(transformation.getMatrix(), view);
        }
    }

    public float getAlpha() {
        return this.f5428h;
    }

    public float getPivotX() {
        return this.i;
    }

    public float getPivotY() {
        return this.j;
    }

    public float getRotation() {
        return this.m;
    }

    public float getRotationX() {
        return this.k;
    }

    public float getRotationY() {
        return this.l;
    }

    public float getScaleX() {
        return this.n;
    }

    public float getScaleY() {
        return this.o;
    }

    public int getScrollX() {
        View view = this.f5422b.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    public int getScrollY() {
        View view = this.f5422b.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    public float getTranslationX() {
        return this.p;
    }

    public float getTranslationY() {
        return this.q;
    }

    public float getX() {
        View view = this.f5422b.get();
        if (view == null) {
            return 0.0f;
        }
        return view.getLeft() + this.p;
    }

    public float getY() {
        View view = this.f5422b.get();
        if (view == null) {
            return 0.0f;
        }
        return view.getTop() + this.q;
    }

    public void setAlpha(float f2) {
        if (this.f5428h != f2) {
            this.f5428h = f2;
            View view = this.f5422b.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void setPivotX(float f2) {
        if (this.f5427g && this.i == f2) {
            return;
        }
        a();
        this.f5427g = true;
        this.i = f2;
        b();
    }

    public void setPivotY(float f2) {
        if (this.f5427g && this.j == f2) {
            return;
        }
        a();
        this.f5427g = true;
        this.j = f2;
        b();
    }

    public void setRotation(float f2) {
        if (this.m != f2) {
            a();
            this.m = f2;
            b();
        }
    }

    public void setRotationX(float f2) {
        if (this.k != f2) {
            a();
            this.k = f2;
            b();
        }
    }

    public void setRotationY(float f2) {
        if (this.l != f2) {
            a();
            this.l = f2;
            b();
        }
    }

    public void setScaleX(float f2) {
        if (this.n != f2) {
            a();
            this.n = f2;
            b();
        }
    }

    public void setScaleY(float f2) {
        if (this.o != f2) {
            a();
            this.o = f2;
            b();
        }
    }

    public void setScrollX(int i) {
        View view = this.f5422b.get();
        if (view != null) {
            view.scrollTo(i, view.getScrollY());
        }
    }

    public void setScrollY(int i) {
        View view = this.f5422b.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i);
        }
    }

    public void setTranslationX(float f2) {
        if (this.p != f2) {
            a();
            this.p = f2;
            b();
        }
    }

    public void setTranslationY(float f2) {
        if (this.q != f2) {
            a();
            this.q = f2;
            b();
        }
    }

    public void setX(float f2) {
        View view = this.f5422b.get();
        if (view != null) {
            setTranslationX(f2 - view.getLeft());
        }
    }

    public void setY(float f2) {
        View view = this.f5422b.get();
        if (view != null) {
            setTranslationY(f2 - view.getTop());
        }
    }

    private void a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Matrix matrix = this.f5426f;
        matrix.reset();
        a(matrix, view);
        this.f5426f.mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        float f2 = rectF.right;
        float f3 = rectF.left;
        if (f2 < f3) {
            rectF.right = f3;
            rectF.left = f2;
        }
        float f4 = rectF.bottom;
        float f5 = rectF.top;
        if (f4 < f5) {
            rectF.top = f4;
            rectF.bottom = f5;
        }
    }

    private void a(Matrix matrix, View view) {
        float width = view.getWidth();
        float height = view.getHeight();
        boolean z = this.f5427g;
        float f2 = z ? this.i : width / 2.0f;
        float f3 = z ? this.j : height / 2.0f;
        float f4 = this.k;
        float f5 = this.l;
        float f6 = this.m;
        if (f4 != 0.0f || f5 != 0.0f || f6 != 0.0f) {
            Camera camera = this.f5423c;
            camera.save();
            camera.rotateX(f4);
            camera.rotateY(f5);
            camera.rotateZ(-f6);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f2, -f3);
            matrix.postTranslate(f2, f3);
        }
        float f7 = this.n;
        float f8 = this.o;
        if (f7 != 1.0f || f8 != 1.0f) {
            matrix.postScale(f7, f8);
            matrix.postTranslate((-(f2 / width)) * ((f7 * width) - width), (-(f3 / height)) * ((f8 * height) - height));
        }
        matrix.postTranslate(this.p, this.q);
    }
}
