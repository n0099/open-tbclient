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
/* loaded from: classes15.dex */
public final class AnimatorProxy extends Animation {
    public static final boolean NEEDS_PROXY;
    private static final WeakHashMap<View, AnimatorProxy> a;
    private final WeakReference<View> b;
    private boolean g;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float p;
    private float q;
    private final Camera c = new Camera();
    private final RectF d = new RectF();
    private final RectF e = new RectF();
    private final Matrix f = new Matrix();
    private float h = 1.0f;
    private float n = 1.0f;
    private float o = 1.0f;

    static {
        NEEDS_PROXY = Integer.valueOf(Build.VERSION.SDK).intValue() < 11;
        a = new WeakHashMap<>();
    }

    private AnimatorProxy(View view) {
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        this.b = new WeakReference<>(view);
    }

    public static AnimatorProxy wrap(View view) {
        AnimatorProxy animatorProxy = a.get(view);
        if (animatorProxy == null || animatorProxy != view.getAnimation()) {
            AnimatorProxy animatorProxy2 = new AnimatorProxy(view);
            a.put(view, animatorProxy2);
            return animatorProxy2;
        }
        return animatorProxy;
    }

    public float getAlpha() {
        return this.h;
    }

    public void setAlpha(float f) {
        if (this.h != f) {
            this.h = f;
            View view = this.b.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public float getPivotX() {
        return this.i;
    }

    public void setPivotX(float f) {
        if (!this.g || this.i != f) {
            a();
            this.g = true;
            this.i = f;
            b();
        }
    }

    public float getPivotY() {
        return this.j;
    }

    public void setPivotY(float f) {
        if (!this.g || this.j != f) {
            a();
            this.g = true;
            this.j = f;
            b();
        }
    }

    public float getRotation() {
        return this.m;
    }

    public void setRotation(float f) {
        if (this.m != f) {
            a();
            this.m = f;
            b();
        }
    }

    public float getRotationX() {
        return this.k;
    }

    public void setRotationX(float f) {
        if (this.k != f) {
            a();
            this.k = f;
            b();
        }
    }

    public float getRotationY() {
        return this.l;
    }

    public void setRotationY(float f) {
        if (this.l != f) {
            a();
            this.l = f;
            b();
        }
    }

    public float getScaleX() {
        return this.n;
    }

    public void setScaleX(float f) {
        if (this.n != f) {
            a();
            this.n = f;
            b();
        }
    }

    public float getScaleY() {
        return this.o;
    }

    public void setScaleY(float f) {
        if (this.o != f) {
            a();
            this.o = f;
            b();
        }
    }

    public int getScrollX() {
        View view = this.b.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    public void setScrollX(int i) {
        View view = this.b.get();
        if (view != null) {
            view.scrollTo(i, view.getScrollY());
        }
    }

    public int getScrollY() {
        View view = this.b.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    public void setScrollY(int i) {
        View view = this.b.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i);
        }
    }

    public float getTranslationX() {
        return this.p;
    }

    public void setTranslationX(float f) {
        if (this.p != f) {
            a();
            this.p = f;
            b();
        }
    }

    public float getTranslationY() {
        return this.q;
    }

    public void setTranslationY(float f) {
        if (this.q != f) {
            a();
            this.q = f;
            b();
        }
    }

    public float getX() {
        View view = this.b.get();
        if (view == null) {
            return 0.0f;
        }
        return view.getLeft() + this.p;
    }

    public void setX(float f) {
        View view = this.b.get();
        if (view != null) {
            setTranslationX(f - view.getLeft());
        }
    }

    public float getY() {
        View view = this.b.get();
        if (view == null) {
            return 0.0f;
        }
        return view.getTop() + this.q;
    }

    public void setY(float f) {
        View view = this.b.get();
        if (view != null) {
            setTranslationY(f - view.getTop());
        }
    }

    private void a() {
        View view = this.b.get();
        if (view != null) {
            a(this.d, view);
        }
    }

    private void b() {
        View view = this.b.get();
        if (view != null && view.getParent() != null) {
            RectF rectF = this.e;
            a(rectF, view);
            rectF.union(this.d);
            ((View) view.getParent()).invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
    }

    private void a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Matrix matrix = this.f;
        matrix.reset();
        a(matrix, view);
        this.f.mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        if (rectF.right < rectF.left) {
            float f = rectF.right;
            rectF.right = rectF.left;
            rectF.left = f;
        }
        if (rectF.bottom < rectF.top) {
            float f2 = rectF.top;
            rectF.top = rectF.bottom;
            rectF.bottom = f2;
        }
    }

    private void a(Matrix matrix, View view) {
        float width = view.getWidth();
        float height = view.getHeight();
        boolean z = this.g;
        float f = z ? this.i : width / 2.0f;
        float f2 = z ? this.j : height / 2.0f;
        float f3 = this.k;
        float f4 = this.l;
        float f5 = this.m;
        if (f3 != 0.0f || f4 != 0.0f || f5 != 0.0f) {
            Camera camera = this.c;
            camera.save();
            camera.rotateX(f3);
            camera.rotateY(f4);
            camera.rotateZ(-f5);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f, -f2);
            matrix.postTranslate(f, f2);
        }
        float f6 = this.n;
        float f7 = this.o;
        if (f6 != 1.0f || f7 != 1.0f) {
            matrix.postScale(f6, f7);
            matrix.postTranslate((-(f / width)) * ((f6 * width) - width), (-(f2 / height)) * ((f7 * height) - height));
        }
        matrix.postTranslate(this.p, this.q);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        View view = this.b.get();
        if (view != null) {
            transformation.setAlpha(this.h);
            a(transformation.getMatrix(), view);
        }
    }
}
