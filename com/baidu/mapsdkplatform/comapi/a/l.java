package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.graphics.Point;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class l extends c {

    /* renamed from: a  reason: collision with root package name */
    public Animator f7515a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f7516b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f7517c = null;

    /* renamed from: d  reason: collision with root package name */
    public Animation.AnimationListener f7518d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7519e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f7520f = 0;

    /* renamed from: g  reason: collision with root package name */
    public Object[] f7521g;

    @TargetApi(11)
    /* loaded from: classes2.dex */
    public class a implements TypeEvaluator {
        public a() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f2, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d2 = latLng.longitude;
            double d3 = f2;
            Double.isNaN(d3);
            double d4 = d2 + ((latLng2.longitude - d2) * d3);
            double d5 = latLng.latitude;
            Double.isNaN(d3);
            return new LatLng(d5 + (d3 * (latLng2.latitude - d5)), d4);
        }
    }

    @TargetApi(11)
    /* loaded from: classes2.dex */
    public class b implements TypeEvaluator {
        public b() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f2, Object obj, Object obj2) {
            Point point = (Point) obj;
            Point point2 = (Point) obj2;
            int i = point.x;
            float f3 = i + ((point2.x - i) * f2);
            int i2 = point.y;
            return new Point((int) f3, (int) (i2 + (f2 * (point2.y - i2))));
        }
    }

    public l(Point... pointArr) {
        this.f7521g = pointArr;
    }

    public l(LatLng... latLngArr) {
        this.f7521g = latLngArr;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        ObjectAnimator ofObject;
        if (marker.isFixed()) {
            if (!(this.f7521g[0] instanceof Point)) {
                throw new ClassCastException("if the marker is fixed on screen, the parameters of Transformation must be android.graphics.Point");
            }
            ofObject = ObjectAnimator.ofObject(marker, "fixedScreenPosition", new b(), this.f7521g);
        } else if (!(this.f7521g[0] instanceof LatLng)) {
            throw new ClassCastException("if the marker isn't fixed on screen, the parameters of Transformation must be Latlng");
        } else {
            ofObject = ObjectAnimator.ofObject(marker, "position", new a(), this.f7521g);
        }
        if (ofObject != null) {
            ofObject.setRepeatCount(this.f7520f);
            ofObject.setRepeatMode(c());
            ofObject.setDuration(this.f7516b);
            Interpolator interpolator = this.f7517c;
            if (interpolator != null) {
                ofObject.setInterpolator(interpolator);
            }
        }
        return ofObject;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        Animator animator = this.f7515a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i) {
        this.f7519e = i;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f7516b = j;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new m(this));
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Interpolator interpolator) {
        this.f7517c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        this.f7518d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        ObjectAnimator a2 = a(marker);
        this.f7515a = a2;
        a(a2);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        Animator animator = this.f7515a;
        if (animator != null) {
            animator.cancel();
            this.f7515a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i) {
        if (i > 0) {
            this.f7520f = i;
        }
    }

    public int c() {
        return this.f7519e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i) {
    }
}
