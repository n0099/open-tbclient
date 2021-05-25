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
    public Animator f7505a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f7506b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f7507c = null;

    /* renamed from: d  reason: collision with root package name */
    public Animation.AnimationListener f7508d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7509e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f7510f = 0;

    /* renamed from: g  reason: collision with root package name */
    public Object[] f7511g;

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
            int i2 = point.x;
            float f3 = i2 + ((point2.x - i2) * f2);
            int i3 = point.y;
            return new Point((int) f3, (int) (i3 + (f2 * (point2.y - i3))));
        }
    }

    public l(Point... pointArr) {
        this.f7511g = pointArr;
    }

    public l(LatLng... latLngArr) {
        this.f7511g = latLngArr;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        ObjectAnimator ofObject;
        if (marker.isFixed()) {
            if (!(this.f7511g[0] instanceof Point)) {
                throw new ClassCastException("BDMapSDKException: if the marker is fixed on screen, the parameters of Transformation must be android.graphics.Point");
            }
            ofObject = ObjectAnimator.ofObject(marker, "fixedScreenPosition", new b(), this.f7511g);
        } else if (!(this.f7511g[0] instanceof LatLng)) {
            throw new ClassCastException("BDMapSDKException: if the marker isn't fixed on screen, the parameters of Transformation must be Latlng");
        } else {
            ofObject = ObjectAnimator.ofObject(marker, "position", new a(), this.f7511g);
        }
        if (ofObject != null) {
            ofObject.setRepeatCount(this.f7510f);
            ofObject.setRepeatMode(c());
            ofObject.setDuration(this.f7506b);
            Interpolator interpolator = this.f7507c;
            if (interpolator != null) {
                ofObject.setInterpolator(interpolator);
            }
        }
        return ofObject;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        Animator animator = this.f7505a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i2) {
        this.f7509e = i2;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f7506b = j;
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
        this.f7507c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        this.f7508d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        ObjectAnimator a2 = a(marker);
        this.f7505a = a2;
        a(a2);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        Animator animator = this.f7505a;
        if (animator != null) {
            animator.cancel();
            this.f7505a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i2) {
        if (i2 > 0 || i2 == -1) {
            this.f7510f = i2;
        }
    }

    public int c() {
        return this.f7509e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i2) {
    }
}
