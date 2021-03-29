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
    public Animator f7516a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f7517b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f7518c = null;

    /* renamed from: d  reason: collision with root package name */
    public Animation.AnimationListener f7519d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7520e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f7521f = 0;

    /* renamed from: g  reason: collision with root package name */
    public Object[] f7522g;

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
            double d4 = d2 + ((latLng2.longitude - d2) * d3);
            double d5 = latLng.latitude;
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
        this.f7522g = pointArr;
    }

    public l(LatLng... latLngArr) {
        this.f7522g = latLngArr;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        ObjectAnimator ofObject;
        if (marker.isFixed()) {
            if (!(this.f7522g[0] instanceof Point)) {
                throw new ClassCastException("if the marker is fixed on screen, the parameters of Transformation must be android.graphics.Point");
            }
            ofObject = ObjectAnimator.ofObject(marker, "fixedScreenPosition", new b(), this.f7522g);
        } else if (!(this.f7522g[0] instanceof LatLng)) {
            throw new ClassCastException("if the marker isn't fixed on screen, the parameters of Transformation must be Latlng");
        } else {
            ofObject = ObjectAnimator.ofObject(marker, "position", new a(), this.f7522g);
        }
        if (ofObject != null) {
            ofObject.setRepeatCount(this.f7521f);
            ofObject.setRepeatMode(c());
            ofObject.setDuration(this.f7517b);
            Interpolator interpolator = this.f7518c;
            if (interpolator != null) {
                ofObject.setInterpolator(interpolator);
            }
        }
        return ofObject;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        Animator animator = this.f7516a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i) {
        this.f7520e = i;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f7517b = j;
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
        this.f7518c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        this.f7519d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        ObjectAnimator a2 = a(marker);
        this.f7516a = a2;
        a(a2);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        Animator animator = this.f7516a;
        if (animator != null) {
            animator.cancel();
            this.f7516a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i) {
        if (i > 0) {
            this.f7521f = i;
        }
    }

    public int c() {
        return this.f7520e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i) {
    }
}
